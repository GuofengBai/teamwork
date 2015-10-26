package org.dataservice.userdataservice;

import java.rmi.Remote;

import org.po.ResultMessage;
import org.po.UserPO;

public interface UserDataService extends Remote{
	public ResultMessage insert(UserPO po);
}
