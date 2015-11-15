package org.businesslogicservice.manageblservice;

import org.po.BeginAccountPO;

public interface BeginAccountBLService {
	public BeginAccountPO getBeginAccount();
	
	public void deleteAccount(BeginAccountPO account);
}
