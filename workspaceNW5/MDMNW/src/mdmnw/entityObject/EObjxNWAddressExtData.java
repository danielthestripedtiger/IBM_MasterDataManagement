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
 * IBM-MDMWB-1.0-[82a4dd706d185c74b9d0eeee838e5e4f]
 */


package mdmnw.entityObject;

import java.util.Iterator;
import com.ibm.mdm.base.db.EntityMapping;
import com.ibm.pdq.annotation.Select;
import com.ibm.pdq.annotation.Update;

import com.dwl.tcrm.coreParty.entityObject.EObjAddress;

import mdmnw.entityObject.EObjxNWAddressExt;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public interface EObjxNWAddressExtData {


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getEObjxNWAddressExtSql = "select X_COUNTY, X_HOSPITAL, X_FACILITY_NAME, X_FACILITY_CODE, X_DEPARTMENT_CODE, X_DEPARTMENT_DESCRIPTION, X_LOCATION_CODE, X_LOCATION_DESCRIPTION, X_LOCATION_MNEMONIC, X_LOCATION_ID, X_LOCATION_NAME, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, X_TAX_ID_NUMBER, X_NEWPORT_KEY, X_DEACTIVATION_FLAG, X_ACTIVATION_DATE, X_DEACTIVATION_DATE, X_TAX_ID_NUMBER_SOURCE, X_TAX_ID_LASTVERIFIEDDATE, X_NEWPORT_KEY_SOURCE, X_NEWPORT_KEY_LASTVERIFIEDDATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from ADDRESS where ADDRESS_ID = ? ";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String createEObjxNWAddressExtSql = "insert into ADDRESS (POSTAL_BARCODE, ADDR_LINE_ONE, ADDR_LINE_THREE, ADDR_LINE_TWO, CITY_NAME, COUNTY_CODE, LATITUDE_DEGREES, LONGITUDE_DEGREES, RESIDENCE_NUM, ADDR_STANDARD_IND, OVERRIDE_IND, POSTAL_CODE, ADDRESS_ID, BOX_ID, BUILDING_NAME, STREET_NUMBER, STREET_NAME, STREET_SUFFIX, PRE_DIRECTIONAL, POST_DIRECTIONAL, BOX_DESIGNATOR, STN_INFO, STN_ID, REGION, DEL_DESIGNATOR, DEL_ID, DEL_INFO, COUNTRY_TP_CD, PROV_STATE_TP_CD, RESIDENCE_TP_CD, P_CITY, P_STREET_NAME, STREET_PREFIX, P_ADDR_LINE_ONE, P_ADDR_LINE_THREE, P_ADDR_LINE_TWO, X_COUNTY, X_HOSPITAL, X_FACILITY_NAME, X_FACILITY_CODE, X_DEPARTMENT_CODE, X_DEPARTMENT_DESCRIPTION, X_LOCATION_CODE, X_LOCATION_DESCRIPTION, X_LOCATION_MNEMONIC, X_LOCATION_ID, X_LOCATION_NAME, X_PHONE, X_PHONE_EXT, X_SECONDARY_PHONE, X_SEC_PHONE_EXT, X_FAX, X_TAX_ID_NUMBER, X_NEWPORT_KEY, X_DEACTIVATION_FLAG, X_ACTIVATION_DATE, X_DEACTIVATION_DATE, X_TAX_ID_NUMBER_SOURCE, X_TAX_ID_LASTVERIFIEDDATE, X_NEWPORT_KEY_SOURCE, X_NEWPORT_KEY_LASTVERIFIEDDATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.postalBarCode, ?1.addrLineOne, ?1.addrLineThree, ?1.addrLineTwo, ?1.cityName, ?1.countyCode, ?1.latitudeDegrees, ?1.longtitudeDegrees, ?1.residenceNum, ?1.addrStandardInd, ?1.overrideInd, ?1.postalCode, ?1.addressIdPK, ?1.boxId, ?1.buildingName, ?1.streetNumber, ?1.streetName, ?1.streetSuffix, ?1.preDirectional, ?1.postDirectional, ?1.boxDesignator, ?1.stnInfo, ?1.stnId, ?1.region, ?1.delDesignator, ?1.delId, ?1.delInfo, ?1.countryTpCd, ?1.provStateTpCd, ?1.residenceTpCd, ?1.pCityName, ?1.pStreetName, ?1.streetPrefix, ?1.pAddrLineOne, ?1.pAddrLineThree, ?1.pAddrLineTwo, ?2.xCounty, ?2.xHospital, ?2.xFacility_Name, ?2.xFacility_Code, ?2.xDepartment_Code, ?2.xDepartment_Description, ?2.xLocation_Code, ?2.xLocation_Description, ?2.xLocation_Mnemonic, ?2.xLocation_ID, ?2.xLocation_Name, ?2.xPhone, ?2.xPhone_Ext, ?2.xSecondary_Phone, ?2.xSec_Phone_Ext, ?2.xFax, ?2.xTax_ID_Number, ?2.xNewport_Key, ?2.xDeactivation_Flag, ?2.xActivation_Date, ?2.xDeactivation_Date, ?2.xTax_ID_Number_Source, ?2.xTax_ID_Number_LastVerifiedDate, ?2.xNewport_Key_Source, ?2.xNewport_Key_LastVerifiedDate, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String updateEObjxNWAddressExtSql = "update ADDRESS set POSTAL_BARCODE = ?1.postalBarCode, ADDR_LINE_ONE = ?1.addrLineOne, ADDR_LINE_THREE = ?1.addrLineThree, ADDR_LINE_TWO = ?1.addrLineTwo, CITY_NAME = ?1.cityName, COUNTY_CODE = ?1.countyCode, LATITUDE_DEGREES = ?1.latitudeDegrees, LONGITUDE_DEGREES = ?1.longtitudeDegrees, RESIDENCE_NUM = ?1.residenceNum, ADDR_STANDARD_IND = ?1.addrStandardInd, OVERRIDE_IND = ?1.overrideInd, POSTAL_CODE = ?1.postalCode, BOX_ID = ?1.boxId, BUILDING_NAME = ?1.buildingName, STREET_NUMBER = ?1.streetNumber, STREET_NAME = ?1.streetName, STREET_SUFFIX = ?1.streetSuffix, PRE_DIRECTIONAL = ?1.preDirectional, POST_DIRECTIONAL = ?1.postDirectional, BOX_DESIGNATOR = ?1.boxDesignator, STN_INFO = ?1.stnInfo, STN_ID = ?1.stnId, REGION = ?1.region, DEL_DESIGNATOR = ?1.delDesignator, DEL_ID = ?1.delId, DEL_INFO = ?1.delInfo, COUNTRY_TP_CD = ?1.countryTpCd, PROV_STATE_TP_CD = ?1.provStateTpCd, RESIDENCE_TP_CD = ?1.residenceTpCd, P_CITY = ?1.pCityName, P_STREET_NAME = ?1.pStreetName, STREET_PREFIX = ?1.streetPrefix, P_ADDR_LINE_ONE = ?1.pAddrLineOne, P_ADDR_LINE_THREE = ?1.pAddrLineThree, P_ADDR_LINE_TWO = ?1.pAddrLineTwo, X_COUNTY = ?2.xCounty, X_HOSPITAL = ?2.xHospital, X_FACILITY_NAME = ?2.xFacility_Name, X_FACILITY_CODE = ?2.xFacility_Code, X_DEPARTMENT_CODE = ?2.xDepartment_Code, X_DEPARTMENT_DESCRIPTION = ?2.xDepartment_Description, X_LOCATION_CODE = ?2.xLocation_Code, X_LOCATION_DESCRIPTION = ?2.xLocation_Description, X_LOCATION_MNEMONIC = ?2.xLocation_Mnemonic, X_LOCATION_ID = ?2.xLocation_ID, X_LOCATION_NAME = ?2.xLocation_Name, X_PHONE = ?2.xPhone, X_PHONE_EXT = ?2.xPhone_Ext, X_SECONDARY_PHONE = ?2.xSecondary_Phone, X_SEC_PHONE_EXT = ?2.xSec_Phone_Ext, X_FAX = ?2.xFax, X_TAX_ID_NUMBER = ?2.xTax_ID_Number, X_NEWPORT_KEY = ?2.xNewport_Key, X_DEACTIVATION_FLAG = ?2.xDeactivation_Flag, X_ACTIVATION_DATE = ?2.xActivation_Date, X_DEACTIVATION_DATE = ?2.xDeactivation_Date, X_TAX_ID_NUMBER_SOURCE = ?2.xTax_ID_Number_Source, X_TAX_ID_LASTVERIFIEDDATE = ?2.xTax_ID_Number_LastVerifiedDate, X_NEWPORT_KEY_SOURCE = ?2.xNewport_Key_Source, X_NEWPORT_KEY_LASTVERIFIEDDATE = ?2.xNewport_Key_LastVerifiedDate, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where ADDRESS_ID = ?1.addressIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String deleteEObjxNWAddressExtSql = "delete from ADDRESS where ADDRESS_ID = ?";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWAddressExtKeyField = "EObjxNWAddressExt.addressIdPK";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWAddressExtGetFields =
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
  public static final String EObjxNWAddressExtAllFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.postalBarCode," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrLineOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrLineThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrLineTwo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.cityName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.countyCode," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.latitudeDegrees," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.longtitudeDegrees," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.residenceNum," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrStandardInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.overrideInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.postalCode," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addressIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.boxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.buildingName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetNumber," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetSuffix," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.preDirectional," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.postDirectional," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.boxDesignator," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.stnInfo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.stnId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.region," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.delDesignator," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.delId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.delInfo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.countryTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.provStateTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.residenceTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pCityName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pStreetName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetPrefix," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pAddrLineOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pAddrLineThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pAddrLineTwo," +
    "mdmnw.entityObject.EObjxNWAddressExt.xCounty," +
    "mdmnw.entityObject.EObjxNWAddressExt.xHospital," +
    "mdmnw.entityObject.EObjxNWAddressExt.xFacility_Name," +
    "mdmnw.entityObject.EObjxNWAddressExt.xFacility_Code," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDepartment_Code," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDepartment_Description," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Code," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Description," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Mnemonic," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_ID," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Name," +
    "mdmnw.entityObject.EObjxNWAddressExt.xPhone," +
    "mdmnw.entityObject.EObjxNWAddressExt.xPhone_Ext," +
    "mdmnw.entityObject.EObjxNWAddressExt.xSecondary_Phone," +
    "mdmnw.entityObject.EObjxNWAddressExt.xSec_Phone_Ext," +
    "mdmnw.entityObject.EObjxNWAddressExt.xFax," +
    "mdmnw.entityObject.EObjxNWAddressExt.xTax_ID_Number," +
    "mdmnw.entityObject.EObjxNWAddressExt.xNewport_Key," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDeactivation_Flag," +
    "mdmnw.entityObject.EObjxNWAddressExt.xActivation_Date," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDeactivation_Date," +
    "mdmnw.entityObject.EObjxNWAddressExt.xTax_ID_Number_Source," +
    "mdmnw.entityObject.EObjxNWAddressExt.xTax_ID_Number_LastVerifiedDate," +
    "mdmnw.entityObject.EObjxNWAddressExt.xNewport_Key_Source," +
    "mdmnw.entityObject.EObjxNWAddressExt.xNewport_Key_LastVerifiedDate," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWAddressExtUpdateFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.postalBarCode," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrLineOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrLineThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrLineTwo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.cityName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.countyCode," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.latitudeDegrees," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.longtitudeDegrees," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.residenceNum," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addrStandardInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.overrideInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.postalCode," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.boxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.buildingName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetNumber," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetSuffix," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.preDirectional," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.postDirectional," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.boxDesignator," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.stnInfo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.stnId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.region," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.delDesignator," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.delId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.delInfo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.countryTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.provStateTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.residenceTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pCityName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pStreetName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.streetPrefix," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pAddrLineOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pAddrLineThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.pAddrLineTwo," +
    "mdmnw.entityObject.EObjxNWAddressExt.xCounty," +
    "mdmnw.entityObject.EObjxNWAddressExt.xHospital," +
    "mdmnw.entityObject.EObjxNWAddressExt.xFacility_Name," +
    "mdmnw.entityObject.EObjxNWAddressExt.xFacility_Code," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDepartment_Code," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDepartment_Description," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Code," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Description," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Mnemonic," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_ID," +
    "mdmnw.entityObject.EObjxNWAddressExt.xLocation_Name," +
    "mdmnw.entityObject.EObjxNWAddressExt.xPhone," +
    "mdmnw.entityObject.EObjxNWAddressExt.xPhone_Ext," +
    "mdmnw.entityObject.EObjxNWAddressExt.xSecondary_Phone," +
    "mdmnw.entityObject.EObjxNWAddressExt.xSec_Phone_Ext," +
    "mdmnw.entityObject.EObjxNWAddressExt.xFax," +
    "mdmnw.entityObject.EObjxNWAddressExt.xTax_ID_Number," +
    "mdmnw.entityObject.EObjxNWAddressExt.xNewport_Key," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDeactivation_Flag," +
    "mdmnw.entityObject.EObjxNWAddressExt.xActivation_Date," +
    "mdmnw.entityObject.EObjxNWAddressExt.xDeactivation_Date," +
    "mdmnw.entityObject.EObjxNWAddressExt.xTax_ID_Number_Source," +
    "mdmnw.entityObject.EObjxNWAddressExt.xTax_ID_Number_LastVerifiedDate," +
    "mdmnw.entityObject.EObjxNWAddressExt.xNewport_Key_Source," +
    "mdmnw.entityObject.EObjxNWAddressExt.xNewport_Key_LastVerifiedDate," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.lastUpdateTxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.addressIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjAddress.oldLastUpdateDt";   

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Select xNWAddress by parameters.
   * @generated
   */
  @Select(sql=getEObjxNWAddressExtSql)
  @EntityMapping(parameters=EObjxNWAddressExtKeyField, results=EObjxNWAddressExtGetFields)
  Iterator<EObjxNWAddressExt> getEObjxNWAddressExt(Long addressIdPK);  
   
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Create xNWAddress by EObjxNWAddressExt Object.
   * @generated
   */
  @Update(sql=createEObjxNWAddressExtSql)
  @EntityMapping(parameters=EObjxNWAddressExtAllFields)
    int createEObjxNWAddressExt(EObjAddress e1, EObjxNWAddressExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Update one xNWAddress by EObjxNWAddressExt object.
   * @generated
   */
  @Update(sql=updateEObjxNWAddressExtSql)
  @EntityMapping(parameters=EObjxNWAddressExtUpdateFields)
    int updateEObjxNWAddressExt(EObjAddress e1, EObjxNWAddressExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Delete xNWAddress by parameters.
   * @generated
   */
  @Update(sql=deleteEObjxNWAddressExtSql)
  @EntityMapping(parameters=EObjxNWAddressExtKeyField)
  int deleteEObjxNWAddressExt(Long addressIdPK);

}

