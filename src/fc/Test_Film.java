package fc;

import java.util.Date;
import java.util.Vector;

public class Test_Film{
    Film film;


    public static void test(Boolean affichage){
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
        
        // changer le resume
        if(affichage) System.out.println("------------------------------------------------------");
        if(affichage) System.out.println("Test du cahngement de résumé :\n");
        film.change_resume("Une classe");
        assert(resume != film.get_resume());
        if(affichage) System.out.println("l'assert de vérification de changement de résumé est passé\n");
        if(affichage) System.out.println("l'ancien résumé est : ");
        if(affichage) System.out.println(resume);
        if(affichage) System.out.println("\nle nouveau résumé est : ");
        if(affichage) System.out.println(film.get_resume());

        // changer la restriction d'age
        if(affichage) System.out.println("\n\nTest du changement de restriction d'age :\n");
        film.set_restriction(10);
        assert(film.get_restriction() == 10);
        if(affichage) System.out.println("la valeure de la restriction est la bonne : ");
        if(affichage) System.out.println(film.get_restriction());
        if(affichage) System.out.println("\nAutre changement de restriction d'age : ");
        film.set_restriction(18);
        assert(film.get_restriction() == 18);
        if(affichage) System.out.println("la valeure a bien été changée : ");
        if(affichage) System.out.println(film.get_restriction());

        // ajouter des genres
        if(affichage) System.out.println("\n\nTest de l'ajout de genre :\n");
        if(affichage) System.out.println("la liste de genre actuelle : ");
        if(affichage) System.out.println(film.get_genre());
        film.add_genre("Societe");
        genre.add("Societe");
        assert(film.get_genre() == genre);
        if(affichage) System.out.println("\nle nouveau genre à bien été ajouté : ");
        if(affichage) System.out.println(film.get_genre());

        // supprimer des genres
        if(affichage) System.out.println("\n\nTest de suppression de genre :\n");
        if(affichage) System.out.println("la liste de genre actuelle : ");
        if(affichage) System.out.println(film.get_genre());
        film.suppr_genre("Societe");
        genre.remove("Societe");
        assert(film.get_genre() == genre);
        if(affichage) System.out.println("\nle  genre à bien été supprimé : ");
        if(affichage) System.out.println(film.get_genre());
        if(affichage) System.out.println("\nTentative de suppression d'un genre  qui n'est pas dans la liste");
        film.suppr_genre("Action");
        assert(film.get_genre() == genre);
        if(affichage) System.out.println("le test est bien passé");

        // effectuer une nouvelle location
        if(affichage) System.out.println("\n\nTest la location de ce film :\n");
        if(affichage) System.out.println("le nombre de location actuel : ");
        if(affichage) System.out.println(film.get_nb_location());
        film.nouvelle_location();
        nb_location++;
        assert(film.get_nb_location() == nb_location);
        if(affichage) System.out.println("\nle nombre de locations à bien été mis à jour : ");
        if(affichage) System.out.println(film.get_nb_location());

        System.out.println("test de classe Film OK");


    }
}