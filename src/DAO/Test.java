package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.Vector;

import fc.Abonne_parent;
import fc.Client;
import fc.DVD;

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
			//drop_table.execut();
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
		table.add("Location (\r\n"
				+ "    noClient number(10) references Client(noClient),\r\n"
				+ "    noSupport number(10) references Support(noSupport),\r\n"
				+ "    dateEmprunt date,\r\n"
				+ "    retourne number(1) check (retourne between 0 and 1),\r\n"
				+ "    dateRetour date,\r\n"
				+ "    primary key (noClient, noSupport, dateEmprunt)\r\n"
				+ ")");
		table.add("Abonne ("
				+ "    noClient number(10) references Client(noClient),"
				+ "    nomAbonne varchar2(20),"
				+ "    prenomAbonne varchar2(20),"
				+ "    adAbonne varchar2(100),"
				+ "    noTel varchar(11),"
				+ "    solde number(4),"
				+ "    primary key (noClient)"
				+ ")");
		table.add("CarteBancaire ("
				+ "    noClient number(10) references Client(noClient),"
				+ "    nomBanque varchar2(20),"
				+ "    typeCarte varchar2(20),"
				+ "    refBancaire varchar(12),"
				+ "    dateUtil date,primary key (noClient)"
				+ ")");
		table.add("AbonneParent ("
				+ "noClient number(10) references Abonne(noClient),"
				+ "nbEnfant number(2) check (nbEnfant between 0 and 99),"
				+ "primary key (noClient)"
				+ ")");
		table.add("AbonneEnfant ("
				+ "noClient number(10) references Abonne(noClient),"
				+ "noParent number(10) references AbonneParent(noClient),"
				+ "restrictionAge number(2) check (restrictionAge in (10, 12, 16, 18, 0)),"
				+ "primary key (noClient)"
				+ ")");
		table.add("Genre ("
				+ "noFilm number(10) references Film(noFilm),"
				+ "genre varchar2(20) references TypeGenre(Genre),"
				+ "primary key (noFilm, genre)"
				+ ")");
		table.add("Restriction ("
				+ "noClient number(10) references AbonneEnfant(noClient),"
				+ "genre varchar2(20) references TypeGenre(genre),"
				+ "primary key (noClient, genre)"
				+ ")");
		table.add("Acteur ("
				+ "noFilm number(10) references Film(noFilm),"
				+ "nomActeur varchar2(20),"
				+ "prenomActeur varchar2(20),"
				+ "primary key (noFilm, nomActeur, prenomActeur)"
				+ ")");
		table.add("DVD ("
				+ "noSupport number(10) references Support(noSupport),"
				+ "etat varchar2(20) check (etat in ('Endommage', 'Bon')),"
				+ "emplacement number(3),"
				+ "primary key (noSupport)"
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

	public static boolean initialisation (Connection conn) throws SQLException{	
		drop_table(conn);
        init_table(conn);
		return false;
	}

    public static void main(String argv[]) throws SQLException{
        Session s = new Session();
        s.open();
        drop_table(Session.getSession());
        init_table(Session.getSession());

        ClientDAO Client = new ClientDAO(Session.getSession());
		Abonne_parent Abonne_p = new Abonne_parent(10, "Test", "prenom", "adresse", "telephone", 15, null, null, null, null);
		Client.create(Abonne_p, "Abonne_parent");
		
        s.close();
    }
}