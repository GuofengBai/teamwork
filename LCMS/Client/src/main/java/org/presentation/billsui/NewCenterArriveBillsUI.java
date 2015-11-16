package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Label;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;


public class NewCenterArriveBillsUI extends JPanel {
	private JTextField year;
	private JTextField CABNum;
	private JTextField day;
	private JTextField month;
	private JTable table;
	private JTextField textField;
	DefaultTableModel intmodel=new DefaultTableModel();
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public NewCenterArriveBillsUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5230\u8FBE\u65E5\u671F  ");
		lblNewLabel.setBounds(19, 8, 60, 15);
		add(lblNewLabel);
		
		year = new JTextField();
		year.setBounds(94, 5, 56, 21);
		add(year);
		year.setColumns(10);
		
		month = new JTextField();
		month.setBounds(160, 5, 49, 21);
		add(month);
		month.setColumns(8);
		
		day = new JTextField();
		day.setBounds(219, 5, 49, 21);
		add(day);
		day.setColumns(8);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		lblNewLabel_1.setBounds(18, 34, 60, 15);
		add(lblNewLabel_1);
		
		CABNum = new JTextField();
		CABNum.setBounds(94, 31, 175, 21);
		add(CABNum);
		CABNum.setColumns(30);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setBounds(100, 260, 93, 23);
		add(button);
		Vector<String> vnum = new Vector<String>();
		vnum.add("���˵���");
		vnum.add("��Ʒ״̬");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(216);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(19, 138, 249, 112);
		add(scrollPane);
		
	
		table.setBounds(78, 88, 208, 256);
		
		JLabel label = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label.setBounds(19, 87, 54, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(94, 84, 176, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D27\u7269\u72B6\u6001");
		lblNewLabel_2.setBounds(19, 112, 54, 15);
		add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(94, 109, 66, 21);
		add(comboBox);
		comboBox.addItem("完整");
		comboBox.addItem("丢失");
		comboBox.addItem("损坏");
		
		JButton button_1 = new JButton("\u6DFB\u52A0\u8D27\u7269");
		button_1.setBounds(175, 108, 93, 23);
		add(button_1);
		
		JLabel label_1 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u7F16\u53F7");
		label_1.setBounds(19, 59, 72, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 56, 174, 21);
		add(textField_1);
		textField_1.setColumns(10);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
			}
			
		});
			
		};

	}

