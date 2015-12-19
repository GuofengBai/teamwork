package org.businesslogicservice.organizationblservice;

import java.util.Vector;

import org.po.DriverPO;
import org.po.ResultMessage;
import org.vo.DriverVO;

public interface HallDriverBLService {
	/**
	 * 
	 * @param po 司机
	 * @return
	 */
	public ResultMessage addDriver(DriverPO po);
	
	/**
	 * 
	 * @param DriverNum 司机编号
	 * @return
	 */
	public ResultMessage delDriver(String DriverNum);
	
	/**
	 * 
	 * @return Vector<DriverVO>
	 */
	public Vector<DriverVO> getList();
}
