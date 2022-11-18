start Table.sql

insert into Client values (1, 'Sans Carte');
insert into Client values (2, 'Abonne Parent');
insert into Client values (3, 'Sans Carte');
insert into Client values (4, 'Sans Carte');
insert into Client values (5, 'Abonne Parent');
insert into Client values (6, 'Abonne Enfant');
insert into Client values (7, 'Abonne Enfant');
insert into Client values (8, 'Abonne Parent');
-- insert into Client values (8, 'Abonne Enfant');
-- insert into Client values (9, 'Abonne');

insert into CarteBancaire values (1,'UGA', 'Etudiant','42' ,SYSDATE);

insert into Abonne values (2, 'André', 'Paul', 'Grenoble', '0000000000', 15);
insert into Abonne values (6, 'ZAGHDAR', 'Bouchra', 'Grenoble', '0000000000', 15);
insert into Abonne values (5, 'GAILLARD', 'Eva', 'Grenoble', '0000000000', 15);
insert into Abonne values (7, 'BERENGUIER', 'Lucas', 'Grenoble', '0000000000', 15);

-- insert into Abonne values(8, 'BR', 'Juju', 'Grenoble', '0000000000', 10);
-- insert into Abonne values(7, 'BR', 'Juju', 'Grenoble', '0000000000', 15);

insert into AbonneParent values (2, 0);
insert into AbonneParent values (5, 0);

insert into AbonneEnfant values (6, 5, 0);
insert into AbonneEnfant values (7, 5, 0);

-- Faire en sorte qu'un abonne ne peut être que dans son type
-- insert into AbonneParent values (6, 5, 0);

