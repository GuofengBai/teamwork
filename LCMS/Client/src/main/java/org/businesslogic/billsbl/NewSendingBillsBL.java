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


	public ResultMessage newSendingBill(myDate Date, BOXSTYPE boxstype,
			SENDSTYPE sendstype, String startplace, String endplace,
			String location, long GoodsNum, String name,double price) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getBillsDataService();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new SendingBills(Date, boxstype,sendstype, startplace, endplace,
					location, GoodsNum, name, price));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	
}
