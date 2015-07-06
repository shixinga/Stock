package com.utils;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SpiderUtils {

	
    
    public static String spider(String path) {
        HttpGet httpget = new HttpGet(path);  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
//        System.out.println("executing request " + httpget.getURI());  
        CloseableHttpResponse response = null;
        String content = null;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();  
//	        System.out.println("--------------------------------------");  
//	        System.out.println(response.getStatusLine());  
	        if (entity != null) {  
//	            System.out.println("Response content length: " + entity.getContentLength());  
	            content = EntityUtils.toString(entity);
//				System.out.println("Response content: " + content);  
	        }  
//	        System.out.println("-------------------------------");  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {  
            	if(response != null) {
            		response.close();  
            		response = null;
            	}
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
		}
            
        return content;
    }
}
