package org.Client;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.businesslogic.blFactory.BLFactory;
import org.po.BILLSTYPE;
import org.presentation.billsui.BillsStateSearch;
import org.presentation.billsui.NewCenterArriveBillsUI;
import org.presentation.billsui.NewHallDispatchBillsUI;
import org.presentation.billsui.NewInstorageBillsUI;
import org.presentation.billsui.NewSendingBillsUI;
import org.presentation.commodityui.CheckCommodityUI;
import org.presentation.commodityui.DistrictChangeUI;
import org.presentation.commodityui.ExamineCommodityUI;
import org.presentation.commodityui.SettingAlertUI;
import org.presentation.commodityui.StorageStaffView;
import org.presentation.mainui.ViewController;
import org.presentation.staffui.GeneralManagerUI;
import org.presentation.userui.UserUI;


public class Client{
    public static void main(String[] args) throws RemoteException
    {
    	RMIHelper.init();
    	JPanel newUI=new BillsStateSearch();
    	BLFactory.init();
    	JFrame frame = new JFrame();
    	ViewController.init(frame);
    	frame.setContentPane(newUI);
    	frame.setVisible(true);
    	
    	frame.setSize(900, 600);
    }
}
