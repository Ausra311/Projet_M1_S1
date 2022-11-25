package fc;

import java.util.Date;
import java.util.Vector;

public class Test_Film{
    Film film;


    public static void test(){
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
        
        System.out.println("début test classe Film :");
        // changer le resume
        film.change_resume("Une classe");
        assert resume != film.get_resume() : "erreur méthode new_resume";
        
        // changer la restriction d'age
        film.set_restriction(10);
        assert film.get_restriction() == 10 : "erreur méthode get_restriction";
        
        film.set_restriction(18);
        assert film.get_restriction() == 18 : "erreur méthode set_restriction";
        
        // ajouter des genres
        film.add_genre("Societe");
        genre.add("Societe");
        assert film.get_genre() == genre : "erreur méthode get_genre";
        
        // supprimer des genres
        film.suppr_genre("Societe");
        genre.remove("Societe");
        assert film.get_genre() == genre : "erreur méthode get_genre";
        film.suppr_genre("Action");
        assert film.get_genre() == genre : "erreur méthode get_genre";
        
        // effectuer une nouvelle location
        film.nouvelle_location();
        nb_location++;
        assert film.get_nb_location() == nb_location : "erreur méthode get_nb_location";
        
        System.out.println("test de classe Film OK");

    }
}