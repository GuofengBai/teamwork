package org.dataservice.managedataservice;

import org.po.HallColletionBills;
import org.po.myDate;

public interface IncomeManagementDataService {
	public HallColletionBills[] incomeSelectDS(myDate date,int hallnumber);
}
