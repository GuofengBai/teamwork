package org.presentation.commodityui;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;



import org.Client.CurrentStaff;
import org.presentation.billsui.NewInstorageBillsUI;
import org.presentation.billsui.NewOutstorageBillsUI;
import org.presentation.mainui.ViewController;
import org.presentation.userui.UserUI;
import org.vo.StaffVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.awt.Font;

public class StorageStaffView extends JPanel {
	private JPanel panel = this;
	private StaffVO thisstaff;
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
		btnNewButton.setBounds(190, 186, 200, 80);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("库存盘点");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckCommodityUI ui = new CheckCommodityUI(panel);
				ViewController.jumpToAnotherView(ui);
			}
		});
		btnNewButton_1.setBounds(190, 353, 200, 80);
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
		btnNewButton_2.setBounds(190, 517, 200, 80);
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
		btnNewButton_3.setBounds(525, 517, 200, 80);
		add(btnNewButton_3);

		
	}

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public StorageStaffView(final JPanel newpanel) throws RemoteException {
		thisstaff = CurrentStaff.getStaff();
		if (thisstaff.workSpace.type.equals("中转中心")) {
		}
		init();
		setLayout(null);

		JLabel label = new JLabel("中转中心仓库管理员");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(264, 26, 360, 147);
		add(label);
		
		JButton btnNewButton_4 = new JButton("入库");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewInstorageBillsUI ui=new NewInstorageBillsUI(panel);
				ViewController.jumpToAnotherView(ui);
			}
		});
		btnNewButton_4.setBounds(525, 186, 200, 80);
		add(btnNewButton_4);
		
		JButton button = new JButton("出库");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewOutstorageBillsUI ui=new NewOutstorageBillsUI(panel);
				ViewController.jumpToAnotherView(ui);
			}
		});
		button.setBounds(525, 353, 200, 80);
		add(button);

		JButton button1 = new JButton("登出");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(new UserUI());
			}
		});
		button1.setBounds(643, 740, 102, 45);
		add(button1);

	}
}
