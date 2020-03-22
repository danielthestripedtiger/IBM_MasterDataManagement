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

import madison.mpi.IxnMemUndelete;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This examples shows how IxnMemUndelete interaction object can be used to
 * undelete member. This interaction returns a logically deleted member to
 * active status. Derived data is recreated so that the member can be the result
 * of a search, match, and take further updates. The memHead recStat value is
 * returned to an ACTIVE status. Attributes have the same recStat value as when
 * the member was deleted.
 *
 * In order to test exMemUndelete successfully, first execute ExMemDelete
 * example (this will delete the member which this example will undelete).
 */
public class ExMemUndelete extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemUndelete";

  public static void main(String[] args) throws Exception
  {
    // This interaction returns a logically deleted member to
    // active status
    // Create a member undelete interaction object.
    IxnMemUndelete memUndelete = new IxnMemUndelete(getContext());

    // Create a member rowlist to hold input member row(s).
    MemRowList inpMemRows = new MemRowList();

    // MemHead models the Initiate database table mpi_memhead.
    MemHead memHead = new MemHead();

    // Set the identifiers of the member to be undeleted.
    memHead.setSrcCode("OUTP");
    memHead.setMemIdnum("567677");
    // We could use MemRecno in place of SrcCode/MemIdnum:
    // memHead.setMemRecno(162L);
    inpMemRows.addRow(memHead);

    waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());

    // Execute the member undelete interaction.
    // If MemRecno was used as member identifier we must use KeyType.MEMRECNO:
    // boolean status = memUndelete.execute(inpMemRows, KeyType.MEMRECNO);
    boolean status = memUndelete.execute(inpMemRows, KeyType.MEMIDNUM);
    if (status)
      info("The " + intrName + " interaction worked.  Member has been undeleted.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memUndelete.getErrCode().toString(), memUndelete.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
