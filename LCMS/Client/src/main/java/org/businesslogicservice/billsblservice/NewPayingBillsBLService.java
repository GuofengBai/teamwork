package org.businesslogicservice.billsblservice;

import java.util.ArrayList;

import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;

public interface NewPayingBillsBLService {
	
	public ResultMessage addPayingBills(PayingBills bill);

}
