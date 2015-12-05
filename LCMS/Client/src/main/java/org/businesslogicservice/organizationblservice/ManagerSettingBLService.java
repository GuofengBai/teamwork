package org.businesslogicservice.organizationblservice;

import org.po.ResultMessage;
import org.po.ExpressFeePO;
import org.po.SENDSTYPE;
import org.po.TRANSPORTATION;
import org.po.VehFeePO;

public interface ManagerSettingBLService {
	/**
	 * 启动设置城市间距离
	 * 
	 * @param city1
	 *            城市1
	 * @param city2
	 *            城市2
	 * @param distance
	 *            城市间距离
	 * @return 返回启动是否成功
	 */
	public boolean setCityDistance(String city1, String city2,double distance);
	
	/**
	 * 获得某两城市间距离
	 * @param city1
	 * @param city2
	 * @return 距离
	 */
	public double getCityDistance(String city1, String city2);
	
	/**
	 * 从城市列表中添加某城市
	 * @param cityName
	 * @return
	 */
	public boolean addCity(String cityName);
	
	/**
	 * 从城市列表中删除某城市
	 * @param cityName
	 * @return
	 */
	public boolean delCity(String cityName);
	
	/**
	 * 获得某种快递方式的运费基准价
	 * @param type
	 * @return 基准价
	 */
	public double getExpressFee(SENDSTYPE type);
	
	/**
	 * 设置某种快递方式的运费基准价
	 * @param type
	 * @param fee
	 * @return
	 */
	public boolean setExpressFee(SENDSTYPE type,double fee);
	
	/**
	 * 获得某种运输方式的运费
	 * @param type（car，train，plane）
	 * @return 运费单价
	 */
	public double getTransFee(TRANSPORTATION type);

	/**
	 * 参考以上
	 * @param type
	 * @param fee
	 * @return
	 */
	public boolean setTransFee(TRANSPORTATION type, double fee);

	

	

	
}
