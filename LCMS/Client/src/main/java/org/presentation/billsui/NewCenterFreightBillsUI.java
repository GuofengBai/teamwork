package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.po.SENDSTYPE;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CFBVO;
import org.vo.StateListVO;
import java.awt.Font;


public class NewCenterFreightBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField freightNum;
	private JLabel lblNewLabel_1;
	private JTextField craftNum;
	private JLabel label_1;
	private JTextField startPlace;
	private JLabel label_2;
	private JTextField endPlace;
	private JLabel label_3;
	private JTextField caseNum;
	private JLabel label_4;
	private JTextField personName;
	private JLabel label_5;
	private JTextField goodNum;
	private JButton addGood;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private JComboBox<String> goodState;
	private JComboBox<String> SendType;
	private JTextField price;
	private JButton back;
	private JLabel suggest;
	NewCenterFreightBillsBLService bl = BLFactory.getNewCenterFreightBillsBL();
	private JLabel label_6;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewCenterFreightBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(407, 746, 102, 45);
		add(submit);
		
		label_6 = new JLabel("新中转单");
		label_6.setFont(new Font("宋体", Font.PLAIN, 40));
		label_6.setBounds(354, 25, 160, 118);
		add(label_6);
		
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SENDSTYPE send = SENDSTYPE.NORMAL;
				if(SendType.getSelectedItem().equals("铁运")){
					send = SENDSTYPE.SLOW;
				}else if(SendType.getSelectedItem().equals("空运")){
					send = SENDSTYPE.FAST;
				}
				
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
				CFBVO bvo = new CFBVO(date, freightNum.getText(), craftNum.getText(), startPlace.getText(), endPlace.getText(), caseNum.getText(), personName.getText(),Long.parseLong(price.getText()),send,list);
				if(suggest.getText().equals("")){
					bl.addCenterFreightBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
		
		
	}
	public NewCenterFreightBillsUI(JPanel superview,CFBVO vo){
		this.superview = superview;
		panel();
		JButton submit = new JButton("更新");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SENDSTYPE send = SENDSTYPE.NORMAL;
				if(SendType.getSelectedItem().equals("铁运")){
					send = SENDSTYPE.SLOW;
				}else if(SendType.getSelectedItem().equals("空运")){
					send = SENDSTYPE.FAST;
				}
				
				//日期判断
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
				CFBVO bvo = new CFBVO(date, freightNum.getText(), craftNum.getText(), startPlace.getText(), endPlace.getText(), caseNum.getText(), personName.getText(),Long.parseLong(price.getText()),send,list);
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.addCenterFreightBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		freightNum.setText(vo.FreightNum);
		craftNum.setText(vo.tramNum);
		startPlace.setText(vo.StartPlace);
		endPlace.setText(vo.EndPlace);
		caseNum.setText(vo.caseNum);
		personName.setText(vo.Scoutername);
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
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(333, 141, 80, 21);
		add(newmonth);
		newmonth.setColumns(10);
		
		newday = new JTextField();
		newday.setBounds(456, 141, 80, 21);
		add(newday);
		newday.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(81, 309, 114, 32);
		add(lblNewLabel);
		
		freightNum = new JTextField();
		freightNum.setBounds(224, 317, 186, 21);
		add(freightNum);
		freightNum.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u822A\u73ED\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(81, 367, 132, 32);
		add(lblNewLabel_1);
		
		craftNum = new JTextField();
		craftNum.setBounds(223, 375, 127, 21);
		add(craftNum);
		craftNum.setColumns(10);
		
		label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 188, 88, 32);
		add(label_1);
		
		startPlace = new JTextField();
		startPlace.setBounds(223, 196, 122, 21);
		add(startPlace);
		startPlace.setColumns(10);
		
		label_2 = new JLabel("\u5230\u8FBE\u5730");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(388, 189, 82, 31);
		add(label_2);
		
		endPlace = new JTextField();
		endPlace.setBounds(499, 196, 122, 21);
		add(endPlace);
		endPlace.setColumns(10);
		
		label_3 = new JLabel("\u8D27\u67DC\u53F7");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(81, 245, 114, 32);
		add(label_3);
		
		caseNum = new JTextField();
		caseNum.setBounds(223, 253, 122, 21);
		add(caseNum);
		caseNum.setColumns(10);
		
		label_4 = new JLabel("\u76D1\u88C5\u5458");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(394, 425, 79, 32);
		add(label_4);
		
		personName = new JTextField();
		personName.setBounds(487, 427, 80, 34);
		add(personName);
		personName.setColumns(10);
		
		label_5 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(388, 245, 110, 32);
		add(label_5);
		
		goodNum = new JTextField();
		goodNum.setBounds(499, 253, 250, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		addGood = new JButton("\u6DFB\u52A0");
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
		
		JButton deleteGood = new JButton("\u5220\u9664");
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
		
		JButton getPrice = new JButton("\u8BA1\u7B97\u8FD0\u8D39");
		getPrice.setBounds(81, 422, 102, 45);
		add(getPrice);
		getPrice.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewCenterFreightBillsBLService bl = BLFactory.getNewCenterFreightBillsBL();
				SENDSTYPE send = SENDSTYPE.NORMAL;
				if(SendType.getSelectedItem().equals("铁运")){
					send = SENDSTYPE.SLOW;
				}else if(SendType.getSelectedItem().equals("空运")){
					send = SENDSTYPE.FAST;
				}
				long Price = bl.getPrice(send, startPlace.getText(), endPlace.getText());
				price.setText(String.valueOf(Price));
			}
			
		});
		goodState = new JComboBox<String>();
		goodState.setBounds(647, 306, 102, 45);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		SendType = new JComboBox<String>();
		SendType.setBounds(396, 364, 102, 45);
		add(SendType);
		SendType.addItem("汽运");
		SendType.addItem("铁运");
		SendType.addItem("空运");
		
		price = new JTextField();
		price.setBounds(223, 427, 80, 34);
		add(price);
		price.setColumns(10);
		
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
