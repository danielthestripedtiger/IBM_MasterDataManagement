package com.nutrien.custmdm.unittest.r1;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;


public class TC_RetrieveAccount_Validation_Test extends AbstractMDMTest {

	static String xmlBaseDir = "req/retrieveAccount/";
	
	@Test
	public void testContractReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_Contract.json", this.getClass()));
       	
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
        Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMContractBObj\","));
	}
		
	@Test
	public void testNativeKeyReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_NativeKey.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: TCRMAdminNativeKeyBObj\","));
	}
		
	@Test
	public void testContractIdReq() throws Exception {
        // Send request and get response.
        String response = sendRequestViaRest(CommonUtil.getStringFromFile(xmlBaseDir, "validation_ContractId.json", this.getClass()));
        
        Assert.assertEquals(true, response.contains("\"RequestType\":\"RetrieveAccount\","));
        Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
       	Assert.assertEquals(true, response.contains("\"ErrorMessage\":\"The following is required: AdminContractId\","));
	}
	
}
