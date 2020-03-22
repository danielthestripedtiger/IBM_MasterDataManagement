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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import madison.mpi.IxnRelTskGet;
import madison.mpi.RelXtsk;

/**
 * This example will illustrates the use of the IxnRelTskGet interaction.
 *
 * You must run the ExRelTskCreate example to create the tasks we will be
 * getting.
 *
 * The method getTasks will be used in the ExRelTskResolve example.
 */
public class ExRelTskGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelTskGet";

  public static void main(String[] args) throws Exception
  {
    getTasks();
  }

  @SuppressWarnings("unchecked")
  protected static List<RelXtsk> getTasks() throws Exception
  {
    // Create the interaction object.
    IxnRelTskGet relTskGet = new IxnRelTskGet(getContext());

    // We are going to use the tasks created during the ExRelTskCreate example.
    // We have a method ExRelTskSearch.getRelTskRecnos() that will get us the
    // relTskRecnos for the tasks we are interested in.

    List<Long> relTskNoList = new ArrayList<Long>();
    for(Iterator<RelXtsk> iter = ExRelTskSearch.getRelTsks().iterator(); iter.hasNext();)
    {
      relTskNoList.add(iter.next().getTskRecno());
    }

    // Execute the interaction.
    boolean status = relTskGet.execute(relTskNoList);
    if (status)
    {
      info("The " + intrName + " interaction worked.  Found " + relTskGet.getResult().size() + " task(s).");
      for(Iterator<RelXtsk> iter = (Iterator<RelXtsk>) (relTskGet.getResult()).iterator(); iter.hasNext(); )
      {
        RelXtsk tsk = iter.next();
        info("Task with tskRecno = " + tsk.getTskRecno() + " has a RelTypeNotype: " + tsk.getRelTypeno() +
            " and tskStatno " + tsk.getTskStatno());
      }
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relTskGet.getErrCode().toString(), relTskGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();

    return relTskGet.getResult();
  }
}
