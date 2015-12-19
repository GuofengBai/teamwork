package org.presentation.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.presentation.mainui.ViewController;
import java.awt.Font;

public class OrganizationUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superView;
	private JPanel temp;
	
	public OrganizationUI(JPanel su) {
		super();
		this.superView=su;
		this.temp=this;
		setLayout(null);
		
		JLabel label = new JLabel("机构管理");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(311, 90, 181, 85);
		add(label);
		
		JButton jump = new JButton("返回");
		jump.setBounds(816, 26, 69, 52);
		add(jump);
		jump.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				ViewController.jumpToAnotherView(superView);
				
			}
			
		});
		
		JButton hall = new JButton("营业厅管理");
		hall.setBounds(298, 285, 231, 147);
		add(hall);
		hall.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				HallUI next=new HallUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
			
		});

		
		JButton center = new JButton("中转中心管理");
		center.setBounds(298, 583, 231, 147);
		add(center);
		center.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				CenterUI next=new CenterUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
			
		});
	}
}
