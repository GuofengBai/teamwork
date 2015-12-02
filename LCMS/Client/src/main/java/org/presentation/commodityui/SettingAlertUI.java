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
import org.vo.StaffVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingAlertUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private String centerNum;
	private StaffVO thisstaff;
	private SettingAlertBLService sabs;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public void showAlertLine() throws RemoteException {
		JLabel label = new JLabel("当前警报线");
		label.setBounds(90, 90, 119, 18);
		add(label);
		String line="";
		System.out.println(this.centerNum);;
		line=(String.valueOf(sabs.getAlert(this.centerNum)));
		JLabel alert = new JLabel(line);
		
		alert.setBounds(222, 99, 72, 18);
		add(alert);

	}

	public void setAlertLine() throws RemoteException {
		if (textField.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "请输入新的警戒线！", "",
					JOptionPane.ERROR_MESSAGE);
		} else if (Double.parseDouble(textField.getText()) > 100.0
				|| Double.parseDouble(textField.getText()) <= 0.0) {
			JOptionPane.showMessageDialog(null, "请输入一个0-100间的警报值！", "",
					JOptionPane.ERROR_MESSAGE);
		}

		else {
			double newline = Double.parseDouble(textField.getText());
			sabs.settingAlert(centerNum, newline);
		}
	}

	public SettingAlertUI() throws RemoteException {
		thisstaff = CurrentStaff.getStaff();
		sabs = BLFactory.getSettingAlertBL();
		//if (thisstaff.workSpace.type.equals("中转中心"))
		//	this.centerNum = thisstaff.workSpace.num;
		this.centerNum="0210001";
		showAlertLine();
		setLayout(null);

		JLabel lblNewLabel = new JLabel("警报设置");
		lblNewLabel.setBounds(222, 30, 74, 25);
		add(lblNewLabel);

		JLabel label_1 = new JLabel("重设警报线");
		label_1.setBounds(90, 160, 88, 18);
		add(label_1);

		textField = new JTextField();
		textField.setBounds(222, 157, 86, 24);
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
		button.setBounds(219, 328, 113, 27);
		add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回上级页面
			}
		});
		button_1.setBounds(422, 328, 113, 27);
		add(button_1);

	}
}
