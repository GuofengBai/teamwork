package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;

import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import org.businesslogic.billsbl.NewCenterFreightBillsBL;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.po.BOXSTYPE;
import org.po.SENDSTYPE;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CEBVO;
import org.vo.CFBVO;
import org.vo.StateListVO;


public class NewCenterFreightBillsUI extends JPanel {
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
	private JComboBox goodState;
	private JComboBox SendType;
	private JTextField price;
	private JButton back;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewCenterFreightBillsUI(JPanel superview) {
		this.superview = superview;
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(61, 307, 93, 23);
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
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewCenterFreightBillsBLService bl = BLFactory.getNewCenterFreightBillsBL();
				CFBVO bvo = new CFBVO(date, freightNum.getText(), craftNum.getText(), startPlace.getText(), endPlace.getText(), caseNum.getText(), personName.getText(),Long.parseLong(price.getText()),send,list);
				bl.addCenterFreightBills(bvo);
			}
			
		});
		
		
	}
	public NewCenterFreightBillsUI(JPanel superview,CFBVO vo){
		this.superview = superview;
		JButton submit = new JButton("更新");
		submit.setBounds(113, 307, 93, 23);
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
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewCenterFreightBillsBLService bl = BLFactory.getNewCenterFreightBillsBL();
				CFBVO bvo = new CFBVO(date, freightNum.getText(), craftNum.getText(), startPlace.getText(), endPlace.getText(), caseNum.getText(), personName.getText(),Long.parseLong(price.getText()),send,list);
				bl.updateCenterFreightBills(bvo);
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
		
		JLabel label = new JLabel("\u88C5\u8F66\u65E5\u671F");
		label.setBounds(10, 10, 54, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setBounds(87, 7, 66, 21);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(163, 7, 50, 21);
		add(newmonth);
		newmonth.setColumns(10);
		
		newday = new JTextField();
		newday.setBounds(223, 7, 50, 21);
		add(newday);
		newday.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		lblNewLabel.setBounds(10, 38, 66, 15);
		add(lblNewLabel);
		
		freightNum = new JTextField();
		freightNum.setBounds(87, 35, 186, 21);
		add(freightNum);
		freightNum.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u822A\u73ED\u53F7");
		lblNewLabel_1.setBounds(10, 66, 54, 15);
		add(lblNewLabel_1);
		
		craftNum = new JTextField();
		craftNum.setBounds(61, 63, 127, 21);
		add(craftNum);
		craftNum.setColumns(10);
		
		label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setBounds(10, 94, 54, 15);
		add(label_1);
		
		startPlace = new JTextField();
		startPlace.setBounds(58, 91, 66, 21);
		add(startPlace);
		startPlace.setColumns(10);
		
		label_2 = new JLabel("\u5230\u8FBE\u5730");
		label_2.setBounds(134, 94, 54, 15);
		add(label_2);
		
		endPlace = new JTextField();
		endPlace.setBounds(181, 91, 66, 21);
		add(endPlace);
		endPlace.setColumns(10);
		
		label_3 = new JLabel("\u8D27\u67DC\u53F7");
		label_3.setBounds(10, 119, 42, 15);
		add(label_3);
		
		caseNum = new JTextField();
		caseNum.setBounds(58, 116, 66, 21);
		add(caseNum);
		caseNum.setColumns(10);
		
		label_4 = new JLabel("\u76D1\u88C5\u5458");
		label_4.setBounds(134, 119, 42, 15);
		add(label_4);
		
		personName = new JTextField();
		personName.setBounds(181, 116, 66, 21);
		add(personName);
		personName.setColumns(10);
		
		label_5 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_5.setBounds(10, 144, 54, 15);
		add(label_5);
		
		goodNum = new JTextField();
		goodNum.setBounds(68, 141, 120, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(10, 169, 107, 23);
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
		scrollPane.setBounds(10, 197, 298, 71);
		add(scrollPane);
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(132, 169, 100, 23);
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
		getPrice.setBounds(10, 278, 93, 23);
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
				price.setText(String.valueOf(Price+"元"));
			}
			
		});
		goodState = new JComboBox();
		goodState.setBounds(198, 141, 75, 21);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		SendType = new JComboBox();
		SendType.setBounds(198, 63, 75, 21);
		add(SendType);
		SendType.addItem("汽运");
		SendType.addItem("铁运");
		SendType.addItem("空运");
		
		price = new JTextField();
		price.setBounds(113, 279, 66, 21);
		add(price);
		price.setColumns(10);
		
		back = new JButton("返回");
		back.setBounds(198, 307, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

		
	}
}
