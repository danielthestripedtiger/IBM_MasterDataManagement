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
 * IBM-MDMWB-1.0-[e2f1f55a19b65290d17e6077bd8226d2]
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
public interface XNWPersonNameExtInquiryData {
  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String tableAliasString = "tableAlias (" + 
                                            "PERSONNAME => mdmnw.entityObject.EObjxNWPersonNameExt, " +
                                            "H_PERSONNAME => mdmnw.entityObject.EObjxNWPersonNameExt" +
                                            ")";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWPersonNameSql = "SELECT r.X_FULL_NAME X_FULL_NAME, r.X_DEGREE X_DEGREE, r.X_DEGREE_SOURCE X_DEGREE_SOURCE, r.X_DEGREE_LAST_VERIFIED_DATE X_DEGREE_LAST_VERIFIED_DATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM PERSONNAME r WHERE r.PERSON_NAME_ID = ? ";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonNameParameters =
    "EObjxNWPersonNameExt.personNameIdPK";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonNameResults =
    "EObjxNWPersonNameExt.x_Full_Name," +
    "EObjxNWPersonNameExt.xDegree," +
    "EObjxNWPersonNameExt.xDegree_Source," +
    "EObjxNWPersonNameExt.xDegree_LastVerifiedDate," +
    "EObjxNWPersonNameExt.lastUpdateDt," +
    "EObjxNWPersonNameExt.lastUpdateUser," +
    "EObjxNWPersonNameExt.lastUpdateTxId";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  static final String getxNWPersonNameHistorySql = "SELECT r.H_PERSON_NAME_ID hist_id_pk, r.H_ACTION_CODE h_action_code, r.H_CREATED_BY h_created_by, r.H_CREATE_DT h_create_dt, r.H_END_DT h_end_dt, r.X_FULL_NAME X_FULL_NAME, r.X_DEGREE X_DEGREE, r.X_DEGREE_SOURCE X_DEGREE_SOURCE, r.X_DEGREE_LAST_VERIFIED_DATE X_DEGREE_LAST_VERIFIED_DATE, r.LAST_UPDATE_DT LAST_UPDATE_DT, r.LAST_UPDATE_USER LAST_UPDATE_USER, r.LAST_UPDATE_TX_ID LAST_UPDATE_TX_ID FROM H_PERSONNAME r WHERE r.H_PERSON_NAME_ID = ?  AND (( ? BETWEEN r.H_CREATE_DT AND r.H_END_DT ) OR ( ? >= r.H_CREATE_DT AND r.H_END_DT IS NULL ))";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonNameHistoryParameters =
    "EObjxNWPersonNameExt.personNameIdPK," +
    "EObjxNWPersonNameExt.lastUpdateDt," +
    "EObjxNWPersonNameExt.lastUpdateDt";
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getxNWPersonNameHistoryResults =
    "EObjxNWPersonNameExt.historyIdPK," +
    "EObjxNWPersonNameExt.histActionCode," +
    "EObjxNWPersonNameExt.histCreatedBy," +
    "EObjxNWPersonNameExt.histCreateDt," +
    "EObjxNWPersonNameExt.histEndDt," +
    "EObjxNWPersonNameExt.x_Full_Name," +
    "EObjxNWPersonNameExt.xDegree," +
    "EObjxNWPersonNameExt.xDegree_Source," +
    "EObjxNWPersonNameExt.xDegree_LastVerifiedDate," +
    "EObjxNWPersonNameExt.lastUpdateDt," +
    "EObjxNWPersonNameExt.lastUpdateUser," +
    "EObjxNWPersonNameExt.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWPersonNameSql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWPersonNameParameters, results=getxNWPersonNameResults)
  Iterator<EObjxNWPersonNameExt> getxNWPersonName(Object[] parameters);  


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Select(sql=getxNWPersonNameHistorySql, pattern=tableAliasString)
  @EntityMapping(parameters=getxNWPersonNameHistoryParameters, results=getxNWPersonNameHistoryResults)
  Iterator<EObjxNWPersonNameExt> getxNWPersonNameHistory(Object[] parameters);  


}


