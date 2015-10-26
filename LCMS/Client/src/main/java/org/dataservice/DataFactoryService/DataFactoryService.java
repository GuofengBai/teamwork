package org.dataservice.DataFactoryService;

import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.dataservice.managedataservice.ManageDataService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.dataservice.staffdataservice.StaffDataService;
import org.dataservice.userdataservice.UserDataService;

public interface DataFactoryService {

	public CommodityDataService getCommodityData();
	
	public BillsDataService getBillsData();
	
	public UserDataService getUserData();
	
	public OrganizationDataService getOrganizationData();
	
	public StaffDataService getStaffData();
	
	public ManageDataService getManageData();
	
}