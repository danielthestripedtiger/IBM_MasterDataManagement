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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import madison.mpi.AudMode;
import madison.mpi.Context;
import madison.mpi.IxnMemDrop;
import madison.mpi.IxnMemPut;
import madison.mpi.IxnMemPutQual;
import madison.mpi.MatchMode;
import madison.mpi.MemAddr;
import madison.mpi.MemAttr;
import madison.mpi.MemDate;
import madison.mpi.MemExtc;
import madison.mpi.MemHead;
import madison.mpi.MemIdent;
import madison.mpi.MemMode;
import madison.mpi.MemName;
import madison.mpi.MemPhone;
import madison.mpi.MemRowList;
import madison.mpi.PutType;
import madison.util.SetterException;

/**
 * This examples illustrates the IxnMemPutQual interaction. The members used in
 * the example will be created and cleaned up during the example execution.
 */
public class ExMemPutQual extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnMemPutQual";

	private static MemHead memHead1 = new MemHead();
	private static MemHead memHead2 = new MemHead();
	private static MemHead memHead3 = new MemHead();
	private static MemHead memHeadWinner = new MemHead();

	public static void main(String[] args) throws Exception
	{
		// We will create the members which will be used in this example:
		createMembers();

		// First we will illustrate the "clear winner" scenario.
		// In this scenario we will update the memHead2 member (based on it's
		// score).
		info("\n* * * First example * * *");
		IxnMemPutQual memPutQual = new IxnMemPutQual(getContext());
		MemRowList inpMemRows = null;
		MemRowList outMemRows = new MemRowList();
		MemHead memHead = new MemHead();
		// MemHead must have a srcCode for this interaction.
		memHead.setSrcCode("RHN");
		inpMemRows = getInputRows(memHead);
		// entType is required for this interaction.
		memPutQual.setEntType("id");
		// See the documentation for IxnMemPutQual for information on PutType,
		// MemMode and MatchMode options.

		// Set entity management priority.
	    // Default is 0.
	    memPutQual.setEntPrior((short)50);

		boolean success = memPutQual.execute(getUsrHead(), inpMemRows, outMemRows, PutType.DEFAULT_WINNER, MemMode.ATTRCOMP, MatchMode.DEFERRED);
		if(!success)
		{
			disconnect();
			ixnError("The " + intrName + " interaction failed.", memPutQual.getErrCode().toString(), memPutQual.getErrText());
		}
		memHeadWinner = (MemHead) outMemRows.rowAt(0);
		info("IxnMemPutQual updated a member: " + memHeadWinner.getSrcCode() + ":" + memHeadWinner.getMemIdnum() + " memRecno: " + memHeadWinner.getMemRecno() + "\n");

		// Second example relies on the fact that we have changed memHead2
		// member in such a way that his score against our input member is less
		// or equals the scores of memHead1 and memHead3 against the input
		// member. We will perform exactly the same IxnMemPutQual call as the
		// first illustration, but the result will be a different member update.
		// Note that members memHead1 and memHead3 score identically against the
		// input member. This is where PutType.DEFAULT_WINNER comes into play
		// and the member with the lowest memRecno (in this case memHead1) will
		// be updated.
		info("\n* * * Second example * * *");
		inpMemRows = null;
		outMemRows = new MemRowList();
		memHead = new MemHead();
		memHead.setSrcCode("RHN");
		inpMemRows = getInputRows(memHead);
		memPutQual.setEntType("id");
		success = memPutQual.execute(getUsrHead(), inpMemRows, outMemRows, PutType.DEFAULT_WINNER, MemMode.ATTRCOMP, MatchMode.DEFERRED);
		if(!success)
		{
			disconnect();
			ixnError("The " + intrName + " interaction failed.", memPutQual.getErrCode().toString(), memPutQual.getErrText());
		}
		memHeadWinner = (MemHead) outMemRows.rowAt(0);
		info("IxnMemPutQual updated a member: " + memHeadWinner.getSrcCode() + ":" + memHeadWinner.getMemIdnum() + " memRecno: " + memHeadWinner.getMemRecno() + "\n");

		// In the third example we will see how PutType.UNCLEAR_WINNER works. We
		// are going to perform exactly the same IxnmemPutQual as above, but use
		// the PutType.UNCLEAR_WINNER. This will result in an error code, since
		// memHead1 and memHead3 score identically against the input member. The
		// matching members will be returned in the outMemRows so the client
		// application can examine them. Note that the call to .execute method
		// still returns true in this case.
		info("\n* * * Third example * * *");
		inpMemRows = null;
		outMemRows = new MemRowList();
		memHead = new MemHead();
		memHead.setSrcCode("RHN");
		inpMemRows = getInputRows(memHead);
		memPutQual.setEntType("id");
		memPutQual.setAudMode(AudMode.AUDNONE);
		success = memPutQual.execute(getUsrHead(), inpMemRows, outMemRows, PutType.UNCLEAR_WINNER, MemMode.ATTRCOMP, MatchMode.DEFERRED);
		if(!success)
		{
			disconnect();
			ixnError("The " + intrName + " interaction failed.", memPutQual.getErrCode().toString(), memPutQual.getErrText());
		}
		info("IxnMemPutQual.execute() returned an error code: " + memPutQual.getErrCode());
		info("error message: " + memPutQual.getErrText());
		info("smt error code: " + memPutQual.getSmtErrCode());
		info("IxnMemPutQual returned " + outMemRows.size() + " rows.");
		// Comment out the statement below if you wish to print the returned
		// memHeads:
		// dumpRows(outMemRows, "Here are the returned rows:");

		// In this final example we will see what happens when IxnMemPutQual is
		// performed and no likely candidates are found as a result of the
		// match. In this case a new member is created (with memIdnum = the new
		// memRecno).
		info("\n* * * Final example * * *");
		inpMemRows = null;
		outMemRows = new MemRowList();
		memHead = new MemHead();
		// Note that we are changing the srcCode for this example.
		memHead.setSrcCode("OUTP");
		inpMemRows = getInputRows(memHead);
		memPutQual.setEntType("id");
		success = memPutQual.execute(getUsrHead(), inpMemRows, outMemRows, PutType.UNCLEAR_WINNER, MemMode.ATTRCOMP, MatchMode.DEFERRED);
		if(!success)
		{
			disconnect();
			ixnError("The " + intrName + " interaction failed.", memPutQual.getErrCode().toString(), memPutQual.getErrText());
		}
		memHeadWinner = (MemHead) outMemRows.rowAt(0);
		info("IxnMemPutQual created a member: " + memHeadWinner.getSrcCode() + ":" + memHeadWinner.getMemIdnum() + " memRecno: " + memHeadWinner.getMemRecno() + "\n");

		// Cleanup of the members (members are dropped).
		cleanUpMembers();
	}

	private static void createMembers() throws Exception
	{
		memHead1.setSrcCode("RHN");
		memHead1.setMemIdnum("112917");
		memHead2.setSrcCode("RHN");
		memHead2.setMemIdnum("300067");
		memHead3.setSrcCode("RHN");
		memHead3.setMemIdnum("500898");
		Context ctx = getContext();
		IxnMemPut put = new IxnMemPut(ctx);
		MemRowList inpMemRows = mem1();
		MemRowList outMemRows = new MemRowList();
		MemHead memHead = (MemHead) inpMemRows.rowAt(0);
		boolean success = put.execute(inpMemRows, outMemRows, PutType.INSERT_UPDATE, MemMode.ATTRCOMP, MatchMode.IMMEDIATE);
		if(!success)
		{
			disconnect();
			ixnError("The IxnMemPut inside the createMembers() method failed for " + memHead.getSrcCode() + ":" + memHead.getMemIdnum(), put.getErrCode().toString(), put.getErrText());
		}
		memHead1.setMemRecno(outMemRows.rowAt(0).getMemRecno());
		info("Created member: " + memHead1.getSrcCode() + ":" + memHead1.getMemIdnum() + " memRecno: " + memHead1.getMemRecno());

		inpMemRows = mem2();
		outMemRows.removeAllRows();
		memHead = (MemHead) inpMemRows.rowAt(0);
		success = put.execute(inpMemRows, outMemRows, PutType.INSERT_UPDATE, MemMode.ATTRCOMP, MatchMode.IMMEDIATE);
		if(!success)
		{
			disconnect();
			ixnError("The IxnMemPut inside the createMembers() method failed for " + memHead.getSrcCode() + ":" + memHead.getMemIdnum(), put.getErrCode().toString(), put.getErrText());
		}
		memHead2.setMemRecno(outMemRows.rowAt(0).getMemRecno());
		info("Created member: " + memHead2.getSrcCode() + ":" + memHead2.getMemIdnum() + " memRecno: " + memHead2.getMemRecno());

		inpMemRows = mem3();
		outMemRows.removeAllRows();
		memHead = (MemHead) inpMemRows.rowAt(0);
		success = put.execute(inpMemRows, outMemRows, PutType.INSERT_UPDATE, MemMode.ATTRCOMP, MatchMode.IMMEDIATE);
		if(!success)
		{
			disconnect();
			ixnError("The IxnMemPut inside the createMembers() method failed for " + memHead.getSrcCode() + ":" + memHead.getMemIdnum(), put.getErrCode().toString(), put.getErrText());
		}
		memHead3.setMemRecno(outMemRows.rowAt(0).getMemRecno());
		info("Created member: " + memHead3.getSrcCode() + ":" + memHead3.getMemIdnum() + " memRecno: " + memHead3.getMemRecno());
		waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());
		waitForQueues(memHead2.getSrcCode(), memHead2.getMemIdnum());
		waitForQueues(memHead3.getSrcCode(), memHead3.getMemIdnum());
	}

	private static void cleanUpMembers()
	{
		try
		{
			waitForQueues(memHead1.getSrcCode(), memHead1.getMemIdnum());
			waitForQueues(memHead2.getSrcCode(), memHead2.getMemIdnum());
			waitForQueues(memHead3.getSrcCode(), memHead3.getMemIdnum());
			waitForQueues(memHeadWinner.getSrcCode(), memHeadWinner.getMemIdnum());

			IxnMemDrop memDrop = new IxnMemDrop(getContext());
			memDrop.execute(memHead1);
			info("Dropped member: " + memHead1.getSrcCode() + ":" + memHead1.getMemIdnum() + " memRecno: " + memHead1.getMemRecno());
			memDrop.execute(memHead2);
			info("Dropped member: " + memHead2.getSrcCode() + ":" + memHead2.getMemIdnum() + " memRecno: " + memHead2.getMemRecno());
			memDrop.execute(memHead3);
			info("Dropped member: " + memHead3.getSrcCode() + ":" + memHead3.getMemIdnum() + " memRecno: " + memHead3.getMemRecno());
			memDrop.execute(memHeadWinner);
			info("Dropped member: " + memHeadWinner.getSrcCode() + ":" + memHeadWinner.getMemIdnum() + " memRecno: " + memHeadWinner.getMemRecno());
		} catch (Exception e)
		{
			// Do Nothing. For this example we do not care about any possible
			// memDrop issues.
		}
	}

	private static MemRowList getInputRows(MemHead memHead) throws SetterException, ParseException
	{
		MemRowList retRowList = new MemRowList();
		retRowList.addRow(memHead);

		MemName memName1 = new MemName(memHead);
		memName1.setAttrCode("LGLNAME");
		memName1.setOnmLast("Howard");
		memName1.setOnmFirst("Michael");
		retRowList.addRow(memName1);

		MemName memName2 = new MemName(memHead);
		memName2.setAttrCode("GTNAME");
		memName2.setOnmLast("Howard");
		memName2.setOnmFirst("Michael");
		retRowList.addRow(memName2);

		MemAddr memAddr1 = new MemAddr(memHead);
		memAddr1.setAttrCode("HOMEADDR");
		memAddr1.setStLine1("8714 S. Main st");
		memAddr1.setCity("Livermore");
		memAddr1.setState("CA");
		memAddr1.setZipCode("94550");
		retRowList.addRow(memAddr1);

		MemAddr memAddr2 = new MemAddr(memHead);
		memAddr2.setAttrCode("GTHADDR");
		memAddr2.setStLine1("8714 S. Main st");
		memAddr2.setCity("Livermore");
		memAddr2.setState("CA");
		memAddr2.setZipCode("94550");
		retRowList.addRow(memAddr2);

		MemIdent memIdent = new MemIdent(memHead);
		memIdent.setAttrCode("SSN");
		memIdent.setIdIssuer("SSA");
		memIdent.setIdNumber("538376183");
		retRowList.addRow(memIdent);

		MemPhone memPhone1 = new MemPhone(memHead);
		memPhone1.setAttrCode("HOMEPHON");
		memPhone1.setPhNumber("925-606-4359");
		retRowList.addRow(memPhone1);

		MemAttr memAttr1 = new MemAttr(memHead);
		memAttr1.setAttrCode("FACILITY");
		memAttr1.setAttrVal("RMC");
		retRowList.addRow(memAttr1);

		MemAttr memAttr2 = new MemAttr(memHead);
		memAttr2.setAttrCode("LANGUAGE");
		memAttr2.setAttrVal("English");
		retRowList.addRow(memAttr2);

		MemAttr memAttr3 = new MemAttr(memHead);
		memAttr3.setAttrCode("SEX");
		memAttr3.setAttrVal("M");
		retRowList.addRow(memAttr3);

		MemDate memDate1 = new MemDate(memHead);
		memDate1.setAttrCode("BIRTHDT");
		memDate1.setDateVal("1958-09-05");
		retRowList.addRow(memDate1);

		MemDate memDate2 = new MemDate(memHead);
		memDate2.setAttrCode("GTDOB");
		memDate2.setDateVal("1958-09-05");
		retRowList.addRow(memDate2);

		return retRowList;
	}

	private static Date makeDate(String arg) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		return sdf.parse(arg);
	}

	private static MemRowList mem1() throws ParseException
	{
		MemRowList retRows = new MemRowList();

		MemHead memHead = new MemHead();
		memHead.setMemIdnum("112917");
		memHead.setSrcCode("RHN");
		retRows.addRow(memHead);

		MemAddr memAddr1 = new MemAddr(memHead);
		memAddr1.setAttrCode("GTHADDR");
		memAddr1.setStLine1("8714 S. Main");
		memAddr1.setCity("Livermore");
		memAddr1.setState("CA");
		memAddr1.setZipCode("94550");
		retRows.addRow(memAddr1);

		MemAddr memAddr2 = new MemAddr(memHead);
		memAddr2.setAttrCode("HOMEADDR");
		memAddr2.setStLine1("8714 S. Main");
		memAddr2.setCity("Livermore");
		memAddr2.setState("CA");
		memAddr2.setZipCode("94550");
		retRows.addRow(memAddr2);

		MemAttr memAttr1 = new MemAttr(memHead);
		memAttr1.setAttrCode("FACILITY");
		memAttr1.setAttrVal("RMC");
		retRows.addRow(memAttr1);

		MemAttr memAttr2 = new MemAttr(memHead);
		memAttr2.setAttrCode("GTINSCOV");
		memAttr2.setAttrVal("6187");
		retRows.addRow(memAttr2);

		MemAttr memAttr3 = new MemAttr(memHead);
		memAttr3.setAttrCode("GTINSNM");
		memAttr3.setAttrVal("State Farm");
		retRows.addRow(memAttr3);

		MemAttr memAttr4 = new MemAttr(memHead);
		memAttr4.setAttrCode("LANGUAGE");
		memAttr4.setAttrVal("English");
		retRows.addRow(memAttr4);

		MemAttr memAttr5 = new MemAttr(memHead);
		memAttr5.setAttrCode("OPERID");
		memAttr5.setAttrVal("MMJ");
		retRows.addRow(memAttr5);

		MemAttr memAttr6 = new MemAttr(memHead);
		memAttr6.setAttrCode("PCPDEAID");
		memAttr6.setAttrVal("BC2763779");
		retRows.addRow(memAttr6);

		MemAttr memAttr7 = new MemAttr(memHead);
		memAttr7.setAttrCode("PCPLICID");
		memAttr7.setAttrVal("153443278");
		retRows.addRow(memAttr7);

		MemAttr memAttr8 = new MemAttr(memHead);
		memAttr8.setAttrCode("PCPPRAC");
		memAttr8.setAttrVal("Margolis Neil W OD - Optometric Specialists");
		retRows.addRow(memAttr8);

		MemAttr memAttr9 = new MemAttr(memHead);
		memAttr9.setAttrCode("PCPSPEC");
		memAttr9.setAttrVal("Geriatric Medicine");
		retRows.addRow(memAttr9);

		MemAttr memAttr10 = new MemAttr(memHead);
		memAttr10.setAttrCode("RACE");
		memAttr10.setAttrVal("Caucasian");
		retRows.addRow(memAttr10);

		MemAttr memAttr11 = new MemAttr(memHead);
		memAttr11.setAttrCode("RELIGION");
		memAttr11.setAttrVal("Protestant");
		retRows.addRow(memAttr11);

		MemAttr memAttr12 = new MemAttr(memHead);
		memAttr12.setAttrCode("SEX");
		memAttr12.setAttrVal("M");
		retRows.addRow(memAttr12);

		MemDate memDate1 = new MemDate(memHead);
		memDate1.setAttrCode("BIRTHDT");
		memDate1.setDateVal("1958-09-05");
		retRows.addRow(memDate1);

		MemDate memDate2 = new MemDate(memHead);
		memDate2.setAttrCode("GTDOB");
		memDate2.setDateVal("1958-09-05");
		retRows.addRow(memDate2);

		MemExtc memExtc1 = new MemExtc(memHead);
		memExtc1.setAttrCode("ENCNTR");
		memExtc1.setAcctNumber("8");
		memExtc1.setEncDate(makeDate("1995-04-20 00:00:00"));
		memExtc1.setDisDate(makeDate("1995-04-20 00:00:00"));
		memExtc1.setPatType("AMS");
		memExtc1.setUser1("Yes");
		retRows.addRow(memExtc1);

		MemIdent memIdent1 = new MemIdent(memHead);
		memIdent1.setAttrCode("GTSSN");
		memIdent1.setIdSrcRecno(3);
		memIdent1.setIdIssuer("SSA");
		memIdent1.setIdNumber("538376183");
		retRows.addRow(memIdent1);

		MemIdent memIdent2 = new MemIdent(memHead);
		memIdent2.setAttrCode("PTCHRTID");
		memIdent2.setIdSrcRecno(211);
		memIdent2.setIdIssuer("RMC");
		memIdent2.setIdNumber("112917");
		retRows.addRow(memIdent2);

		MemIdent memIdent3 = new MemIdent(memHead);
		memIdent3.setAttrCode("PTENTRID");
		memIdent3.setIdSrcRecno(211);
		memIdent3.setIdIssuer("RMC");
		memIdent3.setIdNumber("E500096");
		retRows.addRow(memIdent3);

		MemIdent memIdent4 = new MemIdent(memHead);
		memIdent4.setAttrCode("SSN");
		memIdent4.setIdSrcRecno(3);
		memIdent4.setIdIssuer("SSA");
		memIdent4.setIdNumber("538376183");
		retRows.addRow(memIdent4);

		MemName memName1 = new MemName(memHead);
		memName1.setAttrCode("GTNAME");
		memName1.setOnmLast("Howard");
		memName1.setOnmFirst(" Michael");
		retRows.addRow(memName1);

		MemName memName2 = new MemName(memHead);
		memName2.setAttrCode("LGLNAME");
		memName2.setOnmLast("Howard");
		memName2.setOnmFirst("Michael");
		memName2.setOnmMiddle("A");
		retRows.addRow(memName2);

		MemName memName3 = new MemName(memHead);
		memName3.setAttrCode("PCPNAME");
		memName3.setOnmLast("Garcia");
		memName3.setOnmFirst("Esperanza");
		retRows.addRow(memName3);

		MemPhone memPhone1 = new MemPhone(memHead);
		memPhone1.setAttrCode("HOMEPHON");
		memPhone1.setPhNumber("925-606-4359");
		retRows.addRow(memPhone1);

		MemPhone memPhone2 = new MemPhone(memHead);
		memPhone2.setAttrCode("PCPPHN");
		memPhone2.setPhNumber("925-482-2213");
		retRows.addRow(memPhone2);

		return retRows;
	}

	private static MemRowList mem2() throws ParseException
	{
		MemRowList retRows = new MemRowList();
		MemHead memHead = new MemHead();
		memHead.setMemIdnum("300067");
		memHead.setSrcCode("RHN");
		retRows.addRow(memHead);

		MemAddr memAddr1 = new MemAddr(memHead);
		memAddr1.setAttrCode("GTHADDR");
		memAddr1.setStLine1("8714 S. Main");
		memAddr1.setCity("Livermore");
		memAddr1.setState("CA");
		memAddr1.setZipCode("94550");
		retRows.addRow(memAddr1);

		MemAddr memAddr2 = new MemAddr(memHead);
		memAddr2.setAttrCode("HOMEADDR");
		memAddr2.setStLine1("8714 S. Main");
		memAddr2.setCity("Livermore");
		memAddr2.setState("CA");
		memAddr2.setZipCode("94550");
		retRows.addRow(memAddr2);

		MemAttr memAttr1 = new MemAttr(memHead);
		memAttr1.setAttrCode("FACILITY");
		memAttr1.setAttrVal("RMC");
		retRows.addRow(memAttr1);

		MemAttr memAttr2 = new MemAttr(memHead);
		memAttr2.setAttrCode("GTINSCOV");
		memAttr2.setAttrVal("6187");
		retRows.addRow(memAttr2);

		MemAttr memAttr3 = new MemAttr(memHead);
		memAttr3.setAttrCode("GTINSNM");
		memAttr3.setAttrVal("State Farm");
		retRows.addRow(memAttr3);

		MemAttr memAttr4 = new MemAttr(memHead);
		memAttr4.setAttrCode("LANGUAGE");
		memAttr4.setAttrVal("English");
		retRows.addRow(memAttr4);

		MemAttr memAttr5 = new MemAttr(memHead);
		memAttr5.setAttrCode("OPERID");
		memAttr5.setAttrVal("MMJ");
		retRows.addRow(memAttr5);

		MemAttr memAttr6 = new MemAttr(memHead);
		memAttr6.setAttrCode("PCPDEAID");
		memAttr6.setAttrVal("BM6774384");
		retRows.addRow(memAttr6);

		MemAttr memAttr7 = new MemAttr(memHead);
		memAttr7.setAttrCode("PCPLICID");
		memAttr7.setAttrVal("153443640");
		retRows.addRow(memAttr7);

		MemAttr memAttr8 = new MemAttr(memHead);
		memAttr8.setAttrCode("PCPPRAC");
		memAttr8.setAttrVal("Appell Dental Group");
		retRows.addRow(memAttr8);

		MemAttr memAttr9 = new MemAttr(memHead);
		memAttr9.setAttrCode("PCPSPEC");
		memAttr9.setAttrVal("Sports Medicine");
		retRows.addRow(memAttr9);

		MemAttr memAttr10 = new MemAttr(memHead);
		memAttr10.setAttrCode("RACE");
		memAttr10.setAttrVal("Caucasian");
		retRows.addRow(memAttr10);

		MemAttr memAttr11 = new MemAttr(memHead);
		memAttr11.setAttrCode("RELIGION");
		memAttr11.setAttrVal("Protestant");
		retRows.addRow(memAttr11);

		MemAttr memAttr12 = new MemAttr(memHead);
		memAttr12.setAttrCode("SEX");
		memAttr12.setAttrVal("M");
		retRows.addRow(memAttr12);

		MemDate memDate1 = new MemDate(memHead);
		memDate1.setAttrCode("BIRTHDT");
		memDate1.setDateVal("1958-09-06");
		retRows.addRow(memDate1);

		MemDate memDate2 = new MemDate(memHead);
		memDate2.setAttrCode("GTDOB");
		memDate2.setDateVal("1958-09-05");
		retRows.addRow(memDate2);

		MemExtc memExtc1 = new MemExtc(memHead);
		memExtc1.setAttrCode("ENCNTR");
		memExtc1.setAcctNumber("8999");
		memExtc1.setEncDate(makeDate("1999-02-01 00:00:00"));
		memExtc1.setDisDate(makeDate("1999-02-01 00:00:00"));
		memExtc1.setPatType("AMS");
		memExtc1.setUser1("Yes");
		retRows.addRow(memExtc1);

		MemIdent memIdent1 = new MemIdent(memHead);
		memIdent1.setAttrCode("GTSSN");
		memIdent1.setIdSrcRecno(3);
		memIdent1.setIdIssuer("SSA");
		memIdent1.setIdNumber("538376183");
		retRows.addRow(memIdent1);

		MemIdent memIdent2 = new MemIdent(memHead);
		memIdent2.setAttrCode("PTCHRTID");
		memIdent2.setIdSrcRecno(211);
		memIdent2.setIdIssuer("RMC");
		memIdent2.setIdNumber("300067");
		retRows.addRow(memIdent2);

		MemIdent memIdent3 = new MemIdent(memHead);
		memIdent3.setAttrCode("PTENTRID");
		memIdent3.setIdSrcRecno(211);
		memIdent3.setIdIssuer("RMC");
		memIdent3.setIdNumber("E500096");
		retRows.addRow(memIdent3);

		MemIdent memIdent4 = new MemIdent(memHead);
		memIdent4.setAttrCode("SSN");
		memIdent4.setIdSrcRecno(3);
		memIdent4.setIdIssuer("SSA");
		memIdent4.setIdNumber("538376183");
		retRows.addRow(memIdent4);

		MemName memName1 = new MemName(memHead);
		memName1.setAttrCode("GTNAME");
		memName1.setOnmLast("Howard");
		memName1.setOnmFirst(" Michael");
		retRows.addRow(memName1);

		MemName memName2 = new MemName(memHead);
		memName2.setAttrCode("LGLNAME");
		memName2.setOnmLast("Howard");
		memName2.setOnmFirst("Mike");
		memName2.setOnmMiddle("A");
		retRows.addRow(memName2);

		MemName memName3 = new MemName(memHead);
		memName3.setAttrCode("PCPNAME");
		memName3.setOnmLast("Green");
		memName3.setOnmFirst("Boy");
		retRows.addRow(memName3);

		MemPhone memPhone1 = new MemPhone(memHead);
		memPhone1.setAttrCode("HOMEPHON");
		memPhone1.setPhNumber("925-606-4359");
		retRows.addRow(memPhone1);

		MemPhone memPhone2 = new MemPhone(memHead);
		memPhone2.setAttrCode("PCPPHN");
		memPhone2.setPhNumber("415-992-7676");
		retRows.addRow(memPhone2);
		return retRows;
	}

	private static MemRowList mem3() throws ParseException
	{
		MemRowList retRows = new MemRowList();
		MemHead memHead = new MemHead();
		memHead.setMemIdnum("500898");
		memHead.setSrcCode("RHN");
		retRows.addRow(memHead);

		MemAddr memAddr1 = new MemAddr(memHead);
		memAddr1.setAttrCode("GTHADDR");
		memAddr1.setStLine1("8714 S. Main");
		memAddr1.setCity("Livermore");
		memAddr1.setState("CA");
		memAddr1.setZipCode("94550");
		retRows.addRow(memAddr1);

		MemAddr memAddr2 = new MemAddr(memHead);
		memAddr2.setAttrCode("HOMEADDR");
		memAddr2.setStLine1("8714 S. Main");
		memAddr2.setCity("Livermore");
		memAddr2.setState("CA");
		memAddr2.setZipCode("94550");
		retRows.addRow(memAddr2);

		MemAttr memAttr1 = new MemAttr(memHead);
		memAttr1.setAttrCode("FACILITY");
		memAttr1.setAttrVal("RMC");
		retRows.addRow(memAttr1);

		MemAttr memAttr2 = new MemAttr(memHead);
		memAttr2.setAttrCode("GTINSCOV");
		memAttr2.setAttrVal("6187");
		retRows.addRow(memAttr2);

		MemAttr memAttr3 = new MemAttr(memHead);
		memAttr3.setAttrCode("GTINSNM");
		memAttr3.setAttrVal("State Farm");
		retRows.addRow(memAttr3);

		MemAttr memAttr4 = new MemAttr(memHead);
		memAttr4.setAttrCode("LANGUAGE");
		memAttr4.setAttrVal("English");
		retRows.addRow(memAttr4);

		MemAttr memAttr5 = new MemAttr(memHead);
		memAttr5.setAttrCode("OPERID");
		memAttr5.setAttrVal("MMJ");
		retRows.addRow(memAttr5);

		MemAttr memAttr6 = new MemAttr(memHead);
		memAttr6.setAttrCode("PCPDEAID");
		memAttr6.setAttrVal("BH2702199");
		retRows.addRow(memAttr6);

		MemAttr memAttr7 = new MemAttr(memHead);
		memAttr7.setAttrCode("PCPLICID");
		memAttr7.setAttrVal("153443606");
		retRows.addRow(memAttr7);

		MemAttr memAttr8 = new MemAttr(memHead);
		memAttr8.setAttrCode("PCPPRAC");
		memAttr8.setAttrVal("Mayfield Susan J PHD - Lake Cook Behavior Health Rsrc");
		retRows.addRow(memAttr8);

		MemAttr memAttr9 = new MemAttr(memHead);
		memAttr9.setAttrCode("PCPSPEC");
		memAttr9.setAttrVal("Gynecologic Surgery");
		retRows.addRow(memAttr9);

		MemAttr memAttr10 = new MemAttr(memHead);
		memAttr10.setAttrCode("RACE");
		memAttr10.setAttrVal("Caucasian");
		retRows.addRow(memAttr10);

		MemAttr memAttr11 = new MemAttr(memHead);
		memAttr11.setAttrCode("RELIGION");
		memAttr11.setAttrVal("Protestant");
		retRows.addRow(memAttr11);

		MemAttr memAttr12 = new MemAttr(memHead);
		memAttr12.setAttrCode("SEX");
		memAttr12.setAttrVal("M");
		retRows.addRow(memAttr12);

		MemDate memDate1 = new MemDate(memHead);
		memDate1.setAttrCode("BIRTHDT");
		memDate1.setDateVal("1958-09-05");
		retRows.addRow(memDate1);

		MemDate memDate2 = new MemDate(memHead);
		memDate2.setAttrCode("GTDOB");
		memDate2.setDateVal("1958-09-05");
		retRows.addRow(memDate2);

		MemExtc memExtc1 = new MemExtc(memHead);
		memExtc1.setAttrCode("ENCNTR");
		memExtc1.setAcctNumber("7888");
		memExtc1.setEncDate(makeDate("1999-03-01 00:00:00"));
		memExtc1.setDisDate(makeDate("1999-03-01 00:00:00"));
		memExtc1.setPatType("AMS");
		memExtc1.setUser1("Yes");
		retRows.addRow(memExtc1);

		MemIdent memIdent1 = new MemIdent(memHead);
		memIdent1.setAttrCode("GTSSN");
		memIdent1.setIdSrcRecno(3);
		memIdent1.setIdIssuer("SSA");
		memIdent1.setIdNumber("538376183");
		retRows.addRow(memIdent1);

		MemIdent memIdent2 = new MemIdent(memHead);
		memIdent2.setAttrCode("PTCHRTID");
		memIdent2.setIdSrcRecno(211);
		memIdent2.setIdIssuer("RMC");
		memIdent2.setIdNumber("500898");
		retRows.addRow(memIdent2);

		MemIdent memIdent3 = new MemIdent(memHead);
		memIdent3.setAttrCode("PTENTRID");
		memIdent3.setIdSrcRecno(211);
		memIdent3.setIdIssuer("RMC");
		memIdent3.setIdNumber("E500096");
		retRows.addRow(memIdent3);

		MemIdent memIdent4 = new MemIdent(memHead);
		memIdent4.setAttrCode("SSN");
		memIdent4.setIdSrcRecno(3);
		memIdent4.setIdIssuer("SSA");
		memIdent4.setIdNumber("538376183");
		retRows.addRow(memIdent4);

		MemName memName1 = new MemName(memHead);
		memName1.setAttrCode("GTNAME");
		memName1.setOnmLast("Howard");
		memName1.setOnmFirst(" Michael");
		retRows.addRow(memName1);

		MemName memName2 = new MemName(memHead);
		memName2.setAttrCode("LGLNAME");
		memName2.setOnmLast("Howard");
		memName2.setOnmFirst("Michael");
		retRows.addRow(memName2);

		MemName memName3 = new MemName(memHead);
		memName3.setAttrCode("PCPNAME");
		memName3.setOnmLast("Hernandez");
		memName3.setOnmFirst("Isidro");
		retRows.addRow(memName3);

		MemPhone memPhone1 = new MemPhone(memHead);
		memPhone1.setAttrCode("HOMEPHON");
		memPhone1.setPhNumber("925-606-4359");
		retRows.addRow(memPhone1);

		MemPhone memPhone2 = new MemPhone(memHead);
		memPhone2.setAttrCode("PCPPHN");
		memPhone2.setPhNumber("415-992-0979");
		retRows.addRow(memPhone2);
		return retRows;
	}
}
