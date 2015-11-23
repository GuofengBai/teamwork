package org.Client;

import javax.swing.JFrame;

import org.po.BILLSTYPE;
import org.presentation.billsui.NewSendingBillsUI;
import org.presentation.userui.UserUI;


public class Client{
    public static void main(String[] args)
    {
    	RMIHelper.init();
    	NewSendingBillsUI newSendingBills=new NewSendingBillsUI();
    	UserUI u=new UserUI();
    	JFrame f=new JFrame();
    	f.add(u);
    	f.setSize(700, 700);
    	f.setVisible(true);
    	
    }
}
