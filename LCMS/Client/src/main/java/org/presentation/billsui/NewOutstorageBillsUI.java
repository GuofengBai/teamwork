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


import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;

import org.po.ComPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.OBVO;


public class NewOutstorageBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public NewOutstorageBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(309, 348, 93, 23);
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
	}
	public NewOutstorageBillsUI(JPanel superview,OBVO vo){
		this.superview = superview;
		panel();
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
	private void panel(){
		setLayout(null);
		
		JLabel label = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label.setBounds(60, 38, 103, 18);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(168, 36, 66, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(271, 36, 66, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(366, 36, 66, 21);
		add(newday);
		
		JLabel lblNewLabel = new JLabel("出库单编号");
		lblNewLabel.setBounds(60, 72, 86, 18);
		add(lblNewLabel);
		
		entruckNum = new JTextField();
		entruckNum.setBounds(168, 70, 191, 21);
		add(entruckNum);
		entruckNum.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u7F16\u53F7");
		label_1.setBounds(60, 105, 137, 18);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(168, 103, 191, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(309, 142, 93, 23);
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
		deleteGood.setBounds(420, 142, 93, 23);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 191, 453, 127);
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
		
		lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(60, 144, 103, 18);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(168, 142, 127, 21);
		add(centerNum);
		centerNum.setColumns(10);
		
		back = new JButton("返回");
		back.setBounds(420, 348, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}
}
