package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewCenterArriveBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewCenterArriveBillsData extends BillsData implements NewCenterArriveBillsDataService{

	public NewCenterArriveBillsData() throws RemoteException {
		super("SerializableData/CAB.file");
		// TODO Auto-generated constructor stub
	}

}
