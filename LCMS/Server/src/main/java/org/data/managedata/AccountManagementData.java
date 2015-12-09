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

import org.data.billsdata.NewHallCollectBillsData;
import org.dataservice.billsdataservice.NewHallCollectBillsDataService;
import org.dataservice.managedataservice.AccountManagementDataService;
import org.dataservice.managedataservice.BeginAccountDataService;
import org.dataservice.managedataservice.CostManagementDataService;
import org.po.BankAccountPO;
import org.po.BeginAccountPO;
import org.po.BillsPO;
import org.po.HallCollectionBills;
import org.po.PayingBills;
import org.po.ResultMessage;

public class AccountManagementData extends UnicastRemoteObject implements AccountManagementDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BankAccountPO> list;
	
	public AccountManagementData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<BankAccountPO> getAccountList() throws RemoteException{
		list=new ArrayList<BankAccountPO>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			list=(ArrayList<BankAccountPO>) is.readObject();
			is.close();
			
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
			
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

	@SuppressWarnings("unchecked")
	public ResultMessage addAccount(BankAccountPO account) throws RemoteException{
		boolean nameExist=false;
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			
			
			list=new ArrayList<BankAccountPO>();
			list=(ArrayList<BankAccountPO>) is.readObject();
			
			is.close();
			
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
			
			if(list.isEmpty()||list==null){
				
			}else{
				for(BankAccountPO accountTemp:list){
					if(accountTemp.getName().equals(account.getName())){
						nameExist=true;
						break;
					}
				}
			}
			
			if(nameExist){
				String[] info={"Failed","The name already exists."};
				 message=new ResultMessage(false,info);
				
			}else{
				list.add(account);
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BankAccount.file"));
				os.writeObject(list);
				os.close();
				String[] info={"Success","Account saved"};
				message=new ResultMessage(true,info);
			}
			
			
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
		
		
		return message;
	}

	public long getBalance(String name) throws RemoteException{
		// TODO Auto-generated method stub
		long result=0;
		BeginAccountDataService begin=new BeginAccountData();
		BeginAccountPO account=begin.getBeginAccount();
		String beginName=account.getAccountName();
		
		ArrayList<BillsPO> billList=new ArrayList<BillsPO>();
		ArrayList<HallCollectionBills> hcblist=new ArrayList<HallCollectionBills>();
		ArrayList<PayingBills> pblist=new ArrayList<PayingBills>();
		
		NewHallCollectBillsDataService nhcb=new NewHallCollectBillsData();
		CostManagementDataService cmd=new CostManagementData();
		
		/**
		 * 计算期初账单和收款单金额
		 */
		if(name.equals(beginName)){
			result=result+account.getBalance();
			
			billList=nhcb.getAll();	
			for(BillsPO po:billList){
				hcblist.add((HallCollectionBills)po);
			}
			for(HallCollectionBills bill:hcblist){
				result=result+Long.parseLong(bill.gettotal());
			}
		}
		
		/**
		 * 计算付款单金额
		 */
		pblist=cmd.getAllBill();
		for(PayingBills bill:pblist){
			if(bill.getAccountName().equals(name)){
				result=result-bill.getMoney();
			}
			
		}
		
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public ResultMessage delAccount(String name) throws RemoteException{
		list=new ArrayList<BankAccountPO>();
		boolean nameExist=false;
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			
			list=(ArrayList<BankAccountPO>) is.readObject();
			is.close();
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
			
			for(BankAccountPO accountTemp:list){
				if(accountTemp.getName().equals(name)){
					nameExist=true;
					break;
				}
			}
			
			for(int i=0,len=list.size();i<len;i++){
				if(list.get(i).getName().equals(name)){
					list.remove(i);
					i--;
					len--;
					break;
				}
			}
			
			if(nameExist){
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BankAccount.file"));
				os.writeObject(list);
				os.close();
			}
			
			
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
		
		if(nameExist=true){
			String[] info={"Success","Account deleted"};
			message=new ResultMessage(true,info);
		}else{
			String[] info={"Failed","Account not found"};
			message=new ResultMessage(false,info);
		}

		return message;
	}

	@SuppressWarnings("unchecked")
	public ResultMessage changeName(String name, String newname) throws RemoteException{
		boolean nameExist=false;
		list=new ArrayList<BankAccountPO>();
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			
			list=(ArrayList<BankAccountPO>) is.readObject();
			is.close();
			
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
			
			for(BankAccountPO accountTemp:list){
				if(accountTemp.getName().equals(newname)){
					String[] info={"Failed","Account already exists"};
					message=new ResultMessage(false,info);
					
					return message;
				}
			}
			
			
			for(BankAccountPO accountTemp:list){
				if(accountTemp.getName().equals(name)){
					nameExist=true;
					accountTemp.setName(newname);
					break;
				}
			}
			
			if(nameExist){
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BankAccount.file"));
				os.writeObject(list);
				os.close();
			}
			
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
		if(nameExist=true){
			String[] info={"Success","Name changed"};
			message=new ResultMessage(true,info);
		}else{
			String[] info={"Failed","Account not found"};
			message=new ResultMessage(false,info);
		}

		return message;

	}

	@SuppressWarnings("unchecked")
	public ResultMessage changeBalance(String name, long change) throws RemoteException{
		boolean nameExist=false;
		list=new ArrayList<BankAccountPO>();
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		

		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			
			list=(ArrayList<BankAccountPO>) is.readObject();
			is.close();
			
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
			if(name.equals("")){
				nameExist=true;
				BeginAccountDataService ba=new BeginAccountData();
				name=ba.getBeginAccount().getAccountName();
				
			}
			
			for(BankAccountPO accountTemp:list){
				if(accountTemp.getName().equals(name)){
					nameExist=true;
					long balancetemp=accountTemp.getBalance();
					accountTemp.setBalance(balancetemp+change);
					break;
				}
			}
			
			
			if(nameExist){
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BankAccount.file"));
				os.writeObject(list);
				os.close();
			}
			
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
		if(nameExist=true){
			String[] info={"Success","Balance changed"+" "+change};
			message=new ResultMessage(true,info);
		}else{
			String[] info={"Failed","Account not found"};
			message=new ResultMessage(false,info);
		}

		return message;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<BankAccountPO> search(String namepart) throws RemoteException{
		list=new ArrayList<BankAccountPO>();
		ArrayList<BankAccountPO> searchList=new ArrayList<BankAccountPO>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			list=(ArrayList<BankAccountPO>) is.readObject();
			is.close();
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
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
		
		for(BankAccountPO accountTemp:list){
			if(accountTemp.getName().contains(namepart)){
				searchList.add(accountTemp);
			}
		}
		
		return searchList;
	}

	@SuppressWarnings("unchecked")
	public ResultMessage setBalance(String name, long balance)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean nameExist=false;
		list=new ArrayList<BankAccountPO>();
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BankAccount.file"));
			
			list=(ArrayList<BankAccountPO>) is.readObject();
			is.close();
			
			if(list==null){
				list=new ArrayList<BankAccountPO>();
			}
			
			for(BankAccountPO accountTemp:list){
				if(accountTemp.getName().equals(name)){
					nameExist=true;
					accountTemp.setBalance(balance);
					break;
				}
			}
			
			if(nameExist){
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BankAccount.file"));
				os.writeObject(list);
				os.close();
			}
			
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
		if(nameExist=true){
			String[] info={"Success","Balance changed to"+" "+balance};
			message=new ResultMessage(true,info);
		}else{
			String[] info={"Failed","Account not found"};
			message=new ResultMessage(false,info);
		}

		return message;
	}

}
