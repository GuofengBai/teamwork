package org.presentation.manageui;
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
	
	private CostManageUI superview;
	/**
	 * Create the panel.
	 */
	public ChangePayingBillsUI(String index,CostManageUI us) {
		setLayout(null);
		this.index=index;
		this.superview=us;
		
		JLabel label = new JLabel("付款日期");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(63, 10, 66, 21);
		add(yearField);
		
		monthField = new JTextField();
		monthField.setColumns(10);
		monthField.setBounds(134, 10, 66, 21);
		add(monthField);
		
		dayField = new JTextField();
		dayField.setColumns(10);
		dayField.setBounds(205, 10, 66, 21);
		add(dayField);
		
		JLabel label_1 = new JLabel("付款人姓名");
		label_1.setBounds(10, 41, 60, 15);
		add(label_1);
		
		nameField = new JTextField();
		nameField.setBounds(80, 35, 120, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel label_2 = new JLabel("付款账号");
		label_2.setBounds(10, 76, 54, 15);
		add(label_2);
		
		accountField = new JTextField();
		accountField.setBounds(80, 73, 208, 21);
		add(accountField);
		accountField.setColumns(10);
		
		JLabel label_3 = new JLabel("款项");
		label_3.setBounds(21, 120, 37, 15);
		add(label_3);
		
		itemField = new JTextField();
		itemField.setBounds(80, 117, 219, 21);
		add(itemField);
		itemField.setColumns(10);
		
		JLabel label_4 = new JLabel("金额");
		label_4.setBounds(21, 156, 37, 15);
		add(label_4);
		
		moneyField = new JTextField();
		moneyField.setBounds(80, 153, 77, 21);
		add(moneyField);
		moneyField.setColumns(10);
		
		addButton = new JButton("提交");
		addButton.setBounds(80, 251, 93, 23);
		add(addButton);
		addButton.addActionListener(new addButtonListener());
		
		JLabel label_5 = new JLabel("备注");
		label_5.setBounds(21, 192, 37, 15);
		add(label_5);
		
		backButton = new JButton("取消");
		backButton.setBounds(223, 251, 93, 23);
		add(backButton);
		backButton.addActionListener(new backButtonListener());
		
		remarkField = new JTextField();
		remarkField.setBounds(80, 189, 219, 21);
		add(remarkField);
		remarkField.setColumns(10);
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(75, 220, 176, 15);
		add(statusLabel);

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
			
			NewPayingBillsBLService billBL=BLFactory.getNewPayingBillsBL();
			
			ResultMessage message=billBL.addPayingBills(bill);
			

			CostManageUI ui=new CostManageUI();
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
			CostManageUI ui=new CostManageUI(superview.superview);
			ViewController.jumpToAnotherView(ui);
		}
		
	}
}
