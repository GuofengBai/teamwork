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

import org.dataservice.managedataservice.AccountManagementDataService;
import org.po.BankAccountPO;
import org.po.ResultMessage;

public class AccountManagementData extends UnicastRemoteObject implements AccountManagementDataService {
	private ArrayList<BankAccountPO> list;
	
	public AccountManagementData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
		return 0;
	}

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
			
			if(nameExist=true){
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

}
