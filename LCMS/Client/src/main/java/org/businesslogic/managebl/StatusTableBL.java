package org.businesslogic.managebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.StatusTableBLService;
import org.dataservice.managedataservice.StatusTableDataService;
import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.myDate;
import org.vo.IncomeBillVO;
import org.vo.PayingBillVO;

public class StatusTableBL implements StatusTableBLService {

	public Vector<IncomeBillVO> searchIncomeBill(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		Vector<IncomeBillVO> volist=new Vector<IncomeBillVO>();
		ArrayList<HallCollectionBills> list=new ArrayList<HallCollectionBills>();
		try {
			StatusTableDataService std=RMIHelper.getDataFactory().getManageDataFactory().getStatusTableData();
			list=std.searchIncomeBill(date1, date2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(HallCollectionBills bill:list){
			IncomeBillVO votemp=new IncomeBillVO(bill);
			volist.add(votemp);
		}

		return volist;
	}

	public Vector<PayingBillVO> searchPayingBill(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		Vector<PayingBillVO> volist=new Vector<PayingBillVO>();
		ArrayList<PayingBills> list=new ArrayList<PayingBills>();
		try {
			StatusTableDataService std=RMIHelper.getDataFactory().getManageDataFactory().getStatusTableData();
			list=std.searchPayingBill(date1, date2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PayingBills bill:list){
			PayingBillVO votemp=new PayingBillVO(bill);
			volist.add(votemp);
		}
		
		return volist;
	}

	

}
