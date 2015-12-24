package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import java.awt.Font;

public class PostmanUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel temp = this;

	/**
	 * Create the panel.
	 */
	public PostmanUI(final JPanel superview) {
		setLayout(null);
		
		JLabel label = new JLabel("快递员收发管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(267, 26, 361, 147);
		add(label);
		
		JLabel label_1 = new JLabel("请选择以下业务");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(373, 252, 255, 39);
		add(label_1);
		
		JButton creatsendingbill = new JButton("新建寄件单");
		creatsendingbill.setBounds(190, 353, 200, 80);
		add(creatsendingbill);
		creatsendingbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewSendingBillsUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton creatreceivebill = new JButton("新建收件单");
		creatreceivebill.setBounds(525, 353, 200, 80);
		add(creatreceivebill);
		
		creatreceivebill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new ReceiveMessageUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton back = new JButton("登出");
		back.setBounds(643, 740, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}
}
