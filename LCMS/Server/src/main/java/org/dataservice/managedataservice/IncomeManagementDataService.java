package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.HallCollectionBills;
import org.po.myDate;

public interface IncomeManagementDataService extends Remote{
	/**
	 * 查找收款单
	 * 
	 * @param myDate
	 * @param String
	 * @return ArrayList<HallCollectionBills>
	 * @throws RemoteException
	 */
	public ArrayList<HallCollectionBills> incomeSearch (myDate date,String hallNumber)throws RemoteException;
}
