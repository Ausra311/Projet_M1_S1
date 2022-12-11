package DAO;

import fc.Client;
import fc.Abonne_enfant;
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
        int Id;
        String titre;
        String realisateur;
        Vector<String> L_acteurs;
        String resume;
        Vector<String> genre;
        int restriction;
        int nb_location;
        String acteur;
        Film f;


        try (PreparedStatement typeClient = conn.prepareStatement("SELECT typeClient FROM Client WHERE noClient = ?)");
        PreparedStatement noFilm = conn.prepareStatement("SELECT noFilm FROM FILM)"); 
        PreparedStatement noFilmEnfant = conn.prepareStatement("(SELECT noFilm FROM FILM) MINUS (SELECT DISTINCT g.noFilm FROM Restriction r, Genre g where r.genre = g.genre and r.noclient = ?");
        PreparedStatement info_Film = conn.prepareStatement("SELECT * FROM Film WHERE noFilm = ?");
        PreparedStatement genre_Film = conn.prepareStatement("SELECT genre FROM Genre WHERE noFilm = ?");
        PreparedStatement acteur_Film = conn.prepareStatement("SELECT nomActeur, prenomActeur FROM Acteur WHERE noFilm = ?")){
        
            typeClient.setInt(1, c.get_id());
            ResultSet res1 = typeClient.executeQuery();
            String Type;

            if (res1.next()) {
                Type = res1.getString(1);

                ResultSet Liste_noFilm;
                ResultSet Liste_genre, Liste_acteur;

                if (Type == "Abonne Enfant"){
                    noFilmEnfant.setInt(1, c.get_id());
                    Liste_noFilm = noFilmEnfant.executeQuery();
                }else{
                    Liste_noFilm = noFilm.executeQuery();
                }

                while (Liste_noFilm.next()) {
                    if ((Type == "Abonne Enfant") && (((Abonne_enfant)obj).get_age() > 0) && (Liste_noFilm.getInt(6) > ((Abonne_enfant)obj).get_age())){
                        //On ne rentre pas le film dans la liste
                    } else {
                        Id = Liste_noFilm.getInt(1);
                        titre = Liste_noFilm.getString(2);
                        realisateur = Liste_noFilm.getString(3);
                        resume = Liste_noFilm.getString(5);
                        restriction = Liste_noFilm.getInt(6);
                        nb_location = Liste_noFilm.getInt(7);

                        genre = new Vector<String>();
                        genre_Film.setInt(1, Id);
                        Liste_genre = genre_Film.executeQuery();
                        while (Liste_genre.next()) {
                            genre.add(Liste_genre.getString(1));
                        }
                        
                        L_acteurs = new Vector<String>();
                        acteur_Film.setInt(1, Id);
                        Liste_acteur = acteur_Film.executeQuery();
                        while (Liste_acteur.next()) {
                            acteur = Liste_acteur.getString(1) + " " + Liste_acteur.getString(1);
                            L_acteurs.add(acteur);
                        }

                        f = new Film(Id, titre, realisateur, L_acteurs, resume, genre, restriction, nb_location);
                        liste_film.add(f);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste_film;
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

