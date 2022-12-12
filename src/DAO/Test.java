package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.Vector;
import java.util.*;

import fc.*;

public class Test {
	public static boolean drop_table(Connection conn) throws SQLException {
		conn.setAutoCommit(true);
				
		Vector<String> drop = new Vector<String>();
		System.out.println("drop");
		drop.add("Genre");
		drop.add("Restriction");
		drop.add("Acteur");
		drop.add("DVD");
		drop.add("AbonneEnfant");
		drop.add("CarteBancaire");
		drop.add("AbonneParent");
		drop.add("Abonne");
		drop.add("Location");
		drop.add("Client");
		drop.add("Support");
		drop.add("Film");
		drop.add("TypeGenre");
		
		for (int i = 0; i < drop.size(); i++){
			
			System.out.print(drop.get(i));
			conn.prepareStatement("Drop table " + drop.get(i)).execute();
		}
		
		return false;
	}
	
	public static boolean init_table(Connection conn) throws SQLException {
		
		conn.setAutoCommit(true);
		
		System.out.println("Create");
		Vector<String> table = new Vector<String>();
		table.add("Client (\r\n"
				+ "    noClient number(10) primary key check (noClient between 1 and 9999999999),\r\n"
				+ "    typeClient varchar2(20) check (typeClient in ('Abonne Parent', 'Abonne Enfant', 'Sans Carte'))\r\n"
				+ ")");
				
		table.add("Film (\r\n"
				+ "    noFilm number(10) primary key check (noFilm between 1 and 9999999999),\r\n"
				+ "    titreFilm varchar2(20),\r\n"
				+ "    nomRealisateur varchar2(20),\r\n"
				+ "    dateSortie number(4),\r\n"
				+ "    resume varchar2(1000),\r\n"
				+ "    restrictionAge number(2) check (restrictionAge in (10, 12, 16, 18, 0)),\r\n"
				+ "    nbLoue number(10)\r\n"
				+ ")");
		table.add("TypeGenre (\r\n"
				+ "    genre varchar2(20) primary key\r\n"
				+ ")");
		table.add("Support (\r\n"
				+ "    noSupport number(10) primary key check (noSupport between 1 and 9999999999),\r\n"
				+ "    noFilm number(10) references Film(noFilm),\r\n"
				+ "    typeSupport varchar2(20) check (typeSupport in ('QRCode', 'DVD'))\r\n"
				+ ")");
		table.add("\r\n"
				+ "Location (\r\n"
				+ "    noClient number(10) references Client(noClient),\r\n"
				+ "    noSupport number(10) references Support(noSupport),\r\n"
				+ "    dateEmprunt date,\r\n"
				+ "    retourne number(1) check (retourne between 0 and 1),\r\n"
				+ "    dateRetour date,\r\n"
				+ "    primary key (noClient, noSupport, dateEmprunt)\r\n"
				+ ")");
		table.add("Abonne (\r\n"
				+ "    noClient number(10) references Client(noClient),\r\n"
				+ "    nomAbonne varchar2(20),\r\n"
				+ "    prenomAbonne varchar2(20),\r\n"
				+ "    adAbonne varchar2(100),\r\n"
				+ "    noTel varchar(11),\r\n"
				+ "    solde number(4),\r\n"
				+ "    primary key (noClient)\r\n"
				+ ")");
		table.add("CarteBancaire(\r\n"
				+ "    noClient number(10) references Client(noClient),\r\n"
				+ "    nomBanque varchar2(20),\r\n"
				+ "    typeCarte varchar2(20),\r\n"
				+ "    refBancaire varchar(12),\r\n"
				+ "    dateUtil date,\r\n"
				+ "    primary key (noClient)\r\n"
				+ ")");
		table.add("AbonneParent (\r\n"
				+ "    noClient number(10) references Abonne(noClient),\r\n"
				+ "    nbEnfant number(2) check (nbEnfant between 0 and 99),\r\n"
				+ "    primary key (noClient)\r\n"
				+ ")");
		table.add("AbonneEnfant (\r\n"
				+ "    noClient number(10) references Abonne(noClient),\r\n"
				+ "    noParent number(10) references AbonneParent(noClient),\r\n"
				+ "    restrictionAge number(2) check (restrictionAge in (10, 12, 16, 18, 0)),\r\n"
				+ "    primary key (noClient)\r\n"
				+ ")");
		table.add("Genre (\r\n"
				+ "    noFilm number(10) references Film(noFilm),\r\n"
				+ "    genre varchar2(20) references TypeGenre(Genre),\r\n"
				+ "    primary key (noFilm, genre)\r\n"
				+ ")");
		table.add("Restriction (\r\n"
				+ "    noClient number(10) references AbonneEnfant(noClient),\r\n"
				+ "    genre varchar2(20) references TypeGenre(genre),\r\n"
				+ "    primary key (noClient, genre)\r\n"
				+ ")");
		table.add("Acteur (\r\n"
				+ "    noFilm number(10) references Film(noFilm),\r\n"
				+ "    nomActeur varchar2(20),\r\n"
				+ "    prenomActeur varchar2(20),\r\n"
				+ "    primary key (noFilm, nomActeur, prenomActeur)\r\n"
				+ ")");
		table.add("DVD (\r\n"
				+ "    noSupport number(10) references Support(noSupport),\r\n"
				+ "    etat varchar2(20) check (etat in ('Endommage', 'Bon')),\r\n"
				+ "    emplacement number(3),\r\n"
				+ "    primary key (noSupport)\r\n"
				+ ")");
		
		
		try {   
            for (int i = 0; i < table.size(); i++){
				conn.prepareStatement("Create table " + table.get(i)).execute();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	public static boolean insert_table(Connection conn) throws SQLException {
		conn.setAutoCommit(true);
				
		System.out.println("insert");

		conn.prepareStatement("insert into Film values (1, 'Totoro', 'Eva', 2000, 'totoro', 0, 0)").execute();
		conn.prepareStatement("insert into Film values (2, 'Avenger', 'Eva', 2000, 'superheros', 0, 0)").execute();

		conn.prepareStatement("insert into TypeGenre values ('Action')").execute();
		conn.prepareStatement("insert into TypeGenre values ('Fanstastique')").execute();
		conn.prepareStatement("insert into TypeGenre values ('Aventure')").execute();

		conn.prepareStatement("insert into Genre values (2, 'Action')").execute();
		conn.prepareStatement("insert into Genre values (2, 'Fanstastique')").execute();
		conn.prepareStatement("insert into Genre values (1, 'Fanstastique')").execute();

		conn.prepareStatement("insert into Support values (1, 1, 'DVD')").execute();
		conn.prepareStatement("insert into Support values (2, 1, 'DVD')").execute();
		conn.prepareStatement("insert into Support values (3, 1, 'DVD')").execute();
		conn.prepareStatement("insert into Support values (4, 2, 'DVD')").execute();

		conn.prepareStatement("insert into Client values (1, 'Sans Carte')").execute();
		conn.prepareStatement("insert into Client values (2, 'Abonne Parent')").execute();
		conn.prepareStatement("insert into Client values (3, 'Sans Carte')").execute();
		conn.prepareStatement("insert into Client values (5, 'Abonne Parent')").execute();
		conn.prepareStatement("insert into Client values (6, 'Abonne Enfant')").execute();
		conn.prepareStatement("insert into Client values (7, 'Abonne Enfant')").execute();

		conn.prepareStatement("insert into CarteBancaire values (1,'UGA', 'Etudiant','42' ,SYSDATE)").execute();

		conn.prepareStatement("insert into Abonne values (2, 'André', 'Paul', 'Grenoble', '0000000000', 15)").execute();
		conn.prepareStatement("insert into Abonne values (5, 'GAILLARD', 'Eva', 'Grenoble', '0000000000', 15)").execute();
		conn.prepareStatement("insert into Abonne values (6, 'ZAGHDAR', 'Bouchra', 'Grenoble', '0000000000', 15)").execute();
		conn.prepareStatement("insert into Abonne values (7, 'BERENGUIER', 'Lucas', 'Grenoble', '0000000000', 15)").execute();
		
		conn.prepareStatement("insert into AbonneParent values (2, 0)").execute();
		conn.prepareStatement("insert into AbonneParent values (5, 0)").execute();

		conn.prepareStatement("insert into AbonneEnfant values (6, 5, 0)").execute();
		conn.prepareStatement("insert into AbonneEnfant values (7, 5, 0)").execute();

		conn.prepareStatement("insert into Restriction values (6, 'Action')").execute();

		conn.prepareStatement("insert into Location values (1, 1, SYSDATE, 0, null)").execute();
		conn.prepareStatement("insert into Location values (2, 2, SYSDATE, 0, null)").execute();
		
		conn.prepareStatement("insert into DVD values (1, 'Bon', 1)").execute();
		conn.prepareStatement("insert into DVD values (2, 'Bon', 2)").execute();
		conn.prepareStatement("insert into DVD values (3, 'Bon', 3)").execute();
		conn.prepareStatement("insert into DVD values (4, 'Bon', 4)").execute();

		//conn.prepareStatement("").execute();

		return false;
	}

	public static boolean initialisation (Connection conn) throws SQLException{	
		drop_table(conn);
        init_table(conn);
		insert_table(conn);
		return false;
	}

    public static void main(String argv[]) throws SQLException{
        Session s = new Session();
        s.open();
        initialisation(Session.getSession());
        
        ClientDAO Client = new ClientDAO(Session.getSession());
		AbonneDAO A = new AbonneDAO(Session.getSession());
		AbonneEnfantDAO Ae = new AbonneEnfantDAO(Session.getSession());
		AbonneParentDAO Ap = new AbonneParentDAO(Session.getSession());
		FilmDAO F = new FilmDAO(Session.getSession());
		DVDDAO D = new DVDDAO(Session.getSession());
		LocationDAO L = new LocationDAO(Session.getSession());
		GenreDAO G = new GenreDAO(Session.getSession());

		Abonne_parent parent = new Abonne_parent(10, "Test", "prenom", "adresse", "telephone", 15, null, null, null, null);
		Client.create(parent, "Abonne Parent");

		Vector<Abonne_enfant> Abonne_e = Ae.read(6);
		System.out.println(Abonne_e.size());
		Abonne_enfant enfant = Abonne_e.get(0);
		
		enfant.add_restriction_categorie("Aventure");
		enfant.add_restriction_age(0);
		Ae.update(enfant);
		System.out.println("Mise à jour des restriction");
		System.out.println("Id enfant " + enfant.get_id());
		
		Vector<Abonne_parent> Abonne_p = Ap.read(10);
		System.out.println(Abonne_p.size());

		
		Vector<Film> film_p = F.read(parent);
		System.out.println("Film parent :" + film_p.size());
		assert(film_p.size() == 2);
		
		Vector<Film> film_e = F.read(enfant);
		System.out.println("Film Enfant : " + film_e.size());
		assert(film_e.size() == 1);
		
		Film f = film_p.get(0);
		Vector<DVD> Dvd = D.read(f);
		System.out.println("Nombre de DVD dispo : " + Dvd.size());
		assert(Dvd.size() == 2);

		DVD d = Dvd.get(0);
		
		/*
		Historique h = new Historique(f, new Date(), null);
		Location loc = new Location(parent, h, d);
		L.create(loc , null);
		System.out.println("Louer");
		loc.retour();
		L.update(loc);
		System.out.println("Rendu");
		*/
		D.update(d);
		System.out.println("Endommage");
		A.update(enfant);
		System.out.println("Abonne");

		Vector<String> Genre = G.read(null);
		System.out.println(Genre.size());

        s.close();

    }
}