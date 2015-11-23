package org.data.staffdata;

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
import java.util.Vector;

import org.dataservice.staffdataservice.StaffDataService;
import org.po.ResultMessage;
import org.po.StaffPO;

public class StaffData extends UnicastRemoteObject implements StaffDataService{
	
	private ArrayList<StaffPO> staffList;

	public StaffData() throws RemoteException {
		super();
		init();
	}
	
	public void init(){
		String fileName="SerializableData/Staff.file";
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        staffList=(ArrayList<StaffPO>)ois.readObject();
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

	public ResultMessage add(StaffPO po) {
		staffList.add(po);
		save();
		return null;
	}

	public ResultMessage remove(String num) {
		for(StaffPO po:staffList){
			if(po.num.equals(num)){
				staffList.remove(po);
				save();
				String[] info={"删除成功"};
				ResultMessage ms=new ResultMessage(true,info);
				return ms;
			}
		}
		String[] info={"删除错误，未找到编号为"+num+"的员工"}; 
		ResultMessage ms=new ResultMessage(false,info);
		return ms;
	}

	public ResultMessage update(StaffPO po) {
		for(StaffPO p:staffList){
			if(p.num.equals(po.num)){
				staffList.remove(p);
				staffList.add(po);
				save();
				String[] info={"更新信息成功"};
				ResultMessage ms=new ResultMessage(true,info);
				return ms;
			}
		}
		String[] info={"更新错误，未找到编号为"+po.num+"的员工"}; 
		ResultMessage ms=new ResultMessage(false,info);
		return ms;
	}

	public StaffPO find(String num) {
        for(StaffPO po:staffList){
        	if(po.num.equals(num)){
        		return po;
        	}
        }
		return null;
	}

	public ArrayList<StaffPO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage save(){
		String fileName="SerializableData/Staff.file";
		try {
            FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(staffList);
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

	public Vector<String[]> getAllStaffInfo() {
		Vector<String[]> allInfo=new Vector<String[]>();
		for(StaffPO po:staffList){
			allInfo.add(po.getInfo());
		}
		return allInfo;
	}

}
