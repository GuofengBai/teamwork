package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.ReceiveMessageBLService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.SendingBills;
import org.po.myDate;

public class ReceiveMessageBL implements ReceiveMessageBLService{

	public Boolean addMessage(String goodNum, String receiverName,
			myDate date) {
		// TODO Auto-generated method stub
		NewSendingBillsDataService sendingBillsData;
		try {
			sendingBillsData = RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
			SendingBills bill = ((SendingBills)sendingBillsData.findBills(receiverName));			
			bill.setArriveDate(date);
			bill.setReceiverNameReal(receiverName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
