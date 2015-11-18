package org.dataservice.DataFactoryService;

import java.rmi.Remote;

import org.dataservice.billsdataservice.NewCenterArriveBillsDataService;
import org.dataservice.billsdataservice.NewHallArriveBillsDataService;
import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.billsdataservice.NewHallDispatchBillsDataService;
import org.dataservice.billsdataservice.NewHallEntruckBillsDataService;
import org.dataservice.billsdataservice.NewInstorageBillsDataService;
import org.dataservice.billsdataservice.NewOutstorageBillsDataService;
import org.dataservice.billsdataservice.NewPayingBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public interface BillsDataFactoryService extends Remote{
	
	public NewSendingBillsDataService getNewSendingBillsData();
	
	public NewCenterArriveBillsDataService getNewCenterArriveBillsData();
	
	public NewHallArriveBillsDataService getNewHallArriveBillsData();
	
	public NewHallCollectBillsDataService getNewHallCollectBillsData();
	
	public NewHallDispatchBillsDataService getNewHallDispatchBillsData();
	
	public NewHallEntruckBillsDataService getNewHallEntruckBillsData();
	
	public NewInstorageBillsDataService getNewInstorageBillsData();
	
	public NewOutstorageBillsDataService getNewOutstorageBillsData();
	
	public NewPayingBillsDataService getNewPayingBillsData();
	

}

