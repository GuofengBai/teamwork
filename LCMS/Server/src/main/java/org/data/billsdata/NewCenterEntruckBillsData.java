package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewCenterArriveBillsDataService;
import org.dataservice.billsdataservice.NewCenterEntruckBillsDataService;

public class NewCenterEntruckBillsData extends BillsData implements NewCenterEntruckBillsDataService{

	public NewCenterEntruckBillsData() throws RemoteException {
		super("SerializableData/CEB.file");
		// TODO Auto-generated constructor stub
	}

}
