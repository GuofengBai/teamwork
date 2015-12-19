package org.presentation.organizationui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;














import java.awt.Button;

import javax.swing.JSeparator;

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.businesslogicservice.organizationblservice.HallCarBLService;
import org.po.CarPO;
import org.po.ResultMessage;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CarVO;
import org.vo.CenterVO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;



public class HallCarUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField carNum;
	private JTextField engineNum;
	private JTextField chassisNum;
	private JTextField buyTime;
	private JTextField serveTime;
	private JTextField number;
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;
	private JLabel stateBar;

	/**
	 * Create the panel.
	 */
	public HallCarUI(JPanel su) {
		super();
		this.superView=su;
		
		setLayout(null);
		
		JLabel label = new JLabel("车辆管理");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(338, 66, 204, 57);
		add(label);
		
		JLabel lblNewLabel = new JLabel("车辆编号");
		lblNewLabel.setBounds(53, 194, 72, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("发动机号");
		lblNewLabel_1.setBounds(53, 251, 72, 18);
		add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("底盘号");
		label_1.setBounds(345, 251, 72, 18);
		add(label_1);
		
		carNum = new JTextField();
		carNum.setBounds(140, 191, 190, 24);
		add(carNum);
		carNum.setColumns(10);
		
		engineNum = new JTextField();
		engineNum.setBounds(140, 248, 190, 24);
		add(engineNum);
		engineNum.setColumns(10);
		
		chassisNum = new JTextField();
		chassisNum.setBounds(416, 248, 164, 24);
		add(chassisNum);
		chassisNum.setColumns(10);
		
		JLabel label_2 = new JLabel("购买时间");
		label_2.setBounds(333, 194, 72, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("服役时间");
		label_3.setBounds(607, 194, 72, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("车牌号");
		label_4.setBounds(607, 251, 72, 18);
		add(label_4);
		
		buyTime = new JTextField();
		buyTime.setBounds(416, 191, 164, 24);
		add(buyTime);
		buyTime.setColumns(10);
		
		serveTime = new JTextField();
		serveTime.setBounds(694, 191, 145, 24);
		add(serveTime);
		serveTime.setColumns(10);
		
		number = new JTextField();
		number.setBounds(694, 248, 145, 24);
		add(number);
		number.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 390, 786, 334);
		add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		stateBar = new JLabel("");
		stateBar.setBounds(53, 840, 786, 21);
		add(stateBar);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(24, 358, 849, 2);
		add(separator);
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(24, 177, 849, 2);
		add(separator_1);
		
		JButton jump = new JButton("返回");
		jump.setBounds(801, 25, 72, 51);
		add(jump);
		
		initModel();
		initButton();

	}

	private void initButton() {
		
		JButton addCar = new JButton("添加");
		addCar.setBounds(745, 298, 94, 45);
		add(addCar);
		addCar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				myDate bt=new myDate(buyTime.getText());
				myDate st=new myDate(serveTime.getText());
				
				if(bt.compareTo(st)<0){
					stateBar.setText("购买时间应早于服役截止时间!");
					return;
				}
				
				CarPO po=new CarPO(carNum.getText(),engineNum.getText(),chassisNum.getText(),
						bt,st,number.getText(),CurrentStaff.getStaff().workSpace.num);
				
				HallCarBLService hallCar=BLFactory.getHallCarBL();
				ResultMessage re=hallCar.addCar(po);
				if(re.success){
					model.addRow(new CarVO(po));
					model.fireTableRowsInserted(model.getRowCount(),model.getRowCount());
					stateBar.setText("新增成功");
				}else{
					stateBar.setText(re.info[0]);
				}
			}
		});
		
		JButton delCar = new JButton("删除");
		delCar.setBounds(382, 739, 123, 45);
		add(delCar);
		delCar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				HallCarBLService hallCar=BLFactory.getHallCarBL();
				int row=table.getSelectedRow();
				if(row<0){
					stateBar.setText("请选中一行");
					return;
				}
				
				String CarNum=(String) model.getValueAt(row,0);
				ResultMessage re=hallCar.delCar(CarNum);
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
		jump.setBounds(801, 25, 72, 51);
		add(jump);
		jump.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
				
			}
		});
		
	}

	private void initModel() {
		Vector<String> column=new Vector<String>();
		column.add("车辆编号");
		column.add("发动机编号");
		column.add("底盘编号");
		column.add("购买时间");
		column.add("服役截止时间");
		column.add("车牌号码");
		
		HallCarBLService hallCarBL=BLFactory.getHallCarBL();
		Vector<CarVO> vData=hallCarBL.getList();
		
		model=new DefaultTableModel(vData,column);
		
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
	}
}
