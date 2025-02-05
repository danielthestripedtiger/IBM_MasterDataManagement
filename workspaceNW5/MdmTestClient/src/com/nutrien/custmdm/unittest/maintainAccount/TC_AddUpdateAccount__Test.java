package com.nutrien.custmdm.unittest.maintainAccount;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

public class TC_AddUpdateAccount__Test extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	@Test
	public void testAddUpdateAccount() throws Exception {
        // Add account with all possible objects
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainAccount_addAccount_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"CurrencyValue\":\"U.S. Dollar\","));
		Assert.assertEquals(true, response.contains("\"AgreementValue\":\"Grower\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"ContractStatusValue\":\"Active\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
		Assert.assertEquals(true, response.contains("\"SourceIdentifierValue\":\"PPLSFT\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationNameBObj\":"));
		Assert.assertEquals(true, response.contains("\"NameUsageValue\":\"Internal\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMPartyAddressBObj\":"));
		Assert.assertEquals(true, response.contains("\"AddressUsageValue\":\"Billing\","));
		Assert.assertEquals(true, response.contains("\"AddressUsageValue\":\"Shipping\","));
		Assert.assertEquals(true, response.contains("\"TCRMAddressBObj\":"));
		Assert.assertEquals(true, response.contains("\"AddressLineOne\":\"12367 Main St.\","));
		Assert.assertEquals(true, response.contains("\"City\":\"Bakersfield\","));
		Assert.assertEquals(true, response.contains("\"ZipPostalCode\":\"67667\","));
		Assert.assertEquals(true, response.contains("\"ProvinceStateValue\":\"CA\","));
		Assert.assertEquals(true, response.contains("\"CountryValue\":\"Canada\","));
//		Assert.assertEquals(true, response.contains("\"CountyName\":\"Denver\","));

		Assert.assertEquals(true, response.contains("\"TCRMPartyContactMethodBObj\":"));
		Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Billing Phone\","));
		Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Shipping Phone\","));
		Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Contact Email\","));
		Assert.assertEquals(true, response.contains("\"TCRMContactMethodBObj\":"));
		Assert.assertEquals(true, response.contains("\"ReferenceNumber\":\"5678961234\","));
		Assert.assertEquals(true, response.contains("\"ReferenceNumber\":\"abc@yahoo.com\","));
		// Verify Phone number
		
		Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
		Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Statement Hold\","));
		Assert.assertEquals(true, response.contains("\"PrivPrefActionValue\":\"Yes\","));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
        Assert.assertEquals(true, response.contains("\"AdminFieldNameValue\":\"PPLSFT\","));
        
        Assert.assertEquals(true, response.contains("\"TCRMContractAlertBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMAlertBObj\":"));
        Assert.assertEquals(true, response.contains("\"AlertValue\":\"Credit - Over Limit\","));
        Assert.assertEquals(true, response.contains("\"AlertSeverityValue\":\"High\","));
        Assert.assertEquals(true, response.contains("\"AlertCategoryValue\":\"Credit Hold Reason\","));
        
        // Modify Currency Type and Agreement Value
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "maintainAccount_addAccount_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "retrieveAccount.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
		
        Assert.assertEquals(true, response.contains("\"TCRMContractBObj\":"));
		Assert.assertEquals(true, response.contains("\"CurrencyValue\":\"U.S. Dollar\","));
		Assert.assertEquals(true, response.contains("\"AgreementValue\":\"Grower\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMContractComponentBObj\":"));
		Assert.assertEquals(true, response.contains("\"ContractStatusValue\":\"Active\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMContractPartyRoleBObj\":["));
		Assert.assertEquals(true, response.contains("\"RoleValue\":\"Account Information\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationBObj\":"));
		Assert.assertEquals(true, response.contains("\"SourceIdentifierValue\":\"PPLSFT\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMOrganizationNameBObj\":"));
		Assert.assertEquals(true, response.contains("\"NameUsageValue\":\"Internal\","));
		
		Assert.assertEquals(true, response.contains("\"TCRMPartyAddressBObj\":"));
		Assert.assertEquals(true, response.contains("\"AddressUsageValue\":\"Billing\","));
		Assert.assertEquals(true, response.contains("\"AddressUsageValue\":\"Shipping\","));
		Assert.assertEquals(true, response.contains("\"TCRMAddressBObj\":"));
		Assert.assertEquals(true, response.contains("\"AddressLineOne\":\"12367 Main St.\","));
		Assert.assertEquals(true, response.contains("\"City\":\"Bakersfield\","));
		Assert.assertEquals(true, response.contains("\"ZipPostalCode\":\"67667\","));
		Assert.assertEquals(true, response.contains("\"ProvinceStateValue\":\"CA\","));
		Assert.assertEquals(true, response.contains("\"CountryValue\":\"Canada\","));
//		Assert.assertEquals(true, response.contains("\"CountyName\":\"Denver\","));

		Assert.assertEquals(true, response.contains("\"TCRMPartyContactMethodBObj\":"));
		Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Billing Phone\","));
		Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Shipping Phone\","));
		Assert.assertEquals(true, response.contains("\"ContactMethodUsageValue\":\"Contact Email\","));
		Assert.assertEquals(true, response.contains("\"TCRMContactMethodBObj\":"));
		Assert.assertEquals(true, response.contains("\"ReferenceNumber\":\"5678961234\","));
		Assert.assertEquals(true, response.contains("\"ReferenceNumber\":\"abc@yahoo.com\","));
		// Verify Phone number
		
		Assert.assertEquals(true, response.contains("\"TCRMPartyPrivPrefBObj\":"));
		Assert.assertEquals(true, response.contains("\"PrivPrefValue\":\"Statement Hold\","));
		Assert.assertEquals(true, response.contains("\"PrivPrefActionValue\":\"Yes\","));
		
        Assert.assertEquals(true, response.contains("\"TCRMAdminNativeKeyBObj\":"));
        Assert.assertEquals(true, response.contains("\"AdminContractId\":\"1409100\","));
        Assert.assertEquals(true, response.contains("\"AdminFieldNameValue\":\"PPLSFT\","));
        
        Assert.assertEquals(true, response.contains("\"TCRMContractAlertBObj\":"));
        Assert.assertEquals(true, response.contains("\"TCRMAlertBObj\":"));
        Assert.assertEquals(true, response.contains("\"AlertValue\":\"Credit - Over Limit\","));
        Assert.assertEquals(true, response.contains("\"AlertSeverityValue\":\"High\","));
        Assert.assertEquals(true, response.contains("\"AlertCategoryValue\":\"Credit Hold Reason\","));
	}
	
	
}
