/* _______________________________________________________ {COPYRIGHT-TOP} _____
* Licensed Materials - Property of IBM
* Restricted Materials of IBM
*
* 5725-E59
*
* (C) Copyright IBM Corp. 2004, 2014  All Rights Reserved.
*
* US Government Users Restricted Rights - Use, duplication, or
* disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
* ________________________________________________________ {COPYRIGHT-END} _____*/
/* ______________________________________________________________________
 *
 * Copyright (c) 2004 DWL Inc. All Rights Reserved.
 * http://www.dwl.com
 *
 * The source code for this software is confidential and proprietary.
 * You shall not disclose such confidential information and shall use
 * it only in accordance with the terms of the license agreement you
 * have with DWL.
 * ______________________________________________________________________
 */

/***************************************************
 * RCSID -- $RCSfile: SuspectAddPartyRule.java,v $
 *          $Revision: 1.8.4.10 $
 *          $Date: 2011/09/26 22:24:29 $
 *          $Author: cgheorgh $
 *          DWL Inc.
 ***************************************************/

package mdmnw.externalrule;

import java.util.Vector;

import mdmnw.component.XNWPersonBObjExt;
import mdmnw.compositeTxn.MaintainNWPersonCompositeTxnBP;
import mdmnw.constant.MdmConstants;
import mdmnw.utils.CommonUtil;

import com.dwl.base.DWLControl;
import com.dwl.base.DWLResponse;
import com.dwl.base.accessToken.AccessTokenCollection;
import com.dwl.base.externalrule.Rule;
import com.dwl.base.logging.DWLLoggerManager;
import com.dwl.base.logging.IDWLLogger;
import com.dwl.base.util.StringUtils;
import com.dwl.management.config.client.Configuration;
import com.dwl.tcrm.coreParty.component.BasicPartyInfo;
import com.dwl.tcrm.coreParty.component.CategorizedSuspects;
import com.dwl.tcrm.coreParty.component.TCRMPartyBObj;
import com.dwl.tcrm.coreParty.component.TCRMSuspectBObj;
import com.dwl.tcrm.coreParty.constant.TCRMCorePropertyKeys;
import com.dwl.tcrm.coreParty.interfaces.IParty;
import com.dwl.tcrm.coreParty.interfaces.ISuspectProcessor;
import com.dwl.tcrm.exception.TCRMException;
import com.dwl.tcrm.utilities.TCRMClassFactory;
import com.ibm.mdm.eme.party.util.EMEPartyUtil;


/**
 * **********************************************************************
 * Description: This class is used to control the logic of what happens when a record is added 
 * and a matching record is found for it after MDM doing record-matching on the database
 * **********************************************************************
 *  
 * External Rule 35.
 * <p>
 * An external rule for adding a party based on the suspects found.
 * 
 * 
 * @since 5.0
 * @modelguid {48EEC273-03AB-411E-B2A2-30146C67204A}
 */
//NOTE: OUT OF BOX DEFAULT BEHAVIOR/CODE PRESERVED. NO CHANGES WERE MADE.
public class SuspectAddPartyRule extends Rule {
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2004, 2014\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";

	private static final String BEST_A1_PERSISTED = "10";
    private static final String A1_NOT_USED_BECAUSE_OF_AccessTOken = "11";
	private static final String BEST_FILITERED_SUSPECT_RULE_ID = "111";

	/** @modelguid {689AD027-27FF-4D44-9ADB-A76FABDE5918} */
	private final static IDWLLogger logger = DWLLoggerManager
			.getLogger(SuspectAddPartyRule.class);

	private static final String PERSIST_DUPLICATE_PARTIES = "/IBM/Party/SuspectProcessing/PersistDuplicateParties/enabled";

	private static final String RETURN_SUSPECT_ENABLED = "/IBM/Party/SuspectProcessing/AddParty/returnSuspect";

	private final static String PARTY_CDC_PROCESSING = "/IBM/Party/CriticalDataChangeProcessing/enabled";

	/** @modelguid {7724E739-D031-485C-9729-6C7E04CB792F} */

	/** @modelguid {E48883EF-9C69-4015-AF5A-C884D8F76829} */
	String rulesetName = "SuspectAddParty";

	/** @modelguid {E2D7C327-E4E1-4E95-B6E2-F0EC2F4E2354} */
	String rulesetVersion = " 5.0 ";

	/** @modelguid {E18B8C26-3427-4D33-B623-ACA25CCF00D8} */
	boolean debugOn = true;

	/** @modelguid {A0BBAF38-47DF-448C-BEBB-7CF9962AB2EE} */
	protected boolean coReturnMandatorySearchResults = true;

	/** @modelguid {CBBF9448-A728-45C5-A872-3CC94342B388} */
	protected boolean existingPartyProvided = false;

	private final static String ERROR_MESSAGE = "Error_Shared_Execute";

	private CollapsePartiesWithRules collapseWRules = new CollapsePartiesWithRules();
	/**
	 * Constructor for SuspectAddPartyRule.
	 * 
	 * @modelguid {BDBF15A5-C589-4BF1-A6AE-C43C5AECE398}
	 */
	public SuspectAddPartyRule() {
		super();
	}

	/**
	 * @param input
	 *            A <code>Vector</code> passed by the caller. The first element 
	 *            is an instance of a party object. The second element is itself
	 *            a <code>Vector</code> of <code>CategorizedSuspect</code> objects.
	 * @param componentObject
	 *            Not used currently
	 * @return An instance of <code>TCRMPartyBObj</code>
	 * 
	 * @modelguid {552CD3BE-79F1-4118-B076-E4A6A6E8A6DD}
	 */
	public Object execute(Object input, Object componentObject)
			throws Exception {
		MaintainNWPersonCompositeTxnBP maintainBP = new MaintainNWPersonCompositeTxnBP();

		if (logger.isFineEnabled()) {
			logger.fine("External Java Rule 35 - SuspectAddPartyRule fired");
		}

		Vector vecInputElements = new Vector();
		TCRMPartyBObj theSourcePartyBObj = null;
		boolean partyAdded = false;
		boolean isA1SuspectAddPartyStatusSet = false; // used to determine if the add party status was set for the highest suspect category. 
		CommonUtil commonUtil = new CommonUtil();
		
		try {
			if (input instanceof Vector) {
				vecInputElements = (Vector) input;
			}

			theSourcePartyBObj = (TCRMPartyBObj) vecInputElements.elementAt(0);
			DWLControl theDWLControl = theSourcePartyBObj.getControl();

			// USE CONFIGURATION CLIENT
			coReturnMandatorySearchResults = Configuration.getConfiguration()
					.getConfigItem(RETURN_SUSPECT_ENABLED,
							theDWLControl.retrieveConfigContext())
					.getBooleanValue();
			boolean coPersistDuplicateParties = Configuration
					.getConfiguration().getConfigItem(PERSIST_DUPLICATE_PARTIES,
							theDWLControl.retrieveConfigContext())
					.getBooleanValue();

			if (StringUtils.isNonBlank(theSourcePartyBObj.getPartyId())) {
				// an existing party identified by the partyId was provided.
				existingPartyProvided = true;
			}

			if ((vecInputElements != null) && (vecInputElements.size() != 0)) {
				IParty partyComp = (IParty) TCRMClassFactory
						.getTCRMComponent(TCRMCorePropertyKeys.PARTY_COMPONENT);

				// Note: in vecCategorizedSuspects, you can have category A1, or
				// categories (A2/B)
				// but not categories(A1/A2/B)

				Vector vecCategorizedSuspects = (Vector) vecInputElements
						.elementAt(1);

				if ((vecCategorizedSuspects != null)
						&& (vecCategorizedSuspects.size() != 0)) {

					for (int i = 0; i < vecCategorizedSuspects.size(); i++) {

						CategorizedSuspects aCategoryOfSuspects = (CategorizedSuspects) vecCategorizedSuspects
								.elementAt(i);

						// 1. get the suspect category type (i.e., 1 - A1, 2 -
						// A2, 3 - B, 4 - C)
						String theSuspectCategoryType = aCategoryOfSuspects.getCdSuspectTp();
						
						// 2. Determine what action to take with the party -
						// either add or call a rule to update it.

						// 3. a) Deal with the case if it is an A1 match
						// (suspect type 1)
						boolean satisfiesACase = false;

						if (theSuspectCategoryType.trim().equalsIgnoreCase("1")) {
							
							Vector vecA1Suspects = aCategoryOfSuspects
									.getTCRMSuspectBObjs();
							
							TCRMSuspectBObj theBestA1MatchedSuspect = null;
							Vector vecNonCDCA1Suspect = filterAccessTokenA1Suspects(vecA1Suspects,theSourcePartyBObj.getPartyType(), theDWLControl);
							// 1. Case: There is more than one A1 match found
							if (vecNonCDCA1Suspect.size() > 1) {
								ISuspectProcessor suspComp = (ISuspectProcessor) TCRMClassFactory
										.getTCRMComponent(TCRMCorePropertyKeys.SUSPECT_COMPONENT);
								// 1. Get the A1 Matched Suspect that most
								// closely matches the source party.
								// Ensure that this one does not have a suspect
								// record added for it.

								if (coPersistDuplicateParties) {
									// Call external rule
									// BestFilteredSuspectsRule to compare the
									// LOBRelatedType
									Vector input2 = new Vector();
									input2.add(theSourcePartyBObj);
									input2.add(vecNonCDCA1Suspect);

//									theBestA1MatchedSuspect = (TCRMSuspectBObj) SuspectProcessingUtil
//											.callExternalRule(
//													input2,
//													BEST_FILITERED_SUSPECT_RULE_ID,
//													theSourcePartyBObj
//															.getStatus(),
//													theSourcePartyBObj
//															.getControl());
								} else {
									int col = suspComp
											.getHighestMatchRelevancyScoredParty(vecNonCDCA1Suspect);

									theBestA1MatchedSuspect = (TCRMSuspectBObj) vecNonCDCA1Suspect
											.elementAt(col);
								}

								/** if (theBestA1MatchedSuspect != null) {
									if (theSourcePartyBObj.getPartyType()
											.equalsIgnoreCase("O")) {
										a1Suspect = (TCRMSuspectOrganizationBObj) theBestA1MatchedSuspect
												.getTCRMSuspectOrganizationBObj();
									} else {
										a1Suspect = (TCRMSuspectPersonBObj) theBestA1MatchedSuspect
												.getTCRMSuspectPersonBObj();
									}
								} */

								theSourcePartyBObj.setAddPartyStatus("8");
							} else if (vecNonCDCA1Suspect.size() == 1) {
								// 2. Case: Only one A1 Match
								if (coPersistDuplicateParties) {
									// Call external rule
									// BestFilteredSuspectsRule to compare the
									// LOBRelatedType
									Vector input2 = new Vector();
									input2.add(theSourcePartyBObj);
									input2.add(vecNonCDCA1Suspect);

//									theBestA1MatchedSuspect = (TCRMSuspectBObj) SuspectProcessingUtil
//											.callExternalRule(
//													input2,
//													BEST_FILITERED_SUSPECT_RULE_ID,
//													theSourcePartyBObj
//															.getStatus(),
//													theSourcePartyBObj
//															.getControl());
								} else {
									theBestA1MatchedSuspect = (TCRMSuspectBObj) vecNonCDCA1Suspect
											.elementAt(0);
								}

								/** if (theBestA1MatchedSuspect != null) {
									if (theSourcePartyBObj.getPartyType()
											.equalsIgnoreCase("O")) {
										a1Suspect = (TCRMSuspectOrganizationBObj) theBestA1MatchedSuspect
												.getTCRMSuspectOrganizationBObj();
									} else {
										a1Suspect = (TCRMSuspectPersonBObj) theBestA1MatchedSuspect
												.getTCRMSuspectPersonBObj();
									} 
								} */

								theSourcePartyBObj.setAddPartyStatus("3");
							}

							satisfiesACase = true;
							if (vecNonCDCA1Suspect.size() >= 1) {
//							if (true == false) {
								// Now that you know which A1 match you're going
								// to use to update/add; if configured to do
								// conditional persistence of duplicates:
								// see if any suspect party (all the A1 matches)
								// has the same or different LOB as the source
								// party
								// If there is a different LOB, add the A1 match
								// party; if it is the same, update the A1 match
								// party.
								// 
								// when a1Suspect == null, which is returned by
								// rule BEST_FILITERED_SUSPECT_RULE_ID, means
								// there is different LOBs; if a1Suspect !=
								// null, means there is same LOB between source
								// party and
								// the best A1 matches (vector of suspects)
								if (coPersistDuplicateParties
										&& theBestA1MatchedSuspect == null) { // there is
									// different LOB
									// between
									// source party
									// and the best
									// A1 match
									// suspect party
									// (vector of
									// suspects)
									// BEST_A1_PERSISTED "10" is a new status,
									// indicating best A1 match suspect was
									// persisted.
									theSourcePartyBObj.setAddPartyStatus(BEST_A1_PERSISTED);
									if (!partyAdded) {										
										partyComp
												.addPartySimple(theSourcePartyBObj);
									}
								} else {
										
//							        TCRMPartyBObj a1SuspectParty = EMEPartyUtil.getSuspectParty(theBestA1MatchedSuspect,"5");
							        
									Vector<String> params2 = new Vector<String>();
									String partyid = theBestA1MatchedSuspect.getSuspectPartyId();
									params2.add(partyid);
									params2.add(MdmConstants.INQRY_LVL_5);

									CommonUtil util = new CommonUtil();
									// execute get person transaction
									DWLResponse response2 = util.invokeBaseInquiryTxn(MdmConstants.TXN_GETPERSON, params2, theSourcePartyBObj.getControl());

									// get person as XNWPersonBObjExt object and set last update dates in order to be able to update the object
									TCRMPartyBObj a1SuspectParty = (XNWPersonBObjExt)response2.getData();

							        
							        /** if (theSourcePartyBObj.getPartyType()
											.equalsIgnoreCase("O")) {
										a1Suspect = (TCRMSuspectOrganizationBObj) theBestA1MatchedSuspect
												.getTCRMSuspectOrganizationBObj();
									} else {
										a1Suspect = (TCRMSuspectPersonBObj) theBestA1MatchedSuspect
												.getTCRMSuspectPersonBObj();
									} */
			   
									maintainBP.processInput((XNWPersonBObjExt)theSourcePartyBObj, theSourcePartyBObj.getControl(), a1SuspectParty.getPartyId());
//							        theSourcePartyBObj.setTCRMSuspectBObj(theBestA1MatchedSuspect);
//							        	partyComp
//											.updatePartyDetails(
//													theSourcePartyBObj,
//													a1SuspectParty);						        	
							        	
									if (theSourcePartyBObj.isRedundantUpdate())
										theSourcePartyBObj.setPartyLastUpdateTxId(a1SuspectParty.getPartyLastUpdateTxId());
								}
							} else {
								// Because we filter out non CDC A1, it is
								// possible that
								// we had 1 or many A1 coming in. But because of
								// the filter we could end up having no A1.
								// In this case, simply add
			   	  				theSourcePartyBObj.setAddPartyStatus(A1_NOT_USED_BECAUSE_OF_AccessTOken);
								if (!partyAdded) {
									partyComp.addPartySimple(theSourcePartyBObj);
								}
							}

							// set the partyAdded to true so we dont add the party again when processing the A2 and B suspects.
							// we dont want to add the party when processing the A2 and B suspects if we've updated the A1 suspect
							// we also want to keep the addPartyStatus from the highest suspect category, A1 
							partyAdded = true;
							isA1SuspectAddPartyStatusSet = true;
							
						}

						// 3. b) Deal with the case if it is an A2 match
						// (suspect type 2)
						if (theSuspectCategoryType.trim().equalsIgnoreCase("2")) {
							if (existingPartyProvided) {
								if (!partyAdded) {
									partyComp
											.addPartySimple(theSourcePartyBObj);
									partyAdded = true;
								}

								if(!isA1SuspectAddPartyStatusSet)
									theSourcePartyBObj.setAddPartyStatus("6");
							} else {
								if (((theSourcePartyBObj
										.getMandatorySearchDone() == null) || (!(theSourcePartyBObj
										.getMandatorySearchDone()
										.equalsIgnoreCase("Y"))))
										&& (coReturnMandatorySearchResults)) {
									if(!isA1SuspectAddPartyStatusSet)
										theSourcePartyBObj.setAddPartyStatus("7");
								} else {
									if (!partyAdded) {
										partyComp
												.addPartySimple(theSourcePartyBObj);
										partyAdded = true;
									}

									if (coReturnMandatorySearchResults) {
										theSourcePartyBObj
												.setMandatorySearchDone("Y");
									}

									if(!isA1SuspectAddPartyStatusSet)
										theSourcePartyBObj.setAddPartyStatus("6");
								}
							}

							satisfiesACase = true;
						}

						// 3. c) Deal with the case if it is an B match (suspect
						// type 3)
						if (theSuspectCategoryType.trim().equalsIgnoreCase("3")) {
							if (((theSourcePartyBObj.getMandatorySearchDone() == null) || (!(theSourcePartyBObj
									.getMandatorySearchDone()
									.equalsIgnoreCase("Y"))))
									&& (coReturnMandatorySearchResults)
									&& (vecCategorizedSuspects.size() > 1)) {

								// If we found multiple categories of suspects
								// and mandatory suspect flag is not Y,
								// let other categories determine how to handle
								// this party.
								continue;
							}

							// 1. There is at one B-level suspect so add the
							// source party
							if (!partyAdded) {
								partyComp.addPartySimple(theSourcePartyBObj);
								partyAdded = true;
							}

							if(!isA1SuspectAddPartyStatusSet)
								theSourcePartyBObj.setAddPartyStatus("2");

							if (coReturnMandatorySearchResults) {
								theSourcePartyBObj.setMandatorySearchDone("Y");
							}

							satisfiesACase = true;
						}

						// 3. d) None of the above cases are satisfied, so no
						// suspects were found.
						// Add the party
						if (!(satisfiesACase)) {
							// no suspects found at all, so simply add the party
							if (!partyAdded) {
								partyComp.addPartySimple(theSourcePartyBObj);
								partyAdded = true;
							}

							if (coReturnMandatorySearchResults) {
								theSourcePartyBObj.setMandatorySearchDone("Y");
							}

							if(!isA1SuspectAddPartyStatusSet)
								theSourcePartyBObj.setAddPartyStatus("1");

							theSourcePartyBObj.vecTCRMSuspectBObj
									.removeAllElements();
						}
					}
				}
			}
		} catch (Exception ex) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(ex);
//			if (logger.isErrorEnabled())
//				logger.error(ResourceBundleHelper.resolve(
//					ResourceBundleNames.DEFAULT_EXTERNAL_RULES_STRINGS,
//					ERROR_MESSAGE, new Object[] { this.getClass().getName(),
//							ex.getLocalizedMessage() }));

			if (ex instanceof TCRMException) {
				TCRMException tcrmEx = (TCRMException) ex;
				throw tcrmEx;
			} else {
				throw ex;
			}
		}

		return theSourcePartyBObj;
	}

	/*
	 * Check the pending CDC indicator on each suspect and don't consider it if
	 * it has CDC
	 */
	//lily todo : no reference, need to clean it
	private Vector filterCDCA1Suspects(Vector vecA1Suspects, IParty partyComp,
			DWLControl control) throws Exception {

		// Only applicable if the CDC processing feature
		// is turned on
		boolean cdcProcessing = Configuration.getConfiguration().getConfigItem(
				PARTY_CDC_PROCESSING, control.retrieveConfigContext())
				.getBooleanValue();
		if (!cdcProcessing) {
			return vecA1Suspects;
		}

		Vector vecNonCDCA1Suspects = new Vector(vecA1Suspects.size());

		for (int i = 0; i < vecA1Suspects.size(); i++) {
			TCRMSuspectBObj suspect = (TCRMSuspectBObj) vecA1Suspects.get(i);

			String partyId = suspect.getSuspectPartyId();
			BasicPartyInfo partyInfo = partyComp.getPartyBasicInfo(partyId, control);
			if (partyInfo.getPendingCDCInd() == null
					|| partyInfo.getPendingCDCInd().equalsIgnoreCase("N")) {
				vecNonCDCA1Suspects.add(suspect);
			}
		}

		return vecNonCDCA1Suspects;
	}

    private Vector filterAccessTokenA1Suspects(Vector vecA1Suspects, String strPartyType, DWLControl objControl) throws Exception 
	{	
        //return, if the AccessToken check is off
    	if(!objControl.isAccessTokenEnforced() )
        {
        	return vecA1Suspects;
        }
        
     Vector vecAccessTokenA1Suspects = new Vector();
      
      if(vecA1Suspects  != null)
      {
    	
      	for(int i=0; i< vecA1Suspects.size(); i++)
      	{
      		TCRMSuspectBObj objSuspect = (TCRMSuspectBObj) vecA1Suspects.get(i);
      		/**TCRMPartyBObj objA1SuspectParty = null;
      		
      		if (strPartyType.equalsIgnoreCase("O")){
      			objA1SuspectParty = (TCRMSuspectOrganizationBObj)objSuspect.getTCRMSuspectOrganizationBObj();
            }else{
            	objA1SuspectParty = (TCRMSuspectPersonBObj)objSuspect.getTCRMSuspectPersonBObj();
            }
      		
      		String strAccessTokenValue = objA1SuspectParty.getAccessTokenValue(); **/
      		
      		String strAccessTokenValue =EMEPartyUtil.getAccessTokenValueForSuspectParty(objSuspect);
      		
	  		AccessTokenCollection objAccessTokenCollection =  objControl.getAccessTokenCollection();
	  		if(objAccessTokenCollection != null && StringUtils.isNonBlank(strAccessTokenValue) && !objAccessTokenCollection.contains(strAccessTokenValue))
	  		{
              continue;	
	  		}
	  		else
	  		{
	  			vecAccessTokenA1Suspects.add(objSuspect);
	  		}
      	}
      }
      return vecAccessTokenA1Suspects;
    }
}
