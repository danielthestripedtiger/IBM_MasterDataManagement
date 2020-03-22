package com.nutrien.custmdm.unittest.r1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.nutrien.custmdm.unit.test.AbstractMDMTest;
 
public class ReprocessRejects extends AbstractMDMTest 
{
	
    public static void main(String[] args) throws IOException
    {
    	loadClientOpts();
    	
        File f = new File(args[0]);
        Scanner numScan = new Scanner(f);
         
        String line;
         
        while (numScan.hasNext())
        {
        	
            line = numScan.nextLine();
            String response = sendRequestViaRest(line);
            
            if(response.contains("<ResultCode>SUCCESS</ResultCode>")){
                System.out.print("SUCCESS");
                System.out.print("`");
                System.out.print("N/A");
            }
            else if(response.contains("<ResultCode>FATAL</ResultCode>")){
                System.out.print("FATAL");
                System.out.print("`");
                System.out.print(StringUtils.substringBetween(response, "<Throwable>", "</Throwable>"));
            } else{
            	System.out.print("UNKNOWN");
                System.out.print("`");
                System.out.print("N/A");
            }
            System.out.print("`");
            System.out.print(line);
            System.out.print("`");
            System.out.println(response);
        }
         
        numScan.close();
    }
}
