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
 * IBM-MDMWB-1.0-[716089315407b1a8d5b2f860c46f9415]
 */


package mdmnw.bobj.query;

import com.dwl.tcrm.coreParty.bobj.query.PartyModuleBObjQueryFactoryImpl;


import com.dwl.base.DWLCommon;
import com.dwl.base.DWLControl;

import com.dwl.bobj.query.BObjQuery;
import com.dwl.bobj.query.Persistence;


/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * The <code>XPartyModuleBObjQueryFactoryImpl</code> is the factory class that
 * provides methods to return the BObjQuery instances corresponding to the
 * business objects.
 *
 * @see com.dwl.tcrm.coreParty.bobj.query.PartyModuleBObjQueryFactory
 * 
 * @generated
 */
 public class XPartyModuleBObjQueryFactoryImpl extends PartyModuleBObjQueryFactoryImpl {
	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XPartyModuleBObjQueryFactoryImpl.class);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Default constructor.
     *
     * @generated
     */
    public XPartyModuleBObjQueryFactoryImpl() {
        super();
    }
    
    /** 
      * <!-- begin-user-doc -->
      * <!-- end-user-doc -->
      *
      * This method returns an object of type <code>Persistence</code>
      * corresponding to <code>TCRMPersonNameBObj</code> business object.
      *
      * @param persistenceStrategyName
      * The persistence strategy name.  This parameter indicates the type of
      * database action to be taken such as addition, update or deletion of
      * records.
      * @param objectToPersist
      * The business object to be persisted.
      *      
      * @return 
      * An instance of <code>XNWPersonNameExtBObjQuery</code>.
      *
      * @generated
      */
      public Persistence createPersonNameBObjPersistence(String persistenceStrategyName, DWLCommon objectToPersist) {
    logger.finest("ENTER createPersonNameBObjPersistence(String persistenceStrategyName, DWLControl dwlControl)");
   	
        return new XNWPersonNameExtBObjQuery(persistenceStrategyName, objectToPersist);
      }

      /** 
      * <!-- begin-user-doc -->
      * <!-- end-user-doc -->
      *
      * This method returns an object of type <code>Persistence</code>
      * corresponding to <code>TCRMPersonBObj</code> business object.
      *
      * @param persistenceStrategyName
      * The persistence strategy name.  This parameter indicates the type of
      * database action to be taken such as addition, update or deletion of
      * records.
      * @param objectToPersist
      * The business object to be persisted.
      *      
      * @return 
      * An instance of <code>XNWPersonExtBObjQuery</code>.
      *
      * @generated
      */
      public Persistence createPersonBObjPersistence(String persistenceStrategyName, DWLCommon objectToPersist) {
    logger.finest("ENTER createPersonBObjPersistence(String persistenceStrategyName, DWLControl dwlControl)");
   	
        return new XNWPersonExtBObjQuery(persistenceStrategyName, objectToPersist);
      }

      /** 
      * <!-- begin-user-doc -->
      * <!-- end-user-doc -->
      *
      * This method returns an object of type <code>Persistence</code>
      * corresponding to <code>TCRMPartyAddressBObj</code> business object.
      *
      * @param persistenceStrategyName
      * The persistence strategy name.  This parameter indicates the type of
      * database action to be taken such as addition, update or deletion of
      * records.
      * @param objectToPersist
      * The business object to be persisted.
      *      
      * @return 
      * An instance of <code>XNWPartyAddressExtBObjQuery</code>.
      *
      * @generated
      */
      public Persistence createPartyAddressBObjPersistence(String persistenceStrategyName, DWLCommon objectToPersist) {
    logger.finest("ENTER createPartyAddressBObjPersistence(String persistenceStrategyName, DWLControl dwlControl)");
   	
        return new XNWPartyAddressExtBObjQuery(persistenceStrategyName, objectToPersist);
      }

      /** 
      * <!-- begin-user-doc -->
      * <!-- end-user-doc -->
      *
      * This method returns an object of type <code>Persistence</code>
      * corresponding to <code>TCRMAddressBObj</code> business object.
      *
      * @param persistenceStrategyName
      * The persistence strategy name.  This parameter indicates the type of
      * database action to be taken such as addition, update or deletion of
      * records.
      * @param objectToPersist
      * The business object to be persisted.
      *      
      * @return 
      * An instance of <code>XNWAddressExtBObjQuery</code>.
      *
      * @generated
      */
      public Persistence createAddressBObjPersistence(String persistenceStrategyName, DWLCommon objectToPersist) {
    logger.finest("ENTER createAddressBObjPersistence(String persistenceStrategyName, DWLControl dwlControl)");
   	
        return new XNWAddressExtBObjQuery(persistenceStrategyName, objectToPersist);
      }

      /** 
      * <!-- begin-user-doc -->
      * <!-- end-user-doc -->
      *
      * This method returns an object of type <code>Persistence</code>
      * corresponding to <code>TCRMContactMethodBObj</code> business object.
      *
      * @param persistenceStrategyName
      * The persistence strategy name.  This parameter indicates the type of
      * database action to be taken such as addition, update or deletion of
      * records.
      * @param objectToPersist
      * The business object to be persisted.
      *      
      * @return 
      * An instance of <code>XNWContactMethodExtBObjQuery</code>.
      *
      * @generated
      */
      public Persistence createContactMethodBObjPersistence(String persistenceStrategyName, DWLCommon objectToPersist) {
    logger.finest("ENTER createContactMethodBObjPersistence(String persistenceStrategyName, DWLControl dwlControl)");
   	
        return new XNWContactMethodExtBObjQuery(persistenceStrategyName, objectToPersist);
      }   
}

