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
import org.po.ResultMessage;

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
		
		
		
		BankAccountPO test1=new BankAccountPO("12345678",10000);
		ResultMessage message=amd.addAccount(test1);
		
		System.out.println(message.info[0]);
		System.out.println(message.info[1]);
	}

}
