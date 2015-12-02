package org.Client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.po.AlertPO;
import org.po.CenterCom;
import org.po.ComPO;
import org.po.ResultMessage;
import org.po.myDate;

public class MockCommodityData {
	public LinkedList<CenterCom> totalList;
	public MockCommodityData(){
		totalList=new LinkedList<CenterCom>();
		myDate date=new myDate(2015,12,3);
		ComPO po1=new ComPO("0000000001",date,"北京市","0001","航运区","0210001");
		ComPO po2=new ComPO("0000000002",date,"北京市","0002","汽运区","0210001");
		ComPO po3=new ComPO("0000000003",date,"北京市","0003","铁运区","0210001");
		ArrayList<ComPO> list1=new ArrayList<ComPO>();
		list1.add(po1);
		list1.add(po2);
		list1.add(po3);
		CenterCom center1=new CenterCom(list1,"0210001");
		ComPO po4=new ComPO("0000000004",date,"南京市","0001","航运区","0100001");
		ComPO po5=new ComPO("0000000005",date,"南京市","0002","汽运区","0100001");
		ComPO po6=new ComPO("0000000006",date,"南京市","0003","铁运区","0100001");
		ArrayList<ComPO> list2=new ArrayList<ComPO>();
		list2.add(po4);
		list2.add(po5);
		list2.add(po6);
		CenterCom center2=new CenterCom(list2,"0100001");
		totalList.add(center1);
		totalList.add(center2);
	}

	public AlertPO getAlert(String centerNum) {
		for(CenterCom center:totalList){
			if(center.centerNum.equals(centerNum)){
				return center.po;
			}
		}
		return null;
	}
	
	public ResultMessage setAlert(String centerNum,double line) {
		ResultMessage re;
		String[] su={"更改成功!"};
		String[] fa={"更改失败!"};
		for(CenterCom center:totalList){
			if(center.centerNum.equals(centerNum)){
				center.po=new AlertPO(line);
				return re=new ResultMessage(true,su);
			}
		}
		return re=new ResultMessage(false,fa);
	}
	public ResultMessage addCom(ComPO po) {
		String[] fa = { "增加失败", "已存在货运单号对应的货物" };
		ArrayList<ComPO> ComList = null;

		for (CenterCom o : totalList) {
			if (o.centerNum.equals(po.getcenterNum())) {
				ComList = o.ComList;
				break;
			}
		}

		for (ComPO p : ComList) {
			if (p.getGoodsNum().equals(po.getGoodsNum())) {
				return new ResultMessage(false, fa);
			}
		}
		ComList.add(po);
		CenterCom center=new CenterCom(ComList,po.getcenterNum());
		for (CenterCom o : totalList) {
			if (o.centerNum.equals(center.centerNum)) {
				o=new CenterCom(ComList,po.getcenterNum());
			}
		}
		return new ResultMessage(true, null);
	}
	public ResultMessage delCom(ComPO po) throws RemoteException {
		
		ArrayList<ComPO> ComList = null;
		for (CenterCom o : totalList) {
			if (o.centerNum.equals(po.getcenterNum()))
				ComList = o.ComList;
			break;
		}
		for (ComPO p : ComList) {
			if (p.getGoodsNum().equals(po.getGoodsNum())) {
				ComList.remove(p);
				String[] info = { "更新信息成功" };
				CenterCom center=new CenterCom(ComList,po.getcenterNum());
				for (CenterCom o : totalList) {
					if (o.centerNum.equals(center.centerNum)) {
						o=new CenterCom(ComList,po.getcenterNum());
					}
				}
				ResultMessage ms = new ResultMessage(true, info);
				return ms;
			}
		}
		CenterCom center=new CenterCom(ComList,po.getcenterNum());
		for (CenterCom o : totalList) {
			if (o.centerNum.equals(center.centerNum)) {
				totalList.remove(o);
				totalList.add(center);
			}
		}
		ResultMessage ms;
		String[] infof = { "删除失败", "没有找到货物项" };
		return ms = new ResultMessage(false, infof);

	}

	@SuppressWarnings("unchecked")
	public ComPO findCom(String GoodsNum) {
		ArrayList<ComPO> ComList = null;

		for (CenterCom o : totalList) {
			ComList = o.ComList;
			for (ComPO po : ComList) {
				if (po.getGoodsNum().equals(GoodsNum)) {
					System.out.println(GoodsNum);
					return po;
				}
			}
		}
		// for(CenterCom o:totalList){
		// if(o.centerNum.equals(po.getcenterNum()))
		// ComList=o.ComList;
		// break;
		// }

		return null;
	}

	public ArrayList<ComPO> getAllCom(String centerNum) {
		
		
		for(CenterCom o:totalList){
			if(o.centerNum.equals(centerNum)){
				return o.ComList;
			}
		}
	
		return null;
	}
	public int getComSize(String centerNum) {
		for(CenterCom o:totalList){
			if(o.centerNum.equals(centerNum)){
				return o.ComList.size();
			}
		}
		return -1;
	}
}
