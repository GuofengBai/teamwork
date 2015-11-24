package org.test.dataservice.manageData;

import org.dataservice.managedataservice.BeginAccountDataService;
import org.po.BeginAccountPO;

public class BeginAccountData implements BeginAccountDataService {

	public void addBeginAccount(BeginAccountPO account) {
		// TODO Auto-generated method stub
		if(account==null){
			System.out.println("Invalid account");
		}else{
			System.out.println("Add success");
		}

	}

	public void Initialize(BeginAccountPO account) {
		// TODO Auto-generated method stub
		if(account==null){
			System.out.println("Invalid account");
		}else{
			System.out.println("Initialize success");
		}
	}

	public BeginAccountPO getBeginAccount() {
		// TODO Auto-generated method stub
		BeginAccountPO example=new BeginAccountPO("营业厅A",50,20,100,"12345678",10000);
		
		return example;
	}

	public void deleteAccount(BeginAccountPO account) {
		// TODO Auto-generated method stub
		if(account==null){
			System.out.println("Invalid account");
		}else{
			System.out.println("Delete success");
		}

	}

}
