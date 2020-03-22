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
 * IBM-MDMWB-1.0-[fc54b42eebb573f01908425b26efb0f4]
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
 * The entity object corresponding to the xNWContactMethod business object. This
 * entity object should include all the attributes as defined by the business
 * object.
 * 
 * @generated
 */
@SuppressWarnings("serial")
@Table(name=EObjxNWContactMethodExt.tableName)
public class EObjxNWContactMethodExt extends EObjCommon {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String tableName = "CONTACTMETHOD";
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xExtensionColumn = "X_EXTENSION";
  
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final String xExtensionJdbcType = "VARCHAR";
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int    xExtensionPrecision = 100;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Long contactMethodIdPK;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String xExtension;


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
    public EObjxNWContactMethodExt(EObjCommon baseEntity) {
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
    public EObjxNWContactMethodExt() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the contactMethodIdPK attribute. 
     *
     * @generated
     **/
	public Long getContactMethodIdPK (){
      return contactMethodIdPK;
  }
	 
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the contactMethodIdPK attribute. 
     *
     * @param contactMethodIdPK
     *     The new value of contactMethodIdPK. 
     * @generated
     */
    public void setContactMethodIdPK( Long contactMethodIdPK ){
    this.contactMethodIdPK = contactMethodIdPK;
  }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Gets the xExtension attribute. 
     *
     * @generated
     */
    @Column(name=xExtensionColumn)
    @DataType(jdbcType=xExtensionJdbcType, precision=xExtensionPrecision)
    public String getXExtension (){
        return xExtension;
    }
     
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * Sets the xExtension attribute. 
     *
     * @param xExtension
     *     The new value of xExtension. 
     * @generated
     */
    public void setXExtension( String xExtension ){
        this.xExtension = xExtension;
    
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
    this.setContactMethodIdPK((Long)aUniqueId);
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
    return this.getContactMethodIdPK();
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


