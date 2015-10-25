package org.businesslogic.billsbl;

import org.businesslogicservice.billsblservice.BillsBLService;
import org.po.ResultMessage;
import org.po.myDate;

public class BillsBL implements BillsBLService{

	public ResultMessage newCenterArriveBill(String CenterNum, String BillNum,
			myDate date, String State) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newCenterFreightBill(String BillNum, myDate date,
			String ContainerNum, String Means, String Name, String StartPlace,
			String EndPlace, long[] GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newCenterEntruckBill(String TravelNum, myDate date,
			String TrafficNum, String HallNum, String Name, long[] GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newInstorageBill(long GoodsNum, myDate date,
			String Place, String LocationNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newOutstorageBill(long GoodsNum, myDate date,
			String FreightNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newHallArrivingBill(myDate date, String FreightNum,
			String StartPlace, String State) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newHallDispatchBill(myDate date, long GoodsNum,
			String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newHallColletcionBill(myDate date, int Cash,
			String name, long[] GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newHallLoadingBill(myDate date, String HallNum,
			String TravelNum, String TrafficNum, String EndPlace, String name,
			long[] GoodsNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newSendingBill(myDate date, long GoodsNum, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage newPayingBill(myDate date, long Cash, String name,
			String PayNum, String[] Item) {
		// TODO Auto-generated method stub
		return null;
	}

}
