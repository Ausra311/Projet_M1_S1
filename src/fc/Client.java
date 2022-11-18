package fc;


import java.util.Vector;
public class Client {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;
    protected Vector<Historique> film_en_location;
    protected Vector<Historique> historique;
    protected int solde;
    protected int nb_film_mensuel;
    protected int nb_film_en_location;
    protected Carte_banquaire carte_banquaire;

    Client(int _id,
          String _nom,
          String _prenom,
          String _adresse,
          String _telephone,
          int _solde, 
          Carte_banquaire _carte_banquaire){

      id = _id;
      nom = _nom;
      prenom = _prenom;
      adresse = _adresse;
      telephone = _telephone;
      historique = new Vector<Historique>();
      solde = _solde;
      nb_film_mensuel = 0;
      nb_film_en_location = 0;
      carte_banquaire = _carte_banquaire;


    }

    public int get_id(){
      return id;
    }

    public String get_nom(){
      return nom;
    }

    public String get_prenom(){
      return prenom;
    }

    public String get_adresse(){
      return adresse;
    }

    public String get_telephone(){
      return telephone;
    }

    public Vector<Historique> get_historique(){
      return historique;
    }

    public int get_solde(){
      return solde;
    }

    public int get_nb_film_mensuel(){
      return nb_film_mensuel;
    }

    public int get_nb_film_en_location(){
      return nb_film_en_location;
    }

    public Carte_banquaire get_cb(){
      return carte_banquaire;
    }

    public void debiterMono(){
      carte_banquaire.debiter(5);
    }

    public void debiterAll(){
      for(int i=0;i<get_nb_film_en_location();i++){
        debiterMono();
      }

    }

    public Boolean peut_louer(Film f){
      if(nb_film_en_location == 0 && solde_suffisant()){
        return true;
      }
        return false;
    }
    public Boolean solde_suffisant(){
      if(solde >=15){
        return true;
      }
      return false;  
    }

    //set
    public void add_film_loc(){
      nb_film_en_location +=1;
    }
    public void rm_film_loc(){
      nb_film_en_location -=1;
    }
    
    public void add_Historique(Film f){
      Historique histo = new Historique(f);
      film_en_location.add(histo);
    }

    public boolean add_date_rendu(Film f){
      for(int i = 0;i<get_nb_film_en_location();i++){
        if(film_en_location.get(i).get_film() == f ){
          Historique histo = film_en_location.get(i);
          histo.rendre();
          historique.add(histo);
          return true;
        }
      }
      return false;
    }

    public void louer(Film f){
      if(peut_louer(f)){
        debiterMono();
        add_film_loc();
        add_Historique(f);
      }
    }

    public void rendre(Film f){
      if(add_date_rendu(f)){
        rm_film_loc();
      }
    }
}


