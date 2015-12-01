package org.dataservice.billsdataservice;

import java.rmi.RemoteException;
import java.util.Vector;

import org.po.myDate;

public interface NewHallCollectBillsDataService extends BillsDataService{
	
	public Vector<Vector<String>> getByHall(String hallNum)throws RemoteException;
	
	public Vector<Vector<String>> getByHallAndDate(String hallNum,myDate Date1,myDate Date2)throws RemoteException;

}
