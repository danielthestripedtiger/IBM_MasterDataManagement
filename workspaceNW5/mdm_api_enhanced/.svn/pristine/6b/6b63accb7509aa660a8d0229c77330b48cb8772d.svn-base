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
Licensed Materials - Property of IBM PID # 5725-E59 (c) Copyright 1995, 2012 IBM
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

import java.util.List;

import madison.mpi.Bean;
import madison.mpi.Context;
import madison.mpi.DicStore;
import madison.mpi.MemHead;
import madison.mpi.RowList;
import madison.mpi.UsrHead;

public interface SDKExampleLogicDelegate 
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
	 Context getContext() throws Exception;
	 DicStore getDicStore() throws Exception;
	 UsrHead getUsrHead() throws Exception;
	 void dumpRows(RowList rowList, String msg);
	 void dumpRows(List<? extends Bean> rowList, String msg);
	 void disconnect();
	 MemHead makeMemHead(String ... params);
	 void ixnError(String msg, String errorCode, String errorMessage) throws Exception;
	 void err(String msg) throws Exception;
	 void info(String msg);
	 void waitForQueues(String srcCode, String memIdnum) throws Exception;
}
