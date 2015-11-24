package org.dataservice.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.dataservice.managedataservice.AccountManagementDataService;
import org.dataservice.managedataservice.BeginAccountDataService;
import org.dataservice.managedataservice.IncomeManagementDataService;
import org.dataservice.managedataservice.IncomeTableDataService;
import org.dataservice.managedataservice.StatusTableDataService;

public interface ManageDataFactoryService extends Remote{
	
	public AccountManagementDataService getAccountManagementData()throws RemoteException;
	
	public BeginAccountDataService getBeginAccountData()throws RemoteException;

	public IncomeManagementDataService getIncomeManagementData()throws RemoteException;

    public IncomeTableDataService getIncomeTableData()throws RemoteException;

    public StatusTableDataService getStatusTableData()throws RemoteException;
}
