package org.Client;

import java.rmi.RemoteException;

import javax.swing.JFrame;

import org.po.BILLSTYPE;
import org.presentation.billsui.NewSendingBillsUI;
import org.presentation.commodityui.CheckCommodityUI;
import org.presentation.commodityui.DistrictChangeUI;
import org.presentation.commodityui.SettingAlertUI;
import org.presentation.userui.UserUI;


public class Client{
    public static void main(String[] args) throws RemoteException
    {
    	RMIHelper.init();
    	NewSendingBillsUI newSendingBills=new NewSendingBillsUI();
    	UserUI u=new UserUI();
    	SettingAlertUI c=new SettingAlertUI();
    	JFrame f=new JFrame();
    	f.add(c);
    	f.setSize(700, 700);
    	f.setVisible(true);
    	
    }
}
