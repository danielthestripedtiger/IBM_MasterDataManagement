select fk.owner, fk.constraint_name , fk.table_name 
    from all_constraints fk, all_constraints pk 
     where fk.CONSTRAINT_TYPE = 'R' and 
           pk.owner = 'MDMDUSER' and
           fk.r_owner = pk.owner and
           fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME and 
           pk.TABLE_NAME = 'CONTACT'; -- REPLACE CONTACT WITH ANY OTHER TABLE THAT YOU NEED TO FIND CONTRAINTS FOR