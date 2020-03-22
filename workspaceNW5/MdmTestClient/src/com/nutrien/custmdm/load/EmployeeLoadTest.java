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

public class EmployeeLoadTest extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	@Test
	public void testLoadRegion() throws Exception {
		InputStream fis = EmployeeLoadTest.class.getResourceAsStream(xmlBaseDir + "Employee.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
        int count = 0;
        while (true) {
        	String line = br.readLine();
        	if(line == null)
        		break;
        	
        	System.out.println(count++);
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
        		String employeeId = st.nextToken();
				String lastName = st.nextToken();
				String firstName = st.nextToken();
				String middleName = st.nextToken();
				st.nextToken();
				String email = st.nextToken();
				String status = st.nextToken();
				st.nextToken();
				st.nextToken();
				String salesRepId = st.nextToken();
				String jobType = st.nextToken();
				String number = st.nextToken();
				
				HashMap<String, String> replaceStrings = new HashMap<String, String>();
				
				replaceStrings.put("employeeId", employeeId);
				replaceStrings.put("lastName", lastName);
				replaceStrings.put("firstName", firstName);
				
				if ("NULL".equals(middleName.trim()))
					replaceStrings.put("middleName", "");
				else
					replaceStrings.put("middleName", middleName);
				
				if ("A".equals(status.trim()))
					replaceStrings.put("status", "Active");
				else
					replaceStrings.put("status", "Inactive");
				
				if ("".equals(email.trim()) || "NULL".equals(email.trim()))
					replaceStrings.put("email", "");
				else {
					replaceStrings.put("email", "\"TCRMPartyContactMethodBObj\": {" +
							"\"ContactMethodUsageValue\": \"Work Email\"," +
							"\"TCRMContactMethodBObj\": {" +
							"\"ReferenceNumber\": \""+email+"\"," +
							"\"ContactMethodValue\": \"Email Address\"}},");
				}
				
				if ("0".equals(salesRepId.trim()) || "NULL".equals(salesRepId.trim()))
					replaceStrings.put("salesRepId", "");
				else {
					replaceStrings.put("salesRepId", "{\"IdentificationValue\": \"Sales Rep ID\"," +
							"\"IdentificationNumber\": \""+salesRepId+"\"},");
				}
				
				replaceStrings.put("relationshipValue", jobType);
				replaceStrings.put("relationshipToValue", number);
				
				System.out.println(employeeId);
				String response = sendRequestViaRest(CommonUtil.getTstMsgFromFile(xmlBaseDir, "maintainParty_addEmployee.json", replaceStrings, this.getClass()));
		       	
		        Assert.assertEquals(true, response.contains("\"RequestType\":\"MaintainParty\","));
		        Assert.assertEquals(true, response.contains("\"ResultCode\":\"SUCCESS\","));
		        Assert.assertEquals(true, response.contains("\"ResponseObject\":{\"MDMCompositePartyBObj\":"));
        	}
        }
        br.close();
	}
	
	
}
