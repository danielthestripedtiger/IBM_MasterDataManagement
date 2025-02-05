package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

public class TC_MaintainParty_Positive_Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/maintainParty/";
	
	@Test
	public void testAddPersonAndOrgAndRelationship() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPerson.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        
        String personPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        String personIdentId = response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"));
        String personEid = response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"));
        
        
        // Send the same request again to make sure duplicate person is not created
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPerson.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, personPartyId.equals(response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"))));
        Assert.assertEquals(true, personIdentId.equals(response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"))));
        Assert.assertEquals(true, personEid.equals(response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"))));
        
        
        // Send the same request again to make sure duplicate person is not created
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPerson.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, personPartyId.equals(response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"))));
        Assert.assertEquals(true, personIdentId.equals(response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"))));
        Assert.assertEquals(true, personEid.equals(response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"))));

        
        // Send the same request again to make sure duplicate person is not created, except this time, pass in the EID
        String message = CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPersonEid.json", this.getClass());
        String eid = personEid.substring(1, 19);
        System.out.println("eid = " + eid);
        message = message.replace("PERSON_EID_PLACEHOLDER", eid);
		response = sendRequestViaRest(message);
      	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, personPartyId.equals(response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"))));
        Assert.assertEquals(true, personIdentId.equals(response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"))));
        Assert.assertEquals(true, personEid.equals(response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"))));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, personPartyId.equals(response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"))));
        Assert.assertEquals(true, personIdentId.equals(response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"))));
        Assert.assertEquals(true, personEid.equals(response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"))));
        
        String orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationStatusValue\":\"Active\","));
        
        String orgPartyId = orgResponse.substring(orgResponse.indexOf("\"PartyId\":")+10, orgResponse.indexOf("IdentificationType"));
        String orgIdentId = orgResponse.substring(orgResponse.indexOf("\"IdentificationIdPK\":")+20, orgResponse.indexOf("\"PartyId\":"));
        String orgEid = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf("StartDate"));
        
        String relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Manages\","));
        Assert.assertEquals(true, personPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromPartyId\":")+26, relationshipResponse.indexOf("RelationshipToPartyId"))));
        Assert.assertEquals(true, orgPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainParty_addPersonOrgRel_SameOrg.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, personPartyId.equals(response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"))));
        Assert.assertEquals(true, personIdentId.equals(response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"))));
        Assert.assertEquals(true, personEid.equals(response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"))));
        
        orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationStatusValue\":\"Active\","));
        
        Assert.assertEquals(true, orgPartyId.equals(orgResponse.substring(orgResponse.indexOf("\"PartyId\":")+10, orgResponse.indexOf("IdentificationType"))));
        Assert.assertEquals(true, orgIdentId.equals(orgResponse.substring(orgResponse.indexOf("\"IdentificationIdPK\":")+20, orgResponse.indexOf("\"PartyId\":"))));
        Assert.assertEquals(true, orgEid.equals(orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":")+23, orgResponse.indexOf("StartDate"))));
        
        relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Manages\","));
        Assert.assertEquals(true, personPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromPartyId\":")+26, relationshipResponse.indexOf("RelationshipToPartyId"))));
        Assert.assertEquals(true, orgPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));

        
        // Retrieve Party to verify Privacy Preference
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrievePartyByEmail.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Marketing Information\""));
        Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Receive Paperless Statement\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"Yes\""));
        Assert.assertEquals(true, response.contains("\"ValueString\":\"No\""));
        
	}
	
	
	@Test
	public void testAddBranchDivisionRegion() throws Exception {
		// Add Region
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Region");
		replaceStrings.put("ID_VALUE", "Region Number");
		replaceStrings.put("ID_NUMBER", "7325");
		replaceStrings.put("NAME", "Canada Retail Admin");
		
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addRegion.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Region Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"7325"));
        
        String regionPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        // Add Division
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Division");
		replaceStrings.put("ID_VALUE", "Division Number");
		replaceStrings.put("ID_NUMBER", "1684");
		replaceStrings.put("NAME", "Wholesale Division");
		replaceStrings.put("REGION_NUMBER", "7325");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addDivision.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Division Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1684"));
        
        String divisionPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        String relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Division of\","));
        Assert.assertEquals(true, divisionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromPartyId\":")+26, relationshipResponse.indexOf("RelationshipToPartyId"))));
        Assert.assertEquals(true, regionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
        
        // Add Branch
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Branch");
		replaceStrings.put("ID_VALUE", "Branch Number");
		replaceStrings.put("ID_NUMBER", "1715");
		replaceStrings.put("NAME", "Silver Valley");
		replaceStrings.put("DIVISION_NUMBER", "1684");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addBranchAndRel.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Branch Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1715"));
        
        String branchPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Branch of\","));
        Assert.assertEquals(true, branchPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromPartyId\":")+26, relationshipResponse.indexOf("RelationshipToPartyId"))));
        Assert.assertEquals(true, divisionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
	}
	
	
	@Test
	public void testAddRegionThenRelationship() throws Exception {
		// Add Region
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Region");
		replaceStrings.put("ID_VALUE", "Region Number");
		replaceStrings.put("ID_NUMBER", "7326");
		replaceStrings.put("NAME", "Eastern Region");
		
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addRegion.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Region Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"7326"));
        
        String regionPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        // Add Division
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Division");
		replaceStrings.put("ID_VALUE", "Division Number");
		replaceStrings.put("ID_NUMBER", "1685");
		replaceStrings.put("NAME", "East Fuel Div Admin");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addRegion.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Division Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1685"));
        
        String divisionPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        Assert.assertEquals(false, response.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(false, response.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(false, response.contains("\"RelationshipValue\":\"Division of\","));
        
        // Update Division with relationship 
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Division");
		replaceStrings.put("ID_VALUE", "Division Number");
		replaceStrings.put("ID_NUMBER", "1685");
		replaceStrings.put("NAME", "Wholesale Division");
		replaceStrings.put("REGION_NUMBER", "7326");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addDivision.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Division Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1685"));
        
        String relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Division of\","));
        Assert.assertEquals(true, divisionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromPartyId\":")+26, relationshipResponse.indexOf("RelationshipToPartyId"))));
        Assert.assertEquals(true, regionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
	}
	
	
	@Test
	public void testAddRegionDivisionBranchAndEmployee() throws Exception {
		// Add Region
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Region");
		replaceStrings.put("ID_VALUE", "Region Number");
		replaceStrings.put("ID_NUMBER", "7327");
		replaceStrings.put("NAME", "Canada Retail Admin");
		
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addRegion.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Region Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"7327"));
        
        String regionPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        // Add Division
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Division");
		replaceStrings.put("ID_VALUE", "Division Number");
		replaceStrings.put("ID_NUMBER", "1686");
		replaceStrings.put("NAME", "Wholesale Division");
		replaceStrings.put("REGION_NUMBER", "7327");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addDivision.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Division Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1686"));
        
        String divisionPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        String relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Division of\","));
        Assert.assertEquals(true, divisionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromPartyId\":")+26, relationshipResponse.indexOf("RelationshipToPartyId"))));
        Assert.assertEquals(true, regionPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
		
		// Add Branch
		replaceStrings = new HashMap<String, String>();
		replaceStrings.put("ORG_VALUE", "Branch");
		replaceStrings.put("ID_VALUE", "Branch Number");
		replaceStrings.put("ID_NUMBER", "1629");
		replaceStrings.put("NAME", "Shellbrook");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addBranch.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Branch Number\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1629"));
        
        String branchPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        // Add Employee
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("email", "tom.JOHNSON@cPSagu.com");
		replaceStrings.put("employeeId", "1008134");
		replaceStrings.put("salesRepId", "103233");
		replaceStrings.put("firstname", "Tom");
		replaceStrings.put("lastname", "Johnson");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addEmployee.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Employee ID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1008134"));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Sales Rep ID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"103233"));
        
        String employee1PartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        Assert.assertEquals(false, response.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(false, response.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(false, response.contains("\"RelationshipValue\":\"Division of\","));
        
        
        // Create relationship for the above employee
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("email", "tom.JOHNSON@cPSagu.com");
		replaceStrings.put("employeeId", "1008134");
		replaceStrings.put("firstname", "Tom");
		replaceStrings.put("lastname", "Johnson");
		replaceStrings.put("REL1_TO_VALUE", "1629");
		replaceStrings.put("RELATIONSHIP1_VALUE", "Facility Manager");
		replaceStrings.put("REL2_TO_VALUE", "1686");
		replaceStrings.put("RELATIONSHIP2_VALUE", "Division Manager");
		replaceStrings.put("REL3_TO_VALUE", "7327");
		replaceStrings.put("RELATIONSHIP3_VALUE", "Region Manager");
		replaceStrings.put("REL4_TO_VALUE", "1629");
		replaceStrings.put("RELATIONSHIP4_VALUE", "AR Contact - Branch");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addEmployeeAndRelationship.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Employee ID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1008134"));
        Assert.assertEquals(true, employee1PartyId.equals(response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"))));
        
        relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Facility Manager\","));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Division Manager\","));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Region Manager\","));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"AR Contact - Branch\","));
        Assert.assertEquals(true, employee1PartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromValue\":")+24, relationshipResponse.indexOf("RelationshipToValue"))));
        Assert.assertEquals(true, branchPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
        
        // Create new Employee with relationship 
        replaceStrings = new HashMap<String, String>();
		replaceStrings.put("email", "tommy.JOhN@cpsAgu.com");
		replaceStrings.put("employeeId", "1008135");
		replaceStrings.put("firstname", "Tommy");
		replaceStrings.put("lastname", "John");
		replaceStrings.put("REL1_TO_VALUE", "1629");
		replaceStrings.put("RELATIONSHIP1_VALUE", "Facility Manager");
		replaceStrings.put("REL2_TO_VALUE", "1686");
		replaceStrings.put("RELATIONSHIP2_VALUE", "AR Contact - Division");
		replaceStrings.put("REL3_TO_VALUE", "7327");
		replaceStrings.put("RELATIONSHIP3_VALUE", "MSRRegion");
		replaceStrings.put("REL4_TO_VALUE", "1686");
		replaceStrings.put("RELATIONSHIP4_VALUE", "Division Manager");
		
        // Send request and get response.
        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addEmployeeAndRelationship.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        response = response.substring(response.indexOf("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(false, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"Employee ID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":\"1008135"));
        
        String employee2PartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        
        relationshipResponse = response.substring(response.indexOf("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"TCRMPartyRelationshipBObj\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"PartyRelationshipIdPK\":"));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Facility Manager\","));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"Division Manager\","));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"MSRRegion\","));
        Assert.assertEquals(true, relationshipResponse.contains("\"RelationshipValue\":\"AR Contact - Division\","));
        Assert.assertEquals(true, employee2PartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipFromValue\":")+24, relationshipResponse.indexOf("RelationshipToValue"))));
        Assert.assertEquals(true, branchPartyId.equals(relationshipResponse.substring(relationshipResponse.indexOf("\"RelationshipToPartyId\":")+24, relationshipResponse.indexOf("RelationshipToPartyName"))));
	}
	
	
	@Test
	public void testAddUpdatePreferredPhoneAndEmail() throws Exception {
		HashMap<String, String> replaceStrings = new HashMap<String, String>();
		replaceStrings.put("emailAddress", "1234@gmail.com");
		replaceStrings.put("phoneNumber", "23957394#(&$*8759435748");
		replaceStrings.put("firstName", "Aaron");
		replaceStrings.put("lastName", "Hal");
		
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_PhoneAndEmail.json", replaceStrings, this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":["));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        
        String personPartyId = response.substring(response.indexOf("\"PartyId\":")+10, response.indexOf("IdentificationType"));
        String personIdentId = response.substring(response.indexOf("\"IdentificationIdPK\":")+20, response.indexOf("\"PartyId\":"));
        String personEid = response.substring(response.indexOf("\"IdentificationNumber\":")+23, response.indexOf("StartDate"));
	}
	
	
	
}
