package fc;
public class DVD extends Support{

    int emplacement;
    Boolean endommage;
    Boolean disponible;
    int id;

    DVD(Film f,int emplacement, Boolean endommage, Boolean disponible,int id) {
		super(f);
	   this.emplacement=emplacement;
       this.endommage=endommage;
       this.disponible=disponible;
       this.id=id;
    }

    int get_emplacement(){
        return emplacement;
    }

    Boolean Est_endommage(){
        return endommage;
    }

    Boolean disponible(){
        return disponible;
    }

    int get_id(){
        return id;
    }

    Film get_film(){
        return film;
    }

    void sortir_support(){
        System.out.println("DVD sorti");
    }
}
