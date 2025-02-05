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
 * IBM-MDMWB-1.0-[1e07989e33d85a0280da0cad0307ce7b]
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
 * The entity object corresponding to the xNWPersonName business object. This
 * entity object should include all the attributes as defined by the business
 * object.
 * 
 * @generated
 */
@SuppressWarnings("serial")
@Table(name=EObjxNWPersonNameExt.tableName)
public class EObjxNWPersonNameExt extends EObjCommon {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String tableName = "PERSONNAME";
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String x_Full_NameColumn = "X_FULL_NAME";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String x_Full_NameJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    x_Full_NamePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDegreeColumn = "X_DEGREE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDegreeJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDegreePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDegree_SourceColumn = "X_DEGREE_SOURCE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDegree_SourceJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xDegree_SourcePrecision = 250;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDegree_LastVerifiedDateColumn = "X_DEGREE_LAST_VERIFIED_DATE";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xDegree_LastVerifiedDateJdbcType = "TIMESTAMP";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Long personNameIdPK;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String x_Full_Name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDegree;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xDegree_Source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected  Timestamp xDegree_LastVerifiedDate;
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
    public EObjxNWPersonNameExt(EObjCommon baseEntity) {
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
    public EObjxNWPersonNameExt() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the personNameIdPK attribute. 
     *
     * @generated
     **/
	public Long getPersonNameIdPK (){
      return personNameIdPK;
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the personNameIdPK attribute. 
     *
     * @param personNameIdPK
     *     The new value of personNameIdPK. 
     * @generated
     */
    public void setPersonNameIdPK( Long personNameIdPK ){
    this.personNameIdPK = personNameIdPK;
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the x_Full_Name attribute. 
     *
     * @generated
     */
    @Column(name=x_Full_NameColumn)
    @DataType(jdbcType=x_Full_NameJdbcType, precision=x_Full_NamePrecision)
    public String getX_Full_Name (){
        return x_Full_Name;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the x_Full_Name attribute. 
     *
     * @param x_Full_Name
     *     The new value of x_Full_Name. 
     * @generated
     */
    public void setX_Full_Name( String x_Full_Name ){
        this.x_Full_Name = x_Full_Name;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDegree attribute. 
     *
     * @generated
     */
    @Column(name=xDegreeColumn)
    @DataType(jdbcType=xDegreeJdbcType, precision=xDegreePrecision)
    public String getXDegree (){
        return xDegree;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDegree attribute. 
     *
     * @param xDegree
     *     The new value of xDegree. 
     * @generated
     */
    public void setXDegree( String xDegree ){
        this.xDegree = xDegree;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDegree_Source attribute. 
     *
     * @generated
     */
    @Column(name=xDegree_SourceColumn)
    @DataType(jdbcType=xDegree_SourceJdbcType, precision=xDegree_SourcePrecision)
    public String getXDegree_Source (){
        return xDegree_Source;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDegree_Source attribute. 
     *
     * @param xDegree_Source
     *     The new value of xDegree_Source. 
     * @generated
     */
    public void setXDegree_Source( String xDegree_Source ){
        this.xDegree_Source = xDegree_Source;
    
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xDegree_LastVerifiedDate attribute. 
     *
     * @generated
     */
    @Column(name=xDegree_LastVerifiedDateColumn)
    @DataType(jdbcType=xDegree_LastVerifiedDateJdbcType)
    public Timestamp getXDegree_LastVerifiedDate (){
        return xDegree_LastVerifiedDate;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xDegree_LastVerifiedDate attribute. 
     *
     * @param xDegree_LastVerifiedDate
     *     The new value of xDegree_LastVerifiedDate. 
     * @generated
     */
    public void setXDegree_LastVerifiedDate( Timestamp xDegree_LastVerifiedDate ){
        this.xDegree_LastVerifiedDate = xDegree_LastVerifiedDate;
    
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
    this.setPersonNameIdPK((Long)aUniqueId);
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
    return this.getPersonNameIdPK();
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


