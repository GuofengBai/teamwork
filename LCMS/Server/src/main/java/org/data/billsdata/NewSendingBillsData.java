package org.data.billsdata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.BillsPO;
import org.po.EXPRESSSTATE;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.myDate;

public class NewSendingBillsData extends BillsData implements NewSendingBillsDataService {

	
	public NewSendingBillsData() throws RemoteException {
		super("SerializableData/SB.file");
	}

	 public ResultMessage updateExpressState(String BillNum,EXPRESSSTATE expressState) throws RemoteException{
		
		for(BillsPO po:list){
			if(po.idNum.equals(BillNum)){
				((SendingBills)po).setExpressState(expressState);
				save();
				String[] info={"成功修改编号为"+BillNum+"的寄件单的货物状态"};
				return new ResultMessage(true,info);
			}
		}
		
		for(BillsPO po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				((SendingBills)po).setExpressState(expressState);
				save();
				String[] info={"成功修改编号为"+BillNum+"的寄件单的货物状态"};
				return new ResultMessage(true,info);
			}
		}
		
		
		return new ResultMessage(false,null);
	}

	public EXPRESSSTATE getExpressState(String BillNum) throws RemoteException{
		for(BillsPO po:list){
			if(po.idNum.equals(BillNum)){
				return ((SendingBills)po).getState();
			}
		}
		
		for(BillsPO po:unExaminedList){
			if(po.idNum.equals(BillNum)){
			    return ((SendingBills)po).getState();
			}
		}
		
		return null;
	}

}
