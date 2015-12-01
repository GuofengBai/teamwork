package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface IncomeTableDataService extends Remote{
	public long getIncome()throws RemoteException;
	
	public long getPayment ()throws RemoteException;
}
