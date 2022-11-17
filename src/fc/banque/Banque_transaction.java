package fc.banque;

import fc.Carte_banquaire;

public class Banque_transaction {
    public void debiter(int montant, Carte_banquaire carte_banquaire){
        System.out.println("compte  débité de ");
        System.out.print(montant);
    }
}
