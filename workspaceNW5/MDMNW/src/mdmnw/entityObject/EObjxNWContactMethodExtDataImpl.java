package mdmnw.entityObject;

import com.ibm.pdq.runtime.generator.BaseParameterHandler;
import java.util.Iterator;
import mdmnw.entityObject.EObjxNWContactMethodExt;
import java.sql.PreparedStatement;
import com.ibm.pdq.runtime.statement.StatementDescriptor;
import com.dwl.tcrm.coreParty.entityObject.EObjContactMethod;
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
public class EObjxNWContactMethodExtDataImpl  extends BaseData implements EObjxNWContactMethodExtData
{

  /**
   * @generated
   */
  public static final String generatorVersion = "3.200.75";

  /**
   * @generated
   */
  public static final String identifier = "EObjxNWContactMethodExtData";

  /**
   * @generated
   */
  public static final long generationTime = 0x000001689ac98f9cL;

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
  public EObjxNWContactMethodExtDataImpl()
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
   * @Select( sql="select X_EXTENSION,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from CONTACTMETHOD where CONTACT_METHOD_ID = ? " )
   * 
   * @generated
   */
  public Iterator<EObjxNWContactMethodExt> getEObjxNWContactMethodExt (Long contactMethodIdPK)
  {
    return queryIterator (getEObjxNWContactMethodExtStatementDescriptor, contactMethodIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor getEObjxNWContactMethodExtStatementDescriptor = createStatementDescriptor (
    "getEObjxNWContactMethodExt(Long)",
    "select X_EXTENSION,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from CONTACTMETHOD where CONTACT_METHOD_ID = ? ",
    new int[] {SINGLE_ROW_PARAMETERS, MULTI_ROW_RESULT, java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, java.sql.ResultSet.TYPE_FORWARD_ONLY, DISALLOW_STATIC_ROWSET_CURSORS},
    SqlStatementType.QUERY,
    new String[]{"x_extension", "last_update_dt", "last_update_user", "last_update_tx_id"},
    new GetEObjxNWContactMethodExtParameterHandler (),
    new int[][]{{Types.BIGINT}, {19}, {0}, {1}},
    null,
    new GetEObjxNWContactMethodExtRowHandler (),
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
  public static class GetEObjxNWContactMethodExtParameterHandler extends BaseParameterHandler 
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
  public static class GetEObjxNWContactMethodExtRowHandler extends BaseRowHandler<EObjxNWContactMethodExt>
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
   * @Update( sql="insert into CONTACTMETHOD (ADDRESS_ID, CONTACT_METHOD_ID, REF_NUM, CONT_METH_STD_IND, CONT_METH_CAT_CD, X_EXTENSION, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.addressId, ?1.contactMethodIdPK, ?1.refNum, ?1.contMethStandardInd, ?1.contMethCatCd, ?2.xExtension, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)" )
   * 
   * @generated
   */
  public int createEObjxNWContactMethodExt (EObjContactMethod e1, EObjxNWContactMethodExt e2)
  {
    return update (createEObjxNWContactMethodExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor createEObjxNWContactMethodExtStatementDescriptor = createStatementDescriptor (
    "createEObjxNWContactMethodExt(com.dwl.tcrm.coreParty.entityObject.EObjContactMethod, mdmnw.entityObject.EObjxNWContactMethodExt)",
    "insert into CONTACTMETHOD (ADDRESS_ID, CONTACT_METHOD_ID, REF_NUM, CONT_METH_STD_IND, CONT_METH_CAT_CD, X_EXTENSION, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values(  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.INSERT,
    null,
    new CreateEObjxNWContactMethodExtParameterHandler (),
    new int[][]{{Types.BIGINT, Types.BIGINT, Types.VARCHAR, Types.CHAR, Types.BIGINT, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT}, {19, 19, 255, 1, 19, 100, 0, 0, 19}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class CreateEObjxNWContactMethodExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjContactMethod bean0 = (EObjContactMethod) parameters[0];
      setLong (stmt, 1, Types.BIGINT, (Long)bean0.getAddressId());
      setLong (stmt, 2, Types.BIGINT, (Long)bean0.getContactMethodIdPK());
      setString (stmt, 3, Types.VARCHAR, (String)bean0.getRefNum());
      setString (stmt, 4, Types.CHAR, (String)bean0.getContMethStandardInd());
      setLong (stmt, 5, Types.BIGINT, (Long)bean0.getContMethCatCd());
      EObjxNWContactMethodExt bean1 = (EObjxNWContactMethodExt) parameters[1];
      setString (stmt, 6, Types.VARCHAR, (String)bean1.getXExtension());
      setTimestamp (stmt, 7, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 8, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 9, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
    }
  }

  /**
   * @Update( sql="update CONTACTMETHOD set ADDRESS_ID = ?1.addressId, REF_NUM = ?1.refNum, CONT_METH_STD_IND = ?1.contMethStandardInd, CONT_METH_CAT_CD = ?1.contMethCatCd, X_EXTENSION = ?2.xExtension, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where CONTACT_METHOD_ID = ?1.contactMethodIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt" )
   * 
   * @generated
   */
  public int updateEObjxNWContactMethodExt (EObjContactMethod e1, EObjxNWContactMethodExt e2)
  {
    return update (updateEObjxNWContactMethodExtStatementDescriptor, e1, e2);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor updateEObjxNWContactMethodExtStatementDescriptor = createStatementDescriptor (
    "updateEObjxNWContactMethodExt(com.dwl.tcrm.coreParty.entityObject.EObjContactMethod, mdmnw.entityObject.EObjxNWContactMethodExt)",
    "update CONTACTMETHOD set ADDRESS_ID =  ? , REF_NUM =  ? , CONT_METH_STD_IND =  ? , CONT_METH_CAT_CD =  ? , X_EXTENSION =  ? , LAST_UPDATE_DT =  ? , LAST_UPDATE_USER =  ? , LAST_UPDATE_TX_ID =  ?  where CONTACT_METHOD_ID =  ?  and LAST_UPDATE_DT =  ? ",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.UPDATE,
    null,
    new UpdateEObjxNWContactMethodExtParameterHandler (),
    new int[][]{{Types.BIGINT, Types.VARCHAR, Types.CHAR, Types.BIGINT, Types.VARCHAR, Types.TIMESTAMP, Types.VARCHAR, Types.BIGINT, Types.BIGINT, Types.TIMESTAMP}, {19, 255, 1, 19, 100, 0, 0, 19, 19, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}},
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
  public static class UpdateEObjxNWContactMethodExtParameterHandler extends BaseParameterHandler 
  {
    /**
     * @generated
     */
    public void handleParameters (PreparedStatement stmt, Object... parameters) throws SQLException
    {
      EObjContactMethod bean0 = (EObjContactMethod) parameters[0];
      setLong (stmt, 1, Types.BIGINT, (Long)bean0.getAddressId());
      setString (stmt, 2, Types.VARCHAR, (String)bean0.getRefNum());
      setString (stmt, 3, Types.CHAR, (String)bean0.getContMethStandardInd());
      setLong (stmt, 4, Types.BIGINT, (Long)bean0.getContMethCatCd());
      EObjxNWContactMethodExt bean1 = (EObjxNWContactMethodExt) parameters[1];
      setString (stmt, 5, Types.VARCHAR, (String)bean1.getXExtension());
      setTimestamp (stmt, 6, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getLastUpdateDt());
      setString (stmt, 7, Types.VARCHAR, (String)bean0.getLastUpdateUser());
      setLong (stmt, 8, Types.BIGINT, (Long)bean0.getLastUpdateTxId());
      setLong (stmt, 9, Types.BIGINT, (Long)bean0.getContactMethodIdPK());
      setTimestamp (stmt, 10, Types.TIMESTAMP, (java.sql.Timestamp)bean0.getOldLastUpdateDt());
    }
  }

  /**
   * @Update( sql="delete from CONTACTMETHOD where CONTACT_METHOD_ID = ?" )
   * 
   * @generated
   */
  public int deleteEObjxNWContactMethodExt (Long contactMethodIdPK)
  {
    return update (deleteEObjxNWContactMethodExtStatementDescriptor, contactMethodIdPK);
  }

  /**
   * @generated
   */
  @Metadata ()
  public static final StatementDescriptor deleteEObjxNWContactMethodExtStatementDescriptor = createStatementDescriptor (
    "deleteEObjxNWContactMethodExt(Long)",
    "delete from CONTACTMETHOD where CONTACT_METHOD_ID = ?",
    new int[] {SINGLE_ROW_PARAMETERS},
    SqlStatementType.DELETE,
    null,
    new DeleteEObjxNWContactMethodExtParameterHandler (),
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
  public static class DeleteEObjxNWContactMethodExtParameterHandler extends BaseParameterHandler 
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
