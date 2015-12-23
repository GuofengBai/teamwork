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
import java.awt.Font;

public class BillsStateSearch extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(354, 25, 160, 118);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入订单编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(113, 266, 286, 39);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(328, 274, 259, 28);
		add(textField);
		textField.setColumns(10);
		
		answer = new JLabel("");
		answer.setFont(new Font("宋体", Font.PLAIN, 22));
		answer.setBounds(354, 471, 322, 39);
		add(answer);
		
		JButton button = new JButton("查询");
		button.setBounds(390, 413, 102, 45);
		add(button);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewSendingBillsBLService bl = BLFactory.getNewSendingBillsBL();
				String ans = bl.searchState(textField.getText());
				if(ans.equals("")){
					answer.setText("托运单号不存在");
				}else{
					answer.setText(ans);
				}
				
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
