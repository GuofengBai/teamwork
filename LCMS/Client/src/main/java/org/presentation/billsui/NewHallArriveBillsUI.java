package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class NewHallArriveBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public NewHallArriveBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u5230\u8FBE\u65E5\u671F  ");
		label.setBounds(10, 13, 60, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(75, 10, 66, 21);
		textField.setColumns(10);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 10, 54, 21);
		textField_1.setColumns(8);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 10, 54, 21);
		textField_2.setColumns(8);
		add(textField_2);
		
		JLabel label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setBounds(10, 38, 54, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 35, 184, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		label_2.setBounds(10, 63, 60, 15);
		add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(75, 60, 184, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8D27\u7269\u72B6\u6001");
		label_3.setBounds(10, 88, 54, 15);
		add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(75, 85, 81, 21);
		add(comboBox);
		comboBox.addItem("完整");
		comboBox.addItem("丢失");
		comboBox.addItem("损坏");
		
		JButton button = new JButton("\u66F4\u65B0");
		button.setBounds(166, 84, 93, 23);
		add(button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u6258\u8FD0\u5355\u53F7", "\u8D27\u7269\u72B6\u6001"
			}
		));
		table.setBounds(10, 113, 250, 92);		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 117, 251, 115);
		add(scrollPane);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.setBounds(92, 242, 93, 23);
		add(button_1);

	}
}
