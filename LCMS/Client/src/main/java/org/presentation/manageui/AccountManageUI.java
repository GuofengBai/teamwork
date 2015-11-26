package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.vo.BankAccountVO;


public class AccountManageUI {

	private JFrame frame;
	private JTable table;
	private JTextField accountNameField;
	private JTextField namepartField;
	private JTable searchTable;
	private JTextField newNameField;
	
	private Vector<BankAccountVO> tableContent;
	DefaultTableModel model;
	private Vector<BankAccountVO> searchtableContent;
	DefaultTableModel searchmodel;
	
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
		frame.setBounds(100, 100, 450, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 662);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u6237\u7BA1\u7406");
		label.setBounds(183, 10, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u6237\u5217\u8868");
		label_1.setBounds(40, 49, 54, 15);
		panel.add(label_1);
		
		
		tableContent=new Vector<BankAccountVO>();
		Vector<String> Column = new Vector<String>();
		Column.add("名称");
		Column.add("余额");
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		model=new DefaultTableModel(tableContent,Column);
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.setFillsViewportHeight(true);
/**		table.setModel(new DefaultTableModel(
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
 */
		table.setBounds(40, 74, 346, 92);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 75, 346, 91);
		panel.add(scrollPane);
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(293, 629, 93, 23);
		panel.add(backButton);
		backButton.addActionListener(new addButtonListener());
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setBounds(40, 176, 93, 23);
		panel.add(deleteButton);
		deleteButton.addActionListener(new deleteButtonListener());
		
		JLabel label_2 = new JLabel("\u65B0\u5EFA\u8D26\u6237");
		label_2.setBounds(171, 323, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8D26\u6237\u540D");
		label_3.setBounds(40, 365, 54, 15);
		panel.add(label_3);
		
		accountNameField = new JTextField();
		accountNameField.setBounds(114, 362, 123, 21);
		panel.add(accountNameField);
		accountNameField.setColumns(10);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.setBounds(263, 361, 93, 23);
		panel.add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		JLabel label_4 = new JLabel("\u5173\u952E\u5B57\u67E5\u627E");
		label_4.setBounds(171, 422, 76, 15);
		panel.add(label_4);
		
		namepartField = new JTextField();
		namepartField.setText("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		namepartField.setBounds(79, 447, 123, 21);
		panel.add(namepartField);
		namepartField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u627E");
		searchButton.setBounds(263, 446, 93, 23);
		panel.add(searchButton);
		
		searchtableContent=new Vector<BankAccountVO>();
		
		searchTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		searchmodel=new DefaultTableModel(searchtableContent,Column);
		searchTable.setModel(searchmodel);
		searchTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		searchTable.setFillsViewportHeight(true);
/**	searchTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u540D\u79F0", "\u4F59\u989D"
			}
		));
*/
		searchTable.setBounds(52, 389, 304, 106);
		//panel.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(searchTable);
		scrollPane_1.setBounds(52, 489, 304, 130);
		panel.add(scrollPane_1);
		
		JLabel label_5 = new JLabel("修改账户名");
		label_5.setBounds(171, 208, 66, 15);
		panel.add(label_5);
		
		newNameField = new JTextField();
		newNameField.setBounds(114, 250, 123, 21);
		panel.add(newNameField);
		newNameField.setColumns(10);
		
		JLabel label_6 = new JLabel("新账户名");
		label_6.setBounds(40, 253, 54, 15);
		panel.add(label_6);
		
		JButton changeButton = new JButton("修改");
		changeButton.setBounds(263, 249, 93, 23);
		panel.add(changeButton);
		changeButton.addActionListener(new changeButtonListener());
	}
	
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=accountNameField.getText();
			BankAccountVO account=new BankAccountVO(name,0);
			model.addRow(account);
			accountNameField.setText("");
			
		}
		
	}
	
	class deleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int dex=table.getSelectedRow();
			model.removeRow(dex);
		}
		
	}
	
	class changeButtonListener implements ActionListener{

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
