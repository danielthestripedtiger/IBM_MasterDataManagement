package mdmnw.entityObject;

import mdmnw.entityObject.EObjxNWAddressExt;
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
public class XNWAddressExtInquiryDataImpl  extends BaseData implements XNWAddressExtInquiryData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "XNWAddressExtInquiryData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001689ac99221L;

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
  public XNWAddressExtInquiryDataImpl()
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
   * @Select( sql="SELECT r.X_COUNTY X_COUNTY, r.X_HOSPITAL X_HOSPITAL, r.X_FACILITY_NAME X_FACILITY_NAME, r.X_FACILITY_CODE X_FACILITY_CODE, r.X_DEPARTMENT_CODE X_DEPARTMENT_CODE, r.X_DEPARTMENT_DESCRIPTION X_DEPARTMENT_DESCRIPTION, r.X_LOCATION_CODE X_LOCATION_CODE, r.X_LOCATION_DESCRIPTION X_LOCATION_DESCRIPTION, r.X_LOCATION_MNEMONIC X_LOCATION_MNEMONIC, r.X_LOCATION_ID X_LOCATION_ID, r.X_LOCATION_NAME X_LOCATION_NAME, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.X_TAX_ID_NUMBER X_TAX_ID_NUMBER, r.X_NEWPORT_KEY X_NEWPORT_KEY, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_ACTIVATION_DATE X_ACTIVATION_DATE, r.X_DEACTIVATION_DATE X_DEACTIVATION_DATE, r.X_TAX_ID_NUMBER_SOURCE X_TAX_ID_NUMBER_SOURCE, r.X_TAX_ID_LASTVERIFIEDDATE X_TAX_ID_LASTVERIFIEDDATE, r.X_NEWPORT_KEY_SOURCE X_NEWPORT_KEY_SOURCE, r.X_NEWPORT_KEY_LASTVERIFIEDDATE X_NEWPORT_KEY_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM ADDRESS r WHERE r.ADDRESS_ID = ? ", pattern="tableAlias (ADDRESS => mdmnw.entityObject.EObjxNWAddressExt, H_ADDRESS => mdmnw.entityObject.EObjxNWAddressExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWAddressExt> getxNWAddress (Object[] parameters)
  {
    return queryIterator (getxNWAddressStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWAddressStatementDescriptor = createStatementDescriptor (
    "getxNWAddress(Object[])",
    "SELECT r.X_COUNTY X_COUNTY, r.X_HOSPITAL X_HOSPITAL, r.X_FACILITY_NAME X_FACILITY_NAME, r.X_FACILITY_CODE X_FACILITY_CODE, r.X_DEPARTMENT_CODE X_DEPARTMENT_CODE, r.X_DEPARTMENT_DESCRIPTION X_DEPARTMENT_DESCRIPTION, r.X_LOCATION_CODE X_LOCATION_CODE, r.X_LOCATION_DESCRIPTION X_LOCATION_DESCRIPTION, r.X_LOCATION_MNEMONIC X_LOCATION_MNEMONIC, r.X_LOCATION_ID X_LOCATION_ID, r.X_LOCATION_NAME X_LOCATION_NAME, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.X_TAX_ID_NUMBER X_TAX_ID_NUMBER, r.X_NEWPORT_KEY X_NEWPORT_KEY, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_ACTIVATION_DATE X_ACTIVATION_DATE, r.X_DEACTIVATION_DATE X_DEACTIVATION_DATE, r.X_TAX_ID_NUMBER_SOURCE X_TAX_ID_NUMBER_SOURCE, r.X_TAX_ID_LASTVERIFIEDDATE X_TAX_ID_LASTVERIFIEDDATE, r.X_NEWPORT_KEY_SOURCE X_NEWPORT_KEY_SOURCE, r.X_NEWPORT_KEY_LASTVERIFIEDDATE X_NEWPORT_KEY_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM ADDRESS r WHERE r.ADDRESS_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_county", "x_hospital", "x_facility_name", "x_facility_code", "x_department_code", "x_department_description", "x_location_code", "x_location_description", "x_location_mnemonic", "x_location_id", "x_location_name", "x_phone", "x_phone_ext", "x_secondary_phone", "x_sec_phone_ext", "x_fax", "x_tax_id_number", "x_newport_key", "x_deactivation_flag", "x_activation_date", "x_deactivation_date", "x_tax_id_number_source", "x_tax_id_lastverifieddate", "x_newport_key_source", "x_newport_key_lastverifieddate", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWAddressParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetxNWAddressRowHandler (),
    new int[][]{ {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 0, 250, 0, 250, 0, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetxNWAddressParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWAddressRowHandler extends BaseRowHandler<EObjxNWAddressExt>
  {
    /**
     * @generated
     */
    public EObjxNWAddressExt handle (java.sql.ResultSet rs, EObjxNWAddressExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWAddressExt ();
      returnObject.setXCounty(getString (rs, 1)); 
      returnObject.setXHospital(getString (rs, 2)); 
      returnObject.setXFacility_Name(getString (rs, 3)); 
      returnObject.setXFacility_Code(getString (rs, 4)); 
      returnObject.setXDepartment_Code(getString (rs, 5)); 
      returnObject.setXDepartment_Description(getString (rs, 6)); 
      returnObject.setXLocation_Code(getString (rs, 7)); 
      returnObject.setXLocation_Description(getString (rs, 8)); 
      returnObject.setXLocation_Mnemonic(getString (rs, 9)); 
      returnObject.setXLocation_ID(getString (rs, 10)); 
      returnObject.setXLocation_Name(getString (rs, 11)); 
      returnObject.setXPhone(getString (rs, 12)); 
      returnObject.setXPhone_Ext(getString (rs, 13)); 
      returnObject.setXSecondary_Phone(getString (rs, 14)); 
      returnObject.setXSec_Phone_Ext(getString (rs, 15)); 
      returnObject.setXFax(getString (rs, 16)); 
      returnObject.setXTax_ID_Number(getString (rs, 17)); 
      returnObject.setXNewport_Key(getString (rs, 18)); 
      returnObject.setXDeactivation_Flag(getString (rs, 19)); 
      returnObject.setXActivation_Date(getTimestamp (rs, 20)); 
      returnObject.setXDeactivation_Date(getTimestamp (rs, 21)); 
      returnObject.setXTax_ID_Number_Source(getString (rs, 22)); 
      returnObject.setXTax_ID_Number_LastVerifiedDate(getTimestamp (rs, 23)); 
      returnObject.setXNewport_Key_Source(getString (rs, 24)); 
      returnObject.setXNewport_Key_LastVerifiedDate(getTimestamp (rs, 25)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 26)); 
      returnObject.setLastUpdateUser(getString (rs, 27)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 28)); 
    
      return returnObject;
    }
  }

  /**
   * @Select( sql="SELECT r.H_ADDRESS_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_COUNTY X_COUNTY, r.X_HOSPITAL X_HOSPITAL, r.X_FACILITY_NAME X_FACILITY_NAME, r.X_FACILITY_CODE X_FACILITY_CODE, r.X_DEPARTMENT_CODE X_DEPARTMENT_CODE, r.X_DEPARTMENT_DESCRIPTION X_DEPARTMENT_DESCRIPTION, r.X_LOCATION_CODE X_LOCATION_CODE, r.X_LOCATION_DESCRIPTION X_LOCATION_DESCRIPTION, r.X_LOCATION_MNEMONIC X_LOCATION_MNEMONIC, r.X_LOCATION_ID X_LOCATION_ID, r.X_LOCATION_NAME X_LOCATION_NAME, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.X_TAX_ID_NUMBER X_TAX_ID_NUMBER, r.X_NEWPORT_KEY X_NEWPORT_KEY, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_ACTIVATION_DATE X_ACTIVATION_DATE, r.X_DEACTIVATION_DATE X_DEACTIVATION_DATE, r.X_TAX_ID_NUMBER_SOURCE X_TAX_ID_NUMBER_SOURCE, r.X_TAX_ID_LASTVERIFIEDDATE X_TAX_ID_LASTVERIFIEDDATE, r.X_NEWPORT_KEY_SOURCE X_NEWPORT_KEY_SOURCE, r.X_NEWPORT_KEY_LASTVERIFIEDDATE X_NEWPORT_KEY_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_ADDRESS r WHERE r.H_ADDRESS_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))", pattern="tableAlias (ADDRESS => mdmnw.entityObject.EObjxNWAddressExt, H_ADDRESS => mdmnw.entityObject.EObjxNWAddressExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWAddressExt> getxNWAddressHistory (Object[] parameters)
  {
    return queryIterator (getxNWAddressHistoryStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWAddressHistoryStatementDescriptor = createStatementDescriptor (
    "getxNWAddressHistory(Object[])",
    "SELECT r.H_ADDRESS_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_COUNTY X_COUNTY, r.X_HOSPITAL X_HOSPITAL, r.X_FACILITY_NAME X_FACILITY_NAME, r.X_FACILITY_CODE X_FACILITY_CODE, r.X_DEPARTMENT_CODE X_DEPARTMENT_CODE, r.X_DEPARTMENT_DESCRIPTION X_DEPARTMENT_DESCRIPTION, r.X_LOCATION_CODE X_LOCATION_CODE, r.X_LOCATION_DESCRIPTION X_LOCATION_DESCRIPTION, r.X_LOCATION_MNEMONIC X_LOCATION_MNEMONIC, r.X_LOCATION_ID X_LOCATION_ID, r.X_LOCATION_NAME X_LOCATION_NAME, r.X_PHONE X_PHONE, r.X_PHONE_EXT X_PHONE_EXT, r.X_SECONDARY_PHONE X_SECONDARY_PHONE, r.X_SEC_PHONE_EXT X_SEC_PHONE_EXT, r.X_FAX X_FAX, r.X_TAX_ID_NUMBER X_TAX_ID_NUMBER, r.X_NEWPORT_KEY X_NEWPORT_KEY, r.X_DEACTIVATION_FLAG X_DEACTIVATION_FLAG, r.X_ACTIVATION_DATE X_ACTIVATION_DATE, r.X_DEACTIVATION_DATE X_DEACTIVATION_DATE, r.X_TAX_ID_NUMBER_SOURCE X_TAX_ID_NUMBER_SOURCE, r.X_TAX_ID_LASTVERIFIEDDATE X_TAX_ID_LASTVERIFIEDDATE, r.X_NEWPORT_KEY_SOURCE X_NEWPORT_KEY_SOURCE, r.X_NEWPORT_KEY_LASTVERIFIEDDATE X_NEWPORT_KEY_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_ADDRESS r WHERE r.H_ADDRESS_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"historyidpk", "h_action_code", "h_created_by", "h_create_dt", "h_end_dt", "x_county", "x_hospital", "x_facility_name", "x_facility_code", "x_department_code", "x_department_description", "x_location_code", "x_location_description", "x_location_mnemonic", "x_location_id", "x_location_name", "x_phone", "x_phone_ext", "x_secondary_phone", "x_sec_phone_ext", "x_fax", "x_tax_id_number", "x_newport_key", "x_deactivation_flag", "x_activation_date", "x_deactivation_date", "x_tax_id_number_source", "x_tax_id_lastverifieddate", "x_newport_key_source", "x_newport_key_lastverifieddate", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWAddressHistoryParameterHandler (),
    new int[][]{{Types.BIGINT, Types.TIMESTAMP, Types.TIMESTAMP}, {19, 0, 0}, {0, 0, 0}, {1, 1, 1}},
    null,
    new GetxNWAddressHistoryRowHandler (),
    new int[][]{ {Types.BIGINT, Types.CHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 1, 20, 0, 0, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 0, 250, 0, 250, 0, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetxNWAddressHistoryParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWAddressHistoryRowHandler extends BaseRowHandler<EObjxNWAddressExt>
  {
    /**
     * @generated
     */
    public EObjxNWAddressExt handle (java.sql.ResultSet rs, EObjxNWAddressExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWAddressExt ();
      returnObject.setHistoryIdPK(getLongObject (rs, 1)); 
      returnObject.setHistActionCode(getString (rs, 2)); 
      returnObject.setHistCreatedBy(getString (rs, 3)); 
      returnObject.setHistCreateDt(getTimestamp (rs, 4)); 
      returnObject.setHistEndDt(getTimestamp (rs, 5)); 
      returnObject.setXCounty(getString (rs, 6)); 
      returnObject.setXHospital(getString (rs, 7)); 
      returnObject.setXFacility_Name(getString (rs, 8)); 
      returnObject.setXFacility_Code(getString (rs, 9)); 
      returnObject.setXDepartment_Code(getString (rs, 10)); 
      returnObject.setXDepartment_Description(getString (rs, 11)); 
      returnObject.setXLocation_Code(getString (rs, 12)); 
      returnObject.setXLocation_Description(getString (rs, 13)); 
      returnObject.setXLocation_Mnemonic(getString (rs, 14)); 
      returnObject.setXLocation_ID(getString (rs, 15)); 
      returnObject.setXLocation_Name(getString (rs, 16)); 
      returnObject.setXPhone(getString (rs, 17)); 
      returnObject.setXPhone_Ext(getString (rs, 18)); 
      returnObject.setXSecondary_Phone(getString (rs, 19)); 
      returnObject.setXSec_Phone_Ext(getString (rs, 20)); 
      returnObject.setXFax(getString (rs, 21)); 
      returnObject.setXTax_ID_Number(getString (rs, 22)); 
      returnObject.setXNewport_Key(getString (rs, 23)); 
      returnObject.setXDeactivation_Flag(getString (rs, 24)); 
      returnObject.setXActivation_Date(getTimestamp (rs, 25)); 
      returnObject.setXDeactivation_Date(getTimestamp (rs, 26)); 
      returnObject.setXTax_ID_Number_Source(getString (rs, 27)); 
      returnObject.setXTax_ID_Number_LastVerifiedDate(getTimestamp (rs, 28)); 
      returnObject.setXNewport_Key_Source(getString (rs, 29)); 
      returnObject.setXNewport_Key_LastVerifiedDate(getTimestamp (rs, 30)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 31)); 
      returnObject.setLastUpdateUser(getString (rs, 32)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 33)); 
    
      return returnObject;
    }
  }

}
