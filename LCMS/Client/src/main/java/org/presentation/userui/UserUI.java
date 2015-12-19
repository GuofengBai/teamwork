package org.presentation.userui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.JPasswordField;

import org.Client.CurrentStaff;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.businesslogicservice.userblservice.UserBLService;
import org.po.UserPO;
import org.presentation.billsui.BillsStateSearch;
import org.presentation.billsui.CenterBusinessContralUI;
import org.presentation.billsui.HallBusinessContralUI;
import org.presentation.billsui.PostmanUI;
import org.presentation.commodityui.StorageStaffView;
import org.presentation.mainui.ViewController;
import org.presentation.manageui.FinacialStaffView;
import org.presentation.staffui.GeneralManagerUI;
import org.vo.StaffVO;
import java.awt.Font;

public class UserUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textField;
	UserBLService ubs;
	StaffBLService sbs;
	private JPanel panel = this;

	/**
	 * Create the panel.
	 */
	public UserUI() {

		ubs = BLFactory.getUserBL();
		sbs = BLFactory.getStaffBL();

		setLayout(null);

		JLabel label = new JLabel("登录");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(422, 198, 80, 64);
		add(label);

		JLabel label_1 = new JLabel("用户名");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(299, 356, 108, 27);
		add(label_1);

		JLabel label_2 = new JLabel("密码");
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(299, 451, 72, 27);
		add(label_2);

		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
					System.out.println("0");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(299, 623, 113, 53);
		add(btnNewButton);

		JButton button = new JButton("订单查询");
		button.setBounds(492, 623, 113, 53);
		add(button);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel ui = new BillsStateSearch(panel);
				ViewController.jumpToAnotherView(ui);
			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(453, 449, 152, 27);
		add(passwordField);

		textField = new JTextField();
		textField.setBounds(453, 356, 152, 27);
		add(textField);
		textField.setColumns(10);

	}

	private void login() throws HeadlessException, RemoteException {
		String account = textField.getText();
		char[] password = passwordField.getPassword();
		String pw = String.valueOf(password);

		if (!ubs.login(account, pw).success)
			JOptionPane.showMessageDialog(null, ubs.login(account, pw).info[1],
					ubs.login(account, pw).info[0], JOptionPane.ERROR_MESSAGE);
		else {
			UserPO po = ubs.getUser(account);
			StaffVO svo = sbs.findStaff(po.getNumber());
			if (svo == null) {
				JOptionPane.showMessageDialog(null, "该员工被删除", "请重新输入",
						JOptionPane.ERROR_MESSAGE);
			}
			CurrentStaff.setStaff(svo);
			if (svo.staffRole.getName().equals("快递员")) {
				ViewController.jumpToAnotherView(new PostmanUI(panel));
			} else if (svo.staffRole.getName().equals("营业厅业务员")) {
				ViewController.jumpToAnotherView(new HallBusinessContralUI(
						panel));
			} else if (svo.staffRole.getName().equals("中转中心业务员")) {
				ViewController.jumpToAnotherView(new CenterBusinessContralUI(
						panel));
			} else if (svo.staffRole.getName().equals("中转中心仓库管理员")) {
				ViewController.jumpToAnotherView(new StorageStaffView(panel));
			} else if (svo.staffRole.getName().equals("财务人员")) {
				ViewController.jumpToAnotherView(new FinacialStaffView(panel));
			} else if (svo.staffRole.getName().equals("总经理")) {
				ViewController.jumpToAnotherView(new GeneralManagerUI(panel));
			} else if (svo.staffRole.getName().equals("管理员")) {
				ViewController.jumpToAnotherView(new AdministratorUI(panel));
			}
		}

	}
}
