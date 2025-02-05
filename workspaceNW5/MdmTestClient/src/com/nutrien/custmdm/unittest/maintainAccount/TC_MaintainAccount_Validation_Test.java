package com.nutrien.custmdm.unittest.maintainAccount;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;


public class TC_MaintainAccount_Validation_Test extends AbstractMDMTest {


	static String xmlBaseDir = "req/";
	
	@Test
	public void testContractReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Contract_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContractBObj\","));
	}
	
	
	@Test
	public void testAdminNativeKeyReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AdminNativeKey_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMAdminNativeKeyBObj\","));
	}
	
	
	@Test
	public void testAdminNativeKeyInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AdminNativeKeyInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AdminContractId & AdminFieldNameValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AdminNativeKeyInfo1_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AdminContractId & AdminFieldNameValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AdminNativeKeyInfo2_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AdminContractId & AdminFieldNameValue\","));
	}
	
	
	@Test
	public void testContractInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContractInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: CurrencyValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AgreementValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContractComponentBObj\","));
	}
	
	
	@Test
	public void testContractComponentInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContractComponentInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ContractStatusValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContractPartyRoleBObj\","));
	}
	
	
	@Test
	public void testContractRoleInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContractRoleInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: RoleValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMOrganizationBObj\","));
	}
	
	
	@Test
	public void testOrgInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_OrgInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: SourceIdentifierValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: OrganizationValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMOrganizationNameBObj\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPartyAddressBObj\","));
	}
	
	
	@Test
	public void testOrgNameInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_OrgNameInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: OrganizationName & NameUsageValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPartyAddressBObj\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_OrgNameInfo1_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: OrganizationName & NameUsageValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPartyAddressBObj\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_OrgNameInfo2_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: OrganizationName & NameUsageValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMPartyAddressBObj\","));
	}
	
	
	@Test
	public void testBillingAddressReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_BillingAddress_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: Billing Address\","));
	}
	
	
	@Test
	public void testAddressInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressUsageValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: Billing Address\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo1_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressLineOne, City, ZipPostalCode, ProvinceStateValue, CountryValue\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo2_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressLineOne, City, ZipPostalCode, ProvinceStateValue, CountryValue\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo3_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressLineOne, City, ZipPostalCode, ProvinceStateValue, CountryValue\","));
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo4_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressLineOne, City, ZipPostalCode, ProvinceStateValue, CountryValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo5_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressLineOne, City, ZipPostalCode, ProvinceStateValue, CountryValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_AddressInfo6_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AddressLineOne, City, ZipPostalCode, ProvinceStateValue, CountryValue\","));
	}
	
	
	@Test
	public void testContactMethodInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContactMethodInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ContactMethodUsageValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContactMethodBObj\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContactMethodInfo1_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ContactMethodUsageValue\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContactMethodBObj\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContactMethodInfo2_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContactMethodInfo3_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContactMethodInfo4_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: ReferenceNumber and ContactMethodValue\","));
	}
	
	
	@Test
	public void testPrivPrefInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PrivPrefInfo_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: PrivPrefActOptId, PrivPrefValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PrivPrefInfo1_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: PrivPrefActOptId, PrivPrefValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_PrivPrefInfo2_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following are required: PrivPrefActOptId, PrivPrefValue\","));
	}
	
	
	@Test
	public void testContractAlertInfoReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContractAlertInfo1_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AlertValue\","));
        
        
        response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContractAlertInfo2_Req.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AlertValue\","));
	}
	

}
