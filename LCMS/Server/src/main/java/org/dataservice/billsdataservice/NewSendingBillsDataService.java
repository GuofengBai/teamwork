package org.dataservice.billsdataservice;

import java.rmi.RemoteException;

import org.po.EXPRESSSTATE;
import org.po.ResultMessage;

public interface NewSendingBillsDataService extends BillsDataService{
	
	public ResultMessage updateExpressState(String BillNum,EXPRESSSTATE expressState)throws RemoteException;
	
	public EXPRESSSTATE getExpressState(String BillNum)throws RemoteException;
	
}
