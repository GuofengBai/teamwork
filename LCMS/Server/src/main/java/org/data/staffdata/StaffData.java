package org.data.staffdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.staffdataservice.StaffDataService;

public class StaffData extends UnicastRemoteObject implements StaffDataService{

	protected StaffData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
