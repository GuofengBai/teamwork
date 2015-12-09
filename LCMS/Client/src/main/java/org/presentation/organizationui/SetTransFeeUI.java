package org.presentation.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.po.TRANSPORTATION;
import org.presentation.mainui.ViewController;

public class SetTransFeeUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox<String> comboBox;
	private JPanel superView;
	
	public SetTransFeeUI(JPanel su) {
		super();
		this.superView=su;
		
		setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(172, 161, 176, 27);
		add(comboBox);
		comboBox.addItem("汽车");
		comboBox.addItem("火车");
		comboBox.addItem("飞机");
		
		
		
		JLabel label = new JLabel("\u8FD0\u8F93\u5DE5\u5177");
		label.setBounds(47, 164, 81, 21);
		add(label);
		
		JLabel label_1 = new JLabel("\u8FD0\u8D39");
		label_1.setBounds(47, 259, 81, 21);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(172, 256, 176, 27);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BBE\u7F6E\u8F7D\u5177\u8FD0\u8F93\u8D39\u7528");
		label_2.setBounds(173, 94, 144, 21);
		add(label_2);
		
		JButton button = new JButton("\u8BBE\u7F6E");
		button.setBounds(194, 332, 123, 29);
		add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
                
				double fee=Double.parseDouble(textField.getText());
				
				TRANSPORTATION type;
				
				if(comboBox.getSelectedItem().equals("汽车")){
					type=TRANSPORTATION.CAR;
				}else if(comboBox.getSelectedItem().equals("火车")){
					type=TRANSPORTATION.TRAIN;
				}else{
					type=TRANSPORTATION.PLANE;
				}
				
				ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
				
				manager.setTransFee(type, fee);
				
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(424, 25, 69, 29);
		add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				ViewController.jumpToAnotherView(superView);
				
			}
		});
	}
}
