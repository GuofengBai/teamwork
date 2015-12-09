package org.data.billsdata;

import java.rmi.RemoteException;
import java.util.Vector;

import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.po.BillsPO;
import org.po.HallCollectionBills;
import org.po.myDate;

public class NewHallCollectBillsData extends BillsData implements NewHallCollectBillsDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewHallCollectBillsData() throws RemoteException {
		super("SerializableData/HCB.file");
		// TODO Auto-generated constructor stub
	}

	public Vector<Vector<String>> getByHall(String hallNum)
			throws RemoteException {
		Vector<Vector<String>> vList=new Vector<Vector<String>>();
		for(BillsPO po:list){
			if(((HallCollectionBills)po).getHallNum().equals(hallNum)){
				vList.add(po.getInfo());
			}
		}
		return vList;
	}

	public Vector<Vector<String>> getByHallAndDate(String hallNum,
			myDate Date1, myDate Date2) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
