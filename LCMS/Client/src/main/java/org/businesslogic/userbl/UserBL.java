package org.businesslogic.userbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.userblservice.UserBLService;
import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;
import org.po.UserPO;

public class UserBL implements UserBLService {

	public ResultMessage login(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		UserDataService uds = RMIHelper.getDataFactory().getUserData();
		
		UserPO po = uds.find(id, password);
		System.out.println(po.getAccount()+" "+po.getPassword());
		ResultMessage re;
		String[] su = { "登陆成功", "正确" };
		String[] fa={"密码错误","请重新输入"};
		String[] nofind={"用户名不存在","请重新输入"};
		if (po.getAccount().equals("登录错误")) {
			System.out.println("BL wrong");
			re = new ResultMessage(false, fa);
		}else if(po.getAccount().equals("用户名不存在")){
			System.out.println("BL wrong");
			re = new ResultMessage(false, nofind);
		}else{
			System.out.println("BL right");
			re = new ResultMessage(true, su);
		}
			
		return re;
	}
	public UserPO getUser(String account,String password) throws RemoteException{
		UserDataService uds = RMIHelper.getDataFactory().getUserData();
		UserPO po=uds.find(account, password);
		return po;
	}
}
