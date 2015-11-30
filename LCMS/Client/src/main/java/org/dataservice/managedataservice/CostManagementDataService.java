package org.dataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;

public interface CostManagementDataService extends Remote{
	public ArrayList<PayingBills> getAllBill()throws RemoteException;
	
	public ResultMessage changeBill(int index,PayingBills newBill)throws RemoteException;
	
	public ResultMessage delBill(int index)throws RemoteException;
	
	public ArrayList<PayingBills> getBillByTime(myDate date1, myDate date2)throws RemoteException;
}
