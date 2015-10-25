package org.businesslogicservice.commodityblservice;

import org.po.myDate;
import org.vo.ComVO;

import java.util.Date;
import java.text.SimpleDateFormat;

public interface CommodityBLService {
	boolean Commodityinable = true;
	/**
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
