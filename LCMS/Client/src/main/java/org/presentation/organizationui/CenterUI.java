package org.presentation.organizationui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;



import java.awt.Color;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.po.ResultMessage;
import org.presentation.mainui.ViewController;
import org.vo.CenterVO;
import java.awt.Font;



public class CenterUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Name;
	private JTextField centerNum;
	private JTextField location;
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;
	private JLabel stateBar;

	/**
	 * Create the panel.
	 */
	public CenterUI(JPanel su) {
		
		super();
		this.superView=su;
		init();
		
	}

	private void init() {
        setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 394, 762, 332);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(24, 365, 845, 2);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("详细地址");
		lblNewLabel_2.setBounds(66, 255, 81, 21);
		add(lblNewLabel_2);
		
		location = new JTextField();
		location.setBounds(177, 253, 651, 25);
		add(location);
		location.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(24, 153, 845, 2);
		add(separator_1);
		
		JLabel lblNewLabel = new JLabel("中转中心管理");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(284, 60, 240, 61);
		add(lblNewLabel);
		
		JLabel label = new JLabel("城市名称名称");
		label.setBounds(66, 186, 108, 18);
		add(label);
		
		Name = new JTextField();
		Name.setBounds(189, 183, 195, 24);
		add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(399, 186, 108, 18);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(527, 183, 301, 24);
		add(centerNum);
		centerNum.setColumns(10);
		
		stateBar = new JLabel("");
		stateBar.setBounds(66, 826, 762, 21);
		add(stateBar);
		
		initModel();
		initButton();

	}

	private void initButton() {
		JButton jump = new JButton("返回");
		jump.setBounds(800, 32, 69, 50);
		add(jump);
		jump.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
		
		JButton submit = new JButton("新增");
		submit.setBounds(741, 312, 87, 38);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CenterVO vo=new CenterVO(Name.getText(),centerNum.getText(),location.getText());
				CenterBLService centerBL=BLFactory.getCenterBL();
				ResultMessage re=centerBL.addCenter(vo);
				if(re.success){
					model.addRow(vo);
					model.fireTableRowsInserted(model.getRowCount(),model.getRowCount());
					stateBar.setText("新增成功");
				}else{
					stateBar.setText(re.info[0]);
				}
			}
			
		});
		
		
		
		JButton del = new JButton("删除");
		del.setBounds(375, 741, 123, 50);
		add(del);
		del.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CenterBLService centerBL=BLFactory.getCenterBL();
				int row=table.getSelectedRow();
				if(row<0){
					stateBar.setText("请选中一行");
					return;
				}
				
				String centernum=(String) model.getValueAt(row,1);
				ResultMessage re=centerBL.delCenter(centernum);
				if(re.success){
					model.removeRow(row);
					model.fireTableRowsDeleted(row,row);
					stateBar.setText("删除成功");
				}else{
					stateBar.setText(re.info[0]);
				}
				
			}
			
		});
	}

	private void initModel() {
		
		Vector<String> column=new Vector<String>();
		column.add("城市名称");
		column.add("城市编号");
		column.add("具体地址");
		
		CenterBLService centerBL=BLFactory.getCenterBL();
		Vector<CenterVO> vData=centerBL.getList();
		
		model=new DefaultTableModel(vData,column);
		
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
	}
}
