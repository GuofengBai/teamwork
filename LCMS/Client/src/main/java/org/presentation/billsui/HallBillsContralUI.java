package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import java.awt.Font;

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
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(341, 100, 255, 39);
		add(label);
		
		JButton arrive = new JButton("营业厅到达单");
		arrive.setBounds(190, 186, 200, 80);
		add(arrive);
		arrive.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallArriveBillsUI ui = new NewHallArriveBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton entruck = new JButton("营业厅装车单");
		entruck.setBounds(190, 353, 200, 80);
		add(entruck);
		entruck.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallEntruckBillsUI ui = new NewHallEntruckBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton dispatch = new JButton("营业厅派件单");
		dispatch.setBounds(525, 186, 200, 80);
		add(dispatch);
		dispatch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsUI ui = new NewHallDispatchBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton collect = new JButton("营业厅收款单");
		collect.setBounds(525, 353, 200, 80);
		add(collect);
		
		collect.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallCollectionBillsUI ui = new NewHallCollectionBillsUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
		});
		
		JButton back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}

}
