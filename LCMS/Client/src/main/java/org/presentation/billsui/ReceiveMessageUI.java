package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.ReceiveMessageBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import java.awt.Font;


public class ReceiveMessageUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField goodNum;
	private JTextField receiverName;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JButton back;
	private JLabel suggest;

	/**
	 * Create the panel.
	 */
	public ReceiveMessageUI(final JPanel superview) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("快递单号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(172, 216, 150, 32);
		add(lblNewLabel);
		
		goodNum = new JTextField();
		goodNum.setBounds(336, 224, 257, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("收件人姓名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(172, 290, 130, 32);
		add(lblNewLabel_1);
		
		receiverName = new JTextField();
		receiverName.setBounds(336, 298, 257, 21);
		add(receiverName);
		receiverName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("收件日期");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(172, 388, 116, 32);
		add(lblNewLabel_2);
		
		newyear = new JTextField();
		newyear.setBounds(336, 395, 86, 24);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(452, 395, 86, 24);
		add(newmonth);
		newmonth.setColumns(10);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(568, 395, 86, 24);
		add(newday);
		
		JButton submit = new JButton("添加");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		
		back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		
		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(114, 746, 281, 32);
		add(suggest);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ReceiveMessageBLService bl = BLFactory.getReceiveMessageBL();
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
				if(!bl.addMessage(goodNum.getText(),receiverName.getText(),date)){
					suggest.setText("托运单号不存在");
				}else{
					suggest.setText("添加成功");
				}
			}
		});

	}
}
