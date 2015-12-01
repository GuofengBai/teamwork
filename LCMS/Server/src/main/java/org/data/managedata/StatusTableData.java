package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.data.billsdata.NewHallCollectBillsData;
import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.managedataservice.CostManagementDataService;
import org.dataservice.managedataservice.StatusTableDataService;
import org.po.BillsPO;
import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;

public class StatusTableData extends UnicastRemoteObject implements StatusTableDataService {

	public StatusTableData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HallCollectionBills> searchIncomeBill(myDate date1,
			myDate date2) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<HallCollectionBills> list=new ArrayList<HallCollectionBills>();
		ArrayList<HallCollectionBills> result=new ArrayList<HallCollectionBills>();
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		NewHallCollectBillsDataService nhcb=new NewHallCollectBillsData();
		billList=nhcb.getAll();		
		for(BillsPO po:billList){
			list.add((HallCollectionBills)po);
		}
		
		for(HallCollectionBills bill:list){
			if((bill.getdate().compareTo(date1))>=0&&(bill.getdate().compareTo(date2))<=0){
				result.add(bill);
			}
		}
		
		return result;
	}

	public ArrayList<PayingBills> searchPayingBill(myDate date1, myDate date2) throws RemoteException{
		// TODO Auto-generated method stub
		
		CostManagementDataService cmd=new CostManagementData();
		
		return cmd.getBillByTime(date1, date2);
	}

}
