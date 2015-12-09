package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.po.ComPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.IBVO;


public class NewInstorageBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newday;
	private JTextField newmonth;
	private JTextField newyear;
	private JTextField goodNum;
	private JTextField place;
	private JTextField location;
	private JTable table;
	private JButton submit;
	private JComboBox<String> area;
	DefaultTableModel model;
	private ArrayList<ComPO> compo = new ArrayList<ComPO>();
	private JTextField centerNum;
	private JLabel label_3;
	private JTextField idNum;
	private JButton back;

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewInstorageBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(271, 396, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewInstorageBillsBLService bl = BLFactory.getNewInstorageBillsBL();
				IBVO bvo = new IBVO(date,idNum.getText(), centerNum.getText(), compo);
				bl.newInstorageBill(bvo);
				bl.addCommodity(compo);				
			}
			
		});
	}
	public NewInstorageBillsUI(JPanel superview,IBVO vo){
		this.superview = superview;
		panel();
		
		submit = new JButton("更新");
		submit.setBounds(102, 288, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewInstorageBillsBLService bl = BLFactory.getNewInstorageBillsBL();
				IBVO bvo = new IBVO(date,idNum.getText(), centerNum.getText(), compo);
				bl.updateInstorageBill(bvo);
				bl.addCommodity(compo);				
			}
			
		});
		
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		centerNum.setText(vo.centerNum);
		idNum.setText(vo.idNum);
		for(ComPO po:vo.list){
			CommodityVO list = new CommodityVO(po);
			model.addRow(list);
		}
	}
	private void panel(){
		setLayout(null);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(366, 36, 66, 21);
		add(newday);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(271, 36, 66, 21);
		add(newmonth);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(168, 36, 66, 21);
		add(newyear);
		
		JLabel label = new JLabel("\u5165\u5E93\u65E5\u671F");
		label.setBounds(60, 38, 103, 18);
		add(label);
		
		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_1.setBounds(271, 70, 103, 21);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(366, 69, 161, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u76EE\u7684\u5730");
		lblNewLabel.setBounds(60, 71, 54, 19);
		add(lblNewLabel);
		
		place = new JTextField();
		place.setBounds(168, 69, 80, 21);
		add(place);
		place.setColumns(10);
		
		JLabel label_2 = new JLabel("摆放位置(4位数字)");
		label_2.setBounds(60, 105, 137, 19);
		add(label_2);
		
		location = new JTextField();
		location.setBounds(264, 103, 161, 21);
		add(location);
		location.setColumns(10);
		
		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(264, 137, 93, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String goodNumvo = goodNum.getText();
				myDate datepo = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				String placevo = place.getText();
				String locationvo = location.getText();
				String areavo = area.getSelectedItem().toString();
				String centerNumvo = centerNum.getText();
				ComPO cpo = new ComPO(goodNumvo,datepo,placevo,locationvo,areavo,centerNumvo);
				CommodityVO cvo = new CommodityVO(goodNumvo,datepo,placevo,locationvo,areavo,centerNumvo);
				model.addRow(cvo);
				compo.add(cpo);
				location.setText("");
				place.setText("");
				goodNum.setText("");
			}
			
		});
		
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(434, 137, 93, 23);
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
		scrollPane.setBounds(60, 241, 467, 128);
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
		
		area = new JComboBox<String>();
		area.setBounds(450, 102, 77, 25);
		add(area);
		area.addItem("汽运区");
		area.addItem("铁运区");
		area.addItem("空运区");
		
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(62, 175, 122, 19);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(264, 173, 263, 21);
		add(centerNum);
		centerNum.setColumns(10);
		
		label_3 = new JLabel("入库单编号");
		label_3.setBounds(62, 207, 137, 21);
		add(label_3);
		
		idNum = new JTextField();
		idNum.setBounds(264, 207, 264, 21);
		add(idNum);
		idNum.setColumns(10);
		
		back = new JButton("返回");
		back.setBounds(434, 396, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
		
	}
}
