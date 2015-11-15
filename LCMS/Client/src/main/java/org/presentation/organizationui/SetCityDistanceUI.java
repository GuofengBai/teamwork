package org.presentation.organizationui;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SetCityDistanceUI extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public SetCityDistanceUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u57CE\u5E02\u8DDD\u79BB");
		label.setBounds(33, 27, 117, 21);
		add(label);
		
		JLabel lbla = new JLabel(" \u57CE\u5E02A");
		lbla.setBounds(33, 83, 81, 21);
		add(lbla);
		
		JLabel lblb = new JLabel("\u57CE\u5E02B");
		lblb.setBounds(43, 142, 81, 21);
		add(lblb);
		
		textField = new JTextField();
		textField.setBounds(145, 80, 266, 27);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 139, 266, 27);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAb = new JLabel("A\u5230B\u7684\u65B0\u8DDD\u79BB");
		lblAb.setBounds(43, 218, 123, 21);
		add(lblAb);
		
		textField_2 = new JTextField();
		textField_2.setBounds(195, 215, 216, 27);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(288, 23, 123, 29);
		add(button);
		
		JButton button_1 = new JButton("\u8BBE\u7F6E");
		button_1.setBounds(288, 286, 123, 29);
		add(button_1);
	}
}
