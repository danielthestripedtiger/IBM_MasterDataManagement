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

import madison.mpi.EntXtsk;
import madison.mpi.IxnTagPut;
import madison.mpi.Tag;

/**
 * This example will illustrate the use of the IxnTagPut interaction. The
 * resulting rows will be used in the other ExTag* examples.
 *
 * Note that once this example has been ran the tag is created,
 * running the example again will result in an Exception.
 *
 * You can delete the tag via the ExTagDelete example.
 */
public class ExTagPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static final String intrName = "IxnTagPut";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		// Get an entity task for the tag
		EntXtsk entXtsk = ExMemGet.getEntXtsk(new String[]{"OUTP", "500567"});

		// Create the interaction object.
		IxnTagPut tagPut = new IxnTagPut(getContext());

		// Create the Tag object.
		Tag tag1 = new Tag();

		// Set the tagType for the example type 50.
		tag1.setTagTypeno(50);

		// Set the entTypeno for the tag to match the task.
		// The entTypeno should be set to 0 for a tag on a MemXtsk.
		tag1.setEntTypeno(entXtsk.getEntTypeno());
		// Set the memRecno for the tag to match the task.
		tag1.setMemRecno(entXtsk.getMemRecno());
		tag1.setTskTypeno(entXtsk.getTskTypeno());
		tag1.setTskRecno(entXtsk.getTskRecno());

		// Set the status for a manual tag.
		tag1.setTagStat(Tag.TAG_STAT_MANUAL);

		List<Tag> tagList = new ArrayList<Tag>();
		tagList.add(tag1);

		// Execute the interaction.
	    boolean status = tagPut.execute(tagList);
	    if (status)
	      info("The " + intrName + " interaction worked, tag has been created.");
	    else
	    {
	    	// Disconnect from Master Data Engine server
	    	disconnect();
	    	ixnError("The " + intrName + " interaction failed.", tagPut.getErrCode().toString(), tagPut.getErrText());
	    }

	    // We can get the Recno of the newly-created tag.
	    // This number is used in ExTagDelete example.
	    tagList = (List<Tag>) tagPut.getResult();
	    long tagRecno = tagList.get(0).getTagRecno();
	    info("The newly-created tag has a Recno = " + tagRecno);

		// Disconnect from Master Data Engine server
	    disconnect();
	}
}
