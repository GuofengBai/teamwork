package org.presentation.manageui;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.StatusTableBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.IncomeBillVO;
import org.vo.PayingBillVO;
import java.awt.Font;


public class StatusTableUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = this;
	private JPanel superView;
	private JFrame frame;
	private JTextField beginDateField;
	private JTextField endDateField;
	private JTable incomeBillTable;
	private JTable PayingBillTable;
	private JLabel statusLabel;
	private JButton searchButton;
	private JButton backButton;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	DefaultTableModel incomemodel;
	DefaultTableModel paymodel;
	private Vector<IncomeBillVO> income;
	private Vector<PayingBillVO> payment;
	
	/**
	 * Create the application.
	 */
	public StatusTableUI(JPanel su) {
		this.superView=su;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		
		backButton = new JButton("\u8FD4\u56DE");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(705, 600, 150, 40);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		JLabel label = new JLabel("\u7ECF\u8425\u60C5\u51B5\u8868");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(368, 20, 212, 55);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5F00\u59CB\u65E5\u671F");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(190, 95, 94, 35);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(501, 95, 104, 35);
		panel.add(label_2);
		
		beginDateField = new JTextField();
		beginDateField.setBounds(294, 97, 100, 35);
		panel.add(beginDateField);
		beginDateField.setColumns(10);
		
		endDateField = new JTextField();
		endDateField.setBounds(615, 97, 100, 35);
		panel.add(endDateField);
		endDateField.setColumns(10);
		
		Vector<String> incolumn = new Vector<String>();
		incolumn.add("日期");
		incolumn.add("金额");
		incolumn.add("收款快递员");
		
		Vector<String> paycolumn = new Vector<String>();
		paycolumn.add("日期");
		paycolumn.add("金额");
		paycolumn.add("付款人");
		paycolumn.add("付款账号");
		paycolumn.add("条目");
		paycolumn.add("备注");
		paycolumn.add("审批状态");
		
		incomeBillTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		incomemodel=new DefaultTableModel(income,incolumn);
		incomeBillTable.setModel(incomemodel);
		incomeBillTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		incomeBillTable.setFillsViewportHeight(true);
/**
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
*/
	    incomeBillTable.setBounds(56, 96, 325, 95);
		//panel.add(table);
		
		JLabel lblNewLabel = new JLabel("\u6536\u6B3E\u5355");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(83, 219, 81, 32);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane(incomeBillTable);
		scrollPane.setBounds(83, 261, 325, 300);
		panel.add(scrollPane);
		
		JLabel label_3 = new JLabel("\u4ED8\u6B3E\u5355");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(455, 219, 79, 32);
		panel.add(label_3);
		
		PayingBillTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		paymodel=new DefaultTableModel(payment,paycolumn);
		PayingBillTable.setModel(paymodel);
		PayingBillTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PayingBillTable.setFillsViewportHeight(true);
/**
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
*/
		PayingBillTable.setBounds(57, 270, 325, 99);
		//panel.add(table_1);
		
		scrollPane_1 = new JScrollPane(PayingBillTable);
		scrollPane_1.setBounds(455, 261, 400, 300);
		panel.add(scrollPane_1);
		
		searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(352, 152, 150, 40);
		panel.add(searchButton);
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		statusLabel.setBounds(512, 157, 223, 35);
		add(statusLabel);
		searchButton.addActionListener(new searchButtonListener());
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//清空列表
			int n=incomemodel.getRowCount();
			for(int i=0;i<n;i++){
				incomemodel.removeRow(0);
			}
			n=paymodel.getRowCount();
			for(int i=0;i<n;i++){
				paymodel.removeRow(0);
			}
			
			if(isValid()){
			statusLabel.setText("");
			String beginDate=beginDateField.getText();
			String endDate=endDateField.getText();
			
			myDate date1=new myDate(beginDate);
			myDate date2=new myDate(endDate);
			
			StatusTableBLService st=BLFactory.getStatusTableBL();
			income=st.searchIncomeBill(date1, date2);
			payment=st.searchPayingBill(date1, date2);
			
			for(IncomeBillVO row:income){
				if(row!=null){
					incomemodel.addRow(row);
				}
				
			}
			for(PayingBillVO row:payment){
				if(row!=null){
					paymodel.addRow(row);
				}
				
			}
			
			}
			
		}
		public boolean isValid(){
			boolean valid=true;
			String date1=beginDateField.getText();
			String date2=endDateField.getText();
			if(date1.equals("")||date2.equals("")){
				statusLabel.setText("日期不应为空");
				valid=false;
			}else if(isNum(date1)==false||isNum(date2)==false||date1.length()!=8||date2.length()!=8){
				statusLabel.setText("日期格式错误");
				valid=false;
			}
			
			return valid;
		}
		public boolean isNum(String s){
			for(int i=0;i<s.length();i++){
				if(!(s.charAt(i)<='9'&&s.charAt(i)>='0')){
					return false;
				}
			}
			return true;
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ViewController.jumpToAnotherView(superView);
		}
		
	}
}
