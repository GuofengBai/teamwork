package org.businesslogicservice.billsblservice;

import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;

public interface NewSendingBillsBLService {
	
	public ResultMessage newSendingBill(myDate Date,BOXSTYPE boxstype,SENDSTYPE sendstype,
			String startplace,String endplace,String location,long GoodsNum,String name);
	
}
