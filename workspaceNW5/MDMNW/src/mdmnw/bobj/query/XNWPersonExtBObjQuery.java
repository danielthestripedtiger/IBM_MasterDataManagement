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
 * IBM-MDMWB-1.0-[3e04b98433a3f15e2827797c356faedf]
 */

package mdmnw.bobj.query;




import com.dwl.base.DWLControl;
import com.dwl.bobj.query.BObjQueryException;
import com.dwl.base.DWLCommon;


import com.dwl.base.db.DataAccessFactory;

import com.dwl.base.interfaces.IGenericResultSetProcessor;

import com.dwl.tcrm.coreParty.bobj.query.PersonBObjQuery;

import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;

import mdmnw.component.XNWPersonBObjExt;
import mdmnw.component.XNWPersonExtResultSetProcessor;

import mdmnw.entityObject.EObjxNWPersonExtData;
import mdmnw.entityObject.XNWPersonExtInquiryData;





/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class extends the <code>PersonBObjQuery</code> class.
 *
 * @generated
 */
public class XNWPersonExtBObjQuery extends PersonBObjQuery {

	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWPersonExtBObjQuery.class);
   
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
    public XNWPersonExtBObjQuery(String queryName, DWLControl control) {
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
    public XNWPersonExtBObjQuery(String persistenceStrategyName, DWLCommon objectToPersist) {
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
    if (objectToPersist instanceof XNWPersonBObjExt) {
      String infoForLogging="persist() instanceof XNWPersonBObjExt";
      logger.finest("persist() " + infoForLogging);
      if (persistenceStrategyName.equals(PERSON_ADD)) {
        addxNWPerson();
      }else if(persistenceStrategyName.equals(PERSON_UPDATE)) {
        updatexNWPerson();
      }else if(persistenceStrategyName.equals(PERSON_DELETE)) {
        deletexNWPerson();
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
      * Inserts xnwperson data by calling
      * <code>EObjxNWPersonExtData.createEObjxNWPerson</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void addxNWPerson() throws Exception{
    logger.finest("ENTER addxNWPerson()");
    EObjxNWPersonExtData theEObjxNWPersonExtData = (EObjxNWPersonExtData) DataAccessFactory
      .getQuery(EObjxNWPersonExtData.class, connection);
 		theEObjxNWPersonExtData.createEObjxNWPersonExt(
 		                                 ((TCRMPersonBObj) objectToPersist).getEObjPerson(),
 		                                 ((XNWPersonBObjExt) objectToPersist).getEObjxNWPersonExt());
    logger.finest("RETURN addxNWPerson()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
      * Updates xnwperson data by calling
      * <code>EObjxNWPersonExtData.updateEObjxNWPerson</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void updatexNWPerson() throws Exception{
    logger.finest("ENTER updatexNWPerson()");
    EObjxNWPersonExtData theEObjxNWPersonExtData = (EObjxNWPersonExtData) DataAccessFactory
      .getQuery(EObjxNWPersonExtData.class, connection);
 		theEObjxNWPersonExtData.updateEObjxNWPersonExt(
 		                                 ((TCRMPersonBObj) objectToPersist).getEObjPerson(),
 		                                 ((XNWPersonBObjExt) objectToPersist).getEObjxNWPersonExt());
    logger.finest("RETURN updatexNWPerson()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
      * Deletes xnwperson data by calling
      * <code>EObjxNWPersonExtData.deleteEObjxNWPerson</code>
   *
     * @throws Exception
     *
     * @generated
     */
	protected void deletexNWPerson() throws Exception{
    logger.finest("ENTER deletexNWPerson()");
    Long id = ((XNWPersonBObjExt) objectToPersist).getEObjPerson().getContIdPK();
    EObjxNWPersonExtData theEObjxNWPersonExtData = (EObjxNWPersonExtData) DataAccessFactory
      .getQuery(EObjxNWPersonExtData.class, connection);
    theEObjxNWPersonExtData.deleteEObjxNWPersonExt(id);
    logger.finest("RETURN deletexNWPerson()");
    } 



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Provides the result set processor that is used to populate the business
     * object.
     *
     * @return
     * An instance of <code>XNWPersonExtResultSetProcessor</code>.
     *
     * @see com.dwl.bobj.query.AbstractBObjQuery#provideResultSetProcessor()
     * @see mdmnw.component.XNWPersonExtResultSetProcessor
     *
     * @generated
     */
    protected IGenericResultSetProcessor provideResultSetProcessor()
            throws BObjQueryException {

        return new XNWPersonExtResultSetProcessor();
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


