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

import madison.mpi.Bean;
import madison.mpi.Context;
import madison.mpi.DicStore;
import madison.mpi.MemHead;
import madison.mpi.RowList;
import madison.mpi.UsrHead;

/**
 * This is a helper class for other examples. It holds some common members and
 * methods.
 */
public abstract class BaseExample 
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	private static SDKExampleLogicDelegate sdkExampleLogicDelegate = new SimpleSDKExampleLogicDelegate();

	public static void setSDKExampleLogicDelegate(SDKExampleLogicDelegate sdkExampleLogicDelegate)
	{
		BaseExample.sdkExampleLogicDelegate = sdkExampleLogicDelegate;
	}
	
	/**
	 * Creates a Context, UserHead, and a DicStore
	 * 
	 * @return Context
	 * @throws Exception
	 *             if the Context or a DicStore could not be created.
	 */
	protected static Context getContext() throws Exception 
	{
		return sdkExampleLogicDelegate.getContext();
	}

	/**
	 * Returns a DicStore. If the call to getContext() has not been made yet,
	 * this call is made to ensure that we have a valid Context
	 * 
	 * @return DicStore
	 * @throws Exception
	 *             if there was a problem with Context or DicStore creation.
	 */
	protected static DicStore getDicStore() throws Exception
	{
		return sdkExampleLogicDelegate.getDicStore();
	}

	/**
	 * Returns a UsrHead object with the user and password set. If the Context
	 * has not yet been created, it is created and then UsrHead is returned.
	 * 
	 * @return UsrHead
	 * @throws Exception
	 *             if Context or DicSstore could not be created.
	 */
	protected static UsrHead getUsrHead() throws Exception 
	{
		return sdkExampleLogicDelegate.getUsrHead();
	}

	/**
	 * Iterate through all the rows in a RowList, using the standard output
	 * (toString) for each row
	 * 
	 * @param rowList
	 *            RowList object
	 */
	protected static void dumpRows(RowList rowList, String msg) 
	{
		sdkExampleLogicDelegate.dumpRows(rowList, msg);
	}

	/**
	 * Iterate through all the row beans in a List, using the standard output
	 * (toString) for each row
	 * 
	 * @param rowList
	 *            Bean object
	 */
	protected static void dumpRows(List<? extends Bean> rowList, String msg) 
	{
		sdkExampleLogicDelegate.dumpRows(rowList, msg);
	}

	protected static void disconnect() 
	{
		sdkExampleLogicDelegate.disconnect();
	}

	/**
	 * This helper method constructs a MemHead object based on the String
	 * parameters passed to it.<BR>
	 * If two strings are passed then params[0] is assumed to be SrcCode and
	 * params[1] is assumed to be MemIdnum.<BR>
	 * If one string is passed then params[0] is assumed to be the MemRecno.
	 * 
	 * @param params
	 *            either SrcCode, MemIdnum or MemRecno
	 * @return MemHead (null if params are incorrectly passed).
	 */
	protected static MemHead makeMemHead(String... params) 
	{
		return sdkExampleLogicDelegate.makeMemHead(params);
	}

	protected static void ixnError(String msg, String errorCode, String errorMessage) throws Exception 
	{
		sdkExampleLogicDelegate.ixnError(msg, errorCode, errorMessage);
	}

	protected static void err(String msg) throws Exception 
	{
		sdkExampleLogicDelegate.err(msg);
	}

	protected static void info(String msg) 
	{
		sdkExampleLogicDelegate.info(msg);
	}

	/**
	 * This is a convenience method to allow the Entity Management to finish
	 * it's work. This method is implemented because some of the examples rely
	 * on work to be done by the Entity Mangers, which takes a few seconds (time
	 * varies based on hardware and EM configuration). During the internal unit
	 * testing within the unit test framework this method is
	 * overwritten with proprietary checks.
	 * 
	 * @param srcCode
	 * @param memIdnum
	 * @throws Exception
	 */
	protected static void waitForQueues(String srcCode, String memIdnum) throws Exception 
	{
		sdkExampleLogicDelegate.waitForQueues(srcCode, memIdnum);
	}
}
