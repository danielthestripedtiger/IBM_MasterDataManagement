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

import madison.mpi.EntXtsk;
import madison.mpi.MemAttrRow;
import madison.mpi.MemHead;
import madison.mpi.MemName;
import madison.mpi.MemRow;
import madison.mpi.MemRowList;
import madison.mpi.MemXeia;
import madison.mpi.Row;
import madison.mpi.RowIterator;
import madison.util.ClassTest;
import madison.util.CompareException;
import madison.util.CompareKey;
import madison.util.GetterException;
/**
 * This class houses a number of different methods that work with RowList
 * objects. The illustrated calls are here to show off the various ways RowLists
 * can be traversed.
 */
public class ExRowWork
{
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";
  /**
   * This method illustrates the ClassTest use.
   *
   * @param rl
   *          MemRowList
   * @return long the first entRecno from the first MemHead in the list
   * @throws ClassNotFoundException
   *           if the ClassTest could not be created.
   */
  protected static long getEntRecno(MemRowList rl) throws ClassNotFoundException
  {
    long entRecno = 0L;
    // First let us find the MemHead row.
    // We can create a ClassTest via an object-based constructor:
    ClassTest ct = new ClassTest("MemHead");
    // We are going to get a RowIterator with a ClassTest clause
    RowIterator iter = rl.rows(ct);
    // This iterator will only iterate through rows that are of type MemHead.
    MemHead mh = null;
    while(iter.hasMoreRows())
    {
      mh = (MemHead) iter.nextRow();
      // Because we executed IxnMemGet with Entity Type specified and used
      // GetType.ASENTITY the entRecno List returned by the .getEntRecnos()
      // will only contain one member.
      return mh.getEntRecnos()[0];
    }
    return entRecno;
  }

  /**
   * This method illustrates the ClassTest use.
   *
   * @param rl
   *          MemRowList
   * @return EntXtsk the first EntXtsk in thelist
   * @throws ClassNotFoundException
   *           if the ClassTest could not be created.
   */
  protected static EntXtsk getEntXtsk(MemRowList rl) throws ClassNotFoundException
  {
    EntXtsk entXtsk = null;
    // Let us find the EntXtsk row.
    // We can create a ClassTest via an object-based constructor:
    ClassTest ct = new ClassTest("EntXtsk");
    // We are going to get a RowIterator with a ClassTest clause
    RowIterator iter = rl.rows(ct);
    // This iterator will only iterate through rows that are of type EntXtsk.
    while(iter.hasMoreRows())
    {
      return (EntXtsk) iter.nextRow();
    }
    return entXtsk;
  }

  /**
   * This method illustrates the iterator and instanceof use.
   *
   * @param rl
   *          MemRowList
   * @return long the Super EntRecno for the MemXeia task row where EiaType is
   *         Undelete
   */
  protected static long getSupMemRecnoFromUndeleteTask(MemRowList rl)
  {
    long supMemRecno = 0L;
    // We are going to get a RowIterator
    RowIterator iter = rl.rows();
    while(iter.hasMoreRows())
    {
      Row r = iter.nextRow();
      // Check if we are at a MemXeia row
      if(r instanceof MemXeia)
      {
        MemXeia mxe = (MemXeia) r;
        // Check if the EiaType is Undelete
        if(mxe.getEiaType().equalsIgnoreCase("Undelete"))
          // Return the Super MemRecno from this MemXeia row:
          supMemRecno = mxe.getSupMemRecno();
      }
    }
    return supMemRecno;
  }

  /**
   * This helper method illustrates the use of ClassTest in combination with
   * CompareKey.
   *
   * @param rl
   *          MemRowList
   */
  protected static void iterateWithSort(MemRowList rl)
  {
    ClassTest classTestMemName = null;
    CompareKey compKey = null;
    try
    {
      // We can create a ClassTest via a string-based constructor:
      classTestMemName = new ClassTest("madison.mpi.MemName");
      //A sort string is needed for the CompareKey:
      String sortString = "-getOnmLast,+getOnmFirst";
      compKey = new CompareKey(MemName.class, sortString);
    } catch (ClassNotFoundException e)
    {
      // This exception would have been thrown if madison.mpi.MemName
      // were not a valid class
    } catch (CompareException e)
    {
      // This exception would have been thrown if our sortString
      // was referencing non-existing fields.
    }
    // Now we can get a RowItterator that will only contain
    // MemName rows, sorted in descending order on onmLast
    // and further sorted in ascending order on onmFirst
    RowIterator iter = rl.rows(classTestMemName, compKey);
    // We could also specify the sorting algorithm:
    // iter = rl.rows(classTestMemName, compKey, RowList.SORT_SELECTION);
    // See API documentation for the detailed explanation of
    // three different sort algorithms.
    MemRowList tl = new MemRowList();
    while(iter.hasMoreRows())
    {
      MemRow mRow = (MemRow) iter.nextRow();
      tl.addRow(mRow);
    }
    // And while we are at it let us see how to work with MemRowList as an array
    toArray(tl);
  }

  /**
   * This helper method illustrates that MemRowList can be easily converted to
   * an Array, and accessed as one.<BR>
   * This method will also illustrate the .findRow() call.<BR>
   * This method also transforms a MemAttrRow into an XML String.
   *
   * @param rl
   *          MemRowList
   */
  protected static void toArray(MemRowList rl)
  {
    MemRow[] rmArray = rl.listToArray();
    for(int x = 0; x < rmArray.length; x ++)
    {
      try
      {
        System.out.println(rmArray[x].getString("onmLast") + ", " + rmArray[x].getString("onmFirst"));
      } catch (GetterException ge)
      {
        // This exception would have been thrown if onmLast or onmFirst
        // were invalid field names.
      }
    }
    MemRow memRow = rmArray[rmArray.length - 1];
    try
    {
      MemAttrRow mar = rl.findRow(memRow.getMemRecno(), memRow.getInt("memSeqno"));
      // We could convert the found row to an XML string:
      String xmlRow = mar.toSmallXMLString();
      System.out.println("First tag in XML: " + xmlRow.substring(0, xmlRow.indexOf('>') + 1));
      System.out.println("Last tag in XML: " + xmlRow.substring(xmlRow.lastIndexOf('<')));
      // Or you could create a DOM Document out of it (assuming you have
      // the appropriate jars).  You can try it by uncommenting the imports
      // and removing the block comment below:
      /*
      try
      {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlRow)));
        doc.getFirstChild();
      } catch (Exception e)
      {
        e.printStackTrace();
      }
      */
    } catch (GetterException e)
    {
      // This exception would have been thrown if memSeqno were not a valid
      // field name.
    }
  }
}
