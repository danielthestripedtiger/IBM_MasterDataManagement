package mdmnw.entityObject;

import mdmnw.entityObject.EObjxNWPartyAddressExt;
import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import java.sql.PreparedStatement;
import com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup;
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
public class EObjxNWPartyAddressExtDataImpl  extends BaseData implements EObjxNWPartyAddressExtData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "EObjxNWPartyAddressExtData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001690b9e48bbL;

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
  public EObjxNWPartyAddressExtDataImpl()
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
   * @Select( sql="select X_PROVIDER_FACILITY_STAFF_CODE, X_PROV_FACILITY_ACTIVE_STATUS, X_PRIMARY_OFFICE_FLAG, X_DEACTIVATION_FLAG, X_PRIMARY_BILLING_LOC_FLAG, X_CREDENTIAL_STATUS, X_PROVIDER_STATUS, X_SCHD_PRIM_FLG, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from ADDRESSGROUP where LOCATION_GROUP_ID = ? " )
   * 
   * @generated
   */
  public Iterator<EObjxNWPartyAddressExt> getEObjxNWPartyAddressExt (Long locationGroupIdPK)
  {
    return queryIterator (getEObjxNWPartyAddressExtStatementDescriptor, locationGroupIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getEObjxNWPartyAddressExtStatementDescriptor = createStatementDescriptor (
    "getEObjxNWPartyAddressExt(Long)",
    "select X_PROVIDER_FACILITY_STAFF_CODE, X_PROV_FACILITY_ACTIVE_STATUS, X_PRIMARY_OFFICE_FLAG, X_DEACTIVATION_FLAG, X_PRIMARY_BILLING_LOC_FLAG, X_CREDENTIAL_STATUS, X_PROVIDER_STATUS, X_SCHD_PRIM_FLG, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from ADDRESSGROUP where LOCATION_GROUP_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_provider_facility_staff_code", "x_prov_facility_active_status", "x_primary_office_flag", "x_deactivation_flag", "x_primary_billing_loc_flag", "x_credential_status", "x_provider_status", "x_schd_prim_flg", "x_phone", "x_phone_ext", "x_secondary_phone", "x_sec_phone_ext", "x_fax", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetEObjxNWPartyAddressExtParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetEObjxNWPartyAddressExtRowHandler (),
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
  public static class GetEObjxNWPartyAddressExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      setLong (stmt, 1, Types.BIGINT, (Long)parameters[0]);
    }
  }

  /**
   * @generated
   */
  public static class GetEObjxNWPartyAddressExtRowHandler extends BaseRowHandler<EObjxNWPartyAddressExt>
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
   * @Update( sql="insert into ADDRESSGROUP (ADDRESS_ID, CARE_OF_DESC, LOCATION_GROUP_ID, ADDR_USAGE_TP_CD, X_PROVIDER_FACILITY_STAFF_CODE, X_PROV_FACILITY_ACTIVE_STATUS, X_PRIMARY_OFFICE_FLAG, X_DEACTIVATION_FLAG, X_PRIMARY_BILLING_LOC_FLAG, X_CREDENTIAL_STATUS, X_PROVIDER_STATUS, X_SCHD_PRIM_FLG, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.addressId, ?1.careOfDesc, ?1.locationGroupIdPK, ?1.addrUsageTpCd, ?2.xProvider_Facility_Staff_Code, ?2.xProvider_Facility_Active_Status, ?2.xPrimary_Office_Flag, ?2.xDeactivation_Flag, ?2.xPrimary_Billing_Location_Flag, ?2.xCredential_Status, ?2.xProvider_Status, ?2.xScheduling_Primary_Flag, ?2.xPhone, ?2.xPhone_Ext, ?2.xSecondary_Phone, ?2.xSec_Phone_Ext, ?2.xFax, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)" )
   * 
   * @generated
   */
  public int createEObjxNWPartyAddressExt (EObjAddressGroup e1, EObjxNWPartyAddressExt e2)
  {
    return update (createEObjxNWPartyAddressExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor createEObjxNWPartyAddressExtStatementDescriptor = createStatementDescriptor (
    "createEObjxNWPartyAddressExt(com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup, mdmnw.entityObject.EObjxNWPartyAddressExt)",
    "insert into ADDRESSGROUP (ADDRESS_ID, CARE_OF_DESC, LOCATION_GROUP_ID, ADDR_USAGE_TP_CD, X_PROVIDER_FACILITY_STAFF_CODE, X_PROV_FACILITY_ACTIVE_STATUS, X_PRIMARY_OFFICE_FLAG, X_DEACTIVATION_FLAG, X_PRIMARY_BILLING_LOC_FLAG, X_CREDENTIAL_STATUS, X_PROVIDER_STATUS, X_SCHD_PRIM_FLG, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values(  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.INSERT,
    null,
    new CreateEObjxNWPartyAddressExtParameterHandler (),
    new int[][]{{Types.BIGINT, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 50, 19, 19, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 0, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
    null,
    null,
    null,
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
  public static class CreateEObjxNWPartyAddressExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjAddressGroup bean0 = (EObjAddressGroup) parameters[0];
      setLong (stmt, 1, Types.BIGINT, (Long)bean0.getAddressId());
      setString (stmt, 2, Types.VARCHAR, (String)bean0.getCareOfDesc());
      setLong (stmt, 3, Types.BIGINT, (Long)bean0.getLocationGroupIdPK());
      setLong (stmt, 4, Types.BIGINT, (Long)bean0.getAddrUsageTpCd());
      EObjxNWPartyAddressExt bean1 = (EObjxNWPartyAddressExt) parameters[1];
      setString (stmt, 5, Types.VARCHAR, (String)bean1.getXProvider_Facility_Staff_Code());
      setString (stmt, 6, Types.VARCHAR, (String)bean1.getXProvider_Facility_Active_Status());
      setString (stmt, 7, Types.VARCHAR, (String)bean1.getXPrimary_Office_Flag());
      setString (stmt, 8, Types.VARCHAR, (String)bean1.getXDeactivation_Flag());
      setString (stmt, 9, Types.VARCHAR, (String)bean1.getXPrimary_Billing_Location_Flag());
      setString (stmt, 10, Types.VARCHAR, (String)bean1.getXCredential_Status());
      setString (stmt, 11, Types.VARCHAR, (String)bean1.getXProvider_Status());
      setString (stmt, 12, Types.VARCHAR, (String)bean1.getXScheduling_Primary_Flag());
      setString (stmt, 13, Types.VARCHAR, (String)bean1.getXPhone());
      setString (stmt, 14, Types.VARCHAR, (String)bean1.getXPhone_Ext());
      setString (stmt, 15, Types.VARCHAR, (String)bean1.getXSecondary_Phone());
      setString (stmt, 16, Types.VARCHAR, (String)bean1.getXSec_Phone_Ext());
      setString (stmt, 17, Types.VARCHAR, (String)bean1.getXFax());
      setTimestamp (stmt, 18, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 19, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 20, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
    }
  }

  /**
   * @Update( sql="update ADDRESSGROUP set ADDRESS_ID = ?1.addressId, CARE_OF_DESC = ?1.careOfDesc, ADDR_USAGE_TP_CD = ?1.addrUsageTpCd, X_PROVIDER_FACILITY_STAFF_CODE = ?2.xProvider_Facility_Staff_Code, X_PROV_FACILITY_ACTIVE_STATUS = ?2.xProvider_Facility_Active_Status, X_PRIMARY_OFFICE_FLAG = ?2.xPrimary_Office_Flag, X_DEACTIVATION_FLAG = ?2.xDeactivation_Flag, X_PRIMARY_BILLING_LOC_FLAG = ?2.xPrimary_Billing_Location_Flag, X_CREDENTIAL_STATUS = ?2.xCredential_Status, X_PROVIDER_STATUS = ?2.xProvider_Status, X_SCHD_PRIM_FLG = ?2.xScheduling_Primary_Flag, X_PHONE = ?2.xPhone, X_PHONE_EXT = ?2.xPhone_Ext, X_SECONDARY_PHONE = ?2.xSecondary_Phone, X_SEC_PHONE_EXT = ?2.xSec_Phone_Ext, X_FAX = ?2.xFax, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where LOCATION_GROUP_ID = ?1.locationGroupIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt" )
   * 
   * @generated
   */
  public int updateEObjxNWPartyAddressExt (EObjAddressGroup e1, EObjxNWPartyAddressExt e2)
  {
    return update (updateEObjxNWPartyAddressExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor updateEObjxNWPartyAddressExtStatementDescriptor = createStatementDescriptor (
    "updateEObjxNWPartyAddressExt(com.dwl.tcrm.coreParty.entityObject.EObjAddressGroup, mdmnw.entityObject.EObjxNWPartyAddressExt)",
    "update ADDRESSGROUP set ADDRESS_ID =  ? , CARE_OF_DESC =  ? , ADDR_USAGE_TP_CD =  ? , X_PROVIDER_FACILITY_STAFF_CODE =  ? , X_PROV_FACILITY_ACTIVE_STATUS =  ? , X_PRIMARY_OFFICE_FLAG =  ? , X_DEACTIVATION_FLAG =  ? , X_PRIMARY_BILLING_LOC_FLAG =  ? , X_CREDENTIAL_STATUS =  ? , X_PROVIDER_STATUS =  ? , X_SCHD_PRIM_FLG =  ? , X_PHONE =  ? , X_PHONE_EXT =  ? , X_SECONDARY_PHONE =  ? , X_SEC_PHONE_EXT =  ? , X_FAX =  ? , LAST_UPDATE_DT =  ? , LAST_UPDATE_USER =  ? , LAST_UPDATE_TX_ID =  ?  where LOCATION_GROUP_ID =  ?  and LAST_UPDATE_DT =  ? ",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.UPDATE,
    null,
    new UpdateEObjxNWPartyAddressExtParameterHandler (),
    new int[][]{{Types.BIGINT, Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.TIMESTAMP}, {19, 50, 19, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 0, 19, 19, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
    null,
    null,
    null,
    null,
    identifier,
    generationTime,
    collection,
    forceSingleBindIsolation,
    null,
    3);

  /**
   * @generated
   */
  public static class UpdateEObjxNWPartyAddressExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjAddressGroup bean0 = (EObjAddressGroup) parameters[0];
      setLong (stmt, 1, Types.BIGINT, (Long)bean0.getAddressId());
      setString (stmt, 2, Types.VARCHAR, (String)bean0.getCareOfDesc());
      setLong (stmt, 3, Types.BIGINT, (Long)bean0.getAddrUsageTpCd());
      EObjxNWPartyAddressExt bean1 = (EObjxNWPartyAddressExt) parameters[1];
      setString (stmt, 4, Types.VARCHAR, (String)bean1.getXProvider_Facility_Staff_Code());
      setString (stmt, 5, Types.VARCHAR, (String)bean1.getXProvider_Facility_Active_Status());
      setString (stmt, 6, Types.VARCHAR, (String)bean1.getXPrimary_Office_Flag());
      setString (stmt, 7, Types.VARCHAR, (String)bean1.getXDeactivation_Flag());
      setString (stmt, 8, Types.VARCHAR, (String)bean1.getXPrimary_Billing_Location_Flag());
      setString (stmt, 9, Types.VARCHAR, (String)bean1.getXCredential_Status());
      setString (stmt, 10, Types.VARCHAR, (String)bean1.getXProvider_Status());
      setString (stmt, 11, Types.VARCHAR, (String)bean1.getXScheduling_Primary_Flag());
      setString (stmt, 12, Types.VARCHAR, (String)bean1.getXPhone());
      setString (stmt, 13, Types.VARCHAR, (String)bean1.getXPhone_Ext());
      setString (stmt, 14, Types.VARCHAR, (String)bean1.getXSecondary_Phone());
      setString (stmt, 15, Types.VARCHAR, (String)bean1.getXSec_Phone_Ext());
      setString (stmt, 16, Types.VARCHAR, (String)bean1.getXFax());
      setTimestamp (stmt, 17, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 18, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 19, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
      setLong (stmt, 20, Types.BIGINT, (Long)bean0.getLocationGroupIdPK());
      setTimestamp (stmt, 21, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getOldLastUpdateDt());
    }
  }

  /**
   * @Update( sql="delete from ADDRESSGROUP where LOCATION_GROUP_ID = ?" )
   * 
   * @generated
   */
  public int deleteEObjxNWPartyAddressExt (Long locationGroupIdPK)
  {
    return update (deleteEObjxNWPartyAddressExtStatementDescriptor, locationGroupIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor deleteEObjxNWPartyAddressExtStatementDescriptor = createStatementDescriptor (
    "deleteEObjxNWPartyAddressExt(Long)",
    "delete from ADDRESSGROUP where LOCATION_GROUP_ID = ?",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.DELETE,
    null,
    new DeleteEObjxNWPartyAddressExtParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    null,
    null,
    null,
    identifier,
    generationTime,
    collection,
    forceSingleBindIsolation,
    null,
    4);

  /**
   * @generated
   */
  public static class DeleteEObjxNWPartyAddressExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      setLong (stmt, 1, Types.BIGINT, (Long)parameters[0]);
    }
  }

}
