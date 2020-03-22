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
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRowList;
import madison.mpi.PutType;

/**
 * This class illustrates the use of IxnMemPut. This IXN allows you to insert or
 * update information about a member.
 */
public class ExMemPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemPut";

  public static void main(String[] args) throws Exception
  {

    // Create the member put interaction object.
    IxnMemPut memPut = new IxnMemPut(getContext());

    // Create a member rowlist to hold input and output member row(s).
    MemRowList  inpMemList = new MemRowList();
    MemRowList  outMemList = new MemRowList();

    // MemdHead models the Initiate database table
    // mpi_memhead
    MemHead memHead = new MemHead(0);
    memHead.setSrcCode("SURG");
    memHead.setMemIdnum("144760");
    // RowInd only needs to be set if using a MemMode.EXPLICIT put option.
    // Refer to "Member put interaction--options and behavior" in the SDK
    // Training Guide for detailed behavior of the MemPut interaction
    // and the different types of put modes.
    // memHead.setRowInd(RowInd.INSERT);

    // Using the createAttrRowByName() method with an optional memHead creates
    // and initializes the MemAttrRow child. All you have to do is set the
    // attribute 'dateVal' field.
    MemAttrRow memDate = getDicStore().createMemAttrRowByName("Birth Date", memHead);
    memDate.setString("dateVal", "1964-09-30");

    // Using the createMemAttrRowByCode() method with the optional MemHead does
    // the same thing as the use of the createAttrRowByName(), except the
    // attrCode is used in place of attrName
    MemAttrRow memAttr = getDicStore().createMemAttrRowByCode("SEX", memHead);
    // Set attribute value as M - Male
    memAttr.setString("attrVal", "M");

    // If you create an attribute from scratch, you must set the memRecno,
    // entRecno, and memSeqno yourself. But since we already have a MemHead
    // object, the required getters are readily available to us.
    MemAttrRow scratchAttr = getDicStore().createMemAttrRowByCode("RACE");
    scratchAttr.setMemRecno(memHead.getMemRecno());
    scratchAttr.setMemSeqno(memHead.generateNextMemSeqno());
    scratchAttr.setString("attrVal", "01");

    inpMemList.addRow(memHead);
    inpMemList.addRow(memDate);
    inpMemList.addRow(memAttr);
    inpMemList.addRow(scratchAttr);

    // output the input row contents.
    dumpRows(inpMemList, "Input row list for the IxnMemPut:");

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    memPut.setEntType("id");

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
    boolean status = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.PARTIAL, MatchMode.IMMEDIATE);
    if (status)
    {
      dumpRows(outMemList, "The " + intrName + " interaction worked, here are the returned rows:");
      waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());
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
