package org.businesslogicservice.manageblservice;

import org.po.BankAccountPO;
import org.po.UserPO;

public interface AccountManagementBLService {
	public BankAccountPO[] getAccountList ();
	
	public void addAccount(String name);
	
	public int calculate (String name);
	
	public void delAccount(String name);
	
	public void changeName(String name,String newname);
	
	public boolean changeBalance (String name,int change);
	
	public BankAccountPO[] accountSearch(String namepart);
	
	public boolean check (UserPO user);
}
