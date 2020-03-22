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
 * IBM-MDMWB-1.0-[be3be9b263db53db21dffcc13883a02a]
 */

package mdmnw.bobj.query;




import com.dwl.base.DWLControl;
import com.dwl.bobj.query.BObjQueryException;
import com.dwl.base.DWLCommon;


import com.dwl.base.db.DataAccessFactory;

import com.dwl.base.interfaces.IGenericResultSetProcessor;

import com.dwl.tcrm.coreParty.bobj.query.AddressBObjQuery;

import com.dwl.tcrm.coreParty.component.TCRMAddressBObj;

import mdmnw.component.XNWAddressBObjExt;
import mdmnw.component.XNWAddressExtResultSetProcessor;

import mdmnw.entityObject.EObjxNWAddressExtData;
import mdmnw.entityObject.XNWAddressExtInquiryData;





/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class extends the <code>AddressBObjQuery</code> class.
 *
 * @generated
 */
public class XNWAddressExtBObjQuery extends AddressBObjQuery {

	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWAddressExtBObjQuery.class);
   
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
    public XNWAddressExtBObjQuery(String queryName, DWLControl control) {
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
    public XNWAddressExtBObjQuery(String persistenceStrategyName, DWLCommon objectToPersist) {
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
    if (objectToPersist instanceof XNWAddressBObjExt) {
      String infoForLogging="persist() instanceof XNWAddressBObjExt";
      logger.finest("persist() " + infoForLogging);
      if (persistenceStrategyName.equals(ADDRESS_ADD)) {
        addxNWAddress();
      }else if(persistenceStrategyName.equals(ADDRESS_UPDATE)) {
        updatexNWAddress();
      }else if(persistenceStrategyName.equals(ADDRESS_DELETE)) {
        deletexNWAddress();
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
      * Inserts xnwaddress data by calling
      * <code>EObjxNWAddressExtData.createEObjxNWAddress</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void addxNWAddress() throws Exception{
    logger.finest("ENTER addxNWAddress()");
    EObjxNWAddressExtData theEObjxNWAddressExtData = (EObjxNWAddressExtData) DataAccessFactory
      .getQuery(EObjxNWAddressExtData.class, connection);
 		theEObjxNWAddressExtData.createEObjxNWAddressExt(
 		                                 ((TCRMAddressBObj) objectToPersist).getEObjAddress(),
 		                                 ((XNWAddressBObjExt) objectToPersist).getEObjxNWAddressExt());
    logger.finest("RETURN addxNWAddress()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
      * Updates xnwaddress data by calling
      * <code>EObjxNWAddressExtData.updateEObjxNWAddress</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void updatexNWAddress() throws Exception{
    logger.finest("ENTER updatexNWAddress()");
    EObjxNWAddressExtData theEObjxNWAddressExtData = (EObjxNWAddressExtData) DataAccessFactory
      .getQuery(EObjxNWAddressExtData.class, connection);
 		theEObjxNWAddressExtData.updateEObjxNWAddressExt(
 		                                 ((TCRMAddressBObj) objectToPersist).getEObjAddress(),
 		                                 ((XNWAddressBObjExt) objectToPersist).getEObjxNWAddressExt());
    logger.finest("RETURN updatexNWAddress()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
      * Deletes xnwaddress data by calling
      * <code>EObjxNWAddressExtData.deleteEObjxNWAddress</code>
   *
     * @throws Exception
     *
     * @generated
     */
	protected void deletexNWAddress() throws Exception{
    logger.finest("ENTER deletexNWAddress()");
    Long id = ((XNWAddressBObjExt) objectToPersist).getEObjAddress().getAddressIdPK();
    EObjxNWAddressExtData theEObjxNWAddressExtData = (EObjxNWAddressExtData) DataAccessFactory
      .getQuery(EObjxNWAddressExtData.class, connection);
    theEObjxNWAddressExtData.deleteEObjxNWAddressExt(id);
    logger.finest("RETURN deletexNWAddress()");
    } 



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Provides the result set processor that is used to populate the business
     * object.
     *
     * @return
     * An instance of <code>XNWAddressExtResultSetProcessor</code>.
     *
     * @see com.dwl.bobj.query.AbstractBObjQuery#provideResultSetProcessor()
     * @see mdmnw.component.XNWAddressExtResultSetProcessor
     *
     * @generated
     */
    protected IGenericResultSetProcessor provideResultSetProcessor()
            throws BObjQueryException {

        return new XNWAddressExtResultSetProcessor();
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


