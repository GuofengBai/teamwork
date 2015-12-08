package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface IncomeTableDataService extends Remote{
	/**
	 * 计算总收入
	 * 
	 * @return long
	 * @throws RemoteException
	 */
	public long getIncome()throws RemoteException;
	
	/**
	 * 计算总支出
	 * 
	 * @return long
	 * @throws RemoteException
	 */
	public long getPayment ()throws RemoteException;
}
