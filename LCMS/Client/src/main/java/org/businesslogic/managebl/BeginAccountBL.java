package org.businesslogic.managebl;

import org.businesslogicservice.manageblservice.BeginAccountBLService;
import org.po.BeginAccountPO;
import org.test.dataservice.manageData.BeginAccountData;

public class BeginAccountBL implements BeginAccountBLService {

	public BeginAccountPO getBeginAccount() {
		// TODO Auto-generated method stub
		BeginAccountData bd=new BeginAccountData();
		
		return bd.getBeginAccount();
	}

	public void deleteAccount(BeginAccountPO account) {
		// TODO Auto-generated method stub
		BeginAccountData bd=new BeginAccountData();
		bd.deleteAccount(account);
	}

	
}
