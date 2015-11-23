package org.businesslogic.commoditybl;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.po.myDate;
import org.vo.ComVO;

public class CheckCommodityBL implements CheckCommodityBLService {
	Vector<ComVO> comlist=new Vector<ComVO>();
	ArrayList<ComPO> list;
	CommodityDataService cds =RMIHelper.getDataFactory().getCommodityData();
	public boolean startCheckCommodity(myDate time) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String curdate = simpleDateFormat.format(date);
		int year = Integer.parseInt(curdate.substring(0, 4));
		int month=Integer.parseInt(curdate.substring(4, 6));
		int day=Integer.parseInt(curdate.substring(6, 8));
		myDate today=new myDate(year,month,day);
		list=cds.getAllCom();
		return false;
	}

	public Vector<ComVO> checkCommodityInf() {
		// TODO Auto-generated method stub
		for(ComPO po:list){
			ComVO obj=new ComVO(po.getGoodsNum(),po.getinDate(),po.getplace(),po.LocationNum(),po.getArea());
			comlist.addElement(obj);
		}
		return comlist;
	}

}
