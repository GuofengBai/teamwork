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

import org.data.billsdata.NewPayingBillsData;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewPayingBillsDataService;
import org.dataservice.managedataservice.AccountManagementDataService;
import org.dataservice.managedataservice.CostManagementDataService;
import org.po.BillsPO;
import org.po.HallCollectionBills;
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
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		
		BillsDataService billsData=new NewPayingBillsData();
		billList=billsData.getAll();
		
		for(BillsPO po:billList){
			list.add((PayingBills)po);
		}
		
		
		return list;
	}

	public ResultMessage changeBill(String index, PayingBills newBill) throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		BillsDataService billsData=new NewPayingBillsData();
		message=billsData.updateBills(index, newBill);
		
		/**
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		
		BillsDataService billsData=new NewPayingBillsData();
		billList=billsData.getAll();
		
		for(BillsPO po:billList){
			list.add((PayingBills)po);
		}
		
		PayingBills oldBill=new PayingBills(null, "", "", "", 0, "", "");
		int dex=0;
		for(PayingBills bill:list){
			if(bill.getIdNum().equals(index)){
				oldBill=bill;
				list.set(dex, newBill);
				
			}
			dex++;
		}
		
		
		
		AccountManagementDataService am=new AccountManagementData();
		am.changeBalance("", oldBill.getMoney()-newBill.getMoney());
		
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
		*/
		
		return message;
	}

	public ResultMessage delBill(String index) throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		BillsDataService billsData=new NewPayingBillsData();
		message=billsData.deleteBills(index);
		/**
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		
		BillsDataService billsData=new NewPayingBillsData();
		billList=billsData.getAll();
		
		for(BillsPO po:billList){
			list.add((PayingBills)po);
		}
		
		PayingBills oldBill=new PayingBills(null, "", "", "", 0, "", "");
		for(PayingBills bill:list){
			if(bill.getIdNum().equals(index)){
				oldBill=bill;
				list.remove(bill);
			}
		}
		
		
		AccountManagementDataService am=new AccountManagementData();
		am.changeBalance("", oldBill.getMoney());
		
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
		*/
		return message;
	}

	public ArrayList<PayingBills> getBillByTime(myDate date1, myDate date2)
			throws RemoteException {
		// TODO Auto-generated method stub
		list=new ArrayList<PayingBills>();
		
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		
		BillsDataService billsData=new NewPayingBillsData();
		billList=billsData.getAll();
		
		for(BillsPO po:billList){
			list.add((PayingBills)po);
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
