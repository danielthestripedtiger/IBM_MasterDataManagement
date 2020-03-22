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

import madison.mpi.DicRowList;
import madison.mpi.IxnDicGet;
import madison.mpi.Row;

/**
 * This example illustrates the use of the IxnDicGet interaction. This
 * interaction retrieves dictionary data from the Master Data Engine.
 */
public class ExDicGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnDicGet";

  public static void main(String[] args) throws Exception
  {
    // Create the dictionary get interaction object.
    IxnDicGet dicGet = new IxnDicGet(getContext());

    // Create dictionary rowlists to hold output row(s).
    DicRowList outputRows = new DicRowList();

    // SegCode filters are required for this interaction.
    // Set the SegCode filter with the segment codes of tables
    // we want to retrieve.
    dicGet.setSegCodeFilter("SEGATTR,SRCHEAD,USRHEAD,GRPHEAD,TSKTYPE");

    // Set the record status indicators desired.
    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow.
    dicGet.setRecStatFilter(Row.m_RECSTAT_A);

    // Execute the dictionary get interaction.
    // The output of the interaction is stored in outputRows.
    boolean status = dicGet.execute(outputRows);
    if (status)
    {
      // There are quite a number of rows that get returned as a result of this
      // dicGet, so we are not going to print them all to the screen.
      info("The " + intrName + " interaction worked and returned " + outputRows.size() + " rows.");
      // Uncomment the line below if you wish to see the returned rows.
      // dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", dicGet.getErrCode().toString(), dicGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
