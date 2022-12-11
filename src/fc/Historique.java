package fc;

import java.util.Date;

public class Historique {
<<<<<<< HEAD
    protected Film film;
    public Date date_debut;
    public Date date_fin;
    public Historique(Film _film){
=======
    Film film;
    Date date_debut;
    Date date_fin;
    Historique(Film _film){
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        film = _film;
        date_debut = new Date();
        
    }

<<<<<<< HEAD
    public Historique(Film _film,Date _date_debut,Date _date_fin){
=======
    Historique(Film _film,Date _date_debut,Date _date_fin){
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
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
