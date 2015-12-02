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

	}

	public ResultMessage insert(UserPO po) throws RemoteException{
		// TODO Auto-generated method stub

		UserList.add(po);
		save();
		ResultMessage re = new ResultMessage(true, null);
		return re;
	}

	public UserPO find(String account,String password) throws RemoteException{
        for(UserPO po:UserList){
        	if((po.getAccount().equals(account))&&(po.getPassword().equals(password))){
        		//System.out.println("Data success");
        		System.out.println(po.getAccount()+" "+po.getPassword());
        		return po;
        	}
        	else if((po.getAccount().equals(account))&&!(po.getPassword().equals(password))){
        		//System.out.println("Data wrong");
        		return new UserPO("登录错误","密码错误","-1");
        	}
        		
        }
       // System.out.println("Data wrong");
        return new UserPO("用户名不存在","用户名不存在","-1");
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

	private void setRole(StaffPO staff){
		String re = String.valueOf(staff.staffRole);
		this.role = re;
	}
}
