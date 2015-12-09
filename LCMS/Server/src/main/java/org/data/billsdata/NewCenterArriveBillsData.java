package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewCenterArriveBillsDataService;


public class NewCenterArriveBillsData extends BillsData implements NewCenterArriveBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewCenterArriveBillsData() throws RemoteException {
		super("SerializableData/CAB.file");
		// TODO Auto-generated constructor stub
	}

}
