package org.presentation.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.presentation.mainui.ViewController;

public class ManagerSettingUI extends JPanel{
	private JPanel superView;
	private JPanel temp;
	
	public ManagerSettingUI(JPanel su) {
		super();
		this.superView=su;
		this.temp=this;
		setLayout(null);
		
		JButton jump = new JButton("返回");
		jump.setBounds(319, 15, 123, 29);
		add(jump);
		jump.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
				
			}
		});
		
		JLabel label = new JLabel("经营参数设置");
		label.setBounds(174, 74, 108, 21);
		add(label);
		
		JButton cad = new JButton("城市距离设置");
		cad.setBounds(158, 137, 141, 29);
		add(cad);
		cad.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new SetCityDistanceUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton exp = new JButton("快递运费设置");
		exp.setBounds(158, 213, 141, 29);
		add(exp);
		exp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new SetExpressFeeUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton trans = new JButton("载具运费设置");
		trans.setBounds(158, 298, 141, 29);
		add(trans);
		trans.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new SetTransFeeUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
	}

}
