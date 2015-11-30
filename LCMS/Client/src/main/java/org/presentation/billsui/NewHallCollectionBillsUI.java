package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.businesslogic.billsbl.NewCenterFreightBillsBL;
import org.businesslogic.billsbl.NewHallCollectBillsBL;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallCollectBillsBLService;
import org.po.SENDSTYPE;
import org.po.StateListPO;
import org.po.myDate;
import org.vo.CEBVO;
import org.vo.HCBVO;
import org.vo.StateListVO;


public class NewHallCollectionBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField name;
	private JTextField pay;
	private JTextField goodNum;
	private JTable table;
	private JButton submit;
	DefaultTableModel model;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private JLabel total;
	private JLabel label_4;
	private JTextField idNum;

	/**
	 * Create the panel.
	 */
	public NewHallCollectionBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("收款日期  ");
		label.setBounds(10, 13, 60, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(75, 10, 66, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(8);
		newmonth.setBounds(146, 10, 54, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(8);
		newday.setBounds(205, 10, 54, 21);
		add(newday);
		
		JLabel label_1 = new JLabel("收款金额");
		label_1.setBounds(10, 91, 54, 15);
		add(label_1);
		
		name = new JTextField();
		name.setBounds(75, 63, 184, 21);
		add(name);
		name.setColumns(10);
		
		JLabel label_2 = new JLabel("快递员姓名");
		label_2.setBounds(10, 66, 60, 15);
		add(label_2);
		
		pay = new JTextField();
		pay.setBounds(75, 88, 184, 21);
		add(pay);
		pay.setColumns(10);
		
		JLabel label_3 = new JLabel("托运单号");
		label_3.setBounds(10, 116, 54, 15);
		add(label_3);
		
		goodNum = new JTextField();
		goodNum.setBounds(75, 113, 184, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(135, 136, 60, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = goodNum.getText();
				String price = pay.getText();
				total.setText(Integer.parseInt(total.getText())+Integer.parseInt(price)+"");
				StateListVO item = new StateListVO(num,price);
				StateListPO po = new StateListPO(num,price);
				model.addRow(item);
				goodNum.setText("");
				pay.setText("");
				list.add(po);				
			}
			
		});
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(199, 136, 60, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				total.setText(Integer.parseInt(total.getText())-Integer.parseInt(list.get(dex).getState())+"");
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("收款金额");
		model = new DefaultTableModel(vo,str);;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 249, 88);
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
		
		submit = new JButton("提交");
		submit.setBounds(90, 266, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewHallCollectBillsBLService bl = BLFactory.getNewHallCollectBillsBL();
				HCBVO bvo = new HCBVO(date,idNum.getText(), name.getText(),total.getText(),list);
				bl.addHallCollectionBills(bvo);
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("总金额");
		lblNewLabel.setBounds(10, 141, 45, 15);
		add(lblNewLabel);
		
		total = new JLabel("0");
		total.setBounds(57, 141, 68, 18);
		add(total);
		
		label_4 = new JLabel("收款单号");
		label_4.setBounds(10, 38, 54, 15);
		add(label_4);
		
		idNum = new JTextField();
		idNum.setBounds(75, 35, 184, 21);
		add(idNum);
		idNum.setColumns(10);

	}
	public void showview(HCBVO vo){
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		idNum.setText(vo.idNum);
		name.setText(vo.name);
		total.setText(vo.total);
		for(StateListPO po:vo.list){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
	}
}
