package org.data.organizationdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.dataservice.organizationdataservice.OrganizationDataService;

public class OrganizationData extends UnicastRemoteObject implements OrganizationDataService{

	protected OrganizationData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
