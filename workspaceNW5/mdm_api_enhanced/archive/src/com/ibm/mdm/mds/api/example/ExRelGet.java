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

import madison.mpi.IxnRelGet;
import madison.mpi.RelLink;

/**
 * This example will illustrate the use of the IxnRelGet interaction.
 *
 * In order for the relationship to exist you must run the ExRelPut example.
 */
public class ExRelGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelGet";

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnRelGet relGet = new IxnRelGet(getContext());

    // A list of LinkNo numbers.
    List<Long> relLinknoList = new ArrayList<Long>();

    // We need the LinkNo number to perform the IxnRelGet. This number is
    // created during the ExRelPut. Since this number will change every time we
    // run ExRelPut we are going to call the ExRelSearch.getLinkNo() method to
    // find the appropriate LinkNo.
    // Reference the ExRelSearch example to see how we can get the LinkNo of a
    // specific relationship.
    Long linkNo = ExRelSearch.getLinkNo();
    relLinknoList.add(linkNo);

    // Execute the interaction.
    boolean status = relGet.execute(relLinknoList);
    if (status)
      info("The " + intrName + " interaction worked.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relGet.getErrCode().toString(), relGet.getErrText());
    }

    // After the interaction has been executed successfully, the result will
    // contain the RelLinks that match the get criteria.
    List<RelLink> result = (List<RelLink>) relGet.getResult();
    info("EntRecno Left = " + result.get(0).getEntRecnoLeft());
    info("EntRecno Right = " + result.get(0).getEntRecnoRight());

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
