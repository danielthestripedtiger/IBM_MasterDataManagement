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

import madison.mpi.IxnMemUnmerge;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This example shows how IxnMemUnmerge interaction object can be used to
 * unmerge one or more members out of a supercession-set.
 *
 * Run the ExMemMerge example first in order to merge the members we will be
 * attempting to unmerge.
 */
public class ExMemUnmerge extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemUnmerge";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnMemUnmerge memUnmerge = new IxnMemUnmerge(getContext());

    // Create a member rowlist to hold input member row(s)
    MemRowList inpRL = new MemRowList();

    // Set the member type as PERSON.
    // Member types are listed in mpi_memtype table.
    memUnmerge.setMemType("PERSON");

    // Set entity type as Identity (id)
    // Entity types are listed in mpi_enttype table.
    memUnmerge.setEntType("id");

    // MemHead models the Initiate database table
    // mpi_memhead
    MemHead obsolete = new MemHead();
    obsolete.setSrcCode("RMC");
    obsolete.setMemIdnum("300067");
    inpRL.addRow(obsolete);

    waitForQueues(obsolete.getSrcCode(), obsolete.getMemIdnum());

    // Execute the interaction
    boolean status = memUnmerge.execute(inpRL);
    if (status)
      info("The " + intrName + " interaction worked, was successful.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memUnmerge.getErrCode().toString(), memUnmerge.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
