package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class BeginAccountUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeginAccountUI window = new BeginAccountUI();
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
	public BeginAccountUI() {
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
		
		JLabel label = new JLabel("\u671F\u521D\u5EFA\u8D26");
		label.setBounds(185, 10, 54, 15);
		panel.add(label);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.setBounds(306, 229, 93, 23);
		panel.add(back);
		
		JLabel label_1 = new JLabel("\u671F\u521D\u8D26\u5355\u5217\u8868");
		label_1.setBounds(37, 50, 84, 15);
		panel.add(label_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u673A\u6784", "\u4EBA\u5458", "\u4EBA\u5458", "\u5E93\u5B58", "\u8D26\u6237\u540D\u79F0", "\u4F59\u989D"
			}
		));
		table.setBounds(37, 96, 321, 123);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(37, 75, 362, 87);
		panel.add(scrollPane);
		
		JButton newBill = new JButton("\u65B0\u5EFA");
		newBill.setBounds(37, 185, 93, 23);
		panel.add(newBill);
		
		JButton delete = new JButton("\u5220\u9664");
		delete.setBounds(165, 185, 93, 23);
		panel.add(delete);
	}

}
