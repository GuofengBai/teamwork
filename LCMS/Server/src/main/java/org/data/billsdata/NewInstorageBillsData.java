package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewInstorageBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewInstorageBillsData extends BillsData implements NewInstorageBillsDataService{

	public NewInstorageBillsData() throws RemoteException {
		super("SerializableData/IB.file");
		// TODO Auto-generated constructor stub
	}

}
