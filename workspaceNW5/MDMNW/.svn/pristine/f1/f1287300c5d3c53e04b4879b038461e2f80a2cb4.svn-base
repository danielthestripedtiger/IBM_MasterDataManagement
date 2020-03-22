
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
 * IBM-MDMWB-1.0-[ee18a6a24aca6cb0252acec7fbee82ba]
 */

package mdmnw.component;

import com.dwl.tcrm.common.TCRMCommon;
import com.dwl.base.error.DWLStatus;
import com.dwl.tcrm.common.ITCRMValidation;
import com.dwl.base.DWLControl;


import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;

import java.util.Vector;

import mdmnw.constant.MDMNWComponentID;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class provides the implementation of the business object
 * <code>CompositeNWPersonBObj</code>.
 * 
 * @see com.dwl.tcrm.common.TCRMCommon
 * @generated
 */
 
@SuppressWarnings("serial")
public class CompositeNWPersonBObj extends TCRMCommon  {

	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(CompositeNWPersonBObj.class);
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected TCRMPersonBObj TCRMPersonBObj;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("rawtypes")
    public CompositeNWPersonBObj() {
        super();
        init();

        setComponentID(MDMNWComponentID.COMPOSITE_NWPERSON_BOBJ);
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Initializes the fields required to populate the metaDataMap. Each key is
     * an element-level field of the business object.
     *
     * @generated
     */
    private void init() {
    }


/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the control object on this business object.
     *
     * @see com.dwl.base.DWLCommon#setControl(DWLControl)
     * @generated
     */
    public void setControl(DWLControl newDWLControl) {
        super.setControl(newDWLControl);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the TCRMPersonBObj attribute.
     * 
     * @generated
     */
    public TCRMPersonBObj getTCRMPersonBObj (){
      return TCRMPersonBObj;
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setTCRMPersonBObj(TCRMPersonBObj newBObj ) {
    TCRMPersonBObj = newBObj;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform validation during an add transaction.
     *
     * @generated
     */
    public DWLStatus validateAdd(int level, DWLStatus status) throws Exception {
    logger.finest("ENTER validateAdd(int level, DWLStatus status)");

        status = super.validateAdd(level, status);
        if (level == ITCRMValidation.CONTROLLER_LEVEL_VALIDATION) {
            // MDM_TODO0: CDKWB0038I Add any controller-level custom validation logic to be
            // executed for this object during an "add" transaction

            TCRMPersonBObj person = getTCRMPersonBObj();
            if( person != null ){
            	status = person.validateAdd(level, status);
            }
        }

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO0: CDKWB0039I Add any component-level custom validation logic to be
            // executed for this object during an "add" transaction
        }
        status = getValidationStatus(level, status);
    if (logger.isFinestEnabled()) {
        	String returnValue = status.toString();
      logger.finest("RETURN validateAdd(int level, DWLStatus status) " + returnValue);
    }
        return status;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform validation during an update transaction.
     *
     * @generated
     */
    public DWLStatus validateUpdate(int level, DWLStatus status) throws Exception {
    logger.finest("ENTER validateUpdate(int level, DWLStatus status)");
        status = super.validateUpdate(level, status);
        if (level == ITCRMValidation.CONTROLLER_LEVEL_VALIDATION) {
            // MDM_TODO0: CDKWB0040I Add any controller-level custom validation logic to be
            // executed for this object during an "update" transaction
           TCRMPersonBObj person = (TCRMPersonBObj) getTCRMPersonBObj();
           if( person != null ){
           		if (person.getEObjPerson().getPrimaryKey() == null) {
               		status = person.validateAdd(level, status);
           		} else  {
               		status = person.validateUpdate(level, status);
           		}
           }
        }

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO: CDKWB0041I Add any component-level custom validation logic to be
            // executed for this object during an "update" transaction
        }
        status = getValidationStatus(level, status);
    if (logger.isFinestEnabled()) {
      String returnValue = status.toString();
      logger.finest("RETURN validateUpdate(int level, DWLStatus status) " + returnValue);
    }
        return status;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform validation common to both add and update transactions.
     *
     * @generated
     */
    private DWLStatus getValidationStatus(int level, DWLStatus status) throws Exception {
    logger.finest("ENTER getValidationStatus(int level, DWLStatus status)");

        if (level == ITCRMValidation.CONTROLLER_LEVEL_VALIDATION) {
            // MDM_TODO0: CDKWB0034I Add any common controller-level custom validation
            // logic to be executed for this object during either "add" or
            // "update" transactions

        }

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO0: CDKWB0035I Add any common component-level custom validation logic
            // to be executed for this object during either "add" or "update"
            // transactions
        }
        if (logger.isFinestEnabled()) {
      	String returnValue = status.toString();
      logger.finest("RETURN getValidationStatus(int level, DWLStatus status) " + returnValue);
    }
        return status;
    }
    


}


