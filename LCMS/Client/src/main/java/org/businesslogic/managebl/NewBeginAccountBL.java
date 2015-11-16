package org.businesslogic.managebl;

import org.businesslogicservice.manageblservice.NewBeginAccountBLService;
import org.po.BeginAccountPO;
import org.test.dataservice.manageData.BeginAccountData;

public class NewBeginAccountBL implements NewBeginAccountBLService {
	
	public void addBeginAccount(String organization, int people, int car,
			int storage, String accountname, int balance) {
		// TODO Auto-generated method stub
		BeginAccountData bd=new BeginAccountData();
		NewBeginAccountBL nbl=new NewBeginAccountBL();
		BeginAccountPO example=new BeginAccountPO(organization,people, car,
				storage, accountname,balance);
		
		bd.addBeginAccount(example);
		nbl.accountInitilize(example);
	}

	public void accountInitilize(BeginAccountPO account) {
		// TODO Auto-generated method stub
		BeginAccountData bd=new BeginAccountData();
		bd.Initialize(account);
	}

}
