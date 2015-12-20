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
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.OBVO;

import java.awt.Font;

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
	private JLabel label_2;
	private JLabel suggest;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */
	public NewOutstorageBillsUI(JPanel superview) {
		this.superview = superview;
		panel();

		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(409, 746, 102, 45);
		add(submit);

		label_2 = new JLabel("新出库单");
		label_2.setFont(new Font("宋体", Font.PLAIN, 40));
		label_2.setBounds(354, 25, 160, 118);
		add(label_2);
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 日期判断
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
				if(entruckNum.getText().equals("")){
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
				NewOutstorageBillsBLService bl = BLFactory
						.getNewOutstorageBillsBL();
				OBVO bvo = new OBVO(date, centerNum.getText(), entruckNum
						.getText(), compo);
				suggest.setText(bl.cherk(bvo));
				if (suggest.getText().equals("")) {
					bl.addOutstorageBills(bvo);
					bl.deleteCommodity(compo);
					suggest.setText("添加成功");
				}

			}
		});
	}

	public NewOutstorageBillsUI(JPanel superview, OBVO vo) {
		this.superview = superview;
		panel();
		submit = new JButton("更新");
		submit.setBounds(94, 242, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),
						Integer.parseInt(newmonth.getText()), Integer
								.parseInt(newday.getText()));
				NewOutstorageBillsBLService bl = BLFactory
						.getNewOutstorageBillsBL();
				OBVO bvo = new OBVO(date, centerNum.getText(), entruckNum
						.getText(), compo);
				bl.updateOutstorageBills(bvo);
				bl.deleteCommodity(compo);
			}

		});
		newyear.setText(vo.date.year + "");
		newmonth.setText(vo.date.month + "");
		newday.setText(vo.date.day + "");
		entruckNum.setText(vo.entruckNum);
		centerNum.setText(vo.centerNum);
		for (ComPO po : vo.list) {
			CommodityVO list = new CommodityVO(po);
			model.addRow(list);
		}
		this.compo = vo.list;
	}

	private void panel() {
		setLayout(null);

		JLabel label = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 188, 112, 32);
		add(label);

		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(81, 815, 340, 39);
		add(suggest);

		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(193, 196, 80, 21);
		add(newyear);

		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(312, 196, 80, 21);
		add(newmonth);

		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(431, 196, 80, 21);
		add(newday);

		JLabel lblNewLabel = new JLabel("出库单编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(81, 367, 137, 32);
		add(lblNewLabel);

		entruckNum = new JTextField();
		entruckNum.setBounds(263, 375, 264, 21);
		add(entruckNum);
		entruckNum.setColumns(10);

		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u7F16\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 245, 137, 32);
		add(label_1);

		goodNum = new JTextField();
		goodNum.setBounds(263, 253, 264, 21);
		add(goodNum);
		goodNum.setColumns(10);

		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(647, 301, 102, 45);
		add(addGood);
		addGood.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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
				NewOutstorageBillsBLService bl = BLFactory
						.getNewOutstorageBillsBL();
				CommodityVO cvo = bl.creatVO(goodNum.getText());
				ComPO cpo = bl.creatPO(goodNum.getText());
				model.addRow(cvo);
				compo.add(cpo);
				goodNum.setText("");
			}

		});

		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(647, 364, 102, 45);
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
		scrollPane.setBounds(81, 430, 688, 274);
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

		lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(81, 304, 137, 32);
		add(lblNewLabel_1);

		centerNum = new JTextField();
		centerNum.setBounds(263, 312, 264, 21);
		add(centerNum);
		centerNum.setColumns(10);

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
