package org.test.data.mamagedata;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.data.managedata.AccountManagementData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.po.BankAccountPO;

public class AccountManagementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws RemoteException {
		AccountManagementData amd=new AccountManagementData();
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerializableData/BankAccount.file"));
			ArrayList <BankAccountPO> temp=new ArrayList <BankAccountPO>();
			BankAccountPO test0=new BankAccountPO("12312322",10000);
			temp.add(test0);
			os.writeObject(temp);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BankAccountPO test1=new BankAccountPO("12345678",10000);
		amd.addAccount(test1);
		
	}

}
