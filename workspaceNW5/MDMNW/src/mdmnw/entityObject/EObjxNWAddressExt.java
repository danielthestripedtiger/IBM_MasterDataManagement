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
 * IBM-MDMWB-1.0-[2956d4bcdf9f839a850d151cb4a70a5f]
 */

package mdmnw.entityObject;

import com.dwl.base.EObjCommon;
import com.ibm.mdm.base.db.DataType;
import com.ibm.pdq.annotation.Column;
import com.ibm.pdq.annotation.Table;


import java.sql.Timestamp;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * The entity object corresponding to the xNWAddress business object. This
 * entity object should include all the attributes as defined by the business
 * object.
 * 
 * This address extension is for the unique addresses that MDM will hold,
 * regardless of the usage type. For Address data instances by usage type, see
 * TCRMPartyAddressBObj / xNWPartyAddressBObj objects types.
 * 
 * @generated
 */
@SuppressWarnings("serial")
@Table(name=EObjxNWAddressExt.tableName)
public class EObjxNWAddressExt extends EObjCommon {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String tableName = "ADDRESS";
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xCountyColumn = "X_COUNTY";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xCountyJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xCountyPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xHospitalColumn = "X_HOSPITAL";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xHospitalJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xHospitalPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xFacility_NameColumn = "X_FACILITY_NAME";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xFacility_NameJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xFacility_NamePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xFacility_CodeColumn = "X_FACILITY_CODE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xFacility_CodeJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xFacility_CodePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_CodeColumn = "X_DEPARTMENT_CODE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_CodeJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDepartment_CodePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_DescriptionColumn = "X_DEPARTMENT_DESCRIPTION";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_DescriptionJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDepartment_DescriptionPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_CodeColumn = "X_LOCATION_CODE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_CodeJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xLocation_CodePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_DescriptionColumn = "X_LOCATION_DESCRIPTION";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_DescriptionJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xLocation_DescriptionPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_MnemonicColumn = "X_LOCATION_MNEMONIC";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_MnemonicJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xLocation_MnemonicPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_IDColumn = "X_LOCATION_ID";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_IDJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xLocation_IDPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_NameColumn = "X_LOCATION_NAME";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xLocation_NameJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xLocation_NamePrecision = 250;
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
    private static final String xTax_ID_NumberColumn = "X_TAX_ID_NUMBER";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTax_ID_NumberJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xTax_ID_NumberPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xNewport_KeyColumn = "X_NEWPORT_KEY";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xNewport_KeyJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xNewport_KeyPrecision = 250;
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
    private static final String xActivation_DateColumn = "X_ACTIVATION_DATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xActivation_DateJdbcType = "TIMESTAMP";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDeactivation_DateColumn = "X_DEACTIVATION_DATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDeactivation_DateJdbcType = "TIMESTAMP";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTax_ID_Number_SourceColumn = "X_TAX_ID_NUMBER_SOURCE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTax_ID_Number_SourceJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xTax_ID_Number_SourcePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTax_ID_Number_LastVerifiedDateColumn = "X_TAX_ID_LASTVERIFIEDDATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTax_ID_Number_LastVerifiedDateJdbcType = "TIMESTAMP";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xNewport_Key_SourceColumn = "X_NEWPORT_KEY_SOURCE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xNewport_Key_SourceJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xNewport_Key_SourcePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xNewport_Key_LastVerifiedDateColumn = "X_NEWPORT_KEY_LASTVERIFIEDDATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xNewport_Key_LastVerifiedDateJdbcType = "TIMESTAMP";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Long addressIdPK;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xCounty;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xHospital;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xFacility_Name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xFacility_Code;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDepartment_Code;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDepartment_Description;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xLocation_Code;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xLocation_Description;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xLocation_Mnemonic;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xLocation_ID;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xLocation_Name;

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
    protected String xTax_ID_Number;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xNewport_Key;

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
    protected  Timestamp xActivation_Date;
    //inside if 

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xDeactivation_Date;
    //inside if 

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xTax_ID_Number_Source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xTax_ID_Number_LastVerifiedDate;
    //inside if 

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xNewport_Key_Source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xNewport_Key_LastVerifiedDate;
    //inside if 


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
    public EObjxNWAddressExt(EObjCommon baseEntity) {
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
    public EObjxNWAddressExt() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the addressIdPK attribute. 
     *
     * @generated
     **/
	public Long getAddressIdPK (){
      return addressIdPK;
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the addressIdPK attribute. 
     *
     * @param addressIdPK
     *     The new value of addressIdPK. 
     * @generated
     */
    public void setAddressIdPK( Long addressIdPK ){
    this.addressIdPK = addressIdPK;
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xCounty attribute. 
     *
     * @generated
     */
    @Column(name=xCountyColumn)
    @DataType(jdbcType=xCountyJdbcType, precision=xCountyPrecision)
    public String getXCounty (){
        return xCounty;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xCounty attribute. 
     *
     * @param xCounty
     *     The new value of xCounty. 
     * @generated
     */
    public void setXCounty( String xCounty ){
        this.xCounty = xCounty;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xHospital attribute. 
     *
     * @generated
     */
    @Column(name=xHospitalColumn)
    @DataType(jdbcType=xHospitalJdbcType, precision=xHospitalPrecision)
    public String getXHospital (){
        return xHospital;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xHospital attribute. 
     *
     * @param xHospital
     *     The new value of xHospital. 
     * @generated
     */
    public void setXHospital( String xHospital ){
        this.xHospital = xHospital;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFacility_Name attribute. 
     *
     * @generated
     */
    @Column(name=xFacility_NameColumn)
    @DataType(jdbcType=xFacility_NameJdbcType, precision=xFacility_NamePrecision)
    public String getXFacility_Name (){
        return xFacility_Name;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFacility_Name attribute. 
     *
     * @param xFacility_Name
     *     The new value of xFacility_Name. 
     * @generated
     */
    public void setXFacility_Name( String xFacility_Name ){
        this.xFacility_Name = xFacility_Name;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xFacility_Code attribute. 
     *
     * @generated
     */
    @Column(name=xFacility_CodeColumn)
    @DataType(jdbcType=xFacility_CodeJdbcType, precision=xFacility_CodePrecision)
    public String getXFacility_Code (){
        return xFacility_Code;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xFacility_Code attribute. 
     *
     * @param xFacility_Code
     *     The new value of xFacility_Code. 
     * @generated
     */
    public void setXFacility_Code( String xFacility_Code ){
        this.xFacility_Code = xFacility_Code;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_Code attribute. 
     *
     * @generated
     */
    @Column(name=xDepartment_CodeColumn)
    @DataType(jdbcType=xDepartment_CodeJdbcType, precision=xDepartment_CodePrecision)
    public String getXDepartment_Code (){
        return xDepartment_Code;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_Code attribute. 
     *
     * @param xDepartment_Code
     *     The new value of xDepartment_Code. 
     * @generated
     */
    public void setXDepartment_Code( String xDepartment_Code ){
        this.xDepartment_Code = xDepartment_Code;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_Description attribute. 
     *
     * @generated
     */
    @Column(name=xDepartment_DescriptionColumn)
    @DataType(jdbcType=xDepartment_DescriptionJdbcType, precision=xDepartment_DescriptionPrecision)
    public String getXDepartment_Description (){
        return xDepartment_Description;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_Description attribute. 
     *
     * @param xDepartment_Description
     *     The new value of xDepartment_Description. 
     * @generated
     */
    public void setXDepartment_Description( String xDepartment_Description ){
        this.xDepartment_Description = xDepartment_Description;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Code attribute. 
     *
     * @generated
     */
    @Column(name=xLocation_CodeColumn)
    @DataType(jdbcType=xLocation_CodeJdbcType, precision=xLocation_CodePrecision)
    public String getXLocation_Code (){
        return xLocation_Code;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Code attribute. 
     *
     * @param xLocation_Code
     *     The new value of xLocation_Code. 
     * @generated
     */
    public void setXLocation_Code( String xLocation_Code ){
        this.xLocation_Code = xLocation_Code;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Description attribute. 
     *
     * @generated
     */
    @Column(name=xLocation_DescriptionColumn)
    @DataType(jdbcType=xLocation_DescriptionJdbcType, precision=xLocation_DescriptionPrecision)
    public String getXLocation_Description (){
        return xLocation_Description;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Description attribute. 
     *
     * @param xLocation_Description
     *     The new value of xLocation_Description. 
     * @generated
     */
    public void setXLocation_Description( String xLocation_Description ){
        this.xLocation_Description = xLocation_Description;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Mnemonic attribute. 
     *
     * @generated
     */
    @Column(name=xLocation_MnemonicColumn)
    @DataType(jdbcType=xLocation_MnemonicJdbcType, precision=xLocation_MnemonicPrecision)
    public String getXLocation_Mnemonic (){
        return xLocation_Mnemonic;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Mnemonic attribute. 
     *
     * @param xLocation_Mnemonic
     *     The new value of xLocation_Mnemonic. 
     * @generated
     */
    public void setXLocation_Mnemonic( String xLocation_Mnemonic ){
        this.xLocation_Mnemonic = xLocation_Mnemonic;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_ID attribute. 
     *
     * @generated
     */
    @Column(name=xLocation_IDColumn)
    @DataType(jdbcType=xLocation_IDJdbcType, precision=xLocation_IDPrecision)
    public String getXLocation_ID (){
        return xLocation_ID;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_ID attribute. 
     *
     * @param xLocation_ID
     *     The new value of xLocation_ID. 
     * @generated
     */
    public void setXLocation_ID( String xLocation_ID ){
        this.xLocation_ID = xLocation_ID;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xLocation_Name attribute. 
     *
     * @generated
     */
    @Column(name=xLocation_NameColumn)
    @DataType(jdbcType=xLocation_NameJdbcType, precision=xLocation_NamePrecision)
    public String getXLocation_Name (){
        return xLocation_Name;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xLocation_Name attribute. 
     *
     * @param xLocation_Name
     *     The new value of xLocation_Name. 
     * @generated
     */
    public void setXLocation_Name( String xLocation_Name ){
        this.xLocation_Name = xLocation_Name;
    
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
     * Gets the xTax_ID_Number attribute. 
     *
     * @generated
     */
    @Column(name=xTax_ID_NumberColumn)
    @DataType(jdbcType=xTax_ID_NumberJdbcType, precision=xTax_ID_NumberPrecision)
    public String getXTax_ID_Number (){
        return xTax_ID_Number;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTax_ID_Number attribute. 
     *
     * @param xTax_ID_Number
     *     The new value of xTax_ID_Number. 
     * @generated
     */
    public void setXTax_ID_Number( String xTax_ID_Number ){
        this.xTax_ID_Number = xTax_ID_Number;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xNewport_Key attribute. 
     *
     * @generated
     */
    @Column(name=xNewport_KeyColumn)
    @DataType(jdbcType=xNewport_KeyJdbcType, precision=xNewport_KeyPrecision)
    public String getXNewport_Key (){
        return xNewport_Key;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xNewport_Key attribute. 
     *
     * @param xNewport_Key
     *     The new value of xNewport_Key. 
     * @generated
     */
    public void setXNewport_Key( String xNewport_Key ){
        this.xNewport_Key = xNewport_Key;
    
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
     * Gets the xActivation_Date attribute. 
     *
     * @generated
     */
    @Column(name=xActivation_DateColumn)
    @DataType(jdbcType=xActivation_DateJdbcType)
    public Timestamp getXActivation_Date (){
        return xActivation_Date;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xActivation_Date attribute. 
     *
     * @param xActivation_Date
     *     The new value of xActivation_Date. 
     * @generated
     */
    public void setXActivation_Date( Timestamp xActivation_Date ){
        this.xActivation_Date = xActivation_Date;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDeactivation_Date attribute. 
     *
     * @generated
     */
    @Column(name=xDeactivation_DateColumn)
    @DataType(jdbcType=xDeactivation_DateJdbcType)
    public Timestamp getXDeactivation_Date (){
        return xDeactivation_Date;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDeactivation_Date attribute. 
     *
     * @param xDeactivation_Date
     *     The new value of xDeactivation_Date. 
     * @generated
     */
    public void setXDeactivation_Date( Timestamp xDeactivation_Date ){
        this.xDeactivation_Date = xDeactivation_Date;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTax_ID_Number_Source attribute. 
     *
     * @generated
     */
    @Column(name=xTax_ID_Number_SourceColumn)
    @DataType(jdbcType=xTax_ID_Number_SourceJdbcType, precision=xTax_ID_Number_SourcePrecision)
    public String getXTax_ID_Number_Source (){
        return xTax_ID_Number_Source;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTax_ID_Number_Source attribute. 
     *
     * @param xTax_ID_Number_Source
     *     The new value of xTax_ID_Number_Source. 
     * @generated
     */
    public void setXTax_ID_Number_Source( String xTax_ID_Number_Source ){
        this.xTax_ID_Number_Source = xTax_ID_Number_Source;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTax_ID_Number_LastVerifiedDate attribute. 
     *
     * @generated
     */
    @Column(name=xTax_ID_Number_LastVerifiedDateColumn)
    @DataType(jdbcType=xTax_ID_Number_LastVerifiedDateJdbcType)
    public Timestamp getXTax_ID_Number_LastVerifiedDate (){
        return xTax_ID_Number_LastVerifiedDate;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTax_ID_Number_LastVerifiedDate attribute. 
     *
     * @param xTax_ID_Number_LastVerifiedDate
     *     The new value of xTax_ID_Number_LastVerifiedDate. 
     * @generated
     */
    public void setXTax_ID_Number_LastVerifiedDate( Timestamp xTax_ID_Number_LastVerifiedDate ){
        this.xTax_ID_Number_LastVerifiedDate = xTax_ID_Number_LastVerifiedDate;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xNewport_Key_Source attribute. 
     *
     * @generated
     */
    @Column(name=xNewport_Key_SourceColumn)
    @DataType(jdbcType=xNewport_Key_SourceJdbcType, precision=xNewport_Key_SourcePrecision)
    public String getXNewport_Key_Source (){
        return xNewport_Key_Source;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xNewport_Key_Source attribute. 
     *
     * @param xNewport_Key_Source
     *     The new value of xNewport_Key_Source. 
     * @generated
     */
    public void setXNewport_Key_Source( String xNewport_Key_Source ){
        this.xNewport_Key_Source = xNewport_Key_Source;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xNewport_Key_LastVerifiedDate attribute. 
     *
     * @generated
     */
    @Column(name=xNewport_Key_LastVerifiedDateColumn)
    @DataType(jdbcType=xNewport_Key_LastVerifiedDateJdbcType)
    public Timestamp getXNewport_Key_LastVerifiedDate (){
        return xNewport_Key_LastVerifiedDate;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xNewport_Key_LastVerifiedDate attribute. 
     *
     * @param xNewport_Key_LastVerifiedDate
     *     The new value of xNewport_Key_LastVerifiedDate. 
     * @generated
     */
    public void setXNewport_Key_LastVerifiedDate( Timestamp xNewport_Key_LastVerifiedDate ){
        this.xNewport_Key_LastVerifiedDate = xNewport_Key_LastVerifiedDate;
    
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
    this.setAddressIdPK((Long)aUniqueId);
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
    return this.getAddressIdPK();
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


