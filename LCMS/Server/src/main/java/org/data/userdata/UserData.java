package org.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.userdataservice.UserDataService;

public class UserData extends UnicastRemoteObject implements UserDataService{

	protected UserData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
