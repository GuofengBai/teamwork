package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;





import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewHallArriveBillsBLService;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.HABVO;
import org.vo.StateListVO;
import java.awt.Font;


public class NewHallArriveBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField startPlace;
	private JTextField entruckNum;
	private JTable table;
	private JTextField goodNum;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	private DefaultTableModel model;
	private JTextField idNum;
	private JLabel suggest;
	NewHallArriveBillsBLService bl = BLFactory.getNewHallArriveBillsBL();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewHallArriveBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		
		JLabel label = new JLabel("新到达单");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);
		
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
				
				HABVO bvo = new HABVO(date,idNum.getText(),startPlace.getText(),entruckNum.getText(),list);
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.addHallArriveBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
	}
	public NewHallArriveBillsUI(JPanel superview,HABVO vo){
		this.superview = superview;
		panel();
		JButton submit = new JButton("更新");
		submit.setBounds(409, 746, 102, 45);
		add(submit);
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				
				HABVO bvo = new HABVO(date,idNum.getText(),startPlace.getText(),entruckNum.getText(),list);
				bl.updateHallArriveBills(bvo);
			}
			
		});
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		startPlace.setText(vo.startPlace);
		entruckNum.setText(vo.entruckNum);
		idNum.setText(vo.idNum);
		for(StateListPO po:vo.list){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
		this.list=vo.list;
	}
	private void panel(){
		setLayout(null);
		
		JLabel label = new JLabel("\u5230\u8FBE\u65E5\u671F  ");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 188, 112, 32);
		add(label);
		
		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(81, 746, 340, 39);
		add(suggest);
		
		newyear = new JTextField();
		newyear.setBounds(193, 196, 80, 21);
		newyear.setColumns(10);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setBounds(312, 196, 80, 21);
		newmonth.setColumns(8);
		add(newmonth);
		
		newday = new JTextField();
		newday.setBounds(431, 196, 80, 21);
		newday.setColumns(8);
		add(newday);
		
		JLabel label_1 = new JLabel("\u51FA\u53D1\u5730");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 304, 102, 32);
		add(label_1);
		
		startPlace = new JTextField();
		startPlace.setBounds(264, 312, 263, 21);
		add(startPlace);
		startPlace.setColumns(10);
		
		JLabel label_2 = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(81, 367, 159, 32);
		add(label_2);
		
		entruckNum = new JTextField();
		entruckNum.setBounds(264, 375, 263, 21);
		add(entruckNum);
		entruckNum.setColumns(10);
		
		JLabel label_3 = new JLabel("托运单号");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(388, 245, 112, 32);
		add(label_3);
		
		final JComboBox<String> goodState = new JComboBox<String>();
		goodState.setBounds(647, 306, 102, 45);
		add(goodState);
		goodState.addItem("完整");
		goodState.addItem("丢失");
		goodState.addItem("损坏");
		
		JButton addGood = new JButton("添加");
		addGood.setBounds(647, 364, 102, 45);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bl.search(goodNum.getText()).equals("")){
					String num = goodNum.getText();
					String state = goodState.getSelectedItem().toString();
					StateListVO item = new StateListVO(num,state);
					StateListPO po = new StateListPO(num,state);
					model.addRow(item);
					goodNum.setText("");
					list.add(po);
				}else{
					suggest.setText(bl.search(goodNum.getText()));
				}
				
			}
			
		});
		
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("货物状态");
		model = new DefaultTableModel(vo,str);;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 496, 668, 208);
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
		goodNum = new JTextField();
		goodNum.setBounds(499, 253, 250, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton deleteGood = new JButton("删除");
		deleteGood.setBounds(647, 422, 102, 45);
		add(deleteGood);
		
		JLabel label_4 = new JLabel("到达单编号");
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(81, 425, 140, 32);
		add(label_4);
		
		idNum = new JTextField();
		idNum.setBounds(264, 433, 263, 21);
		add(idNum);
		idNum.setColumns(10);
		
		JButton back = new JButton("返回");
		back.setBounds(712, 36, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
			}
			
		});
	}
}
