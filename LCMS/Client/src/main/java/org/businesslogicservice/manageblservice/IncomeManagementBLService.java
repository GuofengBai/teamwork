package org.businesslogicservice.manageblservice;

import org.po.HallCollectionBills;
import org.po.myDate;

public interface IncomeManagementBLService {
	public HallCollectionBills[] incomeSearch (myDate date,int hallNumber);
}
