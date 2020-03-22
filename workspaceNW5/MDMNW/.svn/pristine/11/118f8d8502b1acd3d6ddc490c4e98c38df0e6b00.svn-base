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
 * IBM-MDMWB-1.0-[f7d697d12913178d4ff3b07d58653256]
 */


package mdmnw.entityObject;

import java.util.Iterator;
import com.ibm.mdm.base.db.EntityMapping;
import com.ibm.pdq.annotation.Select;
import com.ibm.pdq.annotation.Update;

import com.dwl.tcrm.coreParty.entityObject.EObjPerson;

import mdmnw.entityObject.EObjxNWPersonExt;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public interface EObjxNWPersonExtData {


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getEObjxNWPersonExtSql = "select X_JOB_TITLE, X_JOB_FAMILY, X_FULL_TIME_PART_TIME, X_STANDARD_HOURS, X_BUSINESS_UNIT, X_HIRE_DATE, X_EMP_ROLE_STATUS, X_REHIRE_DATE, X_TERMINATION_DATE, X_DEPARTMENT_ID, X_DEPARTMENT_NAME, X_SERVICE_LINE_FIN_BUDGETARY, X_GENDER_SOURCE, X_GENDER_LASTVERIFIEDDATE, X_MARITAL_STATUS_SOURCE, X_MARSTAT_LASTVERIFIEDDATE, X_EMPLOYMENTDATA_SOURCE, X_EMPDATA_LASTVERIFIEDDATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from PERSON where CONT_ID = ? ";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String createEObjxNWPersonExtSql = "insert into PERSON (USER_IND, CHILDREN_CT, BIRTH_DT, DECEASED_DT, DISAB_END_DT, DISAB_START_DT, GENDER_TP_CODE, CONT_ID, MARITAL_ST_TP_CD, HIGHEST_EDU_TP_CD, AGE_VER_DOC_TP_CD, BIRTHPLACE_TP_CD, CITIZENSHIP_TP_CD, X_JOB_TITLE, X_JOB_FAMILY, X_FULL_TIME_PART_TIME, X_STANDARD_HOURS, X_BUSINESS_UNIT, X_HIRE_DATE, X_EMP_ROLE_STATUS, X_REHIRE_DATE, X_TERMINATION_DATE, X_DEPARTMENT_ID, X_DEPARTMENT_NAME, X_SERVICE_LINE_FIN_BUDGETARY, X_GENDER_SOURCE, X_GENDER_LASTVERIFIEDDATE, X_MARITAL_STATUS_SOURCE, X_MARSTAT_LASTVERIFIEDDATE, X_EMPLOYMENTDATA_SOURCE, X_EMPDATA_LASTVERIFIEDDATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.userInd, ?1.childrenCt, ?1.birthDt, ?1.deceasedDt, ?1.disabEndDt, ?1.disabStartDt, ?1.genderTpCd, ?1.contIdPK, ?1.maritalStTpCd, ?1.highestEduTpCd, ?1.ageVerDocTpCd, ?1.birthPlaceTpCd, ?1.citizenshipTpCd, ?2.xJob_Title, ?2.xJob_Family, ?2.ixFullTime_PartTIme, ?2.xStandard_Hours, ?2.xBusiness_Unit, ?2.xHire_Date, ?2.xEmployee_Role_Status, ?2.xRehire_Date, ?2.xTermination_Date, ?2.xDepartment_ID, ?2.xDepartment_Name, ?2.xService_Line_Financial_Budgetary, ?2.xGender_Source, ?2.xGender_LastVerifiedDate, ?2.xMaritalStatus_Source, ?2.xMaritalStatus_LastVerifiedDate, ?2.xEmploymentData_Source, ?2.xEmploymentData_LastVerifiedDate, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String updateEObjxNWPersonExtSql = "update PERSON set USER_IND = ?1.userInd, CHILDREN_CT = ?1.childrenCt, BIRTH_DT = ?1.birthDt, DECEASED_DT = ?1.deceasedDt, DISAB_END_DT = ?1.disabEndDt, DISAB_START_DT = ?1.disabStartDt, GENDER_TP_CODE = ?1.genderTpCd, MARITAL_ST_TP_CD = ?1.maritalStTpCd, HIGHEST_EDU_TP_CD = ?1.highestEduTpCd, AGE_VER_DOC_TP_CD = ?1.ageVerDocTpCd, BIRTHPLACE_TP_CD = ?1.birthPlaceTpCd, CITIZENSHIP_TP_CD = ?1.citizenshipTpCd, X_JOB_TITLE = ?2.xJob_Title, X_JOB_FAMILY = ?2.xJob_Family, X_FULL_TIME_PART_TIME = ?2.ixFullTime_PartTIme, X_STANDARD_HOURS = ?2.xStandard_Hours, X_BUSINESS_UNIT = ?2.xBusiness_Unit, X_HIRE_DATE = ?2.xHire_Date, X_EMP_ROLE_STATUS = ?2.xEmployee_Role_Status, X_REHIRE_DATE = ?2.xRehire_Date, X_TERMINATION_DATE = ?2.xTermination_Date, X_DEPARTMENT_ID = ?2.xDepartment_ID, X_DEPARTMENT_NAME = ?2.xDepartment_Name, X_SERVICE_LINE_FIN_BUDGETARY = ?2.xService_Line_Financial_Budgetary, X_GENDER_SOURCE = ?2.xGender_Source, X_GENDER_LASTVERIFIEDDATE = ?2.xGender_LastVerifiedDate, X_MARITAL_STATUS_SOURCE = ?2.xMaritalStatus_Source, X_MARSTAT_LASTVERIFIEDDATE = ?2.xMaritalStatus_LastVerifiedDate, X_EMPLOYMENTDATA_SOURCE = ?2.xEmploymentData_Source, X_EMPDATA_LASTVERIFIEDDATE = ?2.xEmploymentData_LastVerifiedDate, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where CONT_ID = ?1.contIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String deleteEObjxNWPersonExtSql = "delete from PERSON where CONT_ID = ?";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonExtKeyField = "EObjxNWPersonExt.contIdPK";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonExtGetFields =
    "EObjxNWPersonExt.xJob_Title," +
    "EObjxNWPersonExt.xJob_Family," +
    "EObjxNWPersonExt.ixFullTime_PartTIme," +
    "EObjxNWPersonExt.xStandard_Hours," +
    "EObjxNWPersonExt.xBusiness_Unit," +
    "EObjxNWPersonExt.xHire_Date," +
    "EObjxNWPersonExt.xEmployee_Role_Status," +
    "EObjxNWPersonExt.xRehire_Date," +
    "EObjxNWPersonExt.xTermination_Date," +
    "EObjxNWPersonExt.xDepartment_ID," +
    "EObjxNWPersonExt.xDepartment_Name," +
    "EObjxNWPersonExt.xService_Line_Financial_Budgetary," +
    "EObjxNWPersonExt.xGender_Source," +
    "EObjxNWPersonExt.xGender_LastVerifiedDate," +
    "EObjxNWPersonExt.xMaritalStatus_Source," +
    "EObjxNWPersonExt.xMaritalStatus_LastVerifiedDate," +
    "EObjxNWPersonExt.xEmploymentData_Source," +
    "EObjxNWPersonExt.xEmploymentData_LastVerifiedDate," +
    "EObjxNWPersonExt.lastUpdateDt," +
    "EObjxNWPersonExt.lastUpdateUser," +
    "EObjxNWPersonExt.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonExtAllFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.userInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.childrenCt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.birthDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.deceasedDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.disabEndDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.disabStartDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.genderTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.contIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.maritalStTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.highestEduTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.ageVerDocTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.birthPlaceTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.citizenshipTpCd," +
    "mdmnw.entityObject.EObjxNWPersonExt.xJob_Title," +
    "mdmnw.entityObject.EObjxNWPersonExt.xJob_Family," +
    "mdmnw.entityObject.EObjxNWPersonExt.ixFullTime_PartTIme," +
    "mdmnw.entityObject.EObjxNWPersonExt.xStandard_Hours," +
    "mdmnw.entityObject.EObjxNWPersonExt.xBusiness_Unit," +
    "mdmnw.entityObject.EObjxNWPersonExt.xHire_Date," +
    "mdmnw.entityObject.EObjxNWPersonExt.xEmployee_Role_Status," +
    "mdmnw.entityObject.EObjxNWPersonExt.xRehire_Date," +
    "mdmnw.entityObject.EObjxNWPersonExt.xTermination_Date," +
    "mdmnw.entityObject.EObjxNWPersonExt.xDepartment_ID," +
    "mdmnw.entityObject.EObjxNWPersonExt.xDepartment_Name," +
    "mdmnw.entityObject.EObjxNWPersonExt.xService_Line_Financial_Budgetary," +
    "mdmnw.entityObject.EObjxNWPersonExt.xGender_Source," +
    "mdmnw.entityObject.EObjxNWPersonExt.xGender_LastVerifiedDate," +
    "mdmnw.entityObject.EObjxNWPersonExt.xMaritalStatus_Source," +
    "mdmnw.entityObject.EObjxNWPersonExt.xMaritalStatus_LastVerifiedDate," +
    "mdmnw.entityObject.EObjxNWPersonExt.xEmploymentData_Source," +
    "mdmnw.entityObject.EObjxNWPersonExt.xEmploymentData_LastVerifiedDate," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonExtUpdateFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.userInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.childrenCt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.birthDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.deceasedDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.disabEndDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.disabStartDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.genderTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.maritalStTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.highestEduTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.ageVerDocTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.birthPlaceTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.citizenshipTpCd," +
    "mdmnw.entityObject.EObjxNWPersonExt.xJob_Title," +
    "mdmnw.entityObject.EObjxNWPersonExt.xJob_Family," +
    "mdmnw.entityObject.EObjxNWPersonExt.ixFullTime_PartTIme," +
    "mdmnw.entityObject.EObjxNWPersonExt.xStandard_Hours," +
    "mdmnw.entityObject.EObjxNWPersonExt.xBusiness_Unit," +
    "mdmnw.entityObject.EObjxNWPersonExt.xHire_Date," +
    "mdmnw.entityObject.EObjxNWPersonExt.xEmployee_Role_Status," +
    "mdmnw.entityObject.EObjxNWPersonExt.xRehire_Date," +
    "mdmnw.entityObject.EObjxNWPersonExt.xTermination_Date," +
    "mdmnw.entityObject.EObjxNWPersonExt.xDepartment_ID," +
    "mdmnw.entityObject.EObjxNWPersonExt.xDepartment_Name," +
    "mdmnw.entityObject.EObjxNWPersonExt.xService_Line_Financial_Budgetary," +
    "mdmnw.entityObject.EObjxNWPersonExt.xGender_Source," +
    "mdmnw.entityObject.EObjxNWPersonExt.xGender_LastVerifiedDate," +
    "mdmnw.entityObject.EObjxNWPersonExt.xMaritalStatus_Source," +
    "mdmnw.entityObject.EObjxNWPersonExt.xMaritalStatus_LastVerifiedDate," +
    "mdmnw.entityObject.EObjxNWPersonExt.xEmploymentData_Source," +
    "mdmnw.entityObject.EObjxNWPersonExt.xEmploymentData_LastVerifiedDate," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.lastUpdateTxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.contIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPerson.oldLastUpdateDt";   

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Select xNWPerson by parameters.
   * @generated
   */
  @Select(sql=getEObjxNWPersonExtSql)
  @EntityMapping(parameters=EObjxNWPersonExtKeyField, results=EObjxNWPersonExtGetFields)
  Iterator<EObjxNWPersonExt> getEObjxNWPersonExt(Long contIdPK);  
   
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Create xNWPerson by EObjxNWPersonExt Object.
   * @generated
   */
  @Update(sql=createEObjxNWPersonExtSql)
  @EntityMapping(parameters=EObjxNWPersonExtAllFields)
    int createEObjxNWPersonExt(EObjPerson e1, EObjxNWPersonExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Update one xNWPerson by EObjxNWPersonExt object.
   * @generated
   */
  @Update(sql=updateEObjxNWPersonExtSql)
  @EntityMapping(parameters=EObjxNWPersonExtUpdateFields)
    int updateEObjxNWPersonExt(EObjPerson e1, EObjxNWPersonExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Delete xNWPerson by parameters.
   * @generated
   */
  @Update(sql=deleteEObjxNWPersonExtSql)
  @EntityMapping(parameters=EObjxNWPersonExtKeyField)
  int deleteEObjxNWPersonExt(Long contIdPK);

}

