package org.dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.po.BillsPO;
import org.po.ResultMessage;

public interface BillsDataService extends Remote{
	public ResultMessage addBills(BillsPO po)throws RemoteException;
	public ResultMessage findBills(int BillNum)throws RemoteException;
	public ResultMessage deleteBills(int BillNum)throws RemoteException;
	public ResultMessage updateBills(int BillNum,BillsPO po)throws RemoteException;

}
