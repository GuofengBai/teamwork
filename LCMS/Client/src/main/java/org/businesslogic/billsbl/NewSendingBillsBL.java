package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.po.myDate;

public class NewSendingBillsBL implements NewSendingBillsBLService{
	
	
	public ResultMessage addSendingBills(String SenderName, 
			String ReceiverName, String SenderPhone, String 
			ReceiverPhone, String SenderLocation, String 
			ReceiverLocation, myDate date, String GoodsNum, 
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, 
			String width, String height, String weight) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getBillsDataService();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new SendingBills(SenderName,ReceiverName,SenderPhone,ReceiverPhone,SenderLocation,
					ReceiverLocation,date,GoodsNum,boxtype,sendtype,length,width,height,weight));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getPrice(String SenderLocation, String ReceiverLocation,
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, String width,
			String height, String weight) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
