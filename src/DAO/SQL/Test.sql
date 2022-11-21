start Table.sql

-- Insertion de Client :
insert into Client values (1, 'Sans Carte');
insert into Client values (2, 'Abonne Parent');
insert into Client values (3, 'Sans Carte');
insert into Client values (4, 'Sans Carte');
insert into Client values (5, 'Abonne Parent');
insert into Client values (6, 'Abonne Enfant');
insert into Client values (7, 'Abonne Enfant');
insert into Client values (8, 'Abonne Parent');
-- Doit retourner des erreurs (contraintes):
insert into Client values (8, 'Abonne Enfant');
insert into Client values (9, 'Abonne');

-- Insertion dans CarteBancaire :
insert into CarteBancaire values (1,'UGA', 'Etudiant','42' ,SYSDATE);
insert into CarteBancaire values (3,'UGA', 'Etudiant','44' ,SYSDATE);
-- Doit retourner des erreurs (contraintes):
insert into CarteBancaire values (1,'ENS', 'Etudiant','45' ,SYSDATE);

-- Insertion dans Abonne :
insert into Abonne values (2, 'André', 'Paul', 'Grenoble', '0000000000', 15);
insert into Abonne values (6, 'ZAGHDAR', 'Bouchra', 'Grenoble', '0000000000', 15);
insert into Abonne values (5, 'GAILLARD', 'Eva', 'Grenoble', '0000000000', 15);
insert into Abonne values (7, 'BERENGUIER', 'Lucas', 'Grenoble', '0000000000', 15);
-- Doit retourner des erreurs (Trigger CreationCompte):
insert into Abonne values(8, 'BR', 'Juju', 'Grenoble', '0000000000', 10);
-- Doit retourner des erreurs (contraintes):
insert into Abonne values(7, 'BR', 'Juju', 'Grenoble', '0000000000', 15);

-- Insertion dans AbonneParent :
insert into AbonneParent values (2, 0);
insert into AbonneParent values (5, 0);

-- Insertion dans AbonneEnfant :
insert into AbonneEnfant values (6, 5, 0);
insert into AbonneEnfant values (7, 5, 0);

-- Faire en sorte qu'un abonne ne peut être que dans son type
-- insert into AbonneParent values (6, 5, 0);

-- Insertion dans Film :
insert into Film values (1, 'Totoro', 'Eva', 2000, 'totoro', 0, 0);
insert into Film values (2, 'Avenger', 'Eva', 2000, 'superheros', 0, 0);
-- Doit retourner des erreurs (contraintes):
insert into Film values (1, 'Avenger', 'Eva', 2000, 'superheros', 0, 0);

-- Insertion dans Support :
insert into Support values (1, 1, 'DVD');
insert into Support values (2, 1, 'DVD');
insert into Support values (3, 1, 'DVD');
insert into Support values (4, 2, 'DVD');
insert into Support values (5, 2, 'QRCode');
-- Doit retourner des erreurs (contraintes):
insert into Support values (1, 2, 'DVD');
insert into Support values (6, 2, 'Autre');

-- Insertion dans Location
insert into Location values (1, 1, SYSDATE, 0);
insert into Location values (2, 2, SYSDATE, 0);
insert into Location values (2, 3, SYSDATE, 0);
insert into Location values (2, 4, SYSDATE, 0);
-- Doit retourner des erreurs (Trigger LocationFilm):
insert into Location values (2, 5, SYSDATE, 0);
insert into Location values (1, 5, SYSDATE, 0);
insert into Location values (5, 1, SYSDATE, 0);

update Abonne set solde = 10 where noClient = 6;
insert into Location values (6, 5, SYSDATE, 0);