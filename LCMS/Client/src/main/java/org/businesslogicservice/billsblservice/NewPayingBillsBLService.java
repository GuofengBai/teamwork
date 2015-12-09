package org.businesslogicservice.billsblservice;

import org.po.PayingBills;
import org.po.ResultMessage;

public interface NewPayingBillsBLService {
	
	public ResultMessage addPayingBills(PayingBills bill);

}
