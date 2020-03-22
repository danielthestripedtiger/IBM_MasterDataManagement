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
 * Copyright (c) 2003 DWL Inc. All Rights Reserved.
 * http://www.dwl.com
 *
 * The source code for this software is confidential and proprietary.
 * You shall not disclose such confidential information and shall use
 * it only in accordance with the terms of the license agreement you
 * have with DWL.
 * ______________________________________________________________________
 */
// NOTE: OUT OF BOX DEFAULT BEHAVIOR/CODE PRESERVED. NO CHANGES WERE MADE.
package mdmnw.externalrule;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.dwl.base.IDWLErrorMessage;
import com.dwl.base.error.DWLStatus;
import com.dwl.base.externalrule.Rule;
import com.dwl.base.logging.DWLLoggerManager;
import com.dwl.base.logging.IDWLLogger;
import com.dwl.base.util.DWLExceptionUtils;
import com.dwl.common.globalization.util.ResourceBundleHelper;
import com.dwl.tcrm.businessServices.component.TCRMAlertBObj;
import com.dwl.tcrm.businessServices.component.TCRMEntityInstancePrivPrefBObj;
import com.dwl.tcrm.common.TCRMErrorCode;
import com.dwl.tcrm.coreParty.component.TCRMAddressBObj;
import com.dwl.tcrm.coreParty.component.TCRMAddressStandardizerManager;
import com.dwl.tcrm.coreParty.component.TCRMAdminContEquivBObj;
import com.dwl.tcrm.coreParty.component.TCRMContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMFinancialProfileBObj;
import com.dwl.tcrm.coreParty.component.TCRMIncomeSourceBObj;
import com.dwl.tcrm.coreParty.component.TCRMOrganizationBObj;
import com.dwl.tcrm.coreParty.component.TCRMOrganizationNameBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyAddressBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyAddressPrivPrefBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyBankAccountBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyChargeCardBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodPrivPrefBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyIdentificationBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyLobRelationshipBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyLocationPrivPrefBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyPayrollDeductionBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyPrivPrefBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyRelationshipBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyValueBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonNameBObj;
import com.dwl.tcrm.coreParty.component.TCRMPhoneNumberBObj;
import com.dwl.tcrm.coreParty.constant.TCRMCoreComponentID;
import com.dwl.tcrm.coreParty.constant.TCRMCoreErrorReasonCode;
import com.dwl.tcrm.coreParty.constant.TCRMCorePropertyKeys;
import com.dwl.tcrm.coreParty.interfaces.IAddressStandardizer;
import com.dwl.tcrm.coreParty.interfaces.IParty;
import com.dwl.tcrm.exception.TCRMDataInvalidException;
import com.dwl.tcrm.exception.TCRMException;
import com.dwl.tcrm.utilities.TCRMClassFactory;

/**
 * 
 * ********************************************************************
 * NOTE: This is the out-of-the-box update logic for MDM
 * It has been externalized in case adjustments to the default update logic ever needs to be made
 * ********************************************************************
 * 
 * External Rule 6.
 * <p>
 * The PartyUpdateExtRule provides merging rules for the case where a party
 * already exists and all child objects are to be updated. The rule checks the
 * business keys of each object and where they match, the incoming/new object is
 * set to update. This is generally done by setting fields mandatory for
 * updating each object on the incoming/new object. Each object has a merge
 * method that handles this merging.
 * <p>
 * When overriding the method, ensure that the source object has the appropriate
 * PK, last update date, and last update transaction ids provided at minimum.
 * Certain objects (i.e., relationship, addresses) require additional fields to
 * be supplied. Reference the transaction reference guide to determine the
 * fields mandatory for conducting updates on these objects.
 * <p>
 * This rule gets called as a part of the SuspectAddPartyRule when exactly one
 * suspect (A1 or guaranteed duplicate) has been found.
 * 
 * @since 5.0
 */
public class PartyUpdateExtRule extends Rule {
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2004, 2014\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";


	private final static IDWLLogger logger = DWLLoggerManager
			.getLogger(PartyUpdateExtRule.class);

	IDWLErrorMessage errHandler;

	String rulesetName = "PartyUpdateExtRule";

	String rulesetVersion = " 5.0 ";

	boolean debugOn = true;

	protected DWLExceptionUtils aDWLExceptionUtils = null;

	private final static String ERROR_MESSAGE = "Error_Shared_Execute";

	private final static String ERROR_UPDATE_METHOD = "Error_Shared_Method";

	private static final String INFO_PARTY_UPDATE_FIRED = "Info_PartyUpdateExtRule_PartyUpdateFired";

	/**
	 * Constructor for PartyUpdateExtRule.
	 */
	public PartyUpdateExtRule() {
		super();
		errHandler = TCRMClassFactory.getErrorHandler();

		aDWLExceptionUtils = new DWLExceptionUtils();
	}

	/*
	 * (non-javadoc)
	 * 
	 * @see com.dwl.base.externalrule.IExternalJavaRule#execute(Object, Object)
	 */
	public Object execute(Object input, Object componentObject)
			throws Exception {

		DWLStatus status = new DWLStatus();

		if (logger.isInfoEnabled()) {
//			logger.info(ResourceBundleHelper.resolve(ResourceBundleNames.DEFAULT_EXTERNAL_RULES_STRINGS, INFO_PARTY_UPDATE_FIRED, new Object [] { rulesetName }));	
		/*	logger.info("External Java Rule 6 - " + rulesetName
					+ " (Party Update) fired");*/
		}

		TCRMPartyBObj resultTCRMPartyBObj = null;
		Vector vecTCRMPartyBObj = null;

		try {

			if (input instanceof Vector) {
				vecTCRMPartyBObj = (Vector) input;
			}

			if ((vecTCRMPartyBObj != null) && (vecTCRMPartyBObj.size() != 0)) {

				TCRMPartyBObj theSourceTCRMPartyBObj = (TCRMPartyBObj) vecTCRMPartyBObj
						.elementAt(0);
				TCRMPartyBObj theTargetTCRMPartyBObj = (TCRMPartyBObj) vecTCRMPartyBObj
						.elementAt(1);

				if (theSourceTCRMPartyBObj.getPartyType().equalsIgnoreCase("P")) {
					updatePartyDetails(theSourceTCRMPartyBObj,
							theTargetTCRMPartyBObj);
					resultTCRMPartyBObj = updatePersonDetails(
							theSourceTCRMPartyBObj, theTargetTCRMPartyBObj);
				}

				if (theSourceTCRMPartyBObj.getPartyType().equalsIgnoreCase("O")) {
					updatePartyDetails(theSourceTCRMPartyBObj,
							theTargetTCRMPartyBObj);
					resultTCRMPartyBObj = updateOrgDetails(
							theSourceTCRMPartyBObj, theTargetTCRMPartyBObj);
				}
			}

			if (resultTCRMPartyBObj == null) {

			}
		} catch (Exception ex) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(ex);
			if (logger.isErrorEnabled())
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

		return resultTCRMPartyBObj;
	}

	/**
	 * Method updatePartyDetails.
	 * 
	 * @param theSourceTCRMPartyBObj
	 * @param theTargetTCRMPartyBObj
	 */
	protected void updatePartyDetails(TCRMPartyBObj theSourceTCRMPartyBObj,
			TCRMPartyBObj theTargetTCRMPartyBObj) throws Exception {

		DWLStatus status = new DWLStatus();

		try {

			// merge TCRMPartyAddressBObj and TCRMAddressBObj
			Vector vecSourcePartyAddressBObj = theSourceTCRMPartyBObj
					.getItemsTCRMPartyAddressBObj();
			Vector vecTargetPartyAddressBObj = theTargetTCRMPartyBObj
					.getItemsTCRMPartyAddressBObj();
			mergePartyAddressBObj(vecSourcePartyAddressBObj,
					vecTargetPartyAddressBObj);

			// merge TCRMPartyContactMethodBObj and TCRMContactMethodBObj
			Vector vecSourcePartyContactMethodBObj = theSourceTCRMPartyBObj
					.getItemsTCRMPartyContactMethodBObj();
			Vector vecTargetPartyContactMethodBObj = theTargetTCRMPartyBObj
					.getItemsTCRMPartyContactMethodBObj();
			mergePartyContactMethodBObj(vecSourcePartyContactMethodBObj,
					vecTargetPartyContactMethodBObj);

			// merge TCRMPartyIdentificationBObj
			Vector vecSourcePartyIdentification = theSourceTCRMPartyBObj
					.getItemsTCRMPartyIdentificationBObj();
			Vector vecTargetPartyIdentification = theTargetTCRMPartyBObj
					.getItemsTCRMPartyIdentificationBObj();
			mergePartyIdentificationBObj(vecSourcePartyIdentification,
					vecTargetPartyIdentification);

			// merge TCRMAlertBObj
			Vector vecSourceAlertBObj = theSourceTCRMPartyBObj
					.getItemsTCRMAlertBObj();
			Vector vecTargetAlertBObj = theTargetTCRMPartyBObj
					.getItemsTCRMAlertBObj();
			mergeAlertBObj(vecSourceAlertBObj, vecTargetAlertBObj);

			// merge TCRMAdminContEquivBObj
			Vector vecSourceAdminContEquivBObj = theSourceTCRMPartyBObj
					.getItemsTCRMAdminContEquivBObj();
			Vector vecTargetAdminContEquivBObj = theTargetTCRMPartyBObj
					.getItemsTCRMAdminContEquivBObj();
			mergeAdminContEquivBObj(vecSourceAdminContEquivBObj,
					vecTargetAdminContEquivBObj);

			// merge TCRMPartyRelationshipBObj
			Vector vecSourcePartyRelationshipBObj = theSourceTCRMPartyBObj
					.getItemsTCRMPartyRelationshipBObj();
			Vector vecTargetPartyRelationshipBObj = theTargetTCRMPartyBObj
					.getItemsTCRMPartyRelationshipBObj();
			mergePartyRelationshipBObj(vecSourcePartyRelationshipBObj,
					vecTargetPartyRelationshipBObj);

			// merge TCRMPartyLobRelationshipBObj
			Vector vecSourcePartyLobRelBObj = theSourceTCRMPartyBObj
					.getItemsTCRMPartyLobRelationshipBObj();
			Vector vecTargetPartyLobRelBObj = theTargetTCRMPartyBObj
					.getItemsTCRMPartyLobRelationshipBObj();
			mergePartyLobRelBObj(vecSourcePartyLobRelBObj,
					vecTargetPartyLobRelBObj);

			// merge TCRMPartyPrivPrefBObj
			Vector vecSourcePartyPrivPrefBObj = theSourceTCRMPartyBObj
					.getItemsTCRMPartyPrivPrefBObj();
			Vector vecTargetPartyPrivPrefBObj = theTargetTCRMPartyBObj
					.getItemsTCRMPartyPrivPrefBObj();
			mergePrivacyPreferenceBObj(vecSourcePartyPrivPrefBObj,
					vecTargetPartyPrivPrefBObj);

			TCRMFinancialProfileBObj theSourceTCRMFinancialProfileBObj = theSourceTCRMPartyBObj
					.getTCRMFinancialProfileBObj();
			TCRMFinancialProfileBObj theTargetTCRMFinancialProfileBObj = theTargetTCRMPartyBObj
					.getTCRMFinancialProfileBObj();

			if ((theSourceTCRMFinancialProfileBObj != null)
					&& (theTargetTCRMFinancialProfileBObj != null)) {

				// merge TCRMPartyChargeCard
				Vector vecSourceChargeCardBObj = theSourceTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMPartyChargeCardBObj();
				Vector vecTargetChargeCardBObj = theTargetTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMPartyChargeCardBObj();
				mergePartyChargeCardBObj(vecSourceChargeCardBObj,
						vecTargetChargeCardBObj);

				// merge TCRMPartyBankAccount
				Vector vecSourceBankAccountBObj = theSourceTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMPartyBankAccountBObj();
				Vector vecTargetBankAccountBObj = theTargetTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMPartyBankAccountBObj();
				mergePartyBankAccountBObj(vecSourceBankAccountBObj,
						vecTargetBankAccountBObj);

				// merge TCRMPartyPayrollDeduction
				Vector vecSourcePayrollDeductionBObj = theSourceTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMPartyPayrollDeductionBObj();
				Vector vecTargetPayrollDeductionBObj = theTargetTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMPartyPayrollDeductionBObj();
				mergePartyPayrollDeductionBObj(vecSourcePayrollDeductionBObj,
						vecTargetPayrollDeductionBObj);

				// merge TCRMIncomeSource
				Vector vecSourceIncomeSourceBObj = theSourceTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMIncomeSourceBObj();
				Vector vecTargetIncomeSourceBObj = theTargetTCRMPartyBObj
						.getTCRMFinancialProfileBObj()
						.getItemsTCRMIncomeSourceBObj();
				mergeIncomeSourceBObj(vecSourceIncomeSourceBObj,
						vecTargetIncomeSourceBObj);
			}

			// merge TCRMPartyValue, source is the incoming one trying to
			// add
			Vector vecSourcePartyValueBObj = theSourceTCRMPartyBObj
					.getItemsTCRMPartyValueBObj();

			Vector vecTargetPartyValueBObj = theTargetTCRMPartyBObj
					.getItemsTCRMPartyValueBObj();

			mergePartyValueBObj(vecSourcePartyValueBObj,
					vecTargetPartyValueBObj);

		} catch (TCRMException tcrmEx) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(tcrmEx);
			throw tcrmEx;
		} catch (Exception ex) {
			com.dwl.base.util.DWLExceptionUtils.log(ex);
//			if (logger.isErrorEnabled())
//				logger.error(ResourceBundleHelper
//					.resolve(
//							ResourceBundleNames.DEFAULT_EXTERNAL_RULES_STRINGS,
//							ERROR_UPDATE_METHOD, new Object[] {
//									"updatePartyDetails",
//									this.getClass().getName(),
//									ex.getLocalizedMessage() }));

			TCRMException tcrmEx = new TCRMException(ex);
			status = new DWLStatus();
			DWLExceptionUtils.addErrorToStatus(ex, status, DWLStatus.FATAL,
					TCRMCoreComponentID.PARTY_COMPONENT,
					TCRMErrorCode.UPDATE_RECORD_ERROR,
					TCRMCoreErrorReasonCode.UPDATE_SUSPECT_ENTRY_FAILED,
					theSourceTCRMPartyBObj.getControl(), errHandler);
			tcrmEx.setStatus(status);
			throw tcrmEx;
		}
	}

	protected TCRMPartyBObj updatePersonDetails(
			TCRMPartyBObj theSourceTCRMPartyBObj,
			TCRMPartyBObj theTargetTCRMPartyBObj) throws Exception {

		DWLStatus status = new DWLStatus();
		TCRMPartyBObj theUpdatedTCRMPartyBObj = null;

		try {

			TCRMPersonBObj theSourcePersonBObj = (TCRMPersonBObj) theSourceTCRMPartyBObj;
			TCRMPersonBObj theTargetPersonBObj = (TCRMPersonBObj) theTargetTCRMPartyBObj;

			// merge the TCRMPersonBObj first
			this.mergePersonBObj(theSourcePersonBObj, theTargetPersonBObj);

			// merge TCRMPersonNameBObj
			Vector vecSourcePersonNameBObj = theSourcePersonBObj
					.getItemsTCRMPersonNameBObj();
			Vector vecTargetPersonNameBObj = theTargetPersonBObj
					.getItemsTCRMPersonNameBObj();
			mergePersonNameBObj(vecSourcePersonNameBObj,
					vecTargetPersonNameBObj);

			theUpdatedTCRMPartyBObj = updateMergedParty(theSourcePersonBObj);
		} catch (TCRMException tcrmEx) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(tcrmEx);
			throw tcrmEx;
		} catch (Exception ex) {
			com.dwl.base.util.DWLExceptionUtils.log(ex);
//			if (logger.isErrorEnabled())
//				logger.error(ResourceBundleHelper
//					.resolve(
//							ResourceBundleNames.DEFAULT_EXTERNAL_RULES_STRINGS,
//							ERROR_UPDATE_METHOD, new Object[] {
//									"updatePersonDetails",
//									this.getClass().getName(),
//									ex.getLocalizedMessage() }));

			TCRMException tcrmEx = new TCRMException(ex);
			status = new DWLStatus();
			DWLExceptionUtils.addErrorToStatus(ex, status, DWLStatus.FATAL,
					TCRMCoreComponentID.PARTY_COMPONENT,
					TCRMErrorCode.UPDATE_RECORD_ERROR,
					TCRMCoreErrorReasonCode.UPDATE_SUSPECT_ENTRY_FAILED,
					theSourceTCRMPartyBObj.getControl(), errHandler);
			tcrmEx.setStatus(status);
			throw tcrmEx;
		}

		return theUpdatedTCRMPartyBObj;
	}

	/**
	 * Method prepareTCRMPartyObjectForUpdate.
	 */
	protected TCRMPartyBObj updateMergedParty(TCRMPartyBObj theTCRMPartyBObj)
			throws Exception {

		try {

			IParty theTCRMPartyComponent = (IParty) TCRMClassFactory
					.getTCRMComponent(TCRMCorePropertyKeys.PARTY_COMPONENT);

			// 1. get PartyBeforeImage
			theTCRMPartyBObj.populateBeforeImage();

			// create a DWLStatus object and set it to SUCCESS (because by
			// default is FATAL)
			DWLStatus status = new DWLStatus();
			status.setStatus(DWLStatus.SUCCESS);

			// 2. validates TCRMPartyBObj
			status = theTCRMPartyBObj.callRuleForBusinessKeyVal(status);

			// populate client added error parameters into status
			DWLExceptionUtils.handleErrMsgInStatus(status, theTCRMPartyBObj
					.getControl(), errHandler);

			// check if there was validation errors
			if ((status != null) && (status.getStatus() == DWLStatus.FATAL)) {

				// create application specific exception type
				TCRMDataInvalidException dataEx = new TCRMDataInvalidException();
				dataEx.setStatus(status);
				throw dataEx;
			}

			// 4. updateParty
			theTCRMPartyComponent.updateParty(theTCRMPartyBObj);
		} catch (TCRMException tcrmEx) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(tcrmEx);
			throw tcrmEx;
		} catch (Exception ex) {
			com.dwl.base.util.DWLExceptionUtils.log(ex);
//			if (logger.isErrorEnabled())
//				logger.error(ResourceBundleHelper
//					.resolve(
//							ResourceBundleNames.DEFAULT_EXTERNAL_RULES_STRINGS,
//							ERROR_UPDATE_METHOD, new Object[] {
//									"updateMergedParty",
//									this.getClass().getName(),
//									ex.getLocalizedMessage() }));

			TCRMDataInvalidException tcrmEx = new TCRMDataInvalidException(ex);
			DWLStatus status = new DWLStatus();
			DWLExceptionUtils.addErrorToStatus(ex, status, DWLStatus.FATAL,
					TCRMCoreComponentID.PARTY_COMPONENT,
					TCRMErrorCode.UPDATE_RECORD_ERROR,
					TCRMCoreErrorReasonCode.UPDATE_PARTY_DETAIL_FAILED,
					theTCRMPartyBObj.getControl(), errHandler);
			tcrmEx.setStatus(status);
			throw tcrmEx;
		}

		return theTCRMPartyBObj;
	}

	/**
	 * Method mergePartyRelationshipBObj.
	 * 
	 * @param vecSourcePartyRelationshipBObj
	 * @param vecTargetPartyRelationshipBObj
	 * @modelguid {3179DAE7-4DC9-4982-A89F-E312FF01FAEB}
	 */
	protected void mergePartyRelationshipBObj(
			Vector vecSourcePartyRelationshipBObj,
			Vector vecTargetPartyRelationshipBObj) throws Exception {

		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourcePartyRelationshipBObj != null)
				&& (vecSourcePartyRelationshipBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyRelationshipBObj.size(); a++) {

				TCRMPartyRelationshipBObj theSourceTCRMPartyRelationshipBObj = (TCRMPartyRelationshipBObj) vecSourcePartyRelationshipBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyRelationshipBObj.size(); b++) {

					TCRMPartyRelationshipBObj theTargetTCRMPartyRelationshipBObj = (TCRMPartyRelationshipBObj) vecTargetPartyRelationshipBObj
							.elementAt(b);
					theSourceTCRMPartyRelationshipBObj
							.setRelationshipToPartyId(theTargetTCRMPartyRelationshipBObj
									.getRelationshipToPartyId());
					theSourceTCRMPartyRelationshipBObj
							.setRelationshipFromPartyId(theSourceTCRMPartyRelationshipBObj
									.getRelationshipToValue());

					boolean aBKMatchFound = theSourceTCRMPartyRelationshipBObj
							.isBusinessKeySame(theTargetTCRMPartyRelationshipBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyRelationshipBObj
								.setPartyRelationshipLastUpdateDate(theTargetTCRMPartyRelationshipBObj
										.getPartyRelationshipLastUpdateDate());
						theSourceTCRMPartyRelationshipBObj
								.setPartyRelationshipIdPK(theTargetTCRMPartyRelationshipBObj
										.getPartyRelationshipIdPK());
						theSourceTCRMPartyRelationshipBObj
								.setPartyRelationshipLastUpdateTxId(theTargetTCRMPartyRelationshipBObj
										.getPartyRelationshipLastUpdateTxId());

						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyRelationshipBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePrivacyPreferenceBObj.
	 * 
	 * @param vecSourcePartyPrivPrefBObj
	 * @param vecTargetPartyPrivPrefBObj
	 * @modelguid {4FDFA882-EB8B-47A7-B5D8-4495196F2917}
	 */
	protected void mergePrivacyPreferenceBObj(
			Vector vecSourcePartyPrivPrefBObj, Vector vecTargetPartyPrivPrefBObj)
			throws Exception {

		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourcePartyPrivPrefBObj != null)
				&& (vecSourcePartyPrivPrefBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyPrivPrefBObj.size(); a++) {

				TCRMPartyPrivPrefBObj theSourceTCRMPartyPrivPrefBObj = (TCRMPartyPrivPrefBObj) vecSourcePartyPrivPrefBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyPrivPrefBObj.size(); b++) {

					TCRMPartyPrivPrefBObj theTargetTCRMPartyPrivPrefBOb = (TCRMPartyPrivPrefBObj) vecTargetPartyPrivPrefBObj
							.elementAt(b);
					if (theSourceTCRMPartyPrivPrefBObj.getPartyId() == null) {
						theSourceTCRMPartyPrivPrefBObj
								.setPartyId(theTargetTCRMPartyPrivPrefBOb
										.getPartyId());
					}
					boolean aBKMatchFound = theSourceTCRMPartyPrivPrefBObj
							.isBusinessKeySame(theTargetTCRMPartyPrivPrefBOb);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyPrivPrefBObj
								.setPrivPrefLastUpdateDate(theTargetTCRMPartyPrivPrefBOb
										.getPrivPrefLastUpdateDate());
						theSourceTCRMPartyPrivPrefBObj
								.setPartyPrivPrefIdPK(theTargetTCRMPartyPrivPrefBOb
										.getPartyPrivPrefIdPK());
						theSourceTCRMPartyPrivPrefBObj
								.setEntityPrivPrefLastUpdateDate(theTargetTCRMPartyPrivPrefBOb
										.getEntityPrivPrefLastUpdateDate());
						theSourceTCRMPartyPrivPrefBObj
								.setPrivPrefLastUpdateTxId(theTargetTCRMPartyPrivPrefBOb
										.getPrivPrefLastUpdateTxId());
						theSourceTCRMPartyPrivPrefBObj
								.setEntityPrivPrefLastUpdateTxId(theTargetTCRMPartyPrivPrefBOb
										.getEntityPrivPrefLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyPrivPrefBObj.metaDataMap);

						mergeEntityInstancePrivPrefBObj(
								theSourceTCRMPartyPrivPrefBObj
										.getItemsTCRMEntityInstancePrivPrefBObj(),
								theTargetTCRMPartyPrivPrefBOb
										.getItemsTCRMEntityInstancePrivPrefBObj());

						break;
					}
				}
			}
		}
	}

	/**
	 * 
	 * @since $Revision: 1.6.4.6 $
	 * 
	 * @param vecSourceTCRMEntityInstancePrivPrefBObj
	 *            DOCUMENT ME!
	 * @param vecTargetTCRMEntityInstancePrivPrefBObj
	 *            DOCUMENT ME!
	 * 
	 * @throws Exception
	 *             DOCUMENT ME!
	 */
	protected void mergeEntityInstancePrivPrefBObj(
			Vector vecSourceTCRMEntityInstancePrivPrefBObj,
			Vector vecTargetTCRMEntityInstancePrivPrefBObj) throws Exception {

		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourceTCRMEntityInstancePrivPrefBObj != null)
				&& (vecSourceTCRMEntityInstancePrivPrefBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceTCRMEntityInstancePrivPrefBObj.size(); a++) {

				TCRMEntityInstancePrivPrefBObj theSourceTCRMEntityInstancePrivPrefBObj = (TCRMEntityInstancePrivPrefBObj) vecSourceTCRMEntityInstancePrivPrefBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetTCRMEntityInstancePrivPrefBObj
						.size(); b++) {

					TCRMEntityInstancePrivPrefBObj theTargetTCRMEntityInstancePrivPrefBObj = (TCRMEntityInstancePrivPrefBObj) vecTargetTCRMEntityInstancePrivPrefBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMEntityInstancePrivPrefBObj
							.isBusinessKeySame(theTargetTCRMEntityInstancePrivPrefBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMEntityInstancePrivPrefBObj
								.setEntityInstancePrivPrefLastUpdateDate(theTargetTCRMEntityInstancePrivPrefBObj
										.getEntityInstancePrivPrefLastUpdateDate());
						theSourceTCRMEntityInstancePrivPrefBObj
								.setPrivPrefInstanceIdPK(theTargetTCRMEntityInstancePrivPrefBObj
										.getPrivPrefInstanceIdPK());
						theSourceTCRMEntityInstancePrivPrefBObj
								.setPrivPrefIdPK(theTargetTCRMEntityInstancePrivPrefBObj
										.getPrivPrefIdPK());
						//Fix for defect 14990
						theSourceTCRMEntityInstancePrivPrefBObj
								.setEntityInstancePrivPrefLastUpdateTxId(theTargetTCRMEntityInstancePrivPrefBObj
										.getEntityInstancePrivPrefLastUpdateTxId());

						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMEntityInstancePrivPrefBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePartyLobRelBObj.
	 * 
	 * @modelguid {8DBF2ADB-6A12-49F9-9122-C334CD30732E}
	 */
	protected void mergePartyLobRelBObj(
			Vector vecSourcePartyLobRelationshipBObj,
			Vector vecTargetPartyLobRelationshipBObj) throws Exception {

		// if the existing/target party has at least one party relationship
		// object, it must be compared with any
		// incoming/source party bank account objects
		if ((vecSourcePartyLobRelationshipBObj != null)
				&& (vecSourcePartyLobRelationshipBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyLobRelationshipBObj.size(); a++) {

				TCRMPartyLobRelationshipBObj theSourceTCRMPartyLobRelationshipBObj = (TCRMPartyLobRelationshipBObj) vecSourcePartyLobRelationshipBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyLobRelationshipBObj.size(); b++) {

					TCRMPartyLobRelationshipBObj theTargetTCRMPartyLobRelationshipBObj = (TCRMPartyLobRelationshipBObj) vecTargetPartyLobRelationshipBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMPartyLobRelationshipBObj
							.isBusinessKeySame(theTargetTCRMPartyLobRelationshipBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyLobRelationshipBObj
								.setPartyLobRelationshipLastUpdateDate(theTargetTCRMPartyLobRelationshipBObj
										.getPartyLobRelationshipLastUpdateDate());
						theSourceTCRMPartyLobRelationshipBObj
								.setPartyLobRelationshipIdPK(theTargetTCRMPartyLobRelationshipBObj
										.getPartyLobRelationshipIdPK());
						theSourceTCRMPartyLobRelationshipBObj
								.setPartyLobRelationshipLastUpdateTxId(theTargetTCRMPartyLobRelationshipBObj
										.getPartyLobRelationshipLastUpdateTxId());

						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyLobRelationshipBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePartyContactMethodBObj.
	 * 
	 * @param vecSourcePartyContactMethodBObj
	 * @param vecTargetPartyContactMethodBObj
	 * @modelguid {66C00CCA-8FD8-4773-AF7F-12B61D7D9B3B}
	 */
	protected void mergePartyContactMethodBObj(
			Vector vecSourcePartyContactMethodBObj,
			Vector vecTargetPartyContactMethodBObj) throws Exception {

		// if the existing/target party has at least one party contact method
		// object, it must be compared with any
		// incoming/source party contact method objects
		if ((vecSourcePartyContactMethodBObj != null)
				&& (vecSourcePartyContactMethodBObj.size() > 0)) {

			for (int a = 0; a < vecSourcePartyContactMethodBObj.size(); a++) {

				TCRMPartyContactMethodBObj theSourceTCRMPartyContactMethodBObj = (TCRMPartyContactMethodBObj) vecSourcePartyContactMethodBObj
						.elementAt(a);
				TCRMContactMethodBObj theSourceTCRMContactMethodBObj = theSourceTCRMPartyContactMethodBObj
						.getTCRMContactMethodBObj();

				for (int b = 0; b < vecTargetPartyContactMethodBObj.size(); b++) {

					TCRMPartyContactMethodBObj theTargetTCRMPartyContactMethodBObj = (TCRMPartyContactMethodBObj) vecTargetPartyContactMethodBObj
							.elementAt(b);
					TCRMContactMethodBObj theTargetTCRMContactMethodBObj = theTargetTCRMPartyContactMethodBObj
							.getTCRMContactMethodBObj();

					boolean aBKMatchFound = theSourceTCRMPartyContactMethodBObj
							.isBusinessKeySame(theTargetTCRMPartyContactMethodBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyContactMethodBObj
								.setContactMethodGroupLastUpdateDate(theTargetTCRMPartyContactMethodBObj
										.getContactMethodGroupLastUpdateDate());
						theSourceTCRMPartyContactMethodBObj
								.setPartyContactMethodIdPK(theTargetTCRMPartyContactMethodBObj
										.getPartyContactMethodIdPK());
						theSourceTCRMPartyContactMethodBObj
								.setLocationGroupLastUpdateDate(theTargetTCRMPartyContactMethodBObj
										.getLocationGroupLastUpdateDate());

						theSourceTCRMPartyContactMethodBObj
								.setContactMethodGroupLastUpdateTxId(theTargetTCRMPartyContactMethodBObj
										.getContactMethodGroupLastUpdateTxId());
						theSourceTCRMPartyContactMethodBObj
								.setLocationGroupLastUpdateTxId(theTargetTCRMPartyContactMethodBObj
										.getLocationGroupLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyContactMethodBObj.metaDataMap);

						mergePartyLocationPrivPrefBObj(
								theSourceTCRMPartyContactMethodBObj
										.getItemsTCRMPartyLocationPrivPrefBObj(),
								theTargetTCRMPartyContactMethodBObj
										.getItemsTCRMPartyLocationPrivPrefBObj());
						mergePartyContactMethodPrivPrefBObj(
								theSourceTCRMPartyContactMethodBObj
										.getItemsTCRMPartyContactMethodPrivPrefBObj(),
								theTargetTCRMPartyContactMethodBObj
										.getItemsTCRMPartyContactMethodPrivPrefBObj());
						if (theSourceTCRMContactMethodBObj
								.isBusinessKeySame(theTargetTCRMContactMethodBObj)) {
							theSourceTCRMContactMethodBObj
									.setContactMethodIdPK(theTargetTCRMContactMethodBObj
											.getContactMethodIdPK());
							theSourceTCRMContactMethodBObj
									.setContactMethodLastUpdateDate(theTargetTCRMContactMethodBObj
											.getContactMethodLastUpdateDate());
							theSourceTCRMContactMethodBObj
									.setContactMethodLastUpdateTxId(theTargetTCRMContactMethodBObj
											.getContactMethodLastUpdateTxId());
							theSourceTCRMPartyContactMethodBObj
									.setContactMethodId(theTargetTCRMPartyContactMethodBObj
											.getContactMethodId());

							// Set metaDataMap values to "", if they are null;
							// due to add transaction rule. By doing so,
							// related DB field is set to null in both blank and
							// missing tag cases in xml transaction requests.
							changeNullToEmptyStrInMetaDataMap(theSourceTCRMContactMethodBObj.metaDataMap);

							TCRMPhoneNumberBObj theSourceTCRMPhoneNumberBObj = theSourceTCRMContactMethodBObj.getTCRMPhoneNumberBObj();
							TCRMPhoneNumberBObj theTargetTCRMPhoneNumberBObj = theTargetTCRMContactMethodBObj.getTCRMPhoneNumberBObj();
							if (theSourceTCRMPhoneNumberBObj != null && theTargetTCRMPhoneNumberBObj != null){
								theSourceTCRMPhoneNumberBObj.setContactMethodId(theSourceTCRMContactMethodBObj.getContactMethodIdPK());
								if (theSourceTCRMPhoneNumberBObj.isBusinessKeySame(theTargetTCRMPhoneNumberBObj)){
									
									theSourceTCRMPhoneNumberBObj.setPhoneNumberId(theTargetTCRMPhoneNumberBObj.getPhoneNumberId());
									theSourceTCRMPhoneNumberBObj.setPhoneLastUpdateDate(theTargetTCRMPhoneNumberBObj.getPhoneLastUpdateDate());
									theSourceTCRMPhoneNumberBObj.setPhoneLastUpdateTxId(theTargetTCRMPhoneNumberBObj.getPhoneLastUpdateTxId());

									changeNullToEmptyStrInMetaDataMap(theSourceTCRMPhoneNumberBObj.metaDataMap);
								}
							}
						}

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergeAdminContEquivBObj.
	 * 
	 * @param vecSourceAdminContEquivBObj
	 * @param vecTargetAdminContEquivBObj
	 * @modelguid {F10AF0A5-F476-4ADC-9357-FE9504470DA7}
	 */
	protected void mergeAdminContEquivBObj(Vector vecSourceAdminContEquivBObj,
			Vector vecTargetAdminContEquivBObj) throws Exception {

		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourceAdminContEquivBObj != null)
				&& (vecSourceAdminContEquivBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceAdminContEquivBObj.size(); a++) {

				TCRMAdminContEquivBObj theSourceTCRMAdminContEquivBObj = (TCRMAdminContEquivBObj) vecSourceAdminContEquivBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetAdminContEquivBObj.size(); b++) {

					TCRMAdminContEquivBObj theTargetTCRMAdminContEquivBObj = (TCRMAdminContEquivBObj) vecTargetAdminContEquivBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMAdminContEquivBObj
							.isBusinessKeySame(theTargetTCRMAdminContEquivBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMAdminContEquivBObj
								.setContEquivLastUpdateDate(theTargetTCRMAdminContEquivBObj
										.getContEquivLastUpdateDate());
						theSourceTCRMAdminContEquivBObj
								.setAdminContEquivIdPK(theTargetTCRMAdminContEquivBObj
										.getAdminContEquivIdPK());

						//ensure txnid being returned in merged objects
						theSourceTCRMAdminContEquivBObj
								.setContEquivLastUpdateTxId(theTargetTCRMAdminContEquivBObj
										.getContEquivLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMAdminContEquivBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergeAlertBObj.
	 * 
	 * @param vecSourceAlertBObj
	 * @param vecTargetAlertBObj
	 * @modelguid {33CF8B53-5246-486C-8701-FA8AE9075674}
	 */
	protected void mergeAlertBObj(Vector vecSourceAlertBObj,
			Vector vecTargetAlertBObj) throws Exception {

		// if the existing/target party has at least one alert object, it must
		// be compared with any
		// incoming/source alert objects
		if ((vecSourceAlertBObj != null) && (vecSourceAlertBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceAlertBObj.size(); a++) {

				TCRMAlertBObj theSourceTCRMAlertBObj = (TCRMAlertBObj) vecSourceAlertBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetAlertBObj.size(); b++) {

					TCRMAlertBObj theTargetTCRMAlertBObj = (TCRMAlertBObj) vecTargetAlertBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMAlertBObj
							.isBusinessKeySame(theTargetTCRMAlertBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMAlertBObj
								.setAlertLastUpdateDate(theTargetTCRMAlertBObj
										.getAlertLastUpdateDate());
						theSourceTCRMAlertBObj
								.setAlertIdPK(theTargetTCRMAlertBObj
										.getAlertIdPK());
						// ensure txnid being returned in merged objects
						theSourceTCRMAlertBObj
								.setAlertLastUpdateTxId(theTargetTCRMAlertBObj
										.getAlertLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMAlertBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePartyIdentificationBObj.
	 * 
	 * @param vecSourcePartyIdentification
	 * @param vecTargetPartyIdentification
	 */
	protected void mergePartyIdentificationBObj(
			Vector vecSourcePartyIdentification,
			Vector vecTargetPartyIdentification) throws Exception {

		// if the existing/target party has at least one party identification
		// object, it must be compared with any
		// incoming/source party identification objects
		if ((vecSourcePartyIdentification != null)
				&& (vecSourcePartyIdentification.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyIdentification.size(); a++) {

				TCRMPartyIdentificationBObj theSourceTCRMPartyIdentificationBObj = (TCRMPartyIdentificationBObj) vecSourcePartyIdentification
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyIdentification.size(); b++) {

					TCRMPartyIdentificationBObj theTargetTCRMPartyIdentificationBObj = (TCRMPartyIdentificationBObj) vecTargetPartyIdentification
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMPartyIdentificationBObj
							.isBusinessKeySame(theTargetTCRMPartyIdentificationBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyIdentificationBObj
								.setPartyIdentificationLastUpdateDate(theTargetTCRMPartyIdentificationBObj
										.getPartyIdentificationLastUpdateDate());
						theSourceTCRMPartyIdentificationBObj
								.setIdentificationIdPK(theTargetTCRMPartyIdentificationBObj
										.getIdentificationIdPK());
						//ensure txnid being returned in merged objects
						theSourceTCRMPartyIdentificationBObj
								.setPartyIdentificationLastUpdateTxId(theTargetTCRMPartyIdentificationBObj
										.getPartyIdentificationLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyIdentificationBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergeIncomeSourceBObj.
	 * 
	 * @param vecSourceIncomeSourceBObj
	 * @param vecTargetIncomeSourceBObj
	 * @modelguid {8F50963C-9F05-49F1-AA36-D92F6E4F68FD}
	 */
	protected void mergeIncomeSourceBObj(Vector vecSourceIncomeSourceBObj,
			Vector vecTargetIncomeSourceBObj) throws Exception {

		// if the existing/target party has at least one income source object,
		// it must be compared with any
		// incoming/source income source objects
		if ((vecSourceIncomeSourceBObj != null)
				&& (vecSourceIncomeSourceBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceIncomeSourceBObj.size(); a++) {

				TCRMIncomeSourceBObj theSourceTCRMIncomeSourceBObj = (TCRMIncomeSourceBObj) vecSourceIncomeSourceBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetIncomeSourceBObj.size(); b++) {

					TCRMIncomeSourceBObj theTargetTCRMIncomeSourceBObj = (TCRMIncomeSourceBObj) vecTargetIncomeSourceBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMIncomeSourceBObj
							.isBusinessKeySame(theTargetTCRMIncomeSourceBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMIncomeSourceBObj
								.setIncomeSourceLastUpdateDate(theTargetTCRMIncomeSourceBObj
										.getIncomeSourceLastUpdateDate());
						theSourceTCRMIncomeSourceBObj
								.setIncomeSourceIdPK(theTargetTCRMIncomeSourceBObj
										.getIncomeSourceIdPK());
						// ensure txnid being returned in merged objects
						theSourceTCRMIncomeSourceBObj
								.setIncomeSourceLastUpdateTxId(theTargetTCRMIncomeSourceBObj
										.getIncomeSourceLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMIncomeSourceBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePartyBankAccountBObj.
	 * 
	 * @param vecSourceBankAccountBObj
	 * @param vecTargetBankAccountBObj
	 * @modelguid {2DF48ABC-EFE7-4DFB-A1DE-D18FCBAB1EBC}
	 */
	protected void mergePartyBankAccountBObj(Vector vecSourceBankAccountBObj,
			Vector vecTargetBankAccountBObj) throws Exception {

		// if the existing/target party has at least one party bank account
		// object, it must be compared with any
		// incoming/source party bank account objects
		if ((vecSourceBankAccountBObj != null)
				&& (vecSourceBankAccountBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceBankAccountBObj.size(); a++) {

				TCRMPartyBankAccountBObj theSourceTCRMPartyBankAccountBObj = (TCRMPartyBankAccountBObj) vecSourceBankAccountBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetBankAccountBObj.size(); b++) {

					TCRMPartyBankAccountBObj theTargetTCRMPartyBankAccountBObj = (TCRMPartyBankAccountBObj) vecTargetBankAccountBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMPartyBankAccountBObj
							.isBusinessKeySame(theTargetTCRMPartyBankAccountBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyBankAccountBObj
								.setBankAccountLastUpdateDate(theTargetTCRMPartyBankAccountBObj
										.getBankAccountLastUpdateDate());
						theSourceTCRMPartyBankAccountBObj
								.setBankAccountLastUpdateTxId(theTargetTCRMPartyBankAccountBObj
										.getBankAccountLastUpdateTxId());
						theSourceTCRMPartyBankAccountBObj
								.setPaymentSourceIdPK(theTargetTCRMPartyBankAccountBObj
										.getPaymentSourceIdPK());
						theSourceTCRMPartyBankAccountBObj
								.setPaymentSourceLastUpdateDate(theTargetTCRMPartyBankAccountBObj
										.getPaymentSourceLastUpdateDate());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyBankAccountBObj
								.setPaymentSourceLastUpdateTxId(theTargetTCRMPartyBankAccountBObj
										.getPaymentSourceLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyBankAccountBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePartyPayrollDeductionBObj.
	 * 
	 * @param vecSourcePayrollDeductionBObj
	 * @param vecTargetPayrollDeductionBObj
	 * @modelguid {91FA95B7-9A7A-4D95-B6A5-33822069E504}
	 */
	protected void mergePartyPayrollDeductionBObj(
			Vector vecSourcePayrollDeductionBObj,
			Vector vecTargetPayrollDeductionBObj) throws Exception {

		// if the existing/target party has at least one party payroll deduction
		// object, it must be compared with any
		// incoming/source party payroll deduction objects
		if ((vecSourcePayrollDeductionBObj != null)
				&& (vecSourcePayrollDeductionBObj.size() > 0)) {

			// for each payroll deduction object in the source
			for (int a = 0; a < vecSourcePayrollDeductionBObj.size(); a++) {

				TCRMPartyPayrollDeductionBObj theSourceTCRMPartyPayrollDeductionBObj = (TCRMPartyPayrollDeductionBObj) vecSourcePayrollDeductionBObj
						.elementAt(a);

				// compare it with the existing/target payroll deduction
				// object(s)
				for (int b = 0; b < vecTargetPayrollDeductionBObj.size(); b++) {

					TCRMPartyPayrollDeductionBObj theTargetTCRMPartyPayrollDeductionBObj = (TCRMPartyPayrollDeductionBObj) vecTargetPayrollDeductionBObj
							.elementAt(b);
					boolean aPDMatchFound = theSourceTCRMPartyPayrollDeductionBObj
							.isBusinessKeySame(theTargetTCRMPartyPayrollDeductionBObj);

					if (aPDMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyPayrollDeductionBObj
								.setPayrollDeductionLastUpdateDate(theTargetTCRMPartyPayrollDeductionBObj
										.getPayrollDeductionLastUpdateDate());
						theSourceTCRMPartyPayrollDeductionBObj
								.setPayrollDeductionLastUpdateTxId(theTargetTCRMPartyPayrollDeductionBObj
										.getPayrollDeductionLastUpdateTxId());
						theSourceTCRMPartyPayrollDeductionBObj
								.setPaymentSourceIdPK(theTargetTCRMPartyPayrollDeductionBObj
										.getPaymentSourceIdPK());
						theSourceTCRMPartyPayrollDeductionBObj
								.setPaymentSourceLastUpdateDate(theTargetTCRMPartyPayrollDeductionBObj
										.getPaymentSourceLastUpdateDate());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyPayrollDeductionBObj
								.setPaymentSourceLastUpdateTxId(theTargetTCRMPartyPayrollDeductionBObj
										.getPaymentSourceLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyPayrollDeductionBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/** @modelguid {8C404333-8793-4386-8822-1DB456C8F1EC} */
	protected TCRMPartyBObj updateOrgDetails(
			TCRMPartyBObj theSourceTCRMPartyBObj,
			TCRMPartyBObj theTargetTCRMPartyBObj) throws Exception {

		TCRMPartyBObj theUpdatedTCRMPartyBObj = null;

		try {

			TCRMOrganizationBObj theSourceOrgBObj = (TCRMOrganizationBObj) theSourceTCRMPartyBObj;
			TCRMOrganizationBObj theTargetOrgBObj = (TCRMOrganizationBObj) theTargetTCRMPartyBObj;

			//merge Organization object
			mergeOrganizationBObj(theSourceOrgBObj, theTargetOrgBObj);

			// merge Organization Name object
			Vector vecSourceOrgNameBObj = theSourceOrgBObj
					.getItemsTCRMOrganizationNameBObj();
			Vector vecTargetOrgNameBObj = theTargetOrgBObj
					.getItemsTCRMOrganizationNameBObj();
			mergeOrgNameBObj(vecSourceOrgNameBObj, vecTargetOrgNameBObj);

			theUpdatedTCRMPartyBObj = updateMergedParty(theSourceOrgBObj);
		} catch (TCRMException tcrmEx) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(tcrmEx);
			throw tcrmEx;
		} catch (Exception ex) {
			com.dwl.base.util.DWLExceptionUtils.log(ex);
//			if (logger.isErrorEnabled())
//				logger.error(ResourceBundleHelper
//					.resolve(
//							ResourceBundleNames.DEFAULT_EXTERNAL_RULES_STRINGS,
//							ERROR_UPDATE_METHOD, new Object[] {
//									"updateOrgDetails",
//									this.getClass().getName(),
//									ex.getLocalizedMessage() }));

			TCRMDataInvalidException tcrmEx = new TCRMDataInvalidException(ex);
			DWLStatus status = new DWLStatus();
			DWLExceptionUtils.addErrorToStatus(ex, status, DWLStatus.FATAL,
					TCRMCoreComponentID.PARTY_COMPONENT,
					TCRMErrorCode.UPDATE_RECORD_ERROR,
					TCRMCoreErrorReasonCode.UPDATE_PARTY_DETAIL_FAILED,
					theSourceTCRMPartyBObj.getControl(), errHandler);
			tcrmEx.setStatus(status);
			throw tcrmEx;
		}

		return theUpdatedTCRMPartyBObj;
	}

	/**
	 * Method mergeOrgNameBObj.
	 * 
	 * @modelguid {50CF8CE4-C30E-4C34-81F1-CB26B2AF6060}
	 */
	protected void mergeOrgNameBObj(Vector vecSourceOrgNameBObj,
			Vector vecTargetOrgNameBObj) throws Exception {

		// if the existing/target party has at least one org name object, it
		// must be compared with any
		// incoming/source org name objects
		if ((vecSourceOrgNameBObj != null) && (vecSourceOrgNameBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceOrgNameBObj.size(); a++) {

				TCRMOrganizationNameBObj theSourceTCRMOrgNameBObj = (TCRMOrganizationNameBObj) vecSourceOrgNameBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetOrgNameBObj.size(); b++) {

					TCRMOrganizationNameBObj theTargetTCRMOrgNameBObj = (TCRMOrganizationNameBObj) vecTargetOrgNameBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMOrgNameBObj
							.isBusinessKeySame(theTargetTCRMOrgNameBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMOrgNameBObj
								.setOrganizationNameLastUpdateDate(theTargetTCRMOrgNameBObj
										.getOrganizationNameLastUpdateDate());
						theSourceTCRMOrgNameBObj
								.setOrganizationNameIdPK(theTargetTCRMOrgNameBObj
										.getOrganizationNameIdPK());
						// ensure txnid being returned in merged objects
						theSourceTCRMOrgNameBObj
								.setOrganizationNameLastUpdateTxId(theTargetTCRMOrgNameBObj
										.getOrganizationNameLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMOrgNameBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePersonNameBObj.
	 * 
	 * @modelguid {DB0B45A7-D9AF-47CA-B335-E45D5FE551A9}
	 */
	protected void mergePersonNameBObj(Vector vecSourceTCRMPersonNameBObj,
			Vector vecTargetTCRMPersonNameBObj) throws Exception {

		// if the existing/target party has at least one person name object, it
		// must be compared with any
		// incoming/source person name objects
		if ((vecSourceTCRMPersonNameBObj != null)
				&& (vecSourceTCRMPersonNameBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourceTCRMPersonNameBObj.size(); a++) {

				TCRMPersonNameBObj theSourceTCRMPersonNameBObj = (TCRMPersonNameBObj) vecSourceTCRMPersonNameBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetTCRMPersonNameBObj.size(); b++) {

					TCRMPersonNameBObj theTargetTCRMPersonNameBObj = (TCRMPersonNameBObj) vecTargetTCRMPersonNameBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMPersonNameBObj
							.isBusinessKeySame(theTargetTCRMPersonNameBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPersonNameBObj
								.setPersonNameLastUpdateDate(theTargetTCRMPersonNameBObj
										.getPersonNameLastUpdateDate());
						theSourceTCRMPersonNameBObj
								.setPersonNameIdPK(theTargetTCRMPersonNameBObj
										.getPersonNameIdPK());
						// ensure txnid being returned in merged objects
						theSourceTCRMPersonNameBObj
								.setPersonNameLastUpdateTxId(theTargetTCRMPersonNameBObj
										.getPersonNameLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPersonNameBObj.metaDataMap);
						//defect fix : CR:mdmu00013241
						changeEmptyStrBackToNullForStandardizeValuesInPersonNameBObj(theSourceTCRMPersonNameBObj.metaDataMap);
						
						break;
					}
				}
			}
		}
	}

	private void changeEmptyStrBackToNullForStandardizeValuesInPersonNameBObj(Map metadataMap) {
		String attributeKey = null;
		String attributeValue = null;
		Iterator it = metadataMap.keySet().iterator();

		while (it.hasNext()) {
			attributeKey = (String) it.next();
			attributeValue = (String) metadataMap.get(attributeKey);
			if ((attributeKey.startsWith("StdGivenName")  &&  "".equals(attributeValue))
					|| (attributeKey.equals("StdLastName")  &&  "".equals(attributeValue)) ){
							metadataMap.put(attributeKey, null);
			}
		}
		
	}

	/**
	 * Method mergePartyAddressBObj.
	 * 
	 * @param vecSourcePartyAddressBObj
	 * @param vecTargetPartyAddressBObj
	 * @modelguid {5DAF1E72-43CA-4E7D-89AA-A2C6BFC03780}
	 */
	protected void mergePartyAddressBObj(Vector vecSourcePartyAddressBObj,
			Vector vecTargetPartyAddressBObj) throws Exception {

		// if the existing/target party has at least one party address object,
		// it must be compared with any
		// incoming/source person name objects
		if ((vecSourcePartyAddressBObj != null)
				&& (vecSourcePartyAddressBObj.size() > 0)) {

			TCRMAddressStandardizerManager theAddressStandardizerManager = new TCRMAddressStandardizerManager();
			IAddressStandardizer theAddressStandardizer = theAddressStandardizerManager
					.getAddressStandardizer();

			for (int a = 0; a < vecSourcePartyAddressBObj.size(); a++) {

				TCRMPartyAddressBObj theSourceTCRMPartyAddressBObj = (TCRMPartyAddressBObj) vecSourcePartyAddressBObj
						.elementAt(a);
				TCRMAddressBObj theSourceTCRMAddressBObj = theSourceTCRMPartyAddressBObj
						.getTCRMAddressBObj();
				boolean flagOverride = false;

				if ((theSourceTCRMAddressBObj.getStandardFormatingOverride() != null)
						&& (theSourceTCRMAddressBObj
								.getStandardFormatingOverride().trim()
								.equalsIgnoreCase("Y"))) {
					flagOverride = true;
				}

				if ((theSourceTCRMAddressBObj.getStandardFormatingIndicator() != null)
						&& (theSourceTCRMAddressBObj
								.getStandardFormatingIndicator().trim()
								.equalsIgnoreCase("Y"))) {
					flagOverride = true;
				}

				if (!flagOverride && !theSourceTCRMAddressBObj.isSkipAddressStandardization()) {
						theSourceTCRMAddressBObj = (theAddressStandardizer.standardizeAddress(theSourceTCRMAddressBObj));					
				} else {

					if ((theSourceTCRMAddressBObj
							.getStandardFormatingIndicator() == null)
							|| (theSourceTCRMAddressBObj
									.getStandardFormatingIndicator().trim()
									.equalsIgnoreCase(""))) {
						theSourceTCRMAddressBObj
								.setStandardFormatingIndicator("N");
					} else {

					}
				}

				for (int b = 0; b < vecTargetPartyAddressBObj.size(); b++) {

					TCRMPartyAddressBObj theTargetTCRMPartyAddressBObj = (TCRMPartyAddressBObj) vecTargetPartyAddressBObj
							.elementAt(b);
					TCRMAddressBObj theTargetTCRMAddressBObj = theTargetTCRMPartyAddressBObj
							.getTCRMAddressBObj();

					if (theSourceTCRMAddressBObj
							.isBusinessKeySame(theTargetTCRMAddressBObj)) {

						if (theSourceTCRMAddressBObj.getEObjAddress()
								.getAddressIdPK() == null) {
							theSourceTCRMAddressBObj
									.setAddressIdPK(theTargetTCRMAddressBObj
											.getAddressIdPK());
							theSourceTCRMAddressBObj
									.setAddressLastUpdateDate(theTargetTCRMAddressBObj
											.getAddressLastUpdateDate());
							theSourceTCRMPartyAddressBObj
									.setAddressId(theTargetTCRMPartyAddressBObj
											.getAddressId());
							// ensure txnid being returned in merged
							// objects
							theSourceTCRMAddressBObj
									.setAddressLastUpdateTxId(theTargetTCRMAddressBObj
											.getAddressLastUpdateTxId());
							// Set metaDataMap values to "", if they are null;
							// due to add transaction rule. By doing so,
							// related DB field is set to null in both blank and
							// missing tag cases in xml transaction requests.
							changeNullToEmptyStrInMetaDataMap(theSourceTCRMAddressBObj.metaDataMap);

						}

						boolean aBKMatchFound = theSourceTCRMPartyAddressBObj
								.isBusinessKeySame(
										theTargetTCRMPartyAddressBObj, false);

						if (aBKMatchFound) {

							// the business key is the same for the two objects,
							// so set the
							// lastupdate date and idpk on the source object to
							// what is on the target
							theSourceTCRMPartyAddressBObj
									.setAddressGroupLastUpdateDate(theTargetTCRMPartyAddressBObj
											.getAddressGroupLastUpdateDate());
							theSourceTCRMPartyAddressBObj
									.setAddressGroupLastUpdateTxId(theTargetTCRMPartyAddressBObj
											.getAddressGroupLastUpdateTxId());
							theSourceTCRMPartyAddressBObj
									.setPartyAddressIdPK(theTargetTCRMPartyAddressBObj
											.getPartyAddressIdPK());
							theSourceTCRMPartyAddressBObj
									.setLocationGroupLastUpdateDate(theTargetTCRMPartyAddressBObj
											.getLocationGroupLastUpdateDate());
							// ensure txnid being returned in merged
							// objects
							theSourceTCRMPartyAddressBObj
									.setLocationGroupLastUpdateTxId(theTargetTCRMPartyAddressBObj
											.getLocationGroupLastUpdateTxId());
							// Set metaDataMap values to "", if they are null;
							// due to add transaction rule. By doing so,
							// related DB field is set to null in both blank and
							// missing tag cases in xml transaction requests.
							changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyAddressBObj.metaDataMap);

							mergePartyLocationPrivPrefBObj(
									theSourceTCRMPartyAddressBObj
											.getItemsTCRMPartyLocationPrivPrefBObj(),
									theTargetTCRMPartyAddressBObj
											.getItemsTCRMPartyLocationPrivPrefBObj());
							mergePartyAddressPrivPrefBObj(
									theSourceTCRMPartyAddressBObj
											.getItemsTCRMPartyAddressPrivPrefBObj(),
									theTargetTCRMPartyAddressBObj
											.getItemsTCRMPartyAddressPrivPrefBObj());

							break;
						}
					}
				}
			}
			for (int a = 0; a < vecSourcePartyAddressBObj.size(); a++) {

				TCRMPartyAddressBObj theSourceTCRMPartyAddressBObj1 = (TCRMPartyAddressBObj) vecSourcePartyAddressBObj
						.elementAt(a);
				TCRMAddressBObj theSourceTCRMAddressBObj1 = theSourceTCRMPartyAddressBObj1
						.getTCRMAddressBObj();
				String s1 = theSourceTCRMAddressBObj1.getAddressIdPK();
				if (s1 != null) {
					for (int b = a; b < vecSourcePartyAddressBObj.size(); b++) {
						TCRMPartyAddressBObj theSourceTCRMPartyAddressBObj2 = (TCRMPartyAddressBObj) vecSourcePartyAddressBObj
								.elementAt(b);
						TCRMAddressBObj theSourceTCRMAddressBObj2 = theSourceTCRMPartyAddressBObj2
								.getTCRMAddressBObj();
						String s2 = theSourceTCRMAddressBObj2.getAddressIdPK();

						if (s2 != null) {
							if (s1.equals(s2)) {
								theSourceTCRMPartyAddressBObj2
										.setTCRMAddressBObj(theSourceTCRMAddressBObj1);
							}
						}
					}
				}
			}

		}
	}

	/** @modelguid {9B83F7B8-7596-401E-9EBB-C248C2C244FF} */
	protected void mergePartyChargeCardBObj(
			Vector vecSourcePartyChargeCardBObj,
			Vector theTargetPartyChargeCardBObj) throws Exception {

		// if the existing/target party has at least one person name object, it
		// must be compared with any
		// incoming/source person name objects
		if ((vecSourcePartyChargeCardBObj != null)
				&& (vecSourcePartyChargeCardBObj.size() > 0)) {

			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyChargeCardBObj.size(); a++) {

				TCRMPartyChargeCardBObj theSourceTCRMPartyChargeCardBObj = (TCRMPartyChargeCardBObj) vecSourcePartyChargeCardBObj
						.elementAt(a);

				// compare it with the existing/target person name object(s)
				for (int b = 0; b < theTargetPartyChargeCardBObj.size(); b++) {

					TCRMPartyChargeCardBObj theTargetTCRMPartyChargeCardBObj = (TCRMPartyChargeCardBObj) theTargetPartyChargeCardBObj
							.elementAt(b);
					boolean aBKMatchFound = theSourceTCRMPartyChargeCardBObj
							.isBusinessKeySame(theTargetTCRMPartyChargeCardBObj);

					if (aBKMatchFound) {

						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyChargeCardBObj
								.setChargeCardLastUpdateDate(theTargetTCRMPartyChargeCardBObj
										.getChargeCardLastUpdateDate());
						theSourceTCRMPartyChargeCardBObj
								.setChargeCardLastUpdateTxId(theTargetTCRMPartyChargeCardBObj
										.getChargeCardLastUpdateTxId());
						theSourceTCRMPartyChargeCardBObj
								.setPaymentSourceIdPK(theTargetTCRMPartyChargeCardBObj
										.getPaymentSourceIdPK());
						theSourceTCRMPartyChargeCardBObj
								.setPaymentSourceLastUpdateDate(theTargetTCRMPartyChargeCardBObj
										.getPaymentSourceLastUpdateDate());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyChargeCardBObj
								.setPaymentSourceLastUpdateTxId(theTargetTCRMPartyChargeCardBObj
										.getPaymentSourceLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyChargeCardBObj.metaDataMap);

						break;
					}
				}
			}
		}
	}

	/**
	 * Method mergePersonBObj.
	 * 
	 * @param theSourceTCRMPersonBObj
	 *            TCRMPersonBObj
	 * @param theTargetTCRMPersonBObj
	 *            TCRMPersonBObj
	 * @modelguid {3B82DF8C-C200-4BF4-B456-1635D3A0D807}
	 */
	protected void mergePersonBObj(TCRMPersonBObj theSourceTCRMPersonBObj,
			TCRMPersonBObj theTargetTCRMPersonBObj) throws Exception {

		/**
		 * The TCRMPersonBObj will always have to be set to spawn an update
		 * because one and only one TCRMPersonBObj must exist in both source and
		 * target parties. Fields not set from in the target party are the
		 * PartyId, PersonPartyId, PartyLastUpdateDate and PersonLastUpdateDate
		 * as these are required to remain to trigger the update.
		 */
		theSourceTCRMPersonBObj.setPersonPartyId(theTargetTCRMPersonBObj
				.getPersonPartyId());
		theSourceTCRMPersonBObj.setPersonLastUpdateDate(theTargetTCRMPersonBObj
				.getPersonLastUpdateDate());
		theSourceTCRMPersonBObj
				.setPartyId(theTargetTCRMPersonBObj.getPartyId());
		theSourceTCRMPersonBObj.setPartyLastUpdateDate(theTargetTCRMPersonBObj
				.getPartyLastUpdateDate());
		// ensure  txnid being returned in merged objects
		theSourceTCRMPersonBObj.setPersonLastUpdateTxId(theTargetTCRMPersonBObj
				.getPersonLastUpdateTxId());
		theSourceTCRMPersonBObj.setPartyLastUpdateTxId(theTargetTCRMPersonBObj
				.getPartyLastUpdateTxId());
		
		// PMR 78853,L6Q,000
		theSourceTCRMPersonBObj.setCreatedDate(theTargetTCRMPersonBObj.getCreatedDate());
		// END PMR
		
	}

	/**
	 * Method mergeOrganizationBObj.
	 * 
	 * @param theSourceTCRMOrgBObj
	 *            TCRMOrganizationBObj
	 * @param theTargetTCRMOrgBObj
	 *            TCRMOrganizationBObj
	 * @modelguid {C426C5AB-CF52-4FED-B1C8-62B355B61D01}
	 */
	protected void mergeOrganizationBObj(
			TCRMOrganizationBObj theSourceTCRMOrgBObj,
			TCRMOrganizationBObj theTargetTCRMOrgBObj) throws Exception {

		/**
		 * The TCRMOrganizationBObj will always have to be set to spawn an update
		 * because one and only one TCRMOrganizattionBObj must exist in both source and
		 * target parties. Fields not set from in the target party are the
		 * PartyId, OrganizationPartyId, PartyLastUpdateDate and OrganizationLastUpdateDate
		 * as these are required to remain to trigger the update.
		 */
		theSourceTCRMOrgBObj.setOrganizationPartyId(theTargetTCRMOrgBObj
				.getOrganizationPartyId());
		theSourceTCRMOrgBObj.setOrganizationLastUpdateDate(theTargetTCRMOrgBObj
				.getOrganizationLastUpdateDate());
		theSourceTCRMOrgBObj.setPartyId(theTargetTCRMOrgBObj.getPartyId());
		theSourceTCRMOrgBObj.setPartyLastUpdateDate(theTargetTCRMOrgBObj
				.getPartyLastUpdateDate());
		//ensure txnid being returned in merged objects
		theSourceTCRMOrgBObj.setOrganizationLastUpdateTxId(theTargetTCRMOrgBObj
				.getOrganizationLastUpdateTxId());
		theSourceTCRMOrgBObj.setPartyLastUpdateTxId(theTargetTCRMOrgBObj
				.getPartyLastUpdateTxId());
		
		//PMR 78853,L6Q,000
		theSourceTCRMOrgBObj.setCreatedDate(theTargetTCRMOrgBObj.getCreatedDate());
		//END PMR
	}

	/**
	 * Method mergePartyValueBObj.
	 * 
	 * @param vecSourcePartyValueBObj
	 * @param vecTargetPartyValueBObj
	 */
	protected void mergePartyValueBObj(Vector vecSourcePartyValueBObj,
			Vector vecTargetPartyValueBObj) throws Exception {

		// if the existing/target party has at least one party value object, it
		// must be compared with any existing one
		for (int a = 0; a < vecSourcePartyValueBObj.size(); a++) {

			TCRMPartyValueBObj theSourceTCRMPartyValueBObj = (TCRMPartyValueBObj) vecSourcePartyValueBObj
					.elementAt(a);

			// compare it with the existing/target party value object(s)
			for (int b = 0; b < vecTargetPartyValueBObj.size(); b++) {

				TCRMPartyValueBObj theTargetTCRMPartyValueBObj = (TCRMPartyValueBObj) vecTargetPartyValueBObj
						.elementAt(b);
				boolean aBKMatchFound = theSourceTCRMPartyValueBObj
						.isBusinessKeySame(theTargetTCRMPartyValueBObj);

				if (aBKMatchFound) {

					// the business key is the same for the two objects, so set
					// the
					// lastupdate date and idpk on the source object to what is
					// on the target
					theSourceTCRMPartyValueBObj
							.setPartyValueLastUpdateDate(theTargetTCRMPartyValueBObj
									.getPartyValueLastUpdateDate());
					theSourceTCRMPartyValueBObj
							.setPartyValueId(theTargetTCRMPartyValueBObj
									.getPartyValueId());
					// ensure txnid being returned in merged objects
					theSourceTCRMPartyValueBObj
							.setPartyValueLastUpdateTxId(theTargetTCRMPartyValueBObj
									.getPartyValueLastUpdateTxId());

					// Set metaDataMap values to "", if they are null; due to
					// add transaction rule. By doing so,
					// related DB field is set to null in both blank and missing
					// tag cases in xml transaction requests.
					changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyValueBObj.metaDataMap);

					break;
				}
			}
		}

		// }
	}

	/**
	 * @param vecSourcePartyContactMethodPrivPrefBObj
	 * @param vecTargetPartyContactMethodPrivPrefBObj
	 */
	protected void mergePartyContactMethodPrivPrefBObj(
			Vector vecSourcePartyContactMethodPrivPrefBObj,
			Vector vecTargetPartyContactMethodPrivPrefBObj) throws Exception {
		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourcePartyContactMethodPrivPrefBObj != null)
				&& (vecSourcePartyContactMethodPrivPrefBObj.size() > 0)) {
			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyContactMethodPrivPrefBObj.size(); a++) {

				TCRMPartyContactMethodPrivPrefBObj theSourceTCRMPartyContactMethodPrivPrefBObj = (TCRMPartyContactMethodPrivPrefBObj) vecSourcePartyContactMethodPrivPrefBObj
						.elementAt(a);
				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyContactMethodPrivPrefBObj
						.size(); b++) {
					TCRMPartyContactMethodPrivPrefBObj theTargetTCRMPartyContactMethodPrivPrefBOb = (TCRMPartyContactMethodPrivPrefBObj) vecTargetPartyContactMethodPrivPrefBObj
							.elementAt(b);

					if (theSourceTCRMPartyContactMethodPrivPrefBObj
							.getLocationGroupId() == null) {
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setLocationGroupId(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getLocationGroupId());
					}
					boolean aBKMatchFound = theSourceTCRMPartyContactMethodPrivPrefBObj
							.isBusinessKeySame(theTargetTCRMPartyContactMethodPrivPrefBOb);
					if (aBKMatchFound) {
						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setPrivPrefLastUpdateDate(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getPrivPrefLastUpdateDate());
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setPartyContactMethodPrivPrefIdPK(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getPartyContactMethodPrivPrefIdPK());
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setLocationGroupId(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getLocationGroupId());
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setEntityPrivPrefLastUpdateDate(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getEntityPrivPrefLastUpdateDate());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setPrivPrefLastUpdateTxId(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getPrivPrefLastUpdateTxId());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyContactMethodPrivPrefBObj
								.setEntityPrivPrefLastUpdateTxId(theTargetTCRMPartyContactMethodPrivPrefBOb
										.getEntityPrivPrefLastUpdateTxId());

						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyContactMethodPrivPrefBObj.metaDataMap);

						mergeEntityInstancePrivPrefBObj(
								theSourceTCRMPartyContactMethodPrivPrefBObj
										.getItemsTCRMEntityInstancePrivPrefBObj(),
								theTargetTCRMPartyContactMethodPrivPrefBOb
										.getItemsTCRMEntityInstancePrivPrefBObj());

						break;
					}
				}
			}
		}

	}

	/**
	 * @param vecSourcePartyAddressPrivPrefBObj
	 * @param vecTargetPartyAddressPrivPrefBObj
	 */
	protected void mergePartyAddressPrivPrefBObj(
			Vector vecSourcePartyAddressPrivPrefBObj,
			Vector vecTargetPartyAddressPrivPrefBObj) throws Exception {
		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourcePartyAddressPrivPrefBObj != null)
				&& (vecSourcePartyAddressPrivPrefBObj.size() > 0)) {
			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyAddressPrivPrefBObj.size(); a++) {

				TCRMPartyAddressPrivPrefBObj theSourceTCRMPartyAddressPrivPrefBObj = (TCRMPartyAddressPrivPrefBObj) vecSourcePartyAddressPrivPrefBObj
						.elementAt(a);
				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyAddressPrivPrefBObj.size(); b++) {
					TCRMPartyAddressPrivPrefBObj theTargetTCRMPartyAddressPrivPrefBOb = (TCRMPartyAddressPrivPrefBObj) vecTargetPartyAddressPrivPrefBObj
							.elementAt(b);
					if (theSourceTCRMPartyAddressPrivPrefBObj
							.getLocationGroupId() == null) {
						theSourceTCRMPartyAddressPrivPrefBObj
								.setLocationGroupId(theTargetTCRMPartyAddressPrivPrefBOb
										.getLocationGroupId());
					}
					boolean aBKMatchFound = theSourceTCRMPartyAddressPrivPrefBObj
							.isBusinessKeySame(theTargetTCRMPartyAddressPrivPrefBOb);
					if (aBKMatchFound) {
						// the business key is the same for the two objects, so
						// set the
						// lastupdate date and idpk on the source object to what
						// is on the target
						theSourceTCRMPartyAddressPrivPrefBObj
								.setPrivPrefLastUpdateDate(theTargetTCRMPartyAddressPrivPrefBOb
										.getPrivPrefLastUpdateDate());

						theSourceTCRMPartyAddressPrivPrefBObj
							.setPartyAddressPrivPrefIdPK(theTargetTCRMPartyAddressPrivPrefBOb
									.getPartyAddressPrivPrefIdPK());
						
						theSourceTCRMPartyAddressPrivPrefBObj
								.setLocationGroupId(theTargetTCRMPartyAddressPrivPrefBOb
										.getLocationGroupId());
						theSourceTCRMPartyAddressPrivPrefBObj
								.setEntityPrivPrefLastUpdateDate(theTargetTCRMPartyAddressPrivPrefBOb
										.getEntityPrivPrefLastUpdateDate());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyAddressPrivPrefBObj
								.setPrivPrefLastUpdateTxId(theTargetTCRMPartyAddressPrivPrefBOb
										.getPrivPrefLastUpdateTxId());
						//ensure txnid being returned in merged objects
						theSourceTCRMPartyAddressPrivPrefBObj
								.setEntityPrivPrefLastUpdateTxId(theTargetTCRMPartyAddressPrivPrefBOb
										.getEntityPrivPrefLastUpdateTxId());
						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyAddressPrivPrefBObj.metaDataMap);

						mergeEntityInstancePrivPrefBObj(
								theSourceTCRMPartyAddressPrivPrefBObj
										.getItemsTCRMEntityInstancePrivPrefBObj(),
								theTargetTCRMPartyAddressPrivPrefBOb
										.getItemsTCRMEntityInstancePrivPrefBObj());

						break;
					}
				}
			}
		}

	}

	/**
	 * @param vecSourcePartyLocationPrivPrefBObj
	 * @param vecTargetPartyLocationPrivPrefBObj
	 */
	protected void mergePartyLocationPrivPrefBObj(
			Vector vecSourcePartyLocationPrivPrefBObj,
			Vector vecTargetPartyLocationPrivPrefBObj) throws Exception {
		// if the existing/target party has at least one admin cont equiv
		// object, it must be compared with any
		// incoming/source one admin cont equiv objects
		if ((vecSourcePartyLocationPrivPrefBObj != null)
				&& (vecSourcePartyLocationPrivPrefBObj.size() > 0)) {
			// for each person name object in the source
			for (int a = 0; a < vecSourcePartyLocationPrivPrefBObj.size(); a++) {

				TCRMPartyLocationPrivPrefBObj theSourceTCRMPartyLocationPrivPrefBObj = (TCRMPartyLocationPrivPrefBObj) vecSourcePartyLocationPrivPrefBObj
						.elementAt(a);
				// compare it with the existing/target person name object(s)
				for (int b = 0; b < vecTargetPartyLocationPrivPrefBObj.size(); b++) {
					TCRMPartyLocationPrivPrefBObj theTargetTCRMPartyLocationPrivPrefBOb = (TCRMPartyLocationPrivPrefBObj) vecTargetPartyLocationPrivPrefBObj
							.elementAt(b);
					if (theSourceTCRMPartyLocationPrivPrefBObj
							.getLocationGroupId() == null) {
						theSourceTCRMPartyLocationPrivPrefBObj
								.setLocationGroupId(theTargetTCRMPartyLocationPrivPrefBOb
										.getLocationGroupId());
					}
					boolean aBKMatchFound = theSourceTCRMPartyLocationPrivPrefBObj
							.isBusinessKeySame(theTargetTCRMPartyLocationPrivPrefBOb);
					if (aBKMatchFound) {
	
						theSourceTCRMPartyLocationPrivPrefBObj
								.setPrivPrefLastUpdateDate(theTargetTCRMPartyLocationPrivPrefBOb
										.getPrivPrefLastUpdateDate());
						theSourceTCRMPartyLocationPrivPrefBObj
								.setPartyLocationPrivPrefIdPK(theTargetTCRMPartyLocationPrivPrefBOb
										.getPartyLocationPrivPrefIdPK());
						theSourceTCRMPartyLocationPrivPrefBObj
								.setLocationGroupId(theTargetTCRMPartyLocationPrivPrefBOb
										.getLocationGroupId());
						theSourceTCRMPartyLocationPrivPrefBObj
								.setEntityPrivPrefLastUpdateDate(theTargetTCRMPartyLocationPrivPrefBOb
										.getEntityPrivPrefLastUpdateDate());
						//ensure txnid being returned in merged objects
						theSourceTCRMPartyLocationPrivPrefBObj
								.setPrivPrefLastUpdateTxId(theTargetTCRMPartyLocationPrivPrefBOb
										.getPrivPrefLastUpdateTxId());
						// ensure txnid being returned in merged objects
						theSourceTCRMPartyLocationPrivPrefBObj
								.setEntityPrivPrefLastUpdateTxId(theTargetTCRMPartyLocationPrivPrefBOb
										.getEntityPrivPrefLastUpdateTxId());

						// Set metaDataMap values to "", if they are null; due
						// to add transaction rule. By doing so,
						// related DB field is set to null in both blank and
						// missing tag cases in xml transaction requests.
						changeNullToEmptyStrInMetaDataMap(theSourceTCRMPartyLocationPrivPrefBObj.metaDataMap);

						mergeEntityInstancePrivPrefBObj(
								theSourceTCRMPartyLocationPrivPrefBObj
										.getItemsTCRMEntityInstancePrivPrefBObj(),
								theTargetTCRMPartyLocationPrivPrefBOb
										.getItemsTCRMEntityInstancePrivPrefBObj());

						break;
					}
				}
			}
		}

	}


	/**
	 * Method changeNullToEmptyStrInMetaDataMap, is used to set metaDataMap
	 * values to "", if they are null; due to add transaction rule. By doing so,
	 * related DB field is set to null in both blank and missing tag cases in
	 * xml transaction requests.
	 * 
	 * @param metMap
	 * @since 5.5
	 */
	private void changeNullToEmptyStrInMetaDataMap(Map metMap) {

		String attributeKey = null;
		String attributeValue = null;
		Iterator it = metMap.keySet().iterator();

		while (it.hasNext()) {
			attributeKey = (String) it.next();
			attributeValue = (String) metMap.get(attributeKey);
			if (attributeValue == null) {
				metMap.put(attributeKey, "");
			}
		}
	}

}
