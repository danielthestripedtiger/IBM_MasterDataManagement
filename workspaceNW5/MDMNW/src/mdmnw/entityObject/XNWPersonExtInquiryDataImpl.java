package mdmnw.entityObject;

import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import mdmnw.entityObject.EObjxNWPersonExt;
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
public class XNWPersonExtInquiryDataImpl  extends BaseData implements XNWPersonExtInquiryData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "XNWPersonExtInquiryData";

  /**
   * @generated
   */
  public static final long generationTime = 0x00000168a4c6d2d2L;

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
  public XNWPersonExtInquiryDataImpl()
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
   * @Select( sql="SELECT r.X_JOB_TITLE X_JOB_TITLE, r.X_JOB_FAMILY X_JOB_FAMILY, r.X_FULL_TIME_PART_TIME X_FULL_TIME_PART_TIME, r.X_STANDARD_HOURS X_STANDARD_HOURS, r.X_BUSINESS_UNIT X_BUSINESS_UNIT, r.X_HIRE_DATE X_HIRE_DATE, r.X_EMP_ROLE_STATUS X_EMP_ROLE_STATUS, r.X_REHIRE_DATE X_REHIRE_DATE, r.X_TERMINATION_DATE X_TERMINATION_DATE, r.X_DEPARTMENT_ID X_DEPARTMENT_ID, r.X_DEPARTMENT_NAME X_DEPARTMENT_NAME, r.X_SERVICE_LINE_FIN_BUDGETARY X_SERVICE_LINE_FIN_BUDGETARY, r.X_GENDER_SOURCE X_GENDER_SOURCE, r.X_GENDER_LASTVERIFIEDDATE X_GENDER_LASTVERIFIEDDATE, r.X_MARITAL_STATUS_SOURCE X_MARITAL_STATUS_SOURCE, r.X_MARSTAT_LASTVERIFIEDDATE X_MARSTAT_LASTVERIFIEDDATE, r.X_EMPLOYMENTDATA_SOURCE X_EMPLOYMENTDATA_SOURCE, r.X_EMPDATA_LASTVERIFIEDDATE X_EMPDATA_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM PERSON r WHERE r.CONT_ID = ? ", pattern="tableAlias (PERSON => mdmnw.entityObject.EObjxNWPersonExt, H_PERSON => mdmnw.entityObject.EObjxNWPersonExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWPersonExt> getxNWPerson (Object[] parameters)
  {
    return queryIterator (getxNWPersonStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWPersonStatementDescriptor = createStatementDescriptor (
    "getxNWPerson(Object[])",
    "SELECT r.X_JOB_TITLE X_JOB_TITLE, r.X_JOB_FAMILY X_JOB_FAMILY, r.X_FULL_TIME_PART_TIME X_FULL_TIME_PART_TIME, r.X_STANDARD_HOURS X_STANDARD_HOURS, r.X_BUSINESS_UNIT X_BUSINESS_UNIT, r.X_HIRE_DATE X_HIRE_DATE, r.X_EMP_ROLE_STATUS X_EMP_ROLE_STATUS, r.X_REHIRE_DATE X_REHIRE_DATE, r.X_TERMINATION_DATE X_TERMINATION_DATE, r.X_DEPARTMENT_ID X_DEPARTMENT_ID, r.X_DEPARTMENT_NAME X_DEPARTMENT_NAME, r.X_SERVICE_LINE_FIN_BUDGETARY X_SERVICE_LINE_FIN_BUDGETARY, r.X_GENDER_SOURCE X_GENDER_SOURCE, r.X_GENDER_LASTVERIFIEDDATE X_GENDER_LASTVERIFIEDDATE, r.X_MARITAL_STATUS_SOURCE X_MARITAL_STATUS_SOURCE, r.X_MARSTAT_LASTVERIFIEDDATE X_MARSTAT_LASTVERIFIEDDATE, r.X_EMPLOYMENTDATA_SOURCE X_EMPLOYMENTDATA_SOURCE, r.X_EMPDATA_LASTVERIFIEDDATE X_EMPDATA_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM PERSON r WHERE r.CONT_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_job_title", "x_job_family", "x_full_time_part_time", "x_standard_hours", "x_business_unit", "x_hire_date", "x_emp_role_status", "x_rehire_date", "x_termination_date", "x_department_id", "x_department_name", "x_service_line_fin_budgetary", "x_gender_source", "x_gender_lastverifieddate", "x_marital_status_source", "x_marstat_lastverifieddate", "x_employmentdata_source", "x_empdata_lastverifieddate", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWPersonParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetxNWPersonRowHandler (),
    new int[][]{ {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.DATE, Types.DATE, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {250, 250, 250, 250, 250, 0, 250, 0, 0, 250, 250, 250, 250, 0, 250, 0, 250, 0, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetxNWPersonParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWPersonRowHandler extends BaseRowHandler<EObjxNWPersonExt>
  {
    /**
     * @generated
     */
    public EObjxNWPersonExt handle (java.sql.ResultSet rs, EObjxNWPersonExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWPersonExt ();
      returnObject.setXJob_Title(getString (rs, 1)); 
      returnObject.setXJob_Family(getString (rs, 2)); 
      returnObject.setIxFullTime_PartTIme(getString (rs, 3)); 
      returnObject.setXStandard_Hours(getString (rs, 4)); 
      returnObject.setXBusiness_Unit(getString (rs, 5)); 
      returnObject.setXHire_Date(getDate (rs, 6)); 
      returnObject.setXEmployee_Role_Status(getString (rs, 7)); 
      returnObject.setXRehire_Date(getDate (rs, 8)); 
      returnObject.setXTermination_Date(getDate (rs, 9)); 
      returnObject.setXDepartment_ID(getString (rs, 10)); 
      returnObject.setXDepartment_Name(getString (rs, 11)); 
      returnObject.setXService_Line_Financial_Budgetary(getString (rs, 12)); 
      returnObject.setXGender_Source(getString (rs, 13)); 
      returnObject.setXGender_LastVerifiedDate(getTimestamp (rs, 14)); 
      returnObject.setXMaritalStatus_Source(getString (rs, 15)); 
      returnObject.setXMaritalStatus_LastVerifiedDate(getTimestamp (rs, 16)); 
      returnObject.setXEmploymentData_Source(getString (rs, 17)); 
      returnObject.setXEmploymentData_LastVerifiedDate(getTimestamp (rs, 18)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 19)); 
      returnObject.setLastUpdateUser(getString (rs, 20)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 21)); 
    
      return returnObject;
    }
  }

  /**
   * @Select( sql="SELECT r.H_CONT_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_JOB_TITLE X_JOB_TITLE, r.X_JOB_FAMILY X_JOB_FAMILY, r.X_FULL_TIME_PART_TIME X_FULL_TIME_PART_TIME, r.X_STANDARD_HOURS X_STANDARD_HOURS, r.X_BUSINESS_UNIT X_BUSINESS_UNIT, r.X_HIRE_DATE X_HIRE_DATE, r.X_EMP_ROLE_STATUS X_EMP_ROLE_STATUS, r.X_REHIRE_DATE X_REHIRE_DATE, r.X_TERMINATION_DATE X_TERMINATION_DATE, r.X_DEPARTMENT_ID X_DEPARTMENT_ID, r.X_DEPARTMENT_NAME X_DEPARTMENT_NAME, r.X_SERVICE_LINE_FIN_BUDGETARY X_SERVICE_LINE_FIN_BUDGETARY, r.X_GENDER_SOURCE X_GENDER_SOURCE, r.X_GENDER_LASTVERIFIEDDATE X_GENDER_LASTVERIFIEDDATE, r.X_MARITAL_STATUS_SOURCE X_MARITAL_STATUS_SOURCE, r.X_MARSTAT_LASTVERIFIEDDATE X_MARSTAT_LASTVERIFIEDDATE, r.X_EMPLOYMENTDATA_SOURCE X_EMPLOYMENTDATA_SOURCE, r.X_EMPDATA_LASTVERIFIEDDATE X_EMPDATA_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_PERSON r WHERE r.H_CONT_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))", pattern="tableAlias (PERSON => mdmnw.entityObject.EObjxNWPersonExt, H_PERSON => mdmnw.entityObject.EObjxNWPersonExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWPersonExt> getxNWPersonHistory (Object[] parameters)
  {
    return queryIterator (getxNWPersonHistoryStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWPersonHistoryStatementDescriptor = createStatementDescriptor (
    "getxNWPersonHistory(Object[])",
    "SELECT r.H_CONT_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_JOB_TITLE X_JOB_TITLE, r.X_JOB_FAMILY X_JOB_FAMILY, r.X_FULL_TIME_PART_TIME X_FULL_TIME_PART_TIME, r.X_STANDARD_HOURS X_STANDARD_HOURS, r.X_BUSINESS_UNIT X_BUSINESS_UNIT, r.X_HIRE_DATE X_HIRE_DATE, r.X_EMP_ROLE_STATUS X_EMP_ROLE_STATUS, r.X_REHIRE_DATE X_REHIRE_DATE, r.X_TERMINATION_DATE X_TERMINATION_DATE, r.X_DEPARTMENT_ID X_DEPARTMENT_ID, r.X_DEPARTMENT_NAME X_DEPARTMENT_NAME, r.X_SERVICE_LINE_FIN_BUDGETARY X_SERVICE_LINE_FIN_BUDGETARY, r.X_GENDER_SOURCE X_GENDER_SOURCE, r.X_GENDER_LASTVERIFIEDDATE X_GENDER_LASTVERIFIEDDATE, r.X_MARITAL_STATUS_SOURCE X_MARITAL_STATUS_SOURCE, r.X_MARSTAT_LASTVERIFIEDDATE X_MARSTAT_LASTVERIFIEDDATE, r.X_EMPLOYMENTDATA_SOURCE X_EMPLOYMENTDATA_SOURCE, r.X_EMPDATA_LASTVERIFIEDDATE X_EMPDATA_LASTVERIFIEDDATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_PERSON r WHERE r.H_CONT_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"historyidpk", "h_action_code", "h_created_by", "h_create_dt", "h_end_dt", "x_job_title", "x_job_family", "x_full_time_part_time", "x_standard_hours", "x_business_unit", "x_hire_date", "x_emp_role_status", "x_rehire_date", "x_termination_date", "x_department_id", "x_department_name", "x_service_line_fin_budgetary", "x_gender_source", "x_gender_lastverifieddate", "x_marital_status_source", "x_marstat_lastverifieddate", "x_employmentdata_source", "x_empdata_lastverifieddate", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWPersonHistoryParameterHandler (),
    new int[][]{{Types.BIGINT, Types.TIMESTAMP, Types.TIMESTAMP}, {19, 0, 0}, {0, 0, 0}, {1, 1, 1}},
    null,
    new GetxNWPersonHistoryRowHandler (),
    new int[][]{ {Types.BIGINT, Types.CHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.DATE, Types.DATE, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 1, 20, 0, 0, 250, 250, 250, 250, 250, 0, 250, 0, 0, 250, 250, 250, 250, 0, 250, 0, 250, 0, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetxNWPersonHistoryParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWPersonHistoryRowHandler extends BaseRowHandler<EObjxNWPersonExt>
  {
    /**
     * @generated
     */
    public EObjxNWPersonExt handle (java.sql.ResultSet rs, EObjxNWPersonExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWPersonExt ();
      returnObject.setHistoryIdPK(getLongObject (rs, 1)); 
      returnObject.setHistActionCode(getString (rs, 2)); 
      returnObject.setHistCreatedBy(getString (rs, 3)); 
      returnObject.setHistCreateDt(getTimestamp (rs, 4)); 
      returnObject.setHistEndDt(getTimestamp (rs, 5)); 
      returnObject.setXJob_Title(getString (rs, 6)); 
      returnObject.setXJob_Family(getString (rs, 7)); 
      returnObject.setIxFullTime_PartTIme(getString (rs, 8)); 
      returnObject.setXStandard_Hours(getString (rs, 9)); 
      returnObject.setXBusiness_Unit(getString (rs, 10)); 
      returnObject.setXHire_Date(getDate (rs, 11)); 
      returnObject.setXEmployee_Role_Status(getString (rs, 12)); 
      returnObject.setXRehire_Date(getDate (rs, 13)); 
      returnObject.setXTermination_Date(getDate (rs, 14)); 
      returnObject.setXDepartment_ID(getString (rs, 15)); 
      returnObject.setXDepartment_Name(getString (rs, 16)); 
      returnObject.setXService_Line_Financial_Budgetary(getString (rs, 17)); 
      returnObject.setXGender_Source(getString (rs, 18)); 
      returnObject.setXGender_LastVerifiedDate(getTimestamp (rs, 19)); 
      returnObject.setXMaritalStatus_Source(getString (rs, 20)); 
      returnObject.setXMaritalStatus_LastVerifiedDate(getTimestamp (rs, 21)); 
      returnObject.setXEmploymentData_Source(getString (rs, 22)); 
      returnObject.setXEmploymentData_LastVerifiedDate(getTimestamp (rs, 23)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 24)); 
      returnObject.setLastUpdateUser(getString (rs, 25)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 26)); 
    
      return returnObject;
    }
  }

}
