package org.businesslogicservice.userblservice;

import java.rmi.RemoteException;

import org.po.ResultMessage;

public interface UserBLService {
	/**启动登录
	/@param id用户名
	/@param password密码
	/**@return 返回提示
	 * @throws RemoteException 
	 * 
	 */
	public ResultMessage login(String id,String password) throws RemoteException;
}
