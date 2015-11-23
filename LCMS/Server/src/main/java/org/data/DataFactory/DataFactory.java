package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.data.commoditydata.CommodityData;
import org.data.managedata.ManageData;
import org.data.organizationdata.OrganizationData;
import org.data.staffdata.StaffData;
import org.data.userdata.UserData;
import org.dataservice.DataFactoryService.BillsDataFactoryService;
import org.dataservice.DataFactoryService.DataFactoryService;
import org.dataservice.Impl.BillsDataServiceSerializableFileImpl;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.dataservice.managedataservice.ManageDataService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.dataservice.staffdataservice.StaffDataService;
import org.dataservice.userdataservice.UserDataService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService {
	
	CommodityDataService commodityData;
	BillsDataFactoryService billsDataFactory;
	UserDataService userData;
	OrganizationDataService organizationData;
	StaffDataService staffData;
	ManageDataService manageData;

	public DataFactory() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
		commodityData=null;
		userData=null;
		organizationData=null;
		billsDataFactory=null;
		staffData=null;
		manageData=null;
		
	}

	public CommodityDataService getCommodityData() {
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


	public UserDataService getUserData() {
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


	public OrganizationDataService getOrganizationData() {
		// TODO Auto-generated method stub
		if(organizationData==null){
			try {
				organizationData=new OrganizationData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return organizationData;
	}

	public StaffDataService getStaffData() {
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

	public ManageDataService getManageData() {
		// TODO Auto-generated method stub
		if(manageData==null){
			try {
				manageData=new ManageData();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return manageData;
	}

	public BillsDataFactoryService getBillsDataFactory() {
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

