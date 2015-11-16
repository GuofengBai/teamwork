package org.Client;

import static org.junit.Assert.*;

import org.businesslogic.billsbl.NewSendingBillsBL;
import org.businesslogic.organizationbl.ManagerSettingBL;
import org.junit.Test;
import org.po.BOXSTYPE;
import org.po.CityAndDistancePO;
import org.po.SENDSTYPE;

public class getPriceTest {
	@Test
	public void test(){
		NewSendingBillsBL bills = new NewSendingBillsBL();
		long price=bills.getPrice("北京", "南京", BOXSTYPE.Bag, SENDSTYPE.NORMAL, 200+"", 50+"", 50+"", 3+"");
		System.out.println(price);
		assertEquals(91,price);
	}
}
