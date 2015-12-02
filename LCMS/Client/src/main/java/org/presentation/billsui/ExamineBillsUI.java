package org.presentation.billsui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.ExamineBillsBLService;
import org.presentation.mainui.ViewController;

//�������ݵĽ���
public class ExamineBillsUI extends JPanel{
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;
	
	public ExamineBillsUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		init();
	}

	private void init() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 140, 408, 240);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ExamineBillsBLService examine=BLFactory.getExamineBillsBL();
		
		Vector<String> head=new Vector<String>();
		head.add("类型");
		head.add("编号");
		head.add("日期");
		
		Vector<Vector<String>> vData=examine.getAllUnExaminedBills();
		
		model=new DefaultTableModel(vData,head){
			public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		
		
		JButton btnNewButton = new JButton("审批选中单据");
		btnNewButton.setBounds(211, 408, 148, 29);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ExamineBillsBLService examine=BLFactory.getExamineBillsBL();
				int[] sel=table.getSelectedRows();
				for(int i=sel.length-1;i>-1;i--){
					System.out.println(sel[i]);
					examine.examineBills((String)model.getValueAt(sel[i],0),(String)model.getValueAt(sel[i],1));
					model.removeRow(sel[i]);
					model.fireTableRowsDeleted(sel[i],sel[i]);
				}
				
			}
			
		});
		
		
		
		JButton button = new JButton("返回");
		button.setBounds(365, 68, 123, 29);
		add(button);
		JPanel temp=this;
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
			}
			
		});
		
		
		
		
		
	}
}
