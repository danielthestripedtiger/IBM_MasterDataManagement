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

import madison.mpi.IxnMemDelete;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This examples shows how IxnMemDelete interaction object can be used to delete
 * member. This interaction updates memstat to D in memhead table but data for
 * member will exist. The member can be recovered by the use of IxnMemUndelete
 * interaction.
 */
public class ExMemDelete extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemDelete";

  public static void main(String[] args) throws Exception
  {
    // This interaction logically deletes a single member from
    // the Identity Hub. Logical deletion removes the derived
    // data for a member so that it cannot be the result of a
    // search, match, or take further updates.
    // Create a member delete interaction object.
    IxnMemDelete memDelete = new IxnMemDelete(getContext());

    // Create a member rowlist to hold input member row(s)
    MemRowList inpMemRows = new MemRowList();

    // Create a MemHead object.
    // MemHead models the Initiate database table mpi_memhead
    MemHead memHead = new MemHead();

    // Set the identifiers of the member to be deleted.
    // You can use SrcCode/MemIdNum combination:
    memHead.setSrcCode("OUTP");
    memHead.setMemIdnum("567677");
    // or the MemRecno to identify the member.
    // memHead.setMemRecno(162);
    // If MemRecno is used the .execute() (below) will use KeyType.MEMRECNO

    waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());

    // Add MemHead into MemRowList
    inpMemRows.addRow(memHead);

    // Execute member delete interaction.
    // boolean status = memDelete.execute(inpMemRows, KeyType.MEMRECNO);
    boolean status = memDelete.execute(inpMemRows, KeyType.MEMIDNUM);
    if (status)
      info("The " + intrName + " interaction worked, member was deleted.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memDelete.getErrCode().toString(), memDelete.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
