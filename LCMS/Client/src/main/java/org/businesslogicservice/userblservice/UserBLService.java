package org.businesslogicservice.userblservice;

import java.rmi.RemoteException;
import java.util.Vector;

import org.po.ResultMessage;
import org.po.UserPO;
import org.vo.UserVO;

public interface UserBLService {
	/**启动登录
	/@param id用户名
	/@param password密码
	/**@return 返回提示
	 * @throws RemoteException 
	 * 
	 */
	public ResultMessage login(String id,String password) throws RemoteException;
	/**
	 * 
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public UserPO getUser(String account) throws RemoteException;
	/**
	 * 
	 * @param account
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delUser(String account) throws RemoteException ;
	/**
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addUser(UserPO po) throws RemoteException;
	
	/**
	 * 获得现有User列表
	 * @return UserVO的Vector
	 */
	public Vector<UserVO> getList();
}
