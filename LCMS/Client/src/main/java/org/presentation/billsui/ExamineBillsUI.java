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
	private DefaultTableModel model;
	private JPanel superView;
	
	public ExamineBillsUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		init();
	}

	private void init() {
		
	}
}
