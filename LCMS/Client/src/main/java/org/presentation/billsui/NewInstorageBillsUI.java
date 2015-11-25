package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import org.po.ComPO;
import org.po.myDate;
import org.vo.CommodityVO;
import org.vo.StateListVO;


public class NewInstorageBillsUI extends JPanel {
	private JTextField newday;
	private JTextField newmonth;
	private JTextField newyear;
	private JTextField goodNum;
	private JTextField place;
	private JTextField location;
	private JTable table;
	private JButton submit;
	private JComboBox area;
	DefaultTableModel model;
	private ArrayList<ComPO> compo = new ArrayList<ComPO>();
	private ArrayList<CommodityVO> comvo = new ArrayList<CommodityVO>();

	/**
	 * Create the panel.
	 */
	public NewInstorageBillsUI() {
		setLayout(null);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(205, 10, 66, 21);
		add(newday);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(134, 10, 66, 21);
		add(newmonth);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(63, 10, 66, 21);
		add(newyear);
		
		JLabel label = new JLabel("\u5165\u5E93\u65E5\u671F");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_1.setBounds(10, 38, 54, 15);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(63, 35, 208, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u76EE\u7684\u5730");
		lblNewLabel.setBounds(10, 63, 54, 15);
		add(lblNewLabel);
		
		place = new JTextField();
		place.setBounds(63, 60, 121, 21);
		add(place);
		place.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6446\u653E\u4F4D\u7F6E");
		label_2.setBounds(10, 88, 54, 15);
		add(label_2);
		
		location = new JTextField();
		location.setBounds(63, 85, 208, 21);
		add(location);
		location.setColumns(10);
		
		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(10, 113, 93, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String goodNumvo = goodNum.getText();
				String datevo = newyear.getText()+"/"+newmonth.getText()+"/"+newday.getText();
				myDate datepo = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				String placevo = place.getText();
				String locationvo = location.getText();
				String areavo = area.getSelectedItem().toString();
				ComPO cpo = new ComPO(goodNumvo,datepo,placevo,locationvo,areavo);
				CommodityVO cvo = new CommodityVO(goodNumvo,datevo,placevo,locationvo,areavo);
			}
			
		});
		
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(113, 113, 93, 23);
		add(deleteGood);
		
		Vector<CommodityVO> vo = new Vector<CommodityVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("日期");
		str.add("目的地");
		str.add("位置");
		str.add("区号");
		model = new DefaultTableModel(vo,str);
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
		table.setFillsViewportHeight(true);

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 147, 261, 79);
		add(scrollPane);
		
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(107, 236, 93, 23);
		add(submit);
		
		area = new JComboBox();
		area.setBounds(194, 60, 77, 21);
		add(area);
		area.addItem("汽运区");
		area.addItem("铁运区");
		area.addItem("空运区");

	}

}
