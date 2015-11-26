package org.presentation.staffui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;

public class GeneralManagerUI extends JPanel {
	
	JPanel superView;
	private JPanel temp=this;

	/**
	 * Create the panel.
	 */
	public GeneralManagerUI() {
		
		setLayout(null);
		
		JLabel label = new JLabel("\u603B\u7ECF\u7406\u754C\u9762");
		label.setBounds(214, 15, 90, 21);
		add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(478, 11, 75, 29);
		add(button);
		
		JButton staff = new JButton("\u4EBA\u5458\u7BA1\u7406");
		staff.setBounds(201, 131, 123, 29);
		
		staff.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JPanel staffList=new StaffListUI(temp);
				ViewController.jumpToAnotherView(staffList);
			}
			
		});
		add(staff);
		
		JButton organization = new JButton("\u673A\u6784\u7BA1\u7406");
		organization.setBounds(201, 196, 123, 29);
		add(organization);
		
		JButton manage = new JButton("\u7ECF\u8425\u53C2\u6570\u8BBE\u7F6E");
		manage.setBounds(201, 261, 141, 29);
		add(manage);
		
		JButton bills = new JButton("\u67E5\u770B\u8868\u5355");
		bills.setBounds(201, 332, 123, 29);
		add(bills);

		
		
	}
}
