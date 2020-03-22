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

import madison.mpi.IxnMemScore;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This examples illustrates the use of the IxnMemScore interaction. Scores two
 * or more member objects that do not exist within the Identity Hub database.
 */
public class ExMemScore extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemPutBulk";

  public static void main(String[] args) throws Exception
  {
    // Create a member score interaction object.
    IxnMemScore memScore = new IxnMemScore(getContext());

    // Create member rowlists to hold input
    // and output row(s).
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    memScore.setEntType("id");

    // Create two member head objects to score. The following
    // two members are very much identical. So we get a high
    // score.
    MemHead memHead1 = new MemHead();

    // Using the createAttrRowByName() method with an
    // optional memHead1 creates and initializes the MemAttrRow child.
    // All you have to do is set the attribute 'value' fields.
    MemAttrRow md = getDicStore().createMemAttrRowByName("Birth Date", memHead1);
    md.setString("dateVal", "1964-09-10");

    MemAttrRow ma = getDicStore().createMemAttrRowByName("Sex", memHead1);
    ma.setString("attrVal", "M");

    MemAttrRow mn = getDicStore().createMemAttrRowByCode("LGLNAME", memHead1);
    mn.setString("onmFirst", "Mike");
    mn.setString("onmLast", "de Test");

    inpMemRows.addRow(memHead1);
    inpMemRows.addRow(md);
    inpMemRows.addRow(ma);
    inpMemRows.addRow(mn);

    // Create the second Member to score against the first.
    MemHead memHead2 = new MemHead();

    MemAttrRow md2 = getDicStore().createMemAttrRowByName("Birth Date", memHead2);
    md2.setString("dateVal", "1964-09-20");

    MemAttrRow ma2 = getDicStore().createMemAttrRowByName("Sex", memHead2);
    ma2.setString("attrVal", "M");

    MemAttrRow mn2 = getDicStore().createMemAttrRowByCode("LGLNAME", memHead1);
    mn2.setString("onmFirst", "Michael");
    mn2.setString("onmLast", "de Test");

    inpMemRows.addRow(memHead2);
    inpMemRows.addRow(md2);
    inpMemRows.addRow(ma2);
    inpMemRows.addRow(mn2);

    boolean status = memScore.execute(inpMemRows, outMemRows);
    if (status)
    {
      // The output member row list will contain the MemHead objects in the same
      // order they were passed in, with the match score set. The match score on
      // the first MemHead object will be the first member scored against
      // itself.
      dumpRows(outMemRows, "The " + intrName + " interaction worked, here are the returned rows:");
      MemHead mhOut = (MemHead) outMemRows.rowAt(1);
      info("The second member scored " + mhOut.getAsString("matchScore") + " against the first member.");
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memScore.getErrCode().toString(), memScore.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
