package org.businesslogic.managebl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.NewBeginAccountBLService;
import org.dataservice.managedataservice.BeginAccountDataService;
import org.po.BeginAccountPO;
import org.po.ResultMessage;

public class NewBeginAccountBL implements NewBeginAccountBLService {
	
	public ResultMessage addBeginAccount(String organization, int people, int car,
			int storage, String accountname, long balance) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		BeginAccountPO account=new BeginAccountPO(organization,people, car,
				storage, accountname,balance);
		
		try {
			BeginAccountDataService bad=RMIHelper.getDataFactory().getManageDataFactory().getBeginAccountData();
			message=bad.addBeginAccount(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}


}
