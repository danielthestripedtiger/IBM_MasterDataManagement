package mdmnw.entityObject;

import mdmnw.entityObject.EObjxNWAddressExt;
import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import java.sql.PreparedStatement;
import com.ibm.pdq.runtime.statement.StatementDescriptor;
import com.ibm.pdq.runtime.generator.BaseData;
import java.sql.SQLException;
import com.ibm.pdq.annotation.Metadata;
import com.dwl.tcrm.coreParty.entityObject.EObjAddress;
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
public class EObjxNWAddressExtDataImpl  extends BaseData implements EObjxNWAddressExtData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "EObjxNWAddressExtData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001689ac98f0cL;

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
  public EObjxNWAddressExtDataImpl()
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
   * @Select( sql="select X_COUNTY, X_HOSPITAL, X_FACILITY_NAME, X_FACILITY_CODE, X_DEPARTMENT_CODE, X_DEPARTMENT_DESCRIPTION, X_LOCATION_CODE, X_LOCATION_DESCRIPTION, X_LOCATION_MNEMONIC, X_LOCATION_ID, X_LOCATION_NAME, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, X_TAX_ID_NUMBER, X_NEWPORT_KEY, X_DEACTIVATION_FLAG, X_ACTIVATION_DATE, X_DEACTIVATION_DATE, X_TAX_ID_NUMBER_SOURCE, X_TAX_ID_LASTVERIFIEDDATE, X_NEWPORT_KEY_SOURCE, X_NEWPORT_KEY_LASTVERIFIEDDATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from ADDRESS where ADDRESS_ID = ? " )
   * 
   * @generated
   */
  public Iterator<EObjxNWAddressExt> getEObjxNWAddressExt (Long addressIdPK)
  {
    return queryIterator (getEObjxNWAddressExtStatementDescriptor, addressIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getEObjxNWAddressExtStatementDescriptor = createStatementDescriptor (
    "getEObjxNWAddressExt(Long)",
    "select X_COUNTY, X_HOSPITAL, X_FACILITY_NAME, X_FACILITY_CODE, X_DEPARTMENT_CODE, X_DEPARTMENT_DESCRIPTION, X_LOCATION_CODE, X_LOCATION_DESCRIPTION, X_LOCATION_MNEMONIC, X_LOCATION_ID, X_LOCATION_NAME, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, X_TAX_ID_NUMBER, X_NEWPORT_KEY, X_DEACTIVATION_FLAG, X_ACTIVATION_DATE, X_DEACTIVATION_DATE, X_TAX_ID_NUMBER_SOURCE, X_TAX_ID_LASTVERIFIEDDATE, X_NEWPORT_KEY_SOURCE, X_NEWPORT_KEY_LASTVERIFIEDDATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from ADDRESS where ADDRESS_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_county", "x_hospital", "x_facility_name", "x_facility_code", "x_department_code", "x_department_description", "x_location_code", "x_location_description", "x_location_mnemonic", "x_location_id", "x_location_name", "x_phone", "x_phone_ext", "x_secondary_phone", "x_sec_phone_ext", "x_fax", "x_tax_id_number", "x_newport_key", "x_deactivation_flag", "x_activation_date", "x_deactivation_date", "x_tax_id_number_source", "x_tax_id_lastverifieddate", "x_newport_key_source", "x_newport_key_lastverifieddate", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetEObjxNWAddressExtParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetEObjxNWAddressExtRowHandler (),
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
  public static class GetEObjxNWAddressExtParameterHandler extends BaseParameterHandler 
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
  public static class GetEObjxNWAddressExtRowHandler extends BaseRowHandler<EObjxNWAddressExt>
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
   * @Update( sql="insert into ADDRESS (POSTAL_BARCODE, ADDR_LINE_ONE, ADDR_LINE_THREE, ADDR_LINE_TWO, CITY_NAME, COUNTY_CODE, LATITUDE_DEGREES, LONGITUDE_DEGREES, RESIDENCE_NUM, ADDR_STANDARD_IND, OVERRIDE_IND, POSTAL_CODE, ADDRESS_ID, BOX_ID, BUILDING_NAME, STREET_NUMBER, STREET_NAME, STREET_SUFFIX, PRE_DIRECTIONAL, POST_DIRECTIONAL, BOX_DESIGNATOR, STN_INFO, STN_ID, REGION, DEL_DESIGNATOR, DEL_ID, DEL_INFO, COUNTRY_TP_CD, PROV_STATE_TP_CD, RESIDENCE_TP_CD, P_CITY, P_STREET_NAME, STREET_PREFIX, P_ADDR_LINE_ONE, P_ADDR_LINE_THREE, P_ADDR_LINE_TWO, X_COUNTY, X_HOSPITAL, X_FACILITY_NAME, X_FACILITY_CODE, X_DEPARTMENT_CODE, X_DEPARTMENT_DESCRIPTION, X_LOCATION_CODE, X_LOCATION_DESCRIPTION, X_LOCATION_MNEMONIC, X_LOCATION_ID, X_LOCATION_NAME, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, X_TAX_ID_NUMBER, X_NEWPORT_KEY, X_DEACTIVATION_FLAG, X_ACTIVATION_DATE, X_DEACTIVATION_DATE, X_TAX_ID_NUMBER_SOURCE, X_TAX_ID_LASTVERIFIEDDATE, X_NEWPORT_KEY_SOURCE, X_NEWPORT_KEY_LASTVERIFIEDDATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.postalBarCode, ?1.addrLineOne, ?1.addrLineThree, ?1.addrLineTwo, ?1.cityName, ?1.countyCode, ?1.latitudeDegrees, ?1.longtitudeDegrees, ?1.residenceNum, ?1.addrStandardInd, ?1.overrideInd, ?1.postalCode, ?1.addressIdPK, ?1.boxId, ?1.buildingName, ?1.streetNumber, ?1.streetName, ?1.streetSuffix, ?1.preDirectional, ?1.postDirectional, ?1.boxDesignator, ?1.stnInfo, ?1.stnId, ?1.region, ?1.delDesignator, ?1.delId, ?1.delInfo, ?1.countryTpCd, ?1.provStateTpCd, ?1.residenceTpCd, ?1.pCityName, ?1.pStreetName, ?1.streetPrefix, ?1.pAddrLineOne, ?1.pAddrLineThree, ?1.pAddrLineTwo, ?2.xCounty, ?2.xHospital, ?2.xFacility_Name, ?2.xFacility_Code, ?2.xDepartment_Code, ?2.xDepartment_Description, ?2.xLocation_Code, ?2.xLocation_Description, ?2.xLocation_Mnemonic, ?2.xLocation_ID, ?2.xLocation_Name, ?2.xPhone, ?2.xPhone_Ext, ?2.xSecondary_Phone, ?2.xSec_Phone_Ext, ?2.xFax, ?2.xTax_ID_Number, ?2.xNewport_Key, ?2.xDeactivation_Flag, ?2.xActivation_Date, ?2.xDeactivation_Date, ?2.xTax_ID_Number_Source, ?2.xTax_ID_Number_LastVerifiedDate, ?2.xNewport_Key_Source, ?2.xNewport_Key_LastVerifiedDate, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)" )
   * 
   * @generated
   */
  public int createEObjxNWAddressExt (EObjAddress e1, EObjxNWAddressExt e2)
  {
    return update (createEObjxNWAddressExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor createEObjxNWAddressExtStatementDescriptor = createStatementDescriptor (
    "createEObjxNWAddressExt(com.dwl.tcrm.coreParty.entityObject.EObjAddress, mdmnw.entityObject.EObjxNWAddressExt)",
    "insert into ADDRESS (POSTAL_BARCODE, ADDR_LINE_ONE, ADDR_LINE_THREE, ADDR_LINE_TWO, CITY_NAME, COUNTY_CODE, LATITUDE_DEGREES, LONGITUDE_DEGREES, RESIDENCE_NUM, ADDR_STANDARD_IND, OVERRIDE_IND, POSTAL_CODE, ADDRESS_ID, BOX_ID, BUILDING_NAME, STREET_NUMBER, STREET_NAME, STREET_SUFFIX, PRE_DIRECTIONAL, POST_DIRECTIONAL, BOX_DESIGNATOR, STN_INFO, STN_ID, REGION, DEL_DESIGNATOR, DEL_ID, DEL_INFO, COUNTRY_TP_CD, PROV_STATE_TP_CD, RESIDENCE_TP_CD, P_CITY, P_STREET_NAME, STREET_PREFIX, P_ADDR_LINE_ONE, P_ADDR_LINE_THREE, P_ADDR_LINE_TWO, X_COUNTY, X_HOSPITAL, X_FACILITY_NAME, X_FACILITY_CODE, X_DEPARTMENT_CODE, X_DEPARTMENT_DESCRIPTION, X_LOCATION_CODE, X_LOCATION_DESCRIPTION, X_LOCATION_MNEMONIC, X_LOCATION_ID, X_LOCATION_NAME, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, X_TAX_ID_NUMBER, X_NEWPORT_KEY, X_DEACTIVATION_FLAG, X_ACTIVATION_DATE, X_DEACTIVATION_DATE, X_TAX_ID_NUMBER_SOURCE, X_TAX_ID_LASTVERIFIEDDATE, X_NEWPORT_KEY_SOURCE, X_NEWPORT_KEY_LASTVERIFIEDDATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values(  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.INSERT,
    null,
    new CreateEObjxNWAddressExtParameterHandler (),
    new int[][]{{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.VARCHAR, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {30, 100, 100, 100, 50, 3, 10, 10, 10, 1, 1, 20, 19, 16, 64, 16, 64, 16, 16, 16, 16, 16, 16, 32, 16, 16, 50, 19, 19, 19, 20, 30, 16, 8, 8, 8, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 0, 250, 0, 250, 0, 0, 0, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class CreateEObjxNWAddressExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjAddress bean0 = (EObjAddress) parameters[0];
      setString (stmt, 1, Types.VARCHAR, (String)bean0.getPostalBarCode());
      setString (stmt, 2, Types.VARCHAR, (String)bean0.getAddrLineOne());
      setString (stmt, 3, Types.VARCHAR, (String)bean0.getAddrLineThree());
      setString (stmt, 4, Types.VARCHAR, (String)bean0.getAddrLineTwo());
      setString (stmt, 5, Types.VARCHAR, (String)bean0.getCityName());
      setString (stmt, 6, Types.CHAR, (String)bean0.getCountyCode());
      setString (stmt, 7, Types.VARCHAR, (String)bean0.getLatitudeDegrees());
      setString (stmt, 8, Types.VARCHAR, (String)bean0.getLongtitudeDegrees());
      setString (stmt, 9, Types.VARCHAR, (String)bean0.getResidenceNum());
      setString (stmt, 10, Types.CHAR, (String)bean0.getAddrStandardInd());
      setString (stmt, 11, Types.CHAR, (String)bean0.getOverrideInd());
      setString (stmt, 12, Types.VARCHAR, (String)bean0.getPostalCode());
      setLong (stmt, 13, Types.BIGINT, (Long)bean0.getAddressIdPK());
      setString (stmt, 14, Types.VARCHAR, (String)bean0.getBoxId());
      setString (stmt, 15, Types.VARCHAR, (String)bean0.getBuildingName());
      setString (stmt, 16, Types.VARCHAR, (String)bean0.getStreetNumber());
      setString (stmt, 17, Types.VARCHAR, (String)bean0.getStreetName());
      setString (stmt, 18, Types.VARCHAR, (String)bean0.getStreetSuffix());
      setString (stmt, 19, Types.VARCHAR, (String)bean0.getPreDirectional());
      setString (stmt, 20, Types.VARCHAR, (String)bean0.getPostDirectional());
      setString (stmt, 21, Types.VARCHAR, (String)bean0.getBoxDesignator());
      setString (stmt, 22, Types.VARCHAR, (String)bean0.getStnInfo());
      setString (stmt, 23, Types.VARCHAR, (String)bean0.getStnId());
      setString (stmt, 24, Types.VARCHAR, (String)bean0.getRegion());
      setString (stmt, 25, Types.VARCHAR, (String)bean0.getDelDesignator());
      setString (stmt, 26, Types.VARCHAR, (String)bean0.getDelId());
      setString (stmt, 27, Types.VARCHAR, (String)bean0.getDelInfo());
      setLong (stmt, 28, Types.BIGINT, (Long)bean0.getCountryTpCd());
      setLong (stmt, 29, Types.BIGINT, (Long)bean0.getProvStateTpCd());
      setLong (stmt, 30, Types.BIGINT, (Long)bean0.getResidenceTpCd());
      setString (stmt, 31, Types.VARCHAR, (String)bean0.getPCityName());
      setString (stmt, 32, Types.VARCHAR, (String)bean0.getPStreetName());
      setString (stmt, 33, Types.VARCHAR, (String)bean0.getStreetPrefix());
      setString (stmt, 34, Types.CHAR, (String)bean0.getPAddrLineOne());
      setString (stmt, 35, Types.CHAR, (String)bean0.getPAddrLineThree());
      setString (stmt, 36, Types.CHAR, (String)bean0.getPAddrLineTwo());
      EObjxNWAddressExt bean1 = (EObjxNWAddressExt) parameters[1];
      setString (stmt, 37, Types.VARCHAR, (String)bean1.getXCounty());
      setString (stmt, 38, Types.VARCHAR, (String)bean1.getXHospital());
      setString (stmt, 39, Types.VARCHAR, (String)bean1.getXFacility_Name());
      setString (stmt, 40, Types.VARCHAR, (String)bean1.getXFacility_Code());
      setString (stmt, 41, Types.VARCHAR, (String)bean1.getXDepartment_Code());
      setString (stmt, 42, Types.VARCHAR, (String)bean1.getXDepartment_Description());
      setString (stmt, 43, Types.VARCHAR, (String)bean1.getXLocation_Code());
      setString (stmt, 44, Types.VARCHAR, (String)bean1.getXLocation_Description());
      setString (stmt, 45, Types.VARCHAR, (String)bean1.getXLocation_Mnemonic());
      setString (stmt, 46, Types.VARCHAR, (String)bean1.getXLocation_ID());
      setString (stmt, 47, Types.VARCHAR, (String)bean1.getXLocation_Name());
      setString (stmt, 48, Types.VARCHAR, (String)bean1.getXPhone());
      setString (stmt, 49, Types.VARCHAR, (String)bean1.getXPhone_Ext());
      setString (stmt, 50, Types.VARCHAR, (String)bean1.getXSecondary_Phone());
      setString (stmt, 51, Types.VARCHAR, (String)bean1.getXSec_Phone_Ext());
      setString (stmt, 52, Types.VARCHAR, (String)bean1.getXFax());
      setString (stmt, 53, Types.VARCHAR, (String)bean1.getXTax_ID_Number());
      setString (stmt, 54, Types.VARCHAR, (String)bean1.getXNewport_Key());
      setString (stmt, 55, Types.VARCHAR, (String)bean1.getXDeactivation_Flag());
      setTimestamp (stmt, 56, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXActivation_Date());
      setTimestamp (stmt, 57, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXDeactivation_Date());
      setString (stmt, 58, Types.VARCHAR, (String)bean1.getXTax_ID_Number_Source());
      setTimestamp (stmt, 59, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXTax_ID_Number_LastVerifiedDate());
      setString (stmt, 60, Types.VARCHAR, (String)bean1.getXNewport_Key_Source());
      setTimestamp (stmt, 61, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXNewport_Key_LastVerifiedDate());
      setTimestamp (stmt, 62, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 63, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 64, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
    }
  }

  /**
   * @Update( sql="update ADDRESS set POSTAL_BARCODE = ?1.postalBarCode, ADDR_LINE_ONE = ?1.addrLineOne, ADDR_LINE_THREE = ?1.addrLineThree, ADDR_LINE_TWO = ?1.addrLineTwo, CITY_NAME = ?1.cityName, COUNTY_CODE = ?1.countyCode, LATITUDE_DEGREES = ?1.latitudeDegrees, LONGITUDE_DEGREES = ?1.longtitudeDegrees, RESIDENCE_NUM = ?1.residenceNum, ADDR_STANDARD_IND = ?1.addrStandardInd, OVERRIDE_IND = ?1.overrideInd, POSTAL_CODE = ?1.postalCode, BOX_ID = ?1.boxId, BUILDING_NAME = ?1.buildingName, STREET_NUMBER = ?1.streetNumber, STREET_NAME = ?1.streetName, STREET_SUFFIX = ?1.streetSuffix, PRE_DIRECTIONAL = ?1.preDirectional, POST_DIRECTIONAL = ?1.postDirectional, BOX_DESIGNATOR = ?1.boxDesignator, STN_INFO = ?1.stnInfo, STN_ID = ?1.stnId, REGION = ?1.region, DEL_DESIGNATOR = ?1.delDesignator, DEL_ID = ?1.delId, DEL_INFO = ?1.delInfo, COUNTRY_TP_CD = ?1.countryTpCd, PROV_STATE_TP_CD = ?1.provStateTpCd, RESIDENCE_TP_CD = ?1.residenceTpCd, P_CITY = ?1.pCityName, P_STREET_NAME = ?1.pStreetName, STREET_PREFIX = ?1.streetPrefix, P_ADDR_LINE_ONE = ?1.pAddrLineOne, P_ADDR_LINE_THREE = ?1.pAddrLineThree, P_ADDR_LINE_TWO = ?1.pAddrLineTwo, X_COUNTY = ?2.xCounty, X_HOSPITAL = ?2.xHospital, X_FACILITY_NAME = ?2.xFacility_Name, X_FACILITY_CODE = ?2.xFacility_Code, X_DEPARTMENT_CODE = ?2.xDepartment_Code, X_DEPARTMENT_DESCRIPTION = ?2.xDepartment_Description, X_LOCATION_CODE = ?2.xLocation_Code, X_LOCATION_DESCRIPTION = ?2.xLocation_Description, X_LOCATION_MNEMONIC = ?2.xLocation_Mnemonic, X_LOCATION_ID = ?2.xLocation_ID, X_LOCATION_NAME = ?2.xLocation_Name, X_PHONE = ?2.xPhone, X_PHONE_EXT = ?2.xPhone_Ext, X_SECONDARY_PHONE = ?2.xSecondary_Phone, X_SEC_PHONE_EXT = ?2.xSec_Phone_Ext, X_FAX = ?2.xFax, X_TAX_ID_NUMBER = ?2.xTax_ID_Number, X_NEWPORT_KEY = ?2.xNewport_Key, X_DEACTIVATION_FLAG = ?2.xDeactivation_Flag, X_ACTIVATION_DATE = ?2.xActivation_Date, X_DEACTIVATION_DATE = ?2.xDeactivation_Date, X_TAX_ID_NUMBER_SOURCE = ?2.xTax_ID_Number_Source, X_TAX_ID_LASTVERIFIEDDATE = ?2.xTax_ID_Number_LastVerifiedDate, X_NEWPORT_KEY_SOURCE = ?2.xNewport_Key_Source, X_NEWPORT_KEY_LASTVERIFIEDDATE = ?2.xNewport_Key_LastVerifiedDate, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where ADDRESS_ID = ?1.addressIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt" )
   * 
   * @generated
   */
  public int updateEObjxNWAddressExt (EObjAddress e1, EObjxNWAddressExt e2)
  {
    return update (updateEObjxNWAddressExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor updateEObjxNWAddressExtStatementDescriptor = createStatementDescriptor (
    "updateEObjxNWAddressExt(com.dwl.tcrm.coreParty.entityObject.EObjAddress, mdmnw.entityObject.EObjxNWAddressExt)",
    "update ADDRESS set POSTAL_BARCODE =  ? , ADDR_LINE_ONE =  ? , ADDR_LINE_THREE =  ? , ADDR_LINE_TWO =  ? , CITY_NAME =  ? , COUNTY_CODE =  ? , LATITUDE_DEGREES =  ? , LONGITUDE_DEGREES =  ? , RESIDENCE_NUM =  ? , ADDR_STANDARD_IND =  ? , OVERRIDE_IND =  ? , POSTAL_CODE =  ? , BOX_ID =  ? , BUILDING_NAME =  ? , STREET_NUMBER =  ? , STREET_NAME =  ? , STREET_SUFFIX =  ? , PRE_DIRECTIONAL =  ? , POST_DIRECTIONAL =  ? , BOX_DESIGNATOR =  ? , STN_INFO =  ? , STN_ID =  ? , REGION =  ? , DEL_DESIGNATOR =  ? , DEL_ID =  ? , DEL_INFO =  ? , COUNTRY_TP_CD =  ? , PROV_STATE_TP_CD =  ? , RESIDENCE_TP_CD =  ? , P_CITY =  ? , P_STREET_NAME =  ? , STREET_PREFIX =  ? , P_ADDR_LINE_ONE =  ? , P_ADDR_LINE_THREE =  ? , P_ADDR_LINE_TWO =  ? , X_COUNTY =  ? , X_HOSPITAL =  ? , X_FACILITY_NAME =  ? , X_FACILITY_CODE =  ? , X_DEPARTMENT_CODE =  ? , X_DEPARTMENT_DESCRIPTION =  ? , X_LOCATION_CODE =  ? , X_LOCATION_DESCRIPTION =  ? , X_LOCATION_MNEMONIC =  ? , X_LOCATION_ID =  ? , X_LOCATION_NAME =  ? , X_PHONE =  ? , X_PHONE_EXT =  ? , X_SECONDARY_PHONE =  ? , X_SEC_PHONE_EXT =  ? , X_FAX =  ? , X_TAX_ID_NUMBER =  ? , X_NEWPORT_KEY =  ? , X_DEACTIVATION_FLAG =  ? , X_ACTIVATION_DATE =  ? , X_DEACTIVATION_DATE =  ? , X_TAX_ID_NUMBER_SOURCE =  ? , X_TAX_ID_LASTVERIFIEDDATE =  ? , X_NEWPORT_KEY_SOURCE =  ? , X_NEWPORT_KEY_LASTVERIFIEDDATE =  ? , LAST_UPDATE_DT =  ? , LAST_UPDATE_USER =  ? , LAST_UPDATE_TX_ID =  ?  where ADDRESS_ID =  ?  and LAST_UPDATE_DT =  ? ",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.UPDATE,
    null,
    new UpdateEObjxNWAddressExtParameterHandler (),
    new int[][]{{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.CHAR, Types.CHAR, Types.CHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.TIMESTAMP}, {30, 100, 100, 100, 50, 3, 10, 10, 10, 1, 1, 20, 16, 64, 16, 64, 16, 16, 16, 16, 16, 16, 32, 16, 16, 50, 19, 19, 19, 20, 30, 16, 8, 8, 8, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 0, 0, 250, 0, 250, 0, 0, 0, 19, 19, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class UpdateEObjxNWAddressExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjAddress bean0 = (EObjAddress) parameters[0];
      setString (stmt, 1, Types.VARCHAR, (String)bean0.getPostalBarCode());
      setString (stmt, 2, Types.VARCHAR, (String)bean0.getAddrLineOne());
      setString (stmt, 3, Types.VARCHAR, (String)bean0.getAddrLineThree());
      setString (stmt, 4, Types.VARCHAR, (String)bean0.getAddrLineTwo());
      setString (stmt, 5, Types.VARCHAR, (String)bean0.getCityName());
      setString (stmt, 6, Types.CHAR, (String)bean0.getCountyCode());
      setString (stmt, 7, Types.VARCHAR, (String)bean0.getLatitudeDegrees());
      setString (stmt, 8, Types.VARCHAR, (String)bean0.getLongtitudeDegrees());
      setString (stmt, 9, Types.VARCHAR, (String)bean0.getResidenceNum());
      setString (stmt, 10, Types.CHAR, (String)bean0.getAddrStandardInd());
      setString (stmt, 11, Types.CHAR, (String)bean0.getOverrideInd());
      setString (stmt, 12, Types.VARCHAR, (String)bean0.getPostalCode());
      setString (stmt, 13, Types.VARCHAR, (String)bean0.getBoxId());
      setString (stmt, 14, Types.VARCHAR, (String)bean0.getBuildingName());
      setString (stmt, 15, Types.VARCHAR, (String)bean0.getStreetNumber());
      setString (stmt, 16, Types.VARCHAR, (String)bean0.getStreetName());
      setString (stmt, 17, Types.VARCHAR, (String)bean0.getStreetSuffix());
      setString (stmt, 18, Types.VARCHAR, (String)bean0.getPreDirectional());
      setString (stmt, 19, Types.VARCHAR, (String)bean0.getPostDirectional());
      setString (stmt, 20, Types.VARCHAR, (String)bean0.getBoxDesignator());
      setString (stmt, 21, Types.VARCHAR, (String)bean0.getStnInfo());
      setString (stmt, 22, Types.VARCHAR, (String)bean0.getStnId());
      setString (stmt, 23, Types.VARCHAR, (String)bean0.getRegion());
      setString (stmt, 24, Types.VARCHAR, (String)bean0.getDelDesignator());
      setString (stmt, 25, Types.VARCHAR, (String)bean0.getDelId());
      setString (stmt, 26, Types.VARCHAR, (String)bean0.getDelInfo());
      setLong (stmt, 27, Types.BIGINT, (Long)bean0.getCountryTpCd());
      setLong (stmt, 28, Types.BIGINT, (Long)bean0.getProvStateTpCd());
      setLong (stmt, 29, Types.BIGINT, (Long)bean0.getResidenceTpCd());
      setString (stmt, 30, Types.VARCHAR, (String)bean0.getPCityName());
      setString (stmt, 31, Types.VARCHAR, (String)bean0.getPStreetName());
      setString (stmt, 32, Types.VARCHAR, (String)bean0.getStreetPrefix());
      setString (stmt, 33, Types.CHAR, (String)bean0.getPAddrLineOne());
      setString (stmt, 34, Types.CHAR, (String)bean0.getPAddrLineThree());
      setString (stmt, 35, Types.CHAR, (String)bean0.getPAddrLineTwo());
      EObjxNWAddressExt bean1 = (EObjxNWAddressExt) parameters[1];
      setString (stmt, 36, Types.VARCHAR, (String)bean1.getXCounty());
      setString (stmt, 37, Types.VARCHAR, (String)bean1.getXHospital());
      setString (stmt, 38, Types.VARCHAR, (String)bean1.getXFacility_Name());
      setString (stmt, 39, Types.VARCHAR, (String)bean1.getXFacility_Code());
      setString (stmt, 40, Types.VARCHAR, (String)bean1.getXDepartment_Code());
      setString (stmt, 41, Types.VARCHAR, (String)bean1.getXDepartment_Description());
      setString (stmt, 42, Types.VARCHAR, (String)bean1.getXLocation_Code());
      setString (stmt, 43, Types.VARCHAR, (String)bean1.getXLocation_Description());
      setString (stmt, 44, Types.VARCHAR, (String)bean1.getXLocation_Mnemonic());
      setString (stmt, 45, Types.VARCHAR, (String)bean1.getXLocation_ID());
      setString (stmt, 46, Types.VARCHAR, (String)bean1.getXLocation_Name());
      setString (stmt, 47, Types.VARCHAR, (String)bean1.getXPhone());
      setString (stmt, 48, Types.VARCHAR, (String)bean1.getXPhone_Ext());
      setString (stmt, 49, Types.VARCHAR, (String)bean1.getXSecondary_Phone());
      setString (stmt, 50, Types.VARCHAR, (String)bean1.getXSec_Phone_Ext());
      setString (stmt, 51, Types.VARCHAR, (String)bean1.getXFax());
      setString (stmt, 52, Types.VARCHAR, (String)bean1.getXTax_ID_Number());
      setString (stmt, 53, Types.VARCHAR, (String)bean1.getXNewport_Key());
      setString (stmt, 54, Types.VARCHAR, (String)bean1.getXDeactivation_Flag());
      setTimestamp (stmt, 55, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXActivation_Date());
      setTimestamp (stmt, 56, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXDeactivation_Date());
      setString (stmt, 57, Types.VARCHAR, (String)bean1.getXTax_ID_Number_Source());
      setTimestamp (stmt, 58, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXTax_ID_Number_LastVerifiedDate());
      setString (stmt, 59, Types.VARCHAR, (String)bean1.getXNewport_Key_Source());
      setTimestamp (stmt, 60, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXNewport_Key_LastVerifiedDate());
      setTimestamp (stmt, 61, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 62, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 63, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
      setLong (stmt, 64, Types.BIGINT, (Long)bean0.getAddressIdPK());
      setTimestamp (stmt, 65, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getOldLastUpdateDt());
    }
  }

  /**
   * @Update( sql="delete from ADDRESS where ADDRESS_ID = ?" )
   * 
   * @generated
   */
  public int deleteEObjxNWAddressExt (Long addressIdPK)
  {
    return update (deleteEObjxNWAddressExtStatementDescriptor, addressIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor deleteEObjxNWAddressExtStatementDescriptor = createStatementDescriptor (
    "deleteEObjxNWAddressExt(Long)",
    "delete from ADDRESS where ADDRESS_ID = ?",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.DELETE,
    null,
    new DeleteEObjxNWAddressExtParameterHandler (),
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
  public static class DeleteEObjxNWAddressExtParameterHandler extends BaseParameterHandler 
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
