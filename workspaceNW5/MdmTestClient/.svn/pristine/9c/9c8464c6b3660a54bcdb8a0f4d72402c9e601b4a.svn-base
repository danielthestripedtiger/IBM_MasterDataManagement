package com.nutrien.custmdm.unit.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CommonUtil {
	
	public static String getStringFromFile(String path, String fileName, Class classObject) throws IOException {
		// Read file file
		InputStream fis = classObject.getResourceAsStream(path + fileName); 
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        StringBuilder sb = new StringBuilder("");
        while (true) {
        	String line = br.readLine();
        	if(line == null)
        		break;
        	
        	sb.append(line);
        }
        br.close();
        
        return sb.toString();
	}
	
	public static String getTstMsgFromFile(String path, String fileName, HashMap<String, String> replaceStrings, Class classObject) throws IOException {
		// Read file file
		InputStream fis = classObject.getResourceAsStream(path + fileName); 
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        StringBuilder sb = new StringBuilder("");
        while (true) {
        	String line = br.readLine();
        	if(line == null)
        		break;
        	
        	for (String placeholderStr : replaceStrings.keySet()) {
        		line = line.replace(placeholderStr, replaceStrings.get(placeholderStr));
			}
        	                    	        	
        	sb.append(line);
        }
        br.close();
        
        return sb.toString();
	}

}
