package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewHallCollectBillsData extends BillsData implements NewHallCollectBillsDataService{

	public NewHallCollectBillsData() throws RemoteException {
		super("SerializableData/HCB.file");
		// TODO Auto-generated constructor stub
	}

}
