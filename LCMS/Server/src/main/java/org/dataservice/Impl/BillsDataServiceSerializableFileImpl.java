package org.dataservice.Impl;

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
import org.po.BillsPO;
import org.po.ResultMessage;

public class BillsDataServiceSerializableFileImpl extends UnicastRemoteObject implements BillsDataService{

	public ArrayList<BillsPO> billsList;
	
	
	public BillsDataServiceSerializableFileImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage addBills(BillsPO po)throws RemoteException {
		// TODO Auto-generated method stub
		String fileName="SerializableData/"+po.type.toString()+".file";
		System.out.println(fileName);
		try {
			FileInputStream fis = new FileInputStream(fileName);
	        BufferedInputStream bis = new BufferedInputStream(fis);  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        billsList= (ArrayList<BillsPO>) ois.readObject();
	        billsList.add(po);
            FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(billsList);
            ois.close();
            oos.close();
            System.out.println("添加成功！");
            String[] info={"add bills successfully!!"};
            return new ResultMessage(true,info);
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
		
		return null;
	}

	public ResultMessage findBills(int BillNum)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage deleteBills(int BillNum)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateBills(int BillNum, BillsPO po)throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
