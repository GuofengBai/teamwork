package org.presentation.manageui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.NewBeginAccountBLService;
import org.po.ResultMessage;
import org.presentation.mainui.ViewController;
import java.awt.Font;


public class NewBeginAccountUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = this;
	private JFrame frame;
	private JTextField organizationField;
	private JTextField carNumField;
	private JTextField presonNumField;
	private JTextField storageField;
	private JTextField nameField;
	private JTextField balanceField;
	private JLabel statusLabel;

	private BeginAccountUI superview;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBeginAccountUI window = new NewBeginAccountUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewBeginAccountUI() {
		initialize();
	}
	
	public NewBeginAccountUI(BeginAccountUI ui) {
		initialize();
		this.superview=ui;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel.setBounds(0, 0, 900, 700);
		panel.setLayout(null);
		setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u5EFA\u671F\u521D\u8D26\u5355");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 16, 269, 48);
		panel.add(label);
		
		JButton saveButton = new JButton("\u786E\u5B9A");
		saveButton.setFont(new Font("宋体", Font.PLAIN, 15));
		saveButton.setBounds(247, 580, 150, 40);
		saveButton.addActionListener(new saveButtonListener());
		panel.add(saveButton);

		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 15));
		cancelButton.setBounds(501, 580, 150, 40);
		panel.add(cancelButton);
		cancelButton.addActionListener(new cancelButtonListener());
		
		JLabel label_1 = new JLabel("\u673A\u6784");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(205, 176, 54, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u4EBA\u5458");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(459, 172, 78, 40);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(205, 317, 54, 32);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u5E93\u5B58");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(459, 317, 52, 32);
		panel.add(label_4);
		
		JLabel lblNewLabel = new JLabel("\u94F6\u884C\u8D26\u6237");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(394, 397, 101, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(205, 472, 66, 40);
		panel.add(lblNewLabel_1);
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		statusLabel.setBounds(305, 630, 256, 40);
		panel.add(statusLabel);
		
		JLabel label_5 = new JLabel("\u4F59\u989D");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(459, 475, 54, 35);
		panel.add(label_5);
		
		organizationField = new JTextField();
		organizationField.setFont(new Font("宋体", Font.PLAIN, 15));
		organizationField.setBounds(281, 177, 161, 35);
		panel.add(organizationField);
		organizationField.setColumns(10);
		
		carNumField = new JTextField();
		carNumField.setFont(new Font("宋体", Font.PLAIN, 15));
		carNumField.setBounds(281, 318, 116, 35);
		panel.add(carNumField);
		carNumField.setColumns(10);
		
		presonNumField = new JTextField();
		presonNumField.setFont(new Font("宋体", Font.PLAIN, 15));
		presonNumField.setBounds(523, 177, 116, 35);
		panel.add(presonNumField);
		presonNumField.setColumns(10);
		
		storageField = new JTextField();
		storageField.setFont(new Font("宋体", Font.PLAIN, 15));
		storageField.setBounds(521, 318, 116, 35);
		panel.add(storageField);
		storageField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 15));
		nameField.setBounds(281, 477, 150, 35);
		panel.add(nameField);
		nameField.setColumns(10);
		
		balanceField = new JTextField();
		balanceField.setFont(new Font("宋体", Font.PLAIN, 15));
		balanceField.setBounds(523, 477, 116, 35);
		panel.add(balanceField);
		balanceField.setColumns(10);
	}
	
	class saveButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(isValid()){
			String organization=organizationField.getText();
			int people=Integer.parseInt(presonNumField.getText());
			int car=Integer.parseInt(carNumField.getText());
			int storage=Integer.parseInt(storageField.getText());
			String accountName=nameField.getText();
			long balance=Long.parseLong(balanceField.getText());
			
			NewBeginAccountBLService nba=BLFactory.getNewBeginAccountBL();
			ResultMessage message=nba.addBeginAccount(organization, people, car, storage, accountName, balance);
			
			if(message.success){
				//页面跳转
				if(superview==null){
					BeginAccountUI ui=new BeginAccountUI();
					ViewController.jumpToAnotherView(ui);
				}else{
					BeginAccountUI ui=new BeginAccountUI(superview.superview);
					ViewController.jumpToAnotherView(ui);
				}
			}else{
				 JOptionPane.showMessageDialog(null,"期初账单创建失败",null ,
							JOptionPane.WARNING_MESSAGE);
			}
			
			}
		}
		public boolean isValid(){
			boolean valid=true;
			String organization=organizationField.getText();
			String people=presonNumField.getText();
			String car=carNumField.getText();
			String storage=storageField.getText();
			String accountName=nameField.getText();
			String balance=balanceField.getText();
			
			if(organization.equals("")||people.equals("")||car.equals("")||storage.equals("")||accountName.equals("")
					||balance.equals("")){
				valid=false;
				statusLabel.setText("有项目为空");
			}else if(isNum(people)==false||isNum(car)==false||isNum(storage)==false||isNum(balance)==false){
				valid=false;
				statusLabel.setText("人员车辆库存金额均应为数字");
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
	
	class cancelButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(superview==null){
				BeginAccountUI ui=new BeginAccountUI();
				ViewController.jumpToAnotherView(ui);
			}else{
				
				ViewController.jumpToAnotherView(superview);
			}
			
		}
		
	}
}
