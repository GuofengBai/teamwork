package org.dataservice.managedataservice;

import org.po.BeginAccountPO;

public interface BeginningAccountDataService {
	public void addBeginAccount (BeginAccountPO account);
	
	public void Initialize(BeginAccountPO account);
	
	public BeginAccountPO getBeginAccount();
	
	public void deleteAccount(BeginAccountPO account);
	
	
}
