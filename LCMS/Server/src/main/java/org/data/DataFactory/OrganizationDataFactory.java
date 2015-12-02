package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.organizationdata.HallData;
import org.dataservice.DataFactoryService.OrganizationDataFactoryService;
import org.dataservice.organizationdataservice.HallDataService;

public class OrganizationDataFactory extends UnicastRemoteObject implements OrganizationDataFactoryService{

	public HallDataService hallData;
	
	
	public OrganizationDataFactory() throws RemoteException {
		super();
		hallData=null;
	}

	public HallDataService getHallData() throws RemoteException {
		if(hallData==null){
			hallData=new HallData();
		}
		return hallData;
	}

}
