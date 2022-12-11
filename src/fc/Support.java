package fc;
public abstract class Support {
    Film film;
    Automate automate;

    public Support(Film f){
        film = f;
        automate = new Automate();
    }

    public int get_emplacement(){
        return -1;
    }

<<<<<<< HEAD
    public Boolean est_endommage(){
=======
    Boolean est_endommage(){
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        return false;
    }

    public Boolean disponible(){
        return true;
    }

    public int get_id(){
        return -1;
    }

    public Film get_film(){
        return film;
    }

<<<<<<< HEAD
    public void sortir_support(){
        //volontairement vide
    }

    public void retour(){
=======
    void sortir_support(){
        //volontairement vide
    }

    void retour(){
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        //volontairement vide
    }
}
