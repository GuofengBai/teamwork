package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class AccountManageUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManageUI window = new AccountManageUI();
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
	public AccountManageUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 562);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u6237\u7BA1\u7406");
		label.setBounds(183, 10, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u6237\u5217\u8868");
		label_1.setBounds(40, 49, 54, 15);
		panel.add(label_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u540D\u79F0", "\u4F59\u989D"
			}
		));
		table.setBounds(40, 74, 346, 92);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 75, 346, 91);
		panel.add(scrollPane);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(293, 529, 93, 23);
		panel.add(button);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setBounds(40, 176, 93, 23);
		panel.add(btnNewButton);
		
		JLabel label_2 = new JLabel("\u65B0\u5EFA\u8D26\u6237");
		label_2.setBounds(173, 209, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8D26\u6237\u540D");
		label_3.setBounds(40, 253, 54, 15);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(104, 250, 123, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.setBounds(263, 249, 93, 23);
		panel.add(button_1);
		
		JLabel label_4 = new JLabel("\u5173\u952E\u5B57\u67E5\u627E");
		label_4.setBounds(161, 295, 76, 15);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		textField_1.setBounds(83, 327, 123, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_2 = new JButton("\u67E5\u627E");
		button_2.setBounds(263, 326, 93, 23);
		panel.add(button_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u540D\u79F0", "\u4F59\u989D"
			}
		));
		table_1.setBounds(52, 389, 304, 106);
		//panel.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(52, 389, 304, 130);
		panel.add(scrollPane_1);
	}

}
