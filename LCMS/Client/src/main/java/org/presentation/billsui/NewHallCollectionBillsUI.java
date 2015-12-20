package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallCollectBillsBLService;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.HCBVO;
import org.vo.StateListVO;


public class NewHallCollectionBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField name;
	private JTextField pay;
	private JTextField goodNum;
	private JTable table;
	private JButton submit;
	DefaultTableModel model;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private JLabel total;
	private JLabel label_4;
	private JTextField idNum;
	private JButton back;
	private JLabel suggest;
	NewHallCollectBillsBLService bl = BLFactory.getNewHallCollectBillsBL();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewHallCollectionBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		submit = new JButton("提交");
		submit.setBounds(20, 266, 93, 23);
		add(submit);
		
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//日期判断
				if(newyear.getText().equals("")||newmonth.getText().equals("")||newday.getText().equals("")){
					suggest.setText("信息未填写完整");
					return;
				}
				for(int i=0;i<newyear.getText().length();i++){
					if(newyear.getText().charAt(i)>'9'||newyear.getText().charAt(i)<'0'||i>=4){
						suggest.setText("年份输入错误");
						return;
					}		
				}
				for(int i=0;i<newmonth.getText().length();i++){
					if(newmonth.getText().charAt(i)>'9'||newmonth.getText().charAt(i)<'0'||i>=2){
						suggest.setText("月份输入错误");
						return;
					}		
				}
				for(int i=0;i<newday.getText().length();i++){
					if(newday.getText().charAt(i)>'9'||newday.getText().charAt(i)<'0'||i>=2){
						suggest.setText("日期输入错误");
						return;
					}					
				}
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				
				HCBVO bvo = new HCBVO(date,idNum.getText(), name.getText(),total.getText(),list);
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.addHallCollectionBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
	}
	public NewHallCollectionBillsUI(JPanel superview,HCBVO vo){
		this.superview = superview;
		panel();
		submit = new JButton("更新");
		submit.setBounds(90, 266, 93, 23);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				
				HCBVO bvo = new HCBVO(date,idNum.getText(), name.getText(),total.getText(),list);
				bl.updateHallCollectionBills(bvo);
			}
			
		});
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		idNum.setText(vo.idNum);
		name.setText(vo.name);
		total.setText(vo.total);
		for(StateListPO po:vo.list){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
		this.list=vo.list;
	}
	private void panel(){
		setLayout(null);
		
		suggest = new JLabel("");
		suggest.setBounds(10, 299, 249, 15);
		add(suggest);
		
		JLabel label = new JLabel("收款日期  ");
		label.setBounds(10, 13, 60, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(75, 10, 66, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(8);
		newmonth.setBounds(146, 10, 54, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(8);
		newday.setBounds(205, 10, 54, 21);
		add(newday);
		
		JLabel label_1 = new JLabel("收款金额");
		label_1.setBounds(10, 91, 54, 15);
		add(label_1);
		
		name = new JTextField();
		name.setBounds(75, 63, 184, 21);
		add(name);
		name.setColumns(10);
		
		JLabel label_2 = new JLabel("快递员姓名");
		label_2.setBounds(10, 66, 60, 15);
		add(label_2);
		
		pay = new JTextField();
		pay.setBounds(75, 88, 184, 21);
		add(pay);
		pay.setColumns(10);
		
		JLabel label_3 = new JLabel("托运单号");
		label_3.setBounds(10, 116, 54, 15);
		add(label_3);
		
		goodNum = new JTextField();
		goodNum.setBounds(75, 113, 184, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(135, 136, 60, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bl.search(goodNum.getText()).equals("")){
					if(pay.getText().equals("")){
						suggest.setText("收款金额不能为空");
						return;
					}
					String num = goodNum.getText();
					String price = pay.getText();
					total.setText(Integer.parseInt(total.getText())+Integer.parseInt(price)+"");
					StateListVO item = new StateListVO(num,price);
					StateListPO po = new StateListPO(num,price);
					model.addRow(item);
					goodNum.setText("");
					pay.setText("");
					list.add(po);
				}else{
					suggest.setText(bl.search(goodNum.getText()));
				}
								
			}
			
		});
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(199, 136, 60, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				total.setText(Integer.parseInt(total.getText())-Integer.parseInt(list.get(dex).getState())+"");
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("收款金额");
		model = new DefaultTableModel(vo,str);;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 249, 88);
		add(scrollPane);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		scrollPane.setViewportView(table);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);	
		JLabel lblNewLabel = new JLabel("总金额");
		lblNewLabel.setBounds(10, 141, 45, 15);
		add(lblNewLabel);
		
		total = new JLabel("0");
		total.setBounds(57, 141, 68, 18);
		add(total);
		
		label_4 = new JLabel("收款单号");
		label_4.setBounds(10, 38, 54, 15);
		add(label_4);
		
		idNum = new JTextField();
		idNum.setBounds(75, 35, 184, 21);
		add(idNum);
		idNum.setColumns(10);
		
		back = new JButton("返回");
		back.setBounds(146, 266, 93, 23);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
	}
}
