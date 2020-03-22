package mdmnw.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import mdmnw.component.XNWAddressBObjExt;
import mdmnw.component.XNWPartyAddressBObjExt;
import mdmnw.component.XNWPersonNameBObjExt;
import mdmnw.constant.MdmConstants;
import mdmnw.exception.CustomMDMException;

import com.dwl.base.DWLControl;
import com.dwl.base.DWLResponse;
import com.dwl.base.IDWLErrorMessage;
import com.dwl.base.db.SQLQuery;
import com.dwl.base.error.DWLError;
import com.dwl.base.error.DWLStatus;
import com.dwl.base.exception.DWLPropertyNotFoundException;
import com.dwl.base.exception.ServiceLocatorException;
import com.dwl.base.requestHandler.DWLTransactionInquiry;
import com.dwl.base.requestHandler.DWLTransactionPersistent;
import com.dwl.base.requestHandler.DWLTxnBP;
import com.dwl.base.util.StringUtils;
import com.dwl.tcrm.common.TCRMCommon;
import com.dwl.tcrm.common.TCRMErrorCode;
import com.dwl.tcrm.coreParty.component.TCRMContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyContactMethodBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyIdentificationBObj;
import com.dwl.tcrm.coreParty.component.TCRMPartyValueBObj;
import com.dwl.tcrm.coreParty.component.TCRMPersonBObj;
import com.dwl.unifi.tx.exception.BusinessProxyException;


public class CommonUtil extends DWLTxnBP implements MdmConstants {

	private final static com.dwl.base.logging.IDWLLogger logger = com.dwl.base.logging.DWLLoggerManager.getLogger(CommonUtil.class);


	/**
	 * This method will get the party IdPk from the supplied admincontractid
	 * 
	 * @param accountId
	 * @return
	 * @throws BusinessProxyException 
	 */
	public static String getPartyIdPkFromSourceId (String source, String idNum) throws BusinessProxyException {

		String partyId = null;
		SQLQuery query = new SQLQuery();
		ResultSet rs = null;

		try {
			rs = query.executeQuery("SELECT ce.CONT_ID FROM CONTEQUIV ce"
					+ " INNER JOIN CDADMINSYSTP ast ON ce.ADMIN_SYS_TP_CD = ast.ADMIN_SYS_TP_CD  "
					+ " INNER JOIN CONTACT c ON ce.CONT_ID = c.CONT_ID "
					+ " WHERE ce.ADMIN_CLIENT_ID = '" + idNum + "' AND ast.NAME='" + source + "' "
							+ "AND (c.INACTIVATED_DT IS NULL OR c.INACTIVATED_DT > SYS_EXTRACT_UTC(SYSTIMESTAMP)) AND ROWNUM = 1");

			while (rs.next()) {
				partyId = rs.getString("CONT_ID");
				break;
			}

			rs.close();

		} catch (DWLPropertyNotFoundException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BusinessProxyException(sqle.getMessage());
		}

		finally {
			query.close();
		}


		return partyId;
	}


	/**
	 * This method will handle any persistent txns
	 * 
	 * @param txnTopLevelObject
	 * @param txnName
	 * @param control
	 * @param errHandler
	 * @return
	 * @throws BusinessProxyException
	 */
	public TCRMCommon handleTransaction(TCRMCommon txnTopLevelObject, String txnName, DWLControl control, 
			IDWLErrorMessage errHandler, String componentId, String reasonCode) throws CustomMDMException, BusinessProxyException {

		txnTopLevelObject.setControl(control);
		logger.fine("Prepare a new DWLTransactionPersistent instance.");
		DWLTransactionPersistent request = new DWLTransactionPersistent();
		request.setTxnControl(control);
		request.setTxnType(txnName);
		request.setTxnTopLevelObject(txnTopLevelObject);

		logger.fine("Prepare a reference to hold the response for this transaction");
		DWLResponse response = null;

		logger.fine("Invoke the transaction");
		try {
			response = (DWLResponse) super.execute(request);
		} catch (BusinessProxyException e) {
			DWLError error = errHandler.getErrorMessage(componentId, TCRMErrorCode.INSERT_RECORD_ERROR,
					reasonCode,	control, new String[0]);
			throw new BusinessProxyException(((DWLError)response.getStatus().getDwlErrorGroup().get(0)).getErrorMessage(), e);
		}

		if (response == null)  {
			DWLError error = errHandler.getErrorMessage(componentId, TCRMErrorCode.INSERT_RECORD_ERROR,
					reasonCode,	control, new String[0]);
			throw new BusinessProxyException(error.getErrorMessage());
		}
		else if (response.getStatus().getStatus() == DWLStatus.FATAL) {
			throw new BusinessProxyException(((DWLError)response.getStatus().getDwlErrorGroup().get(0)).getErrorMessage());
		}

		logger.fine("CommonUtil - Extract the returned business object from the response");
		return (TCRMCommon) response.getData();
	}

	/**
	 * This method invokes inquiry transactions
	 */
	public DWLResponse invokeBaseInquiryTxn (String txnName, Vector<String> params, DWLControl control) 
			throws BusinessProxyException {
		DWLTransactionInquiry inquiry = new DWLTransactionInquiry();
		inquiry.setTxnControl(control);
		inquiry.setTxnType(txnName);
		inquiry.setStringParameters(params);

		return processInquiryObject(inquiry);
	}

	/**
	 * This method gets the current timestamp as a string
	 */
	public static String getCurrentTimestamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * This method gets far future timestamp as a string
	 */
	public static String getFarFutureTimestamp(){
//	     Calendar cal = Calendar.getInstance();
//
//	      // set the year,month and day to something else
//	      cal.set(2099, 01, 01);
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date date = new Date();
//		date.setTime(cal.getTimeInMillis());
//		return dateFormat.format(date);
		return "2099-12-31 00:00:00";
	}
	
	/**
	 * This method gets the current timestamp as a string given a Date object
	 */
	public static String getTimestampStr(Date date){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return dateFormat.format(date);
	}

	/**
	 * This method gets the current timestamp as a string in Oracle Timestamp format
	 */
	public static String getCurrentTimestampOracleFormat(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.SSS a");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

	/**
	 * This method gets the current timestamp as a string in Oracle Timestamp format given a Date object
	 */
	public static String getTimestampOracleFormatStr(Date date){
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.SSS a");
		return dateFormat.format(date);
	}

	/**
	 * This method updates custom address payload fields
	 */
	public static void updateAddressPayloads(String addressId, String X_COUNTY, String X_NEWPORT_KEY, String X_TAX_ID_NUMBER, String X_FAX, 
			String X_SEC_PHONE_EXT, String X_SECONDARY_PHONE, String X_PHONE_EXT, String X_PHONE, String X_LOCATION_NAME, String X_LOCATION_MNEMONIC, 
			String X_LOCATION_ID, String X_LOCATION_DESCRIPTION, String X_DEPARTMENT_DESCRIPTION, 
			String X_FACILITY_NAME, String X_HOSPITAL ) throws BusinessProxyException {

		if(X_COUNTY == null){
			X_COUNTY = "NULL";
		}
		if(X_NEWPORT_KEY == null){
			X_NEWPORT_KEY = "NULL";
		}
		if(X_TAX_ID_NUMBER == null){
			X_TAX_ID_NUMBER = "NULL";
		}
		if(X_FAX == null){
			X_FAX = "NULL";
		}
		if(X_SEC_PHONE_EXT == null){
			X_SEC_PHONE_EXT = "NULL";
		}
		if(X_SECONDARY_PHONE == null){
			X_SECONDARY_PHONE = "NULL";
		}
		if(X_PHONE_EXT == null){
			X_PHONE_EXT = "NULL";
		}
		if(X_PHONE == null){
			X_PHONE = "NULL";
		}
		if(X_LOCATION_NAME == null){
			X_LOCATION_NAME = "NULL";
		}
		if(X_LOCATION_MNEMONIC == null){
			X_LOCATION_MNEMONIC = "NULL";
		}
		if(X_LOCATION_ID == null){
			X_LOCATION_ID = "NULL";
		}
		if(X_LOCATION_DESCRIPTION == null){
			X_LOCATION_DESCRIPTION = "NULL";
		}
		if(X_DEPARTMENT_DESCRIPTION == null){
			X_DEPARTMENT_DESCRIPTION = "NULL";
		}
		if(X_FACILITY_NAME == null){
			X_FACILITY_NAME = "NULL";
		}
		if(X_HOSPITAL == null){
			X_HOSPITAL = "NULL";
		}
		
		if(X_COUNTY.contains("'")){
			X_COUNTY = X_COUNTY.replaceAll("'", "''");
		}
		if(X_NEWPORT_KEY.contains("'")){
			X_NEWPORT_KEY = X_NEWPORT_KEY.replaceAll("'", "''");
		}
		if(X_TAX_ID_NUMBER.contains("'")){
			X_TAX_ID_NUMBER = X_TAX_ID_NUMBER.replaceAll("'", "''");
		}
		if(X_FAX.contains("'")){
			X_FAX = X_FAX.replaceAll("'", "''");
		}
		if(X_SEC_PHONE_EXT.contains("'")){
			X_SEC_PHONE_EXT = X_SEC_PHONE_EXT.replaceAll("'", "''");
		}
		if(X_SECONDARY_PHONE.contains("'")){
			X_SECONDARY_PHONE = X_SECONDARY_PHONE.replaceAll("'", "''");
		}
		if(X_PHONE_EXT.contains("'")){
			X_PHONE_EXT = X_PHONE_EXT.replaceAll("'", "''");
		}
		if(X_PHONE.contains("'")){
			X_PHONE = X_PHONE.replaceAll("'", "''");
		}
		if(X_LOCATION_NAME.contains("'")){
			X_LOCATION_NAME = X_LOCATION_NAME.replaceAll("'", "''");
		}
		if(X_LOCATION_MNEMONIC.contains("'")){
			X_LOCATION_MNEMONIC = X_LOCATION_MNEMONIC.replaceAll("'", "''");
		}
		if(X_LOCATION_ID.contains("'")){
			X_LOCATION_ID = X_LOCATION_ID.replaceAll("'", "''");
		}
		if(X_LOCATION_DESCRIPTION.contains("'")){
			X_LOCATION_DESCRIPTION = X_LOCATION_DESCRIPTION.replaceAll("'", "''");
		}
		if(X_DEPARTMENT_DESCRIPTION.contains("'")){
			X_DEPARTMENT_DESCRIPTION = X_DEPARTMENT_DESCRIPTION.replaceAll("'", "''");
		}
		if(X_FACILITY_NAME.contains("'")){
			X_FACILITY_NAME = X_FACILITY_NAME.replaceAll("'", "''");
		}
		if(X_HOSPITAL.contains("'")){
			X_HOSPITAL = X_HOSPITAL.replaceAll("'", "''");
		}

		String currentTimestamp = getCurrentTimestampOracleFormat();
		SQLQuery query = new SQLQuery();
		String queryString = "UPDATE ADDRESS SET X_COUNTY = '" + X_COUNTY + "' , X_NEWPORT_KEY = '" + X_NEWPORT_KEY
				+ "' , X_TAX_ID_NUMBER = '" + X_TAX_ID_NUMBER + "' , X_FAX = '" + X_FAX + "' , X_SEC_PHONE_EXT = '" + X_SEC_PHONE_EXT
				+ "' , X_SECONDARY_PHONE = '" + X_SECONDARY_PHONE + "' , X_PHONE_EXT = '" + X_PHONE_EXT + "' , X_PHONE = '" + X_PHONE
				+ "' , X_LOCATION_NAME = '" + X_LOCATION_NAME + "' , X_LOCATION_MNEMONIC = '" + X_LOCATION_MNEMONIC
				+ "' , X_LOCATION_ID = '" + X_LOCATION_ID + "' , X_LOCATION_DESCRIPTION = '" + X_LOCATION_DESCRIPTION
				+ "' , X_DEPARTMENT_DESCRIPTION = '" + X_DEPARTMENT_DESCRIPTION
				+ "' , X_FACILITY_NAME = '" + X_FACILITY_NAME + "' , X_HOSPITAL = '" + X_HOSPITAL + "' , LAST_UPDATE_DT = '" + currentTimestamp + "' WHERE ADDRESS_ID = '" + addressId + "'";
		queryString = queryString.replaceAll("'NULL'", "NULL");
		int returnCode = 0;

		try {
			returnCode = query.executeUpdate(queryString);

		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BusinessProxyException(sqle.getMessage());
		}

		finally {
			query.close();
		}
	}

	/**
	 * This method removes empty TCRM objects for a person object
	 */
	public void removeEmptyTCRMObjects(TCRMPersonBObj personInput){

		Vector<XNWPartyAddressBObjExt> inputPartyAddresses = personInput.getItemsTCRMPartyAddressBObj();
		int inputPartyAddressesSize = inputPartyAddresses.size();
		for (int x = 0; x < inputPartyAddressesSize; x++) {
			XNWAddressBObjExt inputAddress = (XNWAddressBObjExt)inputPartyAddresses.get(x).getTCRMAddressBObj();
			if(StringUtils.isBlank(inputAddress.getAddressLineOne())
					&& StringUtils.isBlank(inputAddress.getAddressLineTwo())
					&& StringUtils.isBlank(inputAddress.getCity())
					&& StringUtils.isBlank(inputAddress.getProvinceStateValue())
					&& StringUtils.isBlank(inputAddress.getZipPostalCode())
					&& StringUtils.isBlank(inputAddress.getXPhone())
					&& StringUtils.isBlank(inputAddress.getXSecondary_Phone())
					&& StringUtils.isBlank(inputAddress.getXFax())
					){
				inputPartyAddresses.remove(x);
				inputPartyAddressesSize = inputPartyAddressesSize - 1;
				x--;
			}
		}

		Vector<TCRMPartyContactMethodBObj> inputPartyContactMethods = personInput.getItemsTCRMPartyContactMethodBObj();
		int inputPartyContactMethodsSize = inputPartyContactMethods.size();
		for (int x = 0; x < inputPartyContactMethodsSize; x++) {
			TCRMContactMethodBObj inputContactMethod = inputPartyContactMethods.get(x).getTCRMContactMethodBObj();
			if(StringUtils.isBlank(inputContactMethod.getReferenceNumber())){
				inputPartyContactMethods.remove(x);
				inputPartyContactMethodsSize = inputPartyContactMethodsSize - 1;
				x--;
			}
		}

		Vector<TCRMPartyIdentificationBObj> inputPartyIdentifications = personInput.getItemsTCRMPartyIdentificationBObj();
		int inputPartyIdentificationsSize = inputPartyIdentifications.size();
		for (int x = 0; x < inputPartyIdentificationsSize; x++) {
			if(StringUtils.isBlank(inputPartyIdentifications.get(x).getIdentificationNumber())){
				inputPartyIdentifications.remove(x);
				inputPartyIdentificationsSize = inputPartyIdentificationsSize - 1;
				x--;
			}
		}

		Vector<XNWPersonNameBObjExt> inputPersonNames = personInput.getItemsTCRMPersonNameBObj();
		int inputPersonNamesSize = inputPersonNames.size();
		for (int x = 0; x < inputPersonNamesSize; x++) {
			if(StringUtils.isBlank(inputPersonNames.get(x).getLastName())){
				inputPersonNames.remove(x);
				inputPersonNamesSize = inputPersonNamesSize - 1;
				x--;
			}
		}

		Vector<TCRMPartyValueBObj> inputPartyValues = personInput.getItemsTCRMPartyValueBObj();
		int inputPartyValuesSize = inputPartyValues.size();
		for (int x = 0; x < inputPartyValuesSize; x++) {
			if(StringUtils.isBlank(inputPartyValues.get(x).getValueString())){
				inputPartyValues.remove(x);
				inputPartyValuesSize = inputPartyValuesSize - 1;
				x--;
			}
		}

	}

	/**
	 * This method checks if a configuration option is present
	 */
	public static boolean isConfigOptionPresent(String configOption) throws BusinessProxyException, DWLPropertyNotFoundException {

		boolean found = false;
		SQLQuery query = new SQLQuery(); 
		String queryString = "SELECT VALUE FROM CONFIGELEMENT WHERE NAME = '" + configOption + "'";

		try {
			ResultSet results = query.executeQuery(queryString);
			if(results.next()){
				found = true;
			} else{
				found = false;
			}

		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BusinessProxyException(sqle.getMessage());
		}

		finally {
			query.close();
		}

		return found;
	}

	/**
	 * This method creates a unique street line 3 entry in address to for a unique address addition.
	 * This was needed because the business key override for address in MDM is not working.
	 */
	public static String getUniqueAddrStr(XNWAddressBObjExt address){
		
		String stline1 = address.getAddressLineOne();
		String stline2 = address.getAddressLineTwo();
		String city = address.getCity();
		String state = address.getProvinceStateValue();
		String zip = address.getZipPostalCode();
		String dept = address.getXDepartment_Code();
		String fac = address.getXFacility_Name();
		String loc = address.getXLocation_Name();
		String faccd = address.getXFacility_Code();
		String loccd = address.getXLocation_Code();

		String uniqueStr=stline1+stline2+city+state+zip+fac+dept+loc+faccd+loccd;
		return uniqueStr;
	}
	
	/**
	 * This method delete street line 3 of a given address id
	 */
	public static void deleteStline3(String addressId) throws BusinessProxyException, DWLPropertyNotFoundException {

		SQLQuery query = new SQLQuery(); 
		String queryString = "UPDATE ADDRESS SET ADDR_LINE_THREE = '' WHERE ADDRESS_ID = '" + addressId + "'";

		try {
			query.executeUpdate(queryString);

		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BusinessProxyException(sqle.getMessage());
		}

		finally {
			query.close();
		}
	}

	/**
	 * This method records instances of transactions
	 * @throws BusinessProxyException 
	 */
	public static void recordTxn(String log) throws BusinessProxyException{ 

		SQLQuery query = new SQLQuery();
		String queryString = "INSERT INTO TXN_LOGS (LOGTIME, LOG) VALUES ('"+getTimestampOracleFormatStr(new Date()) + "' , '" + log + "')";

		try {
			query.executeUpdate(queryString);

		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BusinessProxyException(sqle.getMessage());
		}

		finally {
			query.close();
		}
	}

	public static void deleteAddress(String existingAddressId) throws BusinessProxyException, DWLPropertyNotFoundException {
		
		String locGrpId = null;
		SQLQuery query = new SQLQuery();
		ResultSet rs = null;

		try {
			rs = query.executeQuery("SELECT LOCATION_GROUP_ID FROM ADDRESSGROUP WHERE ADDRESS_ID = '" + existingAddressId + "'");

			while (rs.next()) {
				locGrpId = rs.getString("LOCATION_GROUP_ID");
				break;
			}

			rs.close();

			String queryString = "DELETE FROM ADDRESSGROUP WHERE ADDRESS_ID = '"+ existingAddressId + "'";
			query.executeUpdate(queryString);

			queryString = "DELETE FROM LOCATIONGROUP WHERE LOCATION_GROUP_ID = '"+ locGrpId + "'";
			query.executeUpdate(queryString);

			queryString = "DELETE FROM ADDRESS WHERE ADDRESS_ID = '"+ existingAddressId + "'";
			query.executeUpdate(queryString);

		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BusinessProxyException(sqle.getMessage());
		}

		finally {
			query.close();
		}
	}

}
