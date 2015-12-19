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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(315, 229, 93, 23);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		JLabel label = new JLabel("\u6210\u672C\u6536\u76CA\u8868");
		label.setBounds(182, 10, 74, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u603B\u6536\u5165");
		label_1.setBounds(72, 64, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u603B\u652F\u51FA");
		label_2.setBounds(182, 64, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u6536\u76CA");
		label_3.setBounds(293, 64, 54, 15);
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
		incomeLabel.setBounds(72, 105, 54, 15);
		panel.add(incomeLabel);
		
		JLabel payLabel = new JLabel(String.valueOf(payment));
		payLabel.setBounds(182, 105, 54, 15);
		panel.add(payLabel);
		
		JLabel earnLabel = new JLabel(String.valueOf(earning));
		earnLabel.setBounds(293, 105, 54, 15);
		panel.add(earnLabel);
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ViewController.jumpToAnotherView(superView);
		}
		
	}

}
