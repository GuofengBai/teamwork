package org.businesslogic.managebl;

import org.businesslogicservice.manageblservice.IncomeTableBLService;
import org.test.dataservice.manageData.IncomeTableData;


public class IncomeTableBL implements IncomeTableBLService {

	public int getIncome() {
		// TODO Auto-generated method stub
		IncomeTableData itd=new IncomeTableData();
		return itd.getIncome();
	}

	public int getPayment() {
		// TODO Auto-generated method stub
		IncomeTableData itd=new IncomeTableData();
		return itd.getPayment();
	}

	public int getEarning() {
		// TODO Auto-generated method stub
		IncomeTableBL itbl=new IncomeTableBL();
		return itbl.getIncome()-itbl.getPayment();
	}

	

}
