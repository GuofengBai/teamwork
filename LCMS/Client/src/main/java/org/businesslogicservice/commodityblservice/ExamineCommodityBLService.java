package org.businesslogicservice.commodityblservice;

import org.po.myDate;
import org.vo.ExamineVO;

public interface ExamineCommodityBLService {
	/**
	 * 启动库存查看
	 * @param timestart 启动时间
	 * @param timeend 终止时间
	 * @return 返回int[0]入库数量 int[1]出库数量
	 */
	public ExamineVO examineCommodity(myDate timestart, myDate timeend);;
}
