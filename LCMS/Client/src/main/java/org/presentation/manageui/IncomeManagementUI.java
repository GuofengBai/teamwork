package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;


public class IncomeManagementUI {

	private JFrame frame;
	private JTextField searchDate;
	private JTextField searchHall;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeManagementUI window = new IncomeManagementUI();
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
	public IncomeManagementUI() {
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
		
		JLabel label = new JLabel("\u7ED3\u7B97\u7BA1\u7406");
		label.setBounds(184, 10, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u65E5\u671F");
		label_1.setBounds(48, 51, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8425\u4E1A\u5385");
		label_2.setBounds(230, 51, 54, 15);
		panel.add(label_2);
		
		searchDate = new JTextField();
		searchDate.setBounds(111, 48, 66, 21);
		panel.add(searchDate);
		searchDate.setColumns(10);
		
		searchHall = new JTextField();
		searchHall.setBounds(297, 48, 66, 21);
		panel.add(searchHall);
		searchHall.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u65E5\u671F", "\u91D1\u989D"
			}
		));
		table.setBounds(48, 102, 321, 101);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(48, 113, 321, 101);
		panel.add(scrollPane);
		
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.setBounds(159, 76, 93, 23);
		panel.add(searchButton);
		searchButton.addActionListener(new searchButtonListener());
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(275, 229, 93, 23);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String date=searchDate.getText();
			String hall=searchHall.getText();
			
			
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
