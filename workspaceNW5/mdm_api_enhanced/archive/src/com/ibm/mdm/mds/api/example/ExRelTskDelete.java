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
import java.util.Map;

import madison.mpi.IxnRelDelete;
import madison.mpi.IxnRelSearch;
import madison.mpi.IxnRelSearchBase;
import madison.mpi.IxnRelTskDelete;
import madison.mpi.RelLink;
import madison.mpi.RelXtsk;

/**
 * There is no IxnRelTskDelete interaction. We are deleting the tasks created in
 * the ExRelTskCreate example.
 *
 * You must execute the ExRelTskCreate example for this example to function.
 *
 * We are also going to be using a method from ExRelTskSearch in order to find
 * the relationship tasks.
 */
public class ExRelTskDelete extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelTskDelete";
  private static final String[] memberOne = new String[]{"RMC", "204894"};
  private static final String[] memberTwo = new String[]{"ARH", "159603"};

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnRelTskDelete relTskDelete = new IxnRelTskDelete(getContext());

    // We are going to make a call to a method in ExRelTskSearch in order to
    // obtain the relTskno list for the tasks we created in ExRelTskCreate.
    List<Long> relTskNoList = new ArrayList<Long>();
    for(Iterator<RelXtsk> iter = ExRelTskSearch.getRelTsks().iterator(); iter.hasNext();)
    {
      relTskNoList.add(iter.next().getTskRecno());
    }
    info("The resulting task recnos: " + relTskNoList);

    // Execute the interaction.
    boolean status = relTskDelete.execute(relTskNoList);
    if (status)
      info("The " + intrName + " interaction worked, relationship tasks have been deleted.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relTskDelete.getErrCode().toString(), relTskDelete.getErrText());
    }

    // Now we have to delete the relationships (clean up) that we created in
    // order to produce the relationship tasks.  Lets find these relationships.
    IxnRelSearch relSearch = new IxnRelSearch(getContext());
    List<Long> entRecnoList = new ArrayList<Long>();
    entRecnoList.add(ExMemGet.getEntRecno(memberOne));
    entRecnoList.add(ExMemGet.getEntRecno(memberTwo));
    status = relSearch.execute(entRecnoList, IxnRelSearchBase.DIR_TYPE_BOTH, 50);
    if (status)
      info("The IxnRelSearch interaction worked.  Relationships found for " + relSearch.getResult().size() + " entities.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The IxnRelSearch interaction failed.", relSearch.getErrCode().toString(), relSearch.getErrText());
    }
    List<Long> relRecNos = new ArrayList<Long>();
    Map<Long, List<RelLink>> relResult = (Map<Long, List<RelLink>>)relSearch.getResult();
    for(Iterator<Long> iter = relResult.keySet().iterator(); iter.hasNext();)
    {
      List<RelLink> relLinks = relResult.get(iter.next());
      for(Iterator<RelLink> iterRelLink = relLinks.iterator(); iterRelLink.hasNext();)
      {
        Long relLinkno = iterRelLink.next().getRelLinkno();
        if(!relRecNos.contains(relLinkno))
          relRecNos.add(relLinkno);
      }
    }
    // Now lets remove the relationships.
    IxnRelDelete relDel = new IxnRelDelete(getContext());
    status = relDel.execute(relRecNos);
    if (status)
      info("The IxnRelDelete interaction worked.  Relationships have been deleted.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The IxnRelDelete interaction failed.", relDel.getErrCode().toString(), relDel.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
