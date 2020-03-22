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
 * IBM-MDMWB-1.0-[6bb03f96acca56e0d569b8832b932dc7]
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
public interface XNWPersonExtInquiryData {
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String tableAliasString = "tableAlias (" + 
                                            "PERSON => mdmnw.entityObject.EObjxNWPersonExt, " +
                                            "H_PERSON => mdmnw.entityObject.EObjxNWPersonExt" +
                                            ")";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWPersonSql = "SELECT r.X_JOB_TITLE X_JOB_TITLE, r.X_JOB_FAMILY X_JOB_FAMILY, r.X_FULL_TIME_PART_TIME X_FULL_TIME_PART_TIME, r.X_STANDARD_HOURS X_STANDARD_HOURS, r.X_BUSINESS_UNIT X_BUSINESS_UNIT, r.X_HIRE_DATE X_HIRE_DATE, r.X_EMP_ROLE_STATUS X_EMP_ROLE_STATUS, r.X_REHIRE_DATE X_REHIRE_DATE, r.X_TERMINATION_DATE X_TERMINATION_DATE, r.X_DEPARTMENT_ID X_DEPARTMENT_ID, r.X_DEPARTMENT_NAME X_DEPARTMENT_NAME, r.X_SERVICE_LINE_FIN_BUDGETARY X_SERVICE_LINE_FIN_BUDGETARY, r.X_GENDER_SOURCE X_GENDER_SOURCE, r.X_GENDER_LASTVERIFIEDDATE X_GENDER_LASTVERIFIEDDATE, r.X_MARITAL_STATUS_SOURCE X_MARITAL_STATUS_SOURCE, r.X_MARSTAT_LASTVERIFIEDDATE X_MARSTAT_LASTVERIFIEDDATE, r.X_EMPLOYMENTDATA_SOURCE X_EMPLOYMENTDATA_SOURCE, r.X_EMPDATA_LASTVERIFIEDDATE X_EMPDATA_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM PERSON r WHERE r.CONT_ID = ? ";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonParameters =
    "EObjxNWPersonExt.contIdPK";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonResults =
    "EObjxNWPersonExt.xJob_Title," +
    "EObjxNWPersonExt.xJob_Family," +
    "EObjxNWPersonExt.IxFullTime_PartTIme," +
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
  static final String getxNWPersonHistorySql = "SELECT r.H_CONT_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_JOB_TITLE X_JOB_TITLE, r.X_JOB_FAMILY X_JOB_FAMILY, r.X_FULL_TIME_PART_TIME X_FULL_TIME_PART_TIME, r.X_STANDARD_HOURS X_STANDARD_HOURS, r.X_BUSINESS_UNIT X_BUSINESS_UNIT, r.X_HIRE_DATE X_HIRE_DATE, r.X_EMP_ROLE_STATUS X_EMP_ROLE_STATUS, r.X_REHIRE_DATE X_REHIRE_DATE, r.X_TERMINATION_DATE X_TERMINATION_DATE, r.X_DEPARTMENT_ID X_DEPARTMENT_ID, r.X_DEPARTMENT_NAME X_DEPARTMENT_NAME, r.X_SERVICE_LINE_FIN_BUDGETARY X_SERVICE_LINE_FIN_BUDGETARY, r.X_GENDER_SOURCE X_GENDER_SOURCE, r.X_GENDER_LASTVERIFIEDDATE X_GENDER_LASTVERIFIEDDATE, r.X_MARITAL_STATUS_SOURCE X_MARITAL_STATUS_SOURCE, r.X_MARSTAT_LASTVERIFIEDDATE X_MARSTAT_LASTVERIFIEDDATE, r.X_EMPLOYMENTDATA_SOURCE X_EMPLOYMENTDATA_SOURCE, r.X_EMPDATA_LASTVERIFIEDDATE X_EMPDATA_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_PERSON r WHERE r.H_CONT_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonHistoryParameters =
    "EObjxNWPersonExt.contIdPK," +
    "EObjxNWPersonExt.lastUpdateDt," +
    "EObjxNWPersonExt.lastUpdateDt";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonHistoryResults =
    "EObjxNWPersonExt.historyIdPK," +
    "EObjxNWPersonExt.histActionCode," +
    "EObjxNWPersonExt.histCreatedBy," +
    "EObjxNWPersonExt.histCreateDt," +
    "EObjxNWPersonExt.histEndDt," +
    "EObjxNWPersonExt.xJob_Title," +
    "EObjxNWPersonExt.xJob_Family," +
    "EObjxNWPersonExt.IxFullTime_PartTIme," +
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
  @Select(sql=getxNWPersonSql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWPersonParameters, results=getxNWPersonResults)
  Iterator<EObjxNWPersonExt> getxNWPerson(Object[] parameters);  


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWPersonHistorySql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWPersonHistoryParameters, results=getxNWPersonHistoryResults)
  Iterator<EObjxNWPersonExt> getxNWPersonHistory(Object[] parameters);  


}


