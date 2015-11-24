package org.dataservice.managedataservice;

import java.rmi.RemoteException;

import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public interface StatusTableDataService {
	public HallCollectionBills[] searchIncomeBill (myDate date1,myDate date2)throws RemoteException;
	
	public PayingBills[] searchPayingBill (myDate date1,myDate date2)throws RemoteException;
}
