package org.businesslogicservice.billsblservice;

import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;
import org.vo.SBVO;

public interface NewSendingBillsBLService {
	
	public ResultMessage addSendingBills(SBVO vo);
	
	public long getPrice(String SenderLocation, String ReceiverLocation, BOXSTYPE boxtype, 
			SENDSTYPE sendtype, String length, String width, String height, String weight);
	
}
