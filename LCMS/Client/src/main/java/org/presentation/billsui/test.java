package org.presentation.billsui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.presentation.mainui.ViewController;

public class test {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JPanel pl = new JPanel();
		HallBusinessContralUI ui = new HallBusinessContralUI(pl);
		frame.setContentPane(ui);
		ViewController.init(frame);
		frame.setVisible(true);
	}

}
