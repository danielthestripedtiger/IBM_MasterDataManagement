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

import madison.mpi.IxnMemCreate;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;
import madison.mpi.RowInd;

/**
 * This example shows how to put a members memHead row into the Identity Hub
 * without doing a crossmatch. MemCreate only puts a MemHead in the DB, any
 * other attributes included in the MemRowList will be ignored. The IxnMemCreate
 * interaction takes only a single member at a time.
 *
 * The member created with this example can be dropped by running the ExMemDrop
 * example. If the member is not dropped, consecutive executions of this example
 * will result in an error (since the member we are trying to create will
 * already exist after the first execution).
 */
public class ExMemCreate extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemCreate";

  public static void main(String[] args) throws Exception
  {
    // memCreate puts a single MemHead into the DB without doing a crossmatch.
    // Allows for a member to be setup in DB, and the attributes to be added
    // later.
    IxnMemCreate memCreate = new IxnMemCreate(getContext());

    // Create member rowlists to hold input
    // and output row(s)
    MemRowList inpMemList = new MemRowList(2, 10);
    MemRowList outMemList = new MemRowList(2, 10);

    // Create a member head object.
    MemHead memHead = new MemHead(0);
    memHead.setSrcCode("RMC");
    memHead.setMemIdnum("111222333444555");
    memHead.setRowInd(RowInd.INSERT);

    inpMemList.addRow(memHead);

    // Execute the interaction.
    boolean status = memCreate.execute(inpMemList, outMemList);
    if (status)
    {
      dumpRows(outMemList, "The " + intrName + " interaction worked, here are the returned rows:");
      // We get back the newly created MemRecno in the returned MemHead. Here is
      // one way to view it:
      MemHead memHeadReturned = (MemHead) outMemList.rowAt(0);
      info("The newly created MemRecno is: " + memHeadReturned.getMemRecno());
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memCreate.getErrCode().toString(), memCreate.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
