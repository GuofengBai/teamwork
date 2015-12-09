package org.presentation.manageui;

import java.rmi.RemoteException;

import javax.swing.JFrame;


import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.presentation.mainui.ViewController;

public class ManageUITest {
	public static void main(String[] args) throws RemoteException
    {
    	RMIHelper.init();




    	BLFactory.init();
		FinacialStaffView c=new FinacialStaffView();

    	JFrame f=new JFrame();
    	f.setSize(700, 700);
    	f.setContentPane(c);
    	f.setVisible(true);
        ViewController.init(f);
 //   	f.setSize(700, 700);
 //   	f.setVisible(true);
 //   	f.add(c);
//    	GeneralManagerUI manager=new GeneralManagerUI();
    	//ViewController.jumpToAnotherView();
    	
    	
    }
}
