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

import madison.mpi.AppHead;
import madison.mpi.DicRowList;
import madison.mpi.IxnAppGetInfo;

/**
 * Illustrates the use of the IxnAppGetInfo interaction with which we can get
 * the Application dictionary data
 */
public class ExAppGetInfo extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnAppGetInfo";

  public static void main(String[] args) throws Exception
  {
    // Create the Application get interaction object
    IxnAppGetInfo   appGet = new IxnAppGetInfo(getContext());

    // Set the Application Name you want the rows for
    DicRowList inputRows = new DicRowList();
    AppHead    appHead   = new AppHead();
    appHead.setAppName("Workbench");
    inputRows.addRow(appHead);

    // Create a dictionary rowlist to hold input dictionary row(s)
    DicRowList  outputRows = new DicRowList();

    // Set segCodeFilter which will limit the output to just specific segments.
    appGet.setSegCodeFilter("APPHEAD,APPDATA,APPPROP");

    // Set the record status indicators desired. The values include (A)ctive,
    // (I)nactive, (D)eleted and (S)hadow.
    appGet.setRecStatFilter("A");

    // Execute the interaction.
    boolean status = appGet.execute(inputRows, outputRows);
    if (status)
      dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", appGet.getErrCode().toString(), appGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
