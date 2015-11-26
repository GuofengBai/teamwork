package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallArriveBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewHallArriveBillsData extends BillsData implements NewHallArriveBillsDataService{

	public NewHallArriveBillsData() throws RemoteException {
		super("SerializableData/HAB.file");
		// TODO Auto-generated constructor stub
	}

}
