package org.data.commoditydata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.commoditydataservice.AlertLineDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.AlertPO;

public class AlertLineData  extends UnicastRemoteObject implements AlertLineDataService{
	public ArrayList<AlertPO> AlertList;
	
	public  AlertLineData() throws RemoteException{
		super();
		init();
	}
	public void init(){
		String fileName="SerializableData/Alert.file";
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        AlertList=(ArrayList<AlertPO>) ois.readObject();
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
}
