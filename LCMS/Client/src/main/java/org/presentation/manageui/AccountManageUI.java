package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField accountNameField;
	private JTextField namepartField;
	private JTable searchTable;

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
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(293, 529, 93, 23);
		panel.add(backButton);
		backButton.addActionListener(new addButtonListener());
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setBounds(40, 176, 93, 23);
		panel.add(deleteButton);
		deleteButton.addActionListener(new deleteButtonListener());
		
		JLabel label_2 = new JLabel("\u65B0\u5EFA\u8D26\u6237");
		label_2.setBounds(173, 209, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8D26\u6237\u540D");
		label_3.setBounds(40, 253, 54, 15);
		panel.add(label_3);
		
		accountNameField = new JTextField();
		accountNameField.setBounds(104, 250, 123, 21);
		panel.add(accountNameField);
		accountNameField.setColumns(10);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.setBounds(263, 249, 93, 23);
		panel.add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		JLabel label_4 = new JLabel("\u5173\u952E\u5B57\u67E5\u627E");
		label_4.setBounds(161, 295, 76, 15);
		panel.add(label_4);
		
		namepartField = new JTextField();
		namepartField.setText("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		namepartField.setBounds(83, 327, 123, 21);
		panel.add(namepartField);
		namepartField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u627E");
		searchButton.setBounds(263, 326, 93, 23);
		panel.add(searchButton);
		
		searchTable = new JTable();
		searchTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u540D\u79F0", "\u4F59\u989D"
			}
		));
		searchTable.setBounds(52, 389, 304, 106);
		//panel.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(searchTable);
		scrollPane_1.setBounds(52, 389, 304, 130);
		panel.add(scrollPane_1);
	}
	
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=accountNameField.getText();
			
			
		}
		
	}
	
	class deleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String namepart=namepartField.getText();
			
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
