package org.presentation.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;

public class OrganizationUI extends JPanel{
	private JPanel superView;
	private JPanel temp;
	
	public OrganizationUI(JPanel su) {
		super();
		this.superView=su;
		this.temp=this;
		setLayout(null);
		
		JLabel label = new JLabel("机构管理");
		label.setBounds(197, 47, 81, 21);
		add(label);
		
		JButton jump = new JButton("返回");
		jump.setBounds(360, 15, 123, 29);
		add(jump);
		jump.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
		
		JButton hall = new JButton("营业厅管理");
		hall.setBounds(175, 147, 123, 29);
		add(hall);
		hall.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HallUI next=new HallUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
			
		});

		
		JButton center = new JButton("中转中心管理");
		center.setBounds(175, 242, 141, 29);
		add(center);
		center.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CenterUI next=new CenterUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
			
		});
	}
}
