package org.dataservice.managedataservice;

import org.po.HallCollectionBills;
import org.po.myDate;

public interface IncomeManagementDataService {
	public HallCollectionBills[] incomeSearch (myDate date,int hallNumber);
}
