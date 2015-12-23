package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import java.awt.Font;


public class CenterBusinessContralUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JPanel temp = this;

	/**
	 * Create the panel.
	 */
	public CenterBusinessContralUI(JPanel view) {
		this.superview = view;
		setLayout(null);
		
		JLabel label = new JLabel("中转中心业务管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(244, 26, 400, 147);
		add(label);
		
		JButton creatarrivebill = new JButton("中转中心到达单生成");
		creatarrivebill.setBounds(190, 186, 200, 80);
		add(creatarrivebill);
		creatarrivebill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewCenterArriveBillsUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton creatfreightbill = new JButton("中转中心中转单生成");
		creatfreightbill.setBounds(525, 186, 200, 80);
		add(creatfreightbill);
		creatfreightbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewCenterFreightBillsUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton createntruckbill = new JButton("中转中心装车单生成");
		createntruckbill.setBounds(190, 353, 200, 80);
		add(createntruckbill);
		
		createntruckbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewCenterEntruckBillsUI(temp);
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
