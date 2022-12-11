package fc;

import java.util.Date;

public class Historique {
    Film film;
    Date date_debut;
    Date date_fin;
    Historique(Film _film){
        film = _film;
        date_debut = new Date();
        
    }

    Historique(Film _film,Date _date_debut,Date _date_fin){
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
