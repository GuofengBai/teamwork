package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface IncomeTableDataService extends Remote{
	public int getIncome()throws RemoteException;
	
	public int getPayment ()throws RemoteException;
}
