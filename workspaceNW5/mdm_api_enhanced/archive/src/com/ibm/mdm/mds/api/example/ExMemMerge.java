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

import madison.mpi.IxnMemMerge;
import madison.mpi.MemHead;

/**
 * This example shows how IxnMemMerge interaction object can be used to
 * logically merge members together into a supercession-set.
 *
 * The example ExMemUnmerge will undo the merge this example performs.
 */
public class ExMemMerge extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemMerge";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnMemMerge memMerge = new IxnMemMerge(getContext());

    // Set the member type as PERSON.
    // Member types are listed in mpi_memtype table.
    memMerge.setMemType("PERSON");

    // Set entity type as Identity (id)
    // Entity types are listed in mpi_enttype table.
    memMerge.setEntType("id");

    // MemHead models the Initiate database table
    // mpi_memhead
    MemHead survivor;
    MemHead obsolete;

    // First Name - Michael Last Name - Howard
    survivor = new MemHead();
    survivor.setSrcCode("RMC");
    survivor.setMemIdnum("112917");

    // First Name - Mike Last Name - Howard
    obsolete = new MemHead();
    obsolete.setSrcCode("RMC");
    obsolete.setMemIdnum("300067");

    waitForQueues(survivor.getSrcCode(), survivor.getMemIdnum());
    waitForQueues(obsolete.getSrcCode(), obsolete.getMemIdnum());

    // Execute the interaction.
    boolean status = memMerge.execute(survivor, obsolete);
    if (status)
      info("The " + intrName + " interaction was successful.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memMerge.getErrCode().toString(), memMerge.getErrText());
    }
    waitForQueues(survivor.getSrcCode(), survivor.getMemIdnum());
    waitForQueues(obsolete.getSrcCode(), obsolete.getMemIdnum());
    // Disconnect from Master Data Engine server
    disconnect();
  }
}
