package org.dataservice.managedataservice;

import java.rmi.RemoteException;



public interface IncomeTableDataService {
	public int getIncome()throws RemoteException;
	
	public int getPayment ()throws RemoteException;
}
