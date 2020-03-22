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
import madison.mpi.IxnUsrGetInfo;
import madison.mpi.UsrHead;

/**
 * This examples illustrates two different uses of the IxnUsrGetInfo
 * interaction.
 *
 * First we will use a valid login to get the user information from Master Data
 * Engine.
 *
 * Afterwards we will use the IxnUsrGetInfo interaction with an invalid login,
 * and handle the outcome.
 */
public class ExUsrGetInfo extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnUsrGetInfo";

  public static void main(String[] args) throws Exception
  {
    // create the interaction
    IxnUsrGetInfo usrGetInfo = new IxnUsrGetInfo(getContext());

    //create the row list to hold the results
    DicRowList  outputRows = new DicRowList();

    // SegCode filter is required for this interaction. Set the filter for what
    // segments you want returned. A list of valid SegCodes can be found in the
    // mpi_seghead table.
    usrGetInfo.setSegCodeFilter("USRHEAD");
    // In this example we are only interested in Active rows.
    usrGetInfo.setRecStatFilter("A");
    // We are bout to execute the interaction and see the available data that is returned.
    // We don't have to create a UsrHead object to make the call, the login
    // information from our Context object will be used.
    boolean status = usrGetInfo.execute(outputRows);
    if (status)
      dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");
    else
      ixnError("The " + intrName + " interaction failed.", usrGetInfo.getErrCode().toString(), usrGetInfo.getErrText());

    // IxnUsrGetInfo can be used to authenticate a specific login against the Master Data Engine's known valid active logins.
    UsrHead usrHead = new UsrHead("invalidLogonId", "invlaidPassword");
    status = usrGetInfo.execute(usrHead, outputRows);
    if (status)
      dumpRows(outputRows, "The " + intrName + " interaction worked, here are the returned rows:");
    else
      // Because the login and password we used were not valid, the interaction
      // fails, and the usrGetInfo.getErrText() states the reason, as expected.
      info("The " + intrName + " interaction failed because of a bad login and/or password." +
           " \nerrCode = " + usrGetInfo.getErrCode().toString() +
           " \nerrtext = " + usrGetInfo.getErrText());

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
