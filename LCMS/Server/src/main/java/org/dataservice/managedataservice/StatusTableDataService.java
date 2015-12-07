package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public interface StatusTableDataService extends Remote{
	/**
	 * 获取该日期段收款单
	 * 
	 * @param myDate
	 * @param myDate
	 * @return ArrayList<HallCollectionBills>
	 * @throws RemoteException
	 */
	public ArrayList<HallCollectionBills> searchIncomeBill (myDate date1,myDate date2)throws RemoteException;
	
	/**
	 * 获取该日期段付款单
	 * 
	 * @param myDate
	 * @param myDate
	 * @return ArrayList<PayingBills>
	 * @throws RemoteException
	 */
	public ArrayList<PayingBills> searchPayingBill (myDate date1,myDate date2)throws RemoteException;
}
