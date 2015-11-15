package org.presentation.organizationui;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SetStandardfeeUI extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	public SetStandardfeeUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u6807\u51C6\u8FD0\u8D39");
		label.setBounds(29, 31, 119, 21);
		add(label);
		
		JLabel label_1 = new JLabel("\u65E7\u8FD0\u8D39");
		label_1.setBounds(29, 84, 81, 21);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(144, 81, 96, 27);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u65B0\u8FD0\u8D39");
		label_2.setBounds(29, 143, 81, 21);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 140, 96, 27);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setBounds(236, 227, 123, 29);
		add(button);
	}

}
