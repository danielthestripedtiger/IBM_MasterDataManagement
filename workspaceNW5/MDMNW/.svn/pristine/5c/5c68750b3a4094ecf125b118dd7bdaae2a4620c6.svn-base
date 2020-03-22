/*
 * The following source code ("Code") may only be used in accordance with the terms
 * and conditions of the license agreement you have with IBM Corporation. The Code 
 * is provided to you on an "AS IS" basis, without warranty of any kind.  
 * SUBJECT TO ANY STATUTORY WARRANTIES WHICH CAN NOT BE EXCLUDED, IBM MAKES NO 
 * WARRANTIES OR CONDITIONS EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
 * TO, THE IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE, AND NON-INFRINGEMENT, REGARDING THE CODE. IN NO EVENT WILL 
 * IBM BE LIABLE TO YOU OR ANY PARTY FOR ANY DIRECT, INDIRECT, SPECIAL OR OTHER 
 * CONSEQUENTIAL DAMAGES FOR ANY USE OF THE CODE, INCLUDING, WITHOUT LIMITATION, 
 * LOSS OF, OR DAMAGE TO, DATA, OR LOST PROFITS, BUSINESS, REVENUE, GOODWILL, OR 
 * ANTICIPATED SAVINGS, EVEN IF IBM HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH 
 * DAMAGES. SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF 
 * INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THE ABOVE LIMITATION OR EXCLUSION MAY 
 * NOT APPLY TO YOU.
 */

/*
 * IBM-MDMWB-1.0-[d2701047d8d8755d273ec759acb6df3a]
 */

package mdmnw.bobj.query;




import com.dwl.base.DWLControl;
import com.dwl.bobj.query.BObjQueryException;
import com.dwl.base.DWLCommon;


import com.dwl.base.db.DataAccessFactory;

import com.dwl.base.interfaces.IGenericResultSetProcessor;

import com.dwl.tcrm.coreParty.bobj.query.PartyAddressBObjQuery;

import com.dwl.tcrm.coreParty.component.TCRMPartyAddressBObj;

import mdmnw.component.XNWPartyAddressBObjExt;
import mdmnw.component.XNWPartyAddressExtResultSetProcessor;

import mdmnw.entityObject.EObjxNWPartyAddressExtData;
import mdmnw.entityObject.XNWPartyAddressExtInquiryData;





/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class extends the <code>PartyAddressBObjQuery</code> class.
 *
 * @generated
 */
public class XNWPartyAddressExtBObjQuery extends PartyAddressBObjQuery {

	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWPartyAddressExtBObjQuery.class);
   
   /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Default constructor.
     *
     * @param queryName
     *     The name of the query.
     * @param control
     *     The control object.
     *
     * @generated
     */
    public XNWPartyAddressExtBObjQuery(String queryName, DWLControl control) {
        super(queryName, control);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Default constructor.
     *
     * @param persistenceStrategyName
     * The persistence strategy name.  This parameter indicates the type of
     * database action to be taken such as addition, update or deletion of
     * records.
     * @param objectToPersist
     * The business object to be persisted.
     *
     * @generated
     */
    public XNWPartyAddressExtBObjQuery(String persistenceStrategyName, DWLCommon objectToPersist) {
        super(persistenceStrategyName, objectToPersist);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
	protected void persist() throws Exception{
    logger.finest("ENTER persist()");
    if (logger.isFinestEnabled()) {
    		String infoForLogging="Persistence strategy is " + persistenceStrategyName;
      logger.finest("persist() " + infoForLogging);
    }
    if (logger.isFinestEnabled()) {
      String infoForLogging=" Extension with fields added to DB table";
      logger.finest("persist() " + infoForLogging);
    }
    if (objectToPersist instanceof XNWPartyAddressBObjExt) {
      String infoForLogging="persist() instanceof XNWPartyAddressBObjExt";
      logger.finest("persist() " + infoForLogging);
      if (persistenceStrategyName.equals(PARTY_ADDRESS_ADD)) {
        addxNWPartyAddress();
      }else if(persistenceStrategyName.equals(PARTY_ADDRESS_UPDATE)) {
        updatexNWPartyAddress();
      }else if(persistenceStrategyName.equals(PARTY_ADDRESS_DELETE)) {
        deletexNWPartyAddress();
      }else {
        super.persist();
      }
    } else {
      if (logger.isFinestEnabled()) {
        String infoForLogging="Call super.persist()";
      logger.finest("persist() " + infoForLogging);
      }
      super.persist();
    }		
    
    logger.finest("RETURN persist()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
      * Inserts xnwpartyaddress data by calling
      * <code>EObjxNWPartyAddressExtData.createEObjxNWPartyAddress</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void addxNWPartyAddress() throws Exception{
    logger.finest("ENTER addxNWPartyAddress()");
    EObjxNWPartyAddressExtData theEObjxNWPartyAddressExtData = (EObjxNWPartyAddressExtData) DataAccessFactory
      .getQuery(EObjxNWPartyAddressExtData.class, connection);
 		theEObjxNWPartyAddressExtData.createEObjxNWPartyAddressExt(
 		                                 ((TCRMPartyAddressBObj) objectToPersist).getEObjAddressGroup(),
 		                                 ((XNWPartyAddressBObjExt) objectToPersist).getEObjxNWPartyAddressExt());
    logger.finest("RETURN addxNWPartyAddress()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
      * Updates xnwpartyaddress data by calling
      * <code>EObjxNWPartyAddressExtData.updateEObjxNWPartyAddress</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void updatexNWPartyAddress() throws Exception{
    logger.finest("ENTER updatexNWPartyAddress()");
    EObjxNWPartyAddressExtData theEObjxNWPartyAddressExtData = (EObjxNWPartyAddressExtData) DataAccessFactory
      .getQuery(EObjxNWPartyAddressExtData.class, connection);
 		theEObjxNWPartyAddressExtData.updateEObjxNWPartyAddressExt(
 		                                 ((TCRMPartyAddressBObj) objectToPersist).getEObjAddressGroup(),
 		                                 ((XNWPartyAddressBObjExt) objectToPersist).getEObjxNWPartyAddressExt());
    logger.finest("RETURN updatexNWPartyAddress()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
      * Deletes xnwpartyaddress data by calling
      * <code>EObjxNWPartyAddressExtData.deleteEObjxNWPartyAddress</code>
   *
     * @throws Exception
     *
     * @generated
     */
	protected void deletexNWPartyAddress() throws Exception{
    logger.finest("ENTER deletexNWPartyAddress()");
    Long id = ((XNWPartyAddressBObjExt) objectToPersist).getEObjAddressGroup().getLocationGroupIdPK();
    EObjxNWPartyAddressExtData theEObjxNWPartyAddressExtData = (EObjxNWPartyAddressExtData) DataAccessFactory
      .getQuery(EObjxNWPartyAddressExtData.class, connection);
    theEObjxNWPartyAddressExtData.deleteEObjxNWPartyAddressExt(id);
    logger.finest("RETURN deletexNWPartyAddress()");
    } 



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Provides the result set processor that is used to populate the business
     * object.
     *
     * @return
     * An instance of <code>XNWPartyAddressExtResultSetProcessor</code>.
     *
     * @see com.dwl.bobj.query.AbstractBObjQuery#provideResultSetProcessor()
     * @see mdmnw.component.XNWPartyAddressExtResultSetProcessor
     *
     * @generated
     */
    protected IGenericResultSetProcessor provideResultSetProcessor()
            throws BObjQueryException {

        return new XNWPartyAddressExtResultSetProcessor();
    }    


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected String getSQLStatement() throws BObjQueryException {
        String sql = super.getSQLStatement();
        if (sql != null) {
            return sql;
        }
        return getSQLStatement(super.provideQueryInterfaceClass());
    }
}


