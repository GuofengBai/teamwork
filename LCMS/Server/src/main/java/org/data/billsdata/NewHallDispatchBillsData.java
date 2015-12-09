package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallDispatchBillsDataService;

public class NewHallDispatchBillsData extends BillsData implements NewHallDispatchBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewHallDispatchBillsData() throws RemoteException {
		super("SerializableData/HDB.file");
		// TODO Auto-generated constructor stub
	}

}
