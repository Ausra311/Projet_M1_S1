package fc;

import java.util.Vector;

public class Abonne_parent  extends Abonne{
    private int nb_enfant;
    private Vector<Abonne_enfant> no_enfant;
    
    Abonne_parent (){};

    @Override 
    public String type_client(){
        return "Abonne_parent";
    }

    //Get :
    public int get_nb_enfant(){
        return nb_enfant;
    };

    public Vector<Abonne_enfant> get_no_enfant(){
        return no_enfant;
    }

    public Vector<Film> get_historique_enfant(Abonne_enfant enfant){
        return enfant.get_historiqe();
    }

    public int get_solde_enfant(Abonne_enfant enfant){
        return enfant.get_solde();
    }

    //Set :

    public void add_restriction_enfant(Abonne_enfant enfant, String s){
        enfant.add_restriction_enfant(s);
    }


    




}