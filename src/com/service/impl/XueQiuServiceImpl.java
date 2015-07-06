package com.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import com.service.XueQiuService;




public class XueQiuServiceImpl extends XueQiuService {

	private static final String URL = "http://xueqiu.com/stock/screener/screen.json"
			+ "?category=SH&exchange=&areacode=&indcode=&orderby=symbol&order=desc"
			+ "&size=300&page=2&current=ALL&pettm=ALL&pelyr=ALL&pb=ALL&pct=All";
	private static final String GET_COOKIE_URL = "http://xueqiu.com/hq/screener";

	private String[] urlList;
	
	public static final String CHARSET = "utf-8";
	
	private static final String RE = "\"symbol\":(.+?),.*?\"name\":(.+?),.*?"
			+  "\"pettm\":(.+?),.*?\"pelyr\":(.+?),.*?"
			+ "\"pb\":(.+?),.*?\"current\":(.+?),.*?\"pct\":(.+?),.*?";
	private static final int[] INDEX = new int[]{1,2,7,6,4,3,5};

	private ArrayList<String> subDataString;
	private String dataString;
	public JSONArray dataArray;
	
	private final String tableName = "xueqiu";
	private String sourceName = "xueqiu";
	
	GetThread[] threads;
	
	public XueQiuServiceImpl() {
		super();
		dataArray = new JSONArray();
	}

	@Override
	public void execute() {
		if(urlList == null){
			urlList = getUrlList();
		}
		
		if(subDataString == null){
			subDataString = new ArrayList<String>();
		}
		
		getCookie(httpClient, GET_COOKIE_URL);
		
		multiThread();
		
		getDataString();
	}

	@Override
	public void update(){
		Thread td = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				execute();
				
				for(GetThread gThread : threads){
					try {
						gThread.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
				getDataArray();
			}
		});
		td.start();
		try {
			td.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void multiThread() {

		threads = new GetThread[urlList.length];
		for (int i = 0; i < threads.length; i++) {
			HttpGet httpget = new HttpGet(urlList[i]);
			threads[i] = new GetThread(httpget);
		}
		// start the threads
		for (int j = 0; j < threads.length; j++) {
			threads[j].start();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public String[] getUrlList(){
		String[] arrStr = new String[10];
		for (int i = 0; i < 10; ++i) {
			arrStr[i] = URL + "&page=" + (i + 1);
		}
		return arrStr;
	}
	
    public void getCookie(final HttpClient httpClient, String urlCookie) {
		HttpResponse response = null;
		HttpGet hg = new HttpGet(urlCookie);
		try {
			httpClient.getParams().setIntParameter("http.socket.timeout", 10000); 
			response = httpClient.execute(hg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("finally");
			hg.releaseConnection();
		}
		CookieStore cookieStore = ((AbstractHttpClient) httpClient)
				.getCookieStore();
		((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
	}

	class GetThread extends Thread {
		private HttpGet httpget;
		private HttpContext context;
		
		public GetThread(HttpGet httpget) {
			this.context = new BasicHttpContext();
			this.httpget = httpget;
		}

		@Override
		public void run() {
			get(httpget, context);
		}
	}
	
	public void get(HttpGet httpget, HttpContext context) {
		try {
			HttpResponse response = httpClient.execute(httpget,
					context);
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				String str = InputStream2String(entity, "utf-8");
				subDataString.add(extractValidValue(str));
			}
			// ensure the connection gets released to the manager
			EntityUtils.consume(entity);
		} catch (Exception ex) {
			httpget.abort();
		} finally {
			httpget.releaseConnection();
		}
	}
	
	public String extractValidValue(String data){
		
		Pattern pattern = Pattern.compile(RE);
		Matcher matcher = pattern.matcher(data);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while(matcher.find()){
			sb.append("[");
			for(int i = 0; i < INDEX.length; ++i){
				sb.append(matcher.group(INDEX[i]) + ",");
			}
			sb.append(matcher.group(5) + ",");

			sb.append("],");
			++count;
		}
		return sb.toString();
	}

	public String subData2DataString(){
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(String s : subDataString){
			if(s == null){
				continue;
			}
			str.append(s);
		}
		str.append("]");
		dataString = str.toString();
		try {
			dataArray = new JSONArray(dataString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataString;
	}

	public String getDataString() {
		if(dataString == null){
			dataString = subData2DataString();
		}
		return dataString;
	}

	@Override
	public JSONArray getDataArray() {
		getDataString();
		if(dataArray == null){
			try {
				dataArray = new JSONArray(dataString);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataArray;
	}
	
	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public String getSourceName() {
		return sourceName;
	}

	@Override
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}


	public String[][] getStr() {
		update();
		String[][] str = new String[dataArray.length()][9];
		for(int i = 0; i < dataArray.length(); ++i) {
			JSONArray temp = dataArray.getJSONArray(i);
			str[i][0] = temp.getString(0);
			str[i][1] = temp.getString(1);
			str[i][5] = null;
			str[i][4] = temp.getDouble(3) + "";
			str[i][6] = temp.getDouble(4) + "";
			str[i][3] = temp.getDouble(5) + "";
			//str[i][7] = temp.getDouble(6) + "";
			str[i][2] = temp.getDouble(7) + "";
			
		}
		
		return str;
	}

}
