package org.presentation.manageui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.IncomeTableBLService;
import org.presentation.mainui.ViewController;
import java.awt.Font;


public class IncomeTableUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = this;
	private JPanel superView;
	private JFrame frame;
	private long income=0;
	private long payment=0;
	private long earning=0;

	/**
	 * Create the application.
	 */
	public IncomeTableUI(JPanel su) {
		this.superView=su;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(707, 600, 150, 40);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		JLabel label = new JLabel("\u6210\u672C\u6536\u76CA\u8868");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(380, 10, 226, 57);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u603B\u6536\u5165");
		label_1.setFont(new Font("宋体", Font.PLAIN, 35));
		label_1.setBounds(203, 158, 114, 40);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u603B\u652F\u51FA");
		label_2.setFont(new Font("宋体", Font.PLAIN, 35));
		label_2.setBounds(422, 154, 122, 48);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u6536\u76CA");
		label_3.setFont(new Font("宋体", Font.PLAIN, 35));
		label_3.setBounds(638, 150, 93, 56);
		panel.add(label_3);
/**	
 */	
		IncomeTableBLService it=BLFactory.getIncomeTableBL();
		income=it.getIncome();
		payment=it.getPayment();
		earning=income-payment;
/*
*/				
		JLabel incomeLabel = new JLabel(String.valueOf(income));
		incomeLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		incomeLabel.setBounds(203, 350, 137, 48);
		panel.add(incomeLabel);
		
		JLabel payLabel = new JLabel(String.valueOf(payment));
		payLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		payLabel.setBounds(422, 350, 137, 48);
		panel.add(payLabel);
		
		JLabel earnLabel = new JLabel(String.valueOf(earning));
		earnLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		earnLabel.setBounds(651, 353, 122, 43);
		panel.add(earnLabel);
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ViewController.jumpToAnotherView(superView);
		}
		
	}

}
