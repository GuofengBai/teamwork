package org.presentation.commodityui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.text.View;

import org.presentation.mainui.ViewController;
import org.vo.StaffVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class StorageStaffView extends JPanel {
	private String centerNum;
	private JPanel panel = this;
	private StaffVO thisstaff;
	private JFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init() throws RemoteException{
		JButton btnNewButton = new JButton("库存查看");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamineCommodityUI ui = null;
				try {
					ui = new ExamineCommodityUI(panel);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ViewController.jumpToAnotherView(ui);

			}
		});
		btnNewButton.setBounds(231, 88, 113, 27);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("库存盘点");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckCommodityUI ui = new CheckCommodityUI(panel);
				ViewController.jumpToAnotherView(ui);
			}
		});
		btnNewButton_1.setBounds(231, 155, 113, 27);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("设置警报");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingAlertUI ui = null;
				try {
					ui = new SettingAlertUI(panel);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ViewController.jumpToAnotherView(ui);
			}
		});
		btnNewButton_2.setBounds(231, 222, 113, 27);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("库存调整");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DistrictChangeUI UI=null;
				try {
					UI = new DistrictChangeUI(panel);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ViewController.jumpToAnotherView(UI);
			}
		});
		btnNewButton_3.setBounds(231, 289, 113, 27);
		add(btnNewButton_3);

		JButton button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(429, 334, 113, 27);
		add(button);
	}

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public StorageStaffView() throws RemoteException {
		// thisstaff = CurrentStaff.getStaff();
		// if (thisstaff.workSpace.type.equals("中转中心"))
		// this.centerNum = thisstaff.workSpace.num;
		this.centerNum = "0210001";
		init();
		setLayout(null);

		JLabel label = new JLabel("中转中心仓库管理员");
		label.setBounds(231, 26, 142, 18);
		add(label);

		

	}
}
