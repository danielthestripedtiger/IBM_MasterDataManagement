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

import java.util.Iterator;
import java.util.List;

import madison.mpi.IxnRelTskResolve;
import madison.mpi.RelXtsk;

public class ExRelTskResolve extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
private static final String intrName = "IxnRelTskResolve";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnRelTskResolve relTskResolve = new IxnRelTskResolve(getContext());

    // Get a list of relTsts
    List<RelXtsk> relTsks =  ExRelTskSearch.getRelTsks();

    // Mark all of the tasks as resolved.
    for(Iterator<RelXtsk> iter = relTsks.iterator(); iter.hasNext();)
    {
      // Status of 2 is Resolved, defined in mpi_tststat table.
      iter.next().setTskStatno(2);
    }

    // Execute the interaction
    boolean status = relTskResolve.execute(relTsks);
    if (status)
    {
      info("The " + intrName + " interaction worked.  Found " + relTskResolve.getResult().size() + " tasks.");
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relTskResolve.getErrCode().toString(), relTskResolve.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
