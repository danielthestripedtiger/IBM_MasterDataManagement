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

import madison.mpi.IxnTagReset;

/**
 * This example illustrates the use of IxnTagReset interaction.
 *
 * In order for this example to work you must run the ExTagPut example first.
 */
public class ExTagReset extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTagReset";

	public static void main(String[] args) throws Exception
	{
		// Create the interaction object
		IxnTagReset tagReset = new IxnTagReset(getContext());

		List<Integer> tagTypenoList = new ArrayList<Integer>();
		// Set the tagType to reset for the example type 50.
		// All existing tags for this tag type are deleted.
		// If the tag type had rules, then the tag engine would automatically
		// apply tags for all tasks based on the current rule definitions.
		tagTypenoList.add(50);

		// Execute the interaction.
		boolean status = tagReset.execute(tagTypenoList);
		if (status)
			info("The " + intrName + " interaction worked, the tag type has been reset.");
		else
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + intrName + " interaction failed.", tagReset.getErrCode().toString(), tagReset.getErrText());
		}

		// Disconnect from Master Data Engine server
		disconnect();
	}
}
