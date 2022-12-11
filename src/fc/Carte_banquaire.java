package fc;

import fc.banque.Banque_transaction;

public class Carte_banquaire{
    String nom_banque;
    String type_carte;
    String ref_bancaire;
    Banque_transaction transaction;

    Carte_banquaire(String _nom_banque,String _type_carte,String _ref_bancaire, Banque_transaction _transaction){
        nom_banque = _nom_banque;
        type_carte = _type_carte;
        ref_bancaire = _ref_bancaire;
        transaction = _transaction;
    }

    public String get_nom(){
        return nom_banque;
    }
    public String get_type_carte(){
        return type_carte;
    }
    public String get_reference(){
        return ref_bancaire;
    }
    public void debiter(int value){
        transaction.debiter(value, this);
    }

    public boolean solde(int n){
        /*
         Verifie que le compte possede au moins n euro 
         */
        return transaction.solde(n);
    }
}
