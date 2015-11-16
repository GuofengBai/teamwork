package org.presentation.billsui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


public class CenterBusinessContralUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterBusinessContralUI() {
		setLayout(null);
		
		JLabel label = new JLabel("中转中心业务管理系统");
		label.setBounds(31, 10, 122, 15);
		add(label);
		
		JLabel label_1 = new JLabel("您可以选择以下操作");
		label_1.setBounds(10, 35, 113, 15);
		add(label_1);
		
		JButton button = new JButton("中转中心到达单生成");
		button.setBounds(20, 60, 141, 23);
		add(button);
		
		JButton button_1 = new JButton("中转中心中转单生成");
		button_1.setBounds(20, 93, 141, 23);
		add(button_1);
		
		JButton button_2 = new JButton("中转中心装车单生成");
		button_2.setBounds(20, 126, 141, 23);
		add(button_2);

	}
}
