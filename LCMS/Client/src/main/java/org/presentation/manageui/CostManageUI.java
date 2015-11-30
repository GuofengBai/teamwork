package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CostManageUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostManageUI window = new CostManageUI();
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
	public CostManageUI() {
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
		
		JLabel label = new JLabel("\u6210\u672C\u7BA1\u7406");
		label.setBounds(187, 10, 54, 15);
		panel.add(label);
		
		JButton newBillButton = new JButton("\u65B0\u5EFA\u4ED8\u6B3E\u5355");
		newBillButton.setBounds(23, 199, 93, 23);
		panel.add(newBillButton);
		
		JButton delete = new JButton("\u5220\u9664\u4ED8\u6B3E\u5355");
		delete.setBounds(303, 199, 93, 23);
		panel.add(delete);
		
		JButton change = new JButton("\u4FEE\u6539");
		change.setBounds(171, 199, 70, 23);
		panel.add(change);
		
		JLabel label_1 = new JLabel("\u4ED8\u6B3E\u5355\u5217\u8868");
		label_1.setBounds(23, 39, 79, 15);
		panel.add(label_1);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u65E5\u671F", "\u91D1\u989D", "\u4ED8\u6B3E\u4EBA", "\u8D26\u53F7", "\u79DF\u91D1", "\u8FD0\u8D39", "\u4EBA\u5458\u5DE5\u8D44", "\u5956\u52B1", "\u5907\u6CE8"
			}
		));
		table.setBounds(44, 109, 326, 126);
		JScrollPane billList = new JScrollPane(table);
		billList.setBounds(23, 68, 401, 121);
		panel.add(billList);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.setBounds(330, 229, 79, 23);
		panel.add(back);

	}
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class changeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class delButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
