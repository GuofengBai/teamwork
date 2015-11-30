package org.presentation.billsui;

import javax.swing.JFrame;

public class test {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		NewCenterArriveBillsUI ui = new NewCenterArriveBillsUI();
		frame.setContentPane(ui);
		frame.setVisible(true);
	}

}
