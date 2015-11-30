package org.businesslogic.managebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.manageblservice.CostManagementBLService;
import org.dataservice.managedataservice.CostManagementDataService;
import org.po.PayingBills;
import org.po.ResultMessage;
import org.vo.PayingBillVO;

public class CostManagementBL implements CostManagementBLService {

	public Vector<PayingBillVO> getAllBill() {
		// TODO Auto-generated method stub
		ArrayList<PayingBills> list=new ArrayList<PayingBills>();
		Vector<PayingBillVO> volist=new Vector<PayingBillVO>();
		try {
			CostManagementDataService cmd=RMIHelper.getDataFactory().getManageDataFactory().getCostManagementData();
			list=cmd.getAllBill();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(PayingBills bill:list){
			PayingBillVO voTemp=new PayingBillVO(bill);
			volist.add(voTemp);
		}
		
		
		return volist;
	}

	public ResultMessage changeBill(int index, PayingBills newBill) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		try {
			CostManagementDataService cmd=RMIHelper.getDataFactory().getManageDataFactory().getCostManagementData();
			message=cmd.changeBill(index, newBill);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public ResultMessage delBill(int index) {
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		try {
			CostManagementDataService cmd=RMIHelper.getDataFactory().getManageDataFactory().getCostManagementData();
			message=cmd.delBill(index);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}


}
