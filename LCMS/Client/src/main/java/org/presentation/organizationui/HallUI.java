package org.presentation.organizationui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Color;


public class HallUI extends JPanel {
	private JTextField hallName;
	private JTextField hallNum;
	private JTextField cityName;
	private JTable table;
	private JTextField location;

	/**
	 * Create the panel.
	 */
	public HallUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("营业厅管理");
		lblNewLabel.setBounds(224, 15, 108, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("营业厅名称");
		label.setBounds(24, 106, 108, 18);
		add(label);
		
		hallName = new JTextField();
		hallName.setBounds(129, 103, 121, 24);
		add(hallName);
		hallName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("营业厅编号");
		lblNewLabel_1.setBounds(287, 106, 108, 18);
		add(lblNewLabel_1);
		
		hallNum = new JTextField();
		hallNum.setBounds(397, 103, 150, 24);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_1 = new JLabel("所在城市");
		label_1.setBounds(24, 175, 72, 18);
		add(label_1);
		
		cityName = new JTextField();
		cityName.setBounds(129, 172, 121, 24);
		add(cityName);
		cityName.setColumns(10);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(415, 15, 114, 28);
		add(button_1);
		
		Button button_2 = new Button("新增");
		button_2.setBounds(457, 175, 87, 25);
		add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 219, 524, 171);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"营业厅名称", "营业厅编号", "所在城市"
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(18, 212, 540, 2);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("详细地址");
		lblNewLabel_2.setBounds(24, 139, 81, 21);
		add(lblNewLabel_2);
		
		location = new JTextField();
		location.setBounds(127, 137, 420, 25);
		add(location);
		location.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(18, 80, 540, 2);
		add(separator_1);
		
		JButton button = new JButton("删除");
		button.setBounds(127, 420, 123, 29);
		add(button);

	}
}
