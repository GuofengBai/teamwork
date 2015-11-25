package org.businesslogic.blFactory;

import org.businesslogic.billsbl.NewSendingBillsBL;
import org.businesslogic.commoditybl.CheckCommodityBL;
import org.businesslogic.commoditybl.CommodityBL;
import org.businesslogic.commoditybl.DistrictChangeBL;
import org.businesslogic.managebl.ManageBL;
import org.businesslogic.organizationbl.OrganizationBL;
import org.businesslogic.staffbl.StaffBL;
import org.businesslogic.userbl.UserBL;
import org.businesslogicservice.billsblservice.NewCenterArriveBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterEntruckBillsBLService;
import org.businesslogicservice.billsblservice.NewCenterFreightBillsBLService;
import org.businesslogicservice.billsblservice.NewHallArriveBillsBLService;
import org.businesslogicservice.billsblservice.NewHallCollectBillsBLService;
import org.businesslogicservice.billsblservice.NewHallDispatchBillsBLService;
import org.businesslogicservice.billsblservice.NewHallEntruckBillsBLService;
import org.businesslogicservice.billsblservice.NewInstorageBillsBLService;
import org.businesslogicservice.billsblservice.NewOutstorageBillsBLService;
import org.businesslogicservice.billsblservice.NewPayingBillsBLService;
import org.businesslogicservice.billsblservice.NewSendingBillsBLService;
import org.businesslogicservice.commodityblservice.CommodityBLService;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.businesslogicservice.manageblservice.ManageBLService;
import org.businesslogicservice.organizationblservice.OrganizationBLService;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.businesslogicservice.userblservice.UserBLService;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;

public class BLFactory {
	
	public static CommodityBLService commodityBL;
	
	public static StaffBLService staffBL;
	
	public static OrganizationBLService organizationBL;
	
	public static ManageBLService manageBL;
	
	public static UserBLService userBL;
	
	public static NewSendingBillsBLService newSendingBillsBL;
	public static NewCenterArriveBillsBLService newCenterArriveBillsBL;
	public static NewCenterEntruckBillsBLService newCenterEntruckBillsBL;
	public static NewCenterFreightBillsBLService newCenterFreightBillsBL;
	public static NewHallArriveBillsBLService newHallArriveBillsBL;
	public static NewHallCollectBillsBLService newHallCollectBillsBL;
	public static NewHallDispatchBillsBLService newHallDispatchBillsBL;
	public static NewHallEntruckBillsBLService newHallEntruckBillsBL;
	public static NewInstorageBillsBLService newInstorageBillsBL;
	public static NewOutstorageBillsBLService newOutstorageBillsBL;
	public static NewPayingBillsBLService newPayingBillsBL;
	public static CheckCommodityBLService checkcommodityBL;
	public static DistrictChangeBLService districtchangeBL;
	
	public static void init(){
		commodityBL=null;
		staffBL=null;
		organizationBL=null;
		manageBL=null;
		userBL=null;
		newSendingBillsBL=null;
	}
	
	public static CommodityBLService getCommodityBL(){
		
		if(commodityBL==null){
			commodityBL=new CommodityBL();
		}
		
		return commodityBL;
	}

    public static StaffBLService getStaffBL(){
		
		if(staffBL==null){
			staffBL=new StaffBL();
		}
		
		return staffBL;
	}
    
    public static UserBLService getUserBL(){
		
		if(userBL==null){
		    userBL=new UserBL();
		}
		
		return userBL;
	}
    
    public static ManageBLService getManageBL(){
		
		if(manageBL==null){
		    manageBL=new ManageBL();
		}
		
		return manageBL;
	}
    
    public static OrganizationBLService getOrganizationBL(){
		
		if(organizationBL==null){
		    organizationBL=new OrganizationBL();
		}
		
		return organizationBL;
	}
    
    public static NewSendingBillsBLService getNewSendingBillsBL(){
		
		if(newSendingBillsBL==null){
		    newSendingBillsBL=new NewSendingBillsBL();
		}
		
		return newSendingBillsBL;
	}

	public static CheckCommodityBLService getCheckCommodityBL() {
		// TODO Auto-generated method stub
		if(checkcommodityBL==null){
			checkcommodityBL=new CheckCommodityBL();
		}
		return checkcommodityBL;
	}
	public static DistrictChangeBLService getDistrictChangeBL() {
		// TODO Auto-generated method stub
		if(districtchangeBL==null){
			districtchangeBL=new DistrictChangeBL();
		}
		return districtchangeBL;
    
	}
}
