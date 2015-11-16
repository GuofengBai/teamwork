package org.test.manageBL;

import static org.junit.Assert.*;

import org.businesslogic.managebl.AccountManagementBL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountManagementBLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		AccountManagementBL ambl=new AccountManagementBL();
		
		assertEquals((ambl.getAccountList())[0].getName(),"12345678");
		assertEquals((ambl.getAccountList())[0].getBalance(),10000);
		
		ambl.addAccount("12345678");
		ambl.addAccount("21312322");
		
		assertEquals(ambl.getBalance("12345678"),10000);
		assertEquals(ambl.getBalance("23345678"),0);
		
		ambl.delAccount("12345678");
		ambl.delAccount("21312322");
		
		ambl.changeName("12345678","11111111");
		ambl.changeName("21312322","12121212");
		
		ambl.changeBalance("12345678",10000);
		ambl.changeBalance("21312322",100);
		
		ambl.accountSearch("2345");
	}

}
