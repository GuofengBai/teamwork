package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;


public class FinacialStaffView extends JPanel{

	private JFrame frame;
	private JPanel panel = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinacialStaffView window = new FinacialStaffView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinacialStaffView() {
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
		
		JLabel label = new JLabel("\u8D22\u52A1\u7BA1\u7406");
		label.setBounds(182, 10, 54, 15);
		panel.add(label);
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(302, 229, 93, 23);
		panel.add(backButton);
		
		JButton incomeButton = new JButton("\u7ED3\u7B97\u7BA1\u7406");
		incomeButton.setBounds(75, 69, 93, 23);
		panel.add(incomeButton);
		incomeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			}
			
		});
		
		JButton paymentButton = new JButton("\u6210\u672C\u7BA1\u7406");
		paymentButton.setBounds(240, 69, 93, 23);
		panel.add(paymentButton);
		
		JButton beginaccoutButton = new JButton("\u671F\u521D\u5EFA\u8D26");
		beginaccoutButton.setBounds(75, 123, 93, 23);
		panel.add(beginaccoutButton);
		
		JButton accountButton = new JButton("\u8D26\u6237\u7BA1\u7406");
		accountButton.setBounds(240, 123, 93, 23);
		panel.add(accountButton);
		
		JButton earningButton = new JButton("\u6210\u672C\u6536\u76CA\u8868");
		earningButton.setBounds(75, 177, 93, 23);
		panel.add(earningButton);
		
		JButton statusButton = new JButton("\u7ECF\u8425\u60C5\u51B5\u8868");
		statusButton.setBounds(240, 177, 93, 23);
		panel.add(statusButton);
	}

}
