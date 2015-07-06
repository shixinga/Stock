package com.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.dao.ReadRecodeDao;
import com.model.Record;

public class ReadRecodeDaoFileImpl implements ReadRecodeDao {
	public Record data = Record.getRecode();

	 //读取收藏记录
	//返回读取到的记录字符串，最后要靠调用display函数显示出来
	 /* (non-Javadoc)
	 * @see com.dao.ReadRecodeDao#readData()
	 */
	@Override
	public String readData() {
		 
	       String str=new String();
	        try {
	            FileReader read = 
	            new FileReader(StoreRecordDaoFileImpl.filePath);//读取文件位置
	              BufferedReader br = new BufferedReader(read);
	            String row=new String();
	            
	            while ((row = br.readLine()) != null) 
	            {
	                 //收藏记录倒序输出（按时间排序，后的在前面）
	                 str=row+"\n"+str;
	            
	             }
	            
	           
	         } catch (FileNotFoundException e) {
	             e.printStackTrace();
	        } catch (IOException e) {
	              e.printStackTrace();
	          }
	        return str;
	 } 
	 
	 //查找某一天的收藏记录（参数日期的格式为：xxxx/yy/zz）
	 //返回符合日期的记录字符串，最后要靠调用display函数显示出来
	 /* (non-Javadoc)
	 * @see com.dao.ReadRecodeDao#Search(java.lang.String)
	 */
	@Override
	public String Search(String Date)
	 {
		 
		 String str=new String();
		 try {
	            FileReader read = 
	            new FileReader(StoreRecordDaoFileImpl.filePath);//读取文件位置
	              BufferedReader br = new BufferedReader(read);
	            String row=new String();
	           
	            while ((row = br.readLine()) != null) 
	            {	
	            	if(row.length()>=10&&Date.equals(row.substring(0,10)))
	            	{
	            		str = str+row+"\n";
	            	} 
	         
	             }
	                        
	         } catch (FileNotFoundException e) {
	             e.printStackTrace();
	        } catch (IOException e) {
	              e.printStackTrace();
	          }
		 return str;

	 }
}