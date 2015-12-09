package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewCenterFreightBillsDataService;

public class NewCenterFreightBillsData extends BillsData implements NewCenterFreightBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewCenterFreightBillsData() throws RemoteException {
		super("SerializableData/CFB.file");
		// TODO Auto-generated constructor stub
	}

}
