package mdmnw.externalrule;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.dwl.base.DWLControl;
import com.dwl.base.IDWLErrorMessage;
import com.dwl.base.error.DWLError;
import com.dwl.base.error.DWLStatus;
import com.dwl.base.exception.DWLBaseException;
import com.dwl.base.externalrule.Rule;
import com.dwl.base.logging.DWLLoggerManager;
import com.dwl.base.logging.IDWLLogger;
import com.dwl.tcrm.common.TCRMErrorCode;
import com.dwl.tcrm.common.TCRMRecordFilter;
import com.dwl.tcrm.coreParty.component.TCRMPartyBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyListBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyRelationshipBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyRelationshipRoleBObj;
import com.dwl.tcrm.coreParty.constant.TCRMCoreComponentID;
import com.dwl.tcrm.coreParty.constant.TCRMCoreErrorReasonCode;
import com.dwl.tcrm.coreParty.constant.TCRMCorePropertyKeys;
import com.dwl.tcrm.coreParty.interfaces.IParty;
import com.dwl.tcrm.coreParty.interfaces.IPartyBusinessServices;
import com.dwl.tcrm.utilities.TCRMClassFactory;

public class CollapseMultiplePartiesRule extends Rule {
    public static final String copyright =  "Licensed Materials -- Property of IBM\n(c) Copyright IBM Corp. 2006, 2011, 2013\nUS Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.";


	protected final static IDWLLogger logger = DWLLoggerManager
			.getLogger(CollapseMultiplePartiesRule.class);

	protected String ruleName = "CollapseMultiplePartiesRule";

	protected String debugStr = "External Java Rule 119 " + ruleName + ": ";

	private boolean bCollapsePartiesAdminContEquiv;

	private boolean bCollapsePartiesAlerts = true;

	private boolean bCollapsePartiesRelationships = true;

	IParty partyComp = null;

	/**
	 * 
	 * NOTE: This class collapses multiple parties
	 * 			It simply uses the CollapsePartiesWithRules clases and applies it to multiple records using a loop
	 * 
	 * @param input
	 *            A vector of <code>TCRMPartyBObj</code> suspect parties passed by 
	 *            the caller.
	 * @param componentObject
	 *            ISuspectProcessor
	 * 
	 * @return A Vector containing instances of TCRMSuspectBObj and DWLStatus.
	 */
	public Object execute(Object input, Object componentObject)
			throws Exception {
		if (logger.isFineEnabled()){
			logger.fine(debugStr + "Entering Rule");
		}

		Vector vecParties = (Vector) input;

		// The last element is bPreview, get it and remove it from vecParties
		Boolean bPreviewTrans = (Boolean) vecParties.elementAt(vecParties
				.size() - 1);
		boolean bPreview = bPreviewTrans.booleanValue();
		vecParties.removeElementAt(vecParties.size() - 1);

		partyComp = (IParty) TCRMClassFactory
				.getTCRMComponent(TCRMCorePropertyKeys.PARTY_COMPONENT);

		DWLStatus status = ((TCRMPartyBObj) vecParties.elementAt(0))
				.getStatus();

		TCRMPartyBObj collapsedPartyBObj = null;

		Vector vecRet = new Vector();
		DWLControl dwlControl = null;

		try {
			// 1. Party relationship will not be collapsed; so before collapse
			// the parties, save party relationships of all parties
			// participating
			// in collapsing, and remove them from the parties; after
			// collapsing, put them back to the parties
			Vector vecAllRels = new Vector();
			Map hmRelationships = new HashMap();
			Vector tmpRel = new Vector();

			// 1.1 Remove all party relationships from each partyBObj and save
			// them in a hashmap before collapsing parties
			TCRMPartyBObj tmpPartyBObj = null;
			
			TCRMPartyListBObj objPartyList = new TCRMPartyListBObj();

			collapsedPartyBObj = (TCRMPartyBObj) vecParties.elementAt(0);
			
			System.out.println("objPartyList  == " +objPartyList.toXML());
			
			// set up new CollapsePartiesWithRules object
			CollapsePartiesWithRules objRule = new CollapsePartiesWithRules();
		
			// go through all the parties in the vector and apply the CollapsePartiesWithRules survivorship logic to all the parties
			for (int i = 1; i < vecParties.size(); i++) {
				Vector vecInput = new Vector();
				tmpPartyBObj = (TCRMPartyBObj) vecParties.elementAt(i);
				System.out.println("tmpPartyBObj =="+tmpPartyBObj.toXML());
				System.out.println("Cont ID == " +tmpPartyBObj.getPartyId());
				
				vecInput.add(collapsedPartyBObj);
				vecInput.add(tmpPartyBObj);
				
				if(i > 1){
					Boolean dontDoGetPersonForCollapsedObject = true;
					vecInput.add(dontDoGetPersonForCollapsedObject);
				}
				
				Vector objRetVec = (Vector)objRule.execute(vecInput, null);
				
				collapsedPartyBObj = (TCRMPartyBObj) objRetVec.get(1);
			}
			
			String xmlResult = collapsedPartyBObj.toXML();
			System.out.println("collapsedPartyBObj == " +xmlResult);

			// add final collapsed party to return vector
			vecRet.add(collapsedPartyBObj);
			Vector vecPartyRelationshipRoles = new Vector();
			vecRet.add(vecPartyRelationshipRoles);
			
		} catch (DWLBaseException ex) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(ex);
			status = ex.getStatus();
		} catch (Exception ex) {
            // Added by AutomatedFix
            com.dwl.base.util.DWLExceptionUtils.log(ex);
			status = addError(dwlControl, TCRMErrorCode.UPDATE_RECORD_ERROR,
					TCRMCoreErrorReasonCode.COLLAPSE_MULTIPLE_PARTIES_FAILED,
					ex.getMessage());
		}

		// set status on collapsed party after collapsing logic is completed
		collapsedPartyBObj.setStatus(status);

		// return collapsed party vector
		return vecRet;
	}

	/**
	 * @return Holding the error messages if there are any
	 */
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

	/**
	 * @param tmpCollapseAlerts
	 *            Set bCollapseAlerts to "true" if collapse partyAlerts is
	 *            desired otherwsie "false"
	 */
	public void setCollapsedPartiesAlerts(boolean tmpCollapseAlerts) {
		bCollapsePartiesAlerts = tmpCollapseAlerts;
	}

	public boolean isCollapsedPartiesAlerts() {
		return bCollapsePartiesAlerts;
	}

	/**
	 * Set bCollapsePartiesAdminContEquiv to "true" if collapse AdminContEquiv
	 * is desired otherwise "false"
	 */
	public void setCollapsePartiesAdminContEquiv(
			boolean tmpCollapsePartiesAdminContEquiv) {
		bCollapsePartiesAdminContEquiv = tmpCollapsePartiesAdminContEquiv;
	}

	protected boolean isCollapsedPartiesAdminContEquiv() {
		return bCollapsePartiesAdminContEquiv;
	}

	protected boolean isCollapsePartiesRelationships() {
		return bCollapsePartiesRelationships;
	}

	/**
	 * 
	 * @param vecCompleteParties
	 * @param collapsedPartyBObj
	 */
	private TCRMPartyBObj processPartyRelationships(Vector vecCompleteParties,
			TCRMPartyBObj collapsedPartyBObj, IParty partyComp)
			throws Exception {
		// 2.2 Process party relationships of parties involving in collapsing
		// for the new collapsedParty; if thirdPartyBObj is supplied,
		// process all partyRelations within TCRMPartyListBObj, and add them
		// into thirdPartyBObj.

		// 2.2.1 Get all the relationships for the party (when we call
		// getParty() for each party above, we use inquiry level "4",
		// so all the party relationships should be retrieved.

		// Put the partyBObj which has partyRelationship to a separate vector for collapsing party relationships
		TCRMPartyBObj collapsedPartyCandidate = null;
		Vector vecPartiesWithRelationships = new Vector();

		for (int i = 0; i < vecCompleteParties.size(); i++) {
			collapsedPartyCandidate = (TCRMPartyBObj) vecCompleteParties
					.elementAt(i);

			// Save the party which has party relationships to one place
			if (collapsedPartyCandidate.getItemsTCRMPartyRelationshipBObj() != null
					&& collapsedPartyCandidate
							.getItemsTCRMPartyRelationshipBObj().size() > 0) {
				vecPartiesWithRelationships.add(collapsedPartyCandidate);
			}
		}

		// 2.2.2 Collapse party relationships - relinquish reciprocal
		// relationship + repetitive relationships in the case of collapse
		Vector rel = null;

		if (vecPartiesWithRelationships.size() > 0) {
			
			//add source party in the end of vecPartiesWithRelationships
			TCRMPartyBObj sourceParty=(TCRMPartyBObj)vecCompleteParties.get(0);
			vecPartiesWithRelationships.add(sourceParty);
			
			rel = partyComp.collapsePartyRelationshipsSurvivingRules(vecPartiesWithRelationships);
		}

		if (rel != null && rel.size() > 0) {
			collapsedPartyBObj.getItemsTCRMPartyRelationshipBObj().removeAllElements();
			collapsedPartyBObj.getItemsTCRMPartyRelationshipBObj().addAll(rel);
		} else { // If there are no relationships returned, the collapsed bobj should not have any party relationships
			collapsedPartyBObj.getItemsTCRMPartyRelationshipBObj().removeAllElements();
		}

		return collapsedPartyBObj;
	}

	/**
	 * 
	 * Process party relationship roles: get all partyRelationshipRoles and set
	 * each ObjectReferenceId of partyRelationship and its partyRelRole to a
	 * unique value, we will use this unique value to identify which
	 * partyRelRoles belong to its corresponding partyRelationship
	 * 
	 * @param vecAllRels
	 *            Vector
	 * @return Vector
	 * @throws Exception
	 */
	private Vector processPartyRelationshipRoles(Vector vecAllRels)
			throws Exception {
		// 2. Process relationships (relinquish reciprocal relationship +
		// repetitive relationships) and relationship roles

		// 2.1 Process party relationship roles: add party relationship role to
		// the survived party

		// Get the party business component from the Class factory
		IPartyBusinessServices partyBusSvcComp = (IPartyBusinessServices) TCRMClassFactory
				.getTCRMComponent(TCRMCorePropertyKeys.PARTY_BUSINESS_SERVICES_COMPONENT);

		Vector vecPartyRelationshipRoles = new Vector();
		TCRMPartyRelationshipBObj partyRel = null;

		for (int index = 0; (vecAllRels != null && index < vecAllRels.size()); index++) {
			partyRel = (TCRMPartyRelationshipBObj) vecAllRels.elementAt(index);

			if (partyRel != null) {
				// Set object reference id as identifier for roles
				partyRel.setObjectReferenceId(index + "");

				Long aryIds[] = new Long[] {
						partyRel.getEObjContactRel().getFromContId(),
						partyRel.getEObjContactRel().getToContId() };

				Long id = null;
				for (int j = 0; j < aryIds.length; j++) {
					id = aryIds[j];

					if (id != null && id.longValue() != 0) {
						Vector vector = partyBusSvcComp
								.getAllPartyRelationshipRoles(partyRel
										.getPartyRelationshipIdPK(), id
										.toString(), TCRMRecordFilter.ACTIVE,
										partyRel.getControl());

						for (int i = 0; (vector != null && i < vector.size()); i++) {
							// set object reference id same as relationship
							((TCRMPartyRelationshipRoleBObj) vector
									.elementAt(i)).setObjectReferenceId(index
									+ "");
						}

						vecPartyRelationshipRoles.addAll(vector);
					}
				}
			}
		}

		return vecPartyRelationshipRoles;
	}

	/**
	 * @deprecated in 10.0. Please use IDWLLogger instead and follow code convention for logging.
	 * @param str
	 */
	protected void debugOut(String str) {
		System.out.println(str);
	}	
	
}
