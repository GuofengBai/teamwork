package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class NewCenterFreightBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JTextField textField_4;
	private JLabel label_1;
	private JTextField textField_5;
	private JLabel label_2;
	private JTextField textField_6;
	private JLabel label_3;
	private JTextField textField_7;
	private JLabel label_4;
	private JTextField textField_8;
	private JLabel label_5;
	private JTextField textField_9;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public NewCenterFreightBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u88C5\u8F66\u65E5\u671F");
		label.setBounds(10, 10, 54, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(87, 7, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 7, 50, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 7, 50, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		lblNewLabel.setBounds(10, 38, 66, 15);
		add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(87, 35, 186, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u822A\u73ED\u53F7");
		lblNewLabel_1.setBounds(10, 66, 54, 15);
		add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(87, 63, 186, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setBounds(10, 94, 54, 15);
		add(label_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(58, 91, 66, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		label_2 = new JLabel("\u5230\u8FBE\u5730");
		label_2.setBounds(134, 94, 54, 15);
		add(label_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(181, 91, 66, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		label_3 = new JLabel("\u8D27\u67DC\u53F7");
		label_3.setBounds(10, 119, 42, 15);
		add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(58, 116, 66, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		label_4 = new JLabel("\u76D1\u88C5\u5458");
		label_4.setBounds(134, 119, 42, 15);
		add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setBounds(181, 116, 66, 21);
		add(textField_8);
		textField_8.setColumns(10);
		
		label_5 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_5.setBounds(10, 144, 54, 15);
		add(label_5);
		
		textField_9 = new JTextField();
		textField_9.setBounds(68, 141, 120, 21);
		add(textField_9);
		textField_9.setColumns(10);
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setBounds(191, 140, 56, 23);
		add(btnNewButton);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
		table.setBounds(10, 173, 246, 95);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 173, 298, 95);
		add(scrollPane);
		
		JButton button = new JButton("\u5220\u9664");
		button.setBounds(252, 140, 56, 23);
		add(button);
		
		JButton button_1 = new JButton("\u8BA1\u7B97\u8FD0\u8D39");
		button_1.setBounds(10, 278, 93, 23);
		add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C");
		lblNewLabel_2.setBounds(113, 282, 54, 15);
		add(lblNewLabel_2);
		
		JButton button_2 = new JButton("\u63D0\u4EA4");
		button_2.setBounds(113, 307, 93, 23);
		add(button_2);

	}
}
