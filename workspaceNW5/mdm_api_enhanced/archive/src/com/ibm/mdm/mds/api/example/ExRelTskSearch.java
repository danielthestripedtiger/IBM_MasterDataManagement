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
import java.util.Iterator;
import java.util.List;

import madison.mpi.IxnRelTskSearch;
import madison.mpi.KeyType;
import madison.mpi.RelXtsk;
import madison.mpi.RelXtskCriteria;

/**
 * This example will illustrates the use of the IxnRelTskSearch interaction.
 *
 * You must run the ExRelTskCreate example to create the tasks we will be
 * searching for.
 *
 * The method getRelTsks() from this example is used by other ExRelTsk*
 * examples.
 */
public class ExRelTskSearch extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnRelTskSearch";
  private static final String[] memberOne = new String[]{"RMC", "204894"};
  private static final String[] memberTwo = new String[]{"ARH", "159603"};

  public static void main(String[] args) throws Exception
  {
    getRelTsks();
  }

  @SuppressWarnings("unchecked")
  public static List<RelXtsk> getRelTsks() throws Exception
  {
    // Holder for our return.
    List<RelXtsk> retList = new ArrayList<RelXtsk>();

    // Create the interaction object.
    IxnRelTskSearch relTskSearch = new IxnRelTskSearch(getContext());

    // IxnRelTskSearch requires a RelXtskCriteria to execute, so here we create one.
    RelXtskCriteria criteria = new RelXtskCriteria();

    // We can limit the tasks by the status (defined in mpi_tststat table).
    // For example task status of 1 = Unexamined
    // criteria.addTskStatno(1);
    // Disabled in this example, because this method is used by other ExRelTsk*
    // examples, which need to get all of the relationship tasks, regardless of
    // the status.

    // Set the relationship type.
    // In this case we are using 50 (Boss), which is defined in the mpi_tsktype
    // table.
    criteria.addRelTypeno(50);

    // We want all of the tasks for a specific entity to be returned, and so we
    // are using KeyType.ENTRECNO
    criteria.setKeyType(KeyType.ENTRECNO);
    // and supply the entRecno
    criteria.setEntRecno(ExMemGet.getEntRecno(memberOne));
    // Alternately we can use memRecno or memIdnum, much like in other search
    // interactions.
    // We would have to use KeyType.MEMRECNO or KeyType.MEMIDNUM in these cases.

    // Entity types are defined in the mpi_enttype table.
    criteria.setEntType("id");

    boolean status = relTskSearch.execute(criteria);
    if (status)
    {
      info("The " + intrName + " interaction worked for entRecno = " + ExMemGet.getEntRecno(memberOne));
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relTskSearch.getErrCode().toString(), relTskSearch.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();

    // Getting the result of the execution
    List<RelXtsk> result = (List<RelXtsk>)relTskSearch.getResult();
    // Assuming there was a task (after running the ExRelTskCreate) we can get the tskRecnos
    for(Iterator<RelXtsk> iter = result.iterator(); iter.hasNext();)
    {
      retList.add(iter.next());
    }

    // Now we will get the tskRecno list for using the other member (which we
    // also used in the ExRelTskCreate example).
    // Note that we are re-using most of the object we have had created for the
    // first execute() call.
    criteria.setEntRecno(ExMemGet.getEntRecno(memberTwo));
    status = relTskSearch.execute(criteria);
    if (status)
    {
      info("The " + intrName + " interaction worked for entRecno = " + ExMemGet.getEntRecno(memberTwo));
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", relTskSearch.getErrCode().toString(), relTskSearch.getErrText());
    }

    // Getting the result of the execution
    result = (List<RelXtsk>)relTskSearch.getResult();
    // Assuming there was a task (after running the ExRelTskCreate) we can get the tskRecnos
    for(Iterator<RelXtsk> iter = result.iterator(); iter.hasNext();)
    {
      retList.add(iter.next());
    }
    // Getting the result of the execution
    return retList;
  }
}
