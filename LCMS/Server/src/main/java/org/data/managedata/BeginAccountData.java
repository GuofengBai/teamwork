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
import org.dataservice.managedataservice.BeginAccountDataService;
import org.po.BeginAccountPO;
import org.po.ResultMessage;

public class BeginAccountData extends UnicastRemoteObject implements BeginAccountDataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeginAccountData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private ArrayList<BeginAccountPO> list;
	
	@SuppressWarnings("unchecked")
	public ResultMessage addBeginAccount(BeginAccountPO account) throws RemoteException{
		// TODO Auto-generated method stub
		String[] infotemp={"Failed","Exception"};
		ResultMessage message=new ResultMessage(false,infotemp);
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginAccount.file"));
			list=new ArrayList<BeginAccountPO>();
			list=(ArrayList<BeginAccountPO>) is.readObject();
			is.close();
			
			if(list==null){
				list=new ArrayList<BeginAccountPO>();
			}
			
			list.add(account);
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BeginAccount.file"));
			os.writeObject(list);
			os.close();
				
			ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("SerializableData/BeginInfo.file"));
			os2.writeObject(account);
			os2.close();
			String[] info={"Success","Account saved"};
			message=new ResultMessage(true,info);
			
			AccountManagementDataService am=new AccountManagementData();
			am.setBalance(account.getAccountName(), account.getBalance());

			
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<BeginAccountPO> getBeginAccountList() throws RemoteException{
		// TODO Auto-generated method stub
		list=new ArrayList<BeginAccountPO>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginAccount.file"));
			list=(ArrayList<BeginAccountPO>) is.readObject();
			is.close();
			if(list==null){
				list=new ArrayList<BeginAccountPO>();
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
	
	public void Initialize(BeginAccountPO account) throws RemoteException{
		// TODO Auto-generated method stub
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BeginInfo.file"));
			os.writeObject(account);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public BeginAccountPO getBeginAccount() throws RemoteException{
		// TODO Auto-generated method stub
		BeginAccountPO beginInfo=new BeginAccountPO(null, 0, 0, 0, null, 0);
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableData/BeginInfo.file"));
			beginInfo=(BeginAccountPO) is.readObject();
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
		return beginInfo;
	}

	@SuppressWarnings("unchecked")
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
			
			if(list==null){
				list=new ArrayList<BeginAccountPO>();
			}
			
			for(BeginAccountPO accountTemp:list){
				if(accountTemp.getAccountName().equals(account.getAccountName())&&accountTemp.getOrganization().equals(account.getOrganization())){
					nameExist=true;
					break;
				}
			}
			
			for(int i=0,len=list.size();i<len;i++){
				if(list.get(i).getAccountName().equals(account.getAccountName())&&list.get(i).getOrganization().equals(account.getOrganization())){
					list.remove(i);
					i--;
					len--;
					break;
				}
			}
			
			if(nameExist){
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
