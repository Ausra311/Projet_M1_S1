package fc;

import java.sql.SQLException;
import java.util.Vector;

import DAO.*;

public class Interface2 extends Interface{
    
    private Session S = new Session();
    ClientDAO Client;
    AbonneDAO abonne;
    AbonneEnfantDAO abonne_enfant;
    AbonneParentDAO abonne_parent;
    FilmDAO film;
    DVDDAO Dvd;
    LocationDAO loc;
    GenreDAO genre;

    Interface2(){
        S.open();
        Client = new ClientDAO(Session.getSession());
		abonne = new AbonneDAO(Session.getSession());
		abonne_enfant = new AbonneEnfantDAO(Session.getSession());
		abonne_parent = new AbonneParentDAO(Session.getSession());
		film = new FilmDAO(Session.getSession());
		Dvd = new DVDDAO(Session.getSession());
		loc = new LocationDAO(Session.getSession());
        genre = new GenreDAO(Session.getSession());
    }

    public void connexion(int id) throws SQLException{
        String type = Client.type(id);
        if (type == "Abonne Enfant"){
            client = abonne_enfant.read(id).get(0);
        } else {
            client = abonne_parent.read(id).get(0);
        }
    }

    public void creation_enfant(Client c) throws SQLException {
        Client.create(c, "Abonne Enfant");
    }

    public void abonnement(Client c) throws SQLException{
        Client.create(c, "Abonne Parent");
        client = c;
    }

    public void deconnexion(){
        client = null;
    }

    public Client get_client(){
        return client;
    }

    public Vector<Film> liste_film () throws SQLException{
        liste_film = film.read(client);
        return liste_film;
    }

    public Vector<String> liste_genre () throws SQLException{
        liste_genre = genre.read(client);
        return liste_genre;
    }
    
    @Override
    public Vector<Film> rechercher_titre (String titre){
        Vector<Film> lf = new Vector<Film>();
        if (liste_film == null){
            try {
                liste_film();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < liste_film.size(); i++){
            if(liste_film.get(i).get_titre() == titre){
                lf.add(liste_film.get(i));
            }
        }
        return lf;
    }

    @Override
    public Vector<Film> rechercher_genre(String categorie){
        Vector<Film> lf = new Vector<Film>();
        if (liste_film == null){
            try {
                liste_film();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < liste_film.size(); i++){
            for (int j = 0; j < liste_film.get(i).get_genre().size(); j++){
                Vector<String> genre = liste_film.get(i).get_genre();
                if(genre.get(j) == categorie){
                    lf.add(liste_film.get(i));
                }
            }
        }
        return lf;
    }
    
    public Vector<DVD> dvd_disponible() throws SQLException{
        return Dvd.read(film);
    }

    public void ajout_restricion(Abonne_enfant enfant,Vector<String> g) throws SQLException{
        for (int i =0; i < g.size(); i++){
            enfant.add_restriction_categorie(g.get(i));
        }
        abonne_enfant.update(enfant);
    }

    public void ajout_restricion(Abonne_enfant enfant,int a) throws SQLException{
        enfant.add_restriction_age(a);
        abonne_enfant.update(enfant);
    }
    
}
