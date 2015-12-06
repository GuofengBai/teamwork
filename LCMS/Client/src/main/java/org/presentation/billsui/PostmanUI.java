package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;

public class PostmanUI extends JPanel {
	private JPanel superview;
	private JPanel temp = this;

	/**
	 * Create the panel.
	 */
	public PostmanUI(final JPanel superview) {
		this.superview = superview;
		setLayout(null);
		
		JLabel label = new JLabel("快递员界面");
		label.setBounds(121, 10, 67, 15);
		add(label);
		
		JLabel label_1 = new JLabel("请选择以下业务");
		label_1.setBounds(10, 37, 93, 15);
		add(label_1);
		
		JButton creatsendingbill = new JButton("新建寄件单");
		creatsendingbill.setBounds(36, 62, 220, 23);
		add(creatsendingbill);
		creatsendingbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewSendingBillsUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton creatreceivebill = new JButton("新建收件单");
		creatreceivebill.setBounds(36, 98, 220, 23);
		add(creatreceivebill);
		creatreceivebill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new ReceiveMessageUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});

	}
}
