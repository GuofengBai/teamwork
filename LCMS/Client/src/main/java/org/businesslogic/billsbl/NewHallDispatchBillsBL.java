package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogicservice.billsblservice.NewHallDispatchBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.HallCollectionBills;
import org.po.HallDispatchBills;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.myDate;
import org.vo.HDBVO;

public class NewHallDispatchBillsBL implements NewHallDispatchBillsBLService{

	public ResultMessage newHallDispatchBill(HDBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message=null;
		try {
			BillsDataService billsData=RMIHelper.getDataFactory().getBillsDataFactory().getNewHallDispatchBillsData();
			message=billsData.addBills(new HallDispatchBills(vo.date,vo.idNum, vo.name, vo.GoodsNum));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String searchTheGood(String goodNum) {
		// TODO Auto-generated method stub
		NewSendingBillsDataService service=null;
		SendingBills bill = null;
		try {
			service = RMIHelper.getDataFactory().getBillsDataFactory().getNewSendingBillsData();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bill = (SendingBills) service.findBills(Integer.parseInt(goodNum));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = bill.getReceiverName();
		String phone = bill.getReceiverPhone();
		String location = bill.getReceiverLocation();
		return name+" "+phone+" "+location;
	}

}
