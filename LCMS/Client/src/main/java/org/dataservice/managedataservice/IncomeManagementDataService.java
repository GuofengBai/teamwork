package org.dataservice.managedataservice;

import java.rmi.RemoteException;

import org.po.HallCollectionBills;
import org.po.myDate;

public interface IncomeManagementDataService {
	public HallCollectionBills[] incomeSearch (myDate date,int hallNumber)throws RemoteException;
}
