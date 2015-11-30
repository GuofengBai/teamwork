package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.managedata.AccountManagementData;
import org.data.managedata.BeginAccountData;
import org.data.managedata.CostManagementData;
import org.data.managedata.IncomeManagementData;
import org.data.managedata.IncomeTableData;
import org.data.managedata.StatusTableData;
import org.dataservice.DataFactoryService.ManageDataFactoryService;
import org.dataservice.managedataservice.AccountManagementDataService;
import org.dataservice.managedataservice.BeginAccountDataService;
import org.dataservice.managedataservice.CostManagementDataService;
import org.dataservice.managedataservice.IncomeManagementDataService;
import org.dataservice.managedataservice.IncomeTableDataService;
import org.dataservice.managedataservice.StatusTableDataService;

public class ManageDataFactory extends UnicastRemoteObject implements ManageDataFactoryService{

	public AccountManagementDataService accountManagementData;
	public BeginAccountDataService beginAccountData;
	public IncomeManagementDataService incomeManagementData;
	public IncomeTableDataService incomeTableData;
	public StatusTableDataService statusTableData;
	public CostManagementDataService costManagementData;
	
	public ManageDataFactory() throws RemoteException {
		super();
		accountManagementData=null;
		beginAccountData=null;
		incomeManagementData=null;
		incomeTableData=null;
		statusTableData=null;
		costManagementData=null;
	}

	public AccountManagementDataService getAccountManagementData()
			throws RemoteException {
		if(accountManagementData==null){
			accountManagementData=new AccountManagementData();
		}
		return accountManagementData;
	}

	public BeginAccountDataService getBeginAccountData() throws RemoteException {
		if(beginAccountData==null){
			beginAccountData=new BeginAccountData();
		}
		return beginAccountData;
	}

	public IncomeManagementDataService getIncomeManagementData()
			throws RemoteException {
		if(incomeManagementData==null){
			incomeManagementData=new IncomeManagementData();
		}
		return incomeManagementData;
	}

	public IncomeTableDataService getIncomeTableData() throws RemoteException {
		if(incomeTableData==null){
			incomeTableData=new IncomeTableData();
		}
		return incomeTableData;
	}

	public StatusTableDataService getStatusTableData() throws RemoteException {
		if(statusTableData==null){
			statusTableData=new StatusTableData();
		}
		return statusTableData;
	}
	
	public CostManagementDataService getCostManagementData() throws RemoteException{
		if(costManagementData==null){
			costManagementData=new CostManagementData();
		}
		return costManagementData;
	}

}
