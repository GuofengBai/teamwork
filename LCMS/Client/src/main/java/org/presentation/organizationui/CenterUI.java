package org.presentation.organizationui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class CenterUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CenterUI() {
		setLayout(null);
		
		JLabel label = new JLabel("中转中心（城市）管理");
		label.setBounds(222, 30, 226, 25);
		add(label);
		
		JLabel label_1 = new JLabel("城市名称");
		label_1.setBounds(24, 73, 72, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("中转中心编号");
		label_2.setBounds(292, 73, 102, 18);
		add(label_2);
		
		textField = new JTextField();
		textField.setBounds(90, 70, 121, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(397, 68, 165, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("距离");
		label_3.setBounds(24, 119, 72, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("北京");
		label_4.setBounds(63, 119, 72, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("广州");
		label_5.setBounds(187, 119, 72, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("上海");
		label_6.setBounds(310, 119, 72, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("南京");
		label_7.setBounds(445, 119, 72, 18);
		add(label_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 116, 72, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(226, 116, 72, 24);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(359, 116, 72, 24);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(490, 116, 72, 24);
		add(textField_5);
		
		JButton button = new JButton("返回");
		button.setBounds(422, 328, 113, 27);
		add(button);
		
		Button button_1 = new Button("新增");
		button_1.setBounds(437, 152, 59, 25);
		add(button_1);
		
		Button button_2 = new Button("删除");
		button_2.setBounds(503, 152, 59, 25);
		add(button_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u4E2D\u5FC3\u7F16\u53F7", "\u57CE\u5E02\u540D\u79F0", "\u8DDD\u5317\u4EAC", "\u8DDD\u5E7F\u5DDE", "\u8DDD\u4E0A\u6D77", "\u8DDD\u5357\u4EAC"
			}
		));
		table.setBounds(24, 135, 539, 172);
		//dd();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 183, 539, 96);
		add(scrollPane);

	}
}
