package org.data.commoditydata;

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

import org.dataservice.commoditydataservice.AlertLineDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.AlertPO;
import org.po.ResultMessage;
import org.po.StaffPO;

public class AlertLineData extends UnicastRemoteObject implements
		AlertLineDataService {
	public ArrayList<AlertPO> AlertList;

	public AlertLineData() throws RemoteException {
		super();
		init();
	}

	public ResultMessage add(AlertPO po) {
		String[] fa={"增加失败","已存在货运单号对应的货物"};
		for(AlertPO p:AlertList){
			if(p.getcenterNum().equals(po.getcenterNum())){
				return new ResultMessage(false,fa);
			}
		}
		AlertList.add(po);
		save();
		return new ResultMessage(true,null);
	}
	
	public ResultMessage del(AlertPO po) {
		for(AlertPO p:AlertList){
			if(p.getcenterNum().equals(po.getcenterNum())){
				AlertList.remove(po);
				save();
				String[] info={"删除成功"};
				ResultMessage ms=new ResultMessage(true,info);
				return ms;
			}
		}
		String[] info={"删除错误，未找到"}; 
		ResultMessage ms=new ResultMessage(false,info);
		return ms;
	}

	public AlertPO find(String centerNum) {
		for (AlertPO po : AlertList) {
			if (po.getcenterNum().equals(centerNum)) {
				return po;
			}
		}
		return null;
	}

	public void init() {
		String fileName = "SerializableData/Alert.file";
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			AlertList = (ArrayList<AlertPO>) ois.readObject();
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

	private void save() {
		String fileName = "SerializableData/Com.file";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(AlertList);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
