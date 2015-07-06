package com.ui;

import javax.swing.JOptionPane;

public class Select {
	String datatemp[][] = new String[10000][7];
	double a[]= new double[10];
	public String[][] MySort(String[] command, String[][] data)
	{
		for(int i=0; i<10 ; i+=2)
		{
			if(command[i]=="")
				a[i] = -1000000;
			else
				a[i]=Double.parseDouble(command[i]);
			if(command[i+1]=="")
				a[i+1] = 1000000;
			else
				a[i+1]=Double.parseDouble(command[i+1]);
		}
		double fluctuation_min = a[0] , fluctuation_max = a[1];
		double price_min = a[2] , price_max = a[3];
		double pe_min = a[4] , pe_max = a[5];
		double predictedpe_min = a[6] , predictedpe_max = a[7];
		double pb_min = a[8] , pb_max = a[9];
		for(int j=0;j<data.length;j++){
			for(int i=0;i<data[j].length;i++){
				if(data[j][i] == null)
					break;
				else
					datatemp[j][i]=data[j][i];
			}
		}
		if(a[0]<=a[1] && a[2]<=a[3] && a[4]<=a[5] && a[6]<=a[7] && a[8]<=a[9])
		{
			if(!(fluctuation_min == -1000000 && fluctuation_max== 1000000))
				datatemp = tosort(fluctuation_min,fluctuation_max,data,2);
			if(!(price_min == -1000000 && price_max== 1000000))
				datatemp = tosort(price_min,price_max,datatemp,3);
			if(!(pe_min == -1000000 && pe_max== 1000000))
				datatemp = tosort(pe_min,pe_max,datatemp,4);
			if(!(predictedpe_min == -1000000 && predictedpe_max== 1000000))
				datatemp = tosort(predictedpe_min,predictedpe_max,datatemp,5);
			if(!(pb_min == -1000000 && pb_max== 1000000))
				datatemp = tosort(pb_min,pb_max,datatemp,6);
			
			datatemp = choose_sort(datatemp,2);
		}
		else
		{
			//弹出对话框提示数值设置错误
			JOptionPane.showMessageDialog(null, "Wrong Input!", "Warning", JOptionPane.ERROR_MESSAGE); 
		}
		return datatemp;
	}
	public String[][] tosort(double min, double max,
			String[][] data, int j) {
		int m=0;
		String[][] temp = new String[10000][7];
		for(int i=0 ; i < data.length ; i++ )
		{
			if(data[i][j] != null )
			{
				if(data[i][j] != "--")
				if(Double.parseDouble(data[i][j]) >= min && Double.parseDouble(data[i][j]) <= max)
				{
					for(int k=0;k<7;k++)
					{
						temp[m][k] = data[i][k];
					}
					m++;
				}
			}
			else
				break;
		}
		return temp;
	}

	public String[][] choose_sort(String[][] data,int j) {
		for(int i=0 ; i < data.length ; i++ )
		{
			int highIndex = i;
			for(int k=i+1; k < data.length ; k++)
			{
				if(data[k][j] != null)
				{
					if(Double.parseDouble(data[k][j]) > Double.parseDouble(data[highIndex][j]))
					{
						highIndex=k;
					}
				}
				else
					break;
			}
			String[] s = new String[7];
			for(int n=0;n<7;n++)
			{
			s[n] = data[i][n];             
			data[i][n] = data[highIndex][n];  
			data[highIndex][n] = s[n];  
			}
		}
		return data;

	}
}



