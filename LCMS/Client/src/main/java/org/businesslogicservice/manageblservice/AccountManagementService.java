package org.businesslogicservice.manageblservice;

import org.po.BankAccountPO;
import org.po.UserPO;

public interface AccountManagementService {
	//新建
	public BankAccountPO newAccount(String name);
	
	//删除
	public void delAccount(BankAccountPO account);
	
	//修改
	public void changeAccount(BankAccountPO account,String newname);
	
	//关键字搜索
	public BankAccountPO[] accountSearch(String namepart); 
	
	//检查用户是否有最高权限
	public boolean checkaccount(UserPO user);
	
}
