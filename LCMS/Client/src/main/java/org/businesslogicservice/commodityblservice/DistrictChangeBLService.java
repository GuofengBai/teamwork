package org.businesslogicservice.commodityblservice;

import java.util.List;
import java.util.Vector;

import org.po.ComPO;
import org.vo.CommodityVO;

public interface DistrictChangeBLService {
	public ComPO change(String from,String to);
	public Vector<CommodityVO> getDistrictCommodity(String from);
	public void changeDistrict(CommodityVO vo);
	public List<String> getArea();
}
