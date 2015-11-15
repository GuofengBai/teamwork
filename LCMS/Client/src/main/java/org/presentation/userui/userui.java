package org.presentation.userui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class UserUI extends JPanel {
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UserUI() {
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
}
