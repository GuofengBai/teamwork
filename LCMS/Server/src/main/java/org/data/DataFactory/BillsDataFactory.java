package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.billsdata.NewSendingBillsData;
import org.dataservice.DataFactoryService.BillsDataFactoryService;
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

public class BillsDataFactory  extends UnicastRemoteObject implements BillsDataFactoryService{

	public NewSendingBillsDataService newSendingBillsData;
	public NewCenterArriveBillsDataService newCenterArriveBillsData;
	public NewCenterEntruckBillsDataService newCenterEntruckBillsData;
	public NewCenterFreightBillsDataService newCenterFreightBillsData;
	public NewHallArriveBillsDataService newHallArriveBillsData;
	public NewHallCollectBillsDataService newHallCollectBillsData;
	public NewHallDispatchBillsDataService newHallDispatchBillsData;
	public NewHallEntruckBillsDataService newHallEntruckBillsData;
	public NewInstorageBillsDataService newInstorageBillsData;
	public NewOutstorageBillsDataService newOutstorageBillsData;
	public NewPayingBillsDataService newPayingBillsData;
	
	
	
	public BillsDataFactory() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
		
		
		newSendingBillsData=null;
		newCenterArriveBillsData=null;
		newCenterEntruckBillsData=null;
		newHallArriveBillsData=null;
		newHallCollectBillsData=null;
		newHallDispatchBillsData=null;
		newHallEntruckBillsData=null;
		newInstorageBillsData=null;
		newOutstorageBillsData=null;
		newPayingBillsData=null;
	}

	public NewSendingBillsDataService getNewSendingBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newSendingBillsData==null){
			try {
				newSendingBillsData=new NewSendingBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public NewCenterArriveBillsDataService getNewCenterArriveBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
	
	public NewCenterEntruckBillsDataService getNewCenterEntruckBillsData() throws RemoteException{
		
		return null;
		
	}
	
	public NewCenterFreightBillsDataService getNewCenterFreightBillsData() throws RemoteException{
		return null;
	}

	public NewHallArriveBillsDataService getNewHallArriveBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public NewHallCollectBillsDataService getNewHallCollectBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public NewHallDispatchBillsDataService getNewHallDispatchBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public NewHallEntruckBillsDataService getNewHallEntruckBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public NewInstorageBillsDataService getNewInstorageBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public NewOutstorageBillsDataService getNewOutstorageBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public NewPayingBillsDataService getNewPayingBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}

