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
	
	public NewSendingBillsData() throws RemoteException {
		super();
		String fileName="SerializableData/SB.file";
		try {
			FileInputStream fis = new FileInputStream(fileName);
	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        list=(ArrayList<SendingBills>)ois.readObject();
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
		list.add((SendingBills)po);
		save();
		return null;
	}

	public BillsPO findBills(int BillNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteBills(int BillNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateBills(int BillNum, BillsPO bill)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage examine(int BillNum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public long getUnexaminedBillsNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	public EXPRESSSTATE getExpressState(int BillNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
