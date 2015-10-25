package org.dataservice.managedataservice;

import org.po.IncomeTableData;

public interface IncomeTableDataService {
	public IncomeTableData calculateDS();
	
	public void incomeTableOutputDS(IncomeTableData data);
}
