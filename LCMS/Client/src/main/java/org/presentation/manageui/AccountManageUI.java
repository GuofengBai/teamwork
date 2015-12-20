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

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.AccountManagementBLService;
import org.po.ResultMessage;
import org.presentation.mainui.ViewController;
import org.vo.BankAccountVO;
import java.awt.Font;


public class AccountManageUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel=this;
	
	private JFrame frame;
	private JTable table;
	private JTextField accountNameField;
	private JTextField namepartField;
	private JTable searchTable;
	private JTextField newNameField;
	
	private JButton backButton;
	private JButton deleteButton;
	private JButton addButton;
	private JButton searchButton;
	private JButton changeButton;
	
	private JLabel statusLabel;
	private Vector<BankAccountVO> tableContent;
	DefaultTableModel model;
	private Vector<BankAccountVO> searchtableContent;
	DefaultTableModel searchmodel;
	
	private JPanel superview;
	
	
	
	/**
	 
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
	*/

	/**
	 * Create the application.
	 */
	public AccountManageUI() {
		initialize();
	}
	public AccountManageUI(JPanel ui) {
		initialize();
		this.superview=ui;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		/**
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		*/
		
//		panel = new JPanel();
		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		JLabel label = new JLabel("账户管理");
		label.setBounds(377, 10, 194, 54);
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u6237\u5217\u8868");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(189, 103, 81, 29);
		panel.add(label_1);
		
		
		AccountManagementBLService ambl=BLFactory.getAccountManagementBL();
//获取列表		
		tableContent=new Vector<BankAccountVO>();
		tableContent=ambl.getAccountList();
		
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
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		scrollPane.setBounds(53, 158, 360, 150);
		panel.add(scrollPane);
		
		backButton = new JButton("返回");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(750, 600, 120, 40);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 15));
		deleteButton.setBounds(293, 318, 120, 40);
		panel.add(deleteButton);
		deleteButton.addActionListener(new deleteButtonListener());
		
		JLabel label_2 = new JLabel("\u65B0\u5EFA\u8D26\u6237");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(156, 498, 81, 29);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8D26\u6237\u540D");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(53, 558, 58, 25);
		panel.add(label_3);
		
		accountNameField = new JTextField();
		accountNameField.setFont(new Font("宋体", Font.PLAIN, 15));
		accountNameField.setBounds(130, 553, 150, 35);
		panel.add(accountNameField);
		accountNameField.setColumns(10);
		
		addButton = new JButton("\u6DFB\u52A0");
		addButton.setFont(new Font("宋体", Font.PLAIN, 15));
		addButton.setBounds(293, 550, 120, 40);
		panel.add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		JLabel label_4 = new JLabel("\u5173\u952E\u5B57\u67E5\u627E");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(640, 103, 107, 29);
		panel.add(label_4);
		
		namepartField = new JTextField();
		namepartField.setFont(new Font("宋体", Font.PLAIN, 15));
		namepartField.setBounds(530, 162, 150, 35);
		namepartField.setText("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		panel.add(namepartField);
		namepartField.setColumns(10);
		
		searchButton = new JButton("\u67E5\u627E");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(711, 159, 120, 40);
		panel.add(searchButton);
		searchButton.addActionListener(new searchButtonListener());
		
		searchtableContent=new Vector<BankAccountVO>();
		
		searchTable = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		searchmodel=new DefaultTableModel(searchtableContent,Column);
		searchTable.setModel(searchmodel);
		searchTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		scrollPane_1.setBounds(510, 230, 360, 250);
		panel.add(scrollPane_1);
		
		JLabel label_5 = new JLabel("修改账户名");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(163, 399, 107, 40);
		panel.add(label_5);
		
		newNameField = new JTextField();
		newNameField.setFont(new Font("宋体", Font.PLAIN, 15));
		newNameField.setBounds(130, 439, 150, 35);
		panel.add(newNameField);
		newNameField.setColumns(10);
		
		JLabel label_6 = new JLabel("新账户名");
		label_6.setFont(new Font("宋体", Font.PLAIN, 15));
		label_6.setBounds(53, 444, 67, 25);
		panel.add(label_6);
		
		changeButton = new JButton("修改");
		changeButton.setFont(new Font("宋体", Font.PLAIN, 15));
		changeButton.setBounds(293, 436, 120, 40);
		panel.add(changeButton);
		changeButton.addActionListener(new changeButtonListener());
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		statusLabel.setBounds(129, 610, 284, 42);
		add(statusLabel);
		
	}
	
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=accountNameField.getText();
			
			if(name.equals("")){
				statusLabel.setText("账户名不能为空");
				return;
			}
			BankAccountVO account=new BankAccountVO(name,0);
			AccountManagementBLService ambl=BLFactory.getAccountManagementBL();
			
			ResultMessage message=ambl.addAccount(name);
			
			if(message.success){
				model.addRow(account);
				accountNameField.setText("");
				statusLabel.setText("");
			}else{
				statusLabel.setText("账户已存在");
				System.out.println(message.info);
			}
			
			
		}
		
	}
	
	class deleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int dex=table.getSelectedRow();
			if(dex<0){
				statusLabel.setText("请选中一行");
				return;
			}
			String name=(String) table.getModel().getValueAt(dex, 0);
			AccountManagementBLService ambl=BLFactory.getAccountManagementBL();
			ResultMessage message=ambl.delAccount(name);
			
			if(message.success){
				model.removeRow(dex);
			}else{
				statusLabel.setText("账户名不存在");
			}
			
		}
		
	}
	
	class changeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String newName=newNameField.getText();
			int dex=table.getSelectedRow();
			if(dex<0){
				statusLabel.setText("请选中一行");
				return;
			}
			String name=(String) table.getModel().getValueAt(dex, 0);
			AccountManagementBLService ambl=BLFactory.getAccountManagementBL();
			
			ResultMessage message=ambl.changeName(name, newName);
			
			if(message.success){
				model.setValueAt(newName, dex, 0);
			}else{
				statusLabel.setText("账户名已存在");
			}
			
		}
		
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String namepart=namepartField.getText();
			AccountManagementBLService ambl=BLFactory.getAccountManagementBL();
			
			//清空列表
			int n=searchmodel.getRowCount();
			for(int i=0;i<n;i++){
				searchmodel.removeRow(0);
			}
			
			
			Vector<BankAccountVO> result=ambl.accountSearch(namepart);			
			for(BankAccountVO row:result){
				searchmodel.addRow(row);
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
