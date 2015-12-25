package org.presentation.billsui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.IBVO;

import java.awt.Font;

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
	private JLabel suggest;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */
	public NewInstorageBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(409, 746, 102, 45);
		add(submit);

		JLabel label = new JLabel("新入库单");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(newyear.getText().equals("")||newmonth.getText().equals("")||newday.getText().equals("")){
					suggest.setText("信息未填写完整");
					return;
				}
				for (int i = 0; i < newyear.getText().length(); i++) {
					if (newyear.getText().charAt(i) > '9'
							|| newyear.getText().charAt(i) < '0' || i >= 4) {
						suggest.setText("年份输入错误");
						return;
					}
				}
				for (int i = 0; i < newmonth.getText().length(); i++) {
					if (newmonth.getText().charAt(i) > '9'
							|| newmonth.getText().charAt(i) < '0' || i >= 2) {
						suggest.setText("月份输入错误");
						return;
					}
				}
				for (int i = 0; i < newday.getText().length(); i++) {
					if (newday.getText().charAt(i) > '9'
							|| newday.getText().charAt(i) < '0' || i >= 2) {
						suggest.setText("日期输入错误");
						return;
					}
				}
				if(idNum.getText().equals("")){
					suggest.setText("未填写完整信息");
					return;
				}
				if(centerNum.getText().equals("")){
					suggest.setText("未填写完整信息");
					return;
				}
				myDate date = new myDate(Integer.parseInt(newyear.getText()),
						Integer.parseInt(newmonth.getText()), Integer
								.parseInt(newday.getText()));
				NewInstorageBillsBLService bl = BLFactory
						.getNewInstorageBillsBL();
				IBVO bvo = new IBVO(date, idNum.getText(), centerNum.getText(),
						compo);
			
				suggest.setText(bl.cherk(bvo));
				if (suggest.getText().equals("")) {
					bl.newInstorageBill(bvo);
					bl.addCommodity(compo);
					suggest.setText("添加成功");	
				}
			}

		});
	}

	public NewInstorageBillsUI(JPanel superview, IBVO vo) {
		this.superview = superview;
		panel();

		submit = new JButton("更新");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),
						Integer.parseInt(newmonth.getText()), Integer
								.parseInt(newday.getText()));
				NewInstorageBillsBLService bl = BLFactory
						.getNewInstorageBillsBL();
				IBVO bvo = new IBVO(date, idNum.getText(), centerNum.getText(),
						compo);
				bl.updateInstorageBill(bvo);
				bl.addCommodity(compo);
			}

		});

		newyear.setText(vo.date.year + "");
		newmonth.setText(vo.date.month + "");
		newday.setText(vo.date.day + "");
		centerNum.setText(vo.centerNum);
		idNum.setText(vo.idNum);
		for (ComPO po : vo.list) {
			CommodityVO list = new CommodityVO(po);
			model.addRow(list);
		}
	}

	private void panel() {
		setLayout(null);

		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(431, 196, 80, 21);
		add(newday);

		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(312, 196, 80, 21);
		add(newmonth);

		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(193, 196, 80, 21);
		add(newyear);

		JLabel label = new JLabel("\u5165\u5E93\u65E5\u671F");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 188, 112, 32);
		add(label);

		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(355, 245, 112, 32);
		add(label_1);

		goodNum = new JTextField();
		goodNum.setBounds(499, 253, 250, 21);
		add(goodNum);
		goodNum.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u76EE\u7684\u5730");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(81, 245, 137, 32);
		add(lblNewLabel);

		place = new JTextField();
		place.setBounds(193, 253, 80, 21);
		add(place);
		place.setColumns(10);

		JLabel label_2 = new JLabel("摆放位置(4位数字)");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(81, 304, 192, 32);
		add(label_2);

		location = new JTextField();
		location.setBounds(349, 312, 178, 21);
		add(location);
		location.setColumns(10);

		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(647, 364, 102, 45);
		add(addGood);
		addGood.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				try {
					CommodityDataService ComData=RMIHelper.getDataFactory().getCommodityData();
					if(ComData.getComSize(centerNum.getText())==-1){
						suggest.setText("中转中心不存在");
						return;
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String goodNumvo = goodNum.getText();
				myDate datepo = new myDate(Integer.parseInt(newyear.getText()),
						Integer.parseInt(newmonth.getText()), Integer
								.parseInt(newday.getText()));
				String placevo = place.getText();
				String locationvo = location.getText();
				String areavo = area.getSelectedItem().toString();
				String centerNumvo = centerNum.getText();
				ComPO cpo = new ComPO(goodNumvo, datepo, placevo, locationvo,
						areavo, centerNumvo);
				CommodityVO cvo = new CommodityVO(goodNumvo, datepo, placevo,
						locationvo, areavo, centerNumvo);
				model.addRow(cvo);
				compo.add(cpo);
				location.setText("");
				place.setText("");
				goodNum.setText("");
			}

		});

		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(647, 422, 102, 45);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener() {

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
		model = new DefaultTableModel(vo, str);
		;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 496, 668, 208);
		add(scrollPane);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);

		area = new JComboBox<String>();
		area.setBounds(647, 301, 102, 45);
		add(area);
		area.addItem("汽运区");
		area.addItem("铁运区");
		area.addItem("空运区");

		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(81, 367, 167, 32);
		add(lblNewLabel_1);

		centerNum = new JTextField();
		centerNum.setBounds(264, 375, 263, 21);
		add(centerNum);
		centerNum.setColumns(10);

		label_3 = new JLabel("入库单编号");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(81, 425, 157, 32);
		add(label_3);

		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(81, 746, 340, 39);
		add(suggest);

		idNum = new JTextField();
		idNum.setBounds(263, 433, 264, 21);
		add(idNum);
		idNum.setColumns(10);

		back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});

	}
}
