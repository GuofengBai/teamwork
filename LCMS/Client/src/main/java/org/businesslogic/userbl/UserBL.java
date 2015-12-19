package org.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogic.blFactory.BLFactory;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.businesslogicservice.userblservice.UserBLService;
import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;
import org.po.UserPO;
import org.vo.StaffVO;
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
		
		UserDataService uds=null;
		try{
			uds = RMIHelper.getDataFactory().getUserData();
			if(uds==null){
				String[] info={"网络错误，无法找到UserData"};
				return new ResultMessage(false,info);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		try{
			UserPO temp=uds.find(po.account);
			if(temp!=null){
				String[] info={"添加错误，已存在同名账号"};
				return new ResultMessage(false,info);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		try{
			StaffBLService staffBL=BLFactory.getStaffBL();
			StaffVO temp=staffBL.findStaff(po.getNumber());
			if(temp==null){
				String[] info={"添加错误，不存在与该编号关联的员工"};
				return new ResultMessage(false,info);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		try{
			Vector<UserVO> list=getList();
			for(UserVO uo:list){
				if(uo.get(1).equals(po.getNumber())){
					String[] info={"添加错误，已存在与该员工关联的账号"+uo.get(0)};
					return new ResultMessage(false,info);
				}
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		try{
			uds.insert(po);
		}catch(Exception exc){
			exc.printStackTrace();
			String[] info={"添加错误，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		
		return new ResultMessage(true,null);
	}
	public ResultMessage delUser(String account) throws RemoteException {
		
		UserDataService uds=null;
		try{
			uds = RMIHelper.getDataFactory().getUserData();
			if(uds==null){
				String[] info={"网络错误，无法找到UserData"};
				return new ResultMessage(false,info);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		try{
			UserPO temp=uds.find(account);
			if(temp==null){
				String[] info={"删除错误，不存在该账号"};
				return new ResultMessage(false,info);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		try{
			uds.delete(account);
		}catch(Exception exc){
			exc.printStackTrace();
			String[] info={"删除错误，数据端发生错误"};
			return new ResultMessage(false,info);
		}
		
		return new ResultMessage(true,null);
	}

	public Vector<UserVO> getList() {
		ArrayList<UserPO> all=null;
		Vector<UserVO> vList=new Vector<UserVO>();
		try {
			UserDataService uds = RMIHelper.getDataFactory().getUserData();
			all=uds.getList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(UserPO po:all){
			vList.add(new UserVO(po));
		}
		return vList;
	}
}
