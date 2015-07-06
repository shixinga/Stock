package com.service.impl;
import org.json.JSONArray;

import com.utils.SpiderUtils;



public class TongHuaSunServiceImpl {

	public static String[][] getJson(String path) {
		String stringJsonContent = null;
		String stringHTMLContent = SpiderUtils.spider(path); 
		int totalIndex = stringHTMLContent.indexOf("\"total\":");
		String stringTotal = stringHTMLContent.substring(totalIndex + 8, totalIndex + 8 + 4);
		int tokenIndex = stringHTMLContent.indexOf("token");
		int endTokenIndex = stringHTMLContent.indexOf("\",\"staticList\"", tokenIndex);
		String stringToken = stringHTMLContent.substring(tokenIndex + 8, endTokenIndex);
		String newPath = path.substring(0, path.indexOf("search")) + "cache?token="
				+ stringToken + "&perpage=" + stringTotal;
		stringJsonContent = SpiderUtils.spider(newPath); 
		String stringJsonArray = stringJsonContent.substring(stringJsonContent.indexOf("[["), stringJsonContent.indexOf("]]") + 2);
		JSONArray jsonArray = new JSONArray(stringJsonArray);
		
		String[][] str = new String[jsonArray.length()][9];
		for(int i = 0; i < jsonArray.length(); ++i) {
			JSONArray temp = jsonArray.getJSONArray(i);
			for(int j = 0; j < 9; ++j) {
				str[i][j] = temp.getString(j);
			}
		}
		
		return str;
		
	}
}
