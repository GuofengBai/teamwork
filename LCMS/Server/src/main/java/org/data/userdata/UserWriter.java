package org.data.userdata;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.po.GENDER;
import org.po.Payment;
import org.po.STAFFROLE;
import org.po.StaffPO;
import org.po.UserPO;
import org.po.WorkSpace;
import org.po.myDate;

public class UserWriter {
	String fileName = "SerializableData/User.file";
	ArrayList<UserPO> UserList=new ArrayList<UserPO>();
	public static void main(String[] args){
		UserWriter uw=new UserWriter();
		uw.add();
		uw.write();
	}
	public void write() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(UserList);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(){
		UserPO po=new UserPO();
		WorkSpace ws=new WorkSpace();
		ws.type="总部";
		ws.num="0";
		StaffPO pos=new StaffPO("牛大","0001",GENDER.FEMALE,new myDate(2016,11,22),"总部","110","不告诉你",
				ws,new Payment("现金",100000),"0001","0001",STAFFROLE.ADMINISTRATOR);
		po=pos.user;
		System.out.println(po.getAccount()+po.getPassword());
		UserList.add(po);
	}
}
