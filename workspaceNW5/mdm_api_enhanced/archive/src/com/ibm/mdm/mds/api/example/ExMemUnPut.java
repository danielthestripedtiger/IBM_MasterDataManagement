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

import madison.mpi.IxnMemPut;
import madison.mpi.IxnMemUnPut;
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.mpi.RowIterator;

/**
 * The example below shows how IxnMemUnPut interaction object can be used to
 * undo inserts and updates to a member record given an audRecno.
 * For a newly inserted record,
 * the MemUnPut interaction will drop the member record.
 * For an updated member, the MemUnPut interaction will revert the member
 * record to the previous state.
 * The audlevel for the interaction to be undone (MEMPUT) should be set to level 2 or higher
 * To undo an update to an attribute, history must be turned "on" for both the member
 * type and the attribute
 * The audRecno passed to the interaction should be associated with a MEMPUT
 * interaction and this should be the last update to the record. If not, the interaction would fail.
 * The interaction would fail if attempts are made to undo an update to an attribute with nsactive
 * (mpi_segattr table) not set equal to 1.
 *
 * Examples scenarios:
 * Scenario 1: MemPut interaction creates a member record that has a LGLNAME attribute associated
 * with it. Executing the MEMUNPUT with the audRecno associated with this MemPut interaction will drop the
 * newly created member record.
 *
 * Scenario 2: MemPut interaction updates the a member record by changing the LGLNAME. Executing the MEMUNPUT
 * with the audRecno associated with this MemPut interaction will set the the original LGLNAME back to 'A' state
 * Say, LGLNAME was John Doe with record status 'A'
 * We update it to Johnny Doe. Post update, if the LGLNAME attribute has nsactive set to 1, the John Doe member
 * attribute is given a record status 'I' and the Johnny Doe member attribute is given a record status 'A'
 * Now, when we execute a MEMUNPUT interaction, the John Doe member attribute goes back to being the active record
 * with status 'A' and the Johnny Doe member attribute is given a record status 'I'
 *
 * Scenario 3: MemPut interaction updates a member record by adding a new attribute. Say add a PCPNAME.
 * Executing the MEMUNPUT with the audRecno associated with this MemPut interaction will set the the PCPNAME
 * attribute to record status 'D' i.e. it is logically deleted.
 */

public class ExMemUnPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  public static void main(String[] args) throws Exception
  {
	  // Create the member put interaction object.
	    IxnMemPut memPut = new IxnMemPut(getContext());

	    // Create member rowlists to hold input
	    // and output row(s).
	    MemRowList inpMemList = new MemRowList();
	    MemRowList outMemList = new MemRowList();

	    // Create a MemHead object.
	    // MemHead models the Initiate database table mpi_memhead.
	    MemHead memHead = new MemHead();
	    memHead.setSrcCode("RMC");
	    memHead.setMemIdnum("112204");

	    MemAttrRow mn1 = getDicStore().createMemAttrRowByCode("LGLNAME");
	    mn1.setMemRecno(memHead.getMemRecno());
	    mn1.setMemSeqno(memHead.generateNextMemSeqno());
	    mn1.setString("onmFirst", "John");
	    mn1.setString("onmLast", "de ode");

	    inpMemList.addRow(memHead);
	    inpMemList.addRow(mn1);

	    // Set entity type as Identity (id).
	    // Entity types are listed in mpi_enttype table.
	    memPut.setEntType("id");

	    // execute the memput interaction
	    boolean status = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.PARTIAL, MatchMode.IMMEDIATE);
	    if (status)
	    {
	      dumpRows(outMemList, "The ixnMemPut interaction worked, here are the returned rows:");
	      waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());
	    }
	    else
	    {
	      // Disconnect from Master Data Engine server
	      disconnect();
	      ixnError("The ixnMemPut interaction failed.", memPut.getErrCode().toString(), memPut.getErrText());
	    }

	    // Now unput this member
	    // Create a member unput interaction object.
	    IxnMemUnPut memUnPut = new IxnMemUnPut(getContext());
	    // Obtain the memHead from the outMemRows List
	    RowIterator rowIt = outMemList.rows();
	    memHead = (MemHead)rowIt.nextRow();

	    // Execute the member unput interaction, pass the audRecno to undo
	    // This would cause the member record to be dropped
	    status = memUnPut.execute( memHead.getCaudRecno());
	    if (status)
	    	info("The ixnMemUnPut interaction worked.  Member has been unput.");
	    else
	    {
	    	// Disconnect from Master Data Engine server
	    	disconnect();
	    	ixnError("The ixnMemUnPut interaction failed.", memUnPut.getErrCode().toString(), memUnPut.getErrText());
	    }

	    // Disconnect from Master Data Engine server
	    disconnect();
  }
}
