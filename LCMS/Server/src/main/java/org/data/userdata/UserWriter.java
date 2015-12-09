package org.data.userdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.po.UserPO;

public class UserWriter {
	public static void main(String[] args) throws RemoteException {
		try {
			ArrayList<UserPO> UserList=new ArrayList<UserPO>();
			UserPO admin=new UserPO("admin","admin","-1");
			UserList.add(admin);
			FileOutputStream fos = new FileOutputStream(
					"SerializableData/User.file");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(UserList);

			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
