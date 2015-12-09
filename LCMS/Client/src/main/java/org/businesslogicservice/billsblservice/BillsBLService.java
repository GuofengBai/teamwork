package org.businesslogicservice.billsblservice;

import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.myDate;

public interface BillsBLService {
	public ResultMessage newCenterArriveBill(String CenterNum,String BillNum,myDate date,String State);
	public ResultMessage newCenterFreightBill(String BillNum,myDate date,String ContainerNum,String Means,String Name,String StartPlace,String EndPlace,long[] GoodsNum);
	public ResultMessage newCenterEntruckBill(String TravelNum,myDate date,String TrafficNum,String HallNum,String Name,long[] GoodsNum);
	public ResultMessage newInstorageBill(long GoodsNum,myDate date,String Place,String LocationNum);
	public ResultMessage newOutstorageBill(long GoodsNum,myDate date,String FreightNum);
	public ResultMessage newHallArrivingBill(myDate date,String FreightNum,String StartPlace,String State);
	public ResultMessage newHallDispatchBill(myDate date,long GoodsNum,String name);
	public ResultMessage newHallColletcionBill(myDate date,int Cash,String name,long[] GoodsNum);
	public ResultMessage newHallLoadingBill(myDate date,String HallNum,String TravelNum,String TrafficNum,String EndPlace,String name,long[] GoodsNum);
	public ResultMessage newSendingBill(myDate Date,BOXSTYPE boxstype,SENDSTYPE sendstype,String startplace,String endplace,String location,long GoodsNum,String name);
	public ResultMessage newPayingBill(myDate date,long Cash,String name,String PayNum,String[] Item);
}
