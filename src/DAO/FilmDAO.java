package DAO;

import fc.Client;
import fc.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class FilmDAO extends DAO<Film> {

    public FilmDAO(Connection conn){
           super(conn);
    }

    @Override
    public boolean create(Film obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<Film> read(Object obj) throws SQLException {
        Client c = (Client)obj;
        Vector<Film> liste_film = new Vector<Film>();

        try (PreparedStatement typeClient = conn.prepareStatement("SELECT typeClient FROM Client WHERE noClient = ?)");
        PreparedStatement noFilm = conn.prepareStatement("SELECT noFilm FROM FILM)"); 
        PreparedStatement noFilmEnfant = conn.prepareStatement("(SELECT noFilm FROM FILM) MINUS (SELECT DISTINCT g.noFilm FROM Restriction r, Genre g where r.genre = g.genre and r.noclient = ?");
        PreparedStatement info_Film = conn.prepareStatement("SELECT * FROM Film WHERE noFilm = ?");
        PreparedStatement genre_Film = conn.prepareStatement("SELECT genre FROM Genre WHERE noFilm = ?");
        PreparedStatement acteur_Film = conn.prepareStatement("SELECT nomActeur, prenomActeur FROM Acteuur WHERE noFilm = ?");){
        
        typeClient.setInt(1, obj.get_id());
        ResultSet res1 = typeClient.executeQuery();
        String Type;

        if (res1.next()) {
            Type = res1.getString(1);
        }

        ResultSet Liste_noFilm;

        if (Type == "Abonne Enfant"){
            noFilmEnfant.setInt(1, obj.get_id());
            Liste_noFilm = noFilmEnfant.executeQuery();
        }else{
            Liste_noFilm = noFilm.executeQuery();
        }

        while (Liste_noFilm.next()) {

            Vector<String> Acteur = new Vector<String>();
            Vector<String> Genre = new Vector<String>();

            

            Film f = new Film(0, Type, Type, null, Type, null, 0, 0);
            liste_film.add(f);
		}
        

        (PreparedStatement lesEmployes = conn.prepareStatement("SELECT NOME, ADRESSE FROM LESEMPLOYES WHERE NOME = ?");
		     PreparedStatement lesGardiens = conn.prepareStatement("SELECT NOCAGE FROM LESGARDIENS WHERE NOME = ?");
		     PreparedStatement lesSpecialites = conn.prepareStatement("SELECT FONCTION_CAGE FROM LESSPECIALITES WHERE NOME = ?")) {
			lesEmployes.setString(1, (String)g);
			ResultSet resultSet = lesEmployes.executeQuery();

			gardien = new Gardien();
			if (resultSet.next()) {
				gardien.setNomE(resultSet.getString(1));
				gardien.setAdresse(resultSet.getString(2));
			}

			lesGardiens.setString(1, (String)g);
			resultSet = lesGardiens.executeQuery();
			while (resultSet.next()) {
				Cage c = new Cage();
				c.setNoCage(resultSet.getInt(1));
				gardien.addCage(c);
			}

			lesSpecialites.setString(1, (String)g);
			resultSet = lesSpecialites.executeQuery();
			while (resultSet.next()) {
				gardien.addSpecialites(resultSet.getString(1));
			}
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return null;
    }

    @Override
    public boolean update(Film obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Film obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}

