package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.MockManagerSettingBL;
import org.Client.RMIHelper;
import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.po.myDate;

public class NewSendingBillsBL implements NewSendingBillsBLService{
	
	
	public ResultMessage addSendingBills(String SenderName, 
			String ReceiverName, String SenderPhone, String 
			ReceiverPhone, String SenderLocation, String 
			ReceiverLocation, myDate date, String GoodsNum, 
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, 
			String width, String height, String weight) {
		// TODO Auto-generated method stub
		BillsDataService billsData=RMIHelper.getDataFactory().getBillsData();
		ResultMessage message=null;
		try {
			message=billsData.addBills(new SendingBills(SenderName,ReceiverName,SenderPhone,ReceiverPhone,SenderLocation,
					ReceiverLocation,date,GoodsNum,boxtype,sendtype,length,width,height,weight));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getPrice(String SenderLocation, String ReceiverLocation,
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, String width,
			String height, String weight) {
		// TODO Auto-generated method stub
		String[] city1 = SenderLocation.split("市");
		String[] city2 = ReceiverLocation.split("市");
		double size=Double.parseDouble(length)*Double.parseDouble(width)*Double.parseDouble(height)/5000;
		double heavy=Double.parseDouble(weight);
		if(size>heavy){
			heavy=size;
		}
		double canshu=1;
		if(sendtype==SENDSTYPE.FAST){
			canshu=25.0/23;
		}else if(sendtype==SENDSTYPE.SLOW){
			canshu=18.0/23;
		}
		ManagerSettingBL managerset = new ManagerSettingBL();
		double price=managerset.getCitiesDistance(city1[0]+"市", city2[0]+"市")/1000*managerset.getStdFee()*canshu*heavy;
		int baozhuang=1;
		if(boxtype==BOXSTYPE.Paper){
			baozhuang=5;
		}else if(boxtype==BOXSTYPE.Box){
			baozhuang=10;
		}
		price=price+baozhuang;		
		return (long)price;
	}	
}
