package fc;
import java.util.Vector;
public abstract class Abonne extends Client {
    private int no_abonne;
    private String nom;
    private String prenom;
    private String adresse;
    private String no_telephone;
    private Vector<Film> historique;
    private int solde;
    private int nb_film_loue_mois;
   
    
    //Get :
    public String get_nom(){
          return nom;
    }
    public String get_prenom(){
          return prenom;
    }
    public String get_adresse(){
          return adresse;
    }
    public int get_no_abonne(){
          return no_abonne;
    }
    public int get_nb_film_loue_mois(){
        return nb_film_loue_mois;
    }
    public String get_no_telephone(){
        return no_telephone;
    }

    public int get_solde(){
        return solde;
    }
    
    public Vector<Film> get_historiqe(){
        return historique;
    }
     public void set_nom(String n){
           nom = n ;
    }
    public String set_prenom(){
          return prenom;
    }
    public String set_adresse(){
          return adresse;
    }
    public int set_no_abonne(){
          return no_abonne;
    }
    public int set_nb_film_loue_mois(){
        return nb_film_loue_mois;
    }
    public String set_no_telephone(){
        return no_telephone;
    }

    public int set_solde(){
        return solde;
    }
    
    public Vector<Film> set_historiqe(){
        return historique;
    }

    public void recharger(int a){

    }

    public void vingtieme_films(){

    }
   @Override
    public void debiter(){

    }
    @Override
    public Boolean peut_louer(){
        return true;
    }
    @Override
    public Boolean solde_suffisant(){
      return true;  
    }

}
