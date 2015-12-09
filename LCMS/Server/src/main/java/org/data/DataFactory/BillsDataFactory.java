package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.billsdata.NewCenterArriveBillsData;
import org.data.billsdata.NewCenterEntruckBillsData;
import org.data.billsdata.NewCenterFreightBillsData;
import org.data.billsdata.NewHallArriveBillsData;
import org.data.billsdata.NewHallCollectBillsData;
import org.data.billsdata.NewHallDispatchBillsData;
import org.data.billsdata.NewHallEntruckBillsData;
import org.data.billsdata.NewInstorageBillsData;
import org.data.billsdata.NewOutstorageBillsData;
import org.data.billsdata.NewPayingBillsData;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		return newSendingBillsData;
	}

	public NewCenterArriveBillsDataService getNewCenterArriveBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newCenterArriveBillsData==null){
			try {
				newCenterArriveBillsData=new NewCenterArriveBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newCenterArriveBillsData;
	}
	
	public NewCenterEntruckBillsDataService getNewCenterEntruckBillsData() throws RemoteException{
		// TODO Auto-generated method stub
				if(newCenterEntruckBillsData==null){
					try {
						newCenterEntruckBillsData=new NewCenterEntruckBillsData();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return newCenterEntruckBillsData;
	}
	
	public NewCenterFreightBillsDataService getNewCenterFreightBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newCenterFreightBillsData==null){
			try {
				newCenterFreightBillsData=new NewCenterFreightBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newCenterFreightBillsData;
	}

	public NewHallArriveBillsDataService getNewHallArriveBillsData() throws RemoteException{
		// TODO Auto-generated method stub
				if(newHallArriveBillsData==null){
					try {
						newHallArriveBillsData=new NewHallArriveBillsData();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return newHallArriveBillsData;
	}

	public NewHallCollectBillsDataService getNewHallCollectBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newHallCollectBillsData==null){
			try {
				newHallCollectBillsData=new NewHallCollectBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newHallCollectBillsData;
	}

	public NewHallDispatchBillsDataService getNewHallDispatchBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newHallDispatchBillsData==null){
			try {
				newHallDispatchBillsData=new NewHallDispatchBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newHallDispatchBillsData;
	}

	public NewHallEntruckBillsDataService getNewHallEntruckBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newHallEntruckBillsData==null){
			try {
				newHallEntruckBillsData=new NewHallEntruckBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newHallEntruckBillsData;
	}

	public NewInstorageBillsDataService getNewInstorageBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newInstorageBillsData==null){
			try {
				newInstorageBillsData=new NewInstorageBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newInstorageBillsData;
	}

	public NewOutstorageBillsDataService getNewOutstorageBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newOutstorageBillsData==null){
			try {
				newOutstorageBillsData=new NewOutstorageBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newOutstorageBillsData;
	}

	public NewPayingBillsDataService getNewPayingBillsData() throws RemoteException{
		// TODO Auto-generated method stub
		if(newPayingBillsData==null){
			try {
				newPayingBillsData=new NewPayingBillsData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newPayingBillsData;
	}

}

