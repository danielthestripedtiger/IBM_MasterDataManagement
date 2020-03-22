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
import madison.mpi.IxnDicGenKey;
import madison.mpi.SeqGen;

/**
 * This example illustrates the use of the IxnDicGenKey interaction. The return
 * value is the entire mpi_seqgen record with the next available sequence
 * number. In the database, we have certain attributes for which we should give
 * unique ids while inserting a new value.This class facilities that by
 * returning the next number in the sequence.
 */
public class ExDicGenKey extends BaseExample
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  private static final String intrName = "IxnDicGenKey";

  public static void main(String[] args) throws Exception
  {
    // Create the interaction
    IxnDicGenKey dicGenKey = new IxnDicGenKey(getContext());

    // Create dictionary row lists to hold the input and the results
    DicRowList  inDicRows  = new DicRowList();
    DicRowList  outDicRows = new DicRowList();

    // Set the SeqName as attrrecno as we want the
    // next sequence number for attrrecno.
    SeqGen seqGen = new SeqGen();
    seqGen.setSeqName("attrrecno");
    inDicRows.addRow(seqGen);

    // Execute the interaction.
    boolean status = dicGenKey.execute(inDicRows, outDicRows);
    if (status)
    {
      dumpRows(outDicRows, "The " + intrName + " interaction worked, here are the returned rows:");
      // Notice that the number increments every time this example is ran.
      info("The next sequence number for attrrecno is: " + outDicRows.rowAt(0).getAsString("seqNum"));
    }
    else
    {
      // Disconnect from Master Data Engine server
      disconnect();
      ixnError("The " + intrName + " interaction failed.", dicGenKey.getErrCode().toString(), dicGenKey.getErrText());
    }

    // Disconnect from Master Data Engine server
    disconnect();
  }
}
