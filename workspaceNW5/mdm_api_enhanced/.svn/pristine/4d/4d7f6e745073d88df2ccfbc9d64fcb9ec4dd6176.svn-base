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

import madison.mpi.DicRowList;
import madison.mpi.IxnDicPut;
import madison.mpi.RowInd;
import madison.mpi.SegAttr;
import madison.mpi.SrcHead;

/**
 * This example illustrates the use of IxnDicPut interaction. IxnDicPut is used
 * to insert/delete dictionary data.
 */
public class ExDicPut extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnDicPut";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction object.
    IxnDicPut dicPut = new IxnDicPut(getContext());

    //create a DicRowList with initial size of 2, and grow by 10
    DicRowList dicList = new DicRowList(2, 10);

    // Create various Dic subclasses. By calling the constructor with a 0, a
    // reserved memRecno will be created.

    // Create various Dic subclasses
    SrcHead srcHead = new SrcHead();
    srcHead.setSrcRecno(255);
    srcHead.setMemTypeno(1);
    srcHead.setSrcCode("TST");
    srcHead.setPhyCode("TST");
    srcHead.setSrcType("D");
    srcHead.setRiCheck("Y");
    srcHead.setSrcName("Test Mental Health Center");
	srcHead.setDefEntPrior((short)100);

    SegAttr segAttr = new SegAttr();
    segAttr.setAttrRecno(255);
    segAttr.setMemTypeno(1);
    segAttr.setSegCode("MEMATTR");
    segAttr.setAttrCode("TSTATTR");
    segAttr.setAttrName("Test Attribute");
    segAttr.setAttrLabel("Test Label");
    segAttr.setMsFilter("A");

    // Set the type of operation we are going to do on each of the rows we
    // created based on the user's choice. Note that the dicPut interaction can
    // be used to insert as well as delete dictionary values. The RowInd value
    // determines whether it is an insert, update, or delete.
    // srcHead.setRowInd(RowInd.INSERT);
    // segAttr.setRowInd(RowInd.INSERT);
    srcHead.setRowInd(RowInd.UPDATE);
    segAttr.setRowInd(RowInd.UPDATE);
    // srcHead.setRowInd(RowInd.DELETE);
    // segAttr.setRowInd(RowInd.DELETE);

    // There is also an RowInd.UPDATE option available.

    dicList.addRow(segAttr);
    dicList.addRow(srcHead);

    // Execute the dictionary put interaction.
    boolean status = dicPut.execute(dicList);
    if (status)
      info("The " + intrName + " interaction worked.");
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", dicPut.getErrCode().toString(), dicPut.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
