package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import org.presentation.organizationui.HallCarUI;
import org.presentation.organizationui.HallDriverUI;
import java.awt.Font;

public class HallMessageContralUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel temp;
	private JPanel superView;

	public HallMessageContralUI(JPanel su) {
		super();
		this.superView=su;
		this.temp=this;
		setLayout(null);
		
		JLabel label = new JLabel("请选择管理项");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(403, 100, 193, 39);
		add(label);
		
		JButton btnNewButton = new JButton("司机管理");
		btnNewButton.setBounds(190, 250, 200, 80);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next = new HallDriverUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton btnNewButton_1 = new JButton("车辆管理");
		btnNewButton_1.setBounds(525, 250, 200, 80);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next = new HallCarUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		JButton back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
			}
		});
	}

}
