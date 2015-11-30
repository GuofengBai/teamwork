package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallDispatchBillsBLService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.SendingBills;
import org.po.StateListPO;
import org.po.myDate;
import org.vo.HABVO;
import org.vo.HDBVO;
import org.vo.StateListVO;


public class NewHallDispatchBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField goodNum;
	private JTextField name;
	private JLabel label_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel rname;
	private JLabel rphone;
	private JLabel rlocation;
	private JLabel label_6;
	private JTextField idNum;

	/**
	 * Create the panel.
	 */
	public NewHallDispatchBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("到达日期  ");
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
		
		JLabel label_1 = new JLabel("托运单号");
		label_1.setBounds(10, 38, 54, 15);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(75, 35, 93, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JLabel label_3 = new JLabel("快递员姓名");
		label_3.setBounds(10, 141, 60, 15);
		add(label_3);
		
		name = new JTextField();
		name.setBounds(75, 138, 174, 21);
		add(name);
		name.setColumns(10);
		
		JButton submit = new JButton("提交");
		submit.setBounds(85, 194, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsBLService bl = BLFactory.getNewHallDispatchBillsBL();
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				HDBVO bvo = new HDBVO(date,idNum.getText(), name.getText(), goodNum.getText());
				bl.newHallDispatchBill(bvo);
			}
			
		});
		
		JButton search = new JButton("检索");
		search.setBounds(178, 34, 81, 23);
		add(search);
		
		label_2 = new JLabel("收件人姓名");
		label_2.setBounds(10, 63, 60, 15);
		add(label_2);
		
		label_4 = new JLabel("收件人电话");
		label_4.setBounds(10, 85, 60, 15);
		add(label_4);
		
		label_5 = new JLabel("收件人住址");
		label_5.setBounds(10, 110, 60, 15);
		add(label_5);
		
		rname = new JLabel("");
		rname.setBounds(85, 63, 174, 15);
		add(rname);
		
		rphone = new JLabel("");
		rphone.setBounds(85, 85, 174, 15);
		add(rphone);
		
		rlocation = new JLabel("");
		rlocation.setBounds(85, 110, 174, 15);
		add(rlocation);
		
		label_6 = new JLabel("派件单编号");
		label_6.setBounds(10, 169, 60, 15);
		add(label_6);
		
		idNum = new JTextField();
		idNum.setBounds(75, 166, 174, 21);
		add(idNum);
		idNum.setColumns(10);
		search.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewHallDispatchBillsBLService bl = BLFactory.getNewHallDispatchBillsBL();
				String message = bl.searchTheGood(goodNum.getText());
				String[] str = message.split(" ");
				rname.setText(str[0]);
				rphone.setText(str[1]);
				rlocation.setText(str[2]);				
			}
			
		});

	}
	public void showview(HDBVO vo){
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		goodNum.setText(vo.GoodsNum);
		name.setText(vo.name);
		idNum.setText(vo.idNum);
	}
}
