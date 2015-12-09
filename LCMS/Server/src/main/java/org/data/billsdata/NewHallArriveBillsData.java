package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewHallArriveBillsDataService;

public class NewHallArriveBillsData extends BillsData implements NewHallArriveBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewHallArriveBillsData() throws RemoteException {
		super("SerializableData/HAB.file");
		// TODO Auto-generated constructor stub
	}

}
