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
		ResultMessage re;
		// String[] su={"登陆成功","登陆成功"};
		// String[] fa={"登录失败","密码错误"};
		// String[] nofind={"登录失败","用户名不存在"};
		// ResultMessage re1;
		// if(id=="0001"&&password=="0001")
		// re1=new ResultMessage(true,su);
		// else if(id=="0001"&&password!="0001")
		// re1=new ResultMessage(false,fa);
		// else
		// re1=new ResultMessage(false,nofind);
		// System.out.println(re1.info[0]);
		String[] su = { "登陆成功", "正确" };
		String[] fa={"密码错误","请重新输入"};
		String[] nofind={"用户名不存在","请重新输入"};
		if (po.getAccount().equals("密码错误")) {
			re = new ResultMessage(false, fa);
		}else if(po.getAccount().equals("用户名不存在")){
			re = new ResultMessage(false, nofind);
		}else
			re = new ResultMessage(true, su);
		return re;
	}

}
