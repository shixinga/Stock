package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.service.impl.TongHuaSunServiceImpl;
import com.service.impl.XueQiuServiceImpl;

public class ConnectTest {
	public static final String GET_PARAM_URL = 
			"http://www.iwencai.com/stockpick/search"
			+ "?typed=0&preParams=&ts=1&f=1&qs=1&selfsectsn="
			+ "&querytype=&searchfilter=&tid=stockpick&w=pe";
	@Test
	public void testGetHtml() {
//		boolean b = com.network.Html.getHtml("http://www.iwencai.com/stockpick/search?typed=1&preParams=&ts=1&f=1&qs=1&selfsectsn=&querytype=&searchfilter=&tid=stockpick&w=pe");
		boolean b = com.utils.HtmlUtils.getHtml(GET_PARAM_URL);
		assertEquals(true, b);
	}
	@Test
	public void testGetJson() {
		String[][] b = TongHuaSunServiceImpl.getJson(GET_PARAM_URL);
	}

	@Test
	public void testgetXueqiu() {
		
		final XueQiuServiceImpl xq = new XueQiuServiceImpl();
		String [][] str= xq.getStr();
		
		for(int i = 0; i < str.length; ++i) {
			for(int j = 0; j < 7; ++j) {
				System.out.print(str[i][j] + ",");
			}
			System.out.println();
		}
	}
}
