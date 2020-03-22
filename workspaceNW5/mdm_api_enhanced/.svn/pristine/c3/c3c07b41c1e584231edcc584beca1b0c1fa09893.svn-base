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
import madison.mpi.IxnEngGetInfo;

/**
 * This example illustrates the IxnEngGetInfo interaction. Is it a good idea to
 * take a look at the ExEngSetInfo example prior to this example.
 */
public class ExEngGetInfo extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnEngGetInfo";

  public static void main(String[] args) throws Exception
  {
    // Create the get interaction
    IxnEngGetInfo engGet = new IxnEngGetInfo(getContext());

    // Create the row list to hold the results
    DicRowList outputRows = new DicRowList();

    engGet.setSegCodeFilter("SYSKEY");
    // We are only interested in the active rows in this example:
    engGet.setRecStatFilter("A");

    // Execute the transaction.
    boolean status = engGet.execute(outputRows);
    if (status)
      dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", engGet.getErrCode().toString(), engGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
