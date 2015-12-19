package org.presentation.organizationui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.HallBLService;
import org.po.ResultMessage;
import org.presentation.mainui.ViewController;
import org.vo.HallVO;

import java.awt.Color;
import java.util.Vector;
import java.awt.Font;


public class HallUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField hallName;
	private JTextField hallNum;
	private JTextField cityName;
	private JLabel stateBar;
	private JTextField location;
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;

	/**
	 * Create the panel.
	 */
	public HallUI(JPanel su) {
		
		super();
		this.superView=su;
		init();
		
	}

	private void init() {
        setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 387, 775, 362);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(18, 370, 856, 2);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("详细地址");
		lblNewLabel_2.setBounds(60, 213, 81, 21);
		add(lblNewLabel_2);
		
		location = new JTextField();
		location.setBounds(165, 211, 670, 25);
		add(location);
		location.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(18, 126, 856, 2);
		add(separator_1);
		
		JLabel lblNewLabel = new JLabel("营业厅管理");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(341, 42, 206, 53);
		add(lblNewLabel);
		
		JLabel label = new JLabel("营业厅名称");
		label.setBounds(60, 157, 108, 18);
		add(label);
		
		hallName = new JTextField();
		hallName.setBounds(183, 154, 229, 24);
		add(hallName);
		hallName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("营业厅编号");
		lblNewLabel_1.setBounds(439, 157, 108, 18);
		add(lblNewLabel_1);
		
		hallNum = new JTextField();
		hallNum.setBounds(562, 154, 273, 24);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_1 = new JLabel("所在城市");
		label_1.setBounds(60, 269, 72, 18);
		add(label_1);
		
		cityName = new JTextField();
		cityName.setBounds(165, 266, 670, 24);
		add(cityName);
		cityName.setColumns(10);
		
		stateBar = new JLabel("");
		stateBar.setBounds(60, 843, 775, 21);
		add(stateBar);
		
		initModel();
		initButton();

	}

	private void initButton() {
		JButton jump = new JButton("返回");
		jump.setBounds(805, 28, 69, 53);
		add(jump);
		jump.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
		
		JButton submit = new JButton("新增");
		submit.setBounds(748, 311, 87, 44);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HallVO vo=new HallVO(hallName.getText(),hallNum.getText(),cityName.getText(),location.getText());
				HallBLService hallBL=BLFactory.getHallBL();
				
				ResultMessage re=hallBL.addHall(vo);
				if(re.success){
					model.addRow(vo);
					model.fireTableRowsInserted(model.getRowCount(),model.getRowCount());
					stateBar.setText("添加成功");
				}else{
					stateBar.setText(re.info[0]);
				}
			}
			
		});
		
		
		
		JButton del = new JButton("删除");
		del.setBounds(385, 764, 123, 44);
		add(del);
		del.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HallBLService hallBL=BLFactory.getHallBL();
				int row=table.getSelectedRow();
				if(row<0){
					stateBar.setText("请选中一行");
				}
				
				String hallnum=(String) model.getValueAt(row,1);
				ResultMessage re=hallBL.delHall(hallnum);
				if(re.success){
					model.removeRow(row);
					model.fireTableRowsDeleted(row,row);
					stateBar.setText(re.info[0]);
				}
				
			}
			
		});
	}

	private void initModel() {
		
		Vector<String> column=new Vector<String>();
		column.add("营业厅名称");
		column.add("营业厅编号");
		column.add("所在城市");
		column.add("具体地址");
		
		HallBLService hallBL=BLFactory.getHallBL();
		Vector<HallVO> vData=hallBL.getList();
		
		model=new DefaultTableModel(vData,column);
		
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
	}
}
