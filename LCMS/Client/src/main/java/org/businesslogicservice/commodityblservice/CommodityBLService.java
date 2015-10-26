package org.businesslogicservice.commodityblservice;

import org.po.myDate;
import org.vo.ComVO;
import java.util.Date;
import java.text.SimpleDateFormat;

public interface CommodityBLService {
	boolean Commodityinable = true;
	/**
	 * 启动库存盘点
	 * @return 返回启动是否成功
	 */
	public boolean startCheckCommodity(myDate time);
	/**
	 * 库存盘点的显示信息
	 * @return 返回Commodity项信息，包括快递编号、入库日期、目的地、区号、排号、架号、位号
	 */
	public ComVO checkCommodityInf();
	/**
	 * 启动库存查看
	 * @param timestart 启动时间
	 * @param timeend 终止时间
	 * @return 返回int[0]入库数量 int[1]出库数量
	 */
	public int[] examineCommodity(myDate timestart, myDate timeend);;
	/**
	 * 启动警报设置
	 * @param alartLine 警报线
	 * @return 返回设置是否成功
	 */
	public boolean settingAlert(double alertLine);
	/**
	 * 入库
	 * @param Sending 快递单号
	 * @return 返回入库是否成功
	 */
	public boolean Commodityin(long Sending);
	/**
	 * 出库
	 * @param Sending 快递单号
	 * @return 返回处库是否成功
	 */
	public boolean Commodityout(long Sending);
}



