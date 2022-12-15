package fc;

import java.util.Vector;

public class Abonne_enfant  extends Abonne{
    

    public Abonne_enfant(int _id,
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

    public Abonne_enfant(int _id,
                    String _nom,
                    String _prenom,
                    String _adresse,
                    String _telephone,
                    int _solde, 
                    Vector<Historique> _historique,
                    Vector<Historique> _film_en_location,
                    Carte_banquaire _carte_banquaire){
        super(_id,
            _nom,
            _prenom,
            _adresse,
            _telephone,
            _solde, 
            _historique,
            _film_en_location,
            _carte_banquaire);
    }

    //Get :
    public int get_age(){
        return restriction_age;
    }

    public Vector<String> get_restriction_categorie(){
        return restriction_categorie;
    }

    //Set :
    public void add_restriction_categorie(String categorie){
        restriction_categorie.add(categorie);
    }

    public void add_restriction_age(int age){
        if(age==18 || age==16 || age==12 || age==10 || age==0){
            restriction_age = age;
        }
    }

    public void remove_restriction_categorie(String categorie){
        restriction_categorie.remove(categorie);
    }

    public void remove_restriction_age(int age){
        if(age==18 || age==16 || age==12 || age==10){
            restriction_age = age;
        }
    }

    public void remove_restriction_age(){
        restriction_age = 0;
    }

    public String type_client(){
        return "Abonne_enfant";
    }

    public boolean peut_louer(Film f){
        boolean b = this.peut_louer();
        if(f.get_restriction()>restriction_age){
            return false;
        }
        for(int i = 0; i<f.get_genre().size();i++){
            for(int j = 0; j<restriction_categorie.size();j++){
                if(f.get_genre().get(i)==restriction_categorie.get(j)){
                    return false;
                }
            }
        }
        return b;
    }

    @Override
    public boolean louer(Film f){
        if(peut_louer(f)){
          debiterMono();
          add_Historique(f);
          vingtieme_films();
          return true;
        }
        return false;
    }
}
