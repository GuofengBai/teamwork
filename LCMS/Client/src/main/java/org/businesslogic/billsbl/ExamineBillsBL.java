package org.businesslogic.billsbl;

import java.rmi.RemoteException;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.ExamineBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.BILLSTYPE;
import org.po.CenterArriveBills;
import org.po.CenterEntruckBills;
import org.po.CenterFreightBills;
import org.po.HallArrivingBills;
import org.po.HallCollectionBills;
import org.po.HallDispatchBills;
import org.po.HallEntruckBills;
import org.po.InstorageBills;
import org.po.OutstorageBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.vo.CABVO;
import org.vo.CEBVO;
import org.vo.CFBVO;
import org.vo.HABVO;
import org.vo.HCBVO;
import org.vo.HDBVO;
import org.vo.HEBVO;
import org.vo.IBVO;
import org.vo.OBVO;
import org.vo.PanelCreaterService;
import org.vo.SBVO;

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

	public PanelCreaterService getPanelCreater(String type, String idNum) {

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
		             CABVO cab=new CABVO((CenterArriveBills) data.findBills(idNum));
		             return cab;
		    case CFB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterFreightBillsData();
		             CFBVO cfb=new CFBVO((CenterFreightBills) data.findBills(idNum));
                     return cfb;
		    case CEB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewCenterEntruckBillsData();
                     CEBVO ceb=new CEBVO((CenterEntruckBills) data.findBills(idNum));
                     return ceb;
		    case IB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewInstorageBillsData();
                     IBVO ib=new IBVO((InstorageBills) data.findBills(idNum));
                     return ib;
		    case OB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewOutstorageBillsData();
                     OBVO ob=new OBVO((OutstorageBills) data.findBills(idNum));
                     return ob;
		    case HAB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallArriveBillsData();
                     HABVO hab=new HABVO((HallArrivingBills) data.findBills(idNum));
                     return hab;
		    case HDB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallDispatchBillsData();
                     HDBVO hdb=new HDBVO((HallDispatchBills) data.findBills(idNum));
                     return hdb;
		    case HCB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallCollectBillsData();
                     HCBVO hcb=new HCBVO((HallCollectionBills) data.findBills(idNum));
                     return hcb;
		    case HEB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallEntruckBillsData();
                     HEBVO heb=new HEBVO((HallEntruckBills) data.findBills(idNum));
                     return heb;
		    case SB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
                     SBVO sb=new SBVO((SendingBills) data.findBills(idNum));
                     return sb;
		    case PB:data=RMIHelper.getDataFactory().getBillsDataFactory().getNewPayingBillsData();
                     return null; 
            }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
		
		    
		    

}
