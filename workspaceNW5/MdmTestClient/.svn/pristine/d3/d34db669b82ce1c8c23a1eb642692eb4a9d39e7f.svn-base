package com.nutrien.custmdm.unittest.r1;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;


public class TC_RetrieveParty_Validation_Test extends AbstractMDMTest {

	static String xmlBaseDir = "req/retrieveParty/";
	
	@Test
	public void testPartyReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Party_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPartyBObj\","));
	}
		
	@Test
	public void testCmUsageReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmUsage_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ContactMethodUsageValue\","));
	}
		
	@Test
	public void testCmReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Cm_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContactMethodBObj\","));
	}
	
	@Test
	public void testCmRefNumReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmRefNum_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
	}
	
	@Test
	public void testCmValReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmVal_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
	}
	
	@Test
	public void testIdNumReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_IdNum_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: IdentificationNumber and IdentificationValue\","));
	}
	
	@Test
	public void testIdValReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_IdVal_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: IdentificationNumber and IdentificationValue\","));
	}
	
	@Test
	public void testPartyCmMissingReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PartyCmMissing_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Please specify either TCRMPartyContactMethodBObj or TCRMPartyIdentificationBObj (not both)\","));
	}
	
	@Test
	public void testPartyCmBothReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PartyCmBoth_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Please specify either TCRMPartyContactMethodBObj or TCRMPartyIdentificationBObj (not both)\","));
	}
	
}
