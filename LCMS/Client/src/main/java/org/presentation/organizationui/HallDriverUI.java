package org.presentation.organizationui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HallDriverUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public HallDriverUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("司机管理");
		lblNewLabel.setBounds(222, 30, 72, 18);
		add(lblNewLabel);
		
		JLabel label = new JLabel("司机编号");
		label.setBounds(24, 73, 72, 18);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(90, 70, 86, 24);
		add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(205, 73, 72, 18);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(259, 70, 103, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("出生日期");
		label_1.setBounds(24, 107, 72, 18);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 104, 86, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("身份证号");
		lblNewLabel_2.setBounds(24, 141, 72, 18);
		add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 138, 204, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("性别");
		label_2.setBounds(390, 73, 72, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("电话号码");
		label_3.setBounds(190, 107, 72, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("驾驶证期限");
		label_4.setBounds(376, 107, 86, 18);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(458, 70, 104, 24);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(259, 104, 103, 24);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(458, 104, 104, 24);
		add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(422, 328, 113, 27);
		add(btnNewButton);
		
		Button button_1 = new Button("删除");
		button_1.setBounds(475, 138, 87, 25);
		add(button_1);
		
		Button button_2 = new Button("新增");
		button_2.setBounds(382, 138, 87, 25);
		add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 178, 528, 137);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"编号", "姓名", "性别", "生日", "电话", "驾驶证期限", "身份证"
			}
		));
		scrollPane.setViewportView(table);

	}

}
