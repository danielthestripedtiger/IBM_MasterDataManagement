package com.nutrien.custmdm.unittest.maintainAccount;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC_AddUpdateBranchSaleRep__Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	static String branch1 = "1816";
	static String branch2 = "1817";
	static String salesRep1 = "203233";
	static String salesRep2 = "303233";
	
	@Test
	public void test1_AddBranchSalesRep() throws Exception {
		// Add Branch 1 & 2
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Branch");
		replaceStrings.put("ID_VALUE", "Branch Number");
		replaceStrings.put("ID_NUMBER", branch1);
		replaceStrings.put("NAME", "Denver Valley");
		
        // Send request and get response.
		String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addBranch.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Branch Number\","));
        
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Branch");
		replaceStrings.put("ID_VALUE", "Branch Number");
		replaceStrings.put("ID_NUMBER", branch2);
		replaceStrings.put("NAME", "Fuel Branch");
		
        // Send request and get response.
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addBranch.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Branch Number\","));
		
		// Add SalesRep 1 & 2
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("email", "tom1@cPSagu.com");
		replaceStrings.put("employeeId", "2008134");
		replaceStrings.put("salesRepId", salesRep1);
		replaceStrings.put("firstname", "Tom");
		replaceStrings.put("lastname", "J");
        
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addEmployee.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        response = response.substring(response.indexOf("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Employee ID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Sales Rep ID\","));
		
        
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("email", "tom2@cPSagu.com");
		replaceStrings.put("employeeId", "3008134");
		replaceStrings.put("salesRepId", salesRep2);
		replaceStrings.put("firstname", "T");
		replaceStrings.put("lastname", "JO");
        
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addEmployee.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        response = response.substring(response.indexOf("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Employee ID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Sales Rep ID\","));
	}
	
	
	@Test
	public void test2_AddBranchSalesRepToAccount() throws Exception {
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("branch", branch1);
		replaceStrings.put("salesRep", salesRep1);
		
		// Add account and link with branch 1 & sales rep 1
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainAccount_BranchSalesRep_Req.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\","));
		Assert.assertEquals(true, response.contains(branch1));
		Assert.assertEquals(true, response.contains(salesRep1));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
	}
	
	
	@Test
	public void test3_updateBranchSalesRepToAccount() throws Exception {
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("branch", branch1);
		replaceStrings.put("salesRep", salesRep2);
		
		// Add account and link with branch 1 & sales rep 1
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainAccount_BranchSalesRep_Req.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\","));
		Assert.assertEquals(true, response.contains(branch1));
		Assert.assertEquals(true, response.contains(salesRep2));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
        
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("branch", branch2);
		
		// Add account and link with branch 1 & sales rep 1
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainAccount_BranchSalesRep_Req.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\","));
		Assert.assertEquals(true, response.contains(branch2));
		Assert.assertEquals(true, response.contains(salesRep2));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
        
        replaceStrings.put("branch", branch1);
		replaceStrings.put("salesRep", salesRep1);
        
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainAccount_BranchSalesRep_Req.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\","));
		Assert.assertEquals(true, response.contains(branch1));
		Assert.assertEquals(true, response.contains(salesRep1));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
        
        
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainAccount_BranchSalesRep_Req.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\","));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\","));
		Assert.assertEquals(true, response.contains(branch1));
		Assert.assertEquals(true, response.contains(salesRep1));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
	}
	
	
}
