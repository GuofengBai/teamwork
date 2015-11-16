package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class NewHallCollectionBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JButton button_2;

	/**
	 * Create the panel.
	 */
	public NewHallCollectionBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("收款日期  ");
		label.setBounds(10, 13, 60, 15);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(75, 10, 66, 21);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(8);
		textField_1.setBounds(146, 10, 54, 21);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(8);
		textField_2.setBounds(205, 10, 54, 21);
		add(textField_2);
		
		JLabel label_1 = new JLabel("收款金额");
		label_1.setBounds(10, 38, 54, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 35, 184, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("快递员姓名");
		label_2.setBounds(10, 63, 60, 15);
		add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(75, 60, 184, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("托运单号");
		label_3.setBounds(10, 88, 54, 15);
		add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(75, 85, 184, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(135, 108, 60, 23);
		add(button);
		
		JButton button_1 = new JButton("删除");
		button_1.setBounds(199, 108, 60, 23);
		add(button_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u6258\u8FD0\u5355\u53F7"
			}
		));
		table.setBounds(10, 140, 249, 88);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 140, 249, 88);
		add(scrollPane);
		
		button_2 = new JButton("提交");
		button_2.setBounds(90, 238, 93, 23);
		add(button_2);

	}

}
