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

<<<<<<< HEAD
    public Boolean est_endommage(){
=======
    Boolean est_endommage(){
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
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
