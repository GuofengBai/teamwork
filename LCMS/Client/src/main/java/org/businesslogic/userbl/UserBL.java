package org.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.userblservice.UserBLService;
import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;
import org.po.UserPO;
import org.vo.UserVO;

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

	public Vector<UserVO> getList() {
		ArrayList<UserPO> all=null;
		Vector<UserVO> vList=new Vector<UserVO>();
		try {
			UserDataService uds = RMIHelper.getDataFactory().getUserData();
			all=uds.getList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(UserPO po:all){
			vList.add(new UserVO(po));
		}
		return vList;
	}
}
