package fc;
public class Carte_banquaire{
    String nom_banque;
    String type_carte;
    String ref_bancaire;
    Carte_banquaire(String n,String t,String r){
        nom_banque = n;
        type_carte = t;
        ref_bancaire = r;
    }
    String nom(){
        return nom_banque;
    }
    String type_carte(){
        return type_carte;
    }
    String reference(){
        return ref_bancaire;
    }
}
