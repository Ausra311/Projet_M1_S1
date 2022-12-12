package fc;
import java.util.Vector;

public class Test_Abonne_Enfant {
    Abonne_enfant enfant;

    public void test(){
        // paramètres pour créer l'enfant
        int id = 1;
        String nom = "Romain";
        String prenom = "Noe";
        String adresse = "Grenoble";
        String telephone = "0606060606";
        int solde = 70;
        Carte_banquaire carte_banquaire = new Carte_banquaire(nom, adresse, telephone, null);
        Abonne_enfant enfant = new Abonne_enfant(id, nom, prenom, adresse, telephone, solde, carte_banquaire);

        // paramètres pour un film
        int id_film = 1;
        String titre = "M1 info";
        String realisateur = "Vania Marangozova";
        Vector<String> acteurs = new Vector<String>();
        acteurs.add("Paul Andre");
        String resume = "Une classe agréable qui pose peu de question en classe et qui a une très bonne entente interne";
        Vector<String> genre = new Vector<String>();
        genre.add("humour");
        int restriction = 0;
        int nb_location = 0;
        Film film = new Film(id_film, titre, realisateur, acteurs, resume, genre, restriction, nb_location);
        
        // cathégorie pour restriction
        Vector<String> restrict = new Vector<String>();
        restrict.add("horeur");
        restrict.add("thriller");

        System.out.println("début test classe Abonne_enfant :");
        // test des méthodes contenues dans la classe abonné

        // recharger
        enfant.recharger(20);
        assert enfant.solde == 90: "erreur méthode recharger";
        enfant.recharger(-5);
        assert enfant.solde == 85: "erreur méthode recharger";

        // vingtieme_films
        assert enfant.get_solde() == 85: "erreur méthode vingtieme_film";
        for(int i=0;i<19;i++){
            enfant.add_Historique(film);
        }
        enfant.vingtieme_films();
        assert enfant.get_solde() == 85: "erreur méthode vingtieme_film";
        enfant.add_Historique(film);
        enfant.vingtieme_films();
        assert enfant.get_solde() == 95: "erreur méthode vingtieme_film";
        for(int i=0;i<20;i++){
            enfant.rendre(film);
        }
        
        // debiterMono
        enfant.debiterMono();
        assert enfant.solde == 91: "erreur méthode debiterMono";
        
        // debiterAll
        enfant.add_Historique(film);
        enfant.add_Historique(film);
        enfant.debiterAll();
        enfant.rendre(film);
        enfant.rendre(film);
        assert enfant.get_solde() == 83 : "error debiterAll";
        
        // louer
        enfant.louer(film);
        int n = enfant.get_nb_film_en_location();
        assert n == 1: "erreur méthode louer";
        enfant.louer(film);
        n = enfant.get_nb_film_en_location();
        assert n == 2: "erreur méthode louer";

        // solde_suffisant
        boolean b = enfant.solde_suffisant();
        assert b == true: "erreur méthode solde_suffisant";
        enfant.solde = 4;
        b = enfant.solde_suffisant();
        assert b == false: "erreur méthode solde_suffisant";

        // peut_louer
        b = enfant.peut_louer();
        assert b == false: "erreur méthode peut_louer";
        enfant.solde = 30;
        b = enfant.peut_louer();
        assert b == true: "erreur méthode peut_louer";
        enfant.louer(film);
        b = enfant.peut_louer();
        assert b == false: "erreur méthode peut_louer";

        // peut_gerer_enfant
        b = enfant.peut_gerer_enfant();
        assert b == false: "erreur méthode peut_gerer_enfant";
        
        // test des méthodes de abonne_enfant
        // get_age
        enfant.restriction_age = 10;
        int age = enfant.get_age();
        assert age == 10: "erreur méthode get_age";

        // get_restriction_categorie
        enfant.restriction_categorie = restrict;
        assert enfant.get_restriction_categorie() == restrict: "erreur méthode get_restriction_categorie";

        // add_restriction_categorie
        enfant.add_restriction_categorie("action");
        restrict.add("action");
        assert enfant.get_restriction_categorie() == restrict: "erreur méthode set_restriction_categorie";

        // remove_restriction_categorie
        enfant.remove_restriction_categorie("action");
        restrict.remove("action");
        assert enfant.get_restriction_categorie() == restrict: "erreur méthode remove_restriction_categorie";

        // remove_restriction_age(int)
        enfant.remove_restriction_age(18);
        assert enfant.get_age() == 18: "erreur méthode remove_restriction_age(int)";
        enfant.remove_restriction_age();
        assert enfant.get_age() == 0: "erreur méthode remove_restriction_age()";

        // type_client
        assert enfant.type_client() == "Abonne_enfant": "erreur méthode type_client";

        System.out.println("test de classe Abonne_enfant OK");


    }
}
