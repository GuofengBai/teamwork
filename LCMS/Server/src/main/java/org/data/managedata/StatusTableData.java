package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.managedataservice.StatusTableDataService;
import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public class StatusTableData extends UnicastRemoteObject implements StatusTableDataService {

	public StatusTableData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HallCollectionBills> searchIncomeBill(myDate date1,
			myDate date2) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PayingBills> searchPayingBill(myDate date1, myDate date2) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
