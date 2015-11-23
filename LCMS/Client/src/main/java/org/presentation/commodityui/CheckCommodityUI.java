package org.presentation.commodityui;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
import java.util.Vector;

import javax.swing.table.DefaultTableColumnModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.vo.ComVO;


public class CheckCommodityUI extends JPanel {
	private JTable table;
	CheckCommodityBLService cbs;
	private DefaultTableModel model;

	
	public void initTable(){
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
		Vector<ComVO> vData = cbs.checkCommodityInf();
		model=new DefaultTableModel(vData,vColumns);
		table=new JTable(model){
			
		};
		scrollPane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	/**
	 * Create the panel.
	 */
	public CheckCommodityUI() {
		cbs=BLFactory.getCheckCommodityBL();
		setLayout(null);
		
		JLabel label = new JLabel("\u5E93\u5B58\u76D8\u70B9");
		label.setBounds(222, 30, 74, 25);
		add(label);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u5FEB\u9012\u7F16\u53F7", "\u5165\u5E93\u65E5\u671F", "\u76EE\u7684\u5730", "\u533A\u53F7\u6392\u53F7\u67B6\u53F7\u4F4D\u53F7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.setBounds(105, 93, 319, 218);
		//add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(53, 82, 482, 218);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(422, 328, 113, 27);
		add(btnNewButton);
		
		JButton button = new JButton("开始");
		button.setBounds(422, 29, 113, 27);
		add(button);
		


	}
}
