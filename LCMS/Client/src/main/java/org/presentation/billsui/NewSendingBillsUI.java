package org.presentation.billsui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.businesslogic.billsbl.NewSendingBillsBL;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;

public class NewSendingBillsUI {
	
	NewSendingBillsBLService newSendingBills;

	public void run() {
		
		newSendingBills=new NewSendingBillsBL();

		final JComboBox<String> boxtype;
		final JComboBox<String> sendtype;
		JFrame jFrame = new JFrame("生成寄件单");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds(((int) dimension.getWidth() - 400) / 2,
				((int) dimension.getHeight() - 330) / 2, 400, 330);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boxtype = new JComboBox<String>();
		sendtype = new JComboBox<String>();
		final myDate Date =new myDate();
		String[] box = { "纸袋", "木箱", "纸箱" };
		String[] type = { "经济", "标准", "特快" };
		if (box.length > 0) {
			for (int i = 0; i < box.length; i++) {
				boxtype.addItem(box[i]);
			}
		}
		boxtype.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selected1 = (String) boxtype.getSelectedItem();
					
				}
			}

		});
		if (type.length > 0) {
			for (int i = 0; i < type.length; i++) {
				sendtype.addItem(type[i]);
			}
		}
		sendtype.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selected2 = (String) sendtype.getSelectedItem();

				}
			}

		});

		JLabel label1 = new JLabel("请输入订单条形码");
		label1.setBounds(10, 10, 250, 30);
		jFrame.add(label1);

		JLabel label2 = new JLabel("请输入寄件人城市");
		label2.setBounds(10, 40, 250, 30);
		jFrame.add(label2);

		JLabel label3 = new JLabel("请输入收件人城市");
		label3.setBounds(10, 70, 250, 30);
		jFrame.add(label3);

		JLabel label4 = new JLabel("请输入收件人姓名");
		label4.setBounds(10, 100, 250, 30);
		jFrame.add(label4);

		JLabel label5 = new JLabel("请输入收件人住址");
		label5.setBounds(10, 130, 250, 30);
		jFrame.add(label5);
		
		JLabel label8 = new JLabel("请输入寄件日期");
		label8.setBounds(10, 160, 250, 30);
		jFrame.add(label8);

		JLabel label6 = new JLabel("请选择包装类型");
		label6.setBounds(10, 190, 250, 30);
		jFrame.add(label6);

		JLabel label7 = new JLabel("请选择快递类型");
		label7.setBounds(10, 220, 250, 30);
		jFrame.add(label7);

		boxtype.setBounds(120, 195, 260, 20);
		jFrame.add(boxtype);
		
		sendtype.setBounds(120, 225, 260, 20);
		jFrame.add(sendtype);

		final JTextField text1 = new JTextField();
		text1.setBounds(120, 15, 260, 20);
		jFrame.add(text1);

		final JTextField text2 = new JTextField();
		text2.setBounds(120, 45, 260, 20);
		jFrame.add(text2);

		final JTextField text3 = new JTextField();
		text3.setBounds(120, 75, 260, 20);
		jFrame.add(text3);

		final JTextField text4 = new JTextField();
		text4.setBounds(120, 105, 260, 20);
		jFrame.add(text4);

		final JTextField text5 = new JTextField();
		text5.setBounds(120, 135, 260, 20);
		jFrame.add(text5);
		
		final JTextField text6 = new JTextField();
		text6.setBounds(120, 165, 100, 20);
		jFrame.add(text6);
		
		final JTextField text7 = new JTextField();
		text7.setBounds(230, 165, 70, 20);
		jFrame.add(text7);
		
		final JTextField text8 = new JTextField();
		text8.setBounds(310, 165, 70, 20);
		jFrame.add(text8);
		
		JButton buttonx = new JButton("显示价格");
		buttonx.setBounds(10, 255, 180, 20);
		buttonx.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "10086", "价格", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		jFrame.add(buttonx);

		JButton button = new JButton("提交");
		button.setBounds(200, 255, 180, 20);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Date.year=Integer.parseInt(text6.getText());
				Date.month=Integer.parseInt(text7.getText());
				Date.day=Integer.parseInt(text8.getText());
				
				String selected1=(String) boxtype.getSelectedItem();
				String selected2=(String) sendtype.getSelectedItem();
				BOXSTYPE boxstype=BOXSTYPE.Paper;
				SENDSTYPE sendstype=SENDSTYPE.SLOW;
				if(selected1.equals("纸箱")){
					boxstype=BOXSTYPE.Paper;
				}
				if(selected1.equals("纸袋")){
					boxstype=BOXSTYPE.Bag;
				}
				if(selected1.equals("木箱")){
					boxstype=BOXSTYPE.Box;
				}
				if(selected2.equals("经济")){
					sendstype=SENDSTYPE.SLOW;
				}
				if(selected2.equals("标准")){
					sendstype=SENDSTYPE.NORMAL;
				}
				if(selected2.equals("特快")){
					sendstype=SENDSTYPE.FAST;
				}
				
				
				
				ResultMessage message=newSendingBills.newSendingBill(Date, boxstype, sendstype,text2.getText(),
						text3.getText(), text5.getText(), Long.parseLong(text1.getText()), text4.getText(), 100);
				
					JOptionPane.showMessageDialog(null, "寄件单生成", "提示", JOptionPane.INFORMATION_MESSAGE);
					
					
				
			}
			
				

				
			
		});
		jFrame.add(button);

		jFrame.setVisible(true);
	}

}