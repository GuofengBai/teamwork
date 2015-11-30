package org.Client;

import java.rmi.RemoteException;

import javax.swing.JFrame;

import org.businesslogic.blFactory.BLFactory;
import org.po.BILLSTYPE;
import org.presentation.billsui.NewCenterArriveBillsUI;
import org.presentation.billsui.NewSendingBillsUI;
import org.presentation.commodityui.CheckCommodityUI;
import org.presentation.commodityui.DistrictChangeUI;
import org.presentation.commodityui.SettingAlertUI;
import org.presentation.mainui.ViewController;
import org.presentation.staffui.GeneralManagerUI;
import org.presentation.userui.UserUI;


public class Client{
    public static void main(String[] args) throws RemoteException
    {
    	RMIHelper.init();
    	BLFactory.init();
 //   	NewSendingBillsUI newSendingBills=new NewSendingBillsUI();
//    	UserUI u=new UserUI();
//    	NewCenterArriveBillsUI c=new NewCenterArriveBillsUI();
    	JFrame f=new JFrame();
        ViewController.init(f);
    	f.setSize(700, 700);
    	f.setVisible(true);
//    	GeneralManagerUI manager=new GeneralManagerUI();
    	ViewController.jumpToAnotherView();
    	
    	
    }
}
