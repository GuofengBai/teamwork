package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallEntruckBillsBLService;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.HEBVO;
import org.vo.StateListVO;


public class NewHallEntruckBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField entruckNum;
	private JTextField hallNum;
	private JTextField aimNum;
	private JTextField carNum;
	private JTextField driverName;
	private JTextField goodNum;
	private JTable table;
	private JButton submit;
	DefaultTableModel model;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private JComboBox<String> goodState;
	private JButton back;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewHallEntruckBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		
		submit = new JButton("提交");
		submit.setBounds(36, 277, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				System.out.println(date.toString());
				NewHallEntruckBillsBLService bl = BLFactory.getNewHallEntruckBillsBL();
				HEBVO bvo = new HEBVO(date, entruckNum.getText(), hallNum.getText(), aimNum.getText(), carNum.getText(), driverName.getText(), list);
				bl.addHallEntruckBills(bvo);
			}
			
		});
		
		

	}
	public NewHallEntruckBillsUI(JPanel superview,HEBVO vo){
		this.superview = superview;
		panel();
		
		submit = new JButton("更新");
		submit.setBounds(95, 277, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewHallEntruckBillsBLService bl = BLFactory.getNewHallEntruckBillsBL();
				HEBVO bvo = new HEBVO(date, entruckNum.getText(), hallNum.getText(), aimNum.getText(), carNum.getText(), driverName.getText(), list);
				bl.updateHallEntruckBills(bvo);
			}
			
		});
		
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		entruckNum.setText(vo.entruckNum);
		aimNum.setText(vo.aimNum);
		carNum.setText(vo.carNum);
		hallNum.setText(vo.hallNum);
		driverName.setText(vo.driverName);
		for(StateListPO po:vo.list){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
		this.list=vo.list;
	}
	private void panel(){
		setLayout(null);
		
		JLabel label = new JLabel("装车日期");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(63, 10, 66, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(134, 10, 66, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(205, 10, 66, 21);
		add(newday);
		
		JLabel label_1 = new JLabel("汽运编号");
		label_1.setBounds(10, 41, 48, 15);
		add(label_1);
		
		entruckNum = new JTextField();
		entruckNum.setColumns(10);
		entruckNum.setBounds(73, 38, 198, 21);
		add(entruckNum);
		
		JLabel label_2 = new JLabel("营业厅编号");
		label_2.setBounds(10, 66, 60, 15);
		add(label_2);
		
		hallNum = new JTextField();
		hallNum.setBounds(83, 63, 188, 21);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_3 = new JLabel("目的地编号");
		label_3.setBounds(10, 91, 60, 15);
		add(label_3);
		
		aimNum = new JTextField();
		aimNum.setBounds(83, 88, 188, 21);
		add(aimNum);
		aimNum.setColumns(10);
		
		JLabel label_4 = new JLabel("车辆编号");
		label_4.setBounds(10, 116, 54, 15);
		add(label_4);
		
		carNum = new JTextField();
		carNum.setBounds(63, 113, 66, 21);
		add(carNum);
		carNum.setColumns(10);
		
		JLabel label_5 = new JLabel("司机姓名");
		label_5.setBounds(134, 116, 54, 15);
		add(label_5);
		
		driverName = new JTextField();
		driverName.setBounds(198, 113, 73, 21);
		add(driverName);
		driverName.setColumns(10);
		
		JLabel label_6 = new JLabel("托运单号");
		label_6.setBounds(10, 141, 54, 15);
		add(label_6);
		
		goodNum = new JTextField();
		goodNum.setBounds(63, 138, 125, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(122, 162, 66, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = goodNum.getText();
				String state = goodState.getSelectedItem().toString();
				StateListVO item = new StateListVO(num,state);
				StateListPO po = new StateListPO(num,state);
				model.addRow(item);
				goodNum.setText("");
				list.add(po);
				
			}
			
		});
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(198, 162, 73, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("货物状态");
		model = new DefaultTableModel(vo,str);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.setFillsViewportHeight(true);	
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 195, 261, 72);
		add(scrollPane);
		
		goodState = new JComboBox<String>();
		goodState.setBounds(198, 138, 73, 21);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		back = new JButton("返回");
		back.setBounds(166, 277, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
	}
}
