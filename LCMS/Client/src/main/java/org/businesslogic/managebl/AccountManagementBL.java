package org.businesslogic.managebl;

import org.businesslogicservice.manageblservice.AccountManagementBLService;
import org.po.BankAccountPO;
import org.po.UserPO;
import org.test.dataservice.manageData.AccountManagementData;

public class AccountManagementBL implements AccountManagementBLService{
	
	
	public BankAccountPO[] getAccountList() {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		return amd.getAccountList();
	}

	public void addAccount(String name) {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		amd.addAccount(name);
	}

	public int getBalance(String name) {
		// TODO Auto-generated method stub
		
		AccountManagementData amd=new AccountManagementData();
		return amd.getBalance(name);
	}

	public void delAccount(String name) {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		amd.delAccount(name);
	}

	public void changeName(String name, String newname) {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		amd.changeName(name, newname);
	}

	public void changeBalance(String name, int change) {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		amd.changeBalance(name, change);
		
		
	}

	public BankAccountPO[] accountSearch(String namepart) {
		// TODO Auto-generated method stub
		AccountManagementData amd=new AccountManagementData();
		return amd.search(namepart);
	}

	public boolean check(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
