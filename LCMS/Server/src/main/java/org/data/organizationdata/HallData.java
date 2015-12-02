package org.data.organizationdata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.organizationdataservice.HallDataService;
import org.po.HallPO;
import org.po.ResultMessage;
import org.po.StaffPO;

public class HallData extends UnicastRemoteObject implements HallDataService{
	
	public ArrayList<HallPO> hallList;
	
	public HallData() throws RemoteException{
		super();
		init();
	}
	
	private void init(){
		String fileName="SerializableData/Hall.file";
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        hallList=(ArrayList<HallPO>)ois.readObject();
	        ois.close();
	        if(hallList==null){
	        	hallList=new ArrayList<HallPO>();
	        }
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

	public ResultMessage addHall(HallPO po) throws RemoteException {
		hallList.add(po);
		return null;
	}

	public ResultMessage delHall(String HallNum) throws RemoteException {
		for(HallPO po:hallList){
			if(po.getHallNum().equals(HallNum)){
				hallList.remove(po);
				return new ResultMessage(true,null);
			}
		}
		return new ResultMessage(false,null);
	}

	public HallPO findHall(String HallNum) throws RemoteException {
		for(HallPO po:hallList){
			if(po.getHallNum().equals(HallNum)){
				return po;
			}
		}
		return null;
	}

	public ResultMessage updateHall(HallPO p) throws RemoteException {
		for(HallPO po:hallList){
			if(po.getHallNum().equals(p.getHallNum())){
				po=p;
				return new ResultMessage(true,null);
			}
		}
		return new ResultMessage(false,null);
	}

	public ArrayList<HallPO> getAll() throws RemoteException {
		ArrayList<HallPO> all=new ArrayList<HallPO>();
		all.addAll(hallList);
		return all;
	}

}
