/* _______________________________________________________ {COPYRIGHT-TOP} _____
* IBM Confidential
* OCO Source Materials
*
* 5725-E59
*
* (C) Copyright IBM Corp. 2013  All Rights Reserved.
*
* The source code for this program is not published or otherwise
* divested of its trade secrets, irrespective of what has been
* deposited with the U.S. Copyright Office.
* ________________________________________________________ {COPYRIGHT-END} _____*/
package com.ibm.mdm.mds.api.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import madison.mpi.IxnMemPut;
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRowList;
import madison.mpi.PutType;

/**
 * This class illustrates the use of IxnMemPut. This IXN allows you to insert or
 * update information about a member.
 */
public class ExMemPutProcessRows extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemPut";

  public static void main(String[] args) throws Exception
  {
	  HashMap<Integer, String> mappings = new HashMap<Integer, String>();
	  File formatfile = new File(args[0]);
	  BufferedReader reader = null;

	  try {
	      reader = new BufferedReader(new FileReader(formatfile));
	      String text = null;

	      while ((text = reader.readLine()) != null) {
	    	  String[] lineArray = text.split("~");
	    	  for (int x=0; x<lineArray.length; x++) {
	    		  mappings.put(x,lineArray[x]);
	    	  }
	      }
	  } catch (FileNotFoundException e) {
	      e.printStackTrace();
	  } catch (IOException e) {
	      e.printStackTrace();
	  } finally {
	      try {
	          if (reader != null) {
	              reader.close();
	          }
	      } catch (IOException e) {
	      }
	  }
	  reader.close();
	  
	  File inputfile = new File(args[1]);
	  reader = null;
	  String currline=null;
	  try {
	      reader = new BufferedReader(new FileReader(inputfile));
	      String text = null;

	      while ((text = reader.readLine()) != null) {
	    	  HashMap<String, MemAttrRow> MDMObjects = new HashMap<String, MemAttrRow>();
	    	  HashMap<String, MemHead> memHeadReference = new HashMap<String, MemHead>();
	    	  currline=text;
	    	  String[] lineArray = text.split("~",-1);
	    	  
	    	  for (int x=0; x<lineArray.length; x++) {
	    		  if(mappings.get(x).split(":")[0].equalsIgnoreCase("MEMHEAD")){
	    			  if(!memHeadReference.containsKey("MEMHEAD")){
	    				  memHeadReference.put("MEMHEAD", new MemHead(0));
	    			  }
	    			  MemHead mh = memHeadReference.get("MEMHEAD");
	    			  if(mappings.get(x).split(":")[1].equalsIgnoreCase("srccode")){
	    				  mh.setSrcCode(lineArray[x]);
	    			  }
	    			  if(mappings.get(x).split(":")[1].equalsIgnoreCase("memidnum")){
	    				  mh.setMemIdnum(lineArray[x]);
	    			  }
	    			 
	    		  }
	    		  else{
	    			  if(lineArray[x].length()>0){
	    			  if(MDMObjects.get(mappings.get(x).split(":")[0]) == null){
	    				  MDMObjects.put(mappings.get(x).split(":")[0], 
	    						  getDicStore().createMemAttrRowByCode(mappings.get(x).split(":")[0],memHeadReference.get("MEMHEAD")));
	    			  } 
		    		  
	    			  MemAttrRow mar = MDMObjects.get(mappings.get(x).split(":")[0]);
	    			  
	    			  
	    			  mar.setAsString(mappings.get(x).split(":")[1], lineArray[x]);  
		    	  }
	    		  }
	    	  } 
	    	  
		      // Create the member put interaction object.
		      IxnMemPut memPut = new IxnMemPut(getContext());

		      // Create a member rowlist to hold input and output member row(s).
		      MemRowList  inpMemList = new MemRowList();
		      MemRowList  outMemList = new MemRowList();

		      for (String attrcode : MDMObjects.keySet()) {
		      	inpMemList.addRow(MDMObjects.get(attrcode));
		  	}
		      
		      inpMemList.addRow(memHeadReference.get("MEMHEAD"));

		      memPut.setEntType("mdmper");

		      boolean status = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.PARTIAL, MatchMode.IMMEDIATE);
		      if (!status)
		      {
		        // Disconnect from Master Data Engine server
		        disconnect();
		        ixnError("The " + intrName + " interaction failed.", memPut.getErrCode().toString(), memPut.getErrText());
		      }
	      }
	      


	  } catch (FileNotFoundException e) {
	      e.printStackTrace();
	  } catch (Exception e) {
		  System.out.println("ERROR LINE: " + currline);
	      e.printStackTrace();
	  } finally {
	      try {
	          if (reader != null) {
	              reader.close();
	          }
	      } catch (IOException e) {
	      }
	  }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
