package org.presentation.organizationui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SetTransFeeUI extends JPanel{
	private JTextField textField;
	public SetTransFeeUI() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(204, 147, 144, 27);
		add(comboBox);
		comboBox.addItem("�ɻ�");
		comboBox.addItem("��");
		comboBox.addItem("����");
		
		
		
		JLabel label = new JLabel("\u8FD0\u8F93\u5DE5\u5177");
		label.setBounds(47, 150, 81, 21);
		add(label);
		
		JLabel label_1 = new JLabel("\u8FD0\u8D39");
		label_1.setBounds(47, 237, 81, 21);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(204, 234, 144, 27);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BBE\u7F6E\u8F7D\u5177\u8FD0\u8F93\u8D39\u7528");
		label_2.setBounds(47, 47, 144, 21);
		add(label_2);
		
		JButton button = new JButton("\u8BBE\u7F6E");
		button.setBounds(204, 321, 123, 29);
		add(button);
	}
}
