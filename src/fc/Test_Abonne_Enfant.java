package fc;

public class Test_Abonne_Enfant {
    Abonne_enfant enfant;

    public void test(){
        int id = 1;
        String nom = "Romain";
        String prenom = "Noe";
        String adresse = "Grenoble";
        String telephone = "0606060606";
        int solde = 70;
        Carte_banquaire carte_banquaire = new Carte_banquaire(nom, adresse, telephone, null);
        Abonne_enfant enfant = new Abonne_enfant(id, nom, prenom, adresse, telephone, solde, carte_banquaire);

        System.out.println("début test classe Abonne_enfant :");
        //


    }
}
