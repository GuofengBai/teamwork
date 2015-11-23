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

public class NewSendingBillsData extends UnicastRemoteObject implements NewSendingBillsDataService {

	private ArrayList<SendingBills> list;
	private long unExaminedNum;
	private ArrayList<SendingBills> unExaminedList;
	
	public NewSendingBillsData() throws RemoteException {
		super();
		String fileName="SerializableData/SB.file";
		try {
			FileInputStream fis = new FileInputStream(fileName);
	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        list=(ArrayList<SendingBills>)ois.readObject();
	        unExaminedNum=(Long) ois.readObject();
	        unExaminedList=(ArrayList<SendingBills>)ois.readObject();
	        ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultMessage addBills(BillsPO po) throws RemoteException {
		if(!po.Examined){
			unExaminedList.add((SendingBills) po);
			unExaminedNum++;
		}else{
			list.add((SendingBills)po);
		}
	    save();
		return null;
	}

	public BillsPO findBills(int BillNum) throws RemoteException {
		for(SendingBills po:list){
			if(po.idNum.equals(BillNum)){
				return po;
			}
		}
		
		for(SendingBills po:unExaminedList){
			if(po.idNum.equals(BillNum)){
			    return po;
			}
		}
		return null;
	}

	public ResultMessage deleteBills(int BillNum) throws RemoteException {
		for(SendingBills po:list){
			if(po.idNum.equals(BillNum)){
				list.remove(po);
				save();
				return new ResultMessage(true,null);
			}
		}
		
		for(SendingBills po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				unExaminedList.remove(po);
				save();
				return new ResultMessage(true,null);
			}
		}
		return new ResultMessage(false,null);
	}

	public ResultMessage updateBills(int BillNum, BillsPO bill)throws RemoteException {
		
		for(SendingBills po:list){
			if(po.idNum.equals(BillNum)){
				list.remove(po);
				list.add((SendingBills) bill);
				save();
				return new ResultMessage(true,null);
			}
		}
		
		for(SendingBills po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				unExaminedList.remove(po);
				unExaminedList.add((SendingBills) bill);
				save();
				return new ResultMessage(true,null);
			}
		}
		return null;
	}

	public ResultMessage examine(int BillNum) throws RemoteException {
	
		for(SendingBills po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				po.Examined=true;
				unExaminedList.remove(po);
				list.add(po);
				unExaminedNum--;
				save();
				return new ResultMessage(true,null);
			}
		}
		return null;
	}

	public long getUnexaminedBillsNum() throws RemoteException {
		
		return unExaminedNum;
	}

	public ArrayList<BillsPO> getUnexaminedBills() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BillsPO> getByDate(myDate date1, myDate date2)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage save() throws RemoteException {
		String fileName="SerializableData/SB.file";
		try {
            FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.writeObject((Long)unExaminedNum);
			oos.writeObject(unExaminedList);
            oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage updateExpressState(int BillNum,
			EXPRESSSTATE expressState) {
		
		for(SendingBills po:list){
			if(po.idNum.equals(BillNum)){
				po.expressState=expressState;
				try {
					save();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] info={"成功修改编号为"+BillNum+"的寄件单的货物状态"};
				return new ResultMessage(true,info);
			}
		}
		
		for(SendingBills po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				po.expressState=expressState;
				try {
					save();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] info={"成功修改编号为"+BillNum+"的寄件单的货物状态"};
				return new ResultMessage(true,info);
			}
		}
		
		
		return new ResultMessage(false,null);
	}

	public EXPRESSSTATE getExpressState(int BillNum) {
		for(SendingBills po:list){
			if(po.idNum.equals(BillNum)){
				return po.expressState;
			}
		}
		
		for(SendingBills po:unExaminedList){
			if(po.idNum.equals(BillNum)){
			    return po.expressState;
			}
		}
		
		return null;
	}

}
