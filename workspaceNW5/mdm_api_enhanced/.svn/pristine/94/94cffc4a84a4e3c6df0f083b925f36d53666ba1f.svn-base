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

import madison.mpi.IxnMemPutBulk;
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRowList;
import madison.mpi.PutType;

/**
 * This class illustrates the use of the IxnMemBulkPut interaction. This
 * interaction allows you to insert/update information about multiple members
 * at a time.
 */
public class ExMemPutBulk extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemPutBulk";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object
    IxnMemPutBulk memPutBulk = new IxnMemPutBulk(getContext());

    // Entity type is configured in the Master Data Engine
    memPutBulk.setEntType("id");

    // Set entity management priority.
    // Default is 0.
    memPutBulk.setEntPrior((short)50);

    // Create member rowlists to hold input and output row(s)
    MemRowList inpMemList = new MemRowList();
    MemRowList outMemList = new MemRowList();

    // Create the first Member to put. A reserved memRecno will be created.
    MemHead memHead1 = new MemHead(0);
    memHead1.setSrcCode("RMC");
    memHead1.setMemIdnum("112201");

    // Using the createAttrRowByName() method with an
    // optional memHead1 creates and initializes the MemAttrRow child.
    // The memRecno/entRecno/memSeqno initialization is handled for you.
    // All you have to do is set the attribute 'value' fields.
    MemAttrRow md1 = getDicStore().createMemAttrRowByName("Birth Date", memHead1);
    md1.setString("dateVal", "1964-09-10");

    MemAttrRow ma1 = getDicStore().createMemAttrRowByCode("SEX", memHead1);
    ma1.setString("attrVal", "M");

    // If you create an MemAttrRow without the use of MemHead, you must assign
    // the memRecno/entRecno/memSeqno yourself.
    MemAttrRow mn1 = getDicStore().createMemAttrRowByCode("LGLNAME");
    mn1.setMemRecno(memHead1.getMemRecno());
    mn1.setMemSeqno(memHead1.generateNextMemSeqno());
    mn1.setString("onmFirst", "Mike1");
    mn1.setString("onmLast", "de Test1");

    inpMemList.addRow(memHead1);
    inpMemList.addRow(md1);
    inpMemList.addRow(ma1);
    inpMemList.addRow(mn1);

    //Create the second Member to put.
    MemHead memHead2 = new MemHead(0);
    memHead2.setSrcCode("RMC");
    memHead2.setMemIdnum("112202");

    MemAttrRow md2 = getDicStore().createMemAttrRowByName("Birth Date", memHead2);
    md2.setString("dateVal", "1964-09-20");

    MemAttrRow ma2 = getDicStore().createMemAttrRowByCode("SEX", memHead2);
    ma2.setString("attrVal", "M");

    MemAttrRow mn2 = getDicStore().createMemAttrRowByCode("LGLNAME", memHead2);
    mn2.setString("onmFirst", "Mike2");
    mn2.setString("onmLast", "de Test2");

    inpMemList.addRow(memHead2);
    inpMemList.addRow(md2);
    inpMemList.addRow(ma2);
    inpMemList.addRow(mn2);

    // Create the third Member to put.
    MemHead memHead3 = new MemHead(0);
    memHead3.setSrcCode("RMC");
    memHead3.setMemIdnum("112203");

    MemAttrRow md3 = getDicStore().createMemAttrRowByName("Birth Date", memHead3);
    md3.setString("dateVal", "1964-09-30");

    MemAttrRow ma3 = getDicStore().createMemAttrRowByCode("SEX", memHead3);
    ma3.setString("attrVal", "M");

    MemAttrRow mn3 = getDicStore().createMemAttrRowByCode("LGLNAME", memHead3);
    mn3.setString("onmFirst", "Mike3");
    mn3.setString("onmLast", "de Test3");

    inpMemList.addRow(memHead3);
    inpMemList.addRow(md3);
    inpMemList.addRow(ma3);
    inpMemList.addRow(mn3);

    // output the rows we are about to put.
    dumpRows(inpMemList, "These are the rows we are about to use in the " + intrName + ":");

    // IMMEDIATE is used because I want to match against
    // other members as soon as the data is saved.
    boolean status = memPutBulk.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.COMPLETE, MatchMode.IMMEDIATE);
    if (status)
      dumpRows(outMemList, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memPutBulk.getErrCode().toString(), memPutBulk.getErrText());
    }
    waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());
    waitForQueues(memHead2.getSrcCode(), memHead2.getMemIdnum());
    waitForQueues(memHead3.getSrcCode(), memHead3.getMemIdnum());
    // Disconnect from Master Data Engine server
    disconnect();
  }
}
