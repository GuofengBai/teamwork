package org.businesslogicservice.manageblservice;

import org.po.BeginAccountPO;

public interface NewBeginAccountBLService {
	public void addBeginAccount(String organization,int people,int car,int storage,String accountname,int balance);
	
	public void accountInitilize(BeginAccountPO account);
}
