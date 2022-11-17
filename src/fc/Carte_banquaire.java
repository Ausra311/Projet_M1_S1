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
    String nom(){
        return nom_banque;
    }
    String type_carte(){
        return type_carte;
    }
    String reference(){
        return ref_bancaire;
    }
    public void debiter(){
        transaction.debiter(5, this);
    }
}
