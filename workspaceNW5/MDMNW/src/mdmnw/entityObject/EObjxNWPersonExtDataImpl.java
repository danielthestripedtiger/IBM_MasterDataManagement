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
import com.dwl.tcrm.coreParty.entityObject.EObjPerson;
import com.ibm.pdq.runtime.statement.SqlStatementType;
import java.sql.Types;


/**
 * <!-- begin-user-doc -->
 * 
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class EObjxNWPersonExtDataImpl  extends BaseData implements EObjxNWPersonExtData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "EObjxNWPersonExtData";

  /**
   * @generated
   */
  public static final long generationTime = 0x00000168a4c6d1e1L;

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
  public EObjxNWPersonExtDataImpl()
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
   * @Select( sql="select X_JOB_TITLE, X_JOB_FAMILY, X_FULL_TIME_PART_TIME, X_STANDARD_HOURS, X_BUSINESS_UNIT, X_HIRE_DATE, X_EMP_ROLE_STATUS, X_REHIRE_DATE, X_TERMINATION_DATE, X_DEPARTMENT_ID, X_DEPARTMENT_NAME, X_SERVICE_LINE_FIN_BUDGETARY, X_GENDER_SOURCE, X_GENDER_LASTVERIFIEDDATE, X_MARITAL_STATUS_SOURCE, X_MARSTAT_LASTVERIFIEDDATE, X_EMPLOYMENTDATA_SOURCE, X_EMPDATA_LASTVERIFIEDDATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from PERSON where CONT_ID = ? " )
   * 
   * @generated
   */
  public Iterator<EObjxNWPersonExt> getEObjxNWPersonExt (Long contIdPK)
  {
    return queryIterator (getEObjxNWPersonExtStatementDescriptor, contIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getEObjxNWPersonExtStatementDescriptor = createStatementDescriptor (
    "getEObjxNWPersonExt(Long)",
    "select X_JOB_TITLE, X_JOB_FAMILY, X_FULL_TIME_PART_TIME, X_STANDARD_HOURS, X_BUSINESS_UNIT, X_HIRE_DATE, X_EMP_ROLE_STATUS, X_REHIRE_DATE, X_TERMINATION_DATE, X_DEPARTMENT_ID, X_DEPARTMENT_NAME, X_SERVICE_LINE_FIN_BUDGETARY, X_GENDER_SOURCE, X_GENDER_LASTVERIFIEDDATE, X_MARITAL_STATUS_SOURCE, X_MARSTAT_LASTVERIFIEDDATE, X_EMPLOYMENTDATA_SOURCE, X_EMPDATA_LASTVERIFIEDDATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from PERSON where CONT_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_job_title", "x_job_family", "x_full_time_part_time", "x_standard_hours", "x_business_unit", "x_hire_date", "x_emp_role_status", "x_rehire_date", "x_termination_date", "x_department_id", "x_department_name", "x_service_line_fin_budgetary", "x_gender_source", "x_gender_lastverifieddate", "x_marital_status_source", "x_marstat_lastverifieddate", "x_employmentdata_source", "x_empdata_lastverifieddate", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetEObjxNWPersonExtParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetEObjxNWPersonExtRowHandler (),
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
  public static class GetEObjxNWPersonExtParameterHandler extends BaseParameterHandler 
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
  public static class GetEObjxNWPersonExtRowHandler extends BaseRowHandler<EObjxNWPersonExt>
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
   * @Update( sql="insert into PERSON (USER_IND, CHILDREN_CT, BIRTH_DT, DECEASED_DT, DISAB_END_DT, DISAB_START_DT, GENDER_TP_CODE, CONT_ID, MARITAL_ST_TP_CD, HIGHEST_EDU_TP_CD, AGE_VER_DOC_TP_CD, BIRTHPLACE_TP_CD, CITIZENSHIP_TP_CD, X_JOB_TITLE, X_JOB_FAMILY, X_FULL_TIME_PART_TIME, X_STANDARD_HOURS, X_BUSINESS_UNIT, X_HIRE_DATE, X_EMP_ROLE_STATUS, X_REHIRE_DATE, X_TERMINATION_DATE, X_DEPARTMENT_ID, X_DEPARTMENT_NAME, X_SERVICE_LINE_FIN_BUDGETARY, X_GENDER_SOURCE, X_GENDER_LASTVERIFIEDDATE, X_MARITAL_STATUS_SOURCE, X_MARSTAT_LASTVERIFIEDDATE, X_EMPLOYMENTDATA_SOURCE, X_EMPDATA_LASTVERIFIEDDATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.userInd, ?1.childrenCt, ?1.birthDt, ?1.deceasedDt, ?1.disabEndDt, ?1.disabStartDt, ?1.genderTpCd, ?1.contIdPK, ?1.maritalStTpCd, ?1.highestEduTpCd, ?1.ageVerDocTpCd, ?1.birthPlaceTpCd, ?1.citizenshipTpCd, ?2.xJob_Title, ?2.xJob_Family, ?2.ixFullTime_PartTIme, ?2.xStandard_Hours, ?2.xBusiness_Unit, ?2.xHire_Date, ?2.xEmployee_Role_Status, ?2.xRehire_Date, ?2.xTermination_Date, ?2.xDepartment_ID, ?2.xDepartment_Name, ?2.xService_Line_Financial_Budgetary, ?2.xGender_Source, ?2.xGender_LastVerifiedDate, ?2.xMaritalStatus_Source, ?2.xMaritalStatus_LastVerifiedDate, ?2.xEmploymentData_Source, ?2.xEmploymentData_LastVerifiedDate, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)" )
   * 
   * @generated
   */
  public int createEObjxNWPersonExt (EObjPerson e1, EObjxNWPersonExt e2)
  {
    return update (createEObjxNWPersonExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor createEObjxNWPersonExtStatementDescriptor = createStatementDescriptor (
    "createEObjxNWPersonExt(com.dwl.tcrm.coreParty.entityObject.EObjPerson, mdmnw.entityObject.EObjxNWPersonExt)",
    "insert into PERSON (USER_IND, CHILDREN_CT, BIRTH_DT, DECEASED_DT, DISAB_END_DT, DISAB_START_DT, GENDER_TP_CODE, CONT_ID, MARITAL_ST_TP_CD, HIGHEST_EDU_TP_CD, AGE_VER_DOC_TP_CD, BIRTHPLACE_TP_CD, CITIZENSHIP_TP_CD, X_JOB_TITLE, X_JOB_FAMILY, X_FULL_TIME_PART_TIME, X_STANDARD_HOURS, X_BUSINESS_UNIT, X_HIRE_DATE, X_EMP_ROLE_STATUS, X_REHIRE_DATE, X_TERMINATION_DATE, X_DEPARTMENT_ID, X_DEPARTMENT_NAME, X_SERVICE_LINE_FIN_BUDGETARY, X_GENDER_SOURCE, X_GENDER_LASTVERIFIEDDATE, X_MARITAL_STATUS_SOURCE, X_MARSTAT_LASTVERIFIEDDATE, X_EMPLOYMENTDATA_SOURCE, X_EMPDATA_LASTVERIFIEDDATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values(  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.INSERT,
    null,
    new CreateEObjxNWPersonExtParameterHandler (),
    new int[][]{{Types.CHAR, Types.SMALLINT, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.CHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.DATE, Types.DATE, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {1, 10, 0, 0, 0, 0, 1, 19, 19, 19, 19, 19, 19, 250, 250, 250, 250, 250, 0, 250, 0, 0, 250, 250, 250, 250, 0, 250, 0, 250, 0, 0, 0, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class CreateEObjxNWPersonExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjPerson bean0 = (EObjPerson) parameters[0];
      setString (stmt, 1, Types.CHAR, (String)bean0.getUserInd());
      setInteger (stmt, 2, Types.SMALLINT, (Integer)bean0.getChildrenCt());
      setTimestamp (stmt, 3, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getBirthDt());
      setTimestamp (stmt, 4, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getDeceasedDt());
      setTimestamp (stmt, 5, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getDisabEndDt());
      setTimestamp (stmt, 6, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getDisabStartDt());
      setString (stmt, 7, Types.CHAR, (String)bean0.getGenderTpCd());
      setLong (stmt, 8, Types.BIGINT, (Long)bean0.getContIdPK());
      setLong (stmt, 9, Types.BIGINT, (Long)bean0.getMaritalStTpCd());
      setLong (stmt, 10, Types.BIGINT, (Long)bean0.getHighestEduTpCd());
      setLong (stmt, 11, Types.BIGINT, (Long)bean0.getAgeVerDocTpCd());
      setLong (stmt, 12, Types.BIGINT, (Long)bean0.getBirthPlaceTpCd());
      setLong (stmt, 13, Types.BIGINT, (Long)bean0.getCitizenshipTpCd());
      EObjxNWPersonExt bean1 = (EObjxNWPersonExt) parameters[1];
      setString (stmt, 14, Types.VARCHAR, (String)bean1.getXJob_Title());
      setString (stmt, 15, Types.VARCHAR, (String)bean1.getXJob_Family());
      setString (stmt, 16, Types.VARCHAR, (String)bean1.getIxFullTime_PartTIme());
      setString (stmt, 17, Types.VARCHAR, (String)bean1.getXStandard_Hours());
      setString (stmt, 18, Types.VARCHAR, (String)bean1.getXBusiness_Unit());
      setDate (stmt, 19, Types.DATE, (java.sql.Date)bean1.getXHire_Date());
      setString (stmt, 20, Types.VARCHAR, (String)bean1.getXEmployee_Role_Status());
      setDate (stmt, 21, Types.DATE, (java.sql.Date)bean1.getXRehire_Date());
      setDate (stmt, 22, Types.DATE, (java.sql.Date)bean1.getXTermination_Date());
      setString (stmt, 23, Types.VARCHAR, (String)bean1.getXDepartment_ID());
      setString (stmt, 24, Types.VARCHAR, (String)bean1.getXDepartment_Name());
      setString (stmt, 25, Types.VARCHAR, (String)bean1.getXService_Line_Financial_Budgetary());
      setString (stmt, 26, Types.VARCHAR, (String)bean1.getXGender_Source());
      setTimestamp (stmt, 27, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXGender_LastVerifiedDate());
      setString (stmt, 28, Types.VARCHAR, (String)bean1.getXMaritalStatus_Source());
      setTimestamp (stmt, 29, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXMaritalStatus_LastVerifiedDate());
      setString (stmt, 30, Types.VARCHAR, (String)bean1.getXEmploymentData_Source());
      setTimestamp (stmt, 31, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXEmploymentData_LastVerifiedDate());
      setTimestamp (stmt, 32, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 33, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 34, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
    }
  }

  /**
   * @Update( sql="update PERSON set USER_IND = ?1.userInd, CHILDREN_CT = ?1.childrenCt, BIRTH_DT = ?1.birthDt, DECEASED_DT = ?1.deceasedDt, DISAB_END_DT = ?1.disabEndDt, DISAB_START_DT = ?1.disabStartDt, GENDER_TP_CODE = ?1.genderTpCd, MARITAL_ST_TP_CD = ?1.maritalStTpCd, HIGHEST_EDU_TP_CD = ?1.highestEduTpCd, AGE_VER_DOC_TP_CD = ?1.ageVerDocTpCd, BIRTHPLACE_TP_CD = ?1.birthPlaceTpCd, CITIZENSHIP_TP_CD = ?1.citizenshipTpCd, X_JOB_TITLE = ?2.xJob_Title, X_JOB_FAMILY = ?2.xJob_Family, X_FULL_TIME_PART_TIME = ?2.ixFullTime_PartTIme, X_STANDARD_HOURS = ?2.xStandard_Hours, X_BUSINESS_UNIT = ?2.xBusiness_Unit, X_HIRE_DATE = ?2.xHire_Date, X_EMP_ROLE_STATUS = ?2.xEmployee_Role_Status, X_REHIRE_DATE = ?2.xRehire_Date, X_TERMINATION_DATE = ?2.xTermination_Date, X_DEPARTMENT_ID = ?2.xDepartment_ID, X_DEPARTMENT_NAME = ?2.xDepartment_Name, X_SERVICE_LINE_FIN_BUDGETARY = ?2.xService_Line_Financial_Budgetary, X_GENDER_SOURCE = ?2.xGender_Source, X_GENDER_LASTVERIFIEDDATE = ?2.xGender_LastVerifiedDate, X_MARITAL_STATUS_SOURCE = ?2.xMaritalStatus_Source, X_MARSTAT_LASTVERIFIEDDATE = ?2.xMaritalStatus_LastVerifiedDate, X_EMPLOYMENTDATA_SOURCE = ?2.xEmploymentData_Source, X_EMPDATA_LASTVERIFIEDDATE = ?2.xEmploymentData_LastVerifiedDate, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where CONT_ID = ?1.contIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt" )
   * 
   * @generated
   */
  public int updateEObjxNWPersonExt (EObjPerson e1, EObjxNWPersonExt e2)
  {
    return update (updateEObjxNWPersonExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor updateEObjxNWPersonExtStatementDescriptor = createStatementDescriptor (
    "updateEObjxNWPersonExt(com.dwl.tcrm.coreParty.entityObject.EObjPerson, mdmnw.entityObject.EObjxNWPersonExt)",
    "update PERSON set USER_IND =  ? , CHILDREN_CT =  ? , BIRTH_DT =  ? , DECEASED_DT =  ? , DISAB_END_DT =  ? , DISAB_START_DT =  ? , GENDER_TP_CODE =  ? , MARITAL_ST_TP_CD =  ? , HIGHEST_EDU_TP_CD =  ? , AGE_VER_DOC_TP_CD =  ? , BIRTHPLACE_TP_CD =  ? , CITIZENSHIP_TP_CD =  ? , X_JOB_TITLE =  ? , X_JOB_FAMILY =  ? , X_FULL_TIME_PART_TIME =  ? , X_STANDARD_HOURS =  ? , X_BUSINESS_UNIT =  ? , X_HIRE_DATE =  ? , X_EMP_ROLE_STATUS =  ? , X_REHIRE_DATE =  ? , X_TERMINATION_DATE =  ? , X_DEPARTMENT_ID =  ? , X_DEPARTMENT_NAME =  ? , X_SERVICE_LINE_FIN_BUDGETARY =  ? , X_GENDER_SOURCE =  ? , X_GENDER_LASTVERIFIEDDATE =  ? , X_MARITAL_STATUS_SOURCE =  ? , X_MARSTAT_LASTVERIFIEDDATE =  ? , X_EMPLOYMENTDATA_SOURCE =  ? , X_EMPDATA_LASTVERIFIEDDATE =  ? , LAST_UPDATE_DT =  ? , LAST_UPDATE_USER =  ? , LAST_UPDATE_TX_ID =  ?  where CONT_ID =  ?  and LAST_UPDATE_DT =  ? ",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.UPDATE,
    null,
    new UpdateEObjxNWPersonExtParameterHandler (),
    new int[][]{{Types.CHAR, Types.SMALLINT, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.CHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.DATE, Types.DATE, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.TIMESTAMP}, {1, 10, 0, 0, 0, 0, 1, 19, 19, 19, 19, 19, 250, 250, 250, 250, 250, 0, 250, 0, 0, 250, 250, 250, 250, 0, 250, 0, 250, 0, 0, 0, 19, 19, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class UpdateEObjxNWPersonExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjPerson bean0 = (EObjPerson) parameters[0];
      setString (stmt, 1, Types.CHAR, (String)bean0.getUserInd());
      setInteger (stmt, 2, Types.SMALLINT, (Integer)bean0.getChildrenCt());
      setTimestamp (stmt, 3, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getBirthDt());
      setTimestamp (stmt, 4, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getDeceasedDt());
      setTimestamp (stmt, 5, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getDisabEndDt());
      setTimestamp (stmt, 6, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getDisabStartDt());
      setString (stmt, 7, Types.CHAR, (String)bean0.getGenderTpCd());
      setLong (stmt, 8, Types.BIGINT, (Long)bean0.getMaritalStTpCd());
      setLong (stmt, 9, Types.BIGINT, (Long)bean0.getHighestEduTpCd());
      setLong (stmt, 10, Types.BIGINT, (Long)bean0.getAgeVerDocTpCd());
      setLong (stmt, 11, Types.BIGINT, (Long)bean0.getBirthPlaceTpCd());
      setLong (stmt, 12, Types.BIGINT, (Long)bean0.getCitizenshipTpCd());
      EObjxNWPersonExt bean1 = (EObjxNWPersonExt) parameters[1];
      setString (stmt, 13, Types.VARCHAR, (String)bean1.getXJob_Title());
      setString (stmt, 14, Types.VARCHAR, (String)bean1.getXJob_Family());
      setString (stmt, 15, Types.VARCHAR, (String)bean1.getIxFullTime_PartTIme());
      setString (stmt, 16, Types.VARCHAR, (String)bean1.getXStandard_Hours());
      setString (stmt, 17, Types.VARCHAR, (String)bean1.getXBusiness_Unit());
      setDate (stmt, 18, Types.DATE, (java.sql.Date)bean1.getXHire_Date());
      setString (stmt, 19, Types.VARCHAR, (String)bean1.getXEmployee_Role_Status());
      setDate (stmt, 20, Types.DATE, (java.sql.Date)bean1.getXRehire_Date());
      setDate (stmt, 21, Types.DATE, (java.sql.Date)bean1.getXTermination_Date());
      setString (stmt, 22, Types.VARCHAR, (String)bean1.getXDepartment_ID());
      setString (stmt, 23, Types.VARCHAR, (String)bean1.getXDepartment_Name());
      setString (stmt, 24, Types.VARCHAR, (String)bean1.getXService_Line_Financial_Budgetary());
      setString (stmt, 25, Types.VARCHAR, (String)bean1.getXGender_Source());
      setTimestamp (stmt, 26, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXGender_LastVerifiedDate());
      setString (stmt, 27, Types.VARCHAR, (String)bean1.getXMaritalStatus_Source());
      setTimestamp (stmt, 28, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXMaritalStatus_LastVerifiedDate());
      setString (stmt, 29, Types.VARCHAR, (String)bean1.getXEmploymentData_Source());
      setTimestamp (stmt, 30, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXEmploymentData_LastVerifiedDate());
      setTimestamp (stmt, 31, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 32, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 33, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
      setLong (stmt, 34, Types.BIGINT, (Long)bean0.getContIdPK());
      setTimestamp (stmt, 35, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getOldLastUpdateDt());
    }
  }

  /**
   * @Update( sql="delete from PERSON where CONT_ID = ?" )
   * 
   * @generated
   */
  public int deleteEObjxNWPersonExt (Long contIdPK)
  {
    return update (deleteEObjxNWPersonExtStatementDescriptor, contIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor deleteEObjxNWPersonExtStatementDescriptor = createStatementDescriptor (
    "deleteEObjxNWPersonExt(Long)",
    "delete from PERSON where CONT_ID = ?",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.DELETE,
    null,
    new DeleteEObjxNWPersonExtParameterHandler (),
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
  public static class DeleteEObjxNWPersonExtParameterHandler extends BaseParameterHandler 
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
