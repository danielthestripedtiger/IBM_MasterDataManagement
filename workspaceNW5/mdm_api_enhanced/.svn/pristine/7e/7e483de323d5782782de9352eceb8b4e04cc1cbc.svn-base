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
import madison.mpi.IxnEngSetInfo;
import madison.mpi.SysKey;

/**
 * This example illustrates the use of IxnEngSetInfo interaction. Note that the
 * changes made via this interaction are not persisted between restarts of the
 * Master Data Engine.
 *
 * After the execution of this example you can use the ExEngGetInfo to see the
 * changes that took place.
 */
public class ExEngSetInfo extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnEngSetInfo";

  public static void main(String[] args) throws Exception
  {
    // Create the dictionary get interaction
    IxnEngSetInfo engSet = new IxnEngSetInfo(getContext());

    //create the row list to hold the results
    DicRowList inputRows = new DicRowList();
    SysKey skTrace = new SysKey();
    skTrace.setKeyName("MAD_DEBUG");
    skTrace.setKeyVal("1");
    inputRows.addRow(skTrace);

    boolean status = engSet.execute(inputRows);
    if (status)
      info("The " + intrName + " interaction worked.  MAD_DEBUG is now set to true.");
    else
      ixnError("The " + intrName + " interaction failed.", engSet.getErrCode().toString(), engSet.getErrText());

    // There are convenience methods for setting some of the fundamental Engine
    // information (MAD_TRACE, MAD_DEBUG, MAD_AUDIT, and a few others). here is
    // an example of on of these setters:
    engSet = new IxnEngSetInfo(getContext());
    engSet.setAlert(true);
    // Note that this time we are not using a DicRowList during the execute()
    // call. If DicRowList is used in the execute(DicRowList), the
    // changes made by the convenience setter .setAlert(true) will be ignored.
    status = engSet.execute();
    if (status)
      info("The " + intrName + " interaction worked.  MAD_ALERT is now set to true.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", engSet.getErrCode().toString(), engSet.getErrText());
    }

    // After the execution of this example you can use the ExEngGetInfo to see
    // the changes that took place.

    // Let us set the MAD_DEBUG and MAD_ALERT back to false:
    engSet = new IxnEngSetInfo(getContext());
    engSet.setDebug(false);
    engSet.setAlert(false);
    status = engSet.execute();
    if (!status)
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", engSet.getErrCode().toString(), engSet.getErrText());
    }
    info("MAD_DEBUG and MAD_ALERT have been set back to false");
    // Disconnect from Master Data Engine server
    disconnect();
  }
}
