package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.presentation.mainui.ViewController;

public class BillsStateSearch extends JPanel {
	private JTextField textField;
	private JLabel answer;
	private JPanel superview;

	/**
	 * Create the panel.
	 */
	public BillsStateSearch(JPanel view) {
		this.superview=view;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("订单查询");
		lblNewLabel.setBounds(71, 10, 135, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入订单编号");
		lblNewLabel_1.setBounds(10, 35, 120, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(20, 60, 186, 21);
		add(textField);
		textField.setColumns(10);
		
		answer = new JLabel("");
		answer.setBounds(10, 124, 196, 15);
		add(answer);
		
		JButton button = new JButton("查询");
		button.setBounds(10, 91, 93, 23);
		add(button);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewSendingBillsBLService bl = BLFactory.getNewSendingBillsBL();
				String ans = bl.searchState(textField.getText());
				answer.setText(ans);
			}
		});
		
		JButton back = new JButton("返回");
		back.setBounds(113, 91, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}
}
