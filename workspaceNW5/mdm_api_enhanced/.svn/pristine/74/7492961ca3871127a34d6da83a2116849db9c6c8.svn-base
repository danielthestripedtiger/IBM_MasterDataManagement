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

import madison.mpi.AudHead;
import madison.mpi.AudRowList;
import madison.mpi.IxnAudGet;

/**
 * This program illustrates the use of the IxnAudGet interaction.
 * This interaction retrieves dictionary data from the Initiate Hub.
 * It dumps the contents of the tables which contain dictionary data
 * and we provide the segment codes corresponding to the tables.
 */
public class ExAudGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemAudGet";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnAudGet audGet = new IxnAudGet(getContext());

    // Create rowlists to hold output row(s).
    AudRowList outputRows = new AudRowList();
    AudRowList inputRows = new AudRowList();

    AudHead audHead = new AudHead();
    audHead.setAudRecno(101);
    inputRows.addRow(audHead);

    audHead = new AudHead();
    audHead.setAudRecno(102);
    inputRows.addRow(audHead);

    // SegCode filters are required for this interaction.
    // Set the SegCode filter with the segment codes of tables
    // we want to retrieve.
    audGet.setSegCodeFilter("AUDHEAD,AUDXMEM");

    // Execute the interaction.
    // The output of the interaction is stored in outputRows.
    boolean status = audGet.execute(inputRows, outputRows);
    if (status)
      dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", audGet.getErrCode().toString(), audGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
