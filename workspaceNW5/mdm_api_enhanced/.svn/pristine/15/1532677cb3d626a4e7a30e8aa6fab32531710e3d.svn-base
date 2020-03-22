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
import madison.mpi.EntXtsk;
import madison.mpi.GetType;
import madison.mpi.IxnMemGet;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;
import madison.mpi.Row;

/**
 * This class illustrates the use of IxnMemGet. This IXN allows you to get
 * information about a member.
 *
 * The method getEntRecno() is used by other examples, and illustrates some of
 * the ways we can get attribute information.
 */
public class ExMemGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnMemGet";

  public static void main(String[] args) throws Exception
  {
    // Create a member get interaction object.
    IxnMemGet memGet = new IxnMemGet(getContext());

    // Create member rowlists to hold input
    // and output row(s).
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    AudRowList outAudRows = new AudRowList();

    // Create a MemHead object.
    // MemHead models the Initiate database table mpi_memhead.
    MemHead memHead = new MemHead();
    memHead.setSrcCode("SURG");
    memHead.setMemIdnum("144760");
    // Another option is to use MemRecno during MemHead instantiation:
    // memHead = new MemHead(167L);
    // But if this option is used you must also use KeyType.MEMRECNO during the
    // memGet.execute() call (below).
    // Consult the API documentation for all of the options of the MemHead
    // creation.
    inpMemRows.addRow(memHead);

    // Set a segment code filter to limit
    // output to specific segments.
    //memGet.setSegCodeFilter("MEMHEAD,MEMATTR,MEMNAME,MEMADDR,MEMPHONE,MEMIDENT,MEMDATE");
    memGet.setSegCodeFilter("MEMHEAD,MEMATTRALL,AUDALL");

    // Set the record status indicators desired.
    // The values include (A)ctive, (I)nactive, (D)eleted and (S)hadow.
    //memGet.setRecStatFilter("A");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);

    // Set the member type as PERSON.
    // Member types are listed in mpi_memtype table.
    memGet.setMemType("PERSON");

    // Set entity type as Identity (id).
    // Entity types are listed in mpi_enttype table.
    // memGet.setEntType("id");
    // Entity type is only used with GetType.ASENTITY

    // GetType.ASMEMBER - ASMEMBER specifies that only individual
    // members will be retrieved.
    // KeyType.MEMIDNUM - specifies the srcCode/memIdnum is the
    // retrieval key.
    // Execute the member get interaction.
    boolean status = memGet.execute(inpMemRows, outMemRows, GetType.ASMEMBER, KeyType.MEMIDNUM, outAudRows);
    if (status)
    {
      // Uncomment the line below to see a dump of the returned rows.
      // dumpRows(outMemRows, "The " + intrName + " interaction worked, here are the returned rows:");
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }

    // Now we are going to get a few members in the same IxnMemGet
    inpMemRows = new MemRowList();
    outMemRows = new MemRowList();
    // We will use some known memSrcCode:memIdnum pairs (based on the demo database).
    memHead = new MemHead();
    inpMemRows.addRow(makeMemHead("ARH", "555555"));
    inpMemRows.addRow(makeMemHead("PHYS", "145212"));
    inpMemRows.addRow(makeMemHead("SURG", "260884"));
    inpMemRows.addRow(makeMemHead("OUTP", "172589"));
    inpMemRows.addRow(makeMemHead("RMC", "565656"));
    memGet.setSegCodeFilter("MEMHEAD,MEMATTRALL");
    memGet.setSegAttrFilter("PCPNAME");
    memGet.setRecStatFilter(Row.m_RECSTAT_ALL);
    status = memGet.execute(inpMemRows, outMemRows, GetType.ASMEMBER, KeyType.MEMIDNUM);
    if (status)
    {
      info("The " + intrName + " interaction worked, here are the sorted names:");
      ExRowWork.iterateWithSort(outMemRows);
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }
    // Disconnect from Master Data Engine server
    disconnect();
  }

  /**
   * This method is used by other example (mostly ExRel*) to obtain the entRecno
   * for a specific member.
   *
   * @param identifiers
   *          A String[] containing either srcCode and memIdNum or memRecno
   * @return the entRecno for the given member
   * @throws Exception
   *           if there was a problem performing the interaction.
   */
  public static long getEntRecno(String[] identifiers) throws Exception
  {
    long entRecno = 0L;
    IxnMemGet memGet = new IxnMemGet(getContext());
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    MemHead memHead = new MemHead();
    KeyType kt = KeyType.MEMIDNUM;
    if(identifiers.length == 2)
    {
      memHead.setSrcCode(identifiers[0]);
      memHead.setMemIdnum(identifiers[1]);
    } else
    {
      memHead.setMemRecno(Long.parseLong(identifiers[0]));
      kt = KeyType.MEMRECNO;
    }
    inpMemRows.addRow(memHead);
    // We only need MemHead rows to get the entRecno
    memGet.setSegCodeFilter("MEMHEAD");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);
    memGet.setMemType("PERSON");
    memGet.setEntType("id");
    boolean status = memGet.execute(inpMemRows, outMemRows, GetType.ASENTITY, kt);
    if (status)
    {
      entRecno = ExRowWork.getEntRecno(outMemRows);
    }
    else
    {
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }
    return entRecno;
  }

  /**
   * This method is used by other examples (mostly ExTag*) to obtain the EntXtsk
   * for a specific member.
   *
   * @param identifiers
   *          A String[] containing either srcCode and memIdNum or memRecno
   * @return the EntXtsk for the given member, null if not found
   * @throws Exception
   *           if there was a problem performing the interaction.
   */
  public static EntXtsk getEntXtsk(String[] identifiers) throws Exception
  {
    EntXtsk entXtsk = null;
    IxnMemGet memGet = new IxnMemGet(getContext());
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    MemHead memHead = new MemHead();
    KeyType kt = KeyType.MEMIDNUM;
    if(identifiers.length == 2)
    {
      memHead.setSrcCode(identifiers[0]);
      memHead.setMemIdnum(identifiers[1]);
    } else
    {
      memHead.setMemRecno(Long.parseLong(identifiers[0]));
      kt = KeyType.MEMRECNO;
    }
    inpMemRows.addRow(memHead);
    // We only need MemHead rows to get the entRecno
    memGet.setSegCodeFilter("MEMHEAD,ENTXTSK");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);
    memGet.setMemType("PERSON");
    memGet.setEntType("id");
    boolean status = memGet.execute(inpMemRows, outMemRows, GetType.ASMEMBER, kt);
    if (status)
    {
    	entXtsk = ExRowWork.getEntXtsk(outMemRows);
    }
    else
    {
      disconnect();
      ixnError("The " + intrName + " interaction failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }
    return entXtsk;
  }
}
