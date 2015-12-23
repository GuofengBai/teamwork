package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import java.awt.Font;

public class HallBusinessContralUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JPanel temp = this;

	/**
	 * Create the panel.
	 */
	public HallBusinessContralUI(JPanel view) {
		this.superview = view;
		setLayout(null);
		
		JLabel label = new JLabel("营业厅业务管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(273, 26, 371, 147);
		add(label);
		
		JLabel lblNewLabel = new JLabel("请选择以下业务");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(376, 262, 257, 45);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("信息管理");
		btnNewButton.setBounds(190, 353, 200, 80);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HallMessageContralUI ui = new HallMessageContralUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton btnNewButton_1 = new JButton("生成单据");
		btnNewButton_1.setBounds(525, 353, 200, 80);
		add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HallBillsContralUI ui = new HallBillsContralUI(temp);
				ViewController.jumpToAnotherView(ui);
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
