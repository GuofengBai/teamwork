package org.test.manageBL;

import static org.junit.Assert.*;

import org.businesslogic.managebl.StatusTableBL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.po.myDate;

public class StatusTableBLTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StatusTableBL stbl=new StatusTableBL();
		myDate date1=new myDate();
		myDate date2=new myDate();
		stbl.searchIncomeBill(date1, date2);
		stbl.searchPayingBill(date1, date2);
	}

}
