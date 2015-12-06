package org.presentation.organizationui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.organizationblservice.ManagerSettingBLService;
import org.po.CityAndDistancePO;
import org.presentation.mainui.ViewController;

public class SetCityDistanceUI extends JPanel{
	
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;
	
	public SetCityDistanceUI(JPanel su) {
		super();
		this.superView=su;
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 128, 441, 280);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u57CE\u5E02\u8DDD\u79BB");
		label.setBounds(190, 72, 117, 21);
		add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(404, 23, 123, 29);
		add(button);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
			}
			
		});
		
		initModel();
		
	}

	private void initModel() {
		
		ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
		CityAndDistancePO cad=manager.getCad();
		
		model=new DefaultTableModel();
		model.setDataVector(cad.distance,cad.cities);
		table.setModel(model);
		
		model.addTableModelListener(new TableModelListener(){

			public void tableChanged(TableModelEvent arg0) {
				int row=arg0.getFirstRow();
				int column=arg0.getColumn();
				double distance=(Double) model.getValueAt(row, column);
				if((Double)model.getValueAt(column,row)!=distance){
				     model.setValueAt(distance,column,row);
				}
				String city1=model.getColumnName(row);
				String city2=model.getColumnName(column);
				
				
				ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
				manager.setCityDistance(city1, city2, distance);
				
			}
			
		});
	}
}
