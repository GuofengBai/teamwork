package org.presentation.commodityui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;



import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;




import javax.swing.JScrollPane;






import javax.swing.UIManager;

import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;



import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.StaffVO;
import java.awt.Font;

public class CheckCommodityUI extends JPanel {
	/**
	 * 
	 */
	private JPanel superpanel;
	private static final long serialVersionUID = 1L;
	private JTable table;
	CheckCommodityBLService cbs;
	private DefaultTableModel model;
	Vector<CommodityVO> cvo;
	private String centerNum;
	private StaffVO thisstaff;

	public void addItem() throws RemoteException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String curdate = simpleDateFormat.format(date);
		int year = Integer.parseInt(curdate.substring(0, 4));
		int month = Integer.parseInt(curdate.substring(4, 6));
		int day = Integer.parseInt(curdate.substring(6, 8));
		myDate today = new myDate(year, month, day);
		cbs.startCheckCommodity(today,centerNum);
		cvo = cbs.checkCommodityInf(centerNum);
		for (CommodityVO vo : cvo) {
			model.addRow(vo);
		}
		//model.addRow(cvo);
	}

	public void initTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(81, 222, 733, 546);
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("货运编号");
		vColumns.add("入库日期");
		vColumns.add("目的地");
		vColumns.add("仓库");
		vColumns.add("区号");
		vColumns.add("排号");
		vColumns.add("架号");
		vColumns.add("位号");
		vColumns.add("中转中心编号");
		Vector<CommodityVO> vData = new Vector<CommodityVO>();

		model = new DefaultTableModel(vData, vColumns);
		this.add(scrollPane);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		//model.addRow(cvo);
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
	}

	/**
	 * Create the panel.
	 */
	public CheckCommodityUI(JPanel ui) {
		thisstaff = CurrentStaff.getStaff();
		if (thisstaff.workSpace.type.equals("中转中心"))
			this.centerNum = thisstaff.workSpace.num;
		this.superpanel=ui;
		//this.centerNum="0250001";
		cbs = BLFactory.getCheckCommodityBL();
		setLayout(null);
		initTable();
		JLabel label = new JLabel("\u5E93\u5B58\u76D8\u70B9");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);

		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superpanel);
			}
		});
		btnNewButton.setBounds(712, 64, 102, 45);
		add(btnNewButton);

		JButton button = new JButton("开始");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addItem();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(712, 142, 102, 45);
		add(button);

	}
}
