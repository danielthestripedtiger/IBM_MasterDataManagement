package com.nutrien.custmdm.load;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

public class MyCpsLoadProdTest extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	@Test
	public void testLoadMyCpsData() throws Exception {
		InputStream fis = MyCpsLoadProdTest.class.getResourceAsStream(xmlBaseDir + "mdm_load_mycps_data_06_12.csv"); 
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        while (true) {
        	String line = br.readLine();
        	if(line == null)
        		break;
        	
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
				String email = st.nextToken();
				String hashEmail = st.nextToken();
				String firstName = st.nextToken();
				String LastName = st.nextToken();
				String orgName = st.nextToken();
				
				String accountId = st.nextToken();
				
				HashMap<String, String> replaceStrings = new HashMap<String, String>();
				replaceStrings.put("email", email);
				replaceStrings.put("firstName", firstName);
				replaceStrings.put("lastName", LastName);
				replaceStrings.put("orgName", orgName);
				String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addPersonOrgRelationship.json", replaceStrings, this.getClass()));
		       	
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
		        String personEid = response.substring(response.indexOf("\"IdentificationNumber\":\"")+24, response.indexOf("IdentificationStatusType"));
		        
		        String orgResponse = response.substring(response.indexOf("\"TCRMOrganizationBObj\":"));
		        Assert.assertEquals(true, orgResponse.contains("\"TCRMOrganizationBObj\":"));
		        Assert.assertEquals(true, orgResponse.contains("\"TCRMPartyIdentificationBObj\":["));
		        Assert.assertEquals(true, orgResponse.contains("\"IdentificationValue\":\"EID\","));
		        Assert.assertEquals(true, orgResponse.contains("\"IdentificationNumber\":"));
		        Assert.assertEquals(true, orgResponse.contains("\"IdentificationStatusValue\":\"Active\","));
		        
		        String orgPartyId = orgResponse.substring(orgResponse.indexOf("\"PartyId\":")+10, orgResponse.indexOf("IdentificationType"));
		        String orgIdentId = orgResponse.substring(orgResponse.indexOf("\"IdentificationIdPK\":")+20, orgResponse.indexOf("\"PartyId\":"));
		        String orgEid = orgResponse.substring(orgResponse.indexOf("\"IdentificationNumber\":\"")+24, orgResponse.indexOf("IdentificationStatusType"));
//		        System.out.println("Before Org Eid:" +orgEid);
		        orgEid = orgEid.substring(0, orgEid.indexOf("\","));
//		        System.out.println("After Org Eid:" +orgEid);
		        
		        replaceStrings = new HashMap<String, String>();
				replaceStrings.put("ORG_EID_PLACEHOLDER1", orgEid);
				replaceStrings.put("ORG_ACCOUNT_NUM_PLACEHOLDER1", accountId);
		        response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "orgAddContractWithContractPartyRole.json", replaceStrings, this.getClass()));
		        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		        
		        System.out.println(email+"|"+personEid.substring(0, personEid.indexOf("\","))+"|"+orgEid);
				
			}
        }
        br.close();
	}
	
	
}
