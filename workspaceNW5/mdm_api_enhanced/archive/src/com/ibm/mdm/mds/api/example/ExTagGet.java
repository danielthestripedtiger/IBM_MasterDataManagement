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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import madison.mpi.EntXtsk;
import madison.mpi.IxnTagGet;
import madison.mpi.Tag;
import madison.mpi.TskKey;

/**
 * This example will illustrate the use of the IxnTagGet interaction.
 *
 * In order for the tag to exist you must run the ExTagPut example.
 */
public class ExTagGet extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTagGet";

	public static void main(String[] args) throws Exception
	{
		doGetTag();

		// Disconnect from Master Data Engine server
	    disconnect();
	}

	@SuppressWarnings("unchecked")
	public static Tag doGetTag() throws Exception
	{
		// Get the entity task that has the tag.
		EntXtsk entXtsk = ExMemGet.getEntXtsk(new String[] {"OUTP", "500567"});

		// Create the interaction object.
		IxnTagGet tagGet = new IxnTagGet(getContext());

		// Create a TskKey to get the tag.
		TskKey tskKey = new TskKey(entXtsk);

		// A list of TskKeys.
		List<TskKey> tskKeyList = new ArrayList<TskKey>();
		tskKeyList.add(tskKey);
		info("Task key: " + tskKey);

		// Get Tags with status of manual.
		String tagStatFilter = Tag.TAG_STAT_MANUAL;

		// Execute the interaction.
		boolean status = tagGet.execute(tskKeyList, tagStatFilter);
		if (status)
			info("The " + intrName + " interaction worked.");
		else
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + intrName + " interaction failed.", tagGet.getErrCode().toString(), tagGet.getErrText());
		}

		// After the interaction has been executed successfully, the result will
		// contain the Tags for the given Task.
		Map<TskKey, List<Tag>> result = (Map<TskKey, List<Tag>>)tagGet.getResult();

		List<Tag> tagResults = result.get(tskKey);
		if (tagResults == null || tagResults.isEmpty())
		{
			info("No Tags found.");
			return null;
		}
		else
		{
			for (Tag tag : tagResults)
			{
				info(tag.toString());
			}
			return tagResults.get(0);
		}


	}

	public static long getTagRecno() throws Exception
	{
		return doGetTag().getTagRecno();
	}
}
