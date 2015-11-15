package org.presentation.organizationui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HallUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public HallUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("营业厅管理");
		lblNewLabel.setBounds(222, 30, 108, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("营业厅名称");
		label.setBounds(24, 73, 108, 18);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(129, 68, 121, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("营业厅编号");
		lblNewLabel_1.setBounds(290, 73, 108, 18);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(397, 70, 150, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("所在城市");
		label_1.setBounds(24, 110, 72, 18);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 107, 121, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(422, 328, 113, 27);
		add(button_1);
		
		Button button_2 = new Button("新增");
		button_2.setBounds(367, 110, 87, 25);
		add(button_2);
		
		Button button_3 = new Button("删除");
		button_3.setBounds(460, 110, 87, 25);
		add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 146, 524, 156);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"营业厅名称", "营业厅编号", "所在城市"
			}
		));
		scrollPane.setViewportView(table);

	}

}
