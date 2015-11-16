package org.businesslogic.managebl;

import org.businesslogicservice.manageblservice.IncomeManagementBLService;
import org.po.HallCollectionBills;
import org.po.myDate;
import org.test.dataservice.manageData.IncomeManagementData;

public class IncomeManagementBL implements IncomeManagementBLService {

	public HallCollectionBills[] incomeSearch(myDate date, int hallNumber) {
		// TODO Auto-generated method stub
		IncomeManagementData imd=new IncomeManagementData();
		return imd.incomeSearch(date, hallNumber);
		
	}


}
