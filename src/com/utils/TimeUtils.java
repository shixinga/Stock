package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	// //获取当前系统时间，用以区分不同的收藏记录
		public	static String getCurrentTime()      
		{
			Date now = new Date(); 
			SimpleDateFormat dateFormat = 
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式 


			String nowtime = dateFormat.format( now ); 
			 
			return nowtime;
		}

}
