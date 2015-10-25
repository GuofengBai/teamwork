package org.businesslogicservice.manageblservice;

import org.po.BeginAccountPO;

public interface BeginningAccountService {
	
	//新建期初账单
	public BeginAccountPO newBenningAccount(String organization,int people,int car,int storage,String accountname,int balance);
	
	//初始化系统
	public void accountInitilize(BeginAccountPO account);
	
	//删除账单
	public void accountDelete(BeginAccountPO account);
}
