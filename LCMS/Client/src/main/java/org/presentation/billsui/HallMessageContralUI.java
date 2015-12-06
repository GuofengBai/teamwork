package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import org.presentation.organizationui.HallCarUI;
import org.presentation.organizationui.HallDriverUI;

public class HallMessageContralUI extends JPanel{
	private JPanel superview;
	private JPanel temp = this;
	public HallMessageContralUI(final JPanel superview) {
		this.superview = superview;
		setLayout(null);
		
		JLabel label = new JLabel("请选择管理项");
		label.setBounds(21, 10, 101, 15);
		add(label);
		
		JButton btnNewButton = new JButton("司机管理");
		btnNewButton.setBounds(10, 35, 93, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HallDriverUI ui = new HallDriverUI();
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton btnNewButton_1 = new JButton("车辆管理");
		btnNewButton_1.setBounds(10, 68, 93, 23);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HallCarUI ui = new HallCarUI();
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton back = new JButton("返回");
		back.setBounds(10, 101, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
	}

}
