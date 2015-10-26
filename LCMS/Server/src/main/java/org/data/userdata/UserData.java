package org.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;

public class UserData extends UnicastRemoteObject implements UserDataService{

	protected UserData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage login(long id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
