package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class StatusTableUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusTableUI window = new StatusTableUI();
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
	public StatusTableUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 412);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(331, 379, 93, 23);
		panel.add(button);
		
		JLabel label = new JLabel("\u7ECF\u8425\u60C5\u51B5\u8868");
		label.setBounds(184, 10, 66, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5F00\u59CB\u65E5\u671F");
		label_1.setBounds(57, 50, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		label_2.setBounds(227, 50, 54, 15);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(121, 47, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(303, 47, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
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
		table.setBounds(56, 96, 325, 95);
		//panel.add(table);
		
		JLabel lblNewLabel = new JLabel("\u6536\u6B3E\u5355");
		lblNewLabel.setBounds(57, 71, 54, 15);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(57, 96, 325, 95);
		panel.add(scrollPane);
		
		JLabel label_3 = new JLabel("\u4ED8\u6B3E\u5355");
		label_3.setBounds(57, 235, 54, 15);
		panel.add(label_3);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u65E5\u671F", "\u91D1\u989D"
			}
		));
		table_1.setBounds(57, 270, 325, 99);
		//panel.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(56, 270, 326, 99);
		panel.add(scrollPane_1);
	}
}
