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
 * IBM-MDMWB-1.0-[65bf528d81250dd807962d454ab85e2b]
 */


package mdmnw.entityObject;

import java.util.Iterator;
import com.ibm.mdm.base.db.EntityMapping;
import com.ibm.pdq.annotation.Select;
import com.ibm.pdq.annotation.Update;

import com.dwl.tcrm.coreParty.entityObject.EObjPersonName;

import mdmnw.entityObject.EObjxNWPersonNameExt;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public interface EObjxNWPersonNameExtData {


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String getEObjxNWPersonNameExtSql = "select X_FULL_NAME, X_DEGREE, X_DEGREE_SOURCE, X_DEGREE_LAST_VERIFIED_DATE,  LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID from PERSONNAME where PERSON_NAME_ID = ? ";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String createEObjxNWPersonNameExtSql = "insert into PERSONNAME (LAST_USED_DT, LAST_VERIFIED_DT, END_DT, GIVEN_NAME_FOUR, GIVEN_NAME_ONE, GIVEN_NAME_THREE, GIVEN_NAME_TWO, LAST_NAME, PREFIX_DESC, PERSON_NAME_ID, CONT_ID, START_DT, SUFFIX_DESC, USE_STANDARD_IND, NAME_USAGE_TP_CD, PREFIX_NAME_TP_CD, GENERATION_TP_CD, SOURCE_IDENT_TP_CD, P_LAST_NAME, P_GIVEN_NAME_ONE, P_GIVEN_NAME_TWO, P_GIVEN_NAME_THREE, P_GIVEN_NAME_FOUR, X_FULL_NAME, X_DEGREE, X_DEGREE_SOURCE, X_DEGREE_LAST_VERIFIED_DATE, LAST_UPDATE_DT, LAST_UPDATE_USER, LAST_UPDATE_TX_ID) values( ?1.lastUsedDt, ?1.lastVerifiedDt, ?1.endDt, ?1.givenNameFour, ?1.givenNameOne, ?1.givenNameThree, ?1.givenNameTwo, ?1.lastName, ?1.prefixDesc, ?1.personNameIdPK, ?1.contId, ?1.startDt, ?1.suffixDesc, ?1.useStandardInd, ?1.nameUsageTpCd, ?1.prefixNameTpCd, ?1.generationTpCd, ?1.sourceIdentTpCd, ?1.pLastName, ?1.pGivenNameOne, ?1.pGivenNameTwo, ?1.pGivenNameThree, ?1.pGivenNameFour, ?2.x_Full_Name, ?2.xDegree, ?2.xDegree_Source, ?2.xDegree_LastVerifiedDate, ?1.lastUpdateDt, ?1.lastUpdateUser, ?1.lastUpdateTxId)";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String updateEObjxNWPersonNameExtSql = "update PERSONNAME set LAST_USED_DT = ?1.lastUsedDt, LAST_VERIFIED_DT = ?1.lastVerifiedDt, END_DT = ?1.endDt, GIVEN_NAME_FOUR = ?1.givenNameFour, GIVEN_NAME_ONE = ?1.givenNameOne, GIVEN_NAME_THREE = ?1.givenNameThree, GIVEN_NAME_TWO = ?1.givenNameTwo, LAST_NAME = ?1.lastName, PREFIX_DESC = ?1.prefixDesc, CONT_ID = ?1.contId, START_DT = ?1.startDt, SUFFIX_DESC = ?1.suffixDesc, USE_STANDARD_IND = ?1.useStandardInd, NAME_USAGE_TP_CD = ?1.nameUsageTpCd, PREFIX_NAME_TP_CD = ?1.prefixNameTpCd, GENERATION_TP_CD = ?1.generationTpCd, SOURCE_IDENT_TP_CD = ?1.sourceIdentTpCd, P_LAST_NAME = ?1.pLastName, P_GIVEN_NAME_ONE = ?1.pGivenNameOne, P_GIVEN_NAME_TWO = ?1.pGivenNameTwo, P_GIVEN_NAME_THREE = ?1.pGivenNameThree, P_GIVEN_NAME_FOUR = ?1.pGivenNameFour, X_FULL_NAME = ?2.x_Full_Name, X_DEGREE = ?2.xDegree, X_DEGREE_SOURCE = ?2.xDegree_Source, X_DEGREE_LAST_VERIFIED_DATE = ?2.xDegree_LastVerifiedDate, LAST_UPDATE_DT = ?1.lastUpdateDt, LAST_UPDATE_USER = ?1.lastUpdateUser, LAST_UPDATE_TX_ID = ?1.lastUpdateTxId where PERSON_NAME_ID = ?1.personNameIdPK and LAST_UPDATE_DT = ?1.oldLastUpdateDt";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String deleteEObjxNWPersonNameExtSql = "delete from PERSONNAME where PERSON_NAME_ID = ?";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonNameExtKeyField = "EObjxNWPersonNameExt.personNameIdPK";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonNameExtGetFields =
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
  public static final String EObjxNWPersonNameExtAllFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUsedDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastVerifiedDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.endDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameFour," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameTwo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.prefixDesc," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.personNameIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.contId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.startDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.suffixDesc," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.useStandardInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.nameUsageTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.prefixNameTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.generationTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.sourceIdentTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pLastName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameTwo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameFour," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.x_Full_Name," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.xDegree," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.xDegree_Source," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.xDegree_LastVerifiedDate," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUpdateTxId";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String EObjxNWPersonNameExtUpdateFields =
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUsedDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastVerifiedDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.endDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameFour," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.givenNameTwo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.prefixDesc," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.contId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.startDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.suffixDesc," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.useStandardInd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.nameUsageTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.prefixNameTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.generationTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.sourceIdentTpCd," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pLastName," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameOne," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameTwo," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameThree," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.pGivenNameFour," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.x_Full_Name," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.xDegree," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.xDegree_Source," +
    "mdmnw.entityObject.EObjxNWPersonNameExt.xDegree_LastVerifiedDate," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUpdateDt," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUpdateUser," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.lastUpdateTxId," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.personNameIdPK," +
    "com.dwl.tcrm.coreParty.entityObject.EObjPersonName.oldLastUpdateDt";   

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Select xNWPersonName by parameters.
   * @generated
   */
  @Select(sql=getEObjxNWPersonNameExtSql)
  @EntityMapping(parameters=EObjxNWPersonNameExtKeyField, results=EObjxNWPersonNameExtGetFields)
  Iterator<EObjxNWPersonNameExt> getEObjxNWPersonNameExt(Long personNameIdPK);  
   
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Create xNWPersonName by EObjxNWPersonNameExt Object.
   * @generated
   */
  @Update(sql=createEObjxNWPersonNameExtSql)
  @EntityMapping(parameters=EObjxNWPersonNameExtAllFields)
    int createEObjxNWPersonNameExt(EObjPersonName e1, EObjxNWPersonNameExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Update one xNWPersonName by EObjxNWPersonNameExt object.
   * @generated
   */
  @Update(sql=updateEObjxNWPersonNameExtSql)
  @EntityMapping(parameters=EObjxNWPersonNameExtUpdateFields)
    int updateEObjxNWPersonNameExt(EObjPersonName e1, EObjxNWPersonNameExt e2); 

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
    * Delete xNWPersonName by parameters.
   * @generated
   */
  @Update(sql=deleteEObjxNWPersonNameExtSql)
  @EntityMapping(parameters=EObjxNWPersonNameExtKeyField)
  int deleteEObjxNWPersonNameExt(Long personNameIdPK);

}

