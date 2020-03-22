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
import java.util.UUID;
import java.util.Vector;

import mdmnw.component.CompositeNWPersonBObj;
import mdmnw.component.XNWAddressBObjExt;
import mdmnw.component.XNWPartyAddressBObjExt;
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
import com.dwl.base.requestHandler.DWLTransactionPersistent;
import com.dwl.base.util.StringUtils;
import com.dwl.tcrm.common.TCRMResponse;
import com.dwl.tcrm.coreParty.component.TCRMAdminContEquivBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyIdentificationBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyValueBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;
import com.dwl.tcrm.utilities.TCRMClassFactory;
import com.dwl.unifi.tx.exception.BusinessProxyException;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * 
 * @generated NOT
 */
public class MaintainNWPersonCompositeTxnBP extends CommonUtil  {

	/**
	 * @generated
	 **/
	private IDWLErrorMessage errHandler;
	private CollapsePartiesWithRules collapseWRules;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated 
	 */
	private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(MaintainNWPersonCompositeTxnBP.class);
	/**
	 * @generated
	 **/
	public MaintainNWPersonCompositeTxnBP() {
		super();
		errHandler = TCRMClassFactory.getErrorHandler();
		collapseWRules = new CollapsePartiesWithRules();
	}
	/**
	 * @generated NOT
	 **/
	public Object execute(Object inputObj) throws BusinessProxyException {
		logger.finest("ENTER Object execute(Object inputObj)");

		TCRMResponse outputTxnObj = null;
		DWLTransactionPersistent inputTxnObj = (DWLTransactionPersistent) inputObj;
		DWLControl control = inputTxnObj.getTxnControl();
		DWLCommon topLevelObject = (DWLCommon) inputTxnObj.getTxnTopLevelObject();
		if (!(topLevelObject instanceof CompositeNWPersonBObj)) {
			// MDM_TODO0: CDKWB0014I optionally use a more appropriate error code than
			// "MAINTAINNWPERSON_FAILED".
			DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
					"INSERR",
					MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
					control, new String[0]);
			throw new BusinessProxyException(error.getErrorMessage());
		}

		CompositeNWPersonBObj mainInput = (CompositeNWPersonBObj) topLevelObject;

		// MDM_TODO: CDKWB0016I Populate the mandatory fields of "addPersonInput".
		TCRMPersonBObj personInput = mainInput.getTCRMPersonBObj();

		TCRMAdminContEquivBObj sourceId = (TCRMAdminContEquivBObj) personInput.getItemsTCRMAdminContEquivBObj().get(0);

		String partyId = null;
		String txnType = "addPerson";

		removeEmptyTCRMObjects(personInput);

		partyId = CommonUtil.getPartyIdPkFromSourceId(sourceId.getAdminSystemValue(), sourceId.getAdminPartyId());

		if(partyId != null){
			try {
				txnType = "updatePerson";
				personInput.setPartyId(partyId);

				Vector<String> params = new Vector<String>();
				params.add(partyId);
				params.add(this.INQRY_LVL_4);

				DWLResponse response = invokeBaseInquiryTxn(this.TXN_GETPERSON, params, control);

				TCRMPersonBObj existingPerson = (TCRMPersonBObj)response.getData();
				personInput.setPersonLastUpdateDate(existingPerson.getPersonLastUpdateDate());
				personInput.setPartyLastUpdateDate(existingPerson.getPartyLastUpdateDate());
				personInput.setPersonLastUpdateUser("MaintainNWPersonCompositeTxnBP");

				handleChildAttributes(personInput, existingPerson, control);

				personInput.getItemsTCRMPartyAddressBObj().clear();
				personInput.getItemsTCRMPartyContactMethodBObj().clear();
				personInput.getItemsTCRMPartyIdentificationBObj().clear();
				personInput.getItemsTCRMPartyValueBObj().clear();
				personInput.getItemsTCRMAdminContEquivBObj().clear();

			} catch (BusinessProxyException e) {
				DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
						"INSERR",
						MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
						control, new String[0]);
				throw new BusinessProxyException("Person ID Affected: " + sourceId.getAdminSystemValue() + ":" +  sourceId.getAdminPartyId() + " -- " + e.getMessage());
			} catch (Exception e) {
				throw new BusinessProxyException("Person ID Affected: " + sourceId.getAdminSystemValue() + ":" +  sourceId.getAdminPartyId() + " -- " + e.getMessage());
			}

		} else{

			Vector<XNWPartyAddressBObjExt> inputPartyAddresses = personInput.getItemsTCRMPartyAddressBObj();

			for (XNWPartyAddressBObjExt inputAddr : inputPartyAddresses) {
				inputAddr.getTCRMAddressBObj().setAddressLineThree(getUniqueAddrString(UUID.randomUUID().toString(), inputAddr));
			}		
		}

		personInput.setControl(control);

		// Prepare a new DWLTransactionPersistent instance.
		DWLTransactionPersistent personRequest = new DWLTransactionPersistent();
		personRequest.setTxnControl(control);
		personRequest.setTxnType(txnType);
		personRequest.setTxnTopLevelObject(personInput);

		// Prepare a reference to hold the response for this transaction.
		DWLResponse personResponse = null;

		// Invoke the transaction.
		try {
			personResponse = (DWLResponse) super.execute(personRequest);
		}
		catch (BusinessProxyException e) {
			DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
					"INSERR",
					MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
					control, new String[0]);
			throw new BusinessProxyException("Person ID Affected: " + sourceId.getAdminSystemValue() + ":" +  sourceId.getAdminPartyId() + " -- " + error.getErrorMessage(), e);
		}

		if (personResponse == null)  {
			DWLError error = errHandler.getErrorMessage(MDMNWComponentID.MAINTAIN_NWPERSON_BUSINESS_PROXY,
					"INSERR",
					MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED,
					control, new String[0]);
			throw new BusinessProxyException("Person ID Affected: " + sourceId.getAdminSystemValue() + ":" +  sourceId.getAdminPartyId() + " -- " + error.getErrorMessage());
		}
		else if (personResponse.getStatus().getStatus() == DWLStatus.FATAL) {
			DWLStatus status = personResponse.getStatus();
			TCRMResponse errResponse = new TCRMResponse();
			errResponse.setStatus(status);
			throw new BusinessProxyException("Person ID Affected: " + sourceId.getAdminSystemValue() + ":" +  sourceId.getAdminPartyId() + " -- " + ((DWLError) errResponse.getStatus().getDwlErrorGroup().get(0)).getErrorMessage());
		}

		// Extract the returned business object from the response.
		TCRMPersonBObj personOutput = (TCRMPersonBObj) personResponse.getData();

		Vector<XNWPartyAddressBObjExt> responsePartyAddresses = personOutput.getItemsTCRMPartyAddressBObj();

		for (XNWPartyAddressBObjExt responsePartyAddress : responsePartyAddresses) {
			CommonUtil.cleanAddress(responsePartyAddress.getAddressId());
		}

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
		return outputTxnObj;
	}

	public TCRMPersonBObj handleChildAttributes(TCRMPersonBObj personInput,
			TCRMPersonBObj existingPerson, DWLControl control) throws Exception {

		String existingPartyId = existingPerson.getPartyId();
		Vector<XNWPartyAddressBObjExt> inputPartyAddresses = personInput.getItemsTCRMPartyAddressBObj();
		Vector<TCRMPartyContactMethodBObj> inputPartyContactMethods = personInput.getItemsTCRMPartyContactMethodBObj();
		Vector<TCRMPartyIdentificationBObj> inputPartyIdentifications = personInput.getItemsTCRMPartyIdentificationBObj();
		Vector<XNWPersonNameBObjExt> inputPersonNames = personInput.getItemsTCRMPersonNameBObj();
		Vector<TCRMPartyValueBObj> inputPartyValues = personInput.getItemsTCRMPartyValueBObj();

		Vector<XNWPartyAddressBObjExt> existingPartyAddresses = existingPerson.getItemsTCRMPartyAddressBObj();
		Vector<TCRMPartyContactMethodBObj> existingPartyContactMethods = existingPerson.getItemsTCRMPartyContactMethodBObj();
		Vector<TCRMPartyIdentificationBObj> existingPartyIdentifications = existingPerson.getItemsTCRMPartyIdentificationBObj();
		Vector<XNWPersonNameBObjExt> existingPersonNames = existingPerson.getItemsTCRMPersonNameBObj();
		Vector<TCRMPartyValueBObj> existingPartyValues = existingPerson.getItemsTCRMPartyValueBObj();

		handlePartyAddresses(existingPerson, inputPartyAddresses, existingPartyAddresses, control);
		handlePartyContactMethods(existingPerson, inputPartyContactMethods, existingPartyContactMethods, control);
		handlePartyIdentifications(existingPerson, inputPartyIdentifications, existingPartyIdentifications, control);
		handlePersonNames(existingPerson, inputPersonNames, existingPersonNames, control);
		handlePartyValues(existingPerson, inputPartyValues, existingPartyValues, control);

		return personInput;

	}


	private Vector<TCRMPartyValueBObj> handlePartyValues(TCRMPersonBObj existingPerson, Vector<TCRMPartyValueBObj> inputPartyValues, Vector<TCRMPartyValueBObj> existingPartyValues, DWLControl control) throws Exception {

		collapseWRules.mergePartyValueBObj(inputPartyValues, existingPartyValues, existingPerson, (ArrayList<String>)control.get("Survivorship/TCRMPartyValueBObj/"));
		
		for (TCRMPartyValueBObj inputPartyValue : inputPartyValues) {
			boolean updated = false;
			for (TCRMPartyValueBObj existingPartyValue : existingPartyValues) {

				if(StringUtils.compareWithTrim(inputPartyValue.getPartyValueValue(), existingPartyValue.getPartyValueValue()) 
						&& StringUtils.compareWithTrim(inputPartyValue.getValueString(), existingPartyValue.getValueString())
						){
					inputPartyValue.setPartyValueId(existingPartyValue.getPartyValueId());
					inputPartyValue.setPartyValueLastUpdateDate(existingPartyValue.getPartyValueLastUpdateDate());
					handleTransaction(inputPartyValue, "updatePartyValue", control, errHandler, "1036", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
				}
			}

			if(updated == false){
				inputPartyValue.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyValue, "addPartyValue", control, errHandler, "1036", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyValues;

	}


	private Vector<XNWPersonNameBObjExt> handlePersonNames(TCRMPersonBObj existingPerson, Vector<XNWPersonNameBObjExt> inputPersonNames, Vector<XNWPersonNameBObjExt> existingPersonNames, DWLControl control) throws Exception {

		for (XNWPersonNameBObjExt inputName : inputPersonNames) {
			boolean updated = false;
			for (XNWPersonNameBObjExt existingName : existingPersonNames) {

				if(StringUtils.compareWithTrim(inputName.getNameUsageValue(), existingName.getNameUsageValue()) 
						&& (!StringUtils.compareWithTrim(inputName.getNameUsageValue(), "Also Known As") || 
								(StringUtils.compareWithTrim(inputName.getNameUsageValue(), "Also Known As") 
										&& StringUtils.compareWithTrim(inputName.getGivenNameOne(), existingName.getGivenNameOne()) 
										&& StringUtils.compareWithTrim(inputName.getLastName(), existingName.getLastName()) 
										&& (StringUtils.compareWithTrim(inputName.getGivenNameTwo(), existingName.getGivenNameTwo()) || 
												(inputName.getGivenNameTwo() == null && existingName.getGivenNameTwo() != null) || 
												(inputName.getGivenNameTwo() != null && existingName.getGivenNameTwo() == null)
												)
										)
								)
						){
					
					if(StringUtils.compareWithTrim(inputName.getNameUsageValue(), "Also Known As")
							&& inputName.getGivenNameTwo() == null && existingName.getGivenNameTwo() != null){
						inputName.setGivenNameTwo(existingName.getGivenNameTwo());
					}
					
					inputName.setPersonNameIdPK(existingName.getPersonNameIdPK());
					inputName.setLastUpdatedDate(existingName.getLastUpdatedDate());
					handleTransaction(inputName, "updatePersonName", control, errHandler, "2000242", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
				}
			}

			if(updated == false){
				inputName.setPersonPartyId(existingPerson.getPartyId());
				handleTransaction(inputName, "addPersonName", control, errHandler, "2000242", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPersonNames;

	}


	private Vector<TCRMPartyIdentificationBObj> handlePartyIdentifications(TCRMPersonBObj existingPerson, Vector<TCRMPartyIdentificationBObj> inputPartyIdentifications, Vector<TCRMPartyIdentificationBObj> existingPartyIdentifications, DWLControl control) throws Exception {

		for (TCRMPartyIdentificationBObj inputPartyIdentification : inputPartyIdentifications) {
			boolean updated = false;
			for (TCRMPartyIdentificationBObj existingPartyIdentification : existingPartyIdentifications) {

				if(StringUtils.compareWithTrim(inputPartyIdentification.getIdentificationValue(), existingPartyIdentification.getIdentificationValue()) 
						//						&& ((inputPartyIdentification.getIdentificationNumber() == null && existingPartyIdentification.getIdentificationNumber() == null) ||
						//								(inputPartyIdentification.getIdentificationNumber().equalsIgnoreCase(existingPartyIdentification.getIdentificationNumber())))
						){
					inputPartyIdentification.setIdentificationIdPK(existingPartyIdentification.getIdentificationIdPK());
					inputPartyIdentification.setPartyIdentificationLastUpdateDate(existingPartyIdentification.getPartyIdentificationLastUpdateDate());
					handleTransaction(inputPartyIdentification, "updatePartyIdentification", control, errHandler, "1010", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
				}
			}

			if(updated == false){
				inputPartyIdentification.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyIdentification, "addPartyIdentification", control, errHandler, "1010", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyIdentifications;

	}


	private Vector<TCRMPartyContactMethodBObj> handlePartyContactMethods(TCRMPersonBObj existingPerson, Vector<TCRMPartyContactMethodBObj> inputPartyContactMethods, Vector<TCRMPartyContactMethodBObj> existingPartyContactMethods, DWLControl control) throws Exception {

		for (TCRMPartyContactMethodBObj inputPartyContactMethod : inputPartyContactMethods) {
			boolean updated = false;
			for (TCRMPartyContactMethodBObj existingPartyContactMethod : existingPartyContactMethods) {

				String inputUsage = inputPartyContactMethod.getContactMethodUsageValue();
				String existingUsage = existingPartyContactMethod.getContactMethodUsageValue();

				if(StringUtils.compareWithTrim(inputPartyContactMethod.getContactMethodUsageValue(), existingPartyContactMethod.getContactMethodUsageValue()) 
						//						&& ((inputPartyContactMethod.getTCRMContactMethodBObj().getReferenceNumber() == null && existingPartyContactMethod.getTCRMContactMethodBObj().getReferenceNumber() == null) ||
						//								(inputPartyContactMethod.getTCRMContactMethodBObj().getReferenceNumber().equalsIgnoreCase(existingPartyContactMethod.getTCRMContactMethodBObj().getReferenceNumber())))
						){

					inputPartyContactMethod.setPartyId(existingPartyContactMethod.getPartyId());
					inputPartyContactMethod.setPartyContactMethodIdPK(existingPartyContactMethod.getPartyContactMethodIdPK());
					inputPartyContactMethod.getTCRMContactMethodBObj().setContactMethodIdPK(existingPartyContactMethod.getTCRMContactMethodBObj().getContactMethodIdPK());

					inputPartyContactMethod.setLocationGroupLastUpdateDate(existingPartyContactMethod.getLocationGroupLastUpdateDate());
					inputPartyContactMethod.setContactMethodGroupLastUpdateDate(existingPartyContactMethod.getContactMethodGroupLastUpdateDate());
					inputPartyContactMethod.getTCRMContactMethodBObj().setContactMethodLastUpdateDate(existingPartyContactMethod.getTCRMContactMethodBObj().getContactMethodLastUpdateDate());
					inputPartyContactMethod.setContactMethodId(existingPartyContactMethod.getContactMethodId());

					handleTransaction(inputPartyContactMethod, "updatePartyContactMethod", control, errHandler, "1009", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

					updated = true;
				}
			}

			if(updated == false){
				inputPartyContactMethod.setPartyId(existingPerson.getPartyId());
				handleTransaction(inputPartyContactMethod, "addPartyContactMethod", control, errHandler, "1009", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
			}
		}

		return inputPartyContactMethods;

	}

	private Vector<XNWPartyAddressBObjExt> handlePartyAddresses(TCRMPersonBObj existingPerson, Vector<XNWPartyAddressBObjExt> inputPartyAddresses, Vector<XNWPartyAddressBObjExt> existingPartyAddresses, DWLControl control) throws Exception {

		for (XNWPartyAddressBObjExt inputAddr : inputPartyAddresses) {
			boolean updated = false;
			for (XNWPartyAddressBObjExt existingAddr : existingPartyAddresses) {

				String inputFacCode = (String) inputAddr.getTCRMAddressBObj().metaDataMap.get("XFacility_Code");
				String existingFacCode = (String) existingAddr.getTCRMAddressBObj().metaDataMap.get("XFacility_Code");
				String inputDeptCode = (String) inputAddr.getTCRMAddressBObj().metaDataMap.get("XDepartment_Code");
				String existingDeptCode = (String) existingAddr.getTCRMAddressBObj().metaDataMap.get("XDepartment_Code");
				String inputLocCode = (String) inputAddr.getTCRMAddressBObj().metaDataMap.get("XLocation_Code");
				String existingLocCode = (String) existingAddr.getTCRMAddressBObj().metaDataMap.get("XLocation_Code");


				if(StringUtils.compareWithTrim(inputAddr.getAddressUsageValue(),existingAddr.getAddressUsageValue())
						&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getAddressLineOne(), existingAddr.getTCRMAddressBObj().getAddressLineOne())
						&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getAddressLineTwo(),existingAddr.getTCRMAddressBObj().getAddressLineTwo())
						&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getCity(),existingAddr.getTCRMAddressBObj().getCity())
						&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getProvinceStateValue(),existingAddr.getTCRMAddressBObj().getProvinceStateValue())
						&&	StringUtils.compareWithTrim(inputAddr.getTCRMAddressBObj().getZipPostalCode(),existingAddr.getTCRMAddressBObj().getZipPostalCode())
						&&	StringUtils.compareWithTrim(inputFacCode, existingFacCode)
						&&	StringUtils.compareWithTrim(inputDeptCode, existingDeptCode)
						&&	StringUtils.compareWithTrim(inputLocCode, existingLocCode)
						){
					
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

					Date inputStartDate = inputAddr.getStartDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)inputAddr.getStartDate());
					Date existingStartDate = existingAddr.getStartDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)existingAddr.getStartDate());
					Date inputEndDate = inputAddr.getEndDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)inputAddr.getEndDate());
					Date existingEndDate = existingAddr.getEndDate() == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)existingAddr.getEndDate());
					Date currentDate = new Date();
					
					boolean inputIsActive = inputStartDate != null && inputStartDate.before(currentDate) && (inputEndDate == null || inputEndDate.after(currentDate)) ? true : false; 
					boolean existingIsActive = existingStartDate != null && existingStartDate.before(currentDate) && (existingEndDate == null || existingEndDate.after(currentDate)) ? true : false; 
					
					if(!inputIsActive && existingIsActive){
						inputAddr.setStartDate(existingAddr.getStartDate());
						inputAddr.setEndDate(existingAddr.getEndDate());
					}

					inputAddr.setPartyAddressIdPK(existingAddr.getPartyAddressIdPK());
					inputAddr.setPartyId(existingPerson.getPartyId());
					inputAddr.setAddressId(existingAddr.getAddressId());
					inputAddr.setAddressGroupLastUpdateDate(existingAddr.getAddressGroupLastUpdateDate());
					inputAddr.setLocationGroupLastUpdateDate(existingAddr.getLocationGroupLastUpdateDate());
					inputAddr.getTCRMAddressBObj().setAddressLastUpdateDate(existingAddr.getTCRMAddressBObj().getAddressLastUpdateDate());

					XNWPartyAddressBObjExt response = (XNWPartyAddressBObjExt)handleTransaction(inputAddr, "updatePartyAddress", control, errHandler, "1007", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);
					CommonUtil.updateAddressPayloads(response.getAddressId(), 
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

					updated = true;
				}	
			}

			if(updated == false){
				inputAddr.setPartyId(existingPerson.getPartyId());

				inputAddr.getTCRMAddressBObj().setAddressLineThree(getUniqueAddrString(existingPartyId, inputAddr));

				XNWPartyAddressBObjExt response = (XNWPartyAddressBObjExt)handleTransaction(inputAddr, "addPartyAddress", control, errHandler, "1007", MDMNWErrorReasonCode.MAINTAINNWPERSON_FAILED);

				String addressId = response.getAddressId();
				CommonUtil.cleanAddress(addressId);
			}
		}

		return inputPartyAddresses;

	}

}


