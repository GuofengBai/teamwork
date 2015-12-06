package org.presentation.organizationui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.presentation.mainui.ViewController;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HallCarUI extends JPanel {
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
	public HallCarUI() {
		setLayout(null);
		
		JLabel label = new JLabel("车辆管理");
		label.setBounds(222, 30, 72, 25);
		add(label);
		
		JLabel lblNewLabel = new JLabel("车辆编号");
		lblNewLabel.setBounds(24, 65, 72, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("发动机号");
		lblNewLabel_1.setBounds(24, 108, 72, 18);
		add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("底盘号");
		label_1.setBounds(222, 108, 72, 18);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(90, 62, 118, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 105, 118, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(275, 105, 107, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("购买时间");
		label_2.setBounds(222, 65, 72, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("服役时间");
		label_3.setBounds(392, 65, 72, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("车牌号");
		label_4.setBounds(392, 108, 72, 18);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 62, 86, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(465, 62, 86, 24);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(444, 105, 107, 24);
		add(textField_5);
		textField_5.setColumns(10);
		
		JButton back = new JButton("返回");
		back.setBounds(422, 328, 113, 27);
		add(back);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 171, 529, 144);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"车辆编号", "发动机号", "底盘号", "购买时间", "服役时间", "车牌号"
			}
		));
		scrollPane.setViewportView(table);
		
		Button button = new Button("删除");
		button.setBounds(465, 140, 87, 25);
		add(button);
		
		Button button_2 = new Button("新增");
		button_2.setBounds(372, 140, 87, 25);
		add(button_2);

	}
}
