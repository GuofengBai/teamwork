package org.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.po.ResultMessage;
import org.po.UserPO;

public interface UserDataService extends Remote {
	/**
	 * 新增用户
	 * 
	 * @param po
	 * @return 插入结果
	 */
	public ResultMessage insert(UserPO po) throws RemoteException;

	/**
	 * 寻找用户，注意当用户名和密码都对应时才会返回用户信息
	 * 
	 * @param po
	 * @return 查找结果
	 */
	public UserPO find(String account, String password) throws RemoteException;
}
