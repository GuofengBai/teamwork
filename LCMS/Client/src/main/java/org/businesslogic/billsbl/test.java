package org.businesslogic.billsbl;

import javax.swing.JFrame;

import org.presentation.billsui.NewSendingBillsUI;

public class test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		NewSendingBillsUI ui = new NewSendingBillsUI();
		frame.setContentPane(ui);
		frame.setVisible(true);
	
		
	}

}
