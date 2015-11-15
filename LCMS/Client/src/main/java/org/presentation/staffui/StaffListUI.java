package org.presentation.staffui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StaffListUI extends JPanel{
	private JTable table;
	public StaffListUI() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 87, 433, 280);
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
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
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
				"����", "Ա�����", "ְ��"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u5458\u5DE5\u5217\u8868");
		label.setBounds(42, 37, 81, 21);
		add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(352, 33, 123, 29);
		add(button);
	}
}
