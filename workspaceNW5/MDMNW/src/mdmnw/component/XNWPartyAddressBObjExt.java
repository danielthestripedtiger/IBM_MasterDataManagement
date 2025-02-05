
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
 * IBM-MDMWB-1.0-[caacdceb864de892be89bb7ffb7ab1da]
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

import com.dwl.tcrm.coreParty.component.TCRMPartyAddressBObj;

import java.sql.Timestamp;
import java.util.Iterator;
import mdmnw.constant.MDMNWComponentID;
import mdmnw.constant.MDMNWErrorReasonCode;

import mdmnw.entityObject.EObjxNWPartyAddressExt;
import mdmnw.entityObject.EObjxNWPartyAddressExtData;
import mdmnw.entityObject.XNWPartyAddressExtInquiryData;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class provides the implementation of the business object
 * <code>XNWPartyAddressBObjExt</code>.
 * 
 * @see com.dwl.tcrm.common.TCRMCommon
 * @generated
 */
 

@SuppressWarnings("serial")
public class XNWPartyAddressBObjExt extends TCRMPartyAddressBObj implements IExtension {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected EObjxNWPartyAddressExt eObjxNWPartyAddressExt;
	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWPartyAddressBObjExt.class);
		
 


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */     
    public XNWPartyAddressBObjExt() {
        super();
        init();
        eObjxNWPartyAddressExt = new EObjxNWPartyAddressExt(getEObjAddressGroup());
        setComponentID(MDMNWComponentID.XNWPARTY_ADDRESS_BOBJ_EXT);
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
        metaDataMap.put("XProvider_Facility_Staff_Code", null);
        metaDataMap.put("XProvider_Facility_Active_Status", null);
        metaDataMap.put("XPrimary_Office_Flag", null);
        metaDataMap.put("XDeactivation_Flag", null);
        metaDataMap.put("XPrimary_Billing_Location_Flag", null);
        metaDataMap.put("XCredential_Status", null);
        metaDataMap.put("XProvider_Status", null);
        metaDataMap.put("XScheduling_Primary_Flag", null);
        metaDataMap.put("XPhone", null);
        metaDataMap.put("XPhone_Ext", null);
        metaDataMap.put("XSecondary_Phone", null);
        metaDataMap.put("XSec_Phone_Ext", null);
        metaDataMap.put("XFax", null);
        metaDataMap.put("XNWPartyAddressHistActionCode", null);
        metaDataMap.put("XNWPartyAddressHistCreateDate", null);
        metaDataMap.put("XNWPartyAddressHistCreatedBy", null);
        metaDataMap.put("XNWPartyAddressHistEndDate", null);
        metaDataMap.put("XNWPartyAddressHistoryIdPK", null);
        metaDataMap.put("XNWPartyAddressLastUpdateDate", null);
        metaDataMap.put("XNWPartyAddressLastUpdateTxId", null);
        metaDataMap.put("XNWPartyAddressLastUpdateUser", null);
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
            metaDataMap.put("XProvider_Facility_Staff_Code", getXProvider_Facility_Staff_Code());
            metaDataMap.put("XProvider_Facility_Active_Status", getXProvider_Facility_Active_Status());
            metaDataMap.put("XPrimary_Office_Flag", getXPrimary_Office_Flag());
            metaDataMap.put("XDeactivation_Flag", getXDeactivation_Flag());
            metaDataMap.put("XPrimary_Billing_Location_Flag", getXPrimary_Billing_Location_Flag());
            metaDataMap.put("XCredential_Status", getXCredential_Status());
            metaDataMap.put("XProvider_Status", getXProvider_Status());
            metaDataMap.put("XScheduling_Primary_Flag", getXScheduling_Primary_Flag());
            metaDataMap.put("XPhone", getXPhone());
            metaDataMap.put("XPhone_Ext", getXPhone_Ext());
            metaDataMap.put("XSecondary_Phone", getXSecondary_Phone());
            metaDataMap.put("XSec_Phone_Ext", getXSec_Phone_Ext());
            metaDataMap.put("XFax", getXFax());
            metaDataMap.put("XNWPartyAddressHistActionCode", getXNWPartyAddressHistActionCode());
            metaDataMap.put("XNWPartyAddressHistCreateDate", getXNWPartyAddressHistCreateDate());
            metaDataMap.put("XNWPartyAddressHistCreatedBy", getXNWPartyAddressHistCreatedBy());
            metaDataMap.put("XNWPartyAddressHistEndDate", getXNWPartyAddressHistEndDate());
            metaDataMap.put("XNWPartyAddressHistoryIdPK", getXNWPartyAddressHistoryIdPK());
            metaDataMap.put("XNWPartyAddressLastUpdateDate", getXNWPartyAddressLastUpdateDate());
            metaDataMap.put("XNWPartyAddressLastUpdateTxId", getXNWPartyAddressLastUpdateTxId());
            metaDataMap.put("XNWPartyAddressLastUpdateUser", getXNWPartyAddressLastUpdateUser());
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

        if (eObjxNWPartyAddressExt != null) {
            eObjxNWPartyAddressExt.setControl(newDWLControl);
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
    public EObjxNWPartyAddressExt getEObjxNWPartyAddressExt() {
        bRequireMapRefresh = true;
        return eObjxNWPartyAddressExt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the entity object associated with this business object.
     *
     * @param eObjxNWPartyAddressExt
     *            The eObjxNWPartyAddressExt to set.
     * @generated
     */
    public void setEObjxNWPartyAddressExt(EObjxNWPartyAddressExt eObjxNWPartyAddressExt) {
        bRequireMapRefresh = true;
        this.eObjxNWPartyAddressExt = eObjxNWPartyAddressExt;
        this.eObjxNWPartyAddressExt.setBaseEntity(getEObjAddressGroup());
        if (this.eObjxNWPartyAddressExt != null && this.eObjxNWPartyAddressExt.getControl() == null) {
            DWLControl control = this.getControl();
            if (control != null) {
                this.eObjxNWPartyAddressExt.setControl(control);
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xProvider_Facility_Staff_Code attribute.
     * 
     * @generated
     */
    public String getXProvider_Facility_Staff_Code (){
   
        return eObjxNWPartyAddressExt.getXProvider_Facility_Staff_Code();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xProvider_Facility_Staff_Code attribute.
     * 
     * @param newXProvider_Facility_Staff_Code
     *     The new value of xProvider_Facility_Staff_Code.
     * @generated
     */
    public void setXProvider_Facility_Staff_Code( String newXProvider_Facility_Staff_Code ) throws Exception {
        metaDataMap.put("XProvider_Facility_Staff_Code", newXProvider_Facility_Staff_Code);

        if (newXProvider_Facility_Staff_Code == null || newXProvider_Facility_Staff_Code.equals("")) {
            newXProvider_Facility_Staff_Code = null;


        }
        eObjxNWPartyAddressExt.setXProvider_Facility_Staff_Code( newXProvider_Facility_Staff_Code );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xProvider_Facility_Active_Status attribute.
     * 
     * @generated
     */
    public String getXProvider_Facility_Active_Status (){
   
        return eObjxNWPartyAddressExt.getXProvider_Facility_Active_Status();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xProvider_Facility_Active_Status attribute.
     * 
     * @param newXProvider_Facility_Active_Status
     *     The new value of xProvider_Facility_Active_Status.
     * @generated
     */
    public void setXProvider_Facility_Active_Status( String newXProvider_Facility_Active_Status ) throws Exception {
        metaDataMap.put("XProvider_Facility_Active_Status", newXProvider_Facility_Active_Status);

        if (newXProvider_Facility_Active_Status == null || newXProvider_Facility_Active_Status.equals("")) {
            newXProvider_Facility_Active_Status = null;


        }
        eObjxNWPartyAddressExt.setXProvider_Facility_Active_Status( newXProvider_Facility_Active_Status );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPrimary_Office_Flag attribute.
     * 
     * @generated
     */
    public String getXPrimary_Office_Flag (){
   
        return eObjxNWPartyAddressExt.getXPrimary_Office_Flag();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPrimary_Office_Flag attribute.
     * 
     * @param newXPrimary_Office_Flag
     *     The new value of xPrimary_Office_Flag.
     * @generated
     */
    public void setXPrimary_Office_Flag( String newXPrimary_Office_Flag ) throws Exception {
        metaDataMap.put("XPrimary_Office_Flag", newXPrimary_Office_Flag);

        if (newXPrimary_Office_Flag == null || newXPrimary_Office_Flag.equals("")) {
            newXPrimary_Office_Flag = null;


        }
        eObjxNWPartyAddressExt.setXPrimary_Office_Flag( newXPrimary_Office_Flag );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDeactivation_Flag attribute.
     * 
     * @generated
     */
    public String getXDeactivation_Flag (){
   
        return eObjxNWPartyAddressExt.getXDeactivation_Flag();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDeactivation_Flag attribute.
     * 
     * @param newXDeactivation_Flag
     *     The new value of xDeactivation_Flag.
     * @generated
     */
    public void setXDeactivation_Flag( String newXDeactivation_Flag ) throws Exception {
        metaDataMap.put("XDeactivation_Flag", newXDeactivation_Flag);

        if (newXDeactivation_Flag == null || newXDeactivation_Flag.equals("")) {
            newXDeactivation_Flag = null;


        }
        eObjxNWPartyAddressExt.setXDeactivation_Flag( newXDeactivation_Flag );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPrimary_Billing_Location_Flag attribute.
     * 
     * @generated
     */
    public String getXPrimary_Billing_Location_Flag (){
   
        return eObjxNWPartyAddressExt.getXPrimary_Billing_Location_Flag();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPrimary_Billing_Location_Flag attribute.
     * 
     * @param newXPrimary_Billing_Location_Flag
     *     The new value of xPrimary_Billing_Location_Flag.
     * @generated
     */
    public void setXPrimary_Billing_Location_Flag( String newXPrimary_Billing_Location_Flag ) throws Exception {
        metaDataMap.put("XPrimary_Billing_Location_Flag", newXPrimary_Billing_Location_Flag);

        if (newXPrimary_Billing_Location_Flag == null || newXPrimary_Billing_Location_Flag.equals("")) {
            newXPrimary_Billing_Location_Flag = null;


        }
        eObjxNWPartyAddressExt.setXPrimary_Billing_Location_Flag( newXPrimary_Billing_Location_Flag );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xCredential_Status attribute.
     * 
     * @generated
     */
    public String getXCredential_Status (){
   
        return eObjxNWPartyAddressExt.getXCredential_Status();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xCredential_Status attribute.
     * 
     * @param newXCredential_Status
     *     The new value of xCredential_Status.
     * @generated
     */
    public void setXCredential_Status( String newXCredential_Status ) throws Exception {
        metaDataMap.put("XCredential_Status", newXCredential_Status);

        if (newXCredential_Status == null || newXCredential_Status.equals("")) {
            newXCredential_Status = null;


        }
        eObjxNWPartyAddressExt.setXCredential_Status( newXCredential_Status );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xProvider_Status attribute.
     * 
     * @generated
     */
    public String getXProvider_Status (){
   
        return eObjxNWPartyAddressExt.getXProvider_Status();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xProvider_Status attribute.
     * 
     * @param newXProvider_Status
     *     The new value of xProvider_Status.
     * @generated
     */
    public void setXProvider_Status( String newXProvider_Status ) throws Exception {
        metaDataMap.put("XProvider_Status", newXProvider_Status);

        if (newXProvider_Status == null || newXProvider_Status.equals("")) {
            newXProvider_Status = null;


        }
        eObjxNWPartyAddressExt.setXProvider_Status( newXProvider_Status );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xScheduling_Primary_Flag attribute.
     * 
     * @generated
     */
    public String getXScheduling_Primary_Flag (){
   
        return eObjxNWPartyAddressExt.getXScheduling_Primary_Flag();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xScheduling_Primary_Flag attribute.
     * 
     * @param newXScheduling_Primary_Flag
     *     The new value of xScheduling_Primary_Flag.
     * @generated
     */
    public void setXScheduling_Primary_Flag( String newXScheduling_Primary_Flag ) throws Exception {
        metaDataMap.put("XScheduling_Primary_Flag", newXScheduling_Primary_Flag);

        if (newXScheduling_Primary_Flag == null || newXScheduling_Primary_Flag.equals("")) {
            newXScheduling_Primary_Flag = null;


        }
        eObjxNWPartyAddressExt.setXScheduling_Primary_Flag( newXScheduling_Primary_Flag );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPhone attribute.
     * 
     * @generated
     */
    public String getXPhone (){
   
        return eObjxNWPartyAddressExt.getXPhone();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPhone attribute.
     * 
     * @param newXPhone
     *     The new value of xPhone.
     * @generated
     */
    public void setXPhone( String newXPhone ) throws Exception {
        metaDataMap.put("XPhone", newXPhone);

        if (newXPhone == null || newXPhone.equals("")) {
            newXPhone = null;


        }
        eObjxNWPartyAddressExt.setXPhone( newXPhone );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPhone_Ext attribute.
     * 
     * @generated
     */
    public String getXPhone_Ext (){
   
        return eObjxNWPartyAddressExt.getXPhone_Ext();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPhone_Ext attribute.
     * 
     * @param newXPhone_Ext
     *     The new value of xPhone_Ext.
     * @generated
     */
    public void setXPhone_Ext( String newXPhone_Ext ) throws Exception {
        metaDataMap.put("XPhone_Ext", newXPhone_Ext);

        if (newXPhone_Ext == null || newXPhone_Ext.equals("")) {
            newXPhone_Ext = null;


        }
        eObjxNWPartyAddressExt.setXPhone_Ext( newXPhone_Ext );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xSecondary_Phone attribute.
     * 
     * @generated
     */
    public String getXSecondary_Phone (){
   
        return eObjxNWPartyAddressExt.getXSecondary_Phone();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xSecondary_Phone attribute.
     * 
     * @param newXSecondary_Phone
     *     The new value of xSecondary_Phone.
     * @generated
     */
    public void setXSecondary_Phone( String newXSecondary_Phone ) throws Exception {
        metaDataMap.put("XSecondary_Phone", newXSecondary_Phone);

        if (newXSecondary_Phone == null || newXSecondary_Phone.equals("")) {
            newXSecondary_Phone = null;


        }
        eObjxNWPartyAddressExt.setXSecondary_Phone( newXSecondary_Phone );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xSec_Phone_Ext attribute.
     * 
     * @generated
     */
    public String getXSec_Phone_Ext (){
   
        return eObjxNWPartyAddressExt.getXSec_Phone_Ext();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xSec_Phone_Ext attribute.
     * 
     * @param newXSec_Phone_Ext
     *     The new value of xSec_Phone_Ext.
     * @generated
     */
    public void setXSec_Phone_Ext( String newXSec_Phone_Ext ) throws Exception {
        metaDataMap.put("XSec_Phone_Ext", newXSec_Phone_Ext);

        if (newXSec_Phone_Ext == null || newXSec_Phone_Ext.equals("")) {
            newXSec_Phone_Ext = null;


        }
        eObjxNWPartyAddressExt.setXSec_Phone_Ext( newXSec_Phone_Ext );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFax attribute.
     * 
     * @generated
     */
    public String getXFax (){
   
        return eObjxNWPartyAddressExt.getXFax();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFax attribute.
     * 
     * @param newXFax
     *     The new value of xFax.
     * @generated
     */
    public void setXFax( String newXFax ) throws Exception {
        metaDataMap.put("XFax", newXFax);

        if (newXFax == null || newXFax.equals("")) {
            newXFax = null;


        }
        eObjxNWPartyAddressExt.setXFax( newXFax );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateTxId attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressLastUpdateTxId() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWPartyAddressExt.getLastUpdateTxId());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateUser attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressLastUpdateUser() {
        return eObjxNWPartyAddressExt.getLastUpdateUser();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateDt attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressLastUpdateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPartyAddressExt.getLastUpdateDt());
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
    public void setXNWPartyAddressLastUpdateTxId(String newLastUpdateTxId) {
        metaDataMap.put("XNWPartyAddressLastUpdateTxId", newLastUpdateTxId);

        if ((newLastUpdateTxId == null) || newLastUpdateTxId.equals("")) {
            newLastUpdateTxId = null;
        }
        eObjxNWPartyAddressExt.setLastUpdateTxId(DWLFunctionUtils.getLongFromString(newLastUpdateTxId));
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
    public void setXNWPartyAddressLastUpdateUser(String newLastUpdateUser) {
        metaDataMap.put("XNWPartyAddressLastUpdateUser", newLastUpdateUser);

        if ((newLastUpdateUser == null) || newLastUpdateUser.equals("")) {
            newLastUpdateUser = null;
        }
        eObjxNWPartyAddressExt.setLastUpdateUser(newLastUpdateUser);
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
    public void setXNWPartyAddressLastUpdateDate(String newLastUpdateDt) throws Exception {
        metaDataMap.put("XNWPartyAddressLastUpdateDate", newLastUpdateDt);

        if ((newLastUpdateDt == null) || newLastUpdateDt.equals("")) {
            newLastUpdateDt = null;
        }

        eObjxNWPartyAddressExt.setLastUpdateDt(DWLFunctionUtils.getTimestampFromTimestampString(newLastUpdateDt));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPartyAddressHistActionCode history attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressHistActionCode() {
        return eObjxNWPartyAddressExt.getHistActionCode();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPartyAddressHistActionCode history attribute.
     *
     * @param aXNWPartyAddressHistActionCode
     *     The new value of XNWPartyAddressHistActionCode.
     * @generated
     */
    public void setXNWPartyAddressHistActionCode(String aXNWPartyAddressHistActionCode) {
        metaDataMap.put("XNWPartyAddressHistActionCode", aXNWPartyAddressHistActionCode);

        if ((aXNWPartyAddressHistActionCode == null) || aXNWPartyAddressHistActionCode.equals("")) {
            aXNWPartyAddressHistActionCode = null;
        }
        eObjxNWPartyAddressExt.setHistActionCode(aXNWPartyAddressHistActionCode);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPartyAddressHistCreateDate history attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressHistCreateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPartyAddressExt.getHistCreateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPartyAddressHistCreateDate history attribute.
     *
     * @param aXNWPartyAddressHistCreateDate
     *     The new value of XNWPartyAddressHistCreateDate.
     * @generated
     */
    public void setXNWPartyAddressHistCreateDate(String aXNWPartyAddressHistCreateDate) throws Exception{
        metaDataMap.put("XNWPartyAddressHistCreateDate", aXNWPartyAddressHistCreateDate);

        if ((aXNWPartyAddressHistCreateDate == null) || aXNWPartyAddressHistCreateDate.equals("")) {
            aXNWPartyAddressHistCreateDate = null;
        }

        eObjxNWPartyAddressExt.setHistCreateDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWPartyAddressHistCreateDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPartyAddressHistCreatedBy history attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressHistCreatedBy() {
        return eObjxNWPartyAddressExt.getHistCreatedBy();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPartyAddressHistCreatedBy history attribute.
     *
     * @param aXNWPartyAddressHistCreatedBy
     *     The new value of XNWPartyAddressHistCreatedBy.
     * @generated
     */
    public void setXNWPartyAddressHistCreatedBy(String aXNWPartyAddressHistCreatedBy) {
        metaDataMap.put("XNWPartyAddressHistCreatedBy", aXNWPartyAddressHistCreatedBy);

        if ((aXNWPartyAddressHistCreatedBy == null) || aXNWPartyAddressHistCreatedBy.equals("")) {
            aXNWPartyAddressHistCreatedBy = null;
        }

        eObjxNWPartyAddressExt.setHistCreatedBy(aXNWPartyAddressHistCreatedBy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPartyAddressHistEndDate history attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressHistEndDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWPartyAddressExt.getHistEndDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPartyAddressHistEndDate history attribute.
     *
     * @param aXNWPartyAddressHistEndDate
     *     The new value of XNWPartyAddressHistEndDate.
     * @generated
     */
    public void setXNWPartyAddressHistEndDate(String aXNWPartyAddressHistEndDate) throws Exception{
        metaDataMap.put("XNWPartyAddressHistEndDate", aXNWPartyAddressHistEndDate);

        if ((aXNWPartyAddressHistEndDate == null) || aXNWPartyAddressHistEndDate.equals("")) {
            aXNWPartyAddressHistEndDate = null;
        }
        eObjxNWPartyAddressExt.setHistEndDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWPartyAddressHistEndDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWPartyAddressHistoryIdPK history attribute.
     *
     * @generated
     */
    public String getXNWPartyAddressHistoryIdPK() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWPartyAddressExt.getHistoryIdPK());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWPartyAddressHistoryIdPK history attribute.
     *
     * @param aXNWPartyAddressHistoryIdPK
     *     The new value of XNWPartyAddressHistoryIdPK.
     * @generated
     */
    public void setXNWPartyAddressHistoryIdPK(String aXNWPartyAddressHistoryIdPK) {
        metaDataMap.put("XNWPartyAddressHistoryIdPK", aXNWPartyAddressHistoryIdPK);

        if ((aXNWPartyAddressHistoryIdPK == null) || aXNWPartyAddressHistoryIdPK.equals("")) {
            aXNWPartyAddressHistoryIdPK = null;
        }
        eObjxNWPartyAddressExt.setHistoryIdPK(DWLFunctionUtils.getLongFromString(aXNWPartyAddressHistoryIdPK));
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
		err.setComponentType(new Long(MDMNWComponentID.XNWPARTY_ADDRESS_BOBJ_EXT).longValue());
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
                 Iterator<EObjxNWPartyAddressExt> eObj = null;
                 String asOfDate = (String) this.getControl().get(
                         DWLControl.INQUIRE_AS_OF_DATE);
                 Timestamp tsAsOfDate = null;
                 
                 if ((asOfDate != null) && !asOfDate.equalsIgnoreCase("")) {
                     tsAsOfDate = DWLDateTimeUtilities.setPITHistoryDate(asOfDate, this.getControl());
 
                	 XNWPartyAddressExtInquiryData theInquiryData = (XNWPartyAddressExtInquiryData)DataAccessFactory.getQuery(XNWPartyAddressExtInquiryData.class, connection);
                	 
                	 Object[] parameters = new Object[3];
                     parameters[0] = (Long) getEObjAddressGroup().getPrimaryKey();
                     parameters[1] = tsAsOfDate;
                     parameters[2] = tsAsOfDate;
                     
                	 eObj = theInquiryData.getxNWPartyAddressHistory(parameters);
                 } else {
                	 EObjxNWPartyAddressExtData  theEObjData = (EObjxNWPartyAddressExtData) DataAccessFactory
                     .getQuery(EObjxNWPartyAddressExtData.class, connection);
                	 
                	 eObj = theEObjData.getEObjxNWPartyAddressExt((Long)getEObjAddressGroup().getPrimaryKey());
                 }
                 
                 if(eObj.hasNext()) {
         			this.setEObjxNWPartyAddressExt((EObjxNWPartyAddressExt)eObj.next());
         			
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
            DWLError error = errHandler.getErrorMessage(MDMNWComponentID.XNWPARTY_ADDRESS_BOBJ_EXT,
                                                                 TCRMErrorCode.READ_RECORD_ERROR,
                                                                 MDMNWErrorReasonCode.READ_EXTENSION_XNWPARTYADDRESS_FAILED,
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

