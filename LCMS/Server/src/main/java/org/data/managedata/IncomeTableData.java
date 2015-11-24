package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.managedataservice.IncomeTableDataService;

public class IncomeTableData extends UnicastRemoteObject implements IncomeTableDataService {

	public IncomeTableData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIncome() throws RemoteException{
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPayment() throws RemoteException{
		// TODO Auto-generated method stub
		return 0;
	}

}
