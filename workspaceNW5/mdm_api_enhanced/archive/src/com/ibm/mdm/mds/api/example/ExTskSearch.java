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

import madison.mpi.IxnTskSearch;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;
import madison.mpi.MemXtsk;

/**
 * This example illustrates the use of the IxnTskSearch interaction to retrieve
 * one or more Task(Tsk) objects.
 *
 * We will attempt to return the memXtsk segment that meets search criteria for
 * the memXtsk segments. Because EntXtsk is set in the SegCode filter the
 * EntXTsk segments will also be returned for just the Members that have MemXtsk
 * segments that match the search.
 */
public class ExTskSearch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnTskSearch";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnTskSearch tskSearch = new IxnTskSearch(getContext());

    // Create a member rowlist to hold input member row(s)
    MemRowList inputRowList = new MemRowList();

    // Create a member rowlist to hold output row(s)
    MemRowList outputRowList = new MemRowList();

    // Create an empty MemHead object. MemHead models
    // Initiate Initiate database table mpi_memhead.
    MemHead memHead = new MemHead();
    inputRowList.addRow(memHead);

    // search for a Task Type - Potential Overlay
    MemXtsk memXtsk = new MemXtsk();
    memXtsk.setTskTypeno(1);

    // find tasks that have a score less then the max of 9.9
    memXtsk.setMaxScore((short) 99);
    inputRowList.addRow(memXtsk);

    // Set the segCodeFilter to limit the output to
    // specific segments if required.
    tskSearch.setSegCodeFilter("MEMHEAD,MEMXTSK,ENTXTSK");

    // Set the record status indicators desired.
    tskSearch.setRecStatFilter("A");

    // Set entity type as Identity (id)
    // Entity types are listed in mpi_enttype table.
    tskSearch.setEntType("id");

    // Execute the interaction
    boolean status = tskSearch.execute(inputRowList, outputRowList);
    if (status)
      dumpRows(outputRowList, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", tskSearch.getErrCode().toString(), tskSearch.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
