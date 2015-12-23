package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;



import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallDispatchBillsBLService;

import org.po.myDate;
import org.presentation.mainui.ViewController;

import org.vo.HDBVO;
import java.awt.Font;



public class NewHallDispatchBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField goodNum;
	private JTextField name;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel rname;
	private JLabel rphone;
	private JLabel rlocation;
	private JLabel label_6;
	private JTextField idNum;
	private JButton back;
	private JLabel suggest;
	private JLabel label_7;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewHallDispatchBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		
		JButton submit = new JButton("提交");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		
		label_7 = new JLabel("新派件单");
		label_7.setFont(new Font("宋体", Font.PLAIN, 40));
		label_7.setBounds(354, 25, 160, 118);
		add(label_7);
		
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsBLService bl = BLFactory.getNewHallDispatchBillsBL();
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
				HDBVO bvo = new HDBVO(date,idNum.getText(), name.getText(), goodNum.getText());
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.newHallDispatchBill(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
		
		

	}
	public NewHallDispatchBillsUI(JPanel superview,HDBVO vo){
		this.superview = superview;
		panel();
		
		JButton submit = new JButton("提交");
		submit.setBounds(85, 194, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsBLService bl = BLFactory.getNewHallDispatchBillsBL();
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				HDBVO bvo = new HDBVO(date,idNum.getText(), name.getText(), goodNum.getText());
				bl.updateHallDispatchBill(bvo);
			}
			
		});
		
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		goodNum.setText(vo.GoodsNum);
		name.setText(vo.name);
		idNum.setText(vo.idNum);
	}
	
	private void panel(){
		setLayout(null);
		
		suggest = new JLabel("");
		suggest.setBounds(81, 746, 310, 39);
		add(suggest);
		
		JLabel label = new JLabel("到达日期  ");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 188, 111, 32);
		add(label);
		
		newyear = new JTextField();
		newyear.setBounds(219, 196, 66, 21);
		newyear.setColumns(10);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setBounds(313, 196, 66, 21);
		newmonth.setColumns(8);
		add(newmonth);
		
		newday = new JTextField();
		newday.setBounds(407, 196, 66, 21);
		newday.setColumns(8);
		add(newday);
		
		JLabel label_1 = new JLabel("托运单号");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 245, 111, 32);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(248, 253, 161, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JLabel label_3 = new JLabel("快递员姓名");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(81, 483, 119, 32);
		add(label_3);
		
		name = new JTextField();
		name.setBounds(248, 491, 161, 21);
		add(name);
		name.setColumns(10);
		
		JButton search = new JButton("检索");
		search.setBounds(489, 242, 102, 45);
		add(search);
		
		label_2 = new JLabel("收件人姓名");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(81, 304, 119, 32);
		add(label_2);
		
		label_4 = new JLabel("收件人电话");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(81, 359, 119, 32);
		add(label_4);
		
		label_5 = new JLabel("收件人住址");
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(81, 418, 119, 32);
		add(label_5);
		
		rname = new JLabel("");
		rname.setFont(new Font("宋体", Font.PLAIN, 22));
		rname.setBounds(248, 304, 174, 32);
		add(rname);
		
		rphone = new JLabel("");
		rphone.setFont(new Font("宋体", Font.PLAIN, 22));
		rphone.setBounds(248, 359, 174, 32);
		add(rphone);
		
		rlocation = new JLabel("");
		rlocation.setFont(new Font("宋体", Font.PLAIN, 22));
		rlocation.setBounds(248, 418, 174, 32);
		add(rlocation);
		
		label_6 = new JLabel("派件单编号");
		label_6.setFont(new Font("宋体", Font.PLAIN, 22));
		label_6.setBounds(81, 539, 119, 32);
		add(label_6);
		
		idNum = new JTextField();
		idNum.setBounds(248, 547, 263, 21);
		add(idNum);
		idNum.setColumns(10);
		
		back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
		search.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsBLService bl = BLFactory.getNewHallDispatchBillsBL();
				String message = bl.searchTheGood(goodNum.getText());
				if(message==null){
					suggest.setText("托运单号不存在");
					rname.setText("");
					rphone.setText("");
					rlocation.setText("");	
					return;
				}
				String[] str = message.split(" ");
				rname.setText(str[0]);
				rphone.setText(str[1]);
				rlocation.setText(str[2]);	
				suggest.setText("");
			}
			
		});
	}
}
