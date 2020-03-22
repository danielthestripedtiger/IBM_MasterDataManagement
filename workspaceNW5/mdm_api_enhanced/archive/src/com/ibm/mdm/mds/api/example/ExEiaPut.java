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
import madison.mpi.IxnEiaPut;
import madison.mpi.KeyType;
import madison.mpi.MemHead;
import madison.mpi.MemRowList;
import madison.mpi.MemXeia;
import madison.mpi.PutType;
import madison.mpi.RowInd;
import madison.mpi.RowIterator;
import madison.util.ClassTest;

/**
 * This example illustrates the IxnEiaPut interaction. We will re-use the code
 * that we covered in the example ExEiaGet during the execution. When tasks are
 * resolved the engine inserts rows into the Eia tables to represent the action
 * the user performed.
 *
 * In order for the rows we are looking for to be in place you must run the
 * ExMemDelete and ExMemUndelete. These two examples will create two Eia rows:
 * one for the delete we performed, and one for the undelete.
 */
public class ExEiaPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnEiaPut";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnEiaPut eiaPut = new IxnEiaPut(getContext());

    // Get the MemExeia records into the MemRowList.
    // This we covered the IxnEiaGet interaction in the ExEiaGet. We are going
    // to do a very similar EiaGet in this example in it's own method:
    MemRowList eiaRowList = doEiaGet();

    // Create member rowlist to hold input rows.
    MemRowList eiaInputRowList = new MemRowList();

    // Create a ClassTest object to use as a filter
    // to allow only MemXeia rows when obtaining a RowIterator
    ClassTest memXeiaTest = null;
    String className = "madison.mpi.MemXeia";
    try
    {
      memXeiaTest = new ClassTest(className);
    } catch (Exception e)
    {
      err("Unable to create a ClassTest for class " + className + " underlying exception: " + e.getMessage());
    }

    // Get a RowIterator using a classTest of memXeia.
    // Traverse through the RowList to get the MemXEia rows and update each record.
    RowIterator memXeiaIter = eiaRowList.rows(memXeiaTest);
    while (memXeiaIter.hasMoreRows())
    {
      MemXeia memXeia = (MemXeia) memXeiaIter.nextRow();

      if (memXeia.getEiaType().equalsIgnoreCase("Delete"))
      {
        memXeia.setEiaStatno(2); //mark as examined-OK
      }

      // Mark all EIA task data for Update even if this member
      // may have other rows that we did not update.
      // (were not a 'Delete'd row)
      memXeia.setTskTypeno(2); //Potential Duplicate
      memXeia.setTskStatno(3); //Deferred
      memXeia.setRowInd(RowInd.UPDATE);

      eiaInputRowList.addRow(memXeia);
    }

    // Execute the interaction. After the execution you can run the ExEiaGet
    // example again, and you should see the changes we just made in the output.
    boolean status = eiaPut.execute(eiaInputRowList, PutType.UPDATE_ONLY);
    if (status)
      info("The " + intrName + " interaction worked.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", eiaPut.getErrCode().toString(), eiaPut.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }

  /**
   * This method mimics the work we did in example ExEiaGet.
   *
   * @return MemRowList
   * @throws Exception
   *           if there was a connection problem.
   */
  private static MemRowList doEiaGet() throws Exception
  {
    IxnEiaGet eiaGet = new IxnEiaGet(getContext());

    // Create member rowlists to hold input.
    MemRowList eiaRowList = new MemRowList();

    // Create a member rowlist to hold output row(s)
    MemRowList eiaOutRowList = new MemRowList();

    // Create a MemHead object.
    MemHead memHead = new MemHead();
    memHead.setSrcCode("OUTP");
    memHead.setMemIdnum("567677");
    eiaRowList.addRow(memHead);

    // Set a segment code filter to limit output to specific segments.
    eiaGet.setSegCodeFilter("MEMHEAD,MEMXEIA,ENTXEIA");

    // Set entity type as Identity (id)
    eiaGet.setEntType("id");

    // Set the record status indicators desired.
    eiaGet.setRecStatFilter("A");

    // Execute the interaction.
    boolean status = eiaGet.execute(eiaRowList, eiaOutRowList, GetType.ASMEMBER, KeyType.MEMIDNUM);
    if (status)
    {
      info("IxnEiaGet worked and returned " + eiaOutRowList.size() + " rows.");
      return eiaOutRowList;
    } else
    {
      // Disconnect from the Master Data Engine.
      disconnect();
      ixnError("The IxnEiaGet interaction failed.", eiaGet.getErrCode().toString(), eiaGet.getErrText());
      return eiaOutRowList;
    }
  }
}
