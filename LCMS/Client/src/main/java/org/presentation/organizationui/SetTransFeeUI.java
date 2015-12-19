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
import java.awt.Font;

public class SetTransFeeUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Fee;
	private JComboBox<String> comboBox;
	private JPanel superView;
	private JLabel stateBar;
	
	public SetTransFeeUI(JPanel su) {
		super();
		this.superView=su;
		
		setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(424, 379, 197, 27);
		comboBox.addItem("汽车");
		comboBox.addItem("火车");
		comboBox.addItem("飞机");
		comboBox.setSelectedIndex(0);
		add(comboBox);
		
		stateBar = new JLabel("");
		stateBar.setBounds(71, 779, 766, 21);
		add(stateBar);
		
		JLabel label = new JLabel("\u8FD0\u8F93\u5DE5\u5177");
		label.setBounds(267, 382, 81, 21);
		add(label);
		
		JLabel label_1 = new JLabel("\u8FD0\u8D39");
		label_1.setBounds(267, 506, 81, 21);
		add(label_1);
		
		Fee = new JTextField();
		Fee.setBounds(424, 503, 197, 27);
		add(Fee);
		Fee.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BBE\u7F6E\u8F7D\u5177\u8FD0\u8F93\u8D39\u7528");
		label_2.setFont(new Font("宋体", Font.PLAIN, 40));
		label_2.setBounds(274, 125, 333, 84);
		add(label_2);
		
		JButton button = new JButton("\u8BBE\u7F6E");
		button.setBounds(383, 623, 123, 78);
		add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				double fee;
				try{
					fee=Double.parseDouble(Fee.getText());
				}catch(Exception exc){
					stateBar.setText("费用输入错误");
					return;
				}
				
				TRANSPORTATION type;
				
				if(comboBox.getSelectedItem().equals("汽车")){
					type=TRANSPORTATION.CAR;
				}else if(comboBox.getSelectedItem().equals("火车")){
					type=TRANSPORTATION.TRAIN;
				}else{
					type=TRANSPORTATION.PLANE;
				}
				
				ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
				
				if(manager.setTransFee(type, fee)){
					stateBar.setText("设置成功");
				}else{
					stateBar.setText("设置失败");
				}
				
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(797, 29, 69, 54);
		add(button_1);
		
		
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				ViewController.jumpToAnotherView(superView);
				
			}
		});
	}
}
