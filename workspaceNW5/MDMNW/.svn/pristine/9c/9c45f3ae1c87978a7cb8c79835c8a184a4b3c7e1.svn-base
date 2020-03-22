
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
 * IBM-MDMWB-1.0-[e1df92391de8aed8bc4ac0ffb165c74d]
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

import com.dwl.tcrm.common.IExtension;
import com.dwl.tcrm.common.ITCRMValidation;
import com.dwl.tcrm.common.TCRMErrorCode;

import com.dwl.tcrm.coreParty.component.TCRMContactMethodBObj;

import java.sql.Timestamp;

import java.util.Iterator;

import mdmnw.constant.MDMNWComponentID;
import mdmnw.constant.MDMNWErrorReasonCode;

import mdmnw.entityObject.EObjxNWContactMethodExt;
import mdmnw.entityObject.EObjxNWContactMethodExtData;
import mdmnw.entityObject.XNWContactMethodExtInquiryData;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class provides the implementation of the business object
 * <code>XNWContactMethodBObjExt</code>.
 * 
 * @see com.dwl.tcrm.common.TCRMCommon
 * @generated
 */
 

@SuppressWarnings("serial")
public class XNWContactMethodBObjExt extends TCRMContactMethodBObj implements IExtension {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected EObjxNWContactMethodExt eObjxNWContactMethodExt;
	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWContactMethodBObjExt.class);
		
 


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */     
    public XNWContactMethodBObjExt() {
        super();
        init();
        eObjxNWContactMethodExt = new EObjxNWContactMethodExt(getEObjContactMethod());
        setComponentID(MDMNWComponentID.XNWCONTACT_METHOD_BOBJ_EXT);
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
        metaDataMap.put("XExtension", null);
        metaDataMap.put("XNWContactMethodHistActionCode", null);
        metaDataMap.put("XNWContactMethodHistCreateDate", null);
        metaDataMap.put("XNWContactMethodHistCreatedBy", null);
        metaDataMap.put("XNWContactMethodHistEndDate", null);
        metaDataMap.put("XNWContactMethodHistoryIdPK", null);
        metaDataMap.put("XNWContactMethodLastUpdateDate", null);
        metaDataMap.put("XNWContactMethodLastUpdateTxId", null);
        metaDataMap.put("XNWContactMethodLastUpdateUser", null);
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
            metaDataMap.put("XExtension", getXExtension());
            metaDataMap.put("XNWContactMethodHistActionCode", getXNWContactMethodHistActionCode());
            metaDataMap.put("XNWContactMethodHistCreateDate", getXNWContactMethodHistCreateDate());
            metaDataMap.put("XNWContactMethodHistCreatedBy", getXNWContactMethodHistCreatedBy());
            metaDataMap.put("XNWContactMethodHistEndDate", getXNWContactMethodHistEndDate());
            metaDataMap.put("XNWContactMethodHistoryIdPK", getXNWContactMethodHistoryIdPK());
            metaDataMap.put("XNWContactMethodLastUpdateDate", getXNWContactMethodLastUpdateDate());
            metaDataMap.put("XNWContactMethodLastUpdateTxId", getXNWContactMethodLastUpdateTxId());
            metaDataMap.put("XNWContactMethodLastUpdateUser", getXNWContactMethodLastUpdateUser());
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

        if (eObjxNWContactMethodExt != null) {
            eObjxNWContactMethodExt.setControl(newDWLControl);
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
    public EObjxNWContactMethodExt getEObjxNWContactMethodExt() {
        bRequireMapRefresh = true;
        return eObjxNWContactMethodExt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the entity object associated with this business object.
     *
     * @param eObjxNWContactMethodExt
     *            The eObjxNWContactMethodExt to set.
     * @generated
     */
    public void setEObjxNWContactMethodExt(EObjxNWContactMethodExt eObjxNWContactMethodExt) {
        bRequireMapRefresh = true;
        this.eObjxNWContactMethodExt = eObjxNWContactMethodExt;
        this.eObjxNWContactMethodExt.setBaseEntity(getEObjContactMethod());
        if (this.eObjxNWContactMethodExt != null && this.eObjxNWContactMethodExt.getControl() == null) {
            DWLControl control = this.getControl();
            if (control != null) {
                this.eObjxNWContactMethodExt.setControl(control);
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xExtension attribute.
     * 
     * @generated
     */
    public String getXExtension (){
   
        return eObjxNWContactMethodExt.getXExtension();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xExtension attribute.
     * 
     * @param newXExtension
     *     The new value of xExtension.
     * @generated
     */
    public void setXExtension( String newXExtension ) throws Exception {
        metaDataMap.put("XExtension", newXExtension);

        if (newXExtension == null || newXExtension.equals("")) {
            newXExtension = null;


        }
        eObjxNWContactMethodExt.setXExtension( newXExtension );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateTxId attribute.
     *
     * @generated
     */
    public String getXNWContactMethodLastUpdateTxId() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWContactMethodExt.getLastUpdateTxId());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateUser attribute.
     *
     * @generated
     */
    public String getXNWContactMethodLastUpdateUser() {
        return eObjxNWContactMethodExt.getLastUpdateUser();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateDt attribute.
     *
     * @generated
     */
    public String getXNWContactMethodLastUpdateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWContactMethodExt.getLastUpdateDt());
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
    public void setXNWContactMethodLastUpdateTxId(String newLastUpdateTxId) {
        metaDataMap.put("XNWContactMethodLastUpdateTxId", newLastUpdateTxId);

        if ((newLastUpdateTxId == null) || newLastUpdateTxId.equals("")) {
            newLastUpdateTxId = null;
        }
        eObjxNWContactMethodExt.setLastUpdateTxId(DWLFunctionUtils.getLongFromString(newLastUpdateTxId));
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
    public void setXNWContactMethodLastUpdateUser(String newLastUpdateUser) {
        metaDataMap.put("XNWContactMethodLastUpdateUser", newLastUpdateUser);

        if ((newLastUpdateUser == null) || newLastUpdateUser.equals("")) {
            newLastUpdateUser = null;
        }
        eObjxNWContactMethodExt.setLastUpdateUser(newLastUpdateUser);
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
    public void setXNWContactMethodLastUpdateDate(String newLastUpdateDt) throws Exception {
        metaDataMap.put("XNWContactMethodLastUpdateDate", newLastUpdateDt);

        if ((newLastUpdateDt == null) || newLastUpdateDt.equals("")) {
            newLastUpdateDt = null;
        }

        eObjxNWContactMethodExt.setLastUpdateDt(DWLFunctionUtils.getTimestampFromTimestampString(newLastUpdateDt));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWContactMethodHistActionCode history attribute.
     *
     * @generated
     */
    public String getXNWContactMethodHistActionCode() {
        return eObjxNWContactMethodExt.getHistActionCode();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWContactMethodHistActionCode history attribute.
     *
     * @param aXNWContactMethodHistActionCode
     *     The new value of XNWContactMethodHistActionCode.
     * @generated
     */
    public void setXNWContactMethodHistActionCode(String aXNWContactMethodHistActionCode) {
        metaDataMap.put("XNWContactMethodHistActionCode", aXNWContactMethodHistActionCode);

        if ((aXNWContactMethodHistActionCode == null) || aXNWContactMethodHistActionCode.equals("")) {
            aXNWContactMethodHistActionCode = null;
        }
        eObjxNWContactMethodExt.setHistActionCode(aXNWContactMethodHistActionCode);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWContactMethodHistCreateDate history attribute.
     *
     * @generated
     */
    public String getXNWContactMethodHistCreateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWContactMethodExt.getHistCreateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWContactMethodHistCreateDate history attribute.
     *
     * @param aXNWContactMethodHistCreateDate
     *     The new value of XNWContactMethodHistCreateDate.
     * @generated
     */
    public void setXNWContactMethodHistCreateDate(String aXNWContactMethodHistCreateDate) throws Exception{
        metaDataMap.put("XNWContactMethodHistCreateDate", aXNWContactMethodHistCreateDate);

        if ((aXNWContactMethodHistCreateDate == null) || aXNWContactMethodHistCreateDate.equals("")) {
            aXNWContactMethodHistCreateDate = null;
        }

        eObjxNWContactMethodExt.setHistCreateDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWContactMethodHistCreateDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWContactMethodHistCreatedBy history attribute.
     *
     * @generated
     */
    public String getXNWContactMethodHistCreatedBy() {
        return eObjxNWContactMethodExt.getHistCreatedBy();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWContactMethodHistCreatedBy history attribute.
     *
     * @param aXNWContactMethodHistCreatedBy
     *     The new value of XNWContactMethodHistCreatedBy.
     * @generated
     */
    public void setXNWContactMethodHistCreatedBy(String aXNWContactMethodHistCreatedBy) {
        metaDataMap.put("XNWContactMethodHistCreatedBy", aXNWContactMethodHistCreatedBy);

        if ((aXNWContactMethodHistCreatedBy == null) || aXNWContactMethodHistCreatedBy.equals("")) {
            aXNWContactMethodHistCreatedBy = null;
        }

        eObjxNWContactMethodExt.setHistCreatedBy(aXNWContactMethodHistCreatedBy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWContactMethodHistEndDate history attribute.
     *
     * @generated
     */
    public String getXNWContactMethodHistEndDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWContactMethodExt.getHistEndDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWContactMethodHistEndDate history attribute.
     *
     * @param aXNWContactMethodHistEndDate
     *     The new value of XNWContactMethodHistEndDate.
     * @generated
     */
    public void setXNWContactMethodHistEndDate(String aXNWContactMethodHistEndDate) throws Exception{
        metaDataMap.put("XNWContactMethodHistEndDate", aXNWContactMethodHistEndDate);

        if ((aXNWContactMethodHistEndDate == null) || aXNWContactMethodHistEndDate.equals("")) {
            aXNWContactMethodHistEndDate = null;
        }
        eObjxNWContactMethodExt.setHistEndDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWContactMethodHistEndDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWContactMethodHistoryIdPK history attribute.
     *
     * @generated
     */
    public String getXNWContactMethodHistoryIdPK() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWContactMethodExt.getHistoryIdPK());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWContactMethodHistoryIdPK history attribute.
     *
     * @param aXNWContactMethodHistoryIdPK
     *     The new value of XNWContactMethodHistoryIdPK.
     * @generated
     */
    public void setXNWContactMethodHistoryIdPK(String aXNWContactMethodHistoryIdPK) {
        metaDataMap.put("XNWContactMethodHistoryIdPK", aXNWContactMethodHistoryIdPK);

        if ((aXNWContactMethodHistoryIdPK == null) || aXNWContactMethodHistoryIdPK.equals("")) {
            aXNWContactMethodHistoryIdPK = null;
        }
        eObjxNWContactMethodExt.setHistoryIdPK(DWLFunctionUtils.getLongFromString(aXNWContactMethodHistoryIdPK));
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

    private DWLError createDWLError(String entityName, String propertyName,String reasonCode){	
		DWLError err = new DWLError();
		err.setComponentType(new Long(MDMNWComponentID.XNWCONTACT_METHOD_BOBJ_EXT).longValue());
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
                 Iterator<EObjxNWContactMethodExt> eObj = null;
                 String asOfDate = (String) this.getControl().get(
                         DWLControl.INQUIRE_AS_OF_DATE);
                 Timestamp tsAsOfDate = null;
                 
                 if ((asOfDate != null) && !asOfDate.equalsIgnoreCase("")) {
                     tsAsOfDate = DWLDateTimeUtilities.setPITHistoryDate(asOfDate, this.getControl());
 
                	 XNWContactMethodExtInquiryData theInquiryData = (XNWContactMethodExtInquiryData)DataAccessFactory.getQuery(XNWContactMethodExtInquiryData.class, connection);
                	 
                	 Object[] parameters = new Object[3];
                     parameters[0] = (Long) getEObjContactMethod().getPrimaryKey();
                     parameters[1] = tsAsOfDate;
                     parameters[2] = tsAsOfDate;
                     
                	 eObj = theInquiryData.getxNWContactMethodHistory(parameters);
                 } else {
                	 EObjxNWContactMethodExtData  theEObjData = (EObjxNWContactMethodExtData) DataAccessFactory
                     .getQuery(EObjxNWContactMethodExtData.class, connection);
                	 
                	 eObj = theEObjData.getEObjxNWContactMethodExt((Long)getEObjContactMethod().getPrimaryKey());
                 }
                 
                 if(eObj.hasNext()) {
         			this.setEObjxNWContactMethodExt((EObjxNWContactMethodExt)eObj.next());
         			
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
            DWLError error = errHandler.getErrorMessage(MDMNWComponentID.XNWCONTACT_METHOD_BOBJ_EXT,
                                                                 TCRMErrorCode.READ_RECORD_ERROR,
                                                                 MDMNWErrorReasonCode.READ_EXTENSION_XNWCONTACTMETHOD_FAILED,
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

