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

import madison.mpi.AudHead;
import madison.mpi.AudRowList;
import madison.mpi.AudSearchHistCriteria;
import madison.mpi.GetType;
import madison.mpi.HistType;
import madison.mpi.IxnAudSearchHist;
import madison.mpi.IxnMemGetHist;
import madison.mpi.MemGetHistCriteria;
import madison.mpi.MemRowList;
import madison.mpi.RowIterator;


/**
 * This class illustrates the use of IxnMemGetHist. This IXN allows you to get
 * information about a member or entity at a specific point in time.
 */
public class ExMemGetHist extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String searchIxnName = "IxnAudSearchHist";
	private static final String getIxnName = "IxnMemGetHist";

	public static void main(String[] args) throws Exception
	{
		// Setup an IxnAudSearchHist interaction object and an AudSearchHistCriteria to execute against.
		String srcCode = "SURG";
		String memIdnum = "144760";
		IxnAudSearchHist audSearchHist = new IxnAudSearchHist(getContext());
		AudSearchHistCriteria searchCriteria = new AudSearchHistCriteria();
		searchCriteria.setHistType(HistType.MEMHEAD);
		searchCriteria.setEntType("id");
		searchCriteria.setSrcCode(srcCode);
		searchCriteria.setMemIdnum(memIdnum);

		// Execute the IxnAudSearchHist to find all HistType-specific changes for the specified member.
		if (!audSearchHist.execute(searchCriteria))
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + searchIxnName + " interaction failed.", audSearchHist.getErrCode().toString(), audSearchHist.getErrText());
		}

		AudRowList audRowList = audSearchHist.getResult();
		dumpRows(audRowList, "The " + searchIxnName + " interaction worked, here are the returned rows:");

		// This shouldn't happen, but the code below relies on >0 AudHead objects being present.
		if (audRowList.isEmpty())
		{
			// Disconnect from Master Data Engine server
			disconnect();
			err("The " + searchIxnName + " interaction returned no AudHead rows using criteria: " + searchCriteria);
		}

		// Setup an IxnMemGetHist interaction object and a MemGetHistCriteria to execute against.
		IxnMemGetHist memGetHist = new IxnMemGetHist(getContext());
		MemGetHistCriteria getCriteria = new MemGetHistCriteria();
		getCriteria.setGetType(GetType.ASMEMBER);
		getCriteria.setEntType("id");
		getCriteria.setSrcCode(srcCode);
		getCriteria.setMemIdnum(memIdnum);
		getCriteria.setSegAttrFilter("MEMATTRALL");

		RowIterator rowIt = audRowList.rows();
		AudHead audHead = (AudHead)rowIt.nextRow();
		MemRowList memRowList;

		// Execute an IxnMemGetHist for the last point in time.
		getCriteria.setAudRecno(audHead.getAudRecno());
		if (!memGetHist.execute(getCriteria))
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + getIxnName + " interaction failed.", memGetHist.getErrCode().toString(), memGetHist.getErrText());
		}
		memRowList = memGetHist.getResult();
		dumpRows(memRowList, "The " + getIxnName + " interaction worked, here is what the member looked like last:");

		while (rowIt.hasMoreRows())
		{
			audHead = (AudHead)rowIt.nextRow();

		}

		// Execute an IxnMemGetHist for the first point in time.
		getCriteria.setAudRecno(audHead.getAudRecno());
		if (!memGetHist.execute(getCriteria))
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + getIxnName + " interaction failed.", memGetHist.getErrCode().toString(), memGetHist.getErrText());
		}
		memRowList = memGetHist.getResult();
		dumpRows(memRowList, "The " + getIxnName + " interaction worked, here is what the member looked like first:");
	}

}
