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

import madison.mpi.MemHead;
import madison.mpi.MemNote;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.mpi.IxnMemPostIt;

/**
 * This class illustrates the use of IxnMemPostIt. This IXN allows you to post
 * (insert) a note about a member.
 */
public class ExMemPostIt extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemPostIt";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnMemPostIt postIt = new IxnMemPostIt(getContext());

    // Create a member rowlist to hold input member row(s)
    MemRowList memList = new MemRowList();

    // Create a MemHead object.
    MemHead memHead = new MemHead();
    memHead.setMemRecno(167L);
    memHead.setEntRecno(0L);

    // Create a member note.
    MemNote memNote = new MemNote(memHead);
    memNote.setEntRecno(0);
    memNote.setTheNote("This is a member note"); // set theNote
    // CusrLogin and MusrLogin will be stored with the note in the mpi_memnote
    // table. Both must be valid MDE logins.
    memNote.setCusrLogin("rouser");
    memNote.setMusrLogin("mdmadmin");

    memList.addRow(memHead);
    memList.addRow(memNote);

    // output the MemList row contents.
    dumpRows(memList, "MemRows before the postIt.execute()");

    postIt.setMemType("PERSON");

    // IxnMemPostIt is a lightweight IxnMemPut, limited to Notes only. You can
    // not edit an existing note, you can only add a note.
    // PutType used does not really matter in this case, since a new note is
    // created every time
    // Execute the interaction.
    boolean status = postIt.execute(memList, PutType.UNKNOWN);
    if (status)
      dumpRows(memList, "The " + intrName + " interaction worked, here are the returned rows:");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", postIt.getErrCode().toString(), postIt.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
