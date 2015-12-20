package org.presentation.commodityui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;

import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.po.ResultMessage;
import org.presentation.mainui.ViewController;
import org.vo.CommodityVO;
import org.vo.StaffVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.Font;

public class DistrictChangeUI extends JPanel {
	/**
	 * 
	 */
	private JPanel superpanel;
	private static final long serialVersionUID = 1L;
	private JTable table1;

	DistrictChangeBLService cbs;
	private DefaultTableModel model1;

	Vector<CommodityVO> cvo1;
	Vector<CommodityVO> cvo2;
	private JComboBox<String> ComBox1;
	private JComboBox<String> ComBox2;
	private List<String> list;
	private String selected1 = "航运区";
	private String selected2;
	private String centerNum;
	private StaffVO thisstaff;
	private JTextField QU;
	private JTextField PAI;
	private JTextField JIA;
	private JTextField WEI;
	private JLabel suggest;

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

		ComBox1.setBounds(81, 140, 102, 45);
		this.add(ComBox1);
	}

	private void showTable() throws RemoteException {
		cvo1 = cbs.getDistrictCommodity(centerNum, selected1);
		for (CommodityVO vo : cvo1) {
			model1.addRow(vo);
		}
	}

	private void hideTable(String selected) {

		for (int i = 0; i < model1.getRowCount(); i++) {
			if (!((String) (model1.getValueAt(i, 3))).equals(selected)) {
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

		ComBox2.setBounds(364, 140, 102, 45);
		this.add(ComBox2);
	}

	public void initSelecterTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(81, 375, 688, 447);
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
		// for (CommodityVO vo : cvo1) {
		// model1.addRow(vo);
		// }
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

	public void initTo() {
		JLabel label_4 = new JLabel("区");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(81, 221, 72, 35);
		add(label_4);

		JLabel label_5 = new JLabel("排");
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(251, 221, 72, 35);
		add(label_5);

		JLabel label_6 = new JLabel("架");
		label_6.setFont(new Font("宋体", Font.PLAIN, 22));
		label_6.setBounds(447, 222, 72, 32);
		add(label_6);

		JLabel label_7 = new JLabel("位");
		label_7.setFont(new Font("宋体", Font.PLAIN, 22));
		label_7.setBounds(644, 221, 72, 35);
		add(label_7);

		QU = new JTextField();
		QU.setBounds(119, 226, 86, 24);
		add(QU);
		QU.setColumns(10);

		PAI = new JTextField();
		PAI.setBounds(305, 226, 86, 24);
		add(PAI);
		PAI.setColumns(10);

		JIA = new JTextField();
		JIA.setBounds(494, 226, 86, 24);
		add(JIA);
		JIA.setColumns(10);

		WEI = new JTextField();
		WEI.setBounds(683, 226, 86, 24);
		add(WEI);
		WEI.setColumns(10);

		JLabel label_8 = new JLabel("区排架位各为1位整数");
		label_8.setFont(new Font("宋体", Font.PLAIN, 22));
		label_8.setBounds(81, 297, 224, 35);
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
			suggest.setText("请输入新的4位数字的位置号！");
			return;
		}
		else if(QU.getText().length()>1||PAI.getText().length()>1||JIA.getText().length()>1||WEI.getText().length()>1){
			suggest.setText("请输入单个数字的4位位置号！");
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
			suggest.setText("请输入正确的(4位数字)的位置号！");
			return;
		} else {
			suggest.setText( "调整成功");
		}
		String location = QU.getText() + PAI.getText() + JIA.getText()
				+ WEI.getText();

		ResultMessage re = cbs.change(selected1, selected2, index, location);
		if (re.success) {
			table1.remove(index);
			model1.removeRow(index);
		}

		else
			JOptionPane.showMessageDialog(null, re.info[0], re.info[1],
					JOptionPane.ERROR_MESSAGE);
	}

	public DistrictChangeUI(JPanel ui) throws RemoteException {
		thisstaff = CurrentStaff.getStaff();
		if (thisstaff.workSpace.type.equals("中转中心"))
			this.centerNum = thisstaff.workSpace.num;
		this.superpanel = ui;
		// this.centerNum="0250001";
		cbs = BLFactory.getDistrictChangeBL();
		initDistrictSelecter();
		initSelecterTable();
		initToSelecter();
		initTo();
		setLayout(null);

		JLabel label = new JLabel("库区调整");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);

		// JComboBox comboBox = new JComboBox();
		// comboBox.setModel(new DefaultComboBoxModel(
		// new String[] { "仓库1", "仓库2" }));
		// comboBox.setBounds(62, 76, 82, 25);
		// add(comboBox);

		JLabel label_1 = new JLabel("移至");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(251, 142, 84, 35);
		add(label_1);
		String result = null;
		SettingAlertBLService sabs = BLFactory.getSettingAlertBL();
		result = String.valueOf(sabs.getAlert(centerNum)) + "%";
		JLabel label_2 = new JLabel("仓库已使用");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(509, 140, 125, 39);
		add(label_2);

		JLabel label_3 = new JLabel(" ");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setText(result);
		label_3.setBounds(644, 143, 86, 32);
		add(label_3);

		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superpanel);
			}
		});
		button.setBounds(712, 64, 102, 45);
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
		btnNewButton.setBounds(364, 295, 102, 45);
		add(btnNewButton);

		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(480, 297, 380, 35);
		add(suggest);

	}
}
