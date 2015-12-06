package org.businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.ExamineCommodityBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.BILLSTYPE;
import org.po.BillsPO;
import org.po.ComPO;
import org.po.InstorageBills;
import org.po.OutstorageBills;
import org.po.myDate;
import org.vo.ExamineVO;

public class ExamineCommodityBL implements ExamineCommodityBLService {
	private CommodityDataService cds;

	/**
	 * 通过检查两个时间内的所有的出库单、入库单和货物信息获得入库数量、出库数量和当前数量 
	 * 返回可显示格式
	 */
	public Vector<ExamineVO> examineCommodity(myDate timestart, myDate timeend,
			String centerNum) throws RemoteException {
		ArrayList<BillsPO> inbillslist, outbillslist;
		ArrayList<ComPO> comlist;
		Vector<ExamineVO> result = new Vector<ExamineVO>();
		List<String> arealist = this.getArea(centerNum);
		int inNum = 0, outNum = 0, nowNum = 0;
		inbillslist = RMIHelper.getDataFactory().getBillsDataFactory()
				.getNewInstorageBillsData().getAll();
		outbillslist = RMIHelper.getDataFactory().getBillsDataFactory()
				.getNewOutstorageBillsData().getAll();

		CommodityDataService cds = RMIHelper.getDataFactory()
				.getCommodityData();
		for (String area1 : arealist) {
			/*
			 * 入库数量
			 */
			for (BillsPO bills : inbillslist) {
				if (bills.type == BILLSTYPE.IB) {
					InstorageBills temp = (InstorageBills) bills;
					ArrayList<ComPO> list = temp.getlist();
					for (ComPO po : list) {
						if (po.getArea().equals(area1))
							inNum++;
					}
				}
			}
			/*
			 * 出库数量
			 */
			for (BillsPO bills : inbillslist) {
				if (bills.type == BILLSTYPE.OB) {
					OutstorageBills temp = (OutstorageBills) bills;
					ArrayList<ComPO> list = temp.getlist();
					for (ComPO po : list) {
						if (po.getArea().equals(area1))
							outNum++;
					}
				}
			}
			/*
			 * 当前数量
			 */
			comlist = cds.getAllCom(centerNum);
			for (ComPO po : comlist) {
				if (po.getArea().equals(area1)) {
					nowNum++;
				}
			}
			/*
			 * table中可显示的格式
			 */
			ExamineVO vo = new ExamineVO(area1, timestart, timeend, inNum,
					outNum, nowNum);
			result.add(vo);
		}

		// TODO Auto-generated method stub
		return result;
	}

	public ExamineCommodityBL() throws RemoteException {
		cds = RMIHelper.getDataFactory().getCommodityData();
	}
	/**
	 * 获得当前库区的列表，返回给显示层
	 * @param centerNum
	 * @return
	 * @throws RemoteException
	 */

	public List<String> getArea(String centerNum) throws RemoteException {
		ArrayList<ComPO> list = cds.getAllCom(centerNum);
		String p;
		List<String> area = new ArrayList<String>();
		for (ComPO po : list) {
			p = po.getArea();
			if (!area.contains(p)) {
				area.add(p);
			}
		}
		// area.add("航运区");
		// area.add("火车区");
		// area.add("汽运区");
		return area;
	}

}
