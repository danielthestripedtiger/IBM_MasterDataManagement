package mdmnw.externalrule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import mdmnw.component.XNWAddressBObjExt;
import mdmnw.component.XNWContactMethodBObjExt;
import mdmnw.component.XNWPartyAddressBObjExt;
import mdmnw.component.XNWPersonBObjExt;
import mdmnw.component.XNWPersonNameBObjExt;
import mdmnw.constant.MdmConstants;
import mdmnw.utils.CommonUtil;
import mdmnw.utils.SurvivorshipConfigObj;

import com.dwl.base.DWLControl;
import com.dwl.base.DWLResponse;
import com.dwl.base.IDWLErrorMessage;
import com.dwl.base.error.DWLError;
import com.dwl.base.error.DWLStatus;
import com.dwl.base.exception.DWLBaseException;
import com.dwl.base.exception.DWLPropertyNotFoundException;
import com.dwl.base.externalrule.Rule;
import com.dwl.base.logging.DWLLoggerManager;
import com.dwl.base.logging.IDWLLogger;
import com.dwl.base.util.StringUtils;
import com.dwl.management.ManagementException;
import com.dwl.management.config.client.Configuration;
import com.dwl.management.config.repository.ConfigurationRepositoryException;
import com.dwl.tcrm.common.TCRMCommon;
import com.dwl.tcrm.common.TCRMErrorCode;
import com.dwl.tcrm.coreParty.component.TCRMAdminContEquivBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyIdentificationBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyValueBObj;
import com.dwl.tcrm.coreParty.component.TCRMSuspectPersonBObj;
import com.dwl.tcrm.coreParty.constant.TCRMCoreComponentID;
import com.dwl.tcrm.coreParty.constant.TCRMCoreErrorReasonCode;
import com.dwl.tcrm.coreParty.constant.TCRMCorePropertyKeys;
import com.dwl.tcrm.coreParty.interfaces.IParty;
import com.dwl.tcrm.utilities.TCRMClassFactory;
import com.dwl.unifi.tx.exception.BusinessProxyException;

/**
 * CollapsePartiesWithRules collapses party1 and party2 parties to create new party.
 * Unique data in party1 and party2 are survived in new party.
 * In case of duplicate data the one with the preferred source will survive.
 * If they are from the same source, the one with the most recent last update date will survive.
 * Usage Type or Usage Type+Value are used to identify duplicates
 *
 * 
 */
public class CollapsePartiesWithRules extends Rule {

	protected final static IDWLLogger logger = DWLLoggerManager.getLogger(CollapsePartiesWithRules.class);

	protected String ruleName = "CollapsePartiesWithRules";
	protected String debugStr = "External Java Rule 38 " + ruleName + ": ";
	private ArrayList<String> multiValueNames;
	private ArrayList<String> multiValueIds;
	private ArrayList<String> multiValueAddresses;
	private ArrayList<String> singleValuePartyVals;
	//	private String updateFlag = "";
	private TCRMPartyBObj objParty1BObj = null;
	private TCRMPartyBObj objParty2BObj = null;

	private HashMap<String, ArrayList<SurvivorshipConfigObj>> survivorshipConfigs;
	private boolean survivorshipConfigsSet;

	public CollapsePartiesWithRules(){

		survivorshipConfigs = new HashMap<String, ArrayList<SurvivorshipConfigObj>>();;

		// specify which name usage types are muilti-valued
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
	}

	/**
	 * This is the main method in CollapsePartiesWithRules. It retrieves Party 1 and 
	 * party 2 from input and keeps surviving data on party 1 based on survivorship rules
	 * when the collapse is complete, the data on party 1 becomes a new party and the original
	 * party 1 and party 2 are deactivated
	 * 
	 * @param input
	 * @param componentObject
	 * @return vector newPartyBobj 
	 * @throws Exception	 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object execute(Object input, Object componentObject)
			throws Exception {			
		IParty partyComp = (IParty) TCRMClassFactory
				.getTCRMComponent(TCRMCorePropertyKeys.PARTY_COMPONENT);
		// Get the involved parties as a vector of objects
		Vector vecParties = (Vector) input;

		// Set up variables that will be needed later
		DWLStatus status = new DWLStatus();
		status.setStatus(DWLStatus.SUCCESS);
		Vector vecRet = new Vector();
		//		TCRMPartyBObj newPartyBobj = null;
		DWLControl objDWLControl = null;

		try {
			logger.info("Inside NW CollapsePartiesWithRules");	           

			// get the party objects from the vector
			objParty1BObj = (TCRMPartyBObj) vecParties.elementAt(0);
			objParty2BObj = (TCRMPartyBObj) vecParties.elementAt(1);
			// if the second object is a TCRMSuspectPersonBObj object, get the XNWPersonBObjExt version of the object by calling out to MDM
			//			if(objParty2BObj instanceof TCRMSuspectPersonBObj){
			// set get person params to get existing person object
			CommonUtil util = new CommonUtil();

			if(vecParties.size() < 3){
				//				updateFlag = (String) vecParties.elementAt(2);

				Vector<String> params1 = new Vector<String>();
				params1.add(objParty1BObj.getPartyId());
				params1.add(MdmConstants.INQRY_LVL_5);

				// execute get person transaction
				DWLResponse response1 = util.invokeBaseInquiryTxn(MdmConstants.TXN_GETPERSON, params1, objParty2BObj.getControl());

				// get person as XNWPersonBObjExt object and set last update dates in order to be able to update the object
				objParty1BObj = (XNWPersonBObjExt)response1.getData();
			}

			Vector<String> params2 = new Vector<String>();
			params2.add(objParty2BObj.getPartyId());
			params2.add(MdmConstants.INQRY_LVL_5);

			// execute get person transaction
			DWLResponse response2 = util.invokeBaseInquiryTxn(MdmConstants.TXN_GETPERSON, params2, objParty2BObj.getControl());

			// get person as XNWPersonBObjExt object and set last update dates in order to be able to update the object
			objParty2BObj = (XNWPersonBObjExt)response2.getData();
			//			}

			objDWLControl = objParty1BObj.getControl();

			// set the survivorship configs if they haven't been already
			if(survivorshipConfigsSet == false){
				setSurvivorshipConfigs(objDWLControl);
				logger.info("Survivorship rules for collapse have been set.");
			}

			// get the party identification objects from the parties and collapse them into party 1 based on survivorship rules
			Vector <TCRMPartyIdentificationBObj> vecParty1Identification =  objParty1BObj.getItemsTCRMPartyIdentificationBObj();
			Vector <TCRMPartyIdentificationBObj> vecParty2Identification =  objParty2BObj.getItemsTCRMPartyIdentificationBObj();			  
			mergePartyIdentificationBObj(false, vecParty1Identification, vecParty2Identification, objParty1BObj);

			// get the party value objects from the parties and collapse them into party 1 based on survivorship rules
			Vector <TCRMPartyValueBObj> vecParty1Value =  objParty1BObj.getItemsTCRMPartyValueBObj();
			Vector <TCRMPartyValueBObj> vecParty2Value =  objParty2BObj.getItemsTCRMPartyValueBObj();			  
			mergePartyValueBObj(false, vecParty1Value, vecParty2Value, objParty1BObj);

			// get the party address objects from the parties and collapse them into party 1 based on survivorship rules
			Vector <XNWPartyAddressBObjExt> vecParty1Addr = objParty1BObj.getItemsTCRMPartyAddressBObj();
			Vector <XNWPartyAddressBObjExt> vecParty2Addr = objParty2BObj.getItemsTCRMPartyAddressBObj();			  
			mergePartyAddressBObj(false, vecParty1Addr, vecParty2Addr, objParty1BObj);

			// get the party contact method objects from the parties and collapse them into party 1 based on survivorship rules
			Vector <TCRMPartyContactMethodBObj> vecParty1ContMeth = objParty1BObj.getItemsTCRMPartyContactMethodBObj();
			Vector <TCRMPartyContactMethodBObj> vecParty2ContMeth = objParty2BObj.getItemsTCRMPartyContactMethodBObj();			  
			mergePartyContactMethodBObj(false, vecParty1ContMeth, vecParty2ContMeth, objParty1BObj);

			// get the party admin key objects from the parties and collapse them into party 1
			Vector <TCRMAdminContEquivBObj> vecParty1AdminContEquiv = new Vector <TCRMAdminContEquivBObj>();
			if(objParty1BObj.getPartyId() != null){
				vecParty1AdminContEquiv = ((IParty) partyComp).getAllPartyAdminSysKeys(objParty1BObj.getPartyId(), objDWLControl);																							    			  
			}
			else{
				vecParty1AdminContEquiv = objParty1BObj.getItemsTCRMAdminContEquivBObj();
			}

			Vector <TCRMAdminContEquivBObj> vecParty2AdminContEquiv = new Vector <TCRMAdminContEquivBObj>();
			if(objParty2BObj.getPartyId() != null){
				vecParty2AdminContEquiv = ((IParty) partyComp).getAllPartyAdminSysKeys(objParty2BObj.getPartyId(), objDWLControl);																								    			  
			}
			else{
				vecParty2AdminContEquiv = objParty2BObj.getItemsTCRMAdminContEquivBObj();		
			}
			mergeAdminContEquivBObj(vecParty1AdminContEquiv, vecParty2AdminContEquiv, objParty1BObj);				

			if(objParty1BObj instanceof XNWPersonBObjExt)
			{
				// get the person objects from the parties and collapse them into party 1 based on survivorship rules
				XNWPersonBObjExt objPerson1BObj = (XNWPersonBObjExt)objParty1BObj;
				XNWPersonBObjExt objPerson2BObj = (XNWPersonBObjExt)objParty2BObj;
				mergePersonBObj((XNWPersonBObjExt)objParty1BObj, (XNWPersonBObjExt)objParty2BObj, (XNWPersonBObjExt)objParty1BObj);

				// get the person name objects from the parties and collapse them into party 1 based on survivorship rules
				Vector <XNWPersonNameBObjExt> vecPerson1Name = objPerson1BObj.getItemsTCRMPersonNameBObj();			  
				Vector <XNWPersonNameBObjExt> vecPerson2Name = objPerson2BObj.getItemsTCRMPersonNameBObj();
				mergePersonNameBObj(false, vecPerson1Name,vecPerson2Name, (XNWPersonBObjExt)objParty1BObj);
			}

		} catch (DWLBaseException ex) {	            
			logger.error("DWLBaseException in execute method of CollapsePartiesWithRules == "+ex.toString());
			com.dwl.base.util.DWLExceptionUtils.log(ex);
			status = ex.getStatus();
		} catch (Exception ex) {
			logger.error("Exception in execute method of CollapsePartiesWithRules == "+ex.toString());	            
			com.dwl.base.util.DWLExceptionUtils.log(ex);
			status = addError(
					objDWLControl,
					TCRMErrorCode.READ_RECORD_ERROR,
					TCRMCoreErrorReasonCode.COLLAPSE_PARTIES_SURVIVING_RULES_FAILED,
					ex.getMessage());
		}

		objParty1BObj.setPartyId(null);


		vecRet.addElement(status);
		vecRet.addElement(objParty1BObj);

		// return final party 1 with collapsed data which will end up becoming a new party
		return vecRet;
	}

	/**
	 * This method collapses Party 1 and Party 2 PartyIdentification business objects.
	 * Survive all Identification Object
	 * @param rules 
	 * 
	 * @param vector sourcePartyIdentificationBObj
	 * @param vector targetPartyIdentificationBObj
	 * @param newOrgBobj
	 * @return  
	 * @throws Exception	 
	 *  
	 */			  
	public void mergePartyIdentificationBObj(boolean externallyCalled, Vector <TCRMPartyIdentificationBObj> vecParty1Vals, Vector <TCRMPartyIdentificationBObj> vecParty2Vals, TCRMPartyBObj newPartyBobj) throws Exception
	{			 
		Vector<TCRMCommon> loserPartyVals = new Vector<TCRMCommon>();
		Vector<TCRMPartyIdentificationBObj> losersCasted = new Vector<TCRMPartyIdentificationBObj>();

		// compare rows from each party to each other using the survivorship rules
		for (TCRMPartyIdentificationBObj party1Value : vecParty1Vals) {
			for (TCRMPartyIdentificationBObj party2Value : vecParty2Vals) {

				// uniqueness is based on usage type only
				if(party1Value.getIdentificationValue().equals(party2Value.getIdentificationValue())
						&& survivorshipConfigs.containsKey("TCRMPartyIdentificationBObj|"+party1Value.getIdentificationValue()) && (!multiValueIds.contains(party1Value.getIdentificationValue()) || 
								(multiValueIds.contains(party1Value.getIdentificationValue())
										&& StringUtils.compareWithTrim(party1Value.getIdentificationNumber(), party2Value.getIdentificationNumber()))
								)){

					// the call below puts the surviving attributes into party 1 and puts party 2 values into an array of loser values
					applySurvivorship("TCRMPartyIdentificationBObj", party1Value.getIdentificationValue(), party1Value, party2Value, newPartyBobj);
					loserPartyVals.add(party2Value);
				}
			}
		}

		// if called from within this class (execute method) combine all the attributes into the primary vector
		if(!externallyCalled)
			vecParty1Vals.addAll(vecParty2Vals);

		// cast the loser objects to as TCRMPartyIdentificationBObj objects
		for (TCRMCommon loserPartyVal : loserPartyVals){
			losersCasted.add((TCRMPartyIdentificationBObj)loserPartyVal);
		}

		// remove all loser objects from the primary vector. This leaves the survivors in the primary vector
		vecParty1Vals.removeAll(losersCasted);


		// if called from within this class (execute method), go through each row in the 
		// primary vector and set the last upd and idpk to null
		if(!externallyCalled){
			for(int x=0; x< vecParty1Vals.size(); x++)
			{
				TCRMPartyIdentificationBObj mergedBobj = (TCRMPartyIdentificationBObj) vecParty1Vals.get(x);

				mergedBobj.setPartyId(null);
				mergedBobj.setPartyIdentificationLastUpdateDate(null);
				mergedBobj.setIdentificationIdPK(null);			
			}
		}
	}

	public void mergePartyValueBObj(boolean externallyCalled, Vector<TCRMPartyValueBObj> vecParty1Vals, Vector<TCRMPartyValueBObj> vecParty2Vals, TCRMPartyBObj newPartyBobj) throws Exception
	{			 
		Vector<TCRMCommon> loserPartyVals = new Vector<TCRMCommon>();
		Vector<TCRMPartyValueBObj> losersCasted = new Vector<TCRMPartyValueBObj>();

		// compare rows from each party to each other using the survivorship rules
		for (TCRMPartyValueBObj party1Value : vecParty1Vals) {
			for (TCRMPartyValueBObj party2Value : vecParty2Vals) {

				//				String p1t = party1Value.getPartyValueValue();
				//				String part1val = party1Value.getValueString();
				//				String p2t = party2Value.getPartyValueValue();
				//				String part2val = party2Value.getValueString();
				// uniqueness is based on usage type and value combination. Unless party value is of single value only
				// then uniqueniss based on usage type alone (i.e. multiple values not allowed)
				if(((StringUtils.compareWithTrim(party1Value.getPartyValueValue(), party2Value.getPartyValueValue()) 
						&& singleValuePartyVals.contains(party1Value.getPartyValueValue())) 
						||
						(party1Value.getPartyValueValue().equals(party2Value.getPartyValueValue())
								&& StringUtils.compareWithTrim(party1Value.getValueString(), party2Value.getValueString())))

								&& survivorshipConfigs.containsKey("TCRMPartyValueBObj|"+party1Value.getPartyValueValue())
						){

					// the call below puts the surviving attributes into party 1 and puts party 2 values into an array of loser values
					applySurvivorship("TCRMPartyValueBObj", party1Value.getPartyValueValue(), party1Value, party2Value, newPartyBobj);
					loserPartyVals.add(party2Value);
				}
			}
		}

		// if called from within this class (execute method) combine all the attributes into the primary vector
		if(!externallyCalled)
			vecParty1Vals.addAll(vecParty2Vals);

		// cast the loser objects to as appropriate object type
		for (TCRMCommon loserPartyVal : loserPartyVals){
			losersCasted.add((TCRMPartyValueBObj)loserPartyVal);
		}

		// remove all loser objects from the primary vector. This leaves the survivors in the primary vector
		vecParty1Vals.removeAll(losersCasted);

		// if called from within this class (execute method), go thorugh each row in the 
		// primary vector and set the last upd and idpk to null
		if(!externallyCalled){
			for(int x=0; x< vecParty1Vals.size(); x++)
			{
				TCRMPartyValueBObj mergedBobj = (TCRMPartyValueBObj) vecParty1Vals.get(x);
				mergedBobj.setPartyId(null);
				mergedBobj.setPartyValueLastUpdateDate(null);
				mergedBobj.setPartyValueId(null);			
			}
		}
	}

	/*
	 * Finds the non-surviving objects when comparing objects
	 */
	private void applySurvivorship(String objectType, String usageType, TCRMCommon party1Value, TCRMCommon party2Value, TCRMPartyBObj newPartyBobj) throws Exception {

		// get survivorship rules from map based on object type + usage type combination
		for (SurvivorshipConfigObj survivorshipConfigObj : this.survivorshipConfigs.get(objectType+"|"+usageType)) {

			// get the sources from the objects
			String party1ValSource = (String)party1Value.metaDataMap.get(survivorshipConfigObj.getSourceFld());
			String party2ValSource = (String)party2Value.metaDataMap.get(survivorshipConfigObj.getSourceFld());

			HashMap<String, Integer> srcPriOrderMap = survivorshipConfigObj.getSourcePriorityMap();

			// if source 2 present but not source 1, the value in party 2 survives into party 1
			if(party1ValSource == null && party2ValSource != null){
				for (String fieldAffected : survivorshipConfigObj.getSurvivorFlds()) {
					updateSurvivingObject(objectType, fieldAffected, party1Value, party2Value);
				}
			}
			// if party1 source is present, but party2 source is not, do nothing as val1 already has the surviving values
			else if(party1ValSource != null && party2ValSource == null){
				// do nothing as val1 already has the surviving values
			}
			// if party1 source is not present and party2 source is also not, do nothing as val1 already has the surviving values
			else if(party1ValSource == null && party2ValSource == null){
				// do nothing as val1 already has the surviving values
			}
			// if source of val1 has a priority, and val2 does not (not in config), then val1 survives
			else if(srcPriOrderMap.get(party1ValSource) != null && srcPriOrderMap.get(party2ValSource) == null){
				// do nothing val1 already has the surviving values
			}
			// if source of val1 does not have a priority (not in config), and val2 does then val2 survives
			else if(srcPriOrderMap.get(party1ValSource) == null && srcPriOrderMap.get(party2ValSource) != null){

				for (String fieldAffected : survivorshipConfigObj.getSurvivorFlds()) {
					updateSurvivingObject(objectType, fieldAffected, party1Value, party2Value);
				}
			}
			// if source of val1 has a higher priority than source of val2, then val1 survives
			else if((srcPriOrderMap.get(party1ValSource) != null && srcPriOrderMap.get(party2ValSource) != null) && srcPriOrderMap.get(party1ValSource) > srcPriOrderMap.get(party2ValSource)){

				// do nothing val1 already has the surviving values
			}
			// if source of val2 has a higher priority than source of val1, then val2 survives
			else if((srcPriOrderMap.get(party1ValSource) != null && srcPriOrderMap.get(party2ValSource) != null) && srcPriOrderMap.get(party2ValSource) > srcPriOrderMap.get(party1ValSource)){

				for (String fieldAffected : survivorshipConfigObj.getSurvivorFlds()) {
					updateSurvivingObject(objectType, fieldAffected, party1Value, party2Value);
				}

			} else {
				// if source of val1 is equal to source of val2, or both sources are not in the priority list,
				// then pick the most recent value as the survivor
				String party1LastUpdDateStr = (String)party1Value.metaDataMap.get(survivorshipConfigObj.getLastVerifiedFld());
				String party2LastUpdDateStr = (String)party2Value.metaDataMap.get(survivorshipConfigObj.getLastVerifiedFld());
				Date party1ValueLastUpd = null;
				Date party2ValueLastUpd = null;

				// if the val1 has an last update date string, set it as a date object
				if(party1LastUpdDateStr != null && !party1LastUpdDateStr.equals("")){
					String dateFormat = "yyyy-MM-dd HH:mm:ss.S";
					if(objectType.equals("TCRMPartyValueBObj")){
						dateFormat = "yyyy-MM-dd HH:mm:ss";
					}
					party1ValueLastUpd = new SimpleDateFormat(dateFormat).parse(party1LastUpdDateStr);
				}
				// if the val2 has an last update date string, set it as a date object
				if(party2LastUpdDateStr != null && !party2LastUpdDateStr.equals("")){
					String dateFormat = "yyyy-MM-dd HH:mm:ss.S"; 
					if(objectType.equals("TCRMPartyValueBObj")){
						dateFormat = "yyyy-MM-dd HH:mm:ss";
					}
					party2ValueLastUpd = new SimpleDateFormat(dateFormat).parse(party2LastUpdDateStr);
				}

				// if val1 and val2 both have last update dates, val1 is the survivor if it is more recent
				if(party1ValueLastUpd != null & party2ValueLastUpd != null && party1ValueLastUpd.after(party2ValueLastUpd)){
					// do nothing val1 already has the surviving values
				} 
				// if val1 and val2 both have last update dates, val2 is the survivor if it is more recent
				else if(party1ValueLastUpd != null & party2ValueLastUpd != null && party2ValueLastUpd.after(party1ValueLastUpd)){
					for (String fieldAffected : survivorshipConfigObj.getSurvivorFlds()) {
						updateSurvivingObject(objectType, fieldAffected, party1Value, party2Value);
					}
				} else{
					// do nothing - val 1 is already the survivor
				}
			}
		}
	}


	// update surviving object. Must include all updateable fields
	private void updateSurvivingObject(String objectType, String fieldAffected, TCRMCommon party1Value, TCRMCommon party2Value) throws Exception {

		// BEGIN PARTY IDENTIFICATION SURVIVOR UPDATES
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("LastVerifiedDate")){
			((TCRMPartyIdentificationBObj)party1Value).setLastVerifiedDate(((TCRMPartyIdentificationBObj)party2Value).getLastVerifiedDate());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("SourceIdentifierValue")){
			((TCRMPartyIdentificationBObj)party1Value).setSourceIdentifierType(((TCRMPartyIdentificationBObj)party2Value).getSourceIdentifierType());
			((TCRMPartyIdentificationBObj)party1Value).setSourceIdentifierValue(((TCRMPartyIdentificationBObj)party2Value).getSourceIdentifierValue());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("IdentificationStatusType")){
			((TCRMPartyIdentificationBObj)party1Value).setIdentificationStatusType(((TCRMPartyIdentificationBObj)party2Value).getIdentificationStatusType());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("IdentificationStatusValue")){
			((TCRMPartyIdentificationBObj)party1Value).setIdentificationStatusValue(((TCRMPartyIdentificationBObj)party2Value).getIdentificationStatusValue());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("IdentificationNumber")){
			((TCRMPartyIdentificationBObj)party1Value).setIdentificationNumber(((TCRMPartyIdentificationBObj)party2Value).getIdentificationNumber());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("IdentificationIssueLocation")){
			((TCRMPartyIdentificationBObj)party1Value).setIdentificationIssueLocation(((TCRMPartyIdentificationBObj)party2Value).getIdentificationIssueLocation());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("StartDate")){
			((TCRMPartyIdentificationBObj)party1Value).setStartDate(((TCRMPartyIdentificationBObj)party2Value).getStartDate());
		}
		if(objectType.equals("TCRMPartyIdentificationBObj") && fieldAffected.equals("EndDate")){
			((TCRMPartyIdentificationBObj)party1Value).setEndDate(((TCRMPartyIdentificationBObj)party2Value).getEndDate());
		}

		// BEGIN PARTY ADDRESS SURVIVOR UPDATES

		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XProvider_Facility_Staff_Code")){			
			((XNWPartyAddressBObjExt)party1Value).setXProvider_Facility_Staff_Code(((XNWPartyAddressBObjExt)party2Value).getXProvider_Facility_Staff_Code());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XProvider_Facility_Active_Status")){			
			((XNWPartyAddressBObjExt)party1Value).setXProvider_Facility_Active_Status(((XNWPartyAddressBObjExt)party2Value).getXProvider_Facility_Active_Status());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XPrimary_Office_Flag")){			
			((XNWPartyAddressBObjExt)party1Value).setXPrimary_Office_Flag(((XNWPartyAddressBObjExt)party2Value).getXPrimary_Office_Flag());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("PA-XDeactivation_Flag")){
			((XNWPartyAddressBObjExt)party1Value).setXDeactivation_Flag(((XNWPartyAddressBObjExt)party2Value).getXDeactivation_Flag());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XPrimary_Billing_Location_Flag")){			
			((XNWPartyAddressBObjExt)party1Value).setXPrimary_Billing_Location_Flag(((XNWPartyAddressBObjExt)party2Value).getXPrimary_Billing_Location_Flag());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XCredential_Status")){			
			((XNWPartyAddressBObjExt)party1Value).setXCredential_Status(((XNWPartyAddressBObjExt)party2Value).getXCredential_Status());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XProvider_Status")){			
			((XNWPartyAddressBObjExt)party1Value).setXProvider_Status(((XNWPartyAddressBObjExt)party2Value).getXProvider_Status());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XScheduling_Primary_Flag")){			
			((XNWPartyAddressBObjExt)party1Value).setXScheduling_Primary_Flag(((XNWPartyAddressBObjExt)party2Value).getXScheduling_Primary_Flag());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("PA-XPhone")){			
			((XNWPartyAddressBObjExt)party1Value).setXPhone(((XNWPartyAddressBObjExt)party2Value).getXPhone());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("PA-XPhone_Ext")){			
			((XNWPartyAddressBObjExt)party1Value).setXPhone_Ext(((XNWPartyAddressBObjExt)party2Value).getXPhone_Ext());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("PA-XSecondary_Phone")){			
			((XNWPartyAddressBObjExt)party1Value).setXSecondary_Phone(((XNWPartyAddressBObjExt)party2Value).getXSecondary_Phone());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("PA-XSec_Phone_Ext")){			
			((XNWPartyAddressBObjExt)party1Value).setXSec_Phone_Ext(((XNWPartyAddressBObjExt)party2Value).getXSec_Phone_Ext());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("PA-XFax")){			
			((XNWPartyAddressBObjExt)party1Value).setXFax(((XNWPartyAddressBObjExt)party2Value).getXFax());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("EndDate")){			
			((XNWPartyAddressBObjExt)party1Value).setEndDate(((XNWPartyAddressBObjExt)party2Value).getEndDate());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("LastVerifiedDate")){			
			((XNWPartyAddressBObjExt)party1Value).setLastVerifiedDate(((XNWPartyAddressBObjExt)party2Value).getLastVerifiedDate());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("StartDate")){
			((XNWPartyAddressBObjExt)party1Value).setStartDate(((XNWPartyAddressBObjExt)party2Value).getStartDate());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("SourceIdentifierValue")){			
			((XNWPartyAddressBObjExt)party1Value).setSourceIdentifierValue(((XNWPartyAddressBObjExt)party2Value).getSourceIdentifierValue());
			((XNWPartyAddressBObjExt)party1Value).setSourceIdentifierType(((XNWPartyAddressBObjExt)party2Value).getSourceIdentifierType());
		}

		// BEGIN ADDRESS SURVIVOR UPDATES

		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XCounty")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXCounty(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXCounty());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XHospital")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXHospital(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXHospital());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XFacility_Name")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXFacility_Name(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXFacility_Name());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XFacility_Code")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXFacility_Code(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXFacility_Code());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XDepartment_Code")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXDepartment_Code(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXDepartment_Code());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XDepartment_Description")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXDepartment_Description(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXDepartment_Description());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XLocation_Code")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXLocation_Code(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXLocation_Code());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XLocation_Description")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXLocation_Description(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXLocation_Description());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XLocation_Mnemonic")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXLocation_Mnemonic(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXLocation_Mnemonic());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XLocation_ID")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXLocation_ID(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXLocation_ID());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XLocation_Name")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXLocation_Name(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXLocation_Name());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XPhone")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXPhone(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXPhone());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XPhone_Ext")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXPhone_Ext(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXPhone_Ext());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XSecondary_Phone")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXSecondary_Phone(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXSecondary_Phone());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XSec_Phone_Ext")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXSec_Phone_Ext(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXSec_Phone_Ext());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XFax")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXFax(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXFax());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XTax_ID_Number")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXTax_ID_Number(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXTax_ID_Number());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XNewport_Key")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXNewport_Key(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXNewport_Key());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("ZipPostalCode")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setZipPostalCode(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getZipPostalCode());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("AddressLineOne")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setAddressLineOne(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getAddressLineOne());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("AddressLineTwo")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setAddressLineTwo(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getAddressLineTwo());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("City")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setCity(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getCity());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("CountyCode")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setCountyCode(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getCountyCode());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("LatitudeDegrees")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setLatitudeDegrees(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getLatitudeDegrees());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("LongitudeDegrees")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setLongitudeDegrees(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getLongitudeDegrees());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("CountryValue")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setCountryValue(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getCountryValue());
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setCountryType(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getCountryType());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("ProvinceStateValue")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setProvinceStateValue(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getProvinceStateValue());
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setProvinceStateType(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getProvinceStateType());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XDeactivation_Flag")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXDeactivation_Flag(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXDeactivation_Flag());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XActivation_Date")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXActivation_Date(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXActivation_Date());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XDeactivation_Date")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXDeactivation_Date(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXDeactivation_Date());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XTax_ID_Number_Source")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXTax_ID_Number_Source(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXTax_ID_Number_Source());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XTax_ID_Number_LastVerifiedDate")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXTax_ID_Number_LastVerifiedDate(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXTax_ID_Number_LastVerifiedDate());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XNewport_Key_Source")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXNewport_Key_Source(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXNewport_Key_Source());
		}
		if(objectType.equals("XNWPartyAddressBObjExt") && fieldAffected.equals("XNewport_Key_LastVerifiedDate")){			
			((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party1Value).getTCRMAddressBObj()).setXNewport_Key_LastVerifiedDate(((XNWAddressBObjExt)((XNWPartyAddressBObjExt)party2Value).getTCRMAddressBObj()).getXNewport_Key_LastVerifiedDate());
		}

		// BEGIN PARTY VALUES SURVIVOR UPDATES
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("StartDate")){			
			((TCRMPartyValueBObj)party1Value).setStartDate(((TCRMPartyValueBObj)party2Value).getStartDate());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("EndDate")){			
			((TCRMPartyValueBObj)party1Value).setEndDate(((TCRMPartyValueBObj)party2Value).getEndDate());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("ValueString")){			
			((TCRMPartyValueBObj)party1Value).setValueString(((TCRMPartyValueBObj)party2Value).getValueString());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("SourceIdentValue")){			
			((TCRMPartyValueBObj)party1Value).setSourceIdentValue(((TCRMPartyValueBObj)party2Value).getSourceIdentValue());
			((TCRMPartyValueBObj)party1Value).setSourceIdentType(((TCRMPartyValueBObj)party2Value).getSourceIdentType());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute0String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute0String(((TCRMPartyValueBObj)party2Value).getAttribute0String());
			((TCRMPartyValueBObj)party1Value).setAttribute0Type(((TCRMPartyValueBObj)party2Value).getAttribute0Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute1String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute1String(((TCRMPartyValueBObj)party2Value).getAttribute1String());
			((TCRMPartyValueBObj)party1Value).setAttribute1Type(((TCRMPartyValueBObj)party2Value).getAttribute1Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute2String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute2String(((TCRMPartyValueBObj)party2Value).getAttribute2String());
			((TCRMPartyValueBObj)party1Value).setAttribute2Type(((TCRMPartyValueBObj)party2Value).getAttribute2Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute3String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute3String(((TCRMPartyValueBObj)party2Value).getAttribute3String());
			((TCRMPartyValueBObj)party1Value).setAttribute3Type(((TCRMPartyValueBObj)party2Value).getAttribute3Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute4String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute4String(((TCRMPartyValueBObj)party2Value).getAttribute4String());
			((TCRMPartyValueBObj)party1Value).setAttribute4Type(((TCRMPartyValueBObj)party2Value).getAttribute4Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute5String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute5String(((TCRMPartyValueBObj)party2Value).getAttribute5String());
			((TCRMPartyValueBObj)party1Value).setAttribute5Type(((TCRMPartyValueBObj)party2Value).getAttribute5Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute6String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute6String(((TCRMPartyValueBObj)party2Value).getAttribute6String());
			((TCRMPartyValueBObj)party1Value).setAttribute6Type(((TCRMPartyValueBObj)party2Value).getAttribute6Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute7String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute7String(((TCRMPartyValueBObj)party2Value).getAttribute7String());
			((TCRMPartyValueBObj)party1Value).setAttribute7Type(((TCRMPartyValueBObj)party2Value).getAttribute7Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute8String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute8String(((TCRMPartyValueBObj)party2Value).getAttribute8String());
			((TCRMPartyValueBObj)party1Value).setAttribute8Type(((TCRMPartyValueBObj)party2Value).getAttribute8Type());
		}
		if(objectType.equals("TCRMPartyValueBObj") && fieldAffected.equals("Attribute9String")){			
			((TCRMPartyValueBObj)party1Value).setAttribute9String(((TCRMPartyValueBObj)party2Value).getAttribute9String());
			((TCRMPartyValueBObj)party1Value).setAttribute9Type(((TCRMPartyValueBObj)party2Value).getAttribute9Type());
		}

		// BEGIN PERSON NAME SURVIVOR UPDATES
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("XFull_Name")){	
			((XNWPersonNameBObjExt)party1Value).setXFull_Name(((XNWPersonNameBObjExt)party2Value).getXFull_Name());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("XDegree")){	
			((XNWPersonNameBObjExt)party1Value).setXDegree(((XNWPersonNameBObjExt)party2Value).getXDegree());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("EndDate")){	
			((XNWPersonNameBObjExt)party1Value).setEndDate(((XNWPersonNameBObjExt)party2Value).getEndDate());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("GivenNameOne")){	
			((XNWPersonNameBObjExt)party1Value).setGivenNameOne(((XNWPersonNameBObjExt)party2Value).getGivenNameOne());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("GivenNameTwo")){	
			((XNWPersonNameBObjExt)party1Value).setGivenNameTwo(((XNWPersonNameBObjExt)party2Value).getGivenNameTwo());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("LastName")){	
			((XNWPersonNameBObjExt)party1Value).setLastName(((XNWPersonNameBObjExt)party2Value).getLastName());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("PrefixDescription")){	
			((XNWPersonNameBObjExt)party1Value).setPrefixDescription(((XNWPersonNameBObjExt)party2Value).getPrefixDescription());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("LastVerifiedDate")){	
			((XNWPersonNameBObjExt)party1Value).setLastVerifiedDate(((XNWPersonNameBObjExt)party2Value).getLastVerifiedDate());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("StartDate")){	
			((XNWPersonNameBObjExt)party1Value).setStartDate(((XNWPersonNameBObjExt)party2Value).getStartDate());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("Suffix")){	
			((XNWPersonNameBObjExt)party1Value).setSuffix(((XNWPersonNameBObjExt)party2Value).getSuffix());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("SourceIdentifierValue")){	
			((XNWPersonNameBObjExt)party1Value).setSourceIdentifierValue(((XNWPersonNameBObjExt)party2Value).getSourceIdentifierValue());
			((XNWPersonNameBObjExt)party1Value).setSourceIdentifierType(((XNWPersonNameBObjExt)party2Value).getSourceIdentifierType());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("PrefixValue")){	
			((XNWPersonNameBObjExt)party1Value).setPrefixValue(((XNWPersonNameBObjExt)party2Value).getPrefixValue());
			((XNWPersonNameBObjExt)party1Value).setPrefixType(((XNWPersonNameBObjExt)party2Value).getPrefixType());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("GenerationValue")){	
			((XNWPersonNameBObjExt)party1Value).setGenerationValue(((XNWPersonNameBObjExt)party2Value).getGenerationValue());
			((XNWPersonNameBObjExt)party1Value).setGenerationType(((XNWPersonNameBObjExt)party2Value).getGenerationType());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("XDegree_Source")){	
			((XNWPersonNameBObjExt)party1Value).setXDegree_Source(((XNWPersonNameBObjExt)party2Value).getXDegree_Source());
		}
		if(objectType.equals("XNWPersonNameBObjExt") && fieldAffected.equals("XDegree_LastVerifiedDate")){	
			((XNWPersonNameBObjExt)party1Value).setXDegree_LastVerifiedDate(((XNWPersonNameBObjExt)party2Value).getXDegree_LastVerifiedDate());
		}

		// BEGIN PARTY CONTACT METHOD SURVIVOR UPDATES
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("LastVerifiedDate")){
			((TCRMPartyContactMethodBObj)party1Value).setLastVerifiedDate(((TCRMPartyContactMethodBObj)party2Value).getLastVerifiedDate());
		}
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("EndDate")){
			((TCRMPartyContactMethodBObj)party1Value).setEndDate(((TCRMPartyContactMethodBObj)party2Value).getEndDate());
		}
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("StartDate")){
			((TCRMPartyContactMethodBObj)party1Value).setStartDate(((TCRMPartyContactMethodBObj)party2Value).getStartDate());
		}
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("ContactMethodStatusValue")){
			((TCRMPartyContactMethodBObj)party1Value).setContactMethodStatusValue(((TCRMPartyContactMethodBObj)party2Value).getContactMethodStatusValue());
			((TCRMPartyContactMethodBObj)party1Value).setContactMethodStatusType(((TCRMPartyContactMethodBObj)party2Value).getContactMethodStatusType());
		}
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("SourceIdentifierValue")){
			((TCRMPartyContactMethodBObj)party1Value).setSourceIdentifierValue(((TCRMPartyContactMethodBObj)party2Value).getSourceIdentifierValue());
			((TCRMPartyContactMethodBObj)party1Value).setSourceIdentifierType(((TCRMPartyContactMethodBObj)party2Value).getSourceIdentifierType());
		}

		// BEGIN CONTACT METHOD SURVIVOR UPDATES
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("XExtension")){
			((XNWContactMethodBObjExt)((TCRMPartyContactMethodBObj)party1Value).getTCRMContactMethodBObj()).setXExtension(((XNWContactMethodBObjExt)((TCRMPartyContactMethodBObj)party2Value).getTCRMContactMethodBObj()).getXExtension());
		}
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("ReferenceNumber")){
			((XNWContactMethodBObjExt)((TCRMPartyContactMethodBObj)party1Value).getTCRMContactMethodBObj()).setReferenceNumber(((XNWContactMethodBObjExt)((TCRMPartyContactMethodBObj)party2Value).getTCRMContactMethodBObj()).getReferenceNumber());
		}
		if(objectType.equals("TCRMPartyContactMethodBObj") && fieldAffected.equals("Status")){
			((XNWContactMethodBObjExt)((TCRMPartyContactMethodBObj)party1Value).getTCRMContactMethodBObj()).setStatus(((XNWContactMethodBObjExt)((TCRMPartyContactMethodBObj)party1Value).getTCRMContactMethodBObj()).getStatus());
		}
	}

	/**
	 *This method collapses Party 1 and Party 2 address business objects.
	 *Address usage type is used as business keys to determine duplicates. Unique party address business
	 *objects from party 1 and Party 2 are survived. For duplicates the most recent address business object is survived.
	 * 
	 * @param vector sourcePartyAddressBObj
	 * @param vector targetPartyAddressBObj
	 * @param newOrgBobj
	 * @return  
	 * @throws Exception	 
	 */	 
	@SuppressWarnings("unchecked")
	public void mergePartyAddressBObj(boolean externallyCalled, Vector<XNWPartyAddressBObjExt> vecParty1Vals, Vector<XNWPartyAddressBObjExt> vecParty2Vals, TCRMPartyBObj newPartyBobj) throws Exception
	{			 

		Vector<TCRMCommon> loserPartyVals = new Vector<TCRMCommon>();
		Vector<XNWPartyAddressBObjExt> losersCasted = new Vector<XNWPartyAddressBObjExt>();

		// compare rows from each party to each other using the survivorship rules
		for (XNWPartyAddressBObjExt party1Value : vecParty1Vals) {
			for (XNWPartyAddressBObjExt party2Value : vecParty2Vals) {


				// uniqueness is based on usage type and value combination
				if(party1Value.getAddressUsageValue().equals(party2Value.getAddressUsageValue())
						&& survivorshipConfigs.containsKey("XNWPartyAddressBObjExt|"+party1Value.getAddressUsageValue())
						&& (!multiValueAddresses.contains(party1Value.getAddressUsageValue()) || 
								(multiValueAddresses.contains(party1Value.getAddressUsageValue())
										&&	StringUtils.compareWithTrim(party1Value.getTCRMAddressBObj().getAddressLineOne(), party2Value.getTCRMAddressBObj().getAddressLineOne())
										&&	StringUtils.compareWithTrim(party1Value.getTCRMAddressBObj().getAddressLineTwo(),party2Value.getTCRMAddressBObj().getAddressLineTwo())
										&&	StringUtils.compareWithTrim(party1Value.getTCRMAddressBObj().getCity(),party2Value.getTCRMAddressBObj().getCity())
										&&	StringUtils.compareWithTrim(party1Value.getTCRMAddressBObj().getProvinceStateValue(),party2Value.getTCRMAddressBObj().getProvinceStateValue())
										&&	StringUtils.compareWithTrim(party1Value.getTCRMAddressBObj().getZipPostalCode(),party2Value.getTCRMAddressBObj().getZipPostalCode())
										&&	
										((StringUtils.compareWithTrim(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXFacility_Code(), ((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXFacility_Code())
												&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXDepartment_Code(), ((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXDepartment_Code())
												&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXLocation_Code(), ((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXLocation_Code())
												&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXFacility_Name(), ((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXFacility_Name())
												&&	StringUtils.compareWithTrim(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXLocation_Name(), ((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXLocation_Name()))

												|| 

												(StringUtils.isBlank(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXFacility_Code())
														&& StringUtils.isBlank(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXFacility_Name())
														&& StringUtils.isBlank(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXDepartment_Code())
														&& StringUtils.isBlank(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXLocation_Code())
														&& StringUtils.isBlank(((XNWAddressBObjExt)party1Value.getTCRMAddressBObj()).getXLocation_Name()))

														||

														(StringUtils.isBlank(((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXFacility_Code())
																&& StringUtils.isBlank(((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXFacility_Name())
																&& StringUtils.isBlank(((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXDepartment_Code())
																&& StringUtils.isBlank(((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXLocation_Code())
																&& StringUtils.isBlank(((XNWAddressBObjExt)party2Value.getTCRMAddressBObj()).getXLocation_Name()))
												)
										)
								)
						)
				{
					// the call below puts the surviving attributes into party 1 and puts party 2 values into an array of loser values
					applySurvivorship("XNWPartyAddressBObjExt", party1Value.getAddressUsageValue(), party1Value, party2Value, newPartyBobj);
					loserPartyVals.add(party2Value);
				}
			}
		}


		// if called from within this class (execute method) combine all the attributes into the primary vector
		if(!externallyCalled)
			vecParty1Vals.addAll(vecParty2Vals);

		// cast the loser objects to as appropriate object type
		for (TCRMCommon loserPartyVal : loserPartyVals){
			losersCasted.add((XNWPartyAddressBObjExt)loserPartyVal);
		}

		//remove all loser objects from the primary vector. This leaves the survivors in the primary vector
		vecParty1Vals.removeAll(losersCasted);

		// if called from within this class (execute method), go thorugh each row in the 
		// primary vector and set the last upd and idpk to null
		if(!externallyCalled){
			for(int x=0; x< vecParty1Vals.size(); x++)
			{
				XNWPartyAddressBObjExt mergedBobj = (XNWPartyAddressBObjExt) vecParty1Vals.get(x);

				mergedBobj.setPartyAddressIdPK(null);
				mergedBobj.setPartyId(null);
				mergedBobj.setAddressId(null);
				mergedBobj.setAddressGroupLastUpdateDate(null);
				mergedBobj.setLocationGroupLastUpdateDate(null);
				mergedBobj.getTCRMAddressBObj().setAddressLastUpdateDate(null);		
				mergedBobj.getTCRMAddressBObj().setAddressIdPK(null);	
			}
		}
	}

	/**
	 * This method collapses Party1 and Party2 contact method business objects.
	 * Party Contact method usage type and contact method type is used as business keys to determine duplicates.
	 * Unique party contact method business objects from Party1 and Party2 are survived.
	 * For duplicates the most recent contact method business object is survived.
	 * 
	 * @param vector vecParty1ContMeth
	 * @param vector vecParty2ContMeth
	 * @param newPartyBobj
	 * @param partyNameRules 
	 * @return  
	 * @throws Exception	 
	 */		 
	public void mergePartyContactMethodBObj(boolean externallyCalled, Vector <TCRMPartyContactMethodBObj> vecParty1Vals, Vector <TCRMPartyContactMethodBObj> vecParty2Vals, TCRMPartyBObj newPartyBobj) throws Exception
	{			 
		Vector<TCRMCommon> loserPartyVals = new Vector<TCRMCommon>();
		Vector<TCRMPartyContactMethodBObj> losersCasted = new Vector<TCRMPartyContactMethodBObj>();

		// compare rows from each party to each other using the survivorship rules
		for (TCRMPartyContactMethodBObj party1Value : vecParty1Vals) {
			for (TCRMPartyContactMethodBObj party2Value : vecParty2Vals) {

				// uniqueness is based on usage type only
				if(party1Value.getContactMethodUsageValue().equals(party2Value.getContactMethodUsageValue())
						&& survivorshipConfigs.containsKey("TCRMPartyContactMethodBObj|"+party1Value.getContactMethodUsageValue())){
					// the call below puts the surviving attributes into party 1 and puts party 2 values into an array of loser values
					applySurvivorship("TCRMPartyContactMethodBObj", party1Value.getContactMethodUsageValue(), party1Value, party2Value, newPartyBobj);
					loserPartyVals.add(party2Value);
				}
			}
		}


		// if called from within this class (execute method) combine all the attributes into the primary vector
		if(!externallyCalled)
			vecParty1Vals.addAll(vecParty2Vals);

		// cast the loser objects to as appropriate object type
		for (TCRMCommon loserPartyVal : loserPartyVals){
			losersCasted.add((TCRMPartyContactMethodBObj)loserPartyVal);
		}

		// remove all loser objects from the primary vector. This leaves the survivors in the primary vector
		vecParty1Vals.removeAll(losersCasted);

		// if called from within this class (execute method), go thorugh each row in the 
		// primary vector and set the last upd and idpk to null
		if(!externallyCalled){
			for(int x=0; x< vecParty1Vals.size(); x++)
			{
				TCRMPartyContactMethodBObj mergedBobj = (TCRMPartyContactMethodBObj) vecParty1Vals.get(x);

				mergedBobj.setPartyId(null);
				mergedBobj.setPartyContactMethodIdPK(null);
				mergedBobj.getTCRMContactMethodBObj().setContactMethodIdPK(null);

				mergedBobj.setLocationGroupLastUpdateDate(null);
				mergedBobj.setContactMethodGroupLastUpdateDate(null);
				mergedBobj.getTCRMContactMethodBObj().setContactMethodLastUpdateDate(null);
				mergedBobj.setContactMethodId(null);
			}

		}
	}

	/**
	 * This method adds source and target suppliers AdminContEquiv business object to new supplier
	 * Note- Each record will have at least one Source ID associated
	 *  
	 * @param vector sourceAdminContEquivBObj
	 * @param vector targetAdminContEquivBObj
	 * @param newOrgBobj
	 * @return  
	 * @throws Exception	 
	 */	 		 
	private void mergeAdminContEquivBObj(Vector <TCRMAdminContEquivBObj> vecParty1AdminContEquiv, Vector <TCRMAdminContEquivBObj> vecParty2AdminContEquiv, TCRMPartyBObj newPartyBobj) throws Exception
	{		 
		Vector <TCRMAdminContEquivBObj> vecMergedAdminContEquiv = new Vector();

		vecMergedAdminContEquiv.addAll(vecParty1AdminContEquiv);
		vecMergedAdminContEquiv.addAll(vecParty2AdminContEquiv);

		for(int i=0; i < vecMergedAdminContEquiv.size(); i++)
		{
			TCRMAdminContEquivBObj mergedAdminContEquivBobj = vecMergedAdminContEquiv.get(i);

			mergedAdminContEquivBobj.setPartyId(null);
			mergedAdminContEquivBobj.setAdminContEquivIdPK(null);
			mergedAdminContEquivBobj.setContEquivLastUpdateDate(null);

			if(!newPartyBobj.getItemsTCRMAdminContEquivBObj().contains(mergedAdminContEquivBobj))
				newPartyBobj.setTCRMAdminContEquivBObj(mergedAdminContEquivBobj);
		}		 		 
	}	 


	/**
	 *This method collapses Party 1 and Party 2 person name business objects.
	 *Name usage type is used as business keys to determine duplicates.
	 *For duplicates the most recent address business object is survived.
	 * 
	 * @param vector vecParty1Name
	 * @param vector vecParty2Name
	 * @param newPersonBObj
	 * @param personNameRules 
	 * @return  
	 * @throws Exception	 
	 */	 
	public void mergePersonNameBObj(boolean externallyCalled, Vector <XNWPersonNameBObjExt> vecParty1Vals, Vector <XNWPersonNameBObjExt> vecParty2Vals, TCRMPartyBObj newPartyBobj) throws Exception
	{			 
		Vector<TCRMCommon> loserPartyVals = new Vector<TCRMCommon>();
		Vector<XNWPersonNameBObjExt> losersCasted = new Vector<XNWPersonNameBObjExt>();

		// compare rows from each party to each other using the survivorship rules
		for (XNWPersonNameBObjExt party1Value : vecParty1Vals) {
			for (XNWPersonNameBObjExt party2Value : vecParty2Vals) {

				// uniqueness is based on usage type only, except for multi-value names which are based on usage type + value combination
				if(party1Value.getNameUsageValue().equals(party2Value.getNameUsageValue())
						&& survivorshipConfigs.containsKey("XNWPersonNameBObjExt|"+party1Value.getNameUsageValue())
						&& (!multiValueNames.contains(party1Value.getNameUsageValue()) || 
								(multiValueNames.contains(party1Value.getNameUsageValue())
										&& StringUtils.compareWithTrim(party1Value.getGivenNameOne(), party2Value.getGivenNameOne()) 
										&& StringUtils.compareWithTrim(party1Value.getLastName(), party2Value.getLastName()) 
										&& (StringUtils.compareWithTrim(party1Value.getGivenNameTwo(), party2Value.getGivenNameTwo()) || 
												(party1Value.getGivenNameTwo() == null && party2Value.getGivenNameTwo() != null) || 
												(party1Value.getGivenNameTwo() != null && party2Value.getGivenNameTwo() == null)
												)
										)
								)
						){
					// the call below puts the surviving attributes into party 1 and puts party 2 values into an array of loser values
					applySurvivorship("XNWPersonNameBObjExt", party1Value.getNameUsageValue(), party1Value, party2Value, newPartyBobj);
					loserPartyVals.add(party2Value);
				}
			}
		}

		// if called from within this class (execute method) combine all the attributes into the primary vector
		if(!externallyCalled)
			vecParty1Vals.addAll(vecParty2Vals);

		// cast the loser objects to as appropriate object type
		for (TCRMCommon loserPartyVal : loserPartyVals){
			losersCasted.add((XNWPersonNameBObjExt)loserPartyVal);
		}

		// remove all loser objects from the primary vector. This leaves the survivors in the primary vector
		vecParty1Vals.removeAll(losersCasted);

		// if called from within this class (execute method), go thorugh each row in the 
		// primary vector and set the last upd and idpk to null
		if(!externallyCalled){
			for(int x=0; x< vecParty1Vals.size(); x++)
			{
				XNWPersonNameBObjExt mergedBobj = (XNWPersonNameBObjExt) vecParty1Vals.get(x);
				mergedBobj.setContId(null);
				mergedBobj.setLastUpdatedDate(null);
				mergedBobj.setPersonNameIdPK(null);
			}
		}	
	}

	/**
	 * This method collapses Party 1 and Party 2 person business objects
	 * @param personRules 
	 * 
	 * @param vector sourcePartyIdentificationBObj
	 * @param vector targetPartyIdentificationBObj
	 * @param newOrgBobj
	 * @return  
	 * @throws Exception	 
	 */		
	public XNWPersonBObjExt mergePersonBObj(XNWPersonBObjExt party1PersonBObj, XNWPersonBObjExt party2PersonBObj, XNWPersonBObjExt newPersonBObj) throws Exception
	{

		for (SurvivorshipConfigObj survivorshipConfigObj : this.survivorshipConfigs.get("XNWPersonBObjExt")) {

			// get sources of each persons
			String party1Source = (String)party1PersonBObj.metaDataMap.get(survivorshipConfigObj.getSourceFld());
			String party2Source = (String)party2PersonBObj.metaDataMap.get(survivorshipConfigObj.getSourceFld());


			HashMap<String, Integer> srcPriOrderMap = survivorshipConfigObj.getSourcePriorityMap();

			// if party1 source is in priority list, but party2 source is not, then leave the person1 values as is to survive
			if(srcPriOrderMap.get(party1Source) != null && srcPriOrderMap.get(party2Source) == null){
				// DO NOTHING - party 1 values survive and stay as-is
			}
			// if party1 source is not in priority list, but party2 source is, then select the person2 value to put in newPersonBObj object
			else if(srcPriOrderMap.get(party1Source) == null && srcPriOrderMap.get(party2Source) != null){
				for (String field : survivorshipConfigObj.getSurvivorFlds()) {
					updateSurvivingPerson(field, newPersonBObj, party2PersonBObj);
				}
			}
			// if party1 source is higher priority than party2 source is, then leave the person1 values as is to survive
			else if((srcPriOrderMap.get(party1Source) != null && srcPriOrderMap.get(party2Source) != null) && srcPriOrderMap.get(party1Source) > srcPriOrderMap.get(party2Source)){
				// DO NOTHING - party 1 values survive and stay as-is
			}
			// if party2 source is higher priority than party1 source is, then select the person2 value to put in newPersonBObj object
			else if((srcPriOrderMap.get(party1Source) != null && srcPriOrderMap.get(party2Source) != null) && srcPriOrderMap.get(party2Source) > srcPriOrderMap.get(party1Source)){
				for (String field : survivorshipConfigObj.getSurvivorFlds()) {
					updateSurvivingPerson(field, newPersonBObj, party2PersonBObj);
				}
			} else {
				// if party1 source is equal priority than party2 source is (or both are not in the priority list)
				// then select the value that is most recent to put into the party 1 object

				if(party1PersonBObj.metaDataMap.get(survivorshipConfigObj.getLastVerifiedFld()) != null && party2PersonBObj.metaDataMap.get(survivorshipConfigObj.getLastVerifiedFld()) != null){
					Date party1PersonBObjLastUpd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)party1PersonBObj.metaDataMap.get(survivorshipConfigObj.getLastVerifiedFld()));
					Date party2PersonBObjLastUpd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)party2PersonBObj.metaDataMap.get(survivorshipConfigObj.getLastVerifiedFld()));
					if(party1PersonBObjLastUpd.after(party2PersonBObjLastUpd)){
						// DO NOTHING - party 1 values survive and stay as-is
					} else {
						for (String field : survivorshipConfigObj.getSurvivorFlds()) {
							updateSurvivingPerson(field, newPersonBObj, party2PersonBObj);					
						}
					}
				} else{
					// DO NOTHING - party 1 values survive and stay as-is
				}
			}
		}

		// set the person1 control as the newPersonBObj control 
		newPersonBObj.setControl(party1PersonBObj.getControl());

		// return the newPersonBObj object representing a new person object containing the surviving person data
		return newPersonBObj;
	}

	// update surviving object. Must include all updateable fields
	private void updateSurvivingPerson(String field, XNWPersonBObjExt newPersonBObj,
			XNWPersonBObjExt party2PersonBObj) throws Exception {

		if(field.equals("SourceIdentifierValue")){
			newPersonBObj.setSourceIdentifierValue(party2PersonBObj.getSourceIdentifierValue());
			newPersonBObj.setSourceIdentifierType(party2PersonBObj.getSourceIdentifierType());
		}
		if(field.equals("LastVerifiedDate")){
			newPersonBObj.setLastVerifiedDate(party2PersonBObj.getLastVerifiedDate());
		}
		if(field.equals("BirthDate")){
			newPersonBObj.setBirthDate(party2PersonBObj.getBirthDate());
		}
		if(field.equals("GenderValue")){
			newPersonBObj.setGenderType(party2PersonBObj.getGenderType());
		}
		if(field.equals("DeceasedDate")){
			newPersonBObj.setDeceasedDate(party2PersonBObj.getDeceasedDate());
		}
		if(field.equals("MaritalStatusValue")){
			newPersonBObj.setMaritalStatusType(party2PersonBObj.getMaritalStatusType());
			newPersonBObj.setMaritalStatusValue(party2PersonBObj.getMaritalStatusValue());
		}
		if(field.equals("XJob_Title")){
			newPersonBObj.setXJob_Title(party2PersonBObj.getXJob_Title());
		}
		if(field.equals("XJob_Family")){
			newPersonBObj.setMaritalStatusType(party2PersonBObj.getMaritalStatusType());
		}
		if(field.equals("XFullTime_PartTIme")){
			newPersonBObj.setXFullTime_PartTIme(party2PersonBObj.getXFullTime_PartTIme());
		}
		if(field.equals("XStandard_Hours")){
			newPersonBObj.setXStandard_Hours(party2PersonBObj.getXStandard_Hours());
		}
		if(field.equals("XBusiness_Unit")){
			newPersonBObj.setXBusiness_Unit(party2PersonBObj.getXBusiness_Unit());
		}
		if(field.equals("XHire_Date")){
			newPersonBObj.setXHire_Date(party2PersonBObj.getXHire_Date());
		}
		if(field.equals("XEmployee_Role_Status")){
			newPersonBObj.setXEmployee_Role_Status(party2PersonBObj.getXEmployee_Role_Status());
		}
		if(field.equals("XRehire_Date")){
			newPersonBObj.setXRehire_Date(party2PersonBObj.getXRehire_Date());
		}
		if(field.equals("XTermination_Date")){
			newPersonBObj.setXTermination_Date(party2PersonBObj.getXTermination_Date());
		}
		if(field.equals("XDepartment_ID")){
			newPersonBObj.setXDepartment_ID(party2PersonBObj.getXDepartment_ID());
		}
		if(field.equals("XDepartment_Name")){
			newPersonBObj.setXDepartment_Name(party2PersonBObj.getXDepartment_Name());
		}
		if(field.equals("XService_Line_Financial_Budgetary")){
			newPersonBObj.setXService_Line_Financial_Budgetary(party2PersonBObj.getXService_Line_Financial_Budgetary());
		}
		if(field.equals("XGender_Source")){
			newPersonBObj.setXGender_Source(party2PersonBObj.getXGender_Source());
		}
		if(field.equals("XGender_LastVerifiedDate")){
			newPersonBObj.setXGender_LastVerifiedDate(party2PersonBObj.getXGender_LastVerifiedDate());
		}
		if(field.equals("XMaritalStatus_Source")){
			newPersonBObj.setXMaritalStatus_Source(party2PersonBObj.getXMaritalStatus_Source());
		}
		if(field.equals("XMaritalStatus_LastVerifiedDate")){
			newPersonBObj.setXMaritalStatus_LastVerifiedDate(party2PersonBObj.getXMaritalStatus_LastVerifiedDate());
		}
		if(field.equals("XEmploymentData_Source")){
			newPersonBObj.setXEmploymentData_Source(party2PersonBObj.getXEmploymentData_Source());
		}
		if(field.equals("XEmploymentData_LastVerifiedDate")){
			newPersonBObj.setXEmploymentData_LastVerifiedDate(party2PersonBObj.getXEmploymentData_LastVerifiedDate());
		}
	}

	// helper function to return status object if call returned an error
	protected DWLStatus addError(DWLControl theControl, String sErrorCode,
			String sReasonCode, String sDetail) {
		IDWLErrorMessage errHandler = TCRMClassFactory.getErrorHandler();

		DWLError error = errHandler.getErrorMessage(
				TCRMCoreComponentID.PARTY_COMPONENT, sErrorCode, sReasonCode,
				theControl, new String[0]);

		error.setDetail(sDetail);
		DWLStatus status = new DWLStatus();
		status.addError(error);
		status.setStatus(DWLStatus.FATAL);
		return status;
	}	 

	/*
	 * Get the survivorship rule configs from the MDM configuration
	 */
	@SuppressWarnings("unchecked")
	public void setSurvivorshipConfigs(DWLControl objDWLControl) throws ConfigurationRepositoryException, ManagementException, BusinessProxyException, DWLPropertyNotFoundException {

		Long startTime = System.currentTimeMillis();
		logger.info("Set survivor configs start: " + startTime);

		// go through all of the survivorship configs for the object type and store them in an ArrayList
		for(int x = 0; x < 40; x++){
			SurvivorshipConfigObj survivorshipConfig = new SurvivorshipConfigObj();
			String rule = null;

			if(CommonUtil.isConfigOptionPresent("Survivorship/TCRMPartyIdentificationBObj/"+x))
				rule = Configuration.getConfiguration()
				.getConfigItem("Survivorship/TCRMPartyIdentificationBObj/"+x, objDWLControl.retrieveConfigContext())
				.getValue();

			if(rule != null){
				String[] partyRuleArr = rule.split("\\|");
				survivorshipConfig.setSourceFld(partyRuleArr[0]);
				survivorshipConfig.setUsageType(partyRuleArr[1]);
				survivorshipConfig.setLastVerifiedFld(partyRuleArr[2]);

				String[] srcPriOrderArr = partyRuleArr[3].split(",");
				HashMap<String, Integer> srcPriOrderMap = new HashMap<String, Integer>();
				int counter = 99;

				// put the sources in a map and assign a priority to it
				for (String source : srcPriOrderArr) {
					counter--;
					srcPriOrderMap.put(source, counter);
				}

				survivorshipConfig.setSourcePriorityMap(srcPriOrderMap);

				survivorshipConfig.setSurvivorFlds(partyRuleArr[4].split(","));

				if(!this.survivorshipConfigs.containsKey("TCRMPartyIdentificationBObj|"+partyRuleArr[1])){
					survivorshipConfigs.put("TCRMPartyIdentificationBObj|"+partyRuleArr[1], new ArrayList<SurvivorshipConfigObj>());
				}

				survivorshipConfigs.get("TCRMPartyIdentificationBObj|"+partyRuleArr[1]).add(survivorshipConfig);

			}
		}

		for(int x = 0; x < 40; x++){
			SurvivorshipConfigObj survivorshipConfig = new SurvivorshipConfigObj();
			String rule = null;

			if(CommonUtil.isConfigOptionPresent("Survivorship/TCRMPartyValueBObj/"+x))
				rule = Configuration.getConfiguration()
				.getConfigItem("Survivorship/TCRMPartyValueBObj/"+x, objDWLControl.retrieveConfigContext())
				.getValue();

			if(rule != null){
				String[] partyRuleArr = rule.split("\\|");
				survivorshipConfig.setSourceFld(partyRuleArr[0]);
				survivorshipConfig.setUsageType(partyRuleArr[1]);
				survivorshipConfig.setLastVerifiedFld(partyRuleArr[2]);

				String[] srcPriOrderArr = partyRuleArr[3].split(",");
				HashMap<String, Integer> srcPriOrderMap = new HashMap<String, Integer>();
				int counter = 99;

				// put the sources in a map and assign a priority to it
				for (String source : srcPriOrderArr) {
					counter--;
					srcPriOrderMap.put(source, counter);
				}

				survivorshipConfig.setSourcePriorityMap(srcPriOrderMap);

				survivorshipConfig.setSurvivorFlds(partyRuleArr[4].split(","));

				if(!this.survivorshipConfigs.containsKey("TCRMPartyValueBObj|"+partyRuleArr[1])){
					survivorshipConfigs.put("TCRMPartyValueBObj|"+partyRuleArr[1], new ArrayList<SurvivorshipConfigObj>());
				}

				survivorshipConfigs.get("TCRMPartyValueBObj|"+partyRuleArr[1]).add(survivorshipConfig);

			}
		}

		for(int x = 0; x < 40; x++){
			SurvivorshipConfigObj survivorshipConfig = new SurvivorshipConfigObj();
			String rule = null;

			if(CommonUtil.isConfigOptionPresent("Survivorship/XNWPartyAddressBObjExt/"+x))
				rule = Configuration.getConfiguration()
				.getConfigItem("Survivorship/XNWPartyAddressBObjExt/"+x, objDWLControl.retrieveConfigContext())
				.getValue();

			if(rule != null){
				String[] partyRuleArr = rule.split("\\|");
				survivorshipConfig.setSourceFld(partyRuleArr[0]);
				survivorshipConfig.setUsageType(partyRuleArr[1]);
				survivorshipConfig.setLastVerifiedFld(partyRuleArr[2]);

				String[] srcPriOrderArr = partyRuleArr[3].split(",");
				HashMap<String, Integer> srcPriOrderMap = new HashMap<String, Integer>();
				int counter = 99;

				// put the sources in a map and assign a priority to it
				for (String source : srcPriOrderArr) {
					counter--;
					srcPriOrderMap.put(source, counter);
				}

				survivorshipConfig.setSourcePriorityMap(srcPriOrderMap);

				survivorshipConfig.setSurvivorFlds(partyRuleArr[4].split(","));

				if(!this.survivorshipConfigs.containsKey("XNWPartyAddressBObjExt|"+partyRuleArr[1])){
					survivorshipConfigs.put("XNWPartyAddressBObjExt|"+partyRuleArr[1], new ArrayList<SurvivorshipConfigObj>());
				}

				survivorshipConfigs.get("XNWPartyAddressBObjExt|"+partyRuleArr[1]).add(survivorshipConfig);

			}
		}

		for(int x = 0; x < 40; x++){
			SurvivorshipConfigObj survivorshipConfig = new SurvivorshipConfigObj();
			String rule = null;

			if(CommonUtil.isConfigOptionPresent("Survivorship/TCRMPartyContactMethodBObj/"+x))
				rule = Configuration.getConfiguration()
				.getConfigItem("Survivorship/TCRMPartyContactMethodBObj/"+x, objDWLControl.retrieveConfigContext())
				.getValue();

			if(rule != null){
				String[] partyRuleArr = rule.split("\\|");
				survivorshipConfig.setSourceFld(partyRuleArr[0]);
				survivorshipConfig.setUsageType(partyRuleArr[1]);
				survivorshipConfig.setLastVerifiedFld(partyRuleArr[2]);

				String[] srcPriOrderArr = partyRuleArr[3].split(",");
				HashMap<String, Integer> srcPriOrderMap = new HashMap<String, Integer>();
				int counter = 99;

				// put the sources in a map and assign a priority to it
				for (String source : srcPriOrderArr) {
					counter--;
					srcPriOrderMap.put(source, counter);
				}

				survivorshipConfig.setSourcePriorityMap(srcPriOrderMap);

				survivorshipConfig.setSurvivorFlds(partyRuleArr[4].split(","));

				if(!this.survivorshipConfigs.containsKey("TCRMPartyContactMethodBObj|"+partyRuleArr[1])){
					survivorshipConfigs.put("TCRMPartyContactMethodBObj|"+partyRuleArr[1], new ArrayList<SurvivorshipConfigObj>());
				}

				survivorshipConfigs.get("TCRMPartyContactMethodBObj|"+partyRuleArr[1]).add(survivorshipConfig);

			}
		}

		for(int x = 0; x < 40; x++){
			SurvivorshipConfigObj survivorshipConfig = new SurvivorshipConfigObj();
			String rule = null;

			if(CommonUtil.isConfigOptionPresent("Survivorship/XNWPersonNameBObjExt/"+x))
				rule = Configuration.getConfiguration()
				.getConfigItem("Survivorship/XNWPersonNameBObjExt/"+x, objDWLControl.retrieveConfigContext())
				.getValue();

			if(rule != null){
				String[] partyRuleArr = rule.split("\\|");
				survivorshipConfig.setSourceFld(partyRuleArr[0]);
				survivorshipConfig.setUsageType(partyRuleArr[1]);
				survivorshipConfig.setLastVerifiedFld(partyRuleArr[2]);

				String[] srcPriOrderArr = partyRuleArr[3].split(",");
				HashMap<String, Integer> srcPriOrderMap = new HashMap<String, Integer>();
				int counter = 99;

				// put the sources in a map and assign a priority to it
				for (String source : srcPriOrderArr) {
					counter--;
					srcPriOrderMap.put(source, counter);
				}

				survivorshipConfig.setSourcePriorityMap(srcPriOrderMap);

				survivorshipConfig.setSurvivorFlds(partyRuleArr[4].split(","));

				if(!this.survivorshipConfigs.containsKey("XNWPersonNameBObjExt|"+partyRuleArr[1])){
					survivorshipConfigs.put("XNWPersonNameBObjExt|"+partyRuleArr[1], new ArrayList<SurvivorshipConfigObj>());
				}

				survivorshipConfigs.get("XNWPersonNameBObjExt|"+partyRuleArr[1]).add(survivorshipConfig);

			}
		}

		for(int x = 0; x < 40; x++){
			SurvivorshipConfigObj survivorshipConfig = new SurvivorshipConfigObj();
			String rule = null;

			if(CommonUtil.isConfigOptionPresent("Survivorship/XNWPersonBObjExt/"+x))
				rule = Configuration.getConfiguration()
				.getConfigItem("Survivorship/XNWPersonBObjExt/"+x, objDWLControl.retrieveConfigContext())
				.getValue();

			if(rule != null){
				String[] partyRuleArr = rule.split("\\|");
				survivorshipConfig.setSourceFld(partyRuleArr[0]);
				survivorshipConfig.setLastVerifiedFld(partyRuleArr[2]);

				String[] srcPriOrderArr = partyRuleArr[3].split(",");
				HashMap<String, Integer> srcPriOrderMap = new HashMap<String, Integer>();
				int counter = 99;

				// put the sources in a map and assign a priority to it
				for (String source : srcPriOrderArr) {
					counter--;
					srcPriOrderMap.put(source, counter);
				}

				survivorshipConfig.setSourcePriorityMap(srcPriOrderMap);

				survivorshipConfig.setSurvivorFlds(partyRuleArr[4].split(","));

				if(!this.survivorshipConfigs.containsKey("XNWPersonBObjExt")){
					survivorshipConfigs.put("XNWPersonBObjExt", new ArrayList<SurvivorshipConfigObj>());
				}

				survivorshipConfigs.get("XNWPersonBObjExt").add(survivorshipConfig);

			}
		}

		survivorshipConfigsSet = true;

		logger.info("CollapsePartiesWithRules - SurvivorshipRulesSet: true");
		Long endTime = System.currentTimeMillis();
		logger.info("Set survivor configs start: " + endTime);
		Long duration = endTime - startTime;
		logger.info("Set survivor configs duration: " + duration);
	}

	// set a flag to indicate that survivorship configuartions have been retreived and set
	public boolean areSurvivorshipConfigsSet(){
		return survivorshipConfigsSet;
	}
}
