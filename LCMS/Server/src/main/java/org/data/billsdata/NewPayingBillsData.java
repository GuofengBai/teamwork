package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewPayingBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewPayingBillsData extends BillsData implements NewPayingBillsDataService{

	public NewPayingBillsData() throws RemoteException {
		super("SerializableData/PB.file");
		// TODO Auto-generated constructor stub
	}

}
