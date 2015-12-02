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

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.po.ResultMessage;
import org.vo.CommodityVO;
import org.vo.StaffVO;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;

public class DistrictChangeUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table1;
	private JTable table2;
	DistrictChangeBLService cbs;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	Vector<CommodityVO> cvo1;
	Vector<CommodityVO> cvo2;
	private JComboBox<String> ComBox1;
	private JComboBox<String> ComBox2;
	private List<String> list;
	private String selected1="航运区";
	private String selected2;
	private String to;// 移至另一个仓库
	private String centerNum;
	private StaffVO thisstaff;
	private JTextField QU;
	private JTextField PAI;
	private JTextField JIA;
	private JTextField WEI;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	private void initDistrictSelecter() throws RemoteException {
		ComBox1 = new JComboBox<String>();
		// 获得供应商列表
		list = cbs.getArea(centerNum);
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
					System.out.println(selected1);
					
					try {
						showTable();
						hideTable(selected1);
						cvo1 = cbs.getDistrictCommodity(centerNum, selected1);
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
	private void showTable() throws RemoteException{
		cvo1=cbs.getDistrictCommodity(centerNum, selected1);
		for(CommodityVO vo:cvo1){
			model1.addRow(vo);
		}
	}

	private void hideTable(String selected){
		
		for(int i=0;i<model1.getRowCount();i++){
			if(!((String)(model1.getValueAt(i, 3))).equals(selected)){
				model1.removeRow(i);
				i--;
			}
		}
	}
	
	private void initToSelecter() throws RemoteException {
		ComBox2 = new JComboBox<String>();
		// 获得供应商列表
		// 初始化下拉框选项
		list = cbs.getArea(centerNum);
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
					System.out.println(selected2);
				}
			}
		});
		// 添加下拉框

		ComBox2.setBounds(375, 56, 82, 25);
		JLabel supplierLabel = new JLabel("仓库：");

		this.add(ComBox2);
	}

	public void initSelecterTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(62, 118, 507, 305);
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

		model1 = new DefaultTableModel(vData, vColumns);
		//for (CommodityVO vo : cvo1) {
		//	model1.addRow(vo);
		//}
		this.add(scrollPane);
		table1 = new JTable(model1) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(table1);
		table1.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		table1.setFillsViewportHeight(true);
	}

/*	public void initToTable() {
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
		vColumns.add("中转中心编号");
		Vector<CommodityVO> vData = new Vector<CommodityVO>();

		model2 = new DefaultTableModel(cvo2, vColumns);
		for (CommodityVO vo : cvo2) {
			model2.addRow(vo);
		}
		this.add(scrollPane);
		table2 = new JTable(model2) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(table2);
		table2.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		table2.setFillsViewportHeight(true);
	}*/

	public void initTo() {
		JLabel label_4 = new JLabel("区");
		label_4.setBounds(609, 117, 72, 18);
		add(label_4);

		JLabel label_5 = new JLabel("排");
		label_5.setBounds(609, 172, 72, 18);
		add(label_5);

		JLabel label_6 = new JLabel("架");
		label_6.setBounds(609, 232, 72, 18);
		add(label_6);

		JLabel label_7 = new JLabel("位");
		label_7.setBounds(609, 286, 72, 18);
		add(label_7);

		QU = new JTextField();
		QU.setBounds(696, 114, 86, 24);
		add(QU);
		QU.setColumns(10);

		PAI = new JTextField();
		PAI.setBounds(696, 169, 86, 24);
		add(PAI);
		PAI.setColumns(10);

		JIA = new JTextField();
		JIA.setBounds(696, 229, 86, 24);
		add(JIA);
		JIA.setColumns(10);

		WEI = new JTextField();
		WEI.setBounds(696, 286, 86, 24);
		add(WEI);
		WEI.setColumns(10);

		JLabel label_8 = new JLabel("区排架位各为1位整数");
		label_8.setBounds(669, 367, 148, 18);
		add(label_8);
	}

	protected void changeItem() throws RemoteException {
		int index = table1.getSelectedRow();

		if (index == -1) {
			JOptionPane.showMessageDialog(null, "请选中一个货物！", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		System.out.println(index);
		if (QU.getText() == null || PAI.getText() == null
				|| JIA.getText() == null || WEI.getText() == null) {
			JOptionPane.showMessageDialog(null, "请输入新的4位数字的位置号！", "",JOptionPane.ERROR_MESSAGE);
			return;
			}
		else if (Integer.parseInt(QU.getText()) > 9
				|| Integer.parseInt(QU.getText()) < 0
				|| Integer.parseInt(PAI.getText()) > 9
				|| Integer.parseInt(PAI.getText()) < 0
				|| Integer.parseInt(JIA.getText()) > 9
				|| Integer.parseInt(JIA.getText()) < 0
				|| Integer.parseInt(WEI.getText()) > 9
				|| Integer.parseInt(WEI.getText()) < 0) {
			JOptionPane.showMessageDialog(null, "请输入正确的(4位数字)的位置号！", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			JOptionPane.showMessageDialog(null, "调整成功", "",
					JOptionPane.ERROR_MESSAGE);
		}
		String location = QU.getText() + PAI.getText() + JIA.getText()
				+ WEI.getText();
		
		ResultMessage re=cbs.change(selected1, selected2, index, location);
		if(re.success){
			table1.remove(index);
			model1.removeRow(index);
			}
		
		else
			JOptionPane.showMessageDialog(null, re.info[0], re.info[1],
					JOptionPane.ERROR_MESSAGE);
	}

	public DistrictChangeUI() throws RemoteException {
		//thisstaff = CurrentStaff.getStaff();
		//if (thisstaff.workSpace.type.equals("中转中心"))
		//	this.centerNum = thisstaff.workSpace.num;
		this.centerNum="0210001";
		cbs = BLFactory.getDistrictChangeBL();
		initDistrictSelecter();
		initSelecterTable();
		initToSelecter();
		initTo();
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
		label_2.setBounds(487, 59, 82, 18);
		add(label_2);

		JLabel label_3 = new JLabel("25%");
		label_3.setBounds(583, 59, 72, 18);
		add(label_3);

		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);//返回
			}
		});
		button.setBounds(669, 436, 113, 27);
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
