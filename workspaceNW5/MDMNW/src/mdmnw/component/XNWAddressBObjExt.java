
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
 * IBM-MDMWB-1.0-[bc4ed7818f4b977a8bb394567ae6a6a8]
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

import com.dwl.tcrm.coreParty.component.TCRMAddressBObj;

import com.dwl.tcrm.utilities.DateFormatter;
import com.dwl.tcrm.utilities.DateValidator;
import java.sql.Timestamp;
import java.util.Iterator;
import mdmnw.constant.MDMNWComponentID;
import mdmnw.constant.MDMNWErrorReasonCode;

import mdmnw.entityObject.EObjxNWAddressExt;
import mdmnw.entityObject.EObjxNWAddressExtData;
import mdmnw.entityObject.XNWAddressExtInquiryData;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * This class provides the implementation of the business object
 * <code>XNWAddressBObjExt</code>.
 * 
 * This address extension is for the unique addresses that MDM will hold,
 * regardless of the usage type. For Address data instances by usage type, see
 * TCRMPartyAddressBObj / xNWPartyAddressBObj objects types.
 * 
 * @see com.dwl.tcrm.common.TCRMCommon
 * @generated
 */
 

@SuppressWarnings("serial")
public class XNWAddressBObjExt extends TCRMAddressBObj implements IExtension {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected EObjxNWAddressExt eObjxNWAddressExt;
	/**
    * <!-- begin-user-doc -->
	  * <!-- end-user-doc -->
    * @generated 
    */
	 private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(XNWAddressBObjExt.class);
		
 


    protected boolean isValidXActivation_Date = true;
  protected boolean isValidXDeactivation_Date = true;
    protected boolean isValidXTax_ID_Number_LastVerifiedDate = true;
  protected boolean isValidXNewport_Key_LastVerifiedDate = true;




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */     
    public XNWAddressBObjExt() {
        super();
        init();
        eObjxNWAddressExt = new EObjxNWAddressExt(getEObjAddress());
        setComponentID(MDMNWComponentID.XNWADDRESS_BOBJ_EXT);
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
        metaDataMap.put("XCounty", null);
        metaDataMap.put("XHospital", null);
        metaDataMap.put("XFacility_Name", null);
        metaDataMap.put("XFacility_Code", null);
        metaDataMap.put("XDepartment_Code", null);
        metaDataMap.put("XDepartment_Description", null);
        metaDataMap.put("XLocation_Code", null);
        metaDataMap.put("XLocation_Description", null);
        metaDataMap.put("XLocation_Mnemonic", null);
        metaDataMap.put("XLocation_ID", null);
        metaDataMap.put("XLocation_Name", null);
        metaDataMap.put("XPhone", null);
        metaDataMap.put("XPhone_Ext", null);
        metaDataMap.put("XSecondary_Phone", null);
        metaDataMap.put("XSec_Phone_Ext", null);
        metaDataMap.put("XFax", null);
        metaDataMap.put("XTax_ID_Number", null);
        metaDataMap.put("XNewport_Key", null);
        metaDataMap.put("XDeactivation_Flag", null);
        metaDataMap.put("XActivation_Date", null);
        metaDataMap.put("XDeactivation_Date", null);
        metaDataMap.put("XTax_ID_Number_Source", null);
        metaDataMap.put("XTax_ID_Number_LastVerifiedDate", null);
        metaDataMap.put("XNewport_Key_Source", null);
        metaDataMap.put("XNewport_Key_LastVerifiedDate", null);
        metaDataMap.put("XNWAddressHistActionCode", null);
        metaDataMap.put("XNWAddressHistCreateDate", null);
        metaDataMap.put("XNWAddressHistCreatedBy", null);
        metaDataMap.put("XNWAddressHistEndDate", null);
        metaDataMap.put("XNWAddressHistoryIdPK", null);
        metaDataMap.put("XNWAddressLastUpdateDate", null);
        metaDataMap.put("XNWAddressLastUpdateTxId", null);
        metaDataMap.put("XNWAddressLastUpdateUser", null);
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
            metaDataMap.put("XCounty", getXCounty());
            metaDataMap.put("XHospital", getXHospital());
            metaDataMap.put("XFacility_Name", getXFacility_Name());
            metaDataMap.put("XFacility_Code", getXFacility_Code());
            metaDataMap.put("XDepartment_Code", getXDepartment_Code());
            metaDataMap.put("XDepartment_Description", getXDepartment_Description());
            metaDataMap.put("XLocation_Code", getXLocation_Code());
            metaDataMap.put("XLocation_Description", getXLocation_Description());
            metaDataMap.put("XLocation_Mnemonic", getXLocation_Mnemonic());
            metaDataMap.put("XLocation_ID", getXLocation_ID());
            metaDataMap.put("XLocation_Name", getXLocation_Name());
            metaDataMap.put("XPhone", getXPhone());
            metaDataMap.put("XPhone_Ext", getXPhone_Ext());
            metaDataMap.put("XSecondary_Phone", getXSecondary_Phone());
            metaDataMap.put("XSec_Phone_Ext", getXSec_Phone_Ext());
            metaDataMap.put("XFax", getXFax());
            metaDataMap.put("XTax_ID_Number", getXTax_ID_Number());
            metaDataMap.put("XNewport_Key", getXNewport_Key());
            metaDataMap.put("XDeactivation_Flag", getXDeactivation_Flag());
            metaDataMap.put("XActivation_Date", getXActivation_Date());
            metaDataMap.put("XDeactivation_Date", getXDeactivation_Date());
            metaDataMap.put("XTax_ID_Number_Source", getXTax_ID_Number_Source());
            metaDataMap.put("XTax_ID_Number_LastVerifiedDate", getXTax_ID_Number_LastVerifiedDate());
            metaDataMap.put("XNewport_Key_Source", getXNewport_Key_Source());
            metaDataMap.put("XNewport_Key_LastVerifiedDate", getXNewport_Key_LastVerifiedDate());
            metaDataMap.put("XNWAddressHistActionCode", getXNWAddressHistActionCode());
            metaDataMap.put("XNWAddressHistCreateDate", getXNWAddressHistCreateDate());
            metaDataMap.put("XNWAddressHistCreatedBy", getXNWAddressHistCreatedBy());
            metaDataMap.put("XNWAddressHistEndDate", getXNWAddressHistEndDate());
            metaDataMap.put("XNWAddressHistoryIdPK", getXNWAddressHistoryIdPK());
            metaDataMap.put("XNWAddressLastUpdateDate", getXNWAddressLastUpdateDate());
            metaDataMap.put("XNWAddressLastUpdateTxId", getXNWAddressLastUpdateTxId());
            metaDataMap.put("XNWAddressLastUpdateUser", getXNWAddressLastUpdateUser());
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

        if (eObjxNWAddressExt != null) {
            eObjxNWAddressExt.setControl(newDWLControl);
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
    public EObjxNWAddressExt getEObjxNWAddressExt() {
        bRequireMapRefresh = true;
        return eObjxNWAddressExt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the entity object associated with this business object.
     *
     * @param eObjxNWAddressExt
     *            The eObjxNWAddressExt to set.
     * @generated
     */
    public void setEObjxNWAddressExt(EObjxNWAddressExt eObjxNWAddressExt) {
        bRequireMapRefresh = true;
        this.eObjxNWAddressExt = eObjxNWAddressExt;
        this.eObjxNWAddressExt.setBaseEntity(getEObjAddress());
        if (this.eObjxNWAddressExt != null && this.eObjxNWAddressExt.getControl() == null) {
            DWLControl control = this.getControl();
            if (control != null) {
                this.eObjxNWAddressExt.setControl(control);
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xCounty attribute.
     * 
     * @generated
     */
    public String getXCounty (){
   
        return eObjxNWAddressExt.getXCounty();
    }
    

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xCounty attribute.
     * 
     * @param newXCounty
     *     The new value of xCounty.
     * @generated
     */
    public void setXCounty( String newXCounty ) throws Exception {
        metaDataMap.put("XCounty", newXCounty);

        if (newXCounty == null || newXCounty.equals("")) {
            newXCounty = null;


        }
        eObjxNWAddressExt.setXCounty( newXCounty );
     }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xHospital attribute.
     * 
     * @generated
     */
    public String getXHospital (){
   
        return eObjxNWAddressExt.getXHospital();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xHospital attribute.
     * 
     * @param newXHospital
     *     The new value of xHospital.
     * @generated
     */
    public void setXHospital( String newXHospital ) throws Exception {
        metaDataMap.put("XHospital", newXHospital);

        if (newXHospital == null || newXHospital.equals("")) {
            newXHospital = null;


        }
        eObjxNWAddressExt.setXHospital( newXHospital );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFacility_Name attribute.
     * 
     * @generated
     */
    public String getXFacility_Name (){
   
        return eObjxNWAddressExt.getXFacility_Name();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFacility_Name attribute.
     * 
     * @param newXFacility_Name
     *     The new value of xFacility_Name.
     * @generated
     */
    public void setXFacility_Name( String newXFacility_Name ) throws Exception {
        metaDataMap.put("XFacility_Name", newXFacility_Name);

        if (newXFacility_Name == null || newXFacility_Name.equals("")) {
            newXFacility_Name = null;


        }
        eObjxNWAddressExt.setXFacility_Name( newXFacility_Name );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFacility_Code attribute.
     * 
     * @generated
     */
    public String getXFacility_Code (){
   
        return eObjxNWAddressExt.getXFacility_Code();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFacility_Code attribute.
     * 
     * @param newXFacility_Code
     *     The new value of xFacility_Code.
     * @generated
     */
    public void setXFacility_Code( String newXFacility_Code ) throws Exception {
        metaDataMap.put("XFacility_Code", newXFacility_Code);

        if (newXFacility_Code == null || newXFacility_Code.equals("")) {
            newXFacility_Code = null;


        }
        eObjxNWAddressExt.setXFacility_Code( newXFacility_Code );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_Code attribute.
     * 
     * @generated
     */
    public String getXDepartment_Code (){
   
        return eObjxNWAddressExt.getXDepartment_Code();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_Code attribute.
     * 
     * @param newXDepartment_Code
     *     The new value of xDepartment_Code.
     * @generated
     */
    public void setXDepartment_Code( String newXDepartment_Code ) throws Exception {
        metaDataMap.put("XDepartment_Code", newXDepartment_Code);

        if (newXDepartment_Code == null || newXDepartment_Code.equals("")) {
            newXDepartment_Code = null;


        }
        eObjxNWAddressExt.setXDepartment_Code( newXDepartment_Code );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_Description attribute.
     * 
     * @generated
     */
    public String getXDepartment_Description (){
   
        return eObjxNWAddressExt.getXDepartment_Description();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_Description attribute.
     * 
     * @param newXDepartment_Description
     *     The new value of xDepartment_Description.
     * @generated
     */
    public void setXDepartment_Description( String newXDepartment_Description ) throws Exception {
        metaDataMap.put("XDepartment_Description", newXDepartment_Description);

        if (newXDepartment_Description == null || newXDepartment_Description.equals("")) {
            newXDepartment_Description = null;


        }
        eObjxNWAddressExt.setXDepartment_Description( newXDepartment_Description );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Code attribute.
     * 
     * @generated
     */
    public String getXLocation_Code (){
   
        return eObjxNWAddressExt.getXLocation_Code();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Code attribute.
     * 
     * @param newXLocation_Code
     *     The new value of xLocation_Code.
     * @generated
     */
    public void setXLocation_Code( String newXLocation_Code ) throws Exception {
        metaDataMap.put("XLocation_Code", newXLocation_Code);

        if (newXLocation_Code == null || newXLocation_Code.equals("")) {
            newXLocation_Code = null;


        }
        eObjxNWAddressExt.setXLocation_Code( newXLocation_Code );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Description attribute.
     * 
     * @generated
     */
    public String getXLocation_Description (){
   
        return eObjxNWAddressExt.getXLocation_Description();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Description attribute.
     * 
     * @param newXLocation_Description
     *     The new value of xLocation_Description.
     * @generated
     */
    public void setXLocation_Description( String newXLocation_Description ) throws Exception {
        metaDataMap.put("XLocation_Description", newXLocation_Description);

        if (newXLocation_Description == null || newXLocation_Description.equals("")) {
            newXLocation_Description = null;


        }
        eObjxNWAddressExt.setXLocation_Description( newXLocation_Description );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Mnemonic attribute.
     * 
     * @generated
     */
    public String getXLocation_Mnemonic (){
   
        return eObjxNWAddressExt.getXLocation_Mnemonic();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Mnemonic attribute.
     * 
     * @param newXLocation_Mnemonic
     *     The new value of xLocation_Mnemonic.
     * @generated
     */
    public void setXLocation_Mnemonic( String newXLocation_Mnemonic ) throws Exception {
        metaDataMap.put("XLocation_Mnemonic", newXLocation_Mnemonic);

        if (newXLocation_Mnemonic == null || newXLocation_Mnemonic.equals("")) {
            newXLocation_Mnemonic = null;


        }
        eObjxNWAddressExt.setXLocation_Mnemonic( newXLocation_Mnemonic );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_ID attribute.
     * 
     * @generated
     */
    public String getXLocation_ID (){
   
        return eObjxNWAddressExt.getXLocation_ID();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_ID attribute.
     * 
     * @param newXLocation_ID
     *     The new value of xLocation_ID.
     * @generated
     */
    public void setXLocation_ID( String newXLocation_ID ) throws Exception {
        metaDataMap.put("XLocation_ID", newXLocation_ID);

        if (newXLocation_ID == null || newXLocation_ID.equals("")) {
            newXLocation_ID = null;


        }
        eObjxNWAddressExt.setXLocation_ID( newXLocation_ID );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Name attribute.
     * 
     * @generated
     */
    public String getXLocation_Name (){
   
        return eObjxNWAddressExt.getXLocation_Name();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Name attribute.
     * 
     * @param newXLocation_Name
     *     The new value of xLocation_Name.
     * @generated
     */
    public void setXLocation_Name( String newXLocation_Name ) throws Exception {
        metaDataMap.put("XLocation_Name", newXLocation_Name);

        if (newXLocation_Name == null || newXLocation_Name.equals("")) {
            newXLocation_Name = null;


        }
        eObjxNWAddressExt.setXLocation_Name( newXLocation_Name );
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
   
        return eObjxNWAddressExt.getXPhone();
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
        eObjxNWAddressExt.setXPhone( newXPhone );
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
   
        return eObjxNWAddressExt.getXPhone_Ext();
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
        eObjxNWAddressExt.setXPhone_Ext( newXPhone_Ext );
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
   
        return eObjxNWAddressExt.getXSecondary_Phone();
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
        eObjxNWAddressExt.setXSecondary_Phone( newXSecondary_Phone );
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
   
        return eObjxNWAddressExt.getXSec_Phone_Ext();
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
        eObjxNWAddressExt.setXSec_Phone_Ext( newXSec_Phone_Ext );
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
   
        return eObjxNWAddressExt.getXFax();
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
        eObjxNWAddressExt.setXFax( newXFax );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTax_ID_Number attribute.
     * 
     * @generated
     */
    public String getXTax_ID_Number (){
   
        return eObjxNWAddressExt.getXTax_ID_Number();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTax_ID_Number attribute.
     * 
     * @param newXTax_ID_Number
     *     The new value of xTax_ID_Number.
     * @generated
     */
    public void setXTax_ID_Number( String newXTax_ID_Number ) throws Exception {
        metaDataMap.put("XTax_ID_Number", newXTax_ID_Number);

        if (newXTax_ID_Number == null || newXTax_ID_Number.equals("")) {
            newXTax_ID_Number = null;


        }
        eObjxNWAddressExt.setXTax_ID_Number( newXTax_ID_Number );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xNewport_Key attribute.
     * 
     * @generated
     */
    public String getXNewport_Key (){
   
        return eObjxNWAddressExt.getXNewport_Key();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xNewport_Key attribute.
     * 
     * @param newXNewport_Key
     *     The new value of xNewport_Key.
     * @generated
     */
    public void setXNewport_Key( String newXNewport_Key ) throws Exception {
        metaDataMap.put("XNewport_Key", newXNewport_Key);

        if (newXNewport_Key == null || newXNewport_Key.equals("")) {
            newXNewport_Key = null;


        }
        eObjxNWAddressExt.setXNewport_Key( newXNewport_Key );
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
   
        return eObjxNWAddressExt.getXDeactivation_Flag();
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
        eObjxNWAddressExt.setXDeactivation_Flag( newXDeactivation_Flag );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xActivation_Date attribute.
     * 
     * @generated
     */
    public String getXActivation_Date (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getXActivation_Date());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xActivation_Date attribute.
     * 
     * @param newXActivation_Date
     *     The new value of xActivation_Date.
     * @generated
     */
    public void setXActivation_Date( String newXActivation_Date ) throws Exception {
        metaDataMap.put("XActivation_Date", newXActivation_Date);
       	isValidXActivation_Date = true;

        if (newXActivation_Date == null || newXActivation_Date.equals("")) {
            newXActivation_Date = null;
            eObjxNWAddressExt.setXActivation_Date(null);


        }
    else {
        	if (DateValidator.validates(newXActivation_Date)) {
           		eObjxNWAddressExt.setXActivation_Date(DateFormatter.getStartDateTimestamp(newXActivation_Date));
            	metaDataMap.put("XActivation_Date", getXActivation_Date());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XActivation_Date") != null) {
                    	metaDataMap.put("XActivation_Date", "");
                	}
                	isValidXActivation_Date = false;
                	eObjxNWAddressExt.setXActivation_Date(null);
            	}
        	}
        }
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDeactivation_Date attribute.
     * 
     * @generated
     */
    public String getXDeactivation_Date (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getXDeactivation_Date());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDeactivation_Date attribute.
     * 
     * @param newXDeactivation_Date
     *     The new value of xDeactivation_Date.
     * @generated
     */
    public void setXDeactivation_Date( String newXDeactivation_Date ) throws Exception {
        metaDataMap.put("XDeactivation_Date", newXDeactivation_Date);
       	isValidXDeactivation_Date = true;

        if (newXDeactivation_Date == null || newXDeactivation_Date.equals("")) {
            newXDeactivation_Date = null;
            eObjxNWAddressExt.setXDeactivation_Date(null);


        }
    else {
        	if (DateValidator.validates(newXDeactivation_Date)) {
           		eObjxNWAddressExt.setXDeactivation_Date(DateFormatter.getStartDateTimestamp(newXDeactivation_Date));
            	metaDataMap.put("XDeactivation_Date", getXDeactivation_Date());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XDeactivation_Date") != null) {
                    	metaDataMap.put("XDeactivation_Date", "");
                	}
                	isValidXDeactivation_Date = false;
                	eObjxNWAddressExt.setXDeactivation_Date(null);
            	}
        	}
        }
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTax_ID_Number_Source attribute.
     * 
     * @generated
     */
    public String getXTax_ID_Number_Source (){
   
        return eObjxNWAddressExt.getXTax_ID_Number_Source();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTax_ID_Number_Source attribute.
     * 
     * @param newXTax_ID_Number_Source
     *     The new value of xTax_ID_Number_Source.
     * @generated
     */
    public void setXTax_ID_Number_Source( String newXTax_ID_Number_Source ) throws Exception {
        metaDataMap.put("XTax_ID_Number_Source", newXTax_ID_Number_Source);

        if (newXTax_ID_Number_Source == null || newXTax_ID_Number_Source.equals("")) {
            newXTax_ID_Number_Source = null;


        }
        eObjxNWAddressExt.setXTax_ID_Number_Source( newXTax_ID_Number_Source );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTax_ID_Number_LastVerifiedDate attribute.
     * 
     * @generated
     */
    public String getXTax_ID_Number_LastVerifiedDate (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getXTax_ID_Number_LastVerifiedDate());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTax_ID_Number_LastVerifiedDate attribute.
     * 
     * @param newXTax_ID_Number_LastVerifiedDate
     *     The new value of xTax_ID_Number_LastVerifiedDate.
     * @generated
     */
    public void setXTax_ID_Number_LastVerifiedDate( String newXTax_ID_Number_LastVerifiedDate ) throws Exception {
        metaDataMap.put("XTax_ID_Number_LastVerifiedDate", newXTax_ID_Number_LastVerifiedDate);
       	isValidXTax_ID_Number_LastVerifiedDate = true;

        if (newXTax_ID_Number_LastVerifiedDate == null || newXTax_ID_Number_LastVerifiedDate.equals("")) {
            newXTax_ID_Number_LastVerifiedDate = null;
            eObjxNWAddressExt.setXTax_ID_Number_LastVerifiedDate(null);


        }
    else {
        	if (DateValidator.validates(newXTax_ID_Number_LastVerifiedDate)) {
           		eObjxNWAddressExt.setXTax_ID_Number_LastVerifiedDate(DateFormatter.getStartDateTimestamp(newXTax_ID_Number_LastVerifiedDate));
            	metaDataMap.put("XTax_ID_Number_LastVerifiedDate", getXTax_ID_Number_LastVerifiedDate());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XTax_ID_Number_LastVerifiedDate") != null) {
                    	metaDataMap.put("XTax_ID_Number_LastVerifiedDate", "");
                	}
                	isValidXTax_ID_Number_LastVerifiedDate = false;
                	eObjxNWAddressExt.setXTax_ID_Number_LastVerifiedDate(null);
            	}
        	}
        }
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xNewport_Key_Source attribute.
     * 
     * @generated
     */
    public String getXNewport_Key_Source (){
   
        return eObjxNWAddressExt.getXNewport_Key_Source();
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xNewport_Key_Source attribute.
     * 
     * @param newXNewport_Key_Source
     *     The new value of xNewport_Key_Source.
     * @generated
     */
    public void setXNewport_Key_Source( String newXNewport_Key_Source ) throws Exception {
        metaDataMap.put("XNewport_Key_Source", newXNewport_Key_Source);

        if (newXNewport_Key_Source == null || newXNewport_Key_Source.equals("")) {
            newXNewport_Key_Source = null;


        }
        eObjxNWAddressExt.setXNewport_Key_Source( newXNewport_Key_Source );
     }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xNewport_Key_LastVerifiedDate attribute.
     * 
     * @generated
     */
    public String getXNewport_Key_LastVerifiedDate (){
   
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getXNewport_Key_LastVerifiedDate());
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xNewport_Key_LastVerifiedDate attribute.
     * 
     * @param newXNewport_Key_LastVerifiedDate
     *     The new value of xNewport_Key_LastVerifiedDate.
     * @generated
     */
    public void setXNewport_Key_LastVerifiedDate( String newXNewport_Key_LastVerifiedDate ) throws Exception {
        metaDataMap.put("XNewport_Key_LastVerifiedDate", newXNewport_Key_LastVerifiedDate);
       	isValidXNewport_Key_LastVerifiedDate = true;

        if (newXNewport_Key_LastVerifiedDate == null || newXNewport_Key_LastVerifiedDate.equals("")) {
            newXNewport_Key_LastVerifiedDate = null;
            eObjxNWAddressExt.setXNewport_Key_LastVerifiedDate(null);


        }
    else {
        	if (DateValidator.validates(newXNewport_Key_LastVerifiedDate)) {
           		eObjxNWAddressExt.setXNewport_Key_LastVerifiedDate(DateFormatter.getStartDateTimestamp(newXNewport_Key_LastVerifiedDate));
            	metaDataMap.put("XNewport_Key_LastVerifiedDate", getXNewport_Key_LastVerifiedDate());
        	} else {
            	if (Configuration.getConfiguration().getConfigItem(
              "/IBM/DWLCommonServices/InternalValidation/enabled").getBooleanValue()) {
                	if (metaDataMap.get("XNewport_Key_LastVerifiedDate") != null) {
                    	metaDataMap.put("XNewport_Key_LastVerifiedDate", "");
                	}
                	isValidXNewport_Key_LastVerifiedDate = false;
                	eObjxNWAddressExt.setXNewport_Key_LastVerifiedDate(null);
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
    public String getXNWAddressLastUpdateTxId() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWAddressExt.getLastUpdateTxId());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateUser attribute.
     *
     * @generated
     */
    public String getXNWAddressLastUpdateUser() {
        return eObjxNWAddressExt.getLastUpdateUser();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the LastUpdateDt attribute.
     *
     * @generated
     */
    public String getXNWAddressLastUpdateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getLastUpdateDt());
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
    public void setXNWAddressLastUpdateTxId(String newLastUpdateTxId) {
        metaDataMap.put("XNWAddressLastUpdateTxId", newLastUpdateTxId);

        if ((newLastUpdateTxId == null) || newLastUpdateTxId.equals("")) {
            newLastUpdateTxId = null;
        }
        eObjxNWAddressExt.setLastUpdateTxId(DWLFunctionUtils.getLongFromString(newLastUpdateTxId));
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
    public void setXNWAddressLastUpdateUser(String newLastUpdateUser) {
        metaDataMap.put("XNWAddressLastUpdateUser", newLastUpdateUser);

        if ((newLastUpdateUser == null) || newLastUpdateUser.equals("")) {
            newLastUpdateUser = null;
        }
        eObjxNWAddressExt.setLastUpdateUser(newLastUpdateUser);
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
    public void setXNWAddressLastUpdateDate(String newLastUpdateDt) throws Exception {
        metaDataMap.put("XNWAddressLastUpdateDate", newLastUpdateDt);

        if ((newLastUpdateDt == null) || newLastUpdateDt.equals("")) {
            newLastUpdateDt = null;
        }

        eObjxNWAddressExt.setLastUpdateDt(DWLFunctionUtils.getTimestampFromTimestampString(newLastUpdateDt));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWAddressHistActionCode history attribute.
     *
     * @generated
     */
    public String getXNWAddressHistActionCode() {
        return eObjxNWAddressExt.getHistActionCode();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWAddressHistActionCode history attribute.
     *
     * @param aXNWAddressHistActionCode
     *     The new value of XNWAddressHistActionCode.
     * @generated
     */
    public void setXNWAddressHistActionCode(String aXNWAddressHistActionCode) {
        metaDataMap.put("XNWAddressHistActionCode", aXNWAddressHistActionCode);

        if ((aXNWAddressHistActionCode == null) || aXNWAddressHistActionCode.equals("")) {
            aXNWAddressHistActionCode = null;
        }
        eObjxNWAddressExt.setHistActionCode(aXNWAddressHistActionCode);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWAddressHistCreateDate history attribute.
     *
     * @generated
     */
    public String getXNWAddressHistCreateDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getHistCreateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWAddressHistCreateDate history attribute.
     *
     * @param aXNWAddressHistCreateDate
     *     The new value of XNWAddressHistCreateDate.
     * @generated
     */
    public void setXNWAddressHistCreateDate(String aXNWAddressHistCreateDate) throws Exception{
        metaDataMap.put("XNWAddressHistCreateDate", aXNWAddressHistCreateDate);

        if ((aXNWAddressHistCreateDate == null) || aXNWAddressHistCreateDate.equals("")) {
            aXNWAddressHistCreateDate = null;
        }

        eObjxNWAddressExt.setHistCreateDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWAddressHistCreateDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWAddressHistCreatedBy history attribute.
     *
     * @generated
     */
    public String getXNWAddressHistCreatedBy() {
        return eObjxNWAddressExt.getHistCreatedBy();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWAddressHistCreatedBy history attribute.
     *
     * @param aXNWAddressHistCreatedBy
     *     The new value of XNWAddressHistCreatedBy.
     * @generated
     */
    public void setXNWAddressHistCreatedBy(String aXNWAddressHistCreatedBy) {
        metaDataMap.put("XNWAddressHistCreatedBy", aXNWAddressHistCreatedBy);

        if ((aXNWAddressHistCreatedBy == null) || aXNWAddressHistCreatedBy.equals("")) {
            aXNWAddressHistCreatedBy = null;
        }

        eObjxNWAddressExt.setHistCreatedBy(aXNWAddressHistCreatedBy);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWAddressHistEndDate history attribute.
     *
     * @generated
     */
    public String getXNWAddressHistEndDate() {
        return DWLFunctionUtils.getStringFromTimestamp(eObjxNWAddressExt.getHistEndDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWAddressHistEndDate history attribute.
     *
     * @param aXNWAddressHistEndDate
     *     The new value of XNWAddressHistEndDate.
     * @generated
     */
    public void setXNWAddressHistEndDate(String aXNWAddressHistEndDate) throws Exception{
        metaDataMap.put("XNWAddressHistEndDate", aXNWAddressHistEndDate);

        if ((aXNWAddressHistEndDate == null) || aXNWAddressHistEndDate.equals("")) {
            aXNWAddressHistEndDate = null;
        }
        eObjxNWAddressExt.setHistEndDt(DWLFunctionUtils.getTimestampFromTimestampString(aXNWAddressHistEndDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the XNWAddressHistoryIdPK history attribute.
     *
     * @generated
     */
    public String getXNWAddressHistoryIdPK() {
        return DWLFunctionUtils.getStringFromLong(eObjxNWAddressExt.getHistoryIdPK());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the XNWAddressHistoryIdPK history attribute.
     *
     * @param aXNWAddressHistoryIdPK
     *     The new value of XNWAddressHistoryIdPK.
     * @generated
     */
    public void setXNWAddressHistoryIdPK(String aXNWAddressHistoryIdPK) {
        metaDataMap.put("XNWAddressHistoryIdPK", aXNWAddressHistoryIdPK);

        if ((aXNWAddressHistoryIdPK == null) || aXNWAddressHistoryIdPK.equals("")) {
            aXNWAddressHistoryIdPK = null;
        }
        eObjxNWAddressExt.setHistoryIdPK(DWLFunctionUtils.getLongFromString(aXNWAddressHistoryIdPK));
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
    		controllerValidation_XActivation_Date(status);
    		controllerValidation_XDeactivation_Date(status);
    		controllerValidation_XTax_ID_Number_LastVerifiedDate(status);
    		controllerValidation_XNewport_Key_LastVerifiedDate(status);
    	}

        if (level == ITCRMValidation.COMPONENT_LEVEL_VALIDATION){
            // MDM_TODO0: CDKWB0035I Add any common component-level custom validation logic
            // to be executed for this object during either "add" or "update"
            // transactions
    		componentValidation_XActivation_Date(status);
    		componentValidation_XDeactivation_Date(status);
    		componentValidation_XTax_ID_Number_LastVerifiedDate(status);
    		componentValidation_XNewport_Key_LastVerifiedDate(status);
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
     * Perform component-level custom validation logic for attribute "XActivation_Date"
     *
     * @generated
     */
  private void componentValidation_XActivation_Date(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XDeactivation_Date"
     *
     * @generated
     */
  private void componentValidation_XDeactivation_Date(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XTax_ID_Number_LastVerifiedDate"
     *
     * @generated
     */
  private void componentValidation_XTax_ID_Number_LastVerifiedDate(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform component-level custom validation logic for attribute "XNewport_Key_LastVerifiedDate"
     *
     * @generated
     */
  private void componentValidation_XNewport_Key_LastVerifiedDate(DWLStatus status) {
  
  }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XActivation_Date"
     *
     * @generated
     */
  private void controllerValidation_XActivation_Date(DWLStatus status) throws Exception {
  
            boolean isXActivation_DateNull = (eObjxNWAddressExt.getXActivation_Date() == null);
            if (!isValidXActivation_Date) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWADDRESS_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWADDRESS_XACTIVATION_DATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xActivation_Date in entity xNWAddress, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XActivation_Date " + infoForLogging);
               	status.addError(err);
            } 
    	}


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XDeactivation_Date"
     *
     * @generated
     */
  private void controllerValidation_XDeactivation_Date(DWLStatus status) throws Exception {
  
            boolean isXDeactivation_DateNull = (eObjxNWAddressExt.getXDeactivation_Date() == null);
            if (!isValidXDeactivation_Date) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWADDRESS_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWADDRESS_XDEACTIVATION_DATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xDeactivation_Date in entity xNWAddress, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XDeactivation_Date " + infoForLogging);
               	status.addError(err);
            } 
    	}


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XTax_ID_Number_LastVerifiedDate"
     *
     * @generated
     */
  private void controllerValidation_XTax_ID_Number_LastVerifiedDate(DWLStatus status) throws Exception {
  
            boolean isXTax_ID_Number_LastVerifiedDateNull = (eObjxNWAddressExt.getXTax_ID_Number_LastVerifiedDate() == null);
            if (!isValidXTax_ID_Number_LastVerifiedDate) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWADDRESS_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWADDRESS_XTAX_ID_NUMBER_LASTVERIFIEDDATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xTax_ID_Number_LastVerifiedDate in entity xNWAddress, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XTax_ID_Number_LastVerifiedDate " + infoForLogging);
               	status.addError(err);
            } 
    	}


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Perform controller-level custom validation logic for attribute "XNewport_Key_LastVerifiedDate"
     *
     * @generated
     */
  private void controllerValidation_XNewport_Key_LastVerifiedDate(DWLStatus status) throws Exception {
  
            boolean isXNewport_Key_LastVerifiedDateNull = (eObjxNWAddressExt.getXNewport_Key_LastVerifiedDate() == null);
            if (!isValidXNewport_Key_LastVerifiedDate) {
              	DWLError err = new DWLError();
               	err.setComponentType(new Long(MDMNWComponentID.XNWADDRESS_BOBJ_EXT).longValue());
               	err.setReasonCode(new Long(MDMNWErrorReasonCode.INVALID_XNWADDRESS_XNEWPORT_KEY_LASTVERIFIEDDATE).longValue());
               	err.setErrorType(DWLErrorCode.DATA_INVALID_ERROR);
                String infoForLogging="Error: Validation error. Invalid time specified on property xNewport_Key_LastVerifiedDate in entity xNWAddress, component type " +err.getComponentType() + " ReasonCode " +err.getReasonCode();
      logger.finest("controllerValidation_XNewport_Key_LastVerifiedDate " + infoForLogging);
               	status.addError(err);
            } 
    	}


    private DWLError createDWLError(String entityName, String propertyName,String reasonCode){	
		DWLError err = new DWLError();
		err.setComponentType(new Long(MDMNWComponentID.XNWADDRESS_BOBJ_EXT).longValue());
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
                 Iterator<EObjxNWAddressExt> eObj = null;
                 String asOfDate = (String) this.getControl().get(
                         DWLControl.INQUIRE_AS_OF_DATE);
                 Timestamp tsAsOfDate = null;
                 
                 if ((asOfDate != null) && !asOfDate.equalsIgnoreCase("")) {
                     tsAsOfDate = DWLDateTimeUtilities.setPITHistoryDate(asOfDate, this.getControl());
 
                	 XNWAddressExtInquiryData theInquiryData = (XNWAddressExtInquiryData)DataAccessFactory.getQuery(XNWAddressExtInquiryData.class, connection);
                	 
                	 Object[] parameters = new Object[3];
                     parameters[0] = (Long) getEObjAddress().getPrimaryKey();
                     parameters[1] = tsAsOfDate;
                     parameters[2] = tsAsOfDate;
                     
                	 eObj = theInquiryData.getxNWAddressHistory(parameters);
                 } else {
                	 EObjxNWAddressExtData  theEObjData = (EObjxNWAddressExtData) DataAccessFactory
                     .getQuery(EObjxNWAddressExtData.class, connection);
                	 
                	 eObj = theEObjData.getEObjxNWAddressExt((Long)getEObjAddress().getPrimaryKey());
                 }
                 
                 if(eObj.hasNext()) {
         			this.setEObjxNWAddressExt((EObjxNWAddressExt)eObj.next());
         			
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
            DWLError error = errHandler.getErrorMessage(MDMNWComponentID.XNWADDRESS_BOBJ_EXT,
                                                                 TCRMErrorCode.READ_RECORD_ERROR,
                                                                 MDMNWErrorReasonCode.READ_EXTENSION_XNWADDRESS_FAILED,
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

