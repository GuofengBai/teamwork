package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.IncomeManagementBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.IncomeBillVO;
import java.awt.Font;


public class IncomeManagementUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = this;
	private JFrame frame;
	private JTextField searchDate;
	private JTextField searchHall;
	private JTable table;
	private JPanel superview;
	private JLabel statusLabel;
	
	private Vector<IncomeBillVO> volist;
	DefaultTableModel model;

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
	public IncomeManagementUI(JPanel ui) {
		initialize();
		this.superview=ui;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		JLabel label = new JLabel("\u7ED3\u7B97\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(380, 19, 179, 47);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u65E5\u671F");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(140, 119, 57, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8425\u4E1A\u5385");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(463, 119, 87, 32);
		panel.add(label_2);
		
		searchDate = new JTextField();
		searchDate.setBounds(217, 120, 180, 35);
		panel.add(searchDate);
		searchDate.setColumns(10);
		
		searchHall = new JTextField();
		searchHall.setBounds(560, 120, 114, 35);
		panel.add(searchHall);
		searchHall.setColumns(10);

		
		Vector<String> column = new Vector<String>();
		column.add("日期");
		column.add("金额");
		column.add("收款快递员");
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		model=new DefaultTableModel(volist,column);
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
/**
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u65E5\u671F", "\u91D1\u989D", "\u6536\u6B3E\u5FEB\u9012\u5458"
			}
		));
*/

		table.setBounds(48, 102, 321, 101);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(140, 290, 600, 300);
		panel.add(scrollPane);
		
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(222, 175, 150, 40);
		panel.add(searchButton);
		searchButton.addActionListener(new searchButtonListener());
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(709, 600, 150, 40);
		panel.add(backButton);
		
		JButton allButton = new JButton("合计");
		allButton.setFont(new Font("宋体", Font.PLAIN, 15));
		allButton.setBounds(508, 175, 150, 40);
		panel.add(allButton);
		allButton.addActionListener(new allButtonListener());
		
		JLabel label_3 = new JLabel("收款单列表");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(386, 250, 129, 30);
		panel.add(label_3);
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		statusLabel.setBounds(149, 225, 223, 40);
		add(statusLabel);
		backButton.addActionListener(new backButtonListener());
		
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String date=searchDate.getText();
			String hall=searchHall.getText();
			myDate mydate;
			if(!isValid()){
				return;
			}
			
			if(date.equals("")){
				mydate=null;
			}else{
				mydate=new myDate(date);
			}

			IncomeManagementBLService im=BLFactory.getIncomeManagementBL();
			volist=im.incomeSearch(mydate, hall);
			
			for(IncomeBillVO row:volist){
				model.addRow(row);
			}
			
		}
		public boolean isValid(){
			boolean valid=true;
			String date=searchDate.getText();
			String hall=searchHall.getText();
			
			if(!date.equals("")&&(isNum(date)==false||date.length()!=8)){
				statusLabel.setText("日期格式错误");
				valid=false;
			}else if(!hall.equals("")&&(isNum(hall)==false||hall.length()!=7)){
				statusLabel.setText("营业厅格式错误");
				valid=false;
			}else{
				statusLabel.setText("");
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
	
	class allButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			IncomeManagementBLService im=BLFactory.getIncomeManagementBL();
			volist=im.incomeSearch(null, "");
			for(IncomeBillVO row:volist){
				model.addRow(row);
			}
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(superview==null){
				FinacialStaffView ui=new FinacialStaffView();
				ViewController.jumpToAnotherView(ui);
			}else{
				ViewController.jumpToAnotherView(superview);
			}
		}
		
	}
}
