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

import madison.mpi.IxnMemCompare;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This exapmles illustrates the use of the IxnMemCompare interaction. Compares
 * two member objects given their header information.
 */
public class ExMemCompare extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemCompare";

  public static void main(String[] args) throws Exception
  {
    // Create a member compare interaction object.
    IxnMemCompare memComp = new IxnMemCompare(getContext());

    // Create member rowlists to hold input
    // and output row(s).
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();

    // Set the member type as PERSON.
    // Member types are listed in mpi_memtype table.
    memComp.setMemType("PERSON");

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    memComp.setEntType("id");

    // Create two member head objects to compare. The following two members are very much identical. So we get a high score.

    // This member's attributes are:
    // Source No: 214 EID: 1000000005, FirstName: Vidalia LastName: Garay-Deras,
    // MiddleName: G.
    MemHead memHead = new MemHead();
    memHead.setSrcCode("FGH");
    memHead.setMemIdnum("988608");
    inpMemRows.addRow(memHead);

    // This member's attributes are:
    // Source No: 217 EID: 1000000005, FirstName: Vidalia LastName: Garay-Deras,
    // MiddleName: D.
    MemHead memHead2 = new MemHead();
    memHead2.setSrcCode("PHYS");
    memHead2.setMemIdnum("145212");
    inpMemRows.addRow(memHead2);

    // This would execute the comparison on the input members and the output is
    // stored in outMemRows in the same order as presented.
    boolean status = memComp.execute(inpMemRows, outMemRows, KeyType.MEMIDNUM);
    if (status)
    {
      dumpRows(outMemRows, "The " + intrName + " interaction worked, here are the returned rows:");
      // The matchScore field contains the score.  Here is one way to display the score:
      MemHead resultRow = (MemHead) outMemRows.rowAt(0);
      info("The first member scored " + resultRow.getAsString("matchScore") + " against the second member.");
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memComp.getErrCode().toString(), memComp.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
