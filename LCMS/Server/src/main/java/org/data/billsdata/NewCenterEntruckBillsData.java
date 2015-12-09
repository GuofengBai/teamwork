package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewCenterEntruckBillsDataService;

public class NewCenterEntruckBillsData extends BillsData implements NewCenterEntruckBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewCenterEntruckBillsData() throws RemoteException {
		super("SerializableData/CEB.file");
		// TODO Auto-generated constructor stub
	}

}
