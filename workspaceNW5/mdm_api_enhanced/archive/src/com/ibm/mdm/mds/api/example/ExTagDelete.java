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

import madison.mpi.IxnTagDelete;

/**
 * This example illustrates the use of IxnTagDelete interaction.
 *
 * In order for this example to work you must run the ExTagPut example first.
 */
public class ExTagDelete extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTagDelete";

	public static void main(String[] args) throws Exception
	{
		// Create the interaction object
		IxnTagDelete tagDel = new IxnTagDelete(getContext());

		List<Long> tagRecnoList = new ArrayList<Long>();

		// We need the tagRecno number to perform the IxnTagDelete. This number is
		// created during the ExTagPut. Since this number will change every time we
		// run ExTagPut we are going to call the ExTagGet.getTagRecno() method to
		// find the appropriate Recno.
		// Reference the ExTagGet example to see how we can get the Recno of a
		// specific tag.
		Long tagRecno = ExTagGet.getTagRecno();
		tagRecnoList.add(tagRecno);

		// Execute the interaction.
		boolean status = tagDel.execute(tagRecnoList);
		if (status)
			info("The " + intrName +
					" interaction worked, the tag has been deleted.");
		else
		{
			// Disconnect from Master Data Engine server
			disconnect();
			ixnError("The " + intrName + " interaction failed.", tagDel.getErrCode().toString(), tagDel.getErrText());
		}

		// Disconnect from Master Data Engine server
		disconnect();
	}
}
