package org.test.manageBL;

import static org.junit.Assert.*;

import org.businesslogic.managebl.NewBeginAccountBL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.po.BeginAccountPO;

public class NewBeginAccountBLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		NewBeginAccountBL nbabl=new NewBeginAccountBL();
		BeginAccountPO example=new BeginAccountPO("营业厅A",50,20,100,"12345678",10000);
		nbabl.accountInitilize(null);
		nbabl.accountInitilize(example);
		
		nbabl.addBeginAccount("12", 1, 1, 1, "12345678", 10000);
	}

}
