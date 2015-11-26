package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallDispatchBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewHallDispatchBillsData extends BillsData implements NewHallDispatchBillsDataService{

	public NewHallDispatchBillsData() throws RemoteException {
		super("SerializableData/HDB.file");
		// TODO Auto-generated constructor stub
	}

}
