package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.HABVO;
import org.vo.OBVO;


public class NewOutstorageBillsUI extends JPanel {
	private JPanel superview;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField entruckNum;
	private JTextField goodNum;
	private JTable table;
	private JButton submit;
	private JLabel lblNewLabel_1;
	private JTextField centerNum;
	DefaultTableModel model;
	private ArrayList<ComPO> compo = new ArrayList<ComPO>();
	private JButton back;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewOutstorageBillsUI(final JPanel superview) {
		this.superview = superview;
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
		
		JLabel lblNewLabel = new JLabel("出库单编号");
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
				NewOutstorageBillsBLService bl = BLFactory.getNewOutstorageBillsBL();
				CommodityVO cvo = bl.creatVO(goodNum.getText());
				ComPO cpo =bl.creatPO(goodNum.getText());
				model.addRow(cvo);
				compo.add(cpo);
				goodNum.setText("");
			}
			
		});
		
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(113, 89, 93, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				compo.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		Vector<CommodityVO> vo = new Vector<CommodityVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("日期");
		str.add("目的地");
		str.add("运输方式");
		str.add("区");
		str.add("排");
		str.add("架");
		str.add("位");
		str.add("中转中心编号");
		model = new DefaultTableModel(vo,str);;
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 145, 261, 87);
		add(scrollPane);
		
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(36, 242, 93, 23);
		add(submit);	
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewOutstorageBillsBLService bl = BLFactory.getNewOutstorageBillsBL();
				OBVO bvo = new OBVO(date, centerNum.getText(), entruckNum.getText(), compo);
				bl.addOutstorageBills(bvo);
				bl.deleteCommodity(compo);
			}
			
		});
		
		lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(10, 122, 78, 15);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(94, 119, 177, 21);
		add(centerNum);
		centerNum.setColumns(10);
		
		back = new JButton("返回");
		back.setBounds(160, 242, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}
	public NewOutstorageBillsUI(OBVO vo){
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
		
		JLabel lblNewLabel = new JLabel("出库单编号");
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
				NewOutstorageBillsBLService bl = BLFactory.getNewOutstorageBillsBL();
				CommodityVO cvo = bl.creatVO(goodNum.getText());
				ComPO cpo =bl.creatPO(goodNum.getText());
				model.addRow(cvo);
				compo.add(cpo);
				goodNum.setText("");
			}
			
		});
		
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(113, 89, 93, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				compo.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		Vector<CommodityVO> VO = new Vector<CommodityVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("日期");
		str.add("目的地");
		str.add("运输方式");
		str.add("区");
		str.add("排");
		str.add("架");
		str.add("位");
		str.add("中转中心编号");
		model = new DefaultTableModel(VO,str);;
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 145, 261, 87);
		add(scrollPane);
		
		submit = new JButton("更新");
		submit.setBounds(94, 242, 93, 23);
		add(submit);	
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewOutstorageBillsBLService bl = BLFactory.getNewOutstorageBillsBL();
				OBVO bvo = new OBVO(date, centerNum.getText(), entruckNum.getText(), compo);
				bl.updateOutstorageBills(bvo);
				bl.deleteCommodity(compo);
			}
			
		});
		
		lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(10, 122, 78, 15);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(94, 119, 177, 21);
		add(centerNum);
		centerNum.setColumns(10);
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		entruckNum.setText(vo.entruckNum);
		centerNum.setText(vo.centerNum);
		for(ComPO po:vo.list){
			CommodityVO list = new CommodityVO(po);
			model.addRow(list);
		}
		this.compo=vo.list;
	}
}
