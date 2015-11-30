package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.ExamineBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.BILLSTYPE;
import org.po.ResultMessage;

public class ExamineBillsBL implements ExamineBillsBLService{

	public ResultMessage examineBills(String type,String idNum) {
		BILLSTYPE btype = null;
		for(BILLSTYPE o:BILLSTYPE.values()){
			if(o.getType().equals(type)){
				btype=o;
				break;
			}
		}
		BillsDataService data = null;
		try {
		    switch(btype){
		    case CAB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
		             break;
		    case CFB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
                     break;
		    case CEB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
                     break;
		    case IB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewInstorageBillsData();
                     break;
		    case OB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewOutstorageBillsData();
                     break;
		    case HAB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
                     break;
		    case HDB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallDispatchBillsData();
                     break;
		    case HCB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
                     break;
		    case HEB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
                     break;
		    case SB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
                     break;
		    case PB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewPayingBillsData();
                     break;
            }
		    data.examine(idNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Vector<Vector<String>> getAllUnExaminedBills() {
		
		Vector<Vector<String>> allList=new Vector<Vector<String>>();
		Vector<Vector<String>> vList;
		BillsDataService data;
		try {
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterArriveBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallDispatchBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewInstorageBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewOutstorageBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewPayingBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
			data=RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
			if(data.getUnexaminedBillsNum()!=0){
				vList=data.getUnexaminedBills();
				allList.addAll(vList);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allList;
	}

}
