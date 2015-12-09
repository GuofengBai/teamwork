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
import org.dataservice.organizationdataservice.ManagerSettingDataService;
import org.po.CityAndDistancePO;
import org.po.ExpressFeePO;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.TRANSPORTATION;
import org.po.TransFeePO;

public class ManagerSettingData extends UnicastRemoteObject implements ManagerSettingDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CityAndDistancePO cad;
	private ExpressFeePO efp;
	private TransFeePO tfp;
	private String fileName;
	
	public ManagerSettingData() throws RemoteException {
		super();
		this.fileName="SerializableData/ManagerSetting.file";
		init();
	}

	private void init() {
	
		cad=null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        cad=(CityAndDistancePO)ois.readObject();
	        efp=(ExpressFeePO)ois.readObject();
	        tfp=(TransFeePO)ois.readObject();
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
		if(cad==null){
			cad=new CityAndDistancePO();
			efp=new ExpressFeePO();
			tfp=new TransFeePO();
		}
		save();
		
	}
	
	private void save(){
		try {
        	FileOutputStream fos = new FileOutputStream(fileName);
    		BufferedOutputStream bos = new BufferedOutputStream(fos);  
            ObjectOutputStream oos = new ObjectOutputStream(bos); 
			oos.writeObject(cad);
			oos.writeObject(efp);
			oos.writeObject(tfp);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CityAndDistancePO getCityAndDistance() throws RemoteException {
		return cad;
	}

	public ResultMessage setCityAndDistance(CityAndDistancePO po)throws RemoteException {
		cad=po;
		save();
		return null;
	}

	public double getExpressFee(SENDSTYPE type) throws RemoteException {
		double fee=efp.getFee(type);
		return fee;
	}

	public ResultMessage setExpressFee(SENDSTYPE type, double fee)throws RemoteException {
		efp.setFee(type, fee);
		save();
		return null;
	}

	public double getTransFee(TRANSPORTATION type) throws RemoteException {
		double fee=tfp.getFee(type);
		return fee;
	}

	public ResultMessage setTransFee(TRANSPORTATION type, double fee)throws RemoteException {
		tfp.setFee(type, fee);
		return null;
	}

}
