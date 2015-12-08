package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewPayingBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.managedataservice.AccountManagementDataService;
import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;

public class NewPayingBillsBL implements NewPayingBillsBLService{

	public ResultMessage addPayingBills(PayingBills bill) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewPayingBillsData();
			message=billsData.addBills(bill);
			
			AccountManagementDataService accountData=RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
			accountData.changeBalance(bill.getname(), (-bill.getMoney()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}



}
