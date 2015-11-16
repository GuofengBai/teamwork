package org.dataservice.managedataservice;

import org.po.BankAccountPO;

public interface AccountManagementDataService {
	public BankAccountPO[] getAccountList ();
	
	public void addAccount(String name);
	
	public int getBalance(String name);
	
	public void delAccount(String name);
	
	public void changeName(String name,String newname);
	
	public void changeBalance (String name,int change);
	
	public BankAccountPO[] search(String namepart);
}
