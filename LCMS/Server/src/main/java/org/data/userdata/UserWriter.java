package org.data.userdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.data.staffdata.StaffData;
import org.dataservice.staffdataservice.StaffDataService;
import org.po.CenterCom;
import org.po.GENDER;
import org.po.Payment;
import org.po.STAFFROLE;
import org.po.StaffPO;
import org.po.UserPO;
import org.po.WorkSpace;
import org.po.myDate;

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
		StaffDataService sds=new StaffData();
		StaffPO adminstaff=new StaffPO(STAFFROLE.ADMINISTRATOR,"上帝",String num,GENDER gender,myDate birthday,String location,String phone,String user,String bankAccount,WorkSpace space,Payment payment);
	}
}
