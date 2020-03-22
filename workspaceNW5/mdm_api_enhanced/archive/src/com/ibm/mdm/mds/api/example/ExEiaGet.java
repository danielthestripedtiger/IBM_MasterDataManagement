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

import madison.mpi.GetType;
import madison.mpi.IxnEiaGet;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;

/**
 * This example shows how IxnEiaGet interaction is used to retrieve the EIA data
 */
public class ExEiaGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnEiaGet";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnEiaGet eiaGet = new IxnEiaGet(getContext());

    // Create member rowlists to hold input.
    MemRowList eiaRowList = new MemRowList();

    // Create a member rowlist to hold output row(s)
    MemRowList eiaOutRowList = new MemRowList();

    // Create a MemHead object. MemHead models
    // Initiate Initiate database table mpi_memhead.
    MemHead memHead = new MemHead();
    memHead.setSrcCode("OUTP");
    memHead.setMemIdnum("567677");
    eiaRowList.addRow(memHead);

    // Set a segment code filter to limit
    // output to specific segments.
    eiaGet.setSegCodeFilter("MEMHEAD,MEMXEIA,ENTXEIA");

    // Set entity type as Identity (id)
    // Entity types are listed in mpi_enttype table.
    eiaGet.setEntType("id");

    // Set the record status indicators desired.
    eiaGet.setRecStatFilter("A");

    // Execute the interaction. If any EIA records are found
    // related to the input member, they will be returned in the
    // output RowList.
    // GetType.ASMEMBER- specifies that only individual
    // members will be retrieved.
    // KeyType.MEMIDNUM - specifies the srcCode/memIdnum is the
    // retrieval key.
    boolean status = eiaGet.execute(eiaRowList, eiaOutRowList, GetType.ASMEMBER, KeyType.MEMIDNUM);
    if (status)
      dumpRows(eiaOutRowList, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", eiaGet.getErrCode().toString(), eiaGet.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
