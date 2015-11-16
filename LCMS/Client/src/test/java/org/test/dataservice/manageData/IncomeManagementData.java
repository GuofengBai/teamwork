package org.test.dataservice.manageData;

import org.dataservice.managedataservice.IncomeManagementDataService;
import org.po.HallCollectionBills;
import org.po.myDate;

public class IncomeManagementData implements IncomeManagementDataService {

	public HallCollectionBills[] incomeSearch(myDate date, int hallNumber) {
		// TODO Auto-generated method stub
		HallCollectionBills[] example=new HallCollectionBills[2];
		HallCollectionBills a=new HallCollectionBills();
		HallCollectionBills b=new HallCollectionBills();
		example[0]=a;
		example[1]=b;
		
		return example;
	}

}
