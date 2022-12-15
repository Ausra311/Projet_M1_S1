package fc;

import java.util.Date;

public class Historique {
    protected Film film;
    public Date date_debut;
    public Date date_fin;
    public Historique(Film _film){
        film = _film;
        date_debut = new Date();
        date_fin = null;
    }

    public Historique(Film _film,Date _date_debut,Date _date_fin){
        film = _film;
        date_debut = _date_debut;
        date_fin = _date_fin;  
    }

    public Film get_film(){
        return film;
    }

    public void rendre(){
        date_fin = new Date();
    }
}
