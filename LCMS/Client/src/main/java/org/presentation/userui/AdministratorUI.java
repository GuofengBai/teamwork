package org.presentation.userui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.userblservice.UserBLService;
import org.po.ResultMessage;
import org.po.UserPO;
import org.presentation.mainui.ViewController;
import org.vo.UserVO;

import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;

public class AdministratorUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JTextField account;
	private JTextField password;
	private JTextField staffNumber;
	private JPanel superView;
	private JLabel stateBar;
	
	/**
	 * Create the panel.
	 */
	public AdministratorUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 332, 748, 422);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("账号名称");
		label.setBounds(79, 140, 81, 21);
		add(label);
		
		account = new JTextField();
		account.setBounds(175, 137, 191, 27);
		add(account);
		account.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(381, 140, 43, 21);
		add(label_1);
		
		password = new JTextField();
		password.setBounds(439, 137, 242, 27);
		add(password);
		password.setColumns(10);
		
		JLabel label_2 = new JLabel("对应员工编号");
		label_2.setBounds(79, 207, 117, 21);
		add(label_2);
		
		staffNumber = new JTextField();
		staffNumber.setBounds(213, 204, 468, 27);
		add(staffNumber);
		staffNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("管理账号");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(352, 51, 173, 57);
		add(lblNewLabel_2);
		
		stateBar = new JLabel("");
		stateBar.setBounds(79, 846, 748, 21);
		add(stateBar);
		
		initModel();
		initButton();

	}
	
	private void initModel(){
		
		Vector<String> column=new Vector<String>();
		column.add("账号名称");
		column.add("员工编号");
		
		Vector<UserVO> vData=null;
		UserBLService ubs=BLFactory.getUserBL();
		vData=ubs.getList();
		
		model=new DefaultTableModel(vData,column){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
                return false;
            }
		};
		
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	private void initButton(){
		
		JButton jump = new JButton("返回");
		jump.setBounds(802, 30, 69, 57);
		add(jump);
		jump.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				ViewController.jumpToAnotherView(superView);
				
			}
		});
		
		JButton newUser = new JButton("新增账号");
		newUser.setBounds(704, 254, 123, 46);
		add(newUser);
		newUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				UserPO newPO=new UserPO(account.getText(),password.getText(),staffNumber.getText());
				
				UserBLService ubs=BLFactory.getUserBL();
				try {
					ResultMessage re=ubs.addUser(newPO);
					if(re.success){
						model.addRow(new UserVO(newPO));
						model.fireTableRowsInserted(model.getRowCount()-1,model.getRowCount()-1);
						stateBar.setText("添加账号成功");
					}else{
						stateBar.setText(re.info[0]);
					}
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton delUser = new JButton("删除账号");
		delUser.setBounds(400, 769, 123, 57);
		add(delUser);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(15, 315, 870, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(15, 123, 870, 2);
		add(separator_1);
		
		delUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int row=table.getSelectedRow();
				String accountToDel=(String) model.getValueAt(row,0);
				
				UserBLService ubs=BLFactory.getUserBL();
				try {
					ResultMessage re=ubs.delUser(accountToDel);
					if(re.success){
						model.removeRow(row);
						model.fireTableRowsDeleted(row, row);
						stateBar.setText("删除成功");
					}else{
						stateBar.setText(re.info[0]);
					}
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
