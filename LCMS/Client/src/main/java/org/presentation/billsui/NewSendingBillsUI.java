package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class NewSendingBillsUI extends JPanel {
	private JTextField sendername;
	private JTextField senderphone;
	private JTextField senderlocation;
	private JTextField receivername;
	private JTextField receiverphone;
	private JTextField receicerlocation;
	private JTextField newyear;
	private JTextField newmonth;
	private JTextField newday;
	private JLabel label_7;
	private JTextField goodsnumber;
	private JLabel label_8;
	private JTextField length;
	private JTextField width;
	private JTextField height;
	private JTextField weight;

	/**
	 * Create the panel.
	 */
	public NewSendingBillsUI() {
		setLayout(null);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA\u59D3\u540D");
		label.setBounds(10, 10, 65, 15);
		add(label);
		
		JLabel label_1 = new JLabel("\u5BC4\u4EF6\u4EBA\u7535\u8BDD");
		label_1.setBounds(10, 35, 65, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC4\u4EF6\u4EBA\u4F4F\u5740");
		label_2.setBounds(10, 60, 65, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u6536\u4EF6\u4EBA\u59D3\u540D");
		label_3.setBounds(165, 10, 65, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u6536\u4EF6\u4EBA\u7535\u8BDD");
		label_4.setBounds(165, 35, 65, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("\u6536\u4EF6\u4EBA\u4F4F\u5740");
		label_5.setBounds(165, 60, 65, 15);
		add(label_5);
		
		sendername = new JTextField();
		sendername.setBounds(85, 7, 70, 21);
		add(sendername);
		sendername.setColumns(10);
		
		senderphone = new JTextField();
		senderphone.setColumns(10);
		senderphone.setBounds(85, 32, 70, 21);
		add(senderphone);
		
		senderlocation = new JTextField();
		senderlocation.setColumns(10);
		senderlocation.setBounds(85, 57, 70, 21);
		add(senderlocation);
		
		receivername = new JTextField();
		receivername.setColumns(10);
		receivername.setBounds(240, 7, 70, 21);
		add(receivername);
		
		receiverphone = new JTextField();
		receiverphone.setColumns(10);
		receiverphone.setBounds(240, 32, 70, 21);
		add(receiverphone);
		
		receicerlocation = new JTextField();
		receicerlocation.setColumns(10);
		receicerlocation.setBounds(240, 57, 70, 21);
		add(receicerlocation);
		
		JLabel label_6 = new JLabel("\u5BC4\u4EF6\u65E5\u671F");
		label_6.setBounds(10, 85, 54, 15);
		add(label_6);
		
		newyear = new JTextField();
		newyear.setBounds(85, 82, 80, 21);
		add(newyear);
		newyear.setColumns(10);
		
		newmonth = new JTextField();
		newmonth.setBounds(175, 82, 62, 21);
		add(newmonth);
		newmonth.setColumns(10);
		
		newday = new JTextField();
		newday.setBounds(248, 82, 62, 21);
		add(newday);
		newday.setColumns(10);
		
		label_7 = new JLabel("\u6258\u8FD0\u5355\u53F7");
		label_7.setBounds(10, 110, 54, 15);
		add(label_7);
		
		goodsnumber = new JTextField();
		goodsnumber.setBounds(85, 107, 225, 21);
		add(goodsnumber);
		goodsnumber.setColumns(10);
		
		label_8 = new JLabel("\u5FEB\u9012\u5F62\u5F0F");
		label_8.setBounds(10, 135, 54, 15);
		add(label_8);
		
		JComboBox sendtype = new JComboBox();
		sendtype.setBounds(85, 132, 70, 21);
		add(sendtype);
		sendtype.addItem("经济");
		sendtype.addItem("一般");
		sendtype.addItem("特快");
		
		JLabel label_9 = new JLabel("\u5305\u88C5\u5F62\u5F0F");
		label_9.setBounds(165, 135, 54, 15);
		add(label_9);
		
		JComboBox boxtype = new JComboBox();
		boxtype.setBounds(240, 132, 70, 21);
		add(boxtype);
		boxtype.addItem("纸袋");
		boxtype.addItem("纸箱");
		boxtype.addItem("木箱");
		
		JLabel label_10 = new JLabel("\u8D27\u7269\u5927\u5C0F\uFF08\u88C5\u7BB1\uFF09\u5355\u4F4D\uFF1A\u7C73");
		label_10.setBounds(10, 160, 145, 15);
		add(label_10);
		
		JLabel label_11 = new JLabel("\u957F");
		label_11.setBounds(10, 185, 20, 15);
		add(label_11);
		
		length = new JTextField();
		length.setBounds(40, 182, 65, 21);
		add(length);
		length.setColumns(10);
		
		JLabel label_12 = new JLabel("\u5BBD");
		label_12.setBounds(115, 185, 20, 15);
		add(label_12);
		
		width = new JTextField();
		width.setBounds(145, 182, 65, 21);
		add(width);
		width.setColumns(10);
		
		JLabel label_13 = new JLabel("\u9AD8");
		label_13.setBounds(220, 185, 20, 15);
		add(label_13);
		
		height = new JTextField();
		height.setBounds(245, 182, 65, 21);
		add(height);
		height.setColumns(10);
		
		JLabel label_14 = new JLabel("\u8D27\u7269\u91CD\u91CF");
		label_14.setBounds(10, 210, 54, 15);
		add(label_14);
		
		weight = new JTextField();
		weight.setBounds(74, 207, 66, 21);
		add(weight);
		weight.setColumns(10);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setBounds(145, 210, 54, 15);
		add(lblKg);
		
		JButton getprice = new JButton("\u8BA1\u7B97\u4EF7\u683C");
		getprice.setBounds(10, 235, 93, 23);
		add(getprice);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setBounds(115, 264, 93, 23);
		add(submit);
		
		JLabel presentvalue = new JLabel("");
		presentvalue.setBounds(122, 240, 182, 15);
		add(presentvalue);

	}
}
