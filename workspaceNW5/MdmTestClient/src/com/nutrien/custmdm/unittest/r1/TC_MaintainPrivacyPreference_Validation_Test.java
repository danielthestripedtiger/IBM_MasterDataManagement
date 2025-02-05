package com.nutrien.custmdm.unittest.r1;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;


public class TC_MaintainPrivacyPreference_Validation_Test extends AbstractMDMTest {

	static String xmlBaseDir = "req/maintainPrivacyPreference/";
	
	@Test
	public void testPersonReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Person_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPersonBObj\","));
	}
	
	@Test
	public void testPartyIdBObjReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PartyIdBObj_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPartyIdentificationBObj\","));
	}
		
	@Test
	public void testPartyPrivPrefBObjReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PartyPrivPrefBObj_Req.json", this.getClass()));

        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Either TCRMPartyPrivPrefBObj or TCRMPartyContactMethodPrivPrefBObj is required\","));
	}
	
	@Test
	public void testIdNumReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_IdNum_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following TCRMPartyIdentificationBObj elements are required: IdentificationNumber and IdentificationValue\","));
	}
	
	@Test
	public void testIdValReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_IdVal_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following TCRMPartyIdentificationBObj elements are required: IdentificationNumber and IdentificationValue\","));
	}
	
	@Test
	public void testSrcIdReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_SrcId_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("elements are required: SourceIdentValue, ValueString, PrivPrefValue"));
	}
	
	@Test
	public void testValueStringReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ValueString_Req.json", this.getClass()));

        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("elements are required: SourceIdentValue, ValueString, PrivPrefValue"));
	}
	
	@Test
	public void testPrivPrefValReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PrivPrefValue_Req.json", this.getClass()));

        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("elements are required: SourceIdentValue, ValueString, PrivPrefValue"));
	}
	
	@Test
	public void testPersonNotFoundReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PersonNotFound_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Person not found\","));
	}
	
	@Test
	public void testCmUsageValReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContactMethodUsage.json", this.getClass()));

        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ContactMethodUsageValue\","));
	}
	
	@Test
	public void testRefNumReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_RefNum.json", this.getClass()));

        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: ReferenceNumber and ContactMethodValue\","));
	}
	
	@Test
	public void testCmPrivPrefReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmPrivPref.json", this.getClass()));

        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPrivacyPreference\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"TCRMPartyContactMethodPrivPrefBObj is required\","));
	}
}
