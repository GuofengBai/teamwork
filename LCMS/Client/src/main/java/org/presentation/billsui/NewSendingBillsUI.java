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

import org.po.BOXSTYPE;

public class NewSendingBillsUI {

	public static void main(String[] args) {

		final JComboBox<String> boxtype;
		final JComboBox<String> sendtype;
		JFrame jFrame = new JFrame("生成寄件单");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setBounds(((int) dimension.getWidth() - 400) / 2,
				((int) dimension.getHeight() - 300) / 2, 400, 300);
		jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boxtype = new JComboBox<String>();
		sendtype = new JComboBox<String>();
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

		JLabel label6 = new JLabel("请选择包装类型");
		label6.setBounds(10, 160, 250, 30);
		jFrame.add(label6);

		JLabel label7 = new JLabel("请选择快递类型");
		label7.setBounds(10, 190, 250, 30);
		jFrame.add(label7);

		boxtype.setBounds(120, 165, 260, 20);
		jFrame.add(boxtype);
		
		sendtype.setBounds(120, 195, 260, 20);
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
		
		JButton buttonx = new JButton("显示价格");
		buttonx.setBounds(10, 230, 180, 20);
		buttonx.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "10086", "价格", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		jFrame.add(buttonx);

		JButton button = new JButton("提交");
		button.setBounds(200, 230, 180, 20);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
					JOptionPane.showMessageDialog(null, "寄件单生成", "提示", JOptionPane.INFORMATION_MESSAGE);
				
					JOptionPane.showMessageDialog(null, "错误", "提示", JOptionPane.ERROR_MESSAGE);
				
			}
			
				

				
			
		});
		jFrame.add(button);

		jFrame.setVisible(true);
	}

}