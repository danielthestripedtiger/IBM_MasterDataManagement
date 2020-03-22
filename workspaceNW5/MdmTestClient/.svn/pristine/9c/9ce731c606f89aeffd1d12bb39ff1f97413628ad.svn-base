package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;


public class TC_MaintainParty_Validation_Test extends AbstractMDMTest {


	static String xmlBaseDir = "req/maintainParty/";
	
	@Test
	public void testPersonReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Person_Org_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPersonBObj or TCRMOrganizationBObj\","));
	}
	
	
	@Test
	public void testPersonSourceReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Source_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: SourceIdentifierValue\","));
	}
	
	
	@Test
	public void testOrgSourceReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Org_Source_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: SourceIdentifierValue\","));
	}
	
	
	@Test
	public void testOrgValueReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Org_Value_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: OrganizationValue\","));
	}
	
	
	@Test
	public void testPcmReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Pcm_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Either TCRMPartyContactMethodBObj or TCRMPartyIdentificationBObj is required\","));
	}
	
	
	@Test
	public void testCmUsageReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmUsage_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ContactMethodUsageValue\","));
	}
	
	
	@Test
	public void testCmRefNumReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmRefNum_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
	}
	
	
	@Test
	public void testCmValueNumReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_CmValue_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
	}
	
	
	@Test
	public void testCmReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Cm_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContactMethodBObj\","));
	}
	
	
	@Test
	public void testNameReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Name_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPersonNameBObj\","));
	}
	
	
	@Test
	public void testNameUsageReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_NameUsage_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Person - NameUsageValue, FirstName and LastName are mandatory\","));
	}

	
	@Test
	public void testFirstNameReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_FirstName_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Person - NameUsageValue, FirstName and LastName are mandatory\","));
	}
	
	
	@Test
	public void testLastNameReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_LastName_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"Person - NameUsageValue, FirstName and LastName are mandatory\","));
	}
	
	
	@Test
	public void testOrgNameBObjReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Org_Name_BObj_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMOrganizationNameBObj\","));
	}
	
	
	@Test
	public void testOrgNameReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Org_Name_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"OrganizationName and NameUsageValue are required\","));
	}
	
	@Test
	public void testOrgNameUsageReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_OrgNameUsage_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"OrganizationName and NameUsageValue are required\","));
	}
	
	
	@Test
	public void testRelReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Rel_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required if Person and Org are supplied: TCRMPartyRelationshipBObj\","));
	}
	
	
	@Test
	public void testRelValueReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_RelValue_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: RelationshipValue\","));
	}
	
	
	@Test
	public void testPrivPrefReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Priv_Pref_Req.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: PrivPrefActOptId and PrivPrefValue\","));
	}
	
	
	@Test
	public void testClientStatusReq() throws Exception {
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Branch");
		
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Client_Status_Req.json", replaceStrings, this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ClientStatusValue\","));
       	
       	replaceStrings.put("ORG_VALUE", "Division");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Client_Status_Req.json", replaceStrings, this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ClientStatusValue\","));
       	
       	replaceStrings.put("ORG_VALUE", "Region");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Client_Status_Req.json", replaceStrings, this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ClientStatusValue\","));
	}
	
	
	@Test
	public void testOrgPiInfoReq() throws Exception {
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Branch");
		replaceStrings.put("ID_VALUE", "Branch Number");
		replaceStrings.put("ID_NUMBER", "");
		
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Pi_Info_Req.json", replaceStrings, this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: IdentificationValue and IdentificationNumber\","));
       	
       	replaceStrings.put("ORG_VALUE", "Division");
       	replaceStrings.put("ID_VALUE", "");
       	replaceStrings.put("ID_NUMBER", "3493872");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Pi_Info_Req.json", replaceStrings, this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: IdentificationValue and IdentificationNumber\","));
       	
       	replaceStrings.put("ORG_VALUE", "Region");
       	replaceStrings.put("ID_VALUE", "");
       	replaceStrings.put("ID_NUMBER", "");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Pi_Info_Req.json", replaceStrings, this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: IdentificationValue and IdentificationNumber\","));
	}

}
