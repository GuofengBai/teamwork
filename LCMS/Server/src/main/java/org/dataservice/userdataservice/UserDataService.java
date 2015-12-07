package org.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
	 * 寻找用户，注意当用户名和密码都对应
	 * 
	 * @param po
	 * @return 查找结果
	 */
	public ResultMessage confirm(String account,String password) throws RemoteException;
	/**
	 * 返回User信息
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(String account) throws RemoteException;
	/**
	 * 删除User
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delete(String account) throws RemoteException;
	
	/**
	 * 获得所有UserPO的列表
	 * @return
	 */
	public ArrayList<UserPO> getList()throws RemoteException;
}
