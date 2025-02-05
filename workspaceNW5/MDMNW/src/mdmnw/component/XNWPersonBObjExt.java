
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
 * IBM-MDMWB-1.0-[7191177d976911bf21d57642779937a4]
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

import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;

import com.dwl.tcrm.utilities.DateFormatter;
import com.dwl.tcrm.utilities.DateValidator;

import java.sql.Date;

import java.sql.Timestamp;
import java.util.Iterator;
import mdmnw.constant.MDMNWComponentID;
import mdmnw.constant.MDMNWErrorReasonCode;

import mdmnw.entityObject.EObjxNWPersonExt;
import mdmnw.entityObject.EObjxNWPersonExtData;
import mdmnw.entityObject.XNWPersonExtInquiryData;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class provides the implementation of the business object
 * <code>XNWPersonBObjExt</code>.
 * 
 * @see com.dwl.tcrm.common.TCRMCommon
 * @generated
 */
 

@SuppressWarnings("serial")
public class XNWPersonBObjExt extends TCRMPersonBObj implements IExtension {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected EObjxNWPersonExt eObjxNWPersonExt;
	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWPersonBObjExt.class);
		
 
	protected boolean isValidXHire_Date = true;
	
	protected boolean isValidXRehire_Date = true;
	
	protected boolean isValidXTermination_Date = true;
	


    protected boolean isValidXGender_LastVerifiedDate = true;
  protected boolean isValidXMaritalStatus_LastVerifiedDate = true;



    protected boolean isValidXEmploymentData_LastVerifiedDate = true;



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */     
    public XNWPersonBObjExt() {
        super();
        init();
        eObjxNWPersonExt = new EObjxNWPersonExt(getEObjPerson());
        setComponentID(MDMNWComponentID.XNWPERSON_BOBJ_EXT);
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
        metaDataMap.put("XJob_Title", null);
        metaDataMap.put("XJob_Family", null);
        metaDataMap.put("XFullTime_PartTIme", null);
        metaDataMap.put("XStandard_Hours", null);
        metaDataMap.put("XBusiness_Unit", null);
        metaDataMap.put("XHire_Date", null);
        metaDataMap.put("XEmployee_Role_Status", null);
        metaDataMap.put("XRehire_Date", null);
        metaDataMap.put("XTermination_Date", null);
        metaDataMap.put("XDepartment_ID", null);
        metaDataMap.put("XDepartment_Name", null);
        metaDataMap.put("XService_Line_Financial_Budgetary", null);
        metaDataMap.put("XGender_Source", null);
        metaDataMap.put("XGender_LastVerifiedDate", null);
        metaDataMap.put("XMaritalStatus_Source", null);
        metaDataMap.put("XMaritalStatus_LastVerifiedDate", null);
        metaDataMap.put("XEmploymentData_Source", null);
        metaDataMap.put("XEmploymentData_LastVerifiedDate", null);
        metaDataMap.put("XNWPersonHistActionCode", null);
        metaDataMap.put("XNWPersonHistCreateDate", null);
        metaDataMap.put("XNWPersonHistCreatedBy", null);
        metaDataMap.put("XNWPersonHistEndDate", null);
        metaDataMap.put("XNWPersonHistoryIdPK", null);
        metaDataMap.put("XNWPersonLastUpdateDate", null);
        metaDataMap.put("XNWPersonLastUpdateTxId", null);
        metaDataMap.put("XNWPersonLastUpdateUser", null);
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
            metaDataMap.put("XJob_Title", getXJob_Title());
            metaDataMap.put("XJob_Family", getXJob_Family());
            metaDataMap.put("XFullTime_PartTIme", getXFullTime_PartTIme());
            metaDataMap.put("XStandard_Hours", getXStandard_Hours());
            metaDataMap.put("XBusiness_Unit", getXBusiness_Unit());
            metaDataMap.put("XHire_Date", getXHire_Date());
            metaDataMap.put("XEmployee_Role_Status", getXEmployee_Role_Status());
            metaDataMap.put("XRehire_Date", getXRehire_Date());
            metaDataMap.put("XTermination_Date", getXTermination_Date());
            metaDataMap.put("XDepartment_ID", getXDepartment_ID());
            metaDataMap.put("XDepartment_Name", getXDepartment_Name());
            metaDataMap.put("XService_Line_Financial_Budgetary", getXService_Line_Financial_Budgetary());
            metaDataMap.put("XGender_Source", getXGender_Source());
            metaDataMap.put("XGender_LastVerifiedDate", getXGender_LastVerifiedDate());
            metaDataMap.put("XMaritalStatus_Source", getXMaritalStatus_Source());
            metaDataMap.put("XMaritalStatus_LastVerifiedDate", getXMaritalStatus_LastVerifiedDate());
            metaDataMap.put("XEmploymentData_Source", getXEmploymentData_Source());
            metaDataMap.put("XEmploymentData_LastVerifiedDate", getXEmploymentData_LastVerifiedDate());
            metaDataMap.put("XNWPersonHistActionCode", getXNWPersonHistActionCode());
            metaDataMap.put("XNWPersonHistCreateDate", getXNWPersonHistCreateDate());
            metaDataMap.put("XNWPersonHistCreatedBy", getXNWPersonHistCreatedBy());
            metaDataMap.put("XNWPersonHistEndDate", getXNWPersonHistEndDate());
            metaDataMap.put("XNWPersonHistoryIdPK", getXNWPersonHistoryIdPK());
            metaDataMap.put("XNWPersonLastUpdateDate", getXNWPersonLastUpdateDate());
            metaDataMap.put("XNWPersonLastUpdateTxId", getXNWPersonLastUpdateTxId());
            metaDataMap.put("XNWPersonLastUpdateUser", getXNWPersonLastUpdateUser());
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

        if (eObjxNWPersonExt != null) {
            eObjxNWPersonExt.setControl(newDWLControl);
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
    public EObjxNWPersonExt getEObjxNWPersonExt() {
        bRequireMapRefresh = true;
        return eObjxNWPersonExt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the entity object associated with this business object.
     *
     * @param eObjxNWPersonExt
     *            The eObjxNWPersonExt to set.
     * @generated
     */
    public void setEObjxNWPersonExt(EObjxNWPersonExt eObjxNWPersonExt) {
        bRequireMapRefresh = true;
        this.eObjxNWPersonExt = eObjxNWPersonExt;
        this.eObjxNWPersonExt.setBaseEntity(getEObjPerson());
        if (this.eObjxNWPersonExt != null && this.eObjxNWPersonExt.getControl() == null) {
            DWLControl control = this.getControl();
            if (control != null) {
                this.eObjxNWPersonExt.setControl(control);
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xJob_Title attribute.
     * 
     * @generated
     */
    public String getXJob_Title (){
   
        return eObjxNWPersonExt.getXJob_Title();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xJob_Title attribute.
     * 
     * @param newXJob_Title
     *     The new value of xJob_Title.
     * @generated
     */
    public void setXJob_Title( String newXJob_Title ) throws Exception {
        metaDataMap.put("XJob_Title", newXJob_Title);

        if (newXJob_Title == null || newXJob_Title.equals("")) {
            newXJob_Title = null;


        }
        eObjxNWPersonExt.setXJob_Title( newXJob_Title );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xJob_Family attribute.
     * 
     * @generated
     */
    public String getXJob_Family (){
   
        return eObjxNWPersonExt.getXJob_Family();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xJob_Family attribute.
     * 
     * @param newXJob_Family
     *     The new value of xJob_Family.
     * @generated
     */
    public void setXJob_Family( String newXJob_Family ) throws Exception {
        metaDataMap.put("XJob_Family", newXJob_Family);

        if (newXJob_Family == null || newXJob_Family.equals("")) {
            newXJob_Family = null;


        }
        eObjxNWPersonExt.setXJob_Family( newXJob_Family );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFullTime_PartTIme attribute.
     * 
     * @generated
     */
    public String getXFullTime_PartTIme (){
   
        return eObjxNWPersonExt.getIxFullTime_PartTIme();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFullTime_PartTIme attribute.
     * 
     * @param newXFullTime_PartTIme
     *     The new value of xFullTime_PartTIme.
     * @generated
     */
    public void setXFullTime_PartTIme( String newXFullTime_PartTIme ) throws Exception {
        metaDataMap.put("XFullTime_PartTIme", newXFullTime_PartTIme);

        if (newXFullTime_PartTIme == null || newXFullTime_PartTIme.equals("")) {
            newXFullTime_PartTIme = null;


        }
        eObjxNWPersonExt.setIxFullTime_PartTIme( newXFullTime_PartTIme );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xStandard_Hours attribute.
     * 
     * @generated
     */
    public String getXStandard_Hours (){
   
        return eObjxNWPersonExt.getXStandard_Hours();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xStandard_Hours attribute.
     * 
     * @param newXStandard_Hours
     *     The new value of xStandard_Hours.
     * @generated
     */
    public void setXStandard_Hours( String newXStandard_Hours ) throws Exception {
        metaDataMap.put("XStandard_Hours", newXStandard_Hours);

        if (newXStandard_Hours == null || newXStandard_Hours.equals("")) {
            newXStandard_Hours = null;


        }
        eObjxNWPersonExt.setXStandard_Hours( newXStandard_Hours );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xBusiness_Unit attribute.
     * 
     * @generated
     */
    public String getXBusiness_Unit (){
   
        return eObjxNWPersonExt.getXBusiness_Unit();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xBusiness_Unit attribute.
     * 
     * @param newXBusiness_Unit
     *     The new value of xBusiness_Unit.
     * @generated
     */
    public void setXBusiness_Unit( String newXBusiness_Unit ) throws Exception {
        metaDataMap.put("XBusiness_Unit", newXBusiness_Unit);

        if (newXBusiness_Unit == null || newXBusiness_Unit.equals("")) {
            newXBusiness_Unit = null;


        }
        eObjxNWPersonExt.setXBusiness_Unit( newXBusiness_Unit );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xHire_Date attribute.
     * 
     * @generated
     */
    public String getXHire_Date (){
   
        return DWLFunctionUtils.getStringFromDate(eObjxNWPersonExt.getXHire_Date());
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xHire_Date attribute.
     * 
     * @param newXHire_Date
     *     The new value of xHire_Date.
     * @generated
     */
    public void setXHire_Date( String newXHire_Date ) throws Exception {
        metaDataMap.put("XHire_Date", newXHire_Date);

       	isValidXHire_Date = true;
        if (newXHire_Date == null || newXHire_Date.equals("")) {
            newXHire_Date = null;

            eObjxNWPersonExt.setXHire_Date(null);

        }
    else {
        	if (DateValidator.validates(newXHire_Date)) {
           		eObjxNWPersonExt.setXHire_Date(new Date(DateFormatter.getStartDateTimestamp(newXHire_Date).getTime()));
            	metaDataMap.put("XHire_Date", getXHire_Date());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XHire_Date") != null) {
                    	metaDataMap.put("XHire_Date", "");
                	}
                	isValidXHire_Date = false;
                	eObjxNWPersonExt.setXHire_Date(null);
            	}
        	}
        }       
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xEmployee_Role_Status attribute.
     * 
     * @generated
     */
    public String getXEmployee_Role_Status (){
   
        return eObjxNWPersonExt.getXEmployee_Role_Status();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xEmployee_Role_Status attribute.
     * 
     * @param newXEmployee_Role_Status
     *     The new value of xEmployee_Role_Status.
     * @generated
     */
    public void setXEmployee_Role_Status( String newXEmployee_Role_Status ) throws Exception {
        metaDataMap.put("XEmployee_Role_Status", newXEmployee_Role_Status);

        if (newXEmployee_Role_Status == null || newXEmployee_Role_Status.equals("")) {
            newXEmployee_Role_Status = null;


        }
        eObjxNWPersonExt.setXEmployee_Role_Status( newXEmployee_Role_Status );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xRehire_Date attribute.
     * 
     * @generated
     */
    public String getXRehire_Date (){
   
        return DWLFunctionUtils.getStringFromDate(eObjxNWPersonExt.getXRehire_Date());
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xRehire_Date attribute.
     * 
     * @param newXRehire_Date
     *     The new value of xRehire_Date.
     * @generated
     */
    public void setXRehire_Date( String newXRehire_Date ) throws Exception {
        metaDataMap.put("XRehire_Date", newXRehire_Date);

       	isValidXRehire_Date = true;
        if (newXRehire_Date == null || newXRehire_Date.equals("")) {
            newXRehire_Date = null;

            eObjxNWPersonExt.setXRehire_Date(null);

        }
    else {
        	if (DateValidator.validates(newXRehire_Date)) {
           		eObjxNWPersonExt.setXRehire_Date(new Date(DateFormatter.getStartDateTimestamp(newXRehire_Date).getTime()));
            	metaDataMap.put("XRehire_Date", getXRehire_Date());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XRehire_Date") != null) {
                    	metaDataMap.put("XRehire_Date", "");
                	}
                	isValidXRehire_Date = false;
                	eObjxNWPersonExt.setXRehire_Date(null);
            	}
        	}
        }       
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTermination_Date attribute.
     * 
     * @generated
     */
    public String getXTermination_Date (){
   
        return DWLFunctionUtils.getStringFromDate(eObjxNWPersonExt.getXTermination_Date());
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTermination_Date attribute.
     * 
     * @param newXTermination_Date
     *     The new value of xTermination_Date.
     * @generated
     */
    public void setXTermination_Date( String newXTermination_Date ) throws Exception {
        metaDataMap.put("XTermination_Date", newXTermination_Date);

       	isValidXTermination_Date = true;
        if (newXTermination_Date == null || newXTermination_Date.equals("")) {
            newXTermination_Date = null;

            eObjxNWPersonExt.setXTermination_Date(null);

        }
    else {
        	if (DateValidator.validates(newXTermination_Date)) {
           		eObjxNWPersonExt.setXTermination_Date(new Date(DateFormatter.getStartDateTimestamp(newXTermination_Date).getTime()));
            	metaDataMap.put("XTermination_Date", getXTermination_Date());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XTermination_Date") != null) {
                    	metaDataMap.put("XTermination_Date", "");
                	}
                	isValidXTermination_Date = false;
                	eObjxNWPersonExt.setXTermination_Date(null);
            	}
        	}
        }       
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_ID attribute.
     * 
     * @generated
     */
    public String getXDepartment_ID (){
   
        return eObjxNWPersonExt.getXDepartment_ID();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_ID attribute.
     * 
     * @param newXDepartment_ID
     *     The new value of xDepartment_ID.
     * @generated
     */
    public void setXDepartment_ID( String newXDepartment_ID ) throws Exception {
        metaDataMap.put("XDepartment_ID", newXDepartment_ID);

        if (newXDepartment_ID == null || newXDepartment_ID.equals("")) {
            newXDepartment_ID = null;


        }
        eObjxNWPersonExt.setXDepartment_ID( newXDepartment_ID );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_Name attribute.
     * 
     * @generated
     */
    public String getXDepartment_Name (){
   
        return eObjxNWPersonExt.getXDepartment_Name();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_Name attribute.
     * 
     * @param newXDepartment_Name
     *     The new value of xDepartment_Name.
     * @generated
     */
    public void setXDepartment_Name( String newXDepartment_Name ) throws Exception {
        metaDataMap.put("XDepartment_Name", newXDepartment_Name);

        if (newXDepartment_Name == null || newXDepartment_Name.equals("")) {
            newXDepartment_Name = null;


        }
        eObjxNWPersonExt.setXDepartment_Name( newXDepartment_Name );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xService_Line_Financial_Budgetary attribute.
     * 
     * @generated
     */
    public String getXService_Line_Financial_Budgetary (){
   
        return eObjxNWPersonExt.getXService_Line_Financial_Budgetary();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xService_Line_Financial_Budgetary attribute.
     * 
     * @param newXService_Line_Financial_Budgetary
     *     The new value of xService_Line_Financial_Budgetary.
     * @generated
     */
    public void setXService_Line_Financial_Budgetary( String newXService_Line_Financial_Budgetary ) throws Exception {
        metaDataMap.put("XService_Line_Financial_Budgetary", newXService_Line_Financial_Budgetary);

        if (newXService_Line_Financial_Budgetary == null || newXService_Line_Financial_Budgetary.equals("")) {
            newXService_Line_Financial_Budgetary = null;


        }
        eObjxNWPersonExt.setXService_Line_Financial_Budgetary( newXService_Line_Financial_Budgetary );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xGender_Source attribute.
     * 
     * @generated
     */
    public String getXGender_Source (){
   
        return eObjxNWPersonExt.getXGender_Source();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xGender_Source attribute.
     * 
     * @param newXGender_Source
     *     The new value of xGender_Source.
     * @generated
     */
    public void setXGender_Source( String newXGender_Source ) throws Exception {
        metaDataMap.put("XGender_Source", newXGender_Source);

        if (newXGender_Source == null || newXGender_Source.equals("")) {
            newXGender_Source = null;


        }
        eObjxNWPersonExt.setXGender_Source( newXGender_Source );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xGender_LastVerifiedDate attribute.
     * 
     * @generated
     */
    public String getXGender_LastVerifiedDate (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonExt.getXGender_LastVerifiedDate());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xGender_LastVerifiedDate attribute.
     * 
     * @param newXGender_LastVerifiedDate
     *     The new value of xGender_LastVerifiedDate.
     * @generated
     */
    public void setXGender_LastVerifiedDate( String newXGender_LastVerifiedDate ) throws Exception {
        metaDataMap.put("XGender_LastVerifiedDate", newXGender_LastVerifiedDate);
       	isValidXGender_LastVerifiedDate = true;

        if (newXGender_LastVerifiedDate == null || newXGender_LastVerifiedDate.equals("")) {
            newXGender_LastVerifiedDate = null;
            eObjxNWPersonExt.setXGender_LastVerifiedDate(null);


        }
    else {
        	if (DateValidator.validates(newXGender_LastVerifiedDate)) {
           		eObjxNWPersonExt.setXGender_LastVerifiedDate(DateFormatter.getStartDateTimestamp(newXGender_LastVerifiedDate));
            	metaDataMap.put("XGender_LastVerifiedDate", getXGender_LastVerifiedDate());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XGender_LastVerifiedDate") != null) {
                    	metaDataMap.put("XGender_LastVerifiedDate", "");
                	}
                	isValidXGender_LastVerifiedDate = false;
                	eObjxNWPersonExt.setXGender_LastVerifiedDate(null);
            	}
        	}
        }
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xMaritalStatus_Source attribute.
     * 
     * @generated
     */
    public String getXMaritalStatus_Source (){
   
        return eObjxNWPersonExt.getXMaritalStatus_Source();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xMaritalStatus_Source attribute.
     * 
     * @param newXMaritalStatus_Source
     *     The new value of xMaritalStatus_Source.
     * @generated
     */
    public void setXMaritalStatus_Source( String newXMaritalStatus_Source ) throws Exception {
        metaDataMap.put("XMaritalStatus_Source", newXMaritalStatus_Source);

        if (newXMaritalStatus_Source == null || newXMaritalStatus_Source.equals("")) {
            newXMaritalStatus_Source = null;


        }
        eObjxNWPersonExt.setXMaritalStatus_Source( newXMaritalStatus_Source );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xMaritalStatus_LastVerifiedDate attribute.
     * 
     * @generated
     */
    public String getXMaritalStatus_LastVerifiedDate (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonExt.getXMaritalStatus_LastVerifiedDate());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xMaritalStatus_LastVerifiedDate attribute.
     * 
     * @param newXMaritalStatus_LastVerifiedDate
     *     The new value of xMaritalStatus_LastVerifiedDate.
     * @generated
     */
    public void setXMaritalStatus_LastVerifiedDate( String newXMaritalStatus_LastVerifiedDate ) throws Exception {
        metaDataMap.put("XMaritalStatus_LastVerifiedDate", newXMaritalStatus_LastVerifiedDate);
       	isValidXMaritalStatus_LastVerifiedDate = true;

        if (newXMaritalStatus_LastVerifiedDate == null || newXMaritalStatus_LastVerifiedDate.equals("")) {
            newXMaritalStatus_LastVerifiedDate = null;
            eObjxNWPersonExt.setXMaritalStatus_LastVerifiedDate(null);


        }
    else {
        	if (DateValidator.validates(newXMaritalStatus_LastVerifiedDate)) {
           		eObjxNWPersonExt.setXMaritalStatus_LastVerifiedDate(DateFormatter.getStartDateTimestamp(newXMaritalStatus_LastVerifiedDate));
            	metaDataMap.put("XMaritalStatus_LastVerifiedDate", getXMaritalStatus_LastVerifiedDate());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XMaritalStatus_LastVerifiedDate") != null) {
                    	metaDataMap.put("XMaritalStatus_LastVerifiedDate", "");
                	}
                	isValidXMaritalStatus_LastVerifiedDate = false;
                	eObjxNWPersonExt.setXMaritalStatus_LastVerifiedDate(null);
            	}
        	}
        }
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xEmploymentData_Source attribute.
     * 
     * @generated
     */
    public String getXEmploymentData_Source (){
   
        return eObjxNWPersonExt.getXEmploymentData_Source();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xEmploymentData_Source attribute.
     * 
     * @param newXEmploymentData_Source
     *     The new value of xEmploymentData_Source.
     * @generated
     */
    public void setXEmploymentData_Source( String newXEmploymentData_Source ) throws Exception {
        metaDataMap.put("XEmploymentData_Source", newXEmploymentData_Source);

        if (newXEmploymentData_Source == null || newXEmploymentData_Source.equals("")) {
            newXEmploymentData_Source = null;


        }
        eObjxNWPersonExt.setXEmploymentData_Source( newXEmploymentData_Source );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xEmploymentData_LastVerifiedDate attribute.
     * 
     * @generated
     */
    public String getXEmploymentData_LastVerifiedDate (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonExt.getXEmploymentData_LastVerifiedDate());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xEmploymentData_LastVerifiedDate attribute.
     * 
     * @param newXEmploymentData_LastVerifiedDate
     *     The new value of xEmploymentData_LastVerifiedDate.
     * @generated
     */
    public void setXEmploymentData_LastVerifiedDate( String newXEmploymentData_LastVerifiedDate ) throws Exception {
        metaDataMap.put("XEmploymentData_LastVerifiedDate", newXEmploymentData_LastVerifiedDate);
       	isValidXEmploymentData_LastVerifiedDate = true;

        if (newXEmploymentData_LastVerifiedDate == null || newXEmploymentData_LastVerifiedDate.equals("")) {
            newXEmploymentData_LastVerifiedDate = null;
            eObjxNWPersonExt.setXEmploymentData_LastVerifiedDate(null);


        }
    else {
        	if (DateValidator.validates(newXEmploymentData_LastVerifiedDate)) {
           		eObjxNWPersonExt.setXEmploymentData_LastVerifiedDate(DateFormatter.getStartDateTimestamp(newXEmploymentData_LastVerifiedDate));
            	metaDataMap.put("XEmploymentData_LastVerifiedDate", getXEmploymentData_LastVerifiedDate());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XEmploymentData_LastVerifiedDate") != null) {
                    	metaDataMap.put("XEmploymentData_LastVerifiedDate", "");
                	}
                	isValidXEmploymentData_LastVerifiedDate = false;
                	eObjxNWPersonExt.setXEmploymentData_LastVerifiedDate(null);
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
    public String getXNWPersonLastUpdateTxId() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWPersonExt.getLastUpdateTxId());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateUser attribute.
     *
     * @generated
     */
    public String getXNWPersonLastUpdateUser() {
        return eObjxNWPersonExt.getLastUpdateUser();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateDt attribute.
     *
     * @generated
     */
    public String getXNWPersonLastUpdateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonExt.getLastUpdateDt());
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
    public void setXNWPersonLastUpdateTxId(String newLastUpdateTxId) {
        metaDataMap.put("XNWPersonLastUpdateTxId", newLastUpdateTxId);

        if ((newLastUpdateTxId == null) || newLastUpdateTxId.equals("")) {
            newLastUpdateTxId = null;
        }
        eObjxNWPersonExt.setLastUpdateTxId(DWLFunctionUtils.getLongFromString(newLastUpdateTxId));
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
    public void setXNWPersonLastUpdateUser(String newLastUpdateUser) {
        metaDataMap.put("XNWPersonLastUpdateUser", newLastUpdateUser);

        if ((newLastUpdateUser == null) || newLastUpdateUser.equals("")) {
            newLastUpdateUser = null;
        }
        eObjxNWPersonExt.setLastUpdateUser(newLastUpdateUser);
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
    public void setXNWPersonLastUpdateDate(String newLastUpdateDt) throws Exception {
        metaDataMap.put("XNWPersonLastUpdateDate", newLastUpdateDt);

        if ((newLastUpdateDt == null) || newLastUpdateDt.equals("")) {
            newLastUpdateDt = null;
        }

        eObjxNWPersonExt.setLastUpdateDt(DWLFunctionUtils.getTimestampFromTimestampString(newLastUpdateDt));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonHistActionCode history attribute.
     *
     * @generated
     */
    public String getXNWPersonHistActionCode() {
        return eObjxNWPersonExt.getHistActionCode();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonHistActionCode history attribute.
     *
     * @param aXNWPersonHistActionCode
     *     The new value of XNWPersonHistActionCode.
     * @generated
     */
    public void setXNWPersonHistActionCode(String aXNWPersonHistActionCode) {
        metaDataMap.put("XNWPersonHistActionCode", aXNWPersonHistActionCode);

        if ((aXNWPersonHistActionCode == null) || aXNWPersonHistActionCode.equals("")) {
            aXNWPersonHistActionCode = null;
        }
        eObjxNWPersonExt.setHistActionCode(aXNWPersonHistActionCode);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonHistCreateDate history attribute.
     *
     * @generated
     */
    public String getXNWPersonHistCreateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonExt.getHistCreateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonHistCreateDate history attribute.
     *
     * @param aXNWPersonHistCreateDate
     *     The new value of XNWPersonHistCreateDate.
     * @generated
     */
    public void setXNWPersonHistCreateDate(String aXNWPersonHistCreateDate) throws Exception{
        metaDataMap.put("XNWPersonHistCreateDate", aXNWPersonHistCreateDate);

        if ((aXNWPersonHistCreateDate == null) || aXNWPersonHistCreateDate.equals("")) {
            aXNWPersonHistCreateDate = null;
        }

        eObjxNWPersonExt.setHistCreateDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWPersonHistCreateDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonHistCreatedBy history attribute.
     *
     * @generated
     */
    public String getXNWPersonHistCreatedBy() {
        return eObjxNWPersonExt.getHistCreatedBy();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonHistCreatedBy history attribute.
     *
     * @param aXNWPersonHistCreatedBy
     *     The new value of XNWPersonHistCreatedBy.
     * @generated
     */
    public void setXNWPersonHistCreatedBy(String aXNWPersonHistCreatedBy) {
        metaDataMap.put("XNWPersonHistCreatedBy", aXNWPersonHistCreatedBy);

        if ((aXNWPersonHistCreatedBy == null) || aXNWPersonHistCreatedBy.equals("")) {
            aXNWPersonHistCreatedBy = null;
        }

        eObjxNWPersonExt.setHistCreatedBy(aXNWPersonHistCreatedBy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonHistEndDate history attribute.
     *
     * @generated
     */
    public String getXNWPersonHistEndDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPersonExt.getHistEndDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonHistEndDate history attribute.
     *
     * @param aXNWPersonHistEndDate
     *     The new value of XNWPersonHistEndDate.
     * @generated
     */
    public void setXNWPersonHistEndDate(String aXNWPersonHistEndDate) throws Exception{
        metaDataMap.put("XNWPersonHistEndDate", aXNWPersonHistEndDate);

        if ((aXNWPersonHistEndDate == null) || aXNWPersonHistEndDate.equals("")) {
            aXNWPersonHistEndDate = null;
        }
        eObjxNWPersonExt.setHistEndDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWPersonHistEndDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPersonHistoryIdPK history attribute.
     *
     * @generated
     */
    public String getXNWPersonHistoryIdPK() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWPersonExt.getHistoryIdPK());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPersonHistoryIdPK history attribute.
     *
     * @param aXNWPersonHistoryIdPK
     *     The new value of XNWPersonHistoryIdPK.
     * @generated
     */
    public void setXNWPersonHistoryIdPK(String aXNWPersonHistoryIdPK) {
        metaDataMap.put("XNWPersonHistoryIdPK", aXNWPersonHistoryIdPK);

        if ((aXNWPersonHistoryIdPK == null) || aXNWPersonHistoryIdPK.equals("")) {
            aXNWPersonHistoryIdPK = null;
        }
        eObjxNWPersonExt.setHistoryIdPK(DWLFunctionUtils.getLongFromString(aXNWPersonHistoryIdPK));
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
    		controllerValidation_XHire_Date(status);
    		controllerValidation_XRehire_Date(status);
    		controllerValidation_XTermination_Date(status);
    		controllerValidation_XGender_LastVerifiedDate(status);
    		controllerValidation_XMaritalStatus_LastVerifiedDate(status);
    		controllerValidation_XEmploymentData_LastVerifiedDate(status);
    	}

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO0: CDKWB0035I Add any common component-level custom validation logic
            // to be executed for this object during either "add" or "update"
            // transactions
    		componentValidation_XHire_Date(status);
    		componentValidation_XRehire_Date(status);
    		componentValidation_XTermination_Date(status);
    		componentValidation_XGender_LastVerifiedDate(status);
    		componentValidation_XMaritalStatus_LastVerifiedDate(status);
    		componentValidation_XEmploymentData_LastVerifiedDate(status);
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
     * Perform component-level custom validation logic for attribute "XHire_Date"
     *
     * @generated
     */
	private void componentValidation_XHire_Date(DWLStatus status) {
  
  }
    	
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XRehire_Date"
     *
     * @generated
     */
	private void componentValidation_XRehire_Date(DWLStatus status) {
  
  }
    	
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XTermination_Date"
     *
     * @generated
     */
	private void componentValidation_XTermination_Date(DWLStatus status) {
  
  }
    	
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XGender_LastVerifiedDate"
     *
     * @generated
     */
  private void componentValidation_XGender_LastVerifiedDate(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XMaritalStatus_LastVerifiedDate"
     *
     * @generated
     */
  private void componentValidation_XMaritalStatus_LastVerifiedDate(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XEmploymentData_LastVerifiedDate"
     *
     * @generated
     */
  private void componentValidation_XEmploymentData_LastVerifiedDate(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XHire_Date"
     *
     * @generated
     */
	private void controllerValidation_XHire_Date(DWLStatus status) throws Exception {
  
            boolean isXHire_DateNull = (eObjxNWPersonExt.getXHire_Date() == null);
            if (!isValidXHire_Date) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSON_XHIRE_DATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid date specified on property xHire_Date in entity xNWPerson, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XHire_Date " + infoForLogging);
               	status.addError(err);
            } 
    	}
    	
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XRehire_Date"
     *
     * @generated
     */
	private void controllerValidation_XRehire_Date(DWLStatus status) throws Exception {
  
            boolean isXRehire_DateNull = (eObjxNWPersonExt.getXRehire_Date() == null);
            if (!isValidXRehire_Date) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSON_XREHIRE_DATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid date specified on property xRehire_Date in entity xNWPerson, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XRehire_Date " + infoForLogging);
               	status.addError(err);
            } 
    	}
    	
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XTermination_Date"
     *
     * @generated
     */
	private void controllerValidation_XTermination_Date(DWLStatus status) throws Exception {
  
            boolean isXTermination_DateNull = (eObjxNWPersonExt.getXTermination_Date() == null);
            if (!isValidXTermination_Date) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSON_XTERMINATION_DATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid date specified on property xTermination_Date in entity xNWPerson, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XTermination_Date " + infoForLogging);
               	status.addError(err);
            } 
    	}
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XGender_LastVerifiedDate"
     *
     * @generated
     */
  private void controllerValidation_XGender_LastVerifiedDate(DWLStatus status) throws Exception {
  
            boolean isXGender_LastVerifiedDateNull = (eObjxNWPersonExt.getXGender_LastVerifiedDate() == null);
            if (!isValidXGender_LastVerifiedDate) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSON_XGENDER_LASTVERIFIEDDATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xGender_LastVerifiedDate in entity xNWPerson, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XGender_LastVerifiedDate " + infoForLogging);
               	status.addError(err);
            } 
    	}


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XMaritalStatus_LastVerifiedDate"
     *
     * @generated
     */
  private void controllerValidation_XMaritalStatus_LastVerifiedDate(DWLStatus status) throws Exception {
  
            boolean isXMaritalStatus_LastVerifiedDateNull = (eObjxNWPersonExt.getXMaritalStatus_LastVerifiedDate() == null);
            if (!isValidXMaritalStatus_LastVerifiedDate) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSON_XMARITALSTATUS_LASTVERIFIEDDATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xMaritalStatus_LastVerifiedDate in entity xNWPerson, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XMaritalStatus_LastVerifiedDate " + infoForLogging);
               	status.addError(err);
            } 
    	}


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XEmploymentData_LastVerifiedDate"
     *
     * @generated
     */
  private void controllerValidation_XEmploymentData_LastVerifiedDate(DWLStatus status) throws Exception {
  
            boolean isXEmploymentData_LastVerifiedDateNull = (eObjxNWPersonExt.getXEmploymentData_LastVerifiedDate() == null);
            if (!isValidXEmploymentData_LastVerifiedDate) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWPERSON_XEMPLOYMENTDATA_LASTVERIFIEDDATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xEmploymentData_LastVerifiedDate in entity xNWPerson, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XEmploymentData_LastVerifiedDate " + infoForLogging);
               	status.addError(err);
            } 
    	}


    private DWLError createDWLError(String entityName, String propertyName,String reasonCode){	
		DWLError err = new DWLError();
		err.setComponentType(new Long(MDMNWComponentID.XNWPERSON_BOBJ_EXT).longValue());
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
                 Iterator<EObjxNWPersonExt> eObj = null;
                 String asOfDate = (String) this.getControl().get(
                         DWLControl.INQUIRE_AS_OF_DATE);
                 Timestamp tsAsOfDate = null;
                 
                 if ((asOfDate != null) && !asOfDate.equalsIgnoreCase("")) {
                     tsAsOfDate = DWLDateTimeUtilities.setPITHistoryDate(asOfDate, this.getControl());
 
                	 XNWPersonExtInquiryData theInquiryData = (XNWPersonExtInquiryData)DataAccessFactory.getQuery(XNWPersonExtInquiryData.class, connection);
                	 
                	 Object[] parameters = new Object[3];
                     parameters[0] = (Long) getEObjPerson().getPrimaryKey();
                     parameters[1] = tsAsOfDate;
                     parameters[2] = tsAsOfDate;
                     
                	 eObj = theInquiryData.getxNWPersonHistory(parameters);
                 } else {
                	 EObjxNWPersonExtData  theEObjData = (EObjxNWPersonExtData) DataAccessFactory
                     .getQuery(EObjxNWPersonExtData.class, connection);
                	 
                	 eObj = theEObjData.getEObjxNWPersonExt((Long)getEObjPerson().getPrimaryKey());
                 }
                 
                 if(eObj.hasNext()) {
         			this.setEObjxNWPersonExt((EObjxNWPersonExt)eObj.next());
         			
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
            DWLError error = errHandler.getErrorMessage(MDMNWComponentID.XNWPERSON_BOBJ_EXT,
                                                                 TCRMErrorCode.READ_RECORD_ERROR,
                                                                 MDMNWErrorReasonCode.READ_EXTENSION_XNWPERSON_FAILED,
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

