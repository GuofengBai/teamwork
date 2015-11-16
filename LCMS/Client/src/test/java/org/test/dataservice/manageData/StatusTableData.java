package org.test.dataservice.manageData;

import org.dataservice.managedataservice.StatusTableDataService;
import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public class StatusTableData implements StatusTableDataService {

	public HallCollectionBills[] searchIncomeBill(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		HallCollectionBills a=new HallCollectionBills();
		HallCollectionBills b=new HallCollectionBills();
		HallCollectionBills[] example=new HallCollectionBills[]{a,b};
		
		
		return example;
	}

	public PayingBills[] searchPayingBill(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		PayingBills a=new PayingBills();
		PayingBills b=new PayingBills();
		PayingBills[] example=new PayingBills[]{a,b};
		
		return example;
	}

}
