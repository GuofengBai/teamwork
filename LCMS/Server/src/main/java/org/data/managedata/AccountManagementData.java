package org.data.managedata;

import org.dataservice.managedataservice.AccountManagementDataService;
import org.po.BankAccountPO;

public class AccountManagementData implements AccountManagementDataService {

	public BankAccountPO[] getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAccount(String name) {
		// TODO Auto-generated method stub

	}

	public int getBalance(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delAccount(String name) {
		// TODO Auto-generated method stub

	}

	public void changeName(String name, String newname) {
		// TODO Auto-generated method stub

	}

	public void changeBalance(String name, int change) {
		// TODO Auto-generated method stub

	}

	public BankAccountPO[] search(String namepart) {
		// TODO Auto-generated method stub
		return null;
	}

}
