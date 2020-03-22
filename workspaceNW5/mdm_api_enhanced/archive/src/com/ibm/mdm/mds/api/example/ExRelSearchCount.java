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
import java.util.List;
import java.util.Map;

import madison.mpi.IxnRelSearch;
import madison.mpi.IxnRelSearchCount;

/**
 * This example illustrates the IxnRelSearchCount interaction.
 *
 * The ExRelPut example must be executed for this example to find the
 * relationship we are looking for.
 */
public class ExRelSearchCount extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelSearchCount";

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnRelSearchCount relSearchCount = new IxnRelSearchCount(getContext());

    List<Long> entRecnoList = new ArrayList<Long>();
    entRecnoList.add(ExMemGet.getEntRecno(new String[]{"RMC", "72949"}));
    entRecnoList.add(ExMemGet.getEntRecno(new String[]{"RMC", "75503"}));

    // We created a relationship in ExRelPut example, so we know relTypeno
    // (50-Boss) and we know the direction (since Boss is a one-way
    // relationship.
    boolean status = relSearchCount.execute(entRecnoList, IxnRelSearch.DIR_TYPE_BOTH, 50);
    if (status)
      info("The " + intrName + " interaction worked.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relSearchCount.getErrCode().toString(), relSearchCount.getErrText());
    }

    // After the interaction has been executed successfully, the result will
    // contain the counts of RelLinks associated with the specified list of
    // entRecnos. Only RelLink counts for the specified relTypeno are returned.
    Map<Long, Long> result = (Map<Long, Long>)relSearchCount.getResult();

    info("List of entRecno=numberOfRelationships: " + result);

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
