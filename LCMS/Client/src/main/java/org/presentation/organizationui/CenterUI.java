package org.presentation.organizationui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Button;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.CenterBLService;
import org.businesslogicservice.organizationblservice.HallBLService;
import org.presentation.mainui.ViewController;
import org.vo.CenterVO;
import org.vo.HallVO;


public class CenterUI extends JPanel {
	private JTextField Name;
	private JTextField centerNum;
	private JTextField location;
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;

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
		
		JLabel lblNewLabel = new JLabel("中转中心管理");
		lblNewLabel.setBounds(239, 40, 108, 25);
		add(lblNewLabel);
		
		JLabel label = new JLabel("城市名称名称");
		label.setBounds(24, 106, 108, 18);
		add(label);
		
		Name = new JTextField();
		Name.setBounds(140, 103, 121, 24);
		add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(276, 106, 108, 18);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(397, 103, 150, 24);
		add(centerNum);
		centerNum.setColumns(10);
		
		initModel();
		initButton();

	}

	private void initButton() {
		JButton jump = new JButton("返回");
		jump.setBounds(460, 13, 114, 28);
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
				CenterVO vo=new CenterVO(Name.getText(),centerNum.getText(),location.getText());
				System.out.println(vo);
				CenterBLService centerBL=BLFactory.getCenterBL();
				if(centerBL.addCenter(vo)){
					model.addRow(vo);
					model.fireTableRowsInserted(model.getRowCount(),model.getRowCount());
				}
			}
			
		});
		
		
		
		JButton del = new JButton("删除");
		del.setBounds(224, 405, 123, 29);
		add(del);
		del.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CenterBLService centerBL=BLFactory.getCenterBL();
				int row=table.getSelectedRow();
				String centernum=(String) model.getValueAt(row,1);
				centerBL.delCenter(centernum);
				model.removeRow(row);
				model.fireTableRowsDeleted(row,row);
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
