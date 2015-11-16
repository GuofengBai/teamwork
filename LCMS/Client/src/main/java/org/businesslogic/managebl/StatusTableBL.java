package org.businesslogic.managebl;

import org.businesslogicservice.manageblservice.StatusTableBLService;
import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;
import org.test.dataservice.manageData.StatusTableData;

public class StatusTableBL implements StatusTableBLService {

	public HallCollectionBills[] searchIncomeBill(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		StatusTableData std=new StatusTableData();
		
		return std.searchIncomeBill(date1, date2);
	}

	public PayingBills[] searchPayingBill(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		StatusTableData std=new StatusTableData();
		
		return std.searchPayingBill(date1, date2);
	}

	

}
