package org.businesslogicservice.manageblservice;

import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public interface StatusTableBLService {
	public HallCollectionBills[] searchIncomeBill (myDate date1,myDate date2);
	
	public PayingBills[] searchPayingBill (myDate date1,myDate date2);

}
