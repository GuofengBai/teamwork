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

import org.dataservice.managedataservice.BeginAccountDataService;
import org.po.BankAccountPO;
import org.po.BeginAccountPO;
import org.po.ResultMessage;

public class BeginAccountData extends UnicastRemoteObject implements BeginAccountDataService {
	
	public BeginAccountData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private ArrayList<BeginAccountPO> list;
	
	public ResultMessage addBeginAccount(BeginAccountPO account) throws RemoteException{
		// TODO Auto-generated method stub
		boolean nameExist=false;
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginAccount.file"));
			list=new ArrayList<BeginAccountPO>();
			list=(ArrayList<BeginAccountPO>) is.readObject();
			is.close();
			
			if(list.isEmpty()||list==null){
				
			}else{
				for(BeginAccountPO accountTemp:list){
					if(accountTemp.getAccountName().equals(account.getAccountName())){
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
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BeginAccount.file"));
				os.writeObject(list);
				os.close();
				
				ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("SerializableData/BeginInfo.file"));
				os2.writeObject(account);
				os2.close();
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
	
	public ArrayList<BeginAccountPO> getBeginAccountList() throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<BeginAccountPO>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginAccount.file"));
			list=(ArrayList<BeginAccountPO>) is.readObject();
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
	
	public void Initialize(BeginAccountPO account) throws RemoteException{
		// TODO Auto-generated method stub

	}

	public BeginAccountPO getBeginAccount() throws RemoteException{
		// TODO Auto-generated method stub
		BeginAccountPO beginInfo=new BeginAccountPO(null, 0, 0, 0, null, 0);
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginInfo.file"));
			beginInfo=(BeginAccountPO) is.readObject();
			
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
		return beginInfo;
	}

	public ResultMessage deleteAccount(BeginAccountPO account) throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<BeginAccountPO>();
		boolean nameExist=false;
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginAccount.file"));
			list=(ArrayList<BeginAccountPO>) is.readObject();
			is.close();
			
			for(BeginAccountPO accountTemp:list){
				if(accountTemp.getAccountName().equals(account.getAccountName())){
					nameExist=true;
					break;
				}
			}
			
			for(int i=0,len=list.size();i<len;i++){
				if(list.get(i).getAccountName().equals(account.getAccountName())){
					list.remove(i);
					i--;
					len--;
					break;
				}
			}
			
			if(nameExist=true){
				ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BeginAccount.file"));
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

	

}
