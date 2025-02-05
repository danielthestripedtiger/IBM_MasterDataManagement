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
 * IBM-MDMWB-1.0-[02bc4fd4df96d97489d9a952a4be45a2]
 */

package mdmnw.entityObject;

import com.dwl.base.EObjCommon;
import com.ibm.mdm.base.db.DataType;
import com.ibm.pdq.annotation.Column;
import com.ibm.pdq.annotation.Table;


import java.sql.Date;
import java.sql.Timestamp;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * The entity object corresponding to the xNWPerson business object. This entity
 * object should include all the attributes as defined by the business object.
 * 
 * @generated
 */
@SuppressWarnings("serial")
@Table(name=EObjxNWPersonExt.tableName)
public class EObjxNWPersonExt extends EObjCommon {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String tableName = "PERSON";
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xJob_TitleColumn = "X_JOB_TITLE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xJob_TitleJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xJob_TitlePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xJob_FamilyColumn = "X_JOB_FAMILY";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xJob_FamilyJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xJob_FamilyPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String ixFullTime_PartTImeColumn = "X_FULL_TIME_PART_TIME";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String ixFullTime_PartTImeJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    ixFullTime_PartTImePrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xStandard_HoursColumn = "X_STANDARD_HOURS";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xStandard_HoursJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xStandard_HoursPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xBusiness_UnitColumn = "X_BUSINESS_UNIT";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xBusiness_UnitJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xBusiness_UnitPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xHire_DateColumn = "X_HIRE_DATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xHire_DateJdbcType = "DATE";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xEmployee_Role_StatusColumn = "X_EMP_ROLE_STATUS";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xEmployee_Role_StatusJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xEmployee_Role_StatusPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xRehire_DateColumn = "X_REHIRE_DATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xRehire_DateJdbcType = "DATE";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTermination_DateColumn = "X_TERMINATION_DATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xTermination_DateJdbcType = "DATE";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_IDColumn = "X_DEPARTMENT_ID";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_IDJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDepartment_IDPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_NameColumn = "X_DEPARTMENT_NAME";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDepartment_NameJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDepartment_NamePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xService_Line_Financial_BudgetaryColumn = "X_SERVICE_LINE_FIN_BUDGETARY";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xService_Line_Financial_BudgetaryJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xService_Line_Financial_BudgetaryPrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xGender_SourceColumn = "X_GENDER_SOURCE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xGender_SourceJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xGender_SourcePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xGender_LastVerifiedDateColumn = "X_GENDER_LASTVERIFIEDDATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xGender_LastVerifiedDateJdbcType = "TIMESTAMP";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xMaritalStatus_SourceColumn = "X_MARITAL_STATUS_SOURCE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xMaritalStatus_SourceJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xMaritalStatus_SourcePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xMaritalStatus_LastVerifiedDateColumn = "X_MARSTAT_LASTVERIFIEDDATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xMaritalStatus_LastVerifiedDateJdbcType = "TIMESTAMP";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xEmploymentData_SourceColumn = "X_EMPLOYMENTDATA_SOURCE";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xEmploymentData_SourceJdbcType = "VARCHAR";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xEmploymentData_SourcePrecision = 250;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xEmploymentData_LastVerifiedDateColumn = "X_EMPDATA_LASTVERIFIEDDATE";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xEmploymentData_LastVerifiedDateJdbcType = "TIMESTAMP";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Long contIdPK;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xJob_Title;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xJob_Family;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String ixFullTime_PartTIme;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xStandard_Hours;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xBusiness_Unit;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Date xHire_Date;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xEmployee_Role_Status;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Date xRehire_Date;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Date xTermination_Date;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDepartment_ID;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDepartment_Name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xService_Line_Financial_Budgetary;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xGender_Source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xGender_LastVerifiedDate;
    //inside if 

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xMaritalStatus_Source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xMaritalStatus_LastVerifiedDate;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xEmploymentData_Source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xEmploymentData_LastVerifiedDate;

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
    public EObjxNWPersonExt(EObjCommon baseEntity) {
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
    public EObjxNWPersonExt() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the contIdPK attribute. 
     *
     * @generated
     **/
	public Long getContIdPK (){
      return contIdPK;
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the contIdPK attribute. 
     *
     * @param contIdPK
     *     The new value of contIdPK. 
     * @generated
     */
    public void setContIdPK( Long contIdPK ){
    this.contIdPK = contIdPK;
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xJob_Title attribute. 
     *
     * @generated
     */
    @Column(name=xJob_TitleColumn)
    @DataType(jdbcType=xJob_TitleJdbcType, precision=xJob_TitlePrecision)
    public String getXJob_Title (){
        return xJob_Title;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xJob_Title attribute. 
     *
     * @param xJob_Title
     *     The new value of xJob_Title. 
     * @generated
     */
    public void setXJob_Title( String xJob_Title ){
        this.xJob_Title = xJob_Title;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xJob_Family attribute. 
     *
     * @generated
     */
    @Column(name=xJob_FamilyColumn)
    @DataType(jdbcType=xJob_FamilyJdbcType, precision=xJob_FamilyPrecision)
    public String getXJob_Family (){
        return xJob_Family;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xJob_Family attribute. 
     *
     * @param xJob_Family
     *     The new value of xJob_Family. 
     * @generated
     */
    public void setXJob_Family( String xJob_Family ){
        this.xJob_Family = xJob_Family;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the ixFullTime_PartTIme attribute. 
     *
     * @generated
     */
    @Column(name=ixFullTime_PartTImeColumn)
    @DataType(jdbcType=ixFullTime_PartTImeJdbcType, precision=ixFullTime_PartTImePrecision)
    public String getIxFullTime_PartTIme (){
        return ixFullTime_PartTIme;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the ixFullTime_PartTIme attribute. 
     *
     * @param ixFullTime_PartTIme
     *     The new value of IxFullTime_PartTIme. 
     * @generated
     */
    public void setIxFullTime_PartTIme( String ixFullTime_PartTIme ){
        this.ixFullTime_PartTIme = ixFullTime_PartTIme;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xStandard_Hours attribute. 
     *
     * @generated
     */
    @Column(name=xStandard_HoursColumn)
    @DataType(jdbcType=xStandard_HoursJdbcType, precision=xStandard_HoursPrecision)
    public String getXStandard_Hours (){
        return xStandard_Hours;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xStandard_Hours attribute. 
     *
     * @param xStandard_Hours
     *     The new value of xStandard_Hours. 
     * @generated
     */
    public void setXStandard_Hours( String xStandard_Hours ){
        this.xStandard_Hours = xStandard_Hours;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xBusiness_Unit attribute. 
     *
     * @generated
     */
    @Column(name=xBusiness_UnitColumn)
    @DataType(jdbcType=xBusiness_UnitJdbcType, precision=xBusiness_UnitPrecision)
    public String getXBusiness_Unit (){
        return xBusiness_Unit;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xBusiness_Unit attribute. 
     *
     * @param xBusiness_Unit
     *     The new value of xBusiness_Unit. 
     * @generated
     */
    public void setXBusiness_Unit( String xBusiness_Unit ){
        this.xBusiness_Unit = xBusiness_Unit;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xHire_Date attribute. 
     *
     * @generated
     */
    @Column(name=xHire_DateColumn)
    @DataType(jdbcType=xHire_DateJdbcType)
    public Date getXHire_Date (){
        return xHire_Date;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xHire_Date attribute. 
     *
     * @param xHire_Date
     *     The new value of xHire_Date. 
     * @generated
     */
    public void setXHire_Date( Date xHire_Date ){
        this.xHire_Date = xHire_Date;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xEmployee_Role_Status attribute. 
     *
     * @generated
     */
    @Column(name=xEmployee_Role_StatusColumn)
    @DataType(jdbcType=xEmployee_Role_StatusJdbcType, precision=xEmployee_Role_StatusPrecision)
    public String getXEmployee_Role_Status (){
        return xEmployee_Role_Status;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xEmployee_Role_Status attribute. 
     *
     * @param xEmployee_Role_Status
     *     The new value of xEmployee_Role_Status. 
     * @generated
     */
    public void setXEmployee_Role_Status( String xEmployee_Role_Status ){
        this.xEmployee_Role_Status = xEmployee_Role_Status;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xRehire_Date attribute. 
     *
     * @generated
     */
    @Column(name=xRehire_DateColumn)
    @DataType(jdbcType=xRehire_DateJdbcType)
    public Date getXRehire_Date (){
        return xRehire_Date;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xRehire_Date attribute. 
     *
     * @param xRehire_Date
     *     The new value of xRehire_Date. 
     * @generated
     */
    public void setXRehire_Date( Date xRehire_Date ){
        this.xRehire_Date = xRehire_Date;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xTermination_Date attribute. 
     *
     * @generated
     */
    @Column(name=xTermination_DateColumn)
    @DataType(jdbcType=xTermination_DateJdbcType)
    public Date getXTermination_Date (){
        return xTermination_Date;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xTermination_Date attribute. 
     *
     * @param xTermination_Date
     *     The new value of xTermination_Date. 
     * @generated
     */
    public void setXTermination_Date( Date xTermination_Date ){
        this.xTermination_Date = xTermination_Date;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_ID attribute. 
     *
     * @generated
     */
    @Column(name=xDepartment_IDColumn)
    @DataType(jdbcType=xDepartment_IDJdbcType, precision=xDepartment_IDPrecision)
    public String getXDepartment_ID (){
        return xDepartment_ID;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_ID attribute. 
     *
     * @param xDepartment_ID
     *     The new value of xDepartment_ID. 
     * @generated
     */
    public void setXDepartment_ID( String xDepartment_ID ){
        this.xDepartment_ID = xDepartment_ID;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDepartment_Name attribute. 
     *
     * @generated
     */
    @Column(name=xDepartment_NameColumn)
    @DataType(jdbcType=xDepartment_NameJdbcType, precision=xDepartment_NamePrecision)
    public String getXDepartment_Name (){
        return xDepartment_Name;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDepartment_Name attribute. 
     *
     * @param xDepartment_Name
     *     The new value of xDepartment_Name. 
     * @generated
     */
    public void setXDepartment_Name( String xDepartment_Name ){
        this.xDepartment_Name = xDepartment_Name;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xService_Line_Financial_Budgetary attribute. 
     *
     * @generated
     */
    @Column(name=xService_Line_Financial_BudgetaryColumn)
    @DataType(jdbcType=xService_Line_Financial_BudgetaryJdbcType, precision=xService_Line_Financial_BudgetaryPrecision)
    public String getXService_Line_Financial_Budgetary (){
        return xService_Line_Financial_Budgetary;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xService_Line_Financial_Budgetary attribute. 
     *
     * @param xService_Line_Financial_Budgetary
     *     The new value of xService_Line_Financial_Budgetary. 
     * @generated
     */
    public void setXService_Line_Financial_Budgetary( String xService_Line_Financial_Budgetary ){
        this.xService_Line_Financial_Budgetary = xService_Line_Financial_Budgetary;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xGender_Source attribute. 
     *
     * @generated
     */
    @Column(name=xGender_SourceColumn)
    @DataType(jdbcType=xGender_SourceJdbcType, precision=xGender_SourcePrecision)
    public String getXGender_Source (){
        return xGender_Source;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xGender_Source attribute. 
     *
     * @param xGender_Source
     *     The new value of xGender_Source. 
     * @generated
     */
    public void setXGender_Source( String xGender_Source ){
        this.xGender_Source = xGender_Source;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xGender_LastVerifiedDate attribute. 
     *
     * @generated
     */
    @Column(name=xGender_LastVerifiedDateColumn)
    @DataType(jdbcType=xGender_LastVerifiedDateJdbcType)
    public Timestamp getXGender_LastVerifiedDate (){
        return xGender_LastVerifiedDate;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xGender_LastVerifiedDate attribute. 
     *
     * @param xGender_LastVerifiedDate
     *     The new value of xGender_LastVerifiedDate. 
     * @generated
     */
    public void setXGender_LastVerifiedDate( Timestamp xGender_LastVerifiedDate ){
        this.xGender_LastVerifiedDate = xGender_LastVerifiedDate;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xMaritalStatus_Source attribute. 
     *
     * @generated
     */
    @Column(name=xMaritalStatus_SourceColumn)
    @DataType(jdbcType=xMaritalStatus_SourceJdbcType, precision=xMaritalStatus_SourcePrecision)
    public String getXMaritalStatus_Source (){
        return xMaritalStatus_Source;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xMaritalStatus_Source attribute. 
     *
     * @param xMaritalStatus_Source
     *     The new value of xMaritalStatus_Source. 
     * @generated
     */
    public void setXMaritalStatus_Source( String xMaritalStatus_Source ){
        this.xMaritalStatus_Source = xMaritalStatus_Source;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xMaritalStatus_LastVerifiedDate attribute. 
     *
     * @generated
     */
    @Column(name=xMaritalStatus_LastVerifiedDateColumn)
    @DataType(jdbcType=xMaritalStatus_LastVerifiedDateJdbcType)
    public Timestamp getXMaritalStatus_LastVerifiedDate (){
        return xMaritalStatus_LastVerifiedDate;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xMaritalStatus_LastVerifiedDate attribute. 
     *
     * @param xMaritalStatus_LastVerifiedDate
     *     The new value of xMaritalStatus_LastVerifiedDate. 
     * @generated
     */
    public void setXMaritalStatus_LastVerifiedDate( Timestamp xMaritalStatus_LastVerifiedDate ){
        this.xMaritalStatus_LastVerifiedDate = xMaritalStatus_LastVerifiedDate;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xEmploymentData_Source attribute. 
     *
     * @generated
     */
    @Column(name=xEmploymentData_SourceColumn)
    @DataType(jdbcType=xEmploymentData_SourceJdbcType, precision=xEmploymentData_SourcePrecision)
    public String getXEmploymentData_Source (){
        return xEmploymentData_Source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xEmploymentData_Source attribute. 
     *
     * @param xEmploymentData_Source
     *     The new value of xEmploymentData_Source. 
     * @generated
     */
    public void setXEmploymentData_Source( String xEmploymentData_Source ){
        this.xEmploymentData_Source = xEmploymentData_Source;
    
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xEmploymentData_LastVerifiedDate attribute. 
     *
     * @generated
     */
    @Column(name=xEmploymentData_LastVerifiedDateColumn)
    @DataType(jdbcType=xEmploymentData_LastVerifiedDateJdbcType)
    public Timestamp getXEmploymentData_LastVerifiedDate (){
        return xEmploymentData_LastVerifiedDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xEmploymentData_LastVerifiedDate attribute. 
     *
     * @param xEmploymentData_LastVerifiedDate
     *     The new value of xEmploymentData_LastVerifiedDate. 
     * @generated
     */
    public void setXEmploymentData_LastVerifiedDate( Timestamp xEmploymentData_LastVerifiedDate ){
        this.xEmploymentData_LastVerifiedDate = xEmploymentData_LastVerifiedDate;
    
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
    this.setContIdPK((Long)aUniqueId);
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
    return this.getContIdPK();
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


