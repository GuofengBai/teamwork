package org.data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
	BillsDataService billsData;
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
		billsData=null;
		staffData=null;
		manageData=null;
		
	}

	public CommodityDataService getCommodityData() {
        if(commodityData==null){
        	commodityData=new CommodityData();
        }
		return commodityData;
	}

	public BillsDataService getBillsData() {
		
		return null;
	}

	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrganizationDataService getOrganizationData() {
		// TODO Auto-generated method stub
		if(organizationData==null){
			organizationData=new OrganizationData();
		}
		
		return organizationData;
	}

	public StaffDataService getStaffData() {
		// TODO Auto-generated method stub
		if(staffData==null){
			staffData=new StaffData();
		}
		return staffData;
	}

	public ManageDataService getManageData() {
		// TODO Auto-generated method stub
		if(manageData==null){
			manageData=new ManageData();
		}
		return manageData;
	}

}

