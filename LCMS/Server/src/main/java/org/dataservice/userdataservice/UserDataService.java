package org.dataservice.userdataservice;

import java.rmi.Remote;

import org.po.ResultMessage;

public interface UserDataService extends Remote{
	//*启动登录
	//@param id用户名
	//@param password密码
	//*@return 返回提示
	public ResultMessage login(long id,String password);
}
