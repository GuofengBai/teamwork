package org.presentation.organizationui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Button;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.JComboBox;

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.HallCarBLService;
import org.businesslogicservice.organizationblservice.HallDriverBLService;
import org.po.CarPO;
import org.po.DriverPO;
import org.po.GENDER;
import org.po.ResultMessage;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CarVO;
import org.vo.DriverVO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class HallDriverUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField driverNum;
	private JTextField name;
	private JTextField birthTime;
	private JTextField ID;
	private JComboBox gender;
	private JTextField phoneNum;
	private JTable table;
	private DefaultTableModel model;
	private JLabel stateBar;
	private JPanel superView;

	/**
	 * Create the panel.
	 */
	public HallDriverUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("司机管理");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(340, 31, 184, 66);
		add(lblNewLabel);
		
		JLabel label = new JLabel("司机编号");
		label.setBounds(47, 139, 72, 18);
		add(label);
		
		driverNum = new JTextField();
		driverNum.setColumns(10);
		driverNum.setBounds(158, 136, 119, 24);
		add(driverNum);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(290, 139, 72, 18);
		add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(377, 136, 126, 24);
		add(name);
		name.setColumns(10);
		
		JLabel label_1 = new JLabel("出生日期");
		label_1.setBounds(47, 200, 72, 18);
		add(label_1);
		
		birthTime = new JTextField();
		birthTime.setBounds(158, 197, 119, 24);
		add(birthTime);
		birthTime.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("身份证号");
		lblNewLabel_2.setBounds(47, 263, 72, 18);
		add(lblNewLabel_2);
		
		ID = new JTextField();
		ID.setBounds(158, 260, 345, 24);
		add(ID);
		ID.setColumns(10);
		
		JLabel label_2 = new JLabel("性别");
		label_2.setBounds(533, 139, 72, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("电话号码");
		label_3.setBounds(290, 200, 72, 18);
		add(label_3);
		
		phoneNum = new JTextField();
		phoneNum.setBounds(377, 197, 126, 24);
		add(phoneNum);
		phoneNum.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 372, 803, 344);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		stateBar = new JLabel("");
		stateBar.setBounds(47, 834, 803, 21);
		add(stateBar);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(24, 352, 846, 2);
		add(separator);
		
		
		
		gender = new JComboBox();
		gender.setBounds(651, 135, 199, 27);
		gender.addItem("男");
		gender.addItem("女");
		add(gender);
		gender.setSelectedIndex(0);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(24, 124, 846, 2);
		add(separator_1);
		
		initModel();
		initButton();

	}

	private void initButton() {
		
		JButton addDriver = new JButton("新增");
		addDriver.setBounds(753, 296, 97, 41);
		add(addDriver);
		addDriver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				myDate bt=new myDate(birthTime.getText());
				
				GENDER g;
				if(gender.getSelectedItem().equals("男")){
					g=GENDER.MALE;
				}else{
					g=GENDER.FEMALE;
				}
				
				DriverPO po=new DriverPO(driverNum.getText(),name.getText(),bt,
						g,phoneNum.getText(),ID.getText(),CurrentStaff.getStaff().workSpace.num);
				
				HallDriverBLService hallDriver=BLFactory.getHallDriverBL();
				ResultMessage re=hallDriver.addDriver(po);
				if(re.success){
					model.addRow(new DriverVO(po));
					model.fireTableRowsInserted(model.getRowCount(),model.getRowCount());
					stateBar.setText("新增成功");
				}else{
					stateBar.setText(re.info[0]);
				}
				
			}
		});
		
		JButton delDriver = new JButton("删除");
		delDriver.setBounds(380, 750, 123, 49);
		add(delDriver);
		delDriver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HallDriverBLService hallDriver=BLFactory.getHallDriverBL();
				int row=table.getSelectedRow();
				if(row<0){
					stateBar.setText("请选中一行");
					return;
				}
				
				String DriverNum=(String) model.getValueAt(row,0);
				ResultMessage re=hallDriver.delDriver(DriverNum);
				if(re.success){
					model.removeRow(row);
					model.fireTableRowsDeleted(row,row);
					stateBar.setText("删除成功");
				}else{
					stateBar.setText(re.info[0]);
				}
				
			}
		});
		
		JButton jump = new JButton("返回");
		jump.setBounds(798, 26, 72, 49);
		add(jump);
		jump.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
				
			}
		});
	}

	private void initModel() {
		Vector<String> column=new Vector<String>();
		column.add("司机编号");
		column.add("姓名");
		column.add("出生日期");
		column.add("性別");
		column.add("电话号码");
		column.add("身份证号");
		
		HallDriverBLService hallDriverBL=BLFactory.getHallDriverBL();
		Vector<DriverVO> vData=hallDriverBL.getList();
		
		model=new DefaultTableModel(vData,column);
		
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
	}
}
