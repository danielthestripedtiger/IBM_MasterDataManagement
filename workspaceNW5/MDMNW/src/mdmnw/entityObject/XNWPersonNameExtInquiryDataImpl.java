package mdmnw.entityObject;

import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
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
public class XNWPersonNameExtInquiryDataImpl  extends BaseData implements XNWPersonNameExtInquiryData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "XNWPersonNameExtInquiryData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001689ac995ddL;

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
  public XNWPersonNameExtInquiryDataImpl()
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
   * @Select( sql="SELECT r.X_FULL_NAME X_FULL_NAME, r.X_DEGREE X_DEGREE, r.X_DEGREE_SOURCE X_DEGREE_SOURCE, r.X_DEGREE_LAST_VERIFIED_DATE X_DEGREE_LAST_VERIFIED_DATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM PERSONNAME r WHERE r.PERSON_NAME_ID = ? ", pattern="tableAlias (PERSONNAME => mdmnw.entityObject.EObjxNWPersonNameExt, H_PERSONNAME => mdmnw.entityObject.EObjxNWPersonNameExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWPersonNameExt> getxNWPersonName (Object[] parameters)
  {
    return queryIterator (getxNWPersonNameStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWPersonNameStatementDescriptor = createStatementDescriptor (
    "getxNWPersonName(Object[])",
    "SELECT r.X_FULL_NAME X_FULL_NAME, r.X_DEGREE X_DEGREE, r.X_DEGREE_SOURCE X_DEGREE_SOURCE, r.X_DEGREE_LAST_VERIFIED_DATE X_DEGREE_LAST_VERIFIED_DATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM PERSONNAME r WHERE r.PERSON_NAME_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_full_name", "x_degree", "x_degree_source", "x_degree_last_verified_date", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWPersonNameParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetxNWPersonNameRowHandler (),
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
  public static class GetxNWPersonNameParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWPersonNameRowHandler extends BaseRowHandler<EObjxNWPersonNameExt>
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
   * @Select( sql="SELECT r.H_PERSON_NAME_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_FULL_NAME X_FULL_NAME, r.X_DEGREE X_DEGREE, r.X_DEGREE_SOURCE X_DEGREE_SOURCE, r.X_DEGREE_LAST_VERIFIED_DATE X_DEGREE_LAST_VERIFIED_DATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_PERSONNAME r WHERE r.H_PERSON_NAME_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))", pattern="tableAlias (PERSONNAME => mdmnw.entityObject.EObjxNWPersonNameExt, H_PERSONNAME => mdmnw.entityObject.EObjxNWPersonNameExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWPersonNameExt> getxNWPersonNameHistory (Object[] parameters)
  {
    return queryIterator (getxNWPersonNameHistoryStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWPersonNameHistoryStatementDescriptor = createStatementDescriptor (
    "getxNWPersonNameHistory(Object[])",
    "SELECT r.H_PERSON_NAME_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_FULL_NAME X_FULL_NAME, r.X_DEGREE X_DEGREE, r.X_DEGREE_SOURCE X_DEGREE_SOURCE, r.X_DEGREE_LAST_VERIFIED_DATE X_DEGREE_LAST_VERIFIED_DATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_PERSONNAME r WHERE r.H_PERSON_NAME_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"historyidpk", "h_action_code", "h_created_by", "h_create_dt", "h_end_dt", "x_full_name", "x_degree", "x_degree_source", "x_degree_last_verified_date", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWPersonNameHistoryParameterHandler (),
    new int[][]{{Types.BIGINT, Types.TIMESTAMP, Types.TIMESTAMP}, {19, 0, 0}, {0, 0, 0}, {1, 1, 1}},
    null,
    new GetxNWPersonNameHistoryRowHandler (),
    new int[][]{ {Types.BIGINT, Types.CHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 1, 20, 0, 0, 250, 250, 250, 0, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetxNWPersonNameHistoryParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWPersonNameHistoryRowHandler extends BaseRowHandler<EObjxNWPersonNameExt>
  {
    /**
     * @generated
     */
    public EObjxNWPersonNameExt handle (java.sql.ResultSet rs, EObjxNWPersonNameExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWPersonNameExt ();
      returnObject.setHistoryIdPK(getLongObject (rs, 1)); 
      returnObject.setHistActionCode(getString (rs, 2)); 
      returnObject.setHistCreatedBy(getString (rs, 3)); 
      returnObject.setHistCreateDt(getTimestamp (rs, 4)); 
      returnObject.setHistEndDt(getTimestamp (rs, 5)); 
      returnObject.setX_Full_Name(getString (rs, 6)); 
      returnObject.setXDegree(getString (rs, 7)); 
      returnObject.setXDegree_Source(getString (rs, 8)); 
      returnObject.setXDegree_LastVerifiedDate(getTimestamp (rs, 9)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 10)); 
      returnObject.setLastUpdateUser(getString (rs, 11)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 12)); 
    
      return returnObject;
    }
  }

}
