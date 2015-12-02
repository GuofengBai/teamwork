package org.Client;

import java.rmi.RemoteException;

import javax.swing.JFrame;

import org.businesslogic.blFactory.BLFactory;
import org.po.BILLSTYPE;
import org.presentation.billsui.NewCenterArriveBillsUI;
import org.presentation.billsui.NewHallDispatchBillsUI;
import org.presentation.billsui.NewSendingBillsUI;
import org.presentation.commodityui.CheckCommodityUI;
import org.presentation.commodityui.DistrictChangeUI;
import org.presentation.commodityui.ExamineCommodityUI;
import org.presentation.commodityui.SettingAlertUI;
import org.presentation.mainui.ViewController;
import org.presentation.staffui.GeneralManagerUI;
import org.presentation.userui.UserUI;


public class Client{
    public static void main(String[] args) throws RemoteException
    {
    	RMIHelper.init();

    	NewCenterArriveBillsUI ui=new NewCenterArriveBillsUI();

    	BLFactory.init();
<<<<<<< HEAD
    	JFrame frame = new JFrame();
    	frame.setContentPane(ui);
    	frame.setVisible(true);
=======
    	SettingAlertUI c=new SettingAlertUI();

    	JFrame f=new JFrame();
    	f.setContentPane(c);
    	f.setVisible(true);
 //       ViewController.init(f);
    	f.setSize(1700, 900);
 //   	f.setVisible(true);
 //   	f.add(c);
//    	GeneralManagerUI manager=new GeneralManagerUI();
    	//ViewController.jumpToAnotherView();
    	
>>>>>>> origin/master
    	
    }
}
