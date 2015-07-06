package com.ui;

import com.dao.impl.StoreRecordDaoFileImpl;
import com.service.impl.StoreRecodeServiceImpl;
import com.service.impl.TongHuaSunServiceImpl;
import com.service.impl.XueQiuServiceImpl;
import com.utils.TimeUtils;

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

import org.junit.Test;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StockView extends JFrame {

	private JFrame frame;
	private JTextField[] MintextField = new JTextField[5];
	private JTextField[] MaxtextFied = new JTextField[5];
	private JLabel[] JMin = new JLabel[5];
	private JLabel[] JMax = new JLabel[5];
	private JButton resetBtn,searchBtn,storeBtn,XueQiuBtn,HuaBtn,RangeBtn;
	private JLabel lstocknum;
	
	private CreateTable table;
	private CreateTable2 table1;
	private String[] T ={"筛选历史记录"};
	private StockSift stocksift =new StockSift();
	//private Select select =new Select();
	//Vector<String> searchBase = new Vector<String>();
	String[][] stockData = new String[3000][9];
	String[][] stockData2 = new String[3000][9];
	int total,total2,bianbie=0;
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
	public StockView()  {
		
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1176, 628);
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
		JMin[0].setName("JMin[0]");
		pUpDown.add(JMin[0]);
		
		JMax[0] = new JLabel("最大值");
		JMax[0].setBounds(50, 65, 65, 15);
		JMax[0].setName("JMax[0]");
		pUpDown.add(JMax[0]);
		
		JLabel label_4 = new JLabel("范围");
		label_4.setBounds(0, 35, 54, 15);
		pUpDown.add(label_4);
		
		MintextField[0] = new JTextField();
		MintextField[0].setBounds(115, 35, 74, 18);
		MintextField[0].setName("MintextField0");
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
		JMin[1].setName("JMin[1]");
		pPrice.add(JMin[1]);
		
		JMax[1] = new JLabel("最大值");
		JMax[1].setBounds(50, 65, 65, 15);
		JMax[1].setName("JMax[1]");
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
		JMin[2].setName("JMin[2]");
		pProfit.add(JMin[2]);
		
		JMax[2] = new JLabel("最大值");
		JMax[2].setBounds(50, 65, 65, 15);
		JMax[2].setName("JMax[2]");
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
		JMin[3].setName("JMin[3]");
		pPreProfit.add(JMin[3]);
		
		JMax[3] = new JLabel("最大值");
		JMax[3].setBounds(50, 65, 65, 15);
		JMax[3].setName("JMax[3]");
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
		JMin[4].setName("JMin[4]");
		pPureProfit.add(JMin[4]);
		
		JMax[4] = new JLabel("最大值");
		JMax[4].setBounds(50, 65, 65, 15);
		JMax[4].setName("JMax[4]");
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
		resetBtn.setName("resetBtn");
		resetBtn.setBounds(10, 563, 63, 23);
		frame.getContentPane().add(resetBtn);
		
		XueQiuBtn = new JButton("雪球");
		XueQiuBtn.setBounds(241, 10, 93, 23);
		frame.getContentPane().add(XueQiuBtn);
		
		HuaBtn = new JButton("同花顺");
		HuaBtn.setBounds(344, 10, 93, 23);
		frame.getContentPane().add(HuaBtn);
		
		RangeBtn = new JButton("范围");
		RangeBtn.setName("resetBtn");
		RangeBtn.setBounds(229, 563, 63, 23);
		frame.getContentPane().add(RangeBtn);
		
		storeBtn = new JButton("收藏");
		storeBtn.setBounds(156, 563, 63, 23);
		frame.getContentPane().add(storeBtn);
		searchBtn.addMouseListener(handler);
		resetBtn.addMouseListener(handler);
		storeBtn.addMouseListener(handler);
		XueQiuBtn.addMouseListener(handler);
		HuaBtn.addMouseListener(handler);
		RangeBtn.addMouseListener(handler);
		
		
		
		table1 =new CreateTable2(T);
		table1.setBounds(741,43,409,510);
		frame.getContentPane().add(table1);
		
		setInfo();
		frame.setTitle("帮我选股票");
	}
	
	public void setInfo()
	{
		final XueQiuServiceImpl xq = new XueQiuServiceImpl();
		stockData2= xq.getStr();
		
		stockData = TongHuaSunServiceImpl.getJson("http://www.iwencai.com/stockpick/search?typed=1&preParams=&ts=1&f=1&qs=1&selfsectsn=&querytype=&searchfilter=&tid=stockpick&w=pe");
		total=stockData.length;
		
		total2=stockData2.length;
		lstocknum.setText(String.valueOf(total));
		table = new CreateTable(total,stockData);
		table.setBounds(241,43,490,510);
		frame.getContentPane().add(table);
		
		JLabel label = new JLabel("\u6536\u85CF");
		label.setBounds(742, 10, 54, 15);
		frame.getContentPane().add(label);
		
		MaxMin = stocksift.findMinmax(stockData,total);
		for(int i = 0,j = 0; i < 5;i++,j+=2)
		{
			if(MaxMin.get(j) == 0xffffff && MaxMin.get(j+1) == -0xffffff)
			{
				JMax[i].setText("--");
				JMin[i].setText("--");
				MintextField[i].setEditable(false);
				MaxtextFied[i].setEditable(false);
				return;
			}
			
			JMax[i].setText(String.valueOf(MaxMin.get(j)));
			JMin[i].setText(String.valueOf(MaxMin.get(j+1)));
			MintextField[i].setEditable(true);
			MaxtextFied[i].setEditable(true);
		}
		
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
				int test=1;
				String[] minmax =new String[12];
			
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
					if(bianbie==0)
					{
						String[][] stockData3 = stocksift.SearchStock(num, Min, Max,Total,stockData,total);
						frame.getContentPane().remove(table);
						table = new CreateTable(stocksift.getSearchTotal(),stockData3);
						lstocknum.setText(String.valueOf(stocksift.getSearchTotal()));
						table.setBounds(241,43,490,510);
						frame.getContentPane().add(table);
						frame.validate();
					}
					if(bianbie==1)
					{
						String[][] stockData3 = stocksift.SearchStock(num, Min, Max,Total,stockData2,total2);
					    //stockData2=select.MySort(minmax, stockData);
					    frame.getContentPane().remove(table);
					    table = new CreateTable(stocksift.getSearchTotal(),stockData3);
					    lstocknum.setText(String.valueOf(stocksift.getSearchTotal()));
					    table.setBounds(241,43,490,510);
					    frame.getContentPane().add(table);
					    frame.validate();
					}
					
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
			else if(e.getSource()== storeBtn)
			{
				String min2[] =new String[6];
				String max2[] =new String[6];
				String[] dataStr =new String[1];
				String[] time =new String[1];
				String[] Record =new String[1];
				for(int i = 0;i < 5;i++)
				{
				
						String maxx = MaxtextFied[i].getText();
						System.out.println(MaxtextFied[i].getText());
						String minn = MintextField[i].getText();
						System.out.println(MintextField[i].getText());
						max2[i] = maxx;
						min2[i] = minn;
				}
				StoreRecodeServiceImpl sr=new StoreRecodeServiceImpl(min2[0],max2[0],min2[1],max2[1],min2[2],
						max2[2],min2[3],max2[3],min2[4],max2[4]);
				dataStr[0]=sr.getData();
				time[0]=TimeUtils.getCurrentTime();
				Record[0]=time[0]+dataStr[0];
				sr.printWriter(Record[0]);
				table1.tableM.addRow(dataStr);
				
			}
			
			else if(e.getSource()== XueQiuBtn)
			{
				bianbie=1;
				frame.getContentPane().remove(table);
				table = new CreateTable(total2,stockData2);
				lstocknum.setText(String.valueOf(total2));
				for(int i = 0; i < 5;i++)
				{
					JMax[i].setText("最大值");
					JMin[i].setText("最小值");
					MintextField[i].setEditable(true);
					MaxtextFied[i].setEditable(true);
					if(i==3)
					{
						MintextField[i].setEditable(false);
						MaxtextFied[i].setEditable(false);
					}
				}
				table.setBounds(241,43,490,510);
				frame.getContentPane().add(table);
				frame.validate();
			}
			else if(e.getSource()==HuaBtn)
			{
				bianbie=0;
				frame.getContentPane().remove(table);
				table = new CreateTable(total,stockData);
				lstocknum.setText(String.valueOf(total));
				MintextField[3].setEditable(true);
			    MaxtextFied[3].setEditable(true);
				table.setBounds(241,43,490,510);
				frame.getContentPane().add(table);
				frame.validate();
			}
			else if(e.getSource()==RangeBtn)
			{
				if(bianbie==0)
				{
					MaxMin = stocksift.findMinmax(stockData,total);
					for(int i = 0,j = 0; i < 5;i++,j+=2)
					{
						if(MaxMin.get(j) == 0xffffff && MaxMin.get(j+1) == -0xffffff)
						{
							JMax[i].setText("--");
							JMin[i].setText("--");
							MintextField[i].setEditable(false);
							MaxtextFied[i].setEditable(false);
							return;
						}
						
						JMax[i].setText(String.valueOf(MaxMin.get(j)));
						JMin[i].setText(String.valueOf(MaxMin.get(j+1)));
						MintextField[i].setEditable(true);
						MaxtextFied[i].setEditable(true);
					}
				}
				if(bianbie==1)
				{
					MaxMin = stocksift.findMinmax(stockData2,total2);
					for(int i = 0,j = 0; i < 5;i++,j+=2)
					{
						if(MaxMin.get(j) == 0xffffff && MaxMin.get(j+1) == -0xffffff)
						{
							JMax[i].setText("--");
							JMin[i].setText("--");
							MintextField[i].setEditable(false);
							MaxtextFied[i].setEditable(false);
							return;
						}
						
						JMax[i].setText(String.valueOf(MaxMin.get(j)));
						JMin[i].setText(String.valueOf(MaxMin.get(j+1)));
						MintextField[i].setEditable(true);
						MaxtextFied[i].setEditable(true);
					}
				}
				
				
			}
		}
	}
}