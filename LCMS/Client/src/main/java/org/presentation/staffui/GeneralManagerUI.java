package org.presentation.staffui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.billsui.ExamineBillsUI;
import org.presentation.mainui.ViewController;
import org.presentation.organizationui.ManagerSettingUI;
import org.presentation.organizationui.OrganizationUI;

public class GeneralManagerUI extends JPanel {
	
	JPanel superView;
	private JPanel temp=this;

	/**
	 * Create the panel.
	 */
	public GeneralManagerUI(JPanel su) {
		super();
		this.superView=su;
		setLayout(null);
		
		JLabel label = new JLabel("\u603B\u7ECF\u7406\u754C\u9762");
		label.setBounds(218, 63, 90, 21);
		add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(465, 15, 75, 29);
		add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
				
			}
		});
		
		JButton staff = new JButton("\u4EBA\u5458\u7BA1\u7406");
		staff.setBounds(201, 215, 123, 29);
		
		staff.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JPanel next=new StaffListUI(temp);
				ViewController.jumpToAnotherView(next);
			}
			
		});
		add(staff);
		
		JButton organization = new JButton("\u673A\u6784\u7BA1\u7406");
		organization.setBounds(201, 281, 123, 29);
		add(organization);
		organization.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JPanel next=new OrganizationUI(temp);
				ViewController.jumpToAnotherView(next);
			}
			
		});
		
		JButton manage = new JButton("\u7ECF\u8425\u53C2\u6570\u8BBE\u7F6E");
		manage.setBounds(201, 343, 141, 29);
		add(manage);
		manage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new ManagerSettingUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton bills = new JButton("\u67E5\u770B\u8868\u5355");
		bills.setBounds(201, 403, 123, 29);
		add(bills);
		
		JButton examine = new JButton("审批单据");
		examine.setBounds(201, 154, 123, 29);
		add(examine);
		examine.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JPanel next=new ExamineBillsUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
			
		});

		
		
	}
}
