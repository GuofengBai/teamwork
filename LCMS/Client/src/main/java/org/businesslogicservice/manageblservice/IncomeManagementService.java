package org.businesslogicservice.manageblservice;

import org.po.myDate;

public interface IncomeManagementService {
	public void incomeSelect(myDate date,int hallnumber);
	
	public void incomeAdd(HallCollectionBills bill);
}
