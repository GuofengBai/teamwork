package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.businesslogic.billsbl.NewCenterFreightBillsBL;
import org.businesslogic.billsbl.NewHallArriveBillsBL;
import org.po.SENDSTYPE;
import org.po.myDate;
import org.vo.StateListVO;


public class NewHallArriveBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField startPlace;
	private JTextField entruckNum;
	private JTable table;
	private JTextField goodNum;
	private ArrayList<StateListVO> list;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public NewHallArriveBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u5230\u8FBE\u65E5\u671F  ");
		label.setBounds(10, 13, 60, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setBounds(75, 10, 66, 21);
		newyear.setColumns(10);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setBounds(146, 10, 54, 21);
		newmonth.setColumns(8);
		add(newmonth);
		
		newday = new JTextField();
		newday.setBounds(205, 10, 54, 21);
		newday.setColumns(8);
		add(newday);
		
		JLabel label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setBounds(10, 38, 54, 15);
		add(label_1);
		
		startPlace = new JTextField();
		startPlace.setBounds(75, 35, 184, 21);
		add(startPlace);
		startPlace.setColumns(10);
		
		JLabel label_2 = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		label_2.setBounds(10, 63, 60, 15);
		add(label_2);
		
		entruckNum = new JTextField();
		entruckNum.setBounds(75, 60, 184, 21);
		add(entruckNum);
		entruckNum.setColumns(10);
		
		JLabel label_3 = new JLabel("托运单号");
		label_3.setBounds(10, 88, 54, 15);
		add(label_3);
		
		final JComboBox goodState = new JComboBox();
		goodState.setBounds(199, 85, 60, 21);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("丢失");
		goodState.addItem("损坏");
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(10, 113, 93, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = goodNum.getText();
				String state = goodState.getSelectedItem().toString();
				StateListVO item = new StateListVO(num,state);
				model.addRow(item);
				goodNum.setText("");
				list.add(item);
				
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
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 140, 251, 92);
		add(scrollPane);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(92, 242, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewHallArriveBillsBL bl = new NewHallArriveBillsBL();
				bl.addHallArriveBills(date,startPlace.getText(),entruckNum.getText(),list);
			}
			
		});
		
		goodNum = new JTextField();
		goodNum.setBounds(75, 85, 114, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(113, 113, 93, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});

	}
}
