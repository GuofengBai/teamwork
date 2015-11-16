package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class NewOutstorageBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JButton button_2;

	/**
	 * Create the panel.
	 */
	public NewOutstorageBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u51FA\u5E93\u65E5\u671F");
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
		
		JLabel lblNewLabel = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		lblNewLabel.setBounds(10, 38, 60, 15);
		add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 35, 191, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u7F16\u53F7");
		label_1.setBounds(10, 64, 60, 15);
		add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 61, 191, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(10, 89, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(113, 89, 93, 23);
		add(button_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u6258\u8FD0\u5355\u53F7", "\u5165\u5E93\u65E5\u671F", "\u76EE\u7684\u5730", "\u6446\u653E\u4F4D\u7F6E"
			}
		));
		table.setBounds(10, 122, 261, 110);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 122, 261, 110);
		add(scrollPane);
		
		button_2 = new JButton("\u63D0\u4EA4");
		button_2.setBounds(94, 242, 93, 23);
		add(button_2);

	}
}
