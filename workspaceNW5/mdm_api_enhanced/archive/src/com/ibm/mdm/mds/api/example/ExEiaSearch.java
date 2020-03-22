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

import madison.mpi.IxnEiaSearch;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;
import madison.mpi.MemXeia;

/**
 * This example shows how IxnEiaSerach interaction used to search for EIA
 * records which meet a combination of member and/or Eia criteria. Must run
 * ExMemDelete, ExMemUndelete, then ExEiaPut for this to work.
 */
public class ExEiaSearch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnEiaSearch";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction
    IxnEiaSearch eiaSearch = new IxnEiaSearch(getContext());

    // Create a member rowlist to hold input member row(s)
    MemRowList inputRowList = new MemRowList();

    // Create a member rowlist to hold output row(s)
    MemRowList outputRowList = new MemRowList();

    // Create a empty MemHead object.
    MemHead memHead = new MemHead();
    inputRowList.addRow(memHead);

    // Search for a eia type 9 - Delete
    MemXeia memXeia = new MemXeia();
    memXeia.setEiaTypeno(9);

    // Find records that are less than max score of 9.9
    memXeia.setMaxScore((short) 99);
    inputRowList.addRow(memXeia);

    // Set a segment code filter to limit output to specific segments.
    eiaSearch.setSegCodeFilter("MEMHEAD,MEMXEIA");

    // Set the record status indicators desired.
    eiaSearch.setRecStatFilter("A");

    // Set entity type as Identity (id)
    // Entity types are listed in mpi_enttype table.
    eiaSearch.setEntType("id");

    // Execute the interaction.
    boolean status = eiaSearch.execute(inputRowList, outputRowList);
    if (status)
    {
      long ser = ExRowWork.getSupMemRecnoFromUndeleteTask(outputRowList);
      info("The " + intrName + " interaction worked, supEntRecno fo the Undelete task is: " + ser);
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", eiaSearch.getErrCode().toString(), eiaSearch.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
