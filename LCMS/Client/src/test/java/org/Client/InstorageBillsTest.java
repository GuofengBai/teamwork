package org.Client;

import static org.junit.Assert.*;

import org.businesslogic.billsbl.NewInstorageBillsBL;
import org.junit.Test;
import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;

public class InstorageBillsTest {

	private myDate date;




	@Test
	public void test() {
		
		String GoodsNum = "000000001";
		String Destination = "广州";
		String Location = "01010101";
		NewInstorageBillsBL bills = new NewInstorageBillsBL();
		//ResultMessage rm = bills.newInstorageBill(date, GoodsNum, Destination,
		//		Location);

		ComPO po1 = bills.addGoods(GoodsNum, date, Destination, Location);
		ComPO po2 = bills.deleteGoods(GoodsNum, date, Destination, Location);
		//assertEquals(rm.success, true);
		//if (po1!=null) {
			assertEquals(po1.getGoodsNum(), "000000001");
			//assertEquals(po2.getGoodsNum(), "000000001");
			assertEquals(po1.getinDate(), date);
			//assertEquals(po2.getinDate(), date);
			assertEquals(po1.getplace(), Destination);
			//assertEquals(po2.getplace(), Destination);
		//}
	}

}
