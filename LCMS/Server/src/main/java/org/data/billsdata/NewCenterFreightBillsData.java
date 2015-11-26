package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewCenterFreightBillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;

public class NewCenterFreightBillsData extends BillsData implements NewCenterFreightBillsDataService{

	public NewCenterFreightBillsData() throws RemoteException {
		super("SerializableData/CFB.file");
		// TODO Auto-generated constructor stub
	}

}
