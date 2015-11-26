package org.presentation.billsui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;
import org.vo.CommodityVO;


public class NewOutstorageBillsUI extends JPanel {
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JTextField entruckNum;
	private JTextField goodNum;
	private JTable table;
	private JButton submit;
	private JLabel lblNewLabel_1;
	private JTextField centerNum;
	DefaultTableModel model;
	private ArrayList<ComPO> compo = new ArrayList<ComPO>();
	private ArrayList<CommodityVO> comvo = new ArrayList<CommodityVO>();

	/**
	 * Create the panel.
	 */
	public NewOutstorageBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u51FA\u5E93\u65E5\u671F");
		label.setBounds(10, 13, 48, 15);
		add(label);
		
		newyear = new JTextField();
		newyear.setColumns(10);
		newyear.setBounds(63, 10, 66, 21);
		add(newyear);
		
		newmonth = new JTextField();
		newmonth.setColumns(10);
		newmonth.setBounds(134, 10, 66, 21);
		add(newmonth);
		
		newday = new JTextField();
		newday.setColumns(10);
		newday.setBounds(205, 10, 66, 21);
		add(newday);
		
		JLabel lblNewLabel = new JLabel("出库单编号");
		lblNewLabel.setBounds(10, 38, 60, 15);
		add(lblNewLabel);
		
		entruckNum = new JTextField();
		entruckNum.setBounds(80, 35, 191, 21);
		add(entruckNum);
		entruckNum.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6258\u8FD0\u5355\u7F16\u53F7");
		label_1.setBounds(10, 64, 60, 15);
		add(label_1);
		
		goodNum = new JTextField();
		goodNum.setBounds(80, 61, 191, 21);
		add(goodNum);
		goodNum.setColumns(10);
		
		JButton addGood = new JButton("\u6DFB\u52A0");
		addGood.setBounds(10, 89, 93, 23);
		add(addGood);
		addGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CommodityDataService service=null;
				ComPO cpo = null;
				try {
					service = RMIHelper.getDataFactory().getCommodityData();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cpo = service.findCom(goodNum.getText());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CommodityVO cvo = new CommodityVO(cpo.getGoodsNum(),cpo.getinDate(),cpo.getplace(),cpo.LocationNum(),cpo.getArea(),cpo.getcenterNum());
				model.addRow(cvo);
				comvo.add(cvo);
				compo.add(cpo);
				goodNum.setText("");
			}
			
		});
		
		
		JButton deleteGood = new JButton("\u5220\u9664");
		deleteGood.setBounds(113, 89, 93, 23);
		add(deleteGood);
		deleteGood.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dex = table.getSelectedRow();
				comvo.remove(dex);
				compo.remove(dex);
				model.removeRow(dex);
			}
			
		});
		
		Vector<CommodityVO> vo = new Vector<CommodityVO>();
		Vector<String> str = new Vector<String>();
		str.add("货物单号");
		str.add("日期");
		str.add("目的地");
		str.add("运输方式");
		str.add("区");
		str.add("排");
		str.add("架");
		str.add("位");
		str.add("中转中心编号");
		model = new DefaultTableModel(vo,str);;
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 145, 261, 87);
		add(scrollPane);
		
		submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(94, 242, 93, 23);
		add(submit);	
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myDate date = new myDate(Integer.parseInt(newyear.getText()),Integer.parseInt(newmonth.getText()),Integer.parseInt(newday.getText()));
				NewOutstorageBillsBLService bl = BLFactory.getNewOutstorageBillsBL();
				CommodityInAndOutBLService commodityInAndOutBL = BLFactory.getCommodityInAndOutBL();
				bl.addOutstorageBills(date, centerNum.getText(), entruckNum.getText(), comvo);
				for(int i=0;i<compo.size();i++){
					try {
						commodityInAndOutBL.Commodityin(compo.get(i));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				System.out.println("helloworld");
			}
			
		});
		
		lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(10, 122, 78, 15);
		add(lblNewLabel_1);
		
		centerNum = new JTextField();
		centerNum.setBounds(94, 119, 177, 21);
		add(centerNum);
		centerNum.setColumns(10);

	}
}
