package com.ui;

import java.util.Vector;
import java.io.UnsupportedEncodingException;



public class stockSift {
	Vector<Double> MinMax = new Vector<Double>();
	String StockData[][] = new String[3000][9];
	int STotal;
	int total;
	
	public stockSift() {
	}
	
	//选出最大最小值
	public Vector<Double> findMinmax(String[][] stockData,int t)
	{
		MinMax.clear();
		StockData = stockData;
		total = t;
		System.out.println(t);
		for(int j = 2; j < 7;j++)
		{
			double min = 0xffffff,max = -0xffffff;
			for(int i = 0; i < total;i++)
			{
				
				if(StockData[i][j].equals("--"))
				{
					continue;
				}
				double d = Double.valueOf(StockData[i][j]);
				if(d > max)
					max = d;
				if(d < min)
					min = d;	
			}
			MinMax.add(max);
			MinMax.add(min);
		}
		System.out.println(MinMax.get(1));
		return MinMax;
	}
}
