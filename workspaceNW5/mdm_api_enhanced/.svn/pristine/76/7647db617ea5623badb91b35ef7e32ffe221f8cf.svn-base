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
import java.util.Map;

import madison.mpi.IxnTskSearch;
import madison.mpi.MemRow;
import madison.mpi.TskSearchCriteria;

/**
 * This example illustrates the use of the IxnTskSearch interaction to retrieve
 * one or more Task(Tsk) objects by criteria. The criteria allows specifying
 * which tags must be applied to the tasks.
 *
 * In order for the tag to exist you must run the ExTagPut example.
 */
public class ExTagTskSearch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTskSearch";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		// Create the interaction object.
		IxnTskSearch tskSearch = new IxnTskSearch(getContext());

		// Create a new task criteria object.
		TskSearchCriteria criteria = new TskSearchCriteria();

		// Populate the criteria object.  Refer to the criteria JavaDoc
		// for all the available options.

		// search for a Task Type - Potential Duplicate
		criteria.addTskTypeno(2);

		// Set entity type as Identity (id)
		// Entity types are listed in mpi_enttype table.
		criteria.addEntTypeno(1);

		// Set the tagType for the example type 50.
		// Only return tasks that have this tag.
		criteria.addTagTypeno(50);

		// Execute the interaction
		boolean status = tskSearch.execute(criteria);
		if (status)
		{
			Map<Integer, List<MemRow>> result = (Map<Integer, List<MemRow>>)tskSearch.getResult();
			// Get the tasks for entType 'id' from the result map.
			List<MemRow> taskResults = result.get(1);
			dumpRows(taskResults, "The " + intrName + " interaction worked, here are the returned rows:");
		}
		else
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + intrName + " interaction failed.", tskSearch.getErrCode().toString(), tskSearch.getErrText());
		}

		// Disconnect from Master Data Engine server
		disconnect();
	}
}
