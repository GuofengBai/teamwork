package org.presentation.commodityui;
import java.util.Vector;

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
import org.vo.CommodityVO;
import org.vo.ExamineVO;
import org.vo.StaffVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ExamineCommodityUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private String centerNum;
	private StaffVO thisstaff;
	private DefaultTableModel model1;
	private JTable table1;
	Vector<ExamineVO> evo;

	/**
	 * Create the panel.
	 */
	protected void addItem() {
		// TODO Auto-generated method stub
		
	}
	public void initDate(){
		JLabel label = new JLabel("开始日期");
		label.setBounds(90, 47, 72, 18);
		add(label);
		
		JLabel label_1 = new JLabel("结束日期");
		label_1.setBounds(90, 86, 72, 18);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(210, 45, 154, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 84, 154, 24);
		add(textField_1);
		textField_1.setColumns(10);
	}
	public void initTable(){
		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(UIManager.getBorder("Menu.border"));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(90, 121, 482, 218);
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("仓库");
		vColumns.add("开始日期");
		vColumns.add("结束日期");
		vColumns.add("入库数量");
		vColumns.add("出库数量");
		vColumns.add("当前数量");

		model1 = new DefaultTableModel(evo, vColumns);
		this.add(scrollPane);
		table = new JTable(model1) {
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
	public ExamineCommodityUI() {
		thisstaff = CurrentStaff.getStaff();
		if (thisstaff.workSpace.type.equals("中转中心"))
			this.centerNum = thisstaff.workSpace.num;
		initDate();
		initTable();
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("库存查看");
		lblNewLabel.setBounds(249, 10, 74, 25);
		add(lblNewLabel);
		
	
		
		JButton button = new JButton("查看");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		button.setBounds(329, 367, 113, 27);
		add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.setBounds(500, 367, 113, 27);
		add(button_1);
		
		
		
		

	}
	
}
