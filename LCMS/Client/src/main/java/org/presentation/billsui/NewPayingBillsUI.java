package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class NewPayingBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JButton button_2;

	/**
	 * Create the panel.
	 */
	public NewPayingBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("付款日期");
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
		
		JLabel label_1 = new JLabel("付款人姓名");
		label_1.setBounds(10, 38, 60, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 35, 120, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("付款账号");
		label_2.setBounds(10, 63, 54, 15);
		add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 60, 208, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("款项");
		label_3.setBounds(10, 88, 37, 15);
		add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(52, 85, 219, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_4 = new JLabel("金额");
		label_4.setBounds(10, 113, 37, 15);
		add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(52, 110, 77, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(134, 109, 66, 23);
		add(button);
		
		JButton button_1 = new JButton("删除");
		button_1.setBounds(205, 109, 66, 23);
		add(button_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u6B3E\u9879", "\u91D1\u989D"
			}
		));
		table.setBounds(10, 138, 261, 90);

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 138, 261, 90);
		add(scrollPane);
		
		button_2 = new JButton("提交");
		button_2.setBounds(95, 238, 93, 23);
		add(button_2);

	}

}
