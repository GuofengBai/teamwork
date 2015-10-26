package org.data.DataFactory;

import java.rmi.RemoteException;

import org.dataservice.DataFactoryService.DataFactoryService;
import org.dataservice.Impl.BillsDataServiceSerializableFileImpl;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.dataservice.managedataservice.ManageDataService;
import org.dataservice.organizationdataservice.OrganizationDataService;
import org.dataservice.staffdataservice.StaffDataService;
import org.dataservice.userdataservice.UserDataService;

public class DataFactory implements DataFactoryService {

	public CommodityDataService getCommodityData() {
		// TODO Auto-generated method stub
//		CommodityDataService data = new CommodityDataServiceTxtFileImpl();            //鍟嗗搧鏁版嵁鎿嶄綔txt瀹炵幇
//		CommodityDataService data = new CommodityDataServiceSerializableFileImpl();   //鍟嗗搧鏁版嵁鎿嶄綔搴忓垪鍖栨枃浠跺疄鐜�
//		CommodityDataService data = new CommodityDataServiceMysqlImpl();              //鍟嗗搧鏁版嵁鎿嶄綔Mysql瀹炵幇
//		return data;
		return null;
	}

	public BillsDataService getBillsData() {
		// TODO Auto-generated method stub
		try {
			BillsDataService data=new BillsDataServiceSerializableFileImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrganizationDataService getOrganizationData() {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffDataService getStaffData() {
		// TODO Auto-generated method stub
		return null;
	}

	public ManageDataService getManageData() {
		// TODO Auto-generated method stub
		return null;
	}

}

