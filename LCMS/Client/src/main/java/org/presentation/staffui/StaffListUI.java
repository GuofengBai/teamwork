package org.presentation.staffui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.presentation.mainui.ViewController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StaffListUI extends JPanel{
	
	public JPanel superView;
	private JPanel temp=this;
	
	private JTable table;
	private DefaultTableModel model;
	
	
	public StaffListUI(JPanel su) {
		super();
		superView=su;
		init();
	}
	
	public void init(){
		
		System.out.println("初始化");
        
		setLayout(null);
        
        initTable();
        
        initModel();
		
        initButton();
		
		JLabel label = new JLabel("\u5458\u5DE5\u5217\u8868");
		label.setBounds(42, 37, 81, 21);
		add(label);
		
		table.repaint();
		
		System.out.println("共"+model.getRowCount()+"行");
	}
	
	public void initTable(){
		
		System.out.println("初始化table");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 87, 433, 280);
		add(scrollPane);
		
		table=new JTable();
		
		scrollPane.setViewportView(table);
		
		
	}
	
	public void initModel(){
		
		System.out.println("初始化model");
		
		StaffBLService staffbl=BLFactory.getStaffBL();
		Vector<Vector<String>> data;
		data=staffbl.getListData();
		Vector<String> column = new Vector<String>();
		column.add("职位");
		column.add("姓名");
		column.add("员工编号");
		column.add("工作地点");
		
		model=new DefaultTableModel(data,column){
			public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	
	    table.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getButton()==MouseEvent.BUTTON1&&arg0.getClickCount()==2){
					int row =((JTable)arg0.getSource()).rowAtPoint(arg0.getPoint());
					System.out.println("选中第"+(row+1)+"行");
					StaffInfoUI next=new StaffInfoUI(temp,null);
					ViewController.jumpToAnotherView(next);
				}
				
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });;
	
	
	
	
	}
	
	public void initButton(){
		
		System.out.println("初始化button");

		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
			}
			
		});
		button.setBounds(352, 33, 123, 29);
		add(button);
		
		JButton button_1 = new JButton("\u65B0\u589E\u5458\u5DE5");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel next=new StaffInfoUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		button_1.setBounds(109, 400, 123, 29);
		add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664\u5458\u5DE5");
		button_2.setBounds(279, 400, 123, 29);
		button_2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StaffBLService staffBL=BLFactory.getStaffBL();
				int[] sel=table.getSelectedRows();
				for(int i=sel.length-1;i>-1;i--){
					System.out.println(sel[i]);
					staffBL.deleteStaff((String)model.getValueAt(sel[i],2));
					model.removeRow(sel[i]);
					model.fireTableRowsDeleted(sel[i],sel[i]);
				}
				
			}
			
		});
		add(button_2);
		
		System.out.println("初始化button完毕");
	}
	
	public void refresh(){
		initModel();
		table.repaint();
	}
}