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
import madison.mpi.IxnMemSearch;
import madison.mpi.MemDate;
import madison.mpi.MemHead;
import madison.mpi.MemIdent;
import madison.mpi.MemName;
import madison.mpi.MemRowList;
import madison.mpi.SearchType;

/**
 *  This example illustrates the use of the IxnMemSearch interaction.
 *  Search is done on various attributes of the member we provide.
 */
public class ExMemSearch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemSearch";

  public static void main(String[] args) throws Exception
  {
    // Create the member search interaction object.
    IxnMemSearch memSearch = new IxnMemSearch(getContext());

    // Create member rowlists to hold input
    // and output row(s).
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    AudRowList outAudRows = new AudRowList();

    MemHead memHead = new MemHead();

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    memSearch.setEntType("id");

    // Set the member type as PERSON.
    // Member types are listed in mpi_memtype table.
    memSearch.setMemType("PERSON");

    //This keeps *Time fields from having the audit dates returned,
    // setting this to AUDNONE will increase performance.
    //memSearch.setAudMode(AudMode.AUDNONE);

    // Set the SegCodeFilter to the segment codes
    // we want to display in the output.
    // In the result set we get, we want only fields
    // from member head table and name table.
    memSearch.setSegCodeFilter("MEMHEAD,MEMATTRALL,AUDALL");

    // Set the record status indicators desired.
    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow.
    memSearch.setRecStatFilter("A,I");

    // Set memstat value as A - Active, O- Overlay.
    memSearch.setMemStatFilter("A,O");
    memSearch.setMinScore((short) 0);
    // Setting the MaxRows is not required. See API documentation for more
    // details.
    memSearch.setMaxRows(50);

    // Searches require well-formed member objects
    // so there must be a memhead even if it is empty.
    inpMemRows.addRow(memHead);

    // The search is performed using the member's legal name,
    // SSN and birth date.
    // Construct/initialize a memName record and add
    // it to the inpMemRow list.
    MemName memName = new MemName(memHead);
    memName.setAttrCode("LGLNAME");
    memName.setOnmLast("Beverly");
    memName.setOnmFirst("Norman");
    inpMemRows.addRow(memName);

    // Construct/initialize a memIdent record
    // and add it to the inpMemRow list.
    MemIdent memIdent = new MemIdent(memHead);
    memIdent.setAttrCode("SSN");
    memIdent.setIdIssuer("SSA");
    memIdent.setIdNumber("359426486");
    inpMemRows.addRow(memIdent);

    // Construct/initialize a memDate record and
    // add it to the inpMemRow list.
    MemDate memDate = new MemDate(memHead);
    memDate.setAttrCode("BIRTHDT");
    memDate.setDateVal("1962-11-04");
    inpMemRows.addRow(memDate);

    // Execute member search interaction with the options
    // GetType.ASENTITY - specifies that if any member of
    // an Entity meets the requirements of the interaction, all
    // related members in the Entity will also be retrieved
    // SearchType.ASMEMBER- tells the search to compare
    // the input on a member by member basis.
    boolean status = memSearch.execute(inpMemRows, outMemRows, GetType.ASENTITY, SearchType.ASMEMBER, outAudRows);
    if (status)
      dumpRows(outMemRows, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memSearch.getErrCode().toString(), memSearch.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
