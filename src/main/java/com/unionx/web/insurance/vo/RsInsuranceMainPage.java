package com.unionx.web.insurance.vo;

import java.util.ArrayList;
import java.util.List;

public class RsInsuranceMainPage implements java.io.Serializable {
	
	/*缴费人员类别实体*/
	private List<RsInsuranceAccount> rsInsuranceAccountList=new ArrayList<RsInsuranceAccount>();
	
	/*险种基数实体*/
	private List<RsInsuranceBase> rsInsuranceBaseList=new ArrayList<RsInsuranceBase>();

	public List<RsInsuranceAccount> getRsInsuranceAccountList() {
		return rsInsuranceAccountList;
	}

	public void setRsInsuranceAccountList(
			List<RsInsuranceAccount> rsInsuranceAccountList) {
		this.rsInsuranceAccountList = rsInsuranceAccountList;
	}

	public List<RsInsuranceBase> getRsInsuranceBaseList() {
		return rsInsuranceBaseList;
	}

	public void setRsInsuranceBaseList(List<RsInsuranceBase> rsInsuranceBaseList) {
		this.rsInsuranceBaseList = rsInsuranceBaseList;
	}

}
