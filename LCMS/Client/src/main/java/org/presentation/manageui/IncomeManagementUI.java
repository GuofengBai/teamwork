package org.presentation.manageui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.manageblservice.IncomeManagementBLService;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.IncomeBillVO;


public class IncomeManagementUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel = this;
	private JFrame frame;
	private JTextField searchDate;
	private JTextField searchHall;
	private JTable table;
	
	
	private Vector<IncomeBillVO> volist;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeManagementUI window = new IncomeManagementUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IncomeManagementUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		panel.setBounds(0, 0, 434, 312);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u7ED3\u7B97\u7BA1\u7406");
		label.setBounds(184, 10, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u65E5\u671F");
		label_1.setBounds(48, 51, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8425\u4E1A\u5385");
		label_2.setBounds(230, 51, 54, 15);
		panel.add(label_2);
		
		searchDate = new JTextField();
		searchDate.setBounds(111, 48, 66, 21);
		panel.add(searchDate);
		searchDate.setColumns(10);
		
		searchHall = new JTextField();
		searchHall.setBounds(297, 48, 66, 21);
		panel.add(searchHall);
		searchHall.setColumns(10);

		
		Vector<String> column = new Vector<String>();
		column.add("日期");
		column.add("金额");
		column.add("收款快递员");
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		model=new DefaultTableModel(volist,column);
		table.setModel(model);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
/**
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u65E5\u671F", "\u91D1\u989D", "\u6536\u6B3E\u5FEB\u9012\u5458"
			}
		));
*/

		table.setBounds(48, 102, 321, 101);
		//panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(48, 144, 321, 125);
		panel.add(scrollPane);
		
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.setBounds(88, 76, 93, 23);
		panel.add(searchButton);
		searchButton.addActionListener(new searchButtonListener());
		
		JButton backButton = new JButton("\u8FD4\u56DE");
		backButton.setBounds(270, 279, 93, 23);
		panel.add(backButton);
		
		JButton allButton = new JButton("合计");
		allButton.setBounds(240, 76, 93, 23);
		panel.add(allButton);
		allButton.addActionListener(new allButtonListener());
		
		JLabel label_3 = new JLabel("收款单列表");
		label_3.setBounds(48, 119, 73, 15);
		panel.add(label_3);
		backButton.addActionListener(new backButtonListener());
		
	}
	
	class searchButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String date=searchDate.getText();
			String hall=searchHall.getText();
			myDate mydate;
			if(date.equals("")){
				mydate=null;
			}else{
				mydate=new myDate(date);
			}

			IncomeManagementBLService im=BLFactory.getIncomeManagementBL();
			volist=im.incomeSearch(mydate, hall);
			
			for(IncomeBillVO row:volist){
				model.addRow(row);
			}
			
		}
		
	}
	
	class allButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			IncomeManagementBLService im=BLFactory.getIncomeManagementBL();
			volist=im.incomeSearch(null, "");
			for(IncomeBillVO row:volist){
				model.addRow(row);
			}
		}
		
	}
	
	class backButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FinacialStaffView ui=new FinacialStaffView();
			ViewController.jumpToAnotherView(ui);
		}
		
	}
}
