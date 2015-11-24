package org.businesslogic.commoditybl;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import org.Client.RMIHelper;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.ComPO;
import org.vo.CommodityVO;

public class DistrictChangeBL implements DistrictChangeBLService {
	CommodityDataService cds = RMIHelper.getDataFactory().getCommodityData();
	Vector<CommodityVO> vdata;
	List<String> area;

	public ComPO change(String from, String to) {
		// TODO Auto-generated method stub
		getDistrictCommodity(from);
		
		return null;

	}

	public Vector<CommodityVO> getDistrictCommodity(String from) {
		ArrayList<ComPO> list = cds.getAllCom();
		for (ComPO po : list) {
			CommodityVO vo;
			if (po.getArea().equals(from))
				vdata.addElement(vo = new CommodityVO(po.getGoodsNum(), po
						.getinDate(), po.getplace(), po.LocationNum(), po
						.getArea()));
		}
		return vdata;
	}
	public void changeDistrict(CommodityVO vo){
		ComPO po,po1;
		po=cds.findCom(vo.getGoodsNum());
		cds.delCom(po);
		po1=new ComPO(vo.getGoodsNum(),po.getinDate(),vo.getplace(),vo.getLocation(),vo.getarea());
		cds.addCom(po1);
	}
	public List<String> getArea(){
		ArrayList<ComPO> list = cds.getAllCom();
		String p;
		;
		for(ComPO po:list){
			p=po.getArea();
			if(!area.contains(p)){
				area.add(p);
			}
		}
		return area;
	}

}
