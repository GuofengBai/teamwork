package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewInstorageBillsDataService;

public class NewInstorageBillsData extends BillsData implements NewInstorageBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewInstorageBillsData() throws RemoteException {
		super("SerializableData/IB.file");
		// TODO Auto-generated constructor stub
	}

}
