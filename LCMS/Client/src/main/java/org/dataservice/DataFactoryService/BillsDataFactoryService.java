package org.dataservice.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewCenterArriveBillsDataService;
import org.dataservice.billsdataservice.NewCenterEntruckBillsDataService;
import org.dataservice.billsdataservice.NewCenterFreightBillsDataService;
import org.dataservice.billsdataservice.NewHallArriveBillsDataService;
import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.billsdataservice.NewHallDispatchBillsDataService;
import org.dataservice.billsdataservice.NewHallEntruckBillsDataService;
import org.dataservice.billsdataservice.NewInstorageBillsDataService;
import org.dataservice.billsdataservice.NewOutstorageBillsDataService;
import org.dataservice.billsdataservice.NewPayingBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public interface BillsDataFactoryService extends Remote{
	
	public NewSendingBillsDataService getNewSendingBillsData()throws RemoteException;
	
	public NewCenterArriveBillsDataService getNewCenterArriveBillsData()throws RemoteException;
	
	public NewCenterEntruckBillsDataService getNewCenterEntruckBillsData()throws RemoteException;
	
	public NewCenterFreightBillsDataService getNewCenterFreightBillsData()throws RemoteException;
	
	public NewHallArriveBillsDataService getNewHallArriveBillsData()throws RemoteException;
	
	public NewHallCollectBillsDataService getNewHallCollectBillsData()throws RemoteException;
	
	public NewHallDispatchBillsDataService getNewHallDispatchBillsData()throws RemoteException;
	
	public NewHallEntruckBillsDataService getNewHallEntruckBillsData()throws RemoteException;
	
	public NewInstorageBillsDataService getNewInstorageBillsData()throws RemoteException;
	
	public NewOutstorageBillsDataService getNewOutstorageBillsData()throws RemoteException;
	
	public NewPayingBillsDataService getNewPayingBillsData()throws RemoteException;

	

}

