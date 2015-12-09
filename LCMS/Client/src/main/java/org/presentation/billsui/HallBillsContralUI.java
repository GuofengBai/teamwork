package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;

public class HallBillsContralUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel temp = this;

	/**
	 * Create the panel.
	 */
	public HallBillsContralUI(final JPanel superview) {
		setLayout(null);
		
		JLabel label = new JLabel("请选择生成的单据类型");
		label.setBounds(10, 10, 188, 15);
		add(label);
		
		JButton arrive = new JButton("到达单");
		arrive.setBounds(10, 35, 93, 23);
		add(arrive);
		arrive.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallArriveBillsUI ui = new NewHallArriveBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton entruck = new JButton("装车单");
		entruck.setBounds(10, 68, 93, 23);
		add(entruck);
		entruck.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallEntruckBillsUI ui = new NewHallEntruckBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton dispatch = new JButton("派件单");
		dispatch.setBounds(113, 35, 93, 23);
		add(dispatch);
		dispatch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsUI ui = new NewHallDispatchBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton collect = new JButton("收款单");
		collect.setBounds(113, 68, 93, 23);
		add(collect);
		
		collect.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallCollectionBillsUI ui = new NewHallCollectionBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton back = new JButton("返回");
		back.setBounds(62, 101, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}

}
