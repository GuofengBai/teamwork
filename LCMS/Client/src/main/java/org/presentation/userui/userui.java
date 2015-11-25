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

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.userblservice.UserBLService;
import org.po.ResultMessage;

public class UserUI extends JPanel {
	private JPasswordField passwordField;
	private JTextField textField;
	UserBLService ubs;

	/**
	 * Create the panel.
	 */
	public UserUI() {
		
		ubs=BLFactory.getUserBL();
		
		
		
		
		
		setLayout(null);

		JLabel label = new JLabel("登录");
		label.setBounds(222, 30, 72, 25);
		add(label);

		JLabel label_1 = new JLabel("用户名");
		label_1.setBounds(90, 90, 108, 18);
		add(label_1);

		JLabel label_2 = new JLabel("密码");
		label_2.setBounds(90, 160, 72, 18);
		add(label_2);

		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(218, 328, 113, 27);
		add(btnNewButton);

		JButton button = new JButton("返回");
		button.setBounds(422, 328, 113, 27);
		add(button);

		passwordField = new JPasswordField();
		passwordField.setBounds(192, 157, 152, 21);
		add(passwordField);

		textField = new JTextField();
		textField.setBounds(192, 87, 152, 24);
		add(textField);
		textField.setColumns(10);

	}

	private void login() throws HeadlessException, RemoteException {
		String account = textField.getText();
		char[] password = passwordField.getPassword();
		String pw = String.valueOf(password);
		//System.out.println(account+pw);

		if (!ubs.login(account, pw).success)
			JOptionPane.showMessageDialog(null, ubs.login(account, pw).info[1], ubs.login(account, pw).info[0],
					JOptionPane.ERROR_MESSAGE);
		else
			System.exit(0);
		//info[2]里储存了String类型的staffrole
	}
}
