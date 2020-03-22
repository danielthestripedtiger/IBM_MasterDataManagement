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

import java.util.List;

import madison.mpi.IxnRelPathToRoot;

/**
 * This example illustrates the IxnRelPathToRoot interaction.
 *
 * The ExRelPut example must be executed for this example to find the
 * relationship we are looking for.
 */
public class ExRelPathToRoot extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelPathToRoot";

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnRelPathToRoot relPtr = new IxnRelPathToRoot(getContext());

    // We created a relationship in ExRelPut example, so we know the relTypeno.
    // boolean status = relPtr.execute(ExMemGet.getEntRecno(new String[]{"RMC", "72949"}), 50);
    boolean status = relPtr.execute(ExMemGet.getEntRecno(new String[]{"RMC", "75503"}), 50);
    if (status)
      info("The " + intrName + " interaction worked.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relPtr.getErrCode().toString(), relPtr.getErrText());
    }

    // After the interaction has been executed successfully, the result will
    // contain the entity record numbers on the path.
    List<Long> result = (List<Long>)relPtr.getResult();

    // Note that the 50 (Boss) relationship is a one-way relationship, and if we
    // used RMC:72949 instead of RMC:75503 in our execute() call the list would
    // contain a single number (path to self).
    info("The list of entRecno numbers that is the path to the root of the relationship: " + result);

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
