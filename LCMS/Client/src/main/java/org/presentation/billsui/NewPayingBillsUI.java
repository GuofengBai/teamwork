package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewPayingBillsBLService;
import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.presentation.manageui.CostManageUI;


public class NewPayingBillsUI extends JPanel {
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
	private JPanel superView;
	private JPanel temp;
	/**
	 * Create the panel.
	 */
	public NewPayingBillsUI(JPanel su) {
		super();
		this.superView=su;
		this.temp=this;
		setLayout(null);
		
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

	}
	
	class addButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
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

			
		}
		
	}
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ViewController.jumpToAnotherView(superView);
		}
		
	}
}
