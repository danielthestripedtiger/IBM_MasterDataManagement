package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC_RetrieveParty_Positive_Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/retrieveParty/";
	
	static String orgEid;
	
	static String orgContracts_uniqueNewAcctNum1 = Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999 + 1));

	static HashMap<String, String> replaceStrings = new HashMap<String, String>();
	
	@Test
	public void test1_OrgAddContractWithContractPartyRole() throws Exception {
		// maintainParty_addPersonOrgRelationship
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", this.getClass()));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\",") || response.contains("Duplicate primary key already exists."));
        String orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        orgEid  = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf(",\"IdentificationStatusType"));
        
        System.out.println("orgEid = " + orgEid);
        
        // orgAddContractWithContractPartyRole
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "orgAddContractWithContractPartyRole.json", this.getClass());
        message = message.replace("ORG_EID_PLACEHOLDER1", orgEid);
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
	public void test2_retrievePartyByEmail() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrievePartyByEmail.json", this.getClass()));
       	
        System.out.println(response);
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"Yes\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"No\""));
	}
	
	@Test
	public void test3_retrievePartyByEID() throws Exception {
        // Send request and get response.
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "retrievePartyByEID.json", this.getClass());
        message = message.replace("ORG_EID_PLACEHOLDER1", orgEid);
        String response = sendRequestViaRest(message);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"Yes\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"No\""));
	}
	
	@Test
	public void test4_retrievePartyDefaultPrivPref() throws Exception {
		// Create new person with new email address
		String emailAddr = "khai" + System.currentTimeMillis() % 100000 + "@lam.com";
		System.out.println(emailAddr);
		
        // Create new person
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPersonNoPrivPref.json", this.getClass());
        message = message.replace("EMAIL_PLACEHOLDER", "\"" + emailAddr + "\"");
        System.out.println(message);
        String response = sendRequestViaRest(message);
        
        // RetrieveParty for new person, default privacy preferences should have been created
        message = CommonUtil.getStringFromFile(xmlBaseDir, "retrievePartyByEmail2.json", this.getClass());
        message = message.replace("EMAIL_PLACEHOLDER", "\"" + emailAddr + "\"");
        System.out.println(message);
        response = sendRequestViaRest(message);
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-NEW_STATEMENT\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_DUE\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_PAST_DUE\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_FAILED\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_SUCCESSFUL\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_PENDING\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-NEW_INVOICE\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"No\""));
        Assert.assertEquals(false, response.contains("\"ValueString\":\"Yes\""));
	}

}
