package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


public class FinacialStaffView {

	private JFrame frame;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D22\u52A1\u7BA1\u7406");
		label.setBounds(182, 10, 54, 15);
		panel.add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(302, 229, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u7ED3\u7B97\u7BA1\u7406");
		button_1.setBounds(75, 69, 93, 23);
		panel.add(button_1);
		
		JButton btnNewButton = new JButton("\u6210\u672C\u7BA1\u7406");
		btnNewButton.setBounds(240, 69, 93, 23);
		panel.add(btnNewButton);
		
		JButton button_2 = new JButton("\u671F\u521D\u5EFA\u8D26");
		button_2.setBounds(75, 123, 93, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("\u8D26\u6237\u7BA1\u7406");
		button_3.setBounds(240, 123, 93, 23);
		panel.add(button_3);
		
		JButton btnNewButton_1 = new JButton("\u6210\u672C\u6536\u76CA\u8868");
		btnNewButton_1.setBounds(75, 177, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton button_4 = new JButton("\u7ECF\u8425\u60C5\u51B5\u8868");
		button_4.setBounds(240, 177, 93, 23);
		panel.add(button_4);
	}

}
