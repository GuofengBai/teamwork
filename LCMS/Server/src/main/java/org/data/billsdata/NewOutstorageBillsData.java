package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewOutstorageBillsDataService;

public class NewOutstorageBillsData extends BillsData implements NewOutstorageBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewOutstorageBillsData() throws RemoteException {
		super("SerializableData/OB.file");
		// TODO Auto-generated constructor stub
	}

}
