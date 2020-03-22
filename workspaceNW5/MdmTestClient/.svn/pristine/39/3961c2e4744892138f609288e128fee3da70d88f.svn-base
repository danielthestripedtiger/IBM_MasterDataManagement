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

public class RegionLoadTest extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	@Test
	public void testLoadRegion() throws Exception {
		InputStream fis = RegionLoadTest.class.getResourceAsStream(xmlBaseDir + "region.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
        while (true) {
        	String line = br.readLine();
        	if(line == null)
        		break;
        	
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
				String number = st.nextToken();
				String name = st.nextToken();
				String status = st.nextToken();
				st.nextToken();
				
				HashMap<String, String> replaceStrings = new HashMap<String, String>();
				replaceStrings.put("status", status);
				replaceStrings.put("name", name);
				replaceStrings.put("number", number);
				System.out.println(number);
				String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addRegion.json", replaceStrings, this.getClass()));
		       	
		        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
		        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        	}
        }
        br.close();
	}
	
	
}
