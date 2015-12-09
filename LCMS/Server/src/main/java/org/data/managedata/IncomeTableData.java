package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.data.billsdata.NewHallCollectBillsData;
import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.managedataservice.CostManagementDataService;
import org.dataservice.managedataservice.IncomeTableDataService;
import org.po.BillsPO;
import org.po.HallCollectionBills;
import org.po.PayingBills;

public class IncomeTableData extends UnicastRemoteObject implements IncomeTableDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncomeTableData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIncome() throws RemoteException{
		// TODO Auto-generated method stub
		long result=0;
		ArrayList<HallCollectionBills> list=new ArrayList<HallCollectionBills>();
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		NewHallCollectBillsDataService nhcb=new NewHallCollectBillsData();
		billList=nhcb.getAll();		
		for(BillsPO po:billList){
			list.add((HallCollectionBills)po);
		}
		for(HallCollectionBills bill:list){
			result=result+Long.parseLong(bill.gettotal());
		}
		
		return result;
	}

	public long getPayment() throws RemoteException{
		// TODO Auto-generated method stub
		long result=0;
		
		CostManagementDataService cmd=new CostManagementData();
		ArrayList<PayingBills> list=new ArrayList<PayingBills>();
		list=cmd.getAllBill();
		
		for(PayingBills bill:list){
			result=result+bill.getMoney();
		}
		
		
		return result;
	}

}
