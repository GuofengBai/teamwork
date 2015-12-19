package org.presentation.commodityui;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.Client.CurrentStaff;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.ExamineCommodityBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;

import org.vo.ExamineVO;
import org.vo.StaffVO;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ExamineCommodityUI extends JPanel {
	/**
	 * 
	 */
	private JPanel superpanel;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private String centerNum;
	private StaffVO thisstaff;
	private DefaultTableModel model1;
	//private JTable table1;
	Vector<ExamineVO> evo;
	private ExamineCommodityBLService ecbs;
	//Vector<ExamineVO> elist;

	/**
	 * Create the panel.
	 */
	private boolean compareDates(String[] stime, String[] etime) {
		if (stime[0].equals(etime[0])) {
			if (stime[1].equals(etime[1])) {
				if (stime[2].equals(etime[2])) {
					return false;
				} else if (Integer.parseInt(stime[2]) > Integer
						.parseInt(etime[2])) {
					return false;
				} else {
					return true;
				}
			} else if (Integer.parseInt(stime[1]) > Integer.parseInt(etime[1])) {
				return false;
			} else {
				return true;
			}
		} else if (Integer.parseInt(stime[0]) > Integer.parseInt(etime[0])) {
			return false;
		} else {
			return true;
		}

	}

	protected void addItem() throws RemoteException {
		// TODO Auto-generated method stub
		if (textField.getText() == null || textField_1.getText() == null) {
			JOptionPane.showMessageDialog(null, "请输入日期！", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		String start = textField.getText();
		String end = textField_1.getText();
		String[] starttime = start.split("/");
		String[] endtime = end.split("/");
		if (compareDates(starttime, endtime)) {
			myDate timestart=new myDate(Integer.parseInt(starttime[0]),Integer.parseInt(starttime[1]),Integer.parseInt(starttime[2]));
			myDate timeend=new myDate(Integer.parseInt(endtime[0]),Integer.parseInt(endtime[1]),Integer.parseInt(endtime[2]));
			evo=ecbs.examineCommodity(timestart, timeend, centerNum);
		} else {
			JOptionPane.showMessageDialog(null, "开始日期不得小于结束日期！", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(ExamineVO vo:evo){
			model1.addRow(vo);
		}
		ExamineCommodityUI.this.validate();
	}

	public void initDate() {
		JLabel label = new JLabel("开始日期");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(126, 162, 110, 41);
		add(label);

		JLabel label_1 = new JLabel("结束日期");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(126, 216, 110, 39);
		add(label_1);

		textField = new JTextField();
		textField.setBounds(238, 173, 154, 24);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(238, 226, 154, 24);
		add(textField_1);
		textField_1.setColumns(10);
	}

	public void initTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(81, 282, 733, 486);
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("仓库");
		vColumns.add("开始日期");
		vColumns.add("结束日期");
		vColumns.add("入库数量");
		vColumns.add("出库数量");
		vColumns.add("当前数量");
		Vector<ExamineVO> vdata=new Vector<ExamineVO>();
		model1 = new DefaultTableModel(vdata, vColumns);
		this.add(scrollPane);
		table = new JTable(model1) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// model.addRow(cvo);
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	public ExamineCommodityUI(JPanel ui) throws RemoteException {
		thisstaff = CurrentStaff.getStaff();
		if (thisstaff.workSpace.type.equals("中转中心"))
			this.centerNum = thisstaff.workSpace.num;
		this.superpanel=ui;
		//this.centerNum="0250001";
		ecbs = BLFactory.getExamineCommodityBL();
		initDate();
		initTable();
		setLayout(null);

		JLabel lblNewLabel = new JLabel("库存查看");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(354, 25, 160, 118);
		add(lblNewLabel);

		JButton button = new JButton("查看");
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
		button.setBounds(457, 217, 102, 45);
		add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superpanel);
			}
		});
		button_1.setBounds(712, 64, 102, 45);
		add(button_1);

		JLabel label = new JLabel("格式:2015/1/29");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(457, 169, 193, 27);
		add(label);

	}
}
