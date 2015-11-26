package org.businesslogicservice.manageblservice;

import org.po.BeginAccountPO;
import org.po.ResultMessage;

public interface NewBeginAccountBLService {
	public ResultMessage addBeginAccount(String organization,int people,int car,int storage,String accountname,int balance);
	
	public void accountInitilize(BeginAccountPO account);
}
