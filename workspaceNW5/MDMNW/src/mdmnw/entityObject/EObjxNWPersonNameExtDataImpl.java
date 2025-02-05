package mdmnw.entityObject;

import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import com.dwl.tcrm.coreParty.entityObject.EObjPersonName;
import java.sql.PreparedStatement;
import mdmnw.entityObject.EObjxNWPersonNameExt;
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
public class EObjxNWPersonNameExtDataImpl  extends BaseData implements EObjxNWPersonNameExtData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "EObjxNWPersonNameExtData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001689ac9914eL;

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
  public EObjxNWPersonNameExtDataImpl()
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
   * @Select( sql="select X_FULL_NAME, X_DEGREE, X_DEGREE_SOURCE, X_DEGREE_LAST_VERIFIED_DATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from PERSONNAME where PERSON_NAME_ID = ? " )
   * 
   * @generated
   */
  public Iterator<EObjxNWPersonNameExt> getEObjxNWPersonNameExt (Long personNameIdPK)
  {
    return queryIterator (getEObjxNWPersonNameExtStatementDescriptor, personNameIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getEObjxNWPersonNameExtStatementDescriptor = createStatementDescriptor (
    "getEObjxNWPersonNameExt(Long)",
    "select X_FULL_NAME, X_DEGREE, X_DEGREE_SOURCE, X_DEGREE_LAST_VERIFIED_DATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from PERSONNAME where PERSON_NAME_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_full_name", "x_degree", "x_degree_source", "x_degree_last_verified_date", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetEObjxNWPersonNameExtParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetEObjxNWPersonNameExtRowHandler (),
    new int[][]{ {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {250, 250, 250, 0, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetEObjxNWPersonNameExtParameterHandler extends BaseParameterHandler 
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
  public static class GetEObjxNWPersonNameExtRowHandler extends BaseRowHandler<EObjxNWPersonNameExt>
  {
    /**
     * @generated
     */
    public EObjxNWPersonNameExt handle (java.sql.ResultSet rs, EObjxNWPersonNameExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWPersonNameExt ();
      returnObject.setX_Full_Name(getString (rs, 1)); 
      returnObject.setXDegree(getString (rs, 2)); 
      returnObject.setXDegree_Source(getString (rs, 3)); 
      returnObject.setXDegree_LastVerifiedDate(getTimestamp (rs, 4)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 5)); 
      returnObject.setLastUpdateUser(getString (rs, 6)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 7)); 
    
      return returnObject;
    }
  }

  /**
   * @Update( sql="insert into PERSONNAME (LAST_USED_DT, LAST_VERIFIED_DT, END_DT, GIVEN_NAME_FOUR, GIVEN_NAME_ONE, GIVEN_NAME_THREE, GIVEN_NAME_TWO, LAST_NAME, PREFIX_DESC, PERSON_NAME_ID, CONT_ID, START_DT, SUFFIX_DESC, USE_STANDARD_IND, NAME_USAGE_TP_CD, PREFIX_NAME_TP_CD, GENERATION_TP_CD, SOURCE_IDENT_TP_CD, P_LAST_NAME, P_GIVEN_NAME_ONE, P_GIVEN_NAME_TWO, P_GIVEN_NAME_THREE, P_GIVEN_NAME_FOUR, X_FULL_NAME, X_DEGREE, X_DEGREE_SOURCE, X_DEGREE_LAST_VERIFIED_DATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.lastUsedDt, ?1.lastVerifiedDt, ?1.endDt, ?1.givenNameFour, ?1.givenNameOne, ?1.givenNameThree, ?1.givenNameTwo, ?1.lastName, ?1.prefixDesc, ?1.personNameIdPK, ?1.contId, ?1.startDt, ?1.suffixDesc, ?1.useStandardInd, ?1.nameUsageTpCd, ?1.prefixNameTpCd, ?1.generationTpCd, ?1.sourceIdentTpCd, ?1.pLastName, ?1.pGivenNameOne, ?1.pGivenNameTwo, ?1.pGivenNameThree, ?1.pGivenNameFour, ?2.x_Full_Name, ?2.xDegree, ?2.xDegree_Source, ?2.xDegree_LastVerifiedDate, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)" )
   * 
   * @generated
   */
  public int createEObjxNWPersonNameExt (EObjPersonName e1, EObjxNWPersonNameExt e2)
  {
    return update (createEObjxNWPersonNameExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor createEObjxNWPersonNameExtStatementDescriptor = createStatementDescriptor (
    "createEObjxNWPersonNameExt(com.dwl.tcrm.coreParty.entityObject.EObjPersonName, mdmnw.entityObject.EObjxNWPersonNameExt)",
    "insert into PERSONNAME (LAST_USED_DT, LAST_VERIFIED_DT, END_DT, GIVEN_NAME_FOUR, GIVEN_NAME_ONE, GIVEN_NAME_THREE, GIVEN_NAME_TWO, LAST_NAME, PREFIX_DESC, PERSON_NAME_ID, CONT_ID, START_DT, SUFFIX_DESC, USE_STANDARD_IND, NAME_USAGE_TP_CD, PREFIX_NAME_TP_CD, GENERATION_TP_CD, SOURCE_IDENT_TP_CD, P_LAST_NAME, P_GIVEN_NAME_ONE, P_GIVEN_NAME_TWO, P_GIVEN_NAME_THREE, P_GIVEN_NAME_FOUR, X_FULL_NAME, X_DEGREE, X_DEGREE_SOURCE, X_DEGREE_LAST_VERIFIED_DATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values(  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.INSERT,
    null,
    new CreateEObjxNWPersonNameExtParameterHandler (),
    new int[][]{{Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.TIMESTAMP, Types.VARCHAR, Types.CHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {0, 0, 0, 25, 25, 25, 25, 30, 20, 19, 19, 0, 20, 1, 19, 19, 19, 19, 20, 20, 20, 20, 20, 250, 250, 250, 0, 0, 0, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class CreateEObjxNWPersonNameExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjPersonName bean0 = (EObjPersonName) parameters[0];
      setTimestamp (stmt, 1, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUsedDt());
      setTimestamp (stmt, 2, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastVerifiedDt());
      setTimestamp (stmt, 3, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getEndDt());
      setString (stmt, 4, Types.VARCHAR, (String)bean0.getGivenNameFour());
      setString (stmt, 5, Types.VARCHAR, (String)bean0.getGivenNameOne());
      setString (stmt, 6, Types.VARCHAR, (String)bean0.getGivenNameThree());
      setString (stmt, 7, Types.VARCHAR, (String)bean0.getGivenNameTwo());
      setString (stmt, 8, Types.VARCHAR, (String)bean0.getLastName());
      setString (stmt, 9, Types.VARCHAR, (String)bean0.getPrefixDesc());
      setLong (stmt, 10, Types.BIGINT, (Long)bean0.getPersonNameIdPK());
      setLong (stmt, 11, Types.BIGINT, (Long)bean0.getContId());
      setTimestamp (stmt, 12, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getStartDt());
      setString (stmt, 13, Types.VARCHAR, (String)bean0.getSuffixDesc());
      setString (stmt, 14, Types.CHAR, (String)bean0.getUseStandardInd());
      setLong (stmt, 15, Types.BIGINT, (Long)bean0.getNameUsageTpCd());
      setLong (stmt, 16, Types.BIGINT, (Long)bean0.getPrefixNameTpCd());
      setLong (stmt, 17, Types.BIGINT, (Long)bean0.getGenerationTpCd());
      setLong (stmt, 18, Types.BIGINT, (Long)bean0.getSourceIdentTpCd());
      setString (stmt, 19, Types.VARCHAR, (String)bean0.getPLastName());
      setString (stmt, 20, Types.VARCHAR, (String)bean0.getPGivenNameOne());
      setString (stmt, 21, Types.VARCHAR, (String)bean0.getPGivenNameTwo());
      setString (stmt, 22, Types.VARCHAR, (String)bean0.getPGivenNameThree());
      setString (stmt, 23, Types.VARCHAR, (String)bean0.getPGivenNameFour());
      EObjxNWPersonNameExt bean1 = (EObjxNWPersonNameExt) parameters[1];
      setString (stmt, 24, Types.VARCHAR, (String)bean1.getX_Full_Name());
      setString (stmt, 25, Types.VARCHAR, (String)bean1.getXDegree());
      setString (stmt, 26, Types.VARCHAR, (String)bean1.getXDegree_Source());
      setTimestamp (stmt, 27, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXDegree_LastVerifiedDate());
      setTimestamp (stmt, 28, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 29, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 30, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
    }
  }

  /**
   * @Update( sql="update PERSONNAME set LAST_USED_DT = ?1.lastUsedDt, LAST_VERIFIED_DT = ?1.lastVerifiedDt, END_DT = ?1.endDt, GIVEN_NAME_FOUR = ?1.givenNameFour, GIVEN_NAME_ONE = ?1.givenNameOne, GIVEN_NAME_THREE = ?1.givenNameThree, GIVEN_NAME_TWO = ?1.givenNameTwo, LAST_NAME = ?1.lastName, PREFIX_DESC = ?1.prefixDesc, CONT_ID = ?1.contId, START_DT = ?1.startDt, SUFFIX_DESC = ?1.suffixDesc, USE_STANDARD_IND = ?1.useStandardInd, NAME_USAGE_TP_CD = ?1.nameUsageTpCd, PREFIX_NAME_TP_CD = ?1.prefixNameTpCd, GENERATION_TP_CD = ?1.generationTpCd, SOURCE_IDENT_TP_CD = ?1.sourceIdentTpCd, P_LAST_NAME = ?1.pLastName, P_GIVEN_NAME_ONE = ?1.pGivenNameOne, P_GIVEN_NAME_TWO = ?1.pGivenNameTwo, P_GIVEN_NAME_THREE = ?1.pGivenNameThree, P_GIVEN_NAME_FOUR = ?1.pGivenNameFour, X_FULL_NAME = ?2.x_Full_Name, X_DEGREE = ?2.xDegree, X_DEGREE_SOURCE = ?2.xDegree_Source, X_DEGREE_LAST_VERIFIED_DATE = ?2.xDegree_LastVerifiedDate, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where PERSON_NAME_ID = ?1.personNameIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt" )
   * 
   * @generated
   */
  public int updateEObjxNWPersonNameExt (EObjPersonName e1, EObjxNWPersonNameExt e2)
  {
    return update (updateEObjxNWPersonNameExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor updateEObjxNWPersonNameExtStatementDescriptor = createStatementDescriptor (
    "updateEObjxNWPersonNameExt(com.dwl.tcrm.coreParty.entityObject.EObjPersonName, mdmnw.entityObject.EObjxNWPersonNameExt)",
    "update PERSONNAME set LAST_USED_DT =  ? , LAST_VERIFIED_DT =  ? , END_DT =  ? , GIVEN_NAME_FOUR =  ? , GIVEN_NAME_ONE =  ? , GIVEN_NAME_THREE =  ? , GIVEN_NAME_TWO =  ? , LAST_NAME =  ? , PREFIX_DESC =  ? , CONT_ID =  ? , START_DT =  ? , SUFFIX_DESC =  ? , USE_STANDARD_IND =  ? , NAME_USAGE_TP_CD =  ? , PREFIX_NAME_TP_CD =  ? , GENERATION_TP_CD =  ? , SOURCE_IDENT_TP_CD =  ? , P_LAST_NAME =  ? , P_GIVEN_NAME_ONE =  ? , P_GIVEN_NAME_TWO =  ? , P_GIVEN_NAME_THREE =  ? , P_GIVEN_NAME_FOUR =  ? , X_FULL_NAME =  ? , X_DEGREE =  ? , X_DEGREE_SOURCE =  ? , X_DEGREE_LAST_VERIFIED_DATE =  ? , LAST_UPDATE_DT =  ? , LAST_UPDATE_USER =  ? , LAST_UPDATE_TX_ID =  ?  where PERSON_NAME_ID =  ?  and LAST_UPDATE_DT =  ? ",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.UPDATE,
    null,
    new UpdateEObjxNWPersonNameExtParameterHandler (),
    new int[][]{{Types.TIMESTAMP, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.TIMESTAMP, Types.VARCHAR, Types.CHAR, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.TIMESTAMP}, {0, 0, 0, 25, 25, 25, 25, 30, 20, 19, 0, 20, 1, 19, 19, 19, 19, 20, 20, 20, 20, 20, 250, 250, 250, 0, 0, 0, 19, 19, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class UpdateEObjxNWPersonNameExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjPersonName bean0 = (EObjPersonName) parameters[0];
      setTimestamp (stmt, 1, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUsedDt());
      setTimestamp (stmt, 2, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastVerifiedDt());
      setTimestamp (stmt, 3, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getEndDt());
      setString (stmt, 4, Types.VARCHAR, (String)bean0.getGivenNameFour());
      setString (stmt, 5, Types.VARCHAR, (String)bean0.getGivenNameOne());
      setString (stmt, 6, Types.VARCHAR, (String)bean0.getGivenNameThree());
      setString (stmt, 7, Types.VARCHAR, (String)bean0.getGivenNameTwo());
      setString (stmt, 8, Types.VARCHAR, (String)bean0.getLastName());
      setString (stmt, 9, Types.VARCHAR, (String)bean0.getPrefixDesc());
      setLong (stmt, 10, Types.BIGINT, (Long)bean0.getContId());
      setTimestamp (stmt, 11, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getStartDt());
      setString (stmt, 12, Types.VARCHAR, (String)bean0.getSuffixDesc());
      setString (stmt, 13, Types.CHAR, (String)bean0.getUseStandardInd());
      setLong (stmt, 14, Types.BIGINT, (Long)bean0.getNameUsageTpCd());
      setLong (stmt, 15, Types.BIGINT, (Long)bean0.getPrefixNameTpCd());
      setLong (stmt, 16, Types.BIGINT, (Long)bean0.getGenerationTpCd());
      setLong (stmt, 17, Types.BIGINT, (Long)bean0.getSourceIdentTpCd());
      setString (stmt, 18, Types.VARCHAR, (String)bean0.getPLastName());
      setString (stmt, 19, Types.VARCHAR, (String)bean0.getPGivenNameOne());
      setString (stmt, 20, Types.VARCHAR, (String)bean0.getPGivenNameTwo());
      setString (stmt, 21, Types.VARCHAR, (String)bean0.getPGivenNameThree());
      setString (stmt, 22, Types.VARCHAR, (String)bean0.getPGivenNameFour());
      EObjxNWPersonNameExt bean1 = (EObjxNWPersonNameExt) parameters[1];
      setString (stmt, 23, Types.VARCHAR, (String)bean1.getX_Full_Name());
      setString (stmt, 24, Types.VARCHAR, (String)bean1.getXDegree());
      setString (stmt, 25, Types.VARCHAR, (String)bean1.getXDegree_Source());
      setTimestamp (stmt, 26, Types.TIMESTAMP, (java.sql.Timestamp)bean1.getXDegree_LastVerifiedDate());
      setTimestamp (stmt, 27, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 28, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 29, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
      setLong (stmt, 30, Types.BIGINT, (Long)bean0.getPersonNameIdPK());
      setTimestamp (stmt, 31, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getOldLastUpdateDt());
    }
  }

  /**
   * @Update( sql="delete from PERSONNAME where PERSON_NAME_ID = ?" )
   * 
   * @generated
   */
  public int deleteEObjxNWPersonNameExt (Long personNameIdPK)
  {
    return update (deleteEObjxNWPersonNameExtStatementDescriptor, personNameIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor deleteEObjxNWPersonNameExtStatementDescriptor = createStatementDescriptor (
    "deleteEObjxNWPersonNameExt(Long)",
    "delete from PERSONNAME where PERSON_NAME_ID = ?",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.DELETE,
    null,
    new DeleteEObjxNWPersonNameExtParameterHandler (),
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
  public static class DeleteEObjxNWPersonNameExtParameterHandler extends BaseParameterHandler 
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
