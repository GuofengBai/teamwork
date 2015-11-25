package org.presentation.commodityui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.vo.CommodityVO;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

public class DistrictChangeUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	DistrictChangeBLService cbs;
	private DefaultTableModel model;
	Vector<CommodityVO> cvo1;
	Vector<CommodityVO> cvo2;
	private JComboBox<String> ComBox1;
	private JComboBox<String> ComBox2;
	private List<String> list;
	private String selected1;
	private String selected2;
	private String to;// 移至另一个仓库

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	private void initDistrictSelecter() throws RemoteException {
		ComBox1 = new JComboBox<String>();
		// 获得供应商列表
		list = cbs.getArea();
		// 初始化下拉框选项
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ComBox1.addItem(list.get(i));
			}
		}
		// 设置选择事件
		ComBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					selected1 = (String) ComBox1.getSelectedItem();
					try {
						cvo1 = cbs.getDistrictCommodity(selected1);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		// 添加下拉框

		ComBox1.setBounds(62, 56, 82, 25);
		this.add(ComBox1);
	}

	private void initToSelecter() throws RemoteException {
		ComBox2 = new JComboBox<String>();
		// 获得供应商列表
		// 初始化下拉框选项
		list = cbs.getArea();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ComBox2.addItem(list.get(i));
			}
		}
		// 设置选择事件
		ComBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					selected2 = (String) ComBox2.getSelectedItem();
					try {
						cvo2 = cbs.getEmpty(selected2);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		// 添加下拉框

		ComBox2.setBounds(376, 56, 82, 25);
		JLabel supplierLabel = new JLabel("仓库：");

		this.add(ComBox2);
	}

	public void initSelecterTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(62, 118, 346, 218);
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("货运编号");
		vColumns.add("入库日期");
		vColumns.add("目的地");
		vColumns.add("仓库");
		vColumns.add("区号");
		vColumns.add("排号");
		vColumns.add("架号");
		vColumns.add("位号");
		Vector<CommodityVO> vData = new Vector<CommodityVO>();

		model = new DefaultTableModel(cvo1, vColumns);
		for (CommodityVO vo : cvo1) {
			model.addRow(vo);
		}
		this.add(scrollPane);
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
	}

	public void initToTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(480, 118, 337, 218);
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("货运编号");
		vColumns.add("入库日期");
		vColumns.add("目的地");
		vColumns.add("仓库");
		vColumns.add("区号");
		vColumns.add("排号");
		vColumns.add("架号");
		vColumns.add("位号");
		Vector<CommodityVO> vData = new Vector<CommodityVO>();

		model = new DefaultTableModel(cvo2, vColumns);
		for (CommodityVO vo : cvo2) {
			model.addRow(vo);
		}
		this.add(scrollPane);
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
	}
	protected void changeItem() throws RemoteException {
		int index = table.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选中一个商品！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		cbs.change(selected1, selected2,index);
	}

	public DistrictChangeUI() throws RemoteException {

		cbs = BLFactory.getDistrictChangeBL();
		initDistrictSelecter();
		initSelecterTable();
		initToSelecter();
		initToTable();
		setLayout(null);

		JLabel label = new JLabel("库区调整");
		label.setBounds(222, 30, 74, 25);
		add(label);

		// JComboBox comboBox = new JComboBox();
		// comboBox.setModel(new DefaultComboBoxModel(
		// new String[] { "仓库1", "仓库2" }));
		// comboBox.setBounds(62, 76, 82, 25);
		// add(comboBox);

		JLabel label_1 = new JLabel("移至");
		label_1.setBounds(253, 68, 72, 18);
		add(label_1);

		JLabel label_2 = new JLabel("仓库已使用");
		label_2.setBounds(469, 59, 82, 18);
		add(label_2);

		JLabel label_3 = new JLabel("25%");
		label_3.setBounds(565, 59, 72, 18);
		add(label_3);

		JButton button = new JButton("返回");
		button.setBounds(453, 363, 113, 27);
		add(button);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changeItem();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(669, 55, 113, 27);
		add(btnNewButton);

	}
}
