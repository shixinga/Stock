package com.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import com.dao.StoreRecodeDao;
import com.model.Record;
import com.utils.TimeUtils;


public class StoreRecordDaoFileImpl implements StoreRecodeDao {
	
	private Record data = Record.getRecode();
	public static final String filePath = "D:\\文档\\StoreData.txt";

			
	//构造函数
	public StoreRecordDaoFileImpl(String a1,String a2,String b1,String b2,
	String c1,String c2,String d1,String d2,String e1,String e2 )
	{
		if(a1!="")
		    {data.setaMIN(a1);}
		else{data.setaMIN("-∞");}
		
		if(a2!="")
	    {data.setaMAX(a2);}
	    else{data.setaMAX("+∞");}
		
		if(b1!="")
            {data.setbMIN(b1);}
		else{data.setbMIN("-∞");}
		
		
		if(b2!="")
		{data.setbMAX(b2);}
		else{data.setbMAX("+∞");}
		
		if(c1!="")
		{data.setcMIN(c1);}
		else{data.setcMIN("-∞");}
		
		if(c2!="")
		{data.setcMAX(c2);}
		else{data.setcMAX("+∞");}
		
		if(d1!="")
		{data.setdMIN(d1);}
		else{data.setdMIN("-∞");}
		
		if(d2!="")
		{data.setdMAX(d2);}
		else{data.setdMAX("+∞");}
		
		if(e1!="")
		{data.seteMIN(e1);}
		else{data.seteMIN("-∞");}
		
		if(e2!="")
		{data.seteMAX(e2);}
		else{data.seteMAX("+∞");}
	}
	
	
	
	//将要保存在10个数字连成字符串
	public	String getData()  
	{
		String StrData=" 涨跌幅度:"+data.getaMIN()+"~"+data.getaMAX()+"  现价："+data.getbMIN()+"~"+
	                data.getbMAX()+"  市盈率："+data.getcMIN()+"~"+data.getcMAX()+"  预测市盈率:"+data.getdMIN()+"~"+data.getdMAX()
	                +"  市净率:"+data.geteMIN()+"~"+data.geteMAX()+"\n";
		return StrData;
	}
	
	//将字符串保存到txt文件中
	public void printWriter(String st)
	{
		
		try
		{
		FileWriter objectName = 
		new FileWriter(new File(filePath), true);//创建文件
		PrintWriter pw = new PrintWriter(objectName);	
		pw.println(st);    //输出内容
		pw.close();
		}catch(IOException e){
		e.printStackTrace();
		}
	}
	
	//收藏记录(没有参数和返回值，直接调用就可以收藏记录）
	/* (non-Javadoc)
	 * @see com.dao.StoreRecodeDao#store()
	 */
	@Override
	public void store()
	{
		StoreRecordDaoFileImpl storeapp=new StoreRecordDaoFileImpl(data.getaMIN(), data.getaMAX(),
				data.getbMIN(), data.getbMAX(), data.getcMIN(), data.getcMAX(),data.getdMIN(), data.getdMAX(),data.geteMIN(), data.geteMAX());
		String st=TimeUtils.getCurrentTime()+storeapp.getData();		
		//调用PrintWriter方法，将字符串保存到txt文件中
		storeapp.printWriter(st);
		
	}
	 
	 //清空收藏记录（把所有收藏记录清空，但收藏记录文件还在）
	 /* (non-Javadoc)
	 * @see com.dao.StoreRecodeDao#clear()
	 */
	@Override
	public void clear()
	 {
		 try
			{
			FileWriter objectName = 
			new FileWriter(new File(filePath), false);//创建文件
			PrintWriter pw = new PrintWriter(objectName);	
			pw.println("");    //输出内容
			pw.close();
			}catch(IOException e){
			e.printStackTrace();
			}
	 }
	
}
