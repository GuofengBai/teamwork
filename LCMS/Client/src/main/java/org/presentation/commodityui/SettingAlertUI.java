package org.presentation.commodityui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class SettingAlertUI extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SettingAlertUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("警报设置");
		lblNewLabel.setBounds(222, 30, 74, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("当前警报线");
		label.setBounds(90, 90, 119, 18);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(222, 99, 72, 18);
		add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("重设警报线");
		label_1.setBounds(90, 160, 88, 18);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(222, 157, 86, 24);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("保存");
		button.setBounds(219, 328, 113, 27);
		add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(422, 328, 113, 27);
		add(button_1);

	}
}
