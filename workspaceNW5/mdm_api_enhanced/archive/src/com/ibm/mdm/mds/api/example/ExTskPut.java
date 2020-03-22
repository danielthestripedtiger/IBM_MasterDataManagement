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

import madison.mpi.DicRowList;
import madison.mpi.EntXtsk;
import madison.mpi.GetType;
import madison.mpi.IxnDicGet;
import madison.mpi.IxnMemDrop;
import madison.mpi.IxnMemGet;
import madison.mpi.IxnMemPut;
import madison.mpi.IxnTskPut;
import madison.mpi.KeyType;
import madison.mpi.MatchMode;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.mpi.Row;
import madison.mpi.RowInd;
import madison.mpi.RowIterator;
import madison.mpi.TskStat;
import madison.mpi.TskType;
import madison.mpi.UsrHead;
import madison.util.ClassTest;

/**
 * This example illustrates the IxnTskPut interaction This interaction is used
 * to insert/update tasks in the database. Note that there is no logic or
 * suggestion that a task is required for this particular pair of members. This
 * example just illustrates how to create a task and NOT the logic deciding that
 * the task has to be created.
 */
public class ExTskPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnTskPut";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnTskPut tskPut = new IxnTskPut(getContext());

    // Create member RowList to hold input rows.
    MemRowList tskRL = new MemRowList();

    // Task Types are described in the mpi_tsktype table.
    TskType taskType = getDicStore().getTskTypeByCode("Potential Linkage");
    // We can always see all of the defined task types:
    // DicRowList drl = getDicStore().getTskTypeList();

    // taskStat can also be gotten via DicStore:
	TskStat taskStat = getDicStore().getTskStatByCode("Resolved");

    // Create a MemHead object.
    MemHead memHead1 = new MemHead();
    memHead1.setMemIdnum("987654321");
    memHead1.setSrcCode("OUTP");
    MemHead memHead2 = new MemHead();
    memHead2.setMemIdnum("654321987");
    memHead2.setSrcCode("OUTP");

    // Setting up two members so we can put tasks against them.
    setUpTwoMembers(memHead1, memHead2);

    // Normally you would do a MemGet to get the MemHeads of the
    // members for which you want to create a Task.

    String entType = "id";

    EntXtsk entXtsk = new EntXtsk(memHead1);
    entXtsk.setMemRecno(getMemRecno(memHead1));
    entXtsk.setEntRecno(getEntRecno(memHead1, entType));
    entXtsk.setSupEntRecno(getEntRecno(memHead2, entType));
    entXtsk.setTskType(taskType);
    entXtsk.setTskStat(taskStat);
    entXtsk.setEntType(entType);
    entXtsk.setRowInd(RowInd.INSERT);
    entXtsk.setOwnerType("U");
    entXtsk.setPrevOwnerType("N");
    entXtsk.setPrevOwnerRecno(0);
    entXtsk.setUsrRecno(getPopulatedUsrHead());
    entXtsk.setSrcCode(memHead1.getSrcCode());

    tskRL.addRow(entXtsk);

    tskPut.setEntType(entType);
    boolean status = tskPut.execute(tskRL, PutType.INSERT_ONLY);
    if (status)
    {
      info("The " + intrName + " interaction worked.");
    }
    else
    {
      ixnError("The " + intrName + " interaction failed.", tskPut.getErrCode().toString(), tskPut.getErrText());
    }
    waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());

    // Now we will unlink a member from the pair we just linked.
    info("Current entRecno for the " + memHead1.getSrcCode() + ":" + memHead1.getMemIdnum() + " is " + getEntRecno(memHead1, entType));
    info("Current entRecno for the " + memHead2.getSrcCode() + ":" + memHead2.getMemIdnum() + " is " + getEntRecno(memHead2, entType));

    // Create the interaction object.
    tskPut = new IxnTskPut(getContext());

    // Create RowList to hold input rows.
    tskRL = new MemRowList();

    entXtsk = new EntXtsk(memHead1);
    entXtsk.setMemRecno(getMemRecno(memHead1));
    entXtsk.setEntRecno(getEntRecno(memHead1, entType));
    // Setting the SupEntRecno to the memHead1.generateNextBigRecno()
    // will cause the HUB to unlink the member.
    entXtsk.setSupEntRecno(memHead1.generateNextBigRecno());
    entXtsk.setTskType(taskType);       // Potential Linkage
    entXtsk.setTskStat(taskStat);       // Resolved
    entXtsk.setEntType(entType);        // EntType is required
    entXtsk.setRowInd(RowInd.INSERT);   // New task, so it's an INSERT
    entXtsk.setOwnerType("U");          // Task owner is set to U (User).
    entXtsk.setPrevOwnerType("N");      // Previous Owner Type is N (since this is a new task).
    entXtsk.setPrevOwnerRecno(0);       // New task, so previous owner is 0.
    // We need to get the UsrHead from the Dictionary
    // so the UsrRecno is populated.
    entXtsk.setUsrRecno(getPopulatedUsrHead());
    // SrcCode is set.
    entXtsk.setSrcCode(memHead1.getSrcCode());

    // Adding the newly created EntXTsk row to the
    // input row list.
    tskRL.addRow(entXtsk);

    // The tskPut interaction requires an EntType.
    tskPut.setEntType(entType);

    status = tskPut.execute(tskRL, PutType.INSERT_ONLY);
    if (status)
    {
      info("The " + intrName + " interaction worked.");
    }
    else
    {
      ixnError("The " + intrName + " interaction failed.", tskPut.getErrCode().toString(), tskPut.getErrText());
    }
    waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());

    info("New entRecno for the " + memHead1.getSrcCode() + ":" + memHead1.getMemIdnum() + " is " + getEntRecno(memHead1, entType));
    info("New entRecno for the " + memHead2.getSrcCode() + ":" + memHead2.getMemIdnum() + " is " + getEntRecno(memHead2, entType));

    // Deleting the members used in this example so the example can be re-ran.
    cleanUpMembers(memHead1, memHead2);

    // Disconnect from Master Data Engine server
    disconnect();
  }

  /**
   * This method will set up two members. These members will be used to
   * illustrate the IxnTskPut in this example.
   *
   * @param memHead1
   *          MemHead
   * @param memHead2
   *          MemHead
   * @throws Exception
   *           if the interaction fails.
   */
  private static void setUpTwoMembers(MemHead memHead1, MemHead memHead2) throws Exception
  {
    // See the ExMemPut for detailed information on IxnMemPut usage.
    IxnMemPut memPut = new IxnMemPut(getContext());
    MemRowList inputRows = new MemRowList();
    inputRows.addRow(memHead1);
    boolean status = memPut.execute(inputRows, PutType.INSERT_UPDATE, MemMode.COMPLETE, MatchMode.IMMEDIATE);
    if (!status)
    {
      disconnect();
      ixnError("The memPut interaction inside of the ExTskPut failed.", memPut.getErrCode().toString(), memPut.getErrText());
    }
    inputRows = new MemRowList();
    inputRows.addRow(memHead2);
    status = memPut.execute(inputRows, PutType.INSERT_UPDATE, MemMode.COMPLETE, MatchMode.IMMEDIATE);
    if (!status)
    {
      disconnect();
      ixnError("The memPut interaction inside of the ExTskPut failed.", memPut.getErrCode().toString(), memPut.getErrText());
    }
    waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());
    waitForQueues(memHead2.getSrcCode(), memHead2.getMemIdnum());
  }

 /**
  * This method gets the EntRecno for a specific member and entity type
  * combination.
  *
  * @param memHead
  *            MemHead
  * @param entType
  *            String entity type
  * @return the EntRecno
  * @throws Exception
  */
  private static long getEntRecno(MemHead memHead, String entType) throws Exception
  {
    long entRecno = 0L;
    IxnMemGet memGet = new IxnMemGet(getContext());
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    inpMemRows.addRow(memHead);
    memGet.setSegCodeFilter("MEMHEAD");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);
    memGet.setMemType("PERSON");
    memGet.setEntType(entType);
    boolean status = memGet.execute(inpMemRows, outMemRows, GetType.ASENTITY, KeyType.MEMIDNUM);
    if (status)
    {
      entRecno = ExRowWork.getEntRecno(outMemRows);
    } else
    {
      ixnError("The IxnMemGet interaction failed. ", memGet.getErrCode().toString(), memGet.getErrText());
	}
	return entRecno;
  }

 /**
  * This method performs an IxnDicGet to populate a UsrHead object.
  *
  * @return UsrHead
  * @throws Exception
  */
  private static UsrHead getPopulatedUsrHead() throws Exception
  {
    IxnDicGet dicGet = new IxnDicGet(getContext());
    DicRowList outputRows = new DicRowList();
    dicGet.setSegCodeFilter("USRHEAD");
    dicGet.setRecStatFilter(Row.m_RECSTAT_A);
    boolean status = dicGet.execute(outputRows);
    if (!status)
    {
      ixnError("The IxnDicget interaction failed.", dicGet.getErrCode().toString(), dicGet.getErrText());
    }
    RowIterator ri = outputRows.rows(new ClassTest("UsrHead"));
    while (ri.hasMoreRows())
    {
      UsrHead uh = (UsrHead) ri.nextRow();
      if (uh.getUsrLogin().equalsIgnoreCase(getUsrHead().getUsrLogin()))
        return uh;
    }
    return null;
  }

  /**
   * This method will drop the two members we had created in the
   * setUpTwoMembers() call.
   *
   * @param memHead1
   *          MemHead
   * @param memHead2
   *          memHead
   * @throws Exception
   *           if the interaction fails.
   */
  private static void cleanUpMembers(MemHead memHead1, MemHead memHead2) throws Exception
  {
    waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());
    waitForQueues(memHead2.getSrcCode(), memHead2.getMemIdnum());
    // See the ExMemDrop for detailed information on IxnMemDrp usage.
    IxnMemDrop memDrop = new IxnMemDrop(getContext());
    MemRowList inputList = new MemRowList();
    inputList.addRow(memHead1);
    boolean status = memDrop.execute(inputList, KeyType.MEMIDNUM);
    if(!status)
    {
      disconnect();
      ixnError("The memDrop interaction inside of the ExTskPut failed.", memDrop.getErrCode().toString(), memDrop.getErrText());
    }
    inputList = new MemRowList();
    inputList.addRow(memHead2);
    status = memDrop.execute(inputList, KeyType.MEMIDNUM);
    if(!status)
    {
      disconnect();
      ixnError("The memDrop interaction inside of the ExTskPut failed.", memDrop.getErrCode().toString(), memDrop.getErrText());
    }
  }

  /**
   * This method will return a memRecno for a specific SrcCode:MemIdnum pair.
   *
   * @param memHead
   *          MemHead
   * @return long the memRecno for the memHead
   * @throws Exception
   *           if the interaction fails.
   */
  private static long getMemRecno(MemHead memHead) throws Exception
  {
    // See the ExMemGet for detailed information on IxnMemGet usage.
    long memRecno = 0L;
    IxnMemGet memGet = new IxnMemGet(getContext());
    MemRowList inpMemRows = new MemRowList();
    MemRowList outMemRows = new MemRowList();
    KeyType kt = KeyType.MEMIDNUM;
    inpMemRows.addRow(memHead);
    memGet.setSegCodeFilter("MEMHEAD");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);
    memGet.setMemType("PERSON");
    memGet.setEntType("id");
    boolean status = memGet.execute(inpMemRows, outMemRows, GetType.ASMEMBER, kt);
    if (status)
      memRecno = outMemRows.rowAt(0).getMemRecno();
    else
    {
      disconnect();
      ixnError("The memGet interaction inside of the ExTskPut failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }
    return memRecno;
  }
}
