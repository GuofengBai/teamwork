package org.data.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.data.billsdata.NewHallCollectBillsData;
import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.managedataservice.IncomeManagementDataService;
import org.po.BillsPO;
import org.po.HallCollectionBills;
import org.po.myDate;

public class IncomeManagementData extends UnicastRemoteObject implements IncomeManagementDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncomeManagementData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HallCollectionBills> incomeSearch(myDate date,
			String hallNumber) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<HallCollectionBills> list=new ArrayList<HallCollectionBills>();
		ArrayList<HallCollectionBills> result=new ArrayList<HallCollectionBills>();
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		NewHallCollectBillsDataService nhcb=new NewHallCollectBillsData();
		billList=nhcb.getAll();
		
		for(BillsPO po:billList){
			list.add((HallCollectionBills)po);
		}
		
		if(date==null&&hallNumber.equals("")){
			result=list;
		}else if(hallNumber.equals("")){
			for(HallCollectionBills bill:list){
				if(bill.getdate().compareTo(date)==0){
					result.add(bill);
				}
			}
		}else if(date==null){
			for(HallCollectionBills bill:list){
				if(bill.getidNum().equals(hallNumber)){
					result.add(bill);
				}
			}
		}else{
			for(HallCollectionBills bill:list){
				if(bill.getdate().compareTo(date)==0&&bill.getidNum().equals(hallNumber)){
					result.add(bill);
				}
			}
		}
		
		
		
		return result;
	}

}
