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
 * IBM-MDMWB-1.0-[16725406b48879797dbab6effde18fcb]
 */

package mdmnw.entityObject;

import com.dwl.base.EObjCommon;
import com.ibm.mdm.base.db.DataType;
import com.ibm.pdq.annotation.Column;
import com.ibm.pdq.annotation.Table;



/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * The entity object corresponding to the xNWPartyAddress business object. This
 * entity object should include all the attributes as defined by the business
 * object.
 * 
 * @generated
 */
@SuppressWarnings("serial")
@Table(name=EObjxNWPartyAddressExt.tableName)
public class EObjxNWPartyAddressExt extends EObjCommon {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String tableName = "ADDRESSGROUP";
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xProvider_Facility_Staff_CodeColumn = "X_PROVIDER_FACILITY_STAFF_CODE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xProvider_Facility_Staff_CodeJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xProvider_Facility_Staff_CodePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xProvider_Facility_Active_StatusColumn = "X_PROV_FACILITY_ACTIVE_STATUS";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xProvider_Facility_Active_StatusJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xProvider_Facility_Active_StatusPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPrimary_Office_FlagColumn = "X_PRIMARY_OFFICE_FLAG";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPrimary_Office_FlagJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xPrimary_Office_FlagPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDeactivation_FlagColumn = "X_DEACTIVATION_FLAG";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDeactivation_FlagJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDeactivation_FlagPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPrimary_Billing_Location_FlagColumn = "X_PRIMARY_BILLING_LOC_FLAG";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPrimary_Billing_Location_FlagJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xPrimary_Billing_Location_FlagPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xCredential_StatusColumn = "X_CREDENTIAL_STATUS";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xCredential_StatusJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xCredential_StatusPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xProvider_StatusColumn = "X_PROVIDER_STATUS";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xProvider_StatusJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xProvider_StatusPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xScheduling_Primary_FlagColumn = "X_SCHD_PRIM_FLG";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xScheduling_Primary_FlagJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xScheduling_Primary_FlagPrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPhoneColumn = "X_PHONE";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPhoneJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xPhonePrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPhone_ExtColumn = "X_PHONE_EXT";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xPhone_ExtJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xPhone_ExtPrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xSecondary_PhoneColumn = "X_SECONDARY_PHONE";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xSecondary_PhoneJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xSecondary_PhonePrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xSec_Phone_ExtColumn = "X_SEC_PHONE_EXT";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xSec_Phone_ExtJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xSec_Phone_ExtPrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xFaxColumn = "X_FAX";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xFaxJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xFaxPrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Long locationGroupIdPK;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xProvider_Facility_Staff_Code;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xProvider_Facility_Active_Status;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xPrimary_Office_Flag;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDeactivation_Flag;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xPrimary_Billing_Location_Flag;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xCredential_Status;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xProvider_Status;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xScheduling_Primary_Flag;


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xPhone;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xPhone_Ext;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xSecondary_Phone;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xSec_Phone_Ext;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xFax;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
	private EObjCommon baseEntity = null;
	
	
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Default constructor.     
     *
     * @generated
     */
    public EObjxNWPartyAddressExt(EObjCommon baseEntity) {
        super();
        setBaseEntity (baseEntity);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Default constructor.     
     *
     * @generated
     */
    public EObjxNWPartyAddressExt() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the locationGroupIdPK attribute. 
     *
     * @generated
     **/
	public Long getLocationGroupIdPK (){
      return locationGroupIdPK;
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the locationGroupIdPK attribute. 
     *
     * @param locationGroupIdPK
     *     The new value of locationGroupIdPK. 
     * @generated
     */
    public void setLocationGroupIdPK( Long locationGroupIdPK ){
    this.locationGroupIdPK = locationGroupIdPK;
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xProvider_Facility_Staff_Code attribute. 
     *
     * @generated
     */
    @Column(name=xProvider_Facility_Staff_CodeColumn)
    @DataType(jdbcType=xProvider_Facility_Staff_CodeJdbcType, precision=xProvider_Facility_Staff_CodePrecision)
    public String getXProvider_Facility_Staff_Code (){
        return xProvider_Facility_Staff_Code;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xProvider_Facility_Staff_Code attribute. 
     *
     * @param xProvider_Facility_Staff_Code
     *     The new value of xProvider_Facility_Staff_Code. 
     * @generated
     */
    public void setXProvider_Facility_Staff_Code( String xProvider_Facility_Staff_Code ){
        this.xProvider_Facility_Staff_Code = xProvider_Facility_Staff_Code;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xProvider_Facility_Active_Status attribute. 
     *
     * @generated
     */
    @Column(name=xProvider_Facility_Active_StatusColumn)
    @DataType(jdbcType=xProvider_Facility_Active_StatusJdbcType, precision=xProvider_Facility_Active_StatusPrecision)
    public String getXProvider_Facility_Active_Status (){
        return xProvider_Facility_Active_Status;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xProvider_Facility_Active_Status attribute. 
     *
     * @param xProvider_Facility_Active_Status
     *     The new value of xProvider_Facility_Active_Status. 
     * @generated
     */
    public void setXProvider_Facility_Active_Status( String xProvider_Facility_Active_Status ){
        this.xProvider_Facility_Active_Status = xProvider_Facility_Active_Status;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPrimary_Office_Flag attribute. 
     *
     * @generated
     */
    @Column(name=xPrimary_Office_FlagColumn)
    @DataType(jdbcType=xPrimary_Office_FlagJdbcType, precision=xPrimary_Office_FlagPrecision)
    public String getXPrimary_Office_Flag (){
        return xPrimary_Office_Flag;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPrimary_Office_Flag attribute. 
     *
     * @param xPrimary_Office_Flag
     *     The new value of xPrimary_Office_Flag. 
     * @generated
     */
    public void setXPrimary_Office_Flag( String xPrimary_Office_Flag ){
        this.xPrimary_Office_Flag = xPrimary_Office_Flag;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDeactivation_Flag attribute. 
     *
     * @generated
     */
    @Column(name=xDeactivation_FlagColumn)
    @DataType(jdbcType=xDeactivation_FlagJdbcType, precision=xDeactivation_FlagPrecision)
    public String getXDeactivation_Flag (){
        return xDeactivation_Flag;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDeactivation_Flag attribute. 
     *
     * @param xDeactivation_Flag
     *     The new value of xDeactivation_Flag. 
     * @generated
     */
    public void setXDeactivation_Flag( String xDeactivation_Flag ){
        this.xDeactivation_Flag = xDeactivation_Flag;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPrimary_Billing_Location_Flag attribute. 
     *
     * @generated
     */
    @Column(name=xPrimary_Billing_Location_FlagColumn)
    @DataType(jdbcType=xPrimary_Billing_Location_FlagJdbcType, precision=xPrimary_Billing_Location_FlagPrecision)
    public String getXPrimary_Billing_Location_Flag (){
        return xPrimary_Billing_Location_Flag;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPrimary_Billing_Location_Flag attribute. 
     *
     * @param xPrimary_Billing_Location_Flag
     *     The new value of xPrimary_Billing_Location_Flag. 
     * @generated
     */
    public void setXPrimary_Billing_Location_Flag( String xPrimary_Billing_Location_Flag ){
        this.xPrimary_Billing_Location_Flag = xPrimary_Billing_Location_Flag;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xCredential_Status attribute. 
     *
     * @generated
     */
    @Column(name=xCredential_StatusColumn)
    @DataType(jdbcType=xCredential_StatusJdbcType, precision=xCredential_StatusPrecision)
    public String getXCredential_Status (){
        return xCredential_Status;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xCredential_Status attribute. 
     *
     * @param xCredential_Status
     *     The new value of xCredential_Status. 
     * @generated
     */
    public void setXCredential_Status( String xCredential_Status ){
        this.xCredential_Status = xCredential_Status;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xProvider_Status attribute. 
     *
     * @generated
     */
    @Column(name=xProvider_StatusColumn)
    @DataType(jdbcType=xProvider_StatusJdbcType, precision=xProvider_StatusPrecision)
    public String getXProvider_Status (){
        return xProvider_Status;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xProvider_Status attribute. 
     *
     * @param xProvider_Status
     *     The new value of xProvider_Status. 
     * @generated
     */
    public void setXProvider_Status( String xProvider_Status ){
        this.xProvider_Status = xProvider_Status;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xScheduling_Primary_Flag attribute. 
     *
     * @generated
     */
    @Column(name=xScheduling_Primary_FlagColumn)
    @DataType(jdbcType=xScheduling_Primary_FlagJdbcType, precision=xScheduling_Primary_FlagPrecision)
    public String getXScheduling_Primary_Flag (){
        return xScheduling_Primary_Flag;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xScheduling_Primary_Flag attribute. 
     *
     * @param xScheduling_Primary_Flag
     *     The new value of xScheduling_Primary_Flag. 
     * @generated
     */
    public void setXScheduling_Primary_Flag( String xScheduling_Primary_Flag ){
        this.xScheduling_Primary_Flag = xScheduling_Primary_Flag;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPhone attribute. 
     *
     * @generated
     */
    @Column(name=xPhoneColumn)
    @DataType(jdbcType=xPhoneJdbcType, precision=xPhonePrecision)
    public String getXPhone (){
        return xPhone;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPhone attribute. 
     *
     * @param xPhone
     *     The new value of xPhone. 
     * @generated
     */
    public void setXPhone( String xPhone ){
        this.xPhone = xPhone;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xPhone_Ext attribute. 
     *
     * @generated
     */
    @Column(name=xPhone_ExtColumn)
    @DataType(jdbcType=xPhone_ExtJdbcType, precision=xPhone_ExtPrecision)
    public String getXPhone_Ext (){
        return xPhone_Ext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xPhone_Ext attribute. 
     *
     * @param xPhone_Ext
     *     The new value of xPhone_Ext. 
     * @generated
     */
    public void setXPhone_Ext( String xPhone_Ext ){
        this.xPhone_Ext = xPhone_Ext;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xSecondary_Phone attribute. 
     *
     * @generated
     */
    @Column(name=xSecondary_PhoneColumn)
    @DataType(jdbcType=xSecondary_PhoneJdbcType, precision=xSecondary_PhonePrecision)
    public String getXSecondary_Phone (){
        return xSecondary_Phone;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xSecondary_Phone attribute. 
     *
     * @param xSecondary_Phone
     *     The new value of xSecondary_Phone. 
     * @generated
     */
    public void setXSecondary_Phone( String xSecondary_Phone ){
        this.xSecondary_Phone = xSecondary_Phone;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xSec_Phone_Ext attribute. 
     *
     * @generated
     */
    @Column(name=xSec_Phone_ExtColumn)
    @DataType(jdbcType=xSec_Phone_ExtJdbcType, precision=xSec_Phone_ExtPrecision)
    public String getXSec_Phone_Ext (){
        return xSec_Phone_Ext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xSec_Phone_Ext attribute. 
     *
     * @param xSec_Phone_Ext
     *     The new value of xSec_Phone_Ext. 
     * @generated
     */
    public void setXSec_Phone_Ext( String xSec_Phone_Ext ){
        this.xSec_Phone_Ext = xSec_Phone_Ext;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFax attribute. 
     *
     * @generated
     */
    @Column(name=xFaxColumn)
    @DataType(jdbcType=xFaxJdbcType, precision=xFaxPrecision)
    public String getXFax (){
        return xFax;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFax attribute. 
     *
     * @param xFax
     *     The new value of xFax. 
     * @generated
     */
    public void setXFax( String xFax ){
        this.xFax = xFax;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the primary key. 
     *
     * @param aUniqueId
     *     The new value of the primary key. 
     * @generated
   */
	public void setPrimaryKey(Object aUniqueId) {
    this.setLocationGroupIdPK((Long)aUniqueId);
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the primary key.
     *
     * @generated
     */
	public Object getPrimaryKey() {
    return this.getLocationGroupIdPK();
  }
	 
	 /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Executes before the extension is added to the database.
     *
     * @generated
     */
    @Override
    protected void beforeAddEx()
    {
        enforceBaseEntityAttributes();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Executes before the extension is updated in the database
     *
     * @generated
     */
    @Override
    protected void beforeUpdateEx()
    {
        enforceBaseEntityAttributes ();
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Handles optimistic locking.
     *
     * @generated
     */
    @Override
    protected void handleOptimisticLocking()
    {
        this.setOldLastUpdateDt(baseEntity.getLastUpdateDt());
        this.setLastUpdateDt(getNextLastUpdateDate());
        baseEntity.setLastUpdateDt(this.getLastUpdateDt());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Enforces and synchronizes the extension and base entity attributes.
     *
     * @generated
     */
    private void enforceBaseEntityAttributes()
    {
        this.setLastUpdateTxId(baseEntity.getLastUpdateTxId());
        this.setLastUpdateUser(baseEntity.getLastUpdateUser());
        this.setPrimaryKey(baseEntity.getPrimaryKey());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the base entity and syncs all attributes between extension and base entity.
     *
     * @generated
     */
    public void setBaseEntity (EObjCommon baseEntity)
    {
        if (baseEntity == null)
            throw new java.lang.IllegalArgumentException ("baseEntity is null");
        
        this.baseEntity = baseEntity;
        enforceBaseEntityAttributes();
        if( this.getLastUpdateDt() == null ){
        	this.setLastUpdateDt(baseEntity.getLastUpdateDt());
        	this.setOldLastUpdateDt(baseEntity.getOldLastUpdateDt());
        }
    }
}


