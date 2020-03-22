
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
 * IBM-MDMWB-1.0-[8fdcb6e862de9f109167ee354f730b32]
 */

package mdmnw.component;

import com.dwl.base.util.DWLClassFactory;
import com.dwl.tcrm.exception.TCRMReadException;



import com.dwl.base.DWLControl;
import com.dwl.base.IDWLErrorMessage;

import com.dwl.base.db.DataAccessFactory;
import com.dwl.base.db.DataManager;
import com.dwl.base.db.QueryConnection;
import com.dwl.base.error.DWLError;
import com.dwl.base.error.DWLErrorCode;
import com.dwl.base.error.DWLStatus;

import com.dwl.base.exception.DWLBaseException;

import com.dwl.base.util.DWLDateTimeUtilities;
import com.dwl.base.util.DWLExceptionUtils;
import com.dwl.base.util.DWLFunctionUtils;

import com.dwl.management.config.client.Configuration;
import com.dwl.tcrm.common.IExtension;
import com.dwl.tcrm.common.ITCRMValidation;
import com.dwl.tcrm.common.TCRMErrorCode;

import com.dwl.tcrm.coreParty.component.TCRMPersonNameBObj;

import com.dwl.tcrm.utilities.DateFormatter;
import com.dwl.tcrm.utilities.DateValidator;
import java.sql.Timestamp;
import java.util.Iterator;
import mdmnw.constant.MDMNWComponentID;
import mdmnw.constant.MDMNWErrorReasonCode;

import mdmnw.entityObject.EObjxNWPersonNameExt;
import mdmnw.entityObject.EObjxNWPersonNameExtData;
import mdmnw.entityObject.XNWPersonNameExtInquiryData;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class provides the implementation of the business object
 * <code>XNWPersonNameBObjExt</code>.
 * 
 * @see com.dwl.tcrm.common.TCRMCommon
 * @generated
 */
 

@SuppressWarnings("serial")
public class XNWPersonNameBObjExt extends TCRMPersonNameBObj implements IExtension {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected EObjxNWPersonNameExt eObjxNWPersonNameExt;
	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWPersonNameBObjExt.class);
		
 


    protected boolean isValidXDegree_LastVerifiedDate = true;




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */     
    public XNWPersonNameBObjExt() {
        super();
        init();
        eObjxNWPersonNameExt = new EObjxNWPersonNameExt(getEObjPersonName());
        setComponentID(MDMNWComponentID.XNWPERSON_NAME_BOBJ_EXT);
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
        metaDataMap.put("XFull_Name", null);
        metaDataMap.put("XDegree", null);
        metaDataMap.put("XDegree_Source", null);
        metaDataMap.put("XDegree_LastVerifiedDate", null);
        metaDataMap.put("XNWPersonNameHistActionCode", null);
        metaDataMap.put("XNWPersonNameHistCreateDate", null);
        metaDataMap.put("XNWPersonNameHistCreatedBy", null);
        metaDataMap.put("XNWPersonNameHistEndDate", null);
        metaDataMap.put("XNWPersonNameHistoryIdPK", null);
        metaDataMap.put("XNWPersonNameLastUpdateDate", null);
        metaDataMap.put("XNWPersonNameLastUpdateTxId", null);
        metaDataMap.put("XNWPersonNameLastUpdateUser", null);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Refreshes all the attributes this business object supports.
     *
     * @see com.dwl.base.DWLCommon#refreshMap()
     * @generated
     */
    public void refreshMap() {

        if (bRequireMapRefresh) {
            super.refreshMap();
            metaDataMap.put("XFull_Name", getXFull_Name());
            metaDataMap.put("XDegree", getXDegree());
            metaDataMap.put("XDegree_Source", getXDegree_Source());
            metaDataMap.put("XDegree_LastVerifiedDate", getXDegree_LastVerifiedDate());
            metaDataMap.put("XNWPersonNameHistActionCode", getXNWPersonNameHistActionCode());
            metaDataMap.put("XNWPersonNameHistCreateDate", getXNWPersonNameHistCreateDate());
            metaDataMap.put("XNWPersonNameHistCreatedBy", getXNWPersonNameHistCreatedBy());
            metaDataMap.put("XNWPersonNameHistEndDate", getXNWPersonNameHistEndDate());
            metaDataMap.put("XNWPersonNameHistoryIdPK", getXNWPersonNameHistoryIdPK());
            metaDataMap.put("XNWPersonNameLastUpdateDate", getXNWPersonNameLastUpdateDate());
            metaDataMap.put("XNWPersonNameLastUpdateTxId", getXNWPersonNameLastUpdateTxId());
            metaDataMap.put("XNWPersonNameLastUpdateUser", getXNWPersonNameLastUpdateUser());
            bRequireMapRefresh = false;
        }
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

        if (eObjxNWPersonNameExt != null) {
            eObjxNWPersonNameExt.setControl(newDWLControl);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the entity object associated with this business object.
     *
     * @generated
     */
    public EObjxNWPersonNameExt getEObjxNWPersonNameExt() {
        bRequireMapRefresh = true;
        return eObjxNWPersonNameExt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the entity object associated with this business object.
     *
     * @param eObjxNWPersonNameExt
     *            The eObjxNWPersonNameExt to set.
     * @generated
     */
    public void setEObjxNWPersonNameExt(EObjxNWPersonNameExt eObjxNWPersonNameExt) {
        bRequireMapRefresh = true;
        this.eObjxNWPersonNameExt = eObjxNWPersonNameExt;
        this.eObjxNWPersonNameExt.setBaseEntity(getEObjPersonName());
        if (this.eObjxNWPersonNameExt != null && this.eObjxNWPersonNameExt.getControl() == null) {
            DWLControl control = this.getControl();
            if (control != null) {
                this.eObjxNWPersonNameExt.setControl(control);
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFull_Name attribute.
     * 
     * @generated
     */
    public String getXFull_Name (){
   
        return eObjxNWPersonNameExt.getX_Full_Name();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFull_Name attribute.
     * 
     * @param newXFull_Name
     *     The new value of xFull_Name.
     * @generated
     */
    public void setXFull_Name( String newXFull_Name ) throws Exception {
        metaDataMap.put("XFull_Name", newXFull_Name);

        if (newXFull_Name == null || newXFull_Name.equals("")) {
            newXFull_Name = null;


        }
        eObjxNWPersonNameExt.setX_Full_Name( newXFull_Name );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDegree attribute.
     * 
     * @generated
     */
    public String getXDegree (){
   
        return eObjxNWPersonNameExt.getXDegree();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDegree attribute.
     * 
     * @param newXDegree
     *     The new value of xDegree.
     * @generated
     */
    public void setXDegree( String newXDegree ) throws Exception {
        metaDataMap.put("XDegree", newXDegree);

        if (newXDegree == null || newXDegree.equals("")) {
            newXDegree = null;


        }
        eObjxNWPersonNameExt.setXDegree( newXDegree );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDegree_Source attribute.
     * 
     * @generated
     */
    public String getXDegree_Source (){
   
        return eObjxNWPersonNameExt.getXDegree_Source();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDegree_Source attribute.
     * 
     * @param newXDegree_Source
     *     The new value of xDegree_Source.
     * @generated
     */
    public void setXDegree_Source( String newXDegree_Source ) throws Exception {
        metaDataMap.put("XDegree_Source", newXDegree_Source);

        if (newXDegree_Source == null || newXDegree_Source.equals("")) {
            newXDegree_Source = null;


        }
        eObjxNWPersonNameExt.setXDegree_Source( newXDegree_Source );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDegree_LastVerifiedDate attribute.
     * 
     * @generated
     */
    public String getXDegree_LastVerifiedDate (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonNameExt.getXDegree_LastVerifiedDate());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDegree_LastVerifiedDate attribute.
     * 
     * @param newXDegree_LastVerifiedDate
     *     The new value of xDegree_LastVerifiedDate.
     * @generated
     */
    public void setXDegree_LastVerifiedDate( String newXDegree_LastVerifiedDate ) throws Exception {
        metaDataMap.put("XDegree_LastVerifiedDate", newXDegree_LastVerifiedDate);
       	isValidXDegree_LastVerifiedDate = true;

        if (newXDegree_LastVerifiedDate == null || newXDegree_LastVerifiedDate.equals("")) {
            newXDegree_LastVerifiedDate = null;
            eObjxNWPersonNameExt.setXDegree_LastVerifiedDate(null);


        }
    else {
        	if (DateValidator.validates(newXDegree_LastVerifiedDate)) {
           		eObjxNWPersonNameExt.setXDegree_LastVerifiedDate(DateFormatter.getStartDateTimestamp(newXDegree_LastVerifiedDate));
            	metaDataMap.put("XDegree_LastVerifiedDate", getXDegree_LastVerifiedDate());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XDegree_LastVerifiedDate") != null) {
                    	metaDataMap.put("XDegree_LastVerifiedDate", "");
                	}
                	isValidXDegree_LastVerifiedDate = false;
                	eObjxNWPersonNameExt.setXDegree_LastVerifiedDate(null);
            	}
        	}
        }
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateTxId attribute.
     *
     * @generated
     */
    public String getXNWPersonNameLastUpdateTxId() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWPersonNameExt.getLastUpdateTxId());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateUser attribute.
     *
     * @generated
     */
    public String getXNWPersonNameLastUpdateUser() {
        return eObjxNWPersonNameExt.getLastUpdateUser();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateDt attribute.
     *
     * @generated
     */
    public String getXNWPersonNameLastUpdateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonNameExt.getLastUpdateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the LastUpdateTxId attribute.
     *
     * @param newLastUpdateTxId
     *     The new value of LastUpdateTxId.
     * @generated
     */
    public void setXNWPersonNameLastUpdateTxId(String newLastUpdateTxId) {
        metaDataMap.put("XNWPersonNameLastUpdateTxId", newLastUpdateTxId);

        if ((newLastUpdateTxId == null) || newLastUpdateTxId.equals("")) {
            newLastUpdateTxId = null;
        }
        eObjxNWPersonNameExt.setLastUpdateTxId(DWLFunctionUtils.getLongFromString(newLastUpdateTxId));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the LastUpdateUser attribute.
     *
     * @param newLastUpdateUser
     *     The new value of LastUpdateUser.
     * @generated
     */
    public void setXNWPersonNameLastUpdateUser(String newLastUpdateUser) {
        metaDataMap.put("XNWPersonNameLastUpdateUser", newLastUpdateUser);

        if ((newLastUpdateUser == null) || newLastUpdateUser.equals("")) {
            newLastUpdateUser = null;
        }
        eObjxNWPersonNameExt.setLastUpdateUser(newLastUpdateUser);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the LastUpdateDt attribute.
     *
     * @param newLastUpdateDt
     *     The new value of LastUpdateDt.
     * @throws Exception
     * @generated
     */
    public void setXNWPersonNameLastUpdateDate(String newLastUpdateDt) throws Exception {
        metaDataMap.put("XNWPersonNameLastUpdateDate", newLastUpdateDt);

        if ((newLastUpdateDt == null) || newLastUpdateDt.equals("")) {
            newLastUpdateDt = null;
        }

        eObjxNWPersonNameExt.setLastUpdateDt(DWLFunctionUtils.getTimestampFromTimestampString(newLastUpdateDt));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonNameHistActionCode history attribute.
     *
     * @generated
     */
    public String getXNWPersonNameHistActionCode() {
        return eObjxNWPersonNameExt.getHistActionCode();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonNameHistActionCode history attribute.
     *
     * @param aXNWPersonNameHistActionCode
     *     The new value of XNWPersonNameHistActionCode.
     * @generated
     */
    public void setXNWPersonNameHistActionCode(String aXNWPersonNameHistActionCode) {
        metaDataMap.put("XNWPersonNameHistActionCode", aXNWPersonNameHistActionCode);

        if ((aXNWPersonNameHistActionCode == null) || aXNWPersonNameHistActionCode.equals("")) {
            aXNWPersonNameHistActionCode = null;
        }
        eObjxNWPersonNameExt.setHistActionCode(aXNWPersonNameHistActionCode);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonNameHistCreateDate history attribute.
     *
     * @generated
     */
    public String getXNWPersonNameHistCreateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonNameExt.getHistCreateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonNameHistCreateDate history attribute.
     *
     * @param aXNWPersonNameHistCreateDate
     *     The new value of XNWPersonNameHistCreateDate.
     * @generated
     */
    public void setXNWPersonNameHistCreateDate(String aXNWPersonNameHistCreateDate) throws Exception{
        metaDataMap.put("XNWPersonNameHistCreateDate", aXNWPersonNameHistCreateDate);

        if ((aXNWPersonNameHistCreateDate == null) || aXNWPersonNameHistCreateDate.equals("")) {
            aXNWPersonNameHistCreateDate = null;
        }

        eObjxNWPersonNameExt.setHistCreateDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWPersonNameHistCreateDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonNameHistCreatedBy history attribute.
     *
     * @generated
     */
    public String getXNWPersonNameHistCreatedBy() {
        return eObjxNWPersonNameExt.getHistCreatedBy();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonNameHistCreatedBy history attribute.
     *
     * @param aXNWPersonNameHistCreatedBy
     *     The new value of XNWPersonNameHistCreatedBy.
     * @generated
     */
    public void setXNWPersonNameHistCreatedBy(String aXNWPersonNameHistCreatedBy) {
        metaDataMap.put("XNWPersonNameHistCreatedBy", aXNWPersonNameHistCreatedBy);

        if ((aXNWPersonNameHistCreatedBy == null) || aXNWPersonNameHistCreatedBy.equals("")) {
            aXNWPersonNameHistCreatedBy = null;
        }

        eObjxNWPersonNameExt.setHistCreatedBy(aXNWPersonNameHistCreatedBy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonNameHistEndDate history attribute.
     *
     * @generated
     */
    public String getXNWPersonNameHistEndDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonNameExt.getHistEndDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonNameHistEndDate history attribute.
     *
     * @param aXNWPersonNameHistEndDate
     *     The new value of XNWPersonNameHistEndDate.
     * @generated
     */
    public void setXNWPersonNameHistEndDate(String aXNWPersonNameHistEndDate) throws Exception{
        metaDataMap.put("XNWPersonNameHistEndDate", aXNWPersonNameHistEndDate);

        if ((aXNWPersonNameHistEndDate == null) || aXNWPersonNameHistEndDate.equals("")) {
            aXNWPersonNameHistEndDate = null;
        }
        eObjxNWPersonNameExt.setHistEndDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWPersonNameHistEndDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonNameHistoryIdPK history attribute.
     *
     * @generated
     */
    public String getXNWPersonNameHistoryIdPK() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWPersonNameExt.getHistoryIdPK());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonNameHistoryIdPK history attribute.
     *
     * @param aXNWPersonNameHistoryIdPK
     *     The new value of XNWPersonNameHistoryIdPK.
     * @generated
     */
    public void setXNWPersonNameHistoryIdPK(String aXNWPersonNameHistoryIdPK) {
        metaDataMap.put("XNWPersonNameHistoryIdPK", aXNWPersonNameHistoryIdPK);

        if ((aXNWPersonNameHistoryIdPK == null) || aXNWPersonNameHistoryIdPK.equals("")) {
            aXNWPersonNameHistoryIdPK = null;
        }
        eObjxNWPersonNameExt.setHistoryIdPK(DWLFunctionUtils.getLongFromString(aXNWPersonNameHistoryIdPK));
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

        status = super.validateAdd(level, status);
        if (level == ITCRMValidation.CONTROLLER_LEVEL_VALIDATION) {
            // MDM_TODO0: CDKWB0038I Add any controller-level custom validation logic to be
            // executed for this object during an "add" transaction

        }

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO0: CDKWB0039I Add any component-level custom validation logic to be
            // executed for this object during an "add" transaction
        }
        status = getValidationStatus(level, status);
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

        }

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            assignBeforeImageValues(metaDataMap);
            
            // MDM_TODO0: CDKWB0041I Add any component-level custom validation logic to be
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
    		controllerValidation_XDegree_LastVerifiedDate(status);
    	}

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO0: CDKWB0035I Add any common component-level custom validation logic
            // to be executed for this object during either "add" or "update"
            // transactions
    		componentValidation_XDegree_LastVerifiedDate(status);
        }
        
        if (logger.isFinestEnabled()) {
            String returnValue = status.toString();
      logger.finest("RETURN getValidationStatus(int level, DWLStatus status) " + returnValue);
        }
    
        return status;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XDegree_LastVerifiedDate"
     *
     * @generated
     */
  private void componentValidation_XDegree_LastVerifiedDate(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XDegree_LastVerifiedDate"
     *
     * @generated
     */
  private void controllerValidation_XDegree_LastVerifiedDate(DWLStatus status) throws Exception {
  
            boolean isXDegree_LastVerifiedDateNull = (eObjxNWPersonNameExt.getXDegree_LastVerifiedDate() == null);
            if (!isValidXDegree_LastVerifiedDate) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_NAME_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSONNAME_XDEGREE_LASTVERIFIEDDATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xDegree_LastVerifiedDate in entity xNWPersonName, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XDegree_LastVerifiedDate " + infoForLogging);
               	status.addError(err);
            } 
    	}


    private DWLError createDWLError(String entityName, String propertyName,String reasonCode){	
		DWLError err = new DWLError();
		err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_NAME_BOBJ_EXT).longValue());
		err.setReasonCode(new Long(reasonCode).longValue());
		err.setErrorType(DWLErrorCode.FIELD_VALIDATION_ERROR);
        if (logger.isFinestEnabled()) {
			String infoForLogging="Error: Validation error occured. Property " + propertyName + " is null, in entity " + entityName + ", component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode() + "  ";
			logger.finest("createDWLError " + infoForLogging);
		}
		return err;
    }
    






	 /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets a record from the extension table.
     *
     * @throws DWLBaseException
     * @generated
     */
    public void getRecord() throws DWLBaseException {

    logger.finest("ENTER getRecord()");
    
    try {
            QueryConnection  connection = null;

            try {
                 connection = DataManager.getInstance().getQueryConnection();
                 Iterator<EObjxNWPersonNameExt> eObj = null;
                 String asOfDate = (String) this.getControl().get(
                         DWLControl.INQUIRE_AS_OF_DATE);
                 Timestamp tsAsOfDate = null;
                 
                 if ((asOfDate != null) && !asOfDate.equalsIgnoreCase("")) {
                     tsAsOfDate = DWLDateTimeUtilities.setPITHistoryDate(asOfDate, this.getControl());
 
                	 XNWPersonNameExtInquiryData theInquiryData = (XNWPersonNameExtInquiryData)DataAccessFactory.getQuery(XNWPersonNameExtInquiryData.class, connection);
                	 
                	 Object[] parameters = new Object[3];
                     parameters[0] = (Long) getEObjPersonName().getPrimaryKey();
                     parameters[1] = tsAsOfDate;
                     parameters[2] = tsAsOfDate;
                     
                	 eObj = theInquiryData.getxNWPersonNameHistory(parameters);
                 } else {
                	 EObjxNWPersonNameExtData  theEObjData = (EObjxNWPersonNameExtData) DataAccessFactory
                     .getQuery(EObjxNWPersonNameExtData.class, connection);
                	 
                	 eObj = theEObjData.getEObjxNWPersonNameExt((Long)getEObjPersonName().getPrimaryKey());
                 }
                 
                 if(eObj.hasNext()) {
         			this.setEObjxNWPersonNameExt((EObjxNWPersonNameExt)eObj.next());
         			
         		 }
          
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    DWLExceptionUtils.log(e);
                	if (logger.isFinestEnabled()) {    
                		String infoForLogging="Error: Error closing the connection " + e.getMessage();
      logger.finest("getRecord() " + infoForLogging);
                	}
                // ignore any exceptions
                }
            }

        } catch (Exception e) {
            DWLExceptionUtils.log(e);
            
            if (logger.isFinestEnabled()) {
        		String infoForLogging="Error: Error reading record " + e.getMessage(); 
      logger.finest("getRecord() " + infoForLogging);
      }
            status = new DWLStatus();

            TCRMReadException readEx = new TCRMReadException();
            IDWLErrorMessage  errHandler = DWLClassFactory.getErrorHandler();
            DWLError error = errHandler.getErrorMessage(MDMNWComponentID.XNWPERSON_NAME_BOBJ_EXT,
                                                                 TCRMErrorCode.READ_RECORD_ERROR,
                                                                 MDMNWErrorReasonCode.READ_EXTENSION_XNWPERSONNAME_FAILED,
                                                                 getControl(), new String[0]);
            error.setThrowable(e);
            status.addError(error);
            status.setStatus(DWLStatus.FATAL);
            readEx.setStatus(status);
            throw readEx;
        }
    logger.finest("RETURN getRecord()");
  }


}

