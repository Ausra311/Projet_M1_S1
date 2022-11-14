package fc;
public abstract class Support {
    Film film;
    Support(Film f){
        film = f;
    }

    int get_emplacement(){
        return -1;
    }

    Boolean Est_endommage(){
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
        System.out.println("Film sorti");
    }
}
