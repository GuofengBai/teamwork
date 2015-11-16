package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;


public class NewHallDispatchBillsUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public NewHallDispatchBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("到达日期  ");
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(75, 63, 183, 33);
		add(table);
		
		JLabel label_1 = new JLabel("托运单号");
		label_1.setBounds(10, 38, 54, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 35, 93, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("快递信息");
		label_2.setBounds(10, 63, 54, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("快递员姓名");
		label_3.setBounds(10, 110, 60, 15);
		add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(85, 106, 174, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("提交");
		button.setBounds(95, 137, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("检索");
		button_1.setBounds(178, 34, 81, 23);
		add(button_1);

	}
}
