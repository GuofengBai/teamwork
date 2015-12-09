package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.managedataservice.ManageDataService;

public class ManageData extends UnicastRemoteObject implements ManageDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
