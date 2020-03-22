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
 * IBM-MDMWB-1.0-[6b11c26129efffd65a4be8d2b426f4e5]
 */


package mdmnw.entityObject;

import java.util.Iterator;
import com.ibm.mdm.base.db.EntityMapping;
import com.ibm.pdq.annotation.Select;
import com.ibm.pdq.annotation.Update;

import com.dwl.tcrm.coreParty.entityObject.EObjContactMethod;

import mdmnw.entityObject.EObjxNWContactMethodExt;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public interface EObjxNWContactMethodExtData {


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getEObjxNWContactMethodExtSql = "select X_EXTENSION,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from CONTACTMETHOD where CONTACT_METHOD_ID = ? ";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String createEObjxNWContactMethodExtSql = "insert into CONTACTMETHOD (ADDRESS_ID, CONTACT_METHOD_ID, REF_NUM, CONT_METH_STD_IND, CONT_METH_CAT_CD, X_EXTENSION, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.addressId, ?1.contactMethodIdPK, ?1.refNum, ?1.contMethStandardInd, ?1.contMethCatCd, ?2.xExtension, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String updateEObjxNWContactMethodExtSql = "update CONTACTMETHOD set ADDRESS_ID = ?1.addressId, REF_NUM = ?1.refNum, CONT_METH_STD_IND = ?1.contMethStandardInd, CONT_METH_CAT_CD = ?1.contMethCatCd, X_EXTENSION = ?2.xExtension, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where CONTACT_METHOD_ID = ?1.contactMethodIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String deleteEObjxNWContactMethodExtSql = "delete from CONTACTMETHOD where CONTACT_METHOD_ID = ?";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWContactMethodExtKeyField = "EObjxNWContactMethodExt.contactMethodIdPK";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWContactMethodExtGetFields =
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
  public static final String EObjxNWContactMethodExtAllFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.addressId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.contactMethodIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.refNum," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.contMethStandardInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.contMethCatCd," +
    "mdmnw.entityObject.EObjxNWContactMethodExt.xExtension," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWContactMethodExtUpdateFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.addressId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.refNum," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.contMethStandardInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.contMethCatCd," +
    "mdmnw.entityObject.EObjxNWContactMethodExt.xExtension," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.lastUpdateTxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.contactMethodIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjContactMethod.oldLastUpdateDt";   

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Select xNWContactMethod by parameters.
   * @generated
   */
  @Select(sql=getEObjxNWContactMethodExtSql)
  @EntityMapping(parameters=EObjxNWContactMethodExtKeyField, results=EObjxNWContactMethodExtGetFields)
  Iterator<EObjxNWContactMethodExt> getEObjxNWContactMethodExt(Long contactMethodIdPK);  
   
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Create xNWContactMethod by EObjxNWContactMethodExt Object.
   * @generated
   */
  @Update(sql=createEObjxNWContactMethodExtSql)
  @EntityMapping(parameters=EObjxNWContactMethodExtAllFields)
    int createEObjxNWContactMethodExt(EObjContactMethod e1, EObjxNWContactMethodExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Update one xNWContactMethod by EObjxNWContactMethodExt object.
   * @generated
   */
  @Update(sql=updateEObjxNWContactMethodExtSql)
  @EntityMapping(parameters=EObjxNWContactMethodExtUpdateFields)
    int updateEObjxNWContactMethodExt(EObjContactMethod e1, EObjxNWContactMethodExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Delete xNWContactMethod by parameters.
   * @generated
   */
  @Update(sql=deleteEObjxNWContactMethodExtSql)
  @EntityMapping(parameters=EObjxNWContactMethodExtKeyField)
  int deleteEObjxNWContactMethodExt(Long contactMethodIdPK);

}

