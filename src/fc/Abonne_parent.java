package fc;

import java.util.Vector;

public class Abonne_parent  extends Abonne{
    private int nb_enfant;
    private Vector<Abonne_enfant> no_enfant;
    
    Abonne_parent(int _id,
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
    public int get_nb_enfant(){
        return nb_enfant;
    };

    public Vector<Abonne_enfant> get_no_enfant(){
        return no_enfant;
    }

    public Vector<Historique> get_historique_enfant(Abonne_enfant enfant){
        return enfant.get_historique();
    }

    public int get_solde_enfant(Abonne_enfant enfant){
        return enfant.get_solde();
    }

    //Set :

    public void add_restriction_enfant(Abonne_enfant enfant, String categorie){
        enfant.add_restriction_categorie(categorie);
    }

    public void add_restriction_enfant(Abonne_enfant enfant, int age){
        enfant.add_restriction_age(age);
    }

    public void remove_restriction_enfant(Abonne_enfant enfant, String categorie){
        enfant.remove_restriction_categorie(categorie);
    }

    public void remove_restriction_enfant(Abonne_enfant enfant, int age){
        enfant.remove_restriction_age(age);
    }

    public void remove_restriction_enfant(Abonne_enfant enfant){
        enfant.remove_restriction_age();
    }

    public void recharge_enfant(Abonne_enfant enfant, int montant){
        enfant.recharger(montant);
    }

    @Override
    public boolean peut_gerer_enfant(){
        return true;    
    }

    




}