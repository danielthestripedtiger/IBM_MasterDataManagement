package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC_MaintainPrivacyPreference_Positive_Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/maintainPrivacyPreference/";
	
	static String personEid;

	static HashMap<String, String> replaceStrings = new HashMap<String, String>();
	
	@Test
	public void test1_AddPerson() throws Exception {
		// maintainParty_addPerson
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPerson.json", this.getClass()));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\",") || response.contains("Duplicate primary key already exists."));
        String personResponse = response.substring(response.indexOf("\"TCRMPersonBObj\":"));
        personEid  = personResponse.substring(personResponse.indexOf("\"IdentificationNumber\":")+23, personResponse.indexOf(",\"IdentificationStatusType"));
        System.out.println("personEid = " + personEid);
	}	
	
	@Test
	public void test2_maintainPrivacyPref_Consent() throws Exception {
        // Send request and get response for "Consent" action
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "maintainPrivacyPref_Consent.json", this.getClass());
        message = message.replace("PERSON_EID_PLACEHOLDER", personEid);
        System.out.println(message);
		String response = sendRequestViaRest(message);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"PartyId\":" + personEid));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"Yes\""));
        Assert.assertEquals(false, response.contains("\"ValueString\":\"No\""));
	}
	
	@Test
	public void test3_maintainPrivacyPref_RevokeConsent() throws Exception {
        // Send request and get response for "Consent" action
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "maintainPrivacyPref_RevokeConsent.json", this.getClass());
        message = message.replace("PERSON_EID_PLACEHOLDER", personEid);
        System.out.println(message);
		String response = sendRequestViaRest(message);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"PartyId\":" + personEid));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"No\""));
        Assert.assertEquals(false, response.contains("\"ValueString\":\"Yes\""));
	}
	
	@Test
	public void test4_maintainPrivacyPref_ContactMethod() throws Exception {
        // Send request and get response for "Consent" action
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "maintainPrivacyPref_ContactMethod.json", this.getClass());
        message = message.replace("PERSON_EID_PLACEHOLDER", personEid);
        System.out.println(message);
		String response = sendRequestViaRest(message);
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"PartyId\":" + personEid));
        Assert.assertEquals(true, response.contains("\"TCRMPartyContactMethodBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_DUE\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_PAST_DUE\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"ACCOUNT-PAYMENT_SUCCESSFUL\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"Yes\""));
        Assert.assertEquals(false, response.contains("\"ValueString\":\"No\""));
	}

}