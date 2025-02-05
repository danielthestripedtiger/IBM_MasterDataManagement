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
 * IBM-MDMWB-1.0-[245236e3f1f94de7d203911f4f40d610]
 */


package mdmnw.entityObject;

import java.util.Iterator;
import com.ibm.mdm.base.db.EntityMapping;
import com.ibm.pdq.annotation.Select;
import com.ibm.pdq.annotation.Update;

import com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup;

import mdmnw.entityObject.EObjxNWPartyAddressExt;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public interface EObjxNWPartyAddressExtData {


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getEObjxNWPartyAddressExtSql = "select X_PROVIDER_FACILITY_STAFF_CODE, X_PROV_FACILITY_ACTIVE_STATUS, X_PRIMARY_OFFICE_FLAG, X_DEACTIVATION_FLAG, X_PRIMARY_BILLING_LOC_FLAG, X_CREDENTIAL_STATUS, X_PROVIDER_STATUS, X_SCHD_PRIM_FLG, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from ADDRESSGROUP where LOCATION_GROUP_ID = ? ";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String createEObjxNWPartyAddressExtSql = "insert into ADDRESSGROUP (ADDRESS_ID, CARE_OF_DESC, LOCATION_GROUP_ID, ADDR_USAGE_TP_CD, X_PROVIDER_FACILITY_STAFF_CODE, X_PROV_FACILITY_ACTIVE_STATUS, X_PRIMARY_OFFICE_FLAG, X_DEACTIVATION_FLAG, X_PRIMARY_BILLING_LOC_FLAG, X_CREDENTIAL_STATUS, X_PROVIDER_STATUS, X_SCHD_PRIM_FLG, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.addressId, ?1.careOfDesc, ?1.locationGroupIdPK, ?1.addrUsageTpCd, ?2.xProvider_Facility_Staff_Code, ?2.xProvider_Facility_Active_Status, ?2.xPrimary_Office_Flag, ?2.xDeactivation_Flag, ?2.xPrimary_Billing_Location_Flag, ?2.xCredential_Status, ?2.xProvider_Status, ?2.xScheduling_Primary_Flag, ?2.xPhone, ?2.xPhone_Ext, ?2.xSecondary_Phone, ?2.xSec_Phone_Ext, ?2.xFax, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String updateEObjxNWPartyAddressExtSql = "update ADDRESSGROUP set ADDRESS_ID = ?1.addressId, CARE_OF_DESC = ?1.careOfDesc, ADDR_USAGE_TP_CD = ?1.addrUsageTpCd, X_PROVIDER_FACILITY_STAFF_CODE = ?2.xProvider_Facility_Staff_Code, X_PROV_FACILITY_ACTIVE_STATUS = ?2.xProvider_Facility_Active_Status, X_PRIMARY_OFFICE_FLAG = ?2.xPrimary_Office_Flag, X_DEACTIVATION_FLAG = ?2.xDeactivation_Flag, X_PRIMARY_BILLING_LOC_FLAG = ?2.xPrimary_Billing_Location_Flag, X_CREDENTIAL_STATUS = ?2.xCredential_Status, X_PROVIDER_STATUS = ?2.xProvider_Status, X_SCHD_PRIM_FLG = ?2.xScheduling_Primary_Flag, X_PHONE = ?2.xPhone, X_PHONE_EXT = ?2.xPhone_Ext, X_SECONDARY_PHONE = ?2.xSecondary_Phone, X_SEC_PHONE_EXT = ?2.xSec_Phone_Ext, X_FAX = ?2.xFax, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where LOCATION_GROUP_ID = ?1.locationGroupIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String deleteEObjxNWPartyAddressExtSql = "delete from ADDRESSGROUP where LOCATION_GROUP_ID = ?";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPartyAddressExtKeyField = "EObjxNWPartyAddressExt.locationGroupIdPK";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPartyAddressExtGetFields =
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
  public static final String EObjxNWPartyAddressExtAllFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.addressId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.careOfDesc," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.locationGroupIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.addrUsageTpCd," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xProvider_Facility_Staff_Code," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xProvider_Facility_Active_Status," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPrimary_Office_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xDeactivation_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPrimary_Billing_Location_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xCredential_Status," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xProvider_Status," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xScheduling_Primary_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPhone," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPhone_Ext," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xSecondary_Phone," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xSec_Phone_Ext," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xFax," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPartyAddressExtUpdateFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.addressId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.careOfDesc," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.addrUsageTpCd," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xProvider_Facility_Staff_Code," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xProvider_Facility_Active_Status," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPrimary_Office_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xDeactivation_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPrimary_Billing_Location_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xCredential_Status," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xProvider_Status," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xScheduling_Primary_Flag," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPhone," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xPhone_Ext," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xSecondary_Phone," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xSec_Phone_Ext," +
    "mdmnw.entityObject.EObjxNWPartyAddressExt.xFax," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.lastUpdateTxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.locationGroupIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup.oldLastUpdateDt";   

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Select xNWPartyAddress by parameters.
   * @generated
   */
  @Select(sql=getEObjxNWPartyAddressExtSql)
  @EntityMapping(parameters=EObjxNWPartyAddressExtKeyField, results=EObjxNWPartyAddressExtGetFields)
  Iterator<EObjxNWPartyAddressExt> getEObjxNWPartyAddressExt(Long locationGroupIdPK);  
   
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Create xNWPartyAddress by EObjxNWPartyAddressExt Object.
   * @generated
   */
  @Update(sql=createEObjxNWPartyAddressExtSql)
  @EntityMapping(parameters=EObjxNWPartyAddressExtAllFields)
    int createEObjxNWPartyAddressExt(EObjAddressGroup e1, EObjxNWPartyAddressExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Update one xNWPartyAddress by EObjxNWPartyAddressExt object.
   * @generated
   */
  @Update(sql=updateEObjxNWPartyAddressExtSql)
  @EntityMapping(parameters=EObjxNWPartyAddressExtUpdateFields)
    int updateEObjxNWPartyAddressExt(EObjAddressGroup e1, EObjxNWPartyAddressExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Delete xNWPartyAddress by parameters.
   * @generated
   */
  @Update(sql=deleteEObjxNWPartyAddressExtSql)
  @EntityMapping(parameters=EObjxNWPartyAddressExtKeyField)
  int deleteEObjxNWPartyAddressExt(Long locationGroupIdPK);

}

