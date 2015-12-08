package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;

public class HallBusinessContralUI extends JPanel {
	private JPanel superview;
	private JPanel temp = this;

	/**
	 * Create the panel.
	 */
	public HallBusinessContralUI(JPanel view) {
		this.superview = view;
		setLayout(null);
		
		JLabel label = new JLabel("营业厅人员主界面");
		label.setBounds(93, 10, 155, 15);
		add(label);
		
		JLabel lblNewLabel = new JLabel("请选择以下业务");
		lblNewLabel.setBounds(10, 39, 102, 15);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("信息管理");
		btnNewButton.setBounds(30, 64, 226, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HallMessageContralUI ui = new HallMessageContralUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton btnNewButton_1 = new JButton("生成单据");
		btnNewButton_1.setBounds(30, 97, 226, 23);
		add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HallBillsContralUI ui = new HallBillsContralUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton back = new JButton("登出");
		back.setBounds(93, 130, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}
}
