package org.presentation.staffui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.billsui.ExamineBillsUI;
import org.presentation.mainui.ViewController;
import org.presentation.manageui.IncomeTableUI;
import org.presentation.manageui.StatusTableUI;
import org.presentation.organizationui.ManagerSettingUI;
import org.presentation.organizationui.OrganizationUI;
import java.awt.Font;

public class GeneralManagerUI extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(341, 105, 209, 103);
		add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setBounds(792, 30, 75, 65);
		add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
				
			}
		});
		
		JButton staff = new JButton("\u4EBA\u5458\u7BA1\u7406");
		staff.setBounds(187, 478, 143, 111);
		
		staff.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JPanel next=new StaffListUI(temp);
				ViewController.jumpToAnotherView(next);
			}
			
		});
		add(staff);
		
		JButton organization = new JButton("\u673A\u6784\u7BA1\u7406");
		organization.setBounds(187, 667, 143, 111);
		add(organization);
		organization.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JPanel next=new OrganizationUI(temp);
				ViewController.jumpToAnotherView(next);
			}
			
		});
		
		JButton manage = new JButton("\u7ECF\u8425\u53C2\u6570\u8BBE\u7F6E");
		manage.setBounds(565, 288, 159, 111);
		add(manage);
		manage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new ManagerSettingUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton incomeTable = new JButton("查看成本收益表");
		incomeTable.setBounds(565, 478, 159, 111);
		add(incomeTable);
		incomeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel next=new IncomeTableUI(temp);
				ViewController.jumpToAnotherView(next);
			}
		});
		
		
		JButton statusTable = new JButton("查看经营情况表");
		statusTable.setBounds(565, 667, 159, 111);
		add(statusTable);
		statusTable.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new StatusTableUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton examine = new JButton("审批单据");
		examine.setBounds(187, 288, 143, 111);
		add(examine);
		examine.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				JPanel next=new ExamineBillsUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
			
		});

		
		
	}
}
