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

import madison.mpi.AudRowList;
import madison.mpi.GetType;
import madison.mpi.IxnMemMatch;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;
import madison.mpi.SearchType;

/**
 * This examples illustrates the use of the IxnMemMatch interaction.
 * The member match interaction object IxnMemMatch is used
 * to perform a two-phase search for members.  The first
 * phase is to get the input member. All of the resulting member's
 * attributes are then used to perform a full search for
 * other members.
 * The Search portion of a MemMatch interaction does not use the
 * maxRows or minScore API settings.  It operates as the entity manager
 * does, using the thresholds, and only returning those members that are
 * above the CR threshold, or take part in an Review Identifier (RI) task.
 */
public class ExMemMatch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemMatch";

  public static void main(String[] args) throws Exception
  {
    // Create the member match interaction object.
    IxnMemMatch memMatch = new IxnMemMatch(getContext());

    // Create member rowlists to hold input
    // and output row(s).
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    AudRowList outAudRows = new AudRowList();

    // Create a MemHead object to pass in the member's ID numbers
    // for whom we wish to find the matches.
    // MemHead models Initiate database table mpi_memhead.
    MemHead memHead = new MemHead();

    // Set the identifiers of member to be matched.
    memHead.setSrcCode("RMC");
    memHead.setMemIdnum("112917");
    inpMemRows.addRow(memHead);

    // Set a segment code filter to limit
    // output to specific segments.
    memMatch.setSegCodeFilter("MEMHEAD,MEMATTR,MEMNAME,MEMADDR,MEMPHONE,MEMIDENT,MEMDATE,AUDHEAD");

    // Set the record status indicators desired.
    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow.
    memMatch.setRecStatFilter("A,I");
    // Set the member type as PERSON.
    // Member types are listed in mpi_memtype table.
    memMatch.setMemType("PERSON");

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    memMatch.setEntType("id");

    // GetType.ASMEMBER- specifies that only individual
    // members will be retrieved
    // SearchType.ASMEMBER- tells the search to compare
    // the input on a member by member basis.
    // KeyType.MEMIDNUM - specifies the srcCode/memIdnum is the
    // retrieval key
    // Execute the member match interaction.
    boolean status = memMatch.execute(inpMemRows, outMemRows, GetType.ASMEMBER, SearchType.ASMEMBER, KeyType.MEMIDNUM, outAudRows);
    if (status)
    {
      // There will be quite a few rows returned as a result of this match. To
      // see the rows uncomment the dumpMem() call.
      // dumpMem(outMemRows, "The " + intrName + " interaction worked, here are the returned rows:");
      info("Total number of rows returned: " + outMemRows.size() +
          "\nTotal number of members returned: " + outMemRows.getMemberCount() +
          "\nAs a result of this " + intrName + " execution.");
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memMatch.getErrCode().toString(), memMatch.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
