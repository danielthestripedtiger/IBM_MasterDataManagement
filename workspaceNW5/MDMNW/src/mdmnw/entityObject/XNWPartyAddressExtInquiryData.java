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
 * IBM-MDMWB-1.0-[ea905ef1800d3c43c903d08b0e0e20f3]
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
public interface XNWPartyAddressExtInquiryData {
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String tableAliasString = "tableAlias (" + 
                                            "ADDRESSGROUP => mdmnw.entityObject.EObjxNWPartyAddressExt, " +
                                            "H_ADDRESSGROUP => mdmnw.entityObject.EObjxNWPartyAddressExt" +
                                            ")";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWPartyAddressSql = "SELECT r.X_PROVIDER_FACILITY_STAFF_CODE X_PROVIDER_FACILITY_STAFF_CODE, r.X_PROV_FACILITY_ACTIVE_STATUS X_PROV_FACILITY_ACTIVE_STATUS, r.X_PRIMARY_OFFICE_FLAG X_PRIMARY_OFFICE_FLAG, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_PRIMARY_BILLING_LOC_FLAG X_PRIMARY_BILLING_LOC_FLAG, r.X_CREDENTIAL_STATUS X_CREDENTIAL_STATUS, r.X_PROVIDER_STATUS X_PROVIDER_STATUS, r.X_SCHD_PRIM_FLG X_SCHD_PRIM_FLG, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM ADDRESSGROUP r WHERE r.LOCATION_GROUP_ID = ? ";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPartyAddressParameters =
    "EObjxNWPartyAddressExt.locationGroupIdPK";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPartyAddressResults =
    "EObjxNWPartyAddressExt.xProvider_Facility_Staff_Code," +
    "EObjxNWPartyAddressExt.xProvider_Facility_Active_Status," +
    "EObjxNWPartyAddressExt.xPrimary_Office_Flag," +
    "EObjxNWPartyAddressExt.xDeactivation_Flag," +
    "EObjxNWPartyAddressExt.xPrimary_Billing_Location_Flag," +
    "EObjxNWPartyAddressExt.xCredential_Status," +
    "EObjxNWPartyAddressExt.xProvider_Status," +
    "EObjxNWPartyAddressExt.xScheduling_Primary_Flag," +
    "EObjxNWPartyAddressExt.xPhone," +
    "EObjxNWPartyAddressExt.xPhone_Ext," +
    "EObjxNWPartyAddressExt.xSecondary_Phone," +
    "EObjxNWPartyAddressExt.xSec_Phone_Ext," +
    "EObjxNWPartyAddressExt.xFax," +
    "EObjxNWPartyAddressExt.lastUpdateDt," +
    "EObjxNWPartyAddressExt.lastUpdateUser," +
    "EObjxNWPartyAddressExt.lastUpdateTxId";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWPartyAddressHistorySql = "SELECT r.H_LOCATION_GROUP_I hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_PROVIDER_FACILITY_STAFF_CODE X_PROVIDER_FACILITY_STAFF_CODE, r.X_PROV_FACILITY_ACTIVE_STATUS X_PROV_FACILITY_ACTIVE_STATUS, r.X_PRIMARY_OFFICE_FLAG X_PRIMARY_OFFICE_FLAG, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_PRIMARY_BILLING_LOC_FLAG X_PRIMARY_BILLING_LOC_FLAG, r.X_CREDENTIAL_STATUS X_CREDENTIAL_STATUS, r.X_PROVIDER_STATUS X_PROVIDER_STATUS, r.X_SCHD_PRIM_FLG X_SCHD_PRIM_FLG, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_ADDRESSGROUP r WHERE r.H_LOCATION_GROUP_I = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPartyAddressHistoryParameters =
    "EObjxNWPartyAddressExt.locationGroupIdPK," +
    "EObjxNWPartyAddressExt.lastUpdateDt," +
    "EObjxNWPartyAddressExt.lastUpdateDt";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPartyAddressHistoryResults =
    "EObjxNWPartyAddressExt.historyIdPK," +
    "EObjxNWPartyAddressExt.histActionCode," +
    "EObjxNWPartyAddressExt.histCreatedBy," +
    "EObjxNWPartyAddressExt.histCreateDt," +
    "EObjxNWPartyAddressExt.histEndDt," +
    "EObjxNWPartyAddressExt.xProvider_Facility_Staff_Code," +
    "EObjxNWPartyAddressExt.xProvider_Facility_Active_Status," +
    "EObjxNWPartyAddressExt.xPrimary_Office_Flag," +
    "EObjxNWPartyAddressExt.xDeactivation_Flag," +
    "EObjxNWPartyAddressExt.xPrimary_Billing_Location_Flag," +
    "EObjxNWPartyAddressExt.xCredential_Status," +
    "EObjxNWPartyAddressExt.xProvider_Status," +
    "EObjxNWPartyAddressExt.xScheduling_Primary_Flag," +
    "EObjxNWPartyAddressExt.xPhone," +
    "EObjxNWPartyAddressExt.xPhone_Ext," +
    "EObjxNWPartyAddressExt.xSecondary_Phone," +
    "EObjxNWPartyAddressExt.xSec_Phone_Ext," +
    "EObjxNWPartyAddressExt.xFax," +
    "EObjxNWPartyAddressExt.lastUpdateDt," +
    "EObjxNWPartyAddressExt.lastUpdateUser," +
    "EObjxNWPartyAddressExt.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWPartyAddressSql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWPartyAddressParameters, results=getxNWPartyAddressResults)
  Iterator<EObjxNWPartyAddressExt> getxNWPartyAddress(Object[] parameters);  


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWPartyAddressHistorySql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWPartyAddressHistoryParameters, results=getxNWPartyAddressHistoryResults)
  Iterator<EObjxNWPartyAddressExt> getxNWPartyAddressHistory(Object[] parameters);  


}


