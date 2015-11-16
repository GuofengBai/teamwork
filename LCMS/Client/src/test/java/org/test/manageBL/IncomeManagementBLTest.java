package org.test.manageBL;

import static org.junit.Assert.*;

import org.businesslogic.managebl.IncomeManagementBL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.po.myDate;

public class IncomeManagementBLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		IncomeManagementBL imbl=new IncomeManagementBL();
		myDate date =new myDate();
		imbl.incomeSearch(date, 1);
	}

}
