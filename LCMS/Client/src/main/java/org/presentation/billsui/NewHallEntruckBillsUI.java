package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class NewHallEntruckBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JButton button_2;

	/**
	 * Create the panel.
	 */
	public NewHallEntruckBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("装车日期");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(63, 10, 66, 21);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 10, 66, 21);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 10, 66, 21);
		add(textField_2);
		
		JLabel label_1 = new JLabel("汽运编号");
		label_1.setBounds(10, 41, 48, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(73, 38, 198, 21);
		add(textField_3);
		
		JLabel label_2 = new JLabel("营业厅编号");
		label_2.setBounds(10, 66, 60, 15);
		add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(83, 63, 188, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("目的地编号");
		label_3.setBounds(10, 91, 60, 15);
		add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(83, 88, 188, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_4 = new JLabel("车辆编号");
		label_4.setBounds(10, 116, 54, 15);
		add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(63, 113, 66, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_5 = new JLabel("司机姓名");
		label_5.setBounds(134, 116, 54, 15);
		add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(198, 113, 73, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_6 = new JLabel("托运单号");
		label_6.setBounds(10, 141, 54, 15);
		add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setBounds(63, 138, 208, 21);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(122, 162, 66, 23);
		add(button);
		
		JButton button_1 = new JButton("删除");
		button_1.setBounds(198, 162, 73, 23);
		add(button_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u6258\u8FD0\u5355\u53F7"
			}
		));
		table.setBounds(10, 184, 261, 72);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 195, 261, 72);
		add(scrollPane);
		
		button_2 = new JButton("提交");
		button_2.setBounds(95, 277, 93, 23);
		add(button_2);

	}

}
