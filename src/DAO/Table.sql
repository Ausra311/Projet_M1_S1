drop table Client;
drop table CarteBancaire;
drop table Location;
drop table Abonne;
drop table AbonneParent;
drop table AbonneEnfant;
drop table Film;
drop table Genre;
drop table TypeGenre;
drop table Restriction;
drop table Acteur;
drop table Support;
drop table DVD;

Create table Client (
    noClient integer(10) primary key check (noClient between 1 and 9999999999),
    typeClient varchar2(20) check (typeClient in ('Abonne Parent', 'Abonne Enfant', 'Sans Carte'))
);

Create table CarteBancaire(
    noClient integer(10) references Client(noClient),
    nomBanque varchar2(20),
    typeCarte varchar2(20),
    refBancaire integer(12),
    dateUtil date,
    primary key (noClient)
);

Create table Location (
    noClient integer(10) references Client(noClient),
    noSupport integer(10) references Support(noSupport),
    dateEmprunt date,
    retourne boolean,
    primary key (noClient, noSupport, dateEmprunt)
);

Create table Abonne (
    noClient integer(10) references Client(noClient),
    nomAbonne varchar2(20),
    prenomAbonne varchar2(20),
    adAbonne varchar2(100),
    noTel integer(11),
    solde integer(4),
    primary key (noClient)
);

Create table AbonneParent (
    noClient integer(10) references Abonne(noClient),
    nbEnfant integer(2) check (nbEnfant between 0 and 99),
    primary key (noClient)
);

Create table AbonneEnfant (
    noClient integer(10) references Abonne(noClient),
    noParent integer(10) references AbonneParent(noClient),
    restrictionAge integer(2) check (restrictionAge in (10, 12, 16, 18, 0)),
    primary key (noClient)
);

Create table Film (
    noFilm integer(10) primary key check (noFilm between 1 and 9999999999),
    titreFilm varchar2(20),
    nomRealisateur varchar2(20),
    dateSortie date,
    resume varchar2(1000),
    restrictionAge integer(2),
    nbLoue integer(10)
);

Create table Genre (
    noFilm integer(10) references Film(noFilm),
    genre varchar2(20) references TypeGenre(Genre),
    primary key (noFilm, genre)
);

Create table TypeGenre (
    genre varchar2(20) primary key
);

Create table Restriction (
    noClient integer(10) references AbonneEnfant(noClient),
    genre varchar2(20) references TypeGenre(genre),
    primary key (noClient, genre)
);

Create table Acteur (
    noFilm integer(10) primary key Film(noFilm),
    nomActeur varchar2(20),
    prenomActeur varchar2(20),
    primary key (noFilm, nomActeur, prenomActeur)
);

Create table Support (
    noSupport integer(10) primary key check (noSupport between 1 and 9999999999),
    noFilm integer(10) references Film(noFilm),
    typeSupport varchar2(20) check (typeSupport in ('QRCode', 'DVD'))
);

Create table DVD (
    noSupport integer(10) references Support(noSupport),
    etat varchar2(20) check (etat in ('Endommage', 'Bon')),
    emplacement integer(3),
    primary key (noSupport)
);





