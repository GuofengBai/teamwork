package org.dataservice.managedataservice;

import org.po.HallColletcionBills;
import org.po.myDate;

public interface IncomeManagementDataService {
	public HallColletcionBills[] incomeSelectDS(myDate date,int hallnumber);
}
