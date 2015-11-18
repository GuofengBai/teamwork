package org.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;
import org.po.UserPO;

public class UserData extends UnicastRemoteObject implements UserDataService{

	protected UserData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage insert(UserPO po) {
		// TODO Auto-generated method stub
		return null;
	}

}
