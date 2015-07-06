package com.ui;

import java.util.Vector;
import java.io.UnsupportedEncodingException;



public class StockSift {
	Vector<Double> MinMax = new Vector<Double>();
	Vector<Double> MinMax2 = new Vector<Double>();
	String StockData[][] = new String[3000][9];
	String StockData2[][] =new String[3000][9];
	double[] Min= new double[6];
	double[] Max= new double[6];
	int SearchTotal;
	int total,total2;
	
	public StockSift() {
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
				if(StockData[i][j].equals(null))
				{
					continue;
				}
				
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

	public String[][] SearchStock(int[] Num, double[] MinC, double[] MaxC,int Total,String[][] s,int t)
	{
		total=t;
		StockData=s;
		System.out.println(String.valueOf(Total));
		System.out.println(StockData.length);
		String[][] temp = StockData;
		String[][] stockResult = new String[3000][9];
		SearchTotal = total;
		
		for(int i = 0; i < Total;i++)
		{
			int k = Num[i]+2;
			
			int temptotal = 0;
			for(int j = 0;j < SearchTotal;j++)
			{
				if(temp[j][k].equals("--"))
					continue;
				
				if(Double.valueOf(temp[j][k]) <= MaxC[i] && Double.valueOf(temp[j][k]) >= MinC[i])
				{
					stockResult[temptotal] = temp[j];
					if(i == Total-1)
					{
						System.out.println(temp[j][0]+" "+temp[j][1]+" "+temp[j][2]+" "+temp[j][3]+" "+temp[j][4]+" "+temp[j][5]);
					}
					temptotal++;
				}
			}
			SearchTotal = temptotal;
			temp = stockResult;
		}
		
		
		return stockResult;
	}
	
	public int getSearchTotal()
	{
		return SearchTotal;
	}
}



