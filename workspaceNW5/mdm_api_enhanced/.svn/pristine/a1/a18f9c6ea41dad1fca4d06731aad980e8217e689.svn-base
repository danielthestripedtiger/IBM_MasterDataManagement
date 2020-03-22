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

import madison.mpi.Context;
import madison.mpi.ErrCode;
import madison.mpi.GetType;
import madison.mpi.IxnMemDelete;
import madison.mpi.IxnMemGet;
import madison.mpi.IxnMemMerge;
import madison.mpi.IxnMemPut;
import madison.mpi.IxnMemUndo;
import madison.mpi.KeyType;
import madison.mpi.MatchMode;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemMode;
import madison.mpi.MemRow;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.util.SetterException;

/**
 * This example illustrates the use of IxnMemUndo to undo transactions
 * by IxnMemDelete, IxnMemMerge and IxnMemPut. Transactions completed via
 * IxnMemPutBulk and IxnMemPutQual can be undone similarly to the example
 * shown with IxnMemPut.
 */
public class ExMemUndo extends BaseExample {
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String SRCCODE = "RMC";
	private static final String MEMIDNUM1 = "MEMUNDO12";
	private static final String MEMIDNUM2 = "MEMUNDO34";
	private static final String MEMIDNUM3 = "MEMUNDO56";
	private static final String MEMIDNUM4 = "MEMUNDO78";
	private Context context;

	public static void main(String[] args) throws Exception {
		new ExMemUndo().runExample();
	}

	/**
	 * This method runs the example functions.
	 * @throws Exception
	 */
	private void runExample() throws Exception {
		try {
			context = getContext();
			executeMemUndoMemDeleteExample();
			executeMemUndoMemMergeExample();
			executeMemUndoMemPutExample();
		} finally {
			if (context != null) {
				context.disconnect();
				disconnect();
			}
		}
	}

	/**
	 * Example method which illustrates the use of IxnMemUndo for IxnMemDelete. A new
	 * member is added to the system via IxnMemPut which is then logically deleted with
	 * IxnMemDelete. The member is then reverted to an active status after calling
	 * IxnMemUndo which calls IxnMemUndelete. The audRecno returned from IxnMemGet is
	 * used as the basis for instructing IxnMemUndo which member to undelete.
	 * @throws Exception
	 */
	private void executeMemUndoMemDeleteExample() throws Exception {
		info("Starting IxnMemUndo for IxnMemDelete...");

		// Create the example member record.
		MemHead memHead = createMemHead(SRCCODE, MEMIDNUM1);

		// Create name attribute.
		MemAttrRow memName = createMemAttrRow(memHead, "MEMNAME", "LGLNAME");
		setField(memName, "onmFirst", "Twisty");
		setField(memName, "onmLast", "Macaroni");

		// Create phone attribute.
		MemAttrRow memPhone = createMemAttrRow(memHead, "MEMPHONE", "HOMEPHON");
		setField(memPhone, "phNumber", "123-4567");

		// Execute a MEMPUT.
		memHead = executeMemPut(memHead, memName, memPhone);
		info("Added member record srcCode=" + memHead.getSrcCode() + ", memIdnum=" + memHead.getMemIdnum() + ", memStat=" + memHead.getMemStat());

		// Execute a MEMDELETE.
		executeMemDelete(memHead);
		memHead = executeMemGet(memHead);
		info("Deleted member record srcCode=" + memHead.getSrcCode() + ", memIdnum=" + memHead.getMemIdnum() + ", memStat=" + memHead.getMemStat());

		// Execute a MEMUNDO.
		executeMemUndo(memHead);
		memHead = executeMemGet(memHead);
		info("Undo delete for member record srcCode=" + memHead.getSrcCode() + ", memIdnum=" + memHead.getMemIdnum() + ", memStat=" + memHead.getMemStat());

		info("Finished IxnMemUndo for IxnMemDelete...");
	}

	/**
	 * Example method which illustrates the use of IxnMemUndo for IxnMemMerge. Two new
	 * members are added to the system via IxnMemPut. These members are then merged using
	 * IxnMemMerge. The second (obsolete) member is then unmerged after calling IxnMemUndo
	 * which calls IxnMemUnmerge. The audRecno returned from IxnMemGet is used as the basis
	 * for instructing IxnMemUndo which member to unmerge.
	 * @throws Exception
	 */
	private void executeMemUndoMemMergeExample() throws Exception {
		info("Starting IxnMemUndo for IxnMemMerge...");

		// Create the test survivor member record.
		MemHead memHead1 = createMemHead(SRCCODE, MEMIDNUM2);

		// Create survivor name attribute.
		MemAttrRow memName1 = createMemAttrRow(memHead1, "MEMNAME", "LGLNAME");
		setField(memName1, "onmFirst", "Sundried");
		setField(memName1, "onmLast", "Tomato");

		// Create survivor phone attribute.
		MemAttrRow memPhone1 = createMemAttrRow(memHead1, "MEMPHONE", "HOMEPHON");
		setField(memPhone1, "phNumber", "123-4567");

		// Execute MEMPUT for survivor.
		memHead1 = executeMemPut(memHead1, memName1, memPhone1);
		info("Added member record srcCode=" + memHead1.getSrcCode() + ", memIdnum=" + memHead1.getMemIdnum() + ", memStat=" + memHead1.getMemStat());

		// Create the obsolete member record.
		MemHead memHead2 = createMemHead(SRCCODE, MEMIDNUM3);

		// Create the obsolete name attribute.
		MemAttrRow memName2 = createMemAttrRow(memHead2, "MEMNAME", "LGLNAME");
		setField(memName2, "onmFirst", "Sunny");
		setField(memName2, "onmLast", "Tomato");

		// Create the obsolete phone attribute.
		MemAttrRow memPhone2 = createMemAttrRow(memHead2, "MEMPHONE", "HOMEPHON");
		setField(memPhone2, "phNumber", "123-4576");

		// Execute MEMPUT for obsolete.
		memHead2 = executeMemPut(memHead2, memName2, memPhone2);
		info("Added member record srcCode=" + memHead2.getSrcCode() + ", memIdnum=" + memHead2.getMemIdnum() + ", memStat=" + memHead2.getMemStat());

		// Execute a MEMMERGE.
		executeMemMerge(memHead1, memHead2);
		memHead2 = executeMemGet(memHead2);
		info("Merged member record srcCode=" + memHead2.getSrcCode() + ", memIdnum=" + memHead2.getMemIdnum() + ", memStat=" + memHead2.getMemStat());

		// Execute a MEMUNDO.
		executeMemUndo(memHead2);
		memHead2 = executeMemGet(memHead2);
		info("Undo merge for member record srcCode=" + memHead2.getSrcCode() + ", memIdnum=" + memHead2.getMemIdnum() + ", memStat=" + memHead2.getMemStat());

		info("Finished IxnMemUndo for IxnMemMerge...");
	}

	/**
	 * Example method which illustrates the use of IxnMemUndo for IxnMemPut. The
	 * audRecno returned from IxnMemGet is used as the basis for instructing
	 * IxnMemUndo which member to unput.
	 * @throws Exception
	 */
	private void executeMemUndoMemPutExample() throws Exception {
		info("Starting IxnMemUndo for IxnMemPut...");

		// Create the example member record.
		MemHead memHead = createMemHead(SRCCODE, MEMIDNUM4);

		// Create name attribute.
		MemAttrRow memName = createMemAttrRow(memHead, "MEMNAME", "LGLNAME");
		setField(memName, "onmFirst", "Tasty");
		setField(memName, "onmLast", "Freeze");

		// Execute a MEMPUT.
		memHead = executeMemPut(memHead, memName);
		info("Added member record srcCode=" + memHead.getSrcCode() + ", memIdnum=" + memHead.getMemIdnum() + ", memStat=" + memHead.getMemStat());

		// Execute a MEMUNDO.
		executeMemUndo(memHead);
		memHead = executeMemGet(memHead);
		info("No member record should be found after undo operation. memHead=" + memHead);

		info("Finished IxnMemUndo for IxnMemPut...");
	}

	/**
	 * Executes the IxnMemUndo interaction.
	 * @param memHead the member record containing the target audit identifier to undo.
	 * @throws Exception
	 */
	private void executeMemUndo(MemHead memHead) throws Exception {
		executeMemUndo(memHead.getMaudRecno());
	}

	/**
	 * Executes the IxnMemUndo interaction.
	 * @param audRecno the audit record to perform the undo for.
	 * @throws Exception
	 */
	private void executeMemUndo(long audRecno) throws Exception {
		IxnMemUndo ixn = new IxnMemUndo(getContext());
		boolean result = ixn.execute(audRecno);
		if (!result) {
			ixnError("The IxnMemUndo interaction failed.", ixn.getErrCode().toString(), ixn.getErrText());
		}
	}

	/**
	 * Executes the IxnMemPut interaction.
	 * @param memHead the member record to put.
	 * @param memRows the attribute rows to put.
	 * @return the inserted or updated member record instance.
	 * @throws Exception
	 */
	private MemHead executeMemPut(MemRow... memRows) throws Exception {
		MemRowList inputList = createMemRowList(memRows);
		MemRowList outputList = createMemRowList();

		IxnMemPut ixn = new IxnMemPut(context);
		ixn.setEntType("id");
		boolean result = ixn.execute(inputList, outputList, PutType.INSERT_UPDATE, MemMode.PARTIAL, MatchMode.DONOTHING);
		if (!result) {
			ixnError("The IxnMemPut interaction failed.", ixn.getErrCode().toString(), ixn.getErrText());
		}

		MemHead memHead = (MemHead)outputList.rowAt(0);
		waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());
		return memHead;
	}

	/**
	 * Executes the IxnMemDelete interaction.
	 * @param memHead the member record to logically delete.
	 * @throws Exception
	 */
	private void executeMemDelete(MemHead memHead) throws Exception {
		MemRowList inputList = createMemRowList(memHead);
		IxnMemDelete ixn = new IxnMemDelete(context);
		boolean result = ixn.execute(inputList, KeyType.MEMIDNUM);
		if (!result) {
			ixnError("The IxnMemDelete interaction failed.", ixn.getErrCode().toString(), ixn.getErrText());
		}
		waitForQueues(memHead.getSrcCode(), memHead.getMemIdnum());
	}

	/**
	 * Executes the IxnMemMerge interaction.
	 * @param survivor the surviving member record.
	 * @param obsolete the obsolete member record.
	 * @throws Exception
	 */
	private void executeMemMerge(MemHead survivor, MemHead obsolete) throws Exception {
		IxnMemMerge ixn = new IxnMemMerge(context);
		boolean result = ixn.execute(survivor, obsolete);
		if (!result) {
			ixnError("The IxnMemMerge interaction failed.", ixn.getErrCode().toString(), ixn.getErrText());
		}
		waitForQueues(survivor.getSrcCode(), survivor.getMemIdnum());
		waitForQueues(obsolete.getSrcCode(), obsolete.getMemIdnum());
	}

	/**
	 * Executes the IxnMemGet interaction.
	 * @param memHead the record instance containing the source code and member identification number to get.
	 * @return the member record if found.
	 * @throws Exception
	 */
	private MemHead executeMemGet(MemHead memHead) throws Exception {
		MemRowList inputList = createMemRowList(memHead);
		MemRowList outputList = createMemRowList();

		IxnMemGet ixn = new IxnMemGet(context);
		ixn.setEntType("id");
		ixn.setSegCodeFilter("MEMHEAD");
		ixn.setRecStatFilter("A");

		boolean result = ixn.execute(inputList, outputList, GetType.ASMEMBER, KeyType.MEMIDNUM);
		if (!result) {
			if (ixn.getErrCode() != ErrCode.ENOREC) {
				ixnError("The IxnMemGet interaction failed.", ixn.getErrCode().toString(), ixn.getErrText());
			}
		}

		if (outputList.isEmpty()) {
			return null;
		} else {
			return (MemHead)outputList.rowAt(0);
		}
	}

	/**
	 * Create a new member record instance.
	 * @param srcCode the source code to set.
	 * @param memIdnum the member identification number to set.
	 * @return a new member record instance.
	 */
	private MemHead createMemHead(String srcCode, String memIdnum) {
		MemHead memHead = new MemHead();
		memHead.setSrcCode(srcCode);
		memHead.setMemIdnum(memIdnum);
		return memHead;
	}

	/**
	 * Creates a new member attribute row.
	 * @param memHead the member record to associate this attribute row with.
	 * @param segCode the segment code of the attribute.
	 * @param attrCode the attribute code.
	 * @return a new member attribute row.
	 */
	private MemAttrRow createMemAttrRow(MemHead memHead, String segCode, String attrCode) {
		MemAttrRow memAttrRow = new MemAttrRow(segCode);
		memAttrRow.setMemHead(memHead);
		memAttrRow.setAttrCode(attrCode);
		return memAttrRow;
	}

	/**
	 * Sets a field on a member attribute row.
	 * @param memAttrRow the attribute row to use.
	 * @param fieldName the field name to set.
	 * @param fieldValue the field value.
	 */
	private void setField(MemAttrRow memAttrRow, String fieldName, String fieldValue) throws Exception {
		try {
			memAttrRow.setAsString(fieldName, fieldValue);
		} catch (SetterException e) {
			err(e.getMessage());
		}
	}

	/**
	 * Creates a member row list.
	 * @param memRows the array of MemRows to create the list from.
	 * @return the member row list.
	 */
	private MemRowList createMemRowList(MemRow... memRows) {
		MemRowList memRowList = new MemRowList();
		if (memRows != null) {
			for (MemRow memRow : memRows) {
				memRowList.addRow(memRow);
			}
		}
		return memRowList;
	}
}
