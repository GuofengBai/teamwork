package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallEntruckBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewHallEntruckBillsData extends BillsData implements NewHallEntruckBillsDataService{

	public NewHallEntruckBillsData() throws RemoteException {
		super("SerializableData/HEB.file");
		// TODO Auto-generated constructor stub
	}

}
