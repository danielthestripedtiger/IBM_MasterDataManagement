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

import madison.mpi.IxnRelPut;
import madison.mpi.RelLink;

/**
 * There is no IxnRelTskPut interaction. This example illustrates one of the
 * ways relationship tasks can come about.
 *
 * This example is used to cause a relationship task to be created, which will
 * be used in other ExRelTsk* examples.
 */
public class ExRelTskCreate extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelPut";
  private static final String[] memberOne = new String[]{"RMC", "204894"};
  private static final String[] memberTwo = new String[]{"ARH", "159603"};

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnRelPut relPut = new IxnRelPut(getContext());

    // Create the Relationship Link object.
    RelLink relLink1 = new RelLink();

    // We are going to get a couple of EntRecnos by using the
    // ExMemGet.getEntRecno() method.
    // These are for members RMC:204894 and ARH:159603
    relLink1.setEntRecnoLeft(ExMemGet.getEntRecno(memberOne));
    relLink1.setEntRecnoRight(ExMemGet.getEntRecno(memberTwo));

    // Setting the relationship type. These are defined in the mpi_reltype
    // table.  Here we are using 50 (Boss) which is a one-way relationship.
    relLink1.setRelTypeno(50);

    // Now we will add another RelLink for the same two entities, but in reverse
    // order (making the two each other's boss). This will cause a Relationship
    // Task to be created.
    RelLink relLink2 = new RelLink();
    relLink2.setEntRecnoLeft(ExMemGet.getEntRecno(memberTwo));
    relLink2.setEntRecnoRight(ExMemGet.getEntRecno(memberOne));
    relLink2.setRelTypeno(50);

    List<RelLink> relLinkList = new ArrayList<RelLink>();
    relLinkList.add(relLink1);
    relLinkList.add(relLink2);

    // Execute the interaction.
    boolean status = relPut.execute(relLinkList);
    if (status)
      info("The " + intrName + " interaction worked, relationships have been created.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relPut.getErrCode().toString(), relPut.getErrText());
    }

    // We can get the LinkNo of the newly-created relationships.
    List<RelLink> relLinks = (List<RelLink>) relPut.getResult();
    for(Iterator<RelLink> iter = relLinks.iterator(); iter.hasNext();)
    {
      RelLink rl = iter.next();
      info("The relationship for entRecno " + rl.getEntRecnoLeft() + " has a relLinkNo = " + rl.getRelLinkno());
    }
    // Disconnect from Master Data Engine server
    disconnect();
  }
}
