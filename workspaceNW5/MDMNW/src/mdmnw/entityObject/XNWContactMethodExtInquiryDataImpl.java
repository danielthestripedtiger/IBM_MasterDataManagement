package mdmnw.entityObject;

import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import mdmnw.entityObject.EObjxNWContactMethodExt;
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
public class XNWContactMethodExtInquiryDataImpl  extends BaseData implements XNWContactMethodExtInquiryData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "XNWContactMethodExtInquiryData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001689ac99281L;

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
  public XNWContactMethodExtInquiryDataImpl()
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
   * @Select( sql="SELECT r.X_EXTENSION X_EXTENSION, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM CONTACTMETHOD r WHERE r.CONTACT_METHOD_ID = ? ", pattern="tableAlias (CONTACTMETHOD => mdmnw.entityObject.EObjxNWContactMethodExt, H_CONTACTMETHOD => mdmnw.entityObject.EObjxNWContactMethodExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWContactMethodExt> getxNWContactMethod (Object[] parameters)
  {
    return queryIterator (getxNWContactMethodStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWContactMethodStatementDescriptor = createStatementDescriptor (
    "getxNWContactMethod(Object[])",
    "SELECT r.X_EXTENSION X_EXTENSION, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM CONTACTMETHOD r WHERE r.CONTACT_METHOD_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_extension", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWContactMethodParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetxNWContactMethodRowHandler (),
    new int[][]{ {Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {100, 0, 20, 19}, {0, 0, 0, 0}, {0, 0, 0, 0}},
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
  public static class GetxNWContactMethodParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWContactMethodRowHandler extends BaseRowHandler<EObjxNWContactMethodExt>
  {
    /**
     * @generated
     */
    public EObjxNWContactMethodExt handle (java.sql.ResultSet rs, EObjxNWContactMethodExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWContactMethodExt ();
      returnObject.setXExtension(getString (rs, 1)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 2)); 
      returnObject.setLastUpdateUser(getString (rs, 3)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 4)); 
    
      return returnObject;
    }
  }

  /**
   * @Select( sql="SELECT r.H_CONTACT_METHOD_I hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_EXTENSION X_EXTENSION, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_CONTACTMETHOD r WHERE r.H_CONTACT_METHOD_I = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))", pattern="tableAlias (CONTACTMETHOD => mdmnw.entityObject.EObjxNWContactMethodExt, H_CONTACTMETHOD => mdmnw.entityObject.EObjxNWContactMethodExt)" )
   * 
   * @generated
   */
  public Iterator<EObjxNWContactMethodExt> getxNWContactMethodHistory (Object[] parameters)
  {
    return queryIterator (getxNWContactMethodHistoryStatementDescriptor, parameters);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getxNWContactMethodHistoryStatementDescriptor = createStatementDescriptor (
    "getxNWContactMethodHistory(Object[])",
    "SELECT r.H_CONTACT_METHOD_I hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_EXTENSION X_EXTENSION, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_CONTACTMETHOD r WHERE r.H_CONTACT_METHOD_I = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"historyidpk", "h_action_code", "h_created_by", "h_create_dt", "h_end_dt", "x_extension", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetxNWContactMethodHistoryParameterHandler (),
    new int[][]{{Types.BIGINT, Types.TIMESTAMP, Types.TIMESTAMP}, {19, 0, 0}, {0, 0, 0}, {1, 1, 1}},
    null,
    new GetxNWContactMethodHistoryRowHandler (),
    new int[][]{ {Types.BIGINT, Types.CHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 1, 20, 0, 0, 100, 0, 20, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}},
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
  public static class GetxNWContactMethodHistoryParameterHandler extends BaseParameterHandler 
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
  public static class GetxNWContactMethodHistoryRowHandler extends BaseRowHandler<EObjxNWContactMethodExt>
  {
    /**
     * @generated
     */
    public EObjxNWContactMethodExt handle (java.sql.ResultSet rs, EObjxNWContactMethodExt returnObject) throws java.sql.SQLException
    {
      returnObject = new EObjxNWContactMethodExt ();
      returnObject.setHistoryIdPK(getLongObject (rs, 1)); 
      returnObject.setHistActionCode(getString (rs, 2)); 
      returnObject.setHistCreatedBy(getString (rs, 3)); 
      returnObject.setHistCreateDt(getTimestamp (rs, 4)); 
      returnObject.setHistEndDt(getTimestamp (rs, 5)); 
      returnObject.setXExtension(getString (rs, 6)); 
      returnObject.setLastUpdateDt(getTimestamp (rs, 7)); 
      returnObject.setLastUpdateUser(getString (rs, 8)); 
      returnObject.setLastUpdateTxId(getLongObject (rs, 9)); 
    
      return returnObject;
    }
  }

}
