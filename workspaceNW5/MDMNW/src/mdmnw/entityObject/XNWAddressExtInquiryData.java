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
 * IBM-MDMWB-1.0-[13b946976c6bcfe9455722456ef8cdbe]
 */

package mdmnw.entityObject;


import java.util.Iterator;
import com.ibm.mdm.base.db.EntityMapping;
import com.ibm.pdq.annotation.Select;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public interface XNWAddressExtInquiryData {
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String tableAliasString = "tableAlias (" + 
                                            "ADDRESS => mdmnw.entityObject.EObjxNWAddressExt, " +
                                            "H_ADDRESS => mdmnw.entityObject.EObjxNWAddressExt" +
                                            ")";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWAddressSql = "SELECT r.X_COUNTY X_COUNTY, r.X_HOSPITAL X_HOSPITAL, r.X_FACILITY_NAME X_FACILITY_NAME, r.X_FACILITY_CODE X_FACILITY_CODE, r.X_DEPARTMENT_CODE X_DEPARTMENT_CODE, r.X_DEPARTMENT_DESCRIPTION X_DEPARTMENT_DESCRIPTION, r.X_LOCATION_CODE X_LOCATION_CODE, r.X_LOCATION_DESCRIPTION X_LOCATION_DESCRIPTION, r.X_LOCATION_MNEMONIC X_LOCATION_MNEMONIC, r.X_LOCATION_ID X_LOCATION_ID, r.X_LOCATION_NAME X_LOCATION_NAME, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.X_TAX_ID_NUMBER X_TAX_ID_NUMBER, r.X_NEWPORT_KEY X_NEWPORT_KEY, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_ACTIVATION_DATE X_ACTIVATION_DATE, r.X_DEACTIVATION_DATE X_DEACTIVATION_DATE, r.X_TAX_ID_NUMBER_SOURCE X_TAX_ID_NUMBER_SOURCE, r.X_TAX_ID_LASTVERIFIEDDATE X_TAX_ID_LASTVERIFIEDDATE, r.X_NEWPORT_KEY_SOURCE X_NEWPORT_KEY_SOURCE, r.X_NEWPORT_KEY_LASTVERIFIEDDATE X_NEWPORT_KEY_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM ADDRESS r WHERE r.ADDRESS_ID = ? ";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWAddressParameters =
    "EObjxNWAddressExt.addressIdPK";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWAddressResults =
    "EObjxNWAddressExt.xCounty," +
    "EObjxNWAddressExt.xHospital," +
    "EObjxNWAddressExt.xFacility_Name," +
    "EObjxNWAddressExt.xFacility_Code," +
    "EObjxNWAddressExt.xDepartment_Code," +
    "EObjxNWAddressExt.xDepartment_Description," +
    "EObjxNWAddressExt.xLocation_Code," +
    "EObjxNWAddressExt.xLocation_Description," +
    "EObjxNWAddressExt.xLocation_Mnemonic," +
    "EObjxNWAddressExt.xLocation_ID," +
    "EObjxNWAddressExt.xLocation_Name," +
    "EObjxNWAddressExt.xPhone," +
    "EObjxNWAddressExt.xPhone_Ext," +
    "EObjxNWAddressExt.xSecondary_Phone," +
    "EObjxNWAddressExt.xSec_Phone_Ext," +
    "EObjxNWAddressExt.xFax," +
    "EObjxNWAddressExt.xTax_ID_Number," +
    "EObjxNWAddressExt.xNewport_Key," +
    "EObjxNWAddressExt.xDeactivation_Flag," +
    "EObjxNWAddressExt.xActivation_Date," +
    "EObjxNWAddressExt.xDeactivation_Date," +
    "EObjxNWAddressExt.xTax_ID_Number_Source," +
    "EObjxNWAddressExt.xTax_ID_Number_LastVerifiedDate," +
    "EObjxNWAddressExt.xNewport_Key_Source," +
    "EObjxNWAddressExt.xNewport_Key_LastVerifiedDate," +
    "EObjxNWAddressExt.lastUpdateDt," +
    "EObjxNWAddressExt.lastUpdateUser," +
    "EObjxNWAddressExt.lastUpdateTxId";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWAddressHistorySql = "SELECT r.H_ADDRESS_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_COUNTY X_COUNTY, r.X_HOSPITAL X_HOSPITAL, r.X_FACILITY_NAME X_FACILITY_NAME, r.X_FACILITY_CODE X_FACILITY_CODE, r.X_DEPARTMENT_CODE X_DEPARTMENT_CODE, r.X_DEPARTMENT_DESCRIPTION X_DEPARTMENT_DESCRIPTION, r.X_LOCATION_CODE X_LOCATION_CODE, r.X_LOCATION_DESCRIPTION X_LOCATION_DESCRIPTION, r.X_LOCATION_MNEMONIC X_LOCATION_MNEMONIC, r.X_LOCATION_ID X_LOCATION_ID, r.X_LOCATION_NAME X_LOCATION_NAME, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.X_TAX_ID_NUMBER X_TAX_ID_NUMBER, r.X_NEWPORT_KEY X_NEWPORT_KEY, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_ACTIVATION_DATE X_ACTIVATION_DATE, r.X_DEACTIVATION_DATE X_DEACTIVATION_DATE, r.X_TAX_ID_NUMBER_SOURCE X_TAX_ID_NUMBER_SOURCE, r.X_TAX_ID_LASTVERIFIEDDATE X_TAX_ID_LASTVERIFIEDDATE, r.X_NEWPORT_KEY_SOURCE X_NEWPORT_KEY_SOURCE, r.X_NEWPORT_KEY_LASTVERIFIEDDATE X_NEWPORT_KEY_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_ADDRESS r WHERE r.H_ADDRESS_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWAddressHistoryParameters =
    "EObjxNWAddressExt.addressIdPK," +
    "EObjxNWAddressExt.lastUpdateDt," +
    "EObjxNWAddressExt.lastUpdateDt";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWAddressHistoryResults =
    "EObjxNWAddressExt.historyIdPK," +
    "EObjxNWAddressExt.histActionCode," +
    "EObjxNWAddressExt.histCreatedBy," +
    "EObjxNWAddressExt.histCreateDt," +
    "EObjxNWAddressExt.histEndDt," +
    "EObjxNWAddressExt.xCounty," +
    "EObjxNWAddressExt.xHospital," +
    "EObjxNWAddressExt.xFacility_Name," +
    "EObjxNWAddressExt.xFacility_Code," +
    "EObjxNWAddressExt.xDepartment_Code," +
    "EObjxNWAddressExt.xDepartment_Description," +
    "EObjxNWAddressExt.xLocation_Code," +
    "EObjxNWAddressExt.xLocation_Description," +
    "EObjxNWAddressExt.xLocation_Mnemonic," +
    "EObjxNWAddressExt.xLocation_ID," +
    "EObjxNWAddressExt.xLocation_Name," +
    "EObjxNWAddressExt.xPhone," +
    "EObjxNWAddressExt.xPhone_Ext," +
    "EObjxNWAddressExt.xSecondary_Phone," +
    "EObjxNWAddressExt.xSec_Phone_Ext," +
    "EObjxNWAddressExt.xFax," +
    "EObjxNWAddressExt.xTax_ID_Number," +
    "EObjxNWAddressExt.xNewport_Key," +
    "EObjxNWAddressExt.xDeactivation_Flag," +
    "EObjxNWAddressExt.xActivation_Date," +
    "EObjxNWAddressExt.xDeactivation_Date," +
    "EObjxNWAddressExt.xTax_ID_Number_Source," +
    "EObjxNWAddressExt.xTax_ID_Number_LastVerifiedDate," +
    "EObjxNWAddressExt.xNewport_Key_Source," +
    "EObjxNWAddressExt.xNewport_Key_LastVerifiedDate," +
    "EObjxNWAddressExt.lastUpdateDt," +
    "EObjxNWAddressExt.lastUpdateUser," +
    "EObjxNWAddressExt.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWAddressSql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWAddressParameters, results=getxNWAddressResults)
  Iterator<EObjxNWAddressExt> getxNWAddress(Object[] parameters);  


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWAddressHistorySql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWAddressHistoryParameters, results=getxNWAddressHistoryResults)
  Iterator<EObjxNWAddressExt> getxNWAddressHistory(Object[] parameters);  


}


