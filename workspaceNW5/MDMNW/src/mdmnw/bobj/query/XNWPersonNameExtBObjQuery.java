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
 * IBM-MDMWB-1.0-[fe3d4acb242c206391bc51ccd4e72816]
 */

package mdmnw.bobj.query;




import com.dwl.base.DWLControl;
import com.dwl.bobj.query.BObjQueryException;
import com.dwl.base.DWLCommon;


import com.dwl.base.db.DataAccessFactory;

import com.dwl.base.interfaces.IGenericResultSetProcessor;

import com.dwl.tcrm.coreParty.bobj.query.PersonNameBObjQuery;

import com.dwl.tcrm.coreParty.component.TCRMPersonNameBObj;

import mdmnw.component.XNWPersonNameBObjExt;
import mdmnw.component.XNWPersonNameExtResultSetProcessor;

import mdmnw.entityObject.EObjxNWPersonNameExtData;
import mdmnw.entityObject.XNWPersonNameExtInquiryData;





/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class extends the <code>PersonNameBObjQuery</code> class.
 *
 * @generated
 */
public class XNWPersonNameExtBObjQuery extends PersonNameBObjQuery {

	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWPersonNameExtBObjQuery.class);
   
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
    public XNWPersonNameExtBObjQuery(String queryName, DWLControl control) {
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
    public XNWPersonNameExtBObjQuery(String persistenceStrategyName, DWLCommon objectToPersist) {
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
    if (objectToPersist instanceof XNWPersonNameBObjExt) {
      String infoForLogging="persist() instanceof XNWPersonNameBObjExt";
      logger.finest("persist() " + infoForLogging);
      if (persistenceStrategyName.equals(PERSON_NAME_ADD)) {
        addxNWPersonName();
      }else if(persistenceStrategyName.equals(PERSON_NAME_UPDATE)) {
        updatexNWPersonName();
      }else if(persistenceStrategyName.equals(PERSON_NAME_DELETE)) {
        deletexNWPersonName();
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
      * Inserts xnwpersonname data by calling
      * <code>EObjxNWPersonNameExtData.createEObjxNWPersonName</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void addxNWPersonName() throws Exception{
    logger.finest("ENTER addxNWPersonName()");
    EObjxNWPersonNameExtData theEObjxNWPersonNameExtData = (EObjxNWPersonNameExtData) DataAccessFactory
      .getQuery(EObjxNWPersonNameExtData.class, connection);
 		theEObjxNWPersonNameExtData.createEObjxNWPersonNameExt(
 		                                 ((TCRMPersonNameBObj) objectToPersist).getEObjPersonName(),
 		                                 ((XNWPersonNameBObjExt) objectToPersist).getEObjxNWPersonNameExt());
    logger.finest("RETURN addxNWPersonName()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
      * Updates xnwpersonname data by calling
      * <code>EObjxNWPersonNameExtData.updateEObjxNWPersonName</code>
     *
     * @throws Exception
     *
     * @generated
     */
	protected void updatexNWPersonName() throws Exception{
    logger.finest("ENTER updatexNWPersonName()");
    EObjxNWPersonNameExtData theEObjxNWPersonNameExtData = (EObjxNWPersonNameExtData) DataAccessFactory
      .getQuery(EObjxNWPersonNameExtData.class, connection);
 		theEObjxNWPersonNameExtData.updateEObjxNWPersonNameExt(
 		                                 ((TCRMPersonNameBObj) objectToPersist).getEObjPersonName(),
 		                                 ((XNWPersonNameBObjExt) objectToPersist).getEObjxNWPersonNameExt());
    logger.finest("RETURN updatexNWPersonName()");
  }

 	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
      * Deletes xnwpersonname data by calling
      * <code>EObjxNWPersonNameExtData.deleteEObjxNWPersonName</code>
   *
     * @throws Exception
     *
     * @generated
     */
	protected void deletexNWPersonName() throws Exception{
    logger.finest("ENTER deletexNWPersonName()");
    Long id = ((XNWPersonNameBObjExt) objectToPersist).getEObjPersonName().getPersonNameIdPK();
    EObjxNWPersonNameExtData theEObjxNWPersonNameExtData = (EObjxNWPersonNameExtData) DataAccessFactory
      .getQuery(EObjxNWPersonNameExtData.class, connection);
    theEObjxNWPersonNameExtData.deleteEObjxNWPersonNameExt(id);
    logger.finest("RETURN deletexNWPersonName()");
    } 



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Provides the result set processor that is used to populate the business
     * object.
     *
     * @return
     * An instance of <code>XNWPersonNameExtResultSetProcessor</code>.
     *
     * @see com.dwl.bobj.query.AbstractBObjQuery#provideResultSetProcessor()
     * @see mdmnw.component.XNWPersonNameExtResultSetProcessor
     *
     * @generated
     */
    protected IGenericResultSetProcessor provideResultSetProcessor()
            throws BObjQueryException {

        return new XNWPersonNameExtResultSetProcessor();
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


