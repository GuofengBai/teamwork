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

import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.BillsPO;
import org.po.ComPO;
import org.po.ResultMessage;
import org.po.StaffPO;
import org.po.myDate;

public class CommodityData extends UnicastRemoteObject implements
		CommodityDataService {

	public ArrayList<ComPO> ComList;

	public CommodityData() throws RemoteException {
		super();
		init();
		// TODO Auto-generated constructor stub
	}
	private void init(){
		
			String fileName="SerializableData/Com.file";
			FileInputStream fis;
			try {
				fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);  
		        ObjectInputStream ois = new ObjectInputStream(bis); 
		        ComList=(ArrayList<ComPO>)ois.readObject();
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

	public ResultMessage addCom(ComPO po) throws RemoteException{
		ComList.add(po);
		save();
		return new ResultMessage(true,null);
	}
	private void save(){
		String fileName="SerializableData/Com.file";
		try {
            FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ComList);
            oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	public ResultMessage delCom(ComPO po) throws RemoteException{
		for(ComPO p:ComList){
			if(p.getGoodsNum().equals(po.getGoodsNum())){
				ComList.remove(p);
				ComList.add(po);
				save();
				String[] info={"更新信息成功"};
				ResultMessage ms=new ResultMessage(true,info);
				return ms;
			}
		}
		ResultMessage ms;
		String[] infof = { "删除失败", "没有找到货物项" };
		return ms = new ResultMessage(false, infof);

	}

	@SuppressWarnings("unchecked")
	public ComPO findCom(String GoodsNum) throws RemoteException{
        for(ComPO po:ComList){
        	if(po.getGoodsNum().equals(GoodsNum)){
        		return po;
        	}
        }
		return null;
	}
	
	public ArrayList<ComPO> getAllCom()throws RemoteException{
		
		
		return ComList;
	}

}
