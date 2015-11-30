package org.dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ResultMessage;
import org.po.myDate;

public interface BillsDataService extends Remote{
	public ResultMessage addBills(BillsPO po)throws RemoteException;
	public BillsPO findBills(String BillNum)throws RemoteException;
	public ResultMessage deleteBills(String BillNum)throws RemoteException;
	public ResultMessage updateBills(String BillNum,BillsPO bill)throws RemoteException;
	public ResultMessage examine(String BillNum)throws RemoteException;
	public long getUnexaminedBillsNum()throws RemoteException;
	public Vector<Vector<String>> getUnexaminedBills()throws RemoteException;
	public Vector<Vector<String>> getByDate(myDate date1,myDate date2)throws RemoteException;
	public Vector<Vector<String>> getAllInfo()throws RemoteException;
	public ArrayList<BillsPO> getAll()throws RemoteException;
	public ResultMessage save()throws RemoteException;
}
 