package mdmnw.constant;

import java.util.Vector;

public interface MdmConstants {
	
	public final static String SOURCE_CXH = "100001";
	public final static String SOURCE_NOT_ALLOWED_TO_UPDATE = "ARS";
	
	public final static String EMPLOYEE = "Employee";
	public final static String BRANCH = "Branch";
	public final static String DIVISION = "Division";
	public final static String REGION = "Region";
	
	public final static String ORG_TYPE_BRANCH = "100001";
	public final static String ORG_TYPE_DIVISION = "100002";
	public final static String ORG_TYPE_REGION = "100003";
	
	public final static String EID_TYPE = "100001";
	public final static String EID_VALUE = "EID";
	public final static String EMPLOYEE_ID_TYPE_VALUE = "Employee ID";
	public final static String SALES_REP_ID_TYPE_VALUE = "Sales Rep ID";
	public final static String BRANCH_ID_TYPE_VALUE = "Branch Number";
	public final static String DIVISION_ID_TYPE_VALUE = "Division Number";
	public final static String REGION_ID_TYPE_VALUE = "Region Number";
	
	public final static String ID_STATUS_ACTIVE = "2";
	
	public final static String REL_MANAGE_TYPE = "100001";
	public final static String REL_BRANCH_OF_TYPE = "100002";
	public final static String REL_BRANCH_OF_VALUE = "Branch of";
	public final static String REL_DIVISION_OF_TYPE = "100003";
	public final static String REL_DIVISION_OF_VALUE = "Division of";
	
	public final static String TXN_ADDPERSON = "addPerson";
	public final static String TXN_UPDATEPERSON = "updatePerson";
	
	public final static String TXN_ADDORG = "addOrganization";
	public final static String TXN_UPDATEORG = "updateOrganization";
	
	public final static String TXN_ADDPARTYREL = "addPartyRelationship";
	public final static String TXN_ADDPARTYIDENTIFICATION = "addPartyIdentification";
	
	public final static String TXN_GETPERSON = "getPerson";
	public final static String TXN_GETORG = "getOrganization";
	
	public final static String TXN_GETPARTYWCONTRACTS = "getPartyWithContracts";
	public final static String TXN_GETCONTRACTPARTYROLE = "getContractPartyRole";
	
	public final static String INQRY_LVL_0 = "0";
	public final static String INQRY_LVL_1 = "1";
	public final static String INQRY_LVL_2 = "2";
	public final static String INQRY_LVL_3 = "3";
	public final static String INQRY_LVL_4 = "4";
	public final static String INQRY_LVL_5 = "5";
	
	public final static String CONTR_CURR_VAL = "Unknown";

	public final static String CONTR_STATUS_VAL = "Active";
	
	public final static String CONTR_COMP_PROD_TP = "Not Applicable";
	
	public final static String TXN_ADDCONTRACT = "addContract";
	public final static String TXN_UPDATECONTRACT = "updateContract";
	
	public final static String TXN_ADDCONTRACTCOMPONENT = "addContractComponent";
	public final static String TXN_ADDCONTRACTPARTYROLE = "addContractPartyRole";
	public final static String TXN_UPDATECONTRACTPARTYROLE = "updateContractPartyRole";
	
	public final static String BILLING_ADDRESS = "Billing";
	public final static String SHIPPING_ADDRESS = "Shipping";
	
	public final static String PREFERRED_EMAIL = "Preferred Email";
	public final static String TELEPHONE_NUMBER = "Telephone Number";
	public final static String US_CAN_COUNTRY_CODE = "+1";
	
	// Retrieve Account Txn Constants
	public final static String TXN_GETCONTRACT = "getContract";
	
	public final static String ROLE_ALL = "All";
	public final static String ROLE_OWNER = "Owner";
	public final static String ROLE_MANAGES = "Manages";
	public final static String ROLE_MANAGED_BY = "Managed By";
	public final static String ROLE_ACCOUNT_INFO = "Account Information";
	
	public final static String ROLE_OWNER_TYPE = "100001";
	public final static String ROLE_BRANCH_TYPE = "100003";
	public final static String ROLE_SALES_REP_TYPE = "100004";
	
	public final static String CLIENT_STATUS_TP_ACTIVE = "1";

	public final static String MEMGET_SRC_CODE = "PPLSFT";
	public final static String MEMGET_MEM_TYPE = "Customer";
	public final static String MEMGET_ENT_TYPE = "account";
	public final static String MEMGET_CVW_NAME = "SourcePriorityEnhanced";
	public final static String MEMGET_REC_STAT_FILTER = "A";
	public final static String MEMGET_SEG_CODE_FILTER = "MEMHEAD,MEMATTR,MEMCODE,MEMNAME,MEMADDREXT,MEMID";

	public final static String AGREEMENT_STATUS_BAD_DEBT = "Bad Debt";
	
	public final static String MDM_READONLY_USERNAME = "mdmreadonly";
	public final static String MDM_READONLY_PASSWORD = "mdmreadonly";
	public final static int WC_DEFAULTHOST_PORT = 9080;
	
	// Maintain Privacy Preference Txn Constants
	public final static String PRIV_PREF_REASON = "Unspecified";
	public final static String PRIV_PREF_VALUE_STR_NO = "No";
	public final static String PRIV_PREF_CAT_PARTY = "100001";
	public final static String PRIV_PREF_CAT_CM = "100003";
	
	public final static String ROLE_END_REASON = "Retired";

}
