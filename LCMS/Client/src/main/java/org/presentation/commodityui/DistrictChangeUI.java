package org.presentation.commodityui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;


public class DistrictChangeUI extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DistrictChangeUI() {
		setLayout(null);
		
		JLabel label = new JLabel("库区调整");
		label.setBounds(222, 30, 74, 25);
		add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"仓库1", "仓库2"}));
		comboBox.setBounds(62, 76, 82, 25);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 114, 454, 188);
		add(scrollPane);
		
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
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"快递单号", "区号排号位号架号"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("移至");
		label_1.setBounds(177, 79, 72, 18);
		add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"仓库1", "仓库2"}));
		comboBox_1.setBounds(245, 76, 82, 25);
		add(comboBox_1);
		
		JLabel label_2 = new JLabel("仓库已使用");
		label_2.setBounds(361, 79, 82, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("25%");
		label_3.setBounds(469, 79, 72, 18);
		add(label_3);
		
		JButton button = new JButton("返回");
		button.setBounds(422, 328, 113, 27);
		add(button);

	}
}
