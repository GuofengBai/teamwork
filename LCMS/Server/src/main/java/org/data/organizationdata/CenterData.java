package org.data.organizationdata;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.organizationdataservice.CenterDataService;
import org.po.CenterPO;
import org.po.HallPO;
import org.po.ResultMessage;

public class CenterData  extends UnicastRemoteObject implements CenterDataService{

	public ArrayList<CenterPO> centerList;
	private String fileName;
	
	public CenterData() throws RemoteException{
		super();
		fileName="SerializableData/Center.file";
		init();
	}
	
	private void init(){
		
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        centerList=(ArrayList<CenterPO>)ois.readObject();
	        ois.close();
	        if(centerList==null){
	        	centerList=new ArrayList<CenterPO>();
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

	public ResultMessage addCenter(CenterPO po) throws RemoteException {
		centerList.add(po);
		save();
		return null;
	}

	public ResultMessage delCenter(String CenterNum) throws RemoteException {
		for(CenterPO po:centerList){
			if(po.getCenterNum().equals(CenterNum)){
				centerList.remove(po);
				save();
				return new ResultMessage(true,null);
			}
		}
		return new ResultMessage(false,null);
	}

	public CenterPO findCenter(String CenterNum) throws RemoteException {
		for(CenterPO po:centerList){
			if(po.getCenterNum().equals(CenterNum)){
				return po;
			}
		}
		return null;
	}

	public ResultMessage updateCenter(CenterPO p) throws RemoteException {
		for(CenterPO po:centerList){
			if(po.getCenterNum().equals(p.getCenterNum())){
				po=p;
				save();
				return new ResultMessage(true,null);
			}
		}
		return new ResultMessage(false,null);
	}

	public ArrayList<CenterPO> getAll() throws RemoteException {
		ArrayList<CenterPO> all=new ArrayList<CenterPO>();
		all.addAll(centerList);
		return all;
	}
	
	private void save(){
		
        try {
        	FileOutputStream fos = new FileOutputStream(fileName);
    		BufferedOutputStream bos = new BufferedOutputStream(fos);  
            ObjectOutputStream oos = new ObjectOutputStream(bos); 
			oos.writeObject(centerList);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
