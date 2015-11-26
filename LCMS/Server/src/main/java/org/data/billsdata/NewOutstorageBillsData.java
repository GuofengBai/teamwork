package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewOutstorageBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewOutstorageBillsData extends BillsData implements NewOutstorageBillsDataService{

	public NewOutstorageBillsData() throws RemoteException {
		super("SerializableData/OB.file");
		// TODO Auto-generated constructor stub
	}

}
