package org.businesslogic.billsbl;

import java.rmi.RemoteException;

import org.Client.RMIHelper;
import org.businesslogic.organizationbl.ManagerSettingBL;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.dataservice.billsdataservice.BillsDataService;
import org.dataservice.billsdataservice.NewSendingBillsDataService;
import org.po.BOXSTYPE;
import org.po.ResultMessage;
import org.po.SENDSTYPE;
import org.po.SendingBills;
import org.vo.SBVO;

public class NewSendingBillsBL implements NewSendingBillsBLService {

	public ResultMessage addSendingBills(SBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message = null;
		BillsDataService billsData;
		try {
			billsData = RMIHelper.getDataFactory().getBillsDataFactory()
					.getNewSendingBillsData();
			message = billsData.addBills(new SendingBills(vo.sendername,
					vo.receivername, vo.senderphone, vo.receiverphone,
					vo.senderlocation, vo.receiverlocation, vo.date,
					vo.goodsnumber, vo.box, vo.send, vo.length, vo.width,
					vo.height, vo.weight));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public long getPrice(String SenderLocation, String ReceiverLocation,
			BOXSTYPE boxtype, SENDSTYPE sendtype, String length, String width,
			String height, String weight) {
		// TODO Auto-generated method stub
		String[] city1 = SenderLocation.split("市");
		String[] city2 = ReceiverLocation.split("市");
		double size = Double.parseDouble(length) * Double.parseDouble(width)
				* Double.parseDouble(height) / 5000;
		double heavy = Double.parseDouble(weight);
		if (size > heavy) {
			heavy = size;
		}
		ManagerSettingBL managerset = new ManagerSettingBL();
		System.out.print(city1[0]+city2[0]+managerset.getCityDistance(city1[0], city2[0]));
		double price = managerset.getCityDistance(city1[0], city2[0]
				)
				/ 1000 * managerset.getExpressFee(sendtype) * heavy;
		int baozhuang = 1;
		if (boxtype == BOXSTYPE.Paper) {
			baozhuang = 5;
		} else if (boxtype == BOXSTYPE.Box) {
			baozhuang = 10;
		}
		price = price + baozhuang;
		return (long) price;
	}

	public ResultMessage updateSendingBills(SBVO vo) {
		// TODO Auto-generated method stub
		ResultMessage message = null;
		try {
			BillsDataService billsData = RMIHelper.getDataFactory()
					.getBillsDataFactory().getNewSendingBillsData();
			message = billsData.updateBills(vo.goodsnumber, new SendingBills(
					vo.sendername, vo.receivername, vo.senderphone,
					vo.receiverphone, vo.senderlocation, vo.receiverlocation,
					vo.date, vo.goodsnumber, vo.box, vo.send, vo.length,
					vo.width, vo.height, vo.weight));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String searchState(String goodNum) {
		// TODO Auto-generated method stub
		String answer = "";
		try {
			NewSendingBillsDataService billsData = RMIHelper.getDataFactory()
					.getBillsDataFactory().getNewSendingBillsData();
			if(billsData.findBills(goodNum)==null){
				return answer;
			}
			answer = billsData.getExpressState(goodNum).getState();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;
	}

	public String cherk(SBVO vo) {
		BillsDataService billsData;
		if (vo.sendername.equals(""))
			return "信息未填写完整";
		if (vo.receivername.equals(""))
			return "信息未填写完整";
		if (vo.senderphone.equals(""))
			return "信息未填写完整";
		if (vo.receiverphone.equals(""))
			return "信息未填写完整";
		if (vo.senderlocation.equals(""))
			return "信息未填写完整";
		if (vo.receiverlocation.equals(""))
			return "信息未填写完整";
		if (vo.goodsnumber.equals(""))
			return "信息未填写完整";
		if (vo.length.equals(""))
			return "信息未填写完整";
		if (vo.width.equals(""))
			return "信息未填写完整";
		if (vo.height.equals(""))
			return "信息未填写完整";
		if (vo.weight.equals(""))
			return "信息未填写完整";
		try {
			billsData = RMIHelper.getDataFactory().getBillsDataFactory()
					.getNewSendingBillsData();
			if (billsData.Used(vo.goodsnumber)) {
				return "单据号已存在";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
}
