package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.po.BOXSTYPE;
import org.po.SENDSTYPE;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.SBVO;
import java.awt.SystemColor;
import java.awt.Font;


public class NewSendingBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField sendername;
	private JTextField senderphone;
	private JTextField senderlocation;
	private JTextField receivername;
	private JTextField receiverphone;
	private JTextField receiverlocation;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JLabel label_7;
	private JTextField goodsnumber;
	private JLabel label_8;
	private JTextField length;
	private JTextField width;
	private JTextField height;
	private JTextField weight;
	private JLabel presentvalue;
	private JLabel suggest;
	private JComboBox<String> sendtype;
	private JComboBox<String> boxtype;
	private JButton back;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */

	public NewSendingBillsUI(JPanel superview) {
		setBackground(SystemColor.menu);
		this.superview = superview;
		panel();
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		
		JLabel label = new JLabel("新寄件单");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewSendingBillsBLService bl2 = BLFactory.getNewSendingBillsBL();
				BOXSTYPE box = BOXSTYPE.Bag;
				SENDSTYPE send = SENDSTYPE.SLOW;
				if(boxtype.getSelectedItem().equals("纸箱")){
					box = BOXSTYPE.Paper;
				}else if(boxtype.getSelectedItem().equals("木箱")){
					box = BOXSTYPE.Box;
				}
				if(sendtype.getSelectedItem().equals("一般")){
					send = SENDSTYPE.NORMAL;
				}else if(sendtype.getSelectedItem().equals("特快")){
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
				
				//规格判断
				for(int i=0;i<length.getText().length();i++){
					if(length.getText().charAt(i)>'9'||length.getText().charAt(i)<'0'){
						suggest.setText("长度规格输入错误");
						return;
					}					
				}
				for(int i=0;i<width.getText().length();i++){
					if(width.getText().charAt(i)>'9'||width.getText().charAt(i)<'0'){
						suggest.setText("宽度规格输入错误");
						return;
					}					
				}
				for(int i=0;i<height.getText().length();i++){
					if(height.getText().charAt(i)>'9'||height.getText().charAt(i)<'0'){
						suggest.setText("高度规格输入错误");
						return;
					}					
				}
				for(int i=0;i<weight.getText().length();i++){
					if(weight.getText().charAt(i)>'9'||weight.getText().charAt(i)<'0'){
						suggest.setText("重量规格输入错误");
						return;
					}					
				}
				
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				SBVO bvo = new SBVO(sendername.getText(), receivername.getText(), senderphone.getText(), receiverphone.getText(), 
						senderlocation.getText(), receiverlocation.getText(), date, goodsnumber.getText(), box, send, 
						length.getText(), width.getText(), height.getText(), weight.getText());
				suggest.setText(bl2.cherk(bvo));
				if(suggest.getText().equals("")){
					bl2.addSendingBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
	}
	public NewSendingBillsUI(JPanel superview,SBVO vo){
		this.superview = superview;
		panel();
		JButton submit = new JButton("更新");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewSendingBillsBLService bl2 = BLFactory.getNewSendingBillsBL();
				BOXSTYPE box = BOXSTYPE.Bag;
				SENDSTYPE send = SENDSTYPE.SLOW;
				if(boxtype.getSelectedItem().equals("纸箱")){
					box = BOXSTYPE.Paper;
				}else if(boxtype.getSelectedItem().equals("木箱")){
					box = BOXSTYPE.Box;
				}
				if(sendtype.getSelectedItem().equals("一般")){
					send = SENDSTYPE.NORMAL;
				}else if(sendtype.getSelectedItem().equals("特快")){
					send = SENDSTYPE.FAST;
				}
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				SBVO bvo = new SBVO(sendername.getText(), receivername.getText(), senderphone.getText(), receiverphone.getText(), senderlocation.getText(), receiverlocation.getText(), date, goodsnumber.getText(), box, send, length.getText(), width.getText(), height.getText(), weight.getText());
				bl2.updateSendingBills(bvo);
				
			}
			
		});
		sendername.setText(vo.sendername);
		senderphone.setText(vo.senderphone);
		senderlocation.setText(vo.senderlocation);
		receivername.setText(vo.receivername);
		receiverphone.setText(vo.receiverphone);
		receiverlocation.setText(vo.receiverlocation);
		goodsnumber.setText(vo.goodsnumber);
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		sendtype.setSelectedItem(vo.send.getState());
		boxtype.setSelectedItem(vo.box.getState());
		length.setText(vo.length);
		width.setText(vo.width);
		height.setText(vo.height);
		weight.setText(vo.weight);
		
	}
	
	private void panel(){
		setLayout(null);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA\u59D3\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 157, 117, 32);
		add(label);
		
		JLabel label_1 = new JLabel("\u5BC4\u4EF6\u4EBA\u7535\u8BDD");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 216, 129, 32);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC4\u4EF6\u4EBA\u4F4F\u5740");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(81, 272, 141, 32);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u6536\u4EF6\u4EBA\u59D3\u540D");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(383, 157, 113, 32);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u6536\u4EF6\u4EBA\u7535\u8BDD");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(383, 216, 128, 32);
		add(label_4);
		
		JLabel label_5 = new JLabel("\u6536\u4EF6\u4EBA\u4F4F\u5740");
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(383, 272, 128, 32);
		add(label_5);
		
		sendername = new JTextField();
		sendername.setBounds(207, 165, 162, 21);
		add(sendername);
		sendername.setColumns(10);
		
		senderphone = new JTextField();
		senderphone.setColumns(10);
		senderphone.setBounds(207, 224, 162, 21);
		add(senderphone);
		
		senderlocation = new JTextField();
		senderlocation.setColumns(10);
		senderlocation.setBounds(207, 280, 162, 21);
		add(senderlocation);
		
		receivername = new JTextField();
		receivername.setColumns(10);
		receivername.setBounds(510, 165, 162, 21);
		add(receivername);
		
		receiverphone = new JTextField();
		receiverphone.setColumns(10);
		receiverphone.setBounds(510, 224, 162, 21);
		add(receiverphone);
		
		receiverlocation = new JTextField();
		receiverlocation.setColumns(10);
		receiverlocation.setBounds(510, 280, 162, 21);
		add(receiverlocation);
		
		JLabel label_6 = new JLabel("\u5BC4\u4EF6\u65E5\u671F");
		label_6.setFont(new Font("宋体", Font.PLAIN, 22));
		label_6.setBounds(81, 324, 89, 32);
		add(label_6);
		
		newyear = new JTextField();
		newyear.setBounds(207, 332, 80, 21);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(312, 332, 80, 21);
		add(newmonth);
		newmonth.setColumns(10);
		
		newday = new JTextField();
		newday.setBounds(416, 332, 80, 21);
		add(newday);
		newday.setColumns(10);
		
		label_7 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_7.setFont(new Font("宋体", Font.PLAIN, 22));
		label_7.setBounds(81, 391, 96, 32);
		add(label_7);
		
		goodsnumber = new JTextField();
		goodsnumber.setBounds(207, 399, 263, 21);
		add(goodsnumber);
		goodsnumber.setColumns(10);
		
		label_8 = new JLabel("\u5FEB\u9012\u5F62\u5F0F");
		label_8.setFont(new Font("宋体", Font.PLAIN, 22));
		label_8.setBounds(81, 447, 108, 32);
		add(label_8);
		
		sendtype = new JComboBox<String>();
		sendtype.setBounds(208, 444, 102, 45);
		add(sendtype);
		sendtype.addItem("经济");
		sendtype.addItem("一般");
		sendtype.addItem("特快");
		
		JLabel label_9 = new JLabel("\u5305\u88C5\u5F62\u5F0F");
		label_9.setFont(new Font("宋体", Font.PLAIN, 22));
		label_9.setBounds(345, 447, 89, 32);
		add(label_9);
		
		boxtype = new JComboBox<String>();
		boxtype.setBounds(470, 444, 102, 45);
		add(boxtype);
		boxtype.addItem("纸袋");
		boxtype.addItem("纸箱");
		boxtype.addItem("木箱");
		
		JLabel label_10 = new JLabel("货物大小（装箱）单位：厘米");
		label_10.setFont(new Font("宋体", Font.PLAIN, 22));
		label_10.setBounds(81, 511, 288, 32);
		add(label_10);
		
		JLabel label_11 = new JLabel("\u957F");
		label_11.setFont(new Font("宋体", Font.PLAIN, 22));
		label_11.setBounds(81, 556, 84, 32);
		add(label_11);
		
		length = new JTextField();
		length.setBounds(145, 564, 65, 21);
		add(length);
		length.setColumns(10);
		
		JLabel label_12 = new JLabel("\u5BBD");
		label_12.setFont(new Font("宋体", Font.PLAIN, 22));
		label_12.setBounds(244, 556, 54, 32);
		add(label_12);
		
		width = new JTextField();
		width.setBounds(312, 564, 65, 21);
		add(width);
		width.setColumns(10);
		
		JLabel label_13 = new JLabel("\u9AD8");
		label_13.setFont(new Font("宋体", Font.PLAIN, 22));
		label_13.setBounds(416, 556, 54, 32);
		add(label_13);
		
		height = new JTextField();
		height.setBounds(472, 564, 65, 21);
		add(height);
		height.setColumns(10);
		
		JLabel label_14 = new JLabel("\u8D27\u7269\u91CD\u91CF");
		label_14.setFont(new Font("宋体", Font.PLAIN, 22));
		label_14.setBounds(81, 601, 91, 31);
		add(label_14);
		
		weight = new JTextField();
		weight.setBounds(208, 608, 133, 21);
		add(weight);
		weight.setColumns(10);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setFont(new Font("宋体", Font.PLAIN, 22));
		lblKg.setBounds(380, 600, 54, 32);
		add(lblKg);
		
		presentvalue = new JLabel();
		presentvalue.setFont(new Font("宋体", Font.PLAIN, 22));
		presentvalue.setBounds(240, 666, 210, 45);
		add(presentvalue);
		
		JButton getprice = new JButton("\u8BA1\u7B97\u4EF7\u683C");
		getprice.setBounds(81, 666, 102, 45);
		add(getprice);
		
		getprice.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewSendingBillsBLService bl = BLFactory.getNewSendingBillsBL();
				BOXSTYPE box = BOXSTYPE.Bag;
				SENDSTYPE send = SENDSTYPE.SLOW;
				if(boxtype.getSelectedItem().equals("纸箱")){
					box = BOXSTYPE.Paper;
				}else if(boxtype.getSelectedItem().equals("木箱")){
					box = BOXSTYPE.Box;
				}
				if(sendtype.getSelectedItem().equals("一般")){
					send = SENDSTYPE.NORMAL;
				}else if(sendtype.getSelectedItem().equals("特快")){
					send = SENDSTYPE.FAST;
				}
				long price = bl.getPrice(senderlocation.getText(), receiverlocation.getText(),box, send, length.getText(), width.getText(), height.getText(), weight.getText());
				presentvalue.setText(String.valueOf(price+"元"));
			}
			
		});
		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(81, 746, 310, 39);
		add(suggest);
		
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
