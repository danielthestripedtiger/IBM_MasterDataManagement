package mdmnw.entityObject;

import mdmnw.entityObject.EObjxNWPartyAddressExt;
import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import java.sql.PreparedStatement;
import com.ibm.pdq.runtime.statement.StatementDescriptor;
import com.ibm.pdq.runtime.generator.BaseData;
import java.sql.SQLException;
import com.ibm.pdq.annotation.Metadata;
import com.ibm.pdq.runtime.generator.BaseRowHandler;
import com.ibm.pdq.runtime.statement.SqlStatementType;
import java.sql.Types;


/**
 * <!-- begin-user-doc -->
 * 
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class XNWPartyAddressExtInquiryDataImpl  extends BaseData implements XNWPartyAddressExtInquiryData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "XNWPartyAddressExtInquiryData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001690b9e49a1L;

  /**
   * @generated
   */
  public static final String collection = "NULLID";

  /**
   * @generated
   */
  public static final String packageVersion = null;

  /**
   * @generated
   */
  public static final boolean forceSingleBindIsolation = false;

  /**
   * @generated
   */
  public XNWPartyAddressExtInquiryDataImpl()
  {
    super();
  } 

  /**
   * @generated
   */
  public String getGeneratorVersion()
  {
    return generatorVersion;
  }

  /**
   * @Select( sql="SELECT r.X_PROVIDER_FACILITY_STAFF_CODE X_PROVIDER_FACILITY_STAFF_CODE, r.X_PROV_FACILITY_ACTIVE_STATUS X_PROV_FACILITY_ACTIVE_STATUS, r.X_PRIMARY_OFFICE_FLAG X_PRIMARY_OFFICE_FLAG, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_PRIMARY_BILLING_LOC_FLAG X_PRIMARY_BILLING_LOC_FLAG, r.X_CREDENTIAL_STATUS X_CREDENTIAL_STATUS, r.X_PROVIDER_STATUS X_PROVIDER_STATUS, r.X_SCHD_PRIM_FLG X_SCHD_PRIM_FLG, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM ADDRESSGROUP r WHERE r.LOCATION_GROUP_ID = ? ", pattern="tableAlias (ADDRESSGROUP => mdmnw.entityObject.EObjxNWPartyAddressExt, H_ADDRESSGROUP => mdmnw.entityObject.EObjxNWPartyAddressExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWPartyAddressExt> getxNWPartyAddress (Object[] parameters)
  {
    return queryIterator (getxNWPartyAddressStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWPartyAddressStatementDescriptor = createStatementDescriptor (
    "getxNWPartyAddress(Object[])",
    "SELECT r.X_PROVIDER_FACILITY_STAFF_CODE X_PROVIDER_FACILITY_STAFF_CODE, r.X_PROV_FACILITY_ACTIVE_STATUS X_PROV_FACILITY_ACTIVE_STATUS, r.X_PRIMARY_OFFICE_FLAG X_PRIMARY_OFFICE_FLAG, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_PRIMARY_BILLING_LOC_FLAG X_PRIMARY_BILLING_LOC_FLAG, r.X_CREDENTIAL_STATUS X_CREDENTIAL_STATUS, r.X_PROVIDER_STATUS X_PROVIDER_STATUS, r.X_SCHD_PRIM_FLG X_SCHD_PRIM_FLG, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM ADDRESSGROUP r WHERE r.LOCATION_GROUP_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_provider_facility_staff_code", "x_prov_facility_active_status", "x_primary_office_flag", "x_deactivation_flag", "x_primary_billing_loc_flag", "x_credential_status", "x_provider_status", "x_schd_prim_flg", "x_phone", "x_phone_ext", "x_secondary_phone", "x_sec_phone_ext", "x_fax", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWPartyAddressParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetxNWPartyAddressRowHandler (),
    new int[][]{ {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
    null,
    identifier,
    generationTime,
    collection,
    forceSingleBindIsolation,
    null,
    1);

  /**
   * @generated
   */
  public static class GetxNWPartyAddressParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      setObject (stmt, 1, Types.BIGINT, parameters[0], 0);
    }
  }

  /**
   * @generated
   */
  public static class GetxNWPartyAddressRowHandler extends BaseRowHandler<EObjxNWPartyAddressExt>
  {
    /**
     * @generated
     */
    public EObjxNWPartyAddressExt handle (java.sql.ResultSet rs, EObjxNWPartyAddressExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWPartyAddressExt ();
      returnObject.setXProvider_Facility_Staff_Code(getString (rs, 1)); 
      returnObject.setXProvider_Facility_Active_Status(getString (rs, 2)); 
      returnObject.setXPrimary_Office_Flag(getString (rs, 3)); 
      returnObject.setXDeactivation_Flag(getString (rs, 4)); 
      returnObject.setXPrimary_Billing_Location_Flag(getString (rs, 5)); 
      returnObject.setXCredential_Status(getString (rs, 6)); 
      returnObject.setXProvider_Status(getString (rs, 7)); 
      returnObject.setXScheduling_Primary_Flag(getString (rs, 8)); 
      returnObject.setXPhone(getString (rs, 9)); 
      returnObject.setXPhone_Ext(getString (rs, 10)); 
      returnObject.setXSecondary_Phone(getString (rs, 11)); 
      returnObject.setXSec_Phone_Ext(getString (rs, 12)); 
      returnObject.setXFax(getString (rs, 13)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 14)); 
      returnObject.setLastUpdateUser(getString (rs, 15)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 16)); 
    
      return returnObject;
    }
  }

  /**
   * @Select( sql="SELECT r.H_LOCATION_GROUP_I hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_PROVIDER_FACILITY_STAFF_CODE X_PROVIDER_FACILITY_STAFF_CODE, r.X_PROV_FACILITY_ACTIVE_STATUS X_PROV_FACILITY_ACTIVE_STATUS, r.X_PRIMARY_OFFICE_FLAG X_PRIMARY_OFFICE_FLAG, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_PRIMARY_BILLING_LOC_FLAG X_PRIMARY_BILLING_LOC_FLAG, r.X_CREDENTIAL_STATUS X_CREDENTIAL_STATUS, r.X_PROVIDER_STATUS X_PROVIDER_STATUS, r.X_SCHD_PRIM_FLG X_SCHD_PRIM_FLG, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_ADDRESSGROUP r WHERE r.H_LOCATION_GROUP_I = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))", pattern="tableAlias (ADDRESSGROUP => mdmnw.entityObject.EObjxNWPartyAddressExt, H_ADDRESSGROUP => mdmnw.entityObject.EObjxNWPartyAddressExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWPartyAddressExt> getxNWPartyAddressHistory (Object[] parameters)
  {
    return queryIterator (getxNWPartyAddressHistoryStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWPartyAddressHistoryStatementDescriptor = createStatementDescriptor (
    "getxNWPartyAddressHistory(Object[])",
    "SELECT r.H_LOCATION_GROUP_I hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_PROVIDER_FACILITY_STAFF_CODE X_PROVIDER_FACILITY_STAFF_CODE, r.X_PROV_FACILITY_ACTIVE_STATUS X_PROV_FACILITY_ACTIVE_STATUS, r.X_PRIMARY_OFFICE_FLAG X_PRIMARY_OFFICE_FLAG, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_PRIMARY_BILLING_LOC_FLAG X_PRIMARY_BILLING_LOC_FLAG, r.X_CREDENTIAL_STATUS X_CREDENTIAL_STATUS, r.X_PROVIDER_STATUS X_PROVIDER_STATUS, r.X_SCHD_PRIM_FLG X_SCHD_PRIM_FLG, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_ADDRESSGROUP r WHERE r.H_LOCATION_GROUP_I = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"historyidpk", "h_action_code", "h_created_by", "h_create_dt", "h_end_dt", "x_provider_facility_staff_code", "x_prov_facility_active_status", "x_primary_office_flag", "x_deactivation_flag", "x_primary_billing_loc_flag", "x_credential_status", "x_provider_status", "x_schd_prim_flg", "x_phone", "x_phone_ext", "x_secondary_phone", "x_sec_phone_ext", "x_fax", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWPartyAddressHistoryParameterHandler (),
    new int[][]{{Types.BIGINT, Types.TIMESTAMP, Types.TIMESTAMP}, {19, 0, 0}, {0, 0, 0}, {1, 1, 1}},
    null,
    new GetxNWPartyAddressHistoryRowHandler (),
    new int[][]{ {Types.BIGINT, Types.CHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 1, 20, 0, 0, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
    null,
    identifier,
    generationTime,
    collection,
    forceSingleBindIsolation,
    null,
    2);

  /**
   * @generated
   */
  public static class GetxNWPartyAddressHistoryParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      setObject (stmt, 1, Types.BIGINT, parameters[0], 0);
      setObject (stmt, 2, Types.TIMESTAMP, parameters[1], 0);
      setObject (stmt, 3, Types.TIMESTAMP, parameters[2], 0);
    }
  }

  /**
   * @generated
   */
  public static class GetxNWPartyAddressHistoryRowHandler extends BaseRowHandler<EObjxNWPartyAddressExt>
  {
    /**
     * @generated
     */
    public EObjxNWPartyAddressExt handle (java.sql.ResultSet rs, EObjxNWPartyAddressExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWPartyAddressExt ();
      returnObject.setHistoryIdPK(getLongObject (rs, 1)); 
      returnObject.setHistActionCode(getString (rs, 2)); 
      returnObject.setHistCreatedBy(getString (rs, 3)); 
      returnObject.setHistCreateDt(getTimestamp (rs, 4)); 
      returnObject.setHistEndDt(getTimestamp (rs, 5)); 
      returnObject.setXProvider_Facility_Staff_Code(getString (rs, 6)); 
      returnObject.setXProvider_Facility_Active_Status(getString (rs, 7)); 
      returnObject.setXPrimary_Office_Flag(getString (rs, 8)); 
      returnObject.setXDeactivation_Flag(getString (rs, 9)); 
      returnObject.setXPrimary_Billing_Location_Flag(getString (rs, 10)); 
      returnObject.setXCredential_Status(getString (rs, 11)); 
      returnObject.setXProvider_Status(getString (rs, 12)); 
      returnObject.setXScheduling_Primary_Flag(getString (rs, 13)); 
      returnObject.setXPhone(getString (rs, 14)); 
      returnObject.setXPhone_Ext(getString (rs, 15)); 
      returnObject.setXSecondary_Phone(getString (rs, 16)); 
      returnObject.setXSec_Phone_Ext(getString (rs, 17)); 
      returnObject.setXFax(getString (rs, 18)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 19)); 
      returnObject.setLastUpdateUser(getString (rs, 20)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 21)); 
    
      return returnObject;
    }
  }

}
