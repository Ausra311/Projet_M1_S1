package fc;
public abstract class Support {
    Film film;
    Automate automate;

    Support(Film f){
        film = f;
        automate = new Automate();
    }

    int get_emplacement(){
        return -1;
    }

    Boolean est_endommage(){
        return false;
    }

    Boolean disponible(){
        return true;
    }

    int get_id(){
        return -1;
    }

    Film get_film(){
        return film;
    }

    void sortir_support(){
        //volontairement vide
    }

    void retour(){
        //volontairement vide
    }
}
