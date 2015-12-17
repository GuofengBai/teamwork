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
		scrollPane.setBounds(24, 219, 524, 171);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(18, 212, 540, 2);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("详细地址");
		lblNewLabel_2.setBounds(24, 139, 81, 21);
		add(lblNewLabel_2);
		
		location = new JTextField();
		location.setBounds(129, 139, 420, 25);
		add(location);
		location.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(18, 80, 540, 2);
		add(separator_1);
		
		JLabel lblNewLabel = new JLabel("营业厅管理");
		lblNewLabel.setBounds(224, 15, 108, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("营业厅名称");
		label.setBounds(24, 106, 108, 18);
		add(label);
		
		hallName = new JTextField();
		hallName.setBounds(129, 103, 121, 24);
		add(hallName);
		hallName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("营业厅编号");
		lblNewLabel_1.setBounds(287, 106, 108, 18);
		add(lblNewLabel_1);
		
		hallNum = new JTextField();
		hallNum.setBounds(397, 103, 150, 24);
		add(hallNum);
		hallNum.setColumns(10);
		
		JLabel label_1 = new JLabel("所在城市");
		label_1.setBounds(24, 175, 72, 18);
		add(label_1);
		
		cityName = new JTextField();
		cityName.setBounds(129, 172, 121, 24);
		add(cityName);
		cityName.setColumns(10);
		
		stateBar = new JLabel("");
		stateBar.setBounds(24, 469, 524, 21);
		add(stateBar);
		
		initModel();
		initButton();

	}

	private void initButton() {
		JButton jump = new JButton("返回");
		jump.setBounds(416, 37, 114, 28);
		add(jump);
		jump.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
		
		JButton submit = new JButton("新增");
		submit.setBounds(457, 175, 87, 25);
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
		del.setBounds(224, 405, 123, 29);
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
