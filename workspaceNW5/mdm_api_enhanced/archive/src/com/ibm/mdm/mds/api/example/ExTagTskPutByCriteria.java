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

import madison.mpi.IxnTskPutByCriteria;
import madison.mpi.Row;
import madison.mpi.TskCriteria;

/**
 * This example illustrates the use of the IxnTskPutByCriteria interaction to
 * update the owner of all Task(Tsk) objects that meet a certain set of criteria.
 * The criteria allows specifying which tags must be applied to the tasks.
 *
 * In order for the tag to exist you must run the ExTagPut example.
 */
public class ExTagTskPutByCriteria extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTskPutByCriteria";

	public static void main(String[] args) throws Exception
	{
		// Create the interaction object.
		IxnTskPutByCriteria tskPut = new IxnTskPutByCriteria(getContext());

		// Create a new task criteria object.
		TskCriteria criteria = new TskCriteria();

		// Populate the criteria object.  Refer to the criteria JavaDoc
		// for all the available options.

		// search for a Task Type - Potential Duplicate
		criteria.addTskTypeno(2);

		// Set entity type as Identity (id)
		// Entity types are listed in mpi_enttype table.
		criteria.addEntTypeno(1);

		// Set the tagType for the example type 50.
		// Only update tasks that have this tag.
		criteria.addTagTypeno(50);

		// apply to all results
		int maxResults = 0;

		// set owner type of the tasks to USER
		char ownerType = Row.m_OWNERTYPE_USER;

		// set the owner to 'rwuser'
		int ownerRecno = 100;

		// Execute the interaction
		boolean status = tskPut.execute(criteria, maxResults, ownerType, ownerRecno);
		if (status)
		{
			long result = tskPut.getResult();
			info("The " + intrName + " interaction worked, number of tasks updated = " + result);
		}
		else
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + intrName + " interaction failed.", tskPut.getErrCode().toString(), tskPut.getErrText());
		}

		// Disconnect from Master Data Engine server
		disconnect();
	}
}
