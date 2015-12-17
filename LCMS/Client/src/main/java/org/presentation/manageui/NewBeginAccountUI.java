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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u5EFA\u671F\u521D\u8D26\u5355");
		label.setBounds(172, 10, 78, 15);
		panel.add(label);
		
		JButton saveButton = new JButton("\u786E\u5B9A");
		saveButton.addActionListener(new saveButtonListener());
		saveButton.setBounds(101, 229, 93, 23);
		panel.add(saveButton);

		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.setBounds(240, 229, 93, 23);
		panel.add(cancelButton);
		cancelButton.addActionListener(new cancelButtonListener());
		
		JLabel label_1 = new JLabel("\u673A\u6784");
		label_1.setBounds(48, 43, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u4EBA\u5458");
		label_2.setBounds(231, 43, 54, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86");
		label_3.setBounds(48, 78, 54, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u5E93\u5B58");
		label_4.setBounds(231, 78, 54, 15);
		panel.add(label_4);
		
		JLabel lblNewLabel = new JLabel("\u94F6\u884C\u8D26\u6237");
		lblNewLabel.setBounds(184, 108, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u79F0");
		lblNewLabel_1.setBounds(48, 159, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("\u4F59\u989D");
		label_5.setBounds(231, 159, 54, 15);
		panel.add(label_5);
		
		organizationField = new JTextField();
		organizationField.setBounds(101, 40, 66, 21);
		panel.add(organizationField);
		organizationField.setColumns(10);
		
		carNumField = new JTextField();
		carNumField.setBounds(101, 75, 66, 21);
		panel.add(carNumField);
		carNumField.setColumns(10);
		
		presonNumField = new JTextField();
		presonNumField.setBounds(267, 40, 66, 21);
		panel.add(presonNumField);
		presonNumField.setColumns(10);
		
		storageField = new JTextField();
		storageField.setBounds(267, 75, 66, 21);
		panel.add(storageField);
		storageField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(101, 156, 66, 21);
		panel.add(nameField);
		nameField.setColumns(10);
		
		balanceField = new JTextField();
		balanceField.setBounds(267, 156, 66, 21);
		panel.add(balanceField);
		balanceField.setColumns(10);
	}
	
	class saveButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
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
//				if(superview==null){
					BeginAccountUI ui=new BeginAccountUI();
					ViewController.jumpToAnotherView(ui);
//				}else{
//					superview.initialize();
//					superview.repaint();
//					ViewController.jumpToAnotherView(superview);
//				}
			}else{
				 JOptionPane.showMessageDialog(null,"期初账单创建失败",null ,
							JOptionPane.WARNING_MESSAGE);
			}
			
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
