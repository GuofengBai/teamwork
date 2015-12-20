package org.presentation.commodityui;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.presentation.mainui.ViewController;
import org.vo.StaffVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SettingAlertUI extends JPanel {
	/**
	 * 
	 */
	private JPanel superpanel;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private String centerNum;
	private StaffVO thisstaff;
	private SettingAlertBLService sabs;
	private JLabel label;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public void showAlertLine() throws RemoteException {
		JLabel label = new JLabel("当前库存比例");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(284, 263, 132, 45);
		add(label);
		String line = "";
		line = (String.valueOf(sabs.getAlert(centerNum)));
		System.out.println(line);
		JLabel alert = new JLabel(line + "%");
		alert.setFont(new Font("宋体", Font.PLAIN, 22));
		alert.setBounds(474, 276, 72, 18);
		add(alert);
	}

	public boolean isNumber(String str) {
		if (str == null)
			return false;
		if (str.charAt(0) == '-')
			return false;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9)
					&& str.charAt(i) != '.')
				return false;

		}
		return true;
	}

	public void setAlertLine() throws RemoteException {
		String line = "";
		line = textField.getText();
		double newline = 70;
		if (isNumber(line)) {

			newline = Double.parseDouble(textField.getText());
		} else {
			label.setText("请输入一个0-100间的警报值！");
			return;
		}
		if ((newline > 100 || newline < 0)) {
			label.setText("请输入一个0-100间的警报值！");
		} else {
			label.setText("设置成功");
			sabs.settingAlert(centerNum, newline);
		}
	}

	public SettingAlertUI(JPanel ui) throws RemoteException {
		thisstaff = CurrentStaff.getStaff();
		sabs = BLFactory.getSettingAlertBL();
		if (thisstaff.workSpace.type.equals("中转中心"))
			this.centerNum = thisstaff.workSpace.num;
		this.superpanel = ui;
		// this.centerNum = "0210001";
		showAlertLine();
		setLayout(null);

		JLabel lblNewLabel = new JLabel("警报设置");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel.setBounds(354, 25, 160, 118);
		add(lblNewLabel);

		JLabel label_1 = new JLabel("重设警报线");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(284, 343, 160, 45);
		add(label_1);

		textField = new JTextField();
		textField.setBounds(474, 356, 86, 24);
		add(textField);
		textField.setColumns(10);

		JButton button = new JButton("保存");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setAlertLine();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(383, 603, 102, 45);
		add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superpanel);
			}
		});
		button_1.setBounds(716, 64, 102, 45);
		add(button_1);

		label = new JLabel("");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(129, 758, 451, 38);
		add(label);

	}
}
