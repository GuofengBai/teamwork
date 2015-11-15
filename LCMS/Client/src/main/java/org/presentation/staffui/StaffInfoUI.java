package org.presentation.staffui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class StaffInfoUI extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public StaffInfoUI() {
		setTitle("***\u5458\u5DE5\u7684\u5177\u4F53\u4FE1\u606F");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(30, 31, 81, 21);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setText("***");
		textField.setBounds(102, 28, 96, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		label_1.setBounds(227, 31, 81, 21);
		getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(304, 28, 96, 27);
		comboBox.addItem("��");
		comboBox.addItem("Ů");
		getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u5458\u5DE5\u7F16\u53F7");
		label_2.setBounds(30, 90, 81, 21);
		getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 87, 134, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8D26\u53F7\u540D\u79F0");
		label_3.setBounds(30, 142, 81, 21);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(174, 139, 134, 27);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u94F6\u884C\u8D26\u6237");
		label_4.setBounds(30, 195, 81, 21);
		getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(174, 192, 134, 27);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_5.setBounds(30, 248, 81, 21);
		getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(174, 248, 134, 27);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5DE5\u8D44\u7ED3\u7B97\u65B9\u5F0F");
		label_6.setBounds(30, 300, 116, 21);
		getContentPane().add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(174, 297, 134, 27);
		comboBox_1.addItem("����");
		comboBox_1.addItem("����");
		comboBox_1.addItem("�����");
		getContentPane().add(comboBox_1);
		
		JLabel label_7 = new JLabel("\u5DE5\u8D44\u7ED3\u7B97\u53C2\u6570");
		label_7.setBounds(30, 351, 81, 21);
		getContentPane().add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(174, 348, 134, 27);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_8 = new JLabel("\u804C\u52A1");
		label_8.setBounds(30, 406, 81, 21);
		getContentPane().add(label_8);
		
		
		String[] position={"���Ա","Ӫҵ��ҵ��Ա","��ת����ҵ��Ա","��ת���Ĳֿ����Ա","������Ա","�ܾ���","����Ա"};
		JComboBox comboBox_2 = new JComboBox(position);
		comboBox_2.setBounds(174, 403, 226, 27);
		getContentPane().add(comboBox_2);
		
		JButton button = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		button.setBounds(279, 463, 123, 29);
		getContentPane().add(button);
		
	}
	
	

}
