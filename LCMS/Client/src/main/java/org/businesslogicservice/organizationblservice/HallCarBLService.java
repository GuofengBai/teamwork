package org.businesslogicservice.organizationblservice;

import java.util.Vector;

import org.po.CarPO;
import org.po.ResultMessage;
import org.vo.CarVO;

public interface HallCarBLService {
	
	/**
	 * 
	 * @param po 车辆
	 * @return
	 */
	public ResultMessage addCar(CarPO po);
	
	/**
	 * 
	 * @param CarNum 车辆编号
	 * @return
	 */
	public ResultMessage delCar(String CarNum);
	
	/**
	 * 
	 * @return Vector<CarVO>
	 */
	public Vector<CarVO> getList();
}
