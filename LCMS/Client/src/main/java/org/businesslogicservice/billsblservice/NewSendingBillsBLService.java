package org.businesslogicservice.billsblservice;

import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;

public interface NewSendingBillsBLService {
	
	public ResultMessage addSendingBills(String SenderName, String ReceiverName, 
			String SenderPhone, String ReceiverPhone, String SenderLocation, 
			String ReceiverLocation, myDate date, String GoodsNum, BOXSTYPE boxtype, 
			SENDSTYPE sendtype, String length, String width, String height, String weight);
	
	public long getPrice(String SenderLocation, String ReceiverLocation, BOXSTYPE boxtype, 
			SENDSTYPE sendtype, String length, String width, String height, String weight);
	
}
