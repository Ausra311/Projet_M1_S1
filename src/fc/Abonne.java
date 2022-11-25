package fc;

import java.util.Vector;

public abstract class Abonne extends Client {
    

    Abonne(int _id,
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
        solde = 0;
        nb_film_mensuel = 0;
        carte_banquaire = _carte_banquaire;
    }
   
    

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

    public boolean solde_suffisant(){
        if(get_solde()>=15){
            return true;
        }
        return false;
    }

    @Override
    public boolean peut_louer(){
        if(get_nb_film_en_location() < 3 && solde_suffisant()){
          return true;
        }
          return false;
      }

    @Override
    public boolean louer(Film f){
        if(peut_louer()){
          debiterMono();
          add_Historique(f);
          return true;
        }
        return false;
    }

    public boolean peut_gerer_enfant(){
        return false;    
    }


}
