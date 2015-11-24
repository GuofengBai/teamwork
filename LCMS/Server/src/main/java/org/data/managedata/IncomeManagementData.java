package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.managedataservice.IncomeManagementDataService;
import org.po.HallCollectionBills;
import org.po.myDate;

public class IncomeManagementData extends UnicastRemoteObject implements IncomeManagementDataService {

	public IncomeManagementData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HallCollectionBills> incomeSearch(myDate date,
			int hallNumber) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
