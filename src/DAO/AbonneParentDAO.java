package DAO;

<<<<<<< HEAD
import fc.Abonne_enfant;
import fc.Abonne_parent;
import fc.Film;
import fc.Historique;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.*;
=======
import fc.Abonne_parent;
import java.sql.Connection;
import java.sql.SQLException;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
import java.util.Vector;

public class AbonneParentDAO extends DAO<Abonne_parent>{
    
    public AbonneParentDAO(Connection conn) {
		super(conn);
	}

    @Override
    public boolean create(Abonne_parent obj, String type) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Vector<Abonne_parent> read(Object obj) throws SQLException {
        Abonne_parent parent;
        AbonneEnfantDAO EnfantDAO = new AbonneEnfantDAO(conn);
<<<<<<< HEAD
        Vector<Abonne_parent> res = new Vector<Abonne_parent>();

        int id = (int)obj;
=======

        int id = (Int)obj;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        String nom;
        String prenom;
        String adresse;
        String telephone;
        Vector<Historique> film_en_location = new Vector<Historique>();
        Vector<Historique> historique = new Vector<Historique>();
        int solde;
        int nb_film_mensuel = 0;
<<<<<<< HEAD
=======
        int nb_enfant;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        Vector<Abonne_enfant> liste_enfant = new Vector<Abonne_enfant>();

        Film f;
        Vector<String> L_acteurs;
<<<<<<< HEAD
        String acteur;
        Vector<String> genre;
=======
        Vector<String> Genre;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        Calendar date_actuel = Calendar.getInstance();
        Calendar date_location = Calendar.getInstance();

        try (PreparedStatement info_abonne = conn.prepareStatement("select * from Abonne where noClient = ?");
            PreparedStatement info_parent = conn.prepareStatement("select nbEnfant from AbonneParent where noClient = ?");
            PreparedStatement info_enfant = conn.prepareStatement("select noClient from AbonneEnfant where noParent = ?");
            PreparedStatement info_location = conn.prepareStatement("select * from Location where noClient = ?");
            PreparedStatement info_film = conn.prepareStatement("select * from Film where noFilm in (Select noFilm from Support where noSupport = ?)");
            PreparedStatement genre_Film = conn.prepareStatement("SELECT genre FROM Genre WHERE noFilm = ?");
            PreparedStatement acteur_Film = conn.prepareStatement("SELECT nomActeur, prenomActeur FROM Acteuur WHERE noFilm = ?")){   
           
            info_abonne.setInt(1, id);
            info_enfant.setInt(1, id);
            info_parent.setInt(1, id);
            info_location.setInt(1, id);

<<<<<<< HEAD
            ResultSet res_abonne, res_enfant, res_location, res_film, res_genre_film, res_acteur;

            res_abonne = info_abonne.executeQuery();
            res_enfant = info_enfant.executeQuery();
            res_location = info_location.executeQuery();
           
            if (res_abonne.next()){
                nom = res_abonne.getString(2);
                prenom = res_abonne.getString(3);
                adresse = res_abonne.getString(4);
                telephone = res_abonne.getString(5);
                solde = res_abonne.getInt(6);

                while (res_location.next()){
                    
                    info_film.setInt(1, res_location.getInt(2));
                    res_film = info_film.executeQuery();

                    genre = new Vector<String>();
                    genre_Film.setInt(1, res_film.getInt(1));
                    res_genre_film = genre_Film.executeQuery();
                    while (res_genre_film.next()) {
                        genre.add(res_genre_film.getString(1));
                    }
                    
                    L_acteurs = new Vector<String>();
                    acteur_Film.setInt(1, res_film.getInt(1));
                    res_acteur = acteur_Film.executeQuery();
                    while (res_acteur.next()) {
                        acteur = res_acteur.getString(1) + " " + res_acteur.getString(2);
                        L_acteurs.add(acteur);
                    }

                    f = new Film(res_film.getInt(1), res_film.getString(2), res_film.getString(3), L_acteurs, res_film.getString(5), genre, res_film.getInt(6), res_film.getInt(7));

                    if (res_location.getInt(4) == 0){
                        film_en_location.add(new Historique(f, res_location.getDate(3), null));
                        historique.add(new Historique(f, res_location.getDate(3), null));

                    } else {
                        historique.add(new Historique(f, res_location.getDate(3), res_location.getDate(5)));
                    }

                    date_location.setTime(res_location.getDate(3));
                    date_actuel.setTime(new Date());
                
                    if (date_location.get(Calendar.MONTH) == date_actuel.get(Calendar.MONTH)){
                        nb_film_mensuel = nb_film_mensuel + 1;
                    }
                }
                while(res_enfant.next()){
                liste_enfant.addAll(EnfantDAO.read(res_enfant.getInt(1)));
                }

                parent = new Abonne_parent(id, nom, prenom, adresse, telephone, solde, historique, film_en_location, null, liste_enfant);
                res.add(parent);
            }
=======
            ResultSet res_abonne, res_enfant, res_parent, res_location, res_film;

            res_abonne = info_abonne.executeQuery();
            res_enfant = info_enfant.executeQuery();
            res_parent = info_parent.executeQuery();
            res_location = info_location.executeQuery();
           
            nom = res_abonne.getString(2);
            prenom = res_abonne.getString(3);
            adresse = res_abonne.getString(4);
            telephone = res_abonne.getInt(5);
            solde = res_abonne.getInt(6);
            nb_enfant = res_parent.getInt(1);
            
            while (res_location.next()){
                info_film.setInt(1, res_location.getInt(2))
                res_film = info_film.executeQuery();

                Genre = new Vector<String>();
                genre_Film.setInt(1, Liste_noFilm.getInt(1));
                Liste_genre = genre_Film.executeQuery();
                while (Liste_genre.next()) {
                    genre.add(Liste_genre.getString(1))
                }
                
                L_acteurs = new Vector<String>();
                acteur_Film.setInt(1, Liste_noFilm.getInt(1));
                Liste_acteur = acteur_Film.executeQuery();
                while (Liste_acteur.next()) {
                    acteur = Liste_acteur.getString(1) + " " + Liste_acteur.getString(1);
                    L_acteurs.add(acteur);
                }

                f = new Film(Liste_noFilm.getInt(1), Liste_noFilm.getString(2), Liste_noFilm.getString(3), Acteur, Liste_noFilm.getString(5), Genre, Liste_noFilm.getInt(6), Liste_noFilm.getInt(7));

                if (res_location.getInt(4) == 0){
                    film_en_location.add(new historique(f, res_location.getDate(3), null));
                    historique.add(new historique(f, res_location.getDate(3), null));

                } else {
                    historique.add(new historique(f, res_location.getDate(3), res_location.getDate(5)));
                }

                date_location.setTime(res_location.getDate(3));
                date_actuel.setTime(new Date());
            
                if (date_location.get(Calendar.MONTH) == date_actuel.get(Calendar.MONTH)){
                    nb_film_mensuel = nb_film_mensuel + 1;
                }
            }

            while(res_enfant.next()){
                liste_enfant.add(EnfantDAO.read(res_enfant.getId(1)));
            }

            parent = new Abonne_parent,(id, nom, prenom, adresse, telephone, solde, historique, film_en_location, null, liste_enfant);
            while (res_genre.next()){
                enfant.add_restriction_categorie(res_genre.getString(2));
            }
            enfant.remove_restriction_age(restriction_age);
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        return res;
=======
        return enfant;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
    }

    @Override
    public boolean update(Abonne_parent obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Abonne_parent obj) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

}
