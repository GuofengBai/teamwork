package org.vo;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.po.CenterEntruckBills;
import org.po.StateListPO;
import org.po.myDate;
import org.presentation.billsui.NewCenterEntruckBillsUI;

public class CEBVO implements PanelCreaterService{
	public myDate date;
	public String TrafficNum;
	public String HallNum;
	public String Vehicle;
	public String DriverName;
	public String ScouterName;
	public ArrayList<StateListPO> po;
	public CEBVO(myDate date, String TrafficNum,
			String HallNum, String Vehicle, String DriverName,
			String ScouterName, ArrayList<StateListPO> po){
		this.date=date;
		this.TrafficNum=TrafficNum;
		this.HallNum=HallNum;
		this.Vehicle=Vehicle;
		this.DriverName=DriverName;
		this.ScouterName=ScouterName;
		this.po=po;
	}
	public CEBVO(CenterEntruckBills po){
		this.date=po.getDate();
		this.TrafficNum=po.getidNum();
		this.HallNum=po.getHallNum();
		this.Vehicle=po.getVehicle();
		this.DriverName=po.getDriverName();
		this.ScouterName=po.getScouterName();
		this.po=po.getpo();
		
	}
	
	public JPanel careatePanel(JPanel su) {
		JPanel panel=new NewCenterEntruckBillsUI(su,this);
		return panel;
	}

}
