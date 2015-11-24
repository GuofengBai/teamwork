package org.businesslogicservice.billsblservice;

import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;

public interface NewCenterFreightBillsBLService {
	public ResultMessage addCenterFreightBills(myDate date, String FreightNum, 
			String tramNum, String StartPlace, String EndPlace, String caseNum, String Scoutername);
	public long getPrice(SENDSTYPE send, String StartPlace, String EndPlace);

}
