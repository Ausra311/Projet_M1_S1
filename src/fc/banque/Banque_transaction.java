package fc.banque;

import fc.Carte_banquaire;

public class Banque_transaction {
    public void debiter(int montant, Carte_banquaire carte_banquaire){
        System.out.print("compte ");
        System.out.print(carte_banquaire.get_reference());
        System.out.print(" débité de ");
        System.out.println(montant);
    }

    public boolean solde(int n){
        return true;
    }
}
