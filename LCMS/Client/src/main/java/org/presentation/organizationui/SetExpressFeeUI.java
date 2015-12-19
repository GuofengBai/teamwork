package org.presentation.organizationui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.po.SENDSTYPE;
import org.presentation.mainui.ViewController;
import java.awt.Font;

public class SetExpressFeeUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JPanel superView;
	private JLabel stateBar;
	
	public SetExpressFeeUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u6807\u51C6\u8FD0\u8D39");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(330, 150, 247, 81);
		add(label);
		
		JLabel label_1 = new JLabel("快递方式");
		label_1.setBounds(270, 441, 81, 21);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u8FD0\u8D39");
		label_2.setBounds(270, 549, 81, 21);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(423, 546, 154, 27);
		add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(423, 438, 154, 27);
		comboBox.addItem("经济快递");
		comboBox.addItem("普通快递");
		comboBox.addItem("次晨特快");
		comboBox.setSelectedIndex(0);
		add(comboBox);
		
		stateBar = new JLabel("");
		stateBar.setBounds(60, 780, 771, 21);
		add(stateBar);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setBounds(377, 637, 123, 63);
		add(button);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				double fee;
				try{
					fee=Double.parseDouble(textField_1.getText());
				}catch(Exception exc){
					stateBar.setText("费用输入错误");
					return;
				}
				
				SENDSTYPE type;
				
				if(comboBox.getSelectedItem().equals("经济快递")){
					type=SENDSTYPE.SLOW;
				}else if(comboBox.getSelectedItem().equals("普通快递")){
					type=SENDSTYPE.NORMAL;
				}else{
					type=SENDSTYPE.FAST;
				}
				
				ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
				
				if(manager.setExpressFee(type, fee)){
					stateBar.setText("设置成功");
				}else{
					stateBar.setText("设置失败");
				}
				
			}
			
		});
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(796, 41, 69, 53);
		add(button_1);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
	}
}
