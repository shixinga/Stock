package com.ui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class CreateTable2 extends JPanel {

	private String[] colName={"¼ÇÂ¼"};
	
	Object[][] row={};
	 DefaultTableModel tableM = new DefaultTableModel(row,colName){  
	      @Override  
	      public boolean isCellEditable(int row,int column){  
	          return false;  
	      }  
	  }; 
	JTable jtable= new JTable(tableM);
	
	public CreateTable2(String[] str)
	{
		
	    tableM.addRow(str);
		this.setLayout(new BorderLayout());
		add(new JScrollPane(jtable),
	    BorderLayout.CENTER);
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	}
	public void addR(String[] str)
	{
		tableM.addRow(str);
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	}
}