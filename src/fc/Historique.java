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

    public Film get_film(){
        return film;
    }

    public void rendre(){
        date_fin = new Date();
    }
}
