package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallEntruckBillsDataService;

public class NewHallEntruckBillsData extends BillsData implements NewHallEntruckBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewHallEntruckBillsData() throws RemoteException {
		super("SerializableData/HEB.file");
		// TODO Auto-generated constructor stub
	}

}
