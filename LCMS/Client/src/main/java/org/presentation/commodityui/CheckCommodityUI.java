package org.presentation.commodityui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.Button;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableColumnModel;

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.ComVO;
import org.vo.CommodityVO;
import org.vo.StaffVO;

public class CheckCommodityUI extends JPanel {
	/**
	 * 
	 */
	private JPanel panel = this;
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
		scrollPane.setBounds(53, 82, 482, 218);
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
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		//model.addRow(cvo);
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	/**
	 * Create the panel.
	 */
	public CheckCommodityUI() {
		thisstaff = CurrentStaff.getStaff();
		if (thisstaff.workSpace.type.equals("中转中心"))
			this.centerNum = thisstaff.workSpace.num;
		//this.centerNum="0250001";
		cbs = BLFactory.getCheckCommodityBL();
		setLayout(null);
		initTable();
		JLabel label = new JLabel("\u5E93\u5B58\u76D8\u70B9");
		label.setBounds(222, 30, 74, 25);
		add(label);

		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ViewController.jumpToAnotherView(new StorageStaffView());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(422, 328, 113, 27);
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
		button.setBounds(422, 29, 113, 27);
		add(button);

	}
}
