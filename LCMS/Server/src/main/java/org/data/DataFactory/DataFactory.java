package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



import org.data.commoditydata.CommodityData;
import org.data.staffdata.StaffData;
import org.data.userdata.UserData;
import org.dataservice.DataFactoryService.BillsDataFactoryService;
import org.dataservice.DataFactoryService.DataFactoryService;
import org.dataservice.DataFactoryService.ManageDataFactoryService;
import org.dataservice.DataFactoryService.OrganizationDataFactoryService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.dataservice.staffdataservice.StaffDataService;
import org.dataservice.userdataservice.UserDataService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CommodityDataService commodityData;
	BillsDataFactoryService billsDataFactory;
	UserDataService userData;
	OrganizationDataFactoryService organizationDataFactory;
	StaffDataService staffData;
	ManageDataFactoryService manageDataFactory;
	

	public DataFactory() throws RemoteException{
		super();
		System.out.println("OK");
		commodityData=null;
		userData=null;
		organizationDataFactory=null;
		billsDataFactory=null;
		staffData=null;
		manageDataFactory=null;
	
	}

	public CommodityDataService getCommodityData() throws RemoteException{
        if(commodityData==null){
        	try {
				commodityData=new CommodityData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return commodityData;
	}


	public UserDataService getUserData() throws RemoteException{
		// TODO Auto-generated method stub
		if (userData == null) {
			try {
				userData = new UserData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userData;
	}


	public OrganizationDataFactoryService getOrganizationDataFactory() throws RemoteException{

		if(organizationDataFactory==null){
			try {
				organizationDataFactory=new OrganizationDataFactory();
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
		}
		
		return organizationDataFactory;
	}

	public StaffDataService getStaffData() throws RemoteException{
		// TODO Auto-generated method stub
		if(staffData==null){
			try {
				staffData=new StaffData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return staffData;
	}

	public ManageDataFactoryService getManageDataFactory() throws RemoteException{
		// TODO Auto-generated method stub
		if(manageDataFactory==null){
			try {
				manageDataFactory=new ManageDataFactory();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return manageDataFactory;
	}

	public BillsDataFactoryService getBillsDataFactory() throws RemoteException{
		// TODO Auto-generated method stub
		if(billsDataFactory==null){
			try {
				billsDataFactory=new BillsDataFactory();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return billsDataFactory;
	}


}

