package org.presentation.commodityui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ExamineCommodityUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ExamineCommodityUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("库存查看");
		lblNewLabel.setBounds(222, 30, 74, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("开始日期");
		label.setBounds(90, 90, 72, 18);
		add(label);
		
		JLabel label_1 = new JLabel("结束日期");
		label_1.setBounds(90, 160, 72, 18);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(210, 87, 154, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 157, 154, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("查看");
		button.setBounds(422, 137, 113, 27);
		add(button);
		
		JLabel lblNewLabel_1 = new JLabel("入库数量");
		lblNewLabel_1.setBounds(90, 230, 72, 18);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("33");
		lblNewLabel_2.setBounds(210, 230, 72, 18);
		add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("出库数量");
		label_2.setBounds(90, 300, 72, 18);
		add(label_2);
		
		JLabel lblNewLabel_3 = new JLabel("55");
		lblNewLabel_3.setBounds(210, 300, 72, 18);
		add(lblNewLabel_3);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(422, 328, 113, 27);
		add(button_1);

	}
}
