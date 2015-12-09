package org.presentation.staffui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.po.GENDER;
import org.po.Payment;
import org.po.STAFFROLE;
import org.po.WorkSpace;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.StaffVO;

public class StaffInfoUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffListUI superView;
	private JTextField placeNum;
	private JTextField year;
	private JTextField month;
	private JTextField day;
	private JTextField location;
	private JTextField name;
	private JComboBox<String> gender;
	private JTextField num;
	private JTextField account;
	private JTextField bankAccount;
	private JTextField phone;
	private JComboBox<String> payWay;
	private JTextField payParameter;
	private JComboBox<?> role;
	private JButton button;
	private JButton jump;
	private JComboBox<String> place;
	private StaffVO vo;
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public StaffInfoUI(JPanel su){
		super();
		superView=(StaffListUI) su;
		vo=null;
		initPosition();
		init_1();
	}
	
	private void init_1() {
		button.setText("添加新员工");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				vo=new StaffVO();
				String srole=role.getSelectedItem().toString();
				System.out.println(srole);
				for(STAFFROLE rl:STAFFROLE.values()){
					if(rl.getName().equals(srole)){
						vo.staffRole=rl;
						System.out.println(vo.staffRole.getName());
						break;
					}
				}
				
				if(gender.getSelectedItem().toString().equals("男")){
			        vo.gender=GENDER.MALE;
		        }else{
		        	vo.gender=GENDER.FEMALE;
		        }
		        
		        vo.birthday=new myDate(Integer.parseInt(year.getText()),Integer.parseInt(month.getText()),Integer.parseInt(day.getText()));
		        
				vo.workSpace=new WorkSpace(place.getSelectedItem().toString(),placeNum.getText());
				
				vo.payment=new Payment(payWay.getSelectedItem().toString(),Double.parseDouble(payParameter.getText()));
			
				vo.name=name.getText();
				
				vo.user=account.getText();
				
				vo.bankAccount=bankAccount.getText();
				
				vo.location=location.getText();
				
				vo.phone=phone.getText();
				
				vo.num=num.getText();
				
				StaffBLService staffBL=BLFactory.getStaffBL();
				
				staffBL.newStaff(vo);
				
			}
			
		});
		
	}

	public StaffInfoUI(JPanel su,StaffVO vo){
		super();
		superView=(StaffListUI) su;
		this.vo=vo;
		initPosition();
		init_2();
	}

	private void init_2() {
		name.setText(vo.name);
		name.setEditable(false);
		
		if(vo.gender==GENDER.MALE){
			gender.setSelectedItem("男");
		}else{
			gender.setSelectedItem("女");
		}
		gender.setEnabled(false);
		
		year.setText(String.valueOf(vo.birthday.year));
		year.setEditable(false);
		month.setText(String.valueOf(vo.birthday.month));
		month.setEditable(false);
		day.setText(String.valueOf(vo.birthday.day));
		day.setEditable(false);
		
		num.setText(vo.num);
		num.setEditable(false);
		
		location.setText(vo.location);
		
		place.setSelectedItem(vo.workSpace.type);
		placeNum.setText(vo.workSpace.num);
		
		account.setText(vo.user);
		
		phone.setText(vo.phone);
		
		bankAccount.setText(vo.bankAccount);
		
		payWay.setSelectedItem(vo.payment.type);
		payParameter.setText(String.valueOf(vo.payment.parameter));
		
		role.setSelectedItem(vo.staffRole.getName());
		
		button.setText("更新员工信息");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String srole=role.getSelectedItem().toString();
				for(STAFFROLE rl:STAFFROLE.values()){
					if(rl.getName().equals(srole)){
						vo.staffRole=rl;
						break;
					}
				}
		        
				vo.workSpace=new WorkSpace(place.getSelectedItem().toString(),placeNum.getText());
				
				vo.payment=new Payment(payWay.getSelectedItem().toString(),Double.parseDouble(payParameter.getText()));
				
				vo.user=account.getText();
				
				vo.bankAccount=bankAccount.getText();
				
				vo.location=location.getText();
				
				vo.phone=phone.getText();
				
				StaffBLService staffBL=BLFactory.getStaffBL();
				
				staffBL.updateStaff(vo);
				
			}
			
		});
		
		
		
	}

	public void initPosition(){
		
		setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(30, 87, 81, 21);
		add(label);
		
		name = new JTextField();
		name.setBounds(108, 84, 96, 27);
		add(name);
		name.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		label_1.setBounds(311, 87, 81, 21);
		add(label_1);
		
		gender = new JComboBox<String>();
		gender.setBounds(368, 84, 96, 27);
		gender.addItem("男");
		gender.addItem("女");
		add(gender);
		gender.setSelectedIndex(0);
		
		JLabel label_2 = new JLabel("\u5458\u5DE5\u7F16\u53F7");
		label_2.setBounds(30, 205, 81, 21);
		add(label_2);
		
		num = new JTextField();
		num.setBounds(147, 202, 134, 27);
		add(num);
		num.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8D26\u53F7\u540D\u79F0");
		label_3.setBounds(311, 205, 81, 21);
		add(label_3);
		
		account = new JTextField();
		account.setBounds(407, 202, 134, 27);
		add(account);
		account.setColumns(10);
		
		JLabel label_4 = new JLabel("\u94F6\u884C\u8D26\u6237");
		label_4.setBounds(30, 269, 81, 21);
		add(label_4);
		
		bankAccount = new JTextField();
		bankAccount.setBounds(147, 266, 134, 27);
		add(bankAccount);
		bankAccount.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_5.setBounds(311, 269, 81, 21);
		add(label_5);
		
		phone = new JTextField();
		phone.setBounds(407, 266, 134, 27);
		add(phone);
		phone.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5DE5\u8D44\u7ED3\u7B97\u65B9\u5F0F");
		label_6.setBounds(30, 390, 116, 21);
		add(label_6);
		
		payWay = new JComboBox<String>();
		payWay.setBounds(161, 387, 81, 27);
		payWay.addItem("按月");
		payWay.addItem("按次");
		payWay.addItem("按提成");
		payWay.setSelectedIndex(0);
		add(payWay);
		
		JLabel label_7 = new JLabel("\u5DE5\u8D44\u7ED3\u7B97\u53C2\u6570");
		label_7.setBounds(276, 390, 116, 21);
		add(label_7);
		
		payParameter = new JTextField();
		payParameter.setBounds(407, 387, 134, 27);
		add(payParameter);
		payParameter.setColumns(10);
		
		JLabel label_8 = new JLabel("\u804C\u52A1");
		label_8.setBounds(30, 451, 81, 21);
		add(label_8);
		
		
		String[] position={"快递员","营业厅业务员","中转中心业务员","中转中心仓库管理员","财务人员","总经理","管理员"};
		role = new JComboBox<String>(position);
		role.setBounds(96, 448, 226, 27);
		role.setSelectedIndex(0);
		add(role);
		
		button = new JButton();
		button.setBounds(418, 557, 123, 29);
		add(button);
		
		jump = new JButton("\u8FD4\u56DE");
		jump.setBounds(456, 15, 123, 29);
		jump.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				superView.refresh();
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
		add(jump);
		
		place = new JComboBox<String>();
		place.setBounds(432, 448, 109, 27);
		place.addItem("总部");
		place.addItem("中转中心");
		place.addItem("营业厅");
		place.setSelectedIndex(0);
		add(place);
		
		JLabel label_9 = new JLabel("\u5DE5\u4F5C\u5730\u70B9");
		label_9.setBounds(348, 451, 81, 21);
		add(label_9);
		
		JLabel lblNewLabel = new JLabel("\u5730\u70B9\u7F16\u53F7");
		lblNewLabel.setBounds(30, 510, 81, 21);
		add(lblNewLabel);
		
		placeNum = new JTextField();
		placeNum.setBounds(146, 507, 96, 27);
		add(placeNum);
		placeNum.setColumns(10);
		
		JLabel label_10 = new JLabel("出生日期");
		label_10.setBounds(30, 144, 81, 21);
		add(label_10);
		
		year = new JTextField();
		year.setBounds(147, 141, 96, 27);
		add(year);
		year.setColumns(10);
		
		JLabel label_11 = new JLabel("年");
		label_11.setBounds(247, 144, 18, 21);
		add(label_11);
		
		month = new JTextField();
		month.setBounds(280, 141, 81, 27);
		add(month);
		month.setColumns(10);
		
		JLabel label_12 = new JLabel("月");
		label_12.setBounds(368, 144, 24, 21);
		add(label_12);
		
		day = new JTextField();
		day.setBounds(395, 141, 81, 27);
		add(day);
		day.setColumns(10);
		
		JLabel label_13 = new JLabel("日");
		label_13.setBounds(483, 144, 32, 21);
		add(label_13);
		
		JLabel label_14 = new JLabel("居住地址");
		label_14.setBounds(30, 328, 81, 21);
		add(label_14);
		
		location = new JTextField();
		location.setBounds(147, 325, 394, 27);
		add(location);
		location.setColumns(10);
		
	}
}
