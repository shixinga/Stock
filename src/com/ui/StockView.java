package com.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;



public class StockView {

	private JFrame frame;
	private JTextField mintextField1;
	private JTextField maxtextField1;
	private JTextField mintextField2;
	private JTextField maxtextField2;
	private JTextField mintextField3;
	private JTextField maxtextField3;
	private JTextField mintextField4;
	private JTextField maxtextField4;
	private JTextField mintextField5;
	private JTextField maxtextField5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockView window = new StockView();
					window.frame.setVisible(true);
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
		frame =  new JFrame();
		frame.setBounds(100, 100, 980, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Selectlabel = new JLabel("\u6761\u4EF6\u8BBE\u7F6E");
		Selectlabel.setFont(new Font("宋体", Font.PLAIN, 14));
		Selectlabel.setForeground(Color.DARK_GRAY);
		Selectlabel.setBounds(10, 10, 73, 15);
		frame.getContentPane().add(Selectlabel);
		
		JCheckBox checkBox = new JCheckBox("\u6DA8\u8DCC\u5E45\u5EA6");
		checkBox.setBounds(10, 50, 103, 23);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u73B0\u4EF7");
		checkBox_1.setBounds(10, 161, 103, 23);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\u5E02\u76C8\u7387");
		checkBox_2.setBounds(10, 291, 103, 23);
		frame.getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("\u9884\u6D4B\u5E02\u76C8\u7387");
		checkBox_3.setBounds(10, 417, 103, 23);
		frame.getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("\u5E02\u51C0\u7387");
		checkBox_4.setBounds(10, 535, 103, 23);
		frame.getContentPane().add(checkBox_4);
		
		JLabel label = new JLabel("\u8303\u56F4");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("宋体", Font.PLAIN, 13));
		label.setBounds(10, 77, 63, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8303\u56F4");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("宋体", Font.PLAIN, 13));
		label_1.setBounds(10, 190, 63, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8303\u56F4");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("宋体", Font.PLAIN, 13));
		label_2.setBounds(10, 320, 63, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8303\u56F4");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("宋体", Font.PLAIN, 13));
		label_3.setBounds(10, 446, 63, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u8303\u56F4");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("宋体", Font.PLAIN, 13));
		label_4.setBounds(10, 564, 63, 15);
		frame.getContentPane().add(label_4);
		
		JLabel minlabel1 = new JLabel("\u6700\u5C0F\u503C");
		minlabel1.setBounds(10, 97, 54, 15);
		frame.getContentPane().add(minlabel1);
		
		JLabel maxlabel1 = new JLabel("\u6700\u5927\u503C");
		maxlabel1.setBounds(10, 122, 54, 15);
		frame.getContentPane().add(maxlabel1);
		
		mintextField1 = new JTextField();
		mintextField1.setBounds(61, 94, 73, 21);
		frame.getContentPane().add(mintextField1);
		mintextField1.setColumns(10);
		
		maxtextField1 = new JTextField();
		maxtextField1.setColumns(10);
		maxtextField1.setBounds(61, 122, 73, 21);
		frame.getContentPane().add(maxtextField1);
		
		JLabel minlabel2 = new JLabel("\u6700\u5C0F\u503C");
		minlabel2.setBounds(10, 221, 54, 15);
		frame.getContentPane().add(minlabel2);
		
		JLabel maxlabel2 = new JLabel("\u6700\u5927\u503C");
		maxlabel2.setBounds(10, 246, 54, 15);
		frame.getContentPane().add(maxlabel2);
		
		mintextField2 = new JTextField();
		mintextField2.setColumns(10);
		mintextField2.setBounds(61, 215, 73, 21);
		frame.getContentPane().add(mintextField2);
		
		maxtextField2 = new JTextField();
		maxtextField2.setColumns(10);
		maxtextField2.setBounds(61, 243, 73, 21);
		frame.getContentPane().add(maxtextField2);
		
		JLabel minlabel3 = new JLabel("\u6700\u5C0F\u503C");
		minlabel3.setBounds(10, 348, 54, 15);
		frame.getContentPane().add(minlabel3);
		
		mintextField3 = new JTextField();
		mintextField3.setColumns(10);
		mintextField3.setBounds(61, 345, 73, 21);
		frame.getContentPane().add(mintextField3);
		
		JLabel maxlabel3 = new JLabel("\u6700\u5927\u503C");
		maxlabel3.setBounds(10, 373, 54, 15);
		frame.getContentPane().add(maxlabel3);
		
		maxtextField3 = new JTextField();
		maxtextField3.setColumns(10);
		maxtextField3.setBounds(61, 373, 73, 21);
		frame.getContentPane().add(maxtextField3);
		
		JLabel minlabel4 = new JLabel("\u6700\u5C0F\u503C");
		minlabel4.setBounds(10, 467, 54, 15);
		frame.getContentPane().add(minlabel4);
		
		JLabel maxlabel4 = new JLabel("\u6700\u5927\u503C");
		maxlabel4.setBounds(10, 495, 54, 15);
		frame.getContentPane().add(maxlabel4);
		
		mintextField4 = new JTextField();
		mintextField4.setColumns(10);
		mintextField4.setBounds(61, 464, 73, 21);
		frame.getContentPane().add(mintextField4);
		
		maxtextField4 = new JTextField();
		maxtextField4.setColumns(10);
		maxtextField4.setBounds(61, 492, 73, 21);
		frame.getContentPane().add(maxtextField4);
		
		JLabel minlabel5 = new JLabel("\u6700\u5C0F\u503C");
		minlabel5.setBounds(10, 589, 54, 15);
		frame.getContentPane().add(minlabel5);
		
		JLabel maxlabel5 = new JLabel("\u6700\u5927\u503C");
		maxlabel5.setBounds(10, 620, 54, 15);
		frame.getContentPane().add(maxlabel5);
		
		mintextField5 = new JTextField();
		mintextField5.setColumns(10);
		mintextField5.setBounds(61, 589, 73, 21);
		frame.getContentPane().add(mintextField5);
		
		maxtextField5 = new JTextField();
		maxtextField5.setColumns(10);
		maxtextField5.setBounds(61, 617, 73, 21);
		frame.getContentPane().add(maxtextField5);
		
		
		
		JButton selectBtn = new JButton("\u6761\u4EF6\u641C\u7D22");
		selectBtn.setBounds(582, 613, 93, 23);
		frame.getContentPane().add(selectBtn);
		
		JButton collectBtn = new JButton("\u6536\u85CF");
		collectBtn.setBounds(690, 613, 93, 23);
		frame.getContentPane().add(collectBtn);
		Object[][] Info={
				{"00607.SZ","abc","5.203","16.58","17590.61","147.59","13.37"},		
				{"00607.SZ","abc","5.203","16.58","17590.61","147.59","13.37"},
		};
		String[] Names={"股票代码","股票简称","涨跌幅","现价","市盈率","预测市盈率","市净率"};
		//frame.getContentPane().add(sp);
		
	    table = new JTable(Info,Names);

		table.setBounds(152, 54, 631, 550);
		
		frame.getContentPane().add(table);
		
		
		JLabel lblNewLabel = new JLabel("\u6536\u85CF");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(856, 29, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u80A1\u7968\u4EE3\u7801");
		lblNewLabel_1.setBounds(165, 29, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("\u80A1\u7968\u7B80\u79F0");
		label_5.setBounds(260, 29, 54, 15);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u6DA8\u8DCC\u5E45");
		label_6.setBounds(347, 29, 54, 15);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u73B0\u4EF7");
		label_7.setBounds(448, 29, 54, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u5E02\u76C8\u7387");
		label_8.setBounds(530, 29, 54, 15);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u9884\u6D4B\u5E02\u76C8\u7387");
		label_9.setBounds(614, 29, 73, 15);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u5E02\u51C0\u7387");
		label_10.setBounds(709, 29, 54, 15);
		frame.getContentPane().add(label_10);
	}
}