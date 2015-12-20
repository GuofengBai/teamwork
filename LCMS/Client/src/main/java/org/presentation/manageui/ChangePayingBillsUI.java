package org.presentation.manageui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;




import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewPayingBillsBLService;
import org.businesslogicservice.manageblservice.CostManagementBLService;
import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.presentation.manageui.CostManageUI;


public class ChangePayingBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private JTextField nameField;
	private JTextField accountField;
	private JTextField itemField;
	private JTextField moneyField;
	private JButton addButton;
	private JTextField remarkField;
	private JButton backButton;
	private JLabel statusLabel;
	private String index;
	private JLabel label_6;
	private CostManageUI superview;
	/**
	 * Create the panel.
	 */
	public ChangePayingBillsUI(String index,CostManageUI us) {
		setLayout(null);
		this.index=index;
		this.superview=us;
		
this.setBounds(0, 0, 900, 700);
		
		JLabel label = new JLabel("付款日期");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(209, 121, 89, 35);
		add(label);
		
		yearField = new JTextField();
		yearField.setFont(new Font("宋体", Font.PLAIN, 15));
		yearField.setBounds(343, 123, 66, 35);
		yearField.setColumns(10);
		add(yearField);
		
		monthField = new JTextField();
		monthField.setFont(new Font("宋体", Font.PLAIN, 15));
		monthField.setBounds(418, 123, 66, 35);
		monthField.setColumns(10);
		add(monthField);
		
		dayField = new JTextField();
		dayField.setFont(new Font("宋体", Font.PLAIN, 15));
		dayField.setBounds(494, 123, 66, 35);
		dayField.setColumns(10);
		add(dayField);
		
		JLabel label_1 = new JLabel("付款人姓名");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(209, 298, 110, 33);
		add(label_1);
		
		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 15));
		nameField.setBounds(343, 299, 120, 35);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel label_2 = new JLabel("付款账号");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(209, 381, 93, 35);
		add(label_2);
		
		accountField = new JTextField();
		accountField.setFont(new Font("宋体", Font.PLAIN, 15));
		accountField.setBounds(343, 383, 264, 35);
		add(accountField);
		accountField.setColumns(10);
		
		JLabel label_3 = new JLabel("款项");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(209, 214, 54, 35);
		add(label_3);
		
		itemField = new JTextField();
		itemField.setFont(new Font("宋体", Font.PLAIN, 15));
		itemField.setBounds(343, 216, 217, 35);
		add(itemField);
		itemField.setColumns(10);
		
		JLabel label_4 = new JLabel("金额");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(209, 451, 54, 41);
		add(label_4);
		
		moneyField = new JTextField();
		moneyField.setFont(new Font("宋体", Font.PLAIN, 15));
		moneyField.setBounds(343, 456, 131, 35);
		add(moneyField);
		moneyField.setColumns(10);
		
		addButton = new JButton("确定");
		addButton.setFont(new Font("宋体", Font.PLAIN, 15));
		addButton.setBounds(302, 608, 150, 40);
		add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		JLabel label_5 = new JLabel("备注");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(209, 533, 79, 35);
		add(label_5);
		
		backButton = new JButton("取消");
		backButton.setFont(new Font("宋体", Font.PLAIN, 15));
		backButton.setBounds(573, 608, 150, 40);
		add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		remarkField = new JTextField();
		remarkField.setFont(new Font("宋体", Font.PLAIN, 15));
		remarkField.setBounds(343, 535, 397, 35);
		add(remarkField);
		remarkField.setColumns(10);
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		statusLabel.setBounds(209, 658, 472, 32);
		add(statusLabel);
		
		label_6 = new JLabel("修改付款单");
		label_6.setFont(new Font("宋体", Font.PLAIN, 40));
		label_6.setBounds(375, 10, 218, 41);
		add(label_6);

	}
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean valid=isValid();
			if(valid){
			
			int year=Integer.parseInt(yearField.getText());
			int month=Integer.parseInt(monthField.getText());
			int day=Integer.parseInt(dayField.getText());
			myDate date=new myDate(year,month,day);
			String name=nameField.getText();
			String accountName=accountField.getText();
			String item=itemField.getText();
			long money=Long.parseLong(moneyField.getText());
			String remark=remarkField.getText();
			
			String idNum=date.toString()+String.valueOf(money);
			
			PayingBills bill=new PayingBills(date,name,accountName,item,money,remark,idNum);
			
			CostManagementBLService billBL=BLFactory.getCostManagementBL();
			
			ResultMessage message=billBL.changeBill(index, bill);
			

			
			CostManageUI ui=new CostManageUI(superview.superview);
			ViewController.jumpToAnotherView(ui);
			}else{
				
			}
			
		}
		public boolean isValid(){
			boolean valid=true;
			String year=yearField.getText();
			String month=monthField.getText();
			String day=dayField.getText();
			String name=nameField.getText();
			String accountName=accountField.getText();
			String item=itemField.getText();
			String money=moneyField.getText();
			String remark=remarkField.getText();
			
			if(year.equals("")||month.equals("")||day.equals("")||name.equals("")||accountName.equals("")
					||item.equals("")||money.equals("")){
				valid=false;
				statusLabel.setText("有项目为空");
			}else if(isNum(year)==false||isNum(month)==false||isNum(day)==false||isNum(money)==false){
				valid=false;
				statusLabel.setText("日期及金额应为数字");
			}
			
			return valid;
		}
		
		public boolean isNum(String s){
			for(int i=0;i<s.length();i++){
				if(!(s.charAt(i)<='9'&&s.charAt(i)>='0')){
					return false;
				}
			}
			return true;
		}
		
	}
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			ViewController.jumpToAnotherView(superview);
		}
		
	}
}
