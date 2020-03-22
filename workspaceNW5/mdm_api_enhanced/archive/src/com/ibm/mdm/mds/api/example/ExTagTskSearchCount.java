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

import madison.mpi.IxnTskSearchCount;
import madison.mpi.TskCountCriteria;
import madison.mpi.TskSearchCountResult;

/**
 * This example illustrates the use of the IxnTskSearchCount interaction to retrieve
 * the number of Tasks and Tags that match a given set of criteria.  The criteria
 * allows specifying which tags must be applied to the tasks.
 *
 * In order for the tag to exist you must run the ExTagPut example.
 */
public class ExTagTskSearchCount extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTskSearch";

	public static void main(String[] args) throws Exception
	{
		// Create the interaction object.
		IxnTskSearchCount tskSearchCount = new IxnTskSearchCount(getContext());

		// Create a new task count criteria object.
		TskCountCriteria criteria = new TskCountCriteria();

		// Populate the criteria object.  Refer to the criteria JavaDoc
		// for all the available options.

		// search for a Task Type - Potential Duplicate
		criteria.addTskTypeno(2);

		// Set entity type as Identity (id)
		// Entity types are listed in mpi_enttype table.
		criteria.addEntTypeno(1);

		// Set the tagType for the example type 50.
		// Only count tasks that have this tag.
		criteria.addTagTypeno(50);

		// Set the flag to include tag counts in the result
		criteria.setReturnTagCounts(true);

		// Execute the interaction using the criteria.
		boolean status = tskSearchCount.execute(criteria);
		if (status)
		{
			TskSearchCountResult result = tskSearchCount.getResult();
			info("The " + intrName + " interaction worked, task search counts returned:");
			info("Total number of tasks matching criteria = " + result.getTskCount());
			info("Total number of tasks for entType 'id' = " + result.getTskCount(1));
			info("Total number of tags for entType 'id' = " + result.getTagCountForEntType(1));
			info("Total number of tags for tagTypeno '50' = " + result.getTagCountForTagType(50));
		}
		else
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + intrName + " interaction failed.", tskSearchCount
					.getErrCode().toString(), tskSearchCount.getErrText());
		}

		// Disconnect from Master Data Engine server
		disconnect();
	}
}
