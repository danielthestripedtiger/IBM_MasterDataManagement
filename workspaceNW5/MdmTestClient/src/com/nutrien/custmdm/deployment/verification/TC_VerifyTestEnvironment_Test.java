package com.nutrien.custmdm.deployment.verification;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

public class TC_VerifyTestEnvironment_Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	@Test
	public void test_retrievePartyByEmail() throws Exception {
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrievePartyByEmail.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveParty\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMPartyContactMethodBObj\":[{"));
        Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Preferred Email\","));
        Assert.assertEquals(true, response.contains("\"TCRMContactMethodBObj\":{"));
        Assert.assertEquals(true, response.contains("\"ReferenceNumber\":\"nknbtrphxq@fwdthemsg.com\","));
        Assert.assertEquals(true, response.contains("\"ContactMethodValue\":\"Email Address\","));
        Assert.assertEquals(true, response.contains("\"TCRMPartyIdentificationBObj\":[{"));
        Assert.assertEquals(true, response.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, response.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, response.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, response.contains("\"TCRMPartyRelationshipBObj\":[{"));
        Assert.assertEquals(true, response.contains("\"TCRMPersonNameBObj\":[{"));
        Assert.assertEquals(true, response.contains("\"NameUsageValue\":\"Preferred\","));

        String orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, orgResponse.contains("\"OrganizationValue\":\"Unknown\","));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMOrganizationNameBObj\":[{"));
        Assert.assertEquals(true, orgResponse.contains("\"NameUsageValue\":\"Preferred\","));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMPartyIdentificationBObj\":[{"));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, orgResponse.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMPartyRelationshipBObj\":[{"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMContractBObj\":[{"));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMContractComponentBObj\":{"));
        Assert.assertEquals(true, orgResponse.contains("\"ContractStatusValue\":\"Active\","));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMContractPartyRoleBObj\":[{"));
        Assert.assertEquals(true, orgResponse.contains("\"RoleValue\":\"Owner\","));
        Assert.assertEquals(true, orgResponse.contains("\"TCRMAdminNativeKeyBObj\":[{"));
        Assert.assertEquals(true, orgResponse.contains("\"AdminFieldNameValue\":\"Account Number\","));
	}
	
	
	
	@Test
	public void test_retrieveAccount() throws Exception {
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        // validate contract
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":{"));
        Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":{"));
        Assert.assertEquals(true, response.contains("\"ContractStatusValue\":\"Active\","));
        Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":[{"));
        Assert.assertEquals(true, response.contains("\"RoleValue\":\"Owner\","));
        
        // validate owner role
        String ownerResponse = response.substring(response.indexOf("\"RoleValue\":\"Owner\","));
        Assert.assertEquals(true, ownerResponse.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, ownerResponse.contains("\"OrganizationValue\":\"Unknown\","));
        Assert.assertEquals(true, ownerResponse.contains("\"TCRMOrganizationNameBObj\":[{"));
        Assert.assertEquals(true, ownerResponse.contains("\"NameUsageValue\":\"Preferred\","));
        Assert.assertEquals(true, ownerResponse.contains("\"TCRMPartyIdentificationBObj\":[{"));
        Assert.assertEquals(true, ownerResponse.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, ownerResponse.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, ownerResponse.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, ownerResponse.contains("\"TCRMPartyRelationshipBObj\":[{"));
        
        // validate manages role
        String mangesResponse = response.substring(response.indexOf("\"RoleValue\":\"Manages\","));
        Assert.assertEquals(true, mangesResponse.contains("\"TCRMPersonBObj\":"));
        Assert.assertEquals(true, mangesResponse.contains("\"TCRMPartyContactMethodBObj\":[{"));
        Assert.assertEquals(true, mangesResponse.contains("\"ContactMethodUsageValue\":\"Preferred Email\","));
        Assert.assertEquals(true, mangesResponse.contains("\"TCRMContactMethodBObj\":{"));
        Assert.assertEquals(true, mangesResponse.contains("\"ReferenceNumber\":\"nknbtrphxq@fwdthemsg.com\","));
        Assert.assertEquals(true, mangesResponse.contains("\"ContactMethodValue\":\"Email Address\","));
        Assert.assertEquals(true, mangesResponse.contains("\"TCRMPartyIdentificationBObj\":[{"));
        Assert.assertEquals(true, mangesResponse.contains("\"IdentificationValue\":\"EID\","));
        Assert.assertEquals(true, mangesResponse.contains("\"IdentificationNumber\":"));
        Assert.assertEquals(true, mangesResponse.contains("\"IdentificationStatusValue\":\"Active\","));
        Assert.assertEquals(true, mangesResponse.contains("\"TCRMPartyRelationshipBObj\":[{"));
        Assert.assertEquals(true, mangesResponse.contains("\"TCRMPersonNameBObj\":[{"));
        Assert.assertEquals(true, mangesResponse.contains("\"NameUsageValue\":\"Preferred\","));

        // validate account information role
        String accountInformationResponse = response.substring(response.indexOf("\"RoleValue\":\"Account Information\","));
        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMOrganizationBObj\":"));
        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMOrganizationNameBObj\":[{"));
        Assert.assertEquals(true, accountInformationResponse.contains("\"NameUsageValue\":\"Preferred\""));
        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMPartyAddressBObj\":[{"));
        Assert.assertEquals(true, accountInformationResponse.contains("\"AddressUsageValue\":\"Billing\","));
        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMAddressBObj\":{"));

        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMPartyContactMethodBObj\":[{"));
        Assert.assertEquals(true, accountInformationResponse.contains("\"ContactMethodUsageValue\":\"Unknown Phone\","));
        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMContactMethodBObj\":{"));
        Assert.assertEquals(true, accountInformationResponse.contains("\"ContactMethodValue\":\"Telephone Number\""));
        Assert.assertEquals(true, accountInformationResponse.contains("\"TCRMAdminNativeKeyBObj\":[{"));
        Assert.assertEquals(true, accountInformationResponse.contains("\"AdminFieldNameValue\":\"Account Number\","));
        Assert.assertEquals(true, accountInformationResponse.contains("\"AdminFieldNameValue\":\"PPLSFT\""));
        Assert.assertEquals(true, accountInformationResponse.contains("\"AdminFieldNameValue\":\"CREDITPOINT\""));
        Assert.assertEquals(true, accountInformationResponse.contains("\"AdminFieldNameValue\":\"ARSUSA\""));
	}

}
