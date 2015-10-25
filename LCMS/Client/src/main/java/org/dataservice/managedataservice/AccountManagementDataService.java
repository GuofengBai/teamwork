package org.dataservice.managedataservice;

import org.po.BankAccountPO;

public interface AccountManagementDataService {
	public void addBankAccountDS(String name);
	
	public void deleteBankAccountDS(String name);
	
	public void getAllBankAccountDS();
	
	public BankAccountPO[] searchBankAccountDS (String name);
}
