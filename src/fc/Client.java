package fc;


import java.util.Vector;
public class Client {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String telephone;
    protected Vector<Historique> film_en_location;
    public Vector<Historique> historique;
    protected int solde;
    protected int nb_film_mensuel;
    protected Carte_banquaire carte_banquaire;

    protected Vector<Abonne_enfant> liste_enfant;

    protected Vector<String> restriction_categorie;
    protected int restriction_age; // 0 ou 10 ou 12 ou 16 ou 18. Dans client 0 uniquement

    public Client(){}

    public Client(int _id,
          Carte_banquaire _carte_banquaire){

      id = _id;
      nom = "";
      prenom = "";
      adresse = "";
      telephone = "";
      film_en_location = new Vector<Historique>();
      historique = new Vector<Historique>();
      solde = 0;
      nb_film_mensuel = 0;
      carte_banquaire = _carte_banquaire;
      liste_enfant = new Vector<Abonne_enfant>();
      restriction_categorie = new Vector<String>();
      restriction_age = 0;
    }

    Client(int _id,
          Carte_banquaire _carte_banquaire,
          Vector<Historique> _film_en_location,
          Vector<Historique> _historique,
          int _nb_film_mensuel){

      id = _id;
      nom = "";
      prenom = "";
      adresse = "";
      telephone = "";
      film_en_location = _film_en_location;
      historique = _historique;
      solde = 0;
      nb_film_mensuel = _nb_film_mensuel;
      carte_banquaire = _carte_banquaire;
      liste_enfant = new Vector<Abonne_enfant>();
      restriction_categorie = new Vector<String>();
      restriction_age = 0;
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
      Vector<Historique> merge = new Vector<Historique>();
      merge.addAll(historique);
      merge.addAll(film_en_location);
      return merge;
    }

    public int get_solde(){
      return solde;
    }

    public int get_nb_film_mensuel(){
      return nb_film_mensuel;
    }

    public int get_nb_film_en_location(){
      return film_en_location.size();
    }

    public Carte_banquaire get_cb(){
      return carte_banquaire;
    }

    public Vector<Abonne_enfant> get_liste_enfant(){
      return liste_enfant;
    }

    public Abonne_enfant get_enfant(int i){
      if(i<liste_enfant.size()){
        return liste_enfant.get(i);
      }
      return null;
    }
    
    public void debiterMono(){
      carte_banquaire.debiter(5);
    }

    public void debiterAll(){
      for(int i=0;i<get_nb_film_en_location();i++){
        debiterMono();
      }

    }

    public boolean peut_louer(){
      if(get_nb_film_en_location() == 0 && solde_suffisant()){
        return true;
      }
        return false;
    }
    
    public boolean solde_suffisant(){
      if(carte_banquaire.solde(15)){
        return true;
      }
      return false;  
    }

    public void add_Historique(Film f){
      Historique histo = new Historique(f);
      film_en_location.add(histo);
    }

    private boolean add_date_rendu(Film f){
      for(int i = 0;i<get_nb_film_en_location();i++){
        if(film_en_location.get(i).get_film() == f ){
          Historique histo = film_en_location.get(i);
          histo.rendre();
          historique.add(histo);
          film_en_location.remove(i);
          return true;
        }
      }
      return false;
    }

    public boolean louer(Film f){
      if(peut_louer()){
        debiterMono();
        add_Historique(f);
        return true;
      }
      return false;
    }

    public void rendre(Film f){
      add_date_rendu(f);

    }

    public void recharger(int s){}
}


