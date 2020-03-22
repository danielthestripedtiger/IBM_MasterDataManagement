package mdmnw.externalrule;

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
import com.dwl.tcrm.coreParty.component.TCRMAdminContEquivBObj;
import com.dwl.tcrm.coreParty.component.TCRMContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyAddressBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyIdentificationBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonNameBObj;
import com.dwl.tcrm.coreParty.constant.TCRMCoreComponentID;
import com.dwl.tcrm.coreParty.constant.TCRMCoreErrorReasonCode;
import com.dwl.tcrm.coreParty.constant.TCRMCorePropertyKeys;
import com.dwl.tcrm.coreParty.interfaces.IParty;
import com.dwl.tcrm.utilities.TCRMClassFactory;

/**
 * BassProCollapsePartiesWithRules collapses party1 and party2 parties to create new party.
 * Unique data in party1 and party2 are survived in new party.
 * In case of duplicate data the most recent one is survived.
 * Business keys are used to identify duplicates
 *
 * 
 */
public class CollapsePartiesWithRulesOriginal extends Rule {
	   
		protected final static IDWLLogger logger = DWLLoggerManager.getLogger(CollapsePartiesWithRulesOriginal.class);

		protected String ruleName = "BassProCollapsePartiesWithRules";
		protected String debugStr = "External Java Rule 38 " + ruleName + ": ";
		

		/**
		 * This is the main method in BassProCollapsePartiesWithRules retrieves Party 1 and 
		 * party 2 from input invokes individual business object collapse method to
		 * collapse data, create new party with survived data from party1 and party2 and return new party.
		 * 
		 * @param input
		 * @param componentObject
		 * @return vector newPartyBobj 
		 * @throws Exception	 
		 */
		public Object execute(Object input, Object componentObject)
				throws Exception {			

			Vector vecParties = (Vector) input;

			IParty partyComp = (IParty) TCRMClassFactory
					.getTCRMComponent(TCRMCorePropertyKeys.PARTY_COMPONENT);

			DWLStatus status = new DWLStatus();
			status.setStatus(DWLStatus.SUCCESS);
			TCRMPartyBObj outputParty = null;
			Vector vecRet = new Vector();
			TCRMPartyBObj objParty1BObj = null;
			TCRMPartyBObj objParty2BObj = null;
			TCRMPartyBObj newPartyBobj = null;
			DWLControl objDWLControl = null;

			try {
								
				objParty1BObj = (TCRMPartyBObj) vecParties.elementAt(0);
				objParty2BObj = (TCRMPartyBObj) vecParties.elementAt(1);
				
				objDWLControl = objParty1BObj.getControl();
				
				newPartyBobj = new TCRMPersonBObj();
				
				
				Vector <TCRMPartyIdentificationBObj> vecParty1Identification =  objParty1BObj.getItemsTCRMPartyIdentificationBObj();
				Vector <TCRMPartyIdentificationBObj> vecParty2Identification =  objParty2BObj.getItemsTCRMPartyIdentificationBObj();			  
				mergePartyIdentificationBObj(vecParty1Identification, vecParty2Identification, newPartyBobj);
				
				Vector <TCRMPartyAddressBObj> vecParty1Addr = objParty1BObj.getItemsTCRMPartyAddressBObj();
				Vector <TCRMPartyAddressBObj> vecParty2Addr = objParty2BObj.getItemsTCRMPartyAddressBObj();			  
				mergePartyAddressBObj(vecParty1Addr, vecParty2Addr, newPartyBobj);
				
			    Vector <TCRMPartyContactMethodBObj> vecParty1ContMeth = objParty1BObj.getItemsTCRMPartyContactMethodBObj();
				Vector <TCRMPartyContactMethodBObj> vecParty2ContMeth = objParty2BObj.getItemsTCRMPartyContactMethodBObj();			  
				mergePartyContactMethodBObj(vecParty1ContMeth, vecParty2ContMeth, newPartyBobj);
				
				Vector <TCRMAdminContEquivBObj> vecParty1AdminContEquiv = ((IParty) partyComp).getAllPartyAdminSysKeys(objParty1BObj.getPartyId(), objDWLControl);
				Vector <TCRMAdminContEquivBObj> vecParty2AdminContEquiv = ((IParty) partyComp).getAllPartyAdminSysKeys(objParty2BObj.getPartyId(), objDWLControl);																								    			  
				mergeAdminContEquivBObj(vecParty1AdminContEquiv,vecParty2AdminContEquiv, newPartyBobj);				
								
				if(objParty1BObj instanceof TCRMPersonBObj)
				{
					TCRMPersonBObj objPerson1BObj = (TCRMPersonBObj)objParty1BObj;
					TCRMPersonBObj objPerson2BObj = (TCRMPersonBObj)objParty2BObj;
					
					mergePersonBObj((TCRMPersonBObj)objParty1BObj, (TCRMPersonBObj)objParty2BObj, (TCRMPersonBObj)newPartyBobj);
					
				    Vector <TCRMPersonNameBObj>  vecPerson1Name = objPerson1BObj.getItemsTCRMPersonNameBObj();			  
					Vector <TCRMPersonNameBObj> vecPerson2Name = objPerson2BObj.getItemsTCRMPersonNameBObj();
					
					mergePersonNameBObj(vecPerson1Name,vecPerson2Name, (TCRMPersonBObj)newPartyBobj);				
					
				}
																				
			} catch (DWLBaseException ex) {	            
				logger.error("DWLBaseException in execute method of BassProCollapsePartiesWithRules == "+ex.toString());
	            com.dwl.base.util.DWLExceptionUtils.log(ex);
				status = ex.getStatus();
			} catch (Exception ex) {
				logger.error("Exception in execute method of BassProCollapsePartiesWithRules == "+ex.toString());	            
	            com.dwl.base.util.DWLExceptionUtils.log(ex);
				status = addError(
						objDWLControl,
						TCRMErrorCode.READ_RECORD_ERROR,
						TCRMCoreErrorReasonCode.COLLAPSE_PARTIES_SURVIVING_RULES_FAILED,
						ex.getMessage());
			}

			vecRet.addElement(status);
			vecRet.addElement(newPartyBobj);
			
			return vecRet;
		}
	

	

		
	
	 /**
	 * This method collapses Party 1 and Party 2 PartyIdentification business objects.
	 * Survive all Identification Object
	 * 
	 * @param vector sourcePartyIdentificationBObj
	 * @param vector targetPartyIdentificationBObj
	 * @param newOrgBobj
	 * @return  
	 * @throws Exception	 
	 * 
	 * Notes : designate one of those as default outdoor rewards number - 
	 */			  
	 private void mergePartyIdentificationBObj(Vector <TCRMPartyIdentificationBObj> vecParty1ID, Vector <TCRMPartyIdentificationBObj> vecParty2ID, TCRMPartyBObj newPartyBobj) throws Exception
	 {			 
		 Vector <TCRMPartyIdentificationBObj> vecMergedPartyID = new Vector();
		 boolean blnMatch = false; 
		 
		 TCRMPartyIdentificationBObj party1DefaultBPSID = null;
		 TCRMPartyIdentificationBObj party2DefaultBPSID = null;
		 String strParty1OutRewardsStatus = null;
		 String strParty2OutRewardsStatus = null;
		 
		 if(!vecParty1ID.isEmpty())
		 {
			 vecMergedPartyID.addAll(vecParty1ID);
		 }
		 
		 if(!vecParty2ID.isEmpty())
		 {

			 vecMergedPartyID.addAll(vecParty2ID);
		 }
		 		 

		 for(int x=0; x< vecMergedPartyID.size(); x++)
		 {
			
			TCRMPartyIdentificationBObj mergedPartyIdentificationBObj = vecMergedPartyID.get(x);
			mergedPartyIdentificationBObj.setPartyId(null);
			mergedPartyIdentificationBObj.setIdentificationIdPK(null);
			mergedPartyIdentificationBObj.setPartyIdentificationLastUpdateDate(null);
			
			System.out.println(" mergedPartyIdentificationBObj == " +mergedPartyIdentificationBObj.toXML());
											
			newPartyBobj.setTCRMPartyIdentificationBObj(mergedPartyIdentificationBObj);				
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
	 private void mergePartyAddressBObj(Vector <TCRMPartyAddressBObj> vecParty1Addr, Vector <TCRMPartyAddressBObj> vecParty2Addr, TCRMPartyBObj newPartyBobj) throws Exception
	 {
		 
		 Vector <TCRMPartyAddressBObj> vecMergedPartyAddr = new Vector<TCRMPartyAddressBObj>();
		 Vector <TCRMPartyAddressBObj> vecShipToAddr = new Vector<TCRMPartyAddressBObj>();
		 boolean blnMatch = false; 
		 
		 vecShipToAddr = removeShipTOAddress(vecParty1Addr, vecParty2Addr);
		 
		 for(int i=0; i < vecParty1Addr.size(); i++)
		 {			 				 
	 		TCRMPartyAddressBObj party1AddrBobj =  vecParty1Addr.get(i);
			String strParty1AddrUsageTp = party1AddrBobj.getAddressUsageType();
			blnMatch = false; 
			
			for(int j=0; j < vecParty2Addr.size(); j++)			
			{
				TCRMPartyAddressBObj party2AddrBobj = vecParty2Addr.get(j);
				String strParty2AddrUsageTp = party2AddrBobj.getAddressUsageType();
				 
				 if(strParty1AddrUsageTp.equals(strParty2AddrUsageTp))
				 {										 					 
					 if(party1AddrBobj.getLocationGroupLastUpdateDate().compareTo(party2AddrBobj.getLocationGroupLastUpdateDate()) > 0)
					 {
						 vecMergedPartyAddr.add(party1AddrBobj);
						 vecParty2Addr.remove(party2AddrBobj);
						 j--;
					 }
					blnMatch = true;							
				 }
			}
			if(!blnMatch)
			{
				vecMergedPartyAddr.add(party1AddrBobj);
			}
		}
		 			 
	 	for(int k=0; k  < vecParty2Addr.size(); k++)
	 	{
	 		vecMergedPartyAddr.add(vecParty2Addr.get(k));
	 	}
	 	
	 	vecShipToAddr = mergeShipToAddress(vecShipToAddr);
	 	if(!vecShipToAddr.isEmpty())
	 	{
	 		vecMergedPartyAddr.addAll(vecShipToAddr);
	 	}
	 	
		for(int x=0; x< vecMergedPartyAddr.size(); x++)
		{
			
			TCRMPartyAddressBObj mergedPartyAddrBobj = vecMergedPartyAddr.get(x);			
			mergedPartyAddrBobj.setAddressId(null);
			mergedPartyAddrBobj.setPartyId(null);
			mergedPartyAddrBobj.setPartyAddressIdPK(null);
			
			mergedPartyAddrBobj.setLocationGroupLastUpdateDate(null);
			mergedPartyAddrBobj.setAddressGroupLastUpdateDate(null);
			mergedPartyAddrBobj.getTCRMAddressBObj().setAddressLastUpdateDate(null);
			
			mergedPartyAddrBobj.getTCRMAddressBObj().setAddressIdPK(null);												
			newPartyBobj.setTCRMPartyAddressBObj(mergedPartyAddrBobj);				
		}
		 		 
	 }
	 
 	/**
	 *This method removes ship to address from old party address
	 * 
	 * @param vector vecParty1Addr
	 * @param vector vecParty2Addr	
	 * @return  Vector vecShipToAddr
	 * @throws Exception	 
	 */		 	 
	 public Vector removeShipTOAddress(Vector <TCRMPartyAddressBObj> vecParty1Addr, Vector <TCRMPartyAddressBObj> vecParty2Addr) throws Exception
	 {		
		 
		 Vector <TCRMPartyAddressBObj> vecShipToAddr = new Vector<TCRMPartyAddressBObj>();
		 
		 for(int i=0; i < vecParty1Addr.size(); i++)
		 {			 				 
	 		TCRMPartyAddressBObj party1AddrBobj =  vecParty1Addr.get(i);
			String strParty1AddrUsageTp = party1AddrBobj.getAddressUsageType();
			
//			if(CustHubConstant.SHIP_TO_ADDR_TP.equals(strParty1AddrUsageTp))
//			{				
//				vecShipToAddr.add(party1AddrBobj);
//				vecParty1Addr.remove(i);
//				i--;
//			}
		 }
		 
//		 for(int i=0; i < vecParty2Addr.size(); i++)
//		 {			 				 
//	 		TCRMPartyAddressBObj party2AddrBobj =  vecParty2Addr.get(i);
//			String strParty2AddrUsageTp = party2AddrBobj.getAddressUsageType();
//			
//			if(CustHubConstant.SHIP_TO_ADDR_TP.equals(strParty2AddrUsageTp))
//			{				
//				vecShipToAddr.add(party2AddrBobj);
//				vecParty2Addr.remove(i);
//				i--;
//			}
//		 }
		 
		 return vecShipToAddr;
	 }
	 
 	/**
	 *This method removes duplicate ship to address from collection
	 * 
	 * @param vector vecParty1Addr
	 * @param vector vecParty2Addr	
	 * @return  Vector vecShipToAddr
	 * @throws Exception	 
	 */	 
	 public Vector mergeShipToAddress(Vector <TCRMPartyAddressBObj> vecShipToAddr) throws Exception
	 {
		 Vector <TCRMPartyAddressBObj> vecMergedShipToAddr = new Vector<TCRMPartyAddressBObj>(); 
		 
		 for(int i=0; i < vecShipToAddr.size(); i++)
		 {
			 for(int j=i+1; j<vecShipToAddr.size(); j++)
			 {
//				 if(CustHubCommonUtils.isAddressEqual(vecShipToAddr.get(i),vecShipToAddr.get(j)))
//				 {
//					 String strLastUsedDatei =  ((TCRMPartyAddressBObj)vecShipToAddr.get(i)).getLastUsedDate();
//					 String strLastUsedDatej =  ((TCRMPartyAddressBObj)vecShipToAddr.get(j)).getLastUsedDate();
//					 
//					 if(strLastUsedDatei != null && strLastUsedDatej != null)
//					 {
//						 //J greater than i
//						 if(strLastUsedDatei.compareTo(strLastUsedDatej) < 0)
//						 {
//							 ((TCRMPartyAddressBObj)vecShipToAddr.get(i)).setLastUsedDate(strLastUsedDatej); 
//						 }
//					 }
//					 vecShipToAddr.remove(j);
//					 j--;
//				 }		 
			 }
		 }
		 
		 return vecShipToAddr;
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
	 * @return  
	 * @throws Exception	 
	 */		 
	 private void mergePartyContactMethodBObj(Vector <TCRMPartyContactMethodBObj> vecParty1ContMeth,  Vector <TCRMPartyContactMethodBObj> vecParty2ContMeth, TCRMPartyBObj newPartyBobj)throws Exception
	 {
		 
		 Vector <TCRMPartyContactMethodBObj> vecMergedContMeth = new Vector();
		 boolean blnMatch = false; 
		 
		 	for(int i=0; i < vecParty1ContMeth.size(); i++)
		 	{			 				 
		 		TCRMPartyContactMethodBObj party1ContMethBobj =  vecParty1ContMeth.get(i);
				String strParty1ContMethUsageTp = party1ContMethBobj.getContactMethodUsageType();
				blnMatch = false; 
				
				for(int j=0; j < vecParty2ContMeth.size(); j++)			
				{
					TCRMPartyContactMethodBObj party2ContMethBobj = vecParty2ContMeth.get(j);
					String strParty2ContMethUsageTp = party2ContMethBobj.getContactMethodUsageType();
					 
					if(strParty1ContMethUsageTp.equals(strParty2ContMethUsageTp))
					{
						 TCRMContactMethodBObj contMethParty1 = party1ContMethBobj.getTCRMContactMethodBObj();
						 TCRMContactMethodBObj contMethParty2 = party2ContMethBobj.getTCRMContactMethodBObj(); 
						 
						 if(contMethParty1.getContactMethodType().equals(contMethParty2.getContactMethodType()))
						 {							 
							 if(contMethParty1.getContactMethodLastUpdateDate().compareTo(contMethParty2.getContactMethodLastUpdateDate()) > 0)
							 {
								 vecMergedContMeth.add(party1ContMethBobj);
								 vecParty2ContMeth.remove(party2ContMethBobj);
								 j--;
							 }
							blnMatch = true;
						 }						 						 							
					 }
				}
				if(!blnMatch)
				{
					vecMergedContMeth.add(party1ContMethBobj);
				}
			}
		 			 
		 	for(int k=0; k  < vecParty2ContMeth.size(); k++)
		 	{
		 		vecMergedContMeth.add(vecParty2ContMeth.get(k));
		 	}
		 	
			for(int x=0; x< vecMergedContMeth.size(); x++)
			{
				
				TCRMPartyContactMethodBObj mergedPartyContMethBobj = vecMergedContMeth.get(x);
				mergedPartyContMethBobj.setContactMethodId(null);
				mergedPartyContMethBobj.setPartyId(null);
				mergedPartyContMethBobj.setPartyContactMethodIdPK(null);
				
				mergedPartyContMethBobj.setContactMethodGroupLastUpdateDate(null);
				mergedPartyContMethBobj.setLocationGroupLastUpdateDate(null);
				mergedPartyContMethBobj.getTCRMContactMethodBObj().setContactMethodLastUpdateDate(null);
				
				mergedPartyContMethBobj.getTCRMContactMethodBObj().setContactMethodIdPK(null);												
				newPartyBobj.setTCRMPartyContactMethodBObj(mergedPartyContMethBobj);				
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
	 * @return  
	 * @throws Exception	 
	 */	 
	 private void mergePersonNameBObj(Vector <TCRMPersonNameBObj> vecParty1Name, Vector <TCRMPersonNameBObj> vecParty2Name, TCRMPersonBObj newPersonBObj)throws Exception
	 {
		 
		 Vector <TCRMPersonNameBObj> vecMergedPersonName = new Vector();
		 boolean blnMatch = false; 
		 
		 for(int i=0; i < vecParty1Name.size(); i++)
		 {			 				 
	 		TCRMPersonNameBObj party1NameBobj =  vecParty1Name.get(i);
			String strParty1NameUsageTp = party1NameBobj.getNameUsageType();
			blnMatch = false; 
			
			for(int j=0; j < vecParty2Name.size(); j++)			
			{
				TCRMPersonNameBObj party2NameBobj = vecParty2Name.get(j);
				String strParty2NameUsageTp = party2NameBobj.getNameUsageType();
				 
				 if(strParty1NameUsageTp.equals(strParty2NameUsageTp))
				 {					 					 
					 if(party1NameBobj.getPersonNameLastUpdateDate().compareTo(party2NameBobj.getPersonNameLastUpdateDate()) > 0)
					 {
						 vecMergedPersonName.add(party1NameBobj);
						 vecParty2Name.remove(party2NameBobj);
						 j--;
					 }
					blnMatch = true;							
				 }
			}
			if(!blnMatch)
			{
				vecMergedPersonName.add(party1NameBobj);
			}
		}
		 			 
	 	for(int k=0; k  < vecParty2Name.size(); k++)
	 	{
	 		vecMergedPersonName.add(vecParty2Name.get(k));
	 	}
	 	
		for(int x=0; x< vecMergedPersonName.size(); x++)
		{
			
			TCRMPersonNameBObj mergedPersonNameBobj = vecMergedPersonName.get(x);
			mergedPersonNameBobj.setContId(null);
			mergedPersonNameBobj.setLastUpdatedDate(null);
			mergedPersonNameBobj.setPersonNameIdPK(null);
																	
			newPersonBObj.setTCRMPersonNameBObj(mergedPersonNameBobj);				
		}
		 		 
	 }	 
	
   /**
	 * This method collapses Party 1 and Party 2 person business objects.
	 * LUD is used to determine which one to survive.
	 * 
	 * @param vector sourcePartyIdentificationBObj
	 * @param vector targetPartyIdentificationBObj
	 * @param newOrgBobj
	 * @return  
	 * @throws Exception	 
	*/		
   private void mergePersonBObj(TCRMPersonBObj party1PersonBObj, TCRMPersonBObj party2PersonBObj, TCRMPersonBObj newPersonBobj) throws Exception
   {	   
	   if(party1PersonBObj.getPersonLastUpdateDate().compareTo(party2PersonBObj.getPersonLastUpdateDate()) > 0)
	   {
		   newPersonBobj.setBirthDate(party1PersonBObj.getBirthDate());
		   newPersonBobj.setGenderType(party1PersonBObj.getGenderType());
		   newPersonBobj.setCreatedDate(party1PersonBObj.getCreatedDate());
		   newPersonBobj.setPartyType(party1PersonBObj.getPartyType());
		   
	   }else{
		   newPersonBobj.setBirthDate(party2PersonBObj.getBirthDate());
		   newPersonBobj.setGenderType(party2PersonBObj.getGenderType());
		   newPersonBobj.setCreatedDate(party2PersonBObj.getCreatedDate());
		   newPersonBobj.setPartyType(party2PersonBObj.getPartyType());
	   }	   
	   newPersonBobj.setControl(party1PersonBObj.getControl());
   }
		 
	 
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
	 
}
