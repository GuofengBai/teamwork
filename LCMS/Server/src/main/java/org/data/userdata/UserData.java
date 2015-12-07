package org.data.userdata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.userdataservice.UserDataService;
import org.po.ResultMessage;
import org.po.StaffPO;
import org.po.UserPO;

public class UserData extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<UserPO> UserList;
	public String role;

	public UserData() throws RemoteException {
		super();
		init();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	private void init() {
		// TODO Auto-generated method stub
		String fileName = "SerializableData/User.file";
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			UserList = (ArrayList<UserPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(UserList==null){
			UserList=new ArrayList<UserPO>();
		}

	}

	public ResultMessage insert(UserPO po) throws RemoteException{
		// TODO Auto-generated method stub

		UserList.add(po);
		save();
		ResultMessage re = new ResultMessage(true, null);
		return re;
	}
	public ResultMessage delete(String account) throws RemoteException{
		String[] su={"删除成功"};
		String[] fa={"删除失败"};
		for(UserPO po:UserList){
			if(po.getAccount().equals(account)){
				UserList.remove(po);
				save();
				return new ResultMessage(true,su);
			}
		}
		return new ResultMessage(false,fa);
	}

	public ResultMessage confirm(String account,String password) throws RemoteException{
		ResultMessage re;
		String[] su={"密码正确","登陆成功"};
		String[] fa={"密码错误","请重新输入"};
		String[] nofind={"未找到","请重新输入"};
		for(UserPO po:UserList){
        	if((po.getAccount().equals(account))&&(po.getPassword().equals(password))){
        		return re=new ResultMessage(true,su);
        	}
        	else if((po.getAccount().equals(account))&&!(po.getPassword().equals(password))){
        		return re=new ResultMessage(false,fa);
        	}
        }
        return new ResultMessage(false,nofind);
	}
	
	public UserPO find(String account) throws RemoteException{
		for(UserPO po:UserList){
			if(po.getAccount().equals(account))
				return po;
		}
		return null;
	}

	private ResultMessage save() {
		String fileName = "SerializableData/User.file";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(UserList);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<UserPO> getList() throws RemoteException{
		ArrayList<UserPO> all=new ArrayList<UserPO>();
		all.addAll(UserList);
		return all;
	}
}
