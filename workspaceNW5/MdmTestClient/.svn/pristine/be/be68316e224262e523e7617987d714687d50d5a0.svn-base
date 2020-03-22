package com.nutrien.custmdm.unittest.r1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TC_MaintainPartyAccountRelationship_Negative_Test extends AbstractMDMTest {

	static String xmlBaseDir = "req/maintainPartyAccountRelationship/";
	String response;
	
	static HashMap<String, String> replaceStrings = new HashMap<String, String>();
	
	@Test
	public void test01_validation_Person_NonExistentEID_NotFound() throws Exception {

		// Send the same request again to make sure duplicate person is not created
		response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "validation_Person_NonExistentEID_NotFound.json", replaceStrings, this.getClass()));

		Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainPartyAccountRelationship\","));
		Assert.assertEquals(true, response.contains("\"ResultCode\":\"FATAL\","));
		Assert.assertEquals(true, response.contains("Party EID does not correspond to an existing party."));
	}
}
