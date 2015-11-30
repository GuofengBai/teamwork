package org.data.managedata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.dataservice.managedataservice.CostManagementDataService;
import org.po.PayingBills;
import org.po.ResultMessage;
import org.po.myDate;

public class CostManagementData extends UnicastRemoteObject implements CostManagementDataService {
	public CostManagementData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private ArrayList<PayingBills> list;
	
	public ArrayList<PayingBills> getAllBill() throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/PB.file"));
			list=(ArrayList<PayingBills>) is.readObject();
			is.close();
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
		
		return list;
	}

	public ResultMessage changeBill(int index, PayingBills newBill) throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream("SerializableData/PB.file"));
			list=(ArrayList<PayingBills>) is.readObject();
			is.close();
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
		
		list.set(index, newBill);
		
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/PB.file"));
			os.writeObject(list);
			os.close();
			
			String[] info={"Success","Bill changed"};
			message=new ResultMessage(true,info);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return message;
	}

	public ResultMessage delBill(int index) throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/PB.file"));
			list=(ArrayList<PayingBills>) is.readObject();
			is.close();
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
		list.remove(index);
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/PB.file"));
			os.writeObject(list);
			os.close();
			
			String[] info={"Success","Bill deleted"};
			message=new ResultMessage(true,info);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	public ArrayList<PayingBills> getBillByTime(myDate date1, myDate date2)
			throws RemoteException {
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/PB.file"));
			list=(ArrayList<PayingBills>) is.readObject();
			is.close();
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
		
		ArrayList<PayingBills> result=new ArrayList<PayingBills>();
		
		for(PayingBills bill:list){
			if((bill.getDate().compareTo(date1))>=0&&(bill.getDate().compareTo(date2))<=0){
				result.add(bill);
			}
		}
		
		
		return result;
	}
	
}
