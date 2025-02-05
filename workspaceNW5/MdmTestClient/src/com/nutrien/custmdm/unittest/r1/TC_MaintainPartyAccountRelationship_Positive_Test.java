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
public class TC_MaintainPartyAccountRelationship_Positive_Test extends AbstractMDMTest {

	static String xmlBaseDir = "req/maintainPartyAccountRelationship/";
	String response;
	
	static String orgContracts_uniqueNewAcctNum1 = "123";
	static String orgContracts_uniqueNewAcctNum2 = "456";
	static String orgContracts_uniqueNewAcctNum3 = "789";
	static String personContracts_uniqueNewAcctNum1 = "123";
	static String personContracts_uniqueNewAcctNum2 = "456";
	static String personContracts_uniqueNewAcctNum3 = "789";

	static String orgEid1;
	static String orgEid2;
	static String orgEid3;	
	static String personEid1;
	static String personEid2;
	static String personEid3;

	static HashMap<String, String> replaceStrings = new HashMap<String, String>();
	
	@Test
	public void test0_AddContract1() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "addContract1.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
	}
	
	@Test
	public void test0_AddContract2() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "addContract2.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
	}
	
	@Test
	public void test0_AddContract3() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "addContract3.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
	}
	
	@Test
	public void test1_OrgAddContractWithContractPartyRole() throws Exception {
		// Send request and get response.
		
        replaceStrings.put("PERSON_EMAIL_PLACEHOLDER", Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999 + 1)));        
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", replaceStrings, this.getClass()));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\",") || response.contains("Duplicate primary key already exists."));
        personEid1 = response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf(",\"IdentificationStatusType"));
        String orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        orgEid1  = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf(",\"IdentificationStatusType"));

        replaceStrings.put("PERSON_EMAIL_PLACEHOLDER", Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999 + 1)));
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", replaceStrings, this.getClass()));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\",") || response.contains("Duplicate primary key already exists."));
        personEid2 = response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf(",\"IdentificationStatusType"));
        orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        orgEid2  = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf(",\"IdentificationStatusType"));
 
        replaceStrings.put("PERSON_EMAIL_PLACEHOLDER", Integer.toString(ThreadLocalRandom.current().nextInt(1, 999999999 + 1)));
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", replaceStrings, this.getClass()));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\",") || response.contains("Duplicate primary key already exists."));
        personEid3 = response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf(",\"IdentificationStatusType"));
        orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        orgEid3  = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf(",\"IdentificationStatusType"));
 
        replaceStrings.put("ORG_EID_PLACEHOLDER1", orgEid1);
        replaceStrings.put("ORG_EID_PLACEHOLDER2", orgEid2);
        replaceStrings.put("ORG_EID_PLACEHOLDER3", orgEid3);
        replaceStrings.put("ORG_ACCOUNT_NUM_PLACEHOLDER1", orgContracts_uniqueNewAcctNum1);
        replaceStrings.put("ORG_ACCOUNT_NUM_PLACEHOLDER2", orgContracts_uniqueNewAcctNum2);
        replaceStrings.put("ORG_ACCOUNT_NUM_PLACEHOLDER3", orgContracts_uniqueNewAcctNum3);
                     
        replaceStrings.put("PERSON_EID_PLACEHOLDER1", personEid1);
        replaceStrings.put("PERSON_EID_PLACEHOLDER2", personEid2);
        replaceStrings.put("PERSON_EID_PLACEHOLDER3", personEid3);
        replaceStrings.put("PERSON_ACCOUNT_NUM_PLACEHOLDER1", personContracts_uniqueNewAcctNum1);
        replaceStrings.put("PERSON_ACCOUNT_NUM_PLACEHOLDER2", personContracts_uniqueNewAcctNum2);
        replaceStrings.put("PERSON_ACCOUNT_NUM_PLACEHOLDER3", personContracts_uniqueNewAcctNum3);
                     
		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "orgAddContractWithContractPartyRole.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("Contract not found"));

	}
		
	@Test
	public void test2_OrgUpdateContractPartyRole() throws Exception {
			
		// Send the same request again to make sure duplicate person is not created
		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "orgUpdateContractPartyRole.json", replaceStrings, this.getClass());
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
		Assert.assertEquals(true, response.contains("\"EndDate\":"));
		Assert.assertEquals(true, response.contains("\"RoleEndReasonValue\":"));
		Assert.assertEquals(true, response.contains("Retired"));
		Assert.assertEquals(true, response.contains(orgEid1));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains(orgContracts_uniqueNewAcctNum1));
	}

	@Test
	public void test3_OrgAddMultipleContractsWithContractPartyRole() throws Exception {
		// Send request and get response.

		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "orgAddMultipleContractsWithContractPartyRole.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":["));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains("\"Branch\""));
		Assert.assertEquals(true, response.contains("\"Sales Representative\""));
		Assert.assertEquals(true, response.contains(orgContracts_uniqueNewAcctNum2));
		Assert.assertEquals(true, response.contains(orgContracts_uniqueNewAcctNum3));
	}
		
	@Test
	public void test4_OrgUpdateMultipleContractPartyRoles() throws Exception {
		// Send request and get response.

		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "orgUpdateMultipleContractPartyRoles.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":["));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains("\"EndDate\":"));
		Assert.assertEquals(true, response.contains("\"RoleEndReasonValue\":"));
		Assert.assertEquals(true, response.contains("Retired"));
		Assert.assertEquals(true, response.contains(orgEid2));
		Assert.assertEquals(true, response.contains(orgEid3));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains(orgContracts_uniqueNewAcctNum2));
		Assert.assertEquals(true, response.contains(orgContracts_uniqueNewAcctNum3));
	}


	@Test
	public void test5_PersonAddContractWithContractPartyRole() throws Exception {
		// Send request and get response.

		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "personAddContractWithContractPartyRole.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains(personEid1));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains(personContracts_uniqueNewAcctNum1));
	}
		
	@Test
	public void test6_PersonUpdateContractPartyRole() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		
		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "personUpdateContractPartyRole.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains("\"EndDate\":"));
		Assert.assertEquals(true, response.contains("\"RoleEndReasonValue\":"));
		Assert.assertEquals(true, response.contains("Retired"));
		Assert.assertEquals(true, response.contains(personEid1));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains(personContracts_uniqueNewAcctNum1));
	}

	@Test
	public void test7_PersonAddMultipleContractsWithContractPartyRole() throws Exception {
		// Send request and get response.

		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "personAddMultipleContractsWithContractPartyRole.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":["));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains(personEid2));
		Assert.assertEquals(true, response.contains(personEid3));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains(personContracts_uniqueNewAcctNum2));
		Assert.assertEquals(true, response.contains(personContracts_uniqueNewAcctNum3));
	}
		
	@Test
	public void test8_PersonUpdateMultipleContractPartyRoles() throws Exception {
		// Send request and get response.

		String message = CommonUtil.getTstMsgFromFile(xmlBaseDir, "personUpdateMultipleContractPartyRoles.json", replaceStrings, this.getClass());
		response = sendRequestViaRest(message);

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":["));
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
		Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":"));
		Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
		Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
		Assert.assertEquals(true, response.contains("\"EndDate\":"));
		Assert.assertEquals(true, response.contains("\"RoleEndReasonValue\":"));
		Assert.assertEquals(true, response.contains("Retired"));
		Assert.assertEquals(true, response.contains(personEid2));
		Assert.assertEquals(true, response.contains(personEid3));
		Assert.assertEquals(true, response.contains("\"Owner\""));
		Assert.assertEquals(true, response.contains(personContracts_uniqueNewAcctNum2));
		Assert.assertEquals(true, response.contains(personContracts_uniqueNewAcctNum3));
	}
}
