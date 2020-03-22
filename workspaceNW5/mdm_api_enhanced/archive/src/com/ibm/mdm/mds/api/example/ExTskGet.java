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

import madison.mpi.GetType;
import madison.mpi.IxnTskGet;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This example illustrates how to use IxnTskGet interaction.
 */
public class ExTskGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnTskGet";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction
    IxnTskGet tskGet = new IxnTskGet(getContext());

    // Create member rowlists to hold input and output row(s)
    MemRowList tskRowList = new MemRowList();
    MemRowList memOutRowList = new MemRowList();

    // Create a MemHead object.
    MemHead memHead = new MemHead();
    // Set the Key Value to perform get on - SrcCode MemIdnum
    memHead.setSrcCode("OUTP");
    memHead.setMemIdnum("500567");
    tskRowList.addRow(memHead);

    // Set a segCodeFilter which will limit the output to just
    // specific segments.
    tskGet.setSegCodeFilter("MEMHEAD,MEMXTSK,ENTXTSK,MEMNAME");
    tskGet.setSegAttrFilter("");

    // Set the record status indicators desired. We are only interested in
    // Active tasks for this example.
    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow
    tskGet.setRecStatFilter("A");

    // Set entity type as Identity (id)
    // Entity types are listed in mpi_enttype table.
    tskGet.setEntType("id");

    // Execute the interaction.
    // this will get all members that have an issue or task with this member
    boolean status = tskGet.execute(getUsrHead(), tskRowList, memOutRowList, GetType.ASMEMBER, KeyType.MEMIDNUM);
    if (status)
      dumpRows(memOutRowList, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", tskGet.getErrCode().toString(), tskGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
