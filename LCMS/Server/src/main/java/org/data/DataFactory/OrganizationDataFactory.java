package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.organizationdata.CenterData;
import org.data.organizationdata.HallData;
import org.dataservice.DataFactoryService.OrganizationDataFactoryService;
import org.dataservice.organizationdataservice.CenterDataService;
import org.dataservice.organizationdataservice.HallDataService;

public class OrganizationDataFactory extends UnicastRemoteObject implements OrganizationDataFactoryService{

	public HallDataService hallData;
	public CenterDataService centerData;
	
	
	public OrganizationDataFactory() throws RemoteException {
		super();
		hallData=null;
		centerData=null;
	}

	public HallDataService getHallData() throws RemoteException {
		if(hallData==null){
			hallData=new HallData();
		}
		return hallData;
	}

	public CenterDataService getCenter() throws RemoteException {
		if(centerData==null){
			centerData=new CenterData();
		}
		return centerData;
	}

}
