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
import org.presentation.mainui.ViewController;


public class ReceiveMessageUI extends JPanel {
	private JPanel superview;
	private JTextField goodNum;
	private JTextField receiverName;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JButton back;

	/**
	 * Create the panel.
	 */
	public ReceiveMessageUI(final JPanel superview) {
		this.superview = superview;
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
		submit.setBounds(20, 85, 93, 23);
		add(submit);
		
		back = new JButton("返回");
		back.setBounds(139, 85, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
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
