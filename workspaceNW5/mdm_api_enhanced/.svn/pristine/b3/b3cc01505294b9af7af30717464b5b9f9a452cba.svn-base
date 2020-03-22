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

import madison.mpi.IxnRelPut;
import madison.mpi.RelLink;

/**
 * This example will illustrate the use of the IxnRelPut interaction. The
 * resulting rows will be used in the other ExRel* examples.
 *
 * Note that once this example has been ran the relationship is created, and
 * running the example again will result in an Exception.
 *
 * You can delete the relationship via the ExRelDelete example.
 */
public class ExRelPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelPut";

  public static void main(String[] args) throws Exception
  {
    // Create the Relationship Link object.
    RelLink relLink1 = new RelLink();

    // We are going to get a couple of EntRecnos by using the
    // ExMemGet.getEntRecno() method.
    // These are for members RCM:72949 and RCM:75503
    relLink1.setEntRecnoLeft(ExMemGet.getEntRecno(new String[]{"RMC", "72949"}));
    relLink1.setEntRecnoRight(ExMemGet.getEntRecno(new String[]{"RMC", "75503"}));

    // Setting the relationship type. These are defined in the mpi_reltype
    // table.  50 = Boss which is a one-way relationship.
    relLink1.setRelTypeno(50);

    doRelPut(relLink1);
  }

  /**
   * Put the specified relationship.
   *
   * @param relLink
   * @return the resulting relLink (with relLinkno populated by the create)
   * @throws Exception
   * 			if there was a problem creating the relationship.
   */
  @SuppressWarnings("unchecked")
  public static RelLink doRelPut(RelLink relLink) throws Exception
  {
    // Create the interaction object.
    IxnRelPut relPut = new IxnRelPut(getContext());

    List<RelLink> relLinkList = new ArrayList<RelLink>();
    relLinkList.add(relLink);

    // Execute the interaction.
    boolean status = relPut.execute(relLinkList);
    if (status)
      info("The " + intrName + " interaction worked, relationship has been created.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relPut.getErrCode().toString(), relPut.getErrText());
    }

    // We can get the LinkNo of the newly-created relationship.
    // This number is used in ExRelDelete and ExRelGet examples.
    relLinkList = (List<RelLink>) relPut.getResult();
    RelLink resultRelLink = relLinkList.get(0);
    long newLinkNo = resultRelLink.getRelLinkno();
    info("The newly-created relationship has a LinkNo = " + newLinkNo);

    // Disconnect from Master Data Engine server
    disconnect();

    return resultRelLink;
  }
}
