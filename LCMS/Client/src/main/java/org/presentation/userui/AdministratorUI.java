package org.presentation.userui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdministratorUI extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AdministratorUI() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 239, 458, 235);
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
				"账号名称", "员工姓名", "员工编号"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("删除账号");
		button.setBounds(377, 489, 123, 29);
		add(button);
		
		JLabel lblNewLabel = new JLabel("————————————————————————————");
		lblNewLabel.setBounds(15, 203, 514, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("————————————————————————————");
		lblNewLabel_1.setBounds(15, 56, 514, 21);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("账号名称");
		label.setBounds(15, 87, 81, 21);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(94, 84, 123, 27);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(251, 87, 43, 21);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 84, 130, 27);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("对应员工编号");
		label_2.setBounds(15, 131, 117, 21);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 128, 291, 27);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("新增账号");
		button_1.setBounds(377, 170, 123, 29);
		add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("管理账号");
		lblNewLabel_2.setBounds(213, 34, 81, 21);
		add(lblNewLabel_2);
		
		JButton button_2 = new JButton("返回");
		button_2.setBounds(460, 12, 69, 29);
		add(button_2);

	}
}
