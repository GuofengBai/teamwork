package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.organizationdata.CenterData;
import org.data.organizationdata.DriverAndCarData;
import org.data.organizationdata.HallData;
import org.data.organizationdata.ManagerSettingData;
import org.dataservice.DataFactoryService.OrganizationDataFactoryService;
import org.dataservice.organizationdataservice.CenterDataService;
import org.dataservice.organizationdataservice.DriverAndCarDataService;
import org.dataservice.organizationdataservice.HallDataService;
import org.dataservice.organizationdataservice.ManagerSettingDataService;

public class OrganizationDataFactory extends UnicastRemoteObject implements OrganizationDataFactoryService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HallDataService hallData;
	public CenterDataService centerData;
	public ManagerSettingDataService managerSettingData;
	public DriverAndCarDataService driverAndCarData;
	
	public OrganizationDataFactory() throws RemoteException {
		super();
		hallData=null;
		centerData=null;
		managerSettingData=null;
	}

	public HallDataService getHallData() throws RemoteException {
		if(hallData==null){
			hallData=new HallData();
		}
		return hallData;
	}

	public CenterDataService getCenterData() throws RemoteException {
		if(centerData==null){
			centerData=new CenterData();
		}
		return centerData;
	}

	public ManagerSettingDataService getManagerSettingData()throws RemoteException {
		if(managerSettingData==null){
			managerSettingData=new ManagerSettingData();
		}
		return managerSettingData;
	}

	public DriverAndCarDataService getDriverAndCarData() throws RemoteException {
		if(driverAndCarData==null){
			driverAndCarData=new DriverAndCarData();
		}
		return driverAndCarData;
	}

}
