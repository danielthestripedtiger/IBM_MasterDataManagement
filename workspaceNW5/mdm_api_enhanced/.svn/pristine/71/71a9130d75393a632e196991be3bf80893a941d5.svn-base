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

import madison.mpi.DicRow;
import madison.mpi.DicRowList;
import madison.mpi.IxnHead;
import madison.mpi.IxnNetGetInfo;
import madison.mpi.IxnStat;
import madison.mpi.RowIterator;

/**
 * This example illustrates the use of the IxnNetGetInfo interaction.
 * IxnNetGetInfo is used to display all the possible interactions with the
 * database. Along with the header information about interactions it displays
 * statistics associated with each in the dictionary. The interaction can also
 * deliver statistical usage information, and we will see this information in
 * the second part of the example.
 */
public class ExNetGetInfo extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnNetGetInfo";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnNetGetInfo netGet = new IxnNetGetInfo(getContext());

    // Create a rowlist to hold input row(s)
    DicRowList outputRows = new DicRowList();

    // Set a segCodeFilter which will limit the output to just specific segments.
    // netGet.setSegCodeFilter("IXNHEAD");
    // To get the statistical usage information we have to supply another filter: IXNSTAT
    netGet.setSegCodeFilter("IXNHEAD,IXNSTAT");

    // Set the record status indicators desired.
    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow.
    netGet.setRecStatFilter("A");

    // Execute the interaction
    boolean status = netGet.execute(outputRows);
    if (status)
      // Because the row list returned by this interaction is quite large (even
      // larger if since used IXNSTAT filter) we are not going to print all of
      // the rows, only their count.
      info("The " + intrName + " interaction worked and returned " + outputRows.size() + " rows.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", netGet.getErrCode().toString(), netGet.getErrText());
    }

    // If you wish to see all of the rows returned comment out the following line:
    // dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");

    // Now we will get only the rows for IxnNetGetInfo interaction (only the IxnStat rows).

    // We are going to store all of the NETGETINFO's IxnStat rows (statistical
    // usage information) in:
    DicRowList narrowList = new DicRowList();

    // We will be looking for ixnRecno to find all of the IxnStat rows for NETGETINFO
    // No interaction has ixnRecno == 0, so it's a safe initialization value.
    int ixnRecno = 0;

    // First iterate through our outputRows and find the NETGETINFO's ixnRecno
    for(RowIterator iter = outputRows.rows(); iter.hasMoreRows();)
    {
      DicRow dr = (DicRow) iter.nextRow();
      if(dr instanceof IxnHead)
      {
        if(dr.getString("ixncode").equalsIgnoreCase("netgetinfo"))
          // Once we find the IxnHead row for the NETGETINFO interaction we can
          // get the ixnRecno
          ixnRecno = dr.getInt("ixnrecno");
      }
    }

    // Now that we know what ixnRecno we are looking for we can get all of the
    // NETGETINFO's IxnStat rows
    for(RowIterator iter = outputRows.rows(); iter.hasMoreRows();)
    {
      DicRow dr = (DicRow) iter.nextRow();
      // We can also use ClassTester in place of the instanceof operator. An
      // example of ClassTester can be seen in ExEiaPut.
      if(dr instanceof IxnStat && dr.getInt("ixnrecno") == ixnRecno)
      {
        // Adding the IxnStat row to our narrowList
        narrowList.addRow(dr);
      }
    }

    // At this point narrowList contains only the IxnStat rows for NETGETINFO
    // interaction. Uncomment the line below if you wish to see them in the
    // output.
    // dumpRows(narrowList, "NETGETINFO");
    // Let us get the number of NETGETINFO interactions in the past two hours.
    int totalNetGetInfoExecutions = 0;
    for(RowIterator iter = narrowList.rows(); iter.hasMoreRows();)
    {
      IxnStat is = (IxnStat) iter.nextRow();
      if(is.getIdxHour() == 0 || is.getIdxHour() == 1)
        // There are other statistical points of data available, see API
        // documentation for more details. For now we are only interested in
        // total number of executions.
        totalNetGetInfoExecutions += is.getTotExecs();
    }

    // Note that the IxnNetGetInfo we just ran is not part of the count, but, if
    // you run this example a few times the number will grow.
    info("NETGETINFO interaction has been executed " + totalNetGetInfoExecutions + " time in the last two hours.");

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
