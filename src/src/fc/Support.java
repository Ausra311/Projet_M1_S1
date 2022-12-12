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

    public void set_endommage(Boolean b){
    }

    public Boolean est_endommage(){
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

    public void sortir_support(){
        //volontairement vide
    }

    public void retour(){
        //volontairement vide
    }
}
