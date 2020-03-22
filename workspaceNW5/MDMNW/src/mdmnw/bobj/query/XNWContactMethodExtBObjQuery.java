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
 * IBM-MDMWB-1.0-[fd3b10c2fec8421a5f09742493c48f34]
 */

package mdmnw.bobj.query;




import com.dwl.base.DWLControl;
import com.dwl.bobj.query.BObjQueryException;
import com.dwl.base.DWLCommon;


import com.dwl.base.db.DataAccessFactory;

import com.dwl.base.interfaces.IGenericResultSetProcessor;

import com.dwl.tcrm.coreParty.bobj.query.ContactMethodBObjQuery;

import com.dwl.tcrm.coreParty.component.TCRMContactMethodBObj;

import mdmnw.component.XNWContactMethodBObjExt;
import mdmnw.component.XNWContactMethodExtResultSetProcessor;

import mdmnw.entityObject.EObjxNWContactMethodExtData;





/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class extends the <code>ContactMethodBObjQuery</code> class.
 *
 * @generated
 */
public class XNWContactMethodExtBObjQuery extends ContactMethodBObjQuery {

	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWContactMethodExtBObjQuery.class);
   
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
    public XNWContactMethodExtBObjQuery(String queryName, DWLControl control) {
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
    public XNWContactMethodExtBObjQuery(String persistenceStrategyName, DWLCommon objectToPersist) {
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
    if (objectToPersist instanceof XNWContactMethodBObjExt) {
      String infoForLogging="persist() instanceof XNWContactMethodBObjExt";
      logger.finest("persist() " + infoForLogging);
      if (persistenceStrategyName.equals(CONTACT_METHOD_ADD)) {
        addxNWContactMethod();
      }else if(persistenceStrategyName.equals(CONTACT_METHOD_UPDATE)) {
        updatexNWContactMethod();
      }else if(persistenceStrategyName.equals(CONTACT_METHOD_DELETE)) {
        deletexNWContactMethod();
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
      * Inserts xnwcontactmethod data by calling
      * <code>EObjxNWContactMethodExtData.createEObjxNWContactMethod</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void addxNWContactMethod() throws Exception{
    logger.finest("ENTER addxNWContactMethod()");
    EObjxNWContactMethodExtData theEObjxNWContactMethodExtData = (EObjxNWContactMethodExtData) DataAccessFactory
      .getQuery(EObjxNWContactMethodExtData.class, connection);
 		theEObjxNWContactMethodExtData.createEObjxNWContactMethodExt(
 		                                 ((TCRMContactMethodBObj) objectToPersist).getEObjContactMethod(),
 		                                 ((XNWContactMethodBObjExt) objectToPersist).getEObjxNWContactMethodExt());
    logger.finest("RETURN addxNWContactMethod()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
      * Updates xnwcontactmethod data by calling
      * <code>EObjxNWContactMethodExtData.updateEObjxNWContactMethod</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void updatexNWContactMethod() throws Exception{
    logger.finest("ENTER updatexNWContactMethod()");
    EObjxNWContactMethodExtData theEObjxNWContactMethodExtData = (EObjxNWContactMethodExtData) DataAccessFactory
      .getQuery(EObjxNWContactMethodExtData.class, connection);
 		theEObjxNWContactMethodExtData.updateEObjxNWContactMethodExt(
 		                                 ((TCRMContactMethodBObj) objectToPersist).getEObjContactMethod(),
 		                                 ((XNWContactMethodBObjExt) objectToPersist).getEObjxNWContactMethodExt());
    logger.finest("RETURN updatexNWContactMethod()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
      * Deletes xnwcontactmethod data by calling
      * <code>EObjxNWContactMethodExtData.deleteEObjxNWContactMethod</code>
   *
     * @throws Exception
     *
     * @generated
     */
	protected void deletexNWContactMethod() throws Exception{
    logger.finest("ENTER deletexNWContactMethod()");
    Long id = ((XNWContactMethodBObjExt) objectToPersist).getEObjContactMethod().getContactMethodIdPK();
    EObjxNWContactMethodExtData theEObjxNWContactMethodExtData = (EObjxNWContactMethodExtData) DataAccessFactory
      .getQuery(EObjxNWContactMethodExtData.class, connection);
    theEObjxNWContactMethodExtData.deleteEObjxNWContactMethodExt(id);
    logger.finest("RETURN deletexNWContactMethod()");
    } 



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Provides the result set processor that is used to populate the business
     * object.
     *
     * @return
     * An instance of <code>XNWContactMethodExtResultSetProcessor</code>.
     *
     * @see com.dwl.bobj.query.AbstractBObjQuery#provideResultSetProcessor()
     * @see mdmnw.component.XNWContactMethodExtResultSetProcessor
     *
     * @generated
     */
    protected IGenericResultSetProcessor provideResultSetProcessor()
            throws BObjQueryException {

        return new XNWContactMethodExtResultSetProcessor();
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


