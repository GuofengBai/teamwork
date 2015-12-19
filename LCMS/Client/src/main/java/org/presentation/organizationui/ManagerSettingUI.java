package org.presentation.organizationui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.presentation.mainui.ViewController;
import java.awt.Font;

public class ManagerSettingUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel superView;
	private JPanel temp;
	
	public ManagerSettingUI(JPanel su) {
		super();
		this.superView=su;
		this.temp=this;
		setLayout(null);
		
		JButton jump = new JButton("返回");
		jump.setBounds(802, 31, 69, 49);
		add(jump);
		jump.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ViewController.jumpToAnotherView(superView);
				
			}
		});
		
		JLabel label = new JLabel("经营参数设置");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(308, 91, 268, 64);
		add(label);
		
		JButton cad = new JButton("城市距离设置");
		cad.setBounds(355, 278, 174, 109);
		add(cad);
		cad.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new SetCityDistanceUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton exp = new JButton("快递运费设置");
		exp.setBounds(355, 475, 174, 109);
		add(exp);
		exp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new SetExpressFeeUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
		
		JButton trans = new JButton("载具运费设置");
		trans.setBounds(355, 671, 174, 109);
		add(trans);
		trans.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JPanel next=new SetTransFeeUI(temp);
				ViewController.jumpToAnotherView(next);
				
			}
		});
	}

}
