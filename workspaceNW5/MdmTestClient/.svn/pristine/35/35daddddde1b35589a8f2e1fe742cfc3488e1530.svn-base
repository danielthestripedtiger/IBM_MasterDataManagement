package com.nutrien.custmdm.load;

import java.sql.*;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.Test;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;

public class ContractStatusLoad extends AbstractMDMTest {
	
	static String xmlBaseDir = "req/";
	
	static String outputDir = "C:/Temp/";
	
	static String dbConnStr = "jdbc:db2://ABCGYDCDAPP126:50000/CUSTMDM";  // DEV
	//static String dbConnStr = "jdbc:db2://ABCGYDCTAPP38:50000/CUSTMDM";  // SIT
	//static String dbConnStr = "jdbc:db2://codendcpapp217:50000/CUSTMDM";  // PROD
	
	static String statusActiveCd = "100001";
	
	static String statusInactiveCd = "100002";
	
	static String NEWLINE = System.getProperty("line.separator");
	
	static int writeCounter = 5;
	
	Connection con;
	
	@Test
	public void loadContractStatus() throws Exception {
		try {
			// load the driver class  
			Class.forName("com.ibm.db2.jcc.DB2Driver");  
			  
			// create  the connection object  
			con = DriverManager.getConnection(dbConnStr,"klam","Khai@i#@546");  
		} catch(Exception e) {
			System.out.println(e);
		}  
		
		// Create FileWriter and BufferedWriter for update files
		FileWriter fwActive = null;
		FileWriter fwInactive = null;

		BufferedWriter bwActive = null;
		BufferedWriter bwInactive = null;

		try {
			fwActive = new FileWriter(outputDir + "AccountActiveUpdate.txt");
			fwInactive = new FileWriter(outputDir + "AccountInactiveUpdate.txt");
		} catch (IOException e) {
			System.err.println("Error encountered while trying to obtain FileWriter instance.");
			e.printStackTrace();
			return;
		}
		bwActive = new BufferedWriter(fwActive);
		bwInactive = new BufferedWriter(fwInactive);
		
		bwActive.write("admin_contract_id,contract_id,contr_component_id" + NEWLINE);
		bwInactive.write("admin_contract_id,contract_id,contr_component_id" + NEWLINE);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// First, check for accounts to be updated to "Inactive"
		////////////////////////////////////////////////////////////////////////////////////////////////////

		InputStream fis = ContractStatusLoad.class.getResourceAsStream(xmlBaseDir + "Account_Inactive.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
		// create the statement object  
		Statement stmt = con.createStatement();  
		
		String accountNumber = "";
		String statement = "";
		ResultSet rs = null;
		
        int counter = 0;
		
        while (true) {
        	accountNumber = br.readLine();
        	if (accountNumber == null) {
        		break;
        	}
        	
        	accountNumber = accountNumber.trim();
        	
    		if (counter % writeCounter == 0) {
    			System.out.println("Processed counter: " + counter + ", Account Number = " + accountNumber);
    		}
    		counter++;
        	
        	statement = "select distinct n.admin_contract_id, n.contract_id, c.contr_component_id " +
        						"from db2inst1.nativekey n, db2inst1.contractcomponent c " +
        			        	"where c.contract_st_tp_cd = " + statusActiveCd + " and c.contract_id = n.contract_id " +
        						"and n.admin_contract_id = '" + accountNumber + "'";
        	
        	//System.out.println(statement);

        	// execute query  
			rs = stmt.executeQuery(statement); 
			
			while(rs.next()) {
				bwInactive.write(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + NEWLINE);
			}
        }
        br.close();
        
        
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// Now, check for accounts to be updated to "Active"
		////////////////////////////////////////////////////////////////////////////////////////////////////

		fis = ContractStatusLoad.class.getResourceAsStream(xmlBaseDir + "Account_Active.txt");
        br = new BufferedReader(new InputStreamReader(fis));
		
        counter = 0;
        
        while (true) {

        	accountNumber = br.readLine();
        	if (accountNumber == null) {
        		break;
        	}
        	
        	accountNumber = accountNumber.trim();
        	
    		if (counter % writeCounter == 0) {
    			System.out.println("Processed counter: " + counter + ", Account Number = " + accountNumber);
    		}
    		counter++;
        	
        	statement = "select distinct n.admin_contract_id, n.contract_id, c.contr_component_id " +
        						"from db2inst1.nativekey n, db2inst1.contractcomponent c " +
        			        	"where c.contract_st_tp_cd = " + statusInactiveCd + " and c.contract_id = n.contract_id " +
        						"and n.admin_contract_id = '" + accountNumber + "'";
        	
        	//System.out.println(statement);

        	// execute query  
			rs = stmt.executeQuery(statement); 
			
			while(rs.next()) {
				bwActive.write(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + NEWLINE);
			}
        }
        br.close();

		// close the connection object  
		con.close();  
		
        // Close file writers
		try {
			if (bwActive != null) bwActive.close();
			if (fwActive != null) fwActive.close();
			if (bwInactive != null) bwInactive.close();
			if (fwInactive != null) fwInactive.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Done");
	}
}
