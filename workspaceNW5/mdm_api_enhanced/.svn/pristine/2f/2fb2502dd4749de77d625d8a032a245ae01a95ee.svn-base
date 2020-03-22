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

import java.util.List;

import madison.mpi.AudHead;
import madison.mpi.AudRowList;
import madison.mpi.AudSearchHistCriteria;
import madison.mpi.HistType;
import madison.mpi.IxnAudSearchHist;
import madison.mpi.IxnRelGetHist;
import madison.mpi.RelGetHistCriteria;
import madison.mpi.RelLink;
import madison.mpi.RowIterator;


/**
 * This class illustrates the use of IxnRelGetHist. This IXN allows you to get
 * information about a relationship at a specific point in time.
 */
public class ExRelGetHist extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String searchIxnName = "IxnAudSearchHist";
	private static final String getIxnName = "IxnRelGetHist";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		// Create the Relationship Link object.
	    RelLink relLink1 = new RelLink();

	    try
	    {
	    	// create a relationship that has history

		    // We are going to get a couple of EntRecnos by using the
		    // ExMemGet.getEntRecno() method.
		    // These are for members RCM:72949 and RCM:75503
		    relLink1.setEntRecnoLeft(ExMemGet.getEntRecno(new String[]{"RMC", "72949"}));
		    relLink1.setEntRecnoRight(ExMemGet.getEntRecno(new String[]{"RMC", "75503"}));

		    // Setting the relationship type. These are defined in the mpi_reltype
		    // table.  52 = manulink which is a relationship with history enabled.
		    relLink1.setRelTypeno(52);

		    // create the relationship
		    relLink1 = ExRelPut.doRelPut(relLink1);

		    // update the relationship to create more history
		    relLink1.setRemovableByLinker(!relLink1.isRemovableByLinker());
		    relLink1 = ExRelPut.doRelPut(relLink1);

			// Setup an IxnAudSearchHist interaction object and an AudSearchHistCriteria to execute against.
			IxnAudSearchHist audSearchHist = new IxnAudSearchHist(getContext());
			AudSearchHistCriteria searchCriteria = new AudSearchHistCriteria();
			// Search for relationship changes by entRecno
			// Get the entRecno for the left side of the relationship using the
			// ExMemGet.getEntRecno() method.
		    long entRecno = ExMemGet.getEntRecno(new String[]{"RMC", "72949"});
		    searchCriteria.setHistType(HistType.RELLINK);
		    // Setting the relationship type. These are defined in the mpi_reltype
		    // table.  52 = manulink which is a relationship with history enabled.
		    searchCriteria.setRelTypeno(52);
		    searchCriteria.setDirType(AudSearchHistCriteria.DIR_TYPE_LEFT);
		    searchCriteria.setEntType("id");
		    searchCriteria.setEntRecno(entRecno);

			// Execute the IxnAudSearchHist to find all HistType-specific changes for the specified relationship.
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

			// Setup an IxnRelGetHist interaction object and a RelGetHistCriteria to execute against.
			IxnRelGetHist relGetHist = new IxnRelGetHist(getContext());
			RelGetHistCriteria getCriteria = new RelGetHistCriteria();
			getCriteria.setRelTypeno(52);
			getCriteria.setDirType(AudSearchHistCriteria.DIR_TYPE_LEFT);
			getCriteria.setEntType("id");
			getCriteria.setEntRecno(entRecno);

			RowIterator rowIt = audRowList.rows();
			AudHead audHead = (AudHead)rowIt.nextRow();
			List<RelLink> relLinkList;

			// Execute an IxnRelGetHist for the last point in time.
			getCriteria.setAudRecno(audHead.getAudRecno());
			if (!relGetHist.execute(getCriteria))
			{
				// Disconnect from Master Data Engine server
				disconnect();
				ixnError("The " + getIxnName + " interaction failed.", relGetHist.getErrCode().toString(), relGetHist.getErrText());
			}
			relLinkList = (List<RelLink>)relGetHist.getResult();
			dumpRows(relLinkList, "The " + getIxnName + " interaction worked, here is what the relationship looked like last:");

			while (rowIt.hasMoreRows())
			{
				audHead = (AudHead)rowIt.nextRow();
			}

			// Execute an IxnMemGetHist for the first point in time.
			getCriteria.setAudRecno(audHead.getAudRecno());
			if (!relGetHist.execute(getCriteria))
			{
				// Disconnect from Master Data Engine server
				disconnect();
				ixnError("The " + getIxnName + " interaction failed.", relGetHist.getErrCode().toString(), relGetHist.getErrText());
			}
			relLinkList = relGetHist.getResult();
			dumpRows(relLinkList, "The " + getIxnName + " interaction worked, here is what the relationship looked like first:");
	    }
	    finally
	    {
	    	// delete the manual relationship
	    	long relLinkno = relLink1.getRelLinkno();
	    	if (relLinkno > 0)
	    	{
	    		ExRelDelete.doRelDelete(relLinkno);
	    	}
	    }
	}

}
