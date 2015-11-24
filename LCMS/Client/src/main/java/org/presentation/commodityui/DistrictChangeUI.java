package org.presentation.commodityui;

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
	Vector<CommodityVO> cvo;
	private JComboBox<String> ComBox;
	private List<String> list;

	/**
	 * Create the panel.
	 */
	private void initDistrictSelecter() {
		ComBox = new JComboBox<String>();
		// 获得供应商列表
		list = cbs.getArea();
		// 初始化下拉框选项
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ComBox.addItem(list.get(i));
			}
		}
		// 设置选择事件
		ComBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					String selected = (String) ComBox.getSelectedItem();
					cvo = cbs.getDistrictCommodity(selected);
				}
			}
		});
		// 添加下拉框
		JPanel supplierPanel = new JPanel();
		ComBox.setBounds(62, 76, 82, 25);
		JLabel supplierLabel = new JLabel("仓库：");
		supplierPanel.add(supplierLabel);
		supplierPanel.add(ComBox);
		this.add(supplierPanel);
	}
	private void initToSelecter() {
		ComBox = new JComboBox<String>();
		// 获得供应商列表
		// 初始化下拉框选项
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ComBox.addItem(list.get(i));
			}
		}
		// 设置选择事件
		ComBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				if (evt.getStateChange() == ItemEvent.SELECTED) {
					String selected = (String) ComBox.getSelectedItem();
					cvo = cbs.getDistrictCommodity(selected);
				}
			}
		});
		// 添加下拉框
		JPanel supplierPanel = new JPanel();
		ComBox.setBounds(245, 76, 82, 25);
		JLabel supplierLabel = new JLabel("仓库：");
		supplierPanel.add(supplierLabel);
		supplierPanel.add(ComBox);
		this.add(supplierPanel);
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
		Vector<CommodityVO> vData = new Vector<CommodityVO>();

		model = new DefaultTableModel(cvo, vColumns);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addRow(cvo);
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	public DistrictChangeUI() {

		cbs = BLFactory.getDistrictChangeBL();
		initDistrictSelecter();
		initTable();
		setLayout(null);

		JLabel label = new JLabel("库区调整");
		label.setBounds(222, 30, 74, 25);
		add(label);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "仓库1", "仓库2" }));
		comboBox.setBounds(62, 76, 82, 25);
		add(comboBox);

		JLabel label_1 = new JLabel("移至");
		label_1.setBounds(177, 79, 72, 18);
		add(label_1);

		JLabel label_2 = new JLabel("仓库已使用");
		label_2.setBounds(361, 79, 82, 18);
		add(label_2);

		JLabel label_3 = new JLabel("25%");
		label_3.setBounds(469, 79, 72, 18);
		add(label_3);

		JButton button = new JButton("返回");
		button.setBounds(422, 328, 113, 27);
		add(button);

	}
}
