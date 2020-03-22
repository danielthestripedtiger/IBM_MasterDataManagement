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
import madison.mpi.IxnRelSearchBase;
import madison.mpi.RelLink;

/**
 * This example illustrates the use of IxnRelSearch interaction.
 *
 * In order for this example to find the relationship you must first run the
 * ExRelPut example.
 *
 * There is a getLinkNo() method in this example, which is used by the ExRelGet
 * and ExRelDelete examples. See comments in the examples for more information.
 */
public class ExRelSearch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelSearch";

  public static void main(String[] args) throws Exception
  {
    // Because we are going to use this example during the execution of ExRelGet
    // and ExRelDelete we are going to perform the IxnRelSearch in it's own
    // method.
    doRelSearch();
  }

  /**
   * This method performs the IxnRelSearch and returns the LinkNo for the
   * relationship (if one was found).
   *
   * @return LinkNo for the predetermined relationship (relationship only exists
   *         if ExRelPut was executed).
   * @throws Exception
   *           if the relationship was not found, or there was a higher-level
   *           issue.
   */
  @SuppressWarnings("unchecked")
  private static long doRelSearch() throws Exception
  {
    // Create the interaction object.
    IxnRelSearch relSearch = new IxnRelSearch(getContext());

    // We are going to use the ExMemGet.getEntRecno() to get the entRecno of the
    // "left" member in the relationship, which we created in the ExRelPut
    // example.
    long entRecNo = ExMemGet.getEntRecno(new String[]{"RMC", "72949"});
    //long entRecNo = ExMemGet.getEntRecno(new String[]{"RMC", "75503"});

    List<Long> entRecnoList = new ArrayList<Long>();
    entRecnoList.add(entRecNo);

    // We are using IxnRelSearchBase.DIR_TYPE_LEFT and 50 because that is what
    // we used when we created the relationship in ExRelPut.
    boolean status = relSearch.execute(entRecnoList, IxnRelSearchBase.DIR_TYPE_LEFT, 50);
    if (status)
      info("The " + intrName + " interaction worked.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relSearch.getErrCode().toString(), relSearch.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();

    // After the interaction has been executed successfully, the result will
    // contain the RelLinks associated with the specified list of entRecnos.
    // Only RelLinks for the specified relTypeno are returned. Each RelLink
    // represents a single relationship between entities.
    Map<Long, List<RelLink>> relResult = (Map<Long, List<RelLink>>)relSearch.getResult();

    // Let us get the List or RelLink rows for the entRecno we are interested in.
    List<RelLink> relLinksReturned = relResult.get(entRecNo);
    if(relLinksReturned == null)
      err("There are no RelLink entries for the entRecno = " + entRecNo);

    info("EntRecno Left = " + relLinksReturned.get(0).getEntRecnoLeft());
    info("EntRecno Right = " + relLinksReturned.get(0).getEntRecnoRight());
    info(intrName + " found the LinkNo: " + relLinksReturned.get(0).getRelLinkno());

    // Now we are going to find out what the LinkNo is for this relationship.
    return relLinksReturned.get(0).getRelLinkno();
  }

  /**
   * This method will perform the IxnRelSearch for a specific entRecno and
   * return the LinkNo of the relationship, or throw an Exception if the
   * relationship is not found.
   *
   * Note that ExRelPut must be ran to create the relationship we are looking
   * for.
   *
   * @return LinkNo
   * @throws Exception
   *           if the relationship does not exist.
   */
  public static long getLinkNo() throws Exception
  {
    return doRelSearch();
  }
}
