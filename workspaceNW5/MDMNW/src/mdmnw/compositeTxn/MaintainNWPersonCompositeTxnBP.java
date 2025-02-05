/*
When using the MDM Workbench, users create a model of a required configuration and then "code generation"
is performed to build code that can implement that configuration. 
This is a process that can be repeated many times as the model is developed.
At any time, users have the option of manually customizing the generated code to inject additional
behaviour that cannot be defined in the model. Where this is done, an "@generated NOT" annotation
must be added immediately before the method definition to prevent the method from being overwritten
when code generation is next run. 

Note: The "NOT" in the "@generated NOT" above can be replaced with any text and have the same effect, but
we recommend that @generated NOT is used for consistency.
We also recommend against removing "@generated" tags as an alternative method of
indicating that a piece of java code is customized and protected from re-generation as doing this has the
effect of supressing the generation of .uncustomized files.

The level of granularity for marking code as "@generated NOT" is a method.

This approach maintains customizations in the code but leads to problems if the generated portion of
the method needs to be updated as a result of model changes (for example, if a field in an entity is removed).
In such cases the customized version of the code no longer reflects the model content and may be inconsistent
with other generated code leading to potential for failure at runtime or failure to compile.

The .uncustomized file you are reading represents the raw output from the internal code generator, before any
customizations from the associated .java file have been incorporated to build a replacement .java file.
If there are no methods marked as "@generated NOT" in the .java file then with the exception of some white 
space reformatting, the .unprocessed and .java files will be the same. Where a method is marked as
"@generated NOT", the .java file will contain the version that was marked as such with whatever manual
customizations have been applied and the the .uncustomized file will contain whatever code would be
created from the most recent model content.

If the .uncustomized files are maintained in a code control system alongside their associated .java file,
its possible to compare successive generations of the .uncustomized file to determine what generated code
is changing.

Should this file differ from what was previously checked-in to the source code control repository,
then there is a possibility that a section of code in the corresponding java file may need to be manually
updated. Some of the contents of this file may need to be manually merged into the .java file where
methods are marked with "@generated NOT."

When merging code from this file into the corresponding java file, use a compare program which ignores whitespace.

This file has a file extension of .uncustomized. Should you wish to hide these files from view in one of the
eclipse resource tree viewers, for example in the package explorer view, create a filter to hide files with
this file extension.
 *//*
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
 * IBM-MDMWB-1.0-[3c5e9a7771d0478b5ce35b40656f9a73]
 */

package mdmnw.compositeTxn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import mdmnw.component.CompositeNWPersonBObj;
import mdmnw.component.XNWAddressBObjExt;
import mdmnw.component.XNWPartyAddressBObjExt;
import mdmnw.component.XNWPersonBObjExt;
import mdmnw.component.XNWPersonNameBObjExt;
import mdmnw.constant.MDMNWComponentID;
import mdmnw.constant.MDMNWErrorReasonCode;
import mdmnw.externalrule.CollapsePartiesWithRules;
import mdmnw.utils.CommonUtil;

import com.dwl.base.DWLCommon;
import com.dwl.base.DWLControl;
import com.dwl.base.DWLResponse;
import com.dwl.base.IDWLErrorMessage;
import com.dwl.base.error.DWLError;
import com.dwl.base.error.DWLStatus;
import com.dwl.base.exception.DWLPropertyNotFoundException;
import com.dwl.base.requestHandler.DWLTransactionPersistent;
import com.dwl.base.util.StringUtils;
import com.dwl.management.ManagementException;
import com.dwl.management.config.client.Configuration;
import com.dwl.management.config.repository.ConfigurationRepositoryException;
import com.dwl.tcrm.common.TCRMResponse;
import com.dwl.tcrm.coreParty.component.TCRMAdminContEquivBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyAddressBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyIdentificationBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyValueBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;
import com.dwl.tcrm.coreParty.constant.TCRMCorePropertyKeys;
import com.dwl.tcrm.coreParty.interfaces.IParty;
import com.dwl.tcrm.utilities.TCRMClassFactory;
import com.dwl.unifi.tx.exception.BusinessProxyException;

/**
 * This class represent custom logic used in Northwell MDM for processing Person records
 * 
 * The class handles add and update transactions for Person, along with additional custom functionality
 * 
 * TERMS: 
 * - "Input" data represent the data to be used in add or update.
 * - "Existing" data represents the data that is already present in the MDM database for the record.
 * 
 * The following are what this class is used for:
 * 
 * 1. Adding records (NOTE: After an add, MDM checks to see if the added record "links" to another record. 
 * 						If it does, then the class mdmnw.externalrule.SuspectAddPartyRule takes over to collapse the two records)
 * 2. Updating records
 * 3. Performing survivorship logic on records upon updating of record
 * 		- i.e. input data may come from sources that are not preferred for a given attribute, whereas the existing record
 * 			has the data from that preferred source. In that case, ignore the input update for that attribute
 * 4. Handles SQL update of custom address fields (since out of box service cannot seem to this)
 * 5. Handles defaulting Start Dates to 1900-01-01 when the Start Date comes in blank but the end date is populated
 * 6. Handles defaulting address fields to "Unknown" when addrline1, city, or state is not present but other 
 * 		address payload is present (since that data can be useful)
 * 7. Handles setting setting end date when an inactivation flag comes in and end date is black or in the future
 * 8. Handles setting inactivation flag when an end date comes in and the flag is blank (only for certain attributes)
 * 9. Handle custom logic for party address association... 
 * 		keep existing record data if update is has primary billing or scheduling flag set, otherwise keep the input record data
 * 10. Handle updating single existing value for a usage type that can only hold one valid value (such as SSN), 
 * 		vs adding a new values for a usage type that should accommodate multiple valid values (such as "Also Known As" name). 
 * 
 * @generated NOT
 */
public class MaintainNWPersonCompositeTxnBP extends CommonUtil  {

	/**
	 * @generated NOT
	 **/
	private IDWLErrorMessage errHandler;
	private CollapsePartiesWithRules collapseWRules = new CollapsePartiesWithRules();
	private ArrayList<String> multiValueNames;
	private ArrayList<String> multiValueIds;
	private ArrayList<String> multiValueAddresses;
	private ArrayList<String> singleValuePartyVals;
	private boolean survivorshipRulesEnabledForUpdate;
	private IParty partyComp;
	private String sourceCode;
	private String sourceIdNum;
	
	/**
	 * Set logger for this class
	 * @generated NOT
	 */
	private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(MaintainNWPersonCompositeTxnBP.class);

	/**
	 * @throws Exception 
	 * @generated NOT
	 * 
	 * Instantiate error handler, collapsing class, and set name usage types where multiple values should be allowed.
	 * 
	 **/
	public MaintainNWPersonCompositeTxnBP() throws Exception {
		super();
		errHandler = TCRMClassFactory.getErrorHandler();
		multiValueNames = new ArrayList<String>();
		multiValueIds = new ArrayList<String>();
		multiValueAddresses = new ArrayList<String>();
		singleValuePartyVals = new ArrayList<String>();
		multiValueNames.add("Also Known As");		
		multiValueIds.add("State License Number");
		multiValueAddresses.add("Scheduling Address");
		multiValueAddresses.add("Billing Address");
		multiValueAddresses.add("Mailing Address");
		multiValueAddresses.add("Facility Address");
		multiValueAddresses.add("Ordering Address");
		singleValuePartyVals.add("Role Status");
		sourceCode = "";
		sourceIdNum = "";
		partyComp = (IParty) TCRMClassFactory
				.getTCRMComponent(TCRMCorePropertyKeys.PARTY_COMPONENT);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public DWLResponse processInput(XNWPersonBObjExt personInput, DWLControl control, String partyId) throws Exception{

		// remove objects from input where all the primary inputs are blank
		removeEmptyTCRMObjects(personInput);
		
		// Pre-process rows with various custom modifications
		preprocessData(personInput);

		// get survivorship rules from the configuration to be used during updates. Return error is config not found.
		try {
			survivorshipRulesEnabledForUpdate = Boolean.parseBoolean(Configuration.getConfiguration()
					.getConfigItem("SurvivorshipRulesEnabledForUpdate", personInput.getControl().retrieveConfigContext())
					.getValue());

			if(survivorshipRulesEnabledForUpdate && collapseWRules.areSurvivorshipConfigsSet() == false){
				collapseWRules.setSurvivorshipConfigs(personInput.getControl());
				logger.info("Survivorship rules for updates have been set.");
			}

		} catch (ConfigurationRepositoryException e1) {
//			recordTxn("FATAL - Error Getting Survivorship Rules Enable Flag. Defaulting to disabling record collapsing.");
			logger.error("Error Getting Survivorship Rules Enable Flag. Defaulting to disabling record collapsing.");
			survivorshipRulesEnabledForUpdate = false;
		} catch (ManagementException e1) {
//			recordTxn("FATAL - Error Getting Survivorship Rules Enable Flag. Defaulting to disabling record collapsing.");
			logger.error("Error Getting Survivorship Rules Enable Flag. Defaulting to disabling record collapsing.");
			survivorshipRulesEnabledForUpdate = false;
		} catch (DWLPropertyNotFoundException e) {
//			recordTxn("FATAL - Error Getting Survivorship Rules Enable Flag. Defaulting to disabling record collapsing.");
			logger.error("Error Getting Survivorship Rules Enable Flag. Defaulting to disabling record collapsing.");
			survivorshipRulesEnabledForUpdate = false;
		}

		// get the source identifier object from the input

		if(partyId == null){
			
			sourceCode = "";
			sourceIdNum = "";
			
			for (Object sourceId : personInput.getItemsTCRMAdminContEquivBObj()) {

				sourceCode = ((TCRMAdminContEquivBObj)sourceId).getAdminSystemValue();
				sourceIdNum = ((TCRMAdminContEquivBObj)sourceId).getAdminPartyId();
				String dbPartyId = CommonUtil.getPartyIdPkFromSourceId(sourceCode, sourceIdNum);
				if(dbPartyId != null){
					partyId = dbPartyId;
				}
			}
		}

		logger.info("Processing " + sourceCode + ":" + sourceIdNum);

		String txnType = "addPerson";

		// get the party id from mdm if it already exist in the database

		// if party id was not null, it means the party is already in MDM and this should be treated as an update, not an add
		if(partyId != null){
			try {

				// set typical update person params
				txnType = "updatePerson";
				personInput.setPartyId(partyId);

				// set get person params to get existing person object
				Vector<String> params = new Vector<String>();
				params.add(partyId);
				params.add(this.INQRY_LVL_5);

				// execute get person transaction
				DWLResponse response = invokeBaseInquiryTxn(this.TXN_GETPERSON, params, control);

				// get person as XNWPersonBObjExt object and set last update dates in order to be able to update the object
				XNWPersonBObjExt existingPerson = (XNWPersonBObjExt)response.getData();
				personInput.setPersonLastUpdateDate(existingPerson.getPersonLastUpdateDate());
				personInput.setPartyLastUpdateDate(existingPerson.getPartyLastUpdateDate());
				personInput.setPersonLastUpdateUser("MaintainNWPersonCompositeTxnBP");

				// handle child attribute updates individually. 
				//  NOTE: Could not do this in one call because the address was not getting updated as expected 
				//			when done in one call (no update of partyaddress data was occurring)
				handleChildAttributes(personInput, existingPerson, control);

				// if survivorship rules are enabled, merge the top level person objects (input with existing)
				if(survivorshipRulesEnabledForUpdate){
					collapseWRules.mergePersonBObj(personInput, existingPerson, personInput);
				}

				// since child objects were already handled individually, clear them out from the person, 
				//	except for name which is always part of the required input
				personInput.getItemsTCRMPartyAddressBObj().clear();
				personInput.getItemsTCRMPartyContactMethodBObj().clear();
				personInput.getItemsTCRMPartyIdentificationBObj().clear();
				personInput.getItemsTCRMPartyValueBObj().clear();
				personInput.getItemsTCRMAdminContEquivBObj().clear();

			} catch (BusinessProxyException e) {

//				// throw specific error message if transaction fails for any reason
//				DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
//						"INSERR",
//						MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
//						control, new String[0]);

//				recordTxn("FATAL - Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + e.getMessage());
				throw new BusinessProxyException("Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + e.getMessage(), e);
			} catch (Exception e) {
//				DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
//						"INSERR",
//						MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
//						control, new String[0]);

//				recordTxn("FATAL - Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + e.getMessage());
				throw new BusinessProxyException("Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + e.getMessage(), e);
			}
		} 

		// Prepare a new DWLTransactionPersistent instance. (in preparation to commit transaction)
		personInput.setControl(control);
		DWLTransactionPersistent personRequest = new DWLTransactionPersistent();
		personRequest.setTxnControl(control);
		personRequest.setTxnType(txnType);
		personRequest.setTxnTopLevelObject(personInput);

		// Prepare a reference to hold the response for this transaction.
		DWLResponse personResponse = null;
		XNWPersonBObjExt resp = null;

		// Invoke the transaction and return specific error response if there were any issues
		try {
			personResponse = (DWLResponse) super.execute(personRequest);
			resp = (XNWPersonBObjExt)personResponse.getData();
			
			if(resp == null){
				DWLError error = (DWLError)personResponse.getStatus().getDwlErrorGroup().get(0);
				String errorStr = error.getErrorMessage();
				
				if(errorStr.equals("The following is required: PersonName")){
					errorStr = "The record that this transaction is trying to update does not exist. Record: " + sourceCode + ":" + sourceIdNum;
				}
				
				throw new Exception(errorStr);
			}

			// delete unique address string being stored in stline3 that was used to force insertion of record using additional facility, location, department keys
			for (TCRMPartyAddressBObj partyAddr : (Vector<TCRMPartyAddressBObj>)resp.getItemsTCRMPartyAddressBObj()) {
				deleteStline3(partyAddr.getTCRMAddressBObj().getAddressIdPK());
			}
		}
		catch (BusinessProxyException e) {
//			DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
//					"INSERR",
//					MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
//					control, new String[0]);
//			recordTxn("FATAL - Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + e.getMessage());
			throw new BusinessProxyException("Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + e.getMessage(), e);
		}

		if (personResponse == null)  {
			DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
					"INSERR",
					MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
					control, new String[0]);
//			recordTxn("FATAL - Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + error.getErrorMessage());
			throw new BusinessProxyException("Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + error.getErrorMessage());
		}
		else if (personResponse.getStatus().getStatus() == DWLStatus.FATAL) {
			DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
					"INSERR",
					MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
					control, new String[0]);
//			recordTxn("FATAL - Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + error.getErrorMessage());
			throw new BusinessProxyException("Person ID Affected: " + sourceCode + ":" +  sourceIdNum + " -- " + " Party ID: " + partyId + " -- " + error.getErrorMessage());
		}

		return personResponse;
	}

	/**
		 * @generated NOT
		 * 
		 * execute() is the method called when the transaction is submitted to MDM. This is the main path of the code.
		 **/
		@SuppressWarnings("unchecked")
		public Object execute(Object inputObj) throws BusinessProxyException {
			Long startTime = System.currentTimeMillis();
	
			logger.finest("ENTER Object execute(Object inputObj)");
	
			// Handle parsing the input objects and returning error is the top level object is not a CompositeNWPersonBObj
			TCRMResponse outputTxnObj = null;
			DWLResponse personResponse = null;
			DWLTransactionPersistent inputTxnObj = (DWLTransactionPersistent) inputObj;
			DWLControl control = inputTxnObj.getTxnControl();
			DWLCommon topLevelObject = (DWLCommon) inputTxnObj.getTxnTopLevelObject();
			if (!(topLevelObject instanceof CompositeNWPersonBObj)) {
				DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
						"INSERR",
						MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
						control, new String[0]);
	//			recordTxn("FATAL - Top level object not identified as CompositeNWPersonBObj type");
				throw new BusinessProxyException("Top level object not identified as CompositeNWPersonBObj type");
			}
	
			// get this CompositeNWPersonBObj (AKA top level object) from the input
			CompositeNWPersonBObj mainInput = (CompositeNWPersonBObj) topLevelObject;
	
			// get the XNWPersonBObjExt (person object) from the input. This is embeeded in the CompositeNWPersonBObj object
			XNWPersonBObjExt personInput = (XNWPersonBObjExt)mainInput.getTCRMPersonBObj();
	
			try {
				personResponse = processInput(personInput, control, null);
	
				// Extract the returned business object from the response.
				TCRMPersonBObj personOutput = (TCRMPersonBObj) personResponse.getData();
				CompositeNWPersonBObj mainOutput = new CompositeNWPersonBObj();
				mainOutput.setTCRMPersonBObj(personOutput);
				mainOutput.setControl(control);
	
				// Construct the response object.
				DWLStatus outputStatus = new DWLStatus();
				outputStatus.setStatus(DWLStatus.SUCCESS);
				outputTxnObj = new TCRMResponse();
				outputTxnObj.setStatus(outputStatus);
				outputTxnObj.setData(mainOutput);
				logger.finest("RETURN Object execute(Object inputObj)");
	
				if(personResponse != null)
					recordTxn(mainOutput.toXML());
	
			} catch (Exception e) {
	//			recordTxn("FATAL - Party ID: " + personInput.getPartyId() + " -- " + e.getMessage());
	
				throw new BusinessProxyException("Party ID: " + personInput.getPartyId() + " -- " + e.getMessage());
			}
	
			Long endTime = System.currentTimeMillis();
			Long duration = endTime - startTime;
	
			logger.info("Maintain transaction duration: " + duration);
	
			return outputTxnObj;
		}

	private void preprocessData(XNWPersonBObjExt personInput) throws Exception {
		Vector<XNWPartyAddressBObjExt> inputPartyAddresses = personInput.getItemsTCRMPartyAddressBObj();
		Vector<TCRMPartyContactMethodBObj> inputPartyContactMethods = personInput.getItemsTCRMPartyContactMethodBObj();
		Vector<TCRMPartyIdentificationBObj> inputPartyIdentifications = personInput.getItemsTCRMPartyIdentificationBObj();
		Vector<XNWPersonNameBObjExt> inputPersonNames = personInput.getItemsTCRMPersonNameBObj();
		Vector<TCRMPartyValueBObj> inputPartyValues = personInput.getItemsTCRMPartyValueBObj();
		
		// Check person last verified date and remove it if blank
		if(StringUtils.isBlank(personInput.getLastVerifiedDate())){
			personInput.setLastVerifiedDate(null);
		}

		// set gender's source and last modified date individually
		if(StringUtils.isNonBlank(personInput.getGenderType())){
			personInput.setXGender_Source(personInput.getSourceIdentifierValue());
			personInput.setXGender_LastVerifiedDate(personInput.getLastVerifiedDate());
		}

		// set marital status's source and last modified date individually
		if(StringUtils.isNonBlank(personInput.getMaritalStatusValue())){
			personInput.setXMaritalStatus_Source(personInput.getSourceIdentifierValue());
			personInput.setXMaritalStatus_LastVerifiedDate(personInput.getLastVerifiedDate());
		}

		// set employment-related fields' source and last modified date individually
		if(StringUtils.isNonBlank(personInput.getXBusiness_Unit()) || StringUtils.isNonBlank(personInput.getXDepartment_ID()) || StringUtils.isNonBlank(personInput.getXDepartment_Name())
				|| StringUtils.isNonBlank(personInput.getXEmployee_Role_Status()) || StringUtils.isNonBlank(personInput.getXFullTime_PartTIme())
				|| StringUtils.isNonBlank(personInput.getXHire_Date()) || StringUtils.isNonBlank(personInput.getXJob_Family()) || StringUtils.isNonBlank(personInput.getXJob_Title())
				|| StringUtils.isNonBlank(personInput.getXRehire_Date()) || StringUtils.isNonBlank(personInput.getXService_Line_Financial_Budgetary())
				|| StringUtils.isNonBlank(personInput.getXStandard_Hours()) || StringUtils.isNonBlank(personInput.getXTermination_Date())){
			personInput.setXEmploymentData_Source(personInput.getSourceIdentifierValue()); 
			personInput.setXEmploymentData_LastVerifiedDate(personInput.getLastVerifiedDate());
		}

		for (TCRMPartyValueBObj inputPartyValue : inputPartyValues) {
			// handle inactive flags and dates, update them as necessary
			handlePartyValueInactiveFields(inputPartyValue);

			// set artificial start date if end date is present but start date is not present
			if(StringUtils.isBlank(inputPartyValue.getStartDate())){
				inputPartyValue.setStartDate("1900-01-01 00:00:00.000");
			}
		}

		for (XNWPersonNameBObjExt inputName : inputPersonNames) {

			// set degree's source and last modified date individually
			if(StringUtils.isNonBlank(inputName.getXDegree())){
				inputName.setXDegree_Source(inputName.getSourceIdentifierValue());
				inputName.setXDegree_LastVerifiedDate(inputName.getLastVerifiedDate());
			}

			// set artificial start date if end date is present but start date is not present
			if(StringUtils.isBlank(inputName.getStartDate())){
				inputName.setStartDate("1900-01-01 00:00:00.000");
			}
			
			// Check last verified date and remove it if blank
			if(StringUtils.isBlank(inputName.getLastVerifiedDate())){
				inputName.setLastVerifiedDate(null);
			}
		}

		for (TCRMPartyIdentificationBObj inputPartyIdentification : inputPartyIdentifications) {

			// handle inactive flags and dates, update them as necessary
			handlePartyIdentificationInactiveFields(inputPartyIdentification);

			// set artificial start date if end date is present but start date is not present
			if(StringUtils.isBlank(inputPartyIdentification.getStartDate())){
				inputPartyIdentification.setStartDate("1900-01-01 00:00:00.000");
			}
			
			// Check last verified date and remove it if blank
			if(StringUtils.isBlank(inputPartyIdentification.getLastVerifiedDate())){
				inputPartyIdentification.setLastVerifiedDate(null);
			}
		}

		for (TCRMPartyContactMethodBObj inputPartyContactMethod : inputPartyContactMethods) {
			// set artificial start date if end date is present but start date is not present
			if(StringUtils.isBlank(inputPartyContactMethod.getStartDate())){
				inputPartyContactMethod.setStartDate("1900-01-01 00:00:00.000");
			}
			
			// Check last verified date and remove it if blank
			if(StringUtils.isBlank(inputPartyContactMethod.getLastVerifiedDate())){
				inputPartyContactMethod.setLastVerifiedDate(null);
			}
		}

		for (XNWPartyAddressBObjExt inputAddr : inputPartyAddresses) {

			// set address tax id's source and last modified date individually
			if(StringUtils.isNonBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXTax_ID_Number())){
				((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXTax_ID_Number_Source(inputAddr.getSourceIdentifierValue());
				((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXTax_ID_Number_LastVerifiedDate(inputAddr.getLastVerifiedDate());
			}

			// set address newport key's source and last modified date individually
			if(StringUtils.isNonBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXNewport_Key())){
				((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXNewport_Key_Source(inputAddr.getSourceIdentifierValue());
				((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXNewport_Key_LastVerifiedDate(inputAddr.getLastVerifiedDate());
			}

			// set blank critical address line to Unknown in order to bring in other important address data
			// (since mdm will reject record if addr line 1, city, or state are blank
			if(StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getAddressLineOne(), null) ||
					StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getAddressLineOne(), "")){
				inputAddr.getTCRMAddressBObj().setAddressLineOne("Unknown");
			}

			if(StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getCity(), null) ||
					StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getCity(), "")){
				inputAddr.getTCRMAddressBObj().setCity("Unknown");
			}

			if(StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getProvinceStateValue(), null) ||
					StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getProvinceStateValue(), "")){
				inputAddr.getTCRMAddressBObj().setProvinceStateValue("Unknown");
			}

			// handle inactive flags and dates, update them as necessary
			handleAddressInactiveFields(inputAddr);

			// set artificial start date if end date is present but start date is not present
			if(StringUtils.isBlank(inputAddr.getStartDate())){
				inputAddr.setStartDate("1900-01-01 00:00:00.000");
			}

			// have to artificially set a unique addressline 3 for this address in order take into account dept, loc, and facility in business key since mdm is not doing it properly
			inputAddr.getTCRMAddressBObj().setAddressLineThree(getUniqueAddrStr((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()));
			
			// Check last verified date and remove it if blank
			if(StringUtils.isBlank(inputAddr.getLastVerifiedDate())){
				inputAddr.setLastVerifiedDate(null);
			}
		}
	}
	@SuppressWarnings("unchecked")
	public XNWPersonBObjExt handleChildAttributes(XNWPersonBObjExt personInput,
			XNWPersonBObjExt existingPerson, DWLControl control) throws Exception {

		// handle all updates individually by attribute type. First get the objects from the input/existing record then handle each individually.
		// the below gets all relevant objects
		Vector<XNWPartyAddressBObjExt> inputPartyAddresses = personInput.getItemsTCRMPartyAddressBObj();
		Vector<TCRMPartyContactMethodBObj> inputPartyContactMethods = personInput.getItemsTCRMPartyContactMethodBObj();
		Vector<TCRMPartyIdentificationBObj> inputPartyIdentifications = personInput.getItemsTCRMPartyIdentificationBObj();
		Vector<XNWPersonNameBObjExt> inputPersonNames = personInput.getItemsTCRMPersonNameBObj();
		Vector<TCRMPartyValueBObj> inputPartyValues = personInput.getItemsTCRMPartyValueBObj();
		Vector<TCRMAdminContEquivBObj> inputPartyContEquivs = personInput.getItemsTCRMAdminContEquivBObj();
		Vector<XNWPartyAddressBObjExt> existingPartyAddresses = existingPerson.getItemsTCRMPartyAddressBObj();
		Vector<TCRMPartyContactMethodBObj> existingPartyContactMethods = existingPerson.getItemsTCRMPartyContactMethodBObj();
		Vector<TCRMPartyIdentificationBObj> existingPartyIdentifications = existingPerson.getItemsTCRMPartyIdentificationBObj();
		Vector<XNWPersonNameBObjExt> existingPersonNames = existingPerson.getItemsTCRMPersonNameBObj();
		Vector<TCRMPartyValueBObj> existingPartyValues = existingPerson.getItemsTCRMPartyValueBObj();
		Vector<TCRMAdminContEquivBObj> existingPartyContEquivs = ((IParty) partyComp).getAllPartyAdminSysKeys(existingPerson.getPartyId(), control);

		// the below takes the objects and handles the update for each type
		handlePartyAddresses(existingPerson, inputPartyAddresses, existingPartyAddresses, control);
		handlePartyContactMethods(existingPerson, inputPartyContactMethods, existingPartyContactMethods, control);
		handlePartyIdentifications(existingPerson, inputPartyIdentifications, existingPartyIdentifications, control);
		handlePersonNames(existingPerson, inputPersonNames, existingPersonNames, control);
		handlePartyValues(existingPerson, inputPartyValues, existingPartyValues, control);
		handleAdminContEquivs(existingPerson, inputPartyContEquivs, existingPartyContEquivs, control);

		return personInput;

	}


	private Vector<TCRMAdminContEquivBObj> handleAdminContEquivs(XNWPersonBObjExt existingPerson,
			Vector<TCRMAdminContEquivBObj> inputPartyContEquivs,
			Vector<TCRMAdminContEquivBObj> existingPartyContEquivs,
			DWLControl control) throws Exception {

		for (TCRMAdminContEquivBObj inputPartyContEquiv : inputPartyContEquivs) {
			boolean updated = false;
			for (TCRMAdminContEquivBObj existingPartyContEquiv : existingPartyContEquivs) {

				// Check to see if source + source id already exists. If it does, this is an attribute update. 
				//	Otherwise it is an attribute add to the existing person record.
				if(StringUtils.compareWithTrim(inputPartyContEquiv.getAdminSystemValue(), existingPartyContEquiv.getAdminSystemValue()) 
						&& StringUtils.compareWithTrim(inputPartyContEquiv.getAdminPartyId(), existingPartyContEquiv.getAdminPartyId())
						){

					// set required fields and commit attribute update
					inputPartyContEquiv.setPartyId(existingPartyContEquiv.getPartyId());
					inputPartyContEquiv.setAdminContEquivIdPK(existingPartyContEquiv.getAdminContEquivIdPK());
					inputPartyContEquiv.setContEquivLastUpdateDate(existingPartyContEquiv.getContEquivLastUpdateDate());
					handleTransaction(inputPartyContEquiv, "updatePartyAdminSysKey", control, errHandler, "1036", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
					break;
				}
			}

			// if not an update, perform an add to add the attribute to the existing record
			if(updated == false){
				inputPartyContEquiv.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyContEquiv, "addPartyAdminSysKey", control, errHandler, "1036", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyContEquivs;

	}

	@SuppressWarnings("unchecked")
	private Vector<TCRMPartyValueBObj> handlePartyValues(TCRMPersonBObj existingPerson, Vector<TCRMPartyValueBObj> inputPartyValues, Vector<TCRMPartyValueBObj> existingPartyValues, DWLControl control) throws Exception {

		// apply survivorship rules on update, removing data that didn't survive when compared to existing data
		if(survivorshipRulesEnabledForUpdate)
			collapseWRules.mergePartyValueBObj(true, inputPartyValues, existingPartyValues, new XNWPersonBObjExt());

		for (TCRMPartyValueBObj inputPartyValue : inputPartyValues) {
			boolean updated = false;
			for (TCRMPartyValueBObj existingPartyValue : existingPartyValues) {

				// Check to see if usage type + value already exists. If it does, this is an attribute update. 
				//	Otherwise it is an attribute add to the existing person record... unless it is in the singleValuePartyVals list, then update it even if value string is different
				if((StringUtils.compareWithTrim(inputPartyValue.getPartyValueValue(), existingPartyValue.getPartyValueValue()) 
						&& singleValuePartyVals.contains(inputPartyValue.getPartyValueValue())) 
					||
						(StringUtils.compareWithTrim(inputPartyValue.getPartyValueValue(), existingPartyValue.getPartyValueValue()) 
						&& StringUtils.compareWithTrim(inputPartyValue.getValueString(), existingPartyValue.getValueString())
						)){

					// set required fields and commit attribute update
					inputPartyValue.setPartyValueId(existingPartyValue.getPartyValueId());
					inputPartyValue.setPartyValueLastUpdateDate(existingPartyValue.getPartyValueLastUpdateDate());
					handleTransaction(inputPartyValue, "updatePartyValue", control, errHandler, "1036", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
					break;
				}
			}

			// if not an update, perform an add to add the attribute to the existing record
			if(updated == false){
				inputPartyValue.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyValue, "addPartyValue", control, errHandler, "1036", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyValues;

	}


	private Vector<XNWPersonNameBObjExt> handlePersonNames(XNWPersonBObjExt existingPerson, Vector<XNWPersonNameBObjExt> inputPersonNames, Vector<XNWPersonNameBObjExt> existingPersonNames, DWLControl control) throws Exception {

		// apply survivorship rules on update, removing data that didn't survive when compared to existing data
		if(survivorshipRulesEnabledForUpdate)
			collapseWRules.mergePersonNameBObj(true, inputPersonNames, existingPersonNames, new XNWPersonBObjExt());

		for (XNWPersonNameBObjExt inputName : inputPersonNames) {
			boolean updated = false;
			for (XNWPersonNameBObjExt existingName : existingPersonNames) {

				// Check to see if usage type already exists. If it does, this is an attribute update. 
				//	Otherwise it is an attribute add to the existing person record.
				// The exception is for multi-value names. In this case, it is checked if the *usage type + value* already exists
				if(StringUtils.compareWithTrim(inputName.getNameUsageValue(), existingName.getNameUsageValue()) 
						&& (!multiValueNames.contains(inputName.getNameUsageValue()) || 
								(multiValueNames.contains(inputName.getNameUsageValue())
										&& StringUtils.compareWithTrim(inputName.getGivenNameOne(), existingName.getGivenNameOne()) 
										&& StringUtils.compareWithTrim(inputName.getLastName(), existingName.getLastName()) 
										&& (StringUtils.compareWithTrim(inputName.getGivenNameTwo(), existingName.getGivenNameTwo()) || 
												(inputName.getGivenNameTwo() == null && existingName.getGivenNameTwo() != null) || 
												(inputName.getGivenNameTwo() != null && existingName.getGivenNameTwo() == null)
												)
										)
								)
						){

					// in case where multiple name are allowed, if the middle name is not present on the input record
					// but is present on the existing record, keep the middle name from the existing record
					if(multiValueNames.contains(inputName.getNameUsageValue())
							&& inputName.getGivenNameTwo() == null && existingName.getGivenNameTwo() != null){
						inputName.setGivenNameTwo(existingName.getGivenNameTwo());
					}

					// set required fields and commit attribute update
					inputName.setPersonNameIdPK(existingName.getPersonNameIdPK());
					inputName.setLastUpdatedDate(existingName.getLastUpdatedDate());
					handleTransaction(inputName, "updatePersonName", control, errHandler, "2000242", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
					break;
				}
			}

			// if not an update, perform an add to add the attribute to the existing record
			if(updated == false){
				inputName.setPersonPartyId(existingPerson.getPartyId());
				handleTransaction(inputName, "addPersonName", control, errHandler, "2000242", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPersonNames;

	}


	private Vector<TCRMPartyIdentificationBObj> handlePartyIdentifications(TCRMPersonBObj existingPerson, Vector<TCRMPartyIdentificationBObj> inputPartyIdentifications, Vector<TCRMPartyIdentificationBObj> existingPartyIdentifications, DWLControl control) throws Exception {

		// apply survivorship rules on update, removing data that didn't survive when compared to existing data
		if(survivorshipRulesEnabledForUpdate)
			collapseWRules.mergePartyIdentificationBObj(true, inputPartyIdentifications, existingPartyIdentifications, new XNWPersonBObjExt());

		for (TCRMPartyIdentificationBObj inputPartyIdentification : inputPartyIdentifications) {
			boolean updated = false;
			for (TCRMPartyIdentificationBObj existingPartyIdentification : existingPartyIdentifications) {

				// Check to see if usage type already exists. If it does, this is an attribute update. 
				//	Otherwise it is an attribute add to the existing person record.
				// The exception is for multi-value party ids. In this case, it is checked if the *usage type + value* already exists
				if(StringUtils.compareWithTrim(inputPartyIdentification.getIdentificationValue(), existingPartyIdentification.getIdentificationValue())
						&& (!multiValueIds.contains(inputPartyIdentification.getIdentificationValue()) || 
								(multiValueIds.contains(inputPartyIdentification.getIdentificationValue())
										&& StringUtils.compareWithTrim(inputPartyIdentification.getIdentificationNumber(), existingPartyIdentification.getIdentificationNumber())
										)
								)
						){

					// set required fields and commit attribute update
					inputPartyIdentification.setIdentificationIdPK(existingPartyIdentification.getIdentificationIdPK());
					inputPartyIdentification.setPartyIdentificationLastUpdateDate(existingPartyIdentification.getPartyIdentificationLastUpdateDate());
					handleTransaction(inputPartyIdentification, "updatePartyIdentification", control, errHandler, "1010", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
					break;
				}
			}

			// if not an update, perform an add to add the attribute to the existing record
			if(updated == false){
				inputPartyIdentification.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyIdentification, "addPartyIdentification", control, errHandler, "1010", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyIdentifications;

	}


	private Vector<TCRMPartyContactMethodBObj> handlePartyContactMethods(TCRMPersonBObj existingPerson, Vector<TCRMPartyContactMethodBObj> inputPartyContactMethods, Vector<TCRMPartyContactMethodBObj> existingPartyContactMethods, DWLControl control) throws Exception {

		// apply survivorship rules on update, removing data that didn't survive when compared to existing data
		if(survivorshipRulesEnabledForUpdate)
			collapseWRules.mergePartyContactMethodBObj(true, inputPartyContactMethods, existingPartyContactMethods, new XNWPersonBObjExt());

		for (TCRMPartyContactMethodBObj inputPartyContactMethod : inputPartyContactMethods) {
			boolean updated = false;
			for (TCRMPartyContactMethodBObj existingPartyContactMethod : existingPartyContactMethods) {

				// Check to see if usage type already exists. If it does, this is an attribute update. 
				//	Otherwise it is an attribute add to the existing person record.
				if(StringUtils.compareWithTrim(inputPartyContactMethod.getContactMethodUsageValue(), existingPartyContactMethod.getContactMethodUsageValue()) 
						){

					// set required fields and commit attribute update
					inputPartyContactMethod.setPartyId(existingPartyContactMethod.getPartyId());
					inputPartyContactMethod.setPartyContactMethodIdPK(existingPartyContactMethod.getPartyContactMethodIdPK());
					inputPartyContactMethod.getTCRMContactMethodBObj().setContactMethodIdPK(existingPartyContactMethod.getTCRMContactMethodBObj().getContactMethodIdPK());
					inputPartyContactMethod.setLocationGroupLastUpdateDate(existingPartyContactMethod.getLocationGroupLastUpdateDate());
					inputPartyContactMethod.setContactMethodGroupLastUpdateDate(existingPartyContactMethod.getContactMethodGroupLastUpdateDate());
					inputPartyContactMethod.getTCRMContactMethodBObj().setContactMethodLastUpdateDate(existingPartyContactMethod.getTCRMContactMethodBObj().getContactMethodLastUpdateDate());
					inputPartyContactMethod.setContactMethodId(existingPartyContactMethod.getContactMethodId());

					handleTransaction(inputPartyContactMethod, "updatePartyContactMethod", control, errHandler, "1009", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
					updated = true;
					break;
				}
			}

			// if not an update, perform an add to add the attribute to the existing record
			if(updated == false){
				inputPartyContactMethod.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyContactMethod, "addPartyContactMethod", control, errHandler, "1009", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyContactMethods;

	}

	@SuppressWarnings("unchecked")
	private Vector<XNWPartyAddressBObjExt> handlePartyAddresses(TCRMPersonBObj existingPerson, Vector<XNWPartyAddressBObjExt> inputPartyAddresses, Vector<XNWPartyAddressBObjExt> existingPartyAddresses, DWLControl control) throws Exception {

		// apply surivorship rules on update, removing data that didn't survive when compared to existing data
		if(survivorshipRulesEnabledForUpdate)
			collapseWRules.mergePartyAddressBObj(true, inputPartyAddresses, existingPartyAddresses, new XNWPersonBObjExt());

		for (XNWPartyAddressBObjExt inputAddr : inputPartyAddresses) {
			boolean updated = false;
			for (XNWPartyAddressBObjExt existingAddr : existingPartyAddresses) {

				// Check to see if usage type already exists. If it does, this is an attribute update. 
				//	Otherwise it is an attribute add to the existing person record.
				// The exception is for multi-value party addresses. In this case, it is checked if the *usage type + value* already exists
				if(StringUtils.compareWithTrim(inputAddr.getAddressUsageValue(),existingAddr.getAddressUsageValue())
						&& (!multiValueAddresses.contains(inputAddr.getAddressUsageValue()) || 
								(multiValueAddresses.contains(inputAddr.getAddressUsageValue())
										&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getAddressLineOne(), existingAddr.getTCRMAddressBObj().getAddressLineOne())
										&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getAddressLineTwo(),existingAddr.getTCRMAddressBObj().getAddressLineTwo())
										&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getCity(),existingAddr.getTCRMAddressBObj().getCity())
										&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getProvinceStateValue(),existingAddr.getTCRMAddressBObj().getProvinceStateValue())
										&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getZipPostalCode(),existingAddr.getTCRMAddressBObj().getZipPostalCode())
										&&	
										((StringUtils.compareWithTrim(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXFacility_Code(), ((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXFacility_Code())
										&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXDepartment_Code(), ((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXDepartment_Code())
										&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXLocation_Code(), ((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXLocation_Code())
										&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXFacility_Name(), ((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXFacility_Name())
										&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXLocation_Name(), ((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXLocation_Name()))
										
										|| 
										
										(StringUtils.isBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXFacility_Code())
										&& StringUtils.isBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXFacility_Name())
										&& StringUtils.isBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXDepartment_Code())
										&& StringUtils.isBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXLocation_Code())
										&& StringUtils.isBlank(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXLocation_Name()))
										
										||
										
										(StringUtils.isBlank(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXFacility_Code())
										&& StringUtils.isBlank(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXFacility_Name())
										&& StringUtils.isBlank(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXDepartment_Code())
										&& StringUtils.isBlank(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXLocation_Code())
										&& StringUtils.isBlank(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXLocation_Name()))
												)
										)
								)
						){

					//Handle custom logic for party address association... 
					// 		keep existing record data if update is has primary billing or scheduling flag set, otherwise keep the input record data
					if((StringUtils.compareWithTrim((String)inputAddr.metaDataMap.get("XPrimary_Billing_Location_Flag"),"0")
							&& StringUtils.compareWithTrim((String)existingAddr.metaDataMap.get("XPrimary_Billing_Location_Flag"),"1"))
							||
							(StringUtils.compareWithTrim((String)inputAddr.metaDataMap.get("XScheduling_Primary_Flag"),"0")
									&& StringUtils.compareWithTrim((String)existingAddr.metaDataMap.get("XScheduling_Primary_Flag"),"1"))
							){
						((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXPhone(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXPhone());
						((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXPhone_Ext(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXPhone_Ext());
						((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXSecondary_Phone(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXSecondary_Phone());
						((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXSec_Phone_Ext(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXSec_Phone_Ext());
						((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXFax(((XNWAddressBObjExt)existingAddr.getTCRMAddressBObj()).getXFax());
					}

					// set required fields and commit attribute update
					String existingPartyAddressIdPk = existingAddr.getPartyAddressIdPK();
					inputAddr.setPartyAddressIdPK(existingPartyAddressIdPk);
					inputAddr.setPartyId(existingAddr.getPartyId());
					String existingAddressId = existingAddr.getAddressId();
					inputAddr.setAddressId(existingAddressId);
					inputAddr.setAddressGroupLastUpdateDate(existingAddr.getAddressGroupLastUpdateDate());
					inputAddr.setLocationGroupLastUpdateDate(existingAddr.getLocationGroupLastUpdateDate());
					inputAddr.getTCRMAddressBObj().setAddressLastUpdateDate(existingAddr.getTCRMAddressBObj().getAddressLastUpdateDate());

					// set the unique address line 3 string to null or else it will cause a duplicate address due to the stline 3 being different
					inputAddr.getTCRMAddressBObj().setAddressLineThree(null);

					XNWPartyAddressBObjExt respPA = (XNWPartyAddressBObjExt)handleTransaction(inputAddr, "updatePartyAddress", control, errHandler, "1007", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					// Handles SQL update of custom address fields (since out of box service cannot seem to this)
					CommonUtil.updateAddressPayloads(respPA.getAddressId(), 
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XCounty"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XNewport_Key"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XTax_ID_Number"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XFax"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XSec_Phone_Ext"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XSecondary_Phone"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XPhone_Ext"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XPhone"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XLocation_Name"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XLocation_Mnemonic"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XLocation_ID"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XLocation_Description"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XDepartment_Description"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XFacility_Name"),
							(String)inputAddr.getTCRMAddressBObj().metaDataMap.get("XHospital"));

					String responseAddressId = respPA.getAddressId();
					
					if(!respPA.getAddressId().equals(existingAddressId)){
						CommonUtil.deleteAddress(existingAddressId);
					}
					
					updated = true;
					break;
				}	
			}

			// if not an update, perform an add to add the attribute to the existing record
			if(updated == false){

				inputAddr.setPartyId(existingPerson.getPartyId());
				String inputAddrStr = inputAddr.toXML();
				XNWPartyAddressBObjExt respPA = (XNWPartyAddressBObjExt)handleTransaction(inputAddr, "addPartyAddress", control, errHandler, "1007", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

				// delete unique address string being stored in stline3 that was used to force insertion of record using additional facility, location, department keys
				deleteStline3(respPA.getTCRMAddressBObj().getAddressIdPK());
			}
		}

		return inputPartyAddresses;

	}

	private void handleAddressInactiveFields(XNWPartyAddressBObjExt inputAddr) throws Exception {

		// handle start/end dates and inactive flags
		// general logic is:
		// If inactive flag present, take that as preference and set end data to now or far in future depending on the flag
		// If end date blank, take the inactive flag and set the end date to current time if flag is inactive
		// If end date and inactive flag conflict, take the flag as the value that specifies whether record is active or inactive
		// For Party Address... if the Address is not active, inactive the associated PartyAddress Object
		Date inputPAEndDate = inputAddr.getEndDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)inputAddr.getEndDate());
		String paDeactFlg = ((XNWPartyAddressBObjExt)inputAddr).getXDeactivation_Flag();
		String addrDeactFlg = ((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXDeactivation_Flag();
		Date addrDeactDt = ((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXDeactivation_Date() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXDeactivation_Date());
		Date currentDate = new Date();

		// if input end date is not present and status flag is not present 
		//	or end date exists and if after current date, then set the status flag to Active
		//		if(addrDeactDt == null && StringUtils.isBlank(addrDeactFlg) || (StringUtils.isBlank(addrDeactFlg) && addrDeactDt != null && addrDeactDt.after(currentDate))){
		//			((XNWPartyAddressBObjExt)inputAddr).setXDeactivation_Flag("Active");
		//		} 

		// if party address is marked as inactive and its end date is null, then set the end date to current timestamp
		if(inputPAEndDate == null && StringUtils.isNonBlank(paDeactFlg)){
			if(paDeactFlg.equals("Inactive")){
				inputAddr.setEndDate(getCurrentTimestamp());
			}
		} 

		String farFutureTimestamp = getFarFutureTimestamp();
		// if party addrss flag is Active, set the end date far into the future
		if(StringUtils.isNonBlank(paDeactFlg)){
			if(paDeactFlg.equals("Active")){
				inputAddr.setEndDate(getFarFutureTimestamp());
			}
		} 

		// if address end date is not present but address status flag is inactive, set address end date to current date
		if(addrDeactDt == null && StringUtils.isNonBlank(addrDeactFlg)){
			if(addrDeactFlg.equals("Inactive")){
				((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXDeactivation_Date(getCurrentTimestamp());
			}
		} 

		// if end date has passed, but status flag is active, have end date set to far in the future 
		if(addrDeactDt != null && StringUtils.compareIgnoreCaseWithTrim(addrDeactFlg, "Active") && addrDeactDt.before(currentDate)){
			((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).setXDeactivation_Date(getFarFutureTimestamp());
		} 

		// If Address is inactive, deactivate the PartyAddress
		if(StringUtils.compareIgnoreCaseWithTrim(((XNWAddressBObjExt)inputAddr.getTCRMAddressBObj()).getXDeactivation_Flag(),"Inactive")){
			if(!StringUtils.compareIgnoreCaseWithTrim(paDeactFlg,"Inactive")){
				((XNWPartyAddressBObjExt)inputAddr).setXDeactivation_Flag("Inactive");
			}

			// If Address is inactive and end date is in the future, set the end date to current time
			if(inputPAEndDate == null || inputPAEndDate.after(currentDate)){
				inputAddr.setEndDate(getCurrentTimestamp());
			}
		}
	}

	private void handlePartyIdentificationInactiveFields(TCRMPartyIdentificationBObj input) throws Exception {

		// handle start/end dates and inactive flags
		// general logic is:
		// If inactive flag present, take that as preference and set end data to now or far in future depending on the flag
		// If end date blank, take the inactive flag and set the end date to current time if flag is inactive
		// If end date and inactive flag conflict, take the flag as the value that specifies whether record is active or inactive

		// Retrieve end date from input
		Date inputEndDate = input.getEndDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)input.getEndDate());

		// Get status value from input
		String inputStatusFlg = input.getIdentificationStatusValue();

		Date currentDate = new Date();

		// if input end date is not present and status flag is not present 
		//	or end date exists and if after current date, then set the status flag to Active
		if(inputEndDate == null && StringUtils.isBlank(inputStatusFlg) || (StringUtils.isBlank(inputStatusFlg) && inputEndDate != null && inputEndDate.after(currentDate))){
			input.setIdentificationStatusValue("Active");
		} 
		// if end date is not present but status flag is inactive, set end date to current date
		else if(inputEndDate == null && StringUtils.isNonBlank(inputStatusFlg)){
			if(inputStatusFlg.equals("Inactive")){
				input.setEndDate(getCurrentTimestamp());
			}
		} 
		// if end date has passed, but status flag is active, have end date set to far in the future 
		else if(inputEndDate != null && StringUtils.compareIgnoreCaseWithTrim(inputStatusFlg, "Active") && inputEndDate.before(currentDate)){
			input.setEndDate(getFarFutureTimestamp());
		} 
	}

	private void handlePartyValueInactiveFields(TCRMPartyValueBObj input) throws Exception {

		// handle start/end dates and inactive flags
		// general logic is:
		// If inactive flag present, take that as preference and set end data to now or far in future depending on the flag
		// If end date blank, take the inactive flag and set the end date to current time if flag is inactive
		// If end date and inactive flag conflict, take the flag as the value that specifies whether record is active or inactive
		// NOTE: Since PartyValue is a general object, the Inactive flag may be present in different fields.
		// 	The logic for what field to look for depending on what Usage Type is implemented below

		// Retrieve end date from input
		Date inputEndDate = input.getEndDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)input.getEndDate());

		// Get status value from input
		String inputStatusFlg = "";
		String newStatusFlg = "";

		// get billing area number inactivation flag
		if(input.getPartyValueValue().equals("Billing Area Number")){
			inputStatusFlg = input.getAttribute3String();
		}

		// get specialty inactivation flag
		if(input.getPartyValueValue().equals("Specialty")){
			inputStatusFlg = input.getAttribute6String();
		}

		Date currentDate = new Date();

		// if input end date is not present and status flag is not present 
		//	or end date exists and if after current date, then set the status flag to Active
		if(inputEndDate == null && StringUtils.isBlank(inputStatusFlg) || (StringUtils.isBlank(inputStatusFlg) && inputEndDate != null && inputEndDate.after(currentDate))){
			newStatusFlg = "Active";
		} 
		// if end date is not present but status flag is inactive, set end date to current date
		else if(inputEndDate == null && StringUtils.isNonBlank(inputStatusFlg)){
			if(inputStatusFlg.equals("Inactive")){
				input.setEndDate(getCurrentTimestamp());
			}
		} 
		// if end date has passed, but status flag is active, have end date set to far in the future 
		else if(inputEndDate != null && StringUtils.compareIgnoreCaseWithTrim(inputStatusFlg, "Active") && inputEndDate.before(currentDate)){
			input.setEndDate(getFarFutureTimestamp());
		} 

		// set the final status flag on the records
		if(input.getPartyValueValue().equals("Billing Area Number")){
			input.setAttribute3Value("Billing Area Deactivation Flag");
			input.setAttribute3String(newStatusFlg);
		}

		// set the final status flag on the records
		if(input.getPartyValueValue().equals("Specialty")){
			input.setAttribute6Value("Specialty Active Status");
			input.setAttribute6String(newStatusFlg);
		}

	}
}
