package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC_RetrieveAccount_Positive_Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/retrieveAccount/";
	
	static String orgEid;

	static HashMap<String, String> replaceStrings = new HashMap<String, String>();
	
	@Test
	public void test1_OrgAddContractWithContractPartyRole() throws Exception {
        // Add account with all possible objects
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainAccount_addAccount_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		
		// maintainParty_addPersonOrgRelationship
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", this.getClass()));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\",") || response.contains("Duplicate primary key already exists."));
        String orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        orgEid  = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf(",\"IdentificationStatusType"));
        
        System.out.println("orgEid = " + orgEid);
        
        // orgAddContractWithContractPartyRole
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "orgAddContractWithContractPartyRole.json", this.getClass());
        message = message.replace("ORG_EID_PLACEHOLDER1", orgEid);
        System.out.println(message);
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains(orgEid));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains("1225095"));
	}	

	
	@Test
	public void test2_retrieveAccountAll() throws Exception {
        // Send request and get response for "All" roles
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass());
        String response = sendRequestViaRest(message);
        
        //System.out.println(response);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Owner\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Manages\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\""));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1225095\""));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        //Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        //Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        //Assert.assertEquals(true, response.contains("\"PrivPrefActionValue\":\"Consent\""));
        //Assert.assertEquals(false, response.contains("\"PrivPrefActionValue\":\"Revoke Consent\""));
	}
	
	@Test
	public void test3_retrieveAccountOwner() throws Exception {
        // Send request and get response for "Owner" role
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccountOwner.json", this.getClass());
        String response = sendRequestViaRest(message);
       	
        System.out.println(response);
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Owner\""));
        Assert.assertEquals(false, response.contains("\"RoleValue\":\"Manages\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\""));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1225095\""));
	}
	
	@Test
	public void test4_retrieveAccountManages() throws Exception {
        // Send request and get response for "Manages" role
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccountManages.json", this.getClass());
        String response = sendRequestViaRest(message);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Owner\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Manages\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\""));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1225095\""));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        //Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        //Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        //Assert.assertEquals(true, response.contains("\"PrivPrefActionValue\":\"Consent\""));
        //Assert.assertEquals(false, response.contains("\"PrivPrefActionValue\":\"Revoke Consent\""));
	}
	
	
	@Test
	public void test5_retrieveAccountInfoDefault() throws Exception {
        // Send request and get response default request
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccountDefault.json", this.getClass());
        String response = sendRequestViaRest(message);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Owner\""));
        Assert.assertEquals(false, response.contains("\"RoleValue\":\"Manages\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Branch\""));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Sales Representative\""));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1225095\""));
	}
}