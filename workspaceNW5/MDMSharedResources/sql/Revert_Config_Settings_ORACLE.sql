UPDATE JAVAIMPL SET JAVA_CLASSNAME = 'com.dwl.tcrm.externalrule.PartyUpdateExtRule', LAST_UPDATE_DT=CURRENT_DATE WHERE EXT_RULE_IMPL_ID = 1005;
UPDATE JAVAIMPL SET JAVA_CLASSNAME = 'com.dwl.tcrm.externalrule.SuspectAddPartyRule', LAST_UPDATE_DT=CURRENT_DATE WHERE EXT_RULE_IMPL_ID = 1032;
UPDATE JAVAIMPL SET JAVA_CLASSNAME = 'com.dwl.tcrm.externalrule.CollapsePartiesWithRules', LAST_UPDATE_DT=CURRENT_DATE WHERE EXT_RULE_IMPL_ID = 1038;
UPDATE JAVAIMPL SET JAVA_CLASSNAME = 'com.dwl.tcrm.externalrule.CollapseMultiplePartiesRule', LAST_UPDATE_DT=CURRENT_DATE WHERE EXT_RULE_IMPL_ID = 10119;

UPDATE CONFIGELEMENT SET VALUE = 'ContractRoleLocationPrivPref, Address, ContactMethod, FinancialProfile, IncomeSource, PartyAddressPrivPref, PartyContactMethodPrivPref, PartyLobRelationship, PartyLocationPrivPref, PartyPrivPref, PartyAddressPrivPref, PartyContactMethodPrivPref, AccessDateValue, AdminContEquiv, EntityInstancePrivPref, ProductSpecValueBObj' 
WHERE NAME = '/IBM/DWLCommonServices/Validation/BusinessKeyValidation/ExcludeList/groupNames';

UPDATE CONFIGELEMENT SET VALUE = 'false' WHERE NAME = '/IBM/DWLCommonServices/Notifications/enabled';

alter trigger U_AERESS enable;
alter trigger D_AERESS enable;
alter trigger U_POARCH enable;
alter trigger D_POARCH enable;
alter trigger D_PONAME enable;
alter trigger U_PONAME enable;

ALTER TABLE PERSONNAME MODIFY LAST_NAME VARCHAR2(30);
ALTER TABLE PERSONSEARCH MODIFY LAST_NAME VARCHAR2(30);
ALTER TABLE H_PERSONNAME MODIFY LAST_NAME VARCHAR2(30);
ALTER TABLE H_PERSONSEARCH MODIFY LAST_NAME VARCHAR2(30);

COMMIT;