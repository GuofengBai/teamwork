package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.StatusTableBLService;
import org.po.myDate;
import org.vo.IncomeBillVO;
import org.vo.PayingBillVO;


public class StatusTableUI extends JPanel{
	
	private JPanel panel = this;
	private JFrame frame;
	private JTextField beginDateField;
	private JTextField endDateField;
	private JTable incomeBillTable;
	private JTable PayingBillTable;
	
	
	DefaultTableModel incomemodel;
	DefaultTableModel paymodel;
	private Vector<IncomeBillVO> income;
	private Vector<PayingBillVO> payment;
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
		
		panel.setBounds(0, 0, 434, 412);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(331, 379, 93, 23);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		JLabel label = new JLabel("\u7ECF\u8425\u60C5\u51B5\u8868");
		label.setBounds(184, 10, 66, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5F00\u59CB\u65E5\u671F");
		label_1.setBounds(57, 50, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		label_2.setBounds(227, 50, 54, 15);
		panel.add(label_2);
		
		beginDateField = new JTextField();
		beginDateField.setBounds(121, 47, 66, 21);
		panel.add(beginDateField);
		beginDateField.setColumns(10);
		
		endDateField = new JTextField();
		endDateField.setBounds(303, 47, 66, 21);
		panel.add(endDateField);
		endDateField.setColumns(10);
		
		Vector<String> incolumn = new Vector<String>();
		incolumn.add("日期");
		incolumn.add("金额");
		incolumn.add("收款快递员");
		
		Vector<String> paycolumn = new Vector<String>();
		paycolumn.add("日期");
		paycolumn.add("金额");
		paycolumn.add("收款快递员");
		
		incomeBillTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		incomeBillTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u65E5\u671F", "\u91D1\u989D"
			}
		));
		incomeBillTable.setBounds(56, 96, 325, 95);
		//panel.add(table);
		
		JLabel lblNewLabel = new JLabel("\u6536\u6B3E\u5355");
		lblNewLabel.setBounds(57, 105, 54, 15);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(incomeBillTable);
		scrollPane.setBounds(57, 130, 325, 95);
		panel.add(scrollPane);
		
		JLabel label_3 = new JLabel("\u4ED8\u6B3E\u5355");
		label_3.setBounds(57, 235, 54, 15);
		panel.add(label_3);
		
		PayingBillTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		PayingBillTable.setModel(new DefaultTableModel(
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
		PayingBillTable.setBounds(57, 270, 325, 99);
		//panel.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane(PayingBillTable);
		scrollPane_1.setBounds(56, 270, 326, 99);
		panel.add(scrollPane_1);
		
		JButton searchButton = new JButton("搜索");
		searchButton.setBounds(168, 75, 93, 23);
		panel.add(searchButton);
		searchButton.addActionListener(new searchButtonListener());
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String beginDate=beginDateField.getText();
			String endDate=endDateField.getText();
			
			myDate date1=new myDate(beginDate);
			myDate date2=new myDate(endDate);
			
			StatusTableBLService st=BLFactory.getStatusTableBL();
			income=st.searchIncomeBill(date1, date2);
			payment=st.searchPayingBill(date1, date2);
			
			for(IncomeBillVO row:income){
				incomemodel.addRow(row);
			}
			for(PayingBillVO row:payment){
				paymodel.addRow(row);
			}
			
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
