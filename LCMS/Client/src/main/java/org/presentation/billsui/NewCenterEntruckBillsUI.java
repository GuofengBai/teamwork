package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import org.vo.StateListVO;


public class NewCenterEntruckBillsUI extends JPanel {
	public ArrayList<StateListVO> list = new ArrayList<StateListVO>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton button;
	private JButton addState;
	private JTextField goodNum;
	private JLabel label_7;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button_2;

	/**
	 * Create the panel.
	 */
	public NewCenterEntruckBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u88C5\u8F66\u65E5\u671F");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(63, 10, 66, 21);
		textField.setColumns(10);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 10, 66, 21);
		textField_1.setColumns(10);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 10, 66, 21);
		textField_2.setColumns(10);
		add(textField_2);
		
		JLabel label_1 = new JLabel("\u6C7D\u8FD0\u7F16\u53F7");
		label_1.setBounds(10, 41, 48, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(73, 38, 198, 21);
		add(textField_3);
		
		JLabel label_2 = new JLabel("\u76EE\u7684\u8425\u4E1A\u5385");
		label_2.setBounds(10, 66, 64, 15);
		add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(83, 63, 188, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86\u4EE3\u53F7");
		label_3.setBounds(10, 91, 54, 15);
		add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(63, 88, 66, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_4 = new JLabel("\u76D1\u88C5\u5458");
		label_4.setBounds(10, 116, 54, 15);
		add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(63, 113, 66, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u62BC\u8FD0\u5458");
		lblNewLabel.setBounds(146, 91, 54, 15);
		add(lblNewLabel);
		
		textField_7 = new JTextField();
		textField_7.setBounds(203, 88, 66, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8FD0\u8D39");
		label_5.setBounds(146, 116, 31, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("\u8D39\u7528");
		label_6.setBounds(187, 116, 54, 15);
		add(label_6);
		
		button = new JButton("\u5220\u9664");
		button.setBounds(146, 178, 125, 23);
		add(button);
		
		final JComboBox goodState = new JComboBox();
		goodState.setBounds(205, 142, 66, 21);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("损坏");
		goodState.addItem("丢失");
		
		
		addState = new JButton("\u6DFB\u52A0");
		addState.setBounds(10, 178, 119, 23);
		add(addState);
		addState.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StateListVO vo = new StateListVO(goodNum.getText(),goodState.getSelectedItem().toString());
				list.add(vo);
			}
			
		});
		
		goodNum = new JTextField();
		goodNum.setColumns(10);
		goodNum.setBounds(68, 142, 120, 21);
		add(goodNum);
		
		label_7 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_7.setBounds(10, 145, 54, 15);
		add(label_7);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u6258\u8FD0\u5355\u53F7"
			}
		));
		table.setBounds(22, 189, 249, 78);

		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 211, 267, 78);
		add(scrollPane);
		
		button_2 = new JButton("\u63D0\u4EA4");
		button_2.setBounds(107, 299, 93, 23);
		add(button_2);
		
		
		
		
	}
}
