package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.BeginAccountBLService;
import org.po.BeginAccountPO;
import org.po.ResultMessage;
import org.presentation.mainui.ViewController;
import org.vo.BeginAccountVO;
import java.awt.Font;


public class BeginAccountUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BeginAccountUI panel = this;
	private JFrame frame;
	private JTable table;
	
	private JButton backButton;
	private JButton addButton;
	private JButton deleteButton;
	
	private Vector<BeginAccountVO> tableContent;
	DefaultTableModel model;
	
	public JPanel superview;


	/**
	 * Create the application.
	 */
	public BeginAccountUI() {
		initialize();
	}
	public BeginAccountUI(JPanel ui) {
		initialize();
		this.superview=ui;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		
		
		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		JLabel label = new JLabel("\u671F\u521D\u5EFA\u8D26");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(371, 10, 185, 55);
		panel.add(label);
		
		backButton = new JButton("\u8FD4\u56DE");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(740, 600, 150, 40);
		panel.add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		
		JLabel label_1 = new JLabel("\u671F\u521D\u8D26\u5355\u5217\u8868");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(386, 91, 143, 47);
		panel.add(label_1);
		
		Vector<String> column = new Vector<String>();
		column.add("机构");
		column.add("人员");
		column.add("车辆");
		column.add("库存");
		column.add("银行账户");
		column.add("余额");
		
		BeginAccountBLService ba=BLFactory.getBeginAccountBL();
		tableContent=new Vector<BeginAccountVO>();
		tableContent=ba.getBeginAccountList();
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		model=new DefaultTableModel(tableContent,column);
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
/*
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u673A\u6784", "\u4EBA\u5458", "车辆", "\u5E93\u5B58", "\u8D26\u6237\u540D\u79F0", "\u4F59\u989D"
			}
		));
*/
		table.setBounds(37, 96, 321, 123);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(115, 148, 714, 365);
		panel.add(scrollPane);
		
		addButton = new JButton("\u65B0\u5EFA");
		addButton.setFont(new Font("宋体", Font.PLAIN, 15));
		addButton.setBounds(203, 556, 150, 40);
		panel.add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 15));
		deleteButton.setBounds(572, 556, 150, 40);
		panel.add(deleteButton);
		deleteButton.addActionListener(new deleteButtonListener());
		
	}
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			NewBeginAccountUI ui=new NewBeginAccountUI(panel);
			ViewController.jumpToAnotherView(ui);
		}
		
	}
	
	class deleteButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int dex=table.getSelectedRow();
			
			String organization=(String) table.getModel().getValueAt(dex, 0);
			int people=Integer.parseInt((String) table.getModel().getValueAt(dex, 1));
			int car=Integer.parseInt((String) table.getModel().getValueAt(dex, 2));
			int storage=Integer.parseInt((String) table.getModel().getValueAt(dex, 3));
			String accountName=(String) table.getModel().getValueAt(dex, 4);
			long balance=Long.parseLong((String) table.getModel().getValueAt(dex, 5));
			BeginAccountPO account=new BeginAccountPO(organization, people, car, storage, accountName, balance);
			
			BeginAccountBLService ba=BLFactory.getBeginAccountBL();
			ResultMessage message=ba.deleteAccount(account);
			
			if(message.success){
				model.removeRow(dex);
			}else{
				
				System.out.println(message.info);
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
