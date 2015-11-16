package org.Client;

import static org.junit.Assert.*;

import org.businesslogic.billsbl.NewSendingBillsBL;
import org.junit.Test;
import org.po.BOXSTYPE;
import org.po.SENDSTYPE;

public class getPriceTest {
	@Test
	public void test(){
		NewSendingBillsBL bills = new NewSendingBillsBL();
		long price=bills.getPrice("北京市", "南京市", BOXSTYPE.Bag, SENDSTYPE.NORMAL, 200+"", 50+"", 50+"", 3+"");
		assertEquals(91,price);
	}
}
