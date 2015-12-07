package org.businesslogic.userbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.userblservice.UserBLService;
import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;
import org.po.UserPO;

public class UserBL implements UserBLService {
	/**
	 * 登录
	 */
	public ResultMessage login(String id, String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		UserDataService uds = RMIHelper.getDataFactory().getUserData();
		ResultMessage message = uds.confirm(id, password);
		if (message.success) {
			return message;
		} else
			return message;
	}

	/**
	 * 获得用户信息
	 */
	public UserPO getUser(String account) throws RemoteException {
		UserDataService uds = RMIHelper.getDataFactory().getUserData();
		UserPO po = uds.find(account);
		return po;
	}
	/**
	 * 
	 */
	public ResultMessage addUser(UserPO po) throws RemoteException{
		UserDataService uds = RMIHelper.getDataFactory().getUserData();
		ResultMessage re = uds.insert(po);
		return re;
	}
	public ResultMessage delUser(String account) throws RemoteException {
		UserDataService uds = RMIHelper.getDataFactory().getUserData();
		ResultMessage re = uds.delete(account);
		return re;
	}
}
