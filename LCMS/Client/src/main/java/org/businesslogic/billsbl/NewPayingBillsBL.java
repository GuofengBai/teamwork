package org.businesslogic.billsbl;

import java.rmi.RemoteException;


import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewPayingBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.PayingBills;
import org.po.ResultMessage;

public class NewPayingBillsBL implements NewPayingBillsBLService{

	public ResultMessage addPayingBills(PayingBills bill) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewPayingBillsData();
			message=billsData.addBills(bill);
			
		//	AccountManagementDataService accountData=RMIHelper.getDataFactory().getManageDataFactory().getAccountManagementData();
		//	accountData.changeBalance(bill.getAccountName(), (-bill.getMoney()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}



}
