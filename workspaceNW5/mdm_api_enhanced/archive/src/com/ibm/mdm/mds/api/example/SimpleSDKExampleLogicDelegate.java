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
/*
Licensed Materials - Property of IBM PID # 5725-E59 (c) Copyright 2012 IBM
Corporation.  IBM, the IBM logo, InfoSphere, Initiate, and Initiate Master Data Service are
trademarks of IBM Corp., registered in many jurisdictions worldwide. Java and
all Java-based trademarks and logos are trademarks or registered trademarks of
Oracle and/or its affiliates.  Other product and service names might be
trademarks of IBM, or other companies. This Program is licensed under the terms
of the license agreement accompanying the Program. This license agreement may
be either located in a Program directory folder or library identified as
"License" or "Non-IBM License", if applicable, or provided as a printed license
agreement. Please read this agreement carefully before using the Program. By
using the Program, you agree to these terms.
*/
package com.ibm.mdm.mds.api.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;



import madison.mpi.Bean;
import madison.mpi.Context;
import madison.mpi.DicStore;
import madison.mpi.MemHead;
import madison.mpi.Row;
import madison.mpi.RowIterator;
import madison.mpi.RowList;
import madison.mpi.UsrHead;


public class SimpleSDKExampleLogicDelegate implements SDKExampleLogicDelegate
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static ExContextFactory ecf = null;
	private static ExContextWrapper ecw = null;
	private static DicStore dicStore = null;
	private static UsrHead usrHead = null;

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#getContext()
	 */
	public Context getContext() throws Exception
	{
	    if(ecf == null)
	    {
	      ecf = ExContextFactory.getInstance(null);
	      ecw = ecf.getWrappedContext();
	      usrHead = ecf.getUsrHead();
	      try
	      {
	        dicStore = new DicStore(ecw);
	      } catch (IOException ioe)
	      {
	        err("DicStore could not be created.  " +
	            "Possibly due to the userId and/or password not being valid. Underlying IOException: "
	            + ioe.toString());
	      }
	    }
	    return ecw;
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#getDicStore()
	 */
	public DicStore getDicStore() throws Exception
	{
	    if(dicStore == null)
	      getContext();
	    return dicStore;
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#getUsrHead()
	 */
	public UsrHead getUsrHead() throws Exception
	{
	    if(usrHead == null)
	      getContext();
	    return usrHead;
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#dumpRows(madison.mpi.RowList, java.lang.String)
	 */
	public void dumpRows(RowList rowList, String msg)
	{
	    msg = (msg == null) ? "***** " : "***** " + msg;
	    Row row = null;
	    info("\n" + msg);
	    info("** Begin Row Dump:");
	    for(RowIterator memIter = rowList.rows(); memIter.hasMoreRows();)
	    {
	      row = (Row) memIter.nextRow();
	      info(row.toString());
	    }
	    info("** End Row Dump.\n");
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#dumpRows(java.util.List, java.lang.String)
	 */
	public void dumpRows(List<? extends Bean> rowList, String msg)
	{
	    msg = (msg == null) ? "***** " : "***** " + msg;
	    Bean row = null;
	    info("\n" + msg);
	    info("** Begin Row Dump:");
	    for(Iterator<? extends Bean> iter = rowList.iterator(); iter.hasNext();)
	    {
	      row = (Bean) iter.next();
	      info(row.toString());
	    }
	    info("** End Row Dump.\n");
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#disconnect()
	 */
	public void disconnect()
	{
	    if(ecw != null)
	      ecf.freeContext(ecw);
	    // Since we are executing the examples one-at-a-time there is no
	    // reason to keep the Context Pool around:
	    ecf.destroyAllContexts();
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#makeMemHead(java.lang.String[])
	 */
	public MemHead makeMemHead(String ... params)
	{
	    MemHead memHead = null;
	    if(params != null && params.length >=1 && params.length <= 2)
	    {
	      memHead = new MemHead();
	      if(params.length == 1)
	        memHead.setMemRecno(Long.parseLong(params[0]));
	      else
	      {
	        memHead.setSrcCode(params[0]);
	        memHead.setMemIdnum(params[1]);
	      }
	    }
	    return memHead;
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#ixnError(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void ixnError(String msg, String errorCode, String errorMessage) throws Exception
	{
	    StringBuffer errMsg = new StringBuffer();
	    errMsg.append("***** ").append(msg);
	    errMsg.append("\n ERROR: " + errorCode);
	    errMsg.append("\n errText = " + errorMessage);
	    err(errMsg.toString());
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#err(java.lang.String)
	 */
	public void err(String msg) throws Exception
	{
	    System.err.println(msg);
	    throw new Exception(msg);
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#info(java.lang.String)
	 */
	public void info(String msg)
	{
	    System.out.println(msg);
	}

	/*
	 * (non-Javadoc)
	 * @see SDKExampleLogicDelegate#waitForQueues(java.lang.String, java.lang.String)
	 */
	public void waitForQueues(String srcCode, String memIdnum) throws Exception
	{
	    int pause = 11000;
	    info("Sleeping for " + pause / 1000 + " seconds to allow EM to complete the work related to the member " + srcCode + ":" + memIdnum);
	    Thread.sleep(pause);
	}
}
