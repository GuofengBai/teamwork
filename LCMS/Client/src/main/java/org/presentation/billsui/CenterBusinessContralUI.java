package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;


public class CenterBusinessContralUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterBusinessContralUI() {
		setLayout(null);
		
		JLabel label = new JLabel("中转中心业务管理系统");
		label.setBounds(31, 10, 122, 15);
		add(label);
		
		JLabel label_1 = new JLabel("您可以选择以下操作");
		label_1.setBounds(10, 35, 113, 15);
		add(label_1);
		
		JButton creatarrivebill = new JButton("中转中心到达单生成");
		creatarrivebill.setBounds(20, 60, 141, 23);
		add(creatarrivebill);
		creatarrivebill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewCenterArriveBillsUI();
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton creatfreightbill = new JButton("中转中心中转单生成");
		creatfreightbill.setBounds(20, 93, 141, 23);
		add(creatfreightbill);
		creatfreightbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewCenterFreightBillsUI();
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton createntruckbill = new JButton("中转中心装车单生成");
		createntruckbill.setBounds(20, 126, 141, 23);
		add(createntruckbill);
		createntruckbill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new NewCenterEntruckBillsUI();
				ViewController.jumpToAnotherView(next);
			}
		});

	}
}
