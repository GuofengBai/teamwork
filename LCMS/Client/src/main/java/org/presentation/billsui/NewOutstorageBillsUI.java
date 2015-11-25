package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.po.ComPO;
import org.po.myDate;
import org.vo.CommodityVO;


public class NewOutstorageBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField entruckNum;
	private JTextField goodNum;
	private JTable table;
	private JButton submit;
	private JLabel lblNewLabel_1;
	private JTextField centerNum;

	/**
	 * Create the panel.
	 */
	public NewOutstorageBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(63, 10, 66, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(134, 10, 66, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(205, 10, 66, 21);
		add(newday);
		
		JLabel lblNewLabel = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		lblNewLabel.setBounds(10, 38, 60, 15);
		add(lblNewLabel);
		
		entruckNum = new JTextField();
		entruckNum.setBounds(80, 35, 191, 21);
		add(entruckNum);
		entruckNum.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u7F16\u53F7");
		label_1.setBounds(10, 64, 60, 15);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(80, 61, 191, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(10, 89, 93, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(113, 89, 93, 23);
		add(deleteGood);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u6258\u8FD0\u5355\u53F7", "\u5165\u5E93\u65E5\u671F", "\u76EE\u7684\u5730", "\u6446\u653E\u4F4D\u7F6E"
			}
		));
		table.setBounds(10, 122, 261, 110);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 145, 261, 87);
		add(scrollPane);
		
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(94, 242, 93, 23);
		add(submit);
		
		lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(10, 122, 78, 15);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(94, 119, 177, 21);
		add(centerNum);
		centerNum.setColumns(10);

	}
}
