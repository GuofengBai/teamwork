package org.test.manageBL;

import static org.junit.Assert.*;

import org.businesslogic.managebl.IncomeTableBL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IncomeTableBLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		IncomeTableBL itbl=new IncomeTableBL();

		
		assertEquals(itbl.getIncome(),10000);
		assertEquals(itbl.getPayment(),5000);
		assertEquals(itbl.getEarning(),5000);
	}

}
