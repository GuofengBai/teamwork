package org.data.billsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.billsdataservice.BillsDataService;

public abstract class BillsData extends UnicastRemoteObject implements BillsDataService{

	protected BillsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
