package fc;
public class DVD extends Support{

    int emplacement;
    Boolean endommage;
    Boolean disponible;
    int id;

    public DVD(Film f,int emplacement, Boolean endommage, Boolean disponible,int id) {
		super(f);
	   this.emplacement=emplacement;
       this.endommage=endommage;
       this.disponible=disponible;
       this.id=id;
    }

    public int get_emplacement(){
        return emplacement;
    }

    public Boolean est_endommage(){
        return endommage;
    }

    public Boolean disponible(){
        return disponible;
    }

    public int get_id(){
        return id;
    }

    public Film get_film(){
        return film;
    }

    public void sortir_support(){
        automate.sortir_DVD(get_emplacement());
        disponible = false;
    }
    
    public void retour(){
        automate.retour();
        disponible = true;
    }
}
