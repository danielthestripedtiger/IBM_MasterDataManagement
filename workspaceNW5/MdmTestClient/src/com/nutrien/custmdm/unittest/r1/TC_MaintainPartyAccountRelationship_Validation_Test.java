package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;

import org.junit.runners.MethodSorters;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC_MaintainPartyAccountRelationship_Validation_Test extends AbstractMDMTest {

	static String xmlBaseDir = "req/maintainPartyAccountRelationship/";
	String response;
	static HashMap<String, String> replaceStrings = new HashMap<String, String>();
	
	@Test
	public void test01_validation_Org_AccountNumber_Req() throws Exception {

		// Send request and get response.
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Org_AccountNumber_Req.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("The following is required: Account Number"));
	}

	@Test
	public void test02_validation_Org_EID_Req() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Org_EID_Req.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("The following is required: EID"));
	}

	@Test
	public void test03_validation_Org_PartyRoleValue_Req() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Org_PartyRoleValue_Req.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("The following is required: Party Role Value"));
	}

	// TODO: This should be a Negative test case
	@Test
	public void test04_validation_Org_NonExistentEID_NotFound() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Org_NonExistentEID_NotFound.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("Party EID does not correspond to an existing party."));
	}

	@Test
	public void test05_validation_Person_AccountNumber_Req() throws Exception {

		// Send request and get response.
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Person_AccountNumber_Req.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("The following is required: Account Number"));
	}

	@Test
	public void test06_validation_Person_EID_Req() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Person_EID_Req.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("The following is required: EID"));
	}

	@Test
	public void test07_validation_Person_PartyRoleValue_Req() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Person_PartyRoleValue_Req.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("The following is required: Party Role Value"));
	}

	@Test
	public void test08_validation_Contract_REQ() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Contract_REQ.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("Invalid content was found starting with element 'TCRMAdminNativeKeyBObj'"));
	}
	
	@Test
	public void test09_validation_CompositeParty_REQ() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_CompositeParty_REQ.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("TCRMContractBObj incompatible with com.nutrien.custmdm.component.MDMCompositePartyBObj"));
	}
}
