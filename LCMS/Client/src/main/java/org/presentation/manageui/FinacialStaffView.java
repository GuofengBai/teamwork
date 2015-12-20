package org.presentation.manageui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import org.presentation.userui.UserUI;
import java.awt.Font;


public class FinacialStaffView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel panel = this;
	private JPanel superview;
	
	private JButton backButton;
	private JButton incomeButton;
	private JButton paymentButton;
	private JButton beginaccountButton;
	private JButton accountButton;
	private JButton earningButton;
	private JButton statusButton;
	private JPanel temp;

	/**
	 * Create the application.
	 */
	public FinacialStaffView() {
		this.temp=this;
		initialize();
	}
	
	public FinacialStaffView(JPanel panel) {
		this.superview=panel;
		this.temp=this;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		backButton = new JButton("\u8FD4\u56DE");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(710, 600, 150, 40);
		panel.add(backButton);
		backButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(superview==null){
					UserUI ui=new UserUI();
					ViewController.jumpToAnotherView(ui);
				}else{
					ViewController.jumpToAnotherView(superview);
				}
				
			}
			
		});
		
		incomeButton = new JButton("\u7ED3\u7B97\u7BA1\u7406");
		incomeButton.setFont(new Font("宋体", Font.PLAIN, 25));
		incomeButton.setBounds(488, 100, 200, 80);
		panel.add(incomeButton);
		incomeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IncomeManagementUI ui=new IncomeManagementUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
			
		});
		
		JLabel label = new JLabel("\u8D22\u52A1\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(350, 10, 182, 49);
		panel.add(label);
		
		paymentButton = new JButton("\u6210\u672C\u7BA1\u7406");
		paymentButton.setFont(new Font("宋体", Font.PLAIN, 25));
		paymentButton.setBounds(200, 100, 200, 80);
		panel.add(paymentButton);
		paymentButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CostManageUI ui=new CostManageUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
			
		});
		
		beginaccountButton = new JButton("\u671F\u521D\u5EFA\u8D26");
		beginaccountButton.setFont(new Font("宋体", Font.PLAIN, 25));
		beginaccountButton.setBounds(200, 245, 200, 80);
		panel.add(beginaccountButton);
		beginaccountButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BeginAccountUI ui=new BeginAccountUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
			
		});
		
		accountButton = new JButton("\u8D26\u6237\u7BA1\u7406");
		accountButton.setFont(new Font("宋体", Font.PLAIN, 25));
		accountButton.setBounds(488, 245, 200, 80);
		panel.add(accountButton);
		accountButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AccountManageUI ui=new AccountManageUI(temp);
				ViewController.jumpToAnotherView(ui);
			}
			
		});
		
		earningButton = new JButton("\u6210\u672C\u6536\u76CA\u8868");
		earningButton.setFont(new Font("宋体", Font.PLAIN, 25));
		earningButton.setBounds(200, 467, 200, 80);
		panel.add(earningButton);
		earningButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next=new IncomeTableUI(temp);
				ViewController.jumpToAnotherView(next);
			}
			
		});
		
		statusButton = new JButton("\u7ECF\u8425\u60C5\u51B5\u8868");
		statusButton.setFont(new Font("宋体", Font.PLAIN, 25));
		statusButton.setBounds(488, 467, 200, 80);
		panel.add(statusButton);
		
		JLabel label_1 = new JLabel("统计报表");
		label_1.setFont(new Font("宋体", Font.PLAIN, 30));
		label_1.setBounds(389, 370, 120, 55);
		add(label_1);
		statusButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel next=new StatusTableUI(temp);
				ViewController.jumpToAnotherView(next);
			}
			
		});
	}
}
