package org.presentation.commodityui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ExamineCommodityUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ExamineCommodityUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("库存查看");
		lblNewLabel.setBounds(249, 10, 74, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("开始日期");
		label.setBounds(90, 47, 72, 18);
		add(label);
		
		JLabel label_1 = new JLabel("结束日期");
		label_1.setBounds(90, 86, 72, 18);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(210, 45, 154, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 84, 154, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("查看");
		button.setBounds(422, 137, 113, 27);
		add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(422, 328, 113, 27);
		add(button_1);
		
		JLabel label_3 = new JLabel("航运区");
		label_3.setBounds(90, 176, 54, 15);
		add(label_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"出库数量", "入库数量", "当前数量"
			}
		));
		table.setBounds(172, 176, 196, 121);
		add(table);

	}
}
