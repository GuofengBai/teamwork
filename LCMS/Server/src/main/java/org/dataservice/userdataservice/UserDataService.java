package org.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.po.ResultMessage;
import org.po.UserPO;

public interface UserDataService extends Remote{
	/**
	 * 
	 * @param po
	 * @return 插入结果
	 */
	public ResultMessage insert(UserPO po)throws RemoteException;
	/**
	 * 
	 * @param po
	 * @return 查找结果
	 */
	public UserPO find(String account,String password)throws RemoteException;
}
