package fc;

import fc.banque.Banque_transaction;

public class Test_Carte_Banquaire {
    Carte_banquaire cb;

    public void test(boolean affichage){
            String bank="CIC";
            String type="Visa";
            String ref="42";
            Banque_transaction bt= new Banque_transaction();
            

            cb = new Carte_banquaire(bank, type, ref, bt);
            
            // get_nom
            assert cb.get_nom()==bank: "erreur méthode get_nom";

            // get_type_carte
            assert cb.get_type_carte()==type : "erreur méthode get_type_carte";

            // test get_reference
            assert cb.get_reference()==ref: "erreur méthode get_reference";

            // debiter

            // je ne comprend pas comment ça vérifie concretement
            cb.debiter(10);
            if(affichage) System.out.println("get_reference ok");

            if(affichage) System.out.println("test solde");
            cb.solde(15);
            if(affichage) System.out.println("get_solde ok");

            if(affichage) System.out.println("test solde");
            cb.solde(15);
            if(affichage) System.out.println("get_solde ok");



            System.out.println("Test Carte Banquaire ok");
    }
}
