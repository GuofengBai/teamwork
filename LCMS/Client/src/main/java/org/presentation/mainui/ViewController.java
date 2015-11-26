package org.presentation.mainui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewController {
	
	public static JFrame main;
	
	public static void init(JFrame o){
		main=o;
	}
	
	public static void jumpToAnotherView(JPanel o){
		main.setContentPane(o);
		main.setVisible(true);
	}

}