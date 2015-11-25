package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Label;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;

import org.businesslogic.billsbl.NewCenterArriveBillsBL;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.po.myDate;
import org.vo.StateListVO;


public class NewCenterArriveBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField CABNum;
	private JTextField newday;
	private JTextField newmonth;
	private DefaultTableModel model;
	private JTable table;
	private JTextField GoodNum;
	private JTextField CenterNum;
	ArrayList<StateListVO> statevo = new ArrayList<StateListVO>();

	/**
	 * Create the panel.
	 */
	public NewCenterArriveBillsUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5230\u8FBE\u65E5\u671F  ");
		lblNewLabel.setBounds(19, 8, 60, 15);
		add(lblNewLabel);
		
		newyear = new JTextField();
		newyear.setBounds(94, 5, 56, 21);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(160, 5, 49, 21);
		add(newmonth);
		newmonth.setColumns(8);
		
		newday = new JTextField();
		newday.setBounds(219, 5, 49, 21);
		add(newday);
		newday.setColumns(8);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		lblNewLabel_1.setBounds(18, 34, 60, 15);
		add(lblNewLabel_1);
		
		CABNum = new JTextField();
		CABNum.setBounds(94, 31, 175, 21);
		add(CABNum);
		CABNum.setColumns(30);
		
		JButton Submit = new JButton("\u63D0\u4EA4");
		Submit.setBounds(100, 260, 93, 23);
		add(Submit);
		Submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewCenterArriveBillsBLService bl = BLFactory.newCenterArriveBillsBL;
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				bl.addCenterArriveBills(date, CABNum.getText(), CenterNum.getText(), statevo);
			}
			
		});
		
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("货物状态");
		model = new DefaultTableModel(vo,str);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.setFillsViewportHeight(true);
		
		
		JLabel label = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label.setBounds(19, 87, 54, 15);
		add(label);
		
		GoodNum = new JTextField();
		GoodNum.setBounds(94, 84, 93, 21);
		add(GoodNum);
		GoodNum.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D27\u7269\u72B6\u6001");
		lblNewLabel_2.setBounds(19, 112, 54, 15);
		add(lblNewLabel_2);
		
		final JComboBox State = new JComboBox();
		State.setBounds(94, 109, 66, 21);
		add(State);
		State.addItem("完整");
		State.addItem("丢失");
		State.addItem("损坏");
		
		JButton AddGood = new JButton("\u6DFB\u52A0\u8D27\u7269");
		AddGood.setBounds(175, 108, 93, 23);
		add(AddGood);
		AddGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = GoodNum.getText();
				String state = State.getSelectedItem().toString();
				StateListVO item = new StateListVO(num,state);
				statevo.add(item);				
				model.addRow(item);
				GoodNum.setText("");
				
			}
			
		});
		
		JLabel label_1 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u7F16\u53F7");
		label_1.setBounds(19, 59, 72, 15);
		add(label_1);
		
		CenterNum = new JTextField();
		CenterNum.setBounds(94, 56, 174, 21);
		add(CenterNum);
		CenterNum.setColumns(10);
		
		JButton delete = new JButton("删除");
		delete.setBounds(197, 83, 71, 23);
		add(delete);
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				statevo.remove(dex);
				model.removeRow(dex);
				
				
			}
			
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(19, 137, 249, 110);
		add(scrollPane);
			
		}
	}

