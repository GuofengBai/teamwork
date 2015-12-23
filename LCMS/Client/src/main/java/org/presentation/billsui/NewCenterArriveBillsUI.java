package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.mainui.ViewController;
import org.vo.CABVO;
import org.vo.StateListVO;
import java.awt.Font;


public class NewCenterArriveBillsUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superview;
	private JTextField newyear;
	private JTextField CABNum;
	private JTextField newday;
	private JTextField newmonth;
	private DefaultTableModel model;
	private JTable table;
	private JTextField GoodNum;
	private JTextField CenterNum;
	private JLabel suggest;
	ArrayList<StateListPO> list = new ArrayList<StateListPO>();
	NewCenterArriveBillsBLService bl = BLFactory.getNewCenterArriveBillsBL();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public NewCenterArriveBillsUI(JPanel superview) {
		this.superview = superview;
		panel();
		JButton Submit = new JButton("提交");
		Submit.setBounds(409, 746, 102, 45);
		add(Submit);
		
		JLabel label = new JLabel("新到达单");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(354, 25, 160, 118);
		add(label);
		
		Submit.addActionListener(new ActionListener(){

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
				CABVO bvo = new CABVO(date, CABNum.getText(), CenterNum.getText(), list);
				suggest.setText(bl.cherk(bvo));
				if(suggest.getText().equals("")){
					bl.addCenterArriveBills(bvo);
					suggest.setText("添加成功");					
				}
			}
			
		});
	}
	public NewCenterArriveBillsUI(JPanel superview,CABVO vo){
		this.superview = superview;
		panel();
		JButton Submit = new JButton("更新信息");
		Submit.setBounds(100, 260, 93, 23);
		add(Submit);
		Submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewCenterArriveBillsBLService bl = BLFactory.getNewCenterArriveBillsBL();
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				CABVO bvo = new CABVO(date, CABNum.getText(), CenterNum.getText(), list);
				bl.updateCenterArriveBills(bvo);
			}
			
		});
		newyear.setText(vo.date.year+"");
		newmonth.setText(vo.date.month+"");
		newday.setText(vo.date.day+"");
		CABNum.setText(vo.FreightNum);
		CenterNum.setText(vo.CenterNum);
		for(StateListPO po:vo.po){
			StateListVO list = new StateListVO(po);
			model.addRow(list);
		}
		this.list=vo.po;
	}
	private void panel(){
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5230\u8FBE\u65E5\u671F  ");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(81, 188, 112, 32);
		add(lblNewLabel);
		
		suggest = new JLabel("");
		suggest.setFont(new Font("宋体", Font.PLAIN, 22));
		suggest.setBounds(81, 746, 340, 39);
		add(suggest);
		
		newyear = new JTextField();
		newyear.setBounds(193, 196, 80, 21);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(312, 196, 80, 21);
		add(newmonth);
		newmonth.setColumns(8);
		
		newday = new JTextField();
		newday.setBounds(431, 196, 80, 21);
		add(newday);
		newday.setColumns(8);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(81, 367, 117, 32);
		add(lblNewLabel_1);
		
		CABNum = new JTextField();
		CABNum.setBounds(264, 375, 264, 21);
		add(CABNum);
		CABNum.setColumns(30);
		Vector<StateListVO> vo = new Vector<StateListVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("货物状态");
		model = new DefaultTableModel(vo,str);;
		
		
		JLabel label = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(81, 245, 112, 32);
		add(label);
		
		GoodNum = new JTextField();
		GoodNum.setBounds(264, 253, 264, 21);
		add(GoodNum);
		GoodNum.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D27\u7269\u72B6\u6001");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(81, 304, 93, 32);
		add(lblNewLabel_2);
		
		final JComboBox<String> State = new JComboBox<String>();
		State.setBounds(266, 301, 102, 45);
		add(State);
		State.addItem("完整");
		State.addItem("丢失");
		State.addItem("损坏");
		
		JButton AddGood = new JButton("\u6DFB\u52A0\u8D27\u7269");
		AddGood.setBounds(647, 364, 102, 45);
		add(AddGood);
		AddGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = GoodNum.getText();
				if(bl.search(CABNum.getText(), GoodNum.getText()).equals("")){
					String state = State.getSelectedItem().toString();
					StateListVO item = new StateListVO(num,state);
					StateListPO po = new StateListPO(num,state);
					list.add(po);				
					model.addRow(item);
					GoodNum.setText("");
					suggest.setText("");
				}else{
					suggest.setText(bl.search(CABNum.getText(), GoodNum.getText()));
				}				
			}
			
		});
		
		JLabel label_1 = new JLabel("到达单编号");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(81, 425, 112, 32);
		add(label_1);
		
		CenterNum = new JTextField();
		CenterNum.setBounds(264, 433, 264, 21);
		add(CenterNum);
		CenterNum.setColumns(10);
		
		JButton delete = new JButton("删除");
		delete.setBounds(647, 422, 102, 45);
		add(delete);
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				list.remove(dex);
				model.removeRow(dex);
				
				
			}
			
		});
		
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
		
		JButton back = new JButton("返回");
		back.setBounds(712, 64, 102, 45);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewController.jumpToAnotherView(superview);
			}
		});
	}
}

