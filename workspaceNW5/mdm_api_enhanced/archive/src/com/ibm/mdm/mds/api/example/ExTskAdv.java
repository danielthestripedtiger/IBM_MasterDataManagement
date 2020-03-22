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

import madison.mpi.EntXtsk;
import madison.mpi.GetType;
import madison.mpi.IxnMemDrop;
import madison.mpi.IxnMemGet;
import madison.mpi.IxnMemMerge;
import madison.mpi.IxnMemPut;
import madison.mpi.IxnTskGet;
import madison.mpi.IxnTskPut;
import madison.mpi.KeyType;
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.mpi.Row;
import madison.mpi.RowInd;
import madison.mpi.RowIterator;
import madison.mpi.TskStat;
import madison.mpi.TskType;

/**
 * This example illustrates the use of a few interactions in unison to resolve
 * the following three situations:<BR>
 * 1. Resolve a potential linkage task (resolvePL()) <BR>
 * 2. Resolve a potential duplicate task (resolvePD()) <BR>
 * 3. Link two entities without having a PL task to start with
 * (linkTwoMembersViaTask())<BR>
 * We will first have to create these situations, and we are going to do so in
 * the setUpMembers() method. <BR>
 * In order for this example to be re-executable we are going to clean up all of
 * the members we created in the tearDownMembers() method.
 */
public class ExTskAdv extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  public static void main(String[] args) throws Exception
  {
    // Two members will be created, and here we are setting up the UsrHead
    // objects for them.
    MemHead memHead1 = new MemHead();
    MemHead memHead2 = new MemHead();
    MemHead memHead3 = new MemHead();
    MemHead memHead4 = new MemHead();
    memHead1.setSrcCode("RHN");
    memHead1.setMemIdnum("555555555");
    memHead2.setSrcCode("RHN");
    memHead2.setMemIdnum("666666666");
    memHead3.setSrcCode("RHN");
    memHead3.setMemIdnum("444444444");
    memHead4.setSrcCode("RMC");
    memHead4.setMemIdnum("111111111");
    setUpMember1(memHead1);
    setUpMember2(memHead2);
    // member3 and member4 are going to be almost identical, with only the
    // SrcCode and IdNum differing between the two.
    setUpMembers3and4(memHead3);
    setUpMembers3and4(memHead4);

    info("Wating to allow Entity Managers to create tasks.");

    waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());
    waitForQueues(memHead2.getSrcCode(), memHead2.getMemIdnum());
    waitForQueues(memHead3.getSrcCode(), memHead3.getMemIdnum());
    waitForQueues(memHead4.getSrcCode(), memHead4.getMemIdnum());

    // Let us resolve the Potential Linkage task that resulted
    // from IxnMemPut of member3 and member4
    resolvePL(memHead3, "hh");

    // Let us resolve the Potential Duplicate task that was created
    // as a result of our IxnMemPut between member1 and member2.
    resolvePD(memHead1, "id");

    // Assign two members to the same EID when they are not even currently
    // in a task together.
    linkTwoMembersViaTask(memHead1, memHead4, "id");

    // Now we will clean up the members we have created so that we can run the
    // example again with no errors.
    tearDownMembers(memHead1);
    tearDownMembers(memHead2);
    tearDownMembers(memHead3);
    tearDownMembers(memHead4);
    info("This example has finished it's execution.");
  }

  /**
   * We are going to resolve the Potential Linkage task. As a result of this
   * resolution the two members will end up having the same entRecno.
   *
   * @param memHead
   *          MemHead
   * @param entType
   *          String entity type
   * @throws Exception
   *           if the interactions fails or one of the setters throws a
   *           SetterException.
   */
  private static void resolvePL(MemHead memHead, String entType) throws Exception
  {
    // Create the interaction object.
    IxnTskPut tskPut = new IxnTskPut(getContext());
    // Create a member rowlist to hold input member row(s).
    MemRowList inpMemList = new MemRowList();

    MemRowList taskGetList = getTasks(memHead, entType, "Potential Linkage");

    // Note that there are 2 MemHead rows and 2 EntXtsk rows returned.
    // First let us find the first MemHead in the returned RowList
    MemHead head = null;
    RowIterator itr = taskGetList.rows();
    while(itr.hasMoreRows())
    {
      Row currentRow = itr.nextRow();
      if(currentRow instanceof MemHead)
      {
        head = (MemHead) currentRow;
        break;
      }
    }
    // We are going to spin through the rows, looking for the
    // entRecno of the members.
    // We will also illustrate the ability to get rows by index.
    TskStat taskStat = getDicStore().getTskStatByCode("Resolved");
    for(int x = 0; x < taskGetList.size(); x++)
    {
    	if(taskGetList.rowAt(x) instanceof EntXtsk)
    	{
    		EntXtsk entXtsk = (EntXtsk) taskGetList.rowAt(x);
    		entXtsk.setRowInd(RowInd.UPDATE);
    		entXtsk.setTskStat(taskStat);
    		if(entXtsk.getEntRecno() != head.getEntRecnos()[0])
    		{
    			entXtsk.setSupEntRecno(head.getEntRecnos()[0]);
    		}
    		inpMemList.addRow(entXtsk);
    	}
    }
    
    // We are resolving entity level task, so EntType is not optional.
    tskPut.setEntType(entType);

    // The use of PutType.UPDATE_ONLY ensures that the interaction would fail if
    // the task did not already exist.
    // If PutType.INSERT_UPDATE is used the task row would be inserted if it
    // does not exist.
    boolean status = tskPut.execute(inpMemList, PutType.INSERT_UPDATE);
    if (!status)
    {
      ixnError("The IxnTskPut inside ExTskAdv failed.", tskPut.getErrCode().toString(), tskPut.getErrText());
    }
  }

  /**
   * This method will illustrate one way of handling a Potential Duplicate task.
   * We are going to get tasks based on the srcCode:memIdnum and merge the
   * members in question. By merging the members we get rid of the task.
   */
  private static void resolvePD(MemHead memHead, String entType) throws Exception
  {
    // Similar to resolvePL first we get the tasks:
    MemRowList taskGetList = getTasks(memHead, entType, "Potential Duplicate");
    // Note that 2 EntXtsk rows are returned in addition
    // to the 2 MemHead rows.
    MemHead memHeadSurvivor = (MemHead) taskGetList.rowAt(0);
    MemHead memHeadObsolete = (MemHead) taskGetList.rowAt(1);

    // One of the way a PD task is resolved is by merging the two members in
    // question. We are going to do just that. This will result in the task
    // being resolved.
    IxnMemMerge memMerge = new IxnMemMerge(getContext());
    boolean status = memMerge.execute(memHeadSurvivor, memHeadObsolete);
    if (!status)
      ixnError("The IxnMemMerge inside ExTskAdv failed.", memMerge.getErrCode().toString(), memMerge.getErrText());
  }

  /**
   * This method will assign the same EID to two different members via an
   * IxnTskPut. The two members in question do not currently have a Potential
   * Linkage task.
   *
   * @param memHead1
   * @param memHead2
   * @param entType
   * @throws Exception
   *           if the interaction fails or one of the setters throws a
   *           SetterException.
   */
  private static void linkTwoMembersViaTask(MemHead memHead1, MemHead memHead2, String entType) throws Exception
  {
    // Create the interaction object.
    IxnTskPut tskPut = new IxnTskPut(getContext());
    tskPut.setEntType(entType);
    // Create a member rowlist to hold input member row(s).
    MemRowList inpMemList = new MemRowList();

    // Create an EntXtsk object
    EntXtsk entXtsk = new EntXtsk();

    // Setting the SupEntRecno to the task target's EntRecno
    entXtsk.setSupEntRecno(getEntRecno(memHead2, entType));
    // Setting the EntRecno to the task object's EntRecno
    entXtsk.setEntRecno(getEntRecno(memHead1, entType));
    // Setting the MemRecno to the task object's MemRecno
    entXtsk.setMemRecno(getMemRecno(memHead1));
    // We can use the DicStore to obtain the TaskType by name.
    // mpi_tsktype table contains the TaskType values.
    TskType taskType = getDicStore().getTskTypeByCode("Potential Linkage");
    entXtsk.setTskType(taskType);
    // 2 - Resolved from mpi_tskstat table
    entXtsk.setTskStatno(2);
    // We must ste the SrcCode.
    entXtsk.setSrcCode(memHead1.getSrcCode());
    // And the login of the user to whom the task is to be assigned.
    entXtsk.setOwnerName(getUsrHead().getUsrLogin());
    // We also have to set the OwnerType (U-user G-group)
    entXtsk.setOwnerType("U");
    // Entity Type is required as well, since we are linking two entities.
    entXtsk.setEntType(entType);

    // We are inserting this row (one does not exist in MDE DB)
    entXtsk.setRowInd(RowInd.INSERT);
    // Adding our newly created task row to the input row list
    inpMemList.addRow(entXtsk);

    // We are using PutType.INSERT_ONLY because we are creating the task
    // and not resolving one.
    boolean status = tskPut.execute(inpMemList, PutType.INSERT_ONLY);
    if (!status)
      ixnError("The IxnTskPut inside ExTskAdv.linkTwoMembersViaTask() failed.", tskPut.getErrCode().toString(), tskPut.getErrText());
  }

  /**
   * This helper method gets all of the EntXtsk rows for a specific entity type,
   * member, and task type.
   *
   * @param memHead
   *          MemHead
   * @param entType
   * @param taskType
   * @return a MemRowList as returned by the IxnTskGet interaction.
   * @throws Exception
   *           if the interaction fails.
   */
  private static MemRowList getTasks(MemHead memHead, String entType, String taskType) throws Exception
  {
    // For details of the IxnTskGet interaction see the API
    // documentation and the ExTskGet example.
    IxnTskGet tskGet = new IxnTskGet(getContext());
    MemRowList inList = new MemRowList();
    MemRowList outList = new MemRowList();
    inList.addRow(memHead);
    tskGet.setEntType(entType);
    tskGet.setSegCodeFilter("MEMHEAD,ENTXTSK");
    tskGet.setRecStatFilter("A");
    EntXtsk entXtsk = new EntXtsk();
    entXtsk.setTskType(getDicStore().getTskTypeByCode(taskType));
    entXtsk.setMaxScore((short) 99);
    inList.addRow(entXtsk);
    boolean status = tskGet.execute(null, inList, outList, GetType.ASMEMBER, KeyType.MEMIDNUM);
    if (!status)
    {
      ixnError("The IxnTskGet inside ExTskAdv failed.", tskGet.getErrCode().toString(), tskGet.getErrText());
    }
    return outList;
  }

  /**
   * This method will create a member that will be used in a Potential Duplicate
   * tasks.
   *
   * @param memHead
   *          MemHead
   * @throws Exception
   *           if the interaction does not succeed or one of the setters throws
   *           a SetterException.
   */
  private static void setUpMember1(MemHead memHead) throws Exception
  {
    IxnMemPut memPut = new IxnMemPut(getContext());
    MemRowList inpMemList = new MemRowList();
    MemRowList outMemList = new MemRowList();

    MemAttrRow memDate1 = getDicStore().createMemAttrRowByName("Birth Date", memHead);
    memDate1.setString("dateVal", "1955-09-31");
    MemAttrRow memAttr1 = getDicStore().createMemAttrRowByCode("SEX", memHead);
    memAttr1.setString("attrVal", "F");
    MemAttrRow memName1 = getDicStore().createMemAttrRowByCode("LGLNAME", memHead);
    memName1.setString("onmFirst", "Sergent");
    memName1.setString("onmLast", "Stadenko");
    MemAttrRow memAddr1 = getDicStore().createMemAttrRowByCode("HOMEADDR", memHead);
    memAddr1.setString("stline1", "420 Stadekno Rd.");
    memAddr1.setString("stline2", "Apt# 420");
    memAddr1.setString("city", "New York");
    memAddr1.setString("state", "NY");
    memAddr1.setString("zipcode", "11375");
    MemAttrRow memPhone1 = getDicStore().createMemAttrRowByCode("HOMEPHON", memHead);
    memPhone1.setString("pharea", "718");
    memPhone1.setString("phnumber", "3216547");
    MemAttrRow memWorkPhone1 = getDicStore().createMemAttrRowByCode("WORKPHON", memHead);
    memWorkPhone1.setString("pharea", "212");
    memWorkPhone1.setString("phnumber", "6543211");
    inpMemList.addRow(memHead);
    inpMemList.addRow(memDate1);
    inpMemList.addRow(memAttr1);
    inpMemList.addRow(memName1);
    inpMemList.addRow(memAddr1);
    inpMemList.addRow(memPhone1);
    inpMemList.addRow(memWorkPhone1);

    // Consult the API documentation and other examples for details on
    // IxnMemPut.
    boolean status = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.COMPLETE, MatchMode.IMMEDIATE);
    if (!status)
    {
      disconnect();
      ixnError("The IxnMemPutBulk inside the ExTskAdv failed.", memPut.getErrCode().toString(), memPut.getErrText());
    }
  }

  /**
   * This method will create a member that will result in a Potential Duplicate
   * tasks.
   *
   * @param memHead
   *          MemHead
   * @throws Exception
   *           if the interaction does not succeed or one of the setters throws
   *           a SetterException.
   */
  private static void setUpMember2(MemHead memHead) throws Exception
  {
    IxnMemPut memPut = new IxnMemPut(getContext());
    MemRowList inpMemList = new MemRowList();
    MemRowList outMemList = new MemRowList();

    MemAttrRow memDate2 = getDicStore().createMemAttrRowByName("Birth Date", memHead);
    memDate2.setString("dateVal", "1955-09-30");
    MemAttrRow memAttr2 = getDicStore().createMemAttrRowByCode("SEX", memHead);
    memAttr2.setString("attrVal", "F");
    MemAttrRow memName2 = getDicStore().createMemAttrRowByCode("LGLNAME", memHead);
    memName2.setString("onmFirst", "Sergent");
    memName2.setString("onmLast", "Stadenko");
    MemAttrRow memAddr2 = getDicStore().createMemAttrRowByCode("HOMEADDR", memHead);
    memAddr2.setString("stline1", "420 Stadekno Rd.");
    memAddr2.setString("city", "New York");
    memAddr2.setString("state", "NY");
    memAddr2.setString("zipcode", "11375");
    MemAttrRow memPhone2 = getDicStore().createMemAttrRowByCode("HOMEPHON", memHead);
    memPhone2.setString("pharea", "718");
    memPhone2.setString("phnumber", "9876541");
    MemAttrRow memWorkPhone2 = getDicStore().createMemAttrRowByCode("WORKPHON", memHead);
    memWorkPhone2.setString("pharea", "212");
    memWorkPhone2.setString("phnumber", "6543210");
    inpMemList.addRow(memHead);
    inpMemList.addRow(memDate2);
    inpMemList.addRow(memAttr2);
    inpMemList.addRow(memName2);
    inpMemList.addRow(memAddr2);
    inpMemList.addRow(memPhone2);
    inpMemList.addRow(memWorkPhone2);
    // Consult the API documentation and other examples for details on
    // IxnMemPut.
    boolean status = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.COMPLETE, MatchMode.IMMEDIATE);
    if (!status)
    {
      disconnect();
      ixnError("The IxnMemPutBulk inside the ExTskAdv failed.", memPut.getErrCode().toString(), memPut.getErrText());
    }
  }

  /**
   * This method will create a member that will result in a Potential Linkage
   * task.
   *
   * @param memHead
   *          MemHead
   * @throws Exception
   *           if the interaction does not succeed or one of the setters throws
   *           a SetterException.
   */
  private static void setUpMembers3and4(MemHead memHead) throws Exception
  {
    IxnMemPut memPut = new IxnMemPut(getContext());
    MemRowList inpMemList = new MemRowList();
    MemRowList outMemList = new MemRowList();

    MemAttrRow memDate3 = getDicStore().createMemAttrRowByName("Birth Date", memHead);
    memDate3.setString("dateVal", "1984-10-20");
    MemAttrRow memAttr3 = getDicStore().createMemAttrRowByCode("SEX", memHead);
    memAttr3.setString("attrVal", "M");
    MemAttrRow raceAttr3 = getDicStore().createMemAttrRowByCode("RACE", memHead);
    raceAttr3.setString("attrVal", "01");
    MemAttrRow memName3 = getDicStore().createMemAttrRowByCode("LGLNAME", memHead);
    memName3.setString("onmFirst", "Eric");
    memName3.setString("onmMiddle", "J");
    memName3.setString("onmLast", "Robinson");
    MemAttrRow memAddr3 = getDicStore().createMemAttrRowByCode("HOMEADDR", memHead);
    memAddr3.setString("stline1", "111 Main Street.");
    memAddr3.setString("stline2", "Apt # 222");
    memAddr3.setString("city", "New York");
    memAddr3.setString("state", "NY");
    memAddr3.setString("zipcode", "11375");
    inpMemList.addRow(memHead);
    inpMemList.addRow(memDate3);
    inpMemList.addRow(memAttr3);
    inpMemList.addRow(raceAttr3);
    inpMemList.addRow(memName3);
    inpMemList.addRow(memAddr3);
    // Consult the API documentation and other examples for details on
    // IxnMemPut.
    boolean status = memPut.execute(inpMemList, outMemList, PutType.INSERT_UPDATE, MemMode.COMPLETE, MatchMode.IMMEDIATE);
    if (!status)
    {
      disconnect();
      ixnError("The IxnmemPut inside the ExTskAdv failed.", memPut.getErrCode().toString(), memPut.getErrText());
    }
  }

  /**
   * This helper method will get a MemRecno for a specific member.
   *
   * @param memHead
   *          MemHead
   * @return long MemRecno for a given member
   * @throws Exception
   *           if the interaction fails.
   */
  private static long getMemRecno(MemHead memHead) throws Exception
  {
    long memRecno = 0;
    IxnMemGet memGet = new IxnMemGet(getContext());
    MemRowList inpMemRows = new MemRowList();
    MemRowList outputMemRows = new MemRowList();
    inpMemRows.addRow(memHead);
    memGet.setSegCodeFilter("MEMHEAD");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);
    boolean status = memGet.execute(inpMemRows, outputMemRows, GetType.ASMEMBER, KeyType.MEMIDNUM);
    if (!status)
    {
      disconnect();
      ixnError("The IxnMemGet inside the ExTskAdv failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }
    MemHead head = (MemHead) outputMemRows.rowAt(0);
    memRecno = head.getMemRecno();
    return memRecno;
  }

  /**
   * This helper method will get a MemRecno for a specific member.
   *
   * @param memHead
   *          MemHead
   * @param ent
   *          String representing the Entity Type.
   * @return long EntRecno for a given member
   * @throws Exception
   *           if the interaction fails.
   */
  private static long getEntRecno(MemHead memHead, String ent) throws Exception
  {
    // For more on IxnMemGet usage please see the ExMemGet example
    // and API documentation.
    long entRecno = 0;
    IxnMemGet memGet = new IxnMemGet(getContext());
    MemRowList inpMemRows = new MemRowList();
    MemRowList outputMemRows = new MemRowList();
    inpMemRows.addRow(memHead);
    memGet.setSegCodeFilter("MEMHEAD");
    memGet.setRecStatFilter(Row.m_RECSTAT_A);
    memGet.setEntType(ent);
    boolean status = memGet.execute(inpMemRows, outputMemRows, GetType.ASENTITY, KeyType.MEMIDNUM);
    if (!status)
    {
      disconnect();
      ixnError("The IxnMemGet inside the ExTskAdv failed.", memGet.getErrCode().toString(), memGet.getErrText());
    }
    MemHead head = (MemHead) outputMemRows.rowAt(0);
    entRecno = head.getEntRecnos()[0];
    return entRecno;
  }

  /**
   * This method will drop the members that we used in this example.
   *
   * @param memHead1
   *          MemHead
   * @throws Exception
   *           if the interaction does not succeed or one of the setters throws
   *           a SetterException.
   */
  private static void tearDownMembers(MemHead memHead) throws Exception
  {
    waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());
    // Consult the ExMemDrop example for comments on how to work
    // with the IxnMemDrop interaction.
    IxnMemDrop memDrop = new IxnMemDrop(getContext());
    MemRowList inpMemRows = new MemRowList();
    inpMemRows.addRow(memHead);
    boolean status = memDrop.execute(inpMemRows, KeyType.MEMIDNUM);
    if (!status)
    {
      disconnect();
      ixnError("The IxnMemDrop insode the ExTskAdv failed.", memDrop.getErrCode().toString(), memDrop.getErrText());
    }
  }
}
