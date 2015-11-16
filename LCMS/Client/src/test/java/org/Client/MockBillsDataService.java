package org.Client;

import java.rmi.RemoteException;

import org.po.BillsPO;
import org.po.ResultMessage;

public class MockBillsDataService {
	public ResultMessage addBills(BillsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage rm=new ResultMessage(true,null);
		return rm;
	}
}
