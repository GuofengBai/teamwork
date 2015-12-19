package org.Client;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.businesslogic.blFactory.BLFactory;
import org.presentation.mainui.ViewController;
import org.presentation.userui.UserUI;


public class Client{
    public static void main(String[] args) throws RemoteException
    {
    	RMIHelper.init();
    	JPanel newUI=new UserUI();
    	BLFactory.init();
    	JFrame frame = new JFrame();
    	ViewController.init(frame);
    	frame.setContentPane(newUI);
    	frame.setVisible(true);
    	frame.setBounds(500, 100, 900, 900);
    }
}
