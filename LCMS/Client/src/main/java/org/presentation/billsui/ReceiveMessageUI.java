package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.ReceiveMessageBLService;
import org.po.myDate;


public class ReceiveMessageUI extends JPanel {
	private JTextField goodNum;
	private JTextField receiverName;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;

	/**
	 * Create the panel.
	 */
	public ReceiveMessageUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("快递单号");
		lblNewLabel.setBounds(10, 10, 54, 15);
		add(lblNewLabel);
		
		goodNum = new JTextField();
		goodNum.setBounds(74, 7, 166, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("收件人姓名");
		lblNewLabel_1.setBounds(10, 35, 66, 15);
		add(lblNewLabel_1);
		
		receiverName = new JTextField();
		receiverName.setBounds(74, 32, 166, 21);
		add(receiverName);
		receiverName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("收件日期");
		lblNewLabel_2.setBounds(10, 60, 54, 15);
		add(lblNewLabel_2);
		
		newyear = new JTextField();
		newyear.setBounds(74, 57, 66, 21);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(150, 57, 40, 21);
		add(newmonth);
		newmonth.setColumns(10);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(200, 57, 40, 21);
		add(newday);
		
		JButton submit = new JButton("添加");
		submit.setBounds(84, 87, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ReceiveMessageBLService bl = BLFactory.getReceiveMessageBL();
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				bl.addMessage(goodNum.getText(),receiverName.getText(),date);
			}
		});

	}
}
