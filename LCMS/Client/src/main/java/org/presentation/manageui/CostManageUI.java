package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;



import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.CostManagementBLService;
import org.po.ResultMessage;
import org.presentation.billsui.NewPayingBillsUI;
import org.presentation.mainui.ViewController;
import org.vo.PayingBillVO;
import java.awt.Font;


public class CostManageUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CostManageUI panel = this;
	private JFrame frame;
	private JTable table;
	
	private JButton addButton;
	private JButton delButton;
	private JButton changeButton;
	private JButton backButton;
	public JPanel superview;

	
	DefaultTableModel model;
	private Vector<PayingBillVO> tableContent;
	private JLabel statusLabel;

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
	public CostManageUI(JPanel ui) {
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
		
		JLabel label = new JLabel("\u6210\u672C\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(376, 25, 175, 47);
		panel.add(label);
		
		addButton = new JButton("\u65B0\u5EFA\u4ED8\u6B3E\u5355");
		addButton.setFont(new Font("宋体", Font.PLAIN, 15));
		addButton.setBounds(114, 506, 150, 40);
		panel.add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		delButton = new JButton("\u5220\u9664\u4ED8\u6B3E\u5355");
		delButton.setFont(new Font("宋体", Font.PLAIN, 15));
		delButton.setBounds(629, 506, 150, 40);
		panel.add(delButton);
		delButton.addActionListener(new delButtonListener());
		
		changeButton = new JButton("\u4FEE\u6539");
		changeButton.setFont(new Font("宋体", Font.PLAIN, 15));
		changeButton.setBounds(376, 506, 150, 40);
		panel.add(changeButton);
		changeButton.addActionListener(new changeButtonListener());
		
		JLabel label_1 = new JLabel("\u4ED8\u6B3E\u5355\u5217\u8868");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(395, 123, 112, 35);
		panel.add(label_1);
		
		Vector<String> column = new Vector<String>();
		column.add("日期");
		column.add("金额");
		column.add("付款人");
		column.add("付款账号");
		column.add("条目");
		column.add("备注");
		column.add("审批状态");
		column.add("id");
		
		CostManagementBLService bl=BLFactory.getCostManagementBL();
		tableContent=new Vector<PayingBillVO>();
		tableContent=bl.getAllBill();
		
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
/*		table.setModel(new DefaultTableModel(
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
*/
		table.setBounds(44, 109, 326, 126);
		JScrollPane billList = new JScrollPane(table);
		billList.setBounds(119, 168, 660, 300);
		panel.add(billList);
		
		backButton = new JButton("\u8FD4\u56DE");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(700, 600, 150, 40);
		panel.add(backButton);
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(337, 574, 297, 40);
		add(statusLabel);
		backButton.addActionListener(new backButtonListener());

	}
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			NewPayingBillsUI ui=new NewPayingBillsUI(panel);
			ViewController.jumpToAnotherView(ui);
			
		}
		
	}
	
	class changeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int index=table.getSelectedRow();
			if(index<0){
				statusLabel.setText("请选中一个付款单");
				return;
			}
			ChangePayingBillsUI ui=new ChangePayingBillsUI(tableContent.get(index).get(7),panel);
			ViewController.jumpToAnotherView(ui);
		}
		
	}
	
	class delButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int dex=table.getSelectedRow();
			CostManagementBLService cmbl=BLFactory.getCostManagementBL();
			ResultMessage message=cmbl.delBill(tableContent.get(dex).get(7));
			
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
