package org.businesslogic.managebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.IncomeManagementBLService;
import org.dataservice.managedataservice.IncomeManagementDataService;
import org.po.HallCollectionBills;
import org.po.myDate;
import org.test.dataservice.manageData.IncomeManagementData;
import org.vo.IncomeBillVO;

public class IncomeManagementBL implements IncomeManagementBLService {

	public Vector<IncomeBillVO> incomeSearch(myDate date, String hallNumber) {
		// TODO Auto-generated method stub
		
		ArrayList <HallCollectionBills> list=new ArrayList<HallCollectionBills>();
		Vector<IncomeBillVO> volist=new Vector<IncomeBillVO>();
		try {
			IncomeManagementDataService imd=RMIHelper.getDataFactory().getManageDataFactory().getIncomeManagementData();
			list=imd.incomeSearch(date, hallNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (HallCollectionBills bill:list){
			IncomeBillVO votemp=new IncomeBillVO(bill);
			volist.add(votemp);
		}
		
		return volist;
		
	}


}
