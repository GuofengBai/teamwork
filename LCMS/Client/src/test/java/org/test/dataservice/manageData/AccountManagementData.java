package org.test.dataservice.manageData;

import org.dataservice.managedataservice.AccountManagementDataService;
import org.po.BankAccountPO;

public class AccountManagementData implements AccountManagementDataService{

	public BankAccountPO[] getAccountList() {
		// TODO Auto-generated method stub
		BankAccountPO a=new BankAccountPO("12345678");
		BankAccountPO b=new BankAccountPO("98765432");
		a.setBalance(10000);
		b.setBalance(0);
		BankAccountPO[] result=new BankAccountPO[2];
		result[0]=a;
		result[1]=b;
		
		return result;
	}

	public void addAccount(String name) {
		// TODO Auto-generated method stub
		if(name.equals("12345678")){
			System.out.println("Account already exists");
		}else{
			System.out.println("New account is Added");
		}
		
	}

	public int getBalance(String name) {
		// TODO Auto-generated method stub
		
		//默认账户名为 12345678
		if(name.equals("12345678")){
			return 10000;
		}else{
			System.out.println("Invalid account");
			return 0;
		}
		
	}

	public void delAccount(String name) {
		// TODO Auto-generated method stub
		if(name.equals("12345678")){
			System.out.println("Delete success");
		}else{
			System.out.println("Invalid account");
		}
	}

	public void changeName(String name, String newname) {
		// TODO Auto-generated method stub
		if(name.equals("12345678")){
			System.out.println("Change success");
		}else{
			System.out.println("Invalid account");
		}
		
	}

	public void changeBalance(String name, int change) {
		//默认账户名为 12345678
		if(name.equals("12345678")){
			System.out.println("Change success");
		}else{
			System.out.println("Invalid account");
		}
	}

	public BankAccountPO[] search(String namepart) {
		// TODO Auto-generated method stub
		BankAccountPO a=new BankAccountPO("12345678");
		BankAccountPO b=new BankAccountPO("98765432");
		a.setBalance(10000);
		b.setBalance(0);
		BankAccountPO[] result=new BankAccountPO[2];
		if(a.getName().contains(namepart)){
			result[0]=a;
		}
		if(b.getName().contains(namepart)){
			result[1]=b;
		}
		
		if(result[0]==null&&result[1]==null){
			System.out.println("No Account found");
			return null;
		}else{
			return result;
		}
		
		
	}

}
