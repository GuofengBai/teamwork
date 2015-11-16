package org.test.manageBL;

import static org.junit.Assert.*;

import org.businesslogic.managebl.BeginAccountBL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.po.BeginAccountPO;

public class BeginAccountBLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BeginAccountBL babl=new BeginAccountBL();
		
		assertEquals(babl.getBeginAccount().getBalance(),10000);
		assertEquals(babl.getBeginAccount().getAccountName(),"12345678");
		
		BeginAccountPO example=new BeginAccountPO("营业厅A",50,20,100,"12345678",10000);
		babl.deleteAccount(example);
		babl.deleteAccount(null);
		
	}

}
