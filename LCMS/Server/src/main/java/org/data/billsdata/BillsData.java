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

import org.dataservice.billsdataservice.BillsDataService;
import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ResultMessage;
import org.po.SendingBills;
import org.po.myDate;

public class BillsData extends UnicastRemoteObject implements BillsDataService{
	
	protected ArrayList<BillsPO> list;
	protected long unExaminedNum;
	protected ArrayList<BillsPO> unExaminedList;
	protected String fileName;

	public BillsData(String fileName) throws RemoteException {
		super();
		this.fileName=fileName;
		try {
			FileInputStream fis = new FileInputStream(fileName);
	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        list=(ArrayList<BillsPO>)ois.readObject();
	        unExaminedNum=(Long) ois.readObject();
	        unExaminedList=(ArrayList<BillsPO>)ois.readObject();
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
			unExaminedList.add( po);
			unExaminedNum++;
		}else{
			list.add(po);
		}
	    save();
		return null;
	}

	public BillsPO findBills(String BillNum) throws RemoteException {
		for(BillsPO po:list){
			if(po.idNum.equals(BillNum)){
				return po;
			}
		}
		
		for(BillsPO po:unExaminedList){
			if(po.idNum.equals(BillNum)){
			    return po;
			}
		}
		return null;
	}

	public ResultMessage deleteBills(String BillNum) throws RemoteException {
		for(BillsPO po:list){
			if(po.idNum.equals(BillNum)){
				list.remove(po);
				save();
				return new ResultMessage(true,null);
			}
		}
		
		for(BillsPO po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				unExaminedList.remove(po);
				save();
				return new ResultMessage(true,null);
			}
		}
		return new ResultMessage(false,null);
	}

	public ResultMessage updateBills(String BillNum, BillsPO bill)
			throws RemoteException {
		for(BillsPO po:list){
			if(po.idNum.equals(BillNum)){
				list.remove(po);
				list.add((SendingBills) bill);
				save();
				return new ResultMessage(true,null);
			}
		}
		
		for(BillsPO po:unExaminedList){
			if(po.idNum.equals(BillNum)){
				unExaminedList.remove(po);
				unExaminedList.add((SendingBills) bill);
				save();
				return new ResultMessage(true,null);
			}
		}
		return null;
	}

	public ResultMessage examine(String BillNum) throws RemoteException {
		for(BillsPO po:unExaminedList){
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

	public long getUnexaminedBillsNum() {
		return unExaminedNum;
	}

	public ArrayList<BillsPO> getUnexaminedBills() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BillsPO> getByDate(myDate date1, myDate date2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage save() {
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

	
}
