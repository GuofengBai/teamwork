package org.data.billsdata;

import java.rmi.RemoteException;

import org.dataservice.billsdataservice.NewPayingBillsDataService;

public class NewPayingBillsData extends BillsData implements NewPayingBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewPayingBillsData() throws RemoteException {
		super("SerializableData/PB.file");
		// TODO Auto-generated constructor stub
	}

}
