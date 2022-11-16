package fc;


import java.util.Vector;
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private Vector<Historique> historique;
    private int solde;
    private int nb_film_mensuel;
    private int nb_film_en_location;

    Client(int _id,
          String _nom,
          String _prenom,
          String _adresse,
          String _telephone,
          int _solde){

      id = _id;
      nom = _nom;
      prenom = _prenom;
      adresse = _adresse;
      telephone = _telephone;
      historique = new Vector<Historique>();
      solde = _solde;
      nb_film_mensuel = 0;
      nb_film_en_location = 0;


    }

     
   public void debiter(){

    }
    public Boolean peut_louer(){
        return true;
    }
    public Boolean solde_suffisant(){
      return true;  
    }
   String type_client(){
    return "Carte Bancaire";
   }

    //get

   public int nb_film_en_location(){
        return nb_film_en_location;
   }
   
    //set
   public void add_film_loc(){
     nb_film_en_location +=1;
   }
   public void rm_film_loc(){
    nb_film_en_location -=1;
   }
  
}


