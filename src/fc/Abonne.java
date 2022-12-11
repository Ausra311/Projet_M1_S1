package fc;

import java.util.Vector;

public abstract class Abonne extends Client {
    

<<<<<<< HEAD
    public Abonne(int _id,
=======
    Abonne(int _id,
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
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
        film_en_location = new Vector<Historique>();
        historique = new Vector<Historique>();
        solde = _solde;
        nb_film_mensuel = 0;
        carte_banquaire = _carte_banquaire;
<<<<<<< HEAD
=======
        nb_enfant = 0;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        liste_enfant = new Vector<Abonne_enfant>();
        restriction_categorie = new Vector<String>();
        restriction_age = 0;
    }

<<<<<<< HEAD
    public Abonne(int _id,
=======
    Abonne(int _id,
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
            String _nom,
            String _prenom,
            String _adresse,
            String _telephone,
            int _solde,
            Vector<Historique> _historique,
            Vector<Historique> _film_en_location,
            Carte_banquaire _carte_banquaire){
        id = _id;
        nom = _nom;
        prenom = _prenom;
        adresse = _adresse;
        telephone = _telephone;
        film_en_location = _film_en_location;
        historique = _historique;
        solde = _solde;
        nb_film_mensuel = 0;
        carte_banquaire = _carte_banquaire;
<<<<<<< HEAD
=======
        nb_enfant = 0;
>>>>>>> 7656e9569456650c37b7f0d1604060bec87eec04
        liste_enfant = new Vector<Abonne_enfant>();
        restriction_categorie = new Vector<String>();
        restriction_age = 0;
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

    @Override
    public void debiterAll(){
        for(int i=0;i<get_nb_film_en_location();i++){
          debiterMono();
        }
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
          vingtieme_films();
          return true;
        }
        return false;
    }

    public boolean peut_gerer_enfant(){
        return false;    
    }


}
