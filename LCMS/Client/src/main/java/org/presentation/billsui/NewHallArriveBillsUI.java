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
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallArriveBillsBLService;
import org.po.SENDSTYPE;
import org.po.StateListPO;
import org.po.myDate;
import org.vo.CEBVO;
import org.vo.HABVO;
import org.vo.StateListVO;


public class NewHallArriveBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField startPlace;
	private JTextField entruckNum;
	private JTable table;
	private JTextField goodNum;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private DefaultTableModel model;
	private JTextField idNum;

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
		label_3.setBounds(10, 116, 54, 15);
		add(label_3);
		
		final JComboBox goodState = new JComboBox();
		goodState.setBounds(199, 113, 60, 21);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("丢失");
		goodState.addItem("损坏");
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(10, 141, 93, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = goodNum.getText();
				String state = goodState.getSelectedItem().toString();
				StateListVO item = new StateListVO(num,state);
				StateListPO po = new StateListPO(num,state);
				model.addRow(item);
				goodNum.setText("");
				list.add(po);
				
			}
			
		});
		
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("货物状态");
		model = new DefaultTableModel(vo,str);;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 251, 92);
		add(scrollPane);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		scrollPane.setViewportView(table);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(96, 277, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewHallArriveBillsBLService bl = BLFactory.getNewHallArriveBillsBL();
				HABVO bvo = new HABVO(date,idNum.getText(),startPlace.getText(),entruckNum.getText(),list);
				bl.addHallArriveBills(bvo);
			}
			
		});
		
		goodNum = new JTextField();
		goodNum.setBounds(75, 113, 114, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(113, 141, 93, 23);
		add(deleteGood);
		
		JLabel label_4 = new JLabel("到达单编号");
		label_4.setBounds(10, 88, 60, 15);
		add(label_4);
		
		idNum = new JTextField();
		idNum.setBounds(75, 85, 184, 21);
		add(idNum);
		idNum.setColumns(10);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});

	}
	public void showview(HABVO vo){
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		startPlace.setText(vo.startPlace);
		entruckNum.setText(vo.entruckNum);
		idNum.setText(vo.idNum);
		for(StateListPO po:vo.list){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
	}
}
