package com.nutrien.custmdm.load;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
import com.nutrien.custmdm.unit.test.CommonUtil;

public class BranchNotExistTest extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	@Test
	public void testLoadRegion() throws Exception {
		InputStream fis = BranchNotExistTest.class.getResourceAsStream(xmlBaseDir + "region.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        InputStream fis1 = BranchNotExistTest.class.getResourceAsStream(xmlBaseDir + "division.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis1));
        InputStream fis2 = BranchNotExistTest.class.getResourceAsStream(xmlBaseDir + "branch.txt");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
		InputStream fis3 = BranchNotExistTest.class.getResourceAsStream(xmlBaseDir + "Employee.txt");
        BufferedReader br3 = new BufferedReader(new InputStreamReader(fis3));
        
        Set<String> numberSet = new HashSet<String>(); 
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
				numberSet.add(number);
        	}
        	
        }
        
        while (true) {
        	String line = br1.readLine();
        	if(line == null)
        		break;
        	
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
        		String regionNumber = st.nextToken();
				String number = st.nextToken();
				String name = st.nextToken();
				String status = st.nextToken();
				numberSet.add(number);
        	}
        }
        
        while (true) {
        	String line = br2.readLine();
        	if(line == null)
        		break;
        	
        	StringTokenizer st = new StringTokenizer(line, "|");
        	while (st.hasMoreElements()) {
        		String divisionNumber = st.nextToken();
				String number = st.nextToken();
				String name = st.nextToken();
				String status = st.nextToken();
				numberSet.add(number);
        	}
        }
				
		
        while (true) {
        	String line = br3.readLine();
        	if(line == null)
        		break;
        	
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
				
				if (!numberSet.contains(number))
					System.out.println(number);
        	}
        }
        br.close();
        br1.close();
        br2.close();
        br3.close();
	}
	
	
}
