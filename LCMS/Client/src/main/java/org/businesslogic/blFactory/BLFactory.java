package org.businesslogic.blFactory;

import java.rmi.RemoteException;

import org.businesslogic.billsbl.NewCenterArriveBillsBL;
import org.businesslogic.billsbl.NewCenterEntruckBillsBL;
import org.businesslogic.billsbl.NewCenterFreightBillsBL;
import org.businesslogic.billsbl.NewHallCollectBillsBL;
import org.businesslogic.billsbl.NewHallDispatchBillsBL;
import org.businesslogic.billsbl.NewHallEntruckBillsBL;
import org.businesslogic.billsbl.NewHallArriveBillsBL;
import org.businesslogic.billsbl.NewInstorageBillsBL;
import org.businesslogic.billsbl.NewOutstorageBillsBL;
import org.businesslogic.billsbl.NewPayingBillsBL;
import org.businesslogic.billsbl.NewSendingBillsBL;
import org.businesslogic.commoditybl.CheckCommodityBL;
import org.businesslogic.commoditybl.CommodityBL;
import org.businesslogic.commoditybl.CommodityInAndOutBL;
import org.businesslogic.commoditybl.DistrictChangeBL;
import org.businesslogic.commoditybl.ExamineCommodityBL;
import org.businesslogic.commoditybl.SettingAlertBL;
import org.businesslogic.managebl.AccountManagementBL;
import org.businesslogic.managebl.BeginAccountBL;
import org.businesslogic.managebl.CostManagementBL;
import org.businesslogic.managebl.IncomeManagementBL;
import org.businesslogic.managebl.IncomeTableBL;
import org.businesslogic.managebl.ManageBL;
import org.businesslogic.managebl.NewBeginAccountBL;
import org.businesslogic.managebl.StatusTableBL;
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
import org.businesslogicservice.commodityblservice.CommodityInAndOutBLService;
import org.businesslogicservice.commodityblservice.DistrictChangeBLService;
import org.businesslogicservice.commodityblservice.ExamineCommodityBLService;
import org.businesslogicservice.commodityblservice.SettingAlertBLService;
import org.businesslogicservice.manageblservice.AccountManagementBLService;
import org.businesslogicservice.manageblservice.BeginAccountBLService;
import org.businesslogicservice.manageblservice.CostManagementBLService;
import org.businesslogicservice.manageblservice.IncomeManagementBLService;
import org.businesslogicservice.manageblservice.IncomeTableBLService;
import org.businesslogicservice.manageblservice.ManageBLService;
import org.businesslogicservice.manageblservice.NewBeginAccountBLService;
import org.businesslogicservice.manageblservice.StatusTableBLService;
import org.businesslogicservice.organizationblservice.OrganizationBLService;
import org.businesslogicservice.staffblservice.StaffBLService;
import org.businesslogicservice.userblservice.UserBLService;
import org.businesslogicservice.commodityblservice.CheckCommodityBLService;

public class BLFactory {

	public static CommodityBLService commodityBL;
	public static CommodityInAndOutBLService commodityInAndOutBL;

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
	public static ExamineCommodityBLService examinecommoditybl;
	
	public static AccountManagementBLService accountManagementBL;
	public static BeginAccountBLService beginAccountBL;
	public static IncomeManagementBLService incomeManagementBL;
	public static IncomeTableBLService incomeTableBL;
	public static NewBeginAccountBLService newBeginAccountBL;
	public static StatusTableBLService statusTableBL;
	public static SettingAlertBLService settingalertBL;
	public static CostManagementBLService costManagementBL;
	
	public static void init() {
		commodityBL = null;
		staffBL = null;
		organizationBL = null;
		manageBL = null;
		userBL = null;
		newSendingBillsBL = null;
		newCenterArriveBillsBL = null;
		newCenterEntruckBillsBL = null;
		newCenterFreightBillsBL = null;
		newHallArriveBillsBL = null;
		newHallCollectBillsBL = null;
		newHallDispatchBillsBL = null;
		newHallEntruckBillsBL = null;
		newInstorageBillsBL = null;
		newOutstorageBillsBL = null;
		newPayingBillsBL = null;
		
		accountManagementBL=null;
		beginAccountBL=null;
		incomeManagementBL=null;
		incomeTableBL=null;
		newBeginAccountBL=null;
		statusTableBL=null;
		costManagementBL=null;
		
		settingalertBL=null;
		examinecommoditybl=null;
		
	}

	public static CommodityBLService getCommodityBL() {

		if (commodityBL == null) {
			commodityBL = new CommodityBL();
		}

		return commodityBL;
	}
	
	public static CommodityInAndOutBLService getCommodityInAndOutBL() {

		if (commodityInAndOutBL == null) {
			commodityInAndOutBL = new CommodityInAndOutBL();
		}

		return commodityInAndOutBL;
	}
	public static SettingAlertBLService getSettingAlertBL() throws RemoteException {

		if (settingalertBL == null) {
			settingalertBL = new SettingAlertBL();
		}

		return settingalertBL;
	}
	public static ExamineCommodityBLService getExamineCommodityBL() throws RemoteException{
		if(examinecommoditybl==null){
			examinecommoditybl=new ExamineCommodityBL();
		}
		return examinecommoditybl;
	}

	public static StaffBLService getStaffBL() {

		if (staffBL == null) {
			staffBL = new StaffBL();
		}

		return staffBL;
	}

	public static UserBLService getUserBL() {

		if (userBL == null) {
			userBL = new UserBL();
		}

		return userBL;
	}

	public static ManageBLService getManageBL() {

		if (manageBL == null) {
			manageBL = new ManageBL();
		}

		return manageBL;
	}

	public static OrganizationBLService getOrganizationBL() {

		if (organizationBL == null) {
			organizationBL = new OrganizationBL();
		}

		return organizationBL;
	}

	public static NewSendingBillsBLService getNewSendingBillsBL() {

		if (newSendingBillsBL == null) {
			newSendingBillsBL = new NewSendingBillsBL();
		}

		return newSendingBillsBL;
	}

	public static NewCenterArriveBillsBLService getNewCenterArriveBillsBL() {

		if (newCenterArriveBillsBL == null) {
			newCenterArriveBillsBL = new NewCenterArriveBillsBL();
		}

		return newCenterArriveBillsBL;
	}
	
	public static NewCenterEntruckBillsBLService getNewCenterEntruckBillsBL() {

		if (newCenterEntruckBillsBL == null) {
			newCenterEntruckBillsBL = new NewCenterEntruckBillsBL();
		}

		return newCenterEntruckBillsBL;
	}
	
	public static NewCenterFreightBillsBLService getNewCenterFreightBillsBL() {

		if (newCenterFreightBillsBL == null) {
			newCenterFreightBillsBL = new NewCenterFreightBillsBL();
		}

		return newCenterFreightBillsBL;
	}
		
	public static NewHallArriveBillsBLService getNewHallArriveBillsBL() {

		if (newHallArriveBillsBL == null) {
			newHallArriveBillsBL = new NewHallArriveBillsBL();
		}

		return newHallArriveBillsBL;
	}
	
	public static NewHallCollectBillsBLService getNewHallCollectBillsBL() {

		if (newHallCollectBillsBL == null) {
			newHallCollectBillsBL = new NewHallCollectBillsBL();
		}

		return newHallCollectBillsBL;
	}
	
	public static NewHallDispatchBillsBLService getNewHallDispatchBillsBL() {

		if (newHallDispatchBillsBL == null) {
			newHallDispatchBillsBL = new NewHallDispatchBillsBL();
		}

		return newHallDispatchBillsBL;
	}
	
	public static NewHallEntruckBillsBLService getNewHallEntruckBillsBL() {

		if (newHallEntruckBillsBL == null) {
			newHallEntruckBillsBL = new NewHallEntruckBillsBL();
		}

		return newHallEntruckBillsBL;
	}
	
	public static NewInstorageBillsBLService getNewInstorageBillsBL() {

		if (newInstorageBillsBL == null) {
			newInstorageBillsBL = new NewInstorageBillsBL();
		}

		return newInstorageBillsBL;
	}
	
	public static NewOutstorageBillsBLService getNewOutstorageBillsBL() {

		if (newOutstorageBillsBL == null) {
			newOutstorageBillsBL = new NewOutstorageBillsBL();
		}

		return newOutstorageBillsBL;
	}
	
	public static NewPayingBillsBLService getNewPayingBillsBL() {

		if (newPayingBillsBL == null) {
			newPayingBillsBL = new NewPayingBillsBL();
		}

		return newPayingBillsBL;
	}

	public static CheckCommodityBLService getCheckCommodityBL() {
		// TODO Auto-generated method stub
		if (checkcommodityBL == null) {
			checkcommodityBL = new CheckCommodityBL();
		}
		return checkcommodityBL;
	}

	public static DistrictChangeBLService getDistrictChangeBL() {
		// TODO Auto-generated method stub
		if (districtchangeBL == null) {
			districtchangeBL = new DistrictChangeBL();
		}
		return districtchangeBL;

	}
	
	public static AccountManagementBLService getAccountManagementBL(){
		
		if(accountManagementBL == null){
			accountManagementBL=new AccountManagementBL();
		}
		return accountManagementBL;
	}
	
	public static BeginAccountBLService getBeginAccountBL(){
		
		if(beginAccountBL == null){
			beginAccountBL=new BeginAccountBL();
		}
		return beginAccountBL;
	}
	
	public static IncomeManagementBLService getIncomeManagementBL(){
	
		if(incomeManagementBL == null){
			incomeManagementBL=new IncomeManagementBL();
		}
	return incomeManagementBL;
	}
	
	public static IncomeTableBLService getIncomeTableBL(){
	
		if(incomeTableBL == null){
			incomeTableBL=new IncomeTableBL();
		}
		return incomeTableBL;
	}
	
	public static NewBeginAccountBLService getNewBeginAccountBL(){
	
		if(newBeginAccountBL == null){
			newBeginAccountBL=new NewBeginAccountBL();
		}
		return newBeginAccountBL;
	}

	public static StatusTableBLService getStatusTableBL(){
	
		if(statusTableBL == null){
			statusTableBL=new StatusTableBL();
		}
		return statusTableBL;
	}
	
	public static CostManagementBLService getCostManagementBL(){
		if(costManagementBL==null){
			costManagementBL=new CostManagementBL();
		}
		
		return costManagementBL;
	}
	
}
