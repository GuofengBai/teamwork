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
import java.awt.Font;


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
	private JLabel suggest;
	NewHallEntruckBillsBLService bl = BLFactory.getNewHallEntruckBillsBL();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewHallEntruckBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		
		submit = new JButton("提交");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		
		JLabel label = new JLabel("新装车单");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);
		
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//日期判断
				if(newyear.getText().equals("")||newmonth.getText().equals("")||newday.getText().equals("")){
					suggest.setText("信息未填写完整");
					return;
				}
				for(int i=0;i<newyear.getText().length();i++){
					if(newyear.getText().charAt(i)>'9'||newyear.getText().charAt(i)<'0'||i>=4){
						suggest.setText("年份输入错误");
						return;
					}		
				}
				for(int i=0;i<newmonth.getText().length();i++){
					if(newmonth.getText().charAt(i)>'9'||newmonth.getText().charAt(i)<'0'||i>=2){
						suggest.setText("月份输入错误");
						return;
					}		
				}
				for(int i=0;i<newday.getText().length();i++){
					if(newday.getText().charAt(i)>'9'||newday.getText().charAt(i)<'0'||i>=2){
						suggest.setText("日期输入错误");
						return;
					}					
				}
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				System.out.println(date.toString());
				
				HEBVO bvo = new HEBVO(date, entruckNum.getText(), hallNum.getText(), aimNum.getText(), carNum.getText(), driverName.getText(), list);
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.addHallEntruckBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
		
		

	}
	public NewHallEntruckBillsUI(JPanel superview,HEBVO vo){
		this.superview = superview;
		panel();
		
		submit = new JButton("更新");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				
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
		
		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(83, 746, 276, 45);
		add(suggest);
		
		JLabel label = new JLabel("装车日期");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(83, 185, 102, 32);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(205, 193, 80, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(319, 193, 80, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(431, 193, 80, 21);
		add(newday);
		
		JLabel label_1 = new JLabel("汽运编号");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(83, 242, 117, 32);
		add(label_1);
		
		entruckNum = new JTextField();
		entruckNum.setColumns(10);
		entruckNum.setBounds(187, 250, 198, 21);
		add(entruckNum);
		
		JLabel label_2 = new JLabel("营业厅编号");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(83, 298, 117, 32);
		add(label_2);
		
		hallNum = new JTextField();
		hallNum.setBounds(294, 306, 188, 21);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_3 = new JLabel("目的地编号");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(83, 356, 110, 32);
		add(label_3);
		
		aimNum = new JTextField();
		aimNum.setBounds(294, 364, 188, 21);
		add(aimNum);
		aimNum.setColumns(10);
		
		JLabel label_4 = new JLabel("车辆编号");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(83, 413, 88, 32);
		add(label_4);
		
		carNum = new JTextField();
		carNum.setBounds(187, 421, 66, 21);
		add(carNum);
		carNum.setColumns(10);
		
		JLabel label_5 = new JLabel("司机姓名");
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(287, 413, 88, 32);
		add(label_5);
		
		driverName = new JTextField();
		driverName.setBounds(409, 421, 73, 21);
		add(driverName);
		driverName.setColumns(10);
		
		JLabel label_6 = new JLabel("托运单号");
		label_6.setFont(new Font("宋体", Font.PLAIN, 22));
		label_6.setBounds(415, 242, 131, 32);
		add(label_6);
		
		goodNum = new JTextField();
		goodNum.setBounds(518, 250, 231, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(647, 364, 102, 45);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bl.search(goodNum.getText()).equals("")){
					String num = goodNum.getText();
					String state = goodState.getSelectedItem().toString();
					StateListVO item = new StateListVO(num,state);
					StateListPO po = new StateListPO(num,state);
					model.addRow(item);
					goodNum.setText("");
					list.add(po);
				}else{
					suggest.setText(bl.search(goodNum.getText()));
				}
				
			}
			
		});
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(647, 422, 102, 45);
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
		scrollPane.setBounds(81, 496, 668, 208);
		add(scrollPane);
		
		goodState = new JComboBox<String>();
		goodState.setBounds(647, 306, 102, 45);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
	}
}
