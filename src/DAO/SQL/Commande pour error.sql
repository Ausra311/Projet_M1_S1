-- Remplir les ... pour éxécuter les commandes

-- ORA-02449: unique/primary keys in table referenced by foreign keys 

    -- Récupère la liste des contraintes :
select table_name,CONSTRAINT_NAME from user_constraints
where R_CONSTRAINT_NAME in (select CONSTRAINT_NAME from user_constraints where table_name='...')
and CONSTRAINT_TYPE='R';

    -- drop la contrainte
    alter table ... drop constraint ...;

    -- drop la table en supprimant les FK
    drop table ... cascade constraints;

git config --global user.email "marion.bastard@gmail.com"
git config --global user.name "MarionBaRo"