package org.businesslogic.managebl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.IncomeTableBLService;
import org.dataservice.managedataservice.IncomeTableDataService;
import org.test.dataservice.manageData.IncomeTableData;


public class IncomeTableBL implements IncomeTableBLService {

	public long getIncome() {
		// TODO Auto-generated method stub
		long result=0;
		try {
			IncomeTableDataService itd = RMIHelper.getDataFactory().getManageDataFactory().getIncomeTableData();
			result=itd.getIncome();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public long getPayment() {
		// TODO Auto-generated method stub
		long result=0;
		try {
			IncomeTableDataService itd = RMIHelper.getDataFactory().getManageDataFactory().getIncomeTableData();
			result=itd.getPayment();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

}
