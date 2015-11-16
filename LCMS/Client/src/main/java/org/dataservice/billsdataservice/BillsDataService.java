package org.dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ResultMessage;
import org.po.myDate;

public interface BillsDataService extends Remote{
	public ResultMessage addBills(BillsPO po)throws RemoteException;
	public BillsPO findBills(int BillNum)throws RemoteException;
	public ResultMessage deleteBills(int BillNum)throws RemoteException;
	public ResultMessage updateBills(int BillNum,BillsPO bill)throws RemoteException;
	public ResultMessage examine(int BillNum)throws RemoteException;
	public long getUnexaminedBillsNum()throws RemoteException;
	public ArrayList<BillsPO> getUnexaminedBills()throws RemoteException;
	public ArrayList<BillsPO> getByDate(myDate date1,myDate date2)throws RemoteException;
    public ResultMessage save()throws RemoteException;
}
