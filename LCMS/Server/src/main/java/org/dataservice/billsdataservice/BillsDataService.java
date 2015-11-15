package org.dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ResultMessage;

public interface BillsDataService extends Remote{
	public ResultMessage addBills(BillsPO po)throws RemoteException;
	public BillsPO findBills(int BillNum,BILLSTYPE type)throws RemoteException;
	public ResultMessage deleteBills(int BillNum,BILLSTYPE type)throws RemoteException;
	public ResultMessage updateBills(int BillNum,BillsPO po)throws RemoteException;
	public ResultMessage examine(BillsPO bill)throws RemoteException;
}
