drop table Genre;
drop table Restriction;
drop table Acteur;
drop table DVD;
drop table AbonneEnfant;
drop table CarteBancaire;
drop table AbonneParent;
drop table Abonne;
drop table Location;
drop table Client;
drop table Support;
drop table Film;
drop table TypeGenre;

Create table Client (
    noClient number(10) primary key check (noClient between 1 and 9999999999),
    typeClient varchar2(20) check (typeClient in ('Abonne Parent', 'Abonne Enfant', 'Sans Carte'))
);

Create table Film (
    noFilm number(10) primary key check (noFilm between 1 and 9999999999),
    titreFilm varchar2(20),
    nomRealisateur varchar2(20),
    dateSortie number(4),
    resume varchar2(1000),
    restrictionAge number(2) check (restrictionAge in (10, 12, 16, 18, 0)),
    nbLoue number(10)
);

Create table TypeGenre (
    genre varchar2(20) primary key
);

Create table Support (
    noSupport number(10) primary key check (noSupport between 1 and 9999999999),
    noFilm number(10) references Film(noFilm),
    typeSupport varchar2(20) check (typeSupport in ('QRCode', 'DVD'))
);

Create table Location (
    noClient number(10) references Client(noClient),
    noSupport number(10) references Support(noSupport),
    dateEmprunt date,
    retourne number(1) check (retourne between 0 and 1),
    dateRetour date;
    primary key (noClient, noSupport, dateEmprunt)
);

Create table Abonne (
    noClient number(10) references Client(noClient),
    nomAbonne varchar2(20),
    prenomAbonne varchar2(20),
    adAbonne varchar2(100),
    noTel number(11),
    solde number(4),
    primary key (noClient)
);

Create table CarteBancaire(
    noClient number(10) references Client(noClient),
    nomBanque varchar2(20),
    typeCarte varchar2(20),
    refBancaire number(12),
    dateUtil date,
    primary key (noClient)
);

Create table AbonneParent (
    noClient number(10) references Abonne(noClient),
    nbEnfant number(2) check (nbEnfant between 0 and 99),
    primary key (noClient)
);

Create table AbonneEnfant (
    noClient number(10) references Abonne(noClient),
    noParent number(10) references AbonneParent(noClient),
    restrictionAge number(2) check (restrictionAge in (10, 12, 16, 18, 0)),
    primary key (noClient)
);

Create table Genre (
    noFilm number(10) references Film(noFilm),
    genre varchar2(20) references TypeGenre(Genre),
    primary key (noFilm, genre)
);

Create table Restriction (
    noClient number(10) references AbonneEnfant(noClient),
    genre varchar2(20) references TypeGenre(genre),
    primary key (noClient, genre)
);

Create table Acteur (
    noFilm number(10) references Film(noFilm),
    nomActeur varchar2(20),
    prenomActeur varchar2(20),
    primary key (noFilm, nomActeur, prenomActeur)
);

Create table DVD (
    noSupport number(10) references Support(noSupport),
    etat varchar2(20) check (etat in ('Endommage', 'Bon')),
    emplacement number(3),
    primary key (noSupport)
);





