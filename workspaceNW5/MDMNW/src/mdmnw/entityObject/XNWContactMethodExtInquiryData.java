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
 * IBM-MDMWB-1.0-[e9d690098481a0c98fa4f0927e456a52]
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
public interface XNWContactMethodExtInquiryData {
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String tableAliasString = "tableAlias (" + 
                                            "CONTACTMETHOD => mdmnw.entityObject.EObjxNWContactMethodExt, " +
                                            "H_CONTACTMETHOD => mdmnw.entityObject.EObjxNWContactMethodExt" +
                                            ")";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWContactMethodSql = "SELECT r.X_EXTENSION X_EXTENSION, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM CONTACTMETHOD r WHERE r.CONTACT_METHOD_ID = ? ";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWContactMethodParameters =
    "EObjxNWContactMethodExt.contactMethodIdPK";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWContactMethodResults =
    "EObjxNWContactMethodExt.xExtension," +
    "EObjxNWContactMethodExt.lastUpdateDt," +
    "EObjxNWContactMethodExt.lastUpdateUser," +
    "EObjxNWContactMethodExt.lastUpdateTxId";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWContactMethodHistorySql = "SELECT r.H_CONTACT_METHOD_I hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_EXTENSION X_EXTENSION, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_CONTACTMETHOD r WHERE r.H_CONTACT_METHOD_I = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWContactMethodHistoryParameters =
    "EObjxNWContactMethodExt.contactMethodIdPK," +
    "EObjxNWContactMethodExt.lastUpdateDt," +
    "EObjxNWContactMethodExt.lastUpdateDt";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWContactMethodHistoryResults =
    "EObjxNWContactMethodExt.historyIdPK," +
    "EObjxNWContactMethodExt.histActionCode," +
    "EObjxNWContactMethodExt.histCreatedBy," +
    "EObjxNWContactMethodExt.histCreateDt," +
    "EObjxNWContactMethodExt.histEndDt," +
    "EObjxNWContactMethodExt.xExtension," +
    "EObjxNWContactMethodExt.lastUpdateDt," +
    "EObjxNWContactMethodExt.lastUpdateUser," +
    "EObjxNWContactMethodExt.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWContactMethodSql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWContactMethodParameters, results=getxNWContactMethodResults)
  Iterator<EObjxNWContactMethodExt> getxNWContactMethod(Object[] parameters);  


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWContactMethodHistorySql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWContactMethodHistoryParameters, results=getxNWContactMethodHistoryResults)
  Iterator<EObjxNWContactMethodExt> getxNWContactMethodHistory(Object[] parameters);  


}


