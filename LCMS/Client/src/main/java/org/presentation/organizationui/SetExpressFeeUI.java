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

public class SetExpressFeeUI extends JPanel{
	private JTextField textField_1;
	private JComboBox comboBox;
	private JPanel superView;
	
	public SetExpressFeeUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u6807\u51C6\u8FD0\u8D39");
		label.setBounds(153, 45, 119, 21);
		add(label);
		
		JLabel label_1 = new JLabel("快递方式");
		label_1.setBounds(29, 116, 81, 21);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u8FD0\u8D39");
		label_2.setBounds(29, 190, 81, 21);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 187, 154, 27);
		add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(144, 113, 154, 27);
		comboBox.addItem("经济快递");
		comboBox.addItem("普通快递");
		comboBox.addItem("次晨特快");
		add(comboBox);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setBounds(149, 256, 123, 29);
		add(button);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				double fee=Double.parseDouble(textField_1.getText());
				
				SENDSTYPE type;
				
				if(comboBox.getSelectedItem().equals("经济快递")){
					type=SENDSTYPE.SLOW;
				}else if(comboBox.getSelectedItem().equals("普通快递")){
					type=SENDSTYPE.NORMAL;
				}else{
					type=SENDSTYPE.FAST;
				}
				
				ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
				
				manager.setExpressFee(type, fee);
			}
			
		});
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(366, 15, 69, 29);
		add(button_1);
		button_1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
	}
}
