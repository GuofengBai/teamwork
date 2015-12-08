package org.data.commoditydata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

import org.dataservice.commoditydataservice.CommodityDataService;
import org.po.AlertPO;
import org.po.BillsPO;
import org.po.CenterCom;
import org.po.ComPO;
import org.po.ResultMessage;
import org.po.StaffPO;
import org.po.myDate;

public class CommodityData extends UnicastRemoteObject implements
		CommodityDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LinkedList<CenterCom> totalList;

	public CommodityData() throws RemoteException {
		super();
		init();
		// TODO Auto-generated constructor stub
	}

	public AlertPO getAlert(String centerNum) throws RemoteException {
		for (CenterCom center : totalList) {
			if (center.centerNum.equals(centerNum)) {
				return center.po;
			}
		}
		return null;
	}

	public ResultMessage setAlert(String centerNum1, double line)
			throws RemoteException {
		ResultMessage re;
		String[] su = { "更改成功!" };
		String[] fa = { "更改失败!" };
		for (CenterCom center : totalList) {
			if (center.centerNum.equals(centerNum1)) {
				center.po = new AlertPO(line);
				save();
				return re = new ResultMessage(true, su);
			}
		}
		return re = new ResultMessage(false, fa);
	}

	private void init() {

		String fileName = "SerializableData/Com.file";
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			totalList = (LinkedList<CenterCom>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultMessage addCom(ComPO po) throws RemoteException {
		String[] fa = { "增加失败", "已存在货运单号对应的货物" };
		String[] used = { "该位置已有货物" };
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
			if (p.getcenterNum().equals(po.getcenterNum())
					&& (p.getArea().equals(po.getArea()) && (p.LocationNum()
							.equals(po.LocationNum())))) {
				return new ResultMessage(false, used);
			}
		}
		ComList.add(po);
//		for (CenterCom o : totalList) {
//			if (o.centerNum.equals(po.getcenterNum())) {
//				o = new CenterCom(ComList, po.getcenterNum());
//			}
//		}
		save();
		return new ResultMessage(true, null);
	}

	private void save() {
		String fileName = "SerializableData/Com.file";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(totalList);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				save();
				ResultMessage ms = new ResultMessage(true, info);
				return ms;
			}
		}
		ResultMessage ms;
		String[] infof = { "删除失败", "没有找到货物项" };
		return ms = new ResultMessage(false, infof);

	}
	@SuppressWarnings("unchecked")
	public ComPO findCom(String GoodsNum) throws RemoteException {
		ArrayList<ComPO> ComList = null;

		for (CenterCom o : totalList) {
			ComList = o.ComList;
			for (ComPO po : ComList) {
				if (po.getGoodsNum().equals(GoodsNum)) {
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

	public ArrayList<ComPO> getAllCom(String centerNum) throws RemoteException {

		for (CenterCom o : totalList) {
			if (o.centerNum.equals(centerNum)) {
				return o.ComList;
			}
		}

		return null;
	}

	public int getComSize(String centerNum) throws RemoteException {
		for (CenterCom o : totalList) {
			if (o.centerNum.equals(centerNum)) {
				return o.ComList.size();
			}
		}
		return -1;
	}
	/**
	 * 新增城市时的方法
	 */
	public ResultMessage addNewCity(String centerNum) throws RemoteException{
		String[] fa={"新增失败"};
		String[] su={"新增成功"};
		
		for (CenterCom o : totalList) {
			if (o.centerNum.equals(centerNum)) {
				return new ResultMessage(false,fa);
			}
		}
		
		totalList.add(new CenterCom(new ArrayList<ComPO>(),centerNum));
		save();
		return new ResultMessage(true,su);
	}
	public ResultMessage delNewCity(String centerNum) throws RemoteException{
		String[] fa={"删除失败"};
		String[] su={"删除成功"};
		
		for (CenterCom o : totalList) {
			if (o.centerNum.equals(centerNum)) {
				totalList.remove(o);
				save();
				return new ResultMessage(true,su);
			}
		}
		
		
		return new ResultMessage(false,fa);
	}
}
