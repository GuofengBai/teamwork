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
import org.po.ComPO;
import org.po.ResultMessage;
import org.po.UserPO;

public class UserData extends UnicastRemoteObject implements UserDataService {

	public ArrayList<UserPO> UserList;

	protected UserData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage insert(UserPO po) {
		// TODO Auto-generated method stub
		String fileName = "SerializableData/User.file";
		System.out.println(fileName);
		try {
			UserList.add(po);
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
		ResultMessage re = new ResultMessage(true, null);
		return re;
	}

	public ResultMessage find(UserPO po) {
		// TODO Auto-generated method stub
		String fileName = "SerializableData/User.file";
		System.out.println(fileName);
		FileInputStream fis;
		ObjectInputStream ois = null;
		ResultMessage re;
		String[] su = { " login success", "correct." };
		String[] fa = { " login fail", "wrong" };
		int i = 0;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
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
		FileOutputStream fos;
		for (UserPO po1 : UserList) {
			if (po1.getAccount().equals(po.getAccount())
					&& po1.getPassword().equals(po.getPassword())) {
				try {
					fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(UserList);
					ois.close();
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return re = new ResultMessage(true, su);

			} else {
				return re = new ResultMessage(false, fa);
			}
		}

		return null;
	}

}
