package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class NewBeginAccountUI {

	private JFrame frame;
	private JTextField organization;
	private JTextField carNum;
	private JTextField presonNum;
	private JTextField storage;
	private JTextField name;
	private JTextField balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBeginAccountUI window = new NewBeginAccountUI();
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
	public NewBeginAccountUI() {
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
		
		JLabel label = new JLabel("\u65B0\u5EFA\u671F\u521D\u8D26\u5355");
		label.setBounds(172, 10, 78, 15);
		panel.add(label);
		
		JButton save = new JButton("\u786E\u5B9A");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		save.setBounds(101, 229, 93, 23);
		panel.add(save);
		
		JButton cancel = new JButton("\u53D6\u6D88");
		cancel.setBounds(240, 229, 93, 23);
		panel.add(cancel);
		
		JLabel label_1 = new JLabel("\u673A\u6784");
		label_1.setBounds(48, 43, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u4EBA\u5458");
		label_2.setBounds(231, 43, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86");
		label_3.setBounds(48, 78, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u5E93\u5B58");
		label_4.setBounds(231, 78, 54, 15);
		panel.add(label_4);
		
		JLabel lblNewLabel = new JLabel("\u94F6\u884C\u8D26\u6237");
		lblNewLabel.setBounds(184, 108, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0");
		lblNewLabel_1.setBounds(48, 159, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("\u4F59\u989D");
		label_5.setBounds(231, 159, 54, 15);
		panel.add(label_5);
		
		organization = new JTextField();
		organization.setBounds(101, 40, 66, 21);
		panel.add(organization);
		organization.setColumns(10);
		
		carNum = new JTextField();
		carNum.setBounds(101, 75, 66, 21);
		panel.add(carNum);
		carNum.setColumns(10);
		
		presonNum = new JTextField();
		presonNum.setBounds(267, 40, 66, 21);
		panel.add(presonNum);
		presonNum.setColumns(10);
		
		storage = new JTextField();
		storage.setBounds(267, 75, 66, 21);
		panel.add(storage);
		storage.setColumns(10);
		
		name = new JTextField();
		name.setBounds(101, 156, 66, 21);
		panel.add(name);
		name.setColumns(10);
		
		balance = new JTextField();
		balance.setBounds(267, 156, 66, 21);
		panel.add(balance);
		balance.setColumns(10);
	}

}
