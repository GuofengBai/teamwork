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
import org.po.myDate;
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
	private ArrayList<StateListVO> list = new ArrayList<StateListVO>();
	private JLabel total;

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
		label_1.setBounds(10, 63, 54, 15);
		add(label_1);
		
		name = new JTextField();
		name.setBounds(75, 35, 184, 21);
		add(name);
		name.setColumns(10);
		
		JLabel label_2 = new JLabel("快递员姓名");
		label_2.setBounds(10, 38, 60, 15);
		add(label_2);
		
		pay = new JTextField();
		pay.setBounds(75, 60, 184, 21);
		add(pay);
		pay.setColumns(10);
		
		JLabel label_3 = new JLabel("托运单号");
		label_3.setBounds(10, 88, 54, 15);
		add(label_3);
		
		goodNum = new JTextField();
		goodNum.setBounds(75, 85, 184, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(135, 108, 60, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = goodNum.getText();
				String price = pay.getText();
				total.setText(Integer.parseInt(total.getText())+Integer.parseInt(price)+"");
				StateListVO item = new StateListVO(num,price);
				model.addRow(item);
				goodNum.setText("");
				pay.setText("");
				list.add(item);				
			}
			
		});
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(199, 108, 60, 23);
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
		scrollPane.setBounds(10, 140, 249, 88);
		add(scrollPane);
		
		submit = new JButton("提交");
		submit.setBounds(90, 238, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewHallCollectBillsBLService bl = BLFactory.getNewHallCollectBillsBL();
				bl.addHallCollectionBills(date, name.getText(),total.getText(),list);
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("总金额");
		lblNewLabel.setBounds(10, 113, 45, 15);
		add(lblNewLabel);
		
		total = new JLabel("0");
		total.setBounds(57, 113, 68, 18);
		add(total);

	}
}
