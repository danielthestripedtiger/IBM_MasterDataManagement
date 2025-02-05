package com.nutrien.custmdm.load;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

public class AlertLoadTest extends AbstractMDMTest {
	
	static String xmlBaseDir1 = "req/";
	
	@Test
	public void testLoadMyCpsData() throws Exception {
		String xmlBaseDir = "C:\\Agrium\\xml\\alert\\";
		
        // Read batch file
        FileInputStream fis = new FileInputStream(xmlBaseDir + "mdm.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        FileInputStream fis1 = new FileInputStream(xmlBaseDir + "ods.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis1));
		
        HashMap<String, String> contractIdPkMap = new HashMap<String, String>();
        while (true) {
        	String line = br.readLine();
        	if(line == null)
        		break;
        	
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
				String custId = st.nextToken();
				String contractIdPk = st.nextToken();
				
				contractIdPkMap.put(custId, contractIdPk);
        	}
        }
        
        while (true) {
        	String line = br1.readLine();
        	if(line == null)
        		break;
        	
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
				String custId = st.nextToken();
				String creditHold = st.nextToken();
				
				if (contractIdPkMap.get(custId) == null)
					continue;
				
				HashMap<String, String> replaceStrings = new HashMap<String, String>();
				replaceStrings.put("contractIdPk", contractIdPkMap.get(custId));
				replaceStrings.put("creditHold", creditHold);
				System.out.println(custId);
				String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir1, "addAlert.json", replaceStrings, this.getClass()));
		       	
		        Assert.assertEquals(true, response.contains("\"RequestType\":\"addContractAlert\","));
		        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"TCRMAlertBObj\":"));
        	}
        }
        br.close();
	}
	
	
}
