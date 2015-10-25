package org.businesslogicservice.commodityblservice;

<<<<<<< HEAD
import ResultMessage;
import org.po.myDate;
=======
import org.po.myDate;
import org.vo.ComVO;

>>>>>>> origin/master
import java.util.Date;
import java.text.SimpleDateFormat;

public interface CommodityBLService {
	boolean Commodityinable = true;
	/**
<<<<<<< HEAD
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
=======
	 * 鍚姩搴撳瓨鐩樼偣
	 * @return 杩斿洖鍚姩鏄惁鎴愬姛
	 */
	public boolean startCheckCommodity(myDate time);
	/**
	 * 搴撳瓨鐩樼偣鐨勬樉绀轰俊鎭�
	 * @return 杩斿洖Commodity椤逛俊鎭紝鍖呮嫭蹇�掔紪鍙枫�佸叆搴撴棩鏈熴�佺洰鐨勫湴銆佸尯鍙枫�佹帓鍙枫�佹灦鍙枫�佷綅鍙�
	 */
	public ComVO checkCommodityInf();
	/**
	 * 鍚姩搴撳瓨鏌ョ湅
	 * @param timestart 鍚姩鏃堕棿
	 * @param timeend 缁堟鏃堕棿
	 * @return 杩斿洖int[0]鍏ュ簱鏁伴噺 int[1]鍑哄簱鏁伴噺
	 */
	public int[] examineCommodity(myDate timestart, myDate timeend);;
	/**
	 * 鍚姩璀︽姤璁剧疆
	 * @param alartLine 璀︽姤绾�
	 * @return 杩斿洖璁剧疆鏄惁鎴愬姛
	 */
	public boolean settingAlert(double alertLine);
	/**
	 * 鍏ュ簱
	 * @param Sending 蹇�掑崟鍙�
	 * @return 杩斿洖鍏ュ簱鏄惁鎴愬姛
	 */
	public boolean Commodityin(long Sending);
	/**
	 * 鍑哄簱
	 * @param Sending 蹇�掑崟鍙�
	 * @return 杩斿洖澶勫簱鏄惁鎴愬姛
	 */
	public boolean Commodityout(long Sending);
}
>>>>>>> origin/master
