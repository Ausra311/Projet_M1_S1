package fc;

public abstract class Abonne extends Client {
    
    Abonne(int _id,
    String _nom,
    String _prenom,
    String _adresse,
    String _telephone,
    int _solde, 
    Carte_banquaire _carte_banquaire){
        super(_id,
            _nom,
            _prenom,
            _adresse,
            _telephone,
            _solde, 
            _carte_banquaire);
    }
   
    
    //Get :
    public void recharger(int v){
        solde += v;
    }

    public void vingtieme_films(){
        if(get_nb_film_en_location() > 0 && get_nb_film_en_location()%20 == 0){
            recharger(10);
        }
    }

    @Override
    public void debiterMono(){
        solde -= 4;
    }

    @Override
    public Boolean peut_louer(Film f){
        if(nb_film_en_location < 3 && solde_suffisant()){
          return true;
        }
          return false;
      }

    @Override
    public void louer(Film f){
        if(peut_louer(f)){
          debiterMono();
          add_film_loc();
          add_Historique(f);
        }
    }

    public boolean peut_gerer_enfant(){
        return false;    
    }


}
