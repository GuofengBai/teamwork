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

import org.dataservice.organizationdataservice.DriverAndCarDataService;
import org.po.CarPO;
import org.po.DriverPO;
import org.po.ResultMessage;

public class DriverAndCarData extends UnicastRemoteObject implements DriverAndCarDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<CarPO> carList;
	private ArrayList<DriverPO> driverList;
	private String fileName;

	public DriverAndCarData() throws RemoteException {
		super();
		fileName="SerializableData/DriverAndCar.file";
		init();
	}
	
	@SuppressWarnings("unchecked")
	private void init(){
		
		carList=null;
		driverList=null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis); 
	        carList=(ArrayList<CarPO>)ois.readObject();
	        driverList=(ArrayList<DriverPO>)ois.readObject();
	        ois.close();
	        if(carList==null){
	        	carList=new ArrayList<CarPO>();
	        	driverList=new ArrayList<DriverPO>();
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
		if(carList==null){
        	carList=new ArrayList<CarPO>();
        	driverList=new ArrayList<DriverPO>();
        }
		save();
	}

	private void save() {
		 try {
	        	FileOutputStream fos = new FileOutputStream(fileName);
	    		BufferedOutputStream bos = new BufferedOutputStream(fos);  
	            ObjectOutputStream oos = new ObjectOutputStream(bos); 
				oos.writeObject(carList);
				oos.writeObject(driverList);
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}

	public ResultMessage addCar(CarPO po) throws RemoteException {
		carList.add(po);
		save();
		return null;
	}

	public ResultMessage addDriver(DriverPO po) throws RemoteException {
		driverList.add(po);
		save();
		return null;
	}

	public ResultMessage delCar(String CarNum) throws RemoteException {
		for(CarPO po:carList){
			if(po.getcarNum().equals(CarNum)){
				carList.remove(po);
				save();
				break;
			}
		}
		return null;
	}

	public ResultMessage delDriver(String driverNum) throws RemoteException {
		for(DriverPO po:driverList){
			if(po.getdriverNum().equals(driverNum)){
				driverList.remove(po);
				save();
				break;
			}
		}
		return null;
	}

	public CarPO findCar(String CarNum) throws RemoteException {
		for(CarPO po:carList){
			if(po.getcarNum().equals(CarNum)){
				return po;
			}
		}
		return null;
	}

	public DriverPO findDriver(String driverNum) throws RemoteException {
		for(DriverPO po:driverList){
			if(po.getdriverNum().equals(driverNum)){
				return po;
			}
		}
		return null;
	}

	public ArrayList<CarPO> findCarByHall(String HallNum)
			throws RemoteException {
		ArrayList<CarPO> cl=new ArrayList<CarPO>();
		for(CarPO po:carList){
			if(po.getHallNum().equals(HallNum)){
				cl.add(po);
			}
		}
		return cl;
	}

	public ArrayList<DriverPO> findDriverByHall(String HallNum)
			throws RemoteException {
		ArrayList<DriverPO> dl=new ArrayList<DriverPO>();
		for(DriverPO po:driverList){
			if(po.getHallNum().equals(HallNum)){
				dl.add(po);
			}
		}
		return dl;
	}


	
}
