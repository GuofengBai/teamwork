package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CEBVO;
import org.vo.StateListVO;
import java.awt.Font;


public class NewCenterEntruckBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField entruckNum;
	private JTextField hallNum;
	private JTextField carNum;
	private JTextField examerName;
	private JTextField driverName;
	private JButton deleteState;
	private JButton addState;
	private JTextField goodNum;
	private JLabel label_7;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton submit;
	DefaultTableModel model;
	private JButton back;
	private JLabel suggest;
	NewCenterEntruckBillsBLService bl = BLFactory.getNewCenterEntruckBillsBL();
	private JLabel label_5;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewCenterEntruckBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		
		label_5 = new JLabel("新装车单");
		label_5.setFont(new Font("宋体", Font.PLAIN, 40));
		label_5.setBounds(354, 25, 160, 118);
		add(label_5);
		
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
				CEBVO bvo = new CEBVO(date, entruckNum.getText(), hallNum.getText(), carNum.getText(), driverName.getText(), examerName.getText(), list);
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.addCenterEntruckBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});		
	}
	public NewCenterEntruckBillsUI(JPanel superview,CEBVO vo){
		this.superview = superview;
		panel();
		submit = new JButton("更新");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				CEBVO bvo = new CEBVO(date, entruckNum.getText(), hallNum.getText(), carNum.getText(), driverName.getText(), examerName.getText(), list);
				bl.updateCenterEntruckBills(bvo);
			}
			
		});
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		entruckNum.setText(vo.TrafficNum);
		hallNum.setText(vo.HallNum);
		carNum.setText(vo.Vehicle);
		driverName.setText(vo.DriverName);
		examerName.setText(vo.ScouterName);
		for(StateListPO po:vo.po){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
		this.list=vo.po;
	}
	
	private void panel(){
		setLayout(null);
		
		
		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(81, 746, 340, 39);
		add(suggest);
		
		
		JLabel label = new JLabel("\u88C5\u8F66\u65E5\u671F");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 133, 102, 32);
		add(label);
		
		newyear = new JTextField();
		newyear.setBounds(214, 141, 80, 21);
		newyear.setColumns(10);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setBounds(333, 141, 80, 21);
		newmonth.setColumns(10);
		add(newmonth);
		
		newday = new JTextField();
		newday.setBounds(456, 141, 80, 21);
		newday.setColumns(10);
		add(newday);
		
		JLabel label_1 = new JLabel("\u6C7D\u8FD0\u7F16\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 367, 119, 32);
		add(label_1);
		
		entruckNum = new JTextField();
		entruckNum.setColumns(10);
		entruckNum.setBounds(214, 375, 263, 21);
		add(entruckNum);
		
		JLabel label_2 = new JLabel("\u76EE\u7684\u8425\u4E1A\u5385");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(81, 245, 119, 32);
		add(label_2);
		
		hallNum = new JTextField();
		hallNum.setBounds(214, 253, 148, 21);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86\u4EE3\u53F7");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(81, 315, 102, 21);
		add(label_3);
		
		carNum = new JTextField();
		carNum.setBounds(214, 317, 148, 21);
		add(carNum);
		carNum.setColumns(10);
		
		JLabel label_4 = new JLabel("\u76D1\u88C5\u5458");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(81, 186, 102, 32);
		add(label_4);
		
		examerName = new JTextField();
		examerName.setBounds(214, 194, 148, 21);
		add(examerName);
		examerName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u62BC\u8FD0\u5458");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(388, 186, 108, 32);
		add(lblNewLabel);
		
		driverName = new JTextField();
		driverName.setBounds(499, 194, 148, 21);
		add(driverName);
		driverName.setColumns(10);
		
		final JLabel price = new JLabel("");
		price.setFont(new Font("宋体", Font.PLAIN, 22));
		price.setBounds(214, 422, 136, 45);
		add(price);
		
		deleteState = new JButton("\u5220\u9664");
		deleteState.setBounds(647, 422, 102, 45);
		add(deleteState);
		deleteState.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		final JComboBox<String> goodState = new JComboBox<String>();
		goodState.setBounds(647, 306, 102, 45);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		
		addState = new JButton("\u6DFB\u52A0");
		addState.setBounds(647, 364, 102, 45);
		add(addState);
		addState.addActionListener(new ActionListener(){

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
		
		goodNum = new JTextField();
		goodNum.setColumns(10);
		goodNum.setBounds(499, 253, 250, 21);
		add(goodNum);
		
		label_7 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_7.setFont(new Font("宋体", Font.PLAIN, 22));
		label_7.setBounds(388, 245, 112, 32);
		add(label_7);
			
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
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(81, 496, 668, 208);
		add(scrollPane);

		
		JButton getPrice = new JButton("显示费用");
		getPrice.setBounds(81, 422, 102, 45);
		add(getPrice);
		
		back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
		getPrice.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				price.setText("600元");
			}
			
		});		
	}
}
