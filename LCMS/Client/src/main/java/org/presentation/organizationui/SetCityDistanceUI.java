package org.presentation.organizationui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;

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
import javax.swing.JTextField;
import java.awt.Font;

public class SetCityDistanceUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JPanel superView;
	private JTextField cityA;
	private JTextField cityB;
	private JTextField newDistance;
	private JLabel stateBar;
	
	public SetCityDistanceUI(JPanel su) {
		super();
		this.superView=su;
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 178, 780, 367);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u8BBE\u7F6E\u57CE\u5E02\u8DDD\u79BB");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(306, 77, 262, 66);
		add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(816, 25, 69, 52);
		add(button);
		
		JLabel lbla = new JLabel("城市A");
		lbla.setBounds(262, 599, 81, 21);
		add(lbla);
		
		cityA = new JTextField();
		cityA.setBounds(335, 596, 117, 27);
		add(cityA);
		cityA.setColumns(10);
		
		JLabel lblb = new JLabel("城市B");
		lblb.setBounds(467, 599, 81, 21);
		add(lblb);
		
		cityB = new JTextField();
		cityB.setBounds(529, 596, 129, 27);
		add(cityB);
		cityB.setColumns(10);
		
		JLabel label_1 = new JLabel("新距离");
		label_1.setBounds(262, 674, 81, 21);
		add(label_1);
		
		newDistance = new JTextField();
		newDistance.setBounds(335, 671, 323, 27);
		add(newDistance);
		newDistance.setColumns(10);
		
		stateBar = new JLabel("");
		stateBar.setBounds(63, 840, 780, 21);
		add(stateBar);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
			}
			
		});
		
		initModel();
		
		JButton submit = new JButton("修改");
		submit.setBounds(388, 743, 123, 52);
		add(submit);
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String city1=cityA.getText();
				String city2=cityB.getText();
				
				
				int i=-1,j=-1,k;
				for(k=0;k<model.getColumnCount();k++){
					if(model.getColumnName(k).equals(city1)){
						i=k;
						break;
					}
				}
				if(i<0){
					stateBar.setText("城市A错误");
					return;
				}
				
				for(k=0;k<model.getColumnCount();k++){
					if(model.getColumnName(k).equals(city2)){
						j=k;
						break;
					}
				}
				if(j<0){
					stateBar.setText("城市B错误");
					return;
				}
				
				if(i==j){
					stateBar.setText("失败，同一城市内距离默认为30公里");
					return;
				}
				
				double dis;
				try{
					dis=Double.parseDouble(newDistance.getText());
				}catch(Exception exc){
					stateBar.setText("新距离距离看可能不是数字，请再输入");
					return;
				};
				
				ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
				
				if(manager.setCityDistance(city1, city2, dis)){
					stateBar.setText("设置成功");
					model.setValueAt(dis,i,j);
					model.setValueAt(dis,j,i);
				}else{
					stateBar.setText("设置失败");
				}
				
			}
		});
		
	}

	private void initModel() {
		
		ManagerSettingBLService manager=BLFactory.getManagerSettingBL();
		CityAndDistancePO cad=manager.getCad();
		
		model=new DefaultTableModel();
		model.setDataVector(cad.distance,cad.cities);
		table.setModel(model);
		
	}
}
