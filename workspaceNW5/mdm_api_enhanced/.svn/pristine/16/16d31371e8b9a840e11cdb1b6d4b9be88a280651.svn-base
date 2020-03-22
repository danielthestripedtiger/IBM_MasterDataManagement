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

import madison.mpi.AudRowList;
import madison.mpi.GetType;
import madison.mpi.IxnMemGet;
import madison.mpi.IxnMemPut;
import madison.mpi.KeyType;
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRow;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.mpi.Row;
import madison.mpi.RowInd;
import madison.mpi.RowIterator;

/**
 * This class illustrates the use of IxnMemPut. This IXN allows you to insert or
 * update information about a member.
 */
public class ExMemPutInactivate extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemPut";

  public static void main(String[] args) throws Exception
  {

	    IxnMemGet memGet = new IxnMemGet(getContext());

	    // Create member rowlists to hold input
	    // and output row(s).
	    MemRowList inpMemRows = new MemRowList();
	    MemRowList outMemRows = new MemRowList();

	    // Create a MemHead object.
	    // MemHead models the Initiate database table mpi_memhead.
	    MemHead memHead1 = new MemHead();
	    memHead1.setSrcCode("FACETS_HC");
	    memHead1.setMemIdnum("TEST-AA");

	    inpMemRows.addRow(memHead1);

	    // Set a segment code filter to limit
	    // output to specific segments.
	    //memGet.setSegCodeFilter("MEMHEAD,MEMATTR,MEMNAME,MEMADDR,MEMPHONE,MEMIDENT,MEMDATE");
	    memGet.setSegCodeFilter("MEMHEAD,MEMADDREXT");

	    // Set the record status indicators desired.
	    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow.
	    //memGet.setRecStatFilter("A");
	    memGet.setRecStatFilter(Row.m_RECSTAT_A);

	    // Set the member type as PERSON.
	    // Member types are listed in mpi_memtype table.
	    memGet.setMemType("Member");


	    memGet.execute(inpMemRows, outMemRows, GetType.ASMEMBER, KeyType.MEMIDNUM);


	    RowIterator iter = outMemRows.rows();
	    // We could also specify the sorting algorithm:
	    // iter = rl.rows(classTestMemName, compKey, RowList.SORT_SELECTION);
	    // See API documentation for the detailed explanation of
	    // three different sort algorithms.
	    
	    MemAttrRow mar = null;
	    MemHead memheadFromGet = null;
	    while(iter.hasMoreRows())
	    {
	      MemRow mRow = (MemRow) iter.nextRow();
	      
	      if(mRow instanceof MemHead){
	    	  memheadFromGet=(MemHead)mRow;
	      }
	      
	      
	      if(mRow instanceof MemAttrRow){
	    	  MemAttrRow marTmp = (MemAttrRow) mRow;
	    	  
	    	  if(marTmp.getAttrCode().equalsIgnoreCase("MEMADDR")){
	    		  

	    		  if(marTmp.getAsString("stLine1").equalsIgnoreCase("456 Main")
	    				  && marTmp.getAsString("city").equalsIgnoreCase("Austin")
	    				  && marTmp.getAsString("state").equalsIgnoreCase("TX")
	    				  ){
	    			  
	    			  marTmp.setRecStat("I");
	    			  marTmp.setRowInd(RowInd.UPDATE);
	    			  mar=marTmp;
	    		  }
	    	  }

	      }
	    }
	    
	    
    // Create the member put interaction object.
    IxnMemPut memPut = new IxnMemPut(getContext());

    // Create a member rowlist to hold input and output member row(s).
    MemRowList  inpMemList = new MemRowList();
    MemRowList  outMemList = new MemRowList();


    inpMemList.addRow(memheadFromGet);
    inpMemList.addRow(mar);

    // output the input row contents.
    dumpRows(inpMemList, "Input row list for the IxnMemPut:");

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    memPut.setEntType("member");

    // Set entity management priority.
    // Default is 0.
    memPut.setEntPrior((short)50);

    //setEvtInfo is optional and NOT necessary to execute the interaction
    //setEvtInfo is used to manipulate mpi_audhead entries with set values
    //Uncomment this if you wish to see the effect, mpi_evttype must be loaded to work
    //Calendar cal = new GregorianCalendar();
    //cal.set(2002,06,20,9,9,9);
    //memPut.setEvtInfo("ADD",cal.getTime(),"User","UserLocation");

    // PutType.INSERT_UPDATE - create it or update it
    // MemMode.PARTIAL - contains partial member information
    // setRowInd() needs to be set only if using the MemMode.EXPLICIT option.
    // MatchMode.IMMEDIATE - Effective only when the Identity Hub
    // is running in asynchronous mode. Once the IxnMemPut
    // interaction has updated the Identity Hub, perform a match.
    // There are other options for execution (for example the outMemList is not
    // required). Consult the API documentation for details.
    // Execute the interaction.
    boolean status2 = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.EXPLICIT, MatchMode.IMMEDIATE);
    if (status2)
    {
      dumpRows(outMemList, "The " + intrName + " interaction worked, here are the returned rows:");
      waitForQueues(memheadFromGet.getSrcCode(), memheadFromGet.getMemIdnum());
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memPut.getErrCode().toString(), memPut.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
