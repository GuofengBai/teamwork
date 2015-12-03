package org.presentation.commodityui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class STORAGESTAFF extends JPanel {

	/**
	 * Create the panel.
	 */
	public STORAGESTAFF() {
		setLayout(null);
		
		JLabel label = new JLabel("中转中心仓库管理员");
		label.setBounds(231, 26, 142, 18);
		add(label);
		
		JButton btnNewButton = new JButton("库存查看");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(231, 88, 113, 27);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("库存盘点");
		btnNewButton_1.setBounds(231, 155, 113, 27);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("设置警报");
		btnNewButton_2.setBounds(231, 222, 113, 27);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("库存调整");
		btnNewButton_3.setBounds(231, 289, 113, 27);
		add(btnNewButton_3);
		
		JButton button = new JButton("返回");
		button.setBounds(429, 334, 113, 27);
		add(button);

	}
}
