package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.swing.JButton;


public class StockView {

	private JFrame frame;
	private JTextField[] MintextField = new JTextField[5];
	private JTextField[] MaxtextFied = new JTextField[5];
	private JLabel[] JMin = new JLabel[5];
	private JLabel[] JMax = new JLabel[5];
	private JButton resetBtn,searchBtn;
	private JLabel lstocknum;
	
	private createTable table;
	//Vector<String> searchBase = new Vector<String>();
	String[][] stockData = new String[3000][9];
	int total;
	Vector<Double> MaxMin = new Vector<Double>();
	MouseHandler handler = new MouseHandler();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//dialog = new Dialog();
					//dialog.setVisible(true);
					//progressBar =  new ProgressBar();//创建进度条
		           

					StockView window = new StockView();
					window.frame.setVisible(true);
					
					//progressBar.stopThread();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockView() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelSet = new JPanel();
		panelSet.setBounds(10, 10, 221, 518);
		frame.getContentPane().add(panelSet);
		panelSet.setLayout(null);
		
		JLabel lChoose = new JLabel("条件设置");
		lChoose.setBounds(10, 10, 54, 15);
		panelSet.add(lChoose);
		
		JPanel pUpDown = new JPanel();
		pUpDown.setBounds(0, 35, 220, 95);
		panelSet.add(pUpDown);
		pUpDown.setLayout(null);
		
		JLabel lupdown = new JLabel("涨跌幅度");
		lupdown.setBounds(0, 10, 84, 15);
		pUpDown.add(lupdown);
		
		JMin[0] = new JLabel("最小值");
		JMin[0].setBounds(50, 35, 65, 15);
		pUpDown.add(JMin[0]);
		
		JMax[0] = new JLabel("最大值");
		JMax[0].setBounds(50, 65, 65, 15);
		pUpDown.add(JMax[0]);
		
		JLabel label_4 = new JLabel("范围");
		label_4.setBounds(0, 35, 54, 15);
		pUpDown.add(label_4);
		
		MintextField[0] = new JTextField();
		MintextField[0].setBounds(115, 35, 74, 18);
		pUpDown.add(MintextField[0]);
		MintextField[0].setColumns(10);
		
		MaxtextFied[0] = new JTextField();
		MaxtextFied[0].setBounds(115, 65, 74, 18);
		pUpDown.add(MaxtextFied[0]);
		MaxtextFied[0].setColumns(10);
		
		JLabel lDelect1 = new JLabel("删除");
		lDelect1.setForeground(Color.BLUE);
		lDelect1.setBounds(0, 82, 54, 15);
		pUpDown.add(lDelect1);
		
		JPanel pPrice = new JPanel();
		pPrice.setLayout(null);
		pPrice.setBounds(0, 130, 220, 95);
		panelSet.add(pPrice);
		
		JLabel lPrice = new JLabel("现价");
		lPrice.setBounds(0, 10, 84, 15);
		pPrice.add(lPrice);
		
		JMin[1] = new JLabel("最小值");
		JMin[1].setBounds(50, 35, 65, 15);
		pPrice.add(JMin[1]);
		
		JMax[1] = new JLabel("最大值");
		JMax[1].setBounds(50, 65, 65, 15);
		pPrice.add(JMax[1]);
		
		JLabel label_8 = new JLabel("范围");
		label_8.setBounds(0, 35, 54, 15);
		pPrice.add(label_8);
		
		MintextField[1] = new JTextField();
		MintextField[1].setColumns(10);
		MintextField[1].setBounds(115, 35, 74, 18);
		pPrice.add(MintextField[1]);
		
		MaxtextFied[1] = new JTextField();
		MaxtextFied[1].setColumns(10);
		MaxtextFied[1].setBounds(115, 65, 74, 18);
		pPrice.add(MaxtextFied[1]);
		
		JLabel lDelect2 = new JLabel("删除");
		lDelect2.setForeground(Color.BLUE);
		lDelect2.setBounds(0, 81, 54, 15);
		pPrice.add(lDelect2);
		
		JPanel pProfit = new JPanel();
		pProfit.setLayout(null);
		pProfit.setBounds(0, 226, 220, 95);
		panelSet.add(pProfit);
		
		JLabel lProfit = new JLabel("市盈率");
		lProfit.setBounds(0, 10, 84, 15);
		pProfit.add(lProfit);
		
		JMin[2] = new JLabel("最小值");
		JMin[2].setBounds(50, 35, 65, 15);
		pProfit.add(JMin[2]);
		
		JMax[2] = new JLabel("最大值");
		JMax[2].setBounds(50, 65, 65, 15);
		pProfit.add(JMax[2]);
		
		JLabel label_12 = new JLabel("范围");
		label_12.setBounds(0, 35, 54, 15);
		pProfit.add(label_12);
		
		MintextField[2] = new JTextField();
		MintextField[2].setColumns(10);
		MintextField[2].setBounds(115, 35, 74, 18);
		pProfit.add(MintextField[2]);
		
		MaxtextFied[2] = new JTextField();
		MaxtextFied[2].setColumns(10);
		MaxtextFied[2].setBounds(115, 65, 74, 18);
		pProfit.add(MaxtextFied[2]);
		
		JLabel lDelect3 = new JLabel("删除");
		lDelect3.setForeground(Color.BLUE);
		lDelect3.setBounds(0, 81, 54, 15);
		pProfit.add(lDelect3);
		
		JPanel pPreProfit = new JPanel();
		pPreProfit.setLayout(null);
		pPreProfit.setBounds(0, 320, 220, 95);
		panelSet.add(pPreProfit);
		
		JLabel lpreProfit = new JLabel("预测市盈率");
		lpreProfit.setBounds(0, 10, 84, 15);
		pPreProfit.add(lpreProfit);
		
		JMin[3] = new JLabel("最小值");
		JMin[3].setBounds(50, 35, 65, 15);
		pPreProfit.add(JMin[3]);
		
		JMax[3] = new JLabel("最大值");
		JMax[3].setBounds(50, 65, 65, 15);
		pPreProfit.add(JMax[3]);
		
		JLabel label_16 = new JLabel("范围");
		label_16.setBounds(0, 35, 54, 15);
		pPreProfit.add(label_16);
		
		MintextField[3] = new JTextField();
		MintextField[3].setColumns(10);
		MintextField[3].setBounds(115, 35, 74, 18);
		pPreProfit.add(MintextField[3]);
		
		MaxtextFied[3] = new JTextField();
		MaxtextFied[3].setColumns(10);
		MaxtextFied[3].setBounds(115, 65, 74, 18);
		pPreProfit.add(MaxtextFied[3]);
		
		JLabel lDelect4 = new JLabel("删除");
		lDelect4.setForeground(Color.BLUE);
		lDelect4.setBounds(0, 81, 54, 15);
		pPreProfit.add(lDelect4);
		
		JPanel pPureProfit = new JPanel();
		pPureProfit.setLayout(null);
		pPureProfit.setBounds(0, 416, 220, 95);
		panelSet.add(pPureProfit);
		
		JLabel lPureProfit = new JLabel("市净率");
		lPureProfit.setBounds(0, 10, 84, 15);
		pPureProfit.add(lPureProfit);
		
		JMin[4] = new JLabel("最小值");
		JMin[4].setBounds(50, 35, 65, 15);
		pPureProfit.add(JMin[4]);
		
		JMax[4] = new JLabel("最大值");
		JMax[4].setBounds(50, 65, 65, 15);
		pPureProfit.add(JMax[4]);
		
		JLabel label_20 = new JLabel("范围");
		label_20.setBounds(0, 38, 54, 15);
		pPureProfit.add(label_20);
		
		MintextField[4] = new JTextField();
		MintextField[4].setColumns(10);
		MintextField[4].setBounds(115, 35, 74, 18);
		pPureProfit.add(MintextField[4]);
		
		MaxtextFied[4] = new JTextField();
		MaxtextFied[4].setColumns(10);
		MaxtextFied[4].setBounds(115, 65, 74, 18);
		pPureProfit.add(MaxtextFied[4]);
		
		JLabel lDelect5 = new JLabel("删除");
		lDelect5.setForeground(Color.BLUE);
		lDelect5.setBounds(0, 81, 54, 15);
		pPureProfit.add(lDelect5);
		
		table = new createTable(total,stockData);
		table.setBounds(241,43,490,510);
		frame.getContentPane().add(table);
		
		searchBtn = new JButton("搜索");
		searchBtn.setBounds(83, 563, 63, 23);
		frame.getContentPane().add(searchBtn);
		
		JLabel lblNewLabel = new JLabel("搜索股票数");
		lblNewLabel.setBounds(10, 538, 82, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lstocknum = new JLabel("未知");
		lstocknum.setBounds(83, 538, 54, 15);
		frame.getContentPane().add(lstocknum);
		
		resetBtn = new JButton("重置");
		resetBtn.setBounds(10, 563, 63, 23);
		frame.getContentPane().add(resetBtn);
		searchBtn.addMouseListener(handler);
		resetBtn.addMouseListener(handler);
		
		frame.setTitle("帮我选股票");
	}
	
	private class MouseHandler extends MouseAdapter
	{
		public  void mouseClicked(MouseEvent e)
		{
			if(e.getSource() == searchBtn)
			{
				int[] num = new int[6];
				double[] Max = new double[6],Min = new double[6];
				int Total = 0;
			
				for(int i = 0;i < 5;i++)
				{
					try{
						double maxx = Double.parseDouble(MaxtextFied[i].getText());
						System.out.println(MaxtextFied[i].getText());
						double minn = Double.parseDouble(MintextField[i].getText());
						System.out.println(MintextField[i].getText());
						num[Total] = i;
						Max[Total] = maxx;
						Min[Total] = minn;
						Total++;
					}catch(Exception en)
					{
						System.out.println("第"+i+"列");
					   //如果有异常 ， s 字符串就不是一个double
					}
				}
				if(Total > 0)
				{
					
				}
				
			}
			else if(e.getSource() == resetBtn)
			{
				for(int i = 0;i < 5;i++)
				{
					MaxtextFied[i].setText("");
					MintextField[i].setText("");
				}
			
				
			}
		}
	}
}