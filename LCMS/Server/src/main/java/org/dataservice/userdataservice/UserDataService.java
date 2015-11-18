package org.dataservice.userdataservice;

import java.rmi.Remote;

import org.po.ResultMessage;
import org.po.UserPO;

public interface UserDataService extends Remote{
	/**
	 * 
	 * @param po
	 * @return 插入结果
	 */
	public ResultMessage insert(UserPO po);
	/**
	 * 
	 * @param po
	 * @return 查找结果
	 */
	public ResultMessage find(UserPO po);
}
