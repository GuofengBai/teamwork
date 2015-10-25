package org.dataservice.managedataservice;

import org.po.BeginAccountPO;

public interface BeginningAccountDataService {
	public BeginAccountPO getBeginningDS();
	
	public void newBeginAccountDS(BeginAccountPO account);
	
	public void delBeginAccountDS(BeginAccountPO account);
	
}
