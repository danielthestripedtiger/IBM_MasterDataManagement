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

import madison.mpi.IxnRelDelete;

/**
 * This example illustrates the use of IxnRelDelete interaction.
 *
 * In order for this example to work you must run the ExRelPut example first.
 */
public class ExRelDelete extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelDelete";

  public static void main(String[] args) throws Exception
  {
    // We need the LinkNo number to perform the IxnRelGet. This number is
    // created during the ExRelPut. Since this number will change every time we
    // run ExRelPut we are going to call the ExRelSearch.getLinkNo() method to
    // find the appropriate LinkNo.
    // Reference the ExRelSearch example to see how we can get the LinkNo of a
    // specific relationship.
    Long linkNo = ExRelSearch.getLinkNo();

    doRelDelete(linkNo);
  }

  /**
   * Delete the specified relationship.
   *
   * @param relLinkno
   * @throws Exception
   * 			if there was a problem deleting the relationship.
   */
  public static void doRelDelete(long relLinkno) throws Exception
  {
    // Create the interaction object
    IxnRelDelete relDel = new IxnRelDelete(getContext());

    List<Long> relLinknoList = new ArrayList<Long>();
    relLinknoList.add(relLinkno);

    // Execute the interaction.
    boolean status = relDel.execute(relLinknoList);
    if (status)
      info("The " + intrName + " interaction worked, the relationship has been deleted.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relDel.getErrCode().toString(), relDel.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
