package org.presentation.billsui;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;

//�������ݵĽ���
public class ExamineBillsUI extends JPanel{
	private JTable table;
	public ExamineBillsUI() {
		setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"����״̬","\u5355\u636E\u7C7B\u578B", "\u5355\u53F7", "\u63D0\u4EA4\u4EBA", "\u63D0\u4EA4\u65E5\u671F"
			}
		));
		table.setBounds(77, 117, 252, 185);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 86, 493, 286);
		add(scrollPane);
		
		JLabel label = new JLabel("\u5BA1\u6279\u5355\u636E");
		label.setBounds(28, 34, 81, 21);
		add(label);
		
		JButton button = new JButton("\u5BA1\u6279\u9009\u4E2D\u7684\u5355\u636E");
		button.setBounds(346, 387, 175, 29);
		add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(398, 30, 123, 29);
		add(button_1);
	}
}
