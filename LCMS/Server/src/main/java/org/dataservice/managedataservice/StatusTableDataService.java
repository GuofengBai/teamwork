package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public interface StatusTableDataService extends Remote{
	public ArrayList<HallCollectionBills> searchIncomeBill (myDate date1,myDate date2)throws RemoteException;
	
	public ArrayList<PayingBills> searchPayingBill (myDate date1,myDate date2)throws RemoteException;
}
