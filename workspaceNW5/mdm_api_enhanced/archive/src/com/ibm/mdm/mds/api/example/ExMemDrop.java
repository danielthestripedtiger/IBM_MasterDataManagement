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
import java.io.FileReader;

import madison.mpi.IxnMemDrop;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This examples shows how IxnMemDrop interaction object can be used to delete
 * member permanently from Initiate database (can not be undeleted via
 * IxnMemUndelete).
 *
 * You should run the ExMemCreate example first (it will create the member which
 * this example will drop).
 */
public class ExMemDrop extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemDrop";

  public static void main(String[] args) throws Exception
  {
    // Create a member drop interaction object.
    IxnMemDrop memDrop = new IxnMemDrop(getContext());

	  File inputfile = new File(args[0]);
	  BufferedReader reader = null;

	  try {
	      reader = new BufferedReader(new FileReader(inputfile));
	      String text = null;

	      while ((text = reader.readLine()) != null) {
	    	  String[] lineArray = text.split("\\|");
	    	  
				    	  
			    // Create a member rowlist to hold input member row(s).
			    MemRowList inpMemRows = new MemRowList();
			
			    // MemHead models the Initiate database table mpi_memhead.
			    MemHead memHead = new MemHead();
			
			    // Set the identifiers of the member to be dropped.
			    memHead.setSrcCode(lineArray[Integer.parseInt(args[1])]);
			    memHead.setMemIdnum(lineArray[Integer.parseInt(args[2])]);
			
//			    waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());
			
			    // We could also use MemRecno (gotten via the ExMemCreate example):
			    // memHead.setMemRecno(184);
			    // Note that the MemRecno changes ever time the ExMemCreate example is ran.
			    // In this case we must use KeyType.MEMRECNO during the execute below.
			
			    // Add MemHead into MemRowList.
			    inpMemRows.addRow(memHead);
			
			    // Execute the member drop interaction.
			    // If we used the MemRecno as the key for the member, we need to use
			    // KeyType.MEMRECNO:
			    // boolean status = memDrop.execute(inpMemRows, KeyType.MEMRECNO);
			    boolean status = memDrop.execute(inpMemRows, KeyType.MEMIDNUM);
			    if (status)
			      info("The " + intrName + " interaction worked, Member was dropped.");
			    else
			    {
			    	System.out.println("The " + intrName + " interaction failed." + " - Err Code: " + memDrop.getErrCode().toString() + " - Err Text: " + memDrop.getErrText());
			      // Disconnect from Master Data Engine server
//			      disconnect();
//			      ixnError("The " + intrName + " interaction failed.", memDrop.getErrCode().toString(), memDrop.getErrText());
			    }
	      }

    // Disconnect from Master Data Engine server
    disconnect();
  } catch (Exception e){
	System.out.println("Error: "+e.getLocalizedMessage());  
  }
  }
}
